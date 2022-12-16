package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.enterForum.tabfeed.EnterForumTabFeedFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class id6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;
    public BdTypeRecyclerView b;
    public ud6 c;
    public ld6 d;
    public nd6 e;
    public md6 f;
    public od6 g;
    public vd6 h;
    public qd6 i;
    public sd6 j;
    public rd6 k;
    public pd6 l;
    public td6 m;
    public kd6 n;
    public wd6 o;
    public List<kn> p;

    public id6(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {enterForumTabFeedFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = new LinkedList();
        this.a = enterForumTabFeedFragment;
        this.b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ud6 ud6Var = new ud6(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.z1());
            this.c = ud6Var;
            ud6Var.w(this.b);
            this.p.add(this.c);
            ld6 ld6Var = new ld6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.z1());
            this.d = ld6Var;
            ld6Var.x(this.b);
            this.p.add(this.d);
            nd6 nd6Var = new nd6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.z1());
            this.e = nd6Var;
            nd6Var.w(this.b);
            this.p.add(this.e);
            md6 md6Var = new md6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.z1());
            this.f = md6Var;
            md6Var.w(this.b);
            this.p.add(this.f);
            od6 od6Var = new od6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.z1());
            this.g = od6Var;
            od6Var.w(this.b);
            this.p.add(this.g);
            vd6 vd6Var = new vd6(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.z1());
            this.h = vd6Var;
            vd6Var.z(this.b);
            this.p.add(this.h);
            qd6 qd6Var = new qd6(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.z1());
            this.i = qd6Var;
            qd6Var.u(this.b);
            this.p.add(this.i);
            sd6 sd6Var = new sd6(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.z1());
            this.j = sd6Var;
            sd6Var.w(this.b);
            this.p.add(this.j);
            rd6 rd6Var = new rd6(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.z1());
            this.k = rd6Var;
            rd6Var.u(this.b);
            this.p.add(this.k);
            pd6 pd6Var = new pd6(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.z1());
            this.l = pd6Var;
            pd6Var.w(this.b);
            this.p.add(this.l);
            td6 td6Var = new td6(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.z1());
            this.m = td6Var;
            td6Var.w(this.b);
            this.p.add(this.m);
            kd6 kd6Var = new kd6(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.z1());
            this.n = kd6Var;
            kd6Var.x(this.b);
            this.p.add(this.n);
            wd6 wd6Var = new wd6(this.a.getPageContext(), pu4.d, this.a.getUniqueId(), this.a.z1());
            this.o = wd6Var;
            wd6Var.v(this.b);
            this.p.add(this.o);
            this.b.a(this.p);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.getAdapter().notifyDataSetChanged();
        }
    }

    public void c(ArrayList<xn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            ld6 ld6Var = this.d;
            if (ld6Var != null) {
                ld6Var.setFromCDN(z);
            }
            md6 md6Var = this.f;
            if (md6Var != null) {
                md6Var.setFromCDN(z);
            }
            nd6 nd6Var = this.e;
            if (nd6Var != null) {
                nd6Var.setFromCDN(z);
            }
        }
    }
}
