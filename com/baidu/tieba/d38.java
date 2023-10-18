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
public class d38 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public BdTypeRecyclerView b;
    public z38 c;
    public s38 d;
    public n38 e;
    public p38 f;
    public o38 g;
    public q38 h;
    public a48 i;
    public r38 j;
    public u38 k;
    public w38 l;
    public v38 m;
    public y38 n;
    public l38 o;
    public j38 p;
    public i38 q;
    public k38 r;
    public t38 s;
    public x38 t;
    public m38 u;
    public b48 v;
    public List<lh> w;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d38 a;

        public a(d38 d38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d38Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.b.getCount() != 0 && (this.a.b.getItem(0) instanceof c48)) {
                    this.a.b.removeItem(0);
                }
            }
        }
    }

    public d38(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void e(ArrayList<yh> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void f(boolean z) {
        b48 b48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (b48Var = this.v) != null) {
            b48Var.u(z);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (lh lhVar : this.w) {
                if (lhVar instanceof f38) {
                    ((f38) lhVar).h(str);
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
            z38 z38Var = new z38(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.p2(), this.a.o2());
            this.c = z38Var;
            z38Var.y(this.b);
            this.w.add(this.c);
            s38 s38Var = new s38(this.a.getPageContext());
            this.d = s38Var;
            s38Var.x(this.b);
            this.w.add(this.d);
            n38 n38Var = new n38(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.p2());
            this.e = n38Var;
            n38Var.z(this.b);
            this.w.add(this.e);
            p38 p38Var = new p38(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.p2());
            this.f = p38Var;
            p38Var.y(this.b);
            this.w.add(this.f);
            o38 o38Var = new o38(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.p2());
            this.g = o38Var;
            o38Var.y(this.b);
            this.w.add(this.g);
            q38 q38Var = new q38(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.p2());
            this.h = q38Var;
            q38Var.y(this.b);
            this.w.add(this.h);
            a48 a48Var = new a48(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.p2());
            this.i = a48Var;
            a48Var.B(this.b);
            this.w.add(this.i);
            r38 r38Var = new r38(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.p2());
            this.j = r38Var;
            r38Var.y(this.b);
            if ("fashion".equals(this.a.o2()) || "local".equals(this.a.o2())) {
                this.w.add(this.j);
            }
            u38 u38Var = new u38(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.p2());
            this.k = u38Var;
            u38Var.u(this.b);
            this.w.add(this.k);
            w38 w38Var = new w38(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.p2());
            this.l = w38Var;
            w38Var.x(this.b);
            this.w.add(this.l);
            v38 v38Var = new v38(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.p2());
            this.m = v38Var;
            v38Var.u(this.b);
            this.w.add(this.m);
            y38 y38Var = new y38(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.p2());
            this.n = y38Var;
            y38Var.x(this.b);
            this.w.add(this.n);
            l38 l38Var = new l38(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.p2());
            this.o = l38Var;
            l38Var.z(this.b);
            this.w.add(this.o);
            k38 k38Var = new k38(this.a.getPageContext(), qk6.S0, this.a.p2());
            this.r = k38Var;
            this.w.add(k38Var);
            j38 j38Var = new j38(this.a.getPageContext(), ey4.e);
            this.p = j38Var;
            j38Var.x(this.b);
            this.w.add(this.p);
            i38 i38Var = new i38(this.a.getPageContext(), jw4.b);
            this.q = i38Var;
            i38Var.A(this.b);
            this.w.add(this.q);
            t38 t38Var = new t38(this.a.getPageContext());
            this.s = t38Var;
            t38Var.u(this.b);
            this.w.add(this.s);
            x38 x38Var = new x38(this.a.getPageContext());
            this.t = x38Var;
            x38Var.u(this.b);
            this.w.add(this.t);
            m38 m38Var = new m38(this.a.getPageContext(), b());
            this.u = m38Var;
            this.w.add(m38Var);
            b48 b48Var = new b48(this.a.getPageContext());
            this.v = b48Var;
            this.w.add(b48Var);
            this.b.addAdapters(this.w);
        }
    }
}
