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
    private CommonWebView aGo;
    private List<String> aGp;
    private SchemeCallback aGr;
    private a eQe;
    private boolean eQf;
    private ImageView eQg;

    /* loaded from: classes3.dex */
    public interface a {
        void iO(boolean z);
    }

    public AlaActiveWebView(Context context) {
        super(context);
        this.aGr = new SchemeCallback() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.3
            @Override // com.baidu.live.tbadk.scheme.SchemeCallback
            public void doJsCallback(int i, String str, JSONObject jSONObject, String str2) {
                try {
                    String assembJavaScript = SchemeUtils.assembJavaScript(i, str, jSONObject, str2);
                    if (Build.VERSION.SDK_INT >= 19) {
                        AlaActiveWebView.this.aGo.evaluateJavascript(assembJavaScript, null);
                    } else {
                        AlaActiveWebView.this.aGo.loadUrl(assembJavaScript);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.eQe = aVar;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.aGp == null) {
            this.aGp = new ArrayList();
        }
        this.aGp.add(str);
        this.aGo.addJavascriptInterface(obj, str);
    }

    public void loadUrl(String str) {
        if (this.aGo != null) {
            this.aGo.loadUrl(str);
        }
    }

    public String getOriginalUrl() {
        return this.aGo != null ? this.aGo.getOriginalUrl() : "";
    }

    public boolean bie() {
        return this.eQf;
    }

    @RequiresApi(19)
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.aGo != null) {
            this.aGo.evaluateJavascript(str, valueCallback);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStart() {
        if (this.aGo != null) {
            this.aGo.onResume();
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.aGo.resumeTimers();
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStop() {
        if (this.aGo != null) {
            this.aGo.onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void release() {
        this.eQe = null;
        this.eQf = false;
        removeAllViews();
        if (this.aGo != null) {
            if (this.aGp != null) {
                for (String str : this.aGp) {
                    this.aGo.removeJavascriptInterface(str);
                }
                this.aGp.clear();
            }
            this.aGo.stopLoading();
            this.aGo.removeAllViews();
            this.aGo.loadUrl("about:blank");
            this.aGo.freeMemory();
            this.aGo.destroy();
        }
    }

    private void init() {
        this.eQf = false;
        setBackgroundColor(0);
        this.aGo = new CommonWebView(getContext());
        this.aGo.setVerticalScrollEnabled(false);
        this.aGo.setHorizontalScrollEnabled(false);
        this.aGo.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.1
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                if (AlaActiveWebView.this.eQg != null) {
                    AlaActiveWebView.this.eQg.setVisibility(8);
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
                            AlaActiveWebView.this.eQf = Boolean.valueOf(str2).booleanValue();
                            if (AlaActiveWebView.this.eQe != null) {
                                AlaActiveWebView.this.eQe.iO(Boolean.valueOf(str2).booleanValue());
                            }
                        }
                    });
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (Build.VERSION.SDK_INT < 23) {
                    AlaActiveWebView.this.bif();
                }
            }

            @Override // android.webkit.WebViewClient
            @RequiresApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame()) {
                    AlaActiveWebView.this.bif();
                }
            }
        });
        addView(this.aGo, new FrameLayout.LayoutParams(-1, -1));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.aGo.resumeTimers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bif() {
        if (this.eQg == null) {
            this.eQg = new ImageView(getContext());
            this.eQg.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.eQg.setImageResource(a.f.icon_live_active_web_error);
            this.eQg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaActiveWebView.this.aGo != null) {
                        if (!TextUtils.isEmpty(AlaActiveWebView.this.aGo.getUrl())) {
                            AlaActiveWebView.this.aGo.loadUrl(AlaActiveWebView.this.aGo.getUrl());
                        } else if (!TextUtils.isEmpty(AlaActiveWebView.this.aGo.getOriginalUrl())) {
                            AlaActiveWebView.this.aGo.loadUrl(AlaActiveWebView.this.aGo.getOriginalUrl());
                        }
                    }
                }
            });
            addView(this.eQg, new FrameLayout.LayoutParams(-1, -1));
        }
        this.eQg.setVisibility(0);
    }

    public SchemeCallback getSchemeCallback() {
        return this.aGr;
    }
}
