package com.baidu.tieba.ad.browser.newstyle;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;
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
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.URLUtil;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.repackage.as4;
import com.repackage.bs4;
import com.repackage.c85;
import com.repackage.cs4;
import com.repackage.ds4;
import com.repackage.ei0;
import com.repackage.fi0;
import com.repackage.fs4;
import com.repackage.hi0;
import com.repackage.hs4;
import com.repackage.ii5;
import com.repackage.is4;
import com.repackage.js4;
import com.repackage.li;
import com.repackage.mg;
import com.repackage.ni5;
import com.repackage.oh8;
import com.repackage.oi5;
import com.repackage.pg0;
import com.repackage.ph8;
import com.repackage.pi5;
import com.repackage.qh8;
import com.repackage.qi5;
import com.repackage.qm4;
import com.repackage.rg;
import com.repackage.ri5;
import com.repackage.rx0;
import com.repackage.ti5;
import com.repackage.u11;
import com.repackage.ug0;
import com.repackage.uh0;
import com.repackage.ui5;
import com.repackage.vr4;
import com.repackage.wi5;
import com.repackage.xg0;
import com.repackage.yr4;
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
    public static boolean sFrameLostTracked;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isShowFullScreen;
    public oh8 jsBridge;
    public qh8 jsCallback;
    public ei0 mDownloadBean;
    public ti5 mDownloadRectifyData;
    public wi5 mDownloadRectifyModel;
    public as4 mHybridBridge;
    public boolean mShowShareItem;
    public TBAdWebView mWebView;

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
    public class b implements pg0 {
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

        @Override // com.repackage.pg0
        public void a(boolean z, @Nullable Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, map) == null) {
                String p = ug0.p(map);
                if (TextUtils.isEmpty(p)) {
                    return;
                }
                this.a.doJsCallback(p);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements qh8 {
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

        @Override // com.repackage.qh8
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, jsPromptResult)) == null) {
                if (this.a.jsBridge != null) {
                    return this.a.jsBridge.c(str, jsPromptResult);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d extends cs4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdWebViewActivity c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(AdWebViewActivity adWebViewActivity, as4 as4Var) {
            super(as4Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adWebViewActivity, as4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((as4) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = adWebViewActivity;
        }

        @ds4(isAsync = false, value = "trackFPS")
        private void trackFPS() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                this.c.trackFPS();
            }
        }

        @Override // com.repackage.cs4
        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_Performance" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class e extends cs4 {
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
                    this.b.c.mView.D(this.a);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(AdWebViewActivity adWebViewActivity, as4 as4Var) {
            super(as4Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adWebViewActivity, as4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((as4) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = adWebViewActivity;
        }

        @ds4(isAsync = false, value = "share")
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
                this.c.mShareResultToFe = true;
            }
            mg.a().post(new a(this, this.c.createShareContent(optString, optString4, optString2, optString3)));
        }

        @Override // com.repackage.cs4
        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_Share" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class f extends cs4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdWebViewActivity c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(AdWebViewActivity adWebViewActivity, as4 as4Var) {
            super(as4Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adWebViewActivity, as4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((as4) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = adWebViewActivity;
        }

        @ds4(isAsync = false, value = "viewHideSwitch")
        private void viewHideSwitch(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65537, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            String optString = jSONObject.optJSONObject("share").optString("value");
            if ("1".equals(optString)) {
                this.c.mShowShareItem = true;
            } else if ("0".equals(optString)) {
                this.c.mShowShareItem = false;
            }
            AdWebViewActivity adWebViewActivity = this.c;
            adWebViewActivity.mView.y(adWebViewActivity.mShowShareItem);
        }

        @Override // com.repackage.cs4
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
                    if (this.a.mWebView != null) {
                        this.a.mWebView.destroy();
                        this.a.mWebView = null;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements yr4 {
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

        @Override // com.repackage.yr4
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
            rg a = c85.a();
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
                this.a.mView.t();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements wi5.b {
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

        @Override // com.repackage.wi5.b
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                this.a.mDownloadRectifyData = ti5.a(optJSONObject);
                if (this.a.mDownloadRectifyData == null) {
                    return;
                }
                this.a.handleDownloadRectifyResult();
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
                    this.a.c.mView.p();
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
                TBAdWebView tBAdWebView = adWebViewActivity.mWebView;
                if (tBAdWebView == null) {
                    return;
                }
                adWebViewActivity.mUrl = str;
                tBAdWebView.loadUrl("javascript:window.local_obj.getIfFullScreen(document.getElementsByName(\"fc_fullscreen\")[0].content);");
                String title = this.c.mWebView.getTitle();
                if (!StringUtils.isNull(title)) {
                    this.c.mUrlTitle = title;
                }
                if (!this.c.isShowFullScreen) {
                    AdWebViewActivity adWebViewActivity2 = this.c;
                    adWebViewActivity2.mView.w(adWebViewActivity2.mUrlTitle);
                }
                AdWebViewActivity adWebViewActivity3 = this.c;
                adWebViewActivity3.mView.v(adWebViewActivity3.mIsShowNavBar);
                AdWebViewActivity adWebViewActivity4 = this.c;
                adWebViewActivity4.mView.y(adWebViewActivity4.isNeedShowShareItem());
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
                if (adWebViewActivity.mWebView == null) {
                    return;
                }
                adWebViewActivity.mUrl = str;
                adWebViewActivity.showProgressBar();
                this.c.startLoadTimer();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i, str, str2) == null) {
                super.onReceivedError(webView, i, str, str2);
                TBAdWebView tBAdWebView = this.c.mWebView;
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
            qi5 qi5Var;
            qi5 qi5Var2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                if (this.c.handleVendorAdScheme(str)) {
                    return true;
                }
                int i = ii5.l().i(this.c.getPageContext().getPageActivity(), new String[]{str});
                if (i == 1) {
                    this.c.finish();
                    return true;
                } else if (i == 0) {
                    return true;
                } else {
                    AdWebViewActivity adWebViewActivity = this.c;
                    if (adWebViewActivity.needHideDownloadWarning(adWebViewActivity.mUrl) && (qi5Var2 = this.c.mView) != null) {
                        qi5Var2.r(false);
                    }
                    AdWebViewActivity adWebViewActivity2 = this.c;
                    adWebViewActivity2.mUrl = str;
                    if (adWebViewActivity2.isShowFullScreen) {
                        this.c.isShowFullScreen = false;
                        this.c.runOnUiThread(new a(this));
                    }
                    if (URLUtil.isNetworkUrl(this.c.mUrl)) {
                        this.c.showProgressBar();
                        if (this.c.isShowFullScreen && (qi5Var = this.c.mView) != null) {
                            qi5Var.t();
                        }
                        return false;
                    }
                    AdWebViewActivity adWebViewActivity3 = this.c;
                    adWebViewActivity3.tryDeeplink(adWebViewActivity3.mUrl);
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
        this.jsCallback = new c(this);
        this.mShowShareItem = true;
        this.isShowFullScreen = false;
    }

    private ph8 buildGameDownloadJSPrompt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001386, ph8.class, getPageContext());
            if (runTask == null || runTask.getData() == null) {
                return null;
            }
            return (ph8) runTask.getData();
        }
        return (ph8) invokeV.objValue;
    }

    private ApkDownloadView createRectifyDownloadView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            ApkDownloadView apkDownloadView = new ApkDownloadView(this);
            apkDownloadView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            apkDownloadView.setBackgroundSkin(R.drawable.obfuscated_res_0x7f0804a6);
            apkDownloadView.setForegroundSkin(R.color.black_alpha15);
            apkDownloadView.setTextColor(SkinManager.getColor(R.color.CAM_X0101));
            apkDownloadView.setTextSize(R.dimen.tbds42);
            apkDownloadView.setTextColorInitSkin(R.color.CAM_X0101);
            apkDownloadView.setTextColorSkin(R.color.CAM_X0101);
            apkDownloadView.c();
            new ri5(apkDownloadView, this.mDownloadBean);
            return apkDownloadView;
        }
        return (ApkDownloadView) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDownloadRectifyResult() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.w(ClogBuilder.LogType.FREE_SHOW).o(String.valueOf(0)).t("DOWNLOAD_RECTIFY").i(String.valueOf(this.mDownloadRectifyData.a)).n(this.mAdExtInfo);
            rx0.c(clogBuilder);
            int i2 = this.mDownloadRectifyData.a;
            if (i2 == 1) {
                startDownload();
            } else if (i2 != 2 && i2 != 3) {
                makeToast();
            } else {
                showDownloadDialog();
            }
        }
    }

    private void handleUploadResult(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65551, this, intent, i2) == null) && i2 == -1 && intent != null) {
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
                bs4 j2 = bs4.j("TBJS_COMMON_Image", "onImageUploadFinish", hashMap, 0L, false);
                if (this.mHybridBridge != null) {
                    this.mHybridBridge.c(j2);
                }
            } catch (JSONException e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleVendorAdScheme(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, this, str)) == null) {
            String str2 = xg0.d().k() + "://vendor/ad";
            if (str.startsWith(str2)) {
                if (str.startsWith(str2 + "/download")) {
                    return false;
                }
                if (str.startsWith(str2 + "/registerDeeplink")) {
                    return false;
                }
                return u11.b.a().a(this, str, this.mOriginUrl, new b(this));
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void initDownloadData() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65553, this) == null) || this.mWebView == null) {
            return;
        }
        Intent intent = getIntent();
        String stringExtra = intent != null ? intent.getStringExtra(WebViewActivityConfig.TAG_DOWNLOAD_AD_ID) : "";
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = Uri.parse(this.mUrl).getQueryParameter("url");
        }
        ei0 createDownloadBean = createDownloadBean(stringExtra);
        this.mDownloadBean = createDownloadBean;
        this.mWebView.d(createDownloadBean);
        this.mView.k(this.mDownloadBean);
    }

    private void makeToast() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            li.O(this, "第三方应用未经百度审核");
        }
    }

    private void showDownloadDialog() {
        ti5 ti5Var;
        qm4 qm4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65555, this) == null) || this.mDownloadBean == null || (ti5Var = this.mDownloadRectifyData) == null || (qm4Var = ti5Var.b) == null) {
            return;
        }
        String str = qm4Var.j;
        if (!TextUtils.isEmpty(str)) {
            this.mDownloadBean.g = str;
        }
        ui5.d(this.mDownloadRectifyData, createRectifyDownloadView(), this, new k(this), new a(this));
    }

    private void startDownload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            this.mView.b();
            this.mView.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackFPS() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65557, this) == null) || sFrameLostTracked) {
            return;
        }
        sFrameLostTracked = true;
        vr4.a().b(16, new h(this));
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
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, str) == null) {
        }
    }

    public void configWebView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mWebView.getSettings().setDatabasePath(getApplicationContext().getDir(NgWebView.APP_DATABASE_PATH, 0).getAbsolutePath());
            this.mWebView.setHorizontalScrollbarOverlay(false);
            this.mWebView.setInitialScale(100);
            this.mWebView.setScrollBarStyle(33554432);
            if (this.mWebView.getLayoutParams() == null) {
                this.mWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.mWebView.setDownloadStartListener(this);
            l lVar = new l(this, this.mWebView, this);
            this.mWebView.setWebViewClient(lVar);
            pi5 pi5Var = new pi5(this);
            pi5Var.a(this.jsCallback);
            this.mWebView.setWebChromeClient(pi5Var);
            if (this.mEnableJs) {
                addJavascriptInterface();
            }
            CompatibleUtile.getInstance().removeJavascriptInterface(this.mWebView);
            boolean isHybridBridgeEnabled = TbadkCoreApplication.getInst().isHybridBridgeEnabled();
            as4 m = fs4.m(isHybridBridgeEnabled, this.mWebView, lVar, pi5Var, null);
            this.mHybridBridge = m;
            if (isHybridBridgeEnabled) {
                m.d(new d(this, m));
                m.d(new hs4(m));
                m.d(new js4(m));
                m.d(new is4(m));
                m.d(new e(this, m));
                m.d(new f(this, m));
                m.d(new oi5(m));
            }
        }
    }

    public ei0 createDownloadBean(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (uh0.a().query(str) != null) {
                return uh0.a().query(str);
            }
            ei0 ei0Var = new ei0();
            ei0Var.g(str);
            hi0 hi0Var = new hi0();
            hi0Var.j = str;
            hi0Var.a = this.mAdExtInfo;
            ei0Var.p = hi0Var;
            fi0 fi0Var = new fi0();
            fi0Var.a = "LANDING_PAGE";
            ei0Var.q = fi0Var;
            return ei0Var;
        }
        return (ei0) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public View createWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.mWebView == null) {
                this.mWebView = new TBAdWebView(getPageContext().getPageActivity());
                configWebView();
            }
            return this.mWebView;
        }
        return (View) invokeV.objValue;
    }

    public void doJsCallback(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || this.mWebView == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.mWebView.loadUrl(str);
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void finish() {
        super.finish();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.repackage.f75
    public /* bridge */ /* synthetic */ String getCurrentPageKey() {
        return super.getCurrentPageKey();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? TbadkCoreApplication.getInst().isGpuOpen() : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public View getWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mWebView : (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.adp.base.BdBaseActivity, android.os.Handler.Callback
    public /* bridge */ /* synthetic */ boolean handleMessage(Message message) {
        return super.handleMessage(message);
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public /* bridge */ /* synthetic */ void hideCrashTip() {
        super.hideCrashTip();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public /* bridge */ /* synthetic */ void hideNoDataView() {
        super.hideNoDataView();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity
    public /* bridge */ /* synthetic */ void hideProgressBar() {
        super.hideProgressBar();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void initCookie() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            ni5.c(getApplicationContext());
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void initWebView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public /* bridge */ /* synthetic */ boolean isNeedShowMenuItem() {
        return super.isNeedShowMenuItem();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public /* bridge */ /* synthetic */ boolean isNeedShowNavigationBar() {
        return super.isNeedShowNavigationBar();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public /* bridge */ /* synthetic */ boolean isNeedShowShareItem() {
        return super.isNeedShowShareItem();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void loadUrl(String str) {
        qi5 qi5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            if (this.isShowFullScreen && (qi5Var = this.mView) != null) {
                qi5Var.t();
            }
            TBAdWebView tBAdWebView = this.mWebView;
            if (tBAdWebView != null) {
                tBAdWebView.loadUrl(str);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048597, this, i2, i3, intent) == null) && i2 == 12015) {
            handleUploadResult(intent, i3);
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void onBackPressed() {
        super.onBackPressed();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity
    public /* bridge */ /* synthetic */ void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public /* bridge */ /* synthetic */ void onClick(View view2) {
        super.onClick(view2);
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bundle) == null) {
            super.onCreate(bundle);
            MessageManager.getInstance().runTask(2001308, (Class) null);
            oh8 oh8Var = new oh8();
            this.jsBridge = oh8Var;
            oh8Var.a(new XiubaTbJsBridge(getPageContext()));
            this.jsBridge.a(new CommonTbJsBridge(getPageContext()));
            this.jsBridge.a(buildGameDownloadJSPrompt());
            if (this.mNeedCookie) {
                initCookie();
            }
            initDownloadData();
        }
    }

    @Override // com.baidu.tieba.ad.webview.BaseAdWebView.d
    public void onDownloadStart(@NonNull ei0 ei0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, ei0Var) == null) {
            if (this.isWitheList) {
                startDownload();
                return;
            }
            if (this.mDownloadRectifyModel == null) {
                this.mDownloadRectifyModel = new wi5(new j(this));
            }
            String str = ei0Var.g;
            HashMap hashMap = new HashMap();
            hashMap.put("ext", this.mAdExtInfo);
            hashMap.put("charge_url", this.mOriginUrl);
            hashMap.put("apk_url", str);
            this.mDownloadRectifyModel.g(hashMap, wi5.c);
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public /* bridge */ /* synthetic */ boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onPause();
            TBAdWebView tBAdWebView = this.mWebView;
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
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            TBAdWebView tBAdWebView = this.mWebView;
            if (tBAdWebView != null) {
                this.mUrl = tBAdWebView.getUrl();
                this.mWebView.stopLoading();
            }
            if ((TextUtils.isEmpty(this.mUrl) || !this.mUrl.endsWith(Constant.FILE.SUFFIX.BUNDLE_SUFFIX)) && i2 != -1) {
                hideProgressBar();
                showNoDataView();
            }
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.onResume();
            TBAdWebView tBAdWebView = this.mWebView;
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
    public /* bridge */ /* synthetic */ void refresh() {
        super.refresh();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public /* bridge */ /* synthetic */ void refreshIgnoreFormat() {
        super.refreshIgnoreFormat();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public /* bridge */ /* synthetic */ void releaseResouce() {
        super.releaseResouce();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public /* bridge */ /* synthetic */ void setAutoChangeStyle(boolean z) {
        super.setAutoChangeStyle(z);
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void setFullScreen() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.isShowFullScreen = true;
            if (1 == 0 || this.mView == null) {
                return;
            }
            runOnUiThread(new i(this));
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public /* bridge */ /* synthetic */ void setNavBarVisibility(boolean z) {
        super.setNavBarVisibility(z);
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public /* bridge */ /* synthetic */ void showCrashTip() {
        super.showCrashTip();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public /* bridge */ /* synthetic */ void showNoDataView() {
        super.showNoDataView();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity
    public /* bridge */ /* synthetic */ void showProgressBar() {
        super.showProgressBar();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, broadcastReceiver) == null) {
            try {
                super.unregisterReceiver(broadcastReceiver);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void webViewDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            oh8 oh8Var = this.jsBridge;
            if (oh8Var != null) {
                oh8Var.g();
            }
            TBAdWebView tBAdWebView = this.mWebView;
            if (tBAdWebView != null) {
                tBAdWebView.getSettings().setBuiltInZoomControls(true);
                this.mWebView.setVisibility(8);
                mg.a().postDelayed(new g(this), ViewConfiguration.getZoomControlsTimeout() + 1000);
            }
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public boolean webViewGoBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public /* bridge */ /* synthetic */ void finish(int i2, Intent intent) {
        super.finish(i2, intent);
    }
}
