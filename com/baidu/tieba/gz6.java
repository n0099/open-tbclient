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
/* loaded from: classes5.dex */
public class gz6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;
    public BdTypeRecyclerView b;
    public sz6 c;
    public jz6 d;
    public lz6 e;
    public kz6 f;
    public mz6 g;
    public tz6 h;
    public oz6 i;
    public qz6 j;
    public pz6 k;
    public nz6 l;
    public rz6 m;
    public iz6 n;
    public uz6 o;
    public List<in> p;

    public gz6(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            sz6 sz6Var = new sz6(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.J1());
            this.c = sz6Var;
            sz6Var.y(this.b);
            this.p.add(this.c);
            jz6 jz6Var = new jz6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.J1());
            this.d = jz6Var;
            jz6Var.z(this.b);
            this.p.add(this.d);
            lz6 lz6Var = new lz6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.J1());
            this.e = lz6Var;
            lz6Var.y(this.b);
            this.p.add(this.e);
            kz6 kz6Var = new kz6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.J1());
            this.f = kz6Var;
            kz6Var.y(this.b);
            this.p.add(this.f);
            mz6 mz6Var = new mz6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.J1());
            this.g = mz6Var;
            mz6Var.y(this.b);
            this.p.add(this.g);
            tz6 tz6Var = new tz6(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.J1());
            this.h = tz6Var;
            tz6Var.B(this.b);
            this.p.add(this.h);
            oz6 oz6Var = new oz6(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.J1());
            this.i = oz6Var;
            oz6Var.u(this.b);
            this.p.add(this.i);
            qz6 qz6Var = new qz6(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.J1());
            this.j = qz6Var;
            qz6Var.y(this.b);
            this.p.add(this.j);
            pz6 pz6Var = new pz6(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.J1());
            this.k = pz6Var;
            pz6Var.u(this.b);
            this.p.add(this.k);
            nz6 nz6Var = new nz6(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.J1());
            this.l = nz6Var;
            nz6Var.y(this.b);
            this.p.add(this.l);
            rz6 rz6Var = new rz6(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.J1());
            this.m = rz6Var;
            rz6Var.y(this.b);
            this.p.add(this.m);
            iz6 iz6Var = new iz6(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.J1());
            this.n = iz6Var;
            iz6Var.z(this.b);
            this.p.add(this.n);
            uz6 uz6Var = new uz6(this.a.getPageContext(), e45.d, this.a.getUniqueId(), this.a.J1());
            this.o = uz6Var;
            uz6Var.x(this.b);
            this.p.add(this.o);
            this.b.addAdapters(this.p);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.getAdapter().notifyDataSetChanged();
        }
    }

    public void c(ArrayList<vn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            jz6 jz6Var = this.d;
            if (jz6Var != null) {
                jz6Var.setFromCDN(z);
            }
            kz6 kz6Var = this.f;
            if (kz6Var != null) {
                kz6Var.setFromCDN(z);
            }
            lz6 lz6Var = this.e;
            if (lz6Var != null) {
                lz6Var.setFromCDN(z);
            }
        }
    }
}
