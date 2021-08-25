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
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.p0.b1.t0;
import c.a.p0.s.l.a;
import c.a.q0.x2.z;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes6.dex */
public abstract class AdBaseWebViewActivity extends BaseActivity<AdBaseWebViewActivity> {
    public static /* synthetic */ Interceptable $ic = null;
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
    public static final List<String> WITHE_LIST;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isWitheList;
    public String mAdExtInfo;
    public boolean mAutoChangeStyle;
    public t0.b mCookieInfo;
    public String mDeeplink;
    public boolean mEnableJs;
    public boolean mIsShowNavBar;
    public HashMap<String, e> mJsInterfaces;
    public boolean mNeedCookie;
    public String mOriginUrl;
    public final Runnable mRunnable;
    public boolean mShareResultToFe;
    public final Runnable mShareRunnable;
    public String mSource;
    public Timer mTimer;
    public String mUrl;
    public String mUrlTitle;
    public c.a.q0.q.c.b.c mView;

    /* loaded from: classes6.dex */
    public final class InJavaScriptLocalObj {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseWebViewActivity this$0;

        public InJavaScriptLocalObj(AdBaseWebViewActivity adBaseWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adBaseWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = adBaseWebViewActivity;
        }

        @JavascriptInterface
        public void getIfFullScreen(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && "yes".equals(str)) {
                this.this$0.setFullScreen();
            }
        }

        @JavascriptInterface
        public void getSource(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.this$0.mSource = str;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdBaseWebViewActivity f49000e;

        public a(AdBaseWebViewActivity adBaseWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adBaseWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49000e = adBaseWebViewActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f49000e.refresh();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdBaseWebViewActivity f49001e;

        public b(AdBaseWebViewActivity adBaseWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adBaseWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49001e = adBaseWebViewActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            ShareItem createShareContent;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (createShareContent = this.f49001e.createShareContent(null, null, null, null)) == null) {
                return;
            }
            this.f49001e.mView.G(createShareContent);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdBaseWebViewActivity f49002e;

        public c(AdBaseWebViewActivity adBaseWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adBaseWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49002e = adBaseWebViewActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!j.z()) {
                    this.f49002e.showToast(R.string.neterror);
                    return;
                }
                this.f49002e.mView.h();
                this.f49002e.refresh();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdBaseWebViewActivity f49003e;

        public d(AdBaseWebViewActivity adBaseWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adBaseWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49003e = adBaseWebViewActivity;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Message message = new Message();
                message.what = 555;
                this.f49003e.mHandler.sendMessage(message);
                if (this.f49003e.mTimer != null) {
                    this.f49003e.mTimer.cancel();
                    this.f49003e.mTimer.purge();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface e {
        Object a(TbPageContext<?> tbPageContext);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1462604800, "Lcom/baidu/tieba/ad/browser/newstyle/AdBaseWebViewActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1462604800, "Lcom/baidu/tieba/ad/browser/newstyle/AdBaseWebViewActivity;");
                return;
            }
        }
        WITHE_LIST = new ArrayList<String>() { // from class: com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                add("https://cover.baidu.com");
                add("http://cover.baidu.com");
            }
        };
    }

    public AdBaseWebViewActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mRunnable = new a(this);
        this.mAutoChangeStyle = true;
        this.mShareResultToFe = false;
        this.mJsInterfaces = null;
        this.mShareRunnable = new b(this);
        this.isWitheList = false;
    }

    private String findSubString(String str, String str2) {
        InterceptResult invokeLL;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, str2)) == null) {
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
        return (String) invokeLL.objValue;
    }

    private void initData() {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) || (intent = getIntent()) == null) {
            return;
        }
        this.mUrlTitle = intent.getStringExtra(WebViewActivityConfig.TAG_TITLE);
        this.mUrl = intent.getStringExtra(WebViewActivityConfig.TAG_URL);
        this.mOriginUrl = intent.getStringExtra(WebViewActivityConfig.TAG_URL);
        String str = this.mUrl;
        if (str != null && !str.startsWith("http://") && !this.mUrl.startsWith("https://")) {
            this.mUrl = "http://".concat(this.mUrl);
        }
        if (needHideDownloadWarning(this.mUrl)) {
            this.mView.u(false);
        }
        this.mNeedCookie = intent.getBooleanExtra(WebViewActivityConfig.TAG_COOKIE, false);
        this.mEnableJs = intent.getBooleanExtra(WebViewActivityConfig.TAG_ENABLE_JS, false);
        this.mIsShowNavBar = intent.getBooleanExtra(WebViewActivityConfig.TAG_NAV_BAR, true);
        this.mAdExtInfo = intent.getStringExtra(WebViewActivityConfig.TAG_AD_EXT_INFO);
        this.mDeeplink = intent.getStringExtra(WebViewActivityConfig.TAG_AD_DEEPLINK_URL);
        boolean z = this.mIsShowNavBar && isNeedShowNavigationBar();
        this.mIsShowNavBar = z;
        this.mView.y(z);
        setUseStyleImmersiveSticky(intent.getBooleanExtra(WebViewActivityConfig.TAG_NEED_STYLE_IMMERSIVE_STICKY, true));
        if (TextUtils.isEmpty(this.mUrl)) {
            l.M(getPageContext().getPageActivity(), getResources().getString(R.string.url_is_null));
            return;
        }
        if (this.mUrl.contains("useImmersive=0") && "Meizu".equalsIgnoreCase(Build.BRAND)) {
            this.mView.C(false);
        }
        this.mHandler.postDelayed(this.mRunnable, 500L);
    }

    private boolean isNeedUpdateCookie() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            a.b d2 = c.a.p0.s.l.a.b().d(TbadkCoreApplication.getCurrentBduss());
            String str2 = "";
            if (d2 != null) {
                String str3 = d2.f14045a;
                if (str3 == null) {
                    str3 = "";
                }
                str = d2.f14046b;
                if (str == null) {
                    str = "";
                }
                str2 = str3;
            } else {
                str = "";
            }
            boolean z = true;
            t0.b bVar = new t0.b(str2, str);
            t0.b bVar2 = this.mCookieInfo;
            if (bVar2 == null || (bVar2 != null && bVar2.equals(bVar))) {
                z = false;
            }
            this.mCookieInfo = bVar;
            return z;
        }
        return invokeV.booleanValue;
    }

    @JavascriptInterface
    public void addJavascriptInterface() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.mJsInterfaces == null) {
                this.mJsInterfaces = new HashMap<>();
            }
            for (String str : this.mJsInterfaces.keySet()) {
                addJavascriptInterface(this.mJsInterfaces.get(str).a(getPageContext()), str);
            }
            addJavascriptInterface(new InJavaScriptLocalObj(this), "local_obj");
        }
    }

    public abstract void addJavascriptInterface(Object obj, String str);

    public void callHiddenWebViewMethod(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || getWebView() == null) {
            return;
        }
        try {
            WebView.class.getMethod(str, new Class[0]).invoke(getWebView(), new Object[0]);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public ShareItem createShareContent(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, str, str2, str3, str4)) == null) {
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
        return (ShareItem) invokeLLLL.objValue;
    }

    public abstract View createWebView();

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setResult(-1);
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, c.a.p0.m0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "a012" : (String) invokeV.objValue;
    }

    public abstract View getWebView();

    @Override // com.baidu.adp.base.BdBaseActivity, android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, message)) == null) {
            if (message.what == 555) {
                onReceivedError(-2);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void hideCrashTip() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.mView.g();
        }
    }

    public void hideNoDataView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.mView.h();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void hideProgressBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.mView.i();
        }
    }

    public abstract void initCookie();

    public abstract void initWebView();

    public boolean isNeedShowMenuItem() {
        InterceptResult invokeV;
        String query;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
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
        return invokeV.booleanValue;
    }

    public boolean isNeedShowNavigationBar() {
        InterceptResult invokeV;
        String query;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
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
        return invokeV.booleanValue;
    }

    public boolean isNeedShowShareItem() {
        InterceptResult invokeV;
        String query;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
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
        return invokeV.booleanValue;
    }

    public abstract void loadUrl(String str);

    public boolean needHideDownloadWarning(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (c.a.q0.a.h().A()) {
                return true;
            }
            for (String str2 : WITHE_LIST) {
                if (str.startsWith(str2)) {
                    this.isWitheList = true;
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onBackPressed();
            webViewGoBack();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (!this.mAutoChangeStyle) {
                i2 = 0;
            }
            this.mView.o(i2);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, view) == null) {
            super.onClick(view);
            int id = view.getId();
            if (id == R.id.webview_more_pop_item_share_friend_layout) {
                this.mView.e();
                loadUrl("javascript:window.local_obj.getSource(document.getElementsByTagName('html')[0].innerHTML);");
                c.a.e.e.m.e.a().post(this.mShareRunnable);
                this.mShareResultToFe = true;
            } else if (id == R.id.webview_more_pop_item_open_browser_layout) {
                this.mView.e();
                c.a.q0.q.c.a.f(getPageContext().getPageActivity(), this.mUrl);
            } else if (id == R.id.webview_more_pop_item_copy_link_layout) {
                this.mView.e();
                c.a.e.e.p.a.a(this.mUrl);
                l.M(view.getContext(), view.getResources().getString(R.string.copy_pb_url_success));
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bundle) == null) {
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            initWebView();
            this.mView = new c.a.q0.q.c.b.c(this);
            initData();
            this.mView.l();
            this.mView.A(new c(this));
            this.mView.x(this.mIsLogin);
            this.mView.x(isNeedShowMenuItem());
            this.mView.v(this.mAdExtInfo);
            this.mView.t(this.mDeeplink);
            if (!this.mView.n() && UtilHelper.canUseStyleImmersiveSticky()) {
                ViewHelper.addStateBarViewSpace(this.mView.f23563a, R.color.CAM_X0303, false);
            }
            adjustResizeForSoftInput();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
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
            c.a.q0.q.c.b.c cVar = this.mView;
            if (cVar != null) {
                cVar.r();
            }
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048601, this, i2, keyEvent)) == null) {
            if (i2 == 4 && webViewGoBack()) {
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        c.a.q0.q.c.b.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, intent) == null) {
            super.onNewIntent(intent);
            this.mUrl = intent.getStringExtra(WebViewActivityConfig.TAG_URL);
            this.mOriginUrl = intent.getStringExtra(WebViewActivityConfig.TAG_URL);
            if (needHideDownloadWarning(this.mUrl) && (cVar = this.mView) != null) {
                cVar.u(false);
            }
            refresh();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onPause();
            if (getWebView() == null) {
            }
        }
    }

    public abstract void onReceivedError(int i2);

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.onResume();
            if (getWebView() == null || getWebView() == null || !isNeedUpdateCookie()) {
                return;
            }
            initCookie();
            this.mHandler.postDelayed(this.mRunnable, 100L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.onStop();
            clearAnimatable();
            clearAnimation();
            dismissAllDialog();
            dismissAllPopupWindow();
            hideListMenu();
            c.a.q0.q.c.b.c cVar = this.mView;
            if (cVar != null) {
                cVar.e();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            super.onUserChanged(z);
            c.a.q0.q.c.b.c cVar = this.mView;
            if (cVar != null) {
                cVar.x(z);
            }
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            hideCrashTip();
            if (URLUtil.isNetworkUrl(this.mUrl)) {
                showProgressBar();
                loadUrl(this.mUrl);
            } else if (tryDeeplink(this.mUrl)) {
            } else {
                loadUrl(this.mUrl);
            }
        }
    }

    public void refreshIgnoreFormat() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            hideCrashTip();
            showProgressBar();
            loadUrl(this.mUrl);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            super.releaseResouce();
            finish();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.mAutoChangeStyle = z;
        }
    }

    public void setFullScreen() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
        }
    }

    public void setNavBarVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.mView.y(z);
        }
    }

    public void showCrashTip() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.mView.D();
        }
    }

    public void showNoDataView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.mView.E();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showProgressBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.mView.F();
        }
    }

    public void startLoadTimer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            Timer timer = this.mTimer;
            if (timer != null) {
                timer.cancel();
                this.mTimer.purge();
            }
            this.mTimer = new Timer();
            this.mTimer.schedule(new d(this), 15000L);
        }
    }

    public void stopLoadTimer() {
        Timer timer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048618, this) == null) || (timer = this.mTimer) == null) {
            return;
        }
        timer.cancel();
        this.mTimer.purge();
        this.mTimer = null;
    }

    public boolean tryDeeplink(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, str)) == null) ? z.y(str, getApplicationContext()) : invokeL.booleanValue;
    }

    public abstract void webViewDestory();

    public abstract boolean webViewGoBack();

    public void finish(int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i2, intent) == null) {
            setResult(i2, intent);
            super.finish();
        }
    }
}
