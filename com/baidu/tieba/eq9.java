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
public class eq9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wp9 a;
    public tp9 b;
    public bq9 c;
    public cq9 d;
    public xp9 e;
    public aq9 f;
    public vp9 g;
    public yp9 h;
    public zp9 i;
    public BdTypeListView j;
    public up9 k;
    public dq9 l;
    public List<lh> m;

    public eq9(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
            this.a = new wp9(tbPageContext, sq9.b);
            this.b = new tp9(tbPageContext, mq9.f);
            this.c = new bq9(tbPageContext, yq9.b);
            this.d = new cq9(tbPageContext, zq9.b);
            this.e = new xp9(tbPageContext, oq9.b);
            this.f = new aq9(tbPageContext, pq9.b);
            this.k = new up9(tbPageContext, qq9.b);
            this.h = new yp9(tbPageContext, uq9.b);
            this.i = new zp9(tbPageContext, vq9.b);
            this.g = new vp9(tbPageContext, rq9.p);
            this.l = new dq9(tbPageContext, PersonVipCardData.PERSON_VIP_CARD_DATA);
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
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.j) != null && (bdTypeListView.getAdapter2() instanceof ph)) {
            this.j.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c() {
        dq9 dq9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (dq9Var = this.l) != null) {
            dq9Var.onDestroy();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            dq9 dq9Var = this.l;
            if (dq9Var != null) {
                dq9Var.onPause();
            }
            bq9 bq9Var = this.c;
            if (bq9Var != null) {
                bq9Var.onPause();
            }
        }
    }

    public void f() {
        dq9 dq9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (dq9Var = this.l) != null) {
            dq9Var.onResume();
        }
    }

    public void g() {
        yp9 yp9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (yp9Var = this.h) != null) {
            yp9Var.onScroll();
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            dq9 dq9Var = this.l;
            if (dq9Var != null) {
                dq9Var.u(z);
            }
            up9 up9Var = this.k;
            if (up9Var != null) {
                up9Var.u(z);
            }
            aq9 aq9Var = this.f;
            if (aq9Var != null) {
                aq9Var.u(z);
            }
            bq9 bq9Var = this.c;
            if (bq9Var != null) {
                bq9Var.u(z);
            }
        }
    }
}
