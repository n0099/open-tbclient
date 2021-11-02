package com.baidu.tieba.homepage.topic.topictab.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.e.e.p.j;
import b.a.e.e.p.l;
import b.a.e.l.e.n;
import b.a.q0.g0.h;
import b.a.q0.s.g0.f;
import b.a.q0.s.g0.g;
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
import java.util.List;
/* loaded from: classes9.dex */
public class TopicListView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f49889e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f49890f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.r0.h1.k.b.a f49891g;

    /* renamed from: h  reason: collision with root package name */
    public BdSwipeRefreshLayout f49892h;

    /* renamed from: i  reason: collision with root package name */
    public BdTypeRecyclerView f49893i;
    public b.a.r0.h1.k.b.b.b j;
    public g k;
    public b.a.q0.g0.g l;
    public h m;
    public ScrollFragmentTabHost n;
    public int o;
    public PbListView p;
    public RecyclerView.OnScrollListener q;
    public ScrollFragmentTabHost.s r;

    /* loaded from: classes9.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TopicListView f49894a;

        public a(TopicListView topicListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49894a = topicListView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) || this.f49894a.o == i2 || this.f49894a.n == null) {
                return;
            }
            this.f49894a.o = i2;
            if (this.f49894a.o == 1) {
                this.f49894a.n.showShadow();
            } else if (this.f49894a.h(recyclerView)) {
                this.f49894a.n.dismissShadow();
            } else {
                this.f49894a.n.showShadow();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends ScrollFragmentTabHost.s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TopicListView f49895a;

        public b(TopicListView topicListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49895a = topicListView;
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.s
        public void c() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f49895a.n == null) {
                return;
            }
            this.f49895a.o = -1;
            TopicListView topicListView = this.f49895a;
            if (topicListView.h(topicListView.f49893i)) {
                this.f49895a.n.dismissShadow();
            } else {
                this.f49895a.n.showShadow();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicListView f49896e;

        public c(TopicListView topicListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49896e = topicListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && j.A() && this.f49896e.f49891g != null) {
                this.f49896e.f49893i.setVisibility(0);
                this.f49896e.f49891g.loadData();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicListView(TbPageContext<?> tbPageContext) {
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
        this.f49889e = 3;
        this.o = -1;
        this.q = new a(this);
        this.r = new b(this);
        this.f49890f = tbPageContext;
        g(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ScrollFragmentTabHost scrollFragmentTabHost = this.n;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.removeShadowChangeListener(this.r);
            }
            this.f49893i.removeOnScrollListener(this.q);
            stopPullRefresh();
            hideLoadingView();
            hideNetRefreshView();
        }
    }

    public void forceRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.j.b();
        }
    }

    public final void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.fragment_topic_list_layout, (ViewGroup) this, true);
            this.f49892h = (BdSwipeRefreshLayout) findViewById(R.id.topic_refresh_layout);
            g gVar = new g(this.f49890f);
            this.k = gVar;
            this.f49892h.setProgressView(gVar);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) findViewById(R.id.topic_list_view);
            this.f49893i = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(context));
            this.f49893i.setFadingEdgeLength(0);
            this.f49893i.setOverScrollMode(2);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.f49893i.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            this.j = new b.a.r0.h1.k.b.b.b(this.f49890f, this.f49893i);
            PbListView pbListView = new PbListView(this.f49890f.getPageActivity());
            this.p = pbListView;
            pbListView.a();
            this.p.p(R.color.transparent);
        }
    }

    public final boolean h(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, recyclerView)) == null) ? recyclerView == null || !recyclerView.canScrollVertically(-1) : invokeL.booleanValue;
    }

    public void hideLoadingView() {
        b.a.q0.g0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (gVar = this.l) == null) {
            return;
        }
        gVar.dettachView(this);
        this.l = null;
    }

    public void hideNetRefreshView() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (hVar = this.m) == null) {
            return;
        }
        hVar.dettachView(this);
        this.m = null;
    }

    public void initListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f49893i.removeOnScrollListener(this.q);
            this.f49893i.addOnScrollListener(this.q);
        }
    }

    public boolean isLoadingViewShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            b.a.q0.g0.g gVar = this.l;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            h hVar = this.m;
            if (hVar != null) {
                return hVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onChangeSkinType() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f49889e) {
            return;
        }
        this.f49889e = skinType;
        g gVar = this.k;
        if (gVar != null) {
            gVar.C(skinType);
        }
        b.a.q0.g0.g gVar2 = this.l;
        if (gVar2 != null) {
            gVar2.onChangeSkinType();
        }
        h hVar = this.m;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        b.a.r0.h1.k.b.b.b bVar = this.j;
        if (bVar != null) {
            bVar.b();
        }
        PbListView pbListView = this.p;
        if (pbListView != null) {
            pbListView.d(skinType);
            this.p.p(R.color.CAM_X0205);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            destroy();
            super.onDetachedFromWindow();
        }
    }

    public void reload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f49893i.setSelection(0);
            startPullRefresh();
            ScrollFragmentTabHost.s sVar = this.r;
            if (sVar != null) {
                sVar.c();
            }
        }
    }

    public void setData(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.j.c(list);
    }

    public void setListPullRefreshListener(f.g gVar) {
        g gVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, gVar) == null) || (gVar2 = this.k) == null) {
            return;
        }
        gVar2.a(gVar);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bdUniqueId) == null) {
            b.a.r0.h1.k.b.b.b bVar = this.j;
            if (bVar != null) {
                bVar.d(bdUniqueId);
            }
            g gVar = this.k;
            if (gVar != null) {
                gVar.U(bdUniqueId);
            }
        }
    }

    public void setPresenter(b.a.r0.h1.k.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) {
            this.f49891g = aVar;
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, scrollFragmentTabHost) == null) {
            this.n = scrollFragmentTabHost;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.removeShadowChangeListener(this.r);
                this.n.addShadowChangeListener(this.r);
            }
        }
    }

    public void setViewForeground() {
        ScrollFragmentTabHost scrollFragmentTabHost;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (scrollFragmentTabHost = this.n) == null) {
            return;
        }
        scrollFragmentTabHost.removeShadowChangeListener(this.r);
        this.n.addShadowChangeListener(this.r);
        this.r.c();
    }

    public void showListView() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (bdTypeRecyclerView = this.f49893i) == null) {
            return;
        }
        bdTypeRecyclerView.setVisibility(0);
    }

    public void showLoadingView(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048595, this, z) == null) || isLoadingViewShowing()) {
            return;
        }
        if (this.l == null) {
            this.l = new b.a.q0.g0.g(getContext());
            int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.g(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
            this.l.h();
            this.l.q(height);
            this.l.onChangeSkinType();
        }
        this.l.attachView(this, z);
    }

    public void showNetRefreshView(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || isRefreshViewShowing()) {
            return;
        }
        if (this.m == null) {
            this.m = new h(getContext(), new c(this));
        }
        this.m.attachView(this, z);
        this.m.o();
        this.f49893i.setVisibility(8);
    }

    public void showNoMoreView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.f49893i.setNextPage(this.p);
            this.p.f();
            this.p.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.p.s(l.g(this.f49890f.getPageActivity(), R.dimen.tbds150));
            this.p.C(getResources().getString(R.string.really_great));
        }
    }

    public void startPullRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.f49892h.setRefreshing(true);
        }
    }

    public void stopPullRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.f49892h.setRefreshing(false);
        }
    }
}
