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
public class ao6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;
    public BdTypeRecyclerView b;
    public mo6 c;
    public do6 d;
    public fo6 e;
    public eo6 f;
    public go6 g;
    public no6 h;
    public io6 i;
    public ko6 j;
    public jo6 k;
    public ho6 l;
    public lo6 m;
    public co6 n;
    public oo6 o;
    public List<qn> p;

    public ao6(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            mo6 mo6Var = new mo6(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.E1());
            this.c = mo6Var;
            mo6Var.w(this.b);
            this.p.add(this.c);
            do6 do6Var = new do6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.E1());
            this.d = do6Var;
            do6Var.x(this.b);
            this.p.add(this.d);
            fo6 fo6Var = new fo6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.E1());
            this.e = fo6Var;
            fo6Var.w(this.b);
            this.p.add(this.e);
            eo6 eo6Var = new eo6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.E1());
            this.f = eo6Var;
            eo6Var.w(this.b);
            this.p.add(this.f);
            go6 go6Var = new go6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.E1());
            this.g = go6Var;
            go6Var.w(this.b);
            this.p.add(this.g);
            no6 no6Var = new no6(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.E1());
            this.h = no6Var;
            no6Var.z(this.b);
            this.p.add(this.h);
            io6 io6Var = new io6(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.E1());
            this.i = io6Var;
            io6Var.u(this.b);
            this.p.add(this.i);
            ko6 ko6Var = new ko6(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.E1());
            this.j = ko6Var;
            ko6Var.w(this.b);
            this.p.add(this.j);
            jo6 jo6Var = new jo6(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.E1());
            this.k = jo6Var;
            jo6Var.u(this.b);
            this.p.add(this.k);
            ho6 ho6Var = new ho6(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.E1());
            this.l = ho6Var;
            ho6Var.w(this.b);
            this.p.add(this.l);
            lo6 lo6Var = new lo6(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.E1());
            this.m = lo6Var;
            lo6Var.w(this.b);
            this.p.add(this.m);
            co6 co6Var = new co6(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.E1());
            this.n = co6Var;
            co6Var.x(this.b);
            this.p.add(this.n);
            oo6 oo6Var = new oo6(this.a.getPageContext(), u05.d, this.a.getUniqueId(), this.a.E1());
            this.o = oo6Var;
            oo6Var.v(this.b);
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

    public void c(ArrayList<Cdo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            do6 do6Var = this.d;
            if (do6Var != null) {
                do6Var.setFromCDN(z);
            }
            eo6 eo6Var = this.f;
            if (eo6Var != null) {
                eo6Var.setFromCDN(z);
            }
            fo6 fo6Var = this.e;
            if (fo6Var != null) {
                fo6Var.setFromCDN(z);
            }
        }
    }
}
