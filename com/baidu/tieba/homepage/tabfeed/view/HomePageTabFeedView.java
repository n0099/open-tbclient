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
import c.a.d.f.p.k;
import c.a.d.f.p.m;
import c.a.r0.s.i0.g;
import c.a.s0.d1.n1;
import c.a.s0.g0.v;
import c.a.s0.o1.j.e;
import c.a.s0.z2.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import com.baidu.tieba.homepage.tabfeed.HomePageTabFeedFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class HomePageTabFeedView implements LifecycleObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public HomePageTabFeedFragment f45930e;

    /* renamed from: f  reason: collision with root package name */
    public e f45931f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f45932g;

    /* renamed from: h  reason: collision with root package name */
    public BdSwipeRefreshLayout f45933h;

    /* renamed from: i  reason: collision with root package name */
    public BdTypeRecyclerView f45934i;

    /* renamed from: j  reason: collision with root package name */
    public PbListView f45935j;

    /* renamed from: k  reason: collision with root package name */
    public g f45936k;
    public SmartBubbleAnimatedView l;
    public HomePageTabFeedHeaderView m;
    public ViewGroup mTaskFloatingView;
    public i n;
    public c.a.s0.o1.j.b o;
    public String p;
    public boolean q;
    public int r;
    public BdListView.p s;
    public RecyclerView.OnScrollListener t;
    public View.OnClickListener u;

    /* loaded from: classes12.dex */
    public class a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedView f45937e;

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
            this.f45937e = homePageTabFeedView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f45937e.f45934i != null) {
                    this.f45937e.f45934i.stopScroll();
                }
                this.f45937e.showLoadMoreView();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedView f45938b;

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
            this.f45938b = homePageTabFeedView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) && i2 == 0) {
                if (this.f45938b.n != null) {
                    this.f45938b.n.n(this.f45938b.f45934i.getFirstVisiblePosition(), this.f45938b.f45934i.getLastVisiblePosition(), this.a, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(true ^ this.f45938b.isListAtTop())));
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
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedView f45939e;

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
            this.f45939e = homePageTabFeedView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f45939e.f45934i != null) {
                    this.f45939e.f45934i.stopScroll();
                }
                if (this.f45939e.f45935j == null || this.f45939e.f45931f == null || !k.z()) {
                    return;
                }
                this.f45939e.f45935j.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.f45939e.f45935j.C(null);
                if (this.f45939e.q) {
                    this.f45939e.f45935j.O();
                    this.f45939e.f45931f.callLoadMore();
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || (view = viewHolder.itemView) == null || this.a.n == null) {
                return;
            }
            this.a.n.k(view);
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
        this.q = true;
        this.r = 3;
        this.s = new a(this);
        this.t = new b(this);
        this.u = new c(this);
        this.f45930e = homePageTabFeedFragment;
        this.f45931f = eVar;
        this.p = str;
        f(viewGroup);
        c.a.s0.o1.j.b bVar = new c.a.s0.o1.j.b(homePageTabFeedFragment, this.f45934i);
        this.o = bVar;
        bVar.g(str);
        setIsRefresh(false);
    }

    public final void f(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
            this.f45932g = viewGroup;
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
            this.f45934i = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f45930e.getContext()));
            this.f45934i.setFadingEdgeLength(0);
            this.f45934i.setOverScrollMode(2);
            this.f45934i.setOnSrollToBottomListener(this.s);
            this.f45934i.addOnScrollListener(this.t);
            g gVar = new g(this.f45930e.getPageContext());
            this.f45936k = gVar;
            gVar.a(this.f45931f);
            this.f45934i.setRecyclerListener(new d(this));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.f45934i.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            PbListView pbListView = new PbListView(this.f45930e.getPageContext().getPageActivity());
            this.f45935j = pbListView;
            pbListView.b();
            this.f45935j.p(R.color.transparent);
            this.f45935j.t(m.f(this.f45930e.getPageContext().getPageActivity(), R.dimen.tbds182));
            this.f45935j.y();
            this.f45935j.H(R.dimen.tbfontsize33);
            this.f45935j.F(SkinManager.getColor(R.color.CAM_X0107));
            this.f45935j.B(R.color.CAM_X0110);
            this.f45935j.s();
            this.f45935j.C(this.u);
            if (this.f45933h == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
                this.f45933h = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.f45936k);
            }
            new n1();
            SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(this.f45930e.getContext());
            this.l = smartBubbleAnimatedView;
            smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, m.f(this.f45930e.getContext(), R.dimen.tbds83)));
            if (this.n == null) {
                i iVar = new i(this.f45930e.getPageContext(), this.f45934i);
                this.n = iVar;
                iVar.p(2);
                this.n.u(this.f45930e.getUniqueId());
            }
            this.mTaskFloatingView = (ViewGroup) viewGroup.findViewById(R.id.task_float_view);
        }
    }

    public BdTypeRecyclerView getRecycleView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f45934i : (BdTypeRecyclerView) invokeV.objValue;
    }

    public boolean isListAtTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f45934i;
            return bdTypeRecyclerView == null || bdTypeRecyclerView.getChildCount() == 0 || this.f45934i.getChildAt(0).getTop() == 0;
        }
        return invokeV.booleanValue;
    }

    public void notifyLocalInfoCompleted() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bdTypeRecyclerView = this.f45934i) == null || bdTypeRecyclerView.getCount() == 0) {
            return;
        }
        if (this.f45934i.getItem(0) instanceof c.a.s0.o1.j.h.a) {
            this.f45934i.removeItem(0);
        }
        c.a.s0.o1.j.b bVar = this.o;
        if (bVar != null) {
            bVar.f(false);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || this.r == i2) {
            return;
        }
        g gVar = this.f45936k;
        if (gVar != null) {
            gVar.C(i2);
        }
        PbListView pbListView = this.f45935j;
        if (pbListView != null) {
            pbListView.F(SkinManager.getColor(R.color.CAM_X0107));
            this.f45935j.d(i2);
        }
        HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.m;
        if (homePageTabFeedHeaderView != null) {
            homePageTabFeedHeaderView.onChangeSkinType(i2);
        }
        c.a.s0.o1.j.b bVar = this.o;
        if (bVar != null) {
            bVar.d();
        }
        SmartBubbleAnimatedView smartBubbleAnimatedView = this.l;
        if (smartBubbleAnimatedView != null) {
            smartBubbleAnimatedView.onChangeSkinType(i2);
        }
        this.r = i2;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            i iVar = this.n;
            if (iVar != null) {
                iVar.h();
            }
            g gVar = this.f45936k;
            if (gVar != null) {
                gVar.a(null);
            }
            HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.m;
            if (homePageTabFeedHeaderView != null) {
                homePageTabFeedHeaderView.onDestroy();
            }
        }
    }

    public void onNetDataUpdate(c.a.s0.o1.j.h.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            setIsRefresh(false);
            if (dVar == null || this.o == null || this.f45934i == null || this.f45935j == null) {
                return;
            }
            this.q = dVar.f21163c;
            if (dVar.f21165e == null && dVar.f21166f == null) {
                HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.m;
                if (homePageTabFeedHeaderView != null && homePageTabFeedHeaderView.getParent() != null) {
                    this.f45934i.removeHeaderView(this.m);
                    this.m = null;
                }
            } else {
                if (this.m == null) {
                    HomePageTabFeedHeaderView homePageTabFeedHeaderView2 = new HomePageTabFeedHeaderView(this.f45930e.getContext());
                    this.m = homePageTabFeedHeaderView2;
                    homePageTabFeedHeaderView2.setTabCode(this.p);
                    this.f45934i.addHeaderView(this.m);
                }
                this.m.setData(dVar);
            }
            if (dVar.f21162b > 0) {
                int firstVisiblePosition = this.f45934i.getFirstVisiblePosition();
                View childAt = this.f45934i.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.f45934i.getLayoutManager();
                int i2 = firstVisiblePosition - dVar.f21162b;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.f45934i.startInterceptLayout();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, top);
                    this.f45934i.stopIntercerceptLayout();
                }
            }
            this.o.e(dVar.a);
            this.o.d();
            i iVar = this.n;
            if (iVar != null) {
                iVar.n(this.f45934i.getFirstVisiblePosition(), this.f45934i.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (iVar = this.n) == null) {
            return;
        }
        iVar.y();
        this.n.r(false);
    }

    public void removeListItems(int i2, int i3) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) || (bdTypeRecyclerView = this.f45934i) == null || i2 >= i3) {
            return;
        }
        bdTypeRecyclerView.removeItemList(i2, i3);
    }

    public void resetListPullRefreshListener() {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (gVar = this.f45936k) != null && gVar.F() == null) {
            this.f45936k.a(this.f45931f);
        }
    }

    public void resume() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (iVar = this.n) == null) {
            return;
        }
        iVar.r(true);
        BdTypeRecyclerView bdTypeRecyclerView = this.f45934i;
        if (bdTypeRecyclerView != null) {
            this.n.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.f45934i.getLastVisiblePosition(), false, true);
        }
    }

    public void setIsRefresh(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || (bdSwipeRefreshLayout = this.f45933h) == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(z);
    }

    public void setListContentVisible(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (bdSwipeRefreshLayout = this.f45933h) == null) {
            return;
        }
        bdSwipeRefreshLayout.setVisibility(z ? 0 : 8);
    }

    public void showLoadMoreView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.f45935j == null || this.f45931f == null) {
            return;
        }
        if (k.z()) {
            this.f45934i.setNextPage(this.f45935j);
            this.f45935j.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f45935j.C(null);
            if (this.q) {
                this.f45935j.O();
                this.f45931f.callLoadMore();
                return;
            }
            this.f45935j.D(this.f45930e.getResources().getString(R.string.list_has_no_more));
            this.f45935j.f();
            return;
        }
        this.f45934i.setNextPage(null);
    }

    public void toListTop() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (bdTypeRecyclerView = this.f45934i) == null) {
            return;
        }
        bdTypeRecyclerView.scrollToPosition(0);
    }
}
