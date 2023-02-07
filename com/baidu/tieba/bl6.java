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
public class bl6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;
    public BdTypeRecyclerView b;
    public nl6 c;
    public el6 d;
    public gl6 e;
    public fl6 f;
    public hl6 g;
    public ol6 h;
    public jl6 i;
    public ll6 j;
    public kl6 k;
    public il6 l;
    public ml6 m;
    public dl6 n;
    public pl6 o;
    public List<qn> p;

    public bl6(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            nl6 nl6Var = new nl6(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.E1());
            this.c = nl6Var;
            nl6Var.w(this.b);
            this.p.add(this.c);
            el6 el6Var = new el6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.E1());
            this.d = el6Var;
            el6Var.x(this.b);
            this.p.add(this.d);
            gl6 gl6Var = new gl6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.E1());
            this.e = gl6Var;
            gl6Var.w(this.b);
            this.p.add(this.e);
            fl6 fl6Var = new fl6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.E1());
            this.f = fl6Var;
            fl6Var.w(this.b);
            this.p.add(this.f);
            hl6 hl6Var = new hl6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.E1());
            this.g = hl6Var;
            hl6Var.w(this.b);
            this.p.add(this.g);
            ol6 ol6Var = new ol6(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.E1());
            this.h = ol6Var;
            ol6Var.z(this.b);
            this.p.add(this.h);
            jl6 jl6Var = new jl6(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.E1());
            this.i = jl6Var;
            jl6Var.u(this.b);
            this.p.add(this.i);
            ll6 ll6Var = new ll6(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.E1());
            this.j = ll6Var;
            ll6Var.w(this.b);
            this.p.add(this.j);
            kl6 kl6Var = new kl6(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.E1());
            this.k = kl6Var;
            kl6Var.u(this.b);
            this.p.add(this.k);
            il6 il6Var = new il6(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.E1());
            this.l = il6Var;
            il6Var.w(this.b);
            this.p.add(this.l);
            ml6 ml6Var = new ml6(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.E1());
            this.m = ml6Var;
            ml6Var.w(this.b);
            this.p.add(this.m);
            dl6 dl6Var = new dl6(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.E1());
            this.n = dl6Var;
            dl6Var.x(this.b);
            this.p.add(this.n);
            pl6 pl6Var = new pl6(this.a.getPageContext(), nz4.d, this.a.getUniqueId(), this.a.E1());
            this.o = pl6Var;
            pl6Var.v(this.b);
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
            el6 el6Var = this.d;
            if (el6Var != null) {
                el6Var.setFromCDN(z);
            }
            fl6 fl6Var = this.f;
            if (fl6Var != null) {
                fl6Var.setFromCDN(z);
            }
            gl6 gl6Var = this.e;
            if (gl6Var != null) {
                gl6Var.setFromCDN(z);
            }
        }
    }
}
