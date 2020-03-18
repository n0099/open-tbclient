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
    private CommonWebView aGD;
    private List<String> aGE;
    private SchemeCallback aGG;
    private a eQP;
    private boolean eQQ;
    private ImageView eQR;

    /* loaded from: classes3.dex */
    public interface a {
        void iQ(boolean z);
    }

    public AlaActiveWebView(Context context) {
        super(context);
        this.aGG = new SchemeCallback() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.3
            @Override // com.baidu.live.tbadk.scheme.SchemeCallback
            public void doJsCallback(int i, String str, JSONObject jSONObject, String str2) {
                try {
                    String assembJavaScript = SchemeUtils.assembJavaScript(i, str, jSONObject, str2);
                    if (Build.VERSION.SDK_INT >= 19) {
                        AlaActiveWebView.this.aGD.evaluateJavascript(assembJavaScript, null);
                    } else {
                        AlaActiveWebView.this.aGD.loadUrl(assembJavaScript);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.eQP = aVar;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.aGE == null) {
            this.aGE = new ArrayList();
        }
        this.aGE.add(str);
        this.aGD.addJavascriptInterface(obj, str);
    }

    public void loadUrl(String str) {
        if (this.aGD != null) {
            this.aGD.loadUrl(str);
        }
    }

    public String getOriginalUrl() {
        return this.aGD != null ? this.aGD.getOriginalUrl() : "";
    }

    public boolean bik() {
        return this.eQQ;
    }

    @RequiresApi(19)
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.aGD != null) {
            this.aGD.evaluateJavascript(str, valueCallback);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStart() {
        if (this.aGD != null) {
            this.aGD.onResume();
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.aGD.resumeTimers();
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStop() {
        if (this.aGD != null) {
            this.aGD.onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void release() {
        this.eQP = null;
        this.eQQ = false;
        removeAllViews();
        if (this.aGD != null) {
            if (this.aGE != null) {
                for (String str : this.aGE) {
                    this.aGD.removeJavascriptInterface(str);
                }
                this.aGE.clear();
            }
            this.aGD.stopLoading();
            this.aGD.removeAllViews();
            this.aGD.loadUrl("about:blank");
            this.aGD.freeMemory();
            this.aGD.destroy();
        }
    }

    private void init() {
        this.eQQ = false;
        setBackgroundColor(0);
        this.aGD = new CommonWebView(getContext());
        this.aGD.setVerticalScrollEnabled(false);
        this.aGD.setHorizontalScrollEnabled(false);
        this.aGD.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.1
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                if (AlaActiveWebView.this.eQR != null) {
                    AlaActiveWebView.this.eQR.setVisibility(8);
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
                            AlaActiveWebView.this.eQQ = Boolean.valueOf(str2).booleanValue();
                            if (AlaActiveWebView.this.eQP != null) {
                                AlaActiveWebView.this.eQP.iQ(Boolean.valueOf(str2).booleanValue());
                            }
                        }
                    });
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (Build.VERSION.SDK_INT < 23) {
                    AlaActiveWebView.this.bil();
                }
            }

            @Override // android.webkit.WebViewClient
            @RequiresApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame()) {
                    AlaActiveWebView.this.bil();
                }
            }
        });
        addView(this.aGD, new FrameLayout.LayoutParams(-1, -1));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.aGD.resumeTimers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bil() {
        if (this.eQR == null) {
            this.eQR = new ImageView(getContext());
            this.eQR.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.eQR.setImageResource(a.f.icon_live_active_web_error);
            this.eQR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaActiveWebView.this.aGD != null) {
                        if (!TextUtils.isEmpty(AlaActiveWebView.this.aGD.getUrl())) {
                            AlaActiveWebView.this.aGD.loadUrl(AlaActiveWebView.this.aGD.getUrl());
                        } else if (!TextUtils.isEmpty(AlaActiveWebView.this.aGD.getOriginalUrl())) {
                            AlaActiveWebView.this.aGD.loadUrl(AlaActiveWebView.this.aGD.getOriginalUrl());
                        }
                    }
                }
            });
            addView(this.eQR, new FrameLayout.LayoutParams(-1, -1));
        }
        this.eQR.setVisibility(0);
    }

    public SchemeCallback getSchemeCallback() {
        return this.aGG;
    }
}
