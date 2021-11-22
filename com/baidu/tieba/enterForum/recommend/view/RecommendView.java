package com.baidu.tieba.enterForum.recommend.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.e.f.p.j;
import b.a.e.f.p.l;
import b.a.q0.g0.h;
import b.a.q0.s.g0.f;
import b.a.q0.s.g0.g;
import b.a.r0.o0.k.c.f;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.view.ForumTestView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class RecommendView extends FrameLayout implements ForumTestView.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f48603e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f48604f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.r0.o0.k.a f48605g;

    /* renamed from: h  reason: collision with root package name */
    public RecommendForumHeaderView f48606h;

    /* renamed from: i  reason: collision with root package name */
    public BdSwipeRefreshLayout f48607i;
    public BdTypeRecyclerView j;
    public b.a.r0.o0.k.b.a k;
    public g l;
    public b.a.q0.g0.g m;
    public h n;
    public b.a.r0.o0.k.c.a o;
    public b.a.r0.o0.h.c p;
    public FrameLayout q;
    public long r;
    public int s;
    public int t;
    public List<f> u;
    public CustomMessageListener v;
    public CustomMessageListener w;
    public RecyclerView.OnScrollListener x;

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendView f48608a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(RecommendView recommendView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48608a = recommendView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f48608a.p == null) {
                return;
            }
            this.f48608a.p.V(TbSingleton.getInstance().getHotSearch());
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendView f48609a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(RecommendView recommendView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48609a = recommendView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof Long)) {
                Long l = (Long) customResponsedMessage.getData();
                if (this.f48609a.o == null || l == null) {
                    return;
                }
                this.f48609a.r = l.longValue();
                if (this.f48609a.f48605g != null) {
                    this.f48609a.f48605g.loadData();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f48610a;

        /* renamed from: b  reason: collision with root package name */
        public int f48611b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ RecommendView f48612c;

        public c(RecommendView recommendView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48612c = recommendView;
            this.f48610a = -1;
            this.f48611b = 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) || this.f48610a == i2 || this.f48612c.p == null) {
                return;
            }
            this.f48610a = i2;
            if (i2 == 1) {
                return;
            }
            this.f48612c.recyclerViewIsAtTop(recyclerView);
            this.f48612c.f48606h.destoryForumTip();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                this.f48611b += i3;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecommendView f48613e;

        public d(RecommendView recommendView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48613e = recommendView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && j.A() && this.f48613e.f48605g != null) {
                this.f48613e.f48605g.loadData();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecommendView f48614e;

        public e(RecommendView recommendView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48614e = recommendView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && j.A() && this.f48614e.f48605g != null) {
                this.f48614e.f48605g.loadData();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendView(TbPageContext<?> tbPageContext) {
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
        this.f48603e = 3;
        this.v = new a(this, 2921396);
        this.w = new b(this, 2921383);
        this.x = new c(this);
        this.f48604f = tbPageContext;
        this.s = UtilHelper.getStatusBarHeight() + l.g(tbPageContext.getPageActivity(), R.dimen.tbds240);
        this.t = l.g(tbPageContext.getPageActivity(), R.dimen.tbds114);
        f(tbPageContext.getPageActivity());
        tbPageContext.registerListener(this.w);
        tbPageContext.registerListener(this.v);
        onChangeSkinType();
    }

    public final void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.fragment_enter_recommend_layout, (ViewGroup) this, true);
            setClipChildren(false);
            this.f48607i = (BdSwipeRefreshLayout) findViewById(R.id.enter_recommend_refresh_layout);
            g gVar = new g(this.f48604f);
            this.l = gVar;
            this.f48607i.setProgressView(gVar);
            this.f48607i.setClipChildren(false);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) findViewById(R.id.enter_recommend_list_view);
            this.j = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(context));
            this.j.setFadingEdgeLength(0);
            this.j.setOverScrollMode(2);
            this.j.setClipChildren(false);
            this.j.addOnScrollListener(this.x);
            this.k = new b.a.r0.o0.k.b.a(this.f48604f, this.j);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f48607i.getLayoutParams();
            marginLayoutParams.topMargin = this.s - getResources().getDimensionPixelSize(R.dimen.tbds24);
            this.f48607i.setLayoutParams(marginLayoutParams);
            RecommendForumHeaderView recommendForumHeaderView = new RecommendForumHeaderView(this.f48604f);
            this.f48606h = recommendForumHeaderView;
            recommendForumHeaderView.setOnSecectedListener(this);
            FrameLayout frameLayout = new FrameLayout(this.f48604f.getPageActivity());
            frameLayout.addView(new View(this.f48604f.getPageActivity()), new FrameLayout.LayoutParams(-1, this.t));
            this.q = frameLayout;
        }
    }

    public final void g(List<f> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.j.removeHeaderView(this.q);
            this.j.removeHeaderView(this.f48606h);
            this.j.getHeaderViewsCount();
            this.j.addHeaderView(this.f48606h);
            this.u = list;
            this.f48606h.setData(list);
            this.p.V(TbSingleton.getInstance().getHotSearch());
        }
    }

    public final void h(b.a.r0.o0.k.c.a aVar, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, aVar, j) == null) || aVar == null) {
            return;
        }
        this.k.e(aVar.a(j, !ListUtils.isEmpty(this.u)));
    }

    public void hideLoadingView() {
        b.a.q0.g0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (gVar = this.m) == null) {
            return;
        }
        gVar.dettachView(this);
        this.m = null;
    }

    public void hideNetRefreshView() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (hVar = this.n) == null) {
            return;
        }
        hVar.dettachView(this);
        this.n = null;
    }

    public boolean isLoadingViewShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            b.a.q0.g0.g gVar = this.m;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            h hVar = this.n;
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
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f48603e) {
            return;
        }
        this.f48603e = skinType;
        SkinManager.setBackgroundColor(this, R.color.CAM_X0205);
        g gVar = this.l;
        if (gVar != null) {
            gVar.C(skinType);
        }
        b.a.q0.g0.g gVar2 = this.m;
        if (gVar2 != null) {
            gVar2.onChangeSkinType();
        }
        h hVar = this.n;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        b.a.r0.o0.k.b.a aVar = this.k;
        if (aVar != null) {
            aVar.d();
        }
        RecommendForumHeaderView recommendForumHeaderView = this.f48606h;
        if (recommendForumHeaderView != null) {
            recommendForumHeaderView.onChangeSkinType();
        }
        SkinManager.setBackgroundColor(this.f48607i, R.color.CAM_X0205);
        SkinManager.setBackgroundColor(this.j, R.color.CAM_X0205);
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.j;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.removeOnScrollListener(this.x);
            }
            stopPullRefresh();
            hideLoadingView();
            hideNetRefreshView();
            RecommendForumHeaderView recommendForumHeaderView = this.f48606h;
            if (recommendForumHeaderView != null) {
                recommendForumHeaderView.unregisterDisappearTipListener();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            onDestroy();
            super.onDetachedFromWindow();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.c
    public void onListCleared() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (bdTypeRecyclerView = this.j) != null && !ListUtils.isEmpty(bdTypeRecyclerView.getData()) && this.j.getData().size() == 1 && (this.j.getData().get(0) instanceof b.a.r0.o0.k.c.e)) {
            showNoDataView();
        }
    }

    public void onNavigationbarHeightChange(View view, int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048587, this, view, i2) == null) || view == (bdTypeRecyclerView = this.j)) {
            return;
        }
        bdTypeRecyclerView.smoothScrollBy(-i2, 100);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.c
    public void onSelected(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j) == null) {
            h(this.o, j);
        }
    }

    public boolean recyclerViewIsAtTop(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, recyclerView)) == null) ? recyclerView == null || !recyclerView.canScrollVertically(-1) : invokeL.booleanValue;
    }

    public void setData(b.a.r0.o0.k.c.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) || aVar == null) {
            return;
        }
        this.o = aVar;
        if (ListUtils.isEmpty(aVar.d()) && ListUtils.isEmpty(aVar.b(true))) {
            showNoDataView();
            return;
        }
        showListView();
        List<f> f2 = aVar.f(this.r);
        this.r = 0L;
        f fVar = (f) ListUtils.getItem(f2, 1);
        if (fVar == null) {
            fVar = (f) ListUtils.getItem(f2, 0);
        }
        long j = fVar != null ? fVar.f23246a : 0L;
        g(f2);
        h(aVar, j);
    }

    public void setListPullRefreshListener(f.g gVar) {
        g gVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, gVar) == null) || (gVar2 = this.l) == null) {
            return;
        }
        gVar2.a(gVar);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bdUniqueId) == null) {
            b.a.r0.o0.k.b.a aVar = this.k;
            if (aVar != null) {
                aVar.f(bdUniqueId);
            }
            g gVar = this.l;
            if (gVar != null) {
                gVar.U(bdUniqueId);
            }
            RecommendForumHeaderView recommendForumHeaderView = this.f48606h;
            if (recommendForumHeaderView != null) {
                recommendForumHeaderView.setPageId(bdUniqueId);
            }
        }
    }

    public void setPresenter(b.a.r0.o0.k.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, aVar) == null) {
            this.f48605g = aVar;
        }
    }

    public void setTabViewController(b.a.r0.o0.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, cVar) == null) {
            this.p = cVar;
        }
    }

    public void showListView() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (bdTypeRecyclerView = this.j) == null) {
            return;
        }
        bdTypeRecyclerView.setVisibility(0);
    }

    public void showLoadingView(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || isLoadingViewShowing()) {
            return;
        }
        if (this.m == null) {
            this.m = new b.a.q0.g0.g(getContext());
            this.m.h();
            this.m.q((getHeight() - l.g(getContext(), R.dimen.tbds304)) / 2);
            this.m.onChangeSkinType();
        }
        this.m.attachView(this, z);
    }

    public void showNetRefreshView(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048597, this, z) == null) || isRefreshViewShowing()) {
            return;
        }
        if (this.n == null) {
            this.n = new h(getContext(), new d(this));
            this.n.j(l.g(TbadkCoreApplication.getInst(), R.dimen.ds364));
        }
        this.n.m(this.f48604f.getString(R.string.refresh_view_title_text));
        this.n.i(R.drawable.new_pic_emotion_08);
        this.n.attachView(this, z);
        this.n.o();
        this.j.setVisibility(8);
    }

    public void showNoDataView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (this.n == null) {
                this.n = new h(getContext(), new e(this));
                this.n.j(l.g(TbadkCoreApplication.getInst(), R.dimen.ds364));
            }
            this.n.i(R.drawable.new_pic_emotion_08);
            this.n.m(this.f48604f.getString(R.string.recommend_forum_no_data));
            this.n.attachView(this, false);
            this.n.o();
            this.j.setVisibility(8);
        }
    }

    public void startPullRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.f48607i.setRefreshing(true);
        }
    }

    public void stopPullRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.f48607i.setRefreshing(false);
        }
    }
}
