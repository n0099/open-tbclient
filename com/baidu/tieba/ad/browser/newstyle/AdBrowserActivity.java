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
import com.baidu.tieba.a21;
import com.baidu.tieba.a45;
import com.baidu.tieba.ad.download.view.ApkDownloadView;
import com.baidu.tieba.ad.webview.BaseAdWebView;
import com.baidu.tieba.ah0;
import com.baidu.tieba.axa;
import com.baidu.tieba.b36;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.bxa;
import com.baidu.tieba.c36;
import com.baidu.tieba.c45;
import com.baidu.tieba.cxa;
import com.baidu.tieba.d45;
import com.baidu.tieba.dz0;
import com.baidu.tieba.e06;
import com.baidu.tieba.e36;
import com.baidu.tieba.e45;
import com.baidu.tieba.ef0;
import com.baidu.tieba.hf0;
import com.baidu.tieba.hw4;
import com.baidu.tieba.mg6;
import com.baidu.tieba.ng0;
import com.baidu.tieba.q26;
import com.baidu.tieba.v26;
import com.baidu.tieba.v31;
import com.baidu.tieba.w26;
import com.baidu.tieba.wg0;
import com.baidu.tieba.x26;
import com.baidu.tieba.x35;
import com.baidu.tieba.xg0;
import com.baidu.tieba.y26;
import com.baidu.tieba.z26;
import com.baidu.tieba.ze0;
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
public class AdBrowserActivity extends AdBaseWebViewActivity implements y26 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean C;
    public transient /* synthetic */ FieldHolder $fh;
    public b36 A;
    public wg0 B;
    public TbWebView t;
    public axa u;
    public final cxa v;
    public c45 w;
    public boolean x;
    public boolean y;
    public e36 z;

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
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, obj, str) == null) {
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void initWebView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
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
        public class b implements ze0 {
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

            @Override // com.baidu.tieba.ze0
            public void a(boolean z, @Nullable Map<String, String> map) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, map) == null) {
                    String p = ef0.p(map);
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
                String str2 = hf0.d().s() + "://vendor/ad";
                if (str.startsWith(str2)) {
                    if (!str.startsWith(str2 + "/download")) {
                        if (!str.startsWith(str2 + "/registerDeeplink")) {
                            v31 a2 = v31.b.a();
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
            x26 x26Var;
            x26 x26Var2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, webView, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                if (b(str)) {
                    return true;
                }
                int i = q26.l().i(this.b.getPageContext().getPageActivity(), new String[]{str});
                if (i == 1) {
                    this.b.finish();
                    return true;
                } else if (i == 0) {
                    return true;
                } else {
                    AdBrowserActivity adBrowserActivity = this.b;
                    if (adBrowserActivity.K0(adBrowserActivity.b) && (x26Var2 = this.b.a) != null) {
                        x26Var2.q(false);
                    }
                    AdBrowserActivity adBrowserActivity2 = this.b;
                    adBrowserActivity2.b = str;
                    if (adBrowserActivity2.y) {
                        this.b.y = false;
                        this.b.runOnUiThread(new a(this));
                    }
                    if (URLUtil.isNetworkUrl(this.b.b)) {
                        this.b.showProgressBar();
                        if (this.b.y && (x26Var = this.b.a) != null) {
                            x26Var.r();
                        }
                        return false;
                    }
                    AdBrowserActivity adBrowserActivity3 = this.b;
                    adBrowserActivity3.L0(adBrowserActivity3.b);
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
    public class b implements cxa {
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

        @Override // com.baidu.tieba.cxa
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
    public class c implements mg6<wg0> {
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
        @Override // com.baidu.tieba.mg6, java.util.concurrent.Callable
        /* renamed from: a */
        public wg0 call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a.B;
            }
            return (wg0) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements a45 {
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

        @Override // com.baidu.tieba.a45
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
    public class f implements e36.b {
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

        @Override // com.baidu.tieba.e36.b
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                this.a.A = b36.a(optJSONObject);
                if (this.a.A == null) {
                    return;
                }
                this.a.f1();
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
        public final mg6<wg0> a;
        public final WeakReference<AdBrowserActivity> b;

        public h(mg6<wg0> mg6Var, AdBrowserActivity adBrowserActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mg6Var, adBrowserActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mg6Var;
            this.b = new WeakReference<>(adBrowserActivity);
        }

        public void a(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLLL(1048576, this, str, str2, str3) != null) || TextUtils.isEmpty(str)) {
                return;
            }
            wg0 call = this.a.call();
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
            String e = a21.e(str, str2, str3);
            a21.b(a21.c(e), str3);
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
                if (!e06.a().f() && !PermissionUtil.checkWriteExternalStorage(adBrowserActivity)) {
                    PermissionUtil.requestWriteExternalStorage(adBrowserActivity, 0);
                } else {
                    adBrowserActivity.o0(call);
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

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    @JavascriptInterface
    public /* bridge */ /* synthetic */ void addJavascriptInterface() {
        super.addJavascriptInterface();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public View createWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.t == null) {
                this.t = new TbWebView(getPageContext().getPageActivity());
                a1();
            }
            return this.t;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return TbadkCoreApplication.getInst().isGpuOpen();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public View getWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.t;
        }
        return (View) invokeV.objValue;
    }

    public final void h1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            BdUtilHelper.showToast(this, "第三方应用未经百度审核");
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void initCookie() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            v26.c(getApplicationContext());
        }
    }

    public final void j1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.a.b();
            this.a.m();
        }
    }

    public final void k1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048593, this) != null) || C) {
            return;
        }
        C = true;
        x35.a().b(16, new d(this));
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
            axa axaVar = this.u;
            if (axaVar != null) {
                axaVar.h();
            }
            TbWebView tbWebView = this.t;
            if (tbWebView != null) {
                tbWebView.onDestroy();
            }
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void loadUrl(String str) {
        x26 x26Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            if (this.y && (x26Var = this.a) != null) {
                x26Var.r();
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

    public void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.t.setScrollBarStyle(33554432);
            if (this.t.getLayoutParams() == null) {
                this.t.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.t.setDownloadListener(new h(new c(this), this));
            this.t.setWebViewClient(new i(this, this));
            w26 w26Var = new w26(this);
            w26Var.a(this.v);
            this.t.setWebChromeClient(w26Var);
            if (this.f) {
                addJavascriptInterface();
            }
            boolean isHybridBridgeEnabled = TbadkCoreApplication.getInst().isHybridBridgeEnabled();
            TbWebView tbWebView = this.t;
            c45 o = WebViewBridge.o(isHybridBridgeEnabled, tbWebView, tbWebView.getWebViewClient(), w26Var);
            this.w = o;
            if (isHybridBridgeEnabled) {
                o.d(new NamedBridgeHandler(this, o) { // from class: com.baidu.tieba.ad.browser.newstyle.AdBrowserActivity.3
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
                        super(o);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, o};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super((c45) newInitContext.callArgs[0]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @e45(isAsync = false, value = "trackFPS")
                    private void trackFPS() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(65537, this) == null) {
                            this.this$0.k1();
                        }
                    }
                });
                o.d(new ClipboardBridgeHandler(o));
                o.d(new ImageOperateBridgeHandler(o));
                o.d(new FocusFeedBridgeHandler(o));
                o.d(new NamedBridgeHandler(this, o) { // from class: com.baidu.tieba.ad.browser.newstyle.AdBrowserActivity.4
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
                        super(o);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, o};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super((c45) newInitContext.callArgs[0]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @e45(isAsync = false, value = "share")
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
                o.d(new NamedBridgeHandler(this, o) { // from class: com.baidu.tieba.ad.browser.newstyle.AdBrowserActivity.5
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
                        super(o);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, o};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super((c45) newInitContext.callArgs[0]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @e45(isAsync = false, value = "viewHideSwitch")
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
                o.d(new AdHybridUtilsBridgeHandler(o));
            }
        }
    }

    public wg0 b1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (ng0.b().d(str) != null) {
                return ng0.b().d(str);
            }
            wg0 wg0Var = new wg0();
            wg0Var.h(str);
            ah0 ah0Var = new ah0();
            ah0Var.j = str;
            ah0Var.a = this.o;
            wg0Var.p = ah0Var;
            xg0 xg0Var = new xg0();
            xg0Var.a = "LANDING_PAGE";
            wg0Var.q = xg0Var;
            return wg0Var;
        }
        return (wg0) invokeL.objValue;
    }

    @Override // com.baidu.tieba.y26
    public void o0(@NonNull wg0 wg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, wg0Var) == null) {
            if (this.r) {
                j1();
                return;
            }
            if (this.z == null) {
                this.z = new e36(new f(this));
            }
            String str = wg0Var.g;
            HashMap hashMap = new HashMap();
            hashMap.put("ext", this.o);
            hashMap.put("charge_url", this.q);
            hashMap.put("apk_url", str);
            this.z.g(hashMap, e36.c);
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bundle) == null) {
            super.onCreate(bundle);
            MessageManager.getInstance().runTask(2001308, (Class) null);
            axa axaVar = new axa();
            this.u = axaVar;
            axaVar.a(new XiubaTbJsBridge(getPageContext()));
            this.u.a(new CommonTbJsBridge(getPageContext()));
            this.u.a(buildGameDownloadJSPrompt());
            if (this.e) {
                initCookie();
            }
            g1();
        }
    }

    public final bxa buildGameDownloadJSPrompt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001386, bxa.class, getPageContext());
            if (runTask != null && runTask.getData() != null) {
                return (bxa) runTask.getData();
            }
            return null;
        }
        return (bxa) invokeV.objValue;
    }

    public final void i1() {
        b36 b36Var;
        hw4 hw4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.B != null && (b36Var = this.A) != null && (hw4Var = b36Var.b) != null) {
            String str = hw4Var.k;
            if (!TextUtils.isEmpty(str)) {
                this.B.g = str;
            }
            c36.d(this.A, c1(), this, new g(this), new a(this));
        }
    }

    public final ApkDownloadView c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ApkDownloadView apkDownloadView = new ApkDownloadView(this);
            apkDownloadView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            apkDownloadView.setBackgroundSkin(R.drawable.obfuscated_res_0x7f0805e7);
            apkDownloadView.setForegroundSkin(R.color.black_alpha15);
            apkDownloadView.setTextColor(SkinManager.getColor(R.color.CAM_X0101));
            apkDownloadView.setTextSize(R.dimen.tbds42);
            apkDownloadView.setTextColorInitSkin(R.color.CAM_X0101);
            apkDownloadView.setTextColorSkin(R.color.CAM_X0101);
            apkDownloadView.d();
            new z26(apkDownloadView, this.B);
            return apkDownloadView;
        }
        return (ApkDownloadView) invokeV.objValue;
    }

    public final void f1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.FREE_SHOW).q(String.valueOf(0)).v("DOWNLOAD_RECTIFY").k(String.valueOf(this.A.a)).p(this.o);
            dz0.e(clogBuilder);
            int i2 = this.A.a;
            if (i2 != 1) {
                if (i2 != 2 && i2 != 3) {
                    h1();
                    return;
                } else {
                    i1();
                    return;
                }
            }
            j1();
        }
    }

    public final void g1() {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || this.t == null) {
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
        wg0 b1 = b1(str);
        this.B = b1;
        this.a.j(b1);
    }

    public final void handleUploadResult(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048588, this, intent, i2) != null) || i2 != -1 || intent == null) {
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
            d45 j = d45.j("TBJS_COMMON_Image", "onImageUploadFinish", hashMap, 0L, false);
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
