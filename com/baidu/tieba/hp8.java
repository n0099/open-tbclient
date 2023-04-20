package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class hp8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public BdUniqueId b;
    public BdTypeRecyclerView c;
    public fp8 d;
    public yo8 e;
    public ap8 f;
    public zo8 g;
    public bp8 h;
    public gp8 i;
    public cp8 j;
    public dp8 k;
    public xo8 l;
    public ip8 m;
    public ep8 n;
    public List<vm> o;

    public hp8(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new LinkedList();
        this.a = tbPageContext;
        this.b = bdUniqueId;
        this.c = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            fp8 fp8Var = new fp8(this.a, ThreadData.TYPE_USER_NORMAL, this.b);
            this.d = fp8Var;
            fp8Var.C(this.c);
            this.o.add(this.d);
            yo8 yo8Var = new yo8(this.a, ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.b);
            this.e = yo8Var;
            yo8Var.D(this.c);
            this.o.add(this.e);
            ap8 ap8Var = new ap8(this.a, ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.b);
            this.f = ap8Var;
            ap8Var.C(this.c);
            this.o.add(this.f);
            zo8 zo8Var = new zo8(this.a, ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.b);
            this.g = zo8Var;
            zo8Var.C(this.c);
            this.o.add(this.g);
            bp8 bp8Var = new bp8(this.a, ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.b);
            this.h = bp8Var;
            bp8Var.C(this.c);
            this.o.add(this.h);
            gp8 gp8Var = new gp8(this.a, ThreadData.TYPE_VIDEO, this.b);
            this.i = gp8Var;
            gp8Var.F(this.c);
            this.o.add(this.i);
            cp8 cp8Var = new cp8(this.a, ThreadData.TYPE_ENTER_FORUM, this.b);
            this.j = cp8Var;
            cp8Var.C(this.c);
            this.o.add(this.j);
            dp8 dp8Var = new dp8(this.a, ThreadData.TYPE_BOTTOM_NORMAL, this.b);
            this.k = dp8Var;
            dp8Var.C(this.c);
            this.o.add(this.k);
            xo8 xo8Var = new xo8(this.a, ThreadData.TYPE_ARTICLE, this.b);
            this.l = xo8Var;
            xo8Var.D(this.c);
            this.o.add(this.l);
            ip8 ip8Var = new ip8(this.a, jx4.b);
            this.m = ip8Var;
            ip8Var.B(this.c);
            this.o.add(this.m);
            ep8 ep8Var = new ep8(this.a, nh6.t0);
            this.n = ep8Var;
            this.o.add(ep8Var);
            this.c.addAdapters(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (vm vmVar : this.o) {
                if (vmVar instanceof wo8) {
                    ((wo8) vmVar).u(z);
                }
            }
        }
    }

    public void d(List<? extends in> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c.getAdapter().notifyDataSetChanged();
        }
    }
}
