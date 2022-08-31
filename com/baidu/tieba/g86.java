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
public class g86 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;
    public BdTypeRecyclerView b;
    public s86 c;
    public j86 d;
    public l86 e;
    public k86 f;
    public m86 g;
    public t86 h;
    public o86 i;
    public q86 j;
    public p86 k;
    public n86 l;
    public r86 m;
    public i86 n;
    public u86 o;
    public List<cn> p;

    public g86(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            s86 s86Var = new s86(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.t1());
            this.c = s86Var;
            s86Var.w(this.b);
            this.p.add(this.c);
            j86 j86Var = new j86(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.t1());
            this.d = j86Var;
            j86Var.x(this.b);
            this.p.add(this.d);
            l86 l86Var = new l86(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.t1());
            this.e = l86Var;
            l86Var.w(this.b);
            this.p.add(this.e);
            k86 k86Var = new k86(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.t1());
            this.f = k86Var;
            k86Var.w(this.b);
            this.p.add(this.f);
            m86 m86Var = new m86(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.t1());
            this.g = m86Var;
            m86Var.w(this.b);
            this.p.add(this.g);
            t86 t86Var = new t86(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.t1());
            this.h = t86Var;
            t86Var.z(this.b);
            this.p.add(this.h);
            o86 o86Var = new o86(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.t1());
            this.i = o86Var;
            o86Var.u(this.b);
            this.p.add(this.i);
            q86 q86Var = new q86(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.t1());
            this.j = q86Var;
            q86Var.w(this.b);
            this.p.add(this.j);
            p86 p86Var = new p86(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.t1());
            this.k = p86Var;
            p86Var.u(this.b);
            this.p.add(this.k);
            n86 n86Var = new n86(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.t1());
            this.l = n86Var;
            n86Var.w(this.b);
            this.p.add(this.l);
            r86 r86Var = new r86(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.t1());
            this.m = r86Var;
            r86Var.w(this.b);
            this.p.add(this.m);
            i86 i86Var = new i86(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.t1());
            this.n = i86Var;
            i86Var.x(this.b);
            this.p.add(this.n);
            u86 u86Var = new u86(this.a.getPageContext(), cr4.d, this.a.getUniqueId(), this.a.t1());
            this.o = u86Var;
            u86Var.v(this.b);
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
            j86 j86Var = this.d;
            if (j86Var != null) {
                j86Var.setFromCDN(z);
            }
            k86 k86Var = this.f;
            if (k86Var != null) {
                k86Var.setFromCDN(z);
            }
            l86 l86Var = this.e;
            if (l86Var != null) {
                l86Var.setFromCDN(z);
            }
        }
    }
}
