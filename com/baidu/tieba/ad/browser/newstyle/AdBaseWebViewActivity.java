package com.baidu.tieba.ad.browser.newstyle;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.URLUtil;
import android.webkit.WebView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import d.b.h0.r.l.a;
import d.b.h0.z0.n0;
import d.b.i0.s2.w;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes4.dex */
public abstract class AdBaseWebViewActivity extends BaseActivity<AdBaseWebViewActivity> {
    public static final String BOOLEAN_VALUE_CONFIG = "1";
    public static final String KEY_FOR_NATIVE_CHECK = "enable_tieba_native_open";
    public static final String KEY_INSTALL_PLUGIN_DIALOG_CLOSED = "install_plugin_dialog_closed";
    public static final String KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME = "install_plugin_dialog_shown_time";
    public static final String KEY_NO_MENU = "nomenu";
    public static final String KEY_NO_NAVIGATIONBAR = "nonavigationbar";
    public static final String KEY_NO_SHARE = "noshare";
    public static final String SHARE_CONTENT_START = "<meta name=\"description\" content=\"";
    public static final String SHARE_END = "\"";
    public static final String SHARE_IMG_START = "<img src=\"";
    public static final String SHARE_URL_START = "<meta name=\"shareurl\" content=\"";
    public static final String TAG = "WebViewActivity";
    public static final int TIME_OUT_MSG_CODE = 555;
    public static final int URL_LOAD_TIME_OUT = 15000;
    public static final int URL_NOT_FOUND_ERROR_CODE = -2;
    public String mAdExtInfo;
    public n0.b mCookieInfo;
    public String mDeeplink;
    public boolean mEnableJs;
    public boolean mIsShowNavBar;
    public boolean mNeedCookie;
    public String mSource;
    public Timer mTimer;
    public String mUrl;
    public String mUrlTitle;
    public d.b.i0.o.c.b.c mView;
    public final Runnable mRunnable = new a();
    public boolean mAutoChangeStyle = true;
    public boolean mShareResultToFe = false;
    public HashMap<String, e> mJsInterfaces = null;
    public final Runnable mShareRunnable = new b();

    /* loaded from: classes4.dex */
    public final class InJavaScriptLocalObj {
        public InJavaScriptLocalObj() {
        }

        @JavascriptInterface
        public void getIfFullScreen(String str) {
            if ("yes".equals(str)) {
                AdBaseWebViewActivity.this.setFullScreen();
            }
        }

        @JavascriptInterface
        public void getSource(String str) {
            AdBaseWebViewActivity.this.mSource = str;
        }
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AdBaseWebViewActivity.this.refresh();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ShareItem createShareContent = AdBaseWebViewActivity.this.createShareContent(null, null, null, null);
            if (createShareContent != null) {
                AdBaseWebViewActivity.this.mView.D(createShareContent);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.z()) {
                AdBaseWebViewActivity.this.showToast(R.string.neterror);
                return;
            }
            AdBaseWebViewActivity.this.mView.g();
            AdBaseWebViewActivity.this.refresh();
        }
    }

    /* loaded from: classes4.dex */
    public class d extends TimerTask {
        public d() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Message message = new Message();
            message.what = 555;
            AdBaseWebViewActivity.this.mHandler.sendMessage(message);
            if (AdBaseWebViewActivity.this.mTimer != null) {
                AdBaseWebViewActivity.this.mTimer.cancel();
                AdBaseWebViewActivity.this.mTimer.purge();
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        Object a(TbPageContext<?> tbPageContext);
    }

    private String findSubString(String str, String str2) {
        int indexOf;
        if (StringUtils.isNull(str, true) || StringUtils.isNull(str2, true) || (indexOf = this.mSource.indexOf(str)) < 0) {
            return null;
        }
        String substring = this.mSource.substring(indexOf + str.length());
        int indexOf2 = substring.indexOf(str2);
        if (indexOf2 < 0) {
            return null;
        }
        return substring.substring(0, indexOf2);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        this.mUrlTitle = intent.getStringExtra(WebViewActivityConfig.TAG_TITLE);
        String stringExtra = intent.getStringExtra(WebViewActivityConfig.TAG_URL);
        this.mUrl = stringExtra;
        if (stringExtra != null && !stringExtra.startsWith("http://") && !this.mUrl.startsWith("https://")) {
            this.mUrl = "http://".concat(this.mUrl);
        }
        this.mNeedCookie = intent.getBooleanExtra(WebViewActivityConfig.TAG_COOKIE, false);
        this.mEnableJs = intent.getBooleanExtra(WebViewActivityConfig.TAG_ENABLE_JS, false);
        this.mIsShowNavBar = intent.getBooleanExtra(WebViewActivityConfig.TAG_NAV_BAR, true);
        this.mAdExtInfo = intent.getStringExtra(WebViewActivityConfig.TAG_AD_EXT_INFO);
        this.mDeeplink = intent.getStringExtra(WebViewActivityConfig.TAG_AD_DEEPLINK_URL);
        boolean z = this.mIsShowNavBar && isNeedShowNavigationBar();
        this.mIsShowNavBar = z;
        this.mView.v(z);
        setUseStyleImmersiveSticky(intent.getBooleanExtra(WebViewActivityConfig.TAG_NEED_STYLE_IMMERSIVE_STICKY, true));
        if (TextUtils.isEmpty(this.mUrl)) {
            l.L(getPageContext().getPageActivity(), getResources().getString(R.string.url_is_null));
            return;
        }
        if (this.mUrl.contains("useImmersive=0") && "Meizu".equalsIgnoreCase(Build.BRAND)) {
            this.mView.z(false);
        }
        this.mHandler.postDelayed(this.mRunnable, 500L);
    }

    private boolean isNeedUpdateCookie() {
        String str;
        a.b d2 = d.b.h0.r.l.a.b().d(TbadkCoreApplication.getCurrentBduss());
        String str2 = "";
        if (d2 != null) {
            String str3 = d2.f51036a;
            if (str3 == null) {
                str3 = "";
            }
            str = d2.f51037b;
            if (str == null) {
                str = "";
            }
            str2 = str3;
        } else {
            str = "";
        }
        boolean z = true;
        n0.b bVar = new n0.b(str2, str);
        n0.b bVar2 = this.mCookieInfo;
        if (bVar2 == null || (bVar2 != null && bVar2.equals(bVar))) {
            z = false;
        }
        this.mCookieInfo = bVar;
        return z;
    }

    @JavascriptInterface
    public void addJavascriptInterface() {
        if (this.mJsInterfaces == null) {
            this.mJsInterfaces = new HashMap<>();
        }
        for (String str : this.mJsInterfaces.keySet()) {
            addJavascriptInterface(this.mJsInterfaces.get(str).a(getPageContext()), str);
        }
        addJavascriptInterface(new InJavaScriptLocalObj(), "local_obj");
    }

    public abstract void addJavascriptInterface(Object obj, String str);

    public void callHiddenWebViewMethod(String str) {
        if (getWebView() != null) {
            try {
                WebView.class.getMethod(str, new Class[0]).invoke(getWebView(), new Object[0]);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public ShareItem createShareContent(String str, String str2, String str3, String str4) {
        ShareItem shareItem = new ShareItem();
        if (StringUtils.isNull(this.mUrlTitle, true)) {
            shareItem.r = getResources().getString(R.string.share_from_tieba);
        } else {
            shareItem.r = this.mUrlTitle;
        }
        shareItem.t = this.mUrl;
        if (StringUtils.isNull(this.mSource, true)) {
            shareItem.s = this.mUrl;
        } else {
            String findSubString = findSubString("<meta name=\"description\" content=\"", "\"");
            if (StringUtils.isNull(findSubString, true)) {
                shareItem.s = this.mUrl;
            } else {
                shareItem.s = findSubString;
            }
            String findSubString2 = findSubString("<img src=\"", "\"");
            if (!StringUtils.isNull(findSubString2, true)) {
                shareItem.v = Uri.parse(findSubString2);
            }
            String findSubString3 = findSubString("<meta name=\"shareurl\" content=\"", "\"");
            if (!StringUtils.isNull(findSubString3, true)) {
                shareItem.t = findSubString3;
            }
        }
        if (!TextUtils.isEmpty(str)) {
            shareItem.r = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            shareItem.t = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            shareItem.s = str3;
        }
        if (!TextUtils.isEmpty(str4)) {
            shareItem.v = Uri.parse(str4);
        }
        return shareItem;
    }

    public abstract View createWebView();

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        setResult(-1);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, d.b.h0.k0.a
    public String getCurrentPageKey() {
        return "a012";
    }

    public abstract View getWebView();

    @Override // com.baidu.adp.base.BdBaseActivity, android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 555) {
            onReceivedError(-2);
            return true;
        }
        return false;
    }

    public void hideCrashTip() {
        this.mView.f();
    }

    public void hideNoDataView() {
        this.mView.g();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void hideProgressBar() {
        this.mView.h();
    }

    public abstract void initCookie();

    public abstract void initWebView();

    public boolean isNeedShowMenuItem() {
        String query;
        String[] split;
        if (StringUtils.isNull(this.mUrl)) {
            return true;
        }
        try {
            query = new URL(this.mUrl).getQuery();
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
        }
        if (StringUtils.isNull(query) || (split = query.split("&")) == null) {
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
    }

    public boolean isNeedShowNavigationBar() {
        String query;
        String[] split;
        if (StringUtils.isNull(this.mUrl)) {
            return true;
        }
        try {
            query = new URL(this.mUrl).getQuery();
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
        }
        if (StringUtils.isNull(query) || (split = query.split("&")) == null) {
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
    }

    public boolean isNeedShowShareItem() {
        String query;
        String[] split;
        if (StringUtils.isNull(this.mUrl)) {
            return true;
        }
        try {
            query = new URL(this.mUrl).getQuery();
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
        }
        if (StringUtils.isNull(query) || (split = query.split("&")) == null) {
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
    }

    public abstract void loadUrl(String str);

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        webViewGoBack();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (!this.mAutoChangeStyle) {
            i = 0;
        }
        this.mView.n(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == R.id.webview_more_pop_item_share_friend_layout) {
            this.mView.d();
            loadUrl("javascript:window.local_obj.getSource(document.getElementsByTagName('html')[0].innerHTML);");
            d.b.c.e.m.e.a().post(this.mShareRunnable);
            this.mShareResultToFe = true;
        } else if (id == R.id.webview_more_pop_item_open_browser_layout) {
            this.mView.d();
            d.b.i0.o.c.a.f(getPageContext().getPageActivity(), this.mUrl);
        } else if (id == R.id.webview_more_pop_item_copy_link_layout) {
            this.mView.d();
            d.b.c.e.p.a.a(this.mUrl);
            l.L(view.getContext(), view.getResources().getString(R.string.copy_pb_url_success));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        initWebView();
        this.mView = new d.b.i0.o.c.b.c(this);
        initData();
        this.mView.k();
        this.mView.x(new c());
        this.mView.u(this.mIsLogin);
        this.mView.u(isNeedShowMenuItem());
        this.mView.s(this.mAdExtInfo);
        this.mView.r(this.mDeeplink);
        if (!this.mView.m() && UtilHelper.canUseStyleImmersiveSticky()) {
            ViewHelper.addStateBarViewSpace(this.mView.f58618a, R.color.CAM_X0303, false);
        }
        adjustResizeForSoftInput();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mRunnable);
        }
        if (getWebView() != null) {
            getWebView().setVisibility(8);
        }
        webViewDestory();
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        stopLoadTimer();
        d.b.i0.o.c.b.c cVar = this.mView;
        if (cVar != null) {
            cVar.p();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && webViewGoBack()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mUrl = intent.getStringExtra(WebViewActivityConfig.TAG_URL);
        refresh();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (getWebView() == null) {
        }
    }

    public abstract void onReceivedError(int i);

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (getWebView() == null || getWebView() == null || !isNeedUpdateCookie()) {
            return;
        }
        initCookie();
        this.mHandler.postDelayed(this.mRunnable, 100L);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        clearAnimatable();
        clearAnimation();
        dismissAllDialog();
        dismissAllPopupWindow();
        hideListMenu();
        d.b.i0.o.c.b.c cVar = this.mView;
        if (cVar != null) {
            cVar.d();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        d.b.i0.o.c.b.c cVar = this.mView;
        if (cVar != null) {
            cVar.u(z);
        }
    }

    public void refresh() {
        hideCrashTip();
        if (URLUtil.isNetworkUrl(this.mUrl)) {
            showProgressBar();
            loadUrl(this.mUrl);
        } else if (tryDeeplink(this.mUrl)) {
        } else {
            loadUrl(this.mUrl);
        }
    }

    public void refreshIgnoreFormat() {
        hideCrashTip();
        showProgressBar();
        loadUrl(this.mUrl);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        super.releaseResouce();
        finish();
    }

    public void setAutoChangeStyle(boolean z) {
        this.mAutoChangeStyle = z;
    }

    public void setFullScreen() {
    }

    public void setNavBarVisibility(boolean z) {
        this.mView.v(z);
    }

    public void showCrashTip() {
        this.mView.A();
    }

    public void showNoDataView() {
        this.mView.B();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showProgressBar() {
        this.mView.C();
    }

    public void startLoadTimer() {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer.purge();
        }
        this.mTimer = new Timer();
        this.mTimer.schedule(new d(), 15000L);
    }

    public void stopLoadTimer() {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer.purge();
            this.mTimer = null;
        }
    }

    public boolean tryDeeplink(String str) {
        return w.y(str, getApplicationContext());
    }

    public abstract void webViewDestory();

    public abstract boolean webViewGoBack();

    public void finish(int i, Intent intent) {
        setResult(i, intent);
        super.finish();
    }
}
