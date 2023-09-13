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
public class a27 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;
    public BdTypeRecyclerView b;
    public m27 c;
    public d27 d;
    public f27 e;
    public e27 f;
    public g27 g;
    public n27 h;
    public i27 i;
    public k27 j;
    public j27 k;
    public h27 l;
    public l27 m;
    public c27 n;
    public o27 o;
    public List<pm> p;

    public a27(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            m27 m27Var = new m27(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.Y1());
            this.c = m27Var;
            m27Var.y(this.b);
            this.p.add(this.c);
            d27 d27Var = new d27(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.Y1());
            this.d = d27Var;
            d27Var.z(this.b);
            this.p.add(this.d);
            f27 f27Var = new f27(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.Y1());
            this.e = f27Var;
            f27Var.y(this.b);
            this.p.add(this.e);
            e27 e27Var = new e27(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.Y1());
            this.f = e27Var;
            e27Var.y(this.b);
            this.p.add(this.f);
            g27 g27Var = new g27(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.Y1());
            this.g = g27Var;
            g27Var.y(this.b);
            this.p.add(this.g);
            n27 n27Var = new n27(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.Y1());
            this.h = n27Var;
            n27Var.B(this.b);
            this.p.add(this.h);
            i27 i27Var = new i27(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.Y1());
            this.i = i27Var;
            i27Var.u(this.b);
            this.p.add(this.i);
            k27 k27Var = new k27(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.Y1());
            this.j = k27Var;
            k27Var.y(this.b);
            this.p.add(this.j);
            j27 j27Var = new j27(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.Y1());
            this.k = j27Var;
            j27Var.u(this.b);
            this.p.add(this.k);
            h27 h27Var = new h27(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.Y1());
            this.l = h27Var;
            h27Var.y(this.b);
            this.p.add(this.l);
            l27 l27Var = new l27(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.Y1());
            this.m = l27Var;
            l27Var.y(this.b);
            this.p.add(this.m);
            c27 c27Var = new c27(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.Y1());
            this.n = c27Var;
            c27Var.z(this.b);
            this.p.add(this.n);
            o27 o27Var = new o27(this.a.getPageContext(), y35.d, this.a.getUniqueId(), this.a.Y1());
            this.o = o27Var;
            o27Var.x(this.b);
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

    public void c(ArrayList<cn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            d27 d27Var = this.d;
            if (d27Var != null) {
                d27Var.setFromCDN(z);
            }
            e27 e27Var = this.f;
            if (e27Var != null) {
                e27Var.setFromCDN(z);
            }
            f27 f27Var = this.e;
            if (f27Var != null) {
                f27Var.setFromCDN(z);
            }
        }
    }
}
