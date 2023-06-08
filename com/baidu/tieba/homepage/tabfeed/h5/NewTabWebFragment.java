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
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.ay4;
import com.baidu.tieba.b38;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.bw4;
import com.baidu.tieba.en5;
import com.baidu.tieba.gt5;
import com.baidu.tieba.jn5;
import com.baidu.tieba.oe7;
import com.baidu.tieba.qx4;
import com.baidu.tieba.vl6;
import com.baidu.tieba.vr5;
import com.baidu.tieba.vx4;
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
public class NewTabWebFragment extends BaseWebViewFragment implements oe7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String e;
    public String f;
    public String g;
    public int h;
    public View i;
    public TbWebView j;
    public FrameLayout k;
    public ViewGroup l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public b38 q;
    public CustomMessageListener r;
    public final CustomMessageListener s;
    public final View.OnClickListener t;

    @Override // com.baidu.tieba.oe7
    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.tieba.oe7
    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.sr5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? "714" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewTabWebFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(NewTabWebFragment newTabWebFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newTabWebFragment, Integer.valueOf(i)};
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
            this.a = newTabWebFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue() && jn5.f().b()) {
                this.a.i.setPadding(0, 0, 0, (int) (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 0.5d));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewTabWebFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(NewTabWebFragment newTabWebFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newTabWebFragment, Integer.valueOf(i)};
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
            this.a = newTabWebFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                vl6.a().d(this.a.j, "writePostSuccess", new HashMap<>());
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements CustomMessageTask.CustomRunnable<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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
                        shareItem.f1080T = optString5;
                        shareItem.U = optString6;
                        shareItem.V = optString7;
                        shareItem.k0 = jSONObject.optInt("shareimg");
                        shareItem.s0 = jSONObject.optInt("weixin_disable");
                        String optString8 = jSONObject.optString("extdata");
                        if (!StringUtils.isNull(optString8)) {
                            try {
                                JSONObject jSONObject2 = new JSONObject(optString8);
                                String optString9 = jSONObject2.optString("activityid");
                                String optString10 = jSONObject2.optString("missionid");
                                if (!StringUtils.isNull(optString9) && !StringUtils.isNull(optString10)) {
                                    JSONObject jSONObject3 = new JSONObject();
                                    jSONObject3.put(optString9, optString10);
                                    shareItem.X = jSONObject3.toString();
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
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewTabWebFragment a;

        public d(NewTabWebFragment newTabWebFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newTabWebFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newTabWebFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0def);
                } else {
                    this.a.h();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewTabWebFragment a;

        public e(NewTabWebFragment newTabWebFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newTabWebFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newTabWebFragment;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                this.a.n = false;
                NewTabWebFragment newTabWebFragment = this.a;
                newTabWebFragment.a = str;
                if (newTabWebFragment.j != null && this.a.k != null) {
                    webView.getProgress();
                    if (this.a.o) {
                        this.a.j.getController().e();
                        this.a.j.setVisibility(8);
                        this.a.k.setVisibility(0);
                        NewTabWebFragment newTabWebFragment2 = this.a;
                        newTabWebFragment2.hideLoadingView(newTabWebFragment2.k);
                        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                        NewTabWebFragment newTabWebFragment3 = this.a;
                        newTabWebFragment3.showNetRefreshView(newTabWebFragment3.k, inst.getString(R.string.url_not_found), null, inst.getString(R.string.obfuscated_res_0x7f0f11c6), false, this.a.t);
                        return;
                    }
                    this.a.m = false;
                    this.a.j.setVisibility(0);
                    this.a.k.setVisibility(8);
                    NewTabWebFragment newTabWebFragment4 = this.a;
                    newTabWebFragment4.hideLoadingView(newTabWebFragment4.k);
                    NewTabWebFragment newTabWebFragment5 = this.a;
                    newTabWebFragment5.hideNetRefreshView(newTabWebFragment5.k);
                    String b = this.a.j.getController().b();
                    if (!TextUtils.isEmpty(b)) {
                        this.a.Q1(b);
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
                if (!this.a.m) {
                    if (this.a.h2(str) && !TbadkCoreApplication.isLogin() && this.a.getPageContext() != null) {
                        ViewHelper.skipToLoginActivity(this.a.getPageContext().getPageActivity());
                        return false;
                    }
                    if (this.a.j != null && this.a.j.isShown()) {
                        if (this.a.J1(str)) {
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
                if (this.a.j != null && this.a.k != null) {
                    this.a.o = false;
                    if (this.a.m) {
                        this.a.n = true;
                        this.a.k.setVisibility(0);
                        NewTabWebFragment newTabWebFragment = this.a;
                        newTabWebFragment.showLoadingView(newTabWebFragment.k);
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
                if (this.a.j != null && this.a.k != null) {
                    this.a.j.getController().e();
                    this.a.j.setVisibility(8);
                    this.a.k.setVisibility(0);
                    NewTabWebFragment newTabWebFragment = this.a;
                    newTabWebFragment.hideLoadingView(newTabWebFragment.k);
                    TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                    NewTabWebFragment newTabWebFragment2 = this.a;
                    newTabWebFragment2.showNetRefreshView(newTabWebFragment2.k, inst.getString(R.string.url_not_found), null, inst.getString(R.string.obfuscated_res_0x7f0f11c6), false, this.a.t);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, renderProcessGoneDetail)) == null) {
                ay4.a("TabWebFragment", webView);
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class f implements DownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewTabWebFragment a;

        public f(NewTabWebFragment newTabWebFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newTabWebFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newTabWebFragment;
        }

        public /* synthetic */ f(NewTabWebFragment newTabWebFragment, a aVar) {
            this(newTabWebFragment);
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

    public NewTabWebFragment() {
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
        this.r = new a(this, 2921551);
        this.s = new b(this, 2921786);
        this.t = new d(this);
    }

    @Override // com.baidu.tieba.oe7
    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            if (this.j != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("skin", SkinManager.getCurrentSkinTypeString());
                vl6.a().d(this.j, CommonTbJsBridge.CHANGE_SKIN_TYPE, linkedHashMap);
                this.j.setWebViewSkinOverly(this.g, R.color.CAM_X0503);
            }
        }
    }

    public void j2() {
        TbWebView tbWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (tbWebView = this.j) != null) {
            tbWebView.setNeedDisAllowParentInterceptTouchEvent(false);
            this.j.setWebViewClient(new e(this));
            this.j.setDownloadListener(new f(this, null));
            this.j.setWebChromeClient(new vx4(getPageContext()));
        }
    }

    public final void n2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && isPrimary()) {
            StatisticItem statisticItem = new StatisticItem("c13749");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("resource_id", this.e);
            statisticItem.param("obj_type", this.f);
            TiebaStatic.log(statisticItem);
        }
    }

    public final boolean h2(String str) {
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

    public void k2(String str) {
        TbWebView tbWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, str) == null) && (tbWebView = this.j) != null) {
            tbWebView.loadUrl(str);
            this.j.setWebViewSkinOverly(str, R.color.CAM_X0503);
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
            gt5.a(getPageContext(), this.i);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bundle) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            super.onUserChanged(z);
        }
    }

    public static void m2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2016568, new c());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    @Override // com.baidu.tieba.oe7
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            h();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.sr5
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return super.getCurrentPageSourceKeyList();
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public vr5 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return super.getPageStayDurationItem();
        }
        return (vr5) invokeV.objValue;
    }

    public void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            qx4.k(getBaseFragmentActivity().getApplicationContext());
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            String str = this.a;
            if (str != null && str.contains("redirect=1")) {
                this.p = true;
            }
            k2(this.a);
        }
    }

    public final void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            registerListener(this.r);
            registerListener(this.s);
        }
    }

    public final void o2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.r);
            MessageManager.getInstance().unRegisterListener(this.s);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onDestroy();
            en5.e().b();
            o2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            TbWebView tbWebView = this.j;
            if (tbWebView != null) {
                tbWebView.setVisibility(8);
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
            b38 b38Var = this.q;
            if (b38Var != null) {
                b38Var.d();
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

    @Override // com.baidu.tbadk.core.BaseFragment
    public ViewGroup taskAttachParentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.l;
        }
        return (ViewGroup) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            String e2 = bw4.f().e(taskActionId(), "tab_code");
            if (!TextUtils.isEmpty(e2) && e2.equalsIgnoreCase(this.f)) {
                super.taskStart();
            }
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.k != null && this.j != null && !this.n && !TextUtils.isEmpty(this.a) && BdNetTypeUtil.isNetWorkAvailable()) {
            this.n = true;
            this.m = true;
            this.k.setVisibility(0);
            this.j.setVisibility(8);
            hideNetRefreshView(this.k);
            showLoadingView(this.k);
            k2(this.a);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                if (this.j == null) {
                    return;
                }
                n2();
                if (this.m) {
                    initData();
                }
                m2();
                vl6.a().d(this.j, CommonTbJsBridge.RE_SHOW, null);
                this.j.setWebViewSkinOverly(this.g, R.color.CAM_X0503);
            } else {
                MessageManager.getInstance().unRegisterTask(2016568);
            }
            b38 b38Var = this.q;
            if (b38Var != null) {
                b38Var.e();
            }
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
            } else if (bundle != null) {
                this.h = bundle.getInt("tab_type");
                this.e = bundle.getString("tab_name");
                this.f = bundle.getString("tab_code");
                this.g = bundle.getString("tab_url");
            }
            this.a = this.g;
            b38 b38Var = new b38(this);
            this.q = b38Var;
            b38Var.a(bundle);
            i2();
            l2();
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
                View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d06e3, (ViewGroup) null);
                this.i = inflate;
                this.j = (TbWebView) inflate.findViewById(R.id.obfuscated_res_0x7f092924);
                this.k = (FrameLayout) this.i.findViewById(R.id.load_state_container);
                this.l = (ViewGroup) this.i.findViewById(R.id.obfuscated_res_0x7f092362);
                j2();
            }
            TbWebView tbWebView = this.j;
            if (tbWebView != null) {
                tbWebView.setVisibility(0);
            }
            this.j.l("webviewType", "tab");
            this.i.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return this.i;
        }
        return (View) invokeLLL.objValue;
    }
}
