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
public class b59 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public t49 a;
    public q49 b;
    public y49 c;
    public z49 d;
    public u49 e;
    public x49 f;
    public s49 g;
    public v49 h;
    public w49 i;
    public BdTypeListView j;
    public r49 k;
    public a59 l;
    public List<vm> m;

    public b59(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
            this.a = new t49(tbPageContext, p59.b);
            this.b = new q49(tbPageContext, j59.f);
            this.c = new y49(tbPageContext, v59.b);
            this.d = new z49(tbPageContext, w59.c);
            this.e = new u49(tbPageContext, l59.b);
            this.f = new x49(tbPageContext, m59.b);
            this.k = new r49(tbPageContext, n59.c);
            this.h = new v49(tbPageContext, r59.b);
            this.i = new w49(tbPageContext, s59.b);
            this.g = new s49(tbPageContext, o59.q);
            this.l = new a59(tbPageContext, PersonVipCardData.PERSON_VIP_CARD_DATA);
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
        a59 a59Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (a59Var = this.l) != null) {
            a59Var.onDestroy();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            a59 a59Var = this.l;
            if (a59Var != null) {
                a59Var.onPause();
            }
            y49 y49Var = this.c;
            if (y49Var != null) {
                y49Var.onPause();
            }
        }
    }

    public void f() {
        a59 a59Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (a59Var = this.l) != null) {
            a59Var.onResume();
        }
    }

    public void g() {
        v49 v49Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (v49Var = this.h) != null) {
            v49Var.onScroll();
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            a59 a59Var = this.l;
            if (a59Var != null) {
                a59Var.u(z);
            }
            r49 r49Var = this.k;
            if (r49Var != null) {
                r49Var.x(z);
            }
            x49 x49Var = this.f;
            if (x49Var != null) {
                x49Var.u(z);
            }
            y49 y49Var = this.c;
            if (y49Var != null) {
                y49Var.u(z);
            }
        }
    }

    public void h(boolean z) {
        r49 r49Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (r49Var = this.k) != null) {
            r49Var.u(z);
        }
    }
}
