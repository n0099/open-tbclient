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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PublishProgressData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.PublishProgressView;
import com.baidu.tieba.R;
import com.baidu.tieba.a06;
import com.baidu.tieba.cv4;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import com.baidu.tieba.gw6;
import com.baidu.tieba.homepage.channel.model.ChannelTabNetFeedModel;
import com.baidu.tieba.homepage.tabfeed.HomePageTabFeedFragment;
import com.baidu.tieba.jr4;
import com.baidu.tieba.k15;
import com.baidu.tieba.lj8;
import com.baidu.tieba.pi;
import com.baidu.tieba.pn;
import com.baidu.tieba.r17;
import com.baidu.tieba.r27;
import com.baidu.tieba.ri;
import com.baidu.tieba.s17;
import com.baidu.tieba.t17;
import com.baidu.tieba.u27;
import com.baidu.tieba.u88;
import com.baidu.tieba.ug6;
import com.baidu.tieba.v17;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class HomePageTabFeedView implements LifecycleObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public v17 b;
    public ViewGroup c;
    public BdSwipeRefreshLayout d;
    public BdTypeRecyclerView e;
    public PbListView f;
    public cv4 g;
    public SmartBubbleAnimatedView h;
    public PublishProgressView i;
    public HomePageTabFeedHeaderView j;
    public u88 k;
    public PostAnimateFloatView l;
    public s17 m;
    public String n;
    public boolean o;
    public int p;
    public ViewGroup q;
    public LuckyHeaderBannerView r;
    public gw6 s;
    public BdListView.p t;
    public RecyclerView.OnScrollListener u;
    public View.OnClickListener v;

    /* loaded from: classes4.dex */
    public class a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomePageTabFeedView a;

        public a(HomePageTabFeedView homePageTabFeedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = homePageTabFeedView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.e != null) {
                    this.a.e.stopScroll();
                }
                this.a.G();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ HomePageTabFeedView b;

        public b(HomePageTabFeedView homePageTabFeedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = homePageTabFeedView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) && i == 0) {
                if (this.b.k != null) {
                    this.b.k.n(this.b.e.getFirstVisiblePosition(), this.b.e.getLastVisiblePosition(), this.a, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(true ^ this.b.w())));
                a06.b().c();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                if (i2 > 0) {
                    this.a = false;
                } else {
                    this.a = true;
                }
                this.b.q();
                if (this.b.s != null) {
                    this.b.s.j();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomePageTabFeedView a;

        public c(HomePageTabFeedView homePageTabFeedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = homePageTabFeedView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.e != null) {
                    this.a.e.stopScroll();
                }
                if (this.a.f == null || this.a.b == null || !pi.z()) {
                    return;
                }
                this.a.f.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.a.f.B(null);
                if (this.a.o) {
                    this.a.f.N();
                    this.a.b.i();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = homePageTabFeedView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || (view2 = viewHolder.itemView) == null || this.a.k == null) {
                return;
            }
            this.a.k.k(view2);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k15 a;
        public final /* synthetic */ HomePageTabFeedView b;

        public e(HomePageTabFeedView homePageTabFeedView, k15 k15Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedView, k15Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = homePageTabFeedView;
            this.a = k15Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.b.v()) {
                    t17.e(this.b.a.F1());
                }
                UrlManager.getInstance().dealOneLink(this.b.a.getPageContext(), new String[]{this.a.g()});
            }
        }
    }

    public HomePageTabFeedView(HomePageTabFeedFragment homePageTabFeedFragment, v17 v17Var, ViewGroup viewGroup, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {homePageTabFeedFragment, v17Var, viewGroup, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = true;
        this.p = 3;
        this.t = new a(this);
        this.u = new b(this);
        this.v = new c(this);
        this.a = homePageTabFeedFragment;
        this.b = v17Var;
        this.n = str;
        t(viewGroup);
        s17 s17Var = new s17(homePageTabFeedFragment, this.e);
        this.m = s17Var;
        s17Var.g(str);
        E(false);
    }

    public void A(u27 u27Var) {
        PostAnimateFloatView postAnimateFloatView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, u27Var) == null) {
            E(false);
            if (u27Var == null || this.m == null || this.e == null || this.f == null) {
                return;
            }
            this.o = u27Var.c;
            k15 f = r17.f(this.a.F1());
            if (f != null && !UbsABTestHelper.isHomeTabModifyABTestA()) {
                if (this.r == null) {
                    LuckyHeaderBannerView luckyHeaderBannerView = new LuckyHeaderBannerView(this.a.getContext());
                    this.r = luckyHeaderBannerView;
                    luckyHeaderBannerView.setClickCallback(new e(this, f));
                    this.e.s(this.r);
                    if (v()) {
                        t17.n(this.a.F1());
                    }
                }
                this.r.c(r17.e(f));
            } else {
                LuckyHeaderBannerView luckyHeaderBannerView2 = this.r;
                if (luckyHeaderBannerView2 != null && luckyHeaderBannerView2.getParent() != null) {
                    this.e.removeHeaderView(this.r);
                    this.r = null;
                }
            }
            if (u27Var.e == null && u27Var.f == null) {
                HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.j;
                if (homePageTabFeedHeaderView != null && homePageTabFeedHeaderView.getParent() != null) {
                    this.e.removeHeaderView(this.j);
                    this.j = null;
                }
            } else {
                if (this.j == null) {
                    HomePageTabFeedHeaderView homePageTabFeedHeaderView2 = new HomePageTabFeedHeaderView(this.a.getContext());
                    this.j = homePageTabFeedHeaderView2;
                    homePageTabFeedHeaderView2.setTabCode(this.n);
                    this.e.s(this.j);
                }
                this.j.setData(u27Var);
            }
            if (u27Var.b > 0) {
                int firstVisiblePosition = this.e.getFirstVisiblePosition();
                View childAt = this.e.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.e.getLayoutManager();
                int i = firstVisiblePosition - u27Var.b;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.e.z();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                    this.e.A();
                }
            }
            this.m.e(u27Var.a);
            this.m.d();
            x();
            u88 u88Var = this.k;
            if (u88Var != null) {
                u88Var.n(this.e.getFirstVisiblePosition(), this.e.getLastVisiblePosition(), false, true);
            }
            if (!"local".equals(this.n) || (postAnimateFloatView = this.l) == null || postAnimateFloatView.getVisibility() == 0) {
                return;
            }
            this.l.setVisibility(0);
            t17.p();
        }
    }

    public void B() {
        u88 u88Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (u88Var = this.k) == null) {
            return;
        }
        u88Var.y();
        this.k.r(false);
    }

    public void C() {
        cv4 cv4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (cv4Var = this.g) != null && cv4Var.L() == null) {
            this.g.f(this.b);
        }
    }

    public void D() {
        u88 u88Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (u88Var = this.k) == null) {
            return;
        }
        u88Var.r(true);
        BdTypeRecyclerView bdTypeRecyclerView = this.e;
        if (bdTypeRecyclerView != null) {
            this.k.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.e.getLastVisiblePosition(), false, true);
        }
    }

    public void E(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (bdSwipeRefreshLayout = this.d) == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(z);
    }

    public void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            BdSwipeRefreshLayout bdSwipeRefreshLayout = this.d;
            if (bdSwipeRefreshLayout != null) {
                bdSwipeRefreshLayout.setVisibility(z ? 0 : 8);
            }
            this.s.q(z);
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f == null || this.b == null) {
            return;
        }
        if (pi.z()) {
            this.e.setNextPage(this.f);
            this.f.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f.B(null);
            if (this.o) {
                this.f.N();
                this.b.i();
                return;
            }
            this.f.C(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09ec));
            this.f.f();
            return;
        }
        this.e.setNextPage(null);
    }

    public void H() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (bdTypeRecyclerView = this.e) == null) {
            return;
        }
        bdTypeRecyclerView.scrollToPosition(0);
    }

    public void I(PublishProgressData publishProgressData) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, publishProgressData) == null) || (viewGroup = this.c) == null || viewGroup.getContext() == null) {
            return;
        }
        if (this.i == null) {
            this.i = new PublishProgressView(this.c.getContext());
            this.c.addView(this.i, new FrameLayout.LayoutParams(-1, ri.f(this.c.getContext(), R.dimen.tbds83)));
        }
        this.i.c(publishProgressData);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            u88 u88Var = this.k;
            if (u88Var != null) {
                u88Var.h();
            }
            cv4 cv4Var = this.g;
            if (cv4Var != null) {
                cv4Var.f(null);
            }
            HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.j;
            if (homePageTabFeedHeaderView != null) {
                homePageTabFeedHeaderView.e();
            }
            PostAnimateFloatView postAnimateFloatView = this.l;
            if (postAnimateFloatView != null) {
                postAnimateFloatView.h();
            }
        }
    }

    public final void q() {
        PostAnimateFloatView postAnimateFloatView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && "local".equals(this.n) && TbSingleton.getInstance().shouldShowLocalChannelPostAnim) {
            pn B = this.e.B(this.e.getFirstVisiblePosition() - 1);
            if (B != null && B.getType() == ThreadData.TYPE_USER_NORMAL && (postAnimateFloatView = this.l) != null && postAnimateFloatView.getVisibility() == 0) {
                this.l.g();
                TbSingleton.getInstance().shouldShowLocalChannelPostAnim = false;
            }
        }
    }

    public PostAnimateFloatView r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.l : (PostAnimateFloatView) invokeV.objValue;
    }

    public BdTypeRecyclerView s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.e : (BdTypeRecyclerView) invokeV.objValue;
    }

    public final void t(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, viewGroup) == null) {
            this.c = viewGroup;
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091fc2);
            this.e = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.a.getContext()));
            this.e.setFadingEdgeLength(0);
            this.e.setOverScrollMode(2);
            this.e.setOnSrollToBottomListener(this.t);
            this.e.addOnScrollListener(this.u);
            gw6 gw6Var = new gw6(this.c, this.e);
            this.s = gw6Var;
            gw6Var.p(this.a.F1());
            this.s.o(this.a.getPageContext());
            cv4 cv4Var = new cv4(this.a.getPageContext());
            this.g = cv4Var;
            cv4Var.f(this.b);
            this.e.setRecyclerListener(new d(this));
            PbListView pbListView = new PbListView(this.a.getPageContext().getPageActivity());
            this.f = pbListView;
            pbListView.b();
            this.f.p(R.color.transparent);
            this.f.t(ri.f(this.a.getPageContext().getPageActivity(), R.dimen.tbds182));
            this.f.x();
            this.f.G(R.dimen.tbfontsize33);
            this.f.E(SkinManager.getColor(R.color.CAM_X0107));
            this.f.A(R.color.CAM_X0110);
            this.f.s();
            this.f.B(this.v);
            if (this.d == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f091fc1);
                this.d = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.g);
            }
            new ug6();
            SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(this.a.getContext());
            this.h = smartBubbleAnimatedView;
            smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, ri.f(this.a.getContext(), R.dimen.tbds83)));
            if (this.k == null) {
                u88 u88Var = new u88(this.a.getPageContext(), this.e);
                this.k = u88Var;
                u88Var.p(2);
                this.k.u(this.a.getUniqueId());
            }
            this.q = (ViewGroup) viewGroup.findViewById(R.id.obfuscated_res_0x7f09207a);
            this.l = (PostAnimateFloatView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0919fc);
        }
    }

    public void u(ThreadData threadData) {
        HomePageTabFeedFragment homePageTabFeedFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, threadData) == null) || this.e == null || (homePageTabFeedFragment = this.a) == null || !(homePageTabFeedFragment.D1() instanceof ChannelTabNetFeedModel) || ListUtils.isEmpty(this.e.getData())) {
            return;
        }
        ArrayList<pn> arrayList = (ArrayList) this.e.getData();
        int i = 0;
        while (true) {
            if (i >= arrayList.size()) {
                i = -1;
                break;
            } else if (arrayList.get(i) instanceof jr4) {
                break;
            } else {
                i++;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(threadData);
        ArrayList<pn> c2 = r17.c(arrayList2);
        if (i != -1) {
            arrayList.addAll(i, c2);
        } else {
            arrayList.addAll(c2);
        }
        List<ThreadData> l = ((ChannelTabNetFeedModel) this.a.D1()).l();
        if (l != null) {
            l.add(0, threadData);
        }
        this.m.e(arrayList);
        this.m.d();
        x();
    }

    public final boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.a.getResources().getString(R.string.obfuscated_res_0x7f0f134e).equals(this.a.F1()) || this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1351).equals(this.a.F1()) : invokeV.booleanValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.e;
            return bdTypeRecyclerView == null || bdTypeRecyclerView.getChildCount() == 0 || this.e.getChildAt(0).getTop() == 0;
        }
        return invokeV.booleanValue;
    }

    public void x() {
        gw6 gw6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (gw6Var = this.s) == null) {
            return;
        }
        gw6Var.f();
    }

    public void y() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (bdTypeRecyclerView = this.e) == null || bdTypeRecyclerView.getCount() == 0) {
            return;
        }
        if (this.e.B(0) instanceof r27) {
            this.e.D(0);
        }
        s17 s17Var = this.m;
        if (s17Var != null) {
            s17Var.f(false);
        }
    }

    public void z(int i) {
        k15 f;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i) == null) || this.p == i) {
            return;
        }
        cv4 cv4Var = this.g;
        if (cv4Var != null) {
            cv4Var.H(i);
            k15 f2 = r17.f(this.a.F1());
            if (f2 != null) {
                this.g.K().setBackgroundColor(lj8.f(r17.d(f2)));
            }
        }
        if (this.r != null && (f = r17.f(this.a.F1())) != null) {
            this.r.c(r17.e(f));
        }
        PbListView pbListView = this.f;
        if (pbListView != null) {
            pbListView.E(SkinManager.getColor(R.color.CAM_X0107));
            this.f.d(i);
        }
        HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.j;
        if (homePageTabFeedHeaderView != null) {
            homePageTabFeedHeaderView.d(i);
        }
        s17 s17Var = this.m;
        if (s17Var != null) {
            s17Var.d();
        }
        x();
        SmartBubbleAnimatedView smartBubbleAnimatedView = this.h;
        if (smartBubbleAnimatedView != null) {
            smartBubbleAnimatedView.e(i);
        }
        PublishProgressView publishProgressView = this.i;
        if (publishProgressView != null) {
            publishProgressView.b();
        }
        PostAnimateFloatView postAnimateFloatView = this.l;
        if (postAnimateFloatView != null) {
            postAnimateFloatView.onChangeSkinType(this.a.getPageContext(), i);
        }
        gw6 gw6Var = this.s;
        if (gw6Var != null) {
            gw6Var.n();
        }
        this.p = i;
    }
}
