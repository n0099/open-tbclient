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
public class f98 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public BdUniqueId b;
    public BdTypeRecyclerView c;
    public d98 d;
    public w88 e;
    public y88 f;
    public x88 g;
    public z88 h;
    public e98 i;
    public a98 j;
    public b98 k;
    public v88 l;
    public g98 m;
    public c98 n;
    public List<qn> o;

    public f98(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
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
            d98 d98Var = new d98(this.a, ThreadData.TYPE_USER_NORMAL, this.b);
            this.d = d98Var;
            d98Var.A(this.c);
            this.o.add(this.d);
            w88 w88Var = new w88(this.a, ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.b);
            this.e = w88Var;
            w88Var.B(this.c);
            this.o.add(this.e);
            y88 y88Var = new y88(this.a, ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.b);
            this.f = y88Var;
            y88Var.A(this.c);
            this.o.add(this.f);
            x88 x88Var = new x88(this.a, ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.b);
            this.g = x88Var;
            x88Var.A(this.c);
            this.o.add(this.g);
            z88 z88Var = new z88(this.a, ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.b);
            this.h = z88Var;
            z88Var.A(this.c);
            this.o.add(this.h);
            e98 e98Var = new e98(this.a, ThreadData.TYPE_VIDEO, this.b);
            this.i = e98Var;
            e98Var.D(this.c);
            this.o.add(this.i);
            a98 a98Var = new a98(this.a, ThreadData.TYPE_ENTER_FORUM, this.b);
            this.j = a98Var;
            a98Var.A(this.c);
            this.o.add(this.j);
            b98 b98Var = new b98(this.a, ThreadData.TYPE_BOTTOM_NORMAL, this.b);
            this.k = b98Var;
            b98Var.A(this.c);
            this.o.add(this.k);
            v88 v88Var = new v88(this.a, ThreadData.TYPE_ARTICLE, this.b);
            this.l = v88Var;
            v88Var.B(this.c);
            this.o.add(this.l);
            g98 g98Var = new g98(this.a, xy4.b);
            this.m = g98Var;
            g98Var.z(this.c);
            this.o.add(this.m);
            c98 c98Var = new c98(this.a, mg6.s0);
            this.n = c98Var;
            this.o.add(c98Var);
            this.c.a(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (qn qnVar : this.o) {
                if (qnVar instanceof u88) {
                    ((u88) qnVar).u(z);
                }
            }
        }
    }

    public void d(List<? extends Cdo> list) {
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
