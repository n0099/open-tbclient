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
public class ga8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public y98 a;
    public v98 b;
    public da8 c;
    public ea8 d;
    public z98 e;
    public ca8 f;
    public x98 g;
    public aa8 h;
    public ba8 i;
    public BdTypeListView j;
    public w98 k;
    public fa8 l;
    public List<kn> m;

    public ga8(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
            this.a = new y98(tbPageContext, ta8.b);
            this.b = new v98(tbPageContext, na8.f);
            this.c = new da8(tbPageContext, za8.b);
            this.d = new ea8(tbPageContext, ab8.c);
            this.e = new z98(tbPageContext, pa8.b);
            this.f = new ca8(tbPageContext, qa8.b);
            this.k = new w98(tbPageContext, ra8.c);
            this.h = new aa8(tbPageContext, va8.b);
            this.i = new ba8(tbPageContext, wa8.b);
            this.g = new x98(tbPageContext, sa8.l);
            this.l = new fa8(tbPageContext, PersonVipCardData.PERSON_VIP_CARD_DATA);
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
        fa8 fa8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (fa8Var = this.l) != null) {
            fa8Var.onDestroy();
        }
    }

    public void d() {
        fa8 fa8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (fa8Var = this.l) != null) {
            fa8Var.onPause();
        }
    }

    public void f() {
        fa8 fa8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (fa8Var = this.l) != null) {
            fa8Var.onResume();
        }
    }

    public void g() {
        aa8 aa8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (aa8Var = this.h) != null) {
            aa8Var.onScroll();
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            fa8 fa8Var = this.l;
            if (fa8Var != null) {
                fa8Var.u(z);
            }
            w98 w98Var = this.k;
            if (w98Var != null) {
                w98Var.v(z);
            }
            ca8 ca8Var = this.f;
            if (ca8Var != null) {
                ca8Var.u(z);
            }
        }
    }

    public void h(boolean z) {
        w98 w98Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (w98Var = this.k) != null) {
            w98Var.u(z);
        }
    }
}
