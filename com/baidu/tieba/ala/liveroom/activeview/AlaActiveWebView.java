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
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import com.baidu.live.tbadk.scheme.SchemeUtils;
import com.baidu.live.view.web.CommonWebView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AlaActiveWebView extends FrameLayout implements c {
    private CommonWebView atK;
    private List<String> atL;
    private SchemeCallback atN;
    private a dWd;
    private boolean dWe;
    private ImageView dWf;

    /* loaded from: classes6.dex */
    public interface a {
        void hl(boolean z);
    }

    public AlaActiveWebView(Context context) {
        super(context);
        this.atN = new SchemeCallback() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.3
            @Override // com.baidu.live.tbadk.scheme.SchemeCallback
            public void doJsCallback(int i, String str, JSONObject jSONObject, String str2) {
                try {
                    String assembJavaScript = SchemeUtils.assembJavaScript(i, str, jSONObject, str2);
                    if (Build.VERSION.SDK_INT >= 19) {
                        AlaActiveWebView.this.atK.evaluateJavascript(assembJavaScript, null);
                    } else {
                        AlaActiveWebView.this.atK.loadUrl(assembJavaScript);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.dWd = aVar;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.atL == null) {
            this.atL = new ArrayList();
        }
        this.atL.add(str);
        this.atK.addJavascriptInterface(obj, str);
    }

    public void loadUrl(String str) {
        if (this.atK != null) {
            this.atK.loadUrl(str);
        }
    }

    public String getOriginalUrl() {
        return this.atK != null ? this.atK.getOriginalUrl() : "";
    }

    public boolean aNZ() {
        return this.dWe;
    }

    @RequiresApi(19)
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.atK != null) {
            this.atK.evaluateJavascript(str, valueCallback);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStart() {
        if (this.atK != null) {
            this.atK.onResume();
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.atK.resumeTimers();
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStop() {
        if (this.atK != null) {
            this.atK.onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void release() {
        this.dWd = null;
        this.dWe = false;
        removeAllViews();
        if (this.atK != null) {
            if (this.atL != null) {
                for (String str : this.atL) {
                    this.atK.removeJavascriptInterface(str);
                }
                this.atL.clear();
            }
            this.atK.stopLoading();
            this.atK.removeAllViews();
            this.atK.loadUrl("about:blank");
            this.atK.freeMemory();
            this.atK.destroy();
        }
    }

    private void init() {
        this.dWe = false;
        setBackgroundColor(0);
        this.atK = new CommonWebView(getContext());
        this.atK.setVerticalScrollEnabled(false);
        this.atK.setHorizontalScrollEnabled(false);
        this.atK.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.1
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                if (AlaActiveWebView.this.dWf != null) {
                    AlaActiveWebView.this.dWf.setVisibility(8);
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
                            AlaActiveWebView.this.dWe = Boolean.valueOf(str2).booleanValue();
                            if (AlaActiveWebView.this.dWd != null) {
                                AlaActiveWebView.this.dWd.hl(Boolean.valueOf(str2).booleanValue());
                            }
                        }
                    });
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (Build.VERSION.SDK_INT < 23) {
                    AlaActiveWebView.this.aOa();
                }
            }

            @Override // android.webkit.WebViewClient
            @RequiresApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame()) {
                    AlaActiveWebView.this.aOa();
                }
            }
        });
        addView(this.atK, new FrameLayout.LayoutParams(-1, -1));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.atK.resumeTimers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOa() {
        if (this.dWf == null) {
            this.dWf = new ImageView(getContext());
            this.dWf.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.dWf.setImageResource(a.f.icon_live_active_web_error);
            this.dWf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaActiveWebView.this.atK != null) {
                        if (!TextUtils.isEmpty(AlaActiveWebView.this.atK.getUrl())) {
                            AlaActiveWebView.this.atK.loadUrl(AlaActiveWebView.this.atK.getUrl());
                        } else if (!TextUtils.isEmpty(AlaActiveWebView.this.atK.getOriginalUrl())) {
                            AlaActiveWebView.this.atK.loadUrl(AlaActiveWebView.this.atK.getOriginalUrl());
                        }
                    }
                }
            });
            addView(this.dWf, new FrameLayout.LayoutParams(-1, -1));
        }
        this.dWf.setVisibility(0);
    }

    public SchemeCallback getSchemeCallback() {
        return this.atN;
    }
}
