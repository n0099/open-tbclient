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
import com.google.android.gms.common.internal.ImagesContract;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class f57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public BdTypeRecyclerView b;
    public b67 c;
    public u57 d;
    public p57 e;
    public r57 f;
    public q57 g;
    public s57 h;
    public c67 i;
    public t57 j;
    public w57 k;
    public y57 l;
    public x57 m;
    public a67 n;
    public n57 o;
    public l57 p;
    public k57 q;
    public m57 r;
    public v57 s;
    public z57 t;
    public o57 u;
    public d67 v;
    public List<jn> w;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f57 a;

        public a(f57 f57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f57Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.b.getCount() != 0 && (this.a.b.B(0) instanceof e67)) {
                    this.a.b.D(0);
                }
            }
        }
    }

    public f57(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void e(ArrayList<wn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void f(boolean z) {
        d67 d67Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (d67Var = this.v) != null) {
            d67Var.u(z);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (jn jnVar : this.w) {
                if (jnVar instanceof h57) {
                    ((h57) jnVar).h(str);
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
            b67 b67Var = new b67(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.E1(), this.a.D1());
            this.c = b67Var;
            b67Var.w(this.b);
            this.w.add(this.c);
            u57 u57Var = new u57(this.a.getPageContext());
            this.d = u57Var;
            u57Var.v(this.b);
            this.w.add(this.d);
            p57 p57Var = new p57(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.E1());
            this.e = p57Var;
            p57Var.x(this.b);
            this.w.add(this.e);
            r57 r57Var = new r57(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.E1());
            this.f = r57Var;
            r57Var.w(this.b);
            this.w.add(this.f);
            q57 q57Var = new q57(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.E1());
            this.g = q57Var;
            q57Var.w(this.b);
            this.w.add(this.g);
            s57 s57Var = new s57(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.E1());
            this.h = s57Var;
            s57Var.w(this.b);
            this.w.add(this.h);
            c67 c67Var = new c67(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.E1());
            this.i = c67Var;
            c67Var.z(this.b);
            this.w.add(this.i);
            t57 t57Var = new t57(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.E1());
            this.j = t57Var;
            t57Var.w(this.b);
            if ("fashion".equals(this.a.D1()) || ImagesContract.LOCAL.equals(this.a.D1())) {
                this.w.add(this.j);
            }
            w57 w57Var = new w57(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.E1());
            this.k = w57Var;
            w57Var.u(this.b);
            this.w.add(this.k);
            y57 y57Var = new y57(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.E1());
            this.l = y57Var;
            y57Var.v(this.b);
            this.w.add(this.l);
            x57 x57Var = new x57(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.E1());
            this.m = x57Var;
            x57Var.u(this.b);
            this.w.add(this.m);
            a67 a67Var = new a67(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.E1());
            this.n = a67Var;
            a67Var.v(this.b);
            this.w.add(this.n);
            n57 n57Var = new n57(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.E1());
            this.o = n57Var;
            n57Var.x(this.b);
            this.w.add(this.o);
            m57 m57Var = new m57(this.a.getPageContext(), n46.N0, this.a.E1());
            this.r = m57Var;
            this.w.add(m57Var);
            l57 l57Var = new l57(this.a.getPageContext(), ku4.e);
            this.p = l57Var;
            l57Var.v(this.b);
            this.w.add(this.p);
            k57 k57Var = new k57(this.a.getPageContext(), ps4.b);
            this.q = k57Var;
            k57Var.y(this.b);
            this.w.add(this.q);
            v57 v57Var = new v57(this.a.getPageContext());
            this.s = v57Var;
            v57Var.u(this.b);
            this.w.add(this.s);
            z57 z57Var = new z57(this.a.getPageContext());
            this.t = z57Var;
            z57Var.u(this.b);
            this.w.add(this.t);
            o57 o57Var = new o57(this.a.getPageContext(), b());
            this.u = o57Var;
            this.w.add(o57Var);
            d67 d67Var = new d67(this.a.getPageContext());
            this.v = d67Var;
            this.w.add(d67Var);
            this.b.a(this.w);
        }
    }
}
