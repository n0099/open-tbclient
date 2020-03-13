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
    private CommonWebView aGp;
    private List<String> aGq;
    private SchemeCallback aGs;
    private a eQr;
    private boolean eQs;
    private ImageView eQt;

    /* loaded from: classes3.dex */
    public interface a {
        void iO(boolean z);
    }

    public AlaActiveWebView(Context context) {
        super(context);
        this.aGs = new SchemeCallback() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.3
            @Override // com.baidu.live.tbadk.scheme.SchemeCallback
            public void doJsCallback(int i, String str, JSONObject jSONObject, String str2) {
                try {
                    String assembJavaScript = SchemeUtils.assembJavaScript(i, str, jSONObject, str2);
                    if (Build.VERSION.SDK_INT >= 19) {
                        AlaActiveWebView.this.aGp.evaluateJavascript(assembJavaScript, null);
                    } else {
                        AlaActiveWebView.this.aGp.loadUrl(assembJavaScript);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.eQr = aVar;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.aGq == null) {
            this.aGq = new ArrayList();
        }
        this.aGq.add(str);
        this.aGp.addJavascriptInterface(obj, str);
    }

    public void loadUrl(String str) {
        if (this.aGp != null) {
            this.aGp.loadUrl(str);
        }
    }

    public String getOriginalUrl() {
        return this.aGp != null ? this.aGp.getOriginalUrl() : "";
    }

    public boolean bif() {
        return this.eQs;
    }

    @RequiresApi(19)
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.aGp != null) {
            this.aGp.evaluateJavascript(str, valueCallback);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStart() {
        if (this.aGp != null) {
            this.aGp.onResume();
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.aGp.resumeTimers();
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStop() {
        if (this.aGp != null) {
            this.aGp.onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void release() {
        this.eQr = null;
        this.eQs = false;
        removeAllViews();
        if (this.aGp != null) {
            if (this.aGq != null) {
                for (String str : this.aGq) {
                    this.aGp.removeJavascriptInterface(str);
                }
                this.aGq.clear();
            }
            this.aGp.stopLoading();
            this.aGp.removeAllViews();
            this.aGp.loadUrl("about:blank");
            this.aGp.freeMemory();
            this.aGp.destroy();
        }
    }

    private void init() {
        this.eQs = false;
        setBackgroundColor(0);
        this.aGp = new CommonWebView(getContext());
        this.aGp.setVerticalScrollEnabled(false);
        this.aGp.setHorizontalScrollEnabled(false);
        this.aGp.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.1
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                if (AlaActiveWebView.this.eQt != null) {
                    AlaActiveWebView.this.eQt.setVisibility(8);
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
                            AlaActiveWebView.this.eQs = Boolean.valueOf(str2).booleanValue();
                            if (AlaActiveWebView.this.eQr != null) {
                                AlaActiveWebView.this.eQr.iO(Boolean.valueOf(str2).booleanValue());
                            }
                        }
                    });
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (Build.VERSION.SDK_INT < 23) {
                    AlaActiveWebView.this.big();
                }
            }

            @Override // android.webkit.WebViewClient
            @RequiresApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame()) {
                    AlaActiveWebView.this.big();
                }
            }
        });
        addView(this.aGp, new FrameLayout.LayoutParams(-1, -1));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.aGp.resumeTimers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void big() {
        if (this.eQt == null) {
            this.eQt = new ImageView(getContext());
            this.eQt.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.eQt.setImageResource(a.f.icon_live_active_web_error);
            this.eQt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaActiveWebView.this.aGp != null) {
                        if (!TextUtils.isEmpty(AlaActiveWebView.this.aGp.getUrl())) {
                            AlaActiveWebView.this.aGp.loadUrl(AlaActiveWebView.this.aGp.getUrl());
                        } else if (!TextUtils.isEmpty(AlaActiveWebView.this.aGp.getOriginalUrl())) {
                            AlaActiveWebView.this.aGp.loadUrl(AlaActiveWebView.this.aGp.getOriginalUrl());
                        }
                    }
                }
            });
            addView(this.eQt, new FrameLayout.LayoutParams(-1, -1));
        }
        this.eQt.setVisibility(0);
    }

    public SchemeCallback getSchemeCallback() {
        return this.aGs;
    }
}
