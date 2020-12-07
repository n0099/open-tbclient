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
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.hybrid.g;
import com.baidu.tbadk.core.hybrid.j;
import com.baidu.tbadk.core.hybrid.l;
import com.baidu.tbadk.core.hybrid.m;
import com.baidu.tbadk.core.hybrid.n;
import com.baidu.tbadk.core.hybrid.o;
import com.baidu.tbadk.core.hybrid.q;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.n.k;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.d;
import com.baidu.tieba.ad.webview.BaseAdWebView;
import com.baidu.tieba.compatible.CompatibleUtile;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes21.dex */
public class NewAdTbWebViewActivity extends AdBaseWebViewActivity {
    private static boolean fZE = false;
    protected TBAdWebView fZV;
    private com.baidu.tieba.tbadkCore.e.a jsBridge;
    private l mHybridBridge;
    private com.baidu.tieba.tbadkCore.e.c jsCallback = new com.baidu.tieba.tbadkCore.e.c() { // from class: com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity.1
        @Override // com.baidu.tieba.tbadkCore.e.c
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            if (NewAdTbWebViewActivity.this.jsBridge != null) {
                return NewAdTbWebViewActivity.this.jsBridge.a(str, jsPromptResult);
            }
            return false;
        }
    };
    private boolean mShowShareItem = true;
    private boolean isShowFullScreen = false;

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    @JavascriptInterface
    public /* bridge */ /* synthetic */ void addJavascriptInterface() {
        super.addJavascriptInterface();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void finish() {
        super.finish();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public /* bridge */ /* synthetic */ String getCurrentPageKey() {
        return super.getCurrentPageKey();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.adp.base.BdBaseActivity, android.os.Handler.Callback
    public /* bridge */ /* synthetic */ boolean handleMessage(Message message) {
        return super.handleMessage(message);
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public /* bridge */ /* synthetic */ void hideCrashTip() {
        super.hideCrashTip();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity
    public /* bridge */ /* synthetic */ void hideProgressBar() {
        super.hideProgressBar();
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

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public /* bridge */ /* synthetic */ boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public /* bridge */ /* synthetic */ void refresh() {
        super.refresh();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public /* bridge */ /* synthetic */ void releaseResouce() {
        super.releaseResouce();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public /* bridge */ /* synthetic */ void showNoDataView() {
        super.showNoDataView();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity
    public /* bridge */ /* synthetic */ void showProgressBar() {
        super.showProgressBar();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MessageManager.getInstance().runTask(CmdConfigCustom.CMD_WEBVIEW_PROXY, (Class) null);
        this.jsBridge = new com.baidu.tieba.tbadkCore.e.a();
        this.jsBridge.a(new XiubaTbJsBridge(getPageContext()));
        this.jsBridge.a(new CommonTbJsBridge(getPageContext()));
        this.jsBridge.a(buildGameDownloadJSPrompt());
        if (this.mNeedCookie) {
            initCookie();
        }
        bMs();
    }

    private void bMs() {
        DownloadCacheKey FB;
        DownloadCacheKey downloadCacheKey;
        String str = "";
        Intent intent = getIntent();
        if (intent != null) {
            str = intent.getStringExtra(WebViewActivityConfig.TAG_DOWNLOAD_AD_ID);
        }
        if (!TextUtils.isEmpty(str)) {
            FB = d.bMx().FA(str);
        } else {
            FB = d.bMx().FB(this.mUrl);
        }
        if (FB == null) {
            if (!TextUtils.isEmpty(str)) {
                downloadCacheKey = DownloadCacheKey.create(str, "");
            } else {
                if (this.mUrl != null) {
                    String queryParameter = Uri.parse(this.mUrl).getQueryParameter("url");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        downloadCacheKey = DownloadCacheKey.create(queryParameter.substring(Math.max(0, queryParameter.length() - 6), queryParameter.length() - 1), "");
                    }
                }
                downloadCacheKey = FB;
            }
            if (downloadCacheKey == null) {
                downloadCacheKey = DownloadCacheKey.create(String.valueOf(System.currentTimeMillis()), "");
            }
            d.bMx().a(downloadCacheKey, null);
        } else {
            downloadCacheKey = FB;
        }
        if (this.fZV != null) {
            this.fZV.h(downloadCacheKey);
            this.fZO.a(downloadCacheKey);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.fZV != null) {
            try {
                this.fZV.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
            callHiddenWebViewMethod(MissionEvent.MESSAGE_RESUME);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.fZV != null) {
            try {
                this.fZV.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
            callHiddenWebViewMethod(MissionEvent.MESSAGE_PAUSE);
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public View createWebView() {
        if (this.fZV == null) {
            this.fZV = new TBAdWebView(getPageContext().getPageActivity());
            bMo();
        }
        return this.fZV;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bMo() {
        this.fZV.getSettings().setDatabasePath(getApplicationContext().getDir(NgWebView.APP_DATABASE_PATH, 0).getAbsolutePath());
        this.fZV.setHorizontalScrollbarOverlay(false);
        this.fZV.setInitialScale(100);
        this.fZV.setScrollBarStyle(33554432);
        if (this.fZV.getLayoutParams() == null) {
            this.fZV.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        a aVar = new a(this.fZV, this);
        this.fZV.setWebViewClient(aVar);
        b bVar = new b(this);
        bVar.setOnJsPromptCallback(this.jsCallback);
        this.fZV.setWebChromeClient(bVar);
        if (this.mEnableJs) {
            addJavascriptInterface();
        }
        CompatibleUtile.getInstance().removeJavascriptInterface(this.fZV);
        boolean isHybridBridgeEnabled = TbadkCoreApplication.getInst().isHybridBridgeEnabled();
        l a2 = q.a(isHybridBridgeEnabled, this.fZV, aVar, bVar, null);
        this.mHybridBridge = a2;
        if (isHybridBridgeEnabled) {
            a2.a(new n(a2) { // from class: com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.tbadk.core.hybrid.n
                public String blw() {
                    return "TBHY_COMMON_Performance";
                }

                @o(bsz = false, value = "trackFPS")
                private void trackFPS() {
                    NewAdTbWebViewActivity.this.trackFPS();
                }
            });
            a2.a(new com.baidu.tbadk.core.hybrid.a.a(a2));
            a2.a(new com.baidu.tbadk.core.hybrid.a.c(a2));
            a2.a(new com.baidu.tbadk.core.hybrid.a.b(a2));
            a2.a(new n(a2) { // from class: com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity.3
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.tbadk.core.hybrid.n
                public String blw() {
                    return "TBHY_COMMON_Share";
                }

                @o(bsz = false, value = TbConfig.TMP_SHARE_DIR_NAME)
                private void share(JSONObject jSONObject) {
                    if (jSONObject != null) {
                        String optString = jSONObject.optString("title");
                        String optString2 = jSONObject.optString("desc");
                        String optString3 = jSONObject.optString("img");
                        String optString4 = jSONObject.optString("url");
                        if (!StringUtils.isNULL(jSONObject.optString(MapBundleKey.MapObjKey.OBJ_BID))) {
                            NewAdTbWebViewActivity.this.mShareResultToFe = true;
                        }
                        final ShareItem createShareContent = NewAdTbWebViewActivity.this.createShareContent(optString, optString4, optString2, optString3);
                        e.mY().post(new Runnable() { // from class: com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                NewAdTbWebViewActivity.this.fZO.showShareDialog(createShareContent);
                            }
                        });
                    }
                }
            });
            a2.a(new n(a2) { // from class: com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity.4
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.tbadk.core.hybrid.n
                public String blw() {
                    return "TBHY_COMMON_UISwitch";
                }

                @o(bsz = false, value = "viewHideSwitch")
                private void viewHideSwitch(JSONObject jSONObject) {
                    if (jSONObject != null) {
                        String optString = jSONObject.optJSONObject(TbConfig.TMP_SHARE_DIR_NAME).optString("value");
                        if ("1".equals(optString)) {
                            NewAdTbWebViewActivity.this.mShowShareItem = true;
                        } else if ("0".equals(optString)) {
                            NewAdTbWebViewActivity.this.mShowShareItem = false;
                        }
                        NewAdTbWebViewActivity.this.fZO.iJ(NewAdTbWebViewActivity.this.mShowShareItem);
                    }
                }
            });
            a2.a(new com.baidu.tieba.ad.browser.newstyle.a(a2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case RequestResponseCode.REQUEST_WEBVIEW /* 12015 */:
                handleUploadResult(intent, i2);
                return;
            default:
                return;
        }
    }

    private void handleUploadResult(Intent intent, int i) {
        if (i == -1 && intent != null) {
            try {
                String stringExtra = intent.getStringExtra("album_result");
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
                m a2 = m.a("TBJS_COMMON_Image", "onImageUploadFinish", hashMap, 0L, false);
                if (this.mHybridBridge != null) {
                    this.mHybridBridge.a(a2);
                }
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    @Deprecated
    public void addJavascriptInterface(Object obj, String str) {
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public View getWebView() {
        return this.fZV;
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void loadUrl(String str) {
        if (this.isShowFullScreen && this.fZO != null) {
            this.fZO.setFullScreen();
        }
        if (this.fZV != null) {
            CompatibleUtile.getInstance().loadUrl(this.fZV, str);
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void webViewDestory() {
        if (this.jsBridge != null) {
            this.jsBridge.dPI();
        }
        if (this.fZV != null) {
            this.fZV.getSettings().setBuiltInZoomControls(true);
            this.fZV.setVisibility(8);
            e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (NewAdTbWebViewActivity.this.fZV != null) {
                            NewAdTbWebViewActivity.this.fZV.destroy();
                            NewAdTbWebViewActivity.this.fZV = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public boolean webViewGoBack() {
        return false;
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void initCookie() {
        com.baidu.tieba.ad.browser.d.initCookie(getApplicationContext());
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void onReceivedError(int i) {
        if (this.fZV != null) {
            this.mUrl = this.fZV.getUrl();
            this.fZV.stopLoading();
        }
        if ((TextUtils.isEmpty(this.mUrl) || !this.mUrl.endsWith(".apk")) && i != -1) {
            hideProgressBar();
            showNoDataView();
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void initWebView() {
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        try {
            super.unregisterReceiver(broadcastReceiver);
        } catch (Throwable th) {
        }
    }

    private com.baidu.tieba.tbadkCore.e.b buildGameDownloadJSPrompt() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GAME_JS_HANDLER_REGISTER, com.baidu.tieba.tbadkCore.e.b.class, getPageContext());
        if (runTask == null || runTask.getData() == null) {
            return null;
        }
        return (com.baidu.tieba.tbadkCore.e.b) runTask.getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackFPS() {
        if (!fZE) {
            fZE = true;
            g.bsq().a(16, new j() { // from class: com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity.6
                @Override // com.baidu.tbadk.core.hybrid.j
                public void bw(List<Long> list) {
                    if (list != null && list.size() != 0) {
                        String str = "";
                        StringBuilder sb = new StringBuilder();
                        Iterator<Long> it = list.iterator();
                        while (true) {
                            String str2 = str;
                            if (it.hasNext()) {
                                sb.append(str2);
                                sb.append(it.next());
                                str = PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS;
                            } else {
                                com.baidu.adp.lib.stats.a mT = k.mT();
                                mT.addValue("frame_delta", sb.toString());
                                BdStatisticsManager.getInstance().performance("webview", mT);
                                return;
                            }
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    protected void setFullScreen() {
        this.isShowFullScreen = true;
        if (this.isShowFullScreen && this.fZO != null) {
            runOnUiThread(new Runnable() { // from class: com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity.7
                @Override // java.lang.Runnable
                public void run() {
                    NewAdTbWebViewActivity.this.fZO.setFullScreen();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes21.dex */
    public class a extends BaseAdWebView.a {
        public a(BaseAdWebView baseAdWebView, Activity activity) {
            super(baseAdWebView, activity);
        }

        @Override // com.baidu.tieba.ad.webview.BaseAdWebView.a, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (NewAdTbWebViewActivity.this.fZV != null) {
                NewAdTbWebViewActivity.this.mUrl = str;
                NewAdTbWebViewActivity.this.fZV.loadUrl("javascript:window.local_obj.getIfFullScreen(document.getElementsByName(\"fc_fullscreen\")[0].content);");
                String title = NewAdTbWebViewActivity.this.fZV.getTitle();
                if (!StringUtils.isNull(title)) {
                    NewAdTbWebViewActivity.this.mUrlTitle = title;
                }
                if (!NewAdTbWebViewActivity.this.isShowFullScreen) {
                    NewAdTbWebViewActivity.this.fZO.Az(NewAdTbWebViewActivity.this.mUrlTitle);
                }
                NewAdTbWebViewActivity.this.fZO.setNavBarVisibility(NewAdTbWebViewActivity.this.mIsShowNavBar);
                NewAdTbWebViewActivity.this.fZO.iJ(NewAdTbWebViewActivity.this.isNeedShowShareItem());
                NewAdTbWebViewActivity.this.hideProgressBar();
                NewAdTbWebViewActivity.this.stopLoadTimer();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (NewAdTbWebViewActivity.this.fZV != null) {
                NewAdTbWebViewActivity.this.fZV.stopLoading();
                NewAdTbWebViewActivity.this.stopLoadTimer();
                NewAdTbWebViewActivity.this.onReceivedError(i);
            }
        }

        @Override // com.baidu.tieba.ad.webview.BaseAdWebView.a, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (NewAdTbWebViewActivity.this.fZV != null) {
                NewAdTbWebViewActivity.this.mUrl = str;
                NewAdTbWebViewActivity.this.showProgressBar();
                NewAdTbWebViewActivity.this.startLoadTimer();
            }
        }

        @Override // com.baidu.tieba.ad.webview.BaseAdWebView.a, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            int b = com.baidu.tieba.ad.a.bMm().b(NewAdTbWebViewActivity.this.getPageContext().getPageActivity(), new String[]{str});
            if (b == 1) {
                NewAdTbWebViewActivity.this.finish();
                return true;
            } else if (b == 0) {
                return true;
            } else {
                NewAdTbWebViewActivity.this.mUrl = str;
                if (NewAdTbWebViewActivity.this.isShowFullScreen) {
                    NewAdTbWebViewActivity.this.isShowFullScreen = false;
                    NewAdTbWebViewActivity.this.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.ad.browser.newstyle.NewAdTbWebViewActivity.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            NewAdTbWebViewActivity.this.fZO.blJ();
                        }
                    });
                }
                NewAdTbWebViewActivity.this.refresh();
                return true;
            }
        }
    }
}
