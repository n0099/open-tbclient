package com.baidu.tieba.ad.browser.newstyle;

import android.app.Activity;
import android.content.BroadcastReceiver;
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
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.webview.BaseAdWebView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.y.j;
import d.a.r0.r.y.l;
import d.a.r0.r.y.m;
import d.a.r0.r.y.n;
import d.a.r0.r.y.o;
import d.a.r0.r.y.q;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class AdWebViewActivity extends AdBaseWebViewActivity implements BaseAdWebView.d {
    public static /* synthetic */ Interceptable $ic;
    public static boolean sFrameLostTracked;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isShowFullScreen;
    public d.a.s0.h3.l0.a jsBridge;
    public d.a.s0.h3.l0.c jsCallback;
    public l mHybridBridge;
    public boolean mShowShareItem;
    public TBAdWebView mWebView;

    /* loaded from: classes5.dex */
    public class a implements d.a.s0.h3.l0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdWebViewActivity f13705a;

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
            this.f13705a = adWebViewActivity;
        }

        @Override // d.a.s0.h3.l0.c
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, jsPromptResult)) == null) {
                if (this.f13705a.jsBridge != null) {
                    return this.f13705a.jsBridge.c(str, jsPromptResult);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AdWebViewActivity f13706c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AdWebViewActivity adWebViewActivity, l lVar) {
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
            this.f13706c = adWebViewActivity;
        }

        @o(isAsync = false, value = "trackFPS")
        private void trackFPS() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                this.f13706c.trackFPS();
            }
        }

        @Override // d.a.r0.r.y.n
        public String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_Performance" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c extends n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AdWebViewActivity f13707c;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ShareItem f13708e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f13709f;

            public a(c cVar, ShareItem shareItem) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, shareItem};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f13709f = cVar;
                this.f13708e = shareItem;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f13709f.f13707c.mView.F(this.f13708e);
                }
            }
        }

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
            this.f13707c = adWebViewActivity;
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
                this.f13707c.mShareResultToFe = true;
            }
            d.a.c.e.m.e.a().post(new a(this, this.f13707c.createShareContent(optString, optString4, optString2, optString3)));
        }

        @Override // d.a.r0.r.y.n
        public String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_Share" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d extends n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AdWebViewActivity f13710c;

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
            this.f13710c = adWebViewActivity;
        }

        @o(isAsync = false, value = "viewHideSwitch")
        private void viewHideSwitch(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65537, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            String optString = jSONObject.optJSONObject("share").optString("value");
            if ("1".equals(optString)) {
                this.f13710c.mShowShareItem = true;
            } else if ("0".equals(optString)) {
                this.f13710c.mShowShareItem = false;
            }
            AdWebViewActivity adWebViewActivity = this.f13710c;
            adWebViewActivity.mView.A(adWebViewActivity.mShowShareItem);
        }

        @Override // d.a.r0.r.y.n
        public String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_UISwitch" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdWebViewActivity f13711e;

        public e(AdWebViewActivity adWebViewActivity) {
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
            this.f13711e = adWebViewActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f13711e.mWebView != null) {
                        this.f13711e.mWebView.destroy();
                        this.f13711e.mWebView = null;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdWebViewActivity f13712a;

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
            this.f13712a = adWebViewActivity;
        }

        @Override // d.a.r0.r.y.j
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
            d.a.c.e.n.a a2 = d.a.r0.m0.j.a();
            a2.a("frame_delta", sb.toString());
            BdStatisticsManager.getInstance().performance("webview", a2);
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdWebViewActivity f13713e;

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
            this.f13713e = adWebViewActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f13713e.mView.v();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h extends BaseAdWebView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AdWebViewActivity f13714c;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h f13715e;

            public a(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f13715e = hVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f13715e.f13714c.mView.r();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(AdWebViewActivity adWebViewActivity, BaseAdWebView baseAdWebView, Activity activity) {
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
            this.f13714c = adWebViewActivity;
        }

        @Override // com.baidu.tieba.ad.webview.BaseAdWebView.c, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                AdWebViewActivity adWebViewActivity = this.f13714c;
                TBAdWebView tBAdWebView = adWebViewActivity.mWebView;
                if (tBAdWebView == null) {
                    return;
                }
                adWebViewActivity.mUrl = str;
                tBAdWebView.loadUrl("javascript:window.local_obj.getIfFullScreen(document.getElementsByName(\"fc_fullscreen\")[0].content);");
                String title = this.f13714c.mWebView.getTitle();
                if (!StringUtils.isNull(title)) {
                    this.f13714c.mUrlTitle = title;
                }
                if (!this.f13714c.isShowFullScreen) {
                    AdWebViewActivity adWebViewActivity2 = this.f13714c;
                    adWebViewActivity2.mView.y(adWebViewActivity2.mUrlTitle);
                }
                AdWebViewActivity adWebViewActivity3 = this.f13714c;
                adWebViewActivity3.mView.x(adWebViewActivity3.mIsShowNavBar);
                AdWebViewActivity adWebViewActivity4 = this.f13714c;
                adWebViewActivity4.mView.A(adWebViewActivity4.isNeedShowShareItem());
                this.f13714c.hideProgressBar();
                this.f13714c.stopLoadTimer();
            }
        }

        @Override // com.baidu.tieba.ad.webview.BaseAdWebView.c, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                AdWebViewActivity adWebViewActivity = this.f13714c;
                if (adWebViewActivity.mWebView == null) {
                    return;
                }
                adWebViewActivity.mUrl = str;
                adWebViewActivity.showProgressBar();
                this.f13714c.startLoadTimer();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i2, str, str2) == null) {
                super.onReceivedError(webView, i2, str, str2);
                TBAdWebView tBAdWebView = this.f13714c.mWebView;
                if (tBAdWebView == null) {
                    return;
                }
                tBAdWebView.stopLoading();
                this.f13714c.stopLoadTimer();
                this.f13714c.onReceivedError(i2);
            }
        }

        @Override // com.baidu.tieba.ad.webview.BaseAdWebView.c, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            d.a.s0.q.c.b.c cVar;
            d.a.s0.q.c.b.c cVar2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                int i2 = d.a.s0.q.a.l().i(this.f13714c.getPageContext().getPageActivity(), new String[]{str});
                if (i2 == 1) {
                    this.f13714c.finish();
                    return true;
                } else if (i2 == 0) {
                    return true;
                } else {
                    AdWebViewActivity adWebViewActivity = this.f13714c;
                    if (adWebViewActivity.needHideDownloadWarning(adWebViewActivity.mUrl) && (cVar2 = this.f13714c.mView) != null) {
                        cVar2.t(false);
                    }
                    AdWebViewActivity adWebViewActivity2 = this.f13714c;
                    adWebViewActivity2.mUrl = str;
                    if (adWebViewActivity2.isShowFullScreen) {
                        this.f13714c.isShowFullScreen = false;
                        this.f13714c.runOnUiThread(new a(this));
                    }
                    if (URLUtil.isNetworkUrl(this.f13714c.mUrl)) {
                        this.f13714c.showProgressBar();
                        if (this.f13714c.isShowFullScreen && (cVar = this.f13714c.mView) != null) {
                            cVar.v();
                        }
                        return false;
                    }
                    AdWebViewActivity adWebViewActivity3 = this.f13714c;
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
        this.jsCallback = new a(this);
        this.mShowShareItem = true;
        this.isShowFullScreen = false;
    }

    private d.a.s0.h3.l0.b buildGameDownloadJSPrompt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001386, d.a.s0.h3.l0.b.class, getPageContext());
            if (runTask == null || runTask.getData() == null) {
                return null;
            }
            return (d.a.s0.h3.l0.b) runTask.getData();
        }
        return (d.a.s0.h3.l0.b) invokeV.objValue;
    }

    private void handleUploadResult(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65545, this, intent, i2) == null) && i2 == -1 && intent != null) {
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
                m j = m.j("TBJS_COMMON_Image", "onImageUploadFinish", hashMap, 0L, false);
                if (this.mHybridBridge != null) {
                    this.mHybridBridge.c(j);
                }
            } catch (JSONException e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    private void initDownloadData() {
        DownloadCacheKey h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            Intent intent = getIntent();
            String stringExtra = intent != null ? intent.getStringExtra(WebViewActivityConfig.TAG_DOWNLOAD_AD_ID) : "";
            if (!TextUtils.isEmpty(stringExtra)) {
                h2 = d.a.s0.q.d.e.c().g(stringExtra);
            } else {
                h2 = d.a.s0.q.d.e.c().h(this.mUrl);
            }
            if (h2 == null) {
                if (!TextUtils.isEmpty(stringExtra)) {
                    h2 = DownloadCacheKey.create(stringExtra, "");
                } else {
                    String str = this.mUrl;
                    if (str != null) {
                        String queryParameter = Uri.parse(str).getQueryParameter("url");
                        if (!TextUtils.isEmpty(queryParameter)) {
                            h2 = DownloadCacheKey.create(queryParameter.substring(Math.max(0, queryParameter.length() - 6), queryParameter.length() - 1), "");
                        }
                    }
                }
                if (h2 == null) {
                    h2 = DownloadCacheKey.create(String.valueOf(System.currentTimeMillis()), "");
                }
                d.a.s0.q.d.e.c().i(h2, null);
            }
            TBAdWebView tBAdWebView = this.mWebView;
            if (tBAdWebView == null) {
                return;
            }
            tBAdWebView.d(h2);
            this.mView.l(h2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackFPS() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || sFrameLostTracked) {
            return;
        }
        sFrameLostTracked = true;
        d.a.r0.r.y.g.a().b(16, new f(this));
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
            h hVar = new h(this, this.mWebView, this);
            this.mWebView.setWebViewClient(hVar);
            d.a.s0.q.c.b.b bVar = new d.a.s0.q.c.b.b(this);
            bVar.a(this.jsCallback);
            this.mWebView.setWebChromeClient(bVar);
            if (this.mEnableJs) {
                addJavascriptInterface();
            }
            CompatibleUtile.getInstance().removeJavascriptInterface(this.mWebView);
            boolean isHybridBridgeEnabled = TbadkCoreApplication.getInst().isHybridBridgeEnabled();
            l n = q.n(isHybridBridgeEnabled, this.mWebView, hVar, bVar, null);
            this.mHybridBridge = n;
            if (isHybridBridgeEnabled) {
                n.d(new b(this, n));
                n.d(new d.a.r0.r.y.s.a(n));
                n.d(new d.a.r0.r.y.s.c(n));
                n.d(new d.a.r0.r.y.s.b(n));
                n.d(new c(this, n));
                n.d(new d(this, n));
                n.d(new d.a.s0.q.c.b.a(n));
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

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, d.a.r0.k0.a
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
            d.a.s0.q.c.a.c(getApplicationContext());
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
        d.a.s0.q.c.b.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            if (this.isShowFullScreen && (cVar = this.mView) != null) {
                cVar.v();
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
            d.a.s0.h3.l0.a aVar = new d.a.s0.h3.l0.a();
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
    public void onDownloadStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.mView.o();
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
            callHiddenWebViewMethod(MissionEvent.MESSAGE_RESUME);
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
            runOnUiThread(new g(this));
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
            d.a.s0.h3.l0.a aVar = this.jsBridge;
            if (aVar != null) {
                aVar.f();
            }
            TBAdWebView tBAdWebView = this.mWebView;
            if (tBAdWebView != null) {
                tBAdWebView.getSettings().setBuiltInZoomControls(true);
                this.mWebView.setVisibility(8);
                d.a.c.e.m.e.a().postDelayed(new e(this), ViewConfiguration.getZoomControlsTimeout() + 1000);
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
