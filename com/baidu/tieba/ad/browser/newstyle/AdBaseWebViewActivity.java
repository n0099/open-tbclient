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
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.cq5;
import com.baidu.tieba.dx5;
import com.baidu.tieba.ej;
import com.baidu.tieba.fw4;
import com.baidu.tieba.fx5;
import com.baidu.tieba.gh;
import com.baidu.tieba.lu5;
import com.baidu.tieba.rs8;
import com.baidu.tieba.ui;
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
/* loaded from: classes3.dex */
public abstract class AdBaseWebViewActivity extends BaseActivity<AdBaseWebViewActivity> {
    public static /* synthetic */ Interceptable $ic;
    public static final List<String> s;
    public transient /* synthetic */ FieldHolder $fh;
    public fx5 a;
    public String b;
    public final Runnable c;
    public String d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public HashMap<String, e> j;
    public String k;
    public final Runnable l;
    public cq5.b m;
    public Timer n;
    public String o;
    public String p;
    public String q;
    public boolean r;

    /* loaded from: classes3.dex */
    public interface e {
        Object a(TbPageContext<?> tbPageContext);
    }

    public abstract void addJavascriptInterface(Object obj, String str);

    public abstract View createWebView();

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tieba.vj5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "a012" : (String) invokeV.objValue;
    }

    public abstract View getWebView();

    public abstract void initCookie();

    public abstract void initWebView();

    public abstract void loadUrl(String str);

    public abstract void onReceivedError(int i);

    public void setFullScreen() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
        }
    }

    public abstract void webViewDestory();

    public abstract boolean webViewGoBack();

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) {
                return;
            }
            this.this$0.k = str;
        }
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseWebViewActivity a;

        public a(AdBaseWebViewActivity adBaseWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adBaseWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adBaseWebViewActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.refresh();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseWebViewActivity a;

        public b(AdBaseWebViewActivity adBaseWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adBaseWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adBaseWebViewActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            ShareItem createShareContent;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (createShareContent = this.a.createShareContent(null, null, null, null)) != null) {
                this.a.a.A(createShareContent);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseWebViewActivity a;

        public c(AdBaseWebViewActivity adBaseWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adBaseWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adBaseWebViewActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0d08);
                    return;
                }
                this.a.a.f();
                this.a.refresh();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseWebViewActivity a;

        public d(AdBaseWebViewActivity adBaseWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adBaseWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adBaseWebViewActivity;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Message message = new Message();
                message.what = BaseWebViewActivity.TIME_OUT_MSG_CODE;
                this.a.mHandler.sendMessage(message);
                if (this.a.n != null) {
                    this.a.n.cancel();
                    this.a.n.purge();
                }
            }
        }
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
        s = new ArrayList<String>() { // from class: com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
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

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            setResult(-1);
            super.finish();
        }
    }

    public void hideCrashTip() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.a.e();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void hideProgressBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.a.g();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onBackPressed();
            webViewGoBack();
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

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.onResume();
            if (getWebView() != null && getWebView() != null && isNeedUpdateCookie()) {
                initCookie();
                this.mHandler.postDelayed(this.c, 100L);
            }
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
            fx5 fx5Var = this.a;
            if (fx5Var != null) {
                fx5Var.c();
            }
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            hideCrashTip();
            if (URLUtil.isNetworkUrl(this.b)) {
                showProgressBar();
                loadUrl(this.b);
            } else if (!z1(this.b)) {
                loadUrl(this.b);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            super.releaseResouce();
            finish();
        }
    }

    public void showNoDataView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.a.y();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showProgressBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.a.z();
        }
    }

    public void startLoadTimer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            Timer timer = this.n;
            if (timer != null) {
                timer.cancel();
                this.n.purge();
            }
            this.n = new Timer();
            this.n.schedule(new d(this), 15000L);
        }
    }

    public void stopLoadTimer() {
        Timer timer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && (timer = this.n) != null) {
            timer.cancel();
            this.n.purge();
            this.n = null;
        }
    }

    public AdBaseWebViewActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new a(this);
        this.h = true;
        this.j = null;
        this.l = new b(this);
        this.r = false;
    }

    public final boolean isNeedUpdateCookie() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            fw4.b c2 = fw4.b().c(TbadkCoreApplication.getCurrentBduss());
            String str2 = "";
            if (c2 == null) {
                str = "";
            } else {
                String str3 = c2.a;
                if (str3 == null) {
                    str3 = "";
                }
                str = c2.b;
                if (str == null) {
                    str = "";
                }
                str2 = str3;
            }
            boolean z = true;
            cq5.b bVar = new cq5.b(str2, str);
            cq5.b bVar2 = this.m;
            if (bVar2 == null || (bVar2 != null && bVar2.equals(bVar))) {
                z = false;
            }
            this.m = bVar;
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.removeCallbacks(this.c);
            }
            if (getWebView() != null) {
                getWebView().setVisibility(8);
            }
            webViewDestory();
            TbadkCoreApplication.getInst().delRemoteActivity(this);
            stopLoadTimer();
            fx5 fx5Var = this.a;
            if (fx5Var != null) {
                fx5Var.n();
            }
            super.onDestroy();
        }
    }

    public void callHiddenWebViewMethod(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && getWebView() != null) {
            try {
                WebView.class.getMethod(str, new Class[0]).invoke(getWebView(), new Object[0]);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

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

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            super.onChangeSkinType(i);
            if (!this.h) {
                i = 0;
            }
            this.a.l(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            super.onUserChanged(z);
            fx5 fx5Var = this.a;
            if (fx5Var != null) {
                fx5Var.s(z);
            }
        }
    }

    public boolean z1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, str)) == null) {
            return rs8.l(str, getApplicationContext());
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048601, this, i, keyEvent)) == null) {
            if (i == 4 && webViewGoBack()) {
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @JavascriptInterface
    public void addJavascriptInterface() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.j == null) {
                this.j = new HashMap<>();
            }
            for (String str : this.j.keySet()) {
                addJavascriptInterface(this.j.get(str).a(getPageContext()), str);
            }
            addJavascriptInterface(new InJavaScriptLocalObj(this), "local_obj");
        }
    }

    public ShareItem createShareContent(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, str, str2, str3, str4)) == null) {
            ShareItem shareItem = new ShareItem();
            if (StringUtils.isNull(this.d, true)) {
                shareItem.v = getResources().getString(R.string.share_from_tieba);
            } else {
                shareItem.v = this.d;
            }
            shareItem.x = this.b;
            if (StringUtils.isNull(this.k, true)) {
                shareItem.w = this.b;
            } else {
                String findSubString = findSubString(BaseWebViewActivity.SHARE_CONTENT_START, "\"");
                if (StringUtils.isNull(findSubString, true)) {
                    shareItem.w = this.b;
                } else {
                    shareItem.w = findSubString;
                }
                String findSubString2 = findSubString(BaseWebViewActivity.SHARE_IMG_START, "\"");
                if (!StringUtils.isNull(findSubString2, true)) {
                    shareItem.z = Uri.parse(findSubString2);
                }
                String findSubString3 = findSubString(BaseWebViewActivity.SHARE_URL_START, "\"");
                if (!StringUtils.isNull(findSubString3, true)) {
                    shareItem.x = findSubString3;
                }
            }
            if (!TextUtils.isEmpty(str)) {
                shareItem.v = str;
            }
            if (!TextUtils.isEmpty(str2)) {
                shareItem.x = str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                shareItem.w = str3;
            }
            if (!TextUtils.isEmpty(str4)) {
                shareItem.z = Uri.parse(str4);
            }
            return shareItem;
        }
        return (ShareItem) invokeLLLL.objValue;
    }

    public final String findSubString(String str, String str2) {
        InterceptResult invokeLL;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            if (StringUtils.isNull(str, true) || StringUtils.isNull(str2, true) || (indexOf = this.k.indexOf(str)) < 0) {
                return null;
            }
            String substring = this.k.substring(indexOf + str.length());
            int indexOf2 = substring.indexOf(str2);
            if (indexOf2 < 0) {
                return null;
            }
            return substring.substring(0, indexOf2);
        }
        return (String) invokeLL.objValue;
    }

    public final void initData() {
        Intent intent;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || (intent = getIntent()) == null) {
            return;
        }
        this.d = intent.getStringExtra(WebViewActivityConfig.TAG_TITLE);
        this.b = intent.getStringExtra(WebViewActivityConfig.TAG_URL);
        this.q = intent.getStringExtra(WebViewActivityConfig.TAG_URL);
        String str = this.b;
        if (str != null && !str.startsWith("http://") && !this.b.startsWith("https://")) {
            this.b = "http://".concat(this.b);
        }
        if (y1(this.b)) {
            this.a.q(false);
        }
        this.e = intent.getBooleanExtra(WebViewActivityConfig.TAG_COOKIE, false);
        this.f = intent.getBooleanExtra(WebViewActivityConfig.TAG_ENABLE_JS, false);
        this.g = intent.getBooleanExtra(WebViewActivityConfig.TAG_NAV_BAR, true);
        this.o = intent.getStringExtra(WebViewActivityConfig.TAG_AD_EXT_INFO);
        this.p = intent.getStringExtra(WebViewActivityConfig.TAG_AD_DEEPLINK_URL);
        if (this.g && isNeedShowNavigationBar()) {
            z = true;
        } else {
            z = false;
        }
        this.g = z;
        this.a.t(z);
        setUseStyleImmersiveSticky(intent.getBooleanExtra(WebViewActivityConfig.TAG_NEED_STYLE_IMMERSIVE_STICKY, true));
        if (TextUtils.isEmpty(this.b)) {
            ej.Q(getPageContext().getPageActivity(), getResources().getString(R.string.url_is_null));
            return;
        }
        if (this.b.contains("useImmersive=0") && "Meizu".equalsIgnoreCase(Build.BRAND)) {
            this.a.x(false);
        }
        this.mHandler.postDelayed(this.c, 500L);
    }

    public boolean isNeedShowMenuItem() {
        InterceptResult invokeV;
        String query;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (StringUtils.isNull(this.b)) {
                return true;
            }
            try {
                query = new URL(this.b).getQuery();
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
                    if (BaseWebViewActivity.KEY_NO_MENU.equalsIgnoreCase(str2) && "1".equalsIgnoreCase(str3)) {
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
            if (StringUtils.isNull(this.b)) {
                return true;
            }
            try {
                query = new URL(this.b).getQuery();
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
                    if (BaseWebViewActivity.KEY_NO_NAVIGATIONBAR.equalsIgnoreCase(str2) && "1".equalsIgnoreCase(str3)) {
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
            if (StringUtils.isNull(this.b)) {
                return true;
            }
            try {
                query = new URL(this.b).getQuery();
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
                    if (BaseWebViewActivity.KEY_NO_SHARE.equalsIgnoreCase(str2) && "1".equalsIgnoreCase(str3)) {
                        return false;
                    }
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, view2) == null) {
            super.onClick(view2);
            int id = view2.getId();
            if (id == R.id.webview_more_pop_item_share_friend_layout) {
                this.a.c();
                loadUrl("javascript:window.local_obj.getSource(document.getElementsByTagName('html')[0].innerHTML);");
                gh.a().post(this.l);
            } else if (id == R.id.webview_more_pop_item_open_browser_layout) {
                this.a.c();
                dx5.f(getPageContext().getPageActivity(), this.b);
            } else if (id == R.id.webview_more_pop_item_copy_link_layout) {
                this.a.c();
                ui.a(this.b);
                ej.Q(view2.getContext(), view2.getResources().getString(R.string.copy_pb_url_success));
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
            this.a = new fx5(this);
            initData();
            this.a.i();
            this.a.v(new c(this));
            this.a.s(this.mIsLogin);
            this.a.s(isNeedShowMenuItem());
            this.a.p(this.p);
            if (!this.a.k() && UtilHelper.canUseStyleImmersiveSticky()) {
                ViewHelper.addStateBarViewSpace(this.a.a, R.color.CAM_X0303, false);
            }
            adjustResizeForSoftInput();
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        fx5 fx5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, intent) == null) {
            super.onNewIntent(intent);
            this.b = intent.getStringExtra(WebViewActivityConfig.TAG_URL);
            this.q = intent.getStringExtra(WebViewActivityConfig.TAG_URL);
            if (y1(this.b) && (fx5Var = this.a) != null) {
                fx5Var.q(false);
            }
            refresh();
        }
    }

    public boolean y1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (lu5.a().m()) {
                return true;
            }
            for (String str2 : s) {
                if (str.startsWith(str2)) {
                    this.r = true;
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
