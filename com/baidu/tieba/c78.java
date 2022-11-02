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
public class c78 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public u68 a;
    public r68 b;
    public z68 c;
    public a78 d;
    public v68 e;
    public y68 f;
    public t68 g;
    public w68 h;
    public x68 i;
    public BdTypeListView j;
    public s68 k;
    public b78 l;
    public List<jn> m;

    public c78(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
            this.a = new u68(tbPageContext, p78.b);
            this.b = new r68(tbPageContext, j78.f);
            this.c = new z68(tbPageContext, v78.b);
            this.d = new a78(tbPageContext, w78.c);
            this.e = new v68(tbPageContext, l78.b);
            this.f = new y68(tbPageContext, m78.b);
            this.k = new s68(tbPageContext, n78.c);
            this.h = new w68(tbPageContext, r78.b);
            this.i = new x68(tbPageContext, s78.b);
            this.g = new t68(tbPageContext, o78.l);
            this.l = new b78(tbPageContext, PersonVipCardData.PERSON_VIP_CARD_DATA);
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
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.j) != null && (bdTypeListView.getAdapter2() instanceof nn)) {
            this.j.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c() {
        b78 b78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (b78Var = this.l) != null) {
            b78Var.onDestroy();
        }
    }

    public void d() {
        b78 b78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (b78Var = this.l) != null) {
            b78Var.onPause();
        }
    }

    public void f() {
        b78 b78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (b78Var = this.l) != null) {
            b78Var.onResume();
        }
    }

    public void g() {
        w68 w68Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (w68Var = this.h) != null) {
            w68Var.onScroll();
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            b78 b78Var = this.l;
            if (b78Var != null) {
                b78Var.u(z);
            }
            s68 s68Var = this.k;
            if (s68Var != null) {
                s68Var.v(z);
            }
        }
    }

    public void h(boolean z) {
        s68 s68Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (s68Var = this.k) != null) {
            s68Var.u(z);
        }
    }
}
