package com.baidu.tieba.ad.browser.newstyle;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.URLUtil;
import android.webkit.WebView;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.util.al;
import com.baidu.tieba.R;
import com.baidu.webkit.internal.ETAG;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class AdBaseWebViewActivity extends BaseActivity<AdBaseWebViewActivity> {
    private static final String[] ALLOWED_NATIVE_SCHEME = {"baiduboxapp", "taobao"};
    protected c ggL;
    private al.a mCookieInfo;
    protected boolean mEnableJs;
    protected boolean mIsShowNavBar;
    protected boolean mNeedCookie;
    private String mSource;
    private Timer mTimer;
    protected String mUrl;
    protected String mUrlTitle;
    private final Runnable mRunnable = new Runnable() { // from class: com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AdBaseWebViewActivity.this.refresh();
        }
    };
    protected boolean mAutoChangeStyle = true;
    protected boolean mShareResultToFe = false;
    private HashMap<String, a> mJsInterfaces = null;
    private final Runnable mShareRunnable = new Runnable() { // from class: com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity.2
        @Override // java.lang.Runnable
        public void run() {
            ShareItem createShareContent = AdBaseWebViewActivity.this.createShareContent(null, null, null, null);
            if (createShareContent != null) {
                AdBaseWebViewActivity.this.ggL.showShareDialog(createShareContent);
            }
        }
    };

    /* loaded from: classes.dex */
    interface a {
        Object f(TbPageContext<?> tbPageContext);
    }

    public abstract void addJavascriptInterface(Object obj, String str);

    public abstract View createWebView();

    public abstract View getWebView();

    public abstract void initCookie();

    public abstract void initWebView();

    public abstract void loadUrl(String str);

    public abstract void onReceivedError(int i);

    public abstract void webViewDestory();

    public abstract boolean webViewGoBack();

    @Override // com.baidu.adp.base.BdBaseActivity, android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 555) {
            onReceivedError(-2);
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        initWebView();
        this.ggL = new c(this);
        initData();
        this.ggL.bkC();
        this.ggL.h(new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    AdBaseWebViewActivity.this.showToast(R.string.neterror);
                    return;
                }
                AdBaseWebViewActivity.this.ggL.hideNoDataView();
                AdBaseWebViewActivity.this.refresh();
            }
        });
        this.ggL.jd(this.mIsLogin);
        this.ggL.jd(isNeedShowMenuItem());
        if (!this.ggL.bkA() && UtilHelper.canUseStyleImmersiveSticky()) {
            bh.d(this.ggL.mRoot, R.color.CAM_X0303, false);
        }
        adjustResizeForSoftInput();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mUrl = intent.getStringExtra("tag_url");
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (this.ggL != null) {
            this.ggL.jd(z);
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mUrlTitle = intent.getStringExtra("tag_title");
            this.mUrl = intent.getStringExtra("tag_url");
            if (this.mUrl != null && !this.mUrl.startsWith("http://") && !this.mUrl.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX)) {
                this.mUrl = "http://".concat(this.mUrl);
            }
            this.mNeedCookie = intent.getBooleanExtra("tag_cookie", false);
            this.mEnableJs = intent.getBooleanExtra("tag_enable_js", false);
            this.mIsShowNavBar = intent.getBooleanExtra("tag_navigation_bar", true);
            this.mIsShowNavBar = this.mIsShowNavBar && isNeedShowNavigationBar();
            this.ggL.setNavBarVisibility(this.mIsShowNavBar);
            setUseStyleImmersiveSticky(intent.getBooleanExtra("tag_style_immersive_sticky", true));
            if (TextUtils.isEmpty(this.mUrl)) {
                l.showToast(getPageContext().getPageActivity(), getResources().getString(R.string.url_is_null));
                return;
            }
            if (this.mUrl.contains("useImmersive=0") && "Meizu".equalsIgnoreCase(Build.BRAND)) {
                this.ggL.jf(false);
            }
            this.mHandler.postDelayed(this.mRunnable, 500L);
        }
    }

    public boolean isNeedShowNavigationBar() {
        String[] split;
        if (StringUtils.isNull(this.mUrl)) {
            return true;
        }
        try {
            String query = new URL(this.mUrl).getQuery();
            if (StringUtils.isNull(query) || (split = query.split(ETAG.ITEM_SEPARATOR)) == null) {
                return true;
            }
            for (String str : split) {
                String[] split2 = str.split("=");
                if (split2 != null && split2.length == 2) {
                    String str2 = split2[0];
                    String str3 = split2[1];
                    if ("nonavigationbar".equalsIgnoreCase(str2) && "1".equalsIgnoreCase(str3)) {
                        return false;
                    }
                }
            }
            return true;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return true;
        }
    }

    public boolean isNeedShowShareItem() {
        String[] split;
        if (StringUtils.isNull(this.mUrl)) {
            return true;
        }
        try {
            String query = new URL(this.mUrl).getQuery();
            if (StringUtils.isNull(query) || (split = query.split(ETAG.ITEM_SEPARATOR)) == null) {
                return true;
            }
            for (String str : split) {
                String[] split2 = str.split("=");
                if (split2 != null && split2.length == 2) {
                    String str2 = split2[0];
                    String str3 = split2[1];
                    if ("noshare".equalsIgnoreCase(str2) && "1".equalsIgnoreCase(str3)) {
                        return false;
                    }
                }
            }
            return true;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return true;
        }
    }

    public boolean isNeedShowMenuItem() {
        String[] split;
        if (StringUtils.isNull(this.mUrl)) {
            return true;
        }
        try {
            String query = new URL(this.mUrl).getQuery();
            if (StringUtils.isNull(query) || (split = query.split(ETAG.ITEM_SEPARATOR)) == null) {
                return true;
            }
            for (String str : split) {
                String[] split2 = str.split("=");
                if (split2 != null && split2.length == 2) {
                    String str2 = split2[0];
                    String str3 = split2[1];
                    if ("nomenu".equalsIgnoreCase(str2) && "1".equalsIgnoreCase(str3)) {
                        return false;
                    }
                }
            }
            return true;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (getWebView() != null && getWebView() != null && isNeedUpdateCookie()) {
            initCookie();
            this.mHandler.postDelayed(this.mRunnable, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (getWebView() == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        clearAnimatable();
        clearAnimation();
        dismissAllDialog();
        dismissAllPopupWindow();
        hideListMenu();
        if (this.ggL != null) {
            this.ggL.baM();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.mRunnable);
        }
        if (getWebView() != null) {
            getWebView().setVisibility(8);
        }
        webViewDestory();
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        stopLoadTimer();
        if (this.ggL != null) {
            this.ggL.release();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        super.releaseResouce();
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        setResult(-1);
        super.finish();
    }

    public void refresh() {
        hideCrashTip();
        if (URLUtil.isNetworkUrl(this.mUrl)) {
            showProgressBar();
            loadUrl(this.mUrl);
            return;
        }
        Intent parseIntentFromUrl = parseIntentFromUrl(getApplicationContext(), this.mUrl);
        if (parseIntentFromUrl != null) {
            try {
                startActivity(parseIntentFromUrl);
            } catch (Throwable th) {
            }
        }
    }

    private Intent parseIntentFromUrl(Context context, String str) {
        Uri parse;
        boolean z = false;
        if (context == null || str == null || (parse = Uri.parse(str)) == null) {
            return null;
        }
        String scheme = parse.getScheme();
        String[] strArr = ALLOWED_NATIVE_SCHEME;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            } else if (!strArr[i].equals(scheme)) {
                i++;
            } else {
                z = true;
                break;
            }
        }
        if (z) {
            Intent intent = new Intent();
            intent.setData(parse);
            try {
                if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
                    intent = null;
                }
                return intent;
            } catch (Throwable th) {
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void callHiddenWebViewMethod(String str) {
        if (getWebView() != null) {
            try {
                WebView.class.getMethod(str, new Class[0]).invoke(getWebView(), new Object[0]);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ShareItem createShareContent(String str, String str2, String str3, String str4) {
        ShareItem shareItem = new ShareItem();
        if (StringUtils.isNull(this.mUrlTitle, true)) {
            shareItem.title = getResources().getString(R.string.share_from_tieba);
        } else {
            shareItem.title = this.mUrlTitle;
        }
        shareItem.linkUrl = this.mUrl;
        if (StringUtils.isNull(this.mSource, true)) {
            shareItem.content = this.mUrl;
        } else {
            String findSubString = findSubString("<meta name=\"description\" content=\"", "\"");
            if (StringUtils.isNull(findSubString, true)) {
                shareItem.content = this.mUrl;
            } else {
                shareItem.content = findSubString;
            }
            String findSubString2 = findSubString("<img src=\"", "\"");
            if (!StringUtils.isNull(findSubString2, true)) {
                shareItem.imageUri = Uri.parse(findSubString2);
            }
            String findSubString3 = findSubString("<meta name=\"shareurl\" content=\"", "\"");
            if (!StringUtils.isNull(findSubString3, true)) {
                shareItem.linkUrl = findSubString3;
            }
        }
        if (!TextUtils.isEmpty(str)) {
            shareItem.title = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            shareItem.linkUrl = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            shareItem.content = str3;
        }
        if (!TextUtils.isEmpty(str4)) {
            shareItem.imageUri = Uri.parse(str4);
        }
        return shareItem;
    }

    private String findSubString(String str, String str2) {
        int indexOf;
        if (StringUtils.isNull(str, true) || StringUtils.isNull(str2, true) || (indexOf = this.mSource.indexOf(str)) < 0) {
            return null;
        }
        String substring = this.mSource.substring(indexOf + str.length(), this.mSource.length());
        int indexOf2 = substring.indexOf(str2);
        if (indexOf2 >= 0) {
            return substring.substring(0, indexOf2);
        }
        return null;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == R.id.webview_more_pop_item_share_friend_layout) {
            this.ggL.baM();
            loadUrl("javascript:window.local_obj.getSource(document.getElementsByTagName('html')[0].innerHTML);");
            e.mA().post(this.mShareRunnable);
            this.mShareResultToFe = true;
        } else if (id == R.id.webview_more_pop_item_open_browser_layout) {
            this.ggL.baM();
            com.baidu.tieba.ad.browser.a.startExternWebActivity(getPageContext().getPageActivity(), this.mUrl);
        } else if (id == R.id.webview_more_pop_item_copy_link_layout) {
            this.ggL.baM();
            com.baidu.adp.lib.util.a.copyToClipboard(this.mUrl);
            l.showToast(view.getContext(), view.getResources().getString(R.string.copy_pb_url_success));
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        webViewGoBack();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && webViewGoBack()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startLoadTimer() {
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer.purge();
        }
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() { // from class: com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Message message = new Message();
                message.what = BaseWebViewActivity.TIME_OUT_MSG_CODE;
                AdBaseWebViewActivity.this.mHandler.sendMessage(message);
                if (AdBaseWebViewActivity.this.mTimer != null) {
                    AdBaseWebViewActivity.this.mTimer.cancel();
                    AdBaseWebViewActivity.this.mTimer.purge();
                }
            }
        }, 15000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void stopLoadTimer() {
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer.purge();
            this.mTimer = null;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (!this.mAutoChangeStyle) {
            i = 0;
        }
        this.ggL.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showProgressBar() {
        this.ggL.showProgressBar();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void hideProgressBar() {
        this.ggL.hideProgressBar();
    }

    public void hideCrashTip() {
        this.ggL.hideCrashTip();
    }

    public void showNoDataView() {
        this.ggL.showNoDataView();
    }

    @JavascriptInterface
    public void addJavascriptInterface() {
        if (this.mJsInterfaces == null) {
            this.mJsInterfaces = new HashMap<>();
        }
        for (String str : this.mJsInterfaces.keySet()) {
            addJavascriptInterface(this.mJsInterfaces.get(str).f(getPageContext()), str);
        }
        addJavascriptInterface(new InJavaScriptLocalObj(), "local_obj");
    }

    private boolean isNeedUpdateCookie() {
        boolean z;
        String str = "";
        String str2 = "";
        a.b zH = com.baidu.tbadk.core.a.a.bkU().zH(TbadkCoreApplication.getCurrentBduss());
        if (zH != null) {
            if (zH.mBduss != null) {
                str = zH.mBduss;
            }
            if (zH.mPtoken != null) {
                str2 = zH.mPtoken;
            }
        }
        al.a aVar = new al.a(str, str2);
        if (this.mCookieInfo != null && (this.mCookieInfo == null || !this.mCookieInfo.equals(aVar))) {
            z = true;
        } else {
            z = false;
        }
        this.mCookieInfo = aVar;
        return z;
    }

    protected void setFullScreen() {
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.WEBVIEW;
    }

    /* loaded from: classes.dex */
    final class InJavaScriptLocalObj {
        InJavaScriptLocalObj() {
        }

        @JavascriptInterface
        public void getSource(String str) {
            AdBaseWebViewActivity.this.mSource = str;
        }

        @JavascriptInterface
        public void getIfFullScreen(String str) {
            if ("yes".equals(str)) {
                AdBaseWebViewActivity.this.setFullScreen();
            }
        }
    }
}
