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
public class hy6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;
    public BdTypeRecyclerView b;
    public ty6 c;
    public ky6 d;
    public my6 e;
    public ly6 f;
    public ny6 g;
    public uy6 h;
    public py6 i;
    public ry6 j;
    public qy6 k;
    public oy6 l;
    public sy6 m;
    public jy6 n;
    public vy6 o;
    public List<bi> p;

    public hy6(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            ty6 ty6Var = new ty6(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.w2());
            this.c = ty6Var;
            ty6Var.z(this.b);
            this.p.add(this.c);
            ky6 ky6Var = new ky6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.w2());
            this.d = ky6Var;
            ky6Var.A(this.b);
            this.p.add(this.d);
            my6 my6Var = new my6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.w2());
            this.e = my6Var;
            my6Var.z(this.b);
            this.p.add(this.e);
            ly6 ly6Var = new ly6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.w2());
            this.f = ly6Var;
            ly6Var.z(this.b);
            this.p.add(this.f);
            ny6 ny6Var = new ny6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.w2());
            this.g = ny6Var;
            ny6Var.z(this.b);
            this.p.add(this.g);
            uy6 uy6Var = new uy6(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.w2());
            this.h = uy6Var;
            uy6Var.C(this.b);
            this.p.add(this.h);
            py6 py6Var = new py6(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.w2());
            this.i = py6Var;
            py6Var.x(this.b);
            this.p.add(this.i);
            ry6 ry6Var = new ry6(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.w2());
            this.j = ry6Var;
            ry6Var.z(this.b);
            this.p.add(this.j);
            qy6 qy6Var = new qy6(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.w2());
            this.k = qy6Var;
            qy6Var.x(this.b);
            this.p.add(this.k);
            oy6 oy6Var = new oy6(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.w2());
            this.l = oy6Var;
            oy6Var.z(this.b);
            this.p.add(this.l);
            sy6 sy6Var = new sy6(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.w2());
            this.m = sy6Var;
            sy6Var.z(this.b);
            this.p.add(this.m);
            jy6 jy6Var = new jy6(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.w2());
            this.n = jy6Var;
            jy6Var.A(this.b);
            this.p.add(this.n);
            vy6 vy6Var = new vy6(this.a.getPageContext(), yy4.d, this.a.getUniqueId(), this.a.w2());
            this.o = vy6Var;
            vy6Var.y(this.b);
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

    public void c(ArrayList<oi> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            ky6 ky6Var = this.d;
            if (ky6Var != null) {
                ky6Var.setFromCDN(z);
            }
            ly6 ly6Var = this.f;
            if (ly6Var != null) {
                ly6Var.setFromCDN(z);
            }
            my6 my6Var = this.e;
            if (my6Var != null) {
                my6Var.setFromCDN(z);
            }
        }
    }
}
