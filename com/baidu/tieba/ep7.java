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
public class ep7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public BdUniqueId b;
    public BdTypeRecyclerView c;
    public cp7 d;
    public vo7 e;
    public xo7 f;
    public wo7 g;
    public yo7 h;
    public dp7 i;
    public zo7 j;
    public ap7 k;
    public uo7 l;
    public fp7 m;
    public bp7 n;
    public List<cn> o;

    public ep7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
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
            cp7 cp7Var = new cp7(this.a, ThreadData.TYPE_USER_NORMAL, this.b);
            this.d = cp7Var;
            cp7Var.A(this.c);
            this.o.add(this.d);
            vo7 vo7Var = new vo7(this.a, ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.b);
            this.e = vo7Var;
            vo7Var.B(this.c);
            this.o.add(this.e);
            xo7 xo7Var = new xo7(this.a, ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.b);
            this.f = xo7Var;
            xo7Var.A(this.c);
            this.o.add(this.f);
            wo7 wo7Var = new wo7(this.a, ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.b);
            this.g = wo7Var;
            wo7Var.A(this.c);
            this.o.add(this.g);
            yo7 yo7Var = new yo7(this.a, ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.b);
            this.h = yo7Var;
            yo7Var.A(this.c);
            this.o.add(this.h);
            dp7 dp7Var = new dp7(this.a, ThreadData.TYPE_VIDEO, this.b);
            this.i = dp7Var;
            dp7Var.D(this.c);
            this.o.add(this.i);
            zo7 zo7Var = new zo7(this.a, ThreadData.TYPE_ENTER_FORUM, this.b);
            this.j = zo7Var;
            zo7Var.A(this.c);
            this.o.add(this.j);
            ap7 ap7Var = new ap7(this.a, ThreadData.TYPE_BOTTOM_NORMAL, this.b);
            this.k = ap7Var;
            ap7Var.A(this.c);
            this.o.add(this.k);
            uo7 uo7Var = new uo7(this.a, ThreadData.TYPE_ARTICLE, this.b);
            this.l = uo7Var;
            uo7Var.B(this.c);
            this.o.add(this.l);
            fp7 fp7Var = new fp7(this.a, ep4.b);
            this.m = fp7Var;
            fp7Var.z(this.c);
            this.o.add(this.m);
            bp7 bp7Var = new bp7(this.a, t06.r0);
            this.n = bp7Var;
            this.o.add(bp7Var);
            this.c.a(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (cn cnVar : this.o) {
                if (cnVar instanceof to7) {
                    ((to7) cnVar).u(z);
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
