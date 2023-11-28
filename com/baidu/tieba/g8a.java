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
public class g8a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public y7a a;
    public v7a b;
    public d8a c;
    public e8a d;
    public z7a e;
    public c8a f;
    public x7a g;
    public a8a h;
    public b8a i;
    public BdTypeListView j;
    public w7a k;
    public f8a l;
    public List<ci> m;

    public g8a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
            this.a = new y7a(tbPageContext, u8a.b);
            this.b = new v7a(tbPageContext, o8a.f);
            this.c = new d8a(tbPageContext, a9a.b);
            this.d = new e8a(tbPageContext, b9a.b);
            this.e = new z7a(tbPageContext, q8a.b);
            this.f = new c8a(tbPageContext, r8a.b);
            this.k = new w7a(tbPageContext, s8a.b);
            this.h = new a8a(tbPageContext, w8a.b);
            this.i = new b8a(tbPageContext, x8a.b);
            this.g = new x7a(tbPageContext, t8a.p);
            this.l = new f8a(tbPageContext, PersonVipCardData.PERSON_VIP_CARD_DATA);
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
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.j) != null && (bdTypeListView.getAdapter2() instanceof gi)) {
            this.j.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c() {
        f8a f8aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (f8aVar = this.l) != null) {
            f8aVar.onDestroy();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            f8a f8aVar = this.l;
            if (f8aVar != null) {
                f8aVar.onPause();
            }
            d8a d8aVar = this.c;
            if (d8aVar != null) {
                d8aVar.onPause();
            }
        }
    }

    public void f() {
        f8a f8aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (f8aVar = this.l) != null) {
            f8aVar.onResume();
        }
    }

    public void g() {
        a8a a8aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (a8aVar = this.h) != null) {
            a8aVar.onScroll();
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            f8a f8aVar = this.l;
            if (f8aVar != null) {
                f8aVar.x(z);
            }
            w7a w7aVar = this.k;
            if (w7aVar != null) {
                w7aVar.x(z);
            }
            c8a c8aVar = this.f;
            if (c8aVar != null) {
                c8aVar.x(z);
            }
            d8a d8aVar = this.c;
            if (d8aVar != null) {
                d8aVar.x(z);
            }
        }
    }
}
