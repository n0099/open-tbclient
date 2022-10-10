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
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PublishProgressData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.PublishProgressView;
import com.baidu.tieba.Cdo;
import com.baidu.tieba.R;
import com.baidu.tieba.b26;
import com.baidu.tieba.bu4;
import com.baidu.tieba.ej;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import com.baidu.tieba.fy6;
import com.baidu.tieba.g45;
import com.baidu.tieba.homepage.channel.model.ChannelTabNetFeedModel;
import com.baidu.tieba.homepage.tabfeed.HomePageTabFeedFragment;
import com.baidu.tieba.m37;
import com.baidu.tieba.m47;
import com.baidu.tieba.n37;
import com.baidu.tieba.o37;
import com.baidu.tieba.ol8;
import com.baidu.tieba.p47;
import com.baidu.tieba.q37;
import com.baidu.tieba.qa8;
import com.baidu.tieba.zi6;
import com.baidu.tieba.zx4;
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
    public q37 b;
    public ViewGroup c;
    public BdSwipeRefreshLayout d;
    public BdTypeRecyclerView e;
    public PbListView f;
    public zx4 g;
    public SmartBubbleAnimatedView h;
    public PublishProgressView i;
    public HomePageTabFeedHeaderView j;
    public qa8 k;
    public PostAnimateFloatView l;
    public n37 m;
    public String n;
    public boolean o;
    public int p;
    public ViewGroup q;
    public LuckyHeaderBannerView r;
    public fy6 s;
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
                b26.b().c();
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
                if (this.a.f == null || this.a.b == null || !BdNetTypeUtil.isNetWorkAvailable()) {
                    return;
                }
                this.a.f.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.a.f.C(null);
                if (this.a.o) {
                    this.a.f.O();
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
        public final /* synthetic */ g45 a;
        public final /* synthetic */ HomePageTabFeedView b;

        public e(HomePageTabFeedView homePageTabFeedView, g45 g45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedView, g45Var};
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
            this.a = g45Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.b.v()) {
                    o37.e(this.b.a.E1());
                }
                UrlManager.getInstance().dealOneLink(this.b.a.getPageContext(), new String[]{this.a.g()});
            }
        }
    }

    public HomePageTabFeedView(HomePageTabFeedFragment homePageTabFeedFragment, q37 q37Var, ViewGroup viewGroup, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {homePageTabFeedFragment, q37Var, viewGroup, str};
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
        this.b = q37Var;
        this.n = str;
        t(viewGroup);
        n37 n37Var = new n37(homePageTabFeedFragment, this.e);
        this.m = n37Var;
        n37Var.g(str);
        E(false);
    }

    public void A(p47 p47Var) {
        PostAnimateFloatView postAnimateFloatView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, p47Var) == null) {
            E(false);
            if (p47Var == null || this.m == null || this.e == null || this.f == null) {
                return;
            }
            this.o = p47Var.c;
            g45 f = m37.f(this.a.E1());
            if (f != null && !UbsABTestHelper.isHomeTabModifyABTestA()) {
                if (this.r == null) {
                    LuckyHeaderBannerView luckyHeaderBannerView = new LuckyHeaderBannerView(this.a.getContext());
                    this.r = luckyHeaderBannerView;
                    luckyHeaderBannerView.setClickCallback(new e(this, f));
                    this.e.s(this.r);
                    if (v()) {
                        o37.l(this.a.E1());
                    }
                }
                this.r.c(m37.e(f));
            } else {
                LuckyHeaderBannerView luckyHeaderBannerView2 = this.r;
                if (luckyHeaderBannerView2 != null && luckyHeaderBannerView2.getParent() != null) {
                    this.e.removeHeaderView(this.r);
                    this.r = null;
                }
            }
            if (p47Var.e == null && p47Var.f == null) {
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
                this.j.setData(p47Var);
            }
            if (p47Var.b > 0) {
                int firstVisiblePosition = this.e.getFirstVisiblePosition();
                View childAt = this.e.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.e.getLayoutManager();
                int i = firstVisiblePosition - p47Var.b;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.e.z();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                    this.e.A();
                }
            }
            this.m.e(p47Var.a);
            this.m.d();
            x();
            qa8 qa8Var = this.k;
            if (qa8Var != null) {
                qa8Var.n(this.e.getFirstVisiblePosition(), this.e.getLastVisiblePosition(), false, true);
            }
            if (!ImagesContract.LOCAL.equals(this.n) || (postAnimateFloatView = this.l) == null || postAnimateFloatView.getVisibility() == 0) {
                return;
            }
            this.l.setVisibility(0);
            o37.n();
        }
    }

    public void B() {
        qa8 qa8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (qa8Var = this.k) == null) {
            return;
        }
        qa8Var.y();
        this.k.r(false);
    }

    public void C() {
        zx4 zx4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (zx4Var = this.g) != null && zx4Var.L() == null) {
            this.g.f(this.b);
        }
    }

    public void D() {
        qa8 qa8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (qa8Var = this.k) == null) {
            return;
        }
        qa8Var.r(true);
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
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.e.setNextPage(this.f);
            this.f.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f.C(null);
            if (this.o) {
                this.f.O();
                this.b.i();
                return;
            }
            this.f.D(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09ff));
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
            this.c.addView(this.i, new FrameLayout.LayoutParams(-1, ej.f(this.c.getContext(), R.dimen.tbds83)));
        }
        this.i.c(publishProgressData);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            qa8 qa8Var = this.k;
            if (qa8Var != null) {
                qa8Var.h();
            }
            zx4 zx4Var = this.g;
            if (zx4Var != null) {
                zx4Var.f(null);
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
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && ImagesContract.LOCAL.equals(this.n) && TbSingleton.getInstance().shouldShowLocalChannelPostAnim) {
            Cdo B = this.e.B(this.e.getFirstVisiblePosition() - 1);
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
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) viewGroup.findViewById(R.id.obfuscated_res_0x7f092015);
            this.e = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.a.getContext()));
            this.e.setFadingEdgeLength(0);
            this.e.setOverScrollMode(2);
            this.e.setOnSrollToBottomListener(this.t);
            this.e.addOnScrollListener(this.u);
            fy6 fy6Var = new fy6(this.c, this.e);
            this.s = fy6Var;
            fy6Var.p(this.a.E1());
            this.s.o(this.a.getPageContext());
            zx4 zx4Var = new zx4(this.a.getPageContext());
            this.g = zx4Var;
            zx4Var.f(this.b);
            this.e.setRecyclerListener(new d(this));
            PbListView pbListView = new PbListView(this.a.getPageContext().getPageActivity());
            this.f = pbListView;
            pbListView.b();
            this.f.p(R.color.transparent);
            this.f.t(ej.f(this.a.getPageContext().getPageActivity(), R.dimen.tbds182));
            this.f.y();
            this.f.H(R.dimen.tbfontsize33);
            this.f.F(SkinManager.getColor(R.color.CAM_X0107));
            this.f.B(R.color.CAM_X0110);
            this.f.s();
            this.f.C(this.v);
            if (this.d == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f092014);
                this.d = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.g);
            }
            new zi6();
            SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(this.a.getContext());
            this.h = smartBubbleAnimatedView;
            smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, ej.f(this.a.getContext(), R.dimen.tbds83)));
            if (this.k == null) {
                qa8 qa8Var = new qa8(this.a.getPageContext(), this.e);
                this.k = qa8Var;
                qa8Var.p(2);
                this.k.u(this.a.getUniqueId());
            }
            this.q = (ViewGroup) viewGroup.findViewById(R.id.obfuscated_res_0x7f0920cd);
            this.l = (PostAnimateFloatView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091a3c);
        }
    }

    public void u(ThreadData threadData) {
        HomePageTabFeedFragment homePageTabFeedFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, threadData) == null) || this.e == null || (homePageTabFeedFragment = this.a) == null || !(homePageTabFeedFragment.C1() instanceof ChannelTabNetFeedModel) || ListUtils.isEmpty(this.e.getData())) {
            return;
        }
        ArrayList<Cdo> arrayList = (ArrayList) this.e.getData();
        int i = 0;
        while (true) {
            if (i >= arrayList.size()) {
                i = -1;
                break;
            } else if (arrayList.get(i) instanceof bu4) {
                break;
            } else {
                i++;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(threadData);
        ArrayList<Cdo> c2 = m37.c(arrayList2);
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
        x();
    }

    public final boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.a.getResources().getString(R.string.obfuscated_res_0x7f0f136d).equals(this.a.E1()) || this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1370).equals(this.a.E1()) : invokeV.booleanValue;
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
        fy6 fy6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (fy6Var = this.s) == null) {
            return;
        }
        fy6Var.f();
    }

    public void y() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (bdTypeRecyclerView = this.e) == null || bdTypeRecyclerView.getCount() == 0) {
            return;
        }
        if (this.e.B(0) instanceof m47) {
            this.e.D(0);
        }
        n37 n37Var = this.m;
        if (n37Var != null) {
            n37Var.f(false);
        }
    }

    public void z(int i) {
        g45 f;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i) == null) || this.p == i) {
            return;
        }
        zx4 zx4Var = this.g;
        if (zx4Var != null) {
            zx4Var.H(i);
            g45 f2 = m37.f(this.a.E1());
            if (f2 != null) {
                this.g.K().setBackgroundColor(ol8.f(m37.d(f2)));
            }
        }
        if (this.r != null && (f = m37.f(this.a.E1())) != null) {
            this.r.c(m37.e(f));
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
        n37 n37Var = this.m;
        if (n37Var != null) {
            n37Var.d();
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
        fy6 fy6Var = this.s;
        if (fy6Var != null) {
            fy6Var.n();
        }
        this.p = i;
    }
}
