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
import b.a.e.e.p.j;
import b.a.e.e.p.l;
import b.a.q0.s.g0.g;
import b.a.r0.b0.u;
import b.a.r0.h1.j.e;
import b.a.r0.q2.i;
import b.a.r0.x0.m1;
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
/* loaded from: classes9.dex */
public class HomePageTabFeedView implements LifecycleObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public HomePageTabFeedFragment f49791e;

    /* renamed from: f  reason: collision with root package name */
    public e f49792f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f49793g;

    /* renamed from: h  reason: collision with root package name */
    public BdSwipeRefreshLayout f49794h;

    /* renamed from: i  reason: collision with root package name */
    public BdTypeRecyclerView f49795i;
    public PbListView j;
    public g k;
    public SmartBubbleAnimatedView l;
    public HomePageTabFeedHeaderView m;
    public i n;
    public b.a.r0.h1.j.b o;
    public String p;
    public boolean q;
    public int r;
    public BdListView.p s;
    public RecyclerView.OnScrollListener t;
    public View.OnClickListener u;

    /* loaded from: classes9.dex */
    public class a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedView f49796e;

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
            this.f49796e = homePageTabFeedView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f49796e.f49795i != null) {
                    this.f49796e.f49795i.stopScroll();
                }
                this.f49796e.showLoadMoreView();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f49797a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedView f49798b;

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
            this.f49798b = homePageTabFeedView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) && i2 == 0) {
                if (this.f49798b.n != null) {
                    this.f49798b.n.n(this.f49798b.f49795i.getFirstVisiblePosition(), this.f49798b.f49795i.getLastVisiblePosition(), this.f49797a, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(true ^ this.f49798b.isListAtTop())));
                u.b().c();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                if (i3 > 0) {
                    this.f49797a = false;
                } else {
                    this.f49797a = true;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedView f49799e;

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
            this.f49799e = homePageTabFeedView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f49799e.f49795i != null) {
                    this.f49799e.f49795i.stopScroll();
                }
                if (this.f49799e.j == null || this.f49799e.f49792f == null || !j.z()) {
                    return;
                }
                this.f49799e.j.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.f49799e.j.B(null);
                if (this.f49799e.q) {
                    this.f49799e.j.N();
                    this.f49799e.f49792f.callLoadMore();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedView f49800a;

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
            this.f49800a = homePageTabFeedView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || (view = viewHolder.itemView) == null || this.f49800a.n == null) {
                return;
            }
            this.f49800a.n.k(view);
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
        this.f49791e = homePageTabFeedFragment;
        this.f49792f = eVar;
        this.p = str;
        f(viewGroup);
        b.a.r0.h1.j.b bVar = new b.a.r0.h1.j.b(homePageTabFeedFragment, this.f49795i);
        this.o = bVar;
        bVar.d(str);
        setIsRefresh(false);
    }

    public final void f(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
            this.f49793g = viewGroup;
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
            this.f49795i = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f49791e.getContext()));
            this.f49795i.setFadingEdgeLength(0);
            this.f49795i.setOverScrollMode(2);
            this.f49795i.setOnSrollToBottomListener(this.s);
            this.f49795i.addOnScrollListener(this.t);
            g gVar = new g(this.f49791e.getPageContext());
            this.k = gVar;
            gVar.a(this.f49792f);
            this.f49795i.setRecyclerListener(new d(this));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.f49795i.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            PbListView pbListView = new PbListView(this.f49791e.getPageContext().getPageActivity());
            this.j = pbListView;
            pbListView.b();
            this.j.p(R.color.transparent);
            this.j.s(l.g(this.f49791e.getPageContext().getPageActivity(), R.dimen.tbds182));
            this.j.x();
            this.j.G(R.dimen.tbfontsize33);
            this.j.E(SkinManager.getColor(R.color.CAM_X0107));
            this.j.A(R.color.CAM_X0110);
            this.j.r();
            this.j.B(this.u);
            if (this.f49794h == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
                this.f49794h = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.k);
            }
            new m1();
            SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(this.f49791e.getContext());
            this.l = smartBubbleAnimatedView;
            smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, l.g(this.f49791e.getContext(), R.dimen.tbds83)));
            if (this.n == null) {
                i iVar = new i(this.f49791e.getPageContext(), this.f49795i);
                this.n = iVar;
                iVar.p(1);
                this.n.t(this.f49791e.getUniqueId());
            }
        }
    }

    public BdTypeRecyclerView getRecycleView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f49795i : (BdTypeRecyclerView) invokeV.objValue;
    }

    public boolean isListAtTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f49795i;
            return bdTypeRecyclerView == null || bdTypeRecyclerView.getChildCount() == 0 || this.f49795i.getChildAt(0).getTop() == 0;
        }
        return invokeV.booleanValue;
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.r == i2) {
            return;
        }
        g gVar = this.k;
        if (gVar != null) {
            gVar.C(i2);
        }
        PbListView pbListView = this.j;
        if (pbListView != null) {
            pbListView.E(SkinManager.getColor(R.color.CAM_X0107));
            this.j.d(i2);
        }
        HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.m;
        if (homePageTabFeedHeaderView != null) {
            homePageTabFeedHeaderView.onChangeSkinType(i2);
        }
        b.a.r0.h1.j.b bVar = this.o;
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
            g gVar = this.k;
            if (gVar != null) {
                gVar.a(null);
            }
            HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.m;
            if (homePageTabFeedHeaderView != null) {
                homePageTabFeedHeaderView.onDestroy();
            }
        }
    }

    public void onNetDataUpdate(b.a.r0.h1.j.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            setIsRefresh(false);
            if (cVar == null || this.o == null || this.f49795i == null || this.j == null) {
                return;
            }
            this.q = cVar.f17566c;
            if (cVar.f17568e == null && cVar.f17569f == null) {
                HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.m;
                if (homePageTabFeedHeaderView != null && homePageTabFeedHeaderView.getParent() != null) {
                    this.f49795i.removeHeaderView(this.m);
                    this.m = null;
                }
            } else {
                if (this.m == null) {
                    HomePageTabFeedHeaderView homePageTabFeedHeaderView2 = new HomePageTabFeedHeaderView(this.f49791e.getContext());
                    this.m = homePageTabFeedHeaderView2;
                    homePageTabFeedHeaderView2.setTabCode(this.p);
                    this.f49795i.addHeaderView(this.m);
                }
                this.m.setData(cVar);
            }
            if (cVar.f17565b > 0) {
                int firstVisiblePosition = this.f49795i.getFirstVisiblePosition();
                View childAt = this.f49795i.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.f49795i.getLayoutManager();
                int i2 = firstVisiblePosition - cVar.f17565b;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.f49795i.startInterceptLayout();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, top);
                    this.f49795i.stopIntercerceptLayout();
                }
            }
            this.o.c(cVar.f17564a);
            this.o.b();
            i iVar = this.n;
            if (iVar != null) {
                iVar.n(this.f49795i.getFirstVisiblePosition(), this.f49795i.getLastVisiblePosition(), false, true);
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
        if (!(interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) || (bdTypeRecyclerView = this.f49795i) == null || i2 >= i3) {
            return;
        }
        bdTypeRecyclerView.removeItemList(i2, i3);
    }

    public void resume() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (iVar = this.n) == null) {
            return;
        }
        iVar.q(true);
        BdTypeRecyclerView bdTypeRecyclerView = this.f49795i;
        if (bdTypeRecyclerView != null) {
            this.n.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.f49795i.getLastVisiblePosition(), false, true);
        }
    }

    public void setIsRefresh(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (bdSwipeRefreshLayout = this.f49794h) == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(z);
    }

    public void setListContentVisible(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (bdSwipeRefreshLayout = this.f49794h) == null) {
            return;
        }
        bdSwipeRefreshLayout.setVisibility(z ? 0 : 8);
    }

    public void showLoadMoreView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.j == null || this.f49792f == null) {
            return;
        }
        if (j.z()) {
            this.f49795i.setNextPage(this.j);
            this.j.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.j.B(null);
            if (this.q) {
                this.j.N();
                this.f49792f.callLoadMore();
                return;
            }
            this.j.C(this.f49791e.getResources().getString(R.string.list_has_no_more));
            this.j.f();
            return;
        }
        this.f49795i.setNextPage(null);
    }

    public void toListTop() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (bdTypeRecyclerView = this.f49795i) == null) {
            return;
        }
        bdTypeRecyclerView.scrollToPosition(0);
    }
}
