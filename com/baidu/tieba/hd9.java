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
/* loaded from: classes6.dex */
public class hd9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zc9 a;
    public wc9 b;
    public ed9 c;
    public fd9 d;
    public ad9 e;
    public dd9 f;
    public yc9 g;
    public bd9 h;
    public cd9 i;
    public BdTypeListView j;
    public xc9 k;
    public gd9 l;
    public List<in> m;

    public hd9(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
            this.a = new zc9(tbPageContext, vd9.b);
            this.b = new wc9(tbPageContext, pd9.f);
            this.c = new ed9(tbPageContext, be9.b);
            this.d = new fd9(tbPageContext, ce9.c);
            this.e = new ad9(tbPageContext, rd9.b);
            this.f = new dd9(tbPageContext, sd9.b);
            this.k = new xc9(tbPageContext, td9.c);
            this.h = new bd9(tbPageContext, xd9.b);
            this.i = new cd9(tbPageContext, yd9.b);
            this.g = new yc9(tbPageContext, ud9.p);
            this.l = new gd9(tbPageContext, PersonVipCardData.PERSON_VIP_CARD_DATA);
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
        gd9 gd9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (gd9Var = this.l) != null) {
            gd9Var.onDestroy();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            gd9 gd9Var = this.l;
            if (gd9Var != null) {
                gd9Var.onPause();
            }
            ed9 ed9Var = this.c;
            if (ed9Var != null) {
                ed9Var.onPause();
            }
        }
    }

    public void f() {
        gd9 gd9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (gd9Var = this.l) != null) {
            gd9Var.onResume();
        }
    }

    public void g() {
        bd9 bd9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (bd9Var = this.h) != null) {
            bd9Var.onScroll();
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            gd9 gd9Var = this.l;
            if (gd9Var != null) {
                gd9Var.u(z);
            }
            xc9 xc9Var = this.k;
            if (xc9Var != null) {
                xc9Var.x(z);
            }
            dd9 dd9Var = this.f;
            if (dd9Var != null) {
                dd9Var.u(z);
            }
            ed9 ed9Var = this.c;
            if (ed9Var != null) {
                ed9Var.u(z);
            }
        }
    }

    public void h(boolean z) {
        xc9 xc9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (xc9Var = this.k) != null) {
            xc9Var.u(z);
        }
    }
}
