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
public class fn9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public BdUniqueId b;
    public BdTypeRecyclerView c;
    public dn9 d;
    public wm9 e;
    public ym9 f;
    public xm9 g;
    public zm9 h;
    public en9 i;
    public an9 j;
    public bn9 k;
    public vm9 l;
    public gn9 m;
    public cn9 n;
    public List<bi> o;

    public fn9(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
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
            dn9 dn9Var = new dn9(this.a, ThreadData.TYPE_USER_NORMAL, this.b);
            this.d = dn9Var;
            dn9Var.D(this.c);
            this.o.add(this.d);
            wm9 wm9Var = new wm9(this.a, ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.b);
            this.e = wm9Var;
            wm9Var.E(this.c);
            this.o.add(this.e);
            ym9 ym9Var = new ym9(this.a, ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.b);
            this.f = ym9Var;
            ym9Var.D(this.c);
            this.o.add(this.f);
            xm9 xm9Var = new xm9(this.a, ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.b);
            this.g = xm9Var;
            xm9Var.D(this.c);
            this.o.add(this.g);
            zm9 zm9Var = new zm9(this.a, ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.b);
            this.h = zm9Var;
            zm9Var.D(this.c);
            this.o.add(this.h);
            en9 en9Var = new en9(this.a, ThreadData.TYPE_VIDEO, this.b);
            this.i = en9Var;
            en9Var.G(this.c);
            this.o.add(this.i);
            an9 an9Var = new an9(this.a, ThreadData.TYPE_ENTER_FORUM, this.b);
            this.j = an9Var;
            an9Var.D(this.c);
            this.o.add(this.j);
            bn9 bn9Var = new bn9(this.a, ThreadData.TYPE_BOTTOM_NORMAL, this.b);
            this.k = bn9Var;
            bn9Var.D(this.c);
            this.o.add(this.k);
            vm9 vm9Var = new vm9(this.a, ThreadData.TYPE_ARTICLE, this.b);
            this.l = vm9Var;
            vm9Var.E(this.c);
            this.o.add(this.l);
            gn9 gn9Var = new gn9(this.a, bx4.b);
            this.m = gn9Var;
            gn9Var.C(this.c);
            this.o.add(this.m);
            cn9 cn9Var = new cn9(this.a, om6.u0);
            this.n = cn9Var;
            this.o.add(cn9Var);
            this.c.addAdapters(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (bi biVar : this.o) {
                if (biVar instanceof um9) {
                    ((um9) biVar).x(z);
                }
            }
        }
    }

    public void d(List<? extends oi> list) {
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
