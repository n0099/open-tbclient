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
import c.a.o0.r.l0.g;
import c.a.o0.r.r.a2;
import c.a.p0.c3.k;
import c.a.p0.f1.d1;
import c.a.p0.h0.u;
import c.a.p0.q1.k.e;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class HomePageTabFeedView implements LifecycleObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;

    /* renamed from: b  reason: collision with root package name */
    public e f33470b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f33471c;

    /* renamed from: d  reason: collision with root package name */
    public BdSwipeRefreshLayout f33472d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeRecyclerView f33473e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f33474f;

    /* renamed from: g  reason: collision with root package name */
    public g f33475g;

    /* renamed from: h  reason: collision with root package name */
    public SmartBubbleAnimatedView f33476h;
    public PublishProgressView i;
    public HomePageTabFeedHeaderView j;
    public k k;
    public PostAnimateFloatView l;
    public c.a.p0.q1.k.b m;
    public String n;
    public boolean o;
    public int p;
    public ViewGroup q;
    public BdListView.p r;
    public RecyclerView.OnScrollListener s;
    public View.OnClickListener t;

    /* loaded from: classes5.dex */
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
                if (this.a.f33473e != null) {
                    this.a.f33473e.stopScroll();
                }
                this.a.u();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedView f33477b;

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
            this.f33477b = homePageTabFeedView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) && i == 0) {
                if (this.f33477b.k != null) {
                    this.f33477b.k.n(this.f33477b.f33473e.getFirstVisiblePosition(), this.f33477b.f33473e.getLastVisiblePosition(), this.a, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(true ^ this.f33477b.l())));
                u.b().c();
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
                this.f33477b.g();
            }
        }
    }

    /* loaded from: classes5.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a.f33473e != null) {
                    this.a.f33473e.stopScroll();
                }
                if (this.a.f33474f == null || this.a.f33470b == null || !l.z()) {
                    return;
                }
                this.a.f33474f.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.a.f33474f.C(null);
                if (this.a.o) {
                    this.a.f33474f.O();
                    this.a.f33470b.e();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || (view = viewHolder.itemView) == null || this.a.k == null) {
                return;
            }
            this.a.k.k(view);
        }
    }

    public HomePageTabFeedView(HomePageTabFeedFragment homePageTabFeedFragment, e eVar, ViewGroup viewGroup, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {homePageTabFeedFragment, eVar, viewGroup, str};
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
        this.f33470b = eVar;
        this.n = str;
        j(viewGroup);
        c.a.p0.q1.k.b bVar = new c.a.p0.q1.k.b(homePageTabFeedFragment, this.f33473e);
        this.m = bVar;
        bVar.g(str);
        s(false);
    }

    public final void g() {
        PostAnimateFloatView postAnimateFloatView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && "local".equals(this.n) && TbSingleton.getInstance().shouldShowLocalChannelPostAnim) {
            n C = this.f33473e.C(this.f33473e.getFirstVisiblePosition() - 1);
            if (C != null && C.getType() == ThreadData.TYPE_USER_NORMAL && (postAnimateFloatView = this.l) != null && postAnimateFloatView.getVisibility() == 0) {
                this.l.g();
                TbSingleton.getInstance().shouldShowLocalChannelPostAnim = false;
            }
        }
    }

    public PostAnimateFloatView h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : (PostAnimateFloatView) invokeV.objValue;
    }

    public BdTypeRecyclerView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33473e : (BdTypeRecyclerView) invokeV.objValue;
    }

    public final void j(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, viewGroup) == null) {
            this.f33471c = viewGroup;
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091e42);
            this.f33473e = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.a.getContext()));
            this.f33473e.setFadingEdgeLength(0);
            this.f33473e.setOverScrollMode(2);
            this.f33473e.setOnSrollToBottomListener(this.r);
            this.f33473e.addOnScrollListener(this.s);
            g gVar = new g(this.a.getPageContext());
            this.f33475g = gVar;
            gVar.f(this.f33470b);
            this.f33473e.setRecyclerListener(new d(this));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.f33473e.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            PbListView pbListView = new PbListView(this.a.getPageContext().getPageActivity());
            this.f33474f = pbListView;
            pbListView.b();
            this.f33474f.p(R.color.transparent);
            this.f33474f.t(c.a.d.f.p.n.f(this.a.getPageContext().getPageActivity(), R.dimen.tbds182));
            this.f33474f.y();
            this.f33474f.H(R.dimen.tbfontsize33);
            this.f33474f.F(SkinManager.getColor(R.color.CAM_X0107));
            this.f33474f.B(R.color.CAM_X0110);
            this.f33474f.s();
            this.f33474f.C(this.t);
            if (this.f33472d == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f091e41);
                this.f33472d = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.f33475g);
            }
            new d1();
            SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(this.a.getContext());
            this.f33476h = smartBubbleAnimatedView;
            smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, c.a.d.f.p.n.f(this.a.getContext(), R.dimen.tbds83)));
            if (this.k == null) {
                this.k = new k(this.a.getPageContext(), this.f33473e);
                if (UbsABTestHelper.isFeedVideoAutoPlayABTest()) {
                    this.k.p(2);
                } else {
                    this.k.p(1);
                }
                this.k.u(this.a.getUniqueId());
            }
            this.q = (ViewGroup) viewGroup.findViewById(R.id.obfuscated_res_0x7f091ef3);
            this.l = (PostAnimateFloatView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0918ab);
        }
    }

    public void k(ThreadData threadData) {
        HomePageTabFeedFragment homePageTabFeedFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, threadData) == null) || this.f33473e == null || (homePageTabFeedFragment = this.a) == null || !(homePageTabFeedFragment.N0() instanceof ChannelTabNetFeedModel) || ListUtils.isEmpty(this.f33473e.getData())) {
            return;
        }
        ArrayList<n> arrayList = (ArrayList) this.f33473e.getData();
        int i = 0;
        while (true) {
            if (i >= arrayList.size()) {
                i = -1;
                break;
            } else if (arrayList.get(i) instanceof a2) {
                break;
            } else {
                i++;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(threadData);
        ArrayList<n> c2 = c.a.p0.q1.k.a.c(arrayList2);
        if (i != -1) {
            arrayList.addAll(i, c2);
        } else {
            arrayList.addAll(c2);
        }
        List<ThreadData> k = ((ChannelTabNetFeedModel) this.a.N0()).k();
        if (k != null) {
            k.add(0, threadData);
        }
        this.m.e(arrayList);
        this.m.d();
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f33473e;
            return bdTypeRecyclerView == null || bdTypeRecyclerView.getChildCount() == 0 || this.f33473e.getChildAt(0).getTop() == 0;
        }
        return invokeV.booleanValue;
    }

    public void m() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (bdTypeRecyclerView = this.f33473e) == null || bdTypeRecyclerView.getCount() == 0) {
            return;
        }
        if (this.f33473e.C(0) instanceof c.a.p0.q1.k.h.a) {
            this.f33473e.E(0);
        }
        c.a.p0.q1.k.b bVar = this.m;
        if (bVar != null) {
            bVar.f(false);
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || this.p == i) {
            return;
        }
        g gVar = this.f33475g;
        if (gVar != null) {
            gVar.H(i);
        }
        PbListView pbListView = this.f33474f;
        if (pbListView != null) {
            pbListView.F(SkinManager.getColor(R.color.CAM_X0107));
            this.f33474f.d(i);
        }
        HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.j;
        if (homePageTabFeedHeaderView != null) {
            homePageTabFeedHeaderView.d(i);
        }
        c.a.p0.q1.k.b bVar = this.m;
        if (bVar != null) {
            bVar.d();
        }
        SmartBubbleAnimatedView smartBubbleAnimatedView = this.f33476h;
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

    public void o(c.a.p0.q1.k.h.d dVar) {
        PostAnimateFloatView postAnimateFloatView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) {
            s(false);
            if (dVar == null || this.m == null || this.f33473e == null || this.f33474f == null) {
                return;
            }
            this.o = dVar.f17522c;
            if (dVar.f17524e == null && dVar.f17525f == null) {
                HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.j;
                if (homePageTabFeedHeaderView != null && homePageTabFeedHeaderView.getParent() != null) {
                    this.f33473e.removeHeaderView(this.j);
                    this.j = null;
                }
            } else {
                if (this.j == null) {
                    HomePageTabFeedHeaderView homePageTabFeedHeaderView2 = new HomePageTabFeedHeaderView(this.a.getContext());
                    this.j = homePageTabFeedHeaderView2;
                    homePageTabFeedHeaderView2.setTabCode(this.n);
                    this.f33473e.s(this.j);
                }
                this.j.setData(dVar);
            }
            if (dVar.f17521b > 0) {
                int firstVisiblePosition = this.f33473e.getFirstVisiblePosition();
                View childAt = this.f33473e.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.f33473e.getLayoutManager();
                int i = firstVisiblePosition - dVar.f17521b;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.f33473e.A();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                    this.f33473e.B();
                }
            }
            this.m.e(dVar.a);
            this.m.d();
            k kVar = this.k;
            if (kVar != null) {
                kVar.n(this.f33473e.getFirstVisiblePosition(), this.f33473e.getLastVisiblePosition(), false, true);
            }
            if (!"local".equals(this.n) || (postAnimateFloatView = this.l) == null || postAnimateFloatView.getVisibility() == 0) {
                return;
            }
            this.l.setVisibility(0);
            c.a.p0.q1.k.c.l();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            k kVar = this.k;
            if (kVar != null) {
                kVar.h();
            }
            g gVar = this.f33475g;
            if (gVar != null) {
                gVar.f(null);
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

    public void p() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (kVar = this.k) == null) {
            return;
        }
        kVar.y();
        this.k.r(false);
    }

    public void q() {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (gVar = this.f33475g) != null && gVar.K() == null) {
            this.f33475g.f(this.f33470b);
        }
    }

    public void r() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (kVar = this.k) == null) {
            return;
        }
        kVar.r(true);
        BdTypeRecyclerView bdTypeRecyclerView = this.f33473e;
        if (bdTypeRecyclerView != null) {
            this.k.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.f33473e.getLastVisiblePosition(), false, true);
        }
    }

    public void s(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (bdSwipeRefreshLayout = this.f33472d) == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(z);
    }

    public void t(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || (bdSwipeRefreshLayout = this.f33472d) == null) {
            return;
        }
        bdSwipeRefreshLayout.setVisibility(z ? 0 : 8);
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.f33474f == null || this.f33470b == null) {
            return;
        }
        if (l.z()) {
            this.f33473e.setNextPage(this.f33474f);
            this.f33474f.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f33474f.C(null);
            if (this.o) {
                this.f33474f.O();
                this.f33470b.e();
                return;
            }
            this.f33474f.D(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09e6));
            this.f33474f.f();
            return;
        }
        this.f33473e.setNextPage(null);
    }

    public void v() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (bdTypeRecyclerView = this.f33473e) == null) {
            return;
        }
        bdTypeRecyclerView.scrollToPosition(0);
    }

    public void w(PublishProgressData publishProgressData) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, publishProgressData) == null) || (viewGroup = this.f33471c) == null || viewGroup.getContext() == null) {
            return;
        }
        if (this.i == null) {
            this.i = new PublishProgressView(this.f33471c.getContext());
            this.f33471c.addView(this.i, new FrameLayout.LayoutParams(-1, c.a.d.f.p.n.f(this.f33471c.getContext(), R.dimen.tbds83)));
        }
        this.i.c(publishProgressData);
    }
}
