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
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nps.utils.Constant;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.view.ApkDownloadView;
import com.baidu.tieba.ad.webview.BaseAdWebView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.at4;
import com.repackage.bt4;
import com.repackage.cj8;
import com.repackage.ct4;
import com.repackage.dj8;
import com.repackage.eh0;
import com.repackage.ej8;
import com.repackage.et4;
import com.repackage.gt4;
import com.repackage.hh0;
import com.repackage.ht4;
import com.repackage.ii0;
import com.repackage.ik5;
import com.repackage.it4;
import com.repackage.iy0;
import com.repackage.m21;
import com.repackage.nk5;
import com.repackage.ok5;
import com.repackage.pi;
import com.repackage.pk5;
import com.repackage.pn4;
import com.repackage.qg;
import com.repackage.qk5;
import com.repackage.r95;
import com.repackage.rk5;
import com.repackage.si0;
import com.repackage.ti0;
import com.repackage.tk5;
import com.repackage.uk5;
import com.repackage.us4;
import com.repackage.vg;
import com.repackage.wi0;
import com.repackage.wk5;
import com.repackage.xs4;
import com.repackage.zg0;
import com.repackage.zs4;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AdWebViewActivity extends AdBaseWebViewActivity implements BaseAdWebView.d {
    public static /* synthetic */ Interceptable $ic;
    public static boolean C;
    public transient /* synthetic */ FieldHolder $fh;
    public tk5 A;
    public si0 B;
    public TBAdWebView t;
    public cj8 u;
    public ej8 v;
    public zs4 w;
    public boolean x;
    public boolean y;
    public wk5 z;

    /* loaded from: classes3.dex */
    public class a implements DialogInterface.OnShowListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdWebViewActivity a;

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

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements zg0 {
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

        @Override // com.repackage.zg0
        public void a(boolean z, @Nullable Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, map) == null) {
                String p = eh0.p(map);
                if (TextUtils.isEmpty(p)) {
                    return;
                }
                this.a.R1(p);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ej8 {
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

        @Override // com.repackage.ej8
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, jsPromptResult)) == null) {
                if (this.a.u != null) {
                    return this.a.u.c(str, jsPromptResult);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d extends bt4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdWebViewActivity c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(AdWebViewActivity adWebViewActivity, zs4 zs4Var) {
            super(zs4Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adWebViewActivity, zs4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((zs4) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = adWebViewActivity;
        }

        @ct4(isAsync = false, value = "trackFPS")
        private void trackFPS() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                this.c.Y1();
            }
        }

        @Override // com.repackage.bt4
        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_Performance" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class e extends bt4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdWebViewActivity c;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ShareItem a;
            public final /* synthetic */ e b;

            public a(e eVar, ShareItem shareItem) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, shareItem};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = eVar;
                this.a = shareItem;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.c.a.C(this.a);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(AdWebViewActivity adWebViewActivity, zs4 zs4Var) {
            super(zs4Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adWebViewActivity, zs4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((zs4) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = adWebViewActivity;
        }

        @ct4(isAsync = false, value = "share")
        private void share(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65537, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            String optString = jSONObject.optString("title");
            String optString2 = jSONObject.optString("desc");
            String optString3 = jSONObject.optString("img");
            String optString4 = jSONObject.optString("url");
            if (!StringUtils.isNULL(jSONObject.optString("bid"))) {
                this.c.i = true;
            }
            qg.a().post(new a(this, this.c.createShareContent(optString, optString4, optString2, optString3)));
        }

        @Override // com.repackage.bt4
        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_Share" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class f extends bt4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdWebViewActivity c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(AdWebViewActivity adWebViewActivity, zs4 zs4Var) {
            super(zs4Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adWebViewActivity, zs4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((zs4) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = adWebViewActivity;
        }

        @ct4(isAsync = false, value = "viewHideSwitch")
        private void viewHideSwitch(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65537, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            String optString = jSONObject.optJSONObject("share").optString("value");
            if ("1".equals(optString)) {
                this.c.x = true;
            } else if ("0".equals(optString)) {
                this.c.x = false;
            }
            AdWebViewActivity adWebViewActivity = this.c;
            adWebViewActivity.a.y(adWebViewActivity.x);
        }

        @Override // com.repackage.bt4
        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_UISwitch" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {
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

    /* loaded from: classes3.dex */
    public class h implements xs4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdWebViewActivity a;

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

        @Override // com.repackage.xs4
        public void a(List<Long> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null || list.size() == 0) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            String str = "";
            for (Long l : list) {
                sb.append(str);
                sb.append(l);
                str = "_";
            }
            vg a = r95.a();
            a.a("frame_delta", sb.toString());
            BdStatisticsManager.getInstance().performance(AlbumActivityConfig.FROM_WEB_VIEW, a);
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdWebViewActivity a;

        public i(AdWebViewActivity adWebViewActivity) {
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
                this.a.a.t();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements wk5.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdWebViewActivity a;

        public j(AdWebViewActivity adWebViewActivity) {
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

        @Override // com.repackage.wk5.b
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                this.a.A = tk5.a(optJSONObject);
                if (this.a.A == null) {
                    return;
                }
                this.a.S1();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdWebViewActivity a;

        public k(AdWebViewActivity adWebViewActivity) {
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

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l extends BaseAdWebView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdWebViewActivity c;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l a;

            public a(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = lVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.c.a.p();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(AdWebViewActivity adWebViewActivity, BaseAdWebView baseAdWebView, Activity activity) {
            super(baseAdWebView, activity);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adWebViewActivity, baseAdWebView, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((BaseAdWebView) objArr2[0], (Activity) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = adWebViewActivity;
        }

        @Override // com.baidu.tieba.ad.webview.BaseAdWebView.c, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                AdWebViewActivity adWebViewActivity = this.c;
                TBAdWebView tBAdWebView = adWebViewActivity.t;
                if (tBAdWebView == null) {
                    return;
                }
                adWebViewActivity.b = str;
                tBAdWebView.loadUrl("javascript:window.local_obj.getIfFullScreen(document.getElementsByName(\"fc_fullscreen\")[0].content);");
                String title = this.c.t.getTitle();
                if (!StringUtils.isNull(title)) {
                    this.c.d = title;
                }
                if (!this.c.y) {
                    AdWebViewActivity adWebViewActivity2 = this.c;
                    adWebViewActivity2.a.w(adWebViewActivity2.d);
                }
                AdWebViewActivity adWebViewActivity3 = this.c;
                adWebViewActivity3.a.v(adWebViewActivity3.g);
                AdWebViewActivity adWebViewActivity4 = this.c;
                adWebViewActivity4.a.y(adWebViewActivity4.isNeedShowShareItem());
                this.c.hideProgressBar();
                this.c.stopLoadTimer();
            }
        }

        @Override // com.baidu.tieba.ad.webview.BaseAdWebView.c, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                AdWebViewActivity adWebViewActivity = this.c;
                if (adWebViewActivity.t == null) {
                    return;
                }
                adWebViewActivity.b = str;
                adWebViewActivity.showProgressBar();
                this.c.startLoadTimer();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i, str, str2) == null) {
                super.onReceivedError(webView, i, str, str2);
                TBAdWebView tBAdWebView = this.c.t;
                if (tBAdWebView == null) {
                    return;
                }
                tBAdWebView.stopLoading();
                this.c.stopLoadTimer();
                this.c.onReceivedError(i);
            }
        }

        @Override // com.baidu.tieba.ad.webview.BaseAdWebView.c, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            qk5 qk5Var;
            qk5 qk5Var2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                if (this.c.T1(str)) {
                    return true;
                }
                int i = ik5.l().i(this.c.getPageContext().getPageActivity(), new String[]{str});
                if (i == 1) {
                    this.c.finish();
                    return true;
                } else if (i == 0) {
                    return true;
                } else {
                    AdWebViewActivity adWebViewActivity = this.c;
                    if (adWebViewActivity.C1(adWebViewActivity.b) && (qk5Var2 = this.c.a) != null) {
                        qk5Var2.r(false);
                    }
                    AdWebViewActivity adWebViewActivity2 = this.c;
                    adWebViewActivity2.b = str;
                    if (adWebViewActivity2.y) {
                        this.c.y = false;
                        this.c.runOnUiThread(new a(this));
                    }
                    if (URLUtil.isNetworkUrl(this.c.b)) {
                        this.c.showProgressBar();
                        if (this.c.y && (qk5Var = this.c.a) != null) {
                            qk5Var.t();
                        }
                        return false;
                    }
                    AdWebViewActivity adWebViewActivity3 = this.c;
                    adWebViewActivity3.D1(adWebViewActivity3.b);
                    return true;
                }
            }
            return invokeLL.booleanValue;
        }
    }

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

    public void O1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.t.getSettings().setDatabasePath(getApplicationContext().getDir(NgWebView.APP_DATABASE_PATH, 0).getAbsolutePath());
            this.t.setHorizontalScrollbarOverlay(false);
            this.t.setInitialScale(100);
            this.t.setScrollBarStyle(33554432);
            if (this.t.getLayoutParams() == null) {
                this.t.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.t.setDownloadStartListener(this);
            l lVar = new l(this, this.t, this);
            this.t.setWebViewClient(lVar);
            pk5 pk5Var = new pk5(this);
            pk5Var.a(this.v);
            this.t.setWebChromeClient(pk5Var);
            if (this.f) {
                addJavascriptInterface();
            }
            CompatibleUtile.getInstance().removeJavascriptInterface(this.t);
            boolean isHybridBridgeEnabled = TbadkCoreApplication.getInst().isHybridBridgeEnabled();
            zs4 m = et4.m(isHybridBridgeEnabled, this.t, lVar, pk5Var, null);
            this.w = m;
            if (isHybridBridgeEnabled) {
                m.d(new d(this, m));
                m.d(new gt4(m));
                m.d(new it4(m));
                m.d(new ht4(m));
                m.d(new e(this, m));
                m.d(new f(this, m));
                m.d(new ok5(m));
            }
        }
    }

    public si0 P1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (ii0.a().query(str) != null) {
                return ii0.a().query(str);
            }
            si0 si0Var = new si0();
            si0Var.g(str);
            wi0 wi0Var = new wi0();
            wi0Var.j = str;
            wi0Var.a = this.o;
            si0Var.p = wi0Var;
            ti0 ti0Var = new ti0();
            ti0Var.a = "LANDING_PAGE";
            si0Var.q = ti0Var;
            return si0Var;
        }
        return (si0) invokeL.objValue;
    }

    public final ApkDownloadView Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ApkDownloadView apkDownloadView = new ApkDownloadView(this);
            apkDownloadView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            apkDownloadView.setBackgroundSkin(R.drawable.obfuscated_res_0x7f0804a4);
            apkDownloadView.setForegroundSkin(R.color.black_alpha15);
            apkDownloadView.setTextColor(SkinManager.getColor(R.color.CAM_X0101));
            apkDownloadView.setTextSize(R.dimen.tbds42);
            apkDownloadView.setTextColorInitSkin(R.color.CAM_X0101);
            apkDownloadView.setTextColorSkin(R.color.CAM_X0101);
            apkDownloadView.c();
            new rk5(apkDownloadView, this.B);
            return apkDownloadView;
        }
        return (ApkDownloadView) invokeV.objValue;
    }

    public void R1(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.t == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.t.loadUrl(str);
    }

    public final void S1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.FREE_SHOW).q(String.valueOf(0)).v("DOWNLOAD_RECTIFY").k(String.valueOf(this.A.a)).p(this.o);
            iy0.b(clogBuilder);
            int i2 = this.A.a;
            if (i2 == 1) {
                X1();
            } else if (i2 != 2 && i2 != 3) {
                V1();
            } else {
                W1();
            }
        }
    }

    public final boolean T1(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            String str2 = hh0.d().k() + "://vendor/ad";
            if (str.startsWith(str2)) {
                if (str.startsWith(str2 + "/download")) {
                    return false;
                }
                if (str.startsWith(str2 + "/registerDeeplink")) {
                    return false;
                }
                return m21.b.a().a(this, str, this.q, new b(this));
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void U1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.t == null) {
            return;
        }
        Intent intent = getIntent();
        String stringExtra = intent != null ? intent.getStringExtra(WebViewActivityConfig.TAG_DOWNLOAD_AD_ID) : "";
        if (TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(this.b)) {
            stringExtra = Uri.parse(this.b).getQueryParameter("url");
        }
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = String.valueOf(System.currentTimeMillis());
        }
        si0 P1 = P1(stringExtra);
        this.B = P1;
        this.t.d(P1);
        this.a.k(this.B);
    }

    public final void V1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            pi.O(this, "第三方应用未经百度审核");
        }
    }

    public final void W1() {
        tk5 tk5Var;
        pn4 pn4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.B == null || (tk5Var = this.A) == null || (pn4Var = tk5Var.b) == null) {
            return;
        }
        String str = pn4Var.j;
        if (!TextUtils.isEmpty(str)) {
            this.B.g = str;
        }
        uk5.d(this.A, Q1(), this, new k(this), new a(this));
    }

    public final void X1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.a.b();
            this.a.n();
        }
    }

    public final void Y1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || C) {
            return;
        }
        C = true;
        us4.a().b(16, new h(this));
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    @JavascriptInterface
    public /* bridge */ /* synthetic */ void addJavascriptInterface() {
        super.addJavascriptInterface();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    @Deprecated
    public void addJavascriptInterface(Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, obj, str) == null) {
        }
    }

    public final dj8 buildGameDownloadJSPrompt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001386, dj8.class, getPageContext());
            if (runTask == null || runTask.getData() == null) {
                return null;
            }
            return (dj8) runTask.getData();
        }
        return (dj8) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public View createWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.t == null) {
                this.t = new TBAdWebView(getPageContext().getPageActivity());
                O1();
            }
            return this.t;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? TbadkCoreApplication.getInst().isGpuOpen() : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public View getWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.t : (View) invokeV.objValue;
    }

    public final void handleUploadResult(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048593, this, intent, i2) == null) && i2 == -1 && intent != null) {
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
                at4 j2 = at4.j("TBJS_COMMON_Image", "onImageUploadFinish", hashMap, 0L, false);
                if (this.w != null) {
                    this.w.c(j2);
                }
            } catch (JSONException e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void initCookie() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            nk5.c(getApplicationContext());
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void initWebView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    @Override // com.baidu.tieba.ad.webview.BaseAdWebView.d
    public void l1(@NonNull si0 si0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, si0Var) == null) {
            if (this.r) {
                X1();
                return;
            }
            if (this.z == null) {
                this.z = new wk5(new j(this));
            }
            String str = si0Var.g;
            HashMap hashMap = new HashMap();
            hashMap.put("ext", this.o);
            hashMap.put("charge_url", this.q);
            hashMap.put("apk_url", str);
            this.z.g(hashMap, wk5.c);
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void loadUrl(String str) {
        qk5 qk5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            if (this.y && (qk5Var = this.a) != null) {
                qk5Var.t();
            }
            TBAdWebView tBAdWebView = this.t;
            if (tBAdWebView != null) {
                tBAdWebView.loadUrl(str);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048598, this, i2, i3, intent) == null) && i2 == 12015) {
            handleUploadResult(intent, i3);
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public /* bridge */ /* synthetic */ void onClick(View view2) {
        super.onClick(view2);
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bundle) == null) {
            super.onCreate(bundle);
            MessageManager.getInstance().runTask(2001308, (Class) null);
            cj8 cj8Var = new cj8();
            this.u = cj8Var;
            cj8Var.a(new XiubaTbJsBridge(getPageContext()));
            this.u.a(new CommonTbJsBridge(getPageContext()));
            this.u.a(buildGameDownloadJSPrompt());
            if (this.e) {
                initCookie();
            }
            U1();
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
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

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void onReceivedError(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            TBAdWebView tBAdWebView = this.t;
            if (tBAdWebView != null) {
                this.b = tBAdWebView.getUrl();
                this.t.stopLoading();
            }
            if ((TextUtils.isEmpty(this.b) || !this.b.endsWith(Constant.FILE.SUFFIX.BUNDLE_SUFFIX)) && i2 != -1) {
                hideProgressBar();
                showNoDataView();
            }
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
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

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void setFullScreen() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.y = true;
            if (1 == 0 || this.a == null) {
                return;
            }
            runOnUiThread(new i(this));
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, broadcastReceiver) == null) {
            try {
                super.unregisterReceiver(broadcastReceiver);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void webViewDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            cj8 cj8Var = this.u;
            if (cj8Var != null) {
                cj8Var.g();
            }
            TBAdWebView tBAdWebView = this.t;
            if (tBAdWebView != null) {
                tBAdWebView.getSettings().setBuiltInZoomControls(true);
                this.t.setVisibility(8);
                qg.a().postDelayed(new g(this), ViewConfiguration.getZoomControlsTimeout() + 1000);
            }
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
}
