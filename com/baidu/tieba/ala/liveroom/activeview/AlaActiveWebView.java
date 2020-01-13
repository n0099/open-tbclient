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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import com.baidu.live.tbadk.scheme.SchemeUtils;
import com.baidu.live.view.web.CommonWebView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaActiveWebView extends FrameLayout implements c {
    private CommonWebView aCg;
    private List<String> aCh;
    private SchemeCallback aCj;
    private a eMa;
    private boolean eMb;
    private ImageView eMc;

    /* loaded from: classes2.dex */
    public interface a {
        void iF(boolean z);
    }

    public AlaActiveWebView(Context context) {
        super(context);
        this.aCj = new SchemeCallback() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.3
            @Override // com.baidu.live.tbadk.scheme.SchemeCallback
            public void doJsCallback(int i, String str, JSONObject jSONObject, String str2) {
                try {
                    String assembJavaScript = SchemeUtils.assembJavaScript(i, str, jSONObject, str2);
                    if (Build.VERSION.SDK_INT >= 19) {
                        AlaActiveWebView.this.aCg.evaluateJavascript(assembJavaScript, null);
                    } else {
                        AlaActiveWebView.this.aCg.loadUrl(assembJavaScript);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.eMa = aVar;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.aCh == null) {
            this.aCh = new ArrayList();
        }
        this.aCh.add(str);
        this.aCg.addJavascriptInterface(obj, str);
    }

    public void loadUrl(String str) {
        if (this.aCg != null) {
            this.aCg.loadUrl(str);
        }
    }

    public String getOriginalUrl() {
        return this.aCg != null ? this.aCg.getOriginalUrl() : "";
    }

    public boolean bfT() {
        return this.eMb;
    }

    @RequiresApi(19)
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.aCg != null) {
            this.aCg.evaluateJavascript(str, valueCallback);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStart() {
        if (this.aCg != null) {
            this.aCg.onResume();
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.aCg.resumeTimers();
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStop() {
        if (this.aCg != null) {
            this.aCg.onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void release() {
        this.eMa = null;
        this.eMb = false;
        removeAllViews();
        if (this.aCg != null) {
            if (this.aCh != null) {
                for (String str : this.aCh) {
                    this.aCg.removeJavascriptInterface(str);
                }
                this.aCh.clear();
            }
            this.aCg.stopLoading();
            this.aCg.removeAllViews();
            this.aCg.loadUrl("about:blank");
            this.aCg.freeMemory();
            this.aCg.destroy();
        }
    }

    private void init() {
        this.eMb = false;
        setBackgroundColor(0);
        this.aCg = new CommonWebView(getContext());
        this.aCg.setVerticalScrollEnabled(false);
        this.aCg.setHorizontalScrollEnabled(false);
        this.aCg.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.1
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                if (AlaActiveWebView.this.eMc != null) {
                    AlaActiveWebView.this.eMc.setVisibility(8);
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
                            AlaActiveWebView.this.eMb = Boolean.valueOf(str2).booleanValue();
                            if (AlaActiveWebView.this.eMa != null) {
                                AlaActiveWebView.this.eMa.iF(Boolean.valueOf(str2).booleanValue());
                            }
                        }
                    });
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (Build.VERSION.SDK_INT < 23) {
                    AlaActiveWebView.this.bfU();
                }
            }

            @Override // android.webkit.WebViewClient
            @RequiresApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame()) {
                    AlaActiveWebView.this.bfU();
                }
            }
        });
        addView(this.aCg, new FrameLayout.LayoutParams(-1, -1));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.aCg.resumeTimers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfU() {
        if (this.eMc == null) {
            this.eMc = new ImageView(getContext());
            this.eMc.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.eMc.setImageResource(a.f.icon_live_active_web_error);
            this.eMc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaActiveWebView.this.aCg != null) {
                        if (!TextUtils.isEmpty(AlaActiveWebView.this.aCg.getUrl())) {
                            AlaActiveWebView.this.aCg.loadUrl(AlaActiveWebView.this.aCg.getUrl());
                        } else if (!TextUtils.isEmpty(AlaActiveWebView.this.aCg.getOriginalUrl())) {
                            AlaActiveWebView.this.aCg.loadUrl(AlaActiveWebView.this.aCg.getOriginalUrl());
                        }
                    }
                }
            });
            addView(this.eMc, new FrameLayout.LayoutParams(-1, -1));
        }
        this.eMc.setVisibility(0);
    }

    public SchemeCallback getSchemeCallback() {
        return this.aCj;
    }
}
