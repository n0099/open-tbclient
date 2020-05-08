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
    private CommonWebView bcw;
    private List<String> bcx;
    private SchemeCallback bcz;
    private a fvo;
    private boolean fvp;
    private ImageView fvq;

    /* loaded from: classes3.dex */
    public interface a {
        void jR(boolean z);
    }

    public AlaActiveWebView(Context context) {
        super(context);
        this.bcz = new SchemeCallback() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.3
            @Override // com.baidu.live.tbadk.scheme.SchemeCallback
            public void doJsCallback(int i, String str, JSONObject jSONObject, String str2) {
                try {
                    String assembJavaScript = SchemeUtils.assembJavaScript(i, str, jSONObject, str2);
                    if (Build.VERSION.SDK_INT >= 19) {
                        AlaActiveWebView.this.bcw.evaluateJavascript(assembJavaScript, null);
                    } else {
                        AlaActiveWebView.this.bcw.loadUrl(assembJavaScript);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.fvo = aVar;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.bcx == null) {
            this.bcx = new ArrayList();
        }
        this.bcx.add(str);
        this.bcw.addJavascriptInterface(obj, str);
    }

    public void loadUrl(String str) {
        if (this.bcw != null) {
            this.bcw.loadUrl(str);
        }
    }

    public String getOriginalUrl() {
        return this.bcw != null ? this.bcw.getOriginalUrl() : "";
    }

    public boolean brA() {
        return this.fvp;
    }

    @RequiresApi(19)
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.bcw != null) {
            this.bcw.evaluateJavascript(str, valueCallback);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStart() {
        if (this.bcw != null) {
            this.bcw.onResume();
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.bcw.resumeTimers();
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStop() {
        if (this.bcw != null) {
            this.bcw.onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void release() {
        this.fvo = null;
        this.fvp = false;
        removeAllViews();
        if (this.bcw != null) {
            if (this.bcx != null) {
                for (String str : this.bcx) {
                    this.bcw.removeJavascriptInterface(str);
                }
                this.bcx.clear();
            }
            this.bcw.stopLoading();
            this.bcw.removeAllViews();
            this.bcw.loadUrl("about:blank");
            this.bcw.freeMemory();
            this.bcw.destroy();
        }
    }

    private void init() {
        this.fvp = false;
        setBackgroundColor(0);
        this.bcw = new CommonWebView(getContext());
        this.bcw.setVerticalScrollEnabled(false);
        this.bcw.setHorizontalScrollEnabled(false);
        this.bcw.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.1
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                if (AlaActiveWebView.this.fvq != null) {
                    AlaActiveWebView.this.fvq.setVisibility(8);
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
                            AlaActiveWebView.this.fvp = Boolean.valueOf(str2).booleanValue();
                            if (AlaActiveWebView.this.fvo != null) {
                                AlaActiveWebView.this.fvo.jR(Boolean.valueOf(str2).booleanValue());
                            }
                        }
                    });
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (Build.VERSION.SDK_INT < 23) {
                    AlaActiveWebView.this.brB();
                }
            }

            @Override // android.webkit.WebViewClient
            @RequiresApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame()) {
                    AlaActiveWebView.this.brB();
                }
            }
        });
        addView(this.bcw, new FrameLayout.LayoutParams(-1, -1));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.bcw.resumeTimers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brB() {
        if (this.fvq == null) {
            this.fvq = new ImageView(getContext());
            this.fvq.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.fvq.setImageResource(a.f.icon_live_active_web_error);
            this.fvq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaActiveWebView.this.bcw != null) {
                        if (!TextUtils.isEmpty(AlaActiveWebView.this.bcw.getUrl())) {
                            AlaActiveWebView.this.bcw.loadUrl(AlaActiveWebView.this.bcw.getUrl());
                        } else if (!TextUtils.isEmpty(AlaActiveWebView.this.bcw.getOriginalUrl())) {
                            AlaActiveWebView.this.bcw.loadUrl(AlaActiveWebView.this.bcw.getOriginalUrl());
                        }
                    }
                }
            });
            addView(this.fvq, new FrameLayout.LayoutParams(-1, -1));
        }
        this.fvq.setVisibility(0);
    }

    public SchemeCallback getSchemeCallback() {
        return this.bcz;
    }
}
