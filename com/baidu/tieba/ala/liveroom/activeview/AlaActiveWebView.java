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
    private CommonWebView bFa;
    private List<String> bFb;
    private SchemeCallback bFd;
    private String elL;
    private a gDw;
    private boolean gDx;

    /* loaded from: classes4.dex */
    public interface a {
        void mi(boolean z);
    }

    public AlaActiveWebView(Context context) {
        super(context);
        this.bFd = new SchemeCallback() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.3
            @Override // com.baidu.live.tbadk.scheme.SchemeCallback
            public void doJsCallback(int i, String str, JSONObject jSONObject, String str2) {
                try {
                    String assembJavaScript = SchemeUtils.assembJavaScript(i, str, jSONObject, str2);
                    if (Build.VERSION.SDK_INT >= 19) {
                        AlaActiveWebView.this.bFa.evaluateJavascript(assembJavaScript, null);
                    } else {
                        AlaActiveWebView.this.bFa.loadUrl(assembJavaScript);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.gDw = aVar;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.bFb == null) {
            this.bFb = new ArrayList();
        }
        this.bFb.add(str);
        this.bFa.addJavascriptInterface(obj, str);
    }

    public void loadUrl(String str) {
        if (this.bFa != null) {
            this.bFa.loadUrl(str);
        }
    }

    public String getOriginalUrl() {
        return this.bFa != null ? this.bFa.getOriginalUrl() : "";
    }

    public boolean bRB() {
        return this.gDx;
    }

    @RequiresApi(19)
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.bFa != null) {
            this.bFa.evaluateJavascript(str, valueCallback);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStart() {
        if (this.bFa != null) {
            this.bFa.onResume();
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.bFa.resumeTimers();
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStop() {
        if (this.bFa != null) {
            this.bFa.onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void release() {
        this.gDw = null;
        this.gDx = false;
        removeAllViews();
        if (this.bFa != null) {
            if (this.bFb != null) {
                for (String str : this.bFb) {
                    this.bFa.removeJavascriptInterface(str);
                }
                this.bFb.clear();
            }
            this.bFa.stopLoading();
            this.bFa.removeAllViews();
            this.bFa.loadUrl("about:blank");
            this.bFa.freeMemory();
            this.bFa.destroy();
        }
    }

    private void init() {
        this.gDx = false;
        setBackgroundColor(0);
        if (getBackground() != null) {
            getBackground().setAlpha(0);
        }
        this.bFa = new CommonWebView(getContext());
        this.bFa.setVerticalScrollEnabled(false);
        this.bFa.setHorizontalScrollEnabled(false);
        this.bFa.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (!"file:///android_asset/web/error.html".equals(str) && Build.VERSION.SDK_INT >= 19) {
                    AlaActiveWebView.this.evaluateJavascript("javascript:window.getClientInfo != undefined", new ValueCallback<String>() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            AlaActiveWebView.this.gDx = Boolean.valueOf(str2).booleanValue();
                            if (AlaActiveWebView.this.gDw != null) {
                                AlaActiveWebView.this.gDw.mi(Boolean.valueOf(str2).booleanValue());
                            }
                        }
                    });
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (Build.VERSION.SDK_INT < 23) {
                    AlaActiveWebView.this.rd(str2);
                }
            }

            @Override // android.webkit.WebViewClient
            @RequiresApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                String uri;
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame() && webResourceRequest.getUrl() != null && (uri = webResourceRequest.getUrl().toString()) != null && !uri.equals("file:///android_asset/web/error.html")) {
                    AlaActiveWebView.this.rd(uri);
                }
            }
        });
        addView(this.bFa, new FrameLayout.LayoutParams(-1, -1));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.bFa.resumeTimers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rd(String str) {
        this.elL = str;
        this.bFa.loadUrl("file:///android_asset/web/error.html");
        this.bFa.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (AlaActiveWebView.this.bFa != null && AlaActiveWebView.this.bFa.getUrl() != null && AlaActiveWebView.this.bFa.getUrl().equals("file:///android_asset/web/error.html") && !TextUtils.isEmpty(AlaActiveWebView.this.elL)) {
                    AlaActiveWebView.this.bFa.loadUrl(AlaActiveWebView.this.elL);
                    return false;
                }
                return false;
            }
        });
    }

    public SchemeCallback getSchemeCallback() {
        return this.bFd;
    }
}
