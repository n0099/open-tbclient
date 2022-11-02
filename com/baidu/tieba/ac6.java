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
public class ac6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;
    public BdTypeRecyclerView b;
    public mc6 c;
    public dc6 d;
    public fc6 e;
    public ec6 f;
    public gc6 g;
    public nc6 h;
    public ic6 i;
    public kc6 j;
    public jc6 k;
    public hc6 l;
    public lc6 m;
    public cc6 n;
    public oc6 o;
    public List<jn> p;

    public ac6(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            mc6 mc6Var = new mc6(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.s1());
            this.c = mc6Var;
            mc6Var.w(this.b);
            this.p.add(this.c);
            dc6 dc6Var = new dc6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.s1());
            this.d = dc6Var;
            dc6Var.x(this.b);
            this.p.add(this.d);
            fc6 fc6Var = new fc6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.s1());
            this.e = fc6Var;
            fc6Var.w(this.b);
            this.p.add(this.e);
            ec6 ec6Var = new ec6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.s1());
            this.f = ec6Var;
            ec6Var.w(this.b);
            this.p.add(this.f);
            gc6 gc6Var = new gc6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.s1());
            this.g = gc6Var;
            gc6Var.w(this.b);
            this.p.add(this.g);
            nc6 nc6Var = new nc6(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.s1());
            this.h = nc6Var;
            nc6Var.z(this.b);
            this.p.add(this.h);
            ic6 ic6Var = new ic6(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.s1());
            this.i = ic6Var;
            ic6Var.u(this.b);
            this.p.add(this.i);
            kc6 kc6Var = new kc6(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.s1());
            this.j = kc6Var;
            kc6Var.w(this.b);
            this.p.add(this.j);
            jc6 jc6Var = new jc6(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.s1());
            this.k = jc6Var;
            jc6Var.u(this.b);
            this.p.add(this.k);
            hc6 hc6Var = new hc6(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.s1());
            this.l = hc6Var;
            hc6Var.w(this.b);
            this.p.add(this.l);
            lc6 lc6Var = new lc6(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.s1());
            this.m = lc6Var;
            lc6Var.w(this.b);
            this.p.add(this.m);
            cc6 cc6Var = new cc6(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.s1());
            this.n = cc6Var;
            cc6Var.x(this.b);
            this.p.add(this.n);
            oc6 oc6Var = new oc6(this.a.getPageContext(), mu4.d, this.a.getUniqueId(), this.a.s1());
            this.o = oc6Var;
            oc6Var.v(this.b);
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

    public void c(ArrayList<wn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            dc6 dc6Var = this.d;
            if (dc6Var != null) {
                dc6Var.setFromCDN(z);
            }
            ec6 ec6Var = this.f;
            if (ec6Var != null) {
                ec6Var.setFromCDN(z);
            }
            fc6 fc6Var = this.e;
            if (fc6Var != null) {
                fc6Var.setFromCDN(z);
            }
        }
    }
}
