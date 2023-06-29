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
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PublishProgressData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.PublishProgressView;
import com.baidu.tieba.R;
import com.baidu.tieba.ba5;
import com.baidu.tieba.ex7;
import com.baidu.tieba.homepage.channel.model.ChannelTabNetFeedModel;
import com.baidu.tieba.homepage.tabfeed.HomePageTabFeedFragment;
import com.baidu.tieba.io9;
import com.baidu.tieba.jo6;
import com.baidu.tieba.r45;
import com.baidu.tieba.s28;
import com.baidu.tieba.s38;
import com.baidu.tieba.t28;
import com.baidu.tieba.u28;
import com.baidu.tieba.v38;
import com.baidu.tieba.w28;
import com.baidu.tieba.xi;
import com.baidu.tieba.xn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class HomePageTabFeedView implements LifecycleObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public w28 b;
    public ViewGroup c;
    public BdSwipeRefreshLayout d;
    public BdTypeRecyclerView e;
    public PbListView f;
    public ba5 g;
    public PublishProgressView h;
    public HomePageTabFeedHeaderView i;
    public io9 j;
    public PostAnimateFloatView k;
    public t28 l;
    public String m;
    public boolean n;
    public int o;
    public ViewGroup p;
    public ex7 q;
    public BdListView.p r;
    public RecyclerView.OnScrollListener s;
    public View.OnClickListener t;

    /* loaded from: classes6.dex */
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
                this.a.J();
            }
        }
    }

    /* loaded from: classes6.dex */
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
                if (this.b.j != null) {
                    this.b.j.n(this.b.e.getFirstVisiblePosition(), this.b.e.getLastVisiblePosition(), this.a, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(true ^ this.b.u())));
                jo6.b().c();
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
                this.b.p();
                if (this.b.q != null) {
                    this.b.q.j();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
                if (this.a.f != null && this.a.b != null && BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.f.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.a.f.G(null);
                    if (this.a.n) {
                        this.a.f.R();
                        this.a.b.j();
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) && (view2 = viewHolder.itemView) != null && this.a.j != null) {
                this.a.j.k(view2);
            }
        }
    }

    public HomePageTabFeedView(HomePageTabFeedFragment homePageTabFeedFragment, w28 w28Var, ViewGroup viewGroup, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {homePageTabFeedFragment, w28Var, viewGroup, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = true;
        this.o = 3;
        this.r = new a(this);
        this.s = new b(this);
        this.t = new c(this);
        this.a = homePageTabFeedFragment;
        this.b = w28Var;
        this.m = str;
        s(viewGroup);
        t28 t28Var = new t28(homePageTabFeedFragment, this.e);
        this.l = t28Var;
        t28Var.g(str);
        H(false);
    }

    public void H(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (bdSwipeRefreshLayout = this.d) != null) {
            bdSwipeRefreshLayout.setRefreshing(z);
        }
    }

    public void I(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            BdSwipeRefreshLayout bdSwipeRefreshLayout = this.d;
            if (bdSwipeRefreshLayout != null) {
                if (z) {
                    i = 0;
                } else {
                    i = 8;
                }
                bdSwipeRefreshLayout.setVisibility(i);
            }
            this.q.r(z);
        }
    }

    public void C(v38 v38Var) {
        PostAnimateFloatView postAnimateFloatView;
        int top;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, v38Var) == null) {
            H(false);
            if (v38Var != null && this.l != null && this.e != null && this.f != null) {
                this.n = v38Var.c;
                if (v38Var.e == null && v38Var.f == null) {
                    HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.i;
                    if (homePageTabFeedHeaderView != null && homePageTabFeedHeaderView.getParent() != null) {
                        this.e.removeHeaderView(this.i);
                        this.i = null;
                    }
                } else {
                    if (this.i == null) {
                        HomePageTabFeedHeaderView homePageTabFeedHeaderView2 = new HomePageTabFeedHeaderView(this.a.getContext());
                        this.i = homePageTabFeedHeaderView2;
                        homePageTabFeedHeaderView2.setTabCode(this.m);
                        this.e.addHeaderView(this.i);
                    }
                    this.i.setData(v38Var);
                }
                if (v38Var.b > 0) {
                    int firstVisiblePosition = this.e.getFirstVisiblePosition();
                    View childAt = this.e.getChildAt(0);
                    if (childAt == null) {
                        top = 0;
                    } else {
                        top = childAt.getTop();
                    }
                    RecyclerView.LayoutManager layoutManager = this.e.getLayoutManager();
                    int i = firstVisiblePosition - v38Var.b;
                    if (layoutManager instanceof LinearLayoutManager) {
                        this.e.startInterceptLayout();
                        ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                        this.e.stopIntercerceptLayout();
                    }
                }
                this.l.e(v38Var.a);
                this.l.d();
                v();
                io9 io9Var = this.j;
                if (io9Var != null) {
                    io9Var.n(this.e.getFirstVisiblePosition(), this.e.getLastVisiblePosition(), false, true);
                }
                if ("local".equals(this.m) && (postAnimateFloatView = this.k) != null && postAnimateFloatView.getVisibility() != 0) {
                    this.k.setVisibility(0);
                    u28.n();
                }
            }
        }
    }

    public final void s(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, viewGroup) == null) {
            this.c = viewGroup;
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0922fb);
            this.e = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.a.getContext()));
            this.e.setFadingEdgeLength(0);
            this.e.setOverScrollMode(2);
            this.e.setOnSrollToBottomListener(this.r);
            this.e.addOnScrollListener(this.s);
            ex7 ex7Var = new ex7(this.c, this.e);
            this.q = ex7Var;
            ex7Var.q(this.a.U1());
            this.q.p(this.a.getPageContext());
            ba5 ba5Var = new ba5(this.a.getPageContext());
            this.g = ba5Var;
            ba5Var.f(this.b);
            this.e.setRecyclerListener(new d(this));
            PbListView pbListView = new PbListView(this.a.getPageContext().getPageActivity());
            this.f = pbListView;
            pbListView.c();
            this.f.s(R.color.transparent);
            this.f.w(xi.g(this.a.getPageContext().getPageActivity(), R.dimen.tbds182));
            this.f.B();
            this.f.L(R.dimen.tbfontsize33);
            this.f.J(SkinManager.getColor(R.color.CAM_X0107));
            this.f.F(R.color.CAM_X0110);
            this.f.v();
            this.f.G(this.t);
            if (this.d == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f0922fa);
                this.d = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.g);
            }
            if (this.j == null) {
                io9 io9Var = new io9(this.a.getPageContext(), this.e);
                this.j = io9Var;
                io9Var.p(2);
                this.j.u(this.a.getUniqueId());
            }
            this.p = (ViewGroup) viewGroup.findViewById(R.id.obfuscated_res_0x7f0923cd);
            this.k = (PostAnimateFloatView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091cbb);
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            io9 io9Var = this.j;
            if (io9Var != null) {
                io9Var.z();
                this.j.r(false);
            }
            HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.i;
            if (homePageTabFeedHeaderView != null) {
                homePageTabFeedHeaderView.f();
            }
        }
    }

    public void E() {
        ba5 ba5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (ba5Var = this.g) != null && ba5Var.K() == null) {
            this.g.f(this.b);
        }
    }

    public void L() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (bdTypeRecyclerView = this.e) != null) {
            bdTypeRecyclerView.scrollToPosition(0);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            io9 io9Var = this.j;
            if (io9Var != null) {
                io9Var.h();
                this.j.v(null);
            }
            ba5 ba5Var = this.g;
            if (ba5Var != null) {
                ba5Var.f(null);
            }
            HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.i;
            if (homePageTabFeedHeaderView != null) {
                homePageTabFeedHeaderView.e();
            }
            PostAnimateFloatView postAnimateFloatView = this.k;
            if (postAnimateFloatView != null) {
                postAnimateFloatView.h();
            }
        }
    }

    public PostAnimateFloatView q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.k;
        }
        return (PostAnimateFloatView) invokeV.objValue;
    }

    public BdTypeRecyclerView r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.e;
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.e;
            if (bdTypeRecyclerView == null || bdTypeRecyclerView.getChildCount() == 0 || this.e.getChildAt(0).getTop() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void v() {
        ex7 ex7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (ex7Var = this.q) != null) {
            ex7Var.f();
        }
    }

    public void w() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (bdTypeRecyclerView = this.e) != null && bdTypeRecyclerView.getCount() != 0) {
            if (this.e.getItem(0) instanceof s38) {
                this.e.removeItem(0);
            }
            t28 t28Var = this.l;
            if (t28Var != null) {
                t28Var.f(false);
            }
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            io9 io9Var = this.j;
            if (io9Var != null) {
                io9Var.r(true);
                BdTypeRecyclerView bdTypeRecyclerView = this.e;
                if (bdTypeRecyclerView != null) {
                    this.j.v(bdTypeRecyclerView);
                    this.j.n(this.e.getFirstVisiblePosition(), this.e.getLastVisiblePosition(), false, true);
                }
            }
            HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.i;
            if (homePageTabFeedHeaderView != null) {
                homePageTabFeedHeaderView.g();
            }
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.f != null && this.b != null) {
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                this.e.setNextPage(this.f);
                this.f.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.f.G(null);
                if (this.n) {
                    this.f.R();
                    this.b.j();
                    return;
                }
                this.f.H(this.a.getResources().getString(R.string.list_has_no_more));
                this.f.g();
                return;
            }
            this.e.setNextPage(null);
        }
    }

    public final void p() {
        PostAnimateFloatView postAnimateFloatView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || !"local".equals(this.m) || !TbSingleton.getInstance().shouldShowLocalChannelPostAnim) {
            return;
        }
        xn item = this.e.getItem(this.e.getFirstVisiblePosition() - 1);
        if (item != null && item.getType() == ThreadData.TYPE_USER_NORMAL && (postAnimateFloatView = this.k) != null && postAnimateFloatView.getVisibility() == 0) {
            this.k.g();
            TbSingleton.getInstance().shouldShowLocalChannelPostAnim = false;
        }
    }

    public void M(PublishProgressData publishProgressData) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, publishProgressData) == null) && (viewGroup = this.c) != null && viewGroup.getContext() != null) {
            if (this.h == null) {
                this.h = new PublishProgressView(this.c.getContext());
                this.c.addView(this.h, new FrameLayout.LayoutParams(-1, xi.g(this.c.getContext(), R.dimen.tbds83)));
            }
            this.h.c(publishProgressData);
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048585, this, i) != null) || this.o == i) {
            return;
        }
        ba5 ba5Var = this.g;
        if (ba5Var != null) {
            ba5Var.H(i);
        }
        PbListView pbListView = this.f;
        if (pbListView != null) {
            pbListView.J(SkinManager.getColor(R.color.CAM_X0107));
            this.f.e(i);
        }
        HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.i;
        if (homePageTabFeedHeaderView != null) {
            homePageTabFeedHeaderView.d(i);
        }
        t28 t28Var = this.l;
        if (t28Var != null) {
            t28Var.d();
        }
        v();
        PublishProgressView publishProgressView = this.h;
        if (publishProgressView != null) {
            publishProgressView.b();
        }
        PostAnimateFloatView postAnimateFloatView = this.k;
        if (postAnimateFloatView != null) {
            postAnimateFloatView.onChangeSkinType(this.a.getPageContext(), i);
        }
        ex7 ex7Var = this.q;
        if (ex7Var != null) {
            ex7Var.o();
        }
        this.o = i;
    }

    public void t(ThreadData threadData) {
        HomePageTabFeedFragment homePageTabFeedFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, threadData) == null) && this.e != null && (homePageTabFeedFragment = this.a) != null && (homePageTabFeedFragment.S1() instanceof ChannelTabNetFeedModel) && !ListUtils.isEmpty(this.e.getData())) {
            ArrayList<xn> arrayList = (ArrayList) this.e.getData();
            int i = 0;
            while (true) {
                if (i < arrayList.size()) {
                    if (arrayList.get(i) instanceof r45) {
                        break;
                    }
                    i++;
                } else {
                    i = -1;
                    break;
                }
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(threadData);
            ArrayList<xn> c2 = s28.c(arrayList2);
            if (i != -1) {
                arrayList.addAll(i, c2);
            } else {
                arrayList.addAll(c2);
            }
            List<ThreadData> u = ((ChannelTabNetFeedModel) this.a.S1()).u();
            if (u != null) {
                u.add(0, threadData);
            }
            this.l.e(arrayList);
            this.l.d();
            v();
        }
    }
}
