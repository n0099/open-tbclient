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
    private CommonWebView bvk;
    private List<String> bvl;
    private SchemeCallback bvn;
    private String dXz;
    private a glW;
    private boolean glX;

    /* loaded from: classes7.dex */
    public interface a {
        void lE(boolean z);
    }

    public AlaActiveWebView(Context context) {
        super(context);
        this.bvn = new SchemeCallback() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.3
            @Override // com.baidu.live.tbadk.scheme.SchemeCallback
            public void doJsCallback(int i, String str, JSONObject jSONObject, String str2) {
                try {
                    String assembJavaScript = SchemeUtils.assembJavaScript(i, str, jSONObject, str2);
                    if (Build.VERSION.SDK_INT >= 19) {
                        AlaActiveWebView.this.bvk.evaluateJavascript(assembJavaScript, null);
                    } else {
                        AlaActiveWebView.this.bvk.loadUrl(assembJavaScript);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.glW = aVar;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.bvl == null) {
            this.bvl = new ArrayList();
        }
        this.bvl.add(str);
        this.bvk.addJavascriptInterface(obj, str);
    }

    public void loadUrl(String str) {
        if (this.bvk != null) {
            this.bvk.loadUrl(str);
        }
    }

    public String getOriginalUrl() {
        return this.bvk != null ? this.bvk.getOriginalUrl() : "";
    }

    public boolean bNb() {
        return this.glX;
    }

    @RequiresApi(19)
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.bvk != null) {
            this.bvk.evaluateJavascript(str, valueCallback);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStart() {
        if (this.bvk != null) {
            this.bvk.onResume();
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.bvk.resumeTimers();
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStop() {
        if (this.bvk != null) {
            this.bvk.onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void release() {
        this.glW = null;
        this.glX = false;
        removeAllViews();
        if (this.bvk != null) {
            if (this.bvl != null) {
                for (String str : this.bvl) {
                    this.bvk.removeJavascriptInterface(str);
                }
                this.bvl.clear();
            }
            this.bvk.stopLoading();
            this.bvk.removeAllViews();
            this.bvk.loadUrl("about:blank");
            this.bvk.freeMemory();
            this.bvk.destroy();
        }
    }

    private void init() {
        this.glX = false;
        setBackgroundColor(0);
        this.bvk = new CommonWebView(getContext());
        this.bvk.setVerticalScrollEnabled(false);
        this.bvk.setHorizontalScrollEnabled(false);
        this.bvk.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (!"file:///android_asset/web/error.html".equals(str) && Build.VERSION.SDK_INT >= 19) {
                    AlaActiveWebView.this.evaluateJavascript("javascript:window.getClientInfo != undefined", new ValueCallback<String>() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            AlaActiveWebView.this.glX = Boolean.valueOf(str2).booleanValue();
                            if (AlaActiveWebView.this.glW != null) {
                                AlaActiveWebView.this.glW.lE(Boolean.valueOf(str2).booleanValue());
                            }
                        }
                    });
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (Build.VERSION.SDK_INT < 23) {
                    AlaActiveWebView.this.pY(str2);
                }
            }

            @Override // android.webkit.WebViewClient
            @RequiresApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                String uri;
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame() && webResourceRequest.getUrl() != null && (uri = webResourceRequest.getUrl().toString()) != null && !uri.equals("file:///android_asset/web/error.html")) {
                    AlaActiveWebView.this.pY(uri);
                }
            }
        });
        addView(this.bvk, new FrameLayout.LayoutParams(-1, -1));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.bvk.resumeTimers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pY(String str) {
        this.dXz = str;
        this.bvk.loadUrl("file:///android_asset/web/error.html");
        this.bvk.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (AlaActiveWebView.this.bvk != null && AlaActiveWebView.this.bvk.getUrl() != null && AlaActiveWebView.this.bvk.getUrl().equals("file:///android_asset/web/error.html") && !TextUtils.isEmpty(AlaActiveWebView.this.dXz)) {
                    AlaActiveWebView.this.bvk.loadUrl(AlaActiveWebView.this.dXz);
                    return false;
                }
                return false;
            }
        });
    }

    public SchemeCallback getSchemeCallback() {
        return this.bvn;
    }
}
