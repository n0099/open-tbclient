package com.baidu.tieba.enterForum.recommend.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.s0.g0.h;
import c.a.s0.s.k0.f;
import c.a.s0.s.k0.g;
import c.a.t0.v0.k.c.f;
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
/* loaded from: classes12.dex */
public class RecommendView extends FrameLayout implements ForumTestView.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f42683e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f42684f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.t0.v0.k.a f42685g;

    /* renamed from: h  reason: collision with root package name */
    public RecommendForumHeaderView f42686h;

    /* renamed from: i  reason: collision with root package name */
    public BdSwipeRefreshLayout f42687i;

    /* renamed from: j  reason: collision with root package name */
    public BdTypeRecyclerView f42688j;
    public c.a.t0.v0.k.b.a k;
    public g l;
    public c.a.s0.g0.g m;
    public h n;
    public c.a.t0.v0.k.c.a o;
    public c.a.t0.v0.h.c p;
    public FrameLayout q;
    public long r;
    public int s;
    public int t;
    public List<f> u;
    public CustomMessageListener v;
    public CustomMessageListener w;
    public RecyclerView.OnScrollListener x;

    /* loaded from: classes12.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendView a;

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
            this.a = recommendView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.p == null) {
                return;
            }
            this.a.p.O(TbSingleton.getInstance().getHotSearch());
        }
    }

    /* loaded from: classes12.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendView a;

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
            this.a = recommendView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof Long)) {
                Long l = (Long) customResponsedMessage.getData();
                if (this.a.o == null || l == null) {
                    return;
                }
                this.a.r = l.longValue();
                if (this.a.f42685g != null) {
                    this.a.f42685g.loadData();
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f42689b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ RecommendView f42690c;

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
            this.f42690c = recommendView;
            this.a = -1;
            this.f42689b = 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) || this.a == i2 || this.f42690c.p == null) {
                return;
            }
            this.a = i2;
            if (i2 == 1) {
                return;
            }
            this.f42690c.recyclerViewIsAtTop(recyclerView);
            this.f42690c.f42686h.destoryForumTip();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                this.f42689b += i3;
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecommendView f42691e;

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
            this.f42691e = recommendView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && l.A() && this.f42691e.f42685g != null) {
                this.f42691e.f42685g.loadData();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecommendView f42692e;

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
            this.f42692e = recommendView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && l.A() && this.f42692e.f42685g != null) {
                this.f42692e.f42685g.loadData();
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
        this.f42683e = 3;
        this.v = new a(this, 2921396);
        this.w = new b(this, 2921383);
        this.x = new c(this);
        this.f42684f = tbPageContext;
        this.s = UtilHelper.getStatusBarHeight() + n.f(tbPageContext.getPageActivity(), R.dimen.tbds240);
        this.t = n.f(tbPageContext.getPageActivity(), R.dimen.tbds114);
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
            this.f42687i = (BdSwipeRefreshLayout) findViewById(R.id.enter_recommend_refresh_layout);
            g gVar = new g(this.f42684f);
            this.l = gVar;
            this.f42687i.setProgressView(gVar);
            this.f42687i.setClipChildren(false);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) findViewById(R.id.enter_recommend_list_view);
            this.f42688j = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(context));
            this.f42688j.setFadingEdgeLength(0);
            this.f42688j.setOverScrollMode(2);
            this.f42688j.setClipChildren(false);
            this.f42688j.addOnScrollListener(this.x);
            this.k = new c.a.t0.v0.k.b.a(this.f42684f, this.f42688j);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f42687i.getLayoutParams();
            marginLayoutParams.topMargin = this.s - getResources().getDimensionPixelSize(R.dimen.tbds24);
            this.f42687i.setLayoutParams(marginLayoutParams);
            RecommendForumHeaderView recommendForumHeaderView = new RecommendForumHeaderView(this.f42684f);
            this.f42686h = recommendForumHeaderView;
            recommendForumHeaderView.setOnSecectedListener(this);
            FrameLayout frameLayout = new FrameLayout(this.f42684f.getPageActivity());
            frameLayout.addView(new View(this.f42684f.getPageActivity()), new FrameLayout.LayoutParams(-1, this.t));
            this.q = frameLayout;
        }
    }

    public final void g(List<f> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f42688j.removeHeaderView(this.q);
            this.f42688j.removeHeaderView(this.f42686h);
            this.f42688j.getHeaderViewsCount();
            this.f42688j.addHeaderView(this.f42686h);
            this.u = list;
            this.f42686h.setData(list);
            this.p.O(TbSingleton.getInstance().getHotSearch());
        }
    }

    public final void h(c.a.t0.v0.k.c.a aVar, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, aVar, j2) == null) || aVar == null) {
            return;
        }
        this.k.e(aVar.a(j2, !ListUtils.isEmpty(this.u)));
    }

    public void hideLoadingView() {
        c.a.s0.g0.g gVar;
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
            c.a.s0.g0.g gVar = this.m;
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
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f42683e) {
            return;
        }
        this.f42683e = skinType;
        SkinManager.setBackgroundColor(this, R.color.CAM_X0205);
        g gVar = this.l;
        if (gVar != null) {
            gVar.C(skinType);
        }
        c.a.s0.g0.g gVar2 = this.m;
        if (gVar2 != null) {
            gVar2.onChangeSkinType();
        }
        h hVar = this.n;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        c.a.t0.v0.k.b.a aVar = this.k;
        if (aVar != null) {
            aVar.d();
        }
        RecommendForumHeaderView recommendForumHeaderView = this.f42686h;
        if (recommendForumHeaderView != null) {
            recommendForumHeaderView.onChangeSkinType();
        }
        SkinManager.setBackgroundColor(this.f42687i, R.color.CAM_X0205);
        SkinManager.setBackgroundColor(this.f42688j, R.color.CAM_X0205);
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f42688j;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.removeOnScrollListener(this.x);
            }
            stopPullRefresh();
            hideLoadingView();
            hideNetRefreshView();
            RecommendForumHeaderView recommendForumHeaderView = this.f42686h;
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
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (bdTypeRecyclerView = this.f42688j) != null && !ListUtils.isEmpty(bdTypeRecyclerView.getData()) && this.f42688j.getData().size() == 1 && (this.f42688j.getData().get(0) instanceof c.a.t0.v0.k.c.e)) {
            showNoDataView();
        }
    }

    public void onNavigationbarHeightChange(View view, int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048587, this, view, i2) == null) || view == (bdTypeRecyclerView = this.f42688j)) {
            return;
        }
        bdTypeRecyclerView.smoothScrollBy(-i2, 100);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.c
    public void onSelected(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j2) == null) {
            h(this.o, j2);
        }
    }

    public boolean recyclerViewIsAtTop(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, recyclerView)) == null) ? recyclerView == null || !recyclerView.canScrollVertically(-1) : invokeL.booleanValue;
    }

    public void setData(c.a.t0.v0.k.c.a aVar) {
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
        long j2 = fVar != null ? fVar.a : 0L;
        g(f2);
        h(aVar, j2);
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
            c.a.t0.v0.k.b.a aVar = this.k;
            if (aVar != null) {
                aVar.f(bdUniqueId);
            }
            g gVar = this.l;
            if (gVar != null) {
                gVar.V(bdUniqueId);
            }
            RecommendForumHeaderView recommendForumHeaderView = this.f42686h;
            if (recommendForumHeaderView != null) {
                recommendForumHeaderView.setPageId(bdUniqueId);
            }
        }
    }

    public void setPresenter(c.a.t0.v0.k.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, aVar) == null) {
            this.f42685g = aVar;
        }
    }

    public void setTabViewController(c.a.t0.v0.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, cVar) == null) {
            this.p = cVar;
        }
    }

    public void showListView() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (bdTypeRecyclerView = this.f42688j) == null) {
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
            this.m = new c.a.s0.g0.g(getContext());
            this.m.h();
            this.m.r((getHeight() - n.f(getContext(), R.dimen.tbds304)) / 2);
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
            this.n.k(n.f(TbadkCoreApplication.getInst(), R.dimen.ds364));
        }
        this.n.n(this.f42684f.getString(R.string.refresh_view_title_text));
        this.n.i(R.drawable.new_pic_emotion_08);
        this.n.attachView(this, z);
        this.n.p();
        this.f42688j.setVisibility(8);
    }

    public void showNoDataView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (this.n == null) {
                this.n = new h(getContext(), new e(this));
                this.n.k(n.f(TbadkCoreApplication.getInst(), R.dimen.ds364));
            }
            this.n.i(R.drawable.new_pic_emotion_08);
            this.n.n(this.f42684f.getString(R.string.recommend_forum_no_data));
            this.n.attachView(this, false);
            this.n.p();
            this.f42688j.setVisibility(8);
        }
    }

    public void startPullRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.f42687i.setRefreshing(true);
        }
    }

    public void stopPullRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.f42687i.setRefreshing(false);
        }
    }
}
