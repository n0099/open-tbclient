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
    private CommonWebView aGn;
    private List<String> aGo;
    private SchemeCallback aGq;
    private a eQd;
    private boolean eQe;
    private ImageView eQf;

    /* loaded from: classes3.dex */
    public interface a {
        void iO(boolean z);
    }

    public AlaActiveWebView(Context context) {
        super(context);
        this.aGq = new SchemeCallback() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.3
            @Override // com.baidu.live.tbadk.scheme.SchemeCallback
            public void doJsCallback(int i, String str, JSONObject jSONObject, String str2) {
                try {
                    String assembJavaScript = SchemeUtils.assembJavaScript(i, str, jSONObject, str2);
                    if (Build.VERSION.SDK_INT >= 19) {
                        AlaActiveWebView.this.aGn.evaluateJavascript(assembJavaScript, null);
                    } else {
                        AlaActiveWebView.this.aGn.loadUrl(assembJavaScript);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.eQd = aVar;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.aGo == null) {
            this.aGo = new ArrayList();
        }
        this.aGo.add(str);
        this.aGn.addJavascriptInterface(obj, str);
    }

    public void loadUrl(String str) {
        if (this.aGn != null) {
            this.aGn.loadUrl(str);
        }
    }

    public String getOriginalUrl() {
        return this.aGn != null ? this.aGn.getOriginalUrl() : "";
    }

    public boolean bic() {
        return this.eQe;
    }

    @RequiresApi(19)
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.aGn != null) {
            this.aGn.evaluateJavascript(str, valueCallback);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStart() {
        if (this.aGn != null) {
            this.aGn.onResume();
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.aGn.resumeTimers();
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStop() {
        if (this.aGn != null) {
            this.aGn.onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void release() {
        this.eQd = null;
        this.eQe = false;
        removeAllViews();
        if (this.aGn != null) {
            if (this.aGo != null) {
                for (String str : this.aGo) {
                    this.aGn.removeJavascriptInterface(str);
                }
                this.aGo.clear();
            }
            this.aGn.stopLoading();
            this.aGn.removeAllViews();
            this.aGn.loadUrl("about:blank");
            this.aGn.freeMemory();
            this.aGn.destroy();
        }
    }

    private void init() {
        this.eQe = false;
        setBackgroundColor(0);
        this.aGn = new CommonWebView(getContext());
        this.aGn.setVerticalScrollEnabled(false);
        this.aGn.setHorizontalScrollEnabled(false);
        this.aGn.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.1
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                if (AlaActiveWebView.this.eQf != null) {
                    AlaActiveWebView.this.eQf.setVisibility(8);
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
                            AlaActiveWebView.this.eQe = Boolean.valueOf(str2).booleanValue();
                            if (AlaActiveWebView.this.eQd != null) {
                                AlaActiveWebView.this.eQd.iO(Boolean.valueOf(str2).booleanValue());
                            }
                        }
                    });
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (Build.VERSION.SDK_INT < 23) {
                    AlaActiveWebView.this.bid();
                }
            }

            @Override // android.webkit.WebViewClient
            @RequiresApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame()) {
                    AlaActiveWebView.this.bid();
                }
            }
        });
        addView(this.aGn, new FrameLayout.LayoutParams(-1, -1));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.aGn.resumeTimers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bid() {
        if (this.eQf == null) {
            this.eQf = new ImageView(getContext());
            this.eQf.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.eQf.setImageResource(a.f.icon_live_active_web_error);
            this.eQf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaActiveWebView.this.aGn != null) {
                        if (!TextUtils.isEmpty(AlaActiveWebView.this.aGn.getUrl())) {
                            AlaActiveWebView.this.aGn.loadUrl(AlaActiveWebView.this.aGn.getUrl());
                        } else if (!TextUtils.isEmpty(AlaActiveWebView.this.aGn.getOriginalUrl())) {
                            AlaActiveWebView.this.aGn.loadUrl(AlaActiveWebView.this.aGn.getOriginalUrl());
                        }
                    }
                }
            });
            addView(this.eQf, new FrameLayout.LayoutParams(-1, -1));
        }
        this.eQf.setVisibility(0);
    }

    public SchemeCallback getSchemeCallback() {
        return this.aGq;
    }
}
