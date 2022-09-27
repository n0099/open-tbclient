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
/* loaded from: classes3.dex */
public class cr7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public BdUniqueId b;
    public BdTypeRecyclerView c;
    public ar7 d;
    public tq7 e;
    public vq7 f;
    public uq7 g;
    public wq7 h;
    public br7 i;
    public xq7 j;
    public yq7 k;
    public sq7 l;
    public dr7 m;
    public zq7 n;
    public List<qn> o;

    public cr7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
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
            ar7 ar7Var = new ar7(this.a, ThreadData.TYPE_USER_NORMAL, this.b);
            this.d = ar7Var;
            ar7Var.A(this.c);
            this.o.add(this.d);
            tq7 tq7Var = new tq7(this.a, ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.b);
            this.e = tq7Var;
            tq7Var.B(this.c);
            this.o.add(this.e);
            vq7 vq7Var = new vq7(this.a, ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.b);
            this.f = vq7Var;
            vq7Var.A(this.c);
            this.o.add(this.f);
            uq7 uq7Var = new uq7(this.a, ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.b);
            this.g = uq7Var;
            uq7Var.A(this.c);
            this.o.add(this.g);
            wq7 wq7Var = new wq7(this.a, ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.b);
            this.h = wq7Var;
            wq7Var.A(this.c);
            this.o.add(this.h);
            br7 br7Var = new br7(this.a, ThreadData.TYPE_VIDEO, this.b);
            this.i = br7Var;
            br7Var.D(this.c);
            this.o.add(this.i);
            xq7 xq7Var = new xq7(this.a, ThreadData.TYPE_ENTER_FORUM, this.b);
            this.j = xq7Var;
            xq7Var.A(this.c);
            this.o.add(this.j);
            yq7 yq7Var = new yq7(this.a, ThreadData.TYPE_BOTTOM_NORMAL, this.b);
            this.k = yq7Var;
            yq7Var.A(this.c);
            this.o.add(this.k);
            sq7 sq7Var = new sq7(this.a, ThreadData.TYPE_ARTICLE, this.b);
            this.l = sq7Var;
            sq7Var.B(this.c);
            this.o.add(this.l);
            dr7 dr7Var = new dr7(this.a, wr4.b);
            this.m = dr7Var;
            dr7Var.z(this.c);
            this.o.add(this.m);
            zq7 zq7Var = new zq7(this.a, x26.r0);
            this.n = zq7Var;
            this.o.add(zq7Var);
            this.c.a(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (qn qnVar : this.o) {
                if (qnVar instanceof rq7) {
                    ((rq7) qnVar).u(z);
                }
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c.getAdapter().notifyDataSetChanged();
        }
    }

    public void d(List<? extends Cdo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.setData(list);
        }
    }
}
