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
import androidx.annotation.NonNull;
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
import com.baidu.searchbox.IntentConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BaseWebViewFragment;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.TbChannelJsInterface;
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
import com.baidu.tbadk.mainTab.dynamicIcon.MainTabBottomDynamicIconManager;
import com.baidu.tbadk.pageStayDuration.PageStayDurationItem;
import com.baidu.tieba.R;
import com.baidu.tieba.co5;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.dfa;
import com.baidu.tieba.dt4;
import com.baidu.tieba.ee7;
import com.baidu.tieba.efa;
import com.baidu.tieba.ffa;
import com.baidu.tieba.g48;
import com.baidu.tieba.gr4;
import com.baidu.tieba.li5;
import com.baidu.tieba.lr4;
import com.baidu.tieba.np4;
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
/* loaded from: classes6.dex */
public class TabWebFragment extends BaseWebViewFragment implements ee7, dt4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String e;
    public String f;
    public String g;
    public int h;
    public View i;
    public NestedScrollWebView j;
    public FrameLayout k;
    public ViewGroup l;
    public dfa m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public g48 r;
    public ffa s;
    public CustomMessageListener t;
    public final CustomMessageListener u;
    public final View.OnClickListener v;

    @Override // com.baidu.tieba.ee7
    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ee7
    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? "714" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements ffa {
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

        @Override // com.baidu.tieba.ffa
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, jsPromptResult)) == null) {
                if (this.a.m != null) {
                    return this.a.m.c(this.a.j, str, jsPromptResult);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue() && MainTabBottomDynamicIconManager.getInstance().canShowDynamicIcon()) {
                this.a.i.setPadding(0, 0, 0, (int) (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 0.5d));
            }
        }
    }

    /* loaded from: classes6.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.m != null) {
                this.a.m.i(this.a.j, "writePostSuccess", new HashMap());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements CustomMessageTask.CustomRunnable<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
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
                        shareItem.title = optString;
                        shareItem.linkUrl = optString4;
                        shareItem.content = optString2;
                        if (!TextUtils.isEmpty(optString3)) {
                            shareItem.imageUri = Uri.parse(optString3);
                        }
                        shareItem.topic = optString5;
                        shareItem.wbtitle = optString6;
                        shareItem.wbcontent = optString7;
                        shareItem.shareType = jSONObject.optInt("shareimg");
                        shareItem.weixinDisable = jSONObject.optInt("weixin_disable");
                        String optString8 = jSONObject.optString("extdata");
                        if (!StringUtils.isNull(optString8)) {
                            try {
                                JSONObject jSONObject2 = new JSONObject(optString8);
                                String optString9 = jSONObject2.optString("activityid");
                                String optString10 = jSONObject2.optString("missionid");
                                if (!StringUtils.isNull(optString9) && !StringUtils.isNull(optString10)) {
                                    JSONObject jSONObject3 = new JSONObject();
                                    jSONObject3.put(optString9, optString10);
                                    shareItem.taskCompleteId = jSONObject3.toString();
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

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TabWebFragment a;

        public e(TabWebFragment tabWebFragment) {
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
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0e4f);
                } else {
                    this.a.i();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends WebViewClient {
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

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                this.a.o = false;
                TabWebFragment tabWebFragment = this.a;
                tabWebFragment.a = str;
                if (tabWebFragment.j != null && this.a.k != null) {
                    webView.getProgress();
                    if (this.a.p) {
                        this.a.j.stopLoading();
                        this.a.j.setVisibility(8);
                        this.a.k.setVisibility(0);
                        TabWebFragment tabWebFragment2 = this.a;
                        tabWebFragment2.hideLoadingView(tabWebFragment2.k);
                        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                        TabWebFragment tabWebFragment3 = this.a;
                        tabWebFragment3.showNetRefreshView(tabWebFragment3.k, inst.getString(R.string.url_not_found), null, inst.getString(R.string.obfuscated_res_0x7f0f1231), false, this.a.v);
                        return;
                    }
                    this.a.n = false;
                    this.a.j.setVisibility(0);
                    this.a.k.setVisibility(8);
                    TabWebFragment tabWebFragment4 = this.a;
                    tabWebFragment4.hideLoadingView(tabWebFragment4.k);
                    TabWebFragment tabWebFragment5 = this.a;
                    tabWebFragment5.hideNetRefreshView(tabWebFragment5.k);
                    String title = this.a.j.getTitle();
                    if (!TextUtils.isEmpty(title)) {
                        this.a.l2(title);
                    }
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) {
                if (TextUtils.isEmpty(str) || this.a.getPageContext() == null || this.a.j == null) {
                    return false;
                }
                if (!this.a.n) {
                    if (this.a.E2(str) && !TbadkCoreApplication.isLogin() && this.a.getPageContext() != null) {
                        ViewHelper.skipToLoginActivity(this.a.getPageContext().getPageActivity());
                        return false;
                    }
                    if (this.a.j != null && this.a.j.isShown()) {
                        if (this.a.e2(str)) {
                            int dealOneLinkWithOutJumpWebView = UrlManager.getInstance().dealOneLinkWithOutJumpWebView(this.a.getPageContext(), new String[]{str});
                            if (dealOneLinkWithOutJumpWebView != 0 && dealOneLinkWithOutJumpWebView != 1) {
                                return false;
                            }
                            return true;
                        } else if (this.a.q) {
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
                this.a.n = false;
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                if (this.a.j != null && this.a.k != null) {
                    this.a.p = false;
                    if (this.a.n) {
                        this.a.o = true;
                        this.a.k.setVisibility(0);
                        TabWebFragment tabWebFragment = this.a;
                        tabWebFragment.showLoadingView(tabWebFragment.k);
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
                this.a.p = true;
                if (this.a.j != null && this.a.k != null) {
                    this.a.j.stopLoading();
                    this.a.j.setVisibility(8);
                    this.a.k.setVisibility(0);
                    TabWebFragment tabWebFragment = this.a;
                    tabWebFragment.hideLoadingView(tabWebFragment.k);
                    TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                    TabWebFragment tabWebFragment2 = this.a;
                    tabWebFragment2.showNetRefreshView(tabWebFragment2.k, inst.getString(R.string.url_not_found), null, inst.getString(R.string.obfuscated_res_0x7f0f1231), false, this.a.v);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, renderProcessGoneDetail)) == null) {
                lr4.a("TabWebFragment", webView);
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class g implements DownloadListener {
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

        public /* synthetic */ g(TabWebFragment tabWebFragment, a aVar) {
            this(tabWebFragment);
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
        this.n = true;
        this.q = false;
        this.s = new a(this);
        this.t = new b(this, 2921551);
        this.u = new c(this, 2921786);
        this.v = new e(this);
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.k != null && this.j != null && !this.o && !TextUtils.isEmpty(this.a) && BdNetTypeUtil.isNetWorkAvailable()) {
            this.o = true;
            this.n = true;
            this.k.setVisibility(0);
            this.j.setVisibility(8);
            hideNetRefreshView(this.k);
            showLoadingView(this.k);
            I2(this.a);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                if (this.j == null) {
                    return;
                }
                L2();
                if (this.n) {
                    initData();
                }
                K2();
                this.j.reshow();
                dfa dfaVar = this.m;
                if (dfaVar != null) {
                    dfaVar.i(this.j, CommonTbJsBridge.RE_SHOW, null);
                }
                this.j.setWebViewSkinOverly(this.g);
            } else {
                MessageManager.getInstance().unRegisterTask(2016568);
            }
            g48 g48Var = this.r;
            if (g48Var != null) {
                g48Var.g();
            }
        }
    }

    public final boolean E2(String str) {
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

    public void I2(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, str) == null) && this.j != null) {
            CompatibleUtile.getInstance().loadUrl(this.j, str);
            this.j.setWebViewSkinOverly(str);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            super.onActivityCreated(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            co5.a(getPageContext(), this.i);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("tab_name", this.e);
            bundle.putString("tab_code", this.f);
            bundle.putString("tab_url", this.g);
            bundle.putInt("tab_type", this.h);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            super.onUserChanged(z);
        }
    }

    public static void K2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2016568, new d());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public String F2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public void G2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            BrowserHelper.initCookie(getBaseFragmentActivity().getApplicationContext());
        }
    }

    public final void J2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            registerListener(this.t);
            registerListener(this.u);
        }
    }

    public final void M2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.t);
            MessageManager.getInstance().unRegisterListener(this.u);
        }
    }

    @Override // com.baidu.tieba.ee7
    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            i();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return super.getCurrentPageSourceKeyList();
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public PageStayDurationItem getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return super.getPageStayDurationItem();
        }
        return (PageStayDurationItem) invokeV.objValue;
    }

    @Override // com.baidu.tieba.dt4
    public void hideLoading() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || (frameLayout = this.k) == null) {
            return;
        }
        this.o = false;
        frameLayout.setVisibility(8);
        hideLoadingView(this.k);
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            String str = this.a;
            if (str != null && str.contains("redirect=1")) {
                this.q = true;
            }
            I2(this.a);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onDestroy();
            dfa dfaVar = this.m;
            if (dfaVar != null) {
                dfaVar.h();
            }
            li5.e().b();
            g48 g48Var = this.r;
            if (g48Var != null) {
                g48Var.c();
            }
            M2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            NestedScrollWebView nestedScrollWebView = this.j;
            if (nestedScrollWebView != null) {
                nestedScrollWebView.setVisibility(8);
            }
            super.onDestroyView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onPause();
            g48 g48Var = this.r;
            if (g48Var != null) {
                g48Var.f();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onResume();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public ViewGroup taskAttachParentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.l;
        }
        return (ViewGroup) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            String e2 = np4.f().e(taskActionId(), "tab_code");
            if (!TextUtils.isEmpty(e2) && e2.equalsIgnoreCase(this.f)) {
                super.taskStart();
            }
        }
    }

    public final efa D2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001386, efa.class, getPageContext());
            if (runTask != null && runTask.getData() != null) {
                return (efa) runTask.getData();
            }
            return null;
        }
        return (efa) invokeV.objValue;
    }

    public final void L2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && isPrimary()) {
            StatisticItem statisticItem = new StatisticItem("c13749");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("resource_id", this.e);
            statisticItem.param("obj_type", this.f);
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tieba.ee7
    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            NestedScrollWebView nestedScrollWebView = this.j;
            if (nestedScrollWebView != null) {
                nestedScrollWebView.onChangeSkinType();
                this.j.setWebViewSkinOverly(this.g);
            }
            if (this.m != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("skin", SkinManager.getCurrentSkinTypeString());
                this.m.i(this.j, CommonTbJsBridge.CHANGE_SKIN_TYPE, linkedHashMap);
            }
        }
    }

    public void H2() {
        NestedScrollWebView nestedScrollWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (nestedScrollWebView = this.j) != null) {
            nestedScrollWebView.setNeedDisAllowParentInterceptTouchEvent(false);
            this.j.getSettings().setJavaScriptEnabled(true);
            this.j.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            this.j.getSettings().setAllowFileAccess(true);
            this.j.getSettings().setDatabaseEnabled(true);
            this.j.getSettings().setDomStorageEnabled(true);
            this.j.getSettings().setSupportZoom(true);
            this.j.getSettings().setBuiltInZoomControls(true);
            this.j.getSettings().setUseWideViewPort(true);
            this.j.getSettings().setLoadWithOverviewMode(true);
            this.j.getSettings().setTextZoom(100);
            this.j.getSettings().setDatabasePath(getBaseFragmentActivity().getApplicationContext().getDir("databases", 0).getAbsolutePath());
            this.j.setHorizontalScrollBarEnabled(false);
            this.j.setHorizontalScrollbarOverlay(false);
            this.j.setInitialScale(100);
            this.j.setScrollBarStyle(33554432);
            this.j.setWebViewClient(new f(this));
            this.j.setDownloadListener(new g(this, null));
            gr4 gr4Var = new gr4(getPageContext());
            gr4Var.b(this.s);
            this.j.setWebChromeClient(gr4Var);
            CompatibleUtile.getInstance().removeJavascriptInterface(this.j);
            this.j.registerPerformanceTracker(new TbChannelJsInterface(this.d));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048594, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            super.onCreate(bundle);
            if (getArguments() != null) {
                Bundle arguments = getArguments();
                this.h = arguments.getInt("tab_type");
                this.e = arguments.getString("tab_name");
                this.f = arguments.getString("tab_code");
                this.g = arguments.getString("tab_url");
            } else if (bundle != null) {
                this.h = bundle.getInt("tab_type");
                this.e = bundle.getString("tab_name");
                this.f = bundle.getString("tab_code");
                this.g = bundle.getString("tab_url");
            }
            this.a = this.g;
            g48 g48Var = new g48(this);
            this.r = g48Var;
            g48Var.b(bundle);
            if (this.m == null) {
                this.m = new dfa();
            }
            if (this.m.b()) {
                this.m.a(new XiubaTbJsBridge(getPageContext()));
                this.m.a(new CommonTbJsBridge(getPageContext().getPageActivity()));
                this.m.a(D2());
            }
            G2();
            J2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @RequiresApi(api = 11)
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048597, this, layoutInflater, viewGroup, bundle)) == null) {
            View view2 = this.i;
            if (view2 != null && (view2.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.i.getParent()).removeView(this.i);
            }
            if (this.i == null) {
                View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d095d, (ViewGroup) null);
                this.i = inflate;
                this.j = (NestedScrollWebView) inflate.findViewById(R.id.obfuscated_res_0x7f092a0e);
                this.k = (FrameLayout) this.i.findViewById(R.id.load_state_container);
                this.l = (ViewGroup) this.i.findViewById(R.id.obfuscated_res_0x7f092463);
                H2();
            }
            NestedScrollWebView nestedScrollWebView = this.j;
            if (nestedScrollWebView != null) {
                nestedScrollWebView.setVisibility(0);
            }
            if (TbadkCoreApplication.getInst().isUseBottomBarDynamicStyleHeight()) {
                this.i.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
            } else {
                this.i.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return this.i;
        }
        return (View) invokeLLL.objValue;
    }
}
