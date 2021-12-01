package com.baidu.tieba.homepage.tabfeed;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.m.e.n;
import c.a.q0.s.q.d2;
import c.a.r0.d1.o0;
import c.a.r0.g0.f0.j;
import c.a.r0.g0.v;
import c.a.r0.n1.j.e;
import c.a.r0.n1.j.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.channel.model.ChannelTabNetFeedModel;
import com.baidu.tieba.homepage.tabfeed.model.TabFeedNetFeedModel;
import com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedView;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class HomePageTabFeedFragment extends BaseFragment implements e, o0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAB_CODE = "tab_code";
    public static final String TAB_NAME = "tab_name";
    public static final String TAB_TYPE = "tab_type";
    public static final int THREAD_NOT_FOUND = -1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f45384e;

    /* renamed from: f  reason: collision with root package name */
    public String f45385f;

    /* renamed from: g  reason: collision with root package name */
    public int f45386g;

    /* renamed from: h  reason: collision with root package name */
    public f f45387h;

    /* renamed from: i  reason: collision with root package name */
    public HomePageTabFeedView f45388i;

    /* renamed from: j  reason: collision with root package name */
    public ViewGroup f45389j;

    /* renamed from: k  reason: collision with root package name */
    public HttpMessageListener f45390k;
    public CustomMessageListener l;
    public boolean m;
    public CustomMessageListener n;

    /* loaded from: classes10.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomePageTabFeedFragment a;

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
            this.a = homePageTabFeedFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && (httpResponsedMessage.getmOrginalMessage() instanceof MercatorModel.MercatorRequestHttpMessage) && ((MercatorModel.MercatorRequestHttpMessage) httpResponsedMessage.getmOrginalMessage()).isFromHomePageTabFeedFragment()) {
                this.a.callRefresh(false);
                TbSingleton.getInstance().setMercatorRequestFromHomePageTabFeedFragment(false);
                this.a.m = false;
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomePageTabFeedFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(HomePageTabFeedFragment homePageTabFeedFragment, int i2) {
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
            this.a = homePageTabFeedFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.a.m = true;
                HomePageTabFeedFragment homePageTabFeedFragment = this.a;
                homePageTabFeedFragment.hideLoadingView(homePageTabFeedFragment.f45389j);
                HomePageTabFeedFragment homePageTabFeedFragment2 = this.a;
                homePageTabFeedFragment2.showNoDataRefreshView(homePageTabFeedFragment2.f45389j, false);
                TbSingleton.getInstance().setMercatorRequestFromHomePageTabFeedFragment(false);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomePageTabFeedFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(HomePageTabFeedFragment homePageTabFeedFragment, int i2) {
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
            this.a = homePageTabFeedFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.f45387h == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || this.a.f45387h.i() == null || ListUtils.getCount(this.a.f45387h.i()) == 0) {
                return;
            }
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString("liveid");
                if (this.a.f45388i == null || this.a.f45388i.getRecycleView() == null || TextUtils.isEmpty(optString2)) {
                    return;
                }
                int i2 = 0;
                while (true) {
                    if (i2 >= this.a.f45388i.getRecycleView().getCount()) {
                        break;
                    }
                    n item = this.a.f45388i.getRecycleView().getItem(i2);
                    if (item instanceof j) {
                        j jVar = (j) item;
                        if (jVar.getThreadData() != null && jVar.getThreadData().o1() != null && optString2.equals(String.valueOf(jVar.getThreadData().o1().live_id))) {
                            optString = jVar.getThreadData().v1();
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
                if (i3 < this.a.f45387h.i().size()) {
                    d2 d2Var = this.a.f45387h.i().get(i3);
                    if (d2Var != null && optString.equals(d2Var.E)) {
                        this.a.f45387h.i().remove(i3);
                        break;
                    }
                    i3++;
                } else {
                    break;
                }
            }
            if (this.a.f45388i.getRecycleView() != null) {
                List<Integer> d2 = c.a.r0.n1.j.a.d(optString, this.a.f45388i.getRecycleView());
                int intValue = d2.get(0).intValue();
                int intValue2 = d2.get(1).intValue();
                if (intValue == -1 || intValue2 == -1) {
                    return;
                }
                this.a.f45388i.getRecycleView().removeItemList(intValue, intValue2);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f45391e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedFragment f45392f;

        /* loaded from: classes10.dex */
        public class a implements PermissionJudgePolicy.OnPermissionsGrantedListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
            public void onPermissionsGranted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    TbSingleton.getInstance().setMercatorRequestFromHomePageTabFeedFragment(true);
                    MercatorModel.d().f();
                    c.a.q0.s.e0.b j2 = c.a.q0.s.e0.b.j();
                    j2.t("key_home_common_tab_fragment_has_request_location_" + this.a.f45392f.f45385f, true);
                    this.a.f45392f.mLocationView.dettachView(this.a.f45392f.f45389j);
                    HomePageTabFeedFragment homePageTabFeedFragment = this.a.f45392f;
                    homePageTabFeedFragment.showLoadingView(homePageTabFeedFragment.f45389j);
                    if (this.a.f45392f.f45388i != null) {
                        this.a.f45392f.f45388i.setListContentVisible(true);
                    }
                }
            }
        }

        public d(HomePageTabFeedFragment homePageTabFeedFragment, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedFragment, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45392f = homePageTabFeedFragment;
            this.f45391e = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.r0.n1.j.c.e();
                PermissionUtil.requestLocation(this.f45391e, 0, new a(this));
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
        this.m = true;
        this.n = new c(this, 2016488);
    }

    @Override // c.a.r0.n1.j.e
    public void callLoadMore() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (fVar = this.f45387h) == null) {
            return;
        }
        fVar.loadMore();
    }

    public void callRefresh(boolean z) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || n() || l() || (fVar = this.f45387h) == null) {
            return;
        }
        if (this.f45388i != null && z) {
            if (fVar.a()) {
                this.f45388i.toListTop();
                this.f45388i.setIsRefresh(true);
            } else {
                hideNetRefreshView(this.f45389j);
                showLoadingView(this.f45389j);
            }
        }
        this.f45387h.refresh();
    }

    @Override // c.a.r0.d1.o0
    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            HomePageTabFeedView homePageTabFeedView = this.f45388i;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.q0.p0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f45386g == 201) {
                return "a075";
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int getLayoutR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? R.layout.tab_feed_fragment : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public c.a.q0.p0.d getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.a.q0.p0.d pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.s = this.f45384e;
            }
            return pageStayDurationItem;
        }
        return (c.a.q0.p0.d) invokeV.objValue;
    }

    public String getTabCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f45385f : (String) invokeV.objValue;
    }

    public String getTabName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f45384e : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            super.hideLoadingView(view);
            HomePageTabFeedView homePageTabFeedView = this.f45388i;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.setListContentVisible(true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            super.hideNetRefreshView(view);
            HomePageTabFeedView homePageTabFeedView = this.f45388i;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.setListContentVisible(true);
            }
        }
    }

    public boolean isAtTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            HomePageTabFeedView homePageTabFeedView = this.f45388i;
            if (homePageTabFeedView != null) {
                return homePageTabFeedView.isListAtTop();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? ((l.i(getContext()) - l.f(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2) : invokeV.intValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (MainTabActivity.TAB_CODE_LOCAL.equals(this.f45385f) && this.f45390k == null) {
                a aVar = new a(this, CmdConfigHttp.CMD_GET_MERCATOR);
                this.f45390k = aVar;
                registerListener(aVar);
            }
            if (MainTabActivity.TAB_CODE_LOCAL.equals(this.f45385f) && this.l == null) {
                b bVar = new b(this, 2921649);
                this.l = bVar;
                registerListener(bVar);
            }
        }
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (MainTabActivity.TAB_CODE_LOCAL.equals(this.f45385f) && this.m && PermissionUtil.checkLocationForTieba(getPageContext().getPageActivity())) {
                if (isNetRefreshViewAttached()) {
                    hideNetRefreshView(this.f45389j);
                }
                showLoadingView(this.f45389j);
                TbSingleton.getInstance().setMercatorRequestFromHomePageTabFeedFragment(true);
                MercatorModel.d().f();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (MainTabActivity.TAB_CODE_LOCAL.equals(this.f45385f)) {
                Activity pageActivity = getPageContext().getPageActivity();
                c.a.q0.s.e0.b j2 = c.a.q0.s.e0.b.j();
                boolean g2 = j2.g("key_home_common_tab_fragment_has_request_location_" + this.f45385f, false);
                if (PermissionUtil.checkLocationForTieba(pageActivity) && g2) {
                    return false;
                }
                HomePageTabFeedView homePageTabFeedView = this.f45388i;
                if (homePageTabFeedView != null) {
                    homePageTabFeedView.setListContentVisible(false);
                }
                if (isNetRefreshViewAttached()) {
                    hideNetRefreshView(this.f45389j);
                }
                c.a.r0.n1.j.c.g();
                showLocationView(this.f45389j, new d(this, pageActivity));
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && isPrimary()) {
            StatisticItem statisticItem = new StatisticItem("c13749");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f45384e);
            statisticItem.param("obj_type", this.f45385f);
            TiebaStatic.log(statisticItem);
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
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            super.onChangeSkinType(i2);
            HomePageTabFeedView homePageTabFeedView = this.f45388i;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.onChangeSkinType(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bundle) == null) {
            super.onCreate(bundle);
            if (getArguments() != null) {
                bundle = getArguments();
            }
            if (bundle != null) {
                this.f45384e = bundle.getString("tab_name");
                this.f45385f = bundle.getString("tab_code");
                this.f45386g = bundle.getInt("tab_type");
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048595, this, layoutInflater, viewGroup, bundle)) == null) {
            ViewGroup viewGroup2 = this.f45389j;
            if (viewGroup2 != null && (viewGroup2.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.f45389j.getParent()).removeView(this.f45389j);
            }
            if (this.f45389j == null) {
                ViewGroup viewGroup3 = (ViewGroup) getLayoutInflater().inflate(getLayoutR(), (ViewGroup) null);
                this.f45389j = viewGroup3;
                this.f45388i = new HomePageTabFeedView(this, this, viewGroup3, this.f45385f);
                getLifecycle().addObserver(this.f45388i);
            }
            HomePageTabFeedView homePageTabFeedView = this.f45388i;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.resetListPullRefreshListener();
            }
            if (this.f45387h == null) {
                if (this.f45386g == 201) {
                    this.f45387h = new ChannelTabNetFeedModel(getPageContext(), this);
                } else {
                    this.f45387h = new TabFeedNetFeedModel(getPageContext(), this);
                }
                this.f45387h.o(this.f45385f, this.f45384e, this.f45386g);
            }
            this.f45387h.registerListener(getUniqueId());
            registerListener(this.n);
            k();
            return this.f45389j;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onDestroy();
            v.b().e(false);
            f fVar = this.f45387h;
            if (fVar != null) {
                fVar.destory();
            }
            if (this.f45388i != null) {
                getLifecycle().removeObserver(this.f45388i);
            }
            MessageManager.getInstance().unRegisterListener(this.n);
            TbadkCoreApplication.getInst().getPersonalizeViewData().a();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onLazyLoad();
            if (c.a.d.f.p.j.z()) {
                if (n() || l()) {
                    return;
                }
                showLoadingView(this.f45389j);
                f fVar = this.f45387h;
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
            showNetRefreshView(this.f45389j, null, true);
        }
    }

    @Override // c.a.q0.s.g0.f.g
    public void onListPullRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            callRefresh(false);
        }
    }

    @Override // c.a.r0.n1.j.e
    public void onNetCallback(c.a.r0.n1.j.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, cVar) == null) {
            hideLoadingView(this.f45389j);
            f fVar = this.f45387h;
            if (fVar != null && !fVar.a()) {
                showNoDataRefreshView(this.f45389j, false);
                return;
            }
            HomePageTabFeedView homePageTabFeedView = this.f45388i;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.onNetDataUpdate(cVar);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && c.a.d.f.p.j.z()) {
            hideNetRefreshView(this.f45389j);
            showLoadingView(this.f45389j);
            callRefresh(false);
        }
    }

    @Override // c.a.r0.d1.o0
    public void onPageOutEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
        }
    }

    @Override // c.a.r0.d1.o0
    public void onPageStartIn() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onPause();
            HomePageTabFeedView homePageTabFeedView = this.f45388i;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.pause();
            }
            v.b().e(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                HomePageTabFeedView homePageTabFeedView = this.f45388i;
                if (homePageTabFeedView != null) {
                    homePageTabFeedView.resume();
                }
                o();
                return;
            }
            HomePageTabFeedView homePageTabFeedView2 = this.f45388i;
            if (homePageTabFeedView2 != null) {
                homePageTabFeedView2.pause();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (bundle != null) {
                bundle.putString("tab_name", this.f45384e);
                bundle.putString("tab_code", this.f45385f);
                bundle.putInt("tab_type", this.f45386g);
            }
        }
    }

    @Override // c.a.r0.n1.j.e
    public void onServerError(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, errorData) == null) {
            hideLoadingView(this.f45389j);
            if (errorData != null) {
                if (!StringUtils.isNull(errorData.error_msg)) {
                    showToast(errorData.error_msg);
                } else {
                    showToast(R.string.im_error_default);
                }
            }
            f fVar = this.f45387h;
            if (fVar != null && !fVar.a()) {
                showNetRefreshView(this.f45389j, errorData != null ? getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)) : null, true);
            }
            HomePageTabFeedView homePageTabFeedView = this.f45388i;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.setIsRefresh(false);
            }
        }
    }

    @Override // c.a.r0.d1.o0
    public void refreshPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            callRefresh(true);
        }
    }

    public void removeListItems(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048608, this, i2, i3) == null) {
            f fVar = this.f45387h;
            if (fVar != null && !fVar.a()) {
                showNoDataRefreshView(this.f45389j, false);
                return;
            }
            HomePageTabFeedView homePageTabFeedView = this.f45388i;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.removeListItems(i2, i3);
            }
        }
    }

    public void setVideoThreadId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, view) == null) {
            HomePageTabFeedView homePageTabFeedView = this.f45388i;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.setListContentVisible(false);
            }
            super.showLoadingView(view, false, j());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048611, this, view, str, z) == null) {
            HomePageTabFeedView homePageTabFeedView = this.f45388i;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.setListContentVisible(false);
            }
            super.showNetRefreshView(view, getString(R.string.refresh_view_title_text), str, null, z, getNetRefreshListener());
            setNetRefreshViewTopMargin(l.f(TbadkCoreApplication.getInst(), R.dimen.ds364));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNoDataRefreshView(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048612, this, view, z) == null) {
            HomePageTabFeedView homePageTabFeedView = this.f45388i;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.setListContentVisible(false);
            }
            super.showNoDataRefreshView(view, z);
            setNetRefreshViewTopMargin(l.f(TbadkCoreApplication.getInst(), R.dimen.ds364));
        }
    }
}
