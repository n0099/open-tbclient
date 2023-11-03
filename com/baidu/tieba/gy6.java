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
public class gy6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;
    public BdTypeRecyclerView b;
    public sy6 c;
    public jy6 d;
    public ly6 e;
    public ky6 f;
    public my6 g;
    public ty6 h;
    public oy6 i;
    public qy6 j;
    public py6 k;
    public ny6 l;
    public ry6 m;
    public iy6 n;
    public uy6 o;
    public List<bi> p;

    public gy6(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            sy6 sy6Var = new sy6(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.w2());
            this.c = sy6Var;
            sy6Var.z(this.b);
            this.p.add(this.c);
            jy6 jy6Var = new jy6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.w2());
            this.d = jy6Var;
            jy6Var.A(this.b);
            this.p.add(this.d);
            ly6 ly6Var = new ly6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.w2());
            this.e = ly6Var;
            ly6Var.z(this.b);
            this.p.add(this.e);
            ky6 ky6Var = new ky6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.w2());
            this.f = ky6Var;
            ky6Var.z(this.b);
            this.p.add(this.f);
            my6 my6Var = new my6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.w2());
            this.g = my6Var;
            my6Var.z(this.b);
            this.p.add(this.g);
            ty6 ty6Var = new ty6(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.w2());
            this.h = ty6Var;
            ty6Var.C(this.b);
            this.p.add(this.h);
            oy6 oy6Var = new oy6(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.w2());
            this.i = oy6Var;
            oy6Var.x(this.b);
            this.p.add(this.i);
            qy6 qy6Var = new qy6(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.w2());
            this.j = qy6Var;
            qy6Var.z(this.b);
            this.p.add(this.j);
            py6 py6Var = new py6(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.w2());
            this.k = py6Var;
            py6Var.x(this.b);
            this.p.add(this.k);
            ny6 ny6Var = new ny6(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.w2());
            this.l = ny6Var;
            ny6Var.z(this.b);
            this.p.add(this.l);
            ry6 ry6Var = new ry6(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.w2());
            this.m = ry6Var;
            ry6Var.z(this.b);
            this.p.add(this.m);
            iy6 iy6Var = new iy6(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.w2());
            this.n = iy6Var;
            iy6Var.A(this.b);
            this.p.add(this.n);
            uy6 uy6Var = new uy6(this.a.getPageContext(), yy4.d, this.a.getUniqueId(), this.a.w2());
            this.o = uy6Var;
            uy6Var.y(this.b);
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
            jy6 jy6Var = this.d;
            if (jy6Var != null) {
                jy6Var.setFromCDN(z);
            }
            ky6 ky6Var = this.f;
            if (ky6Var != null) {
                ky6Var.setFromCDN(z);
            }
            ly6 ly6Var = this.e;
            if (ly6Var != null) {
                ly6Var.setFromCDN(z);
            }
        }
    }
}
