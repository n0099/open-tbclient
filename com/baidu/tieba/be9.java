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
public class be9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public BdUniqueId b;
    public BdTypeRecyclerView c;
    public zd9 d;
    public sd9 e;
    public ud9 f;
    public td9 g;
    public vd9 h;
    public ae9 i;
    public wd9 j;
    public xd9 k;
    public rd9 l;
    public ce9 m;
    public yd9 n;
    public List<pm> o;

    public be9(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
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
            zd9 zd9Var = new zd9(this.a, ThreadData.TYPE_USER_NORMAL, this.b);
            this.d = zd9Var;
            zd9Var.C(this.c);
            this.o.add(this.d);
            sd9 sd9Var = new sd9(this.a, ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.b);
            this.e = sd9Var;
            sd9Var.D(this.c);
            this.o.add(this.e);
            ud9 ud9Var = new ud9(this.a, ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.b);
            this.f = ud9Var;
            ud9Var.C(this.c);
            this.o.add(this.f);
            td9 td9Var = new td9(this.a, ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.b);
            this.g = td9Var;
            td9Var.C(this.c);
            this.o.add(this.g);
            vd9 vd9Var = new vd9(this.a, ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.b);
            this.h = vd9Var;
            vd9Var.C(this.c);
            this.o.add(this.h);
            ae9 ae9Var = new ae9(this.a, ThreadData.TYPE_VIDEO, this.b);
            this.i = ae9Var;
            ae9Var.F(this.c);
            this.o.add(this.i);
            wd9 wd9Var = new wd9(this.a, ThreadData.TYPE_ENTER_FORUM, this.b);
            this.j = wd9Var;
            wd9Var.C(this.c);
            this.o.add(this.j);
            xd9 xd9Var = new xd9(this.a, ThreadData.TYPE_BOTTOM_NORMAL, this.b);
            this.k = xd9Var;
            xd9Var.C(this.c);
            this.o.add(this.k);
            rd9 rd9Var = new rd9(this.a, ThreadData.TYPE_ARTICLE, this.b);
            this.l = rd9Var;
            rd9Var.D(this.c);
            this.o.add(this.l);
            ce9 ce9Var = new ce9(this.a, b25.b);
            this.m = ce9Var;
            ce9Var.B(this.c);
            this.o.add(this.m);
            yd9 yd9Var = new yd9(this.a, cq6.u0);
            this.n = yd9Var;
            this.o.add(yd9Var);
            this.c.addAdapters(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (pm pmVar : this.o) {
                if (pmVar instanceof qd9) {
                    ((qd9) pmVar).u(z);
                }
            }
        }
    }

    public void d(List<? extends cn> list) {
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
