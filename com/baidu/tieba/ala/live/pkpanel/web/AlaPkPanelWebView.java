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
/* loaded from: classes10.dex */
public class AlaPkPanelWebView extends FrameLayout {
    private CommonWebView bRU;
    private List<String> bRV;
    private SchemeCallback bRX;
    private String eKz;
    private a hik;
    private boolean hil;

    /* loaded from: classes10.dex */
    public interface a {
        void nv(boolean z);
    }

    public AlaPkPanelWebView(Context context) {
        super(context);
        this.bRX = new SchemeCallback() { // from class: com.baidu.tieba.ala.live.pkpanel.web.AlaPkPanelWebView.3
            @Override // com.baidu.live.tbadk.scheme.SchemeCallback
            public void doJsCallback(int i, String str, JSONObject jSONObject, String str2) {
                try {
                    String assembJavaScript = SchemeUtils.assembJavaScript(i, str, jSONObject, str2);
                    if (Build.VERSION.SDK_INT >= 19) {
                        AlaPkPanelWebView.this.bRU.evaluateJavascript(assembJavaScript, null);
                    } else {
                        AlaPkPanelWebView.this.bRU.loadUrl(assembJavaScript);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.hik = aVar;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.bRV == null) {
            this.bRV = new ArrayList();
        }
        this.bRV.add(str);
        this.bRU.addJavascriptInterface(obj, str);
    }

    public void loadUrl(String str) {
        if (this.bRU != null) {
            this.bRU.loadUrl(str);
        }
    }

    public String getOriginalUrl() {
        return this.bRU != null ? this.bRU.getOriginalUrl() : "";
    }

    public boolean bXM() {
        return this.hil;
    }

    @RequiresApi(19)
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.bRU != null) {
            this.bRU.evaluateJavascript(str, valueCallback);
        }
    }

    public void release() {
        this.hik = null;
        this.hil = false;
        removeAllViews();
        if (this.bRU != null) {
            if (this.bRV != null) {
                for (String str : this.bRV) {
                    this.bRU.removeJavascriptInterface(str);
                }
                this.bRV.clear();
            }
            this.bRU.stopLoading();
            this.bRU.removeAllViews();
            this.bRU.loadUrl("about:blank");
            this.bRU.freeMemory();
            this.bRU.destroy();
        }
    }

    private void init() {
        this.hil = false;
        setBackgroundColor(0);
        if (getBackground() != null) {
            getBackground().setAlpha(0);
        }
        this.bRU = new CommonWebView(getContext());
        this.bRU.setVerticalScrollEnabled(false);
        this.bRU.setHorizontalScrollEnabled(false);
        this.bRU.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.ala.live.pkpanel.web.AlaPkPanelWebView.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (!"file:///android_asset/web/error.html".equals(str) && Build.VERSION.SDK_INT >= 19) {
                    AlaPkPanelWebView.this.evaluateJavascript("javascript:window.getClientInfo != undefined", new ValueCallback<String>() { // from class: com.baidu.tieba.ala.live.pkpanel.web.AlaPkPanelWebView.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            AlaPkPanelWebView.this.hil = Boolean.valueOf(str2).booleanValue();
                            if (AlaPkPanelWebView.this.hik != null) {
                                AlaPkPanelWebView.this.hik.nv(Boolean.valueOf(str2).booleanValue());
                            }
                        }
                    });
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (Build.VERSION.SDK_INT < 23) {
                    AlaPkPanelWebView.this.qT(str2);
                }
            }

            @Override // android.webkit.WebViewClient
            @RequiresApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                String uri;
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame() && webResourceRequest.getUrl() != null && (uri = webResourceRequest.getUrl().toString()) != null && !uri.equals("file:///android_asset/web/error.html")) {
                    AlaPkPanelWebView.this.qT(uri);
                }
            }
        });
        addView(this.bRU, new FrameLayout.LayoutParams(-1, -1));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.bRU.resumeTimers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qT(String str) {
        this.eKz = str;
        this.bRU.loadUrl("file:///android_asset/web/error.html");
        this.bRU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.live.pkpanel.web.AlaPkPanelWebView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (AlaPkPanelWebView.this.bRU != null && AlaPkPanelWebView.this.bRU.getUrl() != null && AlaPkPanelWebView.this.bRU.getUrl().equals("file:///android_asset/web/error.html") && !TextUtils.isEmpty(AlaPkPanelWebView.this.eKz)) {
                    AlaPkPanelWebView.this.bRU.loadUrl(AlaPkPanelWebView.this.eKz);
                    return false;
                }
                return false;
            }
        });
    }

    public SchemeCallback getSchemeCallback() {
        return this.bRX;
    }
}
