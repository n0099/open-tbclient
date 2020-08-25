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
/* loaded from: classes7.dex */
public class AlaActiveWebView extends FrameLayout implements c {
    private CommonWebView bvh;
    private List<String> bvi;
    private SchemeCallback bvk;
    private String dXv;
    private a glS;
    private boolean glT;

    /* loaded from: classes7.dex */
    public interface a {
        void lC(boolean z);
    }

    public AlaActiveWebView(Context context) {
        super(context);
        this.bvk = new SchemeCallback() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.3
            @Override // com.baidu.live.tbadk.scheme.SchemeCallback
            public void doJsCallback(int i, String str, JSONObject jSONObject, String str2) {
                try {
                    String assembJavaScript = SchemeUtils.assembJavaScript(i, str, jSONObject, str2);
                    if (Build.VERSION.SDK_INT >= 19) {
                        AlaActiveWebView.this.bvh.evaluateJavascript(assembJavaScript, null);
                    } else {
                        AlaActiveWebView.this.bvh.loadUrl(assembJavaScript);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.glS = aVar;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.bvi == null) {
            this.bvi = new ArrayList();
        }
        this.bvi.add(str);
        this.bvh.addJavascriptInterface(obj, str);
    }

    public void loadUrl(String str) {
        if (this.bvh != null) {
            this.bvh.loadUrl(str);
        }
    }

    public String getOriginalUrl() {
        return this.bvh != null ? this.bvh.getOriginalUrl() : "";
    }

    public boolean bNa() {
        return this.glT;
    }

    @RequiresApi(19)
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.bvh != null) {
            this.bvh.evaluateJavascript(str, valueCallback);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStart() {
        if (this.bvh != null) {
            this.bvh.onResume();
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.bvh.resumeTimers();
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStop() {
        if (this.bvh != null) {
            this.bvh.onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void release() {
        this.glS = null;
        this.glT = false;
        removeAllViews();
        if (this.bvh != null) {
            if (this.bvi != null) {
                for (String str : this.bvi) {
                    this.bvh.removeJavascriptInterface(str);
                }
                this.bvi.clear();
            }
            this.bvh.stopLoading();
            this.bvh.removeAllViews();
            this.bvh.loadUrl("about:blank");
            this.bvh.freeMemory();
            this.bvh.destroy();
        }
    }

    private void init() {
        this.glT = false;
        setBackgroundColor(0);
        this.bvh = new CommonWebView(getContext());
        this.bvh.setVerticalScrollEnabled(false);
        this.bvh.setHorizontalScrollEnabled(false);
        this.bvh.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (!"file:///android_asset/web/error.html".equals(str) && Build.VERSION.SDK_INT >= 19) {
                    AlaActiveWebView.this.evaluateJavascript("javascript:window.getClientInfo != undefined", new ValueCallback<String>() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            AlaActiveWebView.this.glT = Boolean.valueOf(str2).booleanValue();
                            if (AlaActiveWebView.this.glS != null) {
                                AlaActiveWebView.this.glS.lC(Boolean.valueOf(str2).booleanValue());
                            }
                        }
                    });
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (Build.VERSION.SDK_INT < 23) {
                    AlaActiveWebView.this.pX(str2);
                }
            }

            @Override // android.webkit.WebViewClient
            @RequiresApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                String uri;
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame() && webResourceRequest.getUrl() != null && (uri = webResourceRequest.getUrl().toString()) != null && !uri.equals("file:///android_asset/web/error.html")) {
                    AlaActiveWebView.this.pX(uri);
                }
            }
        });
        addView(this.bvh, new FrameLayout.LayoutParams(-1, -1));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.bvh.resumeTimers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pX(String str) {
        this.dXv = str;
        this.bvh.loadUrl("file:///android_asset/web/error.html");
        this.bvh.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (AlaActiveWebView.this.bvh != null && AlaActiveWebView.this.bvh.getUrl() != null && AlaActiveWebView.this.bvh.getUrl().equals("file:///android_asset/web/error.html") && !TextUtils.isEmpty(AlaActiveWebView.this.dXv)) {
                    AlaActiveWebView.this.bvh.loadUrl(AlaActiveWebView.this.dXv);
                    return false;
                }
                return false;
            }
        });
    }

    public SchemeCallback getSchemeCallback() {
        return this.bvk;
    }
}
