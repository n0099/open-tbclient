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
import com.baidu.tieba.a56;
import com.baidu.tieba.bz4;
import com.baidu.tieba.h17;
import com.baidu.tieba.homepage.channel.model.ChannelTabNetFeedModel;
import com.baidu.tieba.homepage.tabfeed.HomePageTabFeedFragment;
import com.baidu.tieba.m55;
import com.baidu.tieba.o67;
import com.baidu.tieba.o77;
import com.baidu.tieba.of8;
import com.baidu.tieba.p67;
import com.baidu.tieba.q67;
import com.baidu.tieba.qq8;
import com.baidu.tieba.r77;
import com.baidu.tieba.s67;
import com.baidu.tieba.xn;
import com.baidu.tieba.yi;
import com.baidu.tieba.yu4;
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
    public s67 b;
    public ViewGroup c;
    public BdSwipeRefreshLayout d;
    public BdTypeRecyclerView e;
    public PbListView f;
    public bz4 g;
    public PublishProgressView h;
    public HomePageTabFeedHeaderView i;
    public of8 j;
    public PostAnimateFloatView k;
    public p67 l;
    public String m;
    public boolean n;
    public int o;
    public ViewGroup p;
    public LuckyHeaderBannerView q;
    public h17 r;
    public BdListView.p s;
    public RecyclerView.OnScrollListener t;
    public View.OnClickListener u;

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
                this.a.D();
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
                if (this.b.j != null) {
                    this.b.j.n(this.b.e.getFirstVisiblePosition(), this.b.e.getLastVisiblePosition(), this.a, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(true ^ this.b.n())));
                a56.b().c();
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
                this.b.i();
                if (this.b.r != null) {
                    this.b.r.j();
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
                if (this.a.f != null && this.a.b != null && BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.f.O(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.a.f.E(null);
                    if (this.a.n) {
                        this.a.f.Q();
                        this.a.b.i();
                    }
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) && (view2 = viewHolder.itemView) != null && this.a.j != null) {
                this.a.j.k(view2);
            }
        }
    }

    public HomePageTabFeedView(HomePageTabFeedFragment homePageTabFeedFragment, s67 s67Var, ViewGroup viewGroup, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {homePageTabFeedFragment, s67Var, viewGroup, str};
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
        this.s = new a(this);
        this.t = new b(this);
        this.u = new c(this);
        this.a = homePageTabFeedFragment;
        this.b = s67Var;
        this.m = str;
        l(viewGroup);
        p67 p67Var = new p67(homePageTabFeedFragment, this.e);
        this.l = p67Var;
        p67Var.g(str);
        A(false);
    }

    public void A(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (bdSwipeRefreshLayout = this.d) != null) {
            bdSwipeRefreshLayout.setRefreshing(z);
        }
    }

    public void B(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            BdSwipeRefreshLayout bdSwipeRefreshLayout = this.d;
            if (bdSwipeRefreshLayout != null) {
                if (z) {
                    i = 0;
                } else {
                    i = 8;
                }
                bdSwipeRefreshLayout.setVisibility(i);
            }
            this.r.q(z);
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f != null && this.b != null) {
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                this.e.setNextPage(this.f);
                this.f.O(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.f.E(null);
                if (this.n) {
                    this.f.Q();
                    this.b.i();
                    return;
                }
                this.f.F(this.a.getResources().getString(R.string.list_has_no_more));
                this.f.g();
                return;
            }
            this.e.setNextPage(null);
        }
    }

    public final void i() {
        PostAnimateFloatView postAnimateFloatView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || !"local".equals(this.m) || !TbSingleton.getInstance().shouldShowLocalChannelPostAnim) {
            return;
        }
        xn E = this.e.E(this.e.getFirstVisiblePosition() - 1);
        if (E != null && E.getType() == ThreadData.TYPE_USER_NORMAL && (postAnimateFloatView = this.k) != null && postAnimateFloatView.getVisibility() == 0) {
            this.k.g();
            TbSingleton.getInstance().shouldShowLocalChannelPostAnim = false;
        }
    }

    public void E() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (bdTypeRecyclerView = this.e) != null) {
            bdTypeRecyclerView.scrollToPosition(0);
        }
    }

    public PostAnimateFloatView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.k;
        }
        return (PostAnimateFloatView) invokeV.objValue;
    }

    public BdTypeRecyclerView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.e;
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.e;
            if (bdTypeRecyclerView == null || bdTypeRecyclerView.getChildCount() == 0 || this.e.getChildAt(0).getTop() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            of8 of8Var = this.j;
            if (of8Var != null) {
                of8Var.h();
                this.j.v(null);
            }
            bz4 bz4Var = this.g;
            if (bz4Var != null) {
                bz4Var.f(null);
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

    public void q() {
        h17 h17Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (h17Var = this.r) != null) {
            h17Var.f();
        }
    }

    public void t() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (bdTypeRecyclerView = this.e) != null && bdTypeRecyclerView.getCount() != 0) {
            if (this.e.E(0) instanceof o77) {
                this.e.G(0);
            }
            p67 p67Var = this.l;
            if (p67Var != null) {
                p67Var.f(false);
            }
        }
    }

    public void x() {
        of8 of8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (of8Var = this.j) != null) {
            of8Var.z();
            this.j.r(false);
        }
    }

    public void y() {
        bz4 bz4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (bz4Var = this.g) != null && bz4Var.L() == null) {
            this.g.f(this.b);
        }
    }

    public void F(PublishProgressData publishProgressData) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, publishProgressData) == null) && (viewGroup = this.c) != null && viewGroup.getContext() != null) {
            if (this.h == null) {
                this.h = new PublishProgressView(this.c.getContext());
                this.c.addView(this.h, new FrameLayout.LayoutParams(-1, yi.g(this.c.getContext(), R.dimen.tbds83)));
            }
            this.h.c(publishProgressData);
        }
    }

    public final void l(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup) == null) {
            this.c = viewGroup;
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0920da);
            this.e = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.a.getContext()));
            this.e.setFadingEdgeLength(0);
            this.e.setOverScrollMode(2);
            this.e.setOnSrollToBottomListener(this.s);
            this.e.addOnScrollListener(this.t);
            h17 h17Var = new h17(this.c, this.e);
            this.r = h17Var;
            h17Var.p(this.a.K1());
            this.r.o(this.a.getPageContext());
            bz4 bz4Var = new bz4(this.a.getPageContext());
            this.g = bz4Var;
            bz4Var.f(this.b);
            this.e.setRecyclerListener(new d(this));
            PbListView pbListView = new PbListView(this.a.getPageContext().getPageActivity());
            this.f = pbListView;
            pbListView.c();
            this.f.r(R.color.transparent);
            this.f.v(yi.g(this.a.getPageContext().getPageActivity(), R.dimen.tbds182));
            this.f.A();
            this.f.J(R.dimen.tbfontsize33);
            this.f.H(SkinManager.getColor(R.color.CAM_X0107));
            this.f.D(R.color.CAM_X0110);
            this.f.u();
            this.f.E(this.u);
            if (this.d == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f0920d9);
                this.d = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.g);
            }
            if (this.j == null) {
                of8 of8Var = new of8(this.a.getPageContext(), this.e);
                this.j = of8Var;
                of8Var.p(2);
                this.j.u(this.a.getUniqueId());
            }
            this.p = (ViewGroup) viewGroup.findViewById(R.id.obfuscated_res_0x7f09219b);
            this.k = (PostAnimateFloatView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091af1);
        }
    }

    public void w(r77 r77Var) {
        PostAnimateFloatView postAnimateFloatView;
        int top;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, r77Var) == null) {
            A(false);
            if (r77Var != null && this.l != null && this.e != null && this.f != null) {
                this.n = r77Var.c;
                LuckyHeaderBannerView luckyHeaderBannerView = this.q;
                if (luckyHeaderBannerView != null && luckyHeaderBannerView.getParent() != null) {
                    this.e.removeHeaderView(this.q);
                    this.q = null;
                }
                if (r77Var.e == null && r77Var.f == null) {
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
                        this.e.s(this.i);
                    }
                    this.i.setData(r77Var);
                }
                if (r77Var.b > 0) {
                    int firstVisiblePosition = this.e.getFirstVisiblePosition();
                    View childAt = this.e.getChildAt(0);
                    if (childAt == null) {
                        top = 0;
                    } else {
                        top = childAt.getTop();
                    }
                    RecyclerView.LayoutManager layoutManager = this.e.getLayoutManager();
                    int i = firstVisiblePosition - r77Var.b;
                    if (layoutManager instanceof LinearLayoutManager) {
                        this.e.B();
                        ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                        this.e.C();
                    }
                }
                this.l.e(r77Var.a);
                this.l.d();
                q();
                of8 of8Var = this.j;
                if (of8Var != null) {
                    of8Var.n(this.e.getFirstVisiblePosition(), this.e.getLastVisiblePosition(), false, true);
                }
                if ("local".equals(this.m) && (postAnimateFloatView = this.k) != null && postAnimateFloatView.getVisibility() != 0) {
                    this.k.setVisibility(0);
                    q67.n();
                }
            }
        }
    }

    public void m(ThreadData threadData) {
        HomePageTabFeedFragment homePageTabFeedFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, threadData) == null) && this.e != null && (homePageTabFeedFragment = this.a) != null && (homePageTabFeedFragment.I1() instanceof ChannelTabNetFeedModel) && !ListUtils.isEmpty(this.e.getData())) {
            ArrayList<xn> arrayList = (ArrayList) this.e.getData();
            int i = 0;
            while (true) {
                if (i < arrayList.size()) {
                    if (arrayList.get(i) instanceof yu4) {
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
            ArrayList<xn> c2 = o67.c(arrayList2);
            if (i != -1) {
                arrayList.addAll(i, c2);
            } else {
                arrayList.addAll(c2);
            }
            List<ThreadData> m = ((ChannelTabNetFeedModel) this.a.I1()).m();
            if (m != null) {
                m.add(0, threadData);
            }
            this.l.e(arrayList);
            this.l.d();
            q();
        }
    }

    public void u(int i) {
        m55 f;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048590, this, i) != null) || this.o == i) {
            return;
        }
        bz4 bz4Var = this.g;
        if (bz4Var != null) {
            bz4Var.H(i);
            m55 f2 = o67.f(this.a.K1());
            if (f2 != null) {
                this.g.K().setBackgroundColor(qq8.f(o67.d(f2)));
            }
        }
        if (this.q != null && (f = o67.f(this.a.K1())) != null) {
            this.q.c(o67.e(f));
        }
        PbListView pbListView = this.f;
        if (pbListView != null) {
            pbListView.H(SkinManager.getColor(R.color.CAM_X0107));
            this.f.e(i);
        }
        HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.i;
        if (homePageTabFeedHeaderView != null) {
            homePageTabFeedHeaderView.d(i);
        }
        p67 p67Var = this.l;
        if (p67Var != null) {
            p67Var.d();
        }
        q();
        PublishProgressView publishProgressView = this.h;
        if (publishProgressView != null) {
            publishProgressView.b();
        }
        PostAnimateFloatView postAnimateFloatView = this.k;
        if (postAnimateFloatView != null) {
            postAnimateFloatView.onChangeSkinType(this.a.getPageContext(), i);
        }
        h17 h17Var = this.r;
        if (h17Var != null) {
            h17Var.n();
        }
        this.o = i;
    }

    public void z() {
        of8 of8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (of8Var = this.j) != null) {
            of8Var.r(true);
            BdTypeRecyclerView bdTypeRecyclerView = this.e;
            if (bdTypeRecyclerView != null) {
                this.j.v(bdTypeRecyclerView);
                this.j.n(this.e.getFirstVisiblePosition(), this.e.getLastVisiblePosition(), false, true);
            }
        }
    }
}
