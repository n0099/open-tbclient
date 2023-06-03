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
/* loaded from: classes5.dex */
public class ed9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wc9 a;
    public tc9 b;
    public bd9 c;
    public cd9 d;
    public xc9 e;
    public ad9 f;
    public vc9 g;
    public yc9 h;
    public zc9 i;
    public BdTypeListView j;
    public uc9 k;
    public dd9 l;
    public List<in> m;

    public ed9(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
            this.a = new wc9(tbPageContext, sd9.b);
            this.b = new tc9(tbPageContext, md9.f);
            this.c = new bd9(tbPageContext, yd9.b);
            this.d = new cd9(tbPageContext, zd9.c);
            this.e = new xc9(tbPageContext, od9.b);
            this.f = new ad9(tbPageContext, pd9.b);
            this.k = new uc9(tbPageContext, qd9.c);
            this.h = new yc9(tbPageContext, ud9.b);
            this.i = new zc9(tbPageContext, vd9.b);
            this.g = new vc9(tbPageContext, rd9.p);
            this.l = new dd9(tbPageContext, PersonVipCardData.PERSON_VIP_CARD_DATA);
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
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.j) != null && (bdTypeListView.getAdapter2() instanceof mn)) {
            this.j.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c() {
        dd9 dd9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (dd9Var = this.l) != null) {
            dd9Var.onDestroy();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            dd9 dd9Var = this.l;
            if (dd9Var != null) {
                dd9Var.onPause();
            }
            bd9 bd9Var = this.c;
            if (bd9Var != null) {
                bd9Var.onPause();
            }
        }
    }

    public void f() {
        dd9 dd9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (dd9Var = this.l) != null) {
            dd9Var.onResume();
        }
    }

    public void g() {
        yc9 yc9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (yc9Var = this.h) != null) {
            yc9Var.onScroll();
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            dd9 dd9Var = this.l;
            if (dd9Var != null) {
                dd9Var.u(z);
            }
            uc9 uc9Var = this.k;
            if (uc9Var != null) {
                uc9Var.x(z);
            }
            ad9 ad9Var = this.f;
            if (ad9Var != null) {
                ad9Var.u(z);
            }
            bd9 bd9Var = this.c;
            if (bd9Var != null) {
                bd9Var.u(z);
            }
        }
    }

    public void h(boolean z) {
        uc9 uc9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (uc9Var = this.k) != null) {
            uc9Var.u(z);
        }
    }
}
