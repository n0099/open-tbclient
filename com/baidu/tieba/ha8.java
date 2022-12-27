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
public class ha8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public z98 a;
    public w98 b;
    public ea8 c;
    public fa8 d;
    public aa8 e;
    public da8 f;
    public y98 g;
    public ba8 h;
    public ca8 i;
    public BdTypeListView j;
    public x98 k;
    public ga8 l;
    public List<kn> m;

    public ha8(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
            this.a = new z98(tbPageContext, ua8.b);
            this.b = new w98(tbPageContext, oa8.f);
            this.c = new ea8(tbPageContext, ab8.b);
            this.d = new fa8(tbPageContext, bb8.c);
            this.e = new aa8(tbPageContext, qa8.b);
            this.f = new da8(tbPageContext, ra8.b);
            this.k = new x98(tbPageContext, sa8.c);
            this.h = new ba8(tbPageContext, wa8.b);
            this.i = new ca8(tbPageContext, xa8.b);
            this.g = new y98(tbPageContext, ta8.l);
            this.l = new ga8(tbPageContext, PersonVipCardData.PERSON_VIP_CARD_DATA);
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
            bdTypeListView.a(this.m);
        }
    }

    public void b() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.j) != null && (bdTypeListView.getAdapter2() instanceof on)) {
            this.j.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c() {
        ga8 ga8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (ga8Var = this.l) != null) {
            ga8Var.onDestroy();
        }
    }

    public void d() {
        ga8 ga8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (ga8Var = this.l) != null) {
            ga8Var.onPause();
        }
    }

    public void f() {
        ga8 ga8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (ga8Var = this.l) != null) {
            ga8Var.onResume();
        }
    }

    public void g() {
        ba8 ba8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (ba8Var = this.h) != null) {
            ba8Var.onScroll();
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            ga8 ga8Var = this.l;
            if (ga8Var != null) {
                ga8Var.u(z);
            }
            x98 x98Var = this.k;
            if (x98Var != null) {
                x98Var.v(z);
            }
            da8 da8Var = this.f;
            if (da8Var != null) {
                da8Var.u(z);
            }
        }
    }

    public void h(boolean z) {
        x98 x98Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (x98Var = this.k) != null) {
            x98Var.u(z);
        }
    }
}
