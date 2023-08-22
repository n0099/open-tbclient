package com.baidu.tieba;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.homepage.tabfeed.HomePageTabFeedFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class c78 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public BdTypeRecyclerView b;
    public y78 c;
    public r78 d;
    public m78 e;
    public o78 f;
    public n78 g;
    public p78 h;
    public z78 i;
    public q78 j;
    public t78 k;
    public v78 l;
    public u78 m;
    public x78 n;
    public k78 o;
    public i78 p;
    public h78 q;
    public j78 r;
    public s78 s;
    public w78 t;
    public l78 u;
    public a88 v;
    public List<om> w;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c78 a;

        public a(c78 c78Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c78Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c78Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.b.getCount() != 0 && (this.a.b.getItem(0) instanceof b88)) {
                    this.a.b.removeItem(0);
                }
            }
        }
    }

    public c78(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {homePageTabFeedFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.w = new LinkedList();
        this.a = homePageTabFeedFragment;
        this.b = bdTypeRecyclerView;
        c();
    }

    public void e(ArrayList<bn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void f(boolean z) {
        a88 a88Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (a88Var = this.v) != null) {
            a88Var.u(z);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (om omVar : this.w) {
                if (omVar instanceof e78) {
                    ((e78) omVar).h(str);
                }
            }
        }
    }

    public final View.OnClickListener b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this);
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.getAdapter().notifyDataSetChanged();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            y78 y78Var = new y78(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.h2(), this.a.g2());
            this.c = y78Var;
            y78Var.y(this.b);
            this.w.add(this.c);
            r78 r78Var = new r78(this.a.getPageContext());
            this.d = r78Var;
            r78Var.x(this.b);
            this.w.add(this.d);
            m78 m78Var = new m78(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.h2());
            this.e = m78Var;
            m78Var.z(this.b);
            this.w.add(this.e);
            o78 o78Var = new o78(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.h2());
            this.f = o78Var;
            o78Var.y(this.b);
            this.w.add(this.f);
            n78 n78Var = new n78(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.h2());
            this.g = n78Var;
            n78Var.y(this.b);
            this.w.add(this.g);
            p78 p78Var = new p78(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.h2());
            this.h = p78Var;
            p78Var.y(this.b);
            this.w.add(this.h);
            z78 z78Var = new z78(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.h2());
            this.i = z78Var;
            z78Var.B(this.b);
            this.w.add(this.i);
            q78 q78Var = new q78(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.h2());
            this.j = q78Var;
            q78Var.y(this.b);
            if ("fashion".equals(this.a.g2()) || "local".equals(this.a.g2())) {
                this.w.add(this.j);
            }
            t78 t78Var = new t78(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.h2());
            this.k = t78Var;
            t78Var.u(this.b);
            this.w.add(this.k);
            v78 v78Var = new v78(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.h2());
            this.l = v78Var;
            v78Var.x(this.b);
            this.w.add(this.l);
            u78 u78Var = new u78(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.h2());
            this.m = u78Var;
            u78Var.u(this.b);
            this.w.add(this.m);
            x78 x78Var = new x78(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.h2());
            this.n = x78Var;
            x78Var.x(this.b);
            this.w.add(this.n);
            k78 k78Var = new k78(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.h2());
            this.o = k78Var;
            k78Var.z(this.b);
            this.w.add(this.o);
            j78 j78Var = new j78(this.a.getPageContext(), yo6.S0, this.a.h2());
            this.r = j78Var;
            this.w.add(j78Var);
            i78 i78Var = new i78(this.a.getPageContext(), r35.e);
            this.p = i78Var;
            i78Var.x(this.b);
            this.w.add(this.p);
            h78 h78Var = new h78(this.a.getPageContext(), w15.b);
            this.q = h78Var;
            h78Var.A(this.b);
            this.w.add(this.q);
            s78 s78Var = new s78(this.a.getPageContext());
            this.s = s78Var;
            s78Var.u(this.b);
            this.w.add(this.s);
            w78 w78Var = new w78(this.a.getPageContext());
            this.t = w78Var;
            w78Var.u(this.b);
            this.w.add(this.t);
            l78 l78Var = new l78(this.a.getPageContext(), b());
            this.u = l78Var;
            this.w.add(l78Var);
            a88 a88Var = new a88(this.a.getPageContext());
            this.v = a88Var;
            this.w.add(a88Var);
            this.b.addAdapters(this.w);
        }
    }
}
