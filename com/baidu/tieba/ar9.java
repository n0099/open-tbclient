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
public class ar9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public BdUniqueId b;
    public BdTypeRecyclerView c;
    public yq9 d;
    public rq9 e;
    public tq9 f;
    public sq9 g;
    public uq9 h;
    public zq9 i;
    public vq9 j;
    public wq9 k;
    public qq9 l;
    public br9 m;
    public xq9 n;
    public List<ci> o;

    public ar9(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
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
            yq9 yq9Var = new yq9(this.a, ThreadData.TYPE_USER_NORMAL, this.b);
            this.d = yq9Var;
            yq9Var.D(this.c);
            this.o.add(this.d);
            rq9 rq9Var = new rq9(this.a, ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.b);
            this.e = rq9Var;
            rq9Var.E(this.c);
            this.o.add(this.e);
            tq9 tq9Var = new tq9(this.a, ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.b);
            this.f = tq9Var;
            tq9Var.D(this.c);
            this.o.add(this.f);
            sq9 sq9Var = new sq9(this.a, ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.b);
            this.g = sq9Var;
            sq9Var.D(this.c);
            this.o.add(this.g);
            uq9 uq9Var = new uq9(this.a, ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.b);
            this.h = uq9Var;
            uq9Var.D(this.c);
            this.o.add(this.h);
            zq9 zq9Var = new zq9(this.a, ThreadData.TYPE_VIDEO, this.b);
            this.i = zq9Var;
            zq9Var.G(this.c);
            this.o.add(this.i);
            vq9 vq9Var = new vq9(this.a, ThreadData.TYPE_ENTER_FORUM, this.b);
            this.j = vq9Var;
            vq9Var.D(this.c);
            this.o.add(this.j);
            wq9 wq9Var = new wq9(this.a, ThreadData.TYPE_BOTTOM_NORMAL, this.b);
            this.k = wq9Var;
            wq9Var.D(this.c);
            this.o.add(this.k);
            qq9 qq9Var = new qq9(this.a, ThreadData.TYPE_ARTICLE, this.b);
            this.l = qq9Var;
            qq9Var.E(this.c);
            this.o.add(this.l);
            br9 br9Var = new br9(this.a, gx4.b);
            this.m = br9Var;
            br9Var.C(this.c);
            this.o.add(this.m);
            xq9 xq9Var = new xq9(this.a, dn6.u0);
            this.n = xq9Var;
            this.o.add(xq9Var);
            this.c.addAdapters(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (ci ciVar : this.o) {
                if (ciVar instanceof pq9) {
                    ((pq9) ciVar).x(z);
                }
            }
        }
    }

    public void d(List<? extends pi> list) {
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
