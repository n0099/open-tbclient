package com.baidu.tieba.ad.browser.newstyle;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.hybrid.NamedBridgeHandler;
import com.baidu.tbadk.core.hybrid.WebViewBridge;
import com.baidu.tbadk.core.hybrid.handlers.ClipboardBridgeHandler;
import com.baidu.tbadk.core.hybrid.handlers.FocusFeedBridgeHandler;
import com.baidu.tbadk.core.hybrid.handlers.ImageOperateBridgeHandler;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.performanceLog.PerformanceLogger;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.view.ApkDownloadView;
import com.baidu.tieba.ad.webview.BaseAdWebView;
import com.baidu.tieba.b31;
import com.baidu.tieba.b35;
import com.baidu.tieba.c35;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d35;
import com.baidu.tieba.dfa;
import com.baidu.tieba.efa;
import com.baidu.tieba.eg0;
import com.baidu.tieba.ffa;
import com.baidu.tieba.fg0;
import com.baidu.tieba.he0;
import com.baidu.tieba.ig0;
import com.baidu.tieba.jy0;
import com.baidu.tieba.k06;
import com.baidu.tieba.lv4;
import com.baidu.tieba.me0;
import com.baidu.tieba.p06;
import com.baidu.tieba.pe0;
import com.baidu.tieba.q06;
import com.baidu.tieba.r06;
import com.baidu.tieba.s06;
import com.baidu.tieba.t06;
import com.baidu.tieba.v06;
import com.baidu.tieba.vf0;
import com.baidu.tieba.w06;
import com.baidu.tieba.w25;
import com.baidu.tieba.y06;
import com.baidu.tieba.z25;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class AdWebViewActivity extends AdBaseWebViewActivity implements s06 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean C;
    public transient /* synthetic */ FieldHolder $fh;
    public v06 A;
    public eg0 B;
    public TBAdWebView t;
    public dfa u;
    public ffa v;
    public b35 w;
    public boolean x;
    public boolean y;
    public y06 z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(38107407, "Lcom/baidu/tieba/ad/browser/newstyle/AdWebViewActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(38107407, "Lcom/baidu/tieba/ad/browser/newstyle/AdWebViewActivity;");
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    @Deprecated
    public void addJavascriptInterface(Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, str) == null) {
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void initWebView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public boolean webViewGoBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class i extends BaseAdWebView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdWebViewActivity b;

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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(AdWebViewActivity adWebViewActivity, Activity activity) {
            super(activity);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adWebViewActivity, activity};
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
            this.b = adWebViewActivity;
        }

        @Override // com.baidu.tieba.ad.webview.BaseAdWebView.c, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                AdWebViewActivity adWebViewActivity = this.b;
                TBAdWebView tBAdWebView = adWebViewActivity.t;
                if (tBAdWebView == null) {
                    return;
                }
                adWebViewActivity.b = str;
                tBAdWebView.loadUrl("javascript:window.local_obj.getIfFullScreen(document.getElementsByName(\"fc_fullscreen\")[0].content);");
                String title = this.b.t.getTitle();
                if (!StringUtils.isNull(title)) {
                    this.b.d = title;
                }
                if (!this.b.y) {
                    AdWebViewActivity adWebViewActivity2 = this.b;
                    adWebViewActivity2.a.u(adWebViewActivity2.d);
                }
                AdWebViewActivity adWebViewActivity3 = this.b;
                adWebViewActivity3.a.t(adWebViewActivity3.g);
                AdWebViewActivity adWebViewActivity4 = this.b;
                adWebViewActivity4.a.w(adWebViewActivity4.isNeedShowShareItem());
                this.b.hideProgressBar();
                this.b.stopLoadTimer();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                AdWebViewActivity adWebViewActivity = this.b;
                if (adWebViewActivity.t == null) {
                    return;
                }
                adWebViewActivity.b = str;
                adWebViewActivity.showProgressBar();
                this.b.startLoadTimer();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i, str, str2) == null) {
                super.onReceivedError(webView, i, str, str2);
                TBAdWebView tBAdWebView = this.b.t;
                if (tBAdWebView == null) {
                    return;
                }
                tBAdWebView.stopLoading();
                this.b.stopLoadTimer();
                this.b.onReceivedError(i);
            }
        }

        @Override // com.baidu.tieba.ad.webview.BaseAdWebView.c, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            r06 r06Var;
            r06 r06Var2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                if (this.b.k1(str)) {
                    return true;
                }
                int i = k06.l().i(this.b.getPageContext().getPageActivity(), new String[]{str});
                if (i == 1) {
                    this.b.finish();
                    return true;
                } else if (i == 0) {
                    return true;
                } else {
                    AdWebViewActivity adWebViewActivity = this.b;
                    if (adWebViewActivity.Q0(adWebViewActivity.b) && (r06Var2 = this.b.a) != null) {
                        r06Var2.q(false);
                    }
                    AdWebViewActivity adWebViewActivity2 = this.b;
                    adWebViewActivity2.b = str;
                    if (adWebViewActivity2.y) {
                        this.b.y = false;
                        this.b.runOnUiThread(new a(this));
                    }
                    if (URLUtil.isNetworkUrl(this.b.b)) {
                        this.b.showProgressBar();
                        if (this.b.y && (r06Var = this.b.a) != null) {
                            r06Var.r();
                        }
                        return false;
                    }
                    AdWebViewActivity adWebViewActivity3 = this.b;
                    adWebViewActivity3.R0(adWebViewActivity3.b);
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
        public final /* synthetic */ AdWebViewActivity a;

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
            }
        }

        public a(AdWebViewActivity adWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adWebViewActivity;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements he0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdWebViewActivity a;

        public b(AdWebViewActivity adWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adWebViewActivity;
        }

        @Override // com.baidu.tieba.he0
        public void a(boolean z, @Nullable Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, map) == null) {
                String p = me0.p(map);
                if (!TextUtils.isEmpty(p)) {
                    this.a.i1(p);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ffa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdWebViewActivity a;

        public c(AdWebViewActivity adWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adWebViewActivity;
        }

        @Override // com.baidu.tieba.ffa
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
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdWebViewActivity a;

        public d(AdWebViewActivity adWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adWebViewActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.a.t != null) {
                        this.a.t.destroy();
                        this.a.t = null;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements z25 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdWebViewActivity a;

        public e(AdWebViewActivity adWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adWebViewActivity;
        }

        @Override // com.baidu.tieba.z25
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
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdWebViewActivity a;

        public f(AdWebViewActivity adWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adWebViewActivity;
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
    public class g implements y06.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdWebViewActivity a;

        public g(AdWebViewActivity adWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adWebViewActivity;
        }

        @Override // com.baidu.tieba.y06.b
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                this.a.A = v06.a(optJSONObject);
                if (this.a.A == null) {
                    return;
                }
                this.a.j1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdWebViewActivity a;

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
            }
        }

        public h(AdWebViewActivity adWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adWebViewActivity;
        }
    }

    public AdWebViewActivity() {
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
        this.v = new c(this);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.t == null) {
                this.t = new TBAdWebView(getPageContext().getPageActivity());
                f1();
            }
            return this.t;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return TbadkCoreApplication.getInst().isGpuOpen();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public View getWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.t;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void initCookie() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            p06.c(getApplicationContext());
        }
    }

    public final void m1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            BdUtilHelper.showToast(this, "第三方应用未经百度审核");
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onPause();
            TBAdWebView tBAdWebView = this.t;
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
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onResume();
            TBAdWebView tBAdWebView = this.t;
            if (tBAdWebView == null) {
                return;
            }
            try {
                tBAdWebView.onResume();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            callHiddenWebViewMethod("onResume");
        }
    }

    public final void q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.a.b();
            this.a.m();
        }
    }

    public final void r1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048602, this) != null) || C) {
            return;
        }
        C = true;
        w25.a().b(16, new e(this));
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void setFullScreen() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.y = true;
            if (1 != 0 && this.a != null) {
                runOnUiThread(new f(this));
            }
        }
    }

    public void i1(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, str) == null) && this.t != null && !TextUtils.isEmpty(str)) {
            this.t.loadUrl(str);
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void loadUrl(String str) {
        r06 r06Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            if (this.y && (r06Var = this.a) != null) {
                r06Var.r();
            }
            TBAdWebView tBAdWebView = this.t;
            if (tBAdWebView != null) {
                tBAdWebView.loadUrl(str);
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
        if (interceptable == null || interceptable.invokeL(1048604, this, broadcastReceiver) == null) {
            try {
                super.unregisterReceiver(broadcastReceiver);
            } catch (Throwable unused) {
            }
        }
    }

    public final efa buildGameDownloadJSPrompt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001386, efa.class, getPageContext());
            if (runTask != null && runTask.getData() != null) {
                return (efa) runTask.getData();
            }
            return null;
        }
        return (efa) invokeV.objValue;
    }

    public final void o1() {
        v06 v06Var;
        lv4 lv4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && this.B != null && (v06Var = this.A) != null && (lv4Var = v06Var.b) != null) {
            String str = lv4Var.k;
            if (!TextUtils.isEmpty(str)) {
                this.B.g = str;
            }
            w06.d(this.A, h1(), this, new h(this), new a(this));
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void webViewDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            dfa dfaVar = this.u;
            if (dfaVar != null) {
                dfaVar.h();
            }
            TBAdWebView tBAdWebView = this.t;
            if (tBAdWebView != null) {
                tBAdWebView.getSettings().setBuiltInZoomControls(true);
                this.t.setVisibility(8);
                SafeHandler.getInst().postDelayed(new d(this), ViewConfiguration.getZoomControlsTimeout() + 1000);
            }
        }
    }

    public void f1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.t.getSettings().setDatabasePath(getApplicationContext().getDir("databases", 0).getAbsolutePath());
            this.t.setHorizontalScrollbarOverlay(false);
            this.t.setInitialScale(100);
            this.t.setScrollBarStyle(33554432);
            if (this.t.getLayoutParams() == null) {
                this.t.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.t.setDownloadStartListener(this);
            i iVar = new i(this, this);
            this.t.setWebViewClient(iVar);
            q06 q06Var = new q06(this);
            q06Var.a(this.v);
            this.t.setWebChromeClient(q06Var);
            if (this.f) {
                addJavascriptInterface();
            }
            CompatibleUtile.getInstance().removeJavascriptInterface(this.t);
            boolean isHybridBridgeEnabled = TbadkCoreApplication.getInst().isHybridBridgeEnabled();
            b35 n = WebViewBridge.n(isHybridBridgeEnabled, this.t, iVar, q06Var);
            this.w = n;
            if (isHybridBridgeEnabled) {
                n.d(new NamedBridgeHandler(this, n) { // from class: com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdWebViewActivity this$0;

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
                                super((b35) newInitContext.callArgs[0]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @d35(isAsync = false, value = "trackFPS")
                    private void trackFPS() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(65537, this) == null) {
                            this.this$0.r1();
                        }
                    }
                });
                n.d(new ClipboardBridgeHandler(n));
                n.d(new ImageOperateBridgeHandler(n));
                n.d(new FocusFeedBridgeHandler(n));
                n.d(new NamedBridgeHandler(this, n) { // from class: com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdWebViewActivity this$0;

                    @Override // com.baidu.tbadk.core.hybrid.NamedBridgeHandler
                    public String scope() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? "TBHY_COMMON_Share" : (String) invokeV.objValue;
                    }

                    /* renamed from: com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity$3$a */
                    /* loaded from: classes5.dex */
                    public class a implements Runnable {
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ShareItem a;
                        public final /* synthetic */ AnonymousClass3 b;

                        public a(AnonymousClass3 anonymousClass3, ShareItem shareItem) {
                            Interceptable interceptable = $ic;
                            if (interceptable != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {anonymousClass3, shareItem};
                                interceptable.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.b = anonymousClass3;
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
                                super((b35) newInitContext.callArgs[0]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @d35(isAsync = false, value = "share")
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
                n.d(new NamedBridgeHandler(this, n) { // from class: com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdWebViewActivity this$0;

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
                                super((b35) newInitContext.callArgs[0]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @d35(isAsync = false, value = "viewHideSwitch")
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
                        AdWebViewActivity adWebViewActivity = this.this$0;
                        adWebViewActivity.a.w(adWebViewActivity.x);
                    }
                });
                n.d(new AdHybridUtilsBridgeHandler(n));
            }
        }
    }

    public eg0 g1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (vf0.b().d(str) != null) {
                return vf0.b().d(str);
            }
            eg0 eg0Var = new eg0();
            eg0Var.h(str);
            ig0 ig0Var = new ig0();
            ig0Var.j = str;
            ig0Var.a = this.o;
            eg0Var.p = ig0Var;
            fg0 fg0Var = new fg0();
            fg0Var.a = "LANDING_PAGE";
            eg0Var.q = fg0Var;
            return eg0Var;
        }
        return (eg0) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bundle) == null) {
            super.onCreate(bundle);
            MessageManager.getInstance().runTask(2001308, (Class) null);
            dfa dfaVar = new dfa();
            this.u = dfaVar;
            dfaVar.a(new XiubaTbJsBridge(getPageContext()));
            this.u.a(new CommonTbJsBridge(getPageContext()));
            this.u.a(buildGameDownloadJSPrompt());
            if (this.e) {
                initCookie();
            }
            l1();
        }
    }

    @Override // com.baidu.tieba.s06
    public void v0(@NonNull eg0 eg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, eg0Var) == null) {
            if (this.r) {
                q1();
                return;
            }
            if (this.z == null) {
                this.z = new y06(new g(this));
            }
            String str = eg0Var.g;
            HashMap hashMap = new HashMap();
            hashMap.put("ext", this.o);
            hashMap.put("charge_url", this.q);
            hashMap.put("apk_url", str);
            this.z.g(hashMap, y06.c);
        }
    }

    public final ApkDownloadView h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ApkDownloadView apkDownloadView = new ApkDownloadView(this);
            apkDownloadView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            apkDownloadView.setBackgroundSkin(R.drawable.obfuscated_res_0x7f0805db);
            apkDownloadView.setForegroundSkin(R.color.black_alpha15);
            apkDownloadView.setTextColor(SkinManager.getColor(R.color.CAM_X0101));
            apkDownloadView.setTextSize(R.dimen.tbds42);
            apkDownloadView.setTextColorInitSkin(R.color.CAM_X0101);
            apkDownloadView.setTextColorSkin(R.color.CAM_X0101);
            apkDownloadView.b();
            new t06(apkDownloadView, this.B);
            return apkDownloadView;
        }
        return (ApkDownloadView) invokeV.objValue;
    }

    public final void j1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.FREE_SHOW).q(String.valueOf(0)).v("DOWNLOAD_RECTIFY").k(String.valueOf(this.A.a)).p(this.o);
            jy0.e(clogBuilder);
            int i2 = this.A.a;
            if (i2 != 1) {
                if (i2 != 2 && i2 != 3) {
                    m1();
                    return;
                } else {
                    o1();
                    return;
                }
            }
            q1();
        }
    }

    public final void l1() {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || this.t == null) {
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
        eg0 g1 = g1(str);
        this.B = g1;
        this.t.d(g1);
        this.a.j(this.B);
    }

    public final void handleUploadResult(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048585, this, intent, i2) != null) || i2 != -1 || intent == null) {
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
            c35 j = c35.j("TBJS_COMMON_Image", "onImageUploadFinish", hashMap, 0L, false);
            if (this.w != null) {
                this.w.c(j);
            }
        } catch (JSONException e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public final boolean k1(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            String str2 = pe0.d().s() + "://vendor/ad";
            if (str.startsWith(str2)) {
                if (!str.startsWith(str2 + "/download")) {
                    if (!str.startsWith(str2 + "/registerDeeplink")) {
                        return b31.b.a().a(this, str, this.q, new b(this));
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048595, this, i2, i3, intent) == null) && i2 == 12015) {
            handleUploadResult(intent, i3);
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void onReceivedError(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            TBAdWebView tBAdWebView = this.t;
            if (tBAdWebView != null) {
                this.b = tBAdWebView.getUrl();
                this.t.stopLoading();
            }
            if ((!TextUtils.isEmpty(this.b) && this.b.endsWith(Constant.FILE.SUFFIX.BUNDLE_SUFFIX)) || i2 == -1) {
                return;
            }
            hideProgressBar();
            showNoDataView();
        }
    }
}
