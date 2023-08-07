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
/* loaded from: classes6.dex */
public class i58 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public BdTypeRecyclerView b;
    public e68 c;
    public x58 d;
    public s58 e;
    public u58 f;
    public t58 g;
    public v58 h;
    public f68 i;
    public w58 j;
    public z58 k;
    public b68 l;
    public a68 m;
    public d68 n;
    public q58 o;
    public o58 p;
    public n58 q;
    public p58 r;
    public y58 s;
    public c68 t;
    public r58 u;
    public g68 v;
    public List<lm> w;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i58 a;

        public a(i58 i58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i58Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.b.getCount() != 0 && (this.a.b.getItem(0) instanceof h68)) {
                    this.a.b.removeItem(0);
                }
            }
        }
    }

    public i58(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void e(ArrayList<ym> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void f(boolean z) {
        g68 g68Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (g68Var = this.v) != null) {
            g68Var.u(z);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (lm lmVar : this.w) {
                if (lmVar instanceof k58) {
                    ((k58) lmVar).h(str);
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
            e68 e68Var = new e68(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.V1(), this.a.U1());
            this.c = e68Var;
            e68Var.y(this.b);
            this.w.add(this.c);
            x58 x58Var = new x58(this.a.getPageContext());
            this.d = x58Var;
            x58Var.x(this.b);
            this.w.add(this.d);
            s58 s58Var = new s58(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.V1());
            this.e = s58Var;
            s58Var.z(this.b);
            this.w.add(this.e);
            u58 u58Var = new u58(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.V1());
            this.f = u58Var;
            u58Var.y(this.b);
            this.w.add(this.f);
            t58 t58Var = new t58(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.V1());
            this.g = t58Var;
            t58Var.y(this.b);
            this.w.add(this.g);
            v58 v58Var = new v58(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.V1());
            this.h = v58Var;
            v58Var.y(this.b);
            this.w.add(this.h);
            f68 f68Var = new f68(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.V1());
            this.i = f68Var;
            f68Var.B(this.b);
            this.w.add(this.i);
            w58 w58Var = new w58(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.V1());
            this.j = w58Var;
            w58Var.y(this.b);
            if ("fashion".equals(this.a.U1()) || "local".equals(this.a.U1())) {
                this.w.add(this.j);
            }
            z58 z58Var = new z58(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.V1());
            this.k = z58Var;
            z58Var.u(this.b);
            this.w.add(this.k);
            b68 b68Var = new b68(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.V1());
            this.l = b68Var;
            b68Var.x(this.b);
            this.w.add(this.l);
            a68 a68Var = new a68(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.V1());
            this.m = a68Var;
            a68Var.u(this.b);
            this.w.add(this.m);
            d68 d68Var = new d68(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.V1());
            this.n = d68Var;
            d68Var.x(this.b);
            this.w.add(this.n);
            q58 q58Var = new q58(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.V1());
            this.o = q58Var;
            q58Var.z(this.b);
            this.w.add(this.o);
            p58 p58Var = new p58(this.a.getPageContext(), qn6.S0, this.a.V1());
            this.r = p58Var;
            this.w.add(p58Var);
            o58 o58Var = new o58(this.a.getPageContext(), l35.e);
            this.p = o58Var;
            o58Var.x(this.b);
            this.w.add(this.p);
            n58 n58Var = new n58(this.a.getPageContext(), q15.b);
            this.q = n58Var;
            n58Var.A(this.b);
            this.w.add(this.q);
            y58 y58Var = new y58(this.a.getPageContext());
            this.s = y58Var;
            y58Var.u(this.b);
            this.w.add(this.s);
            c68 c68Var = new c68(this.a.getPageContext());
            this.t = c68Var;
            c68Var.u(this.b);
            this.w.add(this.t);
            r58 r58Var = new r58(this.a.getPageContext(), b());
            this.u = r58Var;
            this.w.add(r58Var);
            g68 g68Var = new g68(this.a.getPageContext());
            this.v = g68Var;
            this.w.add(g68Var);
            this.b.addAdapters(this.w);
        }
    }
}
