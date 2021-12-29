package com.baidu.tieba.homepage.tabfeed.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.l;
import c.a.d.n.e.n;
import c.a.s0.s.i0.g;
import c.a.s0.s.q.c2;
import c.a.s0.s.q.d2;
import c.a.s0.s.q.l1;
import c.a.t0.d1.n1;
import c.a.t0.g0.v;
import c.a.t0.o1.j.e;
import c.a.t0.z2.k;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.PublishProgressView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import com.baidu.tieba.homepage.channel.model.ChannelTabNetFeedModel;
import com.baidu.tieba.homepage.tabfeed.HomePageTabFeedFragment;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class HomePageTabFeedView implements LifecycleObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public HomePageTabFeedFragment f46128e;

    /* renamed from: f  reason: collision with root package name */
    public e f46129f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f46130g;

    /* renamed from: h  reason: collision with root package name */
    public BdSwipeRefreshLayout f46131h;

    /* renamed from: i  reason: collision with root package name */
    public BdTypeRecyclerView f46132i;

    /* renamed from: j  reason: collision with root package name */
    public PbListView f46133j;

    /* renamed from: k  reason: collision with root package name */
    public g f46134k;
    public SmartBubbleAnimatedView l;
    public PublishProgressView m;
    public ViewGroup mTaskFloatingView;
    public HomePageTabFeedHeaderView n;
    public k o;
    public PostAnimateFloatView p;
    public c.a.t0.o1.j.b q;
    public String r;
    public boolean s;
    public int t;
    public BdListView.p u;
    public RecyclerView.OnScrollListener v;
    public View.OnClickListener w;

    /* loaded from: classes12.dex */
    public class a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedView f46135e;

        public a(HomePageTabFeedView homePageTabFeedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46135e = homePageTabFeedView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f46135e.f46132i != null) {
                    this.f46135e.f46132i.stopScroll();
                }
                this.f46135e.showLoadMoreView();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedView f46136b;

        public b(HomePageTabFeedView homePageTabFeedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46136b = homePageTabFeedView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) && i2 == 0) {
                if (this.f46136b.o != null) {
                    this.f46136b.o.n(this.f46136b.f46132i.getFirstVisiblePosition(), this.f46136b.f46132i.getLastVisiblePosition(), this.a, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(true ^ this.f46136b.isListAtTop())));
                v.b().c();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                if (i3 > 0) {
                    this.a = false;
                } else {
                    this.a = true;
                }
                this.f46136b.g();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedView f46137e;

        public c(HomePageTabFeedView homePageTabFeedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46137e = homePageTabFeedView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f46137e.f46132i != null) {
                    this.f46137e.f46132i.stopScroll();
                }
                if (this.f46137e.f46133j == null || this.f46137e.f46129f == null || !l.z()) {
                    return;
                }
                this.f46137e.f46133j.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.f46137e.f46133j.C(null);
                if (this.f46137e.s) {
                    this.f46137e.f46133j.O();
                    this.f46137e.f46129f.callLoadMore();
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomePageTabFeedView a;

        public d(HomePageTabFeedView homePageTabFeedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = homePageTabFeedView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || (view = viewHolder.itemView) == null || this.a.o == null) {
                return;
            }
            this.a.o.k(view);
        }
    }

    public HomePageTabFeedView(HomePageTabFeedFragment homePageTabFeedFragment, e eVar, ViewGroup viewGroup, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {homePageTabFeedFragment, eVar, viewGroup, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = true;
        this.t = 3;
        this.u = new a(this);
        this.v = new b(this);
        this.w = new c(this);
        this.f46128e = homePageTabFeedFragment;
        this.f46129f = eVar;
        this.r = str;
        h(viewGroup);
        c.a.t0.o1.j.b bVar = new c.a.t0.o1.j.b(homePageTabFeedFragment, this.f46132i);
        this.q = bVar;
        bVar.g(str);
        setIsRefresh(false);
    }

    public final void g() {
        PostAnimateFloatView postAnimateFloatView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && MainTabActivity.TAB_CODE_LOCAL.equals(this.r) && TbSingleton.getInstance().shouldShowLocalChannelPostAnim) {
            n item = this.f46132i.getItem(this.f46132i.getFirstVisiblePosition() - 1);
            if (item != null && item.getType() == d2.o3 && (postAnimateFloatView = this.p) != null && postAnimateFloatView.getVisibility() == 0) {
                this.p.animateShow();
                TbSingleton.getInstance().shouldShowLocalChannelPostAnim = false;
            }
        }
    }

    public PostAnimateFloatView getPostAnimateFloatView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.p : (PostAnimateFloatView) invokeV.objValue;
    }

    public BdTypeRecyclerView getRecycleView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f46132i : (BdTypeRecyclerView) invokeV.objValue;
    }

    public final void h(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, viewGroup) == null) {
            this.f46130g = viewGroup;
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
            this.f46132i = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f46128e.getContext()));
            this.f46132i.setFadingEdgeLength(0);
            this.f46132i.setOverScrollMode(2);
            this.f46132i.setOnSrollToBottomListener(this.u);
            this.f46132i.addOnScrollListener(this.v);
            g gVar = new g(this.f46128e.getPageContext());
            this.f46134k = gVar;
            gVar.a(this.f46129f);
            this.f46132i.setRecyclerListener(new d(this));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.f46132i.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            PbListView pbListView = new PbListView(this.f46128e.getPageContext().getPageActivity());
            this.f46133j = pbListView;
            pbListView.b();
            this.f46133j.p(R.color.transparent);
            this.f46133j.t(c.a.d.f.p.n.f(this.f46128e.getPageContext().getPageActivity(), R.dimen.tbds182));
            this.f46133j.y();
            this.f46133j.H(R.dimen.tbfontsize33);
            this.f46133j.F(SkinManager.getColor(R.color.CAM_X0107));
            this.f46133j.B(R.color.CAM_X0110);
            this.f46133j.s();
            this.f46133j.C(this.w);
            if (this.f46131h == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
                this.f46131h = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.f46134k);
            }
            new n1();
            SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(this.f46128e.getContext());
            this.l = smartBubbleAnimatedView;
            smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, c.a.d.f.p.n.f(this.f46128e.getContext(), R.dimen.tbds83)));
            if (this.o == null) {
                this.o = new k(this.f46128e.getPageContext(), this.f46132i);
                if (c.a.s0.b.d.o()) {
                    this.o.p(2);
                } else {
                    this.o.p(1);
                }
                this.o.u(this.f46128e.getUniqueId());
            }
            this.mTaskFloatingView = (ViewGroup) viewGroup.findViewById(R.id.task_float_view);
            this.p = (PostAnimateFloatView) viewGroup.findViewById(R.id.post_animate_float_view);
        }
    }

    public void insertFakeThreadData(d2 d2Var) {
        HomePageTabFeedFragment homePageTabFeedFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, d2Var) == null) || this.f46132i == null || (homePageTabFeedFragment = this.f46128e) == null || !(homePageTabFeedFragment.getNetModel() instanceof ChannelTabNetFeedModel) || ListUtils.isEmpty(this.f46132i.getData())) {
            return;
        }
        ArrayList<n> arrayList = (ArrayList) this.f46132i.getData();
        int i2 = 0;
        while (true) {
            if (i2 >= arrayList.size()) {
                i2 = -1;
                break;
            } else if (arrayList.get(i2) instanceof c2) {
                break;
            } else {
                i2++;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(d2Var);
        ArrayList<n> c2 = c.a.t0.o1.j.a.c(arrayList2);
        if (i2 != -1) {
            arrayList.addAll(i2, c2);
        } else {
            arrayList.addAll(c2);
        }
        List<d2> i3 = ((ChannelTabNetFeedModel) this.f46128e.getNetModel()).i();
        if (i3 != null) {
            i3.add(0, d2Var);
        }
        this.q.e(arrayList);
        this.q.d();
    }

    public boolean isListAtTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f46132i;
            return bdTypeRecyclerView == null || bdTypeRecyclerView.getChildCount() == 0 || this.f46132i.getChildAt(0).getTop() == 0;
        }
        return invokeV.booleanValue;
    }

    public void notifyLocalInfoCompleted() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (bdTypeRecyclerView = this.f46132i) == null || bdTypeRecyclerView.getCount() == 0) {
            return;
        }
        if (this.f46132i.getItem(0) instanceof c.a.t0.o1.j.h.a) {
            this.f46132i.removeItem(0);
        }
        c.a.t0.o1.j.b bVar = this.q;
        if (bVar != null) {
            bVar.f(false);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || this.t == i2) {
            return;
        }
        g gVar = this.f46134k;
        if (gVar != null) {
            gVar.C(i2);
        }
        PbListView pbListView = this.f46133j;
        if (pbListView != null) {
            pbListView.F(SkinManager.getColor(R.color.CAM_X0107));
            this.f46133j.d(i2);
        }
        HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.n;
        if (homePageTabFeedHeaderView != null) {
            homePageTabFeedHeaderView.onChangeSkinType(i2);
        }
        c.a.t0.o1.j.b bVar = this.q;
        if (bVar != null) {
            bVar.d();
        }
        SmartBubbleAnimatedView smartBubbleAnimatedView = this.l;
        if (smartBubbleAnimatedView != null) {
            smartBubbleAnimatedView.onChangeSkinType(i2);
        }
        PublishProgressView publishProgressView = this.m;
        if (publishProgressView != null) {
            publishProgressView.onChangeSkinType();
        }
        PostAnimateFloatView postAnimateFloatView = this.p;
        if (postAnimateFloatView != null) {
            postAnimateFloatView.onChangeSkinType(this.f46128e.getPageContext(), i2);
        }
        this.t = i2;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            k kVar = this.o;
            if (kVar != null) {
                kVar.h();
            }
            g gVar = this.f46134k;
            if (gVar != null) {
                gVar.a(null);
            }
            HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.n;
            if (homePageTabFeedHeaderView != null) {
                homePageTabFeedHeaderView.onDestroy();
            }
            PostAnimateFloatView postAnimateFloatView = this.p;
            if (postAnimateFloatView != null) {
                postAnimateFloatView.destroy();
            }
        }
    }

    public void onNetDataUpdate(c.a.t0.o1.j.h.d dVar) {
        PostAnimateFloatView postAnimateFloatView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, dVar) == null) {
            setIsRefresh(false);
            if (dVar == null || this.q == null || this.f46132i == null || this.f46133j == null) {
                return;
            }
            this.s = dVar.f21204c;
            if (dVar.f21206e == null && dVar.f21207f == null) {
                HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.n;
                if (homePageTabFeedHeaderView != null && homePageTabFeedHeaderView.getParent() != null) {
                    this.f46132i.removeHeaderView(this.n);
                    this.n = null;
                }
            } else {
                if (this.n == null) {
                    HomePageTabFeedHeaderView homePageTabFeedHeaderView2 = new HomePageTabFeedHeaderView(this.f46128e.getContext());
                    this.n = homePageTabFeedHeaderView2;
                    homePageTabFeedHeaderView2.setTabCode(this.r);
                    this.f46132i.addHeaderView(this.n);
                }
                this.n.setData(dVar);
            }
            if (dVar.f21203b > 0) {
                int firstVisiblePosition = this.f46132i.getFirstVisiblePosition();
                View childAt = this.f46132i.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.f46132i.getLayoutManager();
                int i2 = firstVisiblePosition - dVar.f21203b;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.f46132i.startInterceptLayout();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, top);
                    this.f46132i.stopIntercerceptLayout();
                }
            }
            this.q.e(dVar.a);
            this.q.d();
            k kVar = this.o;
            if (kVar != null) {
                kVar.n(this.f46132i.getFirstVisiblePosition(), this.f46132i.getLastVisiblePosition(), false, true);
            }
            if (!MainTabActivity.TAB_CODE_LOCAL.equals(this.r) || (postAnimateFloatView = this.p) == null) {
                return;
            }
            postAnimateFloatView.setVisibility(0);
        }
    }

    public void pause() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (kVar = this.o) == null) {
            return;
        }
        kVar.y();
        this.o.r(false);
    }

    public void removeListItems(int i2, int i3) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) || (bdTypeRecyclerView = this.f46132i) == null || i2 >= i3) {
            return;
        }
        bdTypeRecyclerView.removeItemList(i2, i3);
    }

    public void resetListPullRefreshListener() {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (gVar = this.f46134k) != null && gVar.F() == null) {
            this.f46134k.a(this.f46129f);
        }
    }

    public void resume() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (kVar = this.o) == null) {
            return;
        }
        kVar.r(true);
        BdTypeRecyclerView bdTypeRecyclerView = this.f46132i;
        if (bdTypeRecyclerView != null) {
            this.o.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.f46132i.getLastVisiblePosition(), false, true);
        }
    }

    public void setIsRefresh(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || (bdSwipeRefreshLayout = this.f46131h) == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(z);
    }

    public void setListContentVisible(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || (bdSwipeRefreshLayout = this.f46131h) == null) {
            return;
        }
        bdSwipeRefreshLayout.setVisibility(z ? 0 : 8);
    }

    public void showLoadMoreView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.f46133j == null || this.f46129f == null) {
            return;
        }
        if (l.z()) {
            this.f46132i.setNextPage(this.f46133j);
            this.f46133j.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f46133j.C(null);
            if (this.s) {
                this.f46133j.O();
                this.f46129f.callLoadMore();
                return;
            }
            this.f46133j.D(this.f46128e.getResources().getString(R.string.list_has_no_more));
            this.f46133j.f();
            return;
        }
        this.f46132i.setNextPage(null);
    }

    public void toListTop() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (bdTypeRecyclerView = this.f46132i) == null) {
            return;
        }
        bdTypeRecyclerView.scrollToPosition(0);
    }

    public void updatePublishProgress(l1 l1Var) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, l1Var) == null) || (viewGroup = this.f46130g) == null || viewGroup.getContext() == null) {
            return;
        }
        if (this.m == null) {
            this.m = new PublishProgressView(this.f46130g.getContext());
            this.f46130g.addView(this.m, new FrameLayout.LayoutParams(-1, c.a.d.f.p.n.f(this.f46130g.getContext(), R.dimen.tbds83)));
        }
        this.m.updateCurProgressData(l1Var);
    }
}
