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
public class cs9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ur9 a;
    public rr9 b;
    public zr9 c;
    public as9 d;
    public vr9 e;
    public yr9 f;
    public tr9 g;
    public wr9 h;
    public xr9 i;
    public BdTypeListView j;
    public sr9 k;
    public bs9 l;
    public List<om> m;

    public cs9(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
            this.a = new ur9(tbPageContext, qs9.b);
            this.b = new rr9(tbPageContext, ks9.f);
            this.c = new zr9(tbPageContext, ws9.b);
            this.d = new as9(tbPageContext, xs9.b);
            this.e = new vr9(tbPageContext, ms9.b);
            this.f = new yr9(tbPageContext, ns9.b);
            this.k = new sr9(tbPageContext, os9.c);
            this.h = new wr9(tbPageContext, ss9.b);
            this.i = new xr9(tbPageContext, ts9.b);
            this.g = new tr9(tbPageContext, ps9.p);
            this.l = new bs9(tbPageContext, PersonVipCardData.PERSON_VIP_CARD_DATA);
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
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.j) != null && (bdTypeListView.getAdapter2() instanceof sm)) {
            this.j.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c() {
        bs9 bs9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (bs9Var = this.l) != null) {
            bs9Var.onDestroy();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            bs9 bs9Var = this.l;
            if (bs9Var != null) {
                bs9Var.onPause();
            }
            zr9 zr9Var = this.c;
            if (zr9Var != null) {
                zr9Var.onPause();
            }
        }
    }

    public void f() {
        bs9 bs9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (bs9Var = this.l) != null) {
            bs9Var.onResume();
        }
    }

    public void g() {
        wr9 wr9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (wr9Var = this.h) != null) {
            wr9Var.onScroll();
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            bs9 bs9Var = this.l;
            if (bs9Var != null) {
                bs9Var.u(z);
            }
            sr9 sr9Var = this.k;
            if (sr9Var != null) {
                sr9Var.x(z);
            }
            yr9 yr9Var = this.f;
            if (yr9Var != null) {
                yr9Var.u(z);
            }
            zr9 zr9Var = this.c;
            if (zr9Var != null) {
                zr9Var.u(z);
            }
        }
    }

    public void h(boolean z) {
        sr9 sr9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (sr9Var = this.k) != null) {
            sr9Var.u(z);
        }
    }
}
