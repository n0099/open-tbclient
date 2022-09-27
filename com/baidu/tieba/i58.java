package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
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
public class i58 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a58 a;
    public x48 b;
    public f58 c;
    public g58 d;
    public b58 e;
    public e58 f;
    public z48 g;
    public c58 h;
    public d58 i;
    public BdTypeListView j;
    public y48 k;
    public h58 l;
    public List<qn> m;

    public i58(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        b(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.t();
        }
    }

    public final void b(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeListView, tbPageContext, bdUniqueId) == null) {
            this.a = new a58(tbPageContext, v58.b);
            this.b = new x48(tbPageContext, p58.f);
            this.c = new f58(tbPageContext, b68.b);
            this.d = new g58(tbPageContext, c68.c);
            this.e = new b58(tbPageContext, r58.b);
            this.f = new e58(tbPageContext, s58.b);
            this.k = new y48(tbPageContext, t58.c);
            this.h = new c58(tbPageContext, x58.b);
            this.i = new d58(tbPageContext, y58.b);
            this.g = new z48(tbPageContext, u58.l);
            this.l = new h58(tbPageContext, PersonVipCardData.PERSON_VIP_CARD_DATA);
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

    public void c() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (bdTypeListView = this.j) != null && (bdTypeListView.getAdapter2() instanceof un)) {
            this.j.getAdapter2().notifyDataSetChanged();
        }
    }

    public void d() {
        h58 h58Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (h58Var = this.l) == null) {
            return;
        }
        h58Var.onDestroy();
    }

    public void e() {
        h58 h58Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (h58Var = this.l) == null) {
            return;
        }
        h58Var.onPause();
    }

    public void f(boolean z) {
        h58 h58Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (h58Var = this.l) == null) {
            return;
        }
        h58Var.u(z);
    }

    public void g() {
        h58 h58Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (h58Var = this.l) == null) {
            return;
        }
        h58Var.onResume();
    }

    public void h() {
        c58 c58Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (c58Var = this.h) == null) {
            return;
        }
        c58Var.onScroll();
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.a.w();
        }
    }
}
