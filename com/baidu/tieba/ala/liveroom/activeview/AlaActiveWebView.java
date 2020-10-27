package com.baidu.tieba.ala.liveroom.activeview;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import com.baidu.live.tbadk.scheme.SchemeUtils;
import com.baidu.live.view.web.CommonWebView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaActiveWebView extends FrameLayout implements c {
    private CommonWebView bHZ;
    private List<String> bIa;
    private SchemeCallback bIc;
    private String eul;
    private a gPk;
    private boolean gPl;

    /* loaded from: classes4.dex */
    public interface a {
        void mz(boolean z);
    }

    public AlaActiveWebView(Context context) {
        super(context);
        this.bIc = new SchemeCallback() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.3
            @Override // com.baidu.live.tbadk.scheme.SchemeCallback
            public void doJsCallback(int i, String str, JSONObject jSONObject, String str2) {
                try {
                    String assembJavaScript = SchemeUtils.assembJavaScript(i, str, jSONObject, str2);
                    if (Build.VERSION.SDK_INT >= 19) {
                        AlaActiveWebView.this.bHZ.evaluateJavascript(assembJavaScript, null);
                    } else {
                        AlaActiveWebView.this.bHZ.loadUrl(assembJavaScript);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.gPk = aVar;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.bIa == null) {
            this.bIa = new ArrayList();
        }
        this.bIa.add(str);
        this.bHZ.addJavascriptInterface(obj, str);
    }

    public void loadUrl(String str) {
        if (this.bHZ != null) {
            this.bHZ.loadUrl(str);
        }
    }

    public String getOriginalUrl() {
        return this.bHZ != null ? this.bHZ.getOriginalUrl() : "";
    }

    public boolean bUy() {
        return this.gPl;
    }

    @RequiresApi(19)
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.bHZ != null) {
            this.bHZ.evaluateJavascript(str, valueCallback);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStart() {
        if (this.bHZ != null) {
            this.bHZ.onResume();
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.bHZ.resumeTimers();
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStop() {
        if (this.bHZ != null) {
            this.bHZ.onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void release() {
        this.gPk = null;
        this.gPl = false;
        removeAllViews();
        if (this.bHZ != null) {
            if (this.bIa != null) {
                for (String str : this.bIa) {
                    this.bHZ.removeJavascriptInterface(str);
                }
                this.bIa.clear();
            }
            this.bHZ.stopLoading();
            this.bHZ.removeAllViews();
            this.bHZ.loadUrl("about:blank");
            this.bHZ.freeMemory();
            this.bHZ.destroy();
        }
    }

    private void init() {
        this.gPl = false;
        setBackgroundColor(0);
        if (getBackground() != null) {
            getBackground().setAlpha(0);
        }
        this.bHZ = new CommonWebView(getContext());
        this.bHZ.setVerticalScrollEnabled(false);
        this.bHZ.setHorizontalScrollEnabled(false);
        this.bHZ.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (!"file:///android_asset/web/error.html".equals(str) && Build.VERSION.SDK_INT >= 19) {
                    AlaActiveWebView.this.evaluateJavascript("javascript:window.getClientInfo != undefined", new ValueCallback<String>() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            AlaActiveWebView.this.gPl = Boolean.valueOf(str2).booleanValue();
                            if (AlaActiveWebView.this.gPk != null) {
                                AlaActiveWebView.this.gPk.mz(Boolean.valueOf(str2).booleanValue());
                            }
                        }
                    });
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (Build.VERSION.SDK_INT < 23) {
                    AlaActiveWebView.this.rw(str2);
                }
            }

            @Override // android.webkit.WebViewClient
            @RequiresApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                String uri;
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame() && webResourceRequest.getUrl() != null && (uri = webResourceRequest.getUrl().toString()) != null && !uri.equals("file:///android_asset/web/error.html")) {
                    AlaActiveWebView.this.rw(uri);
                }
            }
        });
        addView(this.bHZ, new FrameLayout.LayoutParams(-1, -1));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.bHZ.resumeTimers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rw(String str) {
        this.eul = str;
        this.bHZ.loadUrl("file:///android_asset/web/error.html");
        this.bHZ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (AlaActiveWebView.this.bHZ != null && AlaActiveWebView.this.bHZ.getUrl() != null && AlaActiveWebView.this.bHZ.getUrl().equals("file:///android_asset/web/error.html") && !TextUtils.isEmpty(AlaActiveWebView.this.eul)) {
                    AlaActiveWebView.this.bHZ.loadUrl(AlaActiveWebView.this.eul);
                    return false;
                }
                return false;
            }
        });
    }

    public SchemeCallback getSchemeCallback() {
        return this.bIc;
    }
}
