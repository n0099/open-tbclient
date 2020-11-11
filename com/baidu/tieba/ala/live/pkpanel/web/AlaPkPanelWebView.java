package com.baidu.tieba.ala.live.pkpanel.web;

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
public class AlaPkPanelWebView extends FrameLayout {
    private CommonWebView bNE;
    private List<String> bNF;
    private SchemeCallback bNH;
    private String eAe;
    private a gSi;
    private boolean gSj;

    /* loaded from: classes4.dex */
    public interface a {
        void mE(boolean z);
    }

    public AlaPkPanelWebView(Context context) {
        super(context);
        this.bNH = new SchemeCallback() { // from class: com.baidu.tieba.ala.live.pkpanel.web.AlaPkPanelWebView.3
            @Override // com.baidu.live.tbadk.scheme.SchemeCallback
            public void doJsCallback(int i, String str, JSONObject jSONObject, String str2) {
                try {
                    String assembJavaScript = SchemeUtils.assembJavaScript(i, str, jSONObject, str2);
                    if (Build.VERSION.SDK_INT >= 19) {
                        AlaPkPanelWebView.this.bNE.evaluateJavascript(assembJavaScript, null);
                    } else {
                        AlaPkPanelWebView.this.bNE.loadUrl(assembJavaScript);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.gSi = aVar;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.bNF == null) {
            this.bNF = new ArrayList();
        }
        this.bNF.add(str);
        this.bNE.addJavascriptInterface(obj, str);
    }

    public void loadUrl(String str) {
        if (this.bNE != null) {
            this.bNE.loadUrl(str);
        }
    }

    public String getOriginalUrl() {
        return this.bNE != null ? this.bNE.getOriginalUrl() : "";
    }

    public boolean bVS() {
        return this.gSj;
    }

    @RequiresApi(19)
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.bNE != null) {
            this.bNE.evaluateJavascript(str, valueCallback);
        }
    }

    private void init() {
        this.gSj = false;
        setBackgroundColor(0);
        if (getBackground() != null) {
            getBackground().setAlpha(0);
        }
        this.bNE = new CommonWebView(getContext());
        this.bNE.setVerticalScrollEnabled(false);
        this.bNE.setHorizontalScrollEnabled(false);
        this.bNE.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.ala.live.pkpanel.web.AlaPkPanelWebView.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (!"file:///android_asset/web/error.html".equals(str) && Build.VERSION.SDK_INT >= 19) {
                    AlaPkPanelWebView.this.evaluateJavascript("javascript:window.getClientInfo != undefined", new ValueCallback<String>() { // from class: com.baidu.tieba.ala.live.pkpanel.web.AlaPkPanelWebView.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            AlaPkPanelWebView.this.gSj = Boolean.valueOf(str2).booleanValue();
                            if (AlaPkPanelWebView.this.gSi != null) {
                                AlaPkPanelWebView.this.gSi.mE(Boolean.valueOf(str2).booleanValue());
                            }
                        }
                    });
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (Build.VERSION.SDK_INT < 23) {
                    AlaPkPanelWebView.this.rK(str2);
                }
            }

            @Override // android.webkit.WebViewClient
            @RequiresApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                String uri;
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame() && webResourceRequest.getUrl() != null && (uri = webResourceRequest.getUrl().toString()) != null && !uri.equals("file:///android_asset/web/error.html")) {
                    AlaPkPanelWebView.this.rK(uri);
                }
            }
        });
        addView(this.bNE, new FrameLayout.LayoutParams(-1, -1));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.bNE.resumeTimers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rK(String str) {
        this.eAe = str;
        this.bNE.loadUrl("file:///android_asset/web/error.html");
        this.bNE.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.live.pkpanel.web.AlaPkPanelWebView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (AlaPkPanelWebView.this.bNE != null && AlaPkPanelWebView.this.bNE.getUrl() != null && AlaPkPanelWebView.this.bNE.getUrl().equals("file:///android_asset/web/error.html") && !TextUtils.isEmpty(AlaPkPanelWebView.this.eAe)) {
                    AlaPkPanelWebView.this.bNE.loadUrl(AlaPkPanelWebView.this.eAe);
                    return false;
                }
                return false;
            }
        });
    }

    public SchemeCallback getSchemeCallback() {
        return this.bNH;
    }
}
