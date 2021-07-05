package com.baidu.tieba.homepage.tabfeed;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.channel.model.ChannelTabNetFeedModel;
import com.baidu.tieba.homepage.tabfeed.model.TabFeedNetFeedModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.r0.k0.d;
import d.a.r0.r.q.b2;
import d.a.r0.z0.b0;
import d.a.s0.a0.e0.j;
import d.a.s0.a0.t;
import d.a.s0.e1.j.e;
import d.a.s0.e1.j.f;
import d.a.s0.e1.j.h.c;
import d.a.s0.u0.n0;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class HomePageTabFeedFragment extends BaseFragment implements e, n0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f16781e;

    /* renamed from: f  reason: collision with root package name */
    public String f16782f;

    /* renamed from: g  reason: collision with root package name */
    public int f16783g;

    /* renamed from: h  reason: collision with root package name */
    public f f16784h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.s0.e1.j.k.a f16785i;
    public ViewGroup j;
    public CustomMessageListener k;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedFragment f16786a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(HomePageTabFeedFragment homePageTabFeedFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16786a = homePageTabFeedFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f16786a.f16784h == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || this.f16786a.f16784h.j() == null || ListUtils.getCount(this.f16786a.f16784h.j()) == 0) {
                return;
            }
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
                if (this.f16786a.f16785i == null || this.f16786a.f16785i.f() == null || TextUtils.isEmpty(optString2)) {
                    return;
                }
                int i2 = 0;
                while (true) {
                    if (i2 >= this.f16786a.f16785i.f().getCount()) {
                        break;
                    }
                    n B = this.f16786a.f16785i.f().B(i2);
                    if (B instanceof j) {
                        j jVar = (j) B;
                        if (jVar.getThreadData() != null && jVar.getThreadData().g1() != null && optString2.equals(String.valueOf(jVar.getThreadData().g1().live_id))) {
                            optString = jVar.getThreadData().n1();
                            break;
                        }
                    }
                    i2++;
                }
                if (StringUtils.isNull(optString)) {
                    return;
                }
            }
            int i3 = 0;
            while (true) {
                if (i3 < this.f16786a.f16784h.j().size()) {
                    b2 b2Var = this.f16786a.f16784h.j().get(i3);
                    if (b2Var != null && optString.equals(b2Var.A)) {
                        this.f16786a.f16784h.j().remove(i3);
                        break;
                    }
                    i3++;
                } else {
                    break;
                }
            }
            if (this.f16786a.f16785i.f() != null) {
                List<Integer> b2 = d.a.s0.e1.j.a.b(optString, this.f16786a.f16785i.f());
                int intValue = b2.get(0).intValue();
                int intValue2 = b2.get(1).intValue();
                if (intValue == -1 || intValue2 == -1) {
                    return;
                }
                this.f16786a.f16785i.f().E(intValue, intValue2);
            }
        }
    }

    public HomePageTabFeedFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = new a(this, 2016488);
    }

    @Override // d.a.s0.u0.n0
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // d.a.s0.u0.n0
    public void G() {
        d.a.s0.e1.j.k.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f16785i) == null) {
            return;
        }
        aVar.i(TbadkCoreApplication.getInst().getSkinType());
    }

    public void I0(boolean z) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (fVar = this.f16784h) == null) {
            return;
        }
        if (this.f16785i != null && z) {
            if (fVar.d()) {
                this.f16785i.q();
                this.f16785i.n(true);
            } else {
                hideNetRefreshView(this.j);
                showLoadingView(this.j);
            }
        }
        this.f16784h.refresh();
    }

    public int J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.tab_feed_fragment : invokeV.intValue;
    }

    public final int K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? ((l.i(getContext()) - l.g(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2) : invokeV.intValue;
    }

    public String L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f16781e : (String) invokeV.objValue;
    }

    @Override // d.a.s0.e1.j.e
    public void M(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            hideLoadingView(this.j);
            f fVar = this.f16784h;
            if (fVar != null && !fVar.d()) {
                showNoDataRefreshView(this.j, false);
                return;
            }
            d.a.s0.e1.j.k.a aVar = this.f16785i;
            if (aVar != null) {
                aVar.k(cVar);
            }
        }
    }

    public final void M0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && isPrimary()) {
            StatisticItem statisticItem = new StatisticItem("c13749");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f16781e);
            statisticItem.param("obj_type", this.f16782f);
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.r0.k0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f16783g == 201) {
                return "a075";
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public d getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            d pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.q = this.f16781e;
            }
            return pageStayDurationItem;
        }
        return (d) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view) == null) {
            super.hideLoadingView(view);
            d.a.s0.e1.j.k.a aVar = this.f16785i;
            if (aVar != null) {
                aVar.o(true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view) == null) {
            super.hideNetRefreshView(view);
            d.a.s0.e1.j.k.a aVar = this.f16785i;
            if (aVar != null) {
                aVar.o(true);
            }
        }
    }

    @Override // d.a.s0.e1.j.e
    public void j() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (fVar = this.f16784h) == null) {
            return;
        }
        fVar.loadMore();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onActivityCreated(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            super.onChangeSkinType(i2);
            d.a.s0.e1.j.k.a aVar = this.f16785i;
            if (aVar != null) {
                aVar.i(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
            super.onCreate(bundle);
            if (getArguments() != null) {
                bundle = getArguments();
            }
            if (bundle != null) {
                this.f16781e = bundle.getString("tab_name");
                this.f16782f = bundle.getString(LowFlowsActivityConfig.TAB_CODE);
                this.f16783g = bundle.getInt("tab_type");
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048592, this, layoutInflater, viewGroup, bundle)) == null) {
            ViewGroup viewGroup2 = this.j;
            if (viewGroup2 != null && (viewGroup2.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.j.getParent()).removeView(this.j);
            }
            if (this.j == null) {
                ViewGroup viewGroup3 = (ViewGroup) getLayoutInflater().inflate(J0(), (ViewGroup) null);
                this.j = viewGroup3;
                this.f16785i = new d.a.s0.e1.j.k.a(this, this, viewGroup3, this.f16782f);
            }
            if (this.f16784h == null) {
                if (this.f16783g == 201) {
                    this.f16784h = new ChannelTabNetFeedModel(getPageContext(), this);
                } else {
                    this.f16784h = new TabFeedNetFeedModel(getPageContext(), this);
                }
                this.f16784h.o(this.f16782f, this.f16781e, this.f16783g);
            }
            this.f16784h.e(getUniqueId());
            registerListener(this.k);
            return this.j;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onDestroy();
            t.b().e(false);
            f fVar = this.f16784h;
            if (fVar != null) {
                fVar.destory();
            }
            d.a.s0.e1.j.k.a aVar = this.f16785i;
            if (aVar != null) {
                aVar.j();
            }
            MessageManager.getInstance().unRegisterListener(this.k);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onLazyLoad();
            if (d.a.c.e.p.j.z()) {
                showLoadingView(this.j);
                f fVar = this.f16784h;
                if (fVar != null) {
                    try {
                        fVar.refresh();
                        return;
                    } catch (Exception unused) {
                        return;
                    }
                }
                return;
            }
            showNetRefreshView(this.j, null, true);
        }
    }

    @Override // d.a.r0.r.f0.f.g
    public void onListPullRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            I0(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && d.a.c.e.p.j.z()) {
            hideNetRefreshView(this.j);
            showLoadingView(this.j);
            I0(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onPause();
            d.a.s0.e1.j.k.a aVar = this.f16785i;
            if (aVar != null) {
                aVar.l();
            }
            t.b().e(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                d.a.s0.e1.j.k.a aVar = this.f16785i;
                if (aVar != null) {
                    aVar.m();
                }
                M0();
                return;
            }
            d.a.s0.e1.j.k.a aVar2 = this.f16785i;
            if (aVar2 != null) {
                aVar2.l();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (bundle != null) {
                bundle.putString("tab_name", this.f16781e);
                bundle.putString(LowFlowsActivityConfig.TAB_CODE, this.f16782f);
                bundle.putInt("tab_type", this.f16783g);
            }
        }
    }

    @Override // d.a.s0.e1.j.e
    public void onServerError(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, errorData) == null) {
            hideLoadingView(this.j);
            if (errorData != null) {
                if (!StringUtils.isNull(errorData.error_msg)) {
                    showToast(errorData.error_msg);
                } else {
                    showToast(R.string.im_error_default);
                }
            }
            f fVar = this.f16784h;
            if (fVar != null && !fVar.d()) {
                showNetRefreshView(this.j, errorData != null ? getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)) : null, true);
            }
            d.a.s0.e1.j.k.a aVar = this.f16785i;
            if (aVar != null) {
                aVar.n(false);
            }
        }
    }

    @Override // d.a.s0.u0.n0
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            I0(true);
        }
    }

    @Override // d.a.s0.u0.n0
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, view) == null) {
            d.a.s0.e1.j.k.a aVar = this.f16785i;
            if (aVar != null) {
                aVar.o(false);
            }
            super.showLoadingView(view, false, K0());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048604, this, view, str, z) == null) {
            d.a.s0.e1.j.k.a aVar = this.f16785i;
            if (aVar != null) {
                aVar.o(false);
            }
            super.showNetRefreshView(view, getString(R.string.refresh_view_title_text), str, null, z, getNetRefreshListener());
            setNetRefreshViewTopMargin(l.g(TbadkCoreApplication.getInst(), R.dimen.ds364));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNoDataRefreshView(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048605, this, view, z) == null) {
            d.a.s0.e1.j.k.a aVar = this.f16785i;
            if (aVar != null) {
                aVar.o(false);
            }
            super.showNoDataRefreshView(view, z);
            setNetRefreshViewTopMargin(l.g(TbadkCoreApplication.getInst(), R.dimen.ds364));
        }
    }

    @Override // d.a.s0.u0.n0
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
        }
    }

    @Override // d.a.s0.u0.n0
    public void x(b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, b0Var) == null) {
        }
    }
}
