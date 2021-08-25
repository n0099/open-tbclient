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
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.p0.s.f0.g;
import c.a.q0.a0.t;
import c.a.q0.f1.j.e;
import c.a.q0.o2.i;
import c.a.q0.v0.c1;
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
/* loaded from: classes7.dex */
public class HomePageTabFeedView implements LifecycleObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public HomePageTabFeedFragment f52310e;

    /* renamed from: f  reason: collision with root package name */
    public e f52311f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f52312g;

    /* renamed from: h  reason: collision with root package name */
    public BdSwipeRefreshLayout f52313h;

    /* renamed from: i  reason: collision with root package name */
    public BdTypeRecyclerView f52314i;

    /* renamed from: j  reason: collision with root package name */
    public PbListView f52315j;
    public g k;
    public SmartBubbleAnimatedView l;
    public HomePageTabFeedHeaderView m;
    public i n;
    public c.a.q0.f1.j.b o;
    public String p;
    public boolean q;
    public int r;
    public BdListView.p s;
    public RecyclerView.OnScrollListener t;
    public View.OnClickListener u;

    /* loaded from: classes7.dex */
    public class a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedView f52316e;

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
            this.f52316e = homePageTabFeedView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f52316e.f52314i != null) {
                    this.f52316e.f52314i.stopScroll();
                }
                this.f52316e.showLoadMoreView();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f52317a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedView f52318b;

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
            this.f52318b = homePageTabFeedView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) && i2 == 0) {
                if (this.f52318b.n != null) {
                    this.f52318b.n.n(this.f52318b.f52314i.getFirstVisiblePosition(), this.f52318b.f52314i.getLastVisiblePosition(), this.f52317a, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(true ^ this.f52318b.isListAtTop())));
                t.b().c();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                if (i3 > 0) {
                    this.f52317a = false;
                } else {
                    this.f52317a = true;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedView f52319e;

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
            this.f52319e = homePageTabFeedView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f52319e.f52314i != null) {
                    this.f52319e.f52314i.stopScroll();
                }
                if (this.f52319e.f52315j == null || this.f52319e.f52311f == null || !j.z()) {
                    return;
                }
                this.f52319e.f52315j.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.f52319e.f52315j.z(null);
                if (this.f52319e.q) {
                    this.f52319e.f52315j.L();
                    this.f52319e.f52311f.callLoadMore();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedView f52320a;

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
            this.f52320a = homePageTabFeedView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || (view = viewHolder.itemView) == null || this.f52320a.n == null) {
                return;
            }
            this.f52320a.n.k(view);
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
        this.f52310e = homePageTabFeedFragment;
        this.f52311f = eVar;
        this.p = str;
        f(viewGroup);
        c.a.q0.f1.j.b bVar = new c.a.q0.f1.j.b(homePageTabFeedFragment, this.f52314i);
        this.o = bVar;
        bVar.d(str);
        setIsRefresh(false);
    }

    public final void f(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
            this.f52312g = viewGroup;
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
            this.f52314i = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f52310e.getContext()));
            this.f52314i.setFadingEdgeLength(0);
            this.f52314i.setOverScrollMode(2);
            this.f52314i.setOnSrollToBottomListener(this.s);
            this.f52314i.addOnScrollListener(this.t);
            g gVar = new g(this.f52310e.getPageContext());
            this.k = gVar;
            gVar.a(this.f52311f);
            this.f52314i.setRecyclerListener(new d(this));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.f52314i.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            PbListView pbListView = new PbListView(this.f52310e.getPageContext().getPageActivity());
            this.f52315j = pbListView;
            pbListView.b();
            this.f52315j.o(R.color.transparent);
            this.f52315j.r(l.g(this.f52310e.getPageContext().getPageActivity(), R.dimen.tbds182));
            this.f52315j.v();
            this.f52315j.E(R.dimen.tbfontsize33);
            this.f52315j.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f52315j.y(R.color.CAM_X0110);
            this.f52315j.q();
            this.f52315j.z(this.u);
            if (this.f52313h == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
                this.f52313h = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.k);
            }
            new c1();
            SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(this.f52310e.getContext());
            this.l = smartBubbleAnimatedView;
            smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, l.g(this.f52310e.getContext(), R.dimen.tbds83)));
            if (this.n == null) {
                i iVar = new i(this.f52310e.getPageContext(), this.f52314i);
                this.n = iVar;
                iVar.p(1);
                this.n.t(this.f52310e.getUniqueId());
            }
        }
    }

    public BdTypeRecyclerView getRecycleView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f52314i : (BdTypeRecyclerView) invokeV.objValue;
    }

    public boolean isListAtTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f52314i;
            return bdTypeRecyclerView == null || bdTypeRecyclerView.getChildCount() == 0 || this.f52314i.getChildAt(0).getTop() == 0;
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
            gVar.D(i2);
        }
        PbListView pbListView = this.f52315j;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f52315j.d(i2);
        }
        HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.m;
        if (homePageTabFeedHeaderView != null) {
            homePageTabFeedHeaderView.onChangeSkinType(i2);
        }
        c.a.q0.f1.j.b bVar = this.o;
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
            HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.m;
            if (homePageTabFeedHeaderView != null) {
                homePageTabFeedHeaderView.onDestroy();
            }
        }
    }

    public void onNetDataUpdate(c.a.q0.f1.j.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            setIsRefresh(false);
            if (cVar == null || this.o == null || this.f52314i == null || this.f52315j == null) {
                return;
            }
            this.q = cVar.f17923c;
            if (cVar.f17925e == null && cVar.f17926f == null) {
                HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.m;
                if (homePageTabFeedHeaderView != null && homePageTabFeedHeaderView.getParent() != null) {
                    this.f52314i.removeHeaderView(this.m);
                    this.m = null;
                }
            } else {
                if (this.m == null) {
                    HomePageTabFeedHeaderView homePageTabFeedHeaderView2 = new HomePageTabFeedHeaderView(this.f52310e.getContext());
                    this.m = homePageTabFeedHeaderView2;
                    homePageTabFeedHeaderView2.setTabCode(this.p);
                    this.f52314i.addHeaderView(this.m);
                }
                this.m.setData(cVar);
            }
            if (cVar.f17922b > 0) {
                int firstVisiblePosition = this.f52314i.getFirstVisiblePosition();
                View childAt = this.f52314i.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.f52314i.getLayoutManager();
                int i2 = firstVisiblePosition - cVar.f17922b;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.f52314i.startInterceptLayout();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, top);
                    this.f52314i.stopIntercerceptLayout();
                }
            }
            this.o.c(cVar.f17921a);
            this.o.b();
            i iVar = this.n;
            if (iVar != null) {
                iVar.n(this.f52314i.getFirstVisiblePosition(), this.f52314i.getLastVisiblePosition(), false, true);
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
        if (!(interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) || (bdTypeRecyclerView = this.f52314i) == null || i2 >= i3) {
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
        BdTypeRecyclerView bdTypeRecyclerView = this.f52314i;
        if (bdTypeRecyclerView != null) {
            this.n.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.f52314i.getLastVisiblePosition(), false, true);
        }
    }

    public void setIsRefresh(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (bdSwipeRefreshLayout = this.f52313h) == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(z);
    }

    public void setListContentVisible(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (bdSwipeRefreshLayout = this.f52313h) == null) {
            return;
        }
        bdSwipeRefreshLayout.setVisibility(z ? 0 : 8);
    }

    public void showLoadMoreView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f52315j == null || this.f52311f == null) {
            return;
        }
        if (j.z()) {
            this.f52314i.setNextPage(this.f52315j);
            this.f52315j.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f52315j.z(null);
            if (this.q) {
                this.f52315j.L();
                this.f52311f.callLoadMore();
                return;
            }
            this.f52315j.A(this.f52310e.getResources().getString(R.string.list_has_no_more));
            this.f52315j.f();
            return;
        }
        this.f52314i.setNextPage(null);
    }

    public void toListTop() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (bdTypeRecyclerView = this.f52314i) == null) {
            return;
        }
        bdTypeRecyclerView.scrollToPosition(0);
    }
}
