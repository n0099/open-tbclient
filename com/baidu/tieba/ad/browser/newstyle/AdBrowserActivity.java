package com.baidu.tieba.ad.browser.newstyle;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.URLUtil;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.BdStatsItem;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nps.utils.Constant;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.hybrid.NamedBridgeHandler;
import com.baidu.tbadk.core.hybrid.WebViewBridge;
import com.baidu.tbadk.core.hybrid.handlers.ClipboardBridgeHandler;
import com.baidu.tbadk.core.hybrid.handlers.FocusFeedBridgeHandler;
import com.baidu.tbadk.core.hybrid.handlers.ImageOperateBridgeHandler;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.performanceLog.PerformanceLogger;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.view.ApkDownloadView;
import com.baidu.tieba.ad.webview.BaseAdWebView;
import com.baidu.tieba.b85;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.e56;
import com.baidu.tieba.e85;
import com.baidu.tieba.g85;
import com.baidu.tieba.h85;
import com.baidu.tieba.hl0;
import com.baidu.tieba.i85;
import com.baidu.tieba.il0;
import com.baidu.tieba.j56;
import com.baidu.tieba.k56;
import com.baidu.tieba.k81;
import com.baidu.tieba.kj0;
import com.baidu.tieba.l56;
import com.baidu.tieba.ll0;
import com.baidu.tieba.m56;
import com.baidu.tieba.n56;
import com.baidu.tieba.nga;
import com.baidu.tieba.oga;
import com.baidu.tieba.p56;
import com.baidu.tieba.p61;
import com.baidu.tieba.pga;
import com.baidu.tieba.pj0;
import com.baidu.tieba.q56;
import com.baidu.tieba.s26;
import com.baidu.tieba.s56;
import com.baidu.tieba.sj0;
import com.baidu.tieba.t31;
import com.baidu.tieba.ti6;
import com.baidu.tieba.y05;
import com.baidu.tieba.yk0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class AdBrowserActivity extends AdBaseWebViewActivity implements m56 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean C;
    public transient /* synthetic */ FieldHolder $fh;
    public p56 A;
    public hl0 B;
    public TbWebView t;
    public nga u;
    public final pga v;
    public g85 w;
    public boolean x;
    public boolean y;
    public s56 z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-803537184, "Lcom/baidu/tieba/ad/browser/newstyle/AdBrowserActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-803537184, "Lcom/baidu/tieba/ad/browser/newstyle/AdBrowserActivity;");
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void addJavascriptInterface(Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, obj, str) == null) {
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void initWebView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public boolean webViewGoBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class i extends BaseAdWebView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBrowserActivity b;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i a;

            public a(i iVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = iVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.b.a.o();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements kj0 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i a;

            public b(i iVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = iVar;
            }

            @Override // com.baidu.tieba.kj0
            public void a(boolean z, @Nullable Map<String, String> map) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, map) == null) {
                    String p = pj0.p(map);
                    if (!TextUtils.isEmpty(p)) {
                        this.a.a(p);
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(AdBrowserActivity adBrowserActivity, Activity activity) {
            super(activity);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adBrowserActivity, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Activity) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = adBrowserActivity;
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.b.t != null && !TextUtils.isEmpty(str)) {
                this.b.t.loadUrl(str);
            }
        }

        public final boolean b(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                String str2 = sj0.d().r() + "://vendor/ad";
                if (str.startsWith(str2)) {
                    if (!str.startsWith(str2 + "/download")) {
                        if (!str.startsWith(str2 + "/registerDeeplink")) {
                            k81 a2 = k81.b.a();
                            AdBrowserActivity adBrowserActivity = this.b;
                            return a2.a(adBrowserActivity, str, adBrowserActivity.q, new b(this));
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.ad.webview.BaseAdWebView.c, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                AdBrowserActivity adBrowserActivity = this.b;
                TbWebView tbWebView = adBrowserActivity.t;
                if (tbWebView == null) {
                    return;
                }
                adBrowserActivity.b = str;
                tbWebView.loadUrl("javascript:window.local_obj.getIfFullScreen(document.getElementsByName(\"fc_fullscreen\")[0].content);");
                String b2 = this.b.t.getController().b();
                if (!StringUtils.isNull(b2)) {
                    this.b.d = b2;
                }
                if (!this.b.y) {
                    AdBrowserActivity adBrowserActivity2 = this.b;
                    adBrowserActivity2.a.u(adBrowserActivity2.d);
                }
                AdBrowserActivity adBrowserActivity3 = this.b;
                adBrowserActivity3.a.t(adBrowserActivity3.g);
                AdBrowserActivity adBrowserActivity4 = this.b;
                adBrowserActivity4.a.w(adBrowserActivity4.isNeedShowShareItem());
                this.b.hideProgressBar();
                this.b.stopLoadTimer();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                AdBrowserActivity adBrowserActivity = this.b;
                if (adBrowserActivity.t == null) {
                    return;
                }
                adBrowserActivity.b = str;
                adBrowserActivity.showProgressBar();
                this.b.startLoadTimer();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048580, this, webView, i, str, str2) == null) {
                super.onReceivedError(webView, i, str, str2);
                TbWebView tbWebView = this.b.t;
                if (tbWebView == null) {
                    return;
                }
                tbWebView.getController().e();
                this.b.stopLoadTimer();
                this.b.onReceivedError(i);
            }
        }

        @Override // com.baidu.tieba.ad.webview.BaseAdWebView.c, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            l56 l56Var;
            l56 l56Var2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, webView, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                if (b(str)) {
                    return true;
                }
                int i = e56.l().i(this.b.getPageContext().getPageActivity(), new String[]{str});
                if (i == 1) {
                    this.b.finish();
                    return true;
                } else if (i == 0) {
                    return true;
                } else {
                    AdBrowserActivity adBrowserActivity = this.b;
                    if (adBrowserActivity.v1(adBrowserActivity.b) && (l56Var2 = this.b.a) != null) {
                        l56Var2.q(false);
                    }
                    AdBrowserActivity adBrowserActivity2 = this.b;
                    adBrowserActivity2.b = str;
                    if (adBrowserActivity2.y) {
                        this.b.y = false;
                        this.b.runOnUiThread(new a(this));
                    }
                    if (URLUtil.isNetworkUrl(this.b.b)) {
                        this.b.showProgressBar();
                        if (this.b.y && (l56Var = this.b.a) != null) {
                            l56Var.r();
                        }
                        return false;
                    }
                    AdBrowserActivity adBrowserActivity3 = this.b;
                    adBrowserActivity3.w1(adBrowserActivity3.b);
                    return true;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class a implements DialogInterface.OnShowListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBrowserActivity a;

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
            }
        }

        public a(AdBrowserActivity adBrowserActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adBrowserActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adBrowserActivity;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements pga {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBrowserActivity a;

        public b(AdBrowserActivity adBrowserActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adBrowserActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adBrowserActivity;
        }

        @Override // com.baidu.tieba.pga
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, jsPromptResult)) == null) {
                if (this.a.u != null) {
                    return this.a.u.d(str, jsPromptResult);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ti6<hl0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBrowserActivity a;

        public c(AdBrowserActivity adBrowserActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adBrowserActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adBrowserActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ti6, java.util.concurrent.Callable
        public hl0 call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a.B;
            }
            return (hl0) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements e85 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBrowserActivity a;

        public d(AdBrowserActivity adBrowserActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adBrowserActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adBrowserActivity;
        }

        @Override // com.baidu.tieba.e85
        public void a(List<Long> list) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, list) == null) && list != null && list.size() != 0) {
                StringBuilder sb = new StringBuilder();
                String str = "";
                for (Long l : list) {
                    sb.append(str);
                    sb.append(l);
                    str = "_";
                }
                BdStatsItem logItem = PerformanceLogger.getLogItem();
                logItem.addValue("frame_delta", sb.toString());
                BdStatisticsManager.getInstance().performance(AlbumActivityConfig.FROM_WEB_VIEW, logItem);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBrowserActivity a;

        public e(AdBrowserActivity adBrowserActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adBrowserActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adBrowserActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a.r();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements s56.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBrowserActivity a;

        public f(AdBrowserActivity adBrowserActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adBrowserActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adBrowserActivity;
        }

        @Override // com.baidu.tieba.s56.b
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                this.a.A = p56.a(optJSONObject);
                if (this.a.A == null) {
                    return;
                }
                this.a.L1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBrowserActivity a;

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
            }
        }

        public g(AdBrowserActivity adBrowserActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adBrowserActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adBrowserActivity;
        }
    }

    /* loaded from: classes5.dex */
    public static class h implements DownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ti6<hl0> a;
        public final WeakReference<AdBrowserActivity> b;

        public h(ti6<hl0> ti6Var, AdBrowserActivity adBrowserActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ti6Var, adBrowserActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ti6Var;
            this.b = new WeakReference<>(adBrowserActivity);
        }

        public void a(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLLL(1048576, this, str, str2, str3) != null) || TextUtils.isEmpty(str)) {
                return;
            }
            hl0 call = this.a.call();
            if (call == null) {
                if (!GlobalBuildConfig.isDebug()) {
                    return;
                }
                throw new IllegalArgumentException("cache key is null");
            }
            if (GlobalBuildConfig.isDebug()) {
                Log.e("BaseActivity", "start downloading.....");
                Log.e("BaseActivity", "download url：" + str);
            }
            call.g = str;
            String e = p61.e(str, str2, str3);
            p61.b(p61.c(e), str3);
            if (TextUtils.isEmpty(e)) {
                String[] split = str.split("/");
                if (split.length > 1) {
                    str = split[split.length - 1];
                }
                if (str != null && str.length() > 50) {
                    e = str.substring(0, 50);
                } else {
                    e = str;
                }
            }
            call.d = e;
            AdBrowserActivity adBrowserActivity = this.b.get();
            if (adBrowserActivity != null) {
                if (!s26.a().f() && !PermissionUtil.checkWriteExternalStorage(adBrowserActivity)) {
                    PermissionUtil.requestWriteExternalStorage(adBrowserActivity, 0);
                } else {
                    adBrowserActivity.c1(call);
                }
            }
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) {
                a(str, str3, str4);
            }
        }
    }

    public AdBrowserActivity() {
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
        this.v = new b(this);
        this.x = true;
        this.y = false;
    }

    public final void N1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            BdUtilHelper.showToast(this, "第三方应用未经百度审核");
        }
    }

    public final void Q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a.b();
            this.a.m();
        }
    }

    public final void R1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || C) {
            return;
        }
        C = true;
        b85.a().b(16, new d(this));
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    @JavascriptInterface
    public /* bridge */ /* synthetic */ void addJavascriptInterface() {
        super.addJavascriptInterface();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public View createWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.t == null) {
                this.t = new TbWebView(getPageContext().getPageActivity());
                I1();
            }
            return this.t;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return TbadkCoreApplication.getInst().isGpuOpen();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public View getWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.t;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void initCookie() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            j56.c(getApplicationContext());
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onPause();
            TbWebView tbWebView = this.t;
            if (tbWebView == null) {
                return;
            }
            try {
                tbWebView.onPause();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            callHiddenWebViewMethod(MissionEvent.MESSAGE_PAUSE);
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onResume();
            TbWebView tbWebView = this.t;
            if (tbWebView == null) {
                return;
            }
            try {
                tbWebView.onResume();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            callHiddenWebViewMethod("onResume");
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void setFullScreen() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.y = true;
            if (1 != 0 && this.a != null) {
                runOnUiThread(new e(this));
            }
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void webViewDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            nga ngaVar = this.u;
            if (ngaVar != null) {
                ngaVar.h();
            }
            TbWebView tbWebView = this.t;
            if (tbWebView != null) {
                tbWebView.onDestroy();
            }
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void loadUrl(String str) {
        l56 l56Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            if (this.y && (l56Var = this.a) != null) {
                l56Var.r();
            }
            TbWebView tbWebView = this.t;
            if (tbWebView != null) {
                tbWebView.loadUrl(str);
            }
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public /* bridge */ /* synthetic */ void onClick(View view2) {
        super.onClick(view2);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, broadcastReceiver) == null) {
            try {
                super.unregisterReceiver(broadcastReceiver);
            } catch (Throwable unused) {
            }
        }
    }

    public void I1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.t.setScrollBarStyle(33554432);
            if (this.t.getLayoutParams() == null) {
                this.t.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.t.setDownloadListener(new h(new c(this), this));
            this.t.setWebViewClient(new i(this, this));
            k56 k56Var = new k56(this);
            k56Var.a(this.v);
            this.t.setWebChromeClient(k56Var);
            if (this.f) {
                addJavascriptInterface();
            }
            boolean isHybridBridgeEnabled = TbadkCoreApplication.getInst().isHybridBridgeEnabled();
            TbWebView tbWebView = this.t;
            g85 n = WebViewBridge.n(isHybridBridgeEnabled, tbWebView, tbWebView.getWebViewClient(), k56Var);
            this.w = n;
            if (isHybridBridgeEnabled) {
                n.d(new NamedBridgeHandler(this, n) { // from class: com.baidu.tieba.ad.browser.newstyle.AdBrowserActivity.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdBrowserActivity this$0;

                    @Override // com.baidu.tbadk.core.hybrid.NamedBridgeHandler
                    public String scope() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? "TBHY_COMMON_Performance" : (String) invokeV.objValue;
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(n);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, n};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super((g85) newInitContext.callArgs[0]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @i85(isAsync = false, value = "trackFPS")
                    private void trackFPS() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(65537, this) == null) {
                            this.this$0.R1();
                        }
                    }
                });
                n.d(new ClipboardBridgeHandler(n));
                n.d(new ImageOperateBridgeHandler(n));
                n.d(new FocusFeedBridgeHandler(n));
                n.d(new NamedBridgeHandler(this, n) { // from class: com.baidu.tieba.ad.browser.newstyle.AdBrowserActivity.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdBrowserActivity this$0;

                    @Override // com.baidu.tbadk.core.hybrid.NamedBridgeHandler
                    public String scope() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? "TBHY_COMMON_Share" : (String) invokeV.objValue;
                    }

                    /* renamed from: com.baidu.tieba.ad.browser.newstyle.AdBrowserActivity$4$a */
                    /* loaded from: classes5.dex */
                    public class a implements Runnable {
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ShareItem a;
                        public final /* synthetic */ AnonymousClass4 b;

                        public a(AnonymousClass4 anonymousClass4, ShareItem shareItem) {
                            Interceptable interceptable = $ic;
                            if (interceptable != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {anonymousClass4, shareItem};
                                interceptable.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.b = anonymousClass4;
                            this.a = shareItem;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable = $ic;
                            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                                this.b.this$0.a.A(this.a);
                            }
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(n);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, n};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super((g85) newInitContext.callArgs[0]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @i85(isAsync = false, value = "share")
                    private void share(JSONObject jSONObject) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 != null && interceptable2.invokeL(65537, this, jSONObject) != null) || jSONObject == null) {
                            return;
                        }
                        String optString = jSONObject.optString("title");
                        String optString2 = jSONObject.optString("desc");
                        String optString3 = jSONObject.optString("img");
                        String optString4 = jSONObject.optString("url");
                        if (!StringUtils.isNULL(jSONObject.optString(MapBundleKey.MapObjKey.OBJ_BID))) {
                            this.this$0.i = true;
                        }
                        SafeHandler.getInst().post(new a(this, this.this$0.createShareContent(optString, optString4, optString2, optString3)));
                    }
                });
                n.d(new NamedBridgeHandler(this, n) { // from class: com.baidu.tieba.ad.browser.newstyle.AdBrowserActivity.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdBrowserActivity this$0;

                    @Override // com.baidu.tbadk.core.hybrid.NamedBridgeHandler
                    public String scope() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? "TBHY_COMMON_UISwitch" : (String) invokeV.objValue;
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(n);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, n};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super((g85) newInitContext.callArgs[0]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @i85(isAsync = false, value = "viewHideSwitch")
                    private void viewHideSwitch(JSONObject jSONObject) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 != null && interceptable2.invokeL(65537, this, jSONObject) != null) || jSONObject == null) {
                            return;
                        }
                        String optString = jSONObject.optJSONObject("share").optString("value");
                        if (!"1".equals(optString)) {
                            if ("0".equals(optString)) {
                                this.this$0.x = false;
                            }
                        } else {
                            this.this$0.x = true;
                        }
                        AdBrowserActivity adBrowserActivity = this.this$0;
                        adBrowserActivity.a.w(adBrowserActivity.x);
                    }
                });
                n.d(new AdHybridUtilsBridgeHandler(n));
            }
        }
    }

    public hl0 J1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (yk0.b().query(str) != null) {
                return yk0.b().query(str);
            }
            hl0 hl0Var = new hl0();
            hl0Var.h(str);
            ll0 ll0Var = new ll0();
            ll0Var.j = str;
            ll0Var.a = this.o;
            hl0Var.p = ll0Var;
            il0 il0Var = new il0();
            il0Var.a = "LANDING_PAGE";
            hl0Var.q = il0Var;
            return hl0Var;
        }
        return (hl0) invokeL.objValue;
    }

    @Override // com.baidu.tieba.m56
    public void c1(@NonNull hl0 hl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, hl0Var) == null) {
            if (this.r) {
                Q1();
                return;
            }
            if (this.z == null) {
                this.z = new s56(new f(this));
            }
            String str = hl0Var.g;
            HashMap hashMap = new HashMap();
            hashMap.put("ext", this.o);
            hashMap.put("charge_url", this.q);
            hashMap.put("apk_url", str);
            this.z.g(hashMap, s56.c);
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bundle) == null) {
            super.onCreate(bundle);
            MessageManager.getInstance().runTask(2001308, (Class) null);
            nga ngaVar = new nga();
            this.u = ngaVar;
            ngaVar.a(new XiubaTbJsBridge(getPageContext()));
            this.u.a(new CommonTbJsBridge(getPageContext()));
            this.u.a(buildGameDownloadJSPrompt());
            if (this.e) {
                initCookie();
            }
            M1();
        }
    }

    public final ApkDownloadView K1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ApkDownloadView apkDownloadView = new ApkDownloadView(this);
            apkDownloadView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            apkDownloadView.setBackgroundSkin(R.drawable.obfuscated_res_0x7f0805cf);
            apkDownloadView.setForegroundSkin(R.color.black_alpha15);
            apkDownloadView.setTextColor(SkinManager.getColor(R.color.CAM_X0101));
            apkDownloadView.setTextSize(R.dimen.tbds42);
            apkDownloadView.setTextColorInitSkin(R.color.CAM_X0101);
            apkDownloadView.setTextColorSkin(R.color.CAM_X0101);
            apkDownloadView.c();
            new n56(apkDownloadView, this.B);
            return apkDownloadView;
        }
        return (ApkDownloadView) invokeV.objValue;
    }

    public final void L1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.FREE_SHOW).q(String.valueOf(0)).v("DOWNLOAD_RECTIFY").k(String.valueOf(this.A.a)).p(this.o);
            t31.e(clogBuilder);
            int i2 = this.A.a;
            if (i2 != 1) {
                if (i2 != 2 && i2 != 3) {
                    N1();
                    return;
                } else {
                    P1();
                    return;
                }
            }
            Q1();
        }
    }

    public final void M1() {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || this.t == null) {
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            str = intent.getStringExtra(WebViewActivityConfig.TAG_DOWNLOAD_AD_ID);
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.b)) {
            str = Uri.parse(this.b).getQueryParameter("url");
        }
        if (TextUtils.isEmpty(str)) {
            str = String.valueOf(System.currentTimeMillis());
        }
        hl0 J1 = J1(str);
        this.B = J1;
        this.a.j(J1);
    }

    public final void P1() {
        p56 p56Var;
        y05 y05Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.B != null && (p56Var = this.A) != null && (y05Var = p56Var.b) != null) {
            String str = y05Var.k;
            if (!TextUtils.isEmpty(str)) {
                this.B.g = str;
            }
            q56.d(this.A, K1(), this, new g(this), new a(this));
        }
    }

    public final oga buildGameDownloadJSPrompt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001386, oga.class, getPageContext());
            if (runTask != null && runTask.getData() != null) {
                return (oga) runTask.getData();
            }
            return null;
        }
        return (oga) invokeV.objValue;
    }

    public final void handleUploadResult(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048592, this, intent, i2) != null) || i2 != -1 || intent == null) {
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
            h85 j = h85.j("TBJS_COMMON_Image", "onImageUploadFinish", hashMap, 0L, false);
            if (this.w != null) {
                this.w.c(j);
            }
        } catch (JSONException e2) {
            BdLog.e(e2.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048596, this, i2, i3, intent) == null) && i2 == 12015) {
            handleUploadResult(intent, i3);
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void onReceivedError(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            TbWebView tbWebView = this.t;
            if (tbWebView != null) {
                this.b = tbWebView.getUrl();
                this.t.getController().e();
            }
            if ((!TextUtils.isEmpty(this.b) && this.b.endsWith(Constant.FILE.SUFFIX.BUNDLE_SUFFIX)) || i2 == -1) {
                return;
            }
            hideProgressBar();
            showNoDataView();
        }
    }
}
