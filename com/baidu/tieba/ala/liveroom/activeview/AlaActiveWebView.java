package com.baidu.tieba.ala.liveroom.activeview;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import com.baidu.live.tbadk.scheme.SchemeUtils;
import com.baidu.live.u.a;
import com.baidu.live.view.web.CommonWebView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaActiveWebView extends FrameLayout implements c {
    private CommonWebView bjW;
    private List<String> bjX;
    private SchemeCallback bjZ;
    private a fJl;
    private boolean fJm;
    private ImageView fJn;

    /* loaded from: classes3.dex */
    public interface a {
        void kk(boolean z);
    }

    public AlaActiveWebView(Context context) {
        super(context);
        this.bjZ = new SchemeCallback() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.3
            @Override // com.baidu.live.tbadk.scheme.SchemeCallback
            public void doJsCallback(int i, String str, JSONObject jSONObject, String str2) {
                try {
                    String assembJavaScript = SchemeUtils.assembJavaScript(i, str, jSONObject, str2);
                    if (Build.VERSION.SDK_INT >= 19) {
                        AlaActiveWebView.this.bjW.evaluateJavascript(assembJavaScript, null);
                    } else {
                        AlaActiveWebView.this.bjW.loadUrl(assembJavaScript);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.fJl = aVar;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.bjX == null) {
            this.bjX = new ArrayList();
        }
        this.bjX.add(str);
        this.bjW.addJavascriptInterface(obj, str);
    }

    public void loadUrl(String str) {
        if (this.bjW != null) {
            this.bjW.loadUrl(str);
        }
    }

    public String getOriginalUrl() {
        return this.bjW != null ? this.bjW.getOriginalUrl() : "";
    }

    public boolean bxu() {
        return this.fJm;
    }

    @RequiresApi(19)
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.bjW != null) {
            this.bjW.evaluateJavascript(str, valueCallback);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStart() {
        if (this.bjW != null) {
            this.bjW.onResume();
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.bjW.resumeTimers();
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStop() {
        if (this.bjW != null) {
            this.bjW.onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void release() {
        this.fJl = null;
        this.fJm = false;
        removeAllViews();
        if (this.bjW != null) {
            if (this.bjX != null) {
                for (String str : this.bjX) {
                    this.bjW.removeJavascriptInterface(str);
                }
                this.bjX.clear();
            }
            this.bjW.stopLoading();
            this.bjW.removeAllViews();
            this.bjW.loadUrl("about:blank");
            this.bjW.freeMemory();
            this.bjW.destroy();
        }
    }

    private void init() {
        this.fJm = false;
        setBackgroundColor(0);
        this.bjW = new CommonWebView(getContext());
        this.bjW.setVerticalScrollEnabled(false);
        this.bjW.setHorizontalScrollEnabled(false);
        this.bjW.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.1
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                if (AlaActiveWebView.this.fJn != null) {
                    AlaActiveWebView.this.fJn.setVisibility(8);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (Build.VERSION.SDK_INT >= 19) {
                    AlaActiveWebView.this.evaluateJavascript("javascript:window.getClientInfo != undefined", new ValueCallback<String>() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            AlaActiveWebView.this.fJm = Boolean.valueOf(str2).booleanValue();
                            if (AlaActiveWebView.this.fJl != null) {
                                AlaActiveWebView.this.fJl.kk(Boolean.valueOf(str2).booleanValue());
                            }
                        }
                    });
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (Build.VERSION.SDK_INT < 23) {
                    AlaActiveWebView.this.bxv();
                }
            }

            @Override // android.webkit.WebViewClient
            @RequiresApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame()) {
                    AlaActiveWebView.this.bxv();
                }
            }
        });
        addView(this.bjW, new FrameLayout.LayoutParams(-1, -1));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.bjW.resumeTimers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxv() {
        if (this.fJn == null) {
            this.fJn = new ImageView(getContext());
            this.fJn.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.fJn.setImageResource(a.f.icon_live_active_web_error);
            this.fJn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaActiveWebView.this.bjW != null) {
                        if (!TextUtils.isEmpty(AlaActiveWebView.this.bjW.getUrl())) {
                            AlaActiveWebView.this.bjW.loadUrl(AlaActiveWebView.this.bjW.getUrl());
                        } else if (!TextUtils.isEmpty(AlaActiveWebView.this.bjW.getOriginalUrl())) {
                            AlaActiveWebView.this.bjW.loadUrl(AlaActiveWebView.this.bjW.getOriginalUrl());
                        }
                    }
                }
            });
            addView(this.fJn, new FrameLayout.LayoutParams(-1, -1));
        }
        this.fJn.setVisibility(0);
    }

    public SchemeCallback getSchemeCallback() {
        return this.bjZ;
    }
}
