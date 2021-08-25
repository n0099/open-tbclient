package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.e.l.e.n;
import c.a.p0.f0.h;
import c.a.p0.s.f0.f;
import c.a.q0.a0.t;
import c.a.q0.h1.f.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class HotTopicView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int SMOOTH_SCROLL_DURATION = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<HotTopicActivity> f52588e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f52589f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.s.f0.g f52590g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.q0.h1.a.d f52591h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.p0.f0.g f52592i;

    /* renamed from: j  reason: collision with root package name */
    public h f52593j;
    public c.a.q0.h1.b.d k;
    public c.a.q0.h1.c.e l;
    public c.f m;
    public int n;
    public PbListView o;
    public int p;
    public f.g q;
    public AbsListView.OnScrollListener r;
    public CustomMessageListener s;
    public CustomMessageListener t;
    public View u;
    public c.a.q0.h1.f.c v;
    public int w;
    public int x;
    public g y;

    /* loaded from: classes7.dex */
    public class a implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicView f52594e;

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
            this.f52594e = hotTopicView;
        }

        @Override // c.a.p0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (j.z()) {
                    this.f52594e.k.i();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
                    ((HotTopicActivity) this.f52594e.f52588e.getOrignalPage()).loadHotTopicData();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                this.f52594e.k.h(true);
                this.f52594e.f52589f.completePullRefreshPostDelayed(0L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicView f52595e;

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
            this.f52595e = hotTopicView;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) {
                this.f52595e.k.e(i2, i3);
                if (this.f52595e.m != null) {
                    this.f52595e.m.onScroll(absListView, i2, i3, i4);
                }
                this.f52595e.q(absListView, i2);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) {
                if (i2 == 0) {
                    this.f52595e.k.g();
                    t.b().c();
                }
                if (this.f52595e.m != null) {
                    this.f52595e.m.onScrollStateChanged(absListView, i2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotTopicView f52596a;

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
            this.f52596a = hotTopicView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f52596a.l == null || this.f52596a.l.k() == null || this.f52596a.l.k().f18657e == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Long) {
                RelateForumItemData l = this.f52596a.l(((Long) data).longValue());
                if (l != null) {
                    l.followNum++;
                    l.setIsLiked(true);
                    this.f52596a.l.k().f18658f = true;
                    this.f52596a.f52591h.d(this.f52596a.l);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotTopicView f52597a;

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
            this.f52597a = hotTopicView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f52597a.l == null || this.f52597a.l.k() == null || this.f52597a.l.k().f18657e == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Long) {
                RelateForumItemData l = this.f52597a.l(((Long) data).longValue());
                if (l != null) {
                    l.followNum--;
                    l.setIsLiked(false);
                    this.f52597a.l.k().f18658f = true;
                    this.f52597a.f52591h.d(this.f52597a.l);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicView f52598e;

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
            this.f52598e = hotTopicView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (view != this.f52598e.f52589f || this.f52598e.k == null) {
                    return false;
                }
                this.f52598e.k.f(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicView f52599e;

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
            this.f52599e = hotTopicView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && j.A()) {
                this.f52599e.hideNetRefreshView();
                this.f52599e.showLoadingView(true);
                ((HotTopicActivity) this.f52599e.f52588e.getOrignalPage()).loadHotTopicData();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f52600e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HotTopicView f52601f;

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
            this.f52601f = hotTopicView;
            this.f52600e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f52601f.f52589f.smoothScrollBy(Math.abs(this.f52600e), 1);
                this.f52601f.k();
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
            c.a.q0.h1.f.c cVar = this.v;
            if (cVar == null || cVar.s() == null) {
                return 0;
            }
            return this.v.t() + (((getHeight() - this.v.t()) - l.g(getContext(), R.dimen.tbds304)) / 2);
        }
        return invokeV.intValue;
    }

    private int getTopMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            c.a.q0.h1.f.c cVar = this.v;
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
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || this.f52589f == null) {
            return;
        }
        this.k.h(true);
        if (z) {
            this.f52589f.completePullRefresh();
        } else {
            this.f52589f.completePullRefreshPostDelayed(0L);
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.p0.s.f0.g gVar = this.f52590g;
            if (gVar != null) {
                gVar.a(null);
            }
            c.a.q0.h1.b.d dVar = this.k;
            if (dVar != null) {
                dVar.c();
            }
            c.a.e.e.m.e.a().removeCallbacks(this.y);
        }
    }

    public BdTypeListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f52589f : (BdTypeListView) invokeV.objValue;
    }

    public void hideLoadMoreView() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bdTypeListView = this.f52589f) == null || this.o == null) {
            return;
        }
        bdTypeListView.setNextPage(null);
        this.o.i();
    }

    public void hideLoadingView() {
        c.a.q0.h1.f.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.p0.f0.g gVar = this.f52592i;
            if (gVar != null) {
                gVar.dettachView(this);
                this.f52592i = null;
            }
            if (n() || (cVar = this.v) == null || cVar.s() == null) {
                return;
            }
            this.f52589f.smoothScrollBy((int) (-this.v.s().getY()), 1);
        }
    }

    public void hideNetRefreshView() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (hVar = this.f52593j) == null) {
            return;
        }
        hVar.dettachView(this);
        this.f52593j = null;
    }

    public boolean isLoadingViewShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            c.a.p0.f0.g gVar = this.f52592i;
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
            h hVar = this.f52593j;
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
            view.setId(R.id.view_header);
            this.u.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
            this.f52589f.addHeaderView(this.u, 0);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (isRefreshViewShowing()) {
                this.f52593j.j(getTopMargin());
            }
            if (isLoadingViewShowing()) {
                this.f52592i.q(getLoadingViewTopMargin());
            }
        }
    }

    public final RelateForumItemData l(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j2)) == null) {
            c.a.q0.h1.c.e eVar = this.l;
            if (eVar == null || eVar.k() == null || this.l.k().f18657e == null) {
                return null;
            }
            for (n nVar : this.l.k().f18657e) {
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
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f52589f == null) {
            return;
        }
        this.k.h(false);
        this.f52589f.startPullRefresh();
    }

    public final void m(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, context) == null) {
            c.a.e.a.f<?> a2 = c.a.e.a.j.a(context);
            if (a2 instanceof TbPageContext) {
                this.f52588e = (TbPageContext) a2;
            }
            if (this.f52588e == null) {
                return;
            }
            BdTypeListView bdTypeListView = new BdTypeListView(context);
            this.f52589f = bdTypeListView;
            bdTypeListView.setVerticalScrollBarEnabled(false);
            this.f52589f.setDividerHeight(0);
            this.f52589f.setSelector(17170445);
            c.a.p0.s.f0.g gVar = new c.a.p0.s.f0.g(this.f52588e);
            this.f52590g = gVar;
            gVar.a(this.q);
            this.f52589f.setPullRefresh(this.f52590g);
            View view = new View(context);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88)));
            this.f52589f.addFooterView(view);
            this.f52589f.setOnScrollListener(this.r);
            this.f52589f.setOnSrollToBottomListener(this.f52588e.getOrignalPage());
            this.f52589f.setOnTouchListener(new e(this));
            this.f52591h = new c.a.q0.h1.a.d(this.f52588e.getOrignalPage(), this.f52589f);
            addView(this.f52589f);
            ((FrameLayout.LayoutParams) this.f52589f.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.line_magin_bottom);
            this.k = new c.a.q0.h1.b.d(this.f52588e, this.f52589f);
            this.f52588e.registerListener(this.s);
            this.f52588e.registerListener(this.t);
            j();
            PbListView pbListView = new PbListView(context);
            this.o = pbListView;
            pbListView.a();
            this.o.o(R.color.CAM_X0205);
            this.o.v();
            this.o.C(SkinManager.getColor(R.color.CAM_X0109));
            this.o.y(R.color.CAM_X0110);
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
        this.v.P(this.f52589f, Math.min(this.n, this.v.v()));
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            c.a.p0.s.f0.g gVar = this.f52590g;
            if (gVar != null) {
                gVar.D(i2);
            }
            c.a.p0.f0.g gVar2 = this.f52592i;
            if (gVar2 != null) {
                gVar2.onChangeSkinType();
            }
            h hVar = this.f52593j;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
            PbListView pbListView = this.o;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
                this.o.d(i2);
            }
            c.a.q0.h1.a.d dVar = this.f52591h;
            if (dVar != null) {
                dVar.b();
            }
            SkinManager.setBackgroundColor(this.f52589f, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
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
            c.a.q0.h1.f.c cVar = this.v;
            cVar.P(this.f52589f, Math.min(this.n, cVar.v()));
        }
    }

    public void pause() {
        c.a.q0.h1.b.d dVar;
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

    public void refreshView(c.a.q0.h1.c.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, eVar) == null) || this.f52591h == null) {
            return;
        }
        if (eVar == null) {
            eVar = new c.a.q0.h1.c.e();
        }
        this.l = eVar;
        this.f52591h.c(eVar.n());
        this.f52591h.d(eVar);
        this.f52589f.setVisibility(0);
        if (ListUtils.isEmpty(eVar.i())) {
            return;
        }
        SkinManager.setBackgroundColor(this.f52589f, R.color.CAM_X0204);
    }

    public void resume() {
        c.a.q0.h1.b.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (dVar = this.k) == null) {
            return;
        }
        dVar.d(false);
    }

    public void scrollListView(int i2) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048599, this, i2) == null) || (bdTypeListView = this.f52589f) == null) {
            return;
        }
        bdTypeListView.smoothScrollBy(i2, 1);
        k();
    }

    public void scrollToTop(float f2) {
        c.a.q0.h1.c.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048600, this, f2) == null) || this.f52589f == null || (eVar = this.l) == null || eVar.k() == null) {
            return;
        }
        this.f52589f.setSelection(0);
        this.y = new g(this, (int) f2);
        c.a.e.e.m.e.a().post(this.y);
    }

    public void setMainView(c.a.q0.h1.f.c cVar) {
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
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (bdTypeListView = this.f52589f) == null || (pbListView = this.o) == null) {
            return;
        }
        bdTypeListView.setNextPage(pbListView);
        this.o.E(R.dimen.tbfontsize33);
        this.o.r(l.g(getContext(), R.dimen.tbds182));
        this.o.O();
    }

    public void showLoadingView(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048604, this, z) == null) || isLoadingViewShowing()) {
            return;
        }
        if (this.f52592i == null) {
            c.a.p0.f0.g gVar = new c.a.p0.f0.g(getContext());
            this.f52592i = gVar;
            gVar.q(getLoadingViewTopMargin());
            this.f52592i.h();
            this.f52592i.onChangeSkinType();
        }
        this.f52592i.attachView(this, z);
        this.f52589f.setVisibility(8);
    }

    public void showNetRefreshView(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048605, this, str, z) == null) || isRefreshViewShowing()) {
            return;
        }
        if (this.f52593j == null) {
            this.f52593j = new h(getContext(), new f(this));
        }
        this.f52593j.j(getTopMargin());
        this.f52593j.attachView(this, z);
        this.f52593j.o();
        this.f52589f.setVisibility(8);
    }

    public void showNoMoreView() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || this.f52589f == null || (pbListView = this.o) == null) {
            return;
        }
        int i2 = this.p;
        if (i2 > 0) {
            pbListView.J(i2);
        }
        this.f52589f.setNextPage(this.o);
        this.o.f();
        this.o.A(getContext().getResources().getString(R.string.list_no_more));
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
