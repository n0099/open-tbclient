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
public class en9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public BdUniqueId b;
    public BdTypeRecyclerView c;
    public cn9 d;
    public vm9 e;
    public xm9 f;
    public wm9 g;
    public ym9 h;
    public dn9 i;
    public zm9 j;
    public an9 k;
    public um9 l;
    public fn9 m;
    public bn9 n;
    public List<bi> o;

    public en9(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
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
            cn9 cn9Var = new cn9(this.a, ThreadData.TYPE_USER_NORMAL, this.b);
            this.d = cn9Var;
            cn9Var.D(this.c);
            this.o.add(this.d);
            vm9 vm9Var = new vm9(this.a, ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.b);
            this.e = vm9Var;
            vm9Var.E(this.c);
            this.o.add(this.e);
            xm9 xm9Var = new xm9(this.a, ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.b);
            this.f = xm9Var;
            xm9Var.D(this.c);
            this.o.add(this.f);
            wm9 wm9Var = new wm9(this.a, ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.b);
            this.g = wm9Var;
            wm9Var.D(this.c);
            this.o.add(this.g);
            ym9 ym9Var = new ym9(this.a, ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.b);
            this.h = ym9Var;
            ym9Var.D(this.c);
            this.o.add(this.h);
            dn9 dn9Var = new dn9(this.a, ThreadData.TYPE_VIDEO, this.b);
            this.i = dn9Var;
            dn9Var.G(this.c);
            this.o.add(this.i);
            zm9 zm9Var = new zm9(this.a, ThreadData.TYPE_ENTER_FORUM, this.b);
            this.j = zm9Var;
            zm9Var.D(this.c);
            this.o.add(this.j);
            an9 an9Var = new an9(this.a, ThreadData.TYPE_BOTTOM_NORMAL, this.b);
            this.k = an9Var;
            an9Var.D(this.c);
            this.o.add(this.k);
            um9 um9Var = new um9(this.a, ThreadData.TYPE_ARTICLE, this.b);
            this.l = um9Var;
            um9Var.E(this.c);
            this.o.add(this.l);
            fn9 fn9Var = new fn9(this.a, bx4.b);
            this.m = fn9Var;
            fn9Var.C(this.c);
            this.o.add(this.m);
            bn9 bn9Var = new bn9(this.a, nm6.u0);
            this.n = bn9Var;
            this.o.add(bn9Var);
            this.c.addAdapters(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (bi biVar : this.o) {
                if (biVar instanceof tm9) {
                    ((tm9) biVar).x(z);
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
