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
    private SchemeCallback byA;
    private CommonWebView byx;
    private List<String> byy;
    private String dZJ;
    private a gpd;
    private boolean gpe;

    /* loaded from: classes4.dex */
    public interface a {
        void lG(boolean z);
    }

    public AlaActiveWebView(Context context) {
        super(context);
        this.byA = new SchemeCallback() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.3
            @Override // com.baidu.live.tbadk.scheme.SchemeCallback
            public void doJsCallback(int i, String str, JSONObject jSONObject, String str2) {
                try {
                    String assembJavaScript = SchemeUtils.assembJavaScript(i, str, jSONObject, str2);
                    if (Build.VERSION.SDK_INT >= 19) {
                        AlaActiveWebView.this.byx.evaluateJavascript(assembJavaScript, null);
                    } else {
                        AlaActiveWebView.this.byx.loadUrl(assembJavaScript);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.gpd = aVar;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.byy == null) {
            this.byy = new ArrayList();
        }
        this.byy.add(str);
        this.byx.addJavascriptInterface(obj, str);
    }

    public void loadUrl(String str) {
        if (this.byx != null) {
            this.byx.loadUrl(str);
        }
    }

    public String getOriginalUrl() {
        return this.byx != null ? this.byx.getOriginalUrl() : "";
    }

    public boolean bOk() {
        return this.gpe;
    }

    @RequiresApi(19)
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.byx != null) {
            this.byx.evaluateJavascript(str, valueCallback);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStart() {
        if (this.byx != null) {
            this.byx.onResume();
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.byx.resumeTimers();
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStop() {
        if (this.byx != null) {
            this.byx.onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void release() {
        this.gpd = null;
        this.gpe = false;
        removeAllViews();
        if (this.byx != null) {
            if (this.byy != null) {
                for (String str : this.byy) {
                    this.byx.removeJavascriptInterface(str);
                }
                this.byy.clear();
            }
            this.byx.stopLoading();
            this.byx.removeAllViews();
            this.byx.loadUrl("about:blank");
            this.byx.freeMemory();
            this.byx.destroy();
        }
    }

    private void init() {
        this.gpe = false;
        setBackgroundColor(0);
        if (getBackground() != null) {
            getBackground().setAlpha(0);
        }
        this.byx = new CommonWebView(getContext());
        this.byx.setVerticalScrollEnabled(false);
        this.byx.setHorizontalScrollEnabled(false);
        this.byx.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (!"file:///android_asset/web/error.html".equals(str) && Build.VERSION.SDK_INT >= 19) {
                    AlaActiveWebView.this.evaluateJavascript("javascript:window.getClientInfo != undefined", new ValueCallback<String>() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            AlaActiveWebView.this.gpe = Boolean.valueOf(str2).booleanValue();
                            if (AlaActiveWebView.this.gpd != null) {
                                AlaActiveWebView.this.gpd.lG(Boolean.valueOf(str2).booleanValue());
                            }
                        }
                    });
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (Build.VERSION.SDK_INT < 23) {
                    AlaActiveWebView.this.qr(str2);
                }
            }

            @Override // android.webkit.WebViewClient
            @RequiresApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                String uri;
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame() && webResourceRequest.getUrl() != null && (uri = webResourceRequest.getUrl().toString()) != null && !uri.equals("file:///android_asset/web/error.html")) {
                    AlaActiveWebView.this.qr(uri);
                }
            }
        });
        addView(this.byx, new FrameLayout.LayoutParams(-1, -1));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.byx.resumeTimers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qr(String str) {
        this.dZJ = str;
        this.byx.loadUrl("file:///android_asset/web/error.html");
        this.byx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (AlaActiveWebView.this.byx != null && AlaActiveWebView.this.byx.getUrl() != null && AlaActiveWebView.this.byx.getUrl().equals("file:///android_asset/web/error.html") && !TextUtils.isEmpty(AlaActiveWebView.this.dZJ)) {
                    AlaActiveWebView.this.byx.loadUrl(AlaActiveWebView.this.dZJ);
                    return false;
                }
                return false;
            }
        });
    }

    public SchemeCallback getSchemeCallback() {
        return this.byA;
    }
}
