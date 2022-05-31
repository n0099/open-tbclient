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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.PublishProgressView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import com.baidu.tieba.homepage.channel.model.ChannelTabNetFeedModel;
import com.baidu.tieba.homepage.tabfeed.HomePageTabFeedFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.gt4;
import com.repackage.gw5;
import com.repackage.j48;
import com.repackage.ji;
import com.repackage.jn;
import com.repackage.li;
import com.repackage.rp4;
import com.repackage.tx6;
import com.repackage.ty6;
import com.repackage.ux6;
import com.repackage.vx6;
import com.repackage.wy6;
import com.repackage.xx6;
import com.repackage.zc6;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class HomePageTabFeedView implements LifecycleObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public xx6 b;
    public ViewGroup c;
    public BdSwipeRefreshLayout d;
    public BdTypeRecyclerView e;
    public PbListView f;
    public gt4 g;
    public SmartBubbleAnimatedView h;
    public PublishProgressView i;
    public HomePageTabFeedHeaderView j;
    public j48 k;
    public PostAnimateFloatView l;
    public ux6 m;
    public String n;
    public boolean o;
    public int p;
    public ViewGroup q;
    public BdListView.p r;
    public RecyclerView.OnScrollListener s;
    public View.OnClickListener t;

    /* loaded from: classes3.dex */
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
                this.a.C();
            }
        }
    }

    /* loaded from: classes3.dex */
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
                gw5.b().c();
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
            }
        }
    }

    /* loaded from: classes3.dex */
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
                if (this.a.f == null || this.a.b == null || !ji.z()) {
                    return;
                }
                this.a.f.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.a.f.B(null);
                if (this.a.o) {
                    this.a.f.N();
                    this.a.b.c();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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

    public HomePageTabFeedView(HomePageTabFeedFragment homePageTabFeedFragment, xx6 xx6Var, ViewGroup viewGroup, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {homePageTabFeedFragment, xx6Var, viewGroup, str};
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
        this.r = new a(this);
        this.s = new b(this);
        this.t = new c(this);
        this.a = homePageTabFeedFragment;
        this.b = xx6Var;
        this.n = str;
        r(viewGroup);
        ux6 ux6Var = new ux6(homePageTabFeedFragment, this.e);
        this.m = ux6Var;
        ux6Var.g(str);
        A(false);
    }

    public void A(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (bdSwipeRefreshLayout = this.d) == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(z);
    }

    public void B(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (bdSwipeRefreshLayout = this.d) == null) {
            return;
        }
        bdSwipeRefreshLayout.setVisibility(z ? 0 : 8);
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f == null || this.b == null) {
            return;
        }
        if (ji.z()) {
            this.e.setNextPage(this.f);
            this.f.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f.B(null);
            if (this.o) {
                this.f.N();
                this.b.c();
                return;
            }
            this.f.C(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09f3));
            this.f.f();
            return;
        }
        this.e.setNextPage(null);
    }

    public void D() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bdTypeRecyclerView = this.e) == null) {
            return;
        }
        bdTypeRecyclerView.scrollToPosition(0);
    }

    public void E(PublishProgressData publishProgressData) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, publishProgressData) == null) || (viewGroup = this.c) == null || viewGroup.getContext() == null) {
            return;
        }
        if (this.i == null) {
            this.i = new PublishProgressView(this.c.getContext());
            this.c.addView(this.i, new FrameLayout.LayoutParams(-1, li.f(this.c.getContext(), R.dimen.tbds83)));
        }
        this.i.c(publishProgressData);
    }

    public final void o() {
        PostAnimateFloatView postAnimateFloatView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && "local".equals(this.n) && TbSingleton.getInstance().shouldShowLocalChannelPostAnim) {
            jn C = this.e.C(this.e.getFirstVisiblePosition() - 1);
            if (C != null && C.getType() == ThreadData.TYPE_USER_NORMAL && (postAnimateFloatView = this.l) != null && postAnimateFloatView.getVisibility() == 0) {
                this.l.g();
                TbSingleton.getInstance().shouldShowLocalChannelPostAnim = false;
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            j48 j48Var = this.k;
            if (j48Var != null) {
                j48Var.h();
            }
            gt4 gt4Var = this.g;
            if (gt4Var != null) {
                gt4Var.e(null);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.l : (PostAnimateFloatView) invokeV.objValue;
    }

    public BdTypeRecyclerView q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.e : (BdTypeRecyclerView) invokeV.objValue;
    }

    public final void r(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, viewGroup) == null) {
            this.c = viewGroup;
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091e2d);
            this.e = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.a.getContext()));
            this.e.setFadingEdgeLength(0);
            this.e.setOverScrollMode(2);
            this.e.setOnSrollToBottomListener(this.r);
            this.e.addOnScrollListener(this.s);
            gt4 gt4Var = new gt4(this.a.getPageContext());
            this.g = gt4Var;
            gt4Var.e(this.b);
            this.e.setRecyclerListener(new d(this));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.e.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            PbListView pbListView = new PbListView(this.a.getPageContext().getPageActivity());
            this.f = pbListView;
            pbListView.b();
            this.f.p(R.color.transparent);
            this.f.t(li.f(this.a.getPageContext().getPageActivity(), R.dimen.tbds182));
            this.f.x();
            this.f.G(R.dimen.tbfontsize33);
            this.f.E(SkinManager.getColor(R.color.CAM_X0107));
            this.f.A(R.color.CAM_X0110);
            this.f.s();
            this.f.B(this.t);
            if (this.d == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f091e2c);
                this.d = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.g);
            }
            new zc6();
            SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(this.a.getContext());
            this.h = smartBubbleAnimatedView;
            smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, li.f(this.a.getContext(), R.dimen.tbds83)));
            if (this.k == null) {
                this.k = new j48(this.a.getPageContext(), this.e);
                if (UbsABTestHelper.isFeedVideoAutoPlayABTest()) {
                    this.k.p(2);
                } else {
                    this.k.p(1);
                }
                this.k.u(this.a.getUniqueId());
            }
            this.q = (ViewGroup) viewGroup.findViewById(R.id.obfuscated_res_0x7f091ede);
            this.l = (PostAnimateFloatView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0918ac);
        }
    }

    public void s(ThreadData threadData) {
        HomePageTabFeedFragment homePageTabFeedFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, threadData) == null) || this.e == null || (homePageTabFeedFragment = this.a) == null || !(homePageTabFeedFragment.P0() instanceof ChannelTabNetFeedModel) || ListUtils.isEmpty(this.e.getData())) {
            return;
        }
        ArrayList<jn> arrayList = (ArrayList) this.e.getData();
        int i = 0;
        while (true) {
            if (i >= arrayList.size()) {
                i = -1;
                break;
            } else if (arrayList.get(i) instanceof rp4) {
                break;
            } else {
                i++;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(threadData);
        ArrayList<jn> c2 = tx6.c(arrayList2);
        if (i != -1) {
            arrayList.addAll(i, c2);
        } else {
            arrayList.addAll(c2);
        }
        List<ThreadData> k = ((ChannelTabNetFeedModel) this.a.P0()).k();
        if (k != null) {
            k.add(0, threadData);
        }
        this.m.e(arrayList);
        this.m.d();
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.e;
            return bdTypeRecyclerView == null || bdTypeRecyclerView.getChildCount() == 0 || this.e.getChildAt(0).getTop() == 0;
        }
        return invokeV.booleanValue;
    }

    public void u() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (bdTypeRecyclerView = this.e) == null || bdTypeRecyclerView.getCount() == 0) {
            return;
        }
        if (this.e.C(0) instanceof ty6) {
            this.e.E(0);
        }
        ux6 ux6Var = this.m;
        if (ux6Var != null) {
            ux6Var.f(false);
        }
    }

    public void v(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i) == null) || this.p == i) {
            return;
        }
        gt4 gt4Var = this.g;
        if (gt4Var != null) {
            gt4Var.H(i);
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
        ux6 ux6Var = this.m;
        if (ux6Var != null) {
            ux6Var.d();
        }
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
        this.p = i;
    }

    public void w(wy6 wy6Var) {
        PostAnimateFloatView postAnimateFloatView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, wy6Var) == null) {
            A(false);
            if (wy6Var == null || this.m == null || this.e == null || this.f == null) {
                return;
            }
            this.o = wy6Var.c;
            if (wy6Var.e == null && wy6Var.f == null) {
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
                this.j.setData(wy6Var);
            }
            if (wy6Var.b > 0) {
                int firstVisiblePosition = this.e.getFirstVisiblePosition();
                View childAt = this.e.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.e.getLayoutManager();
                int i = firstVisiblePosition - wy6Var.b;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.e.A();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                    this.e.B();
                }
            }
            this.m.e(wy6Var.a);
            this.m.d();
            j48 j48Var = this.k;
            if (j48Var != null) {
                j48Var.n(this.e.getFirstVisiblePosition(), this.e.getLastVisiblePosition(), false, true);
            }
            if (!"local".equals(this.n) || (postAnimateFloatView = this.l) == null || postAnimateFloatView.getVisibility() == 0) {
                return;
            }
            this.l.setVisibility(0);
            vx6.l();
        }
    }

    public void x() {
        j48 j48Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (j48Var = this.k) == null) {
            return;
        }
        j48Var.y();
        this.k.r(false);
    }

    public void y() {
        gt4 gt4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (gt4Var = this.g) != null && gt4Var.K() == null) {
            this.g.e(this.b);
        }
    }

    public void z() {
        j48 j48Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (j48Var = this.k) == null) {
            return;
        }
        j48Var.r(true);
        BdTypeRecyclerView bdTypeRecyclerView = this.e;
        if (bdTypeRecyclerView != null) {
            this.k.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.e.getLastVisiblePosition(), false, true);
        }
    }
}
