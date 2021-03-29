package com.baidu.tieba.ad.browser.newstyle;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.URLUtil;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.nps.utils.Constant;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.webview.BaseAdWebView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidubce.auth.NTLMEngineImpl;
import d.b.h0.r.y.j;
import d.b.h0.r.y.l;
import d.b.h0.r.y.m;
import d.b.h0.r.y.n;
import d.b.h0.r.y.o;
import d.b.h0.r.y.q;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AdWebViewActivity extends AdBaseWebViewActivity {
    public static boolean sFrameLostTracked = false;
    public d.b.i0.c3.l0.a jsBridge;
    public l mHybridBridge;
    public TBAdWebView mWebView;
    public d.b.i0.c3.l0.c jsCallback = new a();
    public boolean mShowShareItem = true;
    public boolean isShowFullScreen = false;

    /* loaded from: classes4.dex */
    public class a implements d.b.i0.c3.l0.c {
        public a() {
        }

        @Override // d.b.i0.c3.l0.c
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            if (AdWebViewActivity.this.jsBridge != null) {
                return AdWebViewActivity.this.jsBridge.c(str, jsPromptResult);
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends n {
        public b(l lVar) {
            super(lVar);
        }

        @o(isAsync = false, value = "trackFPS")
        private void trackFPS() {
            AdWebViewActivity.this.trackFPS();
        }

        @Override // d.b.h0.r.y.n
        public String g() {
            return "TBHY_COMMON_Performance";
        }
    }

    /* loaded from: classes4.dex */
    public class c extends n {

        /* loaded from: classes4.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ShareItem f14498e;

            public a(ShareItem shareItem) {
                this.f14498e = shareItem;
            }

            @Override // java.lang.Runnable
            public void run() {
                AdWebViewActivity.this.mView.B(this.f14498e);
            }
        }

        public c(l lVar) {
            super(lVar);
        }

        @o(isAsync = false, value = "share")
        private void share(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            String optString = jSONObject.optString("title");
            String optString2 = jSONObject.optString("desc");
            String optString3 = jSONObject.optString("img");
            String optString4 = jSONObject.optString("url");
            if (!StringUtils.isNULL(jSONObject.optString("bid"))) {
                AdWebViewActivity.this.mShareResultToFe = true;
            }
            d.b.b.e.m.e.a().post(new a(AdWebViewActivity.this.createShareContent(optString, optString4, optString2, optString3)));
        }

        @Override // d.b.h0.r.y.n
        public String g() {
            return "TBHY_COMMON_Share";
        }
    }

    /* loaded from: classes4.dex */
    public class d extends n {
        public d(l lVar) {
            super(lVar);
        }

        @o(isAsync = false, value = "viewHideSwitch")
        private void viewHideSwitch(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            String optString = jSONObject.optJSONObject("share").optString("value");
            if ("1".equals(optString)) {
                AdWebViewActivity.this.mShowShareItem = true;
            } else if ("0".equals(optString)) {
                AdWebViewActivity.this.mShowShareItem = false;
            }
            AdWebViewActivity adWebViewActivity = AdWebViewActivity.this;
            adWebViewActivity.mView.w(adWebViewActivity.mShowShareItem);
        }

        @Override // d.b.h0.r.y.n
        public String g() {
            return "TBHY_COMMON_UISwitch";
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (AdWebViewActivity.this.mWebView != null) {
                    AdWebViewActivity.this.mWebView.destroy();
                    AdWebViewActivity.this.mWebView = null;
                }
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements j {
        public f() {
        }

        @Override // d.b.h0.r.y.j
        public void a(List<Long> list) {
            if (list == null || list.size() == 0) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            String str = "";
            for (Long l : list) {
                sb.append(str);
                sb.append(l);
                str = "_";
            }
            d.b.b.e.n.a a2 = d.b.h0.m0.j.a();
            a2.a("frame_delta", sb.toString());
            BdStatisticsManager.getInstance().performance("webview", a2);
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AdWebViewActivity.this.mView.r();
        }
    }

    /* loaded from: classes4.dex */
    public class h extends BaseAdWebView.c {

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AdWebViewActivity.this.mView.q();
            }
        }

        public h(BaseAdWebView baseAdWebView, Activity activity) {
            super(baseAdWebView, activity);
        }

        @Override // com.baidu.tieba.ad.webview.BaseAdWebView.c, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            AdWebViewActivity adWebViewActivity = AdWebViewActivity.this;
            TBAdWebView tBAdWebView = adWebViewActivity.mWebView;
            if (tBAdWebView == null) {
                return;
            }
            adWebViewActivity.mUrl = str;
            tBAdWebView.loadUrl("javascript:window.local_obj.getIfFullScreen(document.getElementsByName(\"fc_fullscreen\")[0].content);");
            String title = AdWebViewActivity.this.mWebView.getTitle();
            if (!StringUtils.isNull(title)) {
                AdWebViewActivity.this.mUrlTitle = title;
            }
            if (!AdWebViewActivity.this.isShowFullScreen) {
                AdWebViewActivity adWebViewActivity2 = AdWebViewActivity.this;
                adWebViewActivity2.mView.u(adWebViewActivity2.mUrlTitle);
            }
            AdWebViewActivity adWebViewActivity3 = AdWebViewActivity.this;
            adWebViewActivity3.mView.t(adWebViewActivity3.mIsShowNavBar);
            AdWebViewActivity adWebViewActivity4 = AdWebViewActivity.this;
            adWebViewActivity4.mView.w(adWebViewActivity4.isNeedShowShareItem());
            AdWebViewActivity.this.hideProgressBar();
            AdWebViewActivity.this.stopLoadTimer();
        }

        @Override // com.baidu.tieba.ad.webview.BaseAdWebView.c, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            AdWebViewActivity adWebViewActivity = AdWebViewActivity.this;
            if (adWebViewActivity.mWebView == null) {
                return;
            }
            adWebViewActivity.mUrl = str;
            adWebViewActivity.showProgressBar();
            AdWebViewActivity.this.startLoadTimer();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            TBAdWebView tBAdWebView = AdWebViewActivity.this.mWebView;
            if (tBAdWebView == null) {
                return;
            }
            tBAdWebView.stopLoading();
            AdWebViewActivity.this.stopLoadTimer();
            AdWebViewActivity.this.onReceivedError(i);
        }

        @Override // com.baidu.tieba.ad.webview.BaseAdWebView.c, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            d.b.i0.o.b.b.c cVar;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            int i = d.b.i0.o.a.l().i(AdWebViewActivity.this.getPageContext().getPageActivity(), new String[]{str});
            if (i == 1) {
                AdWebViewActivity.this.finish();
                return true;
            } else if (i == 0) {
                return true;
            } else {
                AdWebViewActivity adWebViewActivity = AdWebViewActivity.this;
                adWebViewActivity.mUrl = str;
                if (adWebViewActivity.isShowFullScreen) {
                    AdWebViewActivity.this.isShowFullScreen = false;
                    AdWebViewActivity.this.runOnUiThread(new a());
                }
                if (URLUtil.isNetworkUrl(AdWebViewActivity.this.mUrl)) {
                    AdWebViewActivity.this.showProgressBar();
                    if (AdWebViewActivity.this.isShowFullScreen && (cVar = AdWebViewActivity.this.mView) != null) {
                        cVar.r();
                    }
                    return false;
                }
                AdWebViewActivity adWebViewActivity2 = AdWebViewActivity.this;
                adWebViewActivity2.tryDeeplink(adWebViewActivity2.mUrl);
                return true;
            }
        }
    }

    private d.b.i0.c3.l0.b buildGameDownloadJSPrompt() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001386, d.b.i0.c3.l0.b.class, getPageContext());
        if (runTask == null || runTask.getData() == null) {
            return null;
        }
        return (d.b.i0.c3.l0.b) runTask.getData();
    }

    private void handleUploadResult(Intent intent, int i) {
        if (i != -1 || intent == null) {
            return;
        }
        try {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            HashMap hashMap = new HashMap();
            JSONArray jSONArray = new JSONArray();
            if (writeImagesInfo.getChosedFiles() != null && writeImagesInfo.getChosedFiles().size() > 0) {
                Iterator<ImageFileInfo> it = writeImagesInfo.getChosedFiles().iterator();
                while (it.hasNext()) {
                    ImageFileInfo next = it.next();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("originalUrl", next.serverPicInfo.originPic.picUrl);
                    jSONObject.put("originalWidth", next.serverPicInfo.originPic.width);
                    jSONObject.put("originalHeight", next.serverPicInfo.originPic.height);
                    jSONObject.put("photoUrl", next.serverPicInfo.bigPic.picUrl);
                    jSONObject.put("photoWidth", next.serverPicInfo.bigPic.width);
                    jSONObject.put("photoHeight", next.serverPicInfo.bigPic.height);
                    jSONObject.put("photoThumbUrl", next.serverPicInfo.smallPic.picUrl);
                    jSONObject.put("filePath", next.getFilePath());
                    jSONArray.put(jSONObject);
                }
            }
            hashMap.put(TbConfig.LOCAL_PIC_DIR, jSONArray);
            m j = m.j("TBJS_COMMON_Image", "onImageUploadFinish", hashMap, 0L, false);
            if (this.mHybridBridge != null) {
                this.mHybridBridge.c(j);
            }
        } catch (JSONException e2) {
            BdLog.e(e2.getMessage());
        }
    }

    private void initDownloadData() {
        DownloadCacheKey h2;
        Intent intent = getIntent();
        String stringExtra = intent != null ? intent.getStringExtra(WebViewActivityConfig.TAG_DOWNLOAD_AD_ID) : "";
        if (!TextUtils.isEmpty(stringExtra)) {
            h2 = d.b.i0.o.c.d.c().g(stringExtra);
        } else {
            h2 = d.b.i0.o.c.d.c().h(this.mUrl);
        }
        if (h2 == null) {
            if (!TextUtils.isEmpty(stringExtra)) {
                h2 = DownloadCacheKey.create(stringExtra, "");
            } else {
                String str = this.mUrl;
                if (str != null) {
                    String queryParameter = Uri.parse(str).getQueryParameter("url");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        h2 = DownloadCacheKey.create(queryParameter.substring(Math.max(0, queryParameter.length() - 6), queryParameter.length() - 1), "");
                    }
                }
            }
            if (h2 == null) {
                h2 = DownloadCacheKey.create(String.valueOf(System.currentTimeMillis()), "");
            }
            d.b.i0.o.c.d.c().i(h2, null);
        }
        TBAdWebView tBAdWebView = this.mWebView;
        if (tBAdWebView == null) {
            return;
        }
        tBAdWebView.d(h2);
        this.mView.l(h2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackFPS() {
        if (sFrameLostTracked) {
            return;
        }
        sFrameLostTracked = true;
        d.b.h0.r.y.g.a().b(16, new f());
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    @JavascriptInterface
    public /* bridge */ /* synthetic */ void addJavascriptInterface() {
        super.addJavascriptInterface();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    @Deprecated
    public void addJavascriptInterface(Object obj, String str) {
    }

    public void configWebView() {
        this.mWebView.getSettings().setDatabasePath(getApplicationContext().getDir("databases", 0).getAbsolutePath());
        this.mWebView.setHorizontalScrollbarOverlay(false);
        this.mWebView.setInitialScale(100);
        this.mWebView.setScrollBarStyle(NTLMEngineImpl.FLAG_REQUEST_VERSION);
        if (this.mWebView.getLayoutParams() == null) {
            this.mWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        h hVar = new h(this.mWebView, this);
        this.mWebView.setWebViewClient(hVar);
        d.b.i0.o.b.b.b bVar = new d.b.i0.o.b.b.b(this);
        bVar.a(this.jsCallback);
        this.mWebView.setWebChromeClient(bVar);
        if (this.mEnableJs) {
            addJavascriptInterface();
        }
        CompatibleUtile.getInstance().removeJavascriptInterface(this.mWebView);
        boolean isHybridBridgeEnabled = TbadkCoreApplication.getInst().isHybridBridgeEnabled();
        l n = q.n(isHybridBridgeEnabled, this.mWebView, hVar, bVar, null);
        this.mHybridBridge = n;
        if (isHybridBridgeEnabled) {
            n.d(new b(n));
            n.d(new d.b.h0.r.y.s.a(n));
            n.d(new d.b.h0.r.y.s.c(n));
            n.d(new d.b.h0.r.y.s.b(n));
            n.d(new c(n));
            n.d(new d(n));
            n.d(new d.b.i0.o.b.b.a(n));
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public View createWebView() {
        if (this.mWebView == null) {
            this.mWebView = new TBAdWebView(getPageContext().getPageActivity());
            configWebView();
        }
        return this.mWebView;
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void finish() {
        super.finish();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, d.b.h0.k0.a
    public /* bridge */ /* synthetic */ String getCurrentPageKey() {
        return super.getCurrentPageKey();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public View getWebView() {
        return this.mWebView;
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.adp.base.BdBaseActivity, android.os.Handler.Callback
    public /* bridge */ /* synthetic */ boolean handleMessage(Message message) {
        return super.handleMessage(message);
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public /* bridge */ /* synthetic */ void hideCrashTip() {
        super.hideCrashTip();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public /* bridge */ /* synthetic */ void hideNoDataView() {
        super.hideNoDataView();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity
    public /* bridge */ /* synthetic */ void hideProgressBar() {
        super.hideProgressBar();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void initCookie() {
        d.b.i0.o.b.a.c(getApplicationContext());
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void initWebView() {
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public /* bridge */ /* synthetic */ boolean isNeedShowMenuItem() {
        return super.isNeedShowMenuItem();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public /* bridge */ /* synthetic */ boolean isNeedShowNavigationBar() {
        return super.isNeedShowNavigationBar();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public /* bridge */ /* synthetic */ boolean isNeedShowShareItem() {
        return super.isNeedShowShareItem();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void loadUrl(String str) {
        d.b.i0.o.b.b.c cVar;
        if (this.isShowFullScreen && (cVar = this.mView) != null) {
            cVar.r();
        }
        TBAdWebView tBAdWebView = this.mWebView;
        if (tBAdWebView != null) {
            tBAdWebView.loadUrl(str);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 12015) {
            return;
        }
        handleUploadResult(intent, i2);
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void onBackPressed() {
        super.onBackPressed();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity
    public /* bridge */ /* synthetic */ void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public /* bridge */ /* synthetic */ void onClick(View view) {
        super.onClick(view);
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MessageManager.getInstance().runTask(2001308, (Class) null);
        d.b.i0.c3.l0.a aVar = new d.b.i0.c3.l0.a();
        this.jsBridge = aVar;
        aVar.a(new XiubaTbJsBridge(getPageContext()));
        this.jsBridge.a(new CommonTbJsBridge(getPageContext()));
        this.jsBridge.a(buildGameDownloadJSPrompt());
        if (this.mNeedCookie) {
            initCookie();
        }
        initDownloadData();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public /* bridge */ /* synthetic */ boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        TBAdWebView tBAdWebView = this.mWebView;
        if (tBAdWebView == null) {
            return;
        }
        try {
            tBAdWebView.onPause();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        callHiddenWebViewMethod(MissionEvent.MESSAGE_PAUSE);
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void onReceivedError(int i) {
        TBAdWebView tBAdWebView = this.mWebView;
        if (tBAdWebView != null) {
            this.mUrl = tBAdWebView.getUrl();
            this.mWebView.stopLoading();
        }
        if ((TextUtils.isEmpty(this.mUrl) || !this.mUrl.endsWith(Constant.FILE.SUFFIX.BUNDLE_SUFFIX)) && i != -1) {
            hideProgressBar();
            showNoDataView();
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        TBAdWebView tBAdWebView = this.mWebView;
        if (tBAdWebView == null) {
            return;
        }
        try {
            tBAdWebView.onResume();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        callHiddenWebViewMethod(MissionEvent.MESSAGE_RESUME);
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public /* bridge */ /* synthetic */ void refresh() {
        super.refresh();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public /* bridge */ /* synthetic */ void refreshIgnoreFormat() {
        super.refreshIgnoreFormat();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public /* bridge */ /* synthetic */ void releaseResouce() {
        super.releaseResouce();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public /* bridge */ /* synthetic */ void setAutoChangeStyle(boolean z) {
        super.setAutoChangeStyle(z);
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void setFullScreen() {
        this.isShowFullScreen = true;
        if (1 == 0 || this.mView == null) {
            return;
        }
        runOnUiThread(new g());
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public /* bridge */ /* synthetic */ void setNavBarVisibility(boolean z) {
        super.setNavBarVisibility(z);
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public /* bridge */ /* synthetic */ void showCrashTip() {
        super.showCrashTip();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public /* bridge */ /* synthetic */ void showNoDataView() {
        super.showNoDataView();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity
    public /* bridge */ /* synthetic */ void showProgressBar() {
        super.showProgressBar();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        try {
            super.unregisterReceiver(broadcastReceiver);
        } catch (Throwable unused) {
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void webViewDestory() {
        d.b.i0.c3.l0.a aVar = this.jsBridge;
        if (aVar != null) {
            aVar.f();
        }
        TBAdWebView tBAdWebView = this.mWebView;
        if (tBAdWebView != null) {
            tBAdWebView.getSettings().setBuiltInZoomControls(true);
            this.mWebView.setVisibility(8);
            d.b.b.e.m.e.a().postDelayed(new e(), ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public boolean webViewGoBack() {
        return false;
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public /* bridge */ /* synthetic */ void finish(int i, Intent intent) {
        super.finish(i, intent);
    }
}
