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
import com.baidu.live.data.ab;
import com.baidu.live.data.t;
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
/* loaded from: classes10.dex */
public class ActiveWebBannerItemView extends FrameLayout implements c {
    private h bXA;
    private CommonWebView bXo;
    private List<String> bXp;
    private SchemeCallback bXr;
    private String eOm;
    private boolean how;
    private a hqU;
    private t hqY;

    public ActiveWebBannerItemView(Context context) {
        super(context);
        this.bXr = new SchemeCallback() { // from class: com.baidu.tieba.ala.liveroom.activeview.ActiveWebBannerItemView.4
            @Override // com.baidu.live.tbadk.scheme.SchemeCallback
            public void doJsCallback(int i, String str, JSONObject jSONObject, String str2) {
                try {
                    String assembJavaScript = SchemeUtils.assembJavaScript(i, str, jSONObject, str2);
                    if (Build.VERSION.SDK_INT >= 19) {
                        ActiveWebBannerItemView.this.bXo.evaluateJavascript(assembJavaScript, null);
                    } else {
                        ActiveWebBannerItemView.this.bXo.loadUrl(assembJavaScript);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.bXA = new h() { // from class: com.baidu.tieba.ala.liveroom.activeview.ActiveWebBannerItemView.5
            @Override // com.baidu.live.view.web.h
            public boolean iF(String str) {
                if (TextUtils.isEmpty(str) || ActiveWebBannerItemView.this.hqU == null) {
                    return false;
                }
                if (ActiveWebBannerItemView.this.el(str, "fullscreen")) {
                    ActiveWebBannerItemView.this.hqU.Hz(str);
                } else if (ActiveWebBannerItemView.this.el(str, UbcStatConstant.KEY_CONTENT_ROOM)) {
                    ActiveWebBannerItemView.this.hqU.Hy(str);
                } else {
                    ActiveWebBannerItemView.this.hqU.HA(str);
                }
                return true;
            }
        };
        init();
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void setCallback(a aVar) {
        this.hqU = aVar;
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void setData(boolean z, ab abVar, t tVar) {
        if (this.bXo != null && tVar != null) {
            this.hqY = tVar;
            String a2 = a(z, abVar, tVar.webUrl, tVar.jump_url, tVar.aJu);
            if (!a2.equals(this.bXo.getOriginalUrl())) {
                this.bXo.loadUrl(a2);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStart() {
        if (this.bXo != null) {
            this.bXo.onResume();
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.bXo.resumeTimers();
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStop() {
        if (this.bXo != null) {
            this.bXo.onPause();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void release() {
        this.hqU = null;
        this.how = false;
        removeAllViews();
        if (this.bXo != null) {
            if (this.bXp != null) {
                for (String str : this.bXp) {
                    this.bXo.removeJavascriptInterface(str);
                }
                this.bXp.clear();
            }
            this.bXo.stopLoading();
            this.bXo.removeAllViews();
            this.bXo.loadUrl("about:blank");
            this.bXo.freeMemory();
            this.bXo.destroy();
        }
    }

    public void setActivityContext(Activity activity) {
        g gVar = new g();
        gVar.t(activity).a(new f() { // from class: com.baidu.tieba.ala.liveroom.activeview.ActiveWebBannerItemView.1
            @Override // com.baidu.live.view.web.f
            public void fq(int i) {
                if ((ActiveWebBannerItemView.this.hqU != null) & (ActiveWebBannerItemView.this.hqY != null)) {
                    ActiveWebBannerItemView.this.hqU.bM(ActiveWebBannerItemView.this.hqY.aJw.pos, ActiveWebBannerItemView.this.hqY.activityId);
                }
            }
        }).a(getSchemeCallback()).b(this.bXA);
        this.bXp = new ArrayList();
        com.baidu.live.view.web.a[] Yb = gVar.Yb();
        for (com.baidu.live.view.web.a aVar : Yb) {
            this.bXp.add(aVar.getName());
            this.bXo.addJavascriptInterface(aVar, aVar.getName());
        }
    }

    public void loadUrl(String str) {
        if (this.bXo != null) {
            this.bXo.loadUrl(str);
        }
    }

    public boolean bYX() {
        return this.how;
    }

    @RequiresApi(19)
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.bXo != null) {
            this.bXo.evaluateJavascript(str, valueCallback);
        }
    }

    private void init() {
        this.how = false;
        setBackgroundColor(0);
        if (getBackground() != null) {
            getBackground().setAlpha(0);
        }
        this.bXo = new CommonWebView(getContext());
        this.bXo.setRequestDisallowInterceptTouchEvent(false);
        this.bXo.setVerticalScrollEnabled(false);
        this.bXo.setHorizontalScrollEnabled(false);
        this.bXo.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.ala.liveroom.activeview.ActiveWebBannerItemView.2
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (!"file:///android_asset/web/error.html".equals(str) && Build.VERSION.SDK_INT >= 19) {
                    ActiveWebBannerItemView.this.evaluateJavascript("javascript:window.getClientInfo != undefined", new ValueCallback<String>() { // from class: com.baidu.tieba.ala.liveroom.activeview.ActiveWebBannerItemView.2.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            ActiveWebBannerItemView.this.how = Boolean.valueOf(str2).booleanValue();
                            if (ActiveWebBannerItemView.this.hqU != null) {
                                ActiveWebBannerItemView.this.hqU.nG(ActiveWebBannerItemView.this.how);
                            }
                        }
                    });
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (Build.VERSION.SDK_INT < 23) {
                    ActiveWebBannerItemView.this.rt(str2);
                }
            }

            @Override // android.webkit.WebViewClient
            @RequiresApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                String uri;
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame() && webResourceRequest.getUrl() != null && (uri = webResourceRequest.getUrl().toString()) != null && !uri.equals("file:///android_asset/web/error.html")) {
                    ActiveWebBannerItemView.this.rt(uri);
                }
            }
        });
        addView(this.bXo, new FrameLayout.LayoutParams(-1, -1));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.bXo.resumeTimers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rt(String str) {
        this.eOm = str;
        this.bXo.loadUrl("file:///android_asset/web/error.html");
        this.bXo.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.ActiveWebBannerItemView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (ActiveWebBannerItemView.this.bXo != null && ActiveWebBannerItemView.this.bXo.getUrl() != null && ActiveWebBannerItemView.this.bXo.getUrl().equals("file:///android_asset/web/error.html") && !TextUtils.isEmpty(ActiveWebBannerItemView.this.eOm)) {
                    ActiveWebBannerItemView.this.bXo.loadUrl(ActiveWebBannerItemView.this.eOm);
                    return false;
                }
                return false;
            }
        });
    }

    public SchemeCallback getSchemeCallback() {
        return this.bXr;
    }

    private String a(boolean z, ab abVar, String str, String str2, int i) {
        String str3;
        String str4;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (abVar == null) {
            return str;
        }
        String encryptionUserId = abVar.aJZ != null ? ExtraParamsManager.getEncryptionUserId(String.valueOf(abVar.aJZ.userId)) : null;
        String encryptionUserId2 = abVar.aJD != null ? ExtraParamsManager.getEncryptionUserId(String.valueOf(abVar.aJD.userId)) : null;
        if (abVar.mLiveInfo != null) {
            str4 = String.valueOf(abVar.mLiveInfo.room_id);
            str3 = String.valueOf(abVar.mLiveInfo.live_id);
        } else {
            str3 = null;
            str4 = null;
        }
        Map<String, Object> a2 = com.baidu.live.utils.b.a(z, encryptionUserId, encryptionUserId2, str4, str3);
        if (i == 2) {
            a2.put(UbcStatConstant.KEY_CONTENT_ROOM, 1);
        }
        a2.put(BigdayActivityConfig.JUMP_URL, aL(str2, i));
        return WebviewHelper.addQueryParams(str, a2);
    }

    private String aL(String str, int i) {
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
    public boolean el(String str, String str2) {
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
