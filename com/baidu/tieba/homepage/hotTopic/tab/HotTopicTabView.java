package com.baidu.tieba.homepage.hotTopic.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.l;
import c.a.d.n.e.n;
import c.a.s0.s.i0.f;
import c.a.s0.s.i0.g;
import c.a.t0.o1.f.a.d.h;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.tabs.TabLayout;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes12.dex */
public class HotTopicTabView extends FrameLayout implements f.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f45933e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f45934f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.t0.o1.f.a.b f45935g;

    /* renamed from: h  reason: collision with root package name */
    public BdSwipeRefreshLayout f45936h;

    /* renamed from: i  reason: collision with root package name */
    public BdTypeRecyclerView f45937i;

    /* renamed from: j  reason: collision with root package name */
    public h f45938j;

    /* renamed from: k  reason: collision with root package name */
    public g f45939k;
    public c.a.s0.g0.g l;
    public c.a.s0.g0.h m;
    public ScrollFragmentTabHost n;
    public int o;
    public PbListView p;
    public HotTopicHeaderView q;
    public TabLayout.OnTabSelectedListener r;
    public c.a.s0.n.f s;
    public boolean t;
    public RecyclerView.OnScrollListener u;
    public ScrollFragmentTabHost.u v;

    /* loaded from: classes12.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicTabView a;

        public a(HotTopicTabView hotTopicTabView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicTabView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicTabView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) || this.a.o == i2 || this.a.n == null) {
                return;
            }
            this.a.o = i2;
            if (this.a.o == 1) {
                this.a.n.showShadow();
            } else if (this.a.i(recyclerView)) {
                this.a.n.dismissShadow();
            } else {
                this.a.n.showShadow();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b extends ScrollFragmentTabHost.u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicTabView a;

        public b(HotTopicTabView hotTopicTabView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicTabView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicTabView;
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.u
        public void c() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.n == null) {
                return;
            }
            this.a.o = -1;
            HotTopicTabView hotTopicTabView = this.a;
            if (hotTopicTabView.i(hotTopicTabView.f45937i)) {
                this.a.n.dismissShadow();
            } else {
                this.a.n.showShadow();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicTabView f45940e;

        public c(HotTopicTabView hotTopicTabView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicTabView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45940e = hotTopicTabView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && l.A() && this.f45940e.f45935g != null) {
                this.f45940e.showLoadingView(false);
                this.f45940e.f45935g.loadData();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicTabView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f45933e = 3;
        this.o = -1;
        this.u = new a(this);
        this.v = new b(this);
        this.f45934f = tbPageContext;
        g(tbPageContext.getPageActivity());
        h();
        onChangeSkinType();
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ScrollFragmentTabHost scrollFragmentTabHost = this.n;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.removeShadowChangeListener(this.v);
            }
            stopPullRefresh();
            hideLoadingView();
            hideNetRefreshView();
            this.t = true;
        }
    }

    public void forceRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f45938j.c();
        }
    }

    public final void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.fragment_hot_topic_tab_layout, (ViewGroup) this, true);
            this.f45936h = (BdSwipeRefreshLayout) findViewById(R.id.hotTopicRefreshLayout);
            g gVar = new g(this.f45934f);
            this.f45939k = gVar;
            this.f45936h.setProgressView(gVar);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) findViewById(R.id.hotTopicListView);
            this.f45937i = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(context));
            this.f45937i.setFadingEdgeLength(0);
            this.f45937i.setOverScrollMode(2);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.f45937i.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            this.f45938j = new h(this.f45934f, this.f45937i);
            PbListView pbListView = new PbListView(this.f45934f.getPageActivity());
            this.p = pbListView;
            pbListView.a();
            this.p.p(R.color.CAM_X0205);
            this.p.B(R.color.CAM_X0111);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f45937i.addOnScrollListener(this.u);
            this.f45939k.a(this);
        }
    }

    public void hideLoadingView() {
        c.a.s0.g0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (gVar = this.l) == null) {
            return;
        }
        gVar.dettachView(this);
        this.l = null;
    }

    public void hideNetRefreshView() {
        c.a.s0.g0.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (hVar = this.m) == null) {
            return;
        }
        hVar.dettachView(this);
        this.m = null;
    }

    public void hideNoMoreView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f45937i.setNextPage(null);
        }
    }

    public final boolean i(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, recyclerView)) == null) {
            if (recyclerView == null) {
                return true;
            }
            return !recyclerView.canScrollVertically(-1);
        }
        return invokeL.booleanValue;
    }

    public boolean isLoadingViewShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            c.a.s0.g0.g gVar = this.l;
            if (gVar != null) {
                return gVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isRefreshViewShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            c.a.s0.g0.h hVar = this.m;
            if (hVar != null) {
                return hVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isShownHeaderView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            HotTopicHeaderView hotTopicHeaderView = this.q;
            return (hotTopicHeaderView == null || hotTopicHeaderView.getParent() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void onChangeSkinType() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f45933e) {
            return;
        }
        this.f45933e = skinType;
        g gVar = this.f45939k;
        if (gVar != null) {
            gVar.C(skinType);
        }
        c.a.s0.g0.g gVar2 = this.l;
        if (gVar2 != null) {
            gVar2.onChangeSkinType();
        }
        c.a.s0.g0.h hVar = this.m;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        h hVar2 = this.f45938j;
        if (hVar2 != null) {
            hVar2.c();
        }
        PbListView pbListView = this.p;
        if (pbListView != null) {
            pbListView.d(skinType);
            this.p.p(R.color.transparent);
        }
        HotTopicHeaderView hotTopicHeaderView = this.q;
        if (hotTopicHeaderView != null) {
            hotTopicHeaderView.onChangeSkinType(skinType);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            destroy();
            super.onDetachedFromWindow();
        }
    }

    @Override // c.a.s0.s.i0.f.g
    public void onListPullRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.f45935g.loadData();
        }
    }

    public void reload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f45937i.setSelection(0);
            startPullRefresh();
            ScrollFragmentTabHost.u uVar = this.v;
            if (uVar != null) {
                uVar.c();
            }
        }
    }

    public void setData(@NonNull c.a.t0.o1.f.a.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) {
            showHeaderView(aVar);
            setListData(aVar.getDataList());
        }
    }

    public void setListData(@NonNull List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, list) == null) {
            this.f45938j.d(list);
        }
    }

    public void setOnItemCoverListener(c.a.s0.n.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, fVar) == null) {
            this.s = fVar;
            h hVar = this.f45938j;
            if (hVar != null) {
                hVar.e(fVar);
            }
            HotTopicHeaderView hotTopicHeaderView = this.q;
            if (hotTopicHeaderView != null) {
                hotTopicHeaderView.setOnItemCoverListener(fVar);
            }
        }
    }

    public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onTabSelectedListener) == null) {
            this.r = onTabSelectedListener;
        }
    }

    public void setPresenter(c.a.t0.o1.f.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bVar) == null) {
            this.f45935g = bVar;
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, scrollFragmentTabHost) == null) {
            this.n = scrollFragmentTabHost;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.removeShadowChangeListener(this.v);
                this.n.addShadowChangeListener(this.v);
            }
        }
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bdUniqueId) == null) {
            h hVar = this.f45938j;
            if (hVar != null) {
                hVar.f(bdUniqueId);
            }
            g gVar = this.f45939k;
            if (gVar != null) {
                gVar.V(bdUniqueId);
            }
        }
    }

    public void setViewForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            ScrollFragmentTabHost scrollFragmentTabHost = this.n;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.removeShadowChangeListener(this.v);
                this.n.addShadowChangeListener(this.v);
                this.v.c();
            }
            if (this.t) {
                this.t = false;
                if (ListUtils.isEmpty(this.f45938j.a())) {
                    this.f45935g.loadData();
                }
            }
        }
    }

    public void showHeaderView(@NonNull c.a.t0.o1.f.a.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, aVar) == null) {
            if (this.q == null) {
                this.q = new HotTopicHeaderView(getContext());
            }
            this.f45937i.setHeaderView(this.q);
            this.q.setOnItemCoverListener(this.s);
            this.q.setOnTabSelectedListener(this.r);
            this.q.setData(aVar.getResData());
        }
    }

    public void showLoadingView(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048600, this, z) == null) || isLoadingViewShowing()) {
            return;
        }
        if (this.l == null) {
            this.l = new c.a.s0.g0.g(getContext());
            int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - c.a.d.f.p.n.f(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
            this.l.h();
            this.l.q(height);
            this.l.onChangeSkinType();
        }
        this.l.attachView(this, z);
    }

    public void showNetRefreshView(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048601, this, z) == null) || isRefreshViewShowing()) {
            return;
        }
        if (this.m == null) {
            this.m = new c.a.s0.g0.h(getContext(), new c(this));
        }
        this.m.attachView(this, z);
        this.m.p();
    }

    public void showNoMoreView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.f45937i.setNextPage(this.p);
            this.p.f();
            this.p.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.p.E(getResources().getString(R.string.really_great), c.a.d.f.p.n.f(getContext(), R.dimen.tbds158));
        }
    }

    public void startPullRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.f45936h.setRefreshing(true);
        }
    }

    public void stopPullRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.f45936h.setRefreshing(false);
        }
    }
}
