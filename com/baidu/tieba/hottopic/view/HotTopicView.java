package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.j;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.s0.g0.h;
import c.a.s0.s.k0.f;
import c.a.t0.g0.v;
import c.a.t0.r1.o.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class HotTopicView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int SMOOTH_SCROLL_DURATION = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<HotTopicActivity> f44721e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f44722f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.s0.s.k0.g f44723g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.t0.r1.j.d f44724h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.s0.g0.g f44725i;

    /* renamed from: j  reason: collision with root package name */
    public h f44726j;
    public c.a.t0.r1.k.d k;
    public c.a.t0.r1.l.e l;
    public c.f m;
    public int n;
    public PbListView o;
    public int p;
    public f.g q;
    public AbsListView.OnScrollListener r;
    public CustomMessageListener s;
    public CustomMessageListener t;
    public View u;
    public c.a.t0.r1.o.c v;
    public int w;
    public int x;
    public g y;

    /* loaded from: classes12.dex */
    public class a implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicView f44727e;

        public a(HotTopicView hotTopicView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44727e = hotTopicView;
        }

        @Override // c.a.s0.s.k0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (l.z()) {
                    this.f44727e.k.i();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
                    ((HotTopicActivity) this.f44727e.f44721e.getOrignalPage()).loadHotTopicData();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                this.f44727e.k.h(true);
                this.f44727e.f44722f.completePullRefreshPostDelayed(0L);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicView f44728e;

        public b(HotTopicView hotTopicView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44728e = hotTopicView;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) {
                this.f44728e.k.e(i2, i3);
                if (this.f44728e.m != null) {
                    this.f44728e.m.onScroll(absListView, i2, i3, i4);
                }
                this.f44728e.q(absListView, i2);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) {
                if (i2 == 0) {
                    this.f44728e.k.g();
                    v.b().c();
                }
                if (this.f44728e.m != null) {
                    this.f44728e.m.onScrollStateChanged(absListView, i2);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(HotTopicView hotTopicView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicView, Integer.valueOf(i2)};
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
            this.a = hotTopicView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.l == null || this.a.l.k() == null || this.a.l.k().f21887e == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Long) {
                RelateForumItemData l = this.a.l(((Long) data).longValue());
                if (l != null) {
                    l.followNum++;
                    l.setIsLiked(true);
                    this.a.l.k().f21888f = true;
                    this.a.f44724h.d(this.a.l);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(HotTopicView hotTopicView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicView, Integer.valueOf(i2)};
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
            this.a = hotTopicView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.l == null || this.a.l.k() == null || this.a.l.k().f21887e == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Long) {
                RelateForumItemData l = this.a.l(((Long) data).longValue());
                if (l != null) {
                    l.followNum--;
                    l.setIsLiked(false);
                    this.a.l.k().f21888f = true;
                    this.a.f44724h.d(this.a.l);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicView f44729e;

        public e(HotTopicView hotTopicView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44729e = hotTopicView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (view != this.f44729e.f44722f || this.f44729e.k == null) {
                    return false;
                }
                this.f44729e.k.f(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicView f44730e;

        public f(HotTopicView hotTopicView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44730e = hotTopicView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && l.A()) {
                this.f44730e.hideNetRefreshView();
                this.f44730e.showLoadingView(true);
                ((HotTopicActivity) this.f44730e.f44721e.getOrignalPage()).loadHotTopicData();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f44731e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HotTopicView f44732f;

        public g(HotTopicView hotTopicView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44732f = hotTopicView;
            this.f44731e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f44732f.f44722f.smoothScrollBy(Math.abs(this.f44731e), 1);
                this.f44732f.k();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.p = 0;
        this.q = new a(this);
        this.r = new b(this);
        this.s = new c(this, 2001335);
        this.t = new d(this, 2001336);
        m(context);
    }

    private int getLoadingViewTopMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            c.a.t0.r1.o.c cVar = this.v;
            if (cVar == null || cVar.s() == null) {
                return 0;
            }
            return this.v.t() + (((getHeight() - this.v.t()) - n.f(getContext(), c.a.t0.r1.c.tbds304)) / 2);
        }
        return invokeV.intValue;
    }

    private int getTopMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            c.a.t0.r1.o.c cVar = this.v;
            if (cVar == null || cVar.s() == null) {
                return 0;
            }
            return (int) Math.abs(this.v.t() + this.v.s().getY());
        }
        return invokeV.intValue;
    }

    public void changePlaceHolderHeaderViewHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            ViewGroup.LayoutParams layoutParams = this.u.getLayoutParams();
            layoutParams.height = i2;
            this.u.setLayoutParams(layoutParams);
            k();
        }
    }

    public void completePullRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || this.f44722f == null) {
            return;
        }
        this.k.h(true);
        if (z) {
            this.f44722f.completePullRefresh();
        } else {
            this.f44722f.completePullRefreshPostDelayed(0L);
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.s0.s.k0.g gVar = this.f44723g;
            if (gVar != null) {
                gVar.a(null);
            }
            c.a.t0.r1.k.d dVar = this.k;
            if (dVar != null) {
                dVar.c();
            }
            c.a.d.f.m.e.a().removeCallbacks(this.y);
        }
    }

    public BdTypeListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f44722f : (BdTypeListView) invokeV.objValue;
    }

    public void hideLoadMoreView() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bdTypeListView = this.f44722f) == null || this.o == null) {
            return;
        }
        bdTypeListView.setNextPage(null);
        this.o.j();
    }

    public void hideLoadingView() {
        c.a.t0.r1.o.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.s0.g0.g gVar = this.f44725i;
            if (gVar != null) {
                gVar.dettachView(this);
                this.f44725i = null;
            }
            if (n() || (cVar = this.v) == null || cVar.s() == null) {
                return;
            }
            this.f44722f.smoothScrollBy((int) (-this.v.s().getY()), 1);
        }
    }

    public void hideNetRefreshView() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (hVar = this.f44726j) == null) {
            return;
        }
        hVar.dettachView(this);
        this.f44726j = null;
    }

    public boolean isLoadingViewShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            c.a.s0.g0.g gVar = this.f44725i;
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
            h hVar = this.f44726j;
            if (hVar != null) {
                return hVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            View view = new View(getContext());
            this.u = view;
            view.setId(c.a.t0.r1.e.view_header);
            this.u.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
            this.f44722f.addHeaderView(this.u, 0);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (isRefreshViewShowing()) {
                this.f44726j.k(getTopMargin());
            }
            if (isLoadingViewShowing()) {
                this.f44725i.r(getLoadingViewTopMargin());
            }
        }
    }

    public final RelateForumItemData l(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j2)) == null) {
            c.a.t0.r1.l.e eVar = this.l;
            if (eVar == null || eVar.k() == null || this.l.k().f21887e == null) {
                return null;
            }
            for (c.a.d.n.e.n nVar : this.l.k().f21887e) {
                if (nVar != null && (nVar instanceof RelateForumItemData)) {
                    RelateForumItemData relateForumItemData = (RelateForumItemData) nVar;
                    if (relateForumItemData.forumId == j2) {
                        return relateForumItemData;
                    }
                }
            }
            return null;
        }
        return (RelateForumItemData) invokeJ.objValue;
    }

    public void listViewStartPullRefresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f44722f == null) {
            return;
        }
        this.k.h(false);
        this.f44722f.startPullRefresh();
    }

    public final void m(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, context) == null) {
            c.a.d.a.f<?> a2 = j.a(context);
            if (a2 instanceof TbPageContext) {
                this.f44721e = (TbPageContext) a2;
            }
            if (this.f44721e == null) {
                return;
            }
            BdTypeListView bdTypeListView = new BdTypeListView(context);
            this.f44722f = bdTypeListView;
            bdTypeListView.setVerticalScrollBarEnabled(false);
            this.f44722f.setDividerHeight(0);
            this.f44722f.setSelector(17170445);
            c.a.s0.s.k0.g gVar = new c.a.s0.s.k0.g(this.f44721e);
            this.f44723g = gVar;
            gVar.a(this.q);
            this.f44722f.setPullRefresh(this.f44723g);
            View view = new View(context);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(c.a.t0.r1.c.ds88)));
            this.f44722f.addFooterView(view);
            this.f44722f.setOnScrollListener(this.r);
            this.f44722f.setOnSrollToBottomListener(this.f44721e.getOrignalPage());
            this.f44722f.setOnTouchListener(new e(this));
            this.f44724h = new c.a.t0.r1.j.d(this.f44721e.getOrignalPage(), this.f44722f);
            addView(this.f44722f);
            ((FrameLayout.LayoutParams) this.f44722f.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(c.a.t0.r1.c.line_magin_bottom);
            this.k = new c.a.t0.r1.k.d(this.f44721e, this.f44722f);
            this.f44721e.registerListener(this.s);
            this.f44721e.registerListener(this.t);
            j();
            PbListView pbListView = new PbListView(context);
            this.o = pbListView;
            pbListView.a();
            this.o.p(c.a.t0.r1.b.CAM_X0205);
            this.o.y();
            this.o.F(SkinManager.getColor(c.a.t0.r1.b.CAM_X0109));
            this.o.B(c.a.t0.r1.b.CAM_X0110);
        }
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.v.s() != null && this.v.s().getY() == 0.0f : invokeV.booleanValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || n()) {
            return;
        }
        this.v.P(this.f44722f, Math.min(this.n, this.v.v()));
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            c.a.s0.s.k0.g gVar = this.f44723g;
            if (gVar != null) {
                gVar.C(i2);
            }
            c.a.s0.g0.g gVar2 = this.f44725i;
            if (gVar2 != null) {
                gVar2.onChangeSkinType();
            }
            h hVar = this.f44726j;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
            PbListView pbListView = this.o;
            if (pbListView != null) {
                pbListView.F(SkinManager.getColor(c.a.t0.r1.b.CAM_X0109));
                this.o.d(i2);
            }
            c.a.t0.r1.j.d dVar = this.f44724h;
            if (dVar != null) {
                dVar.b();
            }
            SkinManager.setBackgroundColor(this.f44722f, c.a.t0.r1.b.CAM_X0204);
            SkinManager.setBackgroundColor(this, c.a.t0.r1.b.CAM_X0201);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            destroy();
            super.onDetachedFromWindow();
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            c.a.t0.r1.o.c cVar = this.v;
            cVar.P(this.f44722f, Math.min(this.n, cVar.v()));
        }
    }

    public void pause() {
        c.a.t0.r1.k.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (dVar = this.k) == null) {
            return;
        }
        dVar.d(true);
    }

    public final void q(AbsListView absListView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048596, this, absListView, i2) == null) || this.v == null) {
            return;
        }
        if (absListView != null && absListView.getChildCount() > 0 && absListView.getChildAt(0) != null && i2 == 0) {
            int abs = Math.abs(absListView.getChildAt(0).getTop());
            this.n = abs;
            if (abs > this.x && this.w <= 1) {
                p();
            } else if (this.n < this.x) {
                o();
            }
            this.x = this.n;
        }
        this.w = i2;
    }

    public void refreshView(c.a.t0.r1.l.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, eVar) == null) || this.f44724h == null) {
            return;
        }
        if (eVar == null) {
            eVar = new c.a.t0.r1.l.e();
        }
        this.l = eVar;
        this.f44724h.c(eVar.n());
        this.f44724h.d(eVar);
        this.f44722f.setVisibility(0);
        if (ListUtils.isEmpty(eVar.i())) {
            return;
        }
        SkinManager.setBackgroundColor(this.f44722f, c.a.t0.r1.b.CAM_X0204);
    }

    public void resume() {
        c.a.t0.r1.k.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (dVar = this.k) == null) {
            return;
        }
        dVar.d(false);
    }

    public void scrollListView(int i2) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048599, this, i2) == null) || (bdTypeListView = this.f44722f) == null) {
            return;
        }
        bdTypeListView.smoothScrollBy(i2, 1);
        k();
    }

    public void scrollToTop(float f2) {
        c.a.t0.r1.l.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048600, this, f2) == null) || this.f44722f == null || (eVar = this.l) == null || eVar.k() == null) {
            return;
        }
        this.f44722f.setSelection(0);
        this.y = new g(this, (int) f2);
        c.a.d.f.m.e.a().post(this.y);
    }

    public void setMainView(c.a.t0.r1.o.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, cVar) == null) {
            this.v = cVar;
        }
    }

    public void setScrollCallback(c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, fVar) == null) {
            this.m = fVar;
        }
    }

    public void showLoadMoreView() {
        BdTypeListView bdTypeListView;
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (bdTypeListView = this.f44722f) == null || (pbListView = this.o) == null) {
            return;
        }
        bdTypeListView.setNextPage(pbListView);
        this.o.H(c.a.t0.r1.c.tbfontsize33);
        this.o.t(n.f(getContext(), c.a.t0.r1.c.tbds182));
        this.o.R();
    }

    public void showLoadingView(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048604, this, z) == null) || isLoadingViewShowing()) {
            return;
        }
        if (this.f44725i == null) {
            c.a.s0.g0.g gVar = new c.a.s0.g0.g(getContext());
            this.f44725i = gVar;
            gVar.r(getLoadingViewTopMargin());
            this.f44725i.h();
            this.f44725i.onChangeSkinType();
        }
        this.f44725i.attachView(this, z);
        this.f44722f.setVisibility(8);
    }

    public void showNetRefreshView(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048605, this, str, z) == null) || isRefreshViewShowing()) {
            return;
        }
        if (this.f44726j == null) {
            this.f44726j = new h(getContext(), new f(this));
        }
        this.f44726j.k(getTopMargin());
        this.f44726j.attachView(this, z);
        this.f44726j.p();
        this.f44722f.setVisibility(8);
    }

    public void showNoMoreView() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || this.f44722f == null || (pbListView = this.o) == null) {
            return;
        }
        int i2 = this.p;
        if (i2 > 0) {
            pbListView.M(i2);
        }
        this.f44722f.setNextPage(this.o);
        this.o.f();
        this.o.D(getContext().getResources().getString(c.a.t0.r1.h.list_no_more));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.p = 0;
        this.q = new a(this);
        this.r = new b(this);
        this.s = new c(this, 2001335);
        this.t = new d(this, 2001336);
        m(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        this.p = 0;
        this.q = new a(this);
        this.r = new b(this);
        this.s = new c(this, 2001335);
        this.t = new d(this, 2001336);
        m(context);
    }
}
