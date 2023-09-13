package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.bv5;
import com.baidu.tieba.dv5;
import com.baidu.tieba.sv5;
import com.baidu.tieba.z95;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class bw5<Q extends dv5, P extends bv5> extends wv5<Q, P> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bu5 b;
    public du5<Q, P> c;
    public jv5 d;
    public BdUniqueId e;
    public TbPageContext f;
    public eu5 g;
    public BdTypeRecyclerView h;
    public BdSwipeRefreshLayout i;
    public aa5 j;
    public xv5 k;
    public yv5<P> l;
    public BdListView.p m;
    public fz9 n;
    public View.OnClickListener o;
    public final BdListView.p p;
    public final RecyclerView.OnScrollListener q;
    public final RecyclerView.RecyclerListener r;
    public final z95.g s;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bw5 a;

        public a(bw5 bw5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bw5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bw5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                tv5.b(" ----LoadMoreClickListener----");
                if (this.a.h != null) {
                    this.a.h.stopScroll();
                }
                this.a.n();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bw5 a;

        public b(bw5 bw5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bw5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bw5Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                tv5.b(" ----onScrollToBottom----");
                if (this.a.h != null) {
                    this.a.h.stopScroll();
                }
                if (this.a.m != null) {
                    this.a.m.onScrollToBottom();
                }
                this.a.n();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ bw5 b;

        public c(bw5 bw5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bw5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bw5Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) && i == 0) {
                this.b.A(this.a);
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
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bw5 a;

        public d(bw5 bw5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bw5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bw5Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) && viewHolder != null && viewHolder.itemView != null && this.a.n != null) {
                this.a.n.k(viewHolder.itemView);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements z95.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bw5 a;

        public e(bw5 bw5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bw5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bw5Var;
        }

        @Override // com.baidu.tieba.z95.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                tv5.b(" ----onListPullRefresh---- auto=" + z);
                this.a.o(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbPageContext<?> a;
        public yv5 b;
        public xv5 c;
        public sv5.c d;
        public List<pm> e;
        public wz4<b15> f;
        public uu5 g;
        public int h;
        public int i;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = 2;
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.d == null) {
                this.d = new sv5.c();
            }
        }

        public f a(List<pm> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
                this.e = list;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public f b(sv5.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                this.d = cVar;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public bw5 c(TbPageContext<?> tbPageContext) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext)) == null) {
                this.a = tbPageContext;
                d();
                return new bw5(this, null);
            }
            return (bw5) invokeL.objValue;
        }

        public f e(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                this.h = i;
                return this;
            }
            return (f) invokeI.objValue;
        }

        public f f(xv5 xv5Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, xv5Var)) == null) {
                this.c = xv5Var;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public f g(wz4<b15> wz4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, wz4Var)) == null) {
                this.f = wz4Var;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public f h(uu5 uu5Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, uu5Var)) == null) {
                this.g = uu5Var;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public f i(yv5 yv5Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, yv5Var)) == null) {
                this.b = yv5Var;
                return this;
            }
            return (f) invokeL.objValue;
        }
    }

    public bw5(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new a(this);
        this.p = new b(this);
        this.q = new c(this);
        this.r = new d(this);
        this.s = new e(this);
        TbPageContext<?> tbPageContext = fVar.a;
        this.f = tbPageContext;
        this.k = fVar.c;
        this.l = fVar.b;
        this.e = tbPageContext.getUniqueId();
        this.b = new bu5();
        s(fVar.d);
        r(fVar.i);
        eu5 eu5Var = new eu5(this.f, this.h);
        this.g = eu5Var;
        eu5Var.a(fVar.e);
        this.g.k(this.h);
        this.g.i(fVar.f);
        this.g.f(fVar.g);
        this.g.e(fVar.h);
    }

    public final void s(sv5.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, cVar) == null) {
            this.i = new BdSwipeRefreshLayout(getActivity());
            this.h = new BdTypeRecyclerView(getActivity());
            K();
            this.i.addView(this.h);
            this.h.setLayoutManager(new LinearLayoutManager(getActivity()));
            this.h.setFadingEdgeLength(0);
            this.h.setVerticalScrollBarEnabled(false);
            this.h.setOverScrollMode(2);
            this.h.setOnSrollToBottomListener(this.p);
            this.h.addOnScrollListener(this.q);
            this.h.setRecyclerListener(this.r);
            if (this.k == null) {
                cVar.h = this.o;
                this.k = new cw5(this.f, this.h, cVar);
            }
            aa5 aa5Var = new aa5(this.f);
            this.j = aa5Var;
            aa5Var.a(this.s);
            this.i.setProgressView(this.j);
            jv5 jv5Var = new jv5(this.h);
            this.d = jv5Var;
            jv5Var.e(this.e);
        }
    }

    public /* synthetic */ bw5(f fVar, a aVar) {
        this(fVar);
    }

    public final String p(int i, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048599, this, i, objArr)) == null) {
            return TbadkCoreApplication.getInst().getResources().getString(i, objArr);
        }
        return (String) invokeIL.objValue;
    }

    public final void A(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        fz9 fz9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (bdTypeRecyclerView = this.h) != null && (fz9Var = this.n) != null) {
            fz9Var.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.h.getLastVisiblePosition(), z, true);
        }
    }

    public final void B(av5 av5Var) {
        List<cn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, av5Var) == null) && av5Var != null && (list = av5Var.a) != null) {
            I(list);
        }
    }

    public void C(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && (bdSwipeRefreshLayout = this.i) != null) {
            bdSwipeRefreshLayout.setRefreshing(z);
        }
    }

    public void I(List<cn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            tv5.b(" ----submitDataList--size =" + ListUtils.getCount(list));
            eu5 eu5Var = this.g;
            if (eu5Var != null) {
                eu5Var.h(list);
            }
        }
    }

    @Override // com.baidu.tieba.wv5
    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bdUniqueId) == null) {
            fz9 fz9Var = this.n;
            if (fz9Var != null) {
                fz9Var.u(bdUniqueId);
            }
            jv5 jv5Var = this.d;
            if (jv5Var != null) {
                jv5Var.e(bdUniqueId);
            }
            eu5 eu5Var = this.g;
            if (eu5Var != null) {
                eu5Var.j(bdUniqueId);
            }
        }
    }

    @Override // com.baidu.tieba.wv5
    public void i(du5 du5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, du5Var) == null) {
            this.c = du5Var;
            du5Var.b(this.b);
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            tv5.b(" ----callRefresh---- ");
            if (z) {
                if (t()) {
                    this.c.r();
                } else {
                    J();
                    C(true);
                }
            }
            this.c.f(true);
        }
    }

    @Override // com.baidu.tieba.aw5
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            xv5 xv5Var = this.k;
            if (xv5Var != null) {
                xv5Var.onChangeSkinType(i);
            }
            aa5 aa5Var = this.j;
            if (aa5Var != null) {
                aa5Var.C(i);
            }
            yv5<P> yv5Var = this.l;
            if (yv5Var != null) {
                yv5Var.onChangeSkinType(i);
            }
            K();
            u();
        }
    }

    public final void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            if (i == 1 || i == 0 || i == 2) {
                fz9 fz9Var = new fz9(this.f, this.h);
                this.n = fz9Var;
                fz9Var.p(i);
                this.n.u(this.e);
            }
        }
    }

    public void y(List<pm> list) {
        eu5 eu5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, list) == null) && (eu5Var = this.g) != null) {
            eu5Var.g(list);
            this.g.k(this.h);
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (!q()) {
                H();
            } else {
                F();
            }
        }
    }

    public final void F() {
        xv5 xv5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (xv5Var = this.k) != null) {
            xv5Var.a();
        }
    }

    public final void G() {
        xv5 xv5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (xv5Var = this.k) != null) {
            xv5Var.b();
        }
    }

    public final void H() {
        xv5 xv5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (xv5Var = this.k) != null) {
            xv5Var.c();
        }
    }

    public void J() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (bdTypeRecyclerView = this.h) != null) {
            bdTypeRecyclerView.scrollToPosition(0);
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.h.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0202);
        }
    }

    @Override // com.baidu.tieba.wv5
    public void d() {
        fz9 fz9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (fz9Var = this.n) != null) {
            fz9Var.h();
        }
    }

    @Override // com.baidu.tieba.wv5
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            w();
        }
    }

    @Override // com.baidu.tieba.wv5
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            z();
        }
    }

    @Override // com.baidu.tieba.wv5
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            tv5.b(" ----sendReq---- ");
            o(true);
        }
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.f.getPageActivity();
        }
        return (Activity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vv5
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.i;
        }
        return (View) invokeV.objValue;
    }

    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.b.c();
        }
        return invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return ListUtils.isEmpty(this.h.getData());
        }
        return invokeV.booleanValue;
    }

    public void u() {
        eu5 eu5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && (eu5Var = this.g) != null) {
            eu5Var.d();
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            x();
        }
    }

    public final void x() {
        fz9 fz9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && (fz9Var = this.n) != null) {
            fz9Var.z();
            this.n.r(false);
        }
    }

    public void z() {
        fz9 fz9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && (fz9Var = this.n) != null) {
            fz9Var.r(true);
            A(false);
        }
    }

    public final void E(P p) {
        yv5<P> yv5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, p) == null) && this.h != null && (yv5Var = this.l) != null && yv5Var.getView() != null) {
            if (this.l.onBindDataToView(p) != null) {
                this.h.setHeaderView(this.l.getView());
            } else {
                this.h.removeHeaderView(this.l.getView());
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            tv5.b(" ----loadMore---- ");
            if (q()) {
                G();
                if (t()) {
                    this.c.r();
                } else {
                    this.c.s();
                }
                this.c.g();
                return;
            }
            if (t()) {
                this.c.r();
            } else {
                this.c.s();
            }
            F();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.zv5
    /* renamed from: v */
    public av5 onBindDataToView(P p) {
        InterceptResult invokeL;
        String p2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, p)) == null) {
            tv5.b(" ----onBindDataToView---- ");
            C(false);
            if (p != null && p.getErrorCode() == 0) {
                tv5.b(" ----showContent---- ");
                av5 d2 = this.d.d(this.c.e(), this.c.d());
                if (d2 != null && !ListUtils.isEmpty(d2.a)) {
                    this.c.s();
                    E(p);
                    D();
                    B(d2);
                    A(false);
                } else {
                    this.c.p(p.getErrorMsg());
                }
                return d2;
            }
            tv5.b(" ----showError---- ");
            if (!ListUtils.isEmpty(this.h.getData())) {
                D();
                return null;
            }
            du5<Q, P> du5Var = this.c;
            if (p != null) {
                p2 = p.getErrorMsg();
            } else {
                p2 = p(R.string.obfuscated_res_0x7f0f06ac, new Object[0]);
            }
            du5Var.q(p2);
            return null;
        }
        return (av5) invokeL.objValue;
    }
}
