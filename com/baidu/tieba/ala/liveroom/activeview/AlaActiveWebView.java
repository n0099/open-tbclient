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
/* loaded from: classes3.dex */
public class AlaActiveWebView extends FrameLayout implements c {
    private boolean bdv;
    private CommonWebView boX;
    private List<String> boY;
    private SchemeCallback bpa;
    private a fUx;
    private String fUy;

    /* loaded from: classes3.dex */
    public interface a {
        void bZ(boolean z);
    }

    public AlaActiveWebView(Context context) {
        super(context);
        this.bpa = new SchemeCallback() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.3
            @Override // com.baidu.live.tbadk.scheme.SchemeCallback
            public void doJsCallback(int i, String str, JSONObject jSONObject, String str2) {
                try {
                    String assembJavaScript = SchemeUtils.assembJavaScript(i, str, jSONObject, str2);
                    if (Build.VERSION.SDK_INT >= 19) {
                        AlaActiveWebView.this.boX.evaluateJavascript(assembJavaScript, null);
                    } else {
                        AlaActiveWebView.this.boX.loadUrl(assembJavaScript);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.fUx = aVar;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.boY == null) {
            this.boY = new ArrayList();
        }
        this.boY.add(str);
        this.boX.addJavascriptInterface(obj, str);
    }

    public void loadUrl(String str) {
        if (this.boX != null) {
            this.boX.loadUrl(str);
        }
    }

    public String getOriginalUrl() {
        return this.boX != null ? this.boX.getOriginalUrl() : "";
    }

    public boolean bAl() {
        return this.bdv;
    }

    @RequiresApi(19)
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.boX != null) {
            this.boX.evaluateJavascript(str, valueCallback);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStart() {
        if (this.boX != null) {
            this.boX.onResume();
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.boX.resumeTimers();
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStop() {
        if (this.boX != null) {
            this.boX.onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void release() {
        this.fUx = null;
        this.bdv = false;
        removeAllViews();
        if (this.boX != null) {
            if (this.boY != null) {
                for (String str : this.boY) {
                    this.boX.removeJavascriptInterface(str);
                }
                this.boY.clear();
            }
            this.boX.stopLoading();
            this.boX.removeAllViews();
            this.boX.loadUrl("about:blank");
            this.boX.freeMemory();
            this.boX.destroy();
        }
    }

    private void init() {
        this.bdv = false;
        setBackgroundColor(0);
        this.boX = new CommonWebView(getContext());
        this.boX.setVerticalScrollEnabled(false);
        this.boX.setHorizontalScrollEnabled(false);
        this.boX.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (!"file:///android_asset/web/error.html".equals(str) && Build.VERSION.SDK_INT >= 19) {
                    AlaActiveWebView.this.evaluateJavascript("javascript:window.getClientInfo != undefined", new ValueCallback<String>() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            AlaActiveWebView.this.bdv = Boolean.valueOf(str2).booleanValue();
                            if (AlaActiveWebView.this.fUx != null) {
                                AlaActiveWebView.this.fUx.bZ(Boolean.valueOf(str2).booleanValue());
                            }
                        }
                    });
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (Build.VERSION.SDK_INT < 23) {
                    AlaActiveWebView.this.ns(str2);
                }
            }

            @Override // android.webkit.WebViewClient
            @RequiresApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                String uri;
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame() && webResourceRequest.getUrl() != null && (uri = webResourceRequest.getUrl().toString()) != null && !uri.equals("file:///android_asset/web/error.html")) {
                    AlaActiveWebView.this.ns(uri);
                }
            }
        });
        addView(this.boX, new FrameLayout.LayoutParams(-1, -1));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.boX.resumeTimers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ns(String str) {
        this.fUy = str;
        this.boX.loadUrl("file:///android_asset/web/error.html");
        this.boX.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (AlaActiveWebView.this.boX != null && AlaActiveWebView.this.boX.getUrl() != null && AlaActiveWebView.this.boX.getUrl().equals("file:///android_asset/web/error.html") && !TextUtils.isEmpty(AlaActiveWebView.this.fUy)) {
                    AlaActiveWebView.this.boX.loadUrl(AlaActiveWebView.this.fUy);
                    return false;
                }
                return false;
            }
        });
    }

    public SchemeCallback getSchemeCallback() {
        return this.bpa;
    }
}
