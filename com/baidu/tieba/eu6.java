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
public class eu6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;
    public BdTypeRecyclerView b;
    public qu6 c;
    public hu6 d;
    public ju6 e;
    public iu6 f;
    public ku6 g;
    public ru6 h;
    public mu6 i;
    public ou6 j;
    public nu6 k;
    public lu6 l;
    public pu6 m;
    public gu6 n;
    public su6 o;
    public List<en> p;

    public eu6(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            qu6 qu6Var = new qu6(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.I1());
            this.c = qu6Var;
            qu6Var.y(this.b);
            this.p.add(this.c);
            hu6 hu6Var = new hu6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.I1());
            this.d = hu6Var;
            hu6Var.z(this.b);
            this.p.add(this.d);
            ju6 ju6Var = new ju6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.I1());
            this.e = ju6Var;
            ju6Var.y(this.b);
            this.p.add(this.e);
            iu6 iu6Var = new iu6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.I1());
            this.f = iu6Var;
            iu6Var.y(this.b);
            this.p.add(this.f);
            ku6 ku6Var = new ku6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.I1());
            this.g = ku6Var;
            ku6Var.y(this.b);
            this.p.add(this.g);
            ru6 ru6Var = new ru6(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.I1());
            this.h = ru6Var;
            ru6Var.B(this.b);
            this.p.add(this.h);
            mu6 mu6Var = new mu6(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.I1());
            this.i = mu6Var;
            mu6Var.u(this.b);
            this.p.add(this.i);
            ou6 ou6Var = new ou6(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.I1());
            this.j = ou6Var;
            ou6Var.y(this.b);
            this.p.add(this.j);
            nu6 nu6Var = new nu6(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.I1());
            this.k = nu6Var;
            nu6Var.u(this.b);
            this.p.add(this.k);
            lu6 lu6Var = new lu6(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.I1());
            this.l = lu6Var;
            lu6Var.y(this.b);
            this.p.add(this.l);
            pu6 pu6Var = new pu6(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.I1());
            this.m = pu6Var;
            pu6Var.y(this.b);
            this.p.add(this.m);
            gu6 gu6Var = new gu6(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.I1());
            this.n = gu6Var;
            gu6Var.z(this.b);
            this.p.add(this.n);
            su6 su6Var = new su6(this.a.getPageContext(), f15.d, this.a.getUniqueId(), this.a.I1());
            this.o = su6Var;
            su6Var.x(this.b);
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
            hu6 hu6Var = this.d;
            if (hu6Var != null) {
                hu6Var.setFromCDN(z);
            }
            iu6 iu6Var = this.f;
            if (iu6Var != null) {
                iu6Var.setFromCDN(z);
            }
            ju6 ju6Var = this.e;
            if (ju6Var != null) {
                ju6Var.setFromCDN(z);
            }
        }
    }
}
