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
    private CommonWebView ats;
    private List<String> att;
    private SchemeCallback atv;
    private a dVm;
    private boolean dVn;
    private ImageView dVo;

    /* loaded from: classes6.dex */
    public interface a {
        void hl(boolean z);
    }

    public AlaActiveWebView(Context context) {
        super(context);
        this.atv = new SchemeCallback() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.3
            @Override // com.baidu.live.tbadk.scheme.SchemeCallback
            public void doJsCallback(int i, String str, JSONObject jSONObject, String str2) {
                try {
                    String assembJavaScript = SchemeUtils.assembJavaScript(i, str, jSONObject, str2);
                    if (Build.VERSION.SDK_INT >= 19) {
                        AlaActiveWebView.this.ats.evaluateJavascript(assembJavaScript, null);
                    } else {
                        AlaActiveWebView.this.ats.loadUrl(assembJavaScript);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.dVm = aVar;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.att == null) {
            this.att = new ArrayList();
        }
        this.att.add(str);
        this.ats.addJavascriptInterface(obj, str);
    }

    public void loadUrl(String str) {
        if (this.ats != null) {
            this.ats.loadUrl(str);
        }
    }

    public String getOriginalUrl() {
        return this.ats != null ? this.ats.getOriginalUrl() : "";
    }

    public boolean aNX() {
        return this.dVn;
    }

    @RequiresApi(19)
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.ats != null) {
            this.ats.evaluateJavascript(str, valueCallback);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStart() {
        if (this.ats != null) {
            this.ats.onResume();
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.ats.resumeTimers();
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStop() {
        if (this.ats != null) {
            this.ats.onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void release() {
        this.dVm = null;
        this.dVn = false;
        removeAllViews();
        if (this.ats != null) {
            if (this.att != null) {
                for (String str : this.att) {
                    this.ats.removeJavascriptInterface(str);
                }
                this.att.clear();
            }
            this.ats.stopLoading();
            this.ats.removeAllViews();
            this.ats.loadUrl("about:blank");
            this.ats.freeMemory();
            this.ats.destroy();
        }
    }

    private void init() {
        this.dVn = false;
        setBackgroundColor(0);
        this.ats = new CommonWebView(getContext());
        this.ats.setVerticalScrollEnabled(false);
        this.ats.setHorizontalScrollEnabled(false);
        this.ats.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.1
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                if (AlaActiveWebView.this.dVo != null) {
                    AlaActiveWebView.this.dVo.setVisibility(8);
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
                            AlaActiveWebView.this.dVn = Boolean.valueOf(str2).booleanValue();
                            if (AlaActiveWebView.this.dVm != null) {
                                AlaActiveWebView.this.dVm.hl(Boolean.valueOf(str2).booleanValue());
                            }
                        }
                    });
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (Build.VERSION.SDK_INT < 23) {
                    AlaActiveWebView.this.aNY();
                }
            }

            @Override // android.webkit.WebViewClient
            @RequiresApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame()) {
                    AlaActiveWebView.this.aNY();
                }
            }
        });
        addView(this.ats, new FrameLayout.LayoutParams(-1, -1));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.ats.resumeTimers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNY() {
        if (this.dVo == null) {
            this.dVo = new ImageView(getContext());
            this.dVo.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.dVo.setImageResource(a.f.icon_live_active_web_error);
            this.dVo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaActiveWebView.this.ats != null) {
                        if (!TextUtils.isEmpty(AlaActiveWebView.this.ats.getUrl())) {
                            AlaActiveWebView.this.ats.loadUrl(AlaActiveWebView.this.ats.getUrl());
                        } else if (!TextUtils.isEmpty(AlaActiveWebView.this.ats.getOriginalUrl())) {
                            AlaActiveWebView.this.ats.loadUrl(AlaActiveWebView.this.ats.getOriginalUrl());
                        }
                    }
                }
            });
            addView(this.dVo, new FrameLayout.LayoutParams(-1, -1));
        }
        this.dVo.setVisibility(0);
    }

    public SchemeCallback getSchemeCallback() {
        return this.atv;
    }
}
