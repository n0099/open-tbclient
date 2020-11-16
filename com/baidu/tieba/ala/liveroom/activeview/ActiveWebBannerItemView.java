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
    private CommonWebView bLU;
    private List<String> bLV;
    private SchemeCallback bLX;
    private h bMh;
    private String eyv;
    private boolean gRQ;
    private a gUp;
    private o gUt;

    public ActiveWebBannerItemView(Context context) {
        super(context);
        this.bLX = new SchemeCallback() { // from class: com.baidu.tieba.ala.liveroom.activeview.ActiveWebBannerItemView.4
            @Override // com.baidu.live.tbadk.scheme.SchemeCallback
            public void doJsCallback(int i, String str, JSONObject jSONObject, String str2) {
                try {
                    String assembJavaScript = SchemeUtils.assembJavaScript(i, str, jSONObject, str2);
                    if (Build.VERSION.SDK_INT >= 19) {
                        ActiveWebBannerItemView.this.bLU.evaluateJavascript(assembJavaScript, null);
                    } else {
                        ActiveWebBannerItemView.this.bLU.loadUrl(assembJavaScript);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.bMh = new h() { // from class: com.baidu.tieba.ala.liveroom.activeview.ActiveWebBannerItemView.5
            @Override // com.baidu.live.view.web.h
            public void iN(String str) {
                if (!TextUtils.isEmpty(str) && ActiveWebBannerItemView.this.gUp != null) {
                    if (ActiveWebBannerItemView.this.eq(str, "fullscreen")) {
                        ActiveWebBannerItemView.this.gUp.Hj(str);
                    } else if (ActiveWebBannerItemView.this.eq(str, UbcStatConstant.KEY_CONTENT_ROOM)) {
                        ActiveWebBannerItemView.this.gUp.Hi(str);
                    } else {
                        ActiveWebBannerItemView.this.gUp.Hk(str);
                    }
                }
            }
        };
        init();
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void setCallback(a aVar) {
        this.gUp = aVar;
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void setData(boolean z, w wVar, o oVar) {
        if (this.bLU != null && oVar != null) {
            this.gUt = oVar;
            String a2 = a(z, wVar, oVar.webUrl, oVar.jump_url, oVar.aHc);
            if (!a2.equals(this.bLU.getOriginalUrl())) {
                this.bLU.loadUrl(a2);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStart() {
        if (this.bLU != null) {
            this.bLU.onResume();
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.bLU.resumeTimers();
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStop() {
        if (this.bLU != null) {
            this.bLU.onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void release() {
        this.gUp = null;
        this.gRQ = false;
        removeAllViews();
        if (this.bLU != null) {
            if (this.bLV != null) {
                for (String str : this.bLV) {
                    this.bLU.removeJavascriptInterface(str);
                }
                this.bLV.clear();
            }
            this.bLU.stopLoading();
            this.bLU.removeAllViews();
            this.bLU.loadUrl("about:blank");
            this.bLU.freeMemory();
            this.bLU.destroy();
        }
    }

    public void setActivityContext(Activity activity) {
        g gVar = new g();
        gVar.x(activity).a(new f() { // from class: com.baidu.tieba.ala.liveroom.activeview.ActiveWebBannerItemView.1
            @Override // com.baidu.live.view.web.f
            public void eT(int i) {
                if ((ActiveWebBannerItemView.this.gUp != null) & (ActiveWebBannerItemView.this.gUt != null)) {
                    ActiveWebBannerItemView.this.gUp.bK(ActiveWebBannerItemView.this.gUt.aHe.pos, ActiveWebBannerItemView.this.gUt.activityId);
                }
            }
        }).a(getSchemeCallback()).b(this.bMh);
        this.bLV = new ArrayList();
        com.baidu.live.view.web.a[] Wo = gVar.Wo();
        for (com.baidu.live.view.web.a aVar : Wo) {
            this.bLV.add(aVar.getName());
            this.bLU.addJavascriptInterface(aVar, aVar.getName());
        }
    }

    public void loadUrl(String str) {
        if (this.bLU != null) {
            this.bLU.loadUrl(str);
        }
    }

    public boolean bVl() {
        return this.gRQ;
    }

    @RequiresApi(19)
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.bLU != null) {
            this.bLU.evaluateJavascript(str, valueCallback);
        }
    }

    private void init() {
        this.gRQ = false;
        setBackgroundColor(0);
        if (getBackground() != null) {
            getBackground().setAlpha(0);
        }
        this.bLU = new CommonWebView(getContext());
        this.bLU.setRequestDisallowInterceptTouchEvent(false);
        this.bLU.setVerticalScrollEnabled(false);
        this.bLU.setHorizontalScrollEnabled(false);
        this.bLU.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.ala.liveroom.activeview.ActiveWebBannerItemView.2
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (!"file:///android_asset/web/error.html".equals(str) && Build.VERSION.SDK_INT >= 19) {
                    ActiveWebBannerItemView.this.evaluateJavascript("javascript:window.getClientInfo != undefined", new ValueCallback<String>() { // from class: com.baidu.tieba.ala.liveroom.activeview.ActiveWebBannerItemView.2.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            ActiveWebBannerItemView.this.gRQ = Boolean.valueOf(str2).booleanValue();
                            if (ActiveWebBannerItemView.this.gUp != null) {
                                ActiveWebBannerItemView.this.gUp.mF(ActiveWebBannerItemView.this.gRQ);
                            }
                        }
                    });
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (Build.VERSION.SDK_INT < 23) {
                    ActiveWebBannerItemView.this.rE(str2);
                }
            }

            @Override // android.webkit.WebViewClient
            @RequiresApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                String uri;
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame() && webResourceRequest.getUrl() != null && (uri = webResourceRequest.getUrl().toString()) != null && !uri.equals("file:///android_asset/web/error.html")) {
                    ActiveWebBannerItemView.this.rE(uri);
                }
            }
        });
        addView(this.bLU, new FrameLayout.LayoutParams(-1, -1));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.bLU.resumeTimers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rE(String str) {
        this.eyv = str;
        this.bLU.loadUrl("file:///android_asset/web/error.html");
        this.bLU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.ActiveWebBannerItemView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (ActiveWebBannerItemView.this.bLU != null && ActiveWebBannerItemView.this.bLU.getUrl() != null && ActiveWebBannerItemView.this.bLU.getUrl().equals("file:///android_asset/web/error.html") && !TextUtils.isEmpty(ActiveWebBannerItemView.this.eyv)) {
                    ActiveWebBannerItemView.this.bLU.loadUrl(ActiveWebBannerItemView.this.eyv);
                    return false;
                }
                return false;
            }
        });
    }

    public SchemeCallback getSchemeCallback() {
        return this.bLX;
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
        String valueOf = wVar.aHG != null ? String.valueOf(wVar.aHG.userId) : null;
        String valueOf2 = wVar.aHk != null ? String.valueOf(wVar.aHk.userId) : null;
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
        a2.put(BigdayActivityConfig.JUMP_URL, aH(str2, i));
        return WebviewHelper.addQueryParams(str, a2);
    }

    private String aH(String str, int i) {
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
