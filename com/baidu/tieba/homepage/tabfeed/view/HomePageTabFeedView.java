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
import c.a.d.o.e.n;
import c.a.t0.s.l0.g;
import c.a.t0.s.r.d2;
import c.a.t0.s.r.e2;
import c.a.t0.s.r.l1;
import c.a.u0.b3.k;
import c.a.u0.e1.n1;
import c.a.u0.g0.u;
import c.a.u0.p1.k.e;
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
    public HomePageTabFeedFragment f44719e;

    /* renamed from: f  reason: collision with root package name */
    public e f44720f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f44721g;

    /* renamed from: h  reason: collision with root package name */
    public BdSwipeRefreshLayout f44722h;

    /* renamed from: i  reason: collision with root package name */
    public BdTypeRecyclerView f44723i;

    /* renamed from: j  reason: collision with root package name */
    public PbListView f44724j;
    public g k;
    public SmartBubbleAnimatedView l;
    public PublishProgressView m;
    public ViewGroup mTaskFloatingView;
    public HomePageTabFeedHeaderView n;
    public k o;
    public PostAnimateFloatView p;
    public c.a.u0.p1.k.b q;
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
        public final /* synthetic */ HomePageTabFeedView f44725e;

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
            this.f44725e = homePageTabFeedView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f44725e.f44723i != null) {
                    this.f44725e.f44723i.stopScroll();
                }
                this.f44725e.showLoadMoreView();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedView f44726b;

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
            this.f44726b = homePageTabFeedView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) && i2 == 0) {
                if (this.f44726b.o != null) {
                    this.f44726b.o.n(this.f44726b.f44723i.getFirstVisiblePosition(), this.f44726b.f44723i.getLastVisiblePosition(), this.a, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(true ^ this.f44726b.isListAtTop())));
                u.b().c();
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
                this.f44726b.g();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedView f44727e;

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
            this.f44727e = homePageTabFeedView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f44727e.f44723i != null) {
                    this.f44727e.f44723i.stopScroll();
                }
                if (this.f44727e.f44724j == null || this.f44727e.f44720f == null || !l.z()) {
                    return;
                }
                this.f44727e.f44724j.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.f44727e.f44724j.C(null);
                if (this.f44727e.s) {
                    this.f44727e.f44724j.O();
                    this.f44727e.f44720f.callLoadMore();
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
        this.f44719e = homePageTabFeedFragment;
        this.f44720f = eVar;
        this.r = str;
        h(viewGroup);
        c.a.u0.p1.k.b bVar = new c.a.u0.p1.k.b(homePageTabFeedFragment, this.f44723i);
        this.q = bVar;
        bVar.g(str);
        setIsRefresh(false);
    }

    public final void g() {
        PostAnimateFloatView postAnimateFloatView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && MainTabActivity.TAB_CODE_LOCAL.equals(this.r) && TbSingleton.getInstance().shouldShowLocalChannelPostAnim) {
            n item = this.f44723i.getItem(this.f44723i.getFirstVisiblePosition() - 1);
            if (item != null && item.getType() == e2.p3 && (postAnimateFloatView = this.p) != null && postAnimateFloatView.getVisibility() == 0) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f44723i : (BdTypeRecyclerView) invokeV.objValue;
    }

    public final void h(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, viewGroup) == null) {
            this.f44721g = viewGroup;
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
            this.f44723i = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f44719e.getContext()));
            this.f44723i.setFadingEdgeLength(0);
            this.f44723i.setOverScrollMode(2);
            this.f44723i.setOnSrollToBottomListener(this.u);
            this.f44723i.addOnScrollListener(this.v);
            g gVar = new g(this.f44719e.getPageContext());
            this.k = gVar;
            gVar.a(this.f44720f);
            this.f44723i.setRecyclerListener(new d(this));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.f44723i.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            PbListView pbListView = new PbListView(this.f44719e.getPageContext().getPageActivity());
            this.f44724j = pbListView;
            pbListView.b();
            this.f44724j.p(R.color.transparent);
            this.f44724j.t(c.a.d.f.p.n.f(this.f44719e.getPageContext().getPageActivity(), R.dimen.tbds182));
            this.f44724j.y();
            this.f44724j.H(R.dimen.tbfontsize33);
            this.f44724j.F(SkinManager.getColor(R.color.CAM_X0107));
            this.f44724j.B(R.color.CAM_X0110);
            this.f44724j.s();
            this.f44724j.C(this.w);
            if (this.f44722h == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
                this.f44722h = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.k);
            }
            new n1();
            SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(this.f44719e.getContext());
            this.l = smartBubbleAnimatedView;
            smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, c.a.d.f.p.n.f(this.f44719e.getContext(), R.dimen.tbds83)));
            if (this.o == null) {
                this.o = new k(this.f44719e.getPageContext(), this.f44723i);
                if (c.a.t0.b.d.l()) {
                    this.o.p(2);
                } else {
                    this.o.p(1);
                }
                this.o.u(this.f44719e.getUniqueId());
            }
            this.mTaskFloatingView = (ViewGroup) viewGroup.findViewById(R.id.task_float_view);
            this.p = (PostAnimateFloatView) viewGroup.findViewById(R.id.post_animate_float_view);
        }
    }

    public void insertFakeThreadData(e2 e2Var) {
        HomePageTabFeedFragment homePageTabFeedFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, e2Var) == null) || this.f44723i == null || (homePageTabFeedFragment = this.f44719e) == null || !(homePageTabFeedFragment.getNetModel() instanceof ChannelTabNetFeedModel) || ListUtils.isEmpty(this.f44723i.getData())) {
            return;
        }
        ArrayList<n> arrayList = (ArrayList) this.f44723i.getData();
        int i2 = 0;
        while (true) {
            if (i2 >= arrayList.size()) {
                i2 = -1;
                break;
            } else if (arrayList.get(i2) instanceof d2) {
                break;
            } else {
                i2++;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(e2Var);
        ArrayList<n> c2 = c.a.u0.p1.k.a.c(arrayList2);
        if (i2 != -1) {
            arrayList.addAll(i2, c2);
        } else {
            arrayList.addAll(c2);
        }
        List<e2> i3 = ((ChannelTabNetFeedModel) this.f44719e.getNetModel()).i();
        if (i3 != null) {
            i3.add(0, e2Var);
        }
        this.q.e(arrayList);
        this.q.d();
    }

    public boolean isListAtTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f44723i;
            return bdTypeRecyclerView == null || bdTypeRecyclerView.getChildCount() == 0 || this.f44723i.getChildAt(0).getTop() == 0;
        }
        return invokeV.booleanValue;
    }

    public void notifyLocalInfoCompleted() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (bdTypeRecyclerView = this.f44723i) == null || bdTypeRecyclerView.getCount() == 0) {
            return;
        }
        if (this.f44723i.getItem(0) instanceof c.a.u0.p1.k.h.a) {
            this.f44723i.removeItem(0);
        }
        c.a.u0.p1.k.b bVar = this.q;
        if (bVar != null) {
            bVar.f(false);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || this.t == i2) {
            return;
        }
        g gVar = this.k;
        if (gVar != null) {
            gVar.C(i2);
        }
        PbListView pbListView = this.f44724j;
        if (pbListView != null) {
            pbListView.F(SkinManager.getColor(R.color.CAM_X0107));
            this.f44724j.d(i2);
        }
        HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.n;
        if (homePageTabFeedHeaderView != null) {
            homePageTabFeedHeaderView.onChangeSkinType(i2);
        }
        c.a.u0.p1.k.b bVar = this.q;
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
            postAnimateFloatView.onChangeSkinType(this.f44719e.getPageContext(), i2);
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
            g gVar = this.k;
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

    public void onNetDataUpdate(c.a.u0.p1.k.h.d dVar) {
        PostAnimateFloatView postAnimateFloatView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, dVar) == null) {
            setIsRefresh(false);
            if (dVar == null || this.q == null || this.f44723i == null || this.f44724j == null) {
                return;
            }
            this.s = dVar.f20851c;
            if (dVar.f20853e == null && dVar.f20854f == null) {
                HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.n;
                if (homePageTabFeedHeaderView != null && homePageTabFeedHeaderView.getParent() != null) {
                    this.f44723i.removeHeaderView(this.n);
                    this.n = null;
                }
            } else {
                if (this.n == null) {
                    HomePageTabFeedHeaderView homePageTabFeedHeaderView2 = new HomePageTabFeedHeaderView(this.f44719e.getContext());
                    this.n = homePageTabFeedHeaderView2;
                    homePageTabFeedHeaderView2.setTabCode(this.r);
                    this.f44723i.addHeaderView(this.n);
                }
                this.n.setData(dVar);
            }
            if (dVar.f20850b > 0) {
                int firstVisiblePosition = this.f44723i.getFirstVisiblePosition();
                View childAt = this.f44723i.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.f44723i.getLayoutManager();
                int i2 = firstVisiblePosition - dVar.f20850b;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.f44723i.startInterceptLayout();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, top);
                    this.f44723i.stopIntercerceptLayout();
                }
            }
            this.q.e(dVar.a);
            this.q.d();
            k kVar = this.o;
            if (kVar != null) {
                kVar.n(this.f44723i.getFirstVisiblePosition(), this.f44723i.getLastVisiblePosition(), false, true);
            }
            if (!MainTabActivity.TAB_CODE_LOCAL.equals(this.r) || (postAnimateFloatView = this.p) == null || postAnimateFloatView.getVisibility() == 0) {
                return;
            }
            this.p.setVisibility(0);
            c.a.u0.p1.k.c.l();
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
        if (!(interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) || (bdTypeRecyclerView = this.f44723i) == null || i2 >= i3) {
            return;
        }
        bdTypeRecyclerView.removeItemList(i2, i3);
    }

    public void resetListPullRefreshListener() {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (gVar = this.k) != null && gVar.F() == null) {
            this.k.a(this.f44720f);
        }
    }

    public void resume() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (kVar = this.o) == null) {
            return;
        }
        kVar.r(true);
        BdTypeRecyclerView bdTypeRecyclerView = this.f44723i;
        if (bdTypeRecyclerView != null) {
            this.o.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.f44723i.getLastVisiblePosition(), false, true);
        }
    }

    public void setIsRefresh(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || (bdSwipeRefreshLayout = this.f44722h) == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(z);
    }

    public void setListContentVisible(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || (bdSwipeRefreshLayout = this.f44722h) == null) {
            return;
        }
        bdSwipeRefreshLayout.setVisibility(z ? 0 : 8);
    }

    public void showLoadMoreView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.f44724j == null || this.f44720f == null) {
            return;
        }
        if (l.z()) {
            this.f44723i.setNextPage(this.f44724j);
            this.f44724j.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f44724j.C(null);
            if (this.s) {
                this.f44724j.O();
                this.f44720f.callLoadMore();
                return;
            }
            this.f44724j.D(this.f44719e.getResources().getString(R.string.list_has_no_more));
            this.f44724j.f();
            return;
        }
        this.f44723i.setNextPage(null);
    }

    public void toListTop() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (bdTypeRecyclerView = this.f44723i) == null) {
            return;
        }
        bdTypeRecyclerView.scrollToPosition(0);
    }

    public void updatePublishProgress(l1 l1Var) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, l1Var) == null) || (viewGroup = this.f44721g) == null || viewGroup.getContext() == null) {
            return;
        }
        if (this.m == null) {
            this.m = new PublishProgressView(this.f44721g.getContext());
            this.f44721g.addView(this.m, new FrameLayout.LayoutParams(-1, c.a.d.f.p.n.f(this.f44721g.getContext(), R.dimen.tbds83)));
        }
        this.m.updateCurProgressData(l1Var);
    }
}
