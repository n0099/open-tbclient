package com.baidu.tieba.frs.h5;

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
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.view.NestedScrollWebView;
import com.baidu.tbadk.pageStayDuration.PageStayDurationItem;
import com.baidu.tieba.R;
import com.baidu.tieba.ax4;
import com.baidu.tieba.bt5;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.ei7;
import com.baidu.tieba.in5;
import com.baidu.tieba.nga;
import com.baidu.tieba.oga;
import com.baidu.tieba.pga;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.vw4;
import com.baidu.tieba.w25;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class FrsTabWebFragment extends BaseWebViewFragment implements ei7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String e;
    public String f;
    public String g;
    public int h;
    public View i;
    public NestedScrollWebView j;
    public FrameLayout k;
    public nga l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public FrsViewData q;
    public pga r;
    public CustomMessageListener s;
    public NestedScrollWebView.a t;
    public final View.OnClickListener u;

    @Override // com.baidu.tieba.ei7
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ei7
    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements pga {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabWebFragment a;

        public a(FrsTabWebFragment frsTabWebFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabWebFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsTabWebFragment;
        }

        @Override // com.baidu.tieba.pga
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, jsPromptResult)) == null) {
                if (this.a.l != null) {
                    return this.a.l.c(this.a.j, str, jsPromptResult);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabWebFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(FrsTabWebFragment frsTabWebFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabWebFragment, Integer.valueOf(i)};
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
            this.a = frsTabWebFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && !StringUtils.isNull(this.a.a)) {
                this.a.h();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements NestedScrollWebView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabWebFragment a;

        public c(FrsTabWebFragment frsTabWebFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabWebFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsTabWebFragment;
        }

        @Override // com.baidu.tbadk.coreExtra.view.NestedScrollWebView.a
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.getBaseFragmentActivity() != null) {
                this.a.getBaseFragmentActivity().setSwipeBackEnabled(true);
            }
        }

        @Override // com.baidu.tbadk.coreExtra.view.NestedScrollWebView.a
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.getBaseFragmentActivity() != null) {
                this.a.getBaseFragmentActivity().setSwipeBackEnabled(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabWebFragment a;

        public d(FrsTabWebFragment frsTabWebFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabWebFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsTabWebFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0e29);
                } else {
                    this.a.h();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class e extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<FrsTabWebFragment> a;

        public e(FrsTabWebFragment frsTabWebFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabWebFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(frsTabWebFragment);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                FrsTabWebFragment frsTabWebFragment = this.a.get();
                if (frsTabWebFragment == null) {
                    return;
                }
                frsTabWebFragment.n = false;
                frsTabWebFragment.a = str;
                if (frsTabWebFragment.j != null && frsTabWebFragment.k != null) {
                    webView.getProgress();
                    if (frsTabWebFragment.o) {
                        frsTabWebFragment.j.stopLoading();
                        frsTabWebFragment.j.setVisibility(8);
                        frsTabWebFragment.k.setVisibility(0);
                        frsTabWebFragment.hideLoadingView(frsTabWebFragment.k);
                        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                        frsTabWebFragment.showNetRefreshView(frsTabWebFragment.k, inst.getString(R.string.url_not_found), null, inst.getString(R.string.obfuscated_res_0x7f0f1207), false, frsTabWebFragment.u);
                        return;
                    }
                    frsTabWebFragment.m = false;
                    frsTabWebFragment.j.setVisibility(0);
                    frsTabWebFragment.k.setVisibility(8);
                    frsTabWebFragment.hideLoadingView(frsTabWebFragment.k);
                    frsTabWebFragment.hideNetRefreshView(frsTabWebFragment.k);
                    String title = frsTabWebFragment.j.getTitle();
                    if (!TextUtils.isEmpty(title)) {
                        frsTabWebFragment.d2(title);
                    }
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) {
                FrsTabWebFragment frsTabWebFragment = this.a.get();
                if (frsTabWebFragment == null || TextUtils.isEmpty(str) || frsTabWebFragment.getPageContext() == null || frsTabWebFragment.j == null) {
                    return false;
                }
                if (!frsTabWebFragment.m) {
                    if (frsTabWebFragment.w2(str) && !TbadkCoreApplication.isLogin() && frsTabWebFragment.getPageContext() != null) {
                        ViewHelper.skipToLoginActivity(frsTabWebFragment.getPageContext().getPageActivity());
                        return false;
                    }
                    if (frsTabWebFragment.j != null && frsTabWebFragment.j.isShown()) {
                        if (frsTabWebFragment.W1(str)) {
                            int dealOneLinkWithOutJumpWebView = UrlManager.getInstance().dealOneLinkWithOutJumpWebView(frsTabWebFragment.getPageContext(), new String[]{str});
                            if (dealOneLinkWithOutJumpWebView != 0 && dealOneLinkWithOutJumpWebView != 1) {
                                return false;
                            }
                            return true;
                        } else if (frsTabWebFragment.p) {
                            if (UrlManager.getInstance().dealOneLinkWithOutJumpWebView(frsTabWebFragment.getPageContext(), new String[]{str}) != 0) {
                                return false;
                            }
                            return true;
                        } else {
                            UrlManager.getInstance().dealOneLink((TbPageContext<?>) frsTabWebFragment.getPageContext(), new String[]{str}, true);
                        }
                    }
                    return true;
                }
                frsTabWebFragment.m = false;
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                FrsTabWebFragment frsTabWebFragment = this.a.get();
                if (frsTabWebFragment != null && frsTabWebFragment.j != null && frsTabWebFragment.k != null) {
                    frsTabWebFragment.o = false;
                    if (frsTabWebFragment.m) {
                        frsTabWebFragment.n = true;
                        frsTabWebFragment.k.setVisibility(0);
                        frsTabWebFragment.showLoadingView(frsTabWebFragment.k);
                    }
                    frsTabWebFragment.a = str;
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i, str, str2) == null) {
                super.onReceivedError(webView, i, str, str2);
                FrsTabWebFragment frsTabWebFragment = this.a.get();
                if (frsTabWebFragment != null) {
                    frsTabWebFragment.o = true;
                    if (frsTabWebFragment.j != null && frsTabWebFragment.k != null) {
                        frsTabWebFragment.j.stopLoading();
                        frsTabWebFragment.j.setVisibility(8);
                        frsTabWebFragment.k.setVisibility(0);
                        frsTabWebFragment.hideLoadingView(frsTabWebFragment.k);
                        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                        frsTabWebFragment.showNetRefreshView(frsTabWebFragment.k, inst.getString(R.string.url_not_found), null, inst.getString(R.string.obfuscated_res_0x7f0f1207), false, frsTabWebFragment.u);
                    }
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, renderProcessGoneDetail)) == null) {
                ax4.a("FrsTabWebFragment", webView);
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class f implements DownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabWebFragment a;

        public f(FrsTabWebFragment frsTabWebFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabWebFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsTabWebFragment;
        }

        public /* synthetic */ f(FrsTabWebFragment frsTabWebFragment, a aVar) {
            this(frsTabWebFragment);
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

    public FrsTabWebFragment() {
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
        this.r = new a(this);
        this.s = new b(this, 2005016);
        this.t = new c(this);
        this.u = new d(this);
    }

    public final void B2() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && TbadkCoreApplication.getInst().getString(R.string.content_collection).equals(this.e) && (frsViewData = this.q) != null && frsViewData.getForum() != null) {
            new StatisticItem(CommonStatisticKey.KEY_FRS_CONTENT_COLLECTION_TAB_LOG).addParam("fid", this.q.getForum().getId()).eventStat();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.k != null && this.j != null && !this.n && !TextUtils.isEmpty(this.a) && BdNetTypeUtil.isNetWorkAvailable()) {
            this.n = true;
            this.m = true;
            this.k.setVisibility(0);
            this.j.setVisibility(8);
            hideNetRefreshView(this.k);
            showLoadingView(this.k);
            A2(this.a);
        }
    }

    public void A2(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.j != null) {
            CompatibleUtile.getInstance().loadUrl(this.j, str);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onActivityCreated(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            bt5.a(getPageContext(), this.i);
            q0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (bundle != null) {
                bundle.putString("tab_name", this.e);
                bundle.putString("tab_code", this.f);
                bundle.putString("tab_url", this.g);
                bundle.putInt("tab_type", this.h);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            super.onUserChanged(z);
        }
    }

    public final boolean w2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            return str.contains("tieba_check_login=1");
        }
        return invokeL.booleanValue;
    }

    public void u2(w25 w25Var, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, w25Var, jSONObject) == null) && this.h == 102 && this.l != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("threadInfo", jSONObject);
            this.l.i(this.j, CommonTbJsBridge.CHANGE_POST_WALL, hashMap);
        }
    }

    @Override // com.baidu.tieba.ei7
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            h();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return super.getCurrentPageSourceKeyList();
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public PageStayDurationItem getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return super.getPageStayDurationItem();
        }
        return (PageStayDurationItem) invokeV.objValue;
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            String str = this.a;
            if (str != null && str.contains("redirect=1")) {
                this.p = true;
            }
            A2(this.a);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDestroy();
            nga ngaVar = this.l;
            if (ngaVar != null) {
                ngaVar.h();
            }
            in5.e().b();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            NestedScrollWebView nestedScrollWebView = this.j;
            if (nestedScrollWebView != null) {
                nestedScrollWebView.setVisibility(8);
                this.j.setWebViewClient(null);
            }
            super.onDestroyView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @RequiresApi(api = 11)
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onPrimary();
            if (!isAdded() || !isPrimary() || this.j == null) {
                return;
            }
            B2();
            if (this.m) {
                initData();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onResume();
        }
    }

    public void y2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            BrowserHelper.initCookie(getBaseFragmentActivity().getApplicationContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048587, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onCreate(bundle);
            if (getArguments() != null) {
                Bundle arguments = getArguments();
                this.h = arguments.getInt("tab_type");
                this.e = arguments.getString("tab_name");
                this.f = arguments.getString("tab_code");
                this.g = arguments.getString("tab_url");
                this.q = (FrsViewData) arguments.getSerializable("view_data");
            } else if (bundle != null) {
                this.h = bundle.getInt("tab_type");
                this.e = bundle.getString("tab_name");
                this.f = bundle.getString("tab_code");
                this.g = bundle.getString("tab_url");
                this.q = (FrsViewData) bundle.getSerializable("view_data");
            }
            x2();
            this.a = this.g;
            nga ngaVar = new nga();
            this.l = ngaVar;
            ngaVar.a(new XiubaTbJsBridge(getPageContext()));
            this.l.a(new CommonTbJsBridge(getPageContext().getPageActivity()));
            this.l.a(v2());
            registerListener(this.s);
            y2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @RequiresApi(api = 11)
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, layoutInflater, viewGroup, bundle)) == null) {
            View view2 = this.i;
            if (view2 != null && (view2.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.i.getParent()).removeView(this.i);
            }
            if (this.i == null) {
                View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d03ae, (ViewGroup) null);
                this.i = inflate;
                this.j = (NestedScrollWebView) inflate.findViewById(R.id.obfuscated_res_0x7f092a1b);
                if (getBaseFragmentActivity() != null && getBaseFragmentActivity().isSwipeBackEnabled()) {
                    this.j.setOnHandleTouchEventListener(this.t);
                }
                this.k = (FrameLayout) this.i.findViewById(R.id.load_state_container);
                z2();
            }
            NestedScrollWebView nestedScrollWebView = this.j;
            if (nestedScrollWebView != null) {
                nestedScrollWebView.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return this.i;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.ei7
    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0202);
            if (this.l != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("skin", SkinManager.getCurrentSkinTypeString());
                this.l.i(this.j, CommonTbJsBridge.CHANGE_SKIN_TYPE, linkedHashMap);
            }
        }
    }

    public final oga v2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001386, oga.class, getPageContext());
            if (runTask != null && runTask.getData() != null) {
                return (oga) runTask.getData();
            }
            return null;
        }
        return (oga) invokeV.objValue;
    }

    public final void x2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && !TextUtils.isEmpty(this.g)) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.g);
            String str = "?";
            if (this.g.contains("?")) {
                str = "&";
            }
            sb.append(str);
            sb.append("skin=");
            sb.append(SkinManager.getCurrentSkinTypeString());
            this.g = sb.toString();
        }
    }

    @RequiresApi(api = 11)
    public void z2() {
        NestedScrollWebView nestedScrollWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (nestedScrollWebView = this.j) != null) {
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
            this.j.getSettings().setDatabasePath(getBaseFragmentActivity().getApplicationContext().getDir("databases", 0).getAbsolutePath());
            this.j.setHorizontalScrollBarEnabled(false);
            this.j.setHorizontalScrollbarOverlay(false);
            this.j.setInitialScale(100);
            this.j.setScrollBarStyle(33554432);
            this.j.setWebViewClient(new e(this));
            this.j.setDownloadListener(new f(this, null));
            vw4 vw4Var = new vw4(getPageContext());
            vw4Var.b(this.r);
            this.j.setWebChromeClient(vw4Var);
            CompatibleUtile.getInstance().removeJavascriptInterface(this.j);
            this.j.registerPerformanceTracker(new TbChannelJsInterface(this.d));
        }
    }
}
