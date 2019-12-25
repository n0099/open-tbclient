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
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import com.baidu.live.tbadk.scheme.SchemeUtils;
import com.baidu.live.view.web.CommonWebView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaActiveWebView extends FrameLayout implements c {
    private CommonWebView aBo;
    private List<String> aBp;
    private SchemeCallback aBr;
    private a eKN;
    private boolean eKO;
    private ImageView eKP;

    /* loaded from: classes2.dex */
    public interface a {
        void iv(boolean z);
    }

    public AlaActiveWebView(Context context) {
        super(context);
        this.aBr = new SchemeCallback() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.3
            @Override // com.baidu.live.tbadk.scheme.SchemeCallback
            public void doJsCallback(int i, String str, JSONObject jSONObject, String str2) {
                try {
                    String assembJavaScript = SchemeUtils.assembJavaScript(i, str, jSONObject, str2);
                    if (Build.VERSION.SDK_INT >= 19) {
                        AlaActiveWebView.this.aBo.evaluateJavascript(assembJavaScript, null);
                    } else {
                        AlaActiveWebView.this.aBo.loadUrl(assembJavaScript);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.eKN = aVar;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.aBp == null) {
            this.aBp = new ArrayList();
        }
        this.aBp.add(str);
        this.aBo.addJavascriptInterface(obj, str);
    }

    public void loadUrl(String str) {
        if (this.aBo != null) {
            this.aBo.loadUrl(str);
        }
    }

    public String getOriginalUrl() {
        return this.aBo != null ? this.aBo.getOriginalUrl() : "";
    }

    public boolean bft() {
        return this.eKO;
    }

    @RequiresApi(19)
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.aBo != null) {
            this.aBo.evaluateJavascript(str, valueCallback);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStart() {
        if (this.aBo != null) {
            this.aBo.onResume();
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.aBo.resumeTimers();
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStop() {
        if (this.aBo != null) {
            this.aBo.onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void release() {
        this.eKN = null;
        this.eKO = false;
        removeAllViews();
        if (this.aBo != null) {
            if (this.aBp != null) {
                for (String str : this.aBp) {
                    this.aBo.removeJavascriptInterface(str);
                }
                this.aBp.clear();
            }
            this.aBo.stopLoading();
            this.aBo.removeAllViews();
            this.aBo.loadUrl("about:blank");
            this.aBo.freeMemory();
            this.aBo.destroy();
        }
    }

    private void init() {
        this.eKO = false;
        setBackgroundColor(0);
        this.aBo = new CommonWebView(getContext());
        this.aBo.setVerticalScrollEnabled(false);
        this.aBo.setHorizontalScrollEnabled(false);
        this.aBo.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.1
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                if (AlaActiveWebView.this.eKP != null) {
                    AlaActiveWebView.this.eKP.setVisibility(8);
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
                            AlaActiveWebView.this.eKO = Boolean.valueOf(str2).booleanValue();
                            if (AlaActiveWebView.this.eKN != null) {
                                AlaActiveWebView.this.eKN.iv(Boolean.valueOf(str2).booleanValue());
                            }
                        }
                    });
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (Build.VERSION.SDK_INT < 23) {
                    AlaActiveWebView.this.bfu();
                }
            }

            @Override // android.webkit.WebViewClient
            @RequiresApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame()) {
                    AlaActiveWebView.this.bfu();
                }
            }
        });
        addView(this.aBo, new FrameLayout.LayoutParams(-1, -1));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.aBo.resumeTimers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfu() {
        if (this.eKP == null) {
            this.eKP = new ImageView(getContext());
            this.eKP.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.eKP.setImageResource(a.f.icon_live_active_web_error);
            this.eKP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaActiveWebView.this.aBo != null) {
                        if (!TextUtils.isEmpty(AlaActiveWebView.this.aBo.getUrl())) {
                            AlaActiveWebView.this.aBo.loadUrl(AlaActiveWebView.this.aBo.getUrl());
                        } else if (!TextUtils.isEmpty(AlaActiveWebView.this.aBo.getOriginalUrl())) {
                            AlaActiveWebView.this.aBo.loadUrl(AlaActiveWebView.this.aBo.getOriginalUrl());
                        }
                    }
                }
            });
            addView(this.eKP, new FrameLayout.LayoutParams(-1, -1));
        }
        this.eKP.setVisibility(0);
    }

    public SchemeCallback getSchemeCallback() {
        return this.aBr;
    }
}
