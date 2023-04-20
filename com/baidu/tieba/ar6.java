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
/* loaded from: classes3.dex */
public class ar6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;
    public BdTypeRecyclerView b;
    public mr6 c;
    public dr6 d;
    public fr6 e;
    public er6 f;
    public gr6 g;
    public nr6 h;
    public ir6 i;
    public kr6 j;
    public jr6 k;
    public hr6 l;
    public lr6 m;
    public cr6 n;
    public or6 o;
    public List<vm> p;

    public ar6(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            mr6 mr6Var = new mr6(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.G1());
            this.c = mr6Var;
            mr6Var.y(this.b);
            this.p.add(this.c);
            dr6 dr6Var = new dr6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.G1());
            this.d = dr6Var;
            dr6Var.z(this.b);
            this.p.add(this.d);
            fr6 fr6Var = new fr6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.G1());
            this.e = fr6Var;
            fr6Var.y(this.b);
            this.p.add(this.e);
            er6 er6Var = new er6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.G1());
            this.f = er6Var;
            er6Var.y(this.b);
            this.p.add(this.f);
            gr6 gr6Var = new gr6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.G1());
            this.g = gr6Var;
            gr6Var.y(this.b);
            this.p.add(this.g);
            nr6 nr6Var = new nr6(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.G1());
            this.h = nr6Var;
            nr6Var.B(this.b);
            this.p.add(this.h);
            ir6 ir6Var = new ir6(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.G1());
            this.i = ir6Var;
            ir6Var.u(this.b);
            this.p.add(this.i);
            kr6 kr6Var = new kr6(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.G1());
            this.j = kr6Var;
            kr6Var.y(this.b);
            this.p.add(this.j);
            jr6 jr6Var = new jr6(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.G1());
            this.k = jr6Var;
            jr6Var.u(this.b);
            this.p.add(this.k);
            hr6 hr6Var = new hr6(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.G1());
            this.l = hr6Var;
            hr6Var.y(this.b);
            this.p.add(this.l);
            lr6 lr6Var = new lr6(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.G1());
            this.m = lr6Var;
            lr6Var.y(this.b);
            this.p.add(this.m);
            cr6 cr6Var = new cr6(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.G1());
            this.n = cr6Var;
            cr6Var.z(this.b);
            this.p.add(this.n);
            or6 or6Var = new or6(this.a.getPageContext(), gz4.d, this.a.getUniqueId(), this.a.G1());
            this.o = or6Var;
            or6Var.x(this.b);
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

    public void c(ArrayList<in> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            dr6 dr6Var = this.d;
            if (dr6Var != null) {
                dr6Var.setFromCDN(z);
            }
            er6 er6Var = this.f;
            if (er6Var != null) {
                er6Var.setFromCDN(z);
            }
            fr6 fr6Var = this.e;
            if (fr6Var != null) {
                fr6Var.setFromCDN(z);
            }
        }
    }
}
