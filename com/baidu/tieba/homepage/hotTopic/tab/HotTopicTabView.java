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
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.r0.r.f0.f;
import d.a.r0.r.f0.g;
import d.a.s0.e1.f.a.d.h;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes5.dex */
public class HotTopicTabView extends FrameLayout implements f.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f16622e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f16623f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.s0.e1.f.a.b f16624g;

    /* renamed from: h  reason: collision with root package name */
    public BdSwipeRefreshLayout f16625h;

    /* renamed from: i  reason: collision with root package name */
    public BdTypeRecyclerView f16626i;
    public h j;
    public g k;
    public d.a.r0.d0.g l;
    public d.a.r0.d0.h m;
    public ScrollFragmentTabHost n;
    public int o;
    public PbListView p;
    public HotTopicHeaderView q;
    public TabLayout.OnTabSelectedListener r;
    public d.a.r0.m.f s;
    public boolean t;
    public RecyclerView.OnScrollListener u;
    public ScrollFragmentTabHost.s v;

    /* loaded from: classes5.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotTopicTabView f16627a;

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
            this.f16627a = hotTopicTabView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) || this.f16627a.o == i2 || this.f16627a.n == null) {
                return;
            }
            this.f16627a.o = i2;
            if (this.f16627a.o == 1) {
                this.f16627a.n.V();
            } else if (this.f16627a.r(recyclerView)) {
                this.f16627a.n.y();
            } else {
                this.f16627a.n.V();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends ScrollFragmentTabHost.s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotTopicTabView f16628a;

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
            this.f16628a = hotTopicTabView;
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.s
        public void c() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f16628a.n == null) {
                return;
            }
            this.f16628a.o = -1;
            HotTopicTabView hotTopicTabView = this.f16628a;
            if (hotTopicTabView.r(hotTopicTabView.f16626i)) {
                this.f16628a.n.y();
            } else {
                this.f16628a.n.V();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicTabView f16629e;

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
            this.f16629e = hotTopicTabView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && j.A() && this.f16629e.f16624g != null) {
                this.f16629e.u(false);
                this.f16629e.f16624g.loadData();
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
        this.f16622e = 3;
        this.o = -1;
        this.u = new a(this);
        this.v = new b(this);
        this.f16623f = tbPageContext;
        l(tbPageContext.getPageActivity());
        m();
        q();
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ScrollFragmentTabHost scrollFragmentTabHost = this.n;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.S(this.v);
            }
            y();
            h();
            i();
            this.t = true;
        }
    }

    public void h() {
        d.a.r0.d0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (gVar = this.l) == null) {
            return;
        }
        gVar.dettachView(this);
        this.l = null;
    }

    public void i() {
        d.a.r0.d0.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (hVar = this.m) == null) {
            return;
        }
        hVar.dettachView(this);
        this.m = null;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f16626i.setNextPage(null);
        }
    }

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.fragment_hot_topic_tab_layout, (ViewGroup) this, true);
            this.f16625h = (BdSwipeRefreshLayout) findViewById(R.id.hotTopicRefreshLayout);
            g gVar = new g(this.f16623f);
            this.k = gVar;
            this.f16625h.setProgressView(gVar);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) findViewById(R.id.hotTopicListView);
            this.f16626i = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(context));
            this.f16626i.setFadingEdgeLength(0);
            this.f16626i.setOverScrollMode(2);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.f16626i.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            this.j = new h(this.f16623f, this.f16626i);
            PbListView pbListView = new PbListView(this.f16623f.getPageActivity());
            this.p = pbListView;
            pbListView.a();
            this.p.o(R.color.CAM_X0205);
            this.p.y(R.color.CAM_X0111);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f16626i.addOnScrollListener(this.u);
            this.k.a(this);
        }
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            d.a.r0.d0.g gVar = this.l;
            if (gVar != null) {
                return gVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            d.a.r0.d0.h hVar = this.m;
            if (hVar != null) {
                return hVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            g();
            super.onDetachedFromWindow();
        }
    }

    @Override // d.a.r0.r.f0.f.g
    public void onListPullRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f16624g.loadData();
        }
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            HotTopicHeaderView hotTopicHeaderView = this.q;
            return (hotTopicHeaderView == null || hotTopicHeaderView.getParent() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void q() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f16622e) {
            return;
        }
        this.f16622e = skinType;
        g gVar = this.k;
        if (gVar != null) {
            gVar.I(skinType);
        }
        d.a.r0.d0.g gVar2 = this.l;
        if (gVar2 != null) {
            gVar2.onChangeSkinType();
        }
        d.a.r0.d0.h hVar = this.m;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        h hVar2 = this.j;
        if (hVar2 != null) {
            hVar2.c();
        }
        PbListView pbListView = this.p;
        if (pbListView != null) {
            pbListView.d(skinType);
            this.p.o(R.color.transparent);
        }
        HotTopicHeaderView hotTopicHeaderView = this.q;
        if (hotTopicHeaderView != null) {
            hotTopicHeaderView.c(skinType);
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.f16626i;
        if (bdTypeRecyclerView != null) {
            d.a.r0.r.u.c.d(bdTypeRecyclerView).f(R.color.CAM_X0202);
        }
    }

    public final boolean r(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, recyclerView)) == null) {
            if (recyclerView == null) {
                return true;
            }
            return !recyclerView.canScrollVertically(-1);
        }
        return invokeL.booleanValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f16626i.setSelection(0);
            x();
            ScrollFragmentTabHost.s sVar = this.v;
            if (sVar != null) {
                sVar.c();
            }
        }
    }

    public void setData(@NonNull d.a.s0.e1.f.a.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
            t(aVar);
            setListData(aVar.getDataList());
        }
    }

    public void setListData(@NonNull List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            this.j.d(list);
        }
    }

    public void setOnItemCoverListener(d.a.r0.m.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, fVar) == null) {
            this.s = fVar;
            h hVar = this.j;
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
        if (interceptable == null || interceptable.invokeL(1048593, this, onTabSelectedListener) == null) {
            this.r = onTabSelectedListener;
        }
    }

    public void setPresenter(d.a.s0.e1.f.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bVar) == null) {
            this.f16624g = bVar;
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, scrollFragmentTabHost) == null) {
            this.n = scrollFragmentTabHost;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.S(this.v);
                this.n.w(this.v);
            }
        }
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bdUniqueId) == null) {
            h hVar = this.j;
            if (hVar != null) {
                hVar.f(bdUniqueId);
            }
            g gVar = this.k;
            if (gVar != null) {
                gVar.a0(bdUniqueId);
            }
        }
    }

    public void setViewForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ScrollFragmentTabHost scrollFragmentTabHost = this.n;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.S(this.v);
                this.n.w(this.v);
                this.v.c();
            }
            if (this.t) {
                this.t = false;
                if (ListUtils.isEmpty(this.j.a())) {
                    this.f16624g.loadData();
                }
            }
        }
    }

    public void t(@NonNull d.a.s0.e1.f.a.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, aVar) == null) {
            if (this.q == null) {
                this.q = new HotTopicHeaderView(getContext());
            }
            this.f16626i.setHeaderView(this.q);
            this.q.setOnItemCoverListener(this.s);
            this.q.setOnTabSelectedListener(this.r);
            this.q.setData(aVar.getResData());
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048599, this, z) == null) || n()) {
            return;
        }
        if (this.l == null) {
            this.l = new d.a.r0.d0.g(getContext());
            int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.g(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
            this.l.h();
            this.l.q(height);
            this.l.onChangeSkinType();
        }
        this.l.attachView(this, z);
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048600, this, z) == null) || o()) {
            return;
        }
        if (this.m == null) {
            this.m = new d.a.r0.d0.h(getContext(), new c(this));
        }
        this.m.attachView(this, z);
        this.m.o();
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.f16626i.setNextPage(this.p);
            this.p.f();
            this.p.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.p.B(getResources().getString(R.string.really_great), l.g(getContext(), R.dimen.tbds158));
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.f16625h.setRefreshing(true);
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.f16625h.setRefreshing(false);
        }
    }
}
