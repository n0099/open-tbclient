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
public class hw7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public BdUniqueId b;
    public BdTypeRecyclerView c;
    public fw7 d;
    public yv7 e;
    public aw7 f;
    public zv7 g;
    public bw7 h;
    public gw7 i;
    public cw7 j;
    public dw7 k;
    public xv7 l;
    public iw7 m;
    public ew7 n;
    public List<kn> o;

    public hw7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
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
            fw7 fw7Var = new fw7(this.a, ThreadData.TYPE_USER_NORMAL, this.b);
            this.d = fw7Var;
            fw7Var.A(this.c);
            this.o.add(this.d);
            yv7 yv7Var = new yv7(this.a, ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.b);
            this.e = yv7Var;
            yv7Var.B(this.c);
            this.o.add(this.e);
            aw7 aw7Var = new aw7(this.a, ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.b);
            this.f = aw7Var;
            aw7Var.A(this.c);
            this.o.add(this.f);
            zv7 zv7Var = new zv7(this.a, ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.b);
            this.g = zv7Var;
            zv7Var.A(this.c);
            this.o.add(this.g);
            bw7 bw7Var = new bw7(this.a, ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.b);
            this.h = bw7Var;
            bw7Var.A(this.c);
            this.o.add(this.h);
            gw7 gw7Var = new gw7(this.a, ThreadData.TYPE_VIDEO, this.b);
            this.i = gw7Var;
            gw7Var.D(this.c);
            this.o.add(this.i);
            cw7 cw7Var = new cw7(this.a, ThreadData.TYPE_ENTER_FORUM, this.b);
            this.j = cw7Var;
            cw7Var.A(this.c);
            this.o.add(this.j);
            dw7 dw7Var = new dw7(this.a, ThreadData.TYPE_BOTTOM_NORMAL, this.b);
            this.k = dw7Var;
            dw7Var.A(this.c);
            this.o.add(this.k);
            xv7 xv7Var = new xv7(this.a, ThreadData.TYPE_ARTICLE, this.b);
            this.l = xv7Var;
            xv7Var.B(this.c);
            this.o.add(this.l);
            iw7 iw7Var = new iw7(this.a, ts4.b);
            this.m = iw7Var;
            iw7Var.z(this.c);
            this.o.add(this.m);
            ew7 ew7Var = new ew7(this.a, w56.r0);
            this.n = ew7Var;
            this.o.add(ew7Var);
            this.c.a(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (kn knVar : this.o) {
                if (knVar instanceof wv7) {
                    ((wv7) knVar).u(z);
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
