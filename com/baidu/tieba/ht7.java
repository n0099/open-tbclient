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
public class ht7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public BdUniqueId b;
    public BdTypeRecyclerView c;
    public ft7 d;
    public ys7 e;
    public at7 f;
    public zs7 g;
    public bt7 h;
    public gt7 i;
    public ct7 j;
    public dt7 k;
    public xs7 l;
    public it7 m;
    public et7 n;
    public List<kn> o;

    public ht7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
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
            ft7 ft7Var = new ft7(this.a, ThreadData.TYPE_USER_NORMAL, this.b);
            this.d = ft7Var;
            ft7Var.A(this.c);
            this.o.add(this.d);
            ys7 ys7Var = new ys7(this.a, ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.b);
            this.e = ys7Var;
            ys7Var.B(this.c);
            this.o.add(this.e);
            at7 at7Var = new at7(this.a, ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.b);
            this.f = at7Var;
            at7Var.A(this.c);
            this.o.add(this.f);
            zs7 zs7Var = new zs7(this.a, ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.b);
            this.g = zs7Var;
            zs7Var.A(this.c);
            this.o.add(this.g);
            bt7 bt7Var = new bt7(this.a, ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.b);
            this.h = bt7Var;
            bt7Var.A(this.c);
            this.o.add(this.h);
            gt7 gt7Var = new gt7(this.a, ThreadData.TYPE_VIDEO, this.b);
            this.i = gt7Var;
            gt7Var.D(this.c);
            this.o.add(this.i);
            ct7 ct7Var = new ct7(this.a, ThreadData.TYPE_ENTER_FORUM, this.b);
            this.j = ct7Var;
            ct7Var.A(this.c);
            this.o.add(this.j);
            dt7 dt7Var = new dt7(this.a, ThreadData.TYPE_BOTTOM_NORMAL, this.b);
            this.k = dt7Var;
            dt7Var.A(this.c);
            this.o.add(this.k);
            xs7 xs7Var = new xs7(this.a, ThreadData.TYPE_ARTICLE, this.b);
            this.l = xs7Var;
            xs7Var.B(this.c);
            this.o.add(this.l);
            it7 it7Var = new it7(this.a, qs4.b);
            this.m = it7Var;
            it7Var.z(this.c);
            this.o.add(this.m);
            et7 et7Var = new et7(this.a, a56.r0);
            this.n = et7Var;
            this.o.add(et7Var);
            this.c.a(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (kn knVar : this.o) {
                if (knVar instanceof ws7) {
                    ((ws7) knVar).u(z);
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
