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
    private CommonWebView bcr;
    private List<String> bcs;
    private SchemeCallback bcu;
    private a fvj;
    private boolean fvk;
    private ImageView fvl;

    /* loaded from: classes3.dex */
    public interface a {
        void jR(boolean z);
    }

    public AlaActiveWebView(Context context) {
        super(context);
        this.bcu = new SchemeCallback() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.3
            @Override // com.baidu.live.tbadk.scheme.SchemeCallback
            public void doJsCallback(int i, String str, JSONObject jSONObject, String str2) {
                try {
                    String assembJavaScript = SchemeUtils.assembJavaScript(i, str, jSONObject, str2);
                    if (Build.VERSION.SDK_INT >= 19) {
                        AlaActiveWebView.this.bcr.evaluateJavascript(assembJavaScript, null);
                    } else {
                        AlaActiveWebView.this.bcr.loadUrl(assembJavaScript);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.fvj = aVar;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.bcs == null) {
            this.bcs = new ArrayList();
        }
        this.bcs.add(str);
        this.bcr.addJavascriptInterface(obj, str);
    }

    public void loadUrl(String str) {
        if (this.bcr != null) {
            this.bcr.loadUrl(str);
        }
    }

    public String getOriginalUrl() {
        return this.bcr != null ? this.bcr.getOriginalUrl() : "";
    }

    public boolean brC() {
        return this.fvk;
    }

    @RequiresApi(19)
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.bcr != null) {
            this.bcr.evaluateJavascript(str, valueCallback);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStart() {
        if (this.bcr != null) {
            this.bcr.onResume();
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.bcr.resumeTimers();
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStop() {
        if (this.bcr != null) {
            this.bcr.onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void release() {
        this.fvj = null;
        this.fvk = false;
        removeAllViews();
        if (this.bcr != null) {
            if (this.bcs != null) {
                for (String str : this.bcs) {
                    this.bcr.removeJavascriptInterface(str);
                }
                this.bcs.clear();
            }
            this.bcr.stopLoading();
            this.bcr.removeAllViews();
            this.bcr.loadUrl("about:blank");
            this.bcr.freeMemory();
            this.bcr.destroy();
        }
    }

    private void init() {
        this.fvk = false;
        setBackgroundColor(0);
        this.bcr = new CommonWebView(getContext());
        this.bcr.setVerticalScrollEnabled(false);
        this.bcr.setHorizontalScrollEnabled(false);
        this.bcr.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.1
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                if (AlaActiveWebView.this.fvl != null) {
                    AlaActiveWebView.this.fvl.setVisibility(8);
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
                            AlaActiveWebView.this.fvk = Boolean.valueOf(str2).booleanValue();
                            if (AlaActiveWebView.this.fvj != null) {
                                AlaActiveWebView.this.fvj.jR(Boolean.valueOf(str2).booleanValue());
                            }
                        }
                    });
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (Build.VERSION.SDK_INT < 23) {
                    AlaActiveWebView.this.brD();
                }
            }

            @Override // android.webkit.WebViewClient
            @RequiresApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame()) {
                    AlaActiveWebView.this.brD();
                }
            }
        });
        addView(this.bcr, new FrameLayout.LayoutParams(-1, -1));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.bcr.resumeTimers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brD() {
        if (this.fvl == null) {
            this.fvl = new ImageView(getContext());
            this.fvl.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.fvl.setImageResource(a.f.icon_live_active_web_error);
            this.fvl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaActiveWebView.this.bcr != null) {
                        if (!TextUtils.isEmpty(AlaActiveWebView.this.bcr.getUrl())) {
                            AlaActiveWebView.this.bcr.loadUrl(AlaActiveWebView.this.bcr.getUrl());
                        } else if (!TextUtils.isEmpty(AlaActiveWebView.this.bcr.getOriginalUrl())) {
                            AlaActiveWebView.this.bcr.loadUrl(AlaActiveWebView.this.bcr.getOriginalUrl());
                        }
                    }
                }
            });
            addView(this.fvl, new FrameLayout.LayoutParams(-1, -1));
        }
        this.fvl.setVisibility(0);
    }

    public SchemeCallback getSchemeCallback() {
        return this.bcu;
    }
}
