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
public class gw7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public BdUniqueId b;
    public BdTypeRecyclerView c;
    public ew7 d;
    public xv7 e;
    public zv7 f;
    public yv7 g;
    public aw7 h;
    public fw7 i;
    public bw7 j;
    public cw7 k;
    public wv7 l;
    public hw7 m;
    public dw7 n;
    public List<kn> o;

    public gw7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
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
            ew7 ew7Var = new ew7(this.a, ThreadData.TYPE_USER_NORMAL, this.b);
            this.d = ew7Var;
            ew7Var.A(this.c);
            this.o.add(this.d);
            xv7 xv7Var = new xv7(this.a, ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.b);
            this.e = xv7Var;
            xv7Var.B(this.c);
            this.o.add(this.e);
            zv7 zv7Var = new zv7(this.a, ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.b);
            this.f = zv7Var;
            zv7Var.A(this.c);
            this.o.add(this.f);
            yv7 yv7Var = new yv7(this.a, ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.b);
            this.g = yv7Var;
            yv7Var.A(this.c);
            this.o.add(this.g);
            aw7 aw7Var = new aw7(this.a, ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.b);
            this.h = aw7Var;
            aw7Var.A(this.c);
            this.o.add(this.h);
            fw7 fw7Var = new fw7(this.a, ThreadData.TYPE_VIDEO, this.b);
            this.i = fw7Var;
            fw7Var.D(this.c);
            this.o.add(this.i);
            bw7 bw7Var = new bw7(this.a, ThreadData.TYPE_ENTER_FORUM, this.b);
            this.j = bw7Var;
            bw7Var.A(this.c);
            this.o.add(this.j);
            cw7 cw7Var = new cw7(this.a, ThreadData.TYPE_BOTTOM_NORMAL, this.b);
            this.k = cw7Var;
            cw7Var.A(this.c);
            this.o.add(this.k);
            wv7 wv7Var = new wv7(this.a, ThreadData.TYPE_ARTICLE, this.b);
            this.l = wv7Var;
            wv7Var.B(this.c);
            this.o.add(this.l);
            hw7 hw7Var = new hw7(this.a, ts4.b);
            this.m = hw7Var;
            hw7Var.z(this.c);
            this.o.add(this.m);
            dw7 dw7Var = new dw7(this.a, w56.r0);
            this.n = dw7Var;
            this.o.add(dw7Var);
            this.c.a(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (kn knVar : this.o) {
                if (knVar instanceof vv7) {
                    ((vv7) knVar).u(z);
                }
            }
        }
    }

    public void d(List<? extends xn> list) {
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
