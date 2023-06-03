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
public class ez6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;
    public BdTypeRecyclerView b;
    public qz6 c;
    public hz6 d;
    public jz6 e;
    public iz6 f;
    public kz6 g;
    public rz6 h;
    public mz6 i;
    public oz6 j;
    public nz6 k;
    public lz6 l;
    public pz6 m;
    public gz6 n;
    public sz6 o;
    public List<in> p;

    public ez6(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            qz6 qz6Var = new qz6(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.J1());
            this.c = qz6Var;
            qz6Var.y(this.b);
            this.p.add(this.c);
            hz6 hz6Var = new hz6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.J1());
            this.d = hz6Var;
            hz6Var.z(this.b);
            this.p.add(this.d);
            jz6 jz6Var = new jz6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.J1());
            this.e = jz6Var;
            jz6Var.y(this.b);
            this.p.add(this.e);
            iz6 iz6Var = new iz6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.J1());
            this.f = iz6Var;
            iz6Var.y(this.b);
            this.p.add(this.f);
            kz6 kz6Var = new kz6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.J1());
            this.g = kz6Var;
            kz6Var.y(this.b);
            this.p.add(this.g);
            rz6 rz6Var = new rz6(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.J1());
            this.h = rz6Var;
            rz6Var.B(this.b);
            this.p.add(this.h);
            mz6 mz6Var = new mz6(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.J1());
            this.i = mz6Var;
            mz6Var.u(this.b);
            this.p.add(this.i);
            oz6 oz6Var = new oz6(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.J1());
            this.j = oz6Var;
            oz6Var.y(this.b);
            this.p.add(this.j);
            nz6 nz6Var = new nz6(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.J1());
            this.k = nz6Var;
            nz6Var.u(this.b);
            this.p.add(this.k);
            lz6 lz6Var = new lz6(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.J1());
            this.l = lz6Var;
            lz6Var.y(this.b);
            this.p.add(this.l);
            pz6 pz6Var = new pz6(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.J1());
            this.m = pz6Var;
            pz6Var.y(this.b);
            this.p.add(this.m);
            gz6 gz6Var = new gz6(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.J1());
            this.n = gz6Var;
            gz6Var.z(this.b);
            this.p.add(this.n);
            sz6 sz6Var = new sz6(this.a.getPageContext(), c45.d, this.a.getUniqueId(), this.a.J1());
            this.o = sz6Var;
            sz6Var.x(this.b);
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
            hz6 hz6Var = this.d;
            if (hz6Var != null) {
                hz6Var.setFromCDN(z);
            }
            iz6 iz6Var = this.f;
            if (iz6Var != null) {
                iz6Var.setFromCDN(z);
            }
            jz6 jz6Var = this.e;
            if (jz6Var != null) {
                jz6Var.setFromCDN(z);
            }
        }
    }
}
