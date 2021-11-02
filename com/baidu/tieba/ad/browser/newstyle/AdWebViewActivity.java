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
import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.z.l;
import b.a.q0.s.z.m;
import b.a.q0.s.z.n;
import b.a.q0.s.z.o;
import b.a.q0.s.z.q;
import b.a.r0.r.g.a;
import b.a.r0.z2.z;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class AdWebViewActivity extends AdBaseWebViewActivity implements BaseAdWebView.d {
    public static /* synthetic */ Interceptable $ic;
    public static boolean sFrameLostTracked;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isShowFullScreen;
    public b.a.r0.l3.n0.a jsBridge;
    public b.a.r0.l3.n0.c jsCallback;
    public DownloadCacheKey mCacheKey;
    public b.a.r0.r.e.j.a mDownloadRectifyData;
    public b.a.r0.r.g.a mDownloadRectifyModel;
    public l mHybridBridge;
    public b.a.r0.r.e.h.b mRectifyDownloadListener;
    public boolean mShowShareItem;
    public TBAdWebView mWebView;

    /* loaded from: classes9.dex */
    public class a implements DialogInterface.OnShowListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdWebViewActivity f46651e;

        public a(AdWebViewActivity adWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46651e = adWebViewActivity;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                AdWebViewActivity adWebViewActivity = this.f46651e;
                if (adWebViewActivity.mCacheKey == null || adWebViewActivity.mRectifyDownloadListener == null) {
                    return;
                }
                b.a.r0.r.e.e c2 = b.a.r0.r.e.e.c();
                AdWebViewActivity adWebViewActivity2 = this.f46651e;
                c2.i(adWebViewActivity2.mCacheKey, adWebViewActivity2.mRectifyDownloadListener);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements b.a.r0.l3.n0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdWebViewActivity f46652a;

        public b(AdWebViewActivity adWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46652a = adWebViewActivity;
        }

        @Override // b.a.r0.l3.n0.c
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, jsPromptResult)) == null) {
                if (this.f46652a.jsBridge != null) {
                    return this.f46652a.jsBridge.c(str, jsPromptResult);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class c extends n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AdWebViewActivity f46653c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(AdWebViewActivity adWebViewActivity, l lVar) {
            super(lVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adWebViewActivity, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((l) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46653c = adWebViewActivity;
        }

        @o(isAsync = false, value = "trackFPS")
        private void trackFPS() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                this.f46653c.trackFPS();
            }
        }

        @Override // b.a.q0.s.z.n
        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_Performance" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class d extends n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AdWebViewActivity f46654c;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ShareItem f46655e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f46656f;

            public a(d dVar, ShareItem shareItem) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, shareItem};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f46656f = dVar;
                this.f46655e = shareItem;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f46656f.f46654c.mView.G(this.f46655e);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(AdWebViewActivity adWebViewActivity, l lVar) {
            super(lVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adWebViewActivity, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((l) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46654c = adWebViewActivity;
        }

        @o(isAsync = false, value = "share")
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
                this.f46654c.mShareResultToFe = true;
            }
            b.a.e.e.m.e.a().post(new a(this, this.f46654c.createShareContent(optString, optString4, optString2, optString3)));
        }

        @Override // b.a.q0.s.z.n
        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_Share" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class e extends n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AdWebViewActivity f46657c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(AdWebViewActivity adWebViewActivity, l lVar) {
            super(lVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adWebViewActivity, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((l) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46657c = adWebViewActivity;
        }

        @o(isAsync = false, value = "viewHideSwitch")
        private void viewHideSwitch(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65537, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            String optString = jSONObject.optJSONObject("share").optString("value");
            if ("1".equals(optString)) {
                this.f46657c.mShowShareItem = true;
            } else if ("0".equals(optString)) {
                this.f46657c.mShowShareItem = false;
            }
            AdWebViewActivity adWebViewActivity = this.f46657c;
            adWebViewActivity.mView.B(adWebViewActivity.mShowShareItem);
        }

        @Override // b.a.q0.s.z.n
        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_UISwitch" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdWebViewActivity f46658e;

        public f(AdWebViewActivity adWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46658e = adWebViewActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f46658e.mWebView != null) {
                        this.f46658e.mWebView.destroy();
                        this.f46658e.mWebView = null;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements b.a.q0.s.z.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdWebViewActivity f46659a;

        public g(AdWebViewActivity adWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46659a = adWebViewActivity;
        }

        @Override // b.a.q0.s.z.j
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
            b.a.e.e.n.a a2 = b.a.q0.q0.j.a();
            a2.a("frame_delta", sb.toString());
            BdStatisticsManager.getInstance().performance(AlbumActivityConfig.FROM_WEB_VIEW, a2);
        }
    }

    /* loaded from: classes9.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdWebViewActivity f46660e;

        public h(AdWebViewActivity adWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46660e = adWebViewActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46660e.mView.w();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdWebViewActivity f46661a;

        public i(AdWebViewActivity adWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46661a = adWebViewActivity;
        }

        @Override // b.a.r0.r.g.a.b
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                this.f46661a.mDownloadRectifyData = b.a.r0.r.e.j.a.a(optJSONObject);
                if (this.f46661a.mDownloadRectifyData == null) {
                    return;
                }
                this.f46661a.handleDownloadRectifyResult();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdWebViewActivity f46662e;

        public j(AdWebViewActivity adWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46662e = adWebViewActivity;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                AdWebViewActivity adWebViewActivity = this.f46662e;
                if (adWebViewActivity.mCacheKey == null || adWebViewActivity.mRectifyDownloadListener == null) {
                    return;
                }
                b.a.r0.r.e.e c2 = b.a.r0.r.e.e.c();
                AdWebViewActivity adWebViewActivity2 = this.f46662e;
                c2.q(adWebViewActivity2.mCacheKey, adWebViewActivity2.mRectifyDownloadListener);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class k extends BaseAdWebView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AdWebViewActivity f46663c;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ k f46664e;

            public a(k kVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f46664e = kVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f46664e.f46663c.mView.s();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(AdWebViewActivity adWebViewActivity, BaseAdWebView baseAdWebView, Activity activity) {
            super(baseAdWebView, activity);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adWebViewActivity, baseAdWebView, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((BaseAdWebView) objArr2[0], (Activity) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46663c = adWebViewActivity;
        }

        @Override // com.baidu.tieba.ad.webview.BaseAdWebView.c, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                AdWebViewActivity adWebViewActivity = this.f46663c;
                TBAdWebView tBAdWebView = adWebViewActivity.mWebView;
                if (tBAdWebView == null) {
                    return;
                }
                adWebViewActivity.mUrl = str;
                tBAdWebView.loadUrl("javascript:window.local_obj.getIfFullScreen(document.getElementsByName(\"fc_fullscreen\")[0].content);");
                String title = this.f46663c.mWebView.getTitle();
                if (!StringUtils.isNull(title)) {
                    this.f46663c.mUrlTitle = title;
                }
                if (!this.f46663c.isShowFullScreen) {
                    AdWebViewActivity adWebViewActivity2 = this.f46663c;
                    adWebViewActivity2.mView.z(adWebViewActivity2.mUrlTitle);
                }
                AdWebViewActivity adWebViewActivity3 = this.f46663c;
                adWebViewActivity3.mView.y(adWebViewActivity3.mIsShowNavBar);
                AdWebViewActivity adWebViewActivity4 = this.f46663c;
                adWebViewActivity4.mView.B(adWebViewActivity4.isNeedShowShareItem());
                this.f46663c.hideProgressBar();
                this.f46663c.stopLoadTimer();
            }
        }

        @Override // com.baidu.tieba.ad.webview.BaseAdWebView.c, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                AdWebViewActivity adWebViewActivity = this.f46663c;
                if (adWebViewActivity.mWebView == null) {
                    return;
                }
                adWebViewActivity.mUrl = str;
                adWebViewActivity.showProgressBar();
                this.f46663c.startLoadTimer();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i2, str, str2) == null) {
                super.onReceivedError(webView, i2, str, str2);
                TBAdWebView tBAdWebView = this.f46663c.mWebView;
                if (tBAdWebView == null) {
                    return;
                }
                tBAdWebView.stopLoading();
                this.f46663c.stopLoadTimer();
                this.f46663c.onReceivedError(i2);
            }
        }

        @Override // com.baidu.tieba.ad.webview.BaseAdWebView.c, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            b.a.r0.r.d.b.c cVar;
            b.a.r0.r.d.b.c cVar2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                int i2 = b.a.r0.r.a.l().i(this.f46663c.getPageContext().getPageActivity(), new String[]{str});
                if (i2 == 1) {
                    this.f46663c.finish();
                    return true;
                } else if (i2 == 0) {
                    return true;
                } else {
                    AdWebViewActivity adWebViewActivity = this.f46663c;
                    if (adWebViewActivity.needHideDownloadWarning(adWebViewActivity.mUrl) && (cVar2 = this.f46663c.mView) != null) {
                        cVar2.u(false);
                    }
                    AdWebViewActivity adWebViewActivity2 = this.f46663c;
                    adWebViewActivity2.mUrl = str;
                    if (adWebViewActivity2.isShowFullScreen) {
                        this.f46663c.isShowFullScreen = false;
                        this.f46663c.runOnUiThread(new a(this));
                    }
                    if (URLUtil.isNetworkUrl(this.f46663c.mUrl)) {
                        this.f46663c.showProgressBar();
                        if (this.f46663c.isShowFullScreen && (cVar = this.f46663c.mView) != null) {
                            cVar.w();
                        }
                        return false;
                    }
                    AdWebViewActivity adWebViewActivity3 = this.f46663c;
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
        this.jsCallback = new b(this);
        this.mShowShareItem = true;
        this.isShowFullScreen = false;
    }

    private b.a.r0.l3.n0.b buildGameDownloadJSPrompt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001386, b.a.r0.l3.n0.b.class, getPageContext());
            if (runTask == null || runTask.getData() == null) {
                return null;
            }
            return (b.a.r0.l3.n0.b) runTask.getData();
        }
        return (b.a.r0.l3.n0.b) invokeV.objValue;
    }

    private ApkDownloadView createRectifyDownloadView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            ApkDownloadView apkDownloadView = new ApkDownloadView(this);
            apkDownloadView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            apkDownloadView.setBackgroundSkin(R.drawable.download_rectifg_btn_bg);
            apkDownloadView.setForegroundSkin(R.color.black_alpha15);
            apkDownloadView.setTextColor(SkinManager.getColor(R.color.CAM_X0101));
            apkDownloadView.setTextSize(R.dimen.tbds42);
            apkDownloadView.setTextColorInitSkin(R.color.CAM_X0101);
            apkDownloadView.setTextColorSkin(R.color.CAM_X0101);
            apkDownloadView.changeSkin();
            AdDownloadData b2 = b.a.r0.r.e.e.c().b(this.mCacheKey);
            b.a.r0.r.d.b.d.a aVar = new b.a.r0.r.d.b.d.a(apkDownloadView, b2);
            this.mRectifyDownloadListener = new b.a.r0.r.e.h.b(aVar);
            if (b2.extra().getPercent() > 0) {
                aVar.e(b2);
            }
            DownloadData downloadData = new DownloadData(b2.getDownloadKey());
            downloadData.setUrl(b2.getDownloadUrl());
            downloadData.setName(b2.pkgName());
            downloadData.setNotifyId(b.a.e.e.m.b.e(b2.adId(), 0));
            if (z.q(this.mCacheKey.mPackageName)) {
                downloadData.setStatus(8);
            } else {
                downloadData.setStatus(apkDownloadView.getDownloadStatus());
            }
            apkDownloadView.setData(downloadData);
            return apkDownloadView;
        }
        return (ApkDownloadView) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDownloadRectifyResult() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            b.a.r0.z2.l0.d.d("DOWNLOAD_RECTIFY", this.mAdExtInfo, 0, 103, String.valueOf(this.mDownloadRectifyData.f22997a));
            int i2 = this.mDownloadRectifyData.f22997a;
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
                m j2 = m.j("TBJS_COMMON_Image", "onImageUploadFinish", hashMap, 0L, false);
                if (this.mHybridBridge != null) {
                    this.mHybridBridge.c(j2);
                }
            } catch (JSONException e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    private void initDownloadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            Intent intent = getIntent();
            String stringExtra = intent != null ? intent.getStringExtra(WebViewActivityConfig.TAG_DOWNLOAD_AD_ID) : "";
            if (!TextUtils.isEmpty(stringExtra)) {
                this.mCacheKey = b.a.r0.r.e.e.c().g(stringExtra);
            } else {
                this.mCacheKey = b.a.r0.r.e.e.c().h(this.mUrl);
            }
            if (this.mCacheKey == null) {
                if (!TextUtils.isEmpty(stringExtra)) {
                    this.mCacheKey = DownloadCacheKey.create(stringExtra, "");
                } else {
                    String str = this.mUrl;
                    if (str != null) {
                        String queryParameter = Uri.parse(str).getQueryParameter("url");
                        if (!TextUtils.isEmpty(queryParameter)) {
                            this.mCacheKey = DownloadCacheKey.create(queryParameter.substring(Math.max(0, queryParameter.length() - 6), queryParameter.length() - 1), "");
                        }
                    }
                }
                if (this.mCacheKey == null) {
                    this.mCacheKey = DownloadCacheKey.create(String.valueOf(System.currentTimeMillis()), "");
                }
                b.a.r0.r.e.e.c().i(this.mCacheKey, null);
            }
            TBAdWebView tBAdWebView = this.mWebView;
            if (tBAdWebView == null) {
                return;
            }
            tBAdWebView.inputDownloadCachekey(this.mCacheKey);
            this.mView.m(this.mCacheKey);
        }
    }

    private void makeToast() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            b.a.e.e.p.l.M(this, "第三方应用未经百度审核");
        }
    }

    private void showDownloadDialog() {
        b.a.r0.r.e.j.a aVar;
        b.a.q0.s.q.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65554, this) == null) || this.mCacheKey == null || (aVar = this.mDownloadRectifyData) == null || (cVar = aVar.f22998b) == null) {
            return;
        }
        String str = cVar.j;
        if (!TextUtils.isEmpty(str)) {
            this.mCacheKey.mDownloadUrl = str;
            b.a.r0.r.e.e.c().b(this.mCacheKey).setupDownloadUrl(str);
        }
        b.a.r0.r.e.j.b.d(this.mDownloadRectifyData, createRectifyDownloadView(), this, new j(this), new a(this));
    }

    private void startDownload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            this.mView.d();
            b.a.r0.r.e.e.c().l(this.mCacheKey, null);
            this.mView.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackFPS() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65556, this) == null) || sFrameLostTracked) {
            return;
        }
        sFrameLostTracked = true;
        b.a.q0.s.z.g.a().b(16, new g(this));
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
            this.mWebView.getSettings().setDatabasePath(getApplicationContext().getDir("databases", 0).getAbsolutePath());
            this.mWebView.setHorizontalScrollbarOverlay(false);
            this.mWebView.setInitialScale(100);
            this.mWebView.setScrollBarStyle(33554432);
            if (this.mWebView.getLayoutParams() == null) {
                this.mWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.mWebView.setDownloadStartListener(this);
            k kVar = new k(this, this.mWebView, this);
            this.mWebView.setWebViewClient(kVar);
            b.a.r0.r.d.b.b bVar = new b.a.r0.r.d.b.b(this);
            bVar.a(this.jsCallback);
            this.mWebView.setWebChromeClient(bVar);
            if (this.mEnableJs) {
                addJavascriptInterface();
            }
            CompatibleUtile.getInstance().removeJavascriptInterface(this.mWebView);
            boolean isHybridBridgeEnabled = TbadkCoreApplication.getInst().isHybridBridgeEnabled();
            l m = q.m(isHybridBridgeEnabled, this.mWebView, kVar, bVar, null);
            this.mHybridBridge = m;
            if (isHybridBridgeEnabled) {
                m.d(new c(this, m));
                m.d(new b.a.q0.s.z.s.a(m));
                m.d(new b.a.q0.s.z.s.c(m));
                m.d(new b.a.q0.s.z.s.b(m));
                m.d(new d(this, m));
                m.d(new e(this, m));
                m.d(new b.a.r0.r.d.b.a(m));
            }
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public View createWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.mWebView == null) {
                this.mWebView = new TBAdWebView(getPageContext().getPageActivity());
                configWebView();
            }
            return this.mWebView;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void finish() {
        super.finish();
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, b.a.q0.o0.a
    public /* bridge */ /* synthetic */ String getCurrentPageKey() {
        return super.getCurrentPageKey();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? TbadkCoreApplication.getInst().isGpuOpen() : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public View getWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mWebView : (View) invokeV.objValue;
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
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            b.a.r0.r.d.a.c(getApplicationContext());
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void initWebView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
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
        b.a.r0.r.d.b.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            if (this.isShowFullScreen && (cVar = this.mView) != null) {
                cVar.w();
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
        if ((interceptable == null || interceptable.invokeIIL(1048595, this, i2, i3, intent) == null) && i2 == 12015) {
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
    public /* bridge */ /* synthetic */ void onClick(View view) {
        super.onClick(view);
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bundle) == null) {
            super.onCreate(bundle);
            MessageManager.getInstance().runTask(2001308, (Class) null);
            b.a.r0.l3.n0.a aVar = new b.a.r0.l3.n0.a();
            this.jsBridge = aVar;
            aVar.a(new XiubaTbJsBridge(getPageContext()));
            this.jsBridge.a(new CommonTbJsBridge(getPageContext()));
            this.jsBridge.a(buildGameDownloadJSPrompt());
            if (this.mNeedCookie) {
                initCookie();
            }
            initDownloadData();
        }
    }

    @Override // com.baidu.tieba.ad.webview.BaseAdWebView.d
    public void onDownloadStart(@NonNull DownloadCacheKey downloadCacheKey) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, downloadCacheKey) == null) {
            if (this.isWitheList) {
                startDownload();
                return;
            }
            if (this.mDownloadRectifyModel == null) {
                this.mDownloadRectifyModel = new b.a.r0.r.g.a(new i(this));
            }
            String str = downloadCacheKey.mDownloadUrl;
            HashMap hashMap = new HashMap();
            hashMap.put("ext", this.mAdExtInfo);
            hashMap.put("charge_url", this.mOriginUrl);
            hashMap.put("apk_url", str);
            this.mDownloadRectifyModel.g(hashMap, "https://afdconf.baidu.com/afd/download");
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public /* bridge */ /* synthetic */ boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
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
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            TBAdWebView tBAdWebView = this.mWebView;
            if (tBAdWebView != null) {
                this.mUrl = tBAdWebView.getUrl();
                this.mWebView.stopLoading();
            }
            if ((TextUtils.isEmpty(this.mUrl) || !this.mUrl.endsWith(".apk")) && i2 != -1) {
                hideProgressBar();
                showNoDataView();
            }
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.isShowFullScreen = true;
            if (1 == 0 || this.mView == null) {
                return;
            }
            runOnUiThread(new h(this));
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
        if (interceptable == null || interceptable.invokeL(1048614, this, broadcastReceiver) == null) {
            try {
                super.unregisterReceiver(broadcastReceiver);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void webViewDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            b.a.r0.l3.n0.a aVar = this.jsBridge;
            if (aVar != null) {
                aVar.f();
            }
            TBAdWebView tBAdWebView = this.mWebView;
            if (tBAdWebView != null) {
                tBAdWebView.getSettings().setBuiltInZoomControls(true);
                this.mWebView.setVisibility(8);
                b.a.e.e.m.e.a().postDelayed(new f(this), ViewConfiguration.getZoomControlsTimeout() + 1000);
            }
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public boolean webViewGoBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public /* bridge */ /* synthetic */ void finish(int i2, Intent intent) {
        super.finish(i2, intent);
    }
}
