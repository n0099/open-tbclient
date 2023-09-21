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
/* loaded from: classes6.dex */
public class h27 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;
    public BdTypeRecyclerView b;
    public t27 c;
    public k27 d;
    public m27 e;
    public l27 f;
    public n27 g;
    public u27 h;
    public p27 i;
    public r27 j;
    public q27 k;
    public o27 l;
    public s27 m;
    public j27 n;
    public v27 o;
    public List<om> p;

    public h27(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            t27 t27Var = new t27(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.e2());
            this.c = t27Var;
            t27Var.y(this.b);
            this.p.add(this.c);
            k27 k27Var = new k27(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.e2());
            this.d = k27Var;
            k27Var.z(this.b);
            this.p.add(this.d);
            m27 m27Var = new m27(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.e2());
            this.e = m27Var;
            m27Var.y(this.b);
            this.p.add(this.e);
            l27 l27Var = new l27(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.e2());
            this.f = l27Var;
            l27Var.y(this.b);
            this.p.add(this.f);
            n27 n27Var = new n27(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.e2());
            this.g = n27Var;
            n27Var.y(this.b);
            this.p.add(this.g);
            u27 u27Var = new u27(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.e2());
            this.h = u27Var;
            u27Var.B(this.b);
            this.p.add(this.h);
            p27 p27Var = new p27(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.e2());
            this.i = p27Var;
            p27Var.u(this.b);
            this.p.add(this.i);
            r27 r27Var = new r27(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.e2());
            this.j = r27Var;
            r27Var.y(this.b);
            this.p.add(this.j);
            q27 q27Var = new q27(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.e2());
            this.k = q27Var;
            q27Var.u(this.b);
            this.p.add(this.k);
            o27 o27Var = new o27(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.e2());
            this.l = o27Var;
            o27Var.y(this.b);
            this.p.add(this.l);
            s27 s27Var = new s27(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.e2());
            this.m = s27Var;
            s27Var.y(this.b);
            this.p.add(this.m);
            j27 j27Var = new j27(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.e2());
            this.n = j27Var;
            j27Var.z(this.b);
            this.p.add(this.n);
            v27 v27Var = new v27(this.a.getPageContext(), y35.d, this.a.getUniqueId(), this.a.e2());
            this.o = v27Var;
            v27Var.x(this.b);
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

    public void c(ArrayList<bn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            k27 k27Var = this.d;
            if (k27Var != null) {
                k27Var.setFromCDN(z);
            }
            l27 l27Var = this.f;
            if (l27Var != null) {
                l27Var.setFromCDN(z);
            }
            m27 m27Var = this.e;
            if (m27Var != null) {
                m27Var.setFromCDN(z);
            }
        }
    }
}
