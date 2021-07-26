package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
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
import d.a.d.e.p.j;
import d.a.d.e.p.l;
import d.a.d.k.e.n;
import d.a.p0.f0.h;
import d.a.p0.s.f0.f;
import d.a.q0.a0.t;
import d.a.q0.g1.f.c;
/* loaded from: classes4.dex */
public class HotTopicView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<HotTopicActivity> f17233e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f17234f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.p0.s.f0.g f17235g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.q0.g1.a.d f17236h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.p0.f0.g f17237i;
    public h j;
    public d.a.q0.g1.b.d k;
    public d.a.q0.g1.c.e l;
    public c.f m;
    public int n;
    public PbListView o;
    public int p;
    public f.g q;
    public AbsListView.OnScrollListener r;
    public CustomMessageListener s;
    public CustomMessageListener t;
    public View u;
    public d.a.q0.g1.f.c v;
    public int w;
    public int x;
    public g y;

    /* loaded from: classes4.dex */
    public class a implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicView f17238e;

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
            this.f17238e = hotTopicView;
        }

        @Override // d.a.p0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (j.z()) {
                    this.f17238e.k.i();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
                    ((HotTopicActivity) this.f17238e.f17233e.getOrignalPage()).loadHotTopicData();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                this.f17238e.k.h(true);
                this.f17238e.f17234f.A(0L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicView f17239e;

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
            this.f17239e = hotTopicView;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) {
                this.f17239e.k.e(i2, i3);
                if (this.f17239e.m != null) {
                    this.f17239e.m.onScroll(absListView, i2, i3, i4);
                }
                this.f17239e.I(absListView, i2);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) {
                if (i2 == 0) {
                    this.f17239e.k.g();
                    t.b().c();
                }
                if (this.f17239e.m != null) {
                    this.f17239e.m.onScrollStateChanged(absListView, i2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotTopicView f17240a;

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
            this.f17240a = hotTopicView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f17240a.l == null || this.f17240a.l.k() == null || this.f17240a.l.k().f56991e == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Long) {
                RelateForumItemData o = this.f17240a.o(((Long) data).longValue());
                if (o != null) {
                    o.followNum++;
                    o.setIsLiked(true);
                    this.f17240a.l.k().f56992f = true;
                    this.f17240a.f17236h.d(this.f17240a.l);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotTopicView f17241a;

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
            this.f17241a = hotTopicView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f17241a.l == null || this.f17241a.l.k() == null || this.f17241a.l.k().f56991e == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Long) {
                RelateForumItemData o = this.f17241a.o(((Long) data).longValue());
                if (o != null) {
                    o.followNum--;
                    o.setIsLiked(false);
                    this.f17241a.l.k().f56992f = true;
                    this.f17241a.f17236h.d(this.f17241a.l);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicView f17242e;

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
            this.f17242e = hotTopicView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (view != this.f17242e.f17234f || this.f17242e.k == null) {
                    return false;
                }
                this.f17242e.k.f(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicView f17243e;

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
            this.f17243e = hotTopicView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && j.A()) {
                this.f17243e.r();
                this.f17243e.F(true);
                ((HotTopicActivity) this.f17243e.f17233e.getOrignalPage()).loadHotTopicData();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f17244e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HotTopicView f17245f;

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
            this.f17245f = hotTopicView;
            this.f17244e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f17245f.f17234f.smoothScrollBy(Math.abs(this.f17244e), 1);
                this.f17245f.l();
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
        s(context);
    }

    private int getLoadingViewTopMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            d.a.q0.g1.f.c cVar = this.v;
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
            d.a.q0.g1.f.c cVar = this.v;
            if (cVar == null || cVar.s() == null) {
                return 0;
            }
            return (int) Math.abs(this.v.t() + this.v.s().getY());
        }
        return invokeV.intValue;
    }

    public void A(d.a.q0.g1.c.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || this.f17236h == null) {
            return;
        }
        if (eVar == null) {
            eVar = new d.a.q0.g1.c.e();
        }
        this.l = eVar;
        this.f17236h.c(eVar.n());
        this.f17236h.d(eVar);
        this.f17234f.setVisibility(0);
        if (ListUtils.isEmpty(eVar.i())) {
            return;
        }
        SkinManager.setBackgroundColor(this.f17234f, R.color.CAM_X0204);
    }

    public void B() {
        d.a.q0.g1.b.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (dVar = this.k) == null) {
            return;
        }
        dVar.d(false);
    }

    public void C(int i2) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (bdTypeListView = this.f17234f) == null) {
            return;
        }
        bdTypeListView.smoothScrollBy(i2, 1);
        l();
    }

    public void D(float f2) {
        d.a.q0.g1.c.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048579, this, f2) == null) || this.f17234f == null || (eVar = this.l) == null || eVar.k() == null) {
            return;
        }
        this.f17234f.setSelection(0);
        this.y = new g(this, (int) f2);
        d.a.d.e.m.e.a().post(this.y);
    }

    public void E() {
        BdTypeListView bdTypeListView;
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bdTypeListView = this.f17234f) == null || (pbListView = this.o) == null) {
            return;
        }
        bdTypeListView.setNextPage(pbListView);
        this.o.E(R.dimen.tbfontsize33);
        this.o.r(l.g(getContext(), R.dimen.tbds182));
        this.o.O();
    }

    public void F(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || u()) {
            return;
        }
        if (this.f17237i == null) {
            d.a.p0.f0.g gVar = new d.a.p0.f0.g(getContext());
            this.f17237i = gVar;
            gVar.q(getLoadingViewTopMargin());
            this.f17237i.h();
            this.f17237i.onChangeSkinType();
        }
        this.f17237i.attachView(this, z);
        this.f17234f.setVisibility(8);
    }

    public void G(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048582, this, str, z) == null) || v()) {
            return;
        }
        if (this.j == null) {
            this.j = new h(getContext(), new f(this));
        }
        this.j.j(getTopMargin());
        this.j.attachView(this, z);
        this.j.o();
        this.f17234f.setVisibility(8);
    }

    public void H() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f17234f == null || (pbListView = this.o) == null) {
            return;
        }
        int i2 = this.p;
        if (i2 > 0) {
            pbListView.J(i2);
        }
        this.f17234f.setNextPage(this.o);
        this.o.f();
        this.o.A(getContext().getResources().getString(R.string.list_no_more));
    }

    public final void I(AbsListView absListView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, absListView, i2) == null) || this.v == null) {
            return;
        }
        if (absListView != null && absListView.getChildCount() > 0 && absListView.getChildAt(0) != null && i2 == 0) {
            int abs = Math.abs(absListView.getChildAt(0).getTop());
            this.n = abs;
            if (abs > this.x && this.w <= 1) {
                y();
            } else if (this.n < this.x) {
                x();
            }
            this.x = this.n;
        }
        this.w = i2;
    }

    public BdTypeListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f17234f : (BdTypeListView) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            View view = new View(getContext());
            this.u = view;
            view.setId(R.id.view_header);
            this.u.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
            this.f17234f.x(this.u, 0);
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            ViewGroup.LayoutParams layoutParams = this.u.getLayoutParams();
            layoutParams.height = i2;
            this.u.setLayoutParams(layoutParams);
            l();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (v()) {
                this.j.j(getTopMargin());
            }
            if (u()) {
                this.f17237i.q(getLoadingViewTopMargin());
            }
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || this.f17234f == null) {
            return;
        }
        this.k.h(true);
        if (z) {
            this.f17234f.z();
        } else {
            this.f17234f.A(0L);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            d.a.p0.s.f0.g gVar = this.f17235g;
            if (gVar != null) {
                gVar.a(null);
            }
            d.a.q0.g1.b.d dVar = this.k;
            if (dVar != null) {
                dVar.c();
            }
            d.a.d.e.m.e.a().removeCallbacks(this.y);
        }
    }

    public final RelateForumItemData o(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048591, this, j)) == null) {
            d.a.q0.g1.c.e eVar = this.l;
            if (eVar == null || eVar.k() == null || this.l.k().f56991e == null) {
                return null;
            }
            for (n nVar : this.l.k().f56991e) {
                if (nVar != null && (nVar instanceof RelateForumItemData)) {
                    RelateForumItemData relateForumItemData = (RelateForumItemData) nVar;
                    if (relateForumItemData.forumId == j) {
                        return relateForumItemData;
                    }
                }
            }
            return null;
        }
        return (RelateForumItemData) invokeJ.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            n();
            super.onDetachedFromWindow();
        }
    }

    public void p() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (bdTypeListView = this.f17234f) == null || this.o == null) {
            return;
        }
        bdTypeListView.setNextPage(null);
        this.o.i();
    }

    public void q() {
        d.a.q0.g1.f.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            d.a.p0.f0.g gVar = this.f17237i;
            if (gVar != null) {
                gVar.dettachView(this);
                this.f17237i = null;
            }
            if (t() || (cVar = this.v) == null || cVar.s() == null) {
                return;
            }
            this.f17234f.smoothScrollBy((int) (-this.v.s().getY()), 1);
        }
    }

    public void r() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (hVar = this.j) == null) {
            return;
        }
        hVar.dettachView(this);
        this.j = null;
    }

    public final void s(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, context) == null) {
            d.a.d.a.f<?> a2 = d.a.d.a.j.a(context);
            if (a2 instanceof TbPageContext) {
                this.f17233e = (TbPageContext) a2;
            }
            if (this.f17233e == null) {
                return;
            }
            BdTypeListView bdTypeListView = new BdTypeListView(context);
            this.f17234f = bdTypeListView;
            bdTypeListView.setVerticalScrollBarEnabled(false);
            this.f17234f.setDividerHeight(0);
            this.f17234f.setSelector(17170445);
            d.a.p0.s.f0.g gVar = new d.a.p0.s.f0.g(this.f17233e);
            this.f17235g = gVar;
            gVar.a(this.q);
            this.f17234f.setPullRefresh(this.f17235g);
            View view = new View(context);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88)));
            this.f17234f.addFooterView(view);
            this.f17234f.setOnScrollListener(this.r);
            this.f17234f.setOnSrollToBottomListener(this.f17233e.getOrignalPage());
            this.f17234f.setOnTouchListener(new e(this));
            this.f17236h = new d.a.q0.g1.a.d(this.f17233e.getOrignalPage(), this.f17234f);
            addView(this.f17234f);
            ((FrameLayout.LayoutParams) this.f17234f.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.line_magin_bottom);
            this.k = new d.a.q0.g1.b.d(this.f17233e, this.f17234f);
            this.f17233e.registerListener(this.s);
            this.f17233e.registerListener(this.t);
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

    public void setMainView(d.a.q0.g1.f.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, cVar) == null) {
            this.v = cVar;
        }
    }

    public void setScrollCallback(c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, fVar) == null) {
            this.m = fVar;
        }
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.v.s() != null && this.v.s().getY() == 0.0f : invokeV.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            d.a.p0.f0.g gVar = this.f17237i;
            if (gVar != null) {
                return gVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            h hVar = this.j;
            if (hVar != null) {
                return hVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            d.a.p0.s.f0.g gVar = this.f17235g;
            if (gVar != null) {
                gVar.I(i2);
            }
            d.a.p0.f0.g gVar2 = this.f17237i;
            if (gVar2 != null) {
                gVar2.onChangeSkinType();
            }
            h hVar = this.j;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
            PbListView pbListView = this.o;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
                this.o.d(i2);
            }
            d.a.q0.g1.a.d dVar = this.f17236h;
            if (dVar != null) {
                dVar.b();
            }
            SkinManager.setBackgroundColor(this.f17234f, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || t()) {
            return;
        }
        this.v.P(this.f17234f, Math.min(this.n, this.v.v()));
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            d.a.q0.g1.f.c cVar = this.v;
            cVar.P(this.f17234f, Math.min(this.n, cVar.v()));
        }
    }

    public void z() {
        d.a.q0.g1.b.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (dVar = this.k) == null) {
            return;
        }
        dVar.d(true);
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
        s(context);
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
        s(context);
    }
}
