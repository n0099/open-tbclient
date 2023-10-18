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
import com.baidu.adp.lib.util.BdUtilHelper;
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
import com.baidu.tieba.c38;
import com.baidu.tieba.c48;
import com.baidu.tieba.cx7;
import com.baidu.tieba.d38;
import com.baidu.tieba.e38;
import com.baidu.tieba.f48;
import com.baidu.tieba.g38;
import com.baidu.tieba.homepage.channel.model.ChannelTabNetFeedModel;
import com.baidu.tieba.homepage.tabfeed.HomePageTabFeedFragment;
import com.baidu.tieba.m45;
import com.baidu.tieba.py4;
import com.baidu.tieba.qv9;
import com.baidu.tieba.tj6;
import com.baidu.tieba.yh;
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
    public g38 b;
    public ViewGroup c;
    public BdSwipeRefreshLayout d;
    public BdTypeRecyclerView e;
    public PbListView f;
    public m45 g;
    public PublishProgressView h;
    public HomePageTabFeedHeaderView i;
    public qv9 j;
    public PostAnimateFloatView k;
    public d38 l;
    public String m;
    public boolean n;
    public int o;
    public ViewGroup p;
    public cx7 q;
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
                this.a.M();
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
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(true ^ this.b.B())));
                tj6.b().c();
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
                        this.a.b.k();
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

    public HomePageTabFeedView(HomePageTabFeedFragment homePageTabFeedFragment, g38 g38Var, ViewGroup viewGroup, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {homePageTabFeedFragment, g38Var, viewGroup, str};
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
        this.b = g38Var;
        this.m = str;
        v(viewGroup);
        d38 d38Var = new d38(homePageTabFeedFragment, this.e);
        this.l = d38Var;
        d38Var.g(str);
        J(false);
    }

    public void J(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (bdSwipeRefreshLayout = this.d) != null) {
            bdSwipeRefreshLayout.setRefreshing(z);
        }
    }

    public void L(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
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

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.e;
            if (bdTypeRecyclerView == null || bdTypeRecyclerView.getChildCount() == 0 || this.e.getChildAt(0).getTop() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void C() {
        cx7 cx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (cx7Var = this.q) != null) {
            cx7Var.f();
        }
    }

    public void D() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (bdTypeRecyclerView = this.e) != null && bdTypeRecyclerView.getCount() != 0) {
            if (this.e.getItem(0) instanceof c48) {
                this.e.removeItem(0);
            }
            d38 d38Var = this.l;
            if (d38Var != null) {
                d38Var.f(false);
            }
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            qv9 qv9Var = this.j;
            if (qv9Var != null) {
                qv9Var.z();
                this.j.r(false);
            }
            HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.i;
            if (homePageTabFeedHeaderView != null) {
                homePageTabFeedHeaderView.f();
            }
        }
    }

    public void H() {
        m45 m45Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (m45Var = this.g) != null && m45Var.G() == null) {
            this.g.a(this.b);
        }
    }

    public void N() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (bdTypeRecyclerView = this.e) != null) {
            bdTypeRecyclerView.scrollToPosition(0);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            qv9 qv9Var = this.j;
            if (qv9Var != null) {
                qv9Var.h();
                this.j.v(null);
            }
            m45 m45Var = this.g;
            if (m45Var != null) {
                m45Var.a(null);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.k;
        }
        return (PostAnimateFloatView) invokeV.objValue;
    }

    public BdTypeRecyclerView s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.e;
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public void E(f48 f48Var) {
        PostAnimateFloatView postAnimateFloatView;
        int top;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, f48Var) == null) {
            J(false);
            if (f48Var != null && this.l != null && this.e != null && this.f != null) {
                this.n = f48Var.c;
                if (f48Var.e == null && f48Var.f == null) {
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
                    this.i.setData(f48Var);
                }
                if (f48Var.b > 0) {
                    int firstVisiblePosition = this.e.getFirstVisiblePosition();
                    View childAt = this.e.getChildAt(0);
                    if (childAt == null) {
                        top = 0;
                    } else {
                        top = childAt.getTop();
                    }
                    RecyclerView.LayoutManager layoutManager = this.e.getLayoutManager();
                    int i = firstVisiblePosition - f48Var.b;
                    if (layoutManager instanceof LinearLayoutManager) {
                        this.e.startInterceptLayout();
                        ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                        this.e.stopIntercerceptLayout();
                    }
                }
                this.l.e(f48Var.a);
                this.l.d();
                C();
                qv9 qv9Var = this.j;
                if (qv9Var != null) {
                    qv9Var.n(this.e.getFirstVisiblePosition(), this.e.getLastVisiblePosition(), false, true);
                }
                if ("local".equals(this.m) && (postAnimateFloatView = this.k) != null && postAnimateFloatView.getVisibility() != 0) {
                    this.k.setVisibility(0);
                    e38.n();
                }
            }
        }
    }

    public final void v(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, viewGroup) == null) {
            this.c = viewGroup;
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) viewGroup.findViewById(R.id.obfuscated_res_0x7f09238f);
            this.e = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.a.getContext()));
            this.e.setFadingEdgeLength(0);
            this.e.setOverScrollMode(2);
            this.e.setOnSrollToBottomListener(this.r);
            this.e.addOnScrollListener(this.s);
            cx7 cx7Var = new cx7(this.c, this.e);
            this.q = cx7Var;
            cx7Var.q(this.a.p2());
            this.q.p(this.a.getPageContext());
            m45 m45Var = new m45(this.a.getPageContext());
            this.g = m45Var;
            m45Var.a(this.b);
            this.e.setRecyclerListener(new d(this));
            PbListView pbListView = new PbListView(this.a.getPageContext().getPageActivity());
            this.f = pbListView;
            pbListView.c();
            this.f.s(R.color.transparent);
            this.f.w(BdUtilHelper.getDimens(this.a.getPageContext().getPageActivity(), R.dimen.tbds182));
            this.f.B();
            this.f.L(R.dimen.tbfontsize33);
            this.f.J(SkinManager.getColor(R.color.CAM_X0107));
            this.f.F(R.color.CAM_X0110);
            this.f.v();
            this.f.G(this.t);
            if (this.d == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f09238e);
                this.d = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.g);
            }
            if (this.j == null) {
                qv9 qv9Var = new qv9(this.a.getPageContext(), this.e);
                this.j = qv9Var;
                qv9Var.p(2);
                this.j.u(this.a.getUniqueId());
            }
            this.p = (ViewGroup) viewGroup.findViewById(R.id.obfuscated_res_0x7f092463);
            this.k = (PostAnimateFloatView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091d2a);
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            qv9 qv9Var = this.j;
            if (qv9Var != null) {
                qv9Var.r(true);
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

    public void M() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.f != null && this.b != null) {
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                this.e.setNextPage(this.f);
                this.f.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.f.G(null);
                if (this.n) {
                    this.f.R();
                    this.b.k();
                    return;
                }
                this.f.H(this.a.getResources().getString(R.string.list_has_no_more));
                this.f.g();
                return;
            }
            this.e.setNextPage(null);
        }
    }

    public final void o() {
        PostAnimateFloatView postAnimateFloatView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || !"local".equals(this.m) || !TbSingleton.getInstance().shouldShowLocalChannelPostAnim) {
            return;
        }
        yh item = this.e.getItem(this.e.getFirstVisiblePosition() - 1);
        if (item != null && item.getType() == ThreadData.TYPE_USER_NORMAL && (postAnimateFloatView = this.k) != null && postAnimateFloatView.getVisibility() == 0) {
            this.k.g();
            TbSingleton.getInstance().shouldShowLocalChannelPostAnim = false;
        }
    }

    public void O(PublishProgressData publishProgressData) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, publishProgressData) == null) && (viewGroup = this.c) != null && viewGroup.getContext() != null) {
            if (this.h == null) {
                this.h = new PublishProgressView(this.c.getContext());
                this.c.addView(this.h, new FrameLayout.LayoutParams(-1, BdUtilHelper.getDimens(this.c.getContext(), R.dimen.tbds83)));
            }
            this.h.c(publishProgressData);
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048589, this, i) != null) || this.o == i) {
            return;
        }
        m45 m45Var = this.g;
        if (m45Var != null) {
            m45Var.D(i);
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
        d38 d38Var = this.l;
        if (d38Var != null) {
            d38Var.d();
        }
        C();
        PublishProgressView publishProgressView = this.h;
        if (publishProgressView != null) {
            publishProgressView.b();
        }
        PostAnimateFloatView postAnimateFloatView = this.k;
        if (postAnimateFloatView != null) {
            postAnimateFloatView.onChangeSkinType(this.a.getPageContext(), i);
        }
        cx7 cx7Var = this.q;
        if (cx7Var != null) {
            cx7Var.o();
        }
        this.o = i;
    }

    public void w(ThreadData threadData) {
        HomePageTabFeedFragment homePageTabFeedFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, threadData) == null) && this.e != null && (homePageTabFeedFragment = this.a) != null && (homePageTabFeedFragment.n2() instanceof ChannelTabNetFeedModel) && !ListUtils.isEmpty(this.e.getData())) {
            ArrayList<yh> arrayList = (ArrayList) this.e.getData();
            int i = 0;
            while (true) {
                if (i < arrayList.size()) {
                    if (arrayList.get(i) instanceof py4) {
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
            ArrayList<yh> c2 = c38.c(arrayList2);
            if (i != -1) {
                arrayList.addAll(i, c2);
            } else {
                arrayList.addAll(c2);
            }
            List<ThreadData> q = ((ChannelTabNetFeedModel) this.a.n2()).q();
            if (q != null) {
                q.add(0, threadData);
            }
            this.l.e(arrayList);
            this.l.d();
            C();
        }
    }
}
