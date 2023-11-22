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
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.pageStayDuration.PageStayDurationItem;
import com.baidu.tieba.R;
import com.baidu.tieba.bk5;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.by4;
import com.baidu.tieba.cs4;
import com.baidu.tieba.ej6;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.wq7;
import com.baidu.tieba.xp5;
import com.baidu.tieba.xr4;
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
/* loaded from: classes6.dex */
public class NewFrsTabWebFragment extends BaseWebViewFragment implements wq7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String e;
    public String f;
    public String g;
    public int h;
    public View i;
    public TbWebView j;
    public FrameLayout k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public FrsViewData p;
    public CustomMessageListener q;
    public final View.OnClickListener r;

    @Override // com.baidu.tieba.wq7
    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.tieba.wq7
    public void c0() {
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

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewFrsTabWebFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(NewFrsTabWebFragment newFrsTabWebFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFrsTabWebFragment, Integer.valueOf(i)};
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
            this.a = newFrsTabWebFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && !StringUtils.isNull(this.a.a)) {
                this.a.i();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewFrsTabWebFragment a;

        public b(NewFrsTabWebFragment newFrsTabWebFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFrsTabWebFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newFrsTabWebFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0e61);
                } else {
                    this.a.i();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<NewFrsTabWebFragment> a;

        public c(NewFrsTabWebFragment newFrsTabWebFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFrsTabWebFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(newFrsTabWebFragment);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                NewFrsTabWebFragment newFrsTabWebFragment = this.a.get();
                if (newFrsTabWebFragment == null) {
                    return;
                }
                newFrsTabWebFragment.m = false;
                newFrsTabWebFragment.a = str;
                if (newFrsTabWebFragment.j != null && newFrsTabWebFragment.k != null) {
                    webView.getProgress();
                    if (newFrsTabWebFragment.n) {
                        newFrsTabWebFragment.j.getController().e();
                        newFrsTabWebFragment.j.setVisibility(8);
                        newFrsTabWebFragment.k.setVisibility(0);
                        newFrsTabWebFragment.hideLoadingView(newFrsTabWebFragment.k);
                        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                        newFrsTabWebFragment.showNetRefreshView(newFrsTabWebFragment.k, inst.getString(R.string.url_not_found), null, inst.getString(R.string.obfuscated_res_0x7f0f1245), false, newFrsTabWebFragment.r);
                        return;
                    }
                    newFrsTabWebFragment.l = false;
                    newFrsTabWebFragment.j.setVisibility(0);
                    newFrsTabWebFragment.k.setVisibility(8);
                    newFrsTabWebFragment.hideLoadingView(newFrsTabWebFragment.k);
                    newFrsTabWebFragment.hideNetRefreshView(newFrsTabWebFragment.k);
                    String b = newFrsTabWebFragment.j.getController().b();
                    if (!TextUtils.isEmpty(b)) {
                        newFrsTabWebFragment.D2(b);
                    }
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) {
                NewFrsTabWebFragment newFrsTabWebFragment = this.a.get();
                if (newFrsTabWebFragment == null || TextUtils.isEmpty(str) || newFrsTabWebFragment.getPageContext() == null || newFrsTabWebFragment.j == null) {
                    return false;
                }
                if (!newFrsTabWebFragment.l) {
                    if (newFrsTabWebFragment.U2(str) && !TbadkCoreApplication.isLogin() && newFrsTabWebFragment.getPageContext() != null) {
                        ViewHelper.skipToLoginActivity(newFrsTabWebFragment.getPageContext().getPageActivity());
                        return false;
                    }
                    if (newFrsTabWebFragment.j != null && newFrsTabWebFragment.j.isShown()) {
                        if (newFrsTabWebFragment.w2(str)) {
                            int dealOneLinkWithOutJumpWebView = UrlManager.getInstance().dealOneLinkWithOutJumpWebView(newFrsTabWebFragment.getPageContext(), new String[]{str});
                            if (dealOneLinkWithOutJumpWebView != 0 && dealOneLinkWithOutJumpWebView != 1) {
                                return false;
                            }
                            return true;
                        } else if (newFrsTabWebFragment.o) {
                            if (UrlManager.getInstance().dealOneLinkWithOutJumpWebView(newFrsTabWebFragment.getPageContext(), new String[]{str}) != 0) {
                                return false;
                            }
                            return true;
                        } else {
                            UrlManager.getInstance().dealOneLink((TbPageContext<?>) newFrsTabWebFragment.getPageContext(), new String[]{str}, true);
                        }
                    }
                    return true;
                }
                newFrsTabWebFragment.l = false;
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                NewFrsTabWebFragment newFrsTabWebFragment = this.a.get();
                if (newFrsTabWebFragment != null && newFrsTabWebFragment.j != null && newFrsTabWebFragment.k != null) {
                    newFrsTabWebFragment.n = false;
                    if (newFrsTabWebFragment.l) {
                        newFrsTabWebFragment.m = true;
                        newFrsTabWebFragment.k.setVisibility(0);
                        newFrsTabWebFragment.showLoadingView(newFrsTabWebFragment.k);
                    }
                    newFrsTabWebFragment.a = str;
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i, str, str2) == null) {
                super.onReceivedError(webView, i, str, str2);
                NewFrsTabWebFragment newFrsTabWebFragment = this.a.get();
                if (newFrsTabWebFragment != null) {
                    newFrsTabWebFragment.n = true;
                    if (newFrsTabWebFragment.j != null && newFrsTabWebFragment.k != null) {
                        newFrsTabWebFragment.j.getController().e();
                        newFrsTabWebFragment.j.setVisibility(8);
                        newFrsTabWebFragment.k.setVisibility(0);
                        newFrsTabWebFragment.hideLoadingView(newFrsTabWebFragment.k);
                        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                        newFrsTabWebFragment.showNetRefreshView(newFrsTabWebFragment.k, inst.getString(R.string.url_not_found), null, inst.getString(R.string.obfuscated_res_0x7f0f1245), false, newFrsTabWebFragment.r);
                    }
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, renderProcessGoneDetail)) == null) {
                cs4.a("FrsTabWebFragment", webView);
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements DownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewFrsTabWebFragment a;

        public d(NewFrsTabWebFragment newFrsTabWebFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFrsTabWebFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newFrsTabWebFragment;
        }

        public /* synthetic */ d(NewFrsTabWebFragment newFrsTabWebFragment, a aVar) {
            this(newFrsTabWebFragment);
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

    public NewFrsTabWebFragment() {
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
        this.l = true;
        this.o = false;
        this.q = new a(this, 2005016);
        this.r = new b(this);
    }

    public final void V2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && !TextUtils.isEmpty(this.g)) {
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
    public void X2() {
        TbWebView tbWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (tbWebView = this.j) != null) {
            tbWebView.setNeedDisAllowParentInterceptTouchEvent(false);
            this.j.setNestedScrollingEnabled(true);
            this.j.setWebViewClient(new c(this));
            this.j.setDownloadListener(new d(this, null));
            this.j.setWebChromeClient(new xr4(getPageContext()));
        }
    }

    public final boolean U2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            return str.contains("tieba_check_login=1");
        }
        return invokeL.booleanValue;
    }

    public void Y2(String str) {
        TbWebView tbWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) && (tbWebView = this.j) != null) {
            tbWebView.loadUrl(str);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            super.onActivityCreated(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            xp5.a(getPageContext(), this.i);
            G0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bundle) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            super.onUserChanged(z);
        }
    }

    public void T2(by4 by4Var, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, by4Var, jSONObject) == null) && this.h == 102) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("threadInfo", jSONObject);
            ej6.a().d(this.j, CommonTbJsBridge.CHANGE_POST_WALL, hashMap);
        }
    }

    @Override // com.baidu.tieba.wq7
    public void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0202);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("skin", SkinManager.getCurrentSkinTypeString());
            ej6.a().d(this.j, CommonTbJsBridge.CHANGE_SKIN_TYPE, linkedHashMap);
        }
    }

    @Override // com.baidu.tieba.wq7
    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            i();
        }
    }

    public void W2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            BrowserHelper.initCookie(getBaseFragmentActivity().getApplicationContext());
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

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            String str = this.a;
            if (str != null && str.contains("redirect=1")) {
                this.o = true;
            }
            Y2(this.a);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onDestroy();
            TbWebView tbWebView = this.j;
            if (tbWebView != null) {
                tbWebView.onDestroy();
            }
            bk5.e().b();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            TbWebView tbWebView = this.j;
            if (tbWebView != null) {
                tbWebView.setVisibility(8);
                this.j.setWebViewClient(null);
            }
            super.onDestroyView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onPause();
            TbWebView tbWebView = this.j;
            if (tbWebView != null) {
                tbWebView.onPause();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    @RequiresApi(api = 11)
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onPrimary();
            if (!isAdded() || !isPrimary() || this.j == null) {
                return;
            }
            Z2();
            if (this.l) {
                initData();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onResume();
            TbWebView tbWebView = this.j;
            if (tbWebView != null) {
                tbWebView.onResume();
            }
        }
    }

    public final void Z2() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && TbadkCoreApplication.getInst().getString(R.string.content_collection).equals(this.e) && (frsViewData = this.p) != null && frsViewData.getForum() != null) {
            new StatisticItem(CommonStatisticKey.KEY_FRS_CONTENT_COLLECTION_TAB_LOG).addParam("fid", this.p.getForum().getId()).eventStat();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.k != null && this.j != null && !this.m && !TextUtils.isEmpty(this.a) && BdNetTypeUtil.isNetWorkAvailable()) {
            this.m = true;
            this.l = true;
            this.k.setVisibility(0);
            this.j.setVisibility(8);
            hideNetRefreshView(this.k);
            showLoadingView(this.k);
            Y2(this.a);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048593, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            super.onCreate(bundle);
            if (getArguments() != null) {
                Bundle arguments = getArguments();
                this.h = arguments.getInt("tab_type");
                this.e = arguments.getString("tab_name");
                this.f = arguments.getString("tab_code");
                this.g = arguments.getString("tab_url");
                this.p = (FrsViewData) arguments.getSerializable("view_data");
            } else if (bundle != null) {
                this.h = bundle.getInt("tab_type");
                this.e = bundle.getString("tab_name");
                this.f = bundle.getString("tab_code");
                this.g = bundle.getString("tab_url");
                this.p = (FrsViewData) bundle.getSerializable("view_data");
            }
            V2();
            this.a = this.g;
            registerListener(this.q);
            W2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @RequiresApi(api = 11)
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048596, this, layoutInflater, viewGroup, bundle)) == null) {
            View view2 = this.i;
            if (view2 != null && (view2.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.i.getParent()).removeView(this.i);
            }
            if (this.i == null) {
                View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d071b, (ViewGroup) null);
                this.i = inflate;
                this.j = (TbWebView) inflate.findViewById(R.id.obfuscated_res_0x7f092a6d);
                this.k = (FrameLayout) this.i.findViewById(R.id.load_state_container);
                X2();
            }
            TbWebView tbWebView = this.j;
            if (tbWebView != null) {
                tbWebView.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return this.i;
        }
        return (View) invokeLLL.objValue;
    }
}
