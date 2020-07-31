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
    private boolean bdN;
    private CommonWebView bps;
    private List<String> bpt;
    private SchemeCallback bpv;
    private a fZP;
    private String fZQ;

    /* loaded from: classes4.dex */
    public interface a {
        void cb(boolean z);
    }

    public AlaActiveWebView(Context context) {
        super(context);
        this.bpv = new SchemeCallback() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.3
            @Override // com.baidu.live.tbadk.scheme.SchemeCallback
            public void doJsCallback(int i, String str, JSONObject jSONObject, String str2) {
                try {
                    String assembJavaScript = SchemeUtils.assembJavaScript(i, str, jSONObject, str2);
                    if (Build.VERSION.SDK_INT >= 19) {
                        AlaActiveWebView.this.bps.evaluateJavascript(assembJavaScript, null);
                    } else {
                        AlaActiveWebView.this.bps.loadUrl(assembJavaScript);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.fZP = aVar;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.bpt == null) {
            this.bpt = new ArrayList();
        }
        this.bpt.add(str);
        this.bps.addJavascriptInterface(obj, str);
    }

    public void loadUrl(String str) {
        if (this.bps != null) {
            this.bps.loadUrl(str);
        }
    }

    public String getOriginalUrl() {
        return this.bps != null ? this.bps.getOriginalUrl() : "";
    }

    public boolean bDz() {
        return this.bdN;
    }

    @RequiresApi(19)
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.bps != null) {
            this.bps.evaluateJavascript(str, valueCallback);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStart() {
        if (this.bps != null) {
            this.bps.onResume();
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.bps.resumeTimers();
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStop() {
        if (this.bps != null) {
            this.bps.onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void release() {
        this.fZP = null;
        this.bdN = false;
        removeAllViews();
        if (this.bps != null) {
            if (this.bpt != null) {
                for (String str : this.bpt) {
                    this.bps.removeJavascriptInterface(str);
                }
                this.bpt.clear();
            }
            this.bps.stopLoading();
            this.bps.removeAllViews();
            this.bps.loadUrl("about:blank");
            this.bps.freeMemory();
            this.bps.destroy();
        }
    }

    private void init() {
        this.bdN = false;
        setBackgroundColor(0);
        this.bps = new CommonWebView(getContext());
        this.bps.setVerticalScrollEnabled(false);
        this.bps.setHorizontalScrollEnabled(false);
        this.bps.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (!"file:///android_asset/web/error.html".equals(str) && Build.VERSION.SDK_INT >= 19) {
                    AlaActiveWebView.this.evaluateJavascript("javascript:window.getClientInfo != undefined", new ValueCallback<String>() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            AlaActiveWebView.this.bdN = Boolean.valueOf(str2).booleanValue();
                            if (AlaActiveWebView.this.fZP != null) {
                                AlaActiveWebView.this.fZP.cb(Boolean.valueOf(str2).booleanValue());
                            }
                        }
                    });
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (Build.VERSION.SDK_INT < 23) {
                    AlaActiveWebView.this.nZ(str2);
                }
            }

            @Override // android.webkit.WebViewClient
            @RequiresApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                String uri;
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame() && webResourceRequest.getUrl() != null && (uri = webResourceRequest.getUrl().toString()) != null && !uri.equals("file:///android_asset/web/error.html")) {
                    AlaActiveWebView.this.nZ(uri);
                }
            }
        });
        addView(this.bps, new FrameLayout.LayoutParams(-1, -1));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.bps.resumeTimers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nZ(String str) {
        this.fZQ = str;
        this.bps.loadUrl("file:///android_asset/web/error.html");
        this.bps.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (AlaActiveWebView.this.bps != null && AlaActiveWebView.this.bps.getUrl() != null && AlaActiveWebView.this.bps.getUrl().equals("file:///android_asset/web/error.html") && !TextUtils.isEmpty(AlaActiveWebView.this.fZQ)) {
                    AlaActiveWebView.this.bps.loadUrl(AlaActiveWebView.this.fZQ);
                    return false;
                }
                return false;
            }
        });
    }

    public SchemeCallback getSchemeCallback() {
        return this.bpv;
    }
}
