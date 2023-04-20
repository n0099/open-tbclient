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
/* loaded from: classes4.dex */
public class i29 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a29 a;
    public x19 b;
    public f29 c;
    public g29 d;
    public b29 e;
    public e29 f;
    public z19 g;
    public c29 h;
    public d29 i;
    public BdTypeListView j;
    public y19 k;
    public h29 l;
    public List<vm> m;

    public i29(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
            this.a = new a29(tbPageContext, w29.b);
            this.b = new x19(tbPageContext, q29.f);
            this.c = new f29(tbPageContext, c39.b);
            this.d = new g29(tbPageContext, d39.c);
            this.e = new b29(tbPageContext, s29.b);
            this.f = new e29(tbPageContext, t29.b);
            this.k = new y19(tbPageContext, u29.c);
            this.h = new c29(tbPageContext, y29.b);
            this.i = new d29(tbPageContext, z29.b);
            this.g = new z19(tbPageContext, v29.q);
            this.l = new h29(tbPageContext, PersonVipCardData.PERSON_VIP_CARD_DATA);
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
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.j) != null && (bdTypeListView.getAdapter2() instanceof zm)) {
            this.j.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c() {
        h29 h29Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (h29Var = this.l) != null) {
            h29Var.onDestroy();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            h29 h29Var = this.l;
            if (h29Var != null) {
                h29Var.onPause();
            }
            f29 f29Var = this.c;
            if (f29Var != null) {
                f29Var.onPause();
            }
        }
    }

    public void f() {
        h29 h29Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (h29Var = this.l) != null) {
            h29Var.onResume();
        }
    }

    public void g() {
        c29 c29Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (c29Var = this.h) != null) {
            c29Var.onScroll();
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            h29 h29Var = this.l;
            if (h29Var != null) {
                h29Var.u(z);
            }
            y19 y19Var = this.k;
            if (y19Var != null) {
                y19Var.x(z);
            }
            e29 e29Var = this.f;
            if (e29Var != null) {
                e29Var.u(z);
            }
            f29 f29Var = this.c;
            if (f29Var != null) {
                f29Var.u(z);
            }
        }
    }

    public void h(boolean z) {
        y19 y19Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (y19Var = this.k) != null) {
            y19Var.u(z);
        }
    }
}
