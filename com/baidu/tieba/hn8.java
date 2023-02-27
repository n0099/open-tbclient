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
public class hn8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zm8 a;
    public wm8 b;
    public en8 c;
    public fn8 d;
    public an8 e;
    public dn8 f;
    public ym8 g;
    public bn8 h;
    public cn8 i;
    public BdTypeListView j;
    public xm8 k;
    public gn8 l;
    public List<qn> m;

    public hn8(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
            this.a = new zm8(tbPageContext, vn8.b);
            this.b = new wm8(tbPageContext, pn8.f);
            this.c = new en8(tbPageContext, bo8.b);
            this.d = new fn8(tbPageContext, co8.c);
            this.e = new an8(tbPageContext, rn8.b);
            this.f = new dn8(tbPageContext, sn8.b);
            this.k = new xm8(tbPageContext, tn8.c);
            this.h = new bn8(tbPageContext, xn8.b);
            this.i = new cn8(tbPageContext, yn8.b);
            this.g = new ym8(tbPageContext, un8.q);
            this.l = new gn8(tbPageContext, PersonVipCardData.PERSON_VIP_CARD_DATA);
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
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.j) != null && (bdTypeListView.getAdapter2() instanceof un)) {
            this.j.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c() {
        gn8 gn8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (gn8Var = this.l) != null) {
            gn8Var.onDestroy();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            gn8 gn8Var = this.l;
            if (gn8Var != null) {
                gn8Var.onPause();
            }
            en8 en8Var = this.c;
            if (en8Var != null) {
                en8Var.onPause();
            }
        }
    }

    public void f() {
        gn8 gn8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (gn8Var = this.l) != null) {
            gn8Var.onResume();
        }
    }

    public void g() {
        bn8 bn8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (bn8Var = this.h) != null) {
            bn8Var.onScroll();
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            gn8 gn8Var = this.l;
            if (gn8Var != null) {
                gn8Var.u(z);
            }
            xm8 xm8Var = this.k;
            if (xm8Var != null) {
                xm8Var.v(z);
            }
            dn8 dn8Var = this.f;
            if (dn8Var != null) {
                dn8Var.u(z);
            }
            en8 en8Var = this.c;
            if (en8Var != null) {
                en8Var.u(z);
            }
        }
    }

    public void h(boolean z) {
        xm8 xm8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (xm8Var = this.k) != null) {
            xm8Var.u(z);
        }
    }
}
