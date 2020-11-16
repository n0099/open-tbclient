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
    private CommonWebView bLU;
    private List<String> bLV;
    private SchemeCallback bLX;
    private String eyv;
    private a gRP;
    private boolean gRQ;

    /* loaded from: classes4.dex */
    public interface a {
        void mF(boolean z);
    }

    public AlaPkPanelWebView(Context context) {
        super(context);
        this.bLX = new SchemeCallback() { // from class: com.baidu.tieba.ala.live.pkpanel.web.AlaPkPanelWebView.3
            @Override // com.baidu.live.tbadk.scheme.SchemeCallback
            public void doJsCallback(int i, String str, JSONObject jSONObject, String str2) {
                try {
                    String assembJavaScript = SchemeUtils.assembJavaScript(i, str, jSONObject, str2);
                    if (Build.VERSION.SDK_INT >= 19) {
                        AlaPkPanelWebView.this.bLU.evaluateJavascript(assembJavaScript, null);
                    } else {
                        AlaPkPanelWebView.this.bLU.loadUrl(assembJavaScript);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.gRP = aVar;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.bLV == null) {
            this.bLV = new ArrayList();
        }
        this.bLV.add(str);
        this.bLU.addJavascriptInterface(obj, str);
    }

    public void loadUrl(String str) {
        if (this.bLU != null) {
            this.bLU.loadUrl(str);
        }
    }

    public String getOriginalUrl() {
        return this.bLU != null ? this.bLU.getOriginalUrl() : "";
    }

    public boolean bVl() {
        return this.gRQ;
    }

    @RequiresApi(19)
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.bLU != null) {
            this.bLU.evaluateJavascript(str, valueCallback);
        }
    }

    private void init() {
        this.gRQ = false;
        setBackgroundColor(0);
        if (getBackground() != null) {
            getBackground().setAlpha(0);
        }
        this.bLU = new CommonWebView(getContext());
        this.bLU.setVerticalScrollEnabled(false);
        this.bLU.setHorizontalScrollEnabled(false);
        this.bLU.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.ala.live.pkpanel.web.AlaPkPanelWebView.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (!"file:///android_asset/web/error.html".equals(str) && Build.VERSION.SDK_INT >= 19) {
                    AlaPkPanelWebView.this.evaluateJavascript("javascript:window.getClientInfo != undefined", new ValueCallback<String>() { // from class: com.baidu.tieba.ala.live.pkpanel.web.AlaPkPanelWebView.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            AlaPkPanelWebView.this.gRQ = Boolean.valueOf(str2).booleanValue();
                            if (AlaPkPanelWebView.this.gRP != null) {
                                AlaPkPanelWebView.this.gRP.mF(Boolean.valueOf(str2).booleanValue());
                            }
                        }
                    });
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (Build.VERSION.SDK_INT < 23) {
                    AlaPkPanelWebView.this.rE(str2);
                }
            }

            @Override // android.webkit.WebViewClient
            @RequiresApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                String uri;
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame() && webResourceRequest.getUrl() != null && (uri = webResourceRequest.getUrl().toString()) != null && !uri.equals("file:///android_asset/web/error.html")) {
                    AlaPkPanelWebView.this.rE(uri);
                }
            }
        });
        addView(this.bLU, new FrameLayout.LayoutParams(-1, -1));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.bLU.resumeTimers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rE(String str) {
        this.eyv = str;
        this.bLU.loadUrl("file:///android_asset/web/error.html");
        this.bLU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.live.pkpanel.web.AlaPkPanelWebView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (AlaPkPanelWebView.this.bLU != null && AlaPkPanelWebView.this.bLU.getUrl() != null && AlaPkPanelWebView.this.bLU.getUrl().equals("file:///android_asset/web/error.html") && !TextUtils.isEmpty(AlaPkPanelWebView.this.eyv)) {
                    AlaPkPanelWebView.this.bLU.loadUrl(AlaPkPanelWebView.this.eyv);
                    return false;
                }
                return false;
            }
        });
    }

    public SchemeCallback getSchemeCallback() {
        return this.bLX;
    }
}
