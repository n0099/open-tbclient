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
/* loaded from: classes5.dex */
public class h09 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public BdUniqueId b;
    public BdTypeRecyclerView c;
    public f09 d;
    public yz8 e;
    public a09 f;
    public zz8 g;
    public b09 h;
    public g09 i;
    public c09 j;
    public d09 k;
    public xz8 l;
    public i09 m;
    public e09 n;
    public List<jn> o;

    public h09(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
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
            f09 f09Var = new f09(this.a, ThreadData.TYPE_USER_NORMAL, this.b);
            this.d = f09Var;
            f09Var.C(this.c);
            this.o.add(this.d);
            yz8 yz8Var = new yz8(this.a, ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.b);
            this.e = yz8Var;
            yz8Var.D(this.c);
            this.o.add(this.e);
            a09 a09Var = new a09(this.a, ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.b);
            this.f = a09Var;
            a09Var.C(this.c);
            this.o.add(this.f);
            zz8 zz8Var = new zz8(this.a, ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.b);
            this.g = zz8Var;
            zz8Var.C(this.c);
            this.o.add(this.g);
            b09 b09Var = new b09(this.a, ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.b);
            this.h = b09Var;
            b09Var.C(this.c);
            this.o.add(this.h);
            g09 g09Var = new g09(this.a, ThreadData.TYPE_VIDEO, this.b);
            this.i = g09Var;
            g09Var.F(this.c);
            this.o.add(this.i);
            c09 c09Var = new c09(this.a, ThreadData.TYPE_ENTER_FORUM, this.b);
            this.j = c09Var;
            c09Var.C(this.c);
            this.o.add(this.j);
            d09 d09Var = new d09(this.a, ThreadData.TYPE_BOTTOM_NORMAL, this.b);
            this.k = d09Var;
            d09Var.C(this.c);
            this.o.add(this.k);
            xz8 xz8Var = new xz8(this.a, ThreadData.TYPE_ARTICLE, this.b);
            this.l = xz8Var;
            xz8Var.D(this.c);
            this.o.add(this.l);
            i09 i09Var = new i09(this.a, h25.b);
            this.m = i09Var;
            i09Var.B(this.c);
            this.o.add(this.m);
            e09 e09Var = new e09(this.a, bp6.u0);
            this.n = e09Var;
            this.o.add(e09Var);
            this.c.addAdapters(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (jn jnVar : this.o) {
                if (jnVar instanceof wz8) {
                    ((wz8) jnVar).u(z);
                }
            }
        }
    }

    public void d(List<? extends wn> list) {
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
