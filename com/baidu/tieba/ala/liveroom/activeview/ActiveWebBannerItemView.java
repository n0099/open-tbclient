package com.baidu.tieba.ala.liveroom.activeview;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.baidu.live.data.o;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import com.baidu.live.tbadk.scheme.SchemeUtils;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.util.WebviewHelper;
import com.baidu.live.view.web.CommonWebView;
import com.baidu.live.view.web.f;
import com.baidu.live.view.web.g;
import com.baidu.live.view.web.h;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.webkit.internal.ETAG;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ActiveWebBannerItemView extends FrameLayout implements c {
    private CommonWebView bNE;
    private List<String> bNF;
    private SchemeCallback bNH;
    private h bNR;
    private String eAe;
    private boolean gSj;
    private a gUI;
    private o gUM;

    public ActiveWebBannerItemView(Context context) {
        super(context);
        this.bNH = new SchemeCallback() { // from class: com.baidu.tieba.ala.liveroom.activeview.ActiveWebBannerItemView.4
            @Override // com.baidu.live.tbadk.scheme.SchemeCallback
            public void doJsCallback(int i, String str, JSONObject jSONObject, String str2) {
                try {
                    String assembJavaScript = SchemeUtils.assembJavaScript(i, str, jSONObject, str2);
                    if (Build.VERSION.SDK_INT >= 19) {
                        ActiveWebBannerItemView.this.bNE.evaluateJavascript(assembJavaScript, null);
                    } else {
                        ActiveWebBannerItemView.this.bNE.loadUrl(assembJavaScript);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.bNR = new h() { // from class: com.baidu.tieba.ala.liveroom.activeview.ActiveWebBannerItemView.5
            @Override // com.baidu.live.view.web.h
            public void iT(String str) {
                if (!TextUtils.isEmpty(str) && ActiveWebBannerItemView.this.gUI != null) {
                    if (ActiveWebBannerItemView.this.eq(str, "fullscreen")) {
                        ActiveWebBannerItemView.this.gUI.HI(str);
                    } else if (ActiveWebBannerItemView.this.eq(str, UbcStatConstant.KEY_CONTENT_ROOM)) {
                        ActiveWebBannerItemView.this.gUI.HH(str);
                    } else {
                        ActiveWebBannerItemView.this.gUI.HJ(str);
                    }
                }
            }
        };
        init();
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void setCallback(a aVar) {
        this.gUI = aVar;
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void setData(boolean z, w wVar, o oVar) {
        if (this.bNE != null && oVar != null) {
            this.gUM = oVar;
            String a2 = a(z, wVar, oVar.webUrl, oVar.jump_url, oVar.aIN);
            if (!a2.equals(this.bNE.getOriginalUrl())) {
                this.bNE.loadUrl(a2);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStart() {
        if (this.bNE != null) {
            this.bNE.onResume();
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.bNE.resumeTimers();
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStop() {
        if (this.bNE != null) {
            this.bNE.onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void release() {
        this.gUI = null;
        this.gSj = false;
        removeAllViews();
        if (this.bNE != null) {
            if (this.bNF != null) {
                for (String str : this.bNF) {
                    this.bNE.removeJavascriptInterface(str);
                }
                this.bNF.clear();
            }
            this.bNE.stopLoading();
            this.bNE.removeAllViews();
            this.bNE.loadUrl("about:blank");
            this.bNE.freeMemory();
            this.bNE.destroy();
        }
    }

    public void setActivityContext(Activity activity) {
        g gVar = new g();
        gVar.y(activity).a(new f() { // from class: com.baidu.tieba.ala.liveroom.activeview.ActiveWebBannerItemView.1
            @Override // com.baidu.live.view.web.f
            public void eX(int i) {
                if ((ActiveWebBannerItemView.this.gUI != null) & (ActiveWebBannerItemView.this.gUM != null)) {
                    ActiveWebBannerItemView.this.gUI.bK(ActiveWebBannerItemView.this.gUM.aIP.pos, ActiveWebBannerItemView.this.gUM.activityId);
                }
            }
        }).a(getSchemeCallback()).b(this.bNR);
        this.bNF = new ArrayList();
        com.baidu.live.view.web.a[] WX = gVar.WX();
        for (com.baidu.live.view.web.a aVar : WX) {
            this.bNF.add(aVar.getName());
            this.bNE.addJavascriptInterface(aVar, aVar.getName());
        }
    }

    public void loadUrl(String str) {
        if (this.bNE != null) {
            this.bNE.loadUrl(str);
        }
    }

    public boolean bVS() {
        return this.gSj;
    }

    @RequiresApi(19)
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.bNE != null) {
            this.bNE.evaluateJavascript(str, valueCallback);
        }
    }

    private void init() {
        this.gSj = false;
        setBackgroundColor(0);
        if (getBackground() != null) {
            getBackground().setAlpha(0);
        }
        this.bNE = new CommonWebView(getContext());
        this.bNE.setRequestDisallowInterceptTouchEvent(false);
        this.bNE.setVerticalScrollEnabled(false);
        this.bNE.setHorizontalScrollEnabled(false);
        this.bNE.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.ala.liveroom.activeview.ActiveWebBannerItemView.2
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (!"file:///android_asset/web/error.html".equals(str) && Build.VERSION.SDK_INT >= 19) {
                    ActiveWebBannerItemView.this.evaluateJavascript("javascript:window.getClientInfo != undefined", new ValueCallback<String>() { // from class: com.baidu.tieba.ala.liveroom.activeview.ActiveWebBannerItemView.2.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            ActiveWebBannerItemView.this.gSj = Boolean.valueOf(str2).booleanValue();
                            if (ActiveWebBannerItemView.this.gUI != null) {
                                ActiveWebBannerItemView.this.gUI.mE(ActiveWebBannerItemView.this.gSj);
                            }
                        }
                    });
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (Build.VERSION.SDK_INT < 23) {
                    ActiveWebBannerItemView.this.rK(str2);
                }
            }

            @Override // android.webkit.WebViewClient
            @RequiresApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                String uri;
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame() && webResourceRequest.getUrl() != null && (uri = webResourceRequest.getUrl().toString()) != null && !uri.equals("file:///android_asset/web/error.html")) {
                    ActiveWebBannerItemView.this.rK(uri);
                }
            }
        });
        addView(this.bNE, new FrameLayout.LayoutParams(-1, -1));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.bNE.resumeTimers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rK(String str) {
        this.eAe = str;
        this.bNE.loadUrl("file:///android_asset/web/error.html");
        this.bNE.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.ActiveWebBannerItemView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (ActiveWebBannerItemView.this.bNE != null && ActiveWebBannerItemView.this.bNE.getUrl() != null && ActiveWebBannerItemView.this.bNE.getUrl().equals("file:///android_asset/web/error.html") && !TextUtils.isEmpty(ActiveWebBannerItemView.this.eAe)) {
                    ActiveWebBannerItemView.this.bNE.loadUrl(ActiveWebBannerItemView.this.eAe);
                    return false;
                }
                return false;
            }
        });
    }

    public SchemeCallback getSchemeCallback() {
        return this.bNH;
    }

    private String a(boolean z, w wVar, String str, String str2, int i) {
        String str3;
        String str4 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (wVar == null) {
            return str;
        }
        String valueOf = wVar.aJr != null ? String.valueOf(wVar.aJr.userId) : null;
        String valueOf2 = wVar.aIV != null ? String.valueOf(wVar.aIV.userId) : null;
        if (wVar.mLiveInfo != null) {
            str3 = String.valueOf(wVar.mLiveInfo.room_id);
            str4 = String.valueOf(wVar.mLiveInfo.live_id);
        } else {
            str3 = null;
        }
        Map<String, Object> a2 = com.baidu.live.utils.b.a(z, valueOf, valueOf2, str3, str4);
        if (i == 2) {
            a2.put(UbcStatConstant.KEY_CONTENT_ROOM, 1);
        }
        a2.put(BigdayActivityConfig.JUMP_URL, aI(str2, i));
        return WebviewHelper.addQueryParams(str, a2);
    }

    private String aI(String str, int i) {
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
    public boolean eq(String str, String str2) {
        String queryParameter = Uri.parse(str).getQueryParameter(str2);
        if (TextUtils.isEmpty(queryParameter)) {
            int indexOf = str.indexOf(str2 + ETAG.EQUAL);
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
