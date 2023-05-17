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
public class du6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;
    public BdTypeRecyclerView b;
    public pu6 c;
    public gu6 d;
    public iu6 e;
    public hu6 f;
    public ju6 g;
    public qu6 h;
    public lu6 i;
    public nu6 j;
    public mu6 k;
    public ku6 l;
    public ou6 m;
    public fu6 n;
    public ru6 o;
    public List<en> p;

    public du6(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            pu6 pu6Var = new pu6(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.I1());
            this.c = pu6Var;
            pu6Var.y(this.b);
            this.p.add(this.c);
            gu6 gu6Var = new gu6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.I1());
            this.d = gu6Var;
            gu6Var.z(this.b);
            this.p.add(this.d);
            iu6 iu6Var = new iu6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.I1());
            this.e = iu6Var;
            iu6Var.y(this.b);
            this.p.add(this.e);
            hu6 hu6Var = new hu6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.I1());
            this.f = hu6Var;
            hu6Var.y(this.b);
            this.p.add(this.f);
            ju6 ju6Var = new ju6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.I1());
            this.g = ju6Var;
            ju6Var.y(this.b);
            this.p.add(this.g);
            qu6 qu6Var = new qu6(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.I1());
            this.h = qu6Var;
            qu6Var.B(this.b);
            this.p.add(this.h);
            lu6 lu6Var = new lu6(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.I1());
            this.i = lu6Var;
            lu6Var.u(this.b);
            this.p.add(this.i);
            nu6 nu6Var = new nu6(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.I1());
            this.j = nu6Var;
            nu6Var.y(this.b);
            this.p.add(this.j);
            mu6 mu6Var = new mu6(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.I1());
            this.k = mu6Var;
            mu6Var.u(this.b);
            this.p.add(this.k);
            ku6 ku6Var = new ku6(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.I1());
            this.l = ku6Var;
            ku6Var.y(this.b);
            this.p.add(this.l);
            ou6 ou6Var = new ou6(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.I1());
            this.m = ou6Var;
            ou6Var.y(this.b);
            this.p.add(this.m);
            fu6 fu6Var = new fu6(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.I1());
            this.n = fu6Var;
            fu6Var.z(this.b);
            this.p.add(this.n);
            ru6 ru6Var = new ru6(this.a.getPageContext(), f15.d, this.a.getUniqueId(), this.a.I1());
            this.o = ru6Var;
            ru6Var.x(this.b);
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

    public void c(ArrayList<rn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            gu6 gu6Var = this.d;
            if (gu6Var != null) {
                gu6Var.setFromCDN(z);
            }
            hu6 hu6Var = this.f;
            if (hu6Var != null) {
                hu6Var.setFromCDN(z);
            }
            iu6 iu6Var = this.e;
            if (iu6Var != null) {
                iu6Var.setFromCDN(z);
            }
        }
    }
}
