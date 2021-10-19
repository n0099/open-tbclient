package com.baidu.tieba.homepage.tabfeed;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.e.l.e.n;
import c.a.q0.o0.d;
import c.a.q0.s.q.d2;
import c.a.r0.b0.e0.j;
import c.a.r0.b0.u;
import c.a.r0.h1.j.e;
import c.a.r0.h1.j.f;
import c.a.r0.h1.j.h.c;
import c.a.r0.x0.n0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.channel.model.ChannelTabNetFeedModel;
import com.baidu.tieba.homepage.tabfeed.model.TabFeedNetFeedModel;
import com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class HomePageTabFeedFragment extends BaseFragment implements e, n0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAB_CODE = "tab_code";
    public static final String TAB_NAME = "tab_name";
    public static final String TAB_TYPE = "tab_type";
    public static final int THREAD_NOT_FOUND = -1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f52441e;

    /* renamed from: f  reason: collision with root package name */
    public String f52442f;

    /* renamed from: g  reason: collision with root package name */
    public int f52443g;

    /* renamed from: h  reason: collision with root package name */
    public f f52444h;

    /* renamed from: i  reason: collision with root package name */
    public HomePageTabFeedView f52445i;

    /* renamed from: j  reason: collision with root package name */
    public ViewGroup f52446j;
    public CustomMessageListener k;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedFragment f52447a;

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
            this.f52447a = homePageTabFeedFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f52447a.f52444h == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || this.f52447a.f52444h.i() == null || ListUtils.getCount(this.f52447a.f52444h.i()) == 0) {
                return;
            }
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString("liveid");
                if (this.f52447a.f52445i == null || this.f52447a.f52445i.getRecycleView() == null || TextUtils.isEmpty(optString2)) {
                    return;
                }
                int i2 = 0;
                while (true) {
                    if (i2 >= this.f52447a.f52445i.getRecycleView().getCount()) {
                        break;
                    }
                    n item = this.f52447a.f52445i.getRecycleView().getItem(i2);
                    if (item instanceof j) {
                        j jVar = (j) item;
                        if (jVar.getThreadData() != null && jVar.getThreadData().l1() != null && optString2.equals(String.valueOf(jVar.getThreadData().l1().live_id))) {
                            optString = jVar.getThreadData().s1();
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
                if (i3 < this.f52447a.f52444h.i().size()) {
                    d2 d2Var = this.f52447a.f52444h.i().get(i3);
                    if (d2Var != null && optString.equals(d2Var.E)) {
                        this.f52447a.f52444h.i().remove(i3);
                        break;
                    }
                    i3++;
                } else {
                    break;
                }
            }
            if (this.f52447a.f52445i.getRecycleView() != null) {
                List<Integer> b2 = c.a.r0.h1.j.a.b(optString, this.f52447a.f52445i.getRecycleView());
                int intValue = b2.get(0).intValue();
                int intValue2 = b2.get(1).intValue();
                if (intValue == -1 || intValue2 == -1) {
                    return;
                }
                this.f52447a.f52445i.getRecycleView().removeItemList(intValue, intValue2);
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

    @Override // c.a.r0.h1.j.e
    public void callLoadMore() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (fVar = this.f52444h) == null) {
            return;
        }
        fVar.loadMore();
    }

    public void callRefresh(boolean z) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (fVar = this.f52444h) == null) {
            return;
        }
        if (this.f52445i != null && z) {
            if (fVar.d()) {
                this.f52445i.toListTop();
                this.f52445i.setIsRefresh(true);
            } else {
                hideNetRefreshView(this.f52446j);
                showLoadingView(this.f52446j);
            }
        }
        this.f52444h.refresh();
    }

    @Override // c.a.r0.x0.n0
    public void changeSkinType() {
        HomePageTabFeedView homePageTabFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (homePageTabFeedView = this.f52445i) == null) {
            return;
        }
        homePageTabFeedView.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public final int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? ((l.i(getContext()) - l.g(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2) : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.q0.o0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f52443g == 201) {
                return "a075";
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int getLayoutR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? R.layout.tab_feed_fragment : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public d getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            d pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.s = this.f52441e;
            }
            return pageStayDurationItem;
        }
        return (d) invokeV.objValue;
    }

    public String getTabName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f52441e : (String) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && isPrimary()) {
            StatisticItem statisticItem = new StatisticItem("c13749");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f52441e);
            statisticItem.param("obj_type", this.f52442f);
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            super.hideLoadingView(view);
            HomePageTabFeedView homePageTabFeedView = this.f52445i;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.setListContentVisible(true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view) == null) {
            super.hideNetRefreshView(view);
            HomePageTabFeedView homePageTabFeedView = this.f52445i;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.setListContentVisible(true);
            }
        }
    }

    public boolean isAtTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            HomePageTabFeedView homePageTabFeedView = this.f52445i;
            if (homePageTabFeedView != null) {
                return homePageTabFeedView.isListAtTop();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            super.onActivityCreated(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            super.onChangeSkinType(i2);
            HomePageTabFeedView homePageTabFeedView = this.f52445i;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.onChangeSkinType(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            super.onCreate(bundle);
            if (getArguments() != null) {
                bundle = getArguments();
            }
            if (bundle != null) {
                this.f52441e = bundle.getString("tab_name");
                this.f52442f = bundle.getString("tab_code");
                this.f52443g = bundle.getInt("tab_type");
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, layoutInflater, viewGroup, bundle)) == null) {
            ViewGroup viewGroup2 = this.f52446j;
            if (viewGroup2 != null && (viewGroup2.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.f52446j.getParent()).removeView(this.f52446j);
            }
            if (this.f52446j == null) {
                ViewGroup viewGroup3 = (ViewGroup) getLayoutInflater().inflate(getLayoutR(), (ViewGroup) null);
                this.f52446j = viewGroup3;
                this.f52445i = new HomePageTabFeedView(this, this, viewGroup3, this.f52442f);
                getLifecycle().addObserver(this.f52445i);
            }
            if (this.f52444h == null) {
                if (this.f52443g == 201) {
                    this.f52444h = new ChannelTabNetFeedModel(getPageContext(), this);
                } else {
                    this.f52444h = new TabFeedNetFeedModel(getPageContext(), this);
                }
                this.f52444h.o(this.f52442f, this.f52441e, this.f52443g);
            }
            this.f52444h.registerListener(getUniqueId());
            registerListener(this.k);
            return this.f52446j;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDestroy();
            u.b().e(false);
            f fVar = this.f52444h;
            if (fVar != null) {
                fVar.destory();
            }
            if (this.f52445i != null) {
                getLifecycle().removeObserver(this.f52445i);
            }
            MessageManager.getInstance().unRegisterListener(this.k);
            TbadkCoreApplication.getInst().getPersonalizeViewData().a();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onLazyLoad();
            if (c.a.e.e.p.j.z()) {
                showLoadingView(this.f52446j);
                f fVar = this.f52444h;
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
            showNetRefreshView(this.f52446j, null, true);
        }
    }

    @Override // c.a.q0.s.f0.f.g
    public void onListPullRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            callRefresh(false);
        }
    }

    @Override // c.a.r0.h1.j.e
    public void onNetCallback(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, cVar) == null) {
            hideLoadingView(this.f52446j);
            f fVar = this.f52444h;
            if (fVar != null && !fVar.d()) {
                showNoDataRefreshView(this.f52446j, false);
                return;
            }
            HomePageTabFeedView homePageTabFeedView = this.f52445i;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.onNetDataUpdate(cVar);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && c.a.e.e.p.j.z()) {
            hideNetRefreshView(this.f52446j);
            showLoadingView(this.f52446j);
            callRefresh(false);
        }
    }

    @Override // c.a.r0.x0.n0
    public void onPageOutEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    @Override // c.a.r0.x0.n0
    public void onPageStartIn() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onPause();
            HomePageTabFeedView homePageTabFeedView = this.f52445i;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.pause();
            }
            u.b().e(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                HomePageTabFeedView homePageTabFeedView = this.f52445i;
                if (homePageTabFeedView != null) {
                    homePageTabFeedView.resume();
                }
                h();
                return;
            }
            HomePageTabFeedView homePageTabFeedView2 = this.f52445i;
            if (homePageTabFeedView2 != null) {
                homePageTabFeedView2.pause();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (bundle != null) {
                bundle.putString("tab_name", this.f52441e);
                bundle.putString("tab_code", this.f52442f);
                bundle.putInt("tab_type", this.f52443g);
            }
        }
    }

    @Override // c.a.r0.h1.j.e
    public void onServerError(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, errorData) == null) {
            hideLoadingView(this.f52446j);
            if (errorData != null) {
                if (!StringUtils.isNull(errorData.error_msg)) {
                    showToast(errorData.error_msg);
                } else {
                    showToast(R.string.im_error_default);
                }
            }
            f fVar = this.f52444h;
            if (fVar != null && !fVar.d()) {
                showNetRefreshView(this.f52446j, errorData != null ? getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)) : null, true);
            }
            HomePageTabFeedView homePageTabFeedView = this.f52445i;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.setIsRefresh(false);
            }
        }
    }

    @Override // c.a.r0.x0.n0
    public void refreshPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            callRefresh(true);
        }
    }

    public void removeListItems(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048604, this, i2, i3) == null) {
            f fVar = this.f52444h;
            if (fVar != null && !fVar.d()) {
                showNoDataRefreshView(this.f52446j, false);
                return;
            }
            HomePageTabFeedView homePageTabFeedView = this.f52445i;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.removeListItems(i2, i3);
            }
        }
    }

    public void setVideoThreadId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, view) == null) {
            HomePageTabFeedView homePageTabFeedView = this.f52445i;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.setListContentVisible(false);
            }
            super.showLoadingView(view, false, g());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048607, this, view, str, z) == null) {
            HomePageTabFeedView homePageTabFeedView = this.f52445i;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.setListContentVisible(false);
            }
            super.showNetRefreshView(view, getString(R.string.refresh_view_title_text), str, null, z, getNetRefreshListener());
            setNetRefreshViewTopMargin(l.g(TbadkCoreApplication.getInst(), R.dimen.ds364));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNoDataRefreshView(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048608, this, view, z) == null) {
            HomePageTabFeedView homePageTabFeedView = this.f52445i;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.setListContentVisible(false);
            }
            super.showNoDataRefreshView(view, z);
            setNetRefreshViewTopMargin(l.g(TbadkCoreApplication.getInst(), R.dimen.ds364));
        }
    }
}
