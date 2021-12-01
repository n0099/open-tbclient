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
import c.a.d.f.p.j;
import c.a.d.f.p.l;
import c.a.q0.s.g0.g;
import c.a.r0.d1.n1;
import c.a.r0.g0.v;
import c.a.r0.n1.j.e;
import c.a.r0.x2.i;
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
/* loaded from: classes10.dex */
public class HomePageTabFeedView implements LifecycleObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public HomePageTabFeedFragment f45438e;

    /* renamed from: f  reason: collision with root package name */
    public e f45439f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f45440g;

    /* renamed from: h  reason: collision with root package name */
    public BdSwipeRefreshLayout f45441h;

    /* renamed from: i  reason: collision with root package name */
    public BdTypeRecyclerView f45442i;

    /* renamed from: j  reason: collision with root package name */
    public PbListView f45443j;

    /* renamed from: k  reason: collision with root package name */
    public g f45444k;
    public SmartBubbleAnimatedView l;
    public HomePageTabFeedHeaderView m;
    public i n;
    public c.a.r0.n1.j.b o;
    public String p;
    public boolean q;
    public int r;
    public BdListView.p s;
    public RecyclerView.OnScrollListener t;
    public View.OnClickListener u;

    /* loaded from: classes10.dex */
    public class a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedView f45445e;

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
            this.f45445e = homePageTabFeedView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f45445e.f45442i != null) {
                    this.f45445e.f45442i.stopScroll();
                }
                this.f45445e.showLoadMoreView();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedView f45446b;

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
            this.f45446b = homePageTabFeedView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) && i2 == 0) {
                if (this.f45446b.n != null) {
                    this.f45446b.n.n(this.f45446b.f45442i.getFirstVisiblePosition(), this.f45446b.f45442i.getLastVisiblePosition(), this.a, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(true ^ this.f45446b.isListAtTop())));
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

    /* loaded from: classes10.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedView f45447e;

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
            this.f45447e = homePageTabFeedView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f45447e.f45442i != null) {
                    this.f45447e.f45442i.stopScroll();
                }
                if (this.f45447e.f45443j == null || this.f45447e.f45439f == null || !j.z()) {
                    return;
                }
                this.f45447e.f45443j.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.f45447e.f45443j.B(null);
                if (this.f45447e.q) {
                    this.f45447e.f45443j.N();
                    this.f45447e.f45439f.callLoadMore();
                }
            }
        }
    }

    /* loaded from: classes10.dex */
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
        this.f45438e = homePageTabFeedFragment;
        this.f45439f = eVar;
        this.p = str;
        f(viewGroup);
        c.a.r0.n1.j.b bVar = new c.a.r0.n1.j.b(homePageTabFeedFragment, this.f45442i);
        this.o = bVar;
        bVar.d(str);
        setIsRefresh(false);
    }

    public final void f(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
            this.f45440g = viewGroup;
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
            this.f45442i = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f45438e.getContext()));
            this.f45442i.setFadingEdgeLength(0);
            this.f45442i.setOverScrollMode(2);
            this.f45442i.setOnSrollToBottomListener(this.s);
            this.f45442i.addOnScrollListener(this.t);
            g gVar = new g(this.f45438e.getPageContext());
            this.f45444k = gVar;
            gVar.a(this.f45439f);
            this.f45442i.setRecyclerListener(new d(this));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.f45442i.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            PbListView pbListView = new PbListView(this.f45438e.getPageContext().getPageActivity());
            this.f45443j = pbListView;
            pbListView.b();
            this.f45443j.p(R.color.transparent);
            this.f45443j.s(l.f(this.f45438e.getPageContext().getPageActivity(), R.dimen.tbds182));
            this.f45443j.x();
            this.f45443j.G(R.dimen.tbfontsize33);
            this.f45443j.E(SkinManager.getColor(R.color.CAM_X0107));
            this.f45443j.A(R.color.CAM_X0110);
            this.f45443j.r();
            this.f45443j.B(this.u);
            if (this.f45441h == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
                this.f45441h = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.f45444k);
            }
            new n1();
            SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(this.f45438e.getContext());
            this.l = smartBubbleAnimatedView;
            smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, l.f(this.f45438e.getContext(), R.dimen.tbds83)));
            if (this.n == null) {
                i iVar = new i(this.f45438e.getPageContext(), this.f45442i);
                this.n = iVar;
                iVar.p(1);
                this.n.t(this.f45438e.getUniqueId());
            }
        }
    }

    public BdTypeRecyclerView getRecycleView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f45442i : (BdTypeRecyclerView) invokeV.objValue;
    }

    public boolean isListAtTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f45442i;
            return bdTypeRecyclerView == null || bdTypeRecyclerView.getChildCount() == 0 || this.f45442i.getChildAt(0).getTop() == 0;
        }
        return invokeV.booleanValue;
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.r == i2) {
            return;
        }
        g gVar = this.f45444k;
        if (gVar != null) {
            gVar.C(i2);
        }
        PbListView pbListView = this.f45443j;
        if (pbListView != null) {
            pbListView.E(SkinManager.getColor(R.color.CAM_X0107));
            this.f45443j.d(i2);
        }
        HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.m;
        if (homePageTabFeedHeaderView != null) {
            homePageTabFeedHeaderView.onChangeSkinType(i2);
        }
        c.a.r0.n1.j.b bVar = this.o;
        if (bVar != null) {
            bVar.b();
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
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            i iVar = this.n;
            if (iVar != null) {
                iVar.h();
            }
            g gVar = this.f45444k;
            if (gVar != null) {
                gVar.a(null);
            }
            HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.m;
            if (homePageTabFeedHeaderView != null) {
                homePageTabFeedHeaderView.onDestroy();
            }
        }
    }

    public void onNetDataUpdate(c.a.r0.n1.j.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            setIsRefresh(false);
            if (cVar == null || this.o == null || this.f45442i == null || this.f45443j == null) {
                return;
            }
            this.q = cVar.f20639c;
            if (cVar.f20641e == null && cVar.f20642f == null) {
                HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.m;
                if (homePageTabFeedHeaderView != null && homePageTabFeedHeaderView.getParent() != null) {
                    this.f45442i.removeHeaderView(this.m);
                    this.m = null;
                }
            } else {
                if (this.m == null) {
                    HomePageTabFeedHeaderView homePageTabFeedHeaderView2 = new HomePageTabFeedHeaderView(this.f45438e.getContext());
                    this.m = homePageTabFeedHeaderView2;
                    homePageTabFeedHeaderView2.setTabCode(this.p);
                    this.f45442i.addHeaderView(this.m);
                }
                this.m.setData(cVar);
            }
            if (cVar.f20638b > 0) {
                int firstVisiblePosition = this.f45442i.getFirstVisiblePosition();
                View childAt = this.f45442i.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.f45442i.getLayoutManager();
                int i2 = firstVisiblePosition - cVar.f20638b;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.f45442i.startInterceptLayout();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, top);
                    this.f45442i.stopIntercerceptLayout();
                }
            }
            this.o.c(cVar.a);
            this.o.b();
            i iVar = this.n;
            if (iVar != null) {
                iVar.n(this.f45442i.getFirstVisiblePosition(), this.f45442i.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (iVar = this.n) == null) {
            return;
        }
        iVar.x();
        this.n.q(false);
    }

    public void removeListItems(int i2, int i3) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) || (bdTypeRecyclerView = this.f45442i) == null || i2 >= i3) {
            return;
        }
        bdTypeRecyclerView.removeItemList(i2, i3);
    }

    public void resetListPullRefreshListener() {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (gVar = this.f45444k) != null && gVar.F() == null) {
            this.f45444k.a(this.f45439f);
        }
    }

    public void resume() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (iVar = this.n) == null) {
            return;
        }
        iVar.q(true);
        BdTypeRecyclerView bdTypeRecyclerView = this.f45442i;
        if (bdTypeRecyclerView != null) {
            this.n.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.f45442i.getLastVisiblePosition(), false, true);
        }
    }

    public void setIsRefresh(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (bdSwipeRefreshLayout = this.f45441h) == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(z);
    }

    public void setListContentVisible(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || (bdSwipeRefreshLayout = this.f45441h) == null) {
            return;
        }
        bdSwipeRefreshLayout.setVisibility(z ? 0 : 8);
    }

    public void showLoadMoreView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f45443j == null || this.f45439f == null) {
            return;
        }
        if (j.z()) {
            this.f45442i.setNextPage(this.f45443j);
            this.f45443j.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f45443j.B(null);
            if (this.q) {
                this.f45443j.N();
                this.f45439f.callLoadMore();
                return;
            }
            this.f45443j.C(this.f45438e.getResources().getString(R.string.list_has_no_more));
            this.f45443j.f();
            return;
        }
        this.f45442i.setNextPage(null);
    }

    public void toListTop() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (bdTypeRecyclerView = this.f45442i) == null) {
            return;
        }
        bdTypeRecyclerView.scrollToPosition(0);
    }
}
