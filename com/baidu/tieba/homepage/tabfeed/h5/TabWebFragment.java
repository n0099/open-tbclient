package com.baidu.tieba.homepage.tabfeed.h5;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.JsPromptResult;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BaseWebViewFragment;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.XiubaTbJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.NestedScrollWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.aq4;
import com.baidu.tieba.aq8;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.fw4;
import com.baidu.tieba.ge5;
import com.baidu.tieba.hw4;
import com.baidu.tieba.io4;
import com.baidu.tieba.mk6;
import com.baidu.tieba.qf5;
import com.baidu.tieba.sa5;
import com.baidu.tieba.sp4;
import com.baidu.tieba.vp4;
import com.baidu.tieba.wa5;
import com.baidu.tieba.yp8;
import com.baidu.tieba.zp8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class TabWebFragment extends BaseWebViewFragment implements mk6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String d;
    public String e;
    public String f;
    public int g;
    public View h;
    public NestedScrollWebView i;
    public FrameLayout j;
    public ViewGroup k;
    public yp8 l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public aq8 q;
    public CustomMessageListener r;
    public final CustomMessageListener s;
    public final View.OnClickListener t;

    @Override // com.baidu.tieba.mk6
    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.de5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? "714" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mk6
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a implements aq8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TabWebFragment a;

        public a(TabWebFragment tabWebFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tabWebFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tabWebFragment;
        }

        @Override // com.baidu.tieba.aq8
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, jsPromptResult)) == null) {
                if (this.a.l != null) {
                    return this.a.l.b(this.a.i, str, jsPromptResult);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TabWebFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(TabWebFragment tabWebFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tabWebFragment, Integer.valueOf(i)};
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
            this.a = tabWebFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && !StringUtils.isNull(this.a.a)) {
                this.a.x();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TabWebFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(TabWebFragment tabWebFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tabWebFragment, Integer.valueOf(i)};
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
            this.a = tabWebFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue() && wa5.d().b()) {
                this.a.h.setPadding(0, 0, 0, (int) (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 0.5d));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TabWebFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(TabWebFragment tabWebFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tabWebFragment, Integer.valueOf(i)};
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
            this.a = tabWebFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.l != null) {
                this.a.l.h(this.a.i, "writePostSuccess", new HashMap());
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class e implements CustomMessageTask.CustomRunnable<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<ShareItem> run(CustomMessage<String> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && (customMessage.getData() instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject(customMessage.getData());
                        String optString = jSONObject.optString("title");
                        String optString2 = jSONObject.optString("desc");
                        String optString3 = jSONObject.optString("img");
                        String optString4 = jSONObject.optString("url");
                        String optString5 = jSONObject.optString("topic");
                        String optString6 = jSONObject.optString("wbtitle");
                        String optString7 = jSONObject.optString("wbcontent");
                        ShareItem shareItem = new ShareItem();
                        shareItem.v = optString;
                        shareItem.x = optString4;
                        shareItem.w = optString2;
                        if (!TextUtils.isEmpty(optString3)) {
                            shareItem.z = Uri.parse(optString3);
                        }
                        shareItem.S = optString5;
                        shareItem.T = optString6;
                        shareItem.U = optString7;
                        shareItem.h0 = jSONObject.optInt("shareimg");
                        shareItem.p0 = jSONObject.optInt("weixin_disable");
                        String optString8 = jSONObject.optString("extdata");
                        if (!StringUtils.isNull(optString8)) {
                            try {
                                JSONObject jSONObject2 = new JSONObject(optString8);
                                String optString9 = jSONObject2.optString("activityid");
                                String optString10 = jSONObject2.optString("missionid");
                                if (!StringUtils.isNull(optString9) && !StringUtils.isNull(optString10)) {
                                    JSONObject jSONObject3 = new JSONObject();
                                    jSONObject3.put(optString9, optString10);
                                    shareItem.W = jSONObject3.toString();
                                }
                            } catch (JSONException unused) {
                            }
                        }
                        return new CustomResponsedMessage<>(2016568, shareItem);
                    } catch (JSONException e) {
                        BdLog.e(e);
                    }
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TabWebFragment a;

        public f(TabWebFragment tabWebFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tabWebFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tabWebFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c81);
                } else {
                    this.a.x();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TabWebFragment a;

        public g(TabWebFragment tabWebFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tabWebFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tabWebFragment;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                this.a.n = false;
                TabWebFragment tabWebFragment = this.a;
                tabWebFragment.a = str;
                if (tabWebFragment.i != null && this.a.j != null) {
                    webView.getProgress();
                    if (this.a.o) {
                        this.a.i.stopLoading();
                        this.a.i.setVisibility(8);
                        this.a.j.setVisibility(0);
                        TabWebFragment tabWebFragment2 = this.a;
                        tabWebFragment2.hideLoadingView(tabWebFragment2.j);
                        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                        TabWebFragment tabWebFragment3 = this.a;
                        tabWebFragment3.showNetRefreshView(tabWebFragment3.j, inst.getString(R.string.obfuscated_res_0x7f0f1537), null, inst.getString(R.string.obfuscated_res_0x7f0f100a), false, this.a.t);
                        return;
                    }
                    this.a.m = false;
                    this.a.i.setVisibility(0);
                    this.a.j.setVisibility(8);
                    TabWebFragment tabWebFragment4 = this.a;
                    tabWebFragment4.hideLoadingView(tabWebFragment4.j);
                    TabWebFragment tabWebFragment5 = this.a;
                    tabWebFragment5.hideNetRefreshView(tabWebFragment5.j);
                    String title = this.a.i.getTitle();
                    if (!TextUtils.isEmpty(title)) {
                        this.a.A1(title);
                    }
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) {
                if (TextUtils.isEmpty(str) || this.a.getPageContext() == null || this.a.i == null) {
                    return false;
                }
                if (!this.a.m) {
                    if (this.a.T1(str) && !TbadkCoreApplication.isLogin() && this.a.getPageContext() != null) {
                        ViewHelper.skipToLoginActivity(this.a.getPageContext().getPageActivity());
                        return false;
                    }
                    if (this.a.i != null && this.a.i.isShown()) {
                        if (this.a.s1(str)) {
                            int dealOneLinkWithOutJumpWebView = UrlManager.getInstance().dealOneLinkWithOutJumpWebView(this.a.getPageContext(), new String[]{str});
                            if (dealOneLinkWithOutJumpWebView != 0 && dealOneLinkWithOutJumpWebView != 1) {
                                return false;
                            }
                            return true;
                        } else if (this.a.p) {
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
                this.a.m = false;
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                if (this.a.i != null && this.a.j != null) {
                    this.a.o = false;
                    if (this.a.m) {
                        this.a.n = true;
                        this.a.j.setVisibility(0);
                        TabWebFragment tabWebFragment = this.a;
                        tabWebFragment.showLoadingView(tabWebFragment.j);
                    }
                    this.a.a = str;
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i, str, str2) == null) {
                super.onReceivedError(webView, i, str, str2);
                this.a.o = true;
                if (this.a.i != null && this.a.j != null) {
                    this.a.i.stopLoading();
                    this.a.i.setVisibility(8);
                    this.a.j.setVisibility(0);
                    TabWebFragment tabWebFragment = this.a;
                    tabWebFragment.hideLoadingView(tabWebFragment.j);
                    TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                    TabWebFragment tabWebFragment2 = this.a;
                    tabWebFragment2.showNetRefreshView(tabWebFragment2.j, inst.getString(R.string.obfuscated_res_0x7f0f1537), null, inst.getString(R.string.obfuscated_res_0x7f0f100a), false, this.a.t);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, renderProcessGoneDetail)) == null) {
                aq4.a("TabWebFragment", webView);
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class h implements DownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TabWebFragment a;

        public h(TabWebFragment tabWebFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tabWebFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tabWebFragment;
        }

        public /* synthetic */ h(TabWebFragment tabWebFragment, a aVar) {
            this(tabWebFragment);
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

    public TabWebFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = true;
        this.p = false;
        this.q = new a(this);
        new b(this, 2005016);
        this.r = new c(this, 2921551);
        this.s = new d(this, 2921757);
        this.t = new f(this);
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && this.j != null && this.i != null && !this.n && !TextUtils.isEmpty(this.a) && BdNetTypeUtil.isNetWorkAvailable()) {
            this.n = true;
            this.m = true;
            this.j.setVisibility(0);
            this.i.setVisibility(8);
            hideNetRefreshView(this.j);
            showLoadingView(this.j);
            W1(this.a);
        }
    }

    public final boolean T1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            return str.contains("tieba_check_login=1");
        }
        return invokeL.booleanValue;
    }

    public void W1(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, str) == null) && this.i != null) {
            CompatibleUtile.getInstance().loadUrl(this.i, str);
            this.i.setWebViewSkinOverly(str);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            super.onActivityCreated(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            qf5.a(getPageContext(), this.h);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (bundle != null) {
                bundle.putString("tab_name", this.d);
                bundle.putString("tab_code", this.e);
                bundle.putString("tab_url", this.f);
                bundle.putInt("tab_type", this.g);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            super.onUserChanged(z);
        }
    }

    public static void Y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2016568, new e());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public void U1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            sp4.g(getBaseFragmentActivity().getApplicationContext());
        }
    }

    public final void X1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            registerListener(this.r);
            registerListener(this.s);
        }
    }

    public final void a2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.r);
            MessageManager.getInstance().unRegisterListener(this.s);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.de5
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return super.getCurrentPageSourceKeyList();
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public ge5 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return super.getPageStayDurationItem();
        }
        return (ge5) invokeV.objValue;
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            String str = this.a;
            if (str != null && str.contains("redirect=1")) {
                this.p = true;
            }
            W1(this.a);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onDestroy();
            yp8 yp8Var = this.l;
            if (yp8Var != null) {
                yp8Var.g();
            }
            sa5.e().b();
            a2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            NestedScrollWebView nestedScrollWebView = this.i;
            if (nestedScrollWebView != null) {
                nestedScrollWebView.setVisibility(8);
            }
            super.onDestroyView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onPause();
            hw4.n(fw4.a(this.e));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onResume();
        }
    }

    @Override // com.baidu.tieba.mk6
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            x();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public ViewGroup taskAttachParentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.k;
        }
        return (ViewGroup) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            String e2 = io4.f().e(taskActionId(), "tab_code");
            if (!TextUtils.isEmpty(e2) && e2.equalsIgnoreCase(this.e)) {
                super.taskStart();
            }
        }
    }

    public final zp8 S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001386, zp8.class, getPageContext());
            if (runTask != null && runTask.getData() != null) {
                return (zp8) runTask.getData();
            }
            return null;
        }
        return (zp8) invokeV.objValue;
    }

    public final void Z1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && isPrimary()) {
            StatisticItem statisticItem = new StatisticItem("c13749");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.d);
            statisticItem.param("obj_type", this.e);
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tieba.mk6
    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            NestedScrollWebView nestedScrollWebView = this.i;
            if (nestedScrollWebView != null) {
                nestedScrollWebView.onChangeSkinType();
            }
            if (this.l != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("skin", SkinManager.getCurrentSkinTypeString());
                this.l.h(this.i, CommonTbJsBridge.CHANGE_SKIN_TYPE, linkedHashMap);
            }
        }
    }

    @RequiresApi(api = 11)
    public void V1() {
        NestedScrollWebView nestedScrollWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (nestedScrollWebView = this.i) != null) {
            nestedScrollWebView.setNeedDisAllowParentInterceptTouchEvent(false);
            this.i.getSettings().setJavaScriptEnabled(true);
            this.i.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            this.i.getSettings().setAllowFileAccess(true);
            this.i.getSettings().setDatabaseEnabled(true);
            this.i.getSettings().setDomStorageEnabled(true);
            this.i.getSettings().setSupportZoom(true);
            this.i.getSettings().setBuiltInZoomControls(true);
            this.i.getSettings().setUseWideViewPort(true);
            this.i.getSettings().setLoadWithOverviewMode(true);
            this.i.getSettings().setDatabasePath(getBaseFragmentActivity().getApplicationContext().getDir(NgWebView.APP_DATABASE_PATH, 0).getAbsolutePath());
            this.i.setHorizontalScrollBarEnabled(false);
            this.i.setHorizontalScrollbarOverlay(false);
            this.i.setInitialScale(100);
            this.i.setScrollBarStyle(33554432);
            this.i.setWebViewClient(new g(this));
            this.i.setDownloadListener(new h(this, null));
            vp4 vp4Var = new vp4(getPageContext());
            vp4Var.b(this.q);
            this.i.setWebChromeClient(vp4Var);
            CompatibleUtile.getInstance().removeJavascriptInterface(this.i);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048591, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            super.onCreate(bundle);
            if (getArguments() != null) {
                Bundle arguments = getArguments();
                this.g = arguments.getInt("tab_type");
                this.d = arguments.getString("tab_name");
                this.e = arguments.getString("tab_code");
                this.f = arguments.getString("tab_url");
            } else if (bundle != null) {
                this.g = bundle.getInt("tab_type");
                this.d = bundle.getString("tab_name");
                this.e = bundle.getString("tab_code");
                this.f = bundle.getString("tab_url");
            }
            this.a = this.f;
            if (this.l == null) {
                yp8 yp8Var = new yp8();
                this.l = yp8Var;
                yp8Var.a(new XiubaTbJsBridge(getPageContext()));
                this.l.a(new CommonTbJsBridge(getPageContext().getPageActivity()));
                this.l.a(S1());
            }
            U1();
            X1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @RequiresApi(api = 11)
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, layoutInflater, viewGroup, bundle)) == null) {
            View view2 = this.h;
            if (view2 != null && (view2.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.h.getParent()).removeView(this.h);
            }
            if (this.h == null) {
                View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d086f, (ViewGroup) null);
                this.h = inflate;
                this.i = (NestedScrollWebView) inflate.findViewById(R.id.obfuscated_res_0x7f0926a8);
                this.j = (FrameLayout) this.h.findViewById(R.id.obfuscated_res_0x7f091449);
                this.k = (ViewGroup) this.h.findViewById(R.id.obfuscated_res_0x7f09212c);
                V1();
            }
            NestedScrollWebView nestedScrollWebView = this.i;
            if (nestedScrollWebView != null) {
                nestedScrollWebView.setVisibility(0);
            }
            this.h.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return this.h;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @RequiresApi(api = 11)
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                if (this.i == null) {
                    return;
                }
                Z1();
                if (this.m) {
                    initData();
                }
                Y1();
                this.i.reshow();
                yp8 yp8Var = this.l;
                if (yp8Var != null) {
                    yp8Var.h(this.i, CommonTbJsBridge.RE_SHOW, null);
                }
            } else {
                MessageManager.getInstance().unRegisterTask(2016568);
            }
            if (getContext() != null && isPrimary()) {
                if ("worldcup".equals(this.e)) {
                    hw4.o(getContext(), fw4.h);
                }
                hw4.o(getContext(), fw4.a(this.e));
                return;
            }
            hw4.n(fw4.a(this.e));
        }
    }
}
