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
public class i86 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;
    public BdTypeRecyclerView b;
    public u86 c;
    public l86 d;
    public n86 e;
    public m86 f;
    public o86 g;
    public v86 h;
    public q86 i;
    public s86 j;
    public r86 k;
    public p86 l;
    public t86 m;
    public k86 n;
    public w86 o;
    public List<cn> p;

    public i86(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            u86 u86Var = new u86(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.t1());
            this.c = u86Var;
            u86Var.w(this.b);
            this.p.add(this.c);
            l86 l86Var = new l86(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.t1());
            this.d = l86Var;
            l86Var.x(this.b);
            this.p.add(this.d);
            n86 n86Var = new n86(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.t1());
            this.e = n86Var;
            n86Var.w(this.b);
            this.p.add(this.e);
            m86 m86Var = new m86(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.t1());
            this.f = m86Var;
            m86Var.w(this.b);
            this.p.add(this.f);
            o86 o86Var = new o86(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.t1());
            this.g = o86Var;
            o86Var.w(this.b);
            this.p.add(this.g);
            v86 v86Var = new v86(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.t1());
            this.h = v86Var;
            v86Var.z(this.b);
            this.p.add(this.h);
            q86 q86Var = new q86(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.t1());
            this.i = q86Var;
            q86Var.u(this.b);
            this.p.add(this.i);
            s86 s86Var = new s86(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.t1());
            this.j = s86Var;
            s86Var.w(this.b);
            this.p.add(this.j);
            r86 r86Var = new r86(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.t1());
            this.k = r86Var;
            r86Var.u(this.b);
            this.p.add(this.k);
            p86 p86Var = new p86(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.t1());
            this.l = p86Var;
            p86Var.w(this.b);
            this.p.add(this.l);
            t86 t86Var = new t86(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.t1());
            this.m = t86Var;
            t86Var.w(this.b);
            this.p.add(this.m);
            k86 k86Var = new k86(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.t1());
            this.n = k86Var;
            k86Var.x(this.b);
            this.p.add(this.n);
            w86 w86Var = new w86(this.a.getPageContext(), dr4.d, this.a.getUniqueId(), this.a.t1());
            this.o = w86Var;
            w86Var.v(this.b);
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

    public void c(ArrayList<pn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            l86 l86Var = this.d;
            if (l86Var != null) {
                l86Var.setFromCDN(z);
            }
            m86 m86Var = this.f;
            if (m86Var != null) {
                m86Var.setFromCDN(z);
            }
            n86 n86Var = this.e;
            if (n86Var != null) {
                n86Var.setFromCDN(z);
            }
        }
    }
}
