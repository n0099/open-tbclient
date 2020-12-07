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
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ActiveWebBannerItemView extends FrameLayout implements c {
    private CommonWebView bQZ;
    private List<String> bRa;
    private SchemeCallback bRc;
    private h bRm;
    private String eFu;
    private boolean hbd;
    private a hdC;
    private o hdG;

    public ActiveWebBannerItemView(Context context) {
        super(context);
        this.bRc = new SchemeCallback() { // from class: com.baidu.tieba.ala.liveroom.activeview.ActiveWebBannerItemView.4
            @Override // com.baidu.live.tbadk.scheme.SchemeCallback
            public void doJsCallback(int i, String str, JSONObject jSONObject, String str2) {
                try {
                    String assembJavaScript = SchemeUtils.assembJavaScript(i, str, jSONObject, str2);
                    if (Build.VERSION.SDK_INT >= 19) {
                        ActiveWebBannerItemView.this.bQZ.evaluateJavascript(assembJavaScript, null);
                    } else {
                        ActiveWebBannerItemView.this.bQZ.loadUrl(assembJavaScript);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.bRm = new h() { // from class: com.baidu.tieba.ala.liveroom.activeview.ActiveWebBannerItemView.5
            @Override // com.baidu.live.view.web.h
            public void jr(String str) {
                if (!TextUtils.isEmpty(str) && ActiveWebBannerItemView.this.hdC != null) {
                    if (ActiveWebBannerItemView.this.aZ(str, "fullscreen")) {
                        ActiveWebBannerItemView.this.hdC.HX(str);
                    } else if (ActiveWebBannerItemView.this.aZ(str, UbcStatConstant.KEY_CONTENT_ROOM)) {
                        ActiveWebBannerItemView.this.hdC.HW(str);
                    } else {
                        ActiveWebBannerItemView.this.hdC.HY(str);
                    }
                }
            }
        };
        init();
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void setCallback(a aVar) {
        this.hdC = aVar;
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void setData(boolean z, w wVar, o oVar) {
        if (this.bQZ != null && oVar != null) {
            this.hdG = oVar;
            String a2 = a(z, wVar, oVar.webUrl, oVar.jump_url, oVar.aJM);
            if (!a2.equals(this.bQZ.getOriginalUrl())) {
                this.bQZ.loadUrl(a2);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStart() {
        if (this.bQZ != null) {
            this.bQZ.onResume();
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.bQZ.resumeTimers();
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStop() {
        if (this.bQZ != null) {
            this.bQZ.onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void release() {
        this.hdC = null;
        this.hbd = false;
        removeAllViews();
        if (this.bQZ != null) {
            if (this.bRa != null) {
                for (String str : this.bRa) {
                    this.bQZ.removeJavascriptInterface(str);
                }
                this.bRa.clear();
            }
            this.bQZ.stopLoading();
            this.bQZ.removeAllViews();
            this.bQZ.loadUrl("about:blank");
            this.bQZ.freeMemory();
            this.bQZ.destroy();
        }
    }

    public void setActivityContext(Activity activity) {
        g gVar = new g();
        gVar.x(activity).a(new f() { // from class: com.baidu.tieba.ala.liveroom.activeview.ActiveWebBannerItemView.1
            @Override // com.baidu.live.view.web.f
            public void fr(int i) {
                if ((ActiveWebBannerItemView.this.hdC != null) & (ActiveWebBannerItemView.this.hdG != null)) {
                    ActiveWebBannerItemView.this.hdC.bO(ActiveWebBannerItemView.this.hdG.aJO.pos, ActiveWebBannerItemView.this.hdG.activityId);
                }
            }
        }).a(getSchemeCallback()).b(this.bRm);
        this.bRa = new ArrayList();
        com.baidu.live.view.web.a[] YO = gVar.YO();
        for (com.baidu.live.view.web.a aVar : YO) {
            this.bRa.add(aVar.getName());
            this.bQZ.addJavascriptInterface(aVar, aVar.getName());
        }
    }

    public void loadUrl(String str) {
        if (this.bQZ != null) {
            this.bQZ.loadUrl(str);
        }
    }

    public boolean bYV() {
        return this.hbd;
    }

    @RequiresApi(19)
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.bQZ != null) {
            this.bQZ.evaluateJavascript(str, valueCallback);
        }
    }

    private void init() {
        this.hbd = false;
        setBackgroundColor(0);
        if (getBackground() != null) {
            getBackground().setAlpha(0);
        }
        this.bQZ = new CommonWebView(getContext());
        this.bQZ.setRequestDisallowInterceptTouchEvent(false);
        this.bQZ.setVerticalScrollEnabled(false);
        this.bQZ.setHorizontalScrollEnabled(false);
        this.bQZ.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.ala.liveroom.activeview.ActiveWebBannerItemView.2
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (!"file:///android_asset/web/error.html".equals(str) && Build.VERSION.SDK_INT >= 19) {
                    ActiveWebBannerItemView.this.evaluateJavascript("javascript:window.getClientInfo != undefined", new ValueCallback<String>() { // from class: com.baidu.tieba.ala.liveroom.activeview.ActiveWebBannerItemView.2.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            ActiveWebBannerItemView.this.hbd = Boolean.valueOf(str2).booleanValue();
                            if (ActiveWebBannerItemView.this.hdC != null) {
                                ActiveWebBannerItemView.this.hdC.na(ActiveWebBannerItemView.this.hbd);
                            }
                        }
                    });
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (Build.VERSION.SDK_INT < 23) {
                    ActiveWebBannerItemView.this.sl(str2);
                }
            }

            @Override // android.webkit.WebViewClient
            @RequiresApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                String uri;
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame() && webResourceRequest.getUrl() != null && (uri = webResourceRequest.getUrl().toString()) != null && !uri.equals("file:///android_asset/web/error.html")) {
                    ActiveWebBannerItemView.this.sl(uri);
                }
            }
        });
        addView(this.bQZ, new FrameLayout.LayoutParams(-1, -1));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.bQZ.resumeTimers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sl(String str) {
        this.eFu = str;
        this.bQZ.loadUrl("file:///android_asset/web/error.html");
        this.bQZ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.ActiveWebBannerItemView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (ActiveWebBannerItemView.this.bQZ != null && ActiveWebBannerItemView.this.bQZ.getUrl() != null && ActiveWebBannerItemView.this.bQZ.getUrl().equals("file:///android_asset/web/error.html") && !TextUtils.isEmpty(ActiveWebBannerItemView.this.eFu)) {
                    ActiveWebBannerItemView.this.bQZ.loadUrl(ActiveWebBannerItemView.this.eFu);
                    return false;
                }
                return false;
            }
        });
    }

    public SchemeCallback getSchemeCallback() {
        return this.bRc;
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
        String valueOf = wVar.aKr != null ? String.valueOf(wVar.aKr.userId) : null;
        String valueOf2 = wVar.aJV != null ? String.valueOf(wVar.aJV.userId) : null;
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
    public boolean aZ(String str, String str2) {
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
