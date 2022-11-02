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
import com.baidu.tieba.e57;
import com.baidu.tieba.e67;
import com.baidu.tieba.f55;
import com.baidu.tieba.f57;
import com.baidu.tieba.fn8;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import com.baidu.tieba.g57;
import com.baidu.tieba.h67;
import com.baidu.tieba.homepage.channel.model.ChannelTabNetFeedModel;
import com.baidu.tieba.homepage.tabfeed.HomePageTabFeedFragment;
import com.baidu.tieba.i57;
import com.baidu.tieba.kc8;
import com.baidu.tieba.qk6;
import com.baidu.tieba.s36;
import com.baidu.tieba.vu4;
import com.baidu.tieba.vy4;
import com.baidu.tieba.vz6;
import com.baidu.tieba.wn;
import com.baidu.tieba.xi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class HomePageTabFeedView implements LifecycleObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public i57 b;
    public ViewGroup c;
    public BdSwipeRefreshLayout d;
    public BdTypeRecyclerView e;
    public PbListView f;
    public vy4 g;
    public SmartBubbleAnimatedView h;
    public PublishProgressView i;
    public HomePageTabFeedHeaderView j;
    public kc8 k;
    public PostAnimateFloatView l;
    public f57 m;
    public String n;
    public boolean o;
    public int p;
    public ViewGroup q;
    public LuckyHeaderBannerView r;
    public vz6 s;
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
                if (this.b.k != null) {
                    this.b.k.n(this.b.e.getFirstVisiblePosition(), this.b.e.getLastVisiblePosition(), this.a, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(true ^ this.b.t())));
                s36.b().c();
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
                this.b.o();
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
                if (this.a.f != null && this.a.b != null && BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.f.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.a.f.C(null);
                    if (this.a.o) {
                        this.a.f.O();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) && (view2 = viewHolder.itemView) != null && this.a.k != null) {
                this.a.k.k(view2);
            }
        }
    }

    public HomePageTabFeedView(HomePageTabFeedFragment homePageTabFeedFragment, i57 i57Var, ViewGroup viewGroup, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {homePageTabFeedFragment, i57Var, viewGroup, str};
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
        this.b = i57Var;
        this.n = str;
        r(viewGroup);
        f57 f57Var = new f57(homePageTabFeedFragment, this.e);
        this.m = f57Var;
        f57Var.g(str);
        B(false);
    }

    public void B(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && (bdSwipeRefreshLayout = this.d) != null) {
            bdSwipeRefreshLayout.setRefreshing(z);
        }
    }

    public void C(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            BdSwipeRefreshLayout bdSwipeRefreshLayout = this.d;
            if (bdSwipeRefreshLayout != null) {
                if (z) {
                    i = 0;
                } else {
                    i = 8;
                }
                bdSwipeRefreshLayout.setVisibility(i);
            }
            this.s.q(z);
        }
    }

    public void A() {
        kc8 kc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (kc8Var = this.k) != null) {
            kc8Var.r(true);
            BdTypeRecyclerView bdTypeRecyclerView = this.e;
            if (bdTypeRecyclerView != null) {
                this.k.v(bdTypeRecyclerView);
                this.k.n(this.e.getFirstVisiblePosition(), this.e.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void E() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (bdTypeRecyclerView = this.e) != null) {
            bdTypeRecyclerView.scrollToPosition(0);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            kc8 kc8Var = this.k;
            if (kc8Var != null) {
                kc8Var.h();
                this.k.v(null);
            }
            vy4 vy4Var = this.g;
            if (vy4Var != null) {
                vy4Var.f(null);
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

    public PostAnimateFloatView p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.l;
        }
        return (PostAnimateFloatView) invokeV.objValue;
    }

    public BdTypeRecyclerView q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.e;
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.e;
            if (bdTypeRecyclerView == null || bdTypeRecyclerView.getChildCount() == 0 || this.e.getChildAt(0).getTop() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void u() {
        vz6 vz6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (vz6Var = this.s) != null) {
            vz6Var.f();
        }
    }

    public void v() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (bdTypeRecyclerView = this.e) != null && bdTypeRecyclerView.getCount() != 0) {
            if (this.e.B(0) instanceof e67) {
                this.e.D(0);
            }
            f57 f57Var = this.m;
            if (f57Var != null) {
                f57Var.f(false);
            }
        }
    }

    public void y() {
        kc8 kc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (kc8Var = this.k) != null) {
            kc8Var.z();
            this.k.r(false);
        }
    }

    public void z() {
        vy4 vy4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (vy4Var = this.g) != null && vy4Var.L() == null) {
            this.g.f(this.b);
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f != null && this.b != null) {
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                this.e.setNextPage(this.f);
                this.f.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.f.C(null);
                if (this.o) {
                    this.f.O();
                    this.b.i();
                    return;
                }
                this.f.D(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a18));
                this.f.f();
                return;
            }
            this.e.setNextPage(null);
        }
    }

    public final void o() {
        PostAnimateFloatView postAnimateFloatView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || !ImagesContract.LOCAL.equals(this.n) || !TbSingleton.getInstance().shouldShowLocalChannelPostAnim) {
            return;
        }
        wn B = this.e.B(this.e.getFirstVisiblePosition() - 1);
        if (B != null && B.getType() == ThreadData.TYPE_USER_NORMAL && (postAnimateFloatView = this.l) != null && postAnimateFloatView.getVisibility() == 0) {
            this.l.g();
            TbSingleton.getInstance().shouldShowLocalChannelPostAnim = false;
        }
    }

    public void F(PublishProgressData publishProgressData) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, publishProgressData) == null) && (viewGroup = this.c) != null && viewGroup.getContext() != null) {
            if (this.i == null) {
                this.i = new PublishProgressView(this.c.getContext());
                this.c.addView(this.i, new FrameLayout.LayoutParams(-1, xi.g(this.c.getContext(), R.dimen.tbds83)));
            }
            this.i.c(publishProgressData);
        }
    }

    public final void r(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, viewGroup) == null) {
            this.c = viewGroup;
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) viewGroup.findViewById(R.id.obfuscated_res_0x7f09205f);
            this.e = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.a.getContext()));
            this.e.setFadingEdgeLength(0);
            this.e.setOverScrollMode(2);
            this.e.setOnSrollToBottomListener(this.t);
            this.e.addOnScrollListener(this.u);
            vz6 vz6Var = new vz6(this.c, this.e);
            this.s = vz6Var;
            vz6Var.p(this.a.E1());
            this.s.o(this.a.getPageContext());
            vy4 vy4Var = new vy4(this.a.getPageContext());
            this.g = vy4Var;
            vy4Var.f(this.b);
            this.e.setRecyclerListener(new d(this));
            PbListView pbListView = new PbListView(this.a.getPageContext().getPageActivity());
            this.f = pbListView;
            pbListView.b();
            this.f.p(R.color.transparent);
            this.f.t(xi.g(this.a.getPageContext().getPageActivity(), R.dimen.tbds182));
            this.f.y();
            this.f.H(R.dimen.tbfontsize33);
            this.f.F(SkinManager.getColor(R.color.CAM_X0107));
            this.f.B(R.color.CAM_X0110);
            this.f.s();
            this.f.C(this.v);
            if (this.d == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f09205e);
                this.d = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.g);
            }
            new qk6();
            SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(this.a.getContext());
            this.h = smartBubbleAnimatedView;
            smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, xi.g(this.a.getContext(), R.dimen.tbds83)));
            if (this.k == null) {
                kc8 kc8Var = new kc8(this.a.getPageContext(), this.e);
                this.k = kc8Var;
                kc8Var.p(2);
                this.k.u(this.a.getUniqueId());
            }
            this.q = (ViewGroup) viewGroup.findViewById(R.id.obfuscated_res_0x7f09211f);
            this.l = (PostAnimateFloatView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091a7c);
        }
    }

    public void s(ThreadData threadData) {
        HomePageTabFeedFragment homePageTabFeedFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, threadData) == null) && this.e != null && (homePageTabFeedFragment = this.a) != null && (homePageTabFeedFragment.C1() instanceof ChannelTabNetFeedModel) && !ListUtils.isEmpty(this.e.getData())) {
            ArrayList<wn> arrayList = (ArrayList) this.e.getData();
            int i = 0;
            while (true) {
                if (i < arrayList.size()) {
                    if (arrayList.get(i) instanceof vu4) {
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
            ArrayList<wn> c2 = e57.c(arrayList2);
            if (i != -1) {
                arrayList.addAll(i, c2);
            } else {
                arrayList.addAll(c2);
            }
            List<ThreadData> l = ((ChannelTabNetFeedModel) this.a.C1()).l();
            if (l != null) {
                l.add(0, threadData);
            }
            this.m.e(arrayList);
            this.m.d();
            u();
        }
    }

    public void w(int i) {
        f55 f;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048591, this, i) != null) || this.p == i) {
            return;
        }
        vy4 vy4Var = this.g;
        if (vy4Var != null) {
            vy4Var.H(i);
            f55 f2 = e57.f(this.a.E1());
            if (f2 != null) {
                this.g.K().setBackgroundColor(fn8.f(e57.d(f2)));
            }
        }
        if (this.r != null && (f = e57.f(this.a.E1())) != null) {
            this.r.c(e57.e(f));
        }
        PbListView pbListView = this.f;
        if (pbListView != null) {
            pbListView.F(SkinManager.getColor(R.color.CAM_X0107));
            this.f.d(i);
        }
        HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.j;
        if (homePageTabFeedHeaderView != null) {
            homePageTabFeedHeaderView.d(i);
        }
        f57 f57Var = this.m;
        if (f57Var != null) {
            f57Var.d();
        }
        u();
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
        vz6 vz6Var = this.s;
        if (vz6Var != null) {
            vz6Var.n();
        }
        this.p = i;
    }

    public void x(h67 h67Var) {
        PostAnimateFloatView postAnimateFloatView;
        int top;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, h67Var) == null) {
            B(false);
            if (h67Var != null && this.m != null && this.e != null && this.f != null) {
                this.o = h67Var.c;
                LuckyHeaderBannerView luckyHeaderBannerView = this.r;
                if (luckyHeaderBannerView != null && luckyHeaderBannerView.getParent() != null) {
                    this.e.removeHeaderView(this.r);
                    this.r = null;
                }
                if (h67Var.e == null && h67Var.f == null) {
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
                    this.j.setData(h67Var);
                }
                if (h67Var.b > 0) {
                    int firstVisiblePosition = this.e.getFirstVisiblePosition();
                    View childAt = this.e.getChildAt(0);
                    if (childAt == null) {
                        top = 0;
                    } else {
                        top = childAt.getTop();
                    }
                    RecyclerView.LayoutManager layoutManager = this.e.getLayoutManager();
                    int i = firstVisiblePosition - h67Var.b;
                    if (layoutManager instanceof LinearLayoutManager) {
                        this.e.z();
                        ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                        this.e.A();
                    }
                }
                this.m.e(h67Var.a);
                this.m.d();
                u();
                kc8 kc8Var = this.k;
                if (kc8Var != null) {
                    kc8Var.n(this.e.getFirstVisiblePosition(), this.e.getLastVisiblePosition(), false, true);
                }
                if (ImagesContract.LOCAL.equals(this.n) && (postAnimateFloatView = this.l) != null && postAnimateFloatView.getVisibility() != 0) {
                    this.l.setVisibility(0);
                    g57.n();
                }
            }
        }
    }
}
