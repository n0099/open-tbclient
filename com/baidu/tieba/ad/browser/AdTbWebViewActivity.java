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
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
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
import com.tencent.open.SocialConstants;
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
    protected AdBaseWebView bnw = null;
    private com.baidu.tieba.tbadkCore.e.c jsCallback = new com.baidu.tieba.tbadkCore.e.c() { // from class: com.baidu.tieba.ad.browser.AdTbWebViewActivity.1
        @Override // com.baidu.tieba.tbadkCore.e.c
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            if (AdTbWebViewActivity.this.jsBridge != null) {
                return AdTbWebViewActivity.this.jsBridge.b(str, jsPromptResult);
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

    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
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
        mShareToTypes.put("weixin_timeline", "weixin_timeline");
        mShareToTypes.put("weixin_friend", "weixin_friend");
        mShareToTypes.put("qqdenglu", "qq_zone");
        mShareToTypes.put("sinaweibo", "sina_weibo");
        mShareToTypes.put("qqweibo", "qq_weibo");
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MessageManager.getInstance().runTask(2001308, (Class) null);
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
        if (this.bnw != null) {
            try {
                this.bnw.onResume();
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
        if (this.bnw != null) {
            try {
                this.bnw.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
            callHiddenWebViewMethod("onPause");
        }
    }

    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public View createWebView() {
        if (this.bnw == null) {
            this.bnw = new com.baidu.tieba.ad.browser.a(getPageContext().getPageActivity());
            Rj();
        }
        return this.bnw;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Rj() {
        this.bnw.getSettings().setJavaScriptEnabled(true);
        this.bnw.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.bnw.getSettings().setAllowFileAccess(true);
        this.bnw.getSettings().setDatabaseEnabled(true);
        this.bnw.getSettings().setDomStorageEnabled(true);
        this.bnw.getSettings().setSupportZoom(true);
        this.bnw.getSettings().setBuiltInZoomControls(true);
        this.bnw.getSettings().setUseWideViewPort(true);
        this.bnw.getSettings().setDatabasePath(getApplicationContext().getDir("databases", 0).getAbsolutePath());
        this.bnw.setHorizontalScrollBarEnabled(false);
        this.bnw.setHorizontalScrollbarOverlay(false);
        this.bnw.setInitialScale(100);
        this.bnw.setScrollBarStyle(33554432);
        if (this.bnw.getLayoutParams() == null) {
            this.bnw.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        a aVar = new a();
        this.bnw.setWebViewClient(aVar);
        this.bnw.setDownloadListener(new b());
        c cVar = new c(this);
        cVar.setOnJsPromptCallback(this.jsCallback);
        this.bnw.setWebChromeClient(cVar);
        if (this.mEnableJs) {
            addJavascriptInterface();
        }
        CompatibleUtile.getInstance().removeJavascriptInterface(this.bnw);
        boolean isHybridBridgeEnabled = TbadkCoreApplication.getInst().isHybridBridgeEnabled();
        l a2 = q.a(isHybridBridgeEnabled, this.bnw, aVar, cVar, null);
        this.mHybridBridge = a2;
        if (isHybridBridgeEnabled) {
            a2.a(new n(a2) { // from class: com.baidu.tieba.ad.browser.AdTbWebViewActivity.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.tbadk.core.hybrid.n
                public String sm() {
                    return "TBHY_COMMON_Performance";
                }

                @o(value = "trackFPS", xM = false)
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
                public String sm() {
                    return "TBHY_COMMON_Share";
                }

                @o(value = "share", xM = false)
                private void share(JSONObject jSONObject) {
                    if (jSONObject != null) {
                        String optString = jSONObject.optString("title");
                        String optString2 = jSONObject.optString(SocialConstants.PARAM_APP_DESC);
                        String optString3 = jSONObject.optString(SocialConstants.PARAM_IMG_URL);
                        String optString4 = jSONObject.optString("url");
                        String optString5 = jSONObject.optString("bid");
                        if (!StringUtils.isNULL(optString5)) {
                            AdTbWebViewActivity.this.mShareResultToFe = true;
                            AdTbWebViewActivity.this.mBid = optString5;
                        }
                        final com.baidu.tbadk.coreExtra.c.d createShareContent = AdTbWebViewActivity.this.createShareContent(optString, optString4, optString2, optString3);
                        com.baidu.adp.lib.g.e.in().post(new Runnable() { // from class: com.baidu.tieba.ad.browser.AdTbWebViewActivity.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AdTbWebViewActivity.this.bnu.a(createShareContent);
                            }
                        });
                    }
                }
            });
            a2.a(new n(a2) { // from class: com.baidu.tieba.ad.browser.AdTbWebViewActivity.4
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.tbadk.core.hybrid.n
                public String sm() {
                    return "TBHY_COMMON_UISwitch";
                }

                @o(value = "viewHideSwitch", xM = false)
                private void viewHideSwitch(JSONObject jSONObject) {
                    if (jSONObject != null) {
                        String optString = jSONObject.optJSONObject("share").optString("value");
                        if ("1".equals(optString)) {
                            AdTbWebViewActivity.this.mShowShareItem = true;
                        } else if ("0".equals(optString)) {
                            AdTbWebViewActivity.this.mShowShareItem = false;
                        }
                        AdTbWebViewActivity.this.bnu.ag(AdTbWebViewActivity.this.mShowShareItem);
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
            case IEventCenterService.EventId.EventMode.SAPIACCOUNT_LOGIN /* 12015 */:
                handleUploadResult(intent, i2);
                return;
            case 24007:
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
        return this.bnw;
    }

    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public void loadUrl(String str) {
        if (this.isShowFullScreen && this.bnu != null) {
            this.bnu.setFullScreen();
        }
        if (this.bnw != null) {
            CompatibleUtile.getInstance().loadUrl(this.bnw, str);
        }
    }

    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public void webViewDestory() {
        if (this.jsBridge != null) {
            this.jsBridge.bwJ();
        }
        if (this.bnw != null) {
            this.bnw.getSettings().setBuiltInZoomControls(true);
            this.bnw.setVisibility(8);
            com.baidu.adp.lib.g.e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.ad.browser.AdTbWebViewActivity.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (AdTbWebViewActivity.this.bnw != null) {
                            AdTbWebViewActivity.this.bnw.destroy();
                            AdTbWebViewActivity.this.bnw = null;
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
        if (this.bnw != null && this.bnw.canGoBack()) {
            this.bnw.goBack();
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public void initCookie() {
        e.aB(getApplicationContext());
    }

    @Override // com.baidu.tieba.ad.browser.AdBaseWebViewActivity
    public void onReceivedError(int i) {
        if (this.bnw != null) {
            this.mUrl = this.bnw.getUrl();
            this.bnw.stopLoading();
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
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001386, com.baidu.tieba.tbadkCore.e.b.class, getPageContext());
        if (runTask == null || runTask.getData() == null) {
            return null;
        }
        return (com.baidu.tieba.tbadkCore.e.b) runTask.getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackFPS() {
        if (!sFrameLostTracked) {
            sFrameLostTracked = true;
            com.baidu.tbadk.core.hybrid.g.xC().a(16, new j() { // from class: com.baidu.tieba.ad.browser.AdTbWebViewActivity.6
                @Override // com.baidu.tbadk.core.hybrid.j
                public void w(List<Long> list) {
                    if (list != null && list.size() != 0) {
                        String str = "";
                        StringBuilder sb = new StringBuilder();
                        Iterator<Long> it = list.iterator();
                        while (true) {
                            String str2 = str;
                            if (it.hasNext()) {
                                sb.append(str2);
                                sb.append(it.next());
                                str = "_";
                            } else {
                                com.baidu.adp.lib.stats.a ii = com.baidu.tbadk.l.l.ii();
                                ii.c("frame_delta", sb.toString());
                                BdStatisticsManager.getInstance().performance("webview", ii);
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
        if (this.isShowFullScreen && this.bnu != null) {
            runOnUiThread(new Runnable() { // from class: com.baidu.tieba.ad.browser.AdTbWebViewActivity.7
                @Override // java.lang.Runnable
                public void run() {
                    AdTbWebViewActivity.this.bnu.setFullScreen();
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
            if (AdTbWebViewActivity.this.bnw != null) {
                AdTbWebViewActivity.this.mUrl = str;
                AdTbWebViewActivity.this.bnw.loadUrl("javascript:window.local_obj.getIfFullScreen(document.getElementsByName(\"fc_fullscreen\")[0].content);");
                String title = AdTbWebViewActivity.this.bnw.getTitle();
                if (!StringUtils.isNull(title)) {
                    AdTbWebViewActivity.this.mUrlTitle = title;
                }
                if (!AdTbWebViewActivity.this.isShowFullScreen) {
                    AdTbWebViewActivity.this.bnu.cW(AdTbWebViewActivity.this.mUrlTitle);
                }
                AdTbWebViewActivity.this.bnu.setNavBarVisibility(AdTbWebViewActivity.this.mIsShowNavBar);
                AdTbWebViewActivity.this.bnu.ag(AdTbWebViewActivity.this.isNeedShowShareItem());
                AdTbWebViewActivity.this.hideProgressBar();
                AdTbWebViewActivity.this.stopLoadTimer();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (AdTbWebViewActivity.this.bnw != null) {
                AdTbWebViewActivity.this.bnw.stopLoading();
                AdTbWebViewActivity.this.stopLoadTimer();
                AdTbWebViewActivity.this.onReceivedError(i);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (AdTbWebViewActivity.this.bnw != null) {
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
            int b = com.baidu.tieba.ad.a.Rh().b(AdTbWebViewActivity.this.getPageContext().getPageActivity(), new String[]{str});
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
                            AdTbWebViewActivity.this.bnu.sA();
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
