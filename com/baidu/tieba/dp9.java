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
public class dp9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vo9 a;
    public so9 b;
    public ap9 c;
    public bp9 d;
    public wo9 e;
    public zo9 f;
    public uo9 g;
    public xo9 h;
    public yo9 i;
    public BdTypeListView j;
    public to9 k;
    public cp9 l;
    public List<ln> m;

    public dp9(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
            this.a = new vo9(tbPageContext, rp9.b);
            this.b = new so9(tbPageContext, lp9.f);
            this.c = new ap9(tbPageContext, xp9.b);
            this.d = new bp9(tbPageContext, yp9.c);
            this.e = new wo9(tbPageContext, np9.b);
            this.f = new zo9(tbPageContext, op9.b);
            this.k = new to9(tbPageContext, pp9.c);
            this.h = new xo9(tbPageContext, tp9.b);
            this.i = new yo9(tbPageContext, up9.b);
            this.g = new uo9(tbPageContext, qp9.p);
            this.l = new cp9(tbPageContext, PersonVipCardData.PERSON_VIP_CARD_DATA);
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
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.j) != null && (bdTypeListView.getAdapter2() instanceof pn)) {
            this.j.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c() {
        cp9 cp9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (cp9Var = this.l) != null) {
            cp9Var.onDestroy();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            cp9 cp9Var = this.l;
            if (cp9Var != null) {
                cp9Var.onPause();
            }
            ap9 ap9Var = this.c;
            if (ap9Var != null) {
                ap9Var.onPause();
            }
        }
    }

    public void f() {
        cp9 cp9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (cp9Var = this.l) != null) {
            cp9Var.onResume();
        }
    }

    public void g() {
        xo9 xo9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (xo9Var = this.h) != null) {
            xo9Var.onScroll();
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            cp9 cp9Var = this.l;
            if (cp9Var != null) {
                cp9Var.u(z);
            }
            to9 to9Var = this.k;
            if (to9Var != null) {
                to9Var.x(z);
            }
            zo9 zo9Var = this.f;
            if (zo9Var != null) {
                zo9Var.u(z);
            }
            ap9 ap9Var = this.c;
            if (ap9Var != null) {
                ap9Var.u(z);
            }
        }
    }

    public void h(boolean z) {
        to9 to9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (to9Var = this.k) != null) {
            to9Var.u(z);
        }
    }
}
