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
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.BdStatsItem;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.livesdk.api.share.Share;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.IntentConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BaseWebViewFragment;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.browser.HybridUtilsBridgeHandler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.hybrid.NamedBridgeHandler;
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
import com.baidu.tbadk.pageStayDuration.PageStayDurationItem;
import com.baidu.tbadk.performanceLog.PerformanceLogger;
import com.baidu.tbadk.util.WebviewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.a85;
import com.baidu.tieba.b85;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.pg7;
import com.baidu.tieba.u75;
import com.baidu.tieba.vm7;
import com.baidu.tieba.x75;
import com.baidu.tieba.xm7;
import com.baidu.tieba.ym7;
import com.baidu.tieba.yw4;
import com.baidu.tieba.z75;
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
/* loaded from: classes5.dex */
public class NewSpecialFrsWebFragment extends BaseWebViewFragment implements pg7 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean y;
    public static HashMap<String, String> z;
    public transient /* synthetic */ FieldHolder $fh;
    public xm7 e;
    public String f;
    public String g;
    public int h;
    public TbWebView i;
    public View j;
    public NoNetworkView k;
    public FrameLayout l;
    public FrameLayout m;
    public ym7 n;
    public z75 o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public String u;
    public CustomMessageListener v;
    public CustomMessageListener w;
    public final View.OnClickListener x;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSpecialFrsWebFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(NewSpecialFrsWebFragment newSpecialFrsWebFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSpecialFrsWebFragment, Integer.valueOf(i)};
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
            this.a = newSpecialFrsWebFragment;
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
                if (!"FrsInfoTab".equals(split[0]) && !"FrsRankList".equals(split[0])) {
                    return;
                }
                this.a.h();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSpecialFrsWebFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(NewSpecialFrsWebFragment newSpecialFrsWebFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSpecialFrsWebFragment, Integer.valueOf(i)};
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
            this.a = newSpecialFrsWebFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016 || StringUtils.isNull(this.a.a)) {
                return;
            }
            this.a.q = true;
            NewSpecialFrsWebFragment newSpecialFrsWebFragment = this.a;
            newSpecialFrsWebFragment.showLoadingView(newSpecialFrsWebFragment.l);
            NewSpecialFrsWebFragment newSpecialFrsWebFragment2 = this.a;
            newSpecialFrsWebFragment2.u2(newSpecialFrsWebFragment2.a);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSpecialFrsWebFragment a;

        public c(NewSpecialFrsWebFragment newSpecialFrsWebFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSpecialFrsWebFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSpecialFrsWebFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.a.i != null) {
                        this.a.i.onDestroy();
                        this.a.i = null;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSpecialFrsWebFragment a;

        public d(NewSpecialFrsWebFragment newSpecialFrsWebFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSpecialFrsWebFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSpecialFrsWebFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0e21);
                    return;
                }
                NewSpecialFrsWebFragment newSpecialFrsWebFragment = this.a;
                newSpecialFrsWebFragment.hideNetRefreshView(newSpecialFrsWebFragment.m);
                this.a.l.setVisibility(0);
                this.a.m.setVisibility(8);
                this.a.p = true;
                this.a.h();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements x75 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSpecialFrsWebFragment a;

        public e(NewSpecialFrsWebFragment newSpecialFrsWebFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSpecialFrsWebFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSpecialFrsWebFragment;
        }

        @Override // com.baidu.tieba.x75
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
    public class f extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSpecialFrsWebFragment a;

        public f(NewSpecialFrsWebFragment newSpecialFrsWebFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSpecialFrsWebFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSpecialFrsWebFragment;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                if (this.a.i == null) {
                    return;
                }
                this.a.q = false;
                NewSpecialFrsWebFragment newSpecialFrsWebFragment = this.a;
                newSpecialFrsWebFragment.hideLoadingView(newSpecialFrsWebFragment.l);
                NewSpecialFrsWebFragment newSpecialFrsWebFragment2 = this.a;
                newSpecialFrsWebFragment2.a = str;
                newSpecialFrsWebFragment2.i.loadUrl("javascript:window.local_obj.getIfFullScreen(document.getElementsByName(\"fc_fullscreen\")[0].content);");
                if (this.a.p) {
                    this.a.p = false;
                }
                String b = this.a.i.getController().b();
                if (!TextUtils.isEmpty(b)) {
                    this.a.R1(b);
                }
                this.a.e.p(this.a.M1());
                this.a.e.q(this.a.N1());
                this.a.e.o(this.a.L1());
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
                if (this.a.p) {
                    this.a.q = true;
                    NewSpecialFrsWebFragment newSpecialFrsWebFragment = this.a;
                    newSpecialFrsWebFragment.showLoadingView(newSpecialFrsWebFragment.l);
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
                this.a.i.getController().e();
                this.a.w2(i);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, renderProcessGoneDetail)) == null) {
                yw4.a("SpecialFrsWebFragment", webView);
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
                if (this.a.p) {
                    this.a.p = false;
                    return false;
                } else if (this.a.m2(str) && !TbadkCoreApplication.isLogin() && this.a.getPageContext() != null) {
                    ViewHelper.skipToLoginActivity(this.a.getPageContext().getPageActivity());
                    return false;
                } else {
                    if (!this.a.v2(str) && this.a.getPageContext() != null && this.a.i.isShown()) {
                        if (str.startsWith("tdoudiscount:")) {
                            this.a.s = true;
                        }
                        if (this.a.K1(str)) {
                            int dealOneLinkWithOutJumpWebView = UrlManager.getInstance().dealOneLinkWithOutJumpWebView(this.a.getPageContext(), new String[]{str});
                            if (dealOneLinkWithOutJumpWebView != 0 && dealOneLinkWithOutJumpWebView != 1) {
                                return false;
                            }
                            return true;
                        } else if (this.a.r) {
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

    /* loaded from: classes5.dex */
    public class g implements DownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSpecialFrsWebFragment a;

        public g(NewSpecialFrsWebFragment newSpecialFrsWebFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSpecialFrsWebFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSpecialFrsWebFragment;
        }

        public /* synthetic */ g(NewSpecialFrsWebFragment newSpecialFrsWebFragment, a aVar) {
            this(newSpecialFrsWebFragment);
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) != null) || StringUtils.isNull(str)) {
                return;
            }
            Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(str));
            if (!UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                return;
            }
            this.a.startActivity(intent);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1340798908, "Lcom/baidu/tieba/frs/gametabs/NewSpecialFrsWebFragment;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1340798908, "Lcom/baidu/tieba/frs/gametabs/NewSpecialFrsWebFragment;");
                return;
            }
        }
        HashMap<String, String> hashMap = new HashMap<>();
        z = hashMap;
        hashMap.put(Share.WEIXIN_TIMELINE, Share.WEIXIN_TIMELINE);
        z.put(Share.WEIXIN_FRIEND, Share.WEIXIN_FRIEND);
        z.put(Share.QQDENGLU, "qq_zone");
        z.put(Share.SINAWEIBO, "sina_weibo");
        z.put(Share.QQWEIBO, "qq_weibo");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.w);
            ym7 ym7Var = this.n;
            if (ym7Var != null) {
                ym7Var.release();
                this.n = null;
            }
            xm7 xm7Var = this.e;
            if (xm7Var != null) {
                xm7Var.n();
            }
            TbWebView tbWebView = this.i;
            if (tbWebView != null) {
                tbWebView.setVisibility(8);
                SafeHandler.getInst().postDelayed(new c(this), ViewConfiguration.getZoomControlsTimeout() + 1000);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                if (this.i == null) {
                    return;
                }
                if (this.p) {
                    initData();
                }
                try {
                    this.i.onResume();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                l2("onResume");
                return;
            }
            TbWebView tbWebView = this.i;
            if (tbWebView == null) {
                return;
            }
            try {
                tbWebView.onPause();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            l2(MissionEvent.MESSAGE_PAUSE);
        }
    }

    public NewSpecialFrsWebFragment() {
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
        this.i = null;
        this.p = true;
        this.r = false;
        this.t = false;
        this.v = new a(this, 0);
        this.w = new b(this, 2005016);
        this.x = new d(this);
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            String str = this.a;
            if (str != null && str.contains("redirect=1")) {
                this.r = true;
            }
            u2(this.a);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921047, ym7.class);
            if (runTask != null) {
                ym7 ym7Var = (ym7) runTask.getData();
                this.n = ym7Var;
                if (ym7Var != null) {
                    ym7Var.init();
                }
            }
        }
    }

    public final SparseArray<String> o2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
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

    public void l2(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && this.i != null) {
            try {
                WebView.class.getMethod(str, new Class[0]).invoke(this.i, new Object[0]);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public final boolean m2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onActivityCreated(bundle);
            if (this.e == null) {
                this.e = new xm7(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            xm7 xm7Var = this.e;
            if (xm7Var != null) {
                xm7Var.m(i);
            }
            NoNetworkView noNetworkView = this.k;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(getPageContext(), i);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (bundle != null) {
                bundle.putString("fid", this.f);
                bundle.putString("fname", this.g);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z2) == null) {
            super.onUserChanged(z2);
        }
    }

    public void u2(String str) {
        TbWebView tbWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, str) == null) && (tbWebView = this.i) != null) {
            tbWebView.loadUrl(str);
        }
    }

    public final boolean v2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            if (!s2(str) && !z2(str) && !t2(str) && !r2(str)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void x2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            this.h = i;
        }
    }

    public final void A2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || y) {
            return;
        }
        y = true;
        u75.a().b(16, new e(this));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i = this.h;
            if (i == 102) {
                return "a055";
            }
            if (i == 103) {
                return "a056";
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return super.getCurrentPageSourceKeyList();
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public PageStayDurationItem getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            PageStayDurationItem pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.setFid(JavaTypesHelper.toLong(w(), 0L));
            }
            return pageStayDurationItem;
        }
        return (PageStayDurationItem) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && !this.q && !TextUtils.isEmpty(this.a) && BdNetTypeUtil.isNetWorkAvailable()) {
            u2(this.a);
        }
    }

    @Override // com.baidu.tieba.pg7
    public NavigationBar o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            xm7 xm7Var = this.e;
            if (xm7Var != null) {
                return xm7Var.j();
            }
            return null;
        }
        return (NavigationBar) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onResume();
            xm7 xm7Var = this.e;
            if (xm7Var != null) {
                xm7Var.m(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            BrowserHelper.initCookie(getBaseFragmentActivity().getApplicationContext());
        }
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public View n2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.i == null) {
                TbWebView tbWebView = new TbWebView(getPageContext().getPageActivity());
                this.i = tbWebView;
                tbWebView.setHorizontalScrollBarEnabled(false);
                this.i.setScrollBarStyle(33554432);
                this.i.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.i.setWebViewClient(new f(this));
                this.i.setDownloadListener(new g(this, null));
                this.i.setWebChromeClient(new vm7(getPageContext()));
                boolean isHybridBridgeEnabled = TbadkCoreApplication.getInst().isHybridBridgeEnabled();
                TbWebView tbWebView2 = this.i;
                z75 n = WebViewBridge.n(isHybridBridgeEnabled, tbWebView2, tbWebView2.getWebViewClient(), this.i.getChromeClient());
                this.o = n;
                if (isHybridBridgeEnabled) {
                    n.d(new NamedBridgeHandler(this, n) { // from class: com.baidu.tieba.frs.gametabs.NewSpecialFrsWebFragment.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ NewSpecialFrsWebFragment this$0;

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
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    super((z75) newInitContext.callArgs[0]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @b85(isAsync = false, value = "trackFPS")
                        private void trackFPS() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null && interceptable2.invokeV(65537, this) != null) {
                                return;
                            }
                            this.this$0.A2();
                        }
                    });
                    n.d(new ClipboardBridgeHandler(n));
                    n.d(new ImageOperateBridgeHandler(this, n) { // from class: com.baidu.tieba.frs.gametabs.NewSpecialFrsWebFragment.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ NewSpecialFrsWebFragment this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(n);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, n};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    super((z75) newInitContext.callArgs[0]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @Override // com.baidu.tbadk.core.hybrid.handlers.ImageOperateBridgeHandler
                        @b85(isAsync = false, value = "scanBigImages")
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
                    n.d(new NamedBridgeHandler(this, n) { // from class: com.baidu.tieba.frs.gametabs.NewSpecialFrsWebFragment.5
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ NewSpecialFrsWebFragment this$0;

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
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    super((z75) newInitContext.callArgs[0]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @b85(isAsync = false, value = "skinToLogin")
                        private void skinToLogin() {
                            Interceptable interceptable2 = $ic;
                            if ((interceptable2 == null || interceptable2.invokeV(65537, this) == null) && !TbadkCoreApplication.isLogin()) {
                                ViewHelper.skipToLoginActivity(this.this$0.getPageContext().getPageActivity());
                            }
                        }
                    });
                    n.d(new NamedBridgeHandler(this, n) { // from class: com.baidu.tieba.frs.gametabs.NewSpecialFrsWebFragment.6
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ NewSpecialFrsWebFragment this$0;

                        @Override // com.baidu.tbadk.core.hybrid.NamedBridgeHandler
                        public String scope() {
                            InterceptResult invokeV2;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) ? "TBHY_COMMON_Share" : (String) invokeV2.objValue;
                        }

                        /* renamed from: com.baidu.tieba.frs.gametabs.NewSpecialFrsWebFragment$6$a */
                        /* loaded from: classes5.dex */
                        public class a implements Runnable {
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ ShareItem a;
                            public final /* synthetic */ AnonymousClass6 b;

                            public a(AnonymousClass6 anonymousClass6, ShareItem shareItem) {
                                Interceptable interceptable = $ic;
                                if (interceptable != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {anonymousClass6, shareItem};
                                    interceptable.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.b = anonymousClass6;
                                this.a = shareItem;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable = $ic;
                                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                                    this.b.this$0.y2(this.a);
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
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    super((z75) newInitContext.callArgs[0]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @b85(isAsync = false, value = "share")
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
                                NewSpecialFrsWebFragment newSpecialFrsWebFragment = this.this$0;
                                newSpecialFrsWebFragment.t = true;
                                newSpecialFrsWebFragment.u = optString5;
                            }
                            SafeHandler.getInst().post(new a(this, this.this$0.I1(optString, optString4, optString2, optString3)));
                        }
                    });
                }
            }
            return this.i;
        }
        return (View) invokeV.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048588, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i == 24007) {
                p2(intent, i2);
            }
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            super.onCreate(bundle);
            if (bundle != null) {
                this.f = bundle.getString("fid");
                this.g = bundle.getString("fname");
            } else if (getArguments() != null) {
                this.f = getArguments().getString("fid");
                this.g = getArguments().getString("fname");
            }
            q2();
            registerListener(2001446, this.v, getBaseFragmentActivity().getUniqueId());
            MessageManager.getInstance().registerListener(this.w);
        }
    }

    public final boolean s2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            if (!StringUtils.isNull(str) && str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_SDK)) {
                int parseInt = Integer.parseInt(WebviewHelper.getMatchStringFromURL(str, "fid="));
                int parseInt2 = Integer.parseInt(WebviewHelper.getMatchStringFromURL(str, "gameid="));
                String matchStringFromURL = WebviewHelper.getMatchStringFromURL(str, "gamename=");
                ym7 ym7Var = this.n;
                if (ym7Var != null) {
                    ym7Var.a(getPageContext(), matchStringFromURL, parseInt2, parseInt);
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean t2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            if (!StringUtils.isNull(str) && str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_JUMP_PB)) {
                String matchStringFromURL = WebviewHelper.getMatchStringFromURL(str, "tid=");
                if (!StringUtils.isNull(matchStringFromURL)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getFragmentActivity()).createNormalCfg(matchStringFromURL, null, "game_news")));
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void w2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            TbWebView tbWebView = this.i;
            if (tbWebView != null) {
                this.a = tbWebView.getUrl();
                this.i.getController().e();
            }
            this.l.setVisibility(8);
            this.m.setVisibility(0);
            if (getPageContext() != null) {
                showNetRefreshView(this.m, getPageContext().getString(R.string.url_not_found), null, getPageContext().getString(R.string.obfuscated_res_0x7f0f11fc), false, this.x);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        ViewParent parent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d08d5, (ViewGroup) null);
            this.j = inflate;
            this.k = (NoNetworkView) inflate.findViewById(R.id.view_no_network);
            this.l = (FrameLayout) this.j.findViewById(R.id.obfuscated_res_0x7f0929e7);
            this.m = (FrameLayout) this.j.findViewById(R.id.obfuscated_res_0x7f091951);
            if (this.e == null) {
                this.e = new xm7(getPageContext());
            }
            this.e.k((NavigationBar) this.j.findViewById(R.id.view_navigation_bar), this);
            n2();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.l.getLayoutParams();
            layoutParams.addRule(3, R.id.view_navigation_bar);
            this.l.setLayoutParams(layoutParams);
            TbWebView tbWebView = this.i;
            if (tbWebView != null && (parent = tbWebView.getParent()) != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.i);
            }
            this.l.addView(this.i);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return this.j;
        }
        return (View) invokeLLL.objValue;
    }

    public final void p2(Intent intent, int i) {
        TbWebView tbWebView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048597, this, intent, i) != null) || !this.t) {
            return;
        }
        boolean z2 = false;
        this.t = false;
        if (intent == null) {
            return;
        }
        String str = z.get(intent.getStringExtra("share_to"));
        HashMap hashMap = new HashMap();
        if (i == -1) {
            z2 = true;
        }
        hashMap.put(MapBundleKey.MapObjKey.OBJ_BID, this.u);
        hashMap.put("result", Boolean.valueOf(z2));
        hashMap.put("channel", str);
        a85 j = a85.j("TBJS_COMMON_Share", "onShareResult", hashMap, 0L, false);
        z75 z75Var = this.o;
        if (z75Var != null) {
            z75Var.c(j);
        }
        if (!StringUtils.isNull(this.a) && this.a.contains("topicgroupcallback=1") && intent != null && intent.getIntExtra("extra_share_status", -1) == 1 && (tbWebView = this.i) != null) {
            tbWebView.loadUrl("javascript:window.__js_bridge_topic_group_share_action()");
        }
    }

    public final boolean r2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
            if (!StringUtils.isNull(str) && str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_FRS_DETAIL)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(getFragmentActivity(), WebviewHelper.getMatchStringFromURL(str, "fid="), ForumDetailActivityConfig.FromType.FRS_GAME_INFO)));
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void y2(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048607, this, shareItem) != null) || shareItem == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) getPageContext().getPageActivity(), shareItem, true, o2())));
    }

    public final boolean z2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) {
            if (!StringUtils.isNull(str) && str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_START_GAME)) {
                String matchStringFromURL = WebviewHelper.getMatchStringFromURL(str, "packagename=");
                if (!StringUtils.isNull(matchStringFromURL)) {
                    getFragmentActivity().startActivity(getFragmentActivity().getPackageManager().getLaunchIntentForPackage(matchStringFromURL));
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
