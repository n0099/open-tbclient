package com.baidu.tieba.ala.liveroom.activeview;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import com.baidu.live.data.p;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import com.baidu.live.tbadk.scheme.SchemeUtils;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.util.WebviewHelper;
import com.baidu.live.view.web.CommonWebView;
import com.baidu.live.view.web.f;
import com.baidu.live.view.web.g;
import com.baidu.live.view.web.h;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class ActiveWebBannerItemView extends FrameLayout implements c {
    private CommonWebView bWG;
    private List<String> bWH;
    private SchemeCallback bWJ;
    private h bWS;
    private String ePk;
    private boolean hmR;
    private a hpr;
    private p hpv;

    public ActiveWebBannerItemView(Context context) {
        super(context);
        this.bWJ = new SchemeCallback() { // from class: com.baidu.tieba.ala.liveroom.activeview.ActiveWebBannerItemView.4
            @Override // com.baidu.live.tbadk.scheme.SchemeCallback
            public void doJsCallback(int i, String str, JSONObject jSONObject, String str2) {
                try {
                    String assembJavaScript = SchemeUtils.assembJavaScript(i, str, jSONObject, str2);
                    if (Build.VERSION.SDK_INT >= 19) {
                        ActiveWebBannerItemView.this.bWG.evaluateJavascript(assembJavaScript, null);
                    } else {
                        ActiveWebBannerItemView.this.bWG.loadUrl(assembJavaScript);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.bWS = new h() { // from class: com.baidu.tieba.ala.liveroom.activeview.ActiveWebBannerItemView.5
            @Override // com.baidu.live.view.web.h
            public void jk(String str) {
                if (!TextUtils.isEmpty(str) && ActiveWebBannerItemView.this.hpr != null) {
                    if (ActiveWebBannerItemView.this.aU(str, "fullscreen")) {
                        ActiveWebBannerItemView.this.hpr.HX(str);
                    } else if (ActiveWebBannerItemView.this.aU(str, UbcStatConstant.KEY_CONTENT_ROOM)) {
                        ActiveWebBannerItemView.this.hpr.HW(str);
                    } else {
                        ActiveWebBannerItemView.this.hpr.HY(str);
                    }
                }
            }
        };
        init();
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void setCallback(a aVar) {
        this.hpr = aVar;
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void setData(boolean z, x xVar, p pVar) {
        if (this.bWG != null && pVar != null) {
            this.hpv = pVar;
            String a2 = a(z, xVar, pVar.webUrl, pVar.jump_url, pVar.aKl);
            if (!a2.equals(this.bWG.getOriginalUrl())) {
                this.bWG.loadUrl(a2);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStart() {
        if (this.bWG != null) {
            this.bWG.onResume();
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.bWG.resumeTimers();
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStop() {
        if (this.bWG != null) {
            this.bWG.onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void release() {
        this.hpr = null;
        this.hmR = false;
        removeAllViews();
        if (this.bWG != null) {
            if (this.bWH != null) {
                for (String str : this.bWH) {
                    this.bWG.removeJavascriptInterface(str);
                }
                this.bWH.clear();
            }
            this.bWG.stopLoading();
            this.bWG.removeAllViews();
            this.bWG.loadUrl("about:blank");
            this.bWG.freeMemory();
            this.bWG.destroy();
        }
    }

    public void setActivityContext(Activity activity) {
        g gVar = new g();
        gVar.w(activity).a(new f() { // from class: com.baidu.tieba.ala.liveroom.activeview.ActiveWebBannerItemView.1
            @Override // com.baidu.live.view.web.f
            public void fr(int i) {
                if ((ActiveWebBannerItemView.this.hpr != null) & (ActiveWebBannerItemView.this.hpv != null)) {
                    ActiveWebBannerItemView.this.hpr.bN(ActiveWebBannerItemView.this.hpv.aKn.pos, ActiveWebBannerItemView.this.hpv.activityId);
                }
            }
        }).a(getSchemeCallback()).b(this.bWS);
        this.bWH = new ArrayList();
        com.baidu.live.view.web.a[] aae = gVar.aae();
        for (com.baidu.live.view.web.a aVar : aae) {
            this.bWH.add(aVar.getName());
            this.bWG.addJavascriptInterface(aVar, aVar.getName());
        }
    }

    public void loadUrl(String str) {
        if (this.bWG != null) {
            this.bWG.loadUrl(str);
        }
    }

    public boolean cbD() {
        return this.hmR;
    }

    @RequiresApi(19)
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.bWG != null) {
            this.bWG.evaluateJavascript(str, valueCallback);
        }
    }

    private void init() {
        this.hmR = false;
        setBackgroundColor(0);
        if (getBackground() != null) {
            getBackground().setAlpha(0);
        }
        this.bWG = new CommonWebView(getContext());
        this.bWG.setRequestDisallowInterceptTouchEvent(false);
        this.bWG.setVerticalScrollEnabled(false);
        this.bWG.setHorizontalScrollEnabled(false);
        this.bWG.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.ala.liveroom.activeview.ActiveWebBannerItemView.2
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (!"file:///android_asset/web/error.html".equals(str) && Build.VERSION.SDK_INT >= 19) {
                    ActiveWebBannerItemView.this.evaluateJavascript("javascript:window.getClientInfo != undefined", new ValueCallback<String>() { // from class: com.baidu.tieba.ala.liveroom.activeview.ActiveWebBannerItemView.2.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            ActiveWebBannerItemView.this.hmR = Boolean.valueOf(str2).booleanValue();
                            if (ActiveWebBannerItemView.this.hpr != null) {
                                ActiveWebBannerItemView.this.hpr.nz(ActiveWebBannerItemView.this.hmR);
                            }
                        }
                    });
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (Build.VERSION.SDK_INT < 23) {
                    ActiveWebBannerItemView.this.se(str2);
                }
            }

            @Override // android.webkit.WebViewClient
            @RequiresApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                String uri;
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame() && webResourceRequest.getUrl() != null && (uri = webResourceRequest.getUrl().toString()) != null && !uri.equals("file:///android_asset/web/error.html")) {
                    ActiveWebBannerItemView.this.se(uri);
                }
            }
        });
        addView(this.bWG, new FrameLayout.LayoutParams(-1, -1));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.bWG.resumeTimers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void se(String str) {
        this.ePk = str;
        this.bWG.loadUrl("file:///android_asset/web/error.html");
        this.bWG.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.ActiveWebBannerItemView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (ActiveWebBannerItemView.this.bWG != null && ActiveWebBannerItemView.this.bWG.getUrl() != null && ActiveWebBannerItemView.this.bWG.getUrl().equals("file:///android_asset/web/error.html") && !TextUtils.isEmpty(ActiveWebBannerItemView.this.ePk)) {
                    ActiveWebBannerItemView.this.bWG.loadUrl(ActiveWebBannerItemView.this.ePk);
                    return false;
                }
                return false;
            }
        });
    }

    public SchemeCallback getSchemeCallback() {
        return this.bWJ;
    }

    private String a(boolean z, x xVar, String str, String str2, int i) {
        String str3;
        String str4;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (xVar == null) {
            return str;
        }
        String encryptionUserId = xVar.aKQ != null ? ExtraParamsManager.getEncryptionUserId(String.valueOf(xVar.aKQ.userId)) : null;
        String encryptionUserId2 = xVar.aKu != null ? ExtraParamsManager.getEncryptionUserId(String.valueOf(xVar.aKu.userId)) : null;
        if (xVar.mLiveInfo != null) {
            str4 = String.valueOf(xVar.mLiveInfo.room_id);
            str3 = String.valueOf(xVar.mLiveInfo.live_id);
        } else {
            str3 = null;
            str4 = null;
        }
        Map<String, Object> a2 = com.baidu.live.utils.b.a(z, encryptionUserId, encryptionUserId2, str4, str3);
        if (i == 2) {
            a2.put(UbcStatConstant.KEY_CONTENT_ROOM, 1);
        }
        a2.put(BigdayActivityConfig.JUMP_URL, aK(str2, i));
        return WebviewHelper.addQueryParams(str, a2);
    }

    private String aK(String str, int i) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (i == 2) {
            HashMap hashMap = new HashMap();
            hashMap.put(UbcStatConstant.KEY_CONTENT_ROOM, 1);
            str2 = WebviewHelper.addQueryParams(str, hashMap);
        } else {
            str2 = str;
        }
        try {
            return URLEncoder.encode(str2, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aU(String str, String str2) {
        String queryParameter = Uri.parse(str).getQueryParameter(str2);
        if (TextUtils.isEmpty(queryParameter)) {
            int indexOf = str.indexOf(str2 + "=");
            int length = str2.length() + 1;
            if (indexOf >= 0 && indexOf + length + 1 <= str.length()) {
                queryParameter = str.substring(indexOf + length, indexOf + length + 1);
            }
        }
        if (TextUtils.isEmpty(queryParameter)) {
            return false;
        }
        try {
            return Integer.parseInt(queryParameter) == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
