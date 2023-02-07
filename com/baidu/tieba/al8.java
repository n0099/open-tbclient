package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class al8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zk8 a;
    public ok8 b;
    public vk8 c;
    public nk8 d;
    public pk8 e;
    public uk8 f;
    public rk8 g;
    public xk8 h;
    public qk8 i;
    public uh8 j;
    public rh8 k;
    public cl8 l;
    public jl8 m;
    public gl8 n;
    public ll8 o;
    public kl8 p;
    public dl8 q;
    public fl8 r;
    public el8 s;
    public hl8 t;
    public il8 u;
    public List<qn> v;
    public BdTypeRecyclerView w;

    public al8(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeRecyclerView, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v = new ArrayList();
        a(tbPageContext, bdTypeRecyclerView);
        e(bdUniqueId);
    }

    public final void a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, tbPageContext, bdTypeRecyclerView) == null) {
            this.w = bdTypeRecyclerView;
            this.a = new zk8(tbPageContext);
            this.b = new ok8(tbPageContext);
            this.c = new vk8(tbPageContext);
            this.d = new nk8(tbPageContext);
            this.e = new pk8(tbPageContext);
            this.f = new uk8(tbPageContext, tbPageContext.getUniqueId());
            this.g = new rk8(tbPageContext, dm8.h);
            this.h = new xk8(tbPageContext);
            this.i = new qk8(tbPageContext);
            this.j = new uh8(tbPageContext, wh8.b);
            this.k = new rh8(tbPageContext.getPageActivity(), nh8.d);
            this.l = new cl8(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
            this.m = new jl8(tbPageContext, ae6.i0);
            this.n = new gl8(tbPageContext, ae6.r0);
            this.o = new ll8(tbPageContext, be6.U);
            this.p = new kl8(tbPageContext, ae6.s0);
            this.s = new el8(tbPageContext, ae6.u0);
            this.t = new hl8(tbPageContext, ae6.t0);
            this.u = new il8(tbPageContext, ae6.v0);
            this.q = new dl8(tbPageContext, vd6.P0);
            this.r = new fl8(tbPageContext, wd6.P0);
            this.v.add(this.a);
            this.v.add(this.b);
            this.v.add(this.c);
            this.v.add(this.d);
            this.v.add(this.e);
            this.v.add(this.f);
            this.v.add(this.g);
            this.v.add(this.h);
            this.v.add(this.i);
            this.v.add(this.j);
            this.v.add(this.k);
            this.v.add(this.l);
            this.v.add(this.m);
            this.v.add(this.n);
            this.v.add(this.o);
            this.v.add(this.p);
            this.v.add(this.s);
            this.v.add(this.t);
            this.v.add(this.u);
            this.v.add(this.q);
            this.v.add(this.r);
            bdTypeRecyclerView.a(this.v);
            c("page_recommend");
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.w.getListAdapter() != null) {
            this.w.getListAdapter().notifyDataSetChanged();
        }
    }

    public final void c(String str) {
        List<qn> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) != null) || (list = this.v) == null) {
            return;
        }
        for (qn qnVar : list) {
            if (qnVar instanceof mw5) {
                ((mw5) qnVar).g(str);
            }
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.l.u(z);
            this.c.w(z);
            this.m.x(z);
            this.n.v(z);
            this.o.w(z);
            this.p.v(z);
            this.q.y(z);
            this.r.x(z);
            this.s.x(z);
            this.t.x(z);
            this.u.x(z);
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            this.m.a = bdUniqueId;
            this.n.a = bdUniqueId;
            this.o.a = bdUniqueId;
            this.p.a = bdUniqueId;
            this.s.a = bdUniqueId;
            this.t.a = bdUniqueId;
            this.u.a = bdUniqueId;
            this.q.a = bdUniqueId;
            this.r.a = bdUniqueId;
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.m.y(i);
            this.n.w(i);
            this.o.x(i);
            this.p.w(i);
            this.q.z(i);
            this.r.y(i);
            this.s.y(i);
            this.t.y(i);
            this.u.y(i);
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.m.z(i);
            this.n.x(i);
            this.o.y(i);
            this.p.x(i);
            this.q.A(i);
            this.r.z(i);
            this.s.z(i);
            this.t.z(i);
            this.u.z(i);
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.m.A(i);
            this.n.y(i);
            this.o.z(i);
            this.p.y(i);
            this.q.B(i);
            this.r.A(i);
            this.s.A(i);
            this.t.A(i);
            this.u.A(i);
        }
    }
}
