package com.baidu.tieba.frs.gametabs;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.DownloadListener;
import android.webkit.JsPromptResult;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.livesdk.api.share.Share;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BaseWebViewFragment;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.HybridUtilsBridgeHandler;
import com.baidu.tbadk.browser.TbChannelJsInterface;
import com.baidu.tbadk.browser.XiubaTbJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.hybrid.NamedBridgeHandler;
import com.baidu.tbadk.core.hybrid.ScrollBridgeWebview;
import com.baidu.tbadk.core.hybrid.WebViewBridge;
import com.baidu.tbadk.core.hybrid.handlers.ClipboardBridgeHandler;
import com.baidu.tbadk.core.hybrid.handlers.ImageOperateBridgeHandler;
import com.baidu.tbadk.core.hybrid.handlers.ShareDialogBridgeHandler;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.bh;
import com.baidu.tieba.by4;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.dq4;
import com.baidu.tieba.ey4;
import com.baidu.tieba.gh;
import com.baidu.tieba.gy4;
import com.baidu.tieba.hy4;
import com.baidu.tieba.ig5;
import com.baidu.tieba.iy4;
import com.baidu.tieba.nf5;
import com.baidu.tieba.rl5;
import com.baidu.tieba.ux8;
import com.baidu.tieba.vx8;
import com.baidu.tieba.wu6;
import com.baidu.tieba.wx8;
import com.baidu.tieba.yg;
import com.baidu.tieba.yo6;
import com.baidu.tieba.yu6;
import com.baidu.tieba.zu6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SpecialFrsWebFragment extends BaseWebViewFragment implements yo6 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean A;
    public static HashMap<String, String> B;
    public transient /* synthetic */ FieldHolder $fh;
    public yu6 e;
    public String f;
    public String g;
    public int h;
    public ScrollBridgeWebview i;
    public View j;
    public NoNetworkView k;
    public FrameLayout l;
    public FrameLayout m;
    public ux8 n;
    public zu6 o;
    public gy4 p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public String v;
    public wx8 w;
    public CustomMessageListener x;
    public CustomMessageListener y;
    public final View.OnClickListener z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialFrsWebFragment a;

        public a(SpecialFrsWebFragment specialFrsWebFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialFrsWebFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = specialFrsWebFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0cd1);
                    return;
                }
                SpecialFrsWebFragment specialFrsWebFragment = this.a;
                specialFrsWebFragment.hideNetRefreshView(specialFrsWebFragment.m);
                this.a.l.setVisibility(0);
                this.a.m.setVisibility(8);
                this.a.q = true;
                this.a.A();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ey4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialFrsWebFragment a;

        public b(SpecialFrsWebFragment specialFrsWebFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialFrsWebFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = specialFrsWebFragment;
        }

        @Override // com.baidu.tieba.ey4
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
                gh a = ig5.a();
                a.a("frame_delta", sb.toString());
                BdStatisticsManager.getInstance().performance(AlbumActivityConfig.FROM_WEB_VIEW, a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements wx8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialFrsWebFragment a;

        public c(SpecialFrsWebFragment specialFrsWebFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialFrsWebFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = specialFrsWebFragment;
        }

        @Override // com.baidu.tieba.wx8
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, jsPromptResult)) == null) {
                if (this.a.n != null) {
                    return this.a.n.c(this.a.i, str, jsPromptResult);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialFrsWebFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(SpecialFrsWebFragment specialFrsWebFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialFrsWebFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = specialFrsWebFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length != 2) {
                    return;
                }
                if ("FrsInfoTab".equals(split[0]) || "FrsRankList".equals(split[0])) {
                    this.a.A();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialFrsWebFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(SpecialFrsWebFragment specialFrsWebFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialFrsWebFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = specialFrsWebFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016 || StringUtils.isNull(this.a.a)) {
                return;
            }
            this.a.r = true;
            SpecialFrsWebFragment specialFrsWebFragment = this.a;
            specialFrsWebFragment.showLoadingView(specialFrsWebFragment.l);
            SpecialFrsWebFragment specialFrsWebFragment2 = this.a;
            specialFrsWebFragment2.r2(specialFrsWebFragment2.a);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements ScrollBridgeWebview.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialFrsWebFragment a;

        @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview.a
        public void a(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i, i2, i3, i4) == null) {
            }
        }

        @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview.a
        public void b(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, i3, i4) == null) {
            }
        }

        @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview.a
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3, i4) == null) {
            }
        }

        public f(SpecialFrsWebFragment specialFrsWebFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialFrsWebFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = specialFrsWebFragment;
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialFrsWebFragment a;

        public g(SpecialFrsWebFragment specialFrsWebFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialFrsWebFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = specialFrsWebFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.a.i != null) {
                        this.a.i.destroy();
                        this.a.i = null;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialFrsWebFragment a;

        public h(SpecialFrsWebFragment specialFrsWebFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialFrsWebFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = specialFrsWebFragment;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                if (this.a.i == null) {
                    return;
                }
                this.a.r = false;
                SpecialFrsWebFragment specialFrsWebFragment = this.a;
                specialFrsWebFragment.hideLoadingView(specialFrsWebFragment.l);
                SpecialFrsWebFragment specialFrsWebFragment2 = this.a;
                specialFrsWebFragment2.a = str;
                specialFrsWebFragment2.i.loadUrl("javascript:window.local_obj.getIfFullScreen(document.getElementsByName(\"fc_fullscreen\")[0].content);");
                if (this.a.q) {
                    this.a.q = false;
                }
                String title = this.a.i.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    this.a.L1(title);
                }
                this.a.e.o(this.a.G1());
                this.a.e.p(this.a.H1());
                this.a.e.n(this.a.F1());
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                if (this.a.i == null) {
                    return;
                }
                if (this.a.q) {
                    this.a.r = true;
                    SpecialFrsWebFragment specialFrsWebFragment = this.a;
                    specialFrsWebFragment.showLoadingView(specialFrsWebFragment.l);
                }
                this.a.a = str;
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i, str, str2) == null) {
                super.onReceivedError(webView, i, str, str2);
                if (this.a.i == null) {
                    return;
                }
                this.a.i.stopLoading();
                this.a.t2(i);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, renderProcessGoneDetail)) == null) {
                dq4.a("SpecialFrsWebFragment", webView);
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                if (this.a.q) {
                    this.a.q = false;
                    return false;
                } else if (this.a.i2(str) && !TbadkCoreApplication.isLogin() && this.a.getPageContext() != null) {
                    ViewHelper.skipToLoginActivity(this.a.getPageContext().getPageActivity());
                    return false;
                } else {
                    if (!this.a.s2(str) && this.a.getPageContext() != null && this.a.i.isShown()) {
                        if (str.startsWith("tdoudiscount:")) {
                            this.a.t = true;
                        }
                        if (this.a.E1(str)) {
                            int dealOneLinkWithOutJumpWebView = UrlManager.getInstance().dealOneLinkWithOutJumpWebView(this.a.getPageContext(), new String[]{str});
                            if (dealOneLinkWithOutJumpWebView != 0 && dealOneLinkWithOutJumpWebView != 1) {
                                return false;
                            }
                            return true;
                        } else if (this.a.s) {
                            if (UrlManager.getInstance().dealOneLinkWithOutJumpWebView(this.a.getPageContext(), new String[]{str}) != 0) {
                                return false;
                            }
                            return true;
                        } else {
                            UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.a.getPageContext(), new String[]{str}, true);
                        }
                    }
                    return true;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class i implements DownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialFrsWebFragment a;

        public i(SpecialFrsWebFragment specialFrsWebFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialFrsWebFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = specialFrsWebFragment;
        }

        public /* synthetic */ i(SpecialFrsWebFragment specialFrsWebFragment, c cVar) {
            this(specialFrsWebFragment);
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) != null) || StringUtils.isNull(str)) {
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            if (!UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                return;
            }
            this.a.startActivity(intent);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-439207698, "Lcom/baidu/tieba/frs/gametabs/SpecialFrsWebFragment;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-439207698, "Lcom/baidu/tieba/frs/gametabs/SpecialFrsWebFragment;");
                return;
            }
        }
        HashMap<String, String> hashMap = new HashMap<>();
        B = hashMap;
        hashMap.put(Share.WEIXIN_TIMELINE, Share.WEIXIN_TIMELINE);
        B.put(Share.WEIXIN_FRIEND, Share.WEIXIN_FRIEND);
        B.put(Share.QQDENGLU, "qq_zone");
        B.put(Share.SINAWEIBO, "sina_weibo");
        B.put(Share.QQWEIBO, "qq_weibo");
    }

    public SpecialFrsWebFragment() {
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
        this.i = null;
        this.q = true;
        this.s = false;
        this.u = false;
        this.w = new c(this);
        this.x = new d(this, 0);
        this.y = new e(this, 2005016);
        this.z = new a(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.y);
            zu6 zu6Var = this.o;
            if (zu6Var != null) {
                zu6Var.release();
                this.o = null;
            }
            yu6 yu6Var = this.e;
            if (yu6Var != null) {
                yu6Var.m();
            }
            ux8 ux8Var = this.n;
            if (ux8Var != null) {
                ux8Var.h();
            }
            ScrollBridgeWebview scrollBridgeWebview = this.i;
            if (scrollBridgeWebview != null) {
                scrollBridgeWebview.getSettings().setBuiltInZoomControls(true);
                this.i.setVisibility(8);
                bh.a().postDelayed(new g(this), ViewConfiguration.getZoomControlsTimeout() + 1000);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                if (this.i == null) {
                    return;
                }
                if (this.q) {
                    initData();
                }
                try {
                    this.i.onResume();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                h2("onResume");
                return;
            }
            ScrollBridgeWebview scrollBridgeWebview = this.i;
            if (scrollBridgeWebview == null) {
                return;
            }
            try {
                scrollBridgeWebview.onPause();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            h2(MissionEvent.MESSAGE_PAUSE);
        }
    }

    public void h2(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, str) == null) && this.i != null) {
            try {
                WebView.class.getMethod(str, new Class[0]).invoke(this.i, new Object[0]);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public final boolean i2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            return str.contains("tieba_check_login=1");
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            super.onActivityCreated(bundle);
            if (this.e == null) {
                this.e = new yu6(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            yu6 yu6Var = this.e;
            if (yu6Var != null) {
                yu6Var.l(i2);
            }
            NoNetworkView noNetworkView = this.k;
            if (noNetworkView != null) {
                noNetworkView.d(getPageContext(), i2);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (bundle != null) {
                bundle.putString("fid", this.f);
                bundle.putString("fname", this.g);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            super.onUserChanged(z);
        }
    }

    public void r2(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, str) == null) && this.i != null) {
            CompatibleUtile.getInstance().loadUrl(this.i, str);
        }
    }

    public final boolean s2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            if (!p2(str) && !w2(str) && !q2(str) && !o2(str)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void u2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            this.h = i2;
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.r && !TextUtils.isEmpty(this.a) && BdNetTypeUtil.isNetWorkAvailable()) {
            r2(this.a);
        }
    }

    @Override // com.baidu.tieba.yo6
    public NavigationBar S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            yu6 yu6Var = this.e;
            if (yu6Var != null) {
                return yu6Var.j();
            }
            return null;
        }
        return (NavigationBar) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.kf5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = this.h;
            if (i2 == 102) {
                return "a055";
            }
            if (i2 == 103) {
                return "a056";
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.kf5
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return super.getCurrentPageSourceKeyList();
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public nf5 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            nf5 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.t(yg.g(l(), 0L));
            }
            return pageStayDurationItem;
        }
        return (nf5) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public void n2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            BrowserHelper.h(getBaseFragmentActivity().getApplicationContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onResume();
            yu6 yu6Var = this.e;
            if (yu6Var != null) {
                yu6Var.l(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public final void x2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048611, this) != null) || A) {
            return;
        }
        A = true;
        by4.a().b(16, new b(this));
    }

    public final vx8 g2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001386, vx8.class, getPageContext());
            if (runTask != null && runTask.getData() != null) {
                return (vx8) runTask.getData();
            }
            return null;
        }
        return (vx8) invokeV.objValue;
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            String str = this.a;
            if (str != null && str.contains("redirect=1")) {
                this.s = true;
            }
            r2(this.a);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921047, zu6.class);
            if (runTask != null) {
                zu6 zu6Var = (zu6) runTask.getData();
                this.o = zu6Var;
                if (zu6Var != null) {
                    zu6Var.init();
                }
            }
        }
    }

    public final SparseArray<String> l2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            SparseArray<String> sparseArray = new SparseArray<>(8);
            sparseArray.put(2, "pb_wx_timeline");
            sparseArray.put(3, "pb_wx_friend");
            sparseArray.put(4, "pb_qq_zone");
            sparseArray.put(5, "pb_tencent_weibo");
            sparseArray.put(6, "pb_sina_weibo");
            sparseArray.put(7, "pb_renren");
            return sparseArray;
        }
        return (SparseArray) invokeV.objValue;
    }

    public View j2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.i == null) {
                ScrollBridgeWebview scrollBridgeWebview = new ScrollBridgeWebview(getPageContext().getPageActivity());
                this.i = scrollBridgeWebview;
                scrollBridgeWebview.setNeedDisAllowParentInterceptTouchEvent(true);
                this.i.getSettings().setJavaScriptEnabled(true);
                this.i.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                this.i.getSettings().setAllowFileAccess(true);
                this.i.getSettings().setDatabaseEnabled(true);
                this.i.getSettings().setDomStorageEnabled(true);
                this.i.getSettings().setSupportZoom(true);
                this.i.getSettings().setBuiltInZoomControls(true);
                this.i.getSettings().setUseWideViewPort(true);
                this.i.getSettings().setLoadWithOverviewMode(true);
                this.i.getSettings().setDatabasePath(getBaseFragmentActivity().getApplicationContext().getDir("databases", 0).getAbsolutePath());
                this.i.setHorizontalScrollBarEnabled(false);
                this.i.setHorizontalScrollbarOverlay(false);
                this.i.setInitialScale(100);
                this.i.setScrollBarStyle(33554432);
                this.i.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.i.setWebViewClient(new h(this));
                this.i.setDownloadListener(new i(this, null));
                wu6 wu6Var = new wu6(getPageContext());
                wu6Var.a(this.w);
                this.i.setWebChromeClient(wu6Var);
                this.i.setOnScrollChangeListener(new f(this));
                CompatibleUtile.getInstance().removeJavascriptInterface(this.i);
                boolean isHybridBridgeEnabled = TbadkCoreApplication.getInst().isHybridBridgeEnabled();
                gy4 n = WebViewBridge.n(isHybridBridgeEnabled, this.i, null);
                this.p = n;
                if (isHybridBridgeEnabled) {
                    n.d(new NamedBridgeHandler(this, n) { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.5
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ SpecialFrsWebFragment this$0;

                        @Override // com.baidu.tbadk.core.hybrid.NamedBridgeHandler
                        public String scope() {
                            InterceptResult invokeV2;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) ? "TBHY_COMMON_Performance" : (String) invokeV2.objValue;
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
                                    super((gy4) newInitContext.callArgs[0]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @iy4(isAsync = false, value = "trackFPS")
                        private void trackFPS() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(65537, this) == null) {
                                this.this$0.x2();
                            }
                        }
                    });
                    n.d(new ClipboardBridgeHandler(n));
                    n.d(new ImageOperateBridgeHandler(this, n) { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.6
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ SpecialFrsWebFragment this$0;

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
                                    super((gy4) newInitContext.callArgs[0]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @Override // com.baidu.tbadk.core.hybrid.handlers.ImageOperateBridgeHandler
                        @iy4(isAsync = false, value = "scanBigImages")
                        public void sanBigImages(JSONObject jSONObject) throws JSONException {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject) == null) {
                                super.sanBigImages(jSONObject);
                                TiebaStatic.log(new StatisticItem("c12338").param("fid", jSONObject.optInt("fid")));
                            }
                        }
                    });
                    n.d(new HybridUtilsBridgeHandler(n));
                    n.d(new ShareDialogBridgeHandler(n));
                    n.d(new SpecialInstallHandler(n));
                    n.d(new SpecialDownloadHandler(n, this.f));
                    n.d(new NamedBridgeHandler(this, n) { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.7
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ SpecialFrsWebFragment this$0;

                        @Override // com.baidu.tbadk.core.hybrid.NamedBridgeHandler
                        public String scope() {
                            InterceptResult invokeV2;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) ? "TBHY_COMMON_SKIN_TO_LOGIN" : (String) invokeV2.objValue;
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
                                    super((gy4) newInitContext.callArgs[0]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @iy4(isAsync = false, value = "skinToLogin")
                        private void skinToLogin() {
                            Interceptable interceptable2 = $ic;
                            if ((interceptable2 == null || interceptable2.invokeV(65537, this) == null) && !TbadkCoreApplication.isLogin()) {
                                ViewHelper.skipToLoginActivity(this.this$0.getPageContext().getPageActivity());
                            }
                        }
                    });
                    n.d(new NamedBridgeHandler(this, n) { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.8
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ SpecialFrsWebFragment this$0;

                        @Override // com.baidu.tbadk.core.hybrid.NamedBridgeHandler
                        public String scope() {
                            InterceptResult invokeV2;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) ? "TBHY_COMMON_Share" : (String) invokeV2.objValue;
                        }

                        /* renamed from: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment$8$a */
                        /* loaded from: classes4.dex */
                        public class a implements Runnable {
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ ShareItem a;
                            public final /* synthetic */ AnonymousClass8 b;

                            public a(AnonymousClass8 anonymousClass8, ShareItem shareItem) {
                                Interceptable interceptable = $ic;
                                if (interceptable != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {anonymousClass8, shareItem};
                                    interceptable.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.b = anonymousClass8;
                                this.a = shareItem;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable = $ic;
                                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                                    this.b.this$0.v2(this.a);
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
                                    super((gy4) newInitContext.callArgs[0]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @iy4(isAsync = false, value = "share")
                        private void share(JSONObject jSONObject) {
                            Interceptable interceptable2 = $ic;
                            if ((interceptable2 != null && interceptable2.invokeL(65537, this, jSONObject) != null) || jSONObject == null) {
                                return;
                            }
                            String optString = jSONObject.optString("title");
                            String optString2 = jSONObject.optString("desc");
                            String optString3 = jSONObject.optString("img");
                            String optString4 = jSONObject.optString("url");
                            String optString5 = jSONObject.optString(MapBundleKey.MapObjKey.OBJ_BID);
                            if (!StringUtils.isNULL(optString5)) {
                                SpecialFrsWebFragment specialFrsWebFragment = this.this$0;
                                specialFrsWebFragment.u = true;
                                specialFrsWebFragment.v = optString5;
                            }
                            bh.a().post(new a(this, this.this$0.C1(optString, optString4, optString2, optString3)));
                        }
                    });
                }
                this.i.registerPerformanceTracker(new TbChannelJsInterface(this.d));
            }
            return this.i;
        }
        return (View) invokeV.objValue;
    }

    public ShareItem k2(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, str, str2, str3, str4)) == null) {
            return C1(str, str2, str3, str4);
        }
        return (ShareItem) invokeLLLL.objValue;
    }

    public final void m2(Intent intent, int i2) {
        ScrollBridgeWebview scrollBridgeWebview;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048590, this, intent, i2) != null) || !this.u) {
            return;
        }
        boolean z = false;
        this.u = false;
        if (intent == null) {
            return;
        }
        String str = B.get(intent.getStringExtra("share_to"));
        HashMap hashMap = new HashMap();
        if (i2 == -1) {
            z = true;
        }
        hashMap.put(MapBundleKey.MapObjKey.OBJ_BID, this.v);
        hashMap.put("result", Boolean.valueOf(z));
        hashMap.put("channel", str);
        hy4 j = hy4.j("TBJS_COMMON_Share", "onShareResult", hashMap, 0L, false);
        gy4 gy4Var = this.p;
        if (gy4Var != null) {
            gy4Var.c(j);
        }
        if (!StringUtils.isNull(this.a) && this.a.contains("topicgroupcallback=1") && intent != null && intent.getIntExtra("extra_share_status", -1) == 1 && (scrollBridgeWebview = this.i) != null) {
            scrollBridgeWebview.loadUrl("javascript:window.__js_bridge_topic_group_share_action()");
        }
    }

    public final boolean o2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (!StringUtils.isNull(str) && str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_FRS_DETAIL)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(getFragmentActivity(), rl5.c(str, "fid="), ForumDetailActivityConfig.FromType.FRS_GAME_INFO)));
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void v2(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048609, this, shareItem) != null) || shareItem == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) getPageContext().getPageActivity(), shareItem, true, l2())));
    }

    public final boolean w2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) {
            if (!StringUtils.isNull(str) && str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_START_GAME)) {
                String c2 = rl5.c(str, "packagename=");
                if (!StringUtils.isNull(c2)) {
                    getFragmentActivity().startActivity(getFragmentActivity().getPackageManager().getLaunchIntentForPackage(c2));
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048594, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 == 24007) {
                m2(intent, i3);
            }
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            super.onCreate(bundle);
            if (bundle != null) {
                this.f = bundle.getString("fid");
                this.g = bundle.getString("fname");
            } else if (getArguments() != null) {
                this.f = getArguments().getString("fid");
                this.g = getArguments().getString("fname");
            }
            ux8 ux8Var = new ux8();
            this.n = ux8Var;
            ux8Var.a(new XiubaTbJsBridge(getPageContext()));
            this.n.a(new CommonTbJsBridge(getPageContext().getPageActivity()));
            this.n.a(g2());
            n2();
            registerListener(2001446, this.x, getBaseFragmentActivity().getUniqueId());
            MessageManager.getInstance().registerListener(this.y);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        ViewParent parent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048597, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0807, (ViewGroup) null);
            this.j = inflate;
            this.k = (NoNetworkView) inflate.findViewById(R.id.view_no_network);
            this.l = (FrameLayout) this.j.findViewById(R.id.obfuscated_res_0x7f09274f);
            this.m = (FrameLayout) this.j.findViewById(R.id.obfuscated_res_0x7f091779);
            if (this.e == null) {
                this.e = new yu6(getPageContext());
            }
            this.e.k((NavigationBar) this.j.findViewById(R.id.view_navigation_bar), this);
            j2();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.l.getLayoutParams();
            layoutParams.addRule(3, R.id.view_navigation_bar);
            this.l.setLayoutParams(layoutParams);
            ScrollBridgeWebview scrollBridgeWebview = this.i;
            if (scrollBridgeWebview != null && (parent = scrollBridgeWebview.getParent()) != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.i);
            }
            this.l.addView(this.i);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return this.j;
        }
        return (View) invokeLLL.objValue;
    }

    public final boolean p2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            if (!StringUtils.isNull(str) && str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_SDK)) {
                int parseInt = Integer.parseInt(rl5.c(str, "fid="));
                int parseInt2 = Integer.parseInt(rl5.c(str, "gameid="));
                String c2 = rl5.c(str, "gamename=");
                zu6 zu6Var = this.o;
                if (zu6Var != null) {
                    zu6Var.a(getPageContext(), c2, parseInt2, parseInt);
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean q2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            if (!StringUtils.isNull(str) && str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_JUMP_PB)) {
                String c2 = rl5.c(str, "tid=");
                if (!StringUtils.isNull(c2)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getFragmentActivity()).createNormalCfg(c2, null, "game_news")));
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void t2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            ScrollBridgeWebview scrollBridgeWebview = this.i;
            if (scrollBridgeWebview != null) {
                this.a = scrollBridgeWebview.getUrl();
                this.i.stopLoading();
            }
            this.l.setVisibility(8);
            this.m.setVisibility(0);
            if (getPageContext() != null) {
                showNetRefreshView(this.m, getPageContext().getString(R.string.url_not_found), null, getPageContext().getString(R.string.obfuscated_res_0x7f0f1053), false, this.z);
            }
        }
    }
}
