package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.data.PersonVipCardData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a29 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public s19 a;
    public p19 b;
    public x19 c;
    public y19 d;
    public t19 e;
    public w19 f;
    public r19 g;
    public u19 h;
    public v19 i;
    public BdTypeListView j;
    public q19 k;
    public z19 l;
    public List<um> m;

    public a29(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdTypeListView, tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = new ArrayList();
        this.j = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public final void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, bdTypeListView, tbPageContext, bdUniqueId) == null) {
            this.a = new s19(tbPageContext, o29.b);
            this.b = new p19(tbPageContext, i29.f);
            this.c = new x19(tbPageContext, u29.b);
            this.d = new y19(tbPageContext, v29.c);
            this.e = new t19(tbPageContext, k29.b);
            this.f = new w19(tbPageContext, l29.b);
            this.k = new q19(tbPageContext, m29.c);
            this.h = new u19(tbPageContext, q29.b);
            this.i = new v19(tbPageContext, r29.b);
            this.g = new r19(tbPageContext, n29.q);
            this.l = new z19(tbPageContext, PersonVipCardData.PERSON_VIP_CARD_DATA);
            this.m.add(this.a);
            this.m.add(this.l);
            this.m.add(this.b);
            this.m.add(this.e);
            this.m.add(this.f);
            this.m.add(this.c);
            this.m.add(this.d);
            this.m.add(this.h);
            this.m.add(this.i);
            this.m.add(this.g);
            this.m.add(this.k);
            bdTypeListView.addAdapters(this.m);
        }
    }

    public void b() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.j) != null && (bdTypeListView.getAdapter2() instanceof ym)) {
            this.j.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c() {
        z19 z19Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (z19Var = this.l) != null) {
            z19Var.onDestroy();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            z19 z19Var = this.l;
            if (z19Var != null) {
                z19Var.onPause();
            }
            x19 x19Var = this.c;
            if (x19Var != null) {
                x19Var.onPause();
            }
        }
    }

    public void f() {
        z19 z19Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (z19Var = this.l) != null) {
            z19Var.onResume();
        }
    }

    public void g() {
        u19 u19Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (u19Var = this.h) != null) {
            u19Var.onScroll();
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            z19 z19Var = this.l;
            if (z19Var != null) {
                z19Var.u(z);
            }
            q19 q19Var = this.k;
            if (q19Var != null) {
                q19Var.x(z);
            }
            w19 w19Var = this.f;
            if (w19Var != null) {
                w19Var.u(z);
            }
            x19 x19Var = this.c;
            if (x19Var != null) {
                x19Var.u(z);
            }
        }
    }

    public void h(boolean z) {
        q19 q19Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (q19Var = this.k) != null) {
            q19Var.u(z);
        }
    }
}
