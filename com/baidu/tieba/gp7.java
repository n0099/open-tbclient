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
public class gp7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public BdUniqueId b;
    public BdTypeRecyclerView c;
    public ep7 d;
    public xo7 e;
    public zo7 f;
    public yo7 g;
    public ap7 h;
    public fp7 i;
    public bp7 j;
    public cp7 k;
    public wo7 l;
    public hp7 m;
    public dp7 n;
    public List<cn> o;

    public gp7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
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
            ep7 ep7Var = new ep7(this.a, ThreadData.TYPE_USER_NORMAL, this.b);
            this.d = ep7Var;
            ep7Var.A(this.c);
            this.o.add(this.d);
            xo7 xo7Var = new xo7(this.a, ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.b);
            this.e = xo7Var;
            xo7Var.B(this.c);
            this.o.add(this.e);
            zo7 zo7Var = new zo7(this.a, ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.b);
            this.f = zo7Var;
            zo7Var.A(this.c);
            this.o.add(this.f);
            yo7 yo7Var = new yo7(this.a, ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.b);
            this.g = yo7Var;
            yo7Var.A(this.c);
            this.o.add(this.g);
            ap7 ap7Var = new ap7(this.a, ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.b);
            this.h = ap7Var;
            ap7Var.A(this.c);
            this.o.add(this.h);
            fp7 fp7Var = new fp7(this.a, ThreadData.TYPE_VIDEO, this.b);
            this.i = fp7Var;
            fp7Var.D(this.c);
            this.o.add(this.i);
            bp7 bp7Var = new bp7(this.a, ThreadData.TYPE_ENTER_FORUM, this.b);
            this.j = bp7Var;
            bp7Var.A(this.c);
            this.o.add(this.j);
            cp7 cp7Var = new cp7(this.a, ThreadData.TYPE_BOTTOM_NORMAL, this.b);
            this.k = cp7Var;
            cp7Var.A(this.c);
            this.o.add(this.k);
            wo7 wo7Var = new wo7(this.a, ThreadData.TYPE_ARTICLE, this.b);
            this.l = wo7Var;
            wo7Var.B(this.c);
            this.o.add(this.l);
            hp7 hp7Var = new hp7(this.a, fp4.b);
            this.m = hp7Var;
            hp7Var.z(this.c);
            this.o.add(this.m);
            dp7 dp7Var = new dp7(this.a, v06.r0);
            this.n = dp7Var;
            this.o.add(dp7Var);
            this.c.a(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (cn cnVar : this.o) {
                if (cnVar instanceof vo7) {
                    ((vo7) cnVar).u(z);
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

    public void d(List<? extends pn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.setData(list);
        }
    }
}
