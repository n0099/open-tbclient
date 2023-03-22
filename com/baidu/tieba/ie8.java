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
public class ie8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public BdUniqueId b;
    public BdTypeRecyclerView c;
    public ge8 d;
    public zd8 e;
    public be8 f;
    public ae8 g;
    public ce8 h;
    public he8 i;
    public de8 j;
    public ee8 k;
    public yd8 l;
    public je8 m;
    public fe8 n;
    public List<tm> o;

    public ie8(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
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
            ge8 ge8Var = new ge8(this.a, ThreadData.TYPE_USER_NORMAL, this.b);
            this.d = ge8Var;
            ge8Var.C(this.c);
            this.o.add(this.d);
            zd8 zd8Var = new zd8(this.a, ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.b);
            this.e = zd8Var;
            zd8Var.D(this.c);
            this.o.add(this.e);
            be8 be8Var = new be8(this.a, ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.b);
            this.f = be8Var;
            be8Var.C(this.c);
            this.o.add(this.f);
            ae8 ae8Var = new ae8(this.a, ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.b);
            this.g = ae8Var;
            ae8Var.C(this.c);
            this.o.add(this.g);
            ce8 ce8Var = new ce8(this.a, ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.b);
            this.h = ce8Var;
            ce8Var.C(this.c);
            this.o.add(this.h);
            he8 he8Var = new he8(this.a, ThreadData.TYPE_VIDEO, this.b);
            this.i = he8Var;
            he8Var.F(this.c);
            this.o.add(this.i);
            de8 de8Var = new de8(this.a, ThreadData.TYPE_ENTER_FORUM, this.b);
            this.j = de8Var;
            de8Var.C(this.c);
            this.o.add(this.j);
            ee8 ee8Var = new ee8(this.a, ThreadData.TYPE_BOTTOM_NORMAL, this.b);
            this.k = ee8Var;
            ee8Var.C(this.c);
            this.o.add(this.k);
            yd8 yd8Var = new yd8(this.a, ThreadData.TYPE_ARTICLE, this.b);
            this.l = yd8Var;
            yd8Var.D(this.c);
            this.o.add(this.l);
            je8 je8Var = new je8(this.a, gx4.b);
            this.m = je8Var;
            je8Var.B(this.c);
            this.o.add(this.m);
            fe8 fe8Var = new fe8(this.a, ag6.t0);
            this.n = fe8Var;
            this.o.add(fe8Var);
            this.c.addAdapters(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (tm tmVar : this.o) {
                if (tmVar instanceof xd8) {
                    ((xd8) tmVar).u(z);
                }
            }
        }
    }

    public void d(List<? extends gn> list) {
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
