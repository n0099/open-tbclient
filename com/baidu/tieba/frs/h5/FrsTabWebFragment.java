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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BaseWebViewFragment;
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
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.gt4;
import com.baidu.tieba.gy4;
import com.baidu.tieba.ik5;
import com.baidu.tieba.jt4;
import com.baidu.tieba.kx6;
import com.baidu.tieba.oc9;
import com.baidu.tieba.ot4;
import com.baidu.tieba.pc9;
import com.baidu.tieba.qc9;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tf5;
import com.baidu.tieba.tl5;
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
/* loaded from: classes4.dex */
public class FrsTabWebFragment extends BaseWebViewFragment implements kx6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String e;
    public String f;
    public String g;
    public int h;
    public View i;
    public NestedScrollWebView j;
    public FrameLayout k;
    public oc9 l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public FrsViewData q;
    public qc9 r;
    public CustomMessageListener s;
    public NestedScrollWebView.a t;
    public final View.OnClickListener u;

    @Override // com.baidu.tieba.kx6
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.tieba.kx6
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.fk5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public class a implements qc9 {
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

        @Override // com.baidu.tieba.qc9
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

    /* loaded from: classes4.dex */
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
                this.a.y();
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0d1f);
                } else {
                    this.a.y();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                        frsTabWebFragment.showNetRefreshView(frsTabWebFragment.k, inst.getString(R.string.url_not_found), null, inst.getString(R.string.obfuscated_res_0x7f0f109c), false, frsTabWebFragment.u);
                        return;
                    }
                    frsTabWebFragment.m = false;
                    frsTabWebFragment.j.setVisibility(0);
                    frsTabWebFragment.k.setVisibility(8);
                    frsTabWebFragment.hideLoadingView(frsTabWebFragment.k);
                    frsTabWebFragment.hideNetRefreshView(frsTabWebFragment.k);
                    String title = frsTabWebFragment.j.getTitle();
                    if (!TextUtils.isEmpty(title)) {
                        frsTabWebFragment.N1(title);
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
                    if (frsTabWebFragment.g2(str) && !TbadkCoreApplication.isLogin() && frsTabWebFragment.getPageContext() != null) {
                        ViewHelper.skipToLoginActivity(frsTabWebFragment.getPageContext().getPageActivity());
                        return false;
                    }
                    if (frsTabWebFragment.j != null && frsTabWebFragment.j.isShown()) {
                        if (frsTabWebFragment.G1(str)) {
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
                        frsTabWebFragment.showNetRefreshView(frsTabWebFragment.k, inst.getString(R.string.url_not_found), null, inst.getString(R.string.obfuscated_res_0x7f0f109c), false, frsTabWebFragment.u);
                    }
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, renderProcessGoneDetail)) == null) {
                ot4.a("FrsTabWebFragment", webView);
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
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
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
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

    public final void l2() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && TbadkCoreApplication.getInst().getString(R.string.content_collection).equals(this.e) && (frsViewData = this.q) != null && frsViewData.getForum() != null) {
            new StatisticItem(CommonStatisticKey.KEY_FRS_CONTENT_COLLECTION_TAB_LOG).addParam("fid", this.q.getForum().getId()).eventStat();
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && this.k != null && this.j != null && !this.n && !TextUtils.isEmpty(this.a) && BdNetTypeUtil.isNetWorkAvailable()) {
            this.n = true;
            this.m = true;
            this.k.setVisibility(0);
            this.j.setVisibility(8);
            hideNetRefreshView(this.k);
            showLoadingView(this.k);
            k2(this.a);
        }
    }

    public final boolean g2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            return str.contains("tieba_check_login=1");
        }
        return invokeL.booleanValue;
    }

    public void k2(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, str) == null) && this.j != null) {
            CompatibleUtile.getInstance().loadUrl(this.j, str);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
            super.onActivityCreated(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            tl5.a(getPageContext(), this.i);
            Z();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bundle) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            super.onUserChanged(z);
        }
    }

    public void e2(gy4 gy4Var, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, gy4Var, jSONObject) == null) && this.h == 102 && this.l != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("threadInfo", jSONObject);
            this.l.i(this.j, CommonTbJsBridge.CHANGE_POST_WALL, hashMap);
        }
    }

    @Override // com.baidu.tieba.kx6
    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0202);
            if (this.l != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("skin", SkinManager.getCurrentSkinTypeString());
                this.l.i(this.j, CommonTbJsBridge.CHANGE_SKIN_TYPE, linkedHashMap);
            }
        }
    }

    public final pc9 f2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001386, pc9.class, getPageContext());
            if (runTask != null && runTask.getData() != null) {
                return (pc9) runTask.getData();
            }
            return null;
        }
        return (pc9) invokeV.objValue;
    }

    public final void h2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && !TextUtils.isEmpty(this.g)) {
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

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.fk5
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return super.getCurrentPageSourceKeyList();
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public ik5 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return super.getPageStayDurationItem();
        }
        return (ik5) invokeV.objValue;
    }

    public void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            gt4.j(getBaseFragmentActivity().getApplicationContext());
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            String str = this.a;
            if (str != null && str.contains("redirect=1")) {
                this.p = true;
            }
            k2(this.a);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onDestroy();
            oc9 oc9Var = this.l;
            if (oc9Var != null) {
                oc9Var.h();
            }
            tf5.e().b();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onPrimary();
            if (!isAdded() || !isPrimary() || this.j == null) {
                return;
            }
            l2();
            if (this.m) {
                initData();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onResume();
        }
    }

    @Override // com.baidu.tieba.kx6
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            y();
        }
    }

    @RequiresApi(api = 11)
    public void j2() {
        NestedScrollWebView nestedScrollWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (nestedScrollWebView = this.j) != null) {
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
            jt4 jt4Var = new jt4(getPageContext());
            jt4Var.b(this.r);
            this.j.setWebChromeClient(jt4Var);
            CompatibleUtile.getInstance().removeJavascriptInterface(this.j);
            this.j.registerPerformanceTracker(new TbChannelJsInterface(this.d));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048592, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bundle) == null) {
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
            h2();
            this.a = this.g;
            oc9 oc9Var = new oc9();
            this.l = oc9Var;
            oc9Var.a(new XiubaTbJsBridge(getPageContext()));
            this.l.a(new CommonTbJsBridge(getPageContext().getPageActivity()));
            this.l.a(f2());
            registerListener(this.s);
            i2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @RequiresApi(api = 11)
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048595, this, layoutInflater, viewGroup, bundle)) == null) {
            View view2 = this.i;
            if (view2 != null && (view2.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.i.getParent()).removeView(this.i);
            }
            if (this.i == null) {
                View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0379, (ViewGroup) null);
                this.i = inflate;
                this.j = (NestedScrollWebView) inflate.findViewById(R.id.obfuscated_res_0x7f092871);
                if (getBaseFragmentActivity() != null && getBaseFragmentActivity().isSwipeBackEnabled()) {
                    this.j.setOnHandleTouchEventListener(this.t);
                }
                this.k = (FrameLayout) this.i.findViewById(R.id.load_state_container);
                j2();
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
}
