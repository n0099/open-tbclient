package com.baidu.tieba.ad.browser;

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
import android.webkit.DownloadListener;
import android.webkit.JsPromptResult;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.hybrid.j;
import com.baidu.tbadk.core.hybrid.l;
import com.baidu.tbadk.core.hybrid.m;
import com.baidu.tbadk.core.hybrid.n;
import com.baidu.tbadk.core.hybrid.o;
import com.baidu.tbadk.core.hybrid.q;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.compatible.CompatibleUtile;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AdTbWebViewActivity extends AdBaseWebViewActivity {
    private com.baidu.tieba.tbadkCore.e.a jsBridge;
    private String mBid;
    private l mHybridBridge;
    private ValueCallback<Uri> mUploadMessage;
    private static boolean sFrameLostTracked = false;
    private static HashMap<String, String> mShareToTypes = new HashMap<>();
    protected AdBaseWebView dgK = null;
    private com.baidu.tieba.tbadkCore.e.c jsCallback = new com.baidu.tieba.tbadkCore.e.c() { // from class: com.baidu.tieba.ad.browser.AdTbWebViewActivity.1
        @Override // com.baidu.tieba.tbadkCore.e.c
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            if (AdTbWebViewActivity.this.jsBridge != null) {
                return AdTbWebViewActivity.this.jsBridge.a(str, jsPromptResult);
            }
            return false;
        }
    };
    private boolean mShowShareItem = true;
    private boolean isShowFullScreen = false;

    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void finish() {
        super.finish();
    }

    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public /* bridge */ /* synthetic */ String getCurrentPageKey() {
        return super.getCurrentPageKey();
    }

    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.adp.base.BdBaseActivity, android.os.Handler.Callback
    public /* bridge */ /* synthetic */ boolean handleMessage(Message message) {
        return super.handleMessage(message);
    }

    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public /* bridge */ /* synthetic */ void hideCrashTip() {
        super.hideCrashTip();
    }

    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity
    public /* bridge */ /* synthetic */ void hideProgressBar() {
        super.hideProgressBar();
    }

    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public /* bridge */ /* synthetic */ boolean isNeedShowMenuItem() {
        return super.isNeedShowMenuItem();
    }

    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public /* bridge */ /* synthetic */ boolean isNeedShowNavigationBar() {
        return super.isNeedShowNavigationBar();
    }

    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public /* bridge */ /* synthetic */ boolean isNeedShowShareItem() {
        return super.isNeedShowShareItem();
    }

    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void onBackPressed() {
        super.onBackPressed();
    }

    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity
    public /* bridge */ /* synthetic */ void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public /* bridge */ /* synthetic */ void onClick(View view) {
        super.onClick(view);
    }

    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public /* bridge */ /* synthetic */ boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public /* bridge */ /* synthetic */ void refresh() {
        super.refresh();
    }

    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public /* bridge */ /* synthetic */ void releaseResouce() {
        super.releaseResouce();
    }

    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public /* bridge */ /* synthetic */ void showNoDataView() {
        super.showNoDataView();
    }

    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity
    public /* bridge */ /* synthetic */ void showProgressBar() {
        super.showProgressBar();
    }

    static {
        mShareToTypes.put(LogConfig.LIVE_SHARE_WEIXIN_TIMELINE, LogConfig.LIVE_SHARE_WEIXIN_TIMELINE);
        mShareToTypes.put(LogConfig.LIVE_SHARE_WEIXIN_FRIEND, LogConfig.LIVE_SHARE_WEIXIN_FRIEND);
        mShareToTypes.put("qqdenglu", "qq_zone");
        mShareToTypes.put(LogConfig.LIVE_SHARE_WEIBO, "sina_weibo");
        mShareToTypes.put("qqweibo", "qq_weibo");
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MessageManager.getInstance().runTask(CmdConfigCustom.CMD_WEBVIEW_PROXY, (Class) null);
        this.jsBridge = new com.baidu.tieba.tbadkCore.e.a();
        this.jsBridge.a(new h(getPageContext()));
        this.jsBridge.a(new f(getPageContext()));
        this.jsBridge.a(buildGameDownloadJSPrompt());
        if (this.mNeedCookie) {
            initCookie();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dgK != null) {
            try {
                this.dgK.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
            callHiddenWebViewMethod("onResume");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.dgK != null) {
            try {
                this.dgK.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
            callHiddenWebViewMethod("onPause");
        }
    }

    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        if (this.dgK == null) {
            this.dgK = new com.baidu.tieba.ad.browser.a(getPageContext().getPageActivity());
            aDy();
        }
        return this.dgK;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aDy() {
        this.dgK.getSettings().setJavaScriptEnabled(true);
        this.dgK.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.dgK.getSettings().setAllowFileAccess(true);
        this.dgK.getSettings().setDatabaseEnabled(true);
        this.dgK.getSettings().setDomStorageEnabled(true);
        this.dgK.getSettings().setSupportZoom(true);
        this.dgK.getSettings().setBuiltInZoomControls(true);
        this.dgK.getSettings().setUseWideViewPort(true);
        this.dgK.getSettings().setDatabasePath(getApplicationContext().getDir("databases", 0).getAbsolutePath());
        this.dgK.setHorizontalScrollBarEnabled(false);
        this.dgK.setHorizontalScrollbarOverlay(false);
        this.dgK.setInitialScale(100);
        this.dgK.setScrollBarStyle(33554432);
        if (this.dgK.getLayoutParams() == null) {
            this.dgK.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        a aVar = new a();
        this.dgK.setWebViewClient(aVar);
        this.dgK.setDownloadListener(new b());
        c cVar = new c(this);
        cVar.setOnJsPromptCallback(this.jsCallback);
        this.dgK.setWebChromeClient(cVar);
        if (this.mEnableJs) {
            addJavascriptInterface();
        }
        CompatibleUtile.getInstance().removeJavascriptInterface(this.dgK);
        boolean isHybridBridgeEnabled = TbadkCoreApplication.getInst().isHybridBridgeEnabled();
        l a2 = q.a(isHybridBridgeEnabled, this.dgK, aVar, cVar, null);
        this.mHybridBridge = a2;
        if (isHybridBridgeEnabled) {
            a2.a(new n(a2) { // from class: com.baidu.tieba.ad.browser.AdTbWebViewActivity.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.tbadk.core.hybrid.n
                public String afT() {
                    return "TBHY_COMMON_Performance";
                }

                @o(alB = false, value = "trackFPS")
                private void trackFPS() {
                    AdTbWebViewActivity.this.trackFPS();
                }
            });
            a2.a(new com.baidu.tbadk.core.hybrid.a.a(a2));
            a2.a(new com.baidu.tbadk.core.hybrid.a.c(a2));
            a2.a(new com.baidu.tbadk.core.hybrid.a.b(a2));
            a2.a(new n(a2) { // from class: com.baidu.tieba.ad.browser.AdTbWebViewActivity.3
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.tbadk.core.hybrid.n
                public String afT() {
                    return "TBHY_COMMON_Share";
                }

                @o(alB = false, value = TbConfig.TMP_SHARE_DIR_NAME)
                private void share(JSONObject jSONObject) {
                    if (jSONObject != null) {
                        String optString = jSONObject.optString("title");
                        String optString2 = jSONObject.optString("desc");
                        String optString3 = jSONObject.optString("img");
                        String optString4 = jSONObject.optString("url");
                        String optString5 = jSONObject.optString("bid");
                        if (!StringUtils.isNULL(optString5)) {
                            AdTbWebViewActivity.this.mShareResultToFe = true;
                            AdTbWebViewActivity.this.mBid = optString5;
                        }
                        final com.baidu.tbadk.coreExtra.c.e createShareContent = AdTbWebViewActivity.this.createShareContent(optString, optString4, optString2, optString3);
                        com.baidu.adp.lib.g.e.fZ().post(new Runnable() { // from class: com.baidu.tieba.ad.browser.AdTbWebViewActivity.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AdTbWebViewActivity.this.dgI.a(createShareContent);
                            }
                        });
                    }
                }
            });
            a2.a(new n(a2) { // from class: com.baidu.tieba.ad.browser.AdTbWebViewActivity.4
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.tbadk.core.hybrid.n
                public String afT() {
                    return "TBHY_COMMON_UISwitch";
                }

                @o(alB = false, value = "viewHideSwitch")
                private void viewHideSwitch(JSONObject jSONObject) {
                    if (jSONObject != null) {
                        String optString = jSONObject.optJSONObject(TbConfig.TMP_SHARE_DIR_NAME).optString("value");
                        if ("1".equals(optString)) {
                            AdTbWebViewActivity.this.mShowShareItem = true;
                        } else if ("0".equals(optString)) {
                            AdTbWebViewActivity.this.mShowShareItem = false;
                        }
                        AdTbWebViewActivity.this.dgI.dR(AdTbWebViewActivity.this.mShowShareItem);
                    }
                }
            });
            a2.a(new com.baidu.tieba.ad.browser.b(a2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            if (getUploadMessage() != null) {
                getUploadMessage().onReceiveValue((intent == null || i2 != -1) ? null : intent.getData());
                setUploadMessage(null);
                return;
            }
            return;
        }
        switch (i) {
            case RequestResponseCode.REQUEST_WEBVIEW /* 12015 */:
                handleUploadResult(intent, i2);
                return;
            case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                handleShareResult(intent, i2);
                return;
            default:
                return;
        }
    }

    private void handleShareResult(Intent intent, int i) {
        if (this.mShareResultToFe) {
            this.mShareResultToFe = false;
            if (intent != null) {
                String str = mShareToTypes.get(intent.getStringExtra("share_to"));
                HashMap hashMap = new HashMap();
                boolean z = i == -1;
                hashMap.put("bid", this.mBid);
                hashMap.put("result", Boolean.valueOf(z));
                hashMap.put("channel", str);
                m a2 = m.a("TBJS_COMMON_Share", "onShareResult", hashMap, 0L, false);
                if (this.mHybridBridge != null) {
                    this.mHybridBridge.a(a2);
                }
            }
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

    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    @Deprecated
    public void addJavascriptInterface(Object obj, String str) {
    }

    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View getWebView() {
        return this.dgK;
    }

    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public void loadUrl(String str) {
        if (this.isShowFullScreen && this.dgI != null) {
            this.dgI.setFullScreen();
        }
        if (this.dgK != null) {
            CompatibleUtile.getInstance().loadUrl(this.dgK, str);
        }
    }

    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public void webViewDestory() {
        if (this.jsBridge != null) {
            this.jsBridge.coR();
        }
        if (this.dgK != null) {
            this.dgK.getSettings().setBuiltInZoomControls(true);
            this.dgK.setVisibility(8);
            com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.ad.browser.AdTbWebViewActivity.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (AdTbWebViewActivity.this.dgK != null) {
                            AdTbWebViewActivity.this.dgK.destroy();
                            AdTbWebViewActivity.this.dgK = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public boolean webViewGoBack() {
        if (this.dgK != null && this.dgK.canGoBack()) {
            this.dgK.goBack();
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public void initCookie() {
        e.initCookie(getApplicationContext());
    }

    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public void onReceivedError(int i) {
        if (this.dgK != null) {
            this.mUrl = this.dgK.getUrl();
            this.dgK.stopLoading();
        }
        hideProgressBar();
        showNoDataView();
    }

    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public void initWebView() {
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        try {
            super.unregisterReceiver(broadcastReceiver);
        } catch (Throwable th) {
        }
    }

    public ValueCallback<Uri> getUploadMessage() {
        return this.mUploadMessage;
    }

    public void setUploadMessage(ValueCallback<Uri> valueCallback) {
        this.mUploadMessage = valueCallback;
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
        if (!sFrameLostTracked) {
            sFrameLostTracked = true;
            com.baidu.tbadk.core.hybrid.g.alr().a(16, new j() { // from class: com.baidu.tieba.ad.browser.AdTbWebViewActivity.6
                @Override // com.baidu.tbadk.core.hybrid.j
                public void au(List<Long> list) {
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
                                com.baidu.adp.lib.stats.a fU = com.baidu.tbadk.p.l.fU();
                                fU.addValue("frame_delta", sb.toString());
                                BdStatisticsManager.getInstance().performance("webview", fU);
                                return;
                            }
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    protected void setFullScreen() {
        this.isShowFullScreen = true;
        if (this.isShowFullScreen && this.dgI != null) {
            runOnUiThread(new Runnable() { // from class: com.baidu.tieba.ad.browser.AdTbWebViewActivity.7
                @Override // java.lang.Runnable
                public void run() {
                    AdTbWebViewActivity.this.dgI.setFullScreen();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes3.dex */
    public class a extends WebViewClient {
        protected a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (AdTbWebViewActivity.this.dgK != null) {
                AdTbWebViewActivity.this.mUrl = str;
                AdTbWebViewActivity.this.dgK.loadUrl("javascript:window.local_obj.getIfFullScreen(document.getElementsByName(\"fc_fullscreen\")[0].content);");
                String title = AdTbWebViewActivity.this.dgK.getTitle();
                if (!StringUtils.isNull(title)) {
                    AdTbWebViewActivity.this.mUrlTitle = title;
                }
                if (!AdTbWebViewActivity.this.isShowFullScreen) {
                    AdTbWebViewActivity.this.dgI.mH(AdTbWebViewActivity.this.mUrlTitle);
                }
                AdTbWebViewActivity.this.dgI.setNavBarVisibility(AdTbWebViewActivity.this.mIsShowNavBar);
                AdTbWebViewActivity.this.dgI.dR(AdTbWebViewActivity.this.isNeedShowShareItem());
                AdTbWebViewActivity.this.hideProgressBar();
                AdTbWebViewActivity.this.stopLoadTimer();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (AdTbWebViewActivity.this.dgK != null) {
                AdTbWebViewActivity.this.dgK.stopLoading();
                AdTbWebViewActivity.this.stopLoadTimer();
                AdTbWebViewActivity.this.onReceivedError(i);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (AdTbWebViewActivity.this.dgK != null) {
                AdTbWebViewActivity.this.mUrl = str;
                AdTbWebViewActivity.this.showProgressBar();
                AdTbWebViewActivity.this.startLoadTimer();
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            int b = com.baidu.tieba.ad.a.aDw().b(AdTbWebViewActivity.this.getPageContext().getPageActivity(), new String[]{str});
            if (b == 1) {
                AdTbWebViewActivity.this.finish();
                return true;
            } else if (b == 0) {
                return true;
            } else {
                AdTbWebViewActivity.this.mUrl = str;
                if (AdTbWebViewActivity.this.isShowFullScreen) {
                    AdTbWebViewActivity.this.isShowFullScreen = false;
                    AdTbWebViewActivity.this.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.ad.browser.AdTbWebViewActivity.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AdTbWebViewActivity.this.dgI.agg();
                        }
                    });
                }
                AdTbWebViewActivity.this.refresh();
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements DownloadListener {
        private b() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            if (!StringUtils.isNull(str)) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                    AdTbWebViewActivity.this.startActivity(intent);
                }
            }
        }
    }
}
