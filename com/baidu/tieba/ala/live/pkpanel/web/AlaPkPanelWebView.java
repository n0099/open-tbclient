package com.baidu.tieba.ala.live.pkpanel.web;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import com.baidu.live.tbadk.scheme.SchemeUtils;
import com.baidu.live.view.web.CommonWebView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaPkPanelWebView extends FrameLayout {
    private CommonWebView bWG;
    private List<String> bWH;
    private SchemeCallback bWJ;
    private String ePk;
    private a hmQ;
    private boolean hmR;

    /* loaded from: classes11.dex */
    public interface a {
        void nz(boolean z);
    }

    public AlaPkPanelWebView(Context context) {
        super(context);
        this.bWJ = new SchemeCallback() { // from class: com.baidu.tieba.ala.live.pkpanel.web.AlaPkPanelWebView.3
            @Override // com.baidu.live.tbadk.scheme.SchemeCallback
            public void doJsCallback(int i, String str, JSONObject jSONObject, String str2) {
                try {
                    String assembJavaScript = SchemeUtils.assembJavaScript(i, str, jSONObject, str2);
                    if (Build.VERSION.SDK_INT >= 19) {
                        AlaPkPanelWebView.this.bWG.evaluateJavascript(assembJavaScript, null);
                    } else {
                        AlaPkPanelWebView.this.bWG.loadUrl(assembJavaScript);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.hmQ = aVar;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.bWH == null) {
            this.bWH = new ArrayList();
        }
        this.bWH.add(str);
        this.bWG.addJavascriptInterface(obj, str);
    }

    public void loadUrl(String str) {
        if (this.bWG != null) {
            this.bWG.loadUrl(str);
        }
    }

    public String getOriginalUrl() {
        return this.bWG != null ? this.bWG.getOriginalUrl() : "";
    }

    public boolean cbD() {
        return this.hmR;
    }

    @RequiresApi(19)
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.bWG != null) {
            this.bWG.evaluateJavascript(str, valueCallback);
        }
    }

    public void release() {
        this.hmQ = null;
        this.hmR = false;
        removeAllViews();
        if (this.bWG != null) {
            if (this.bWH != null) {
                for (String str : this.bWH) {
                    this.bWG.removeJavascriptInterface(str);
                }
                this.bWH.clear();
            }
            this.bWG.stopLoading();
            this.bWG.removeAllViews();
            this.bWG.loadUrl("about:blank");
            this.bWG.freeMemory();
            this.bWG.destroy();
        }
    }

    private void init() {
        this.hmR = false;
        setBackgroundColor(0);
        if (getBackground() != null) {
            getBackground().setAlpha(0);
        }
        this.bWG = new CommonWebView(getContext());
        this.bWG.setVerticalScrollEnabled(false);
        this.bWG.setHorizontalScrollEnabled(false);
        this.bWG.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.ala.live.pkpanel.web.AlaPkPanelWebView.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (!"file:///android_asset/web/error.html".equals(str) && Build.VERSION.SDK_INT >= 19) {
                    AlaPkPanelWebView.this.evaluateJavascript("javascript:window.getClientInfo != undefined", new ValueCallback<String>() { // from class: com.baidu.tieba.ala.live.pkpanel.web.AlaPkPanelWebView.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            AlaPkPanelWebView.this.hmR = Boolean.valueOf(str2).booleanValue();
                            if (AlaPkPanelWebView.this.hmQ != null) {
                                AlaPkPanelWebView.this.hmQ.nz(Boolean.valueOf(str2).booleanValue());
                            }
                        }
                    });
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (Build.VERSION.SDK_INT < 23) {
                    AlaPkPanelWebView.this.se(str2);
                }
            }

            @Override // android.webkit.WebViewClient
            @RequiresApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                String uri;
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame() && webResourceRequest.getUrl() != null && (uri = webResourceRequest.getUrl().toString()) != null && !uri.equals("file:///android_asset/web/error.html")) {
                    AlaPkPanelWebView.this.se(uri);
                }
            }
        });
        addView(this.bWG, new FrameLayout.LayoutParams(-1, -1));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.bWG.resumeTimers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void se(String str) {
        this.ePk = str;
        this.bWG.loadUrl("file:///android_asset/web/error.html");
        this.bWG.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.live.pkpanel.web.AlaPkPanelWebView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (AlaPkPanelWebView.this.bWG != null && AlaPkPanelWebView.this.bWG.getUrl() != null && AlaPkPanelWebView.this.bWG.getUrl().equals("file:///android_asset/web/error.html") && !TextUtils.isEmpty(AlaPkPanelWebView.this.ePk)) {
                    AlaPkPanelWebView.this.bWG.loadUrl(AlaPkPanelWebView.this.ePk);
                    return false;
                }
                return false;
            }
        });
    }

    public SchemeCallback getSchemeCallback() {
        return this.bWJ;
    }
}
