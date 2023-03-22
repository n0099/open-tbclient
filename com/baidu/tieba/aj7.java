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
/* loaded from: classes3.dex */
public class aj7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public BdTypeRecyclerView b;
    public wj7 c;
    public pj7 d;
    public kj7 e;
    public mj7 f;
    public lj7 g;
    public nj7 h;
    public xj7 i;
    public oj7 j;
    public rj7 k;
    public tj7 l;
    public sj7 m;
    public vj7 n;
    public ij7 o;
    public gj7 p;
    public fj7 q;
    public hj7 r;
    public qj7 s;
    public uj7 t;
    public jj7 u;
    public yj7 v;
    public List<tm> w;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aj7 a;

        public a(aj7 aj7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aj7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aj7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.b.getCount() != 0 && (this.a.b.getItem(0) instanceof zj7)) {
                    this.a.b.removeItem(0);
                }
            }
        }
    }

    public aj7(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void e(ArrayList<gn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void f(boolean z) {
        yj7 yj7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (yj7Var = this.v) != null) {
            yj7Var.u(z);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (tm tmVar : this.w) {
                if (tmVar instanceof cj7) {
                    ((cj7) tmVar).h(str);
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
            wj7 wj7Var = new wj7(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.R1(), this.a.Q1());
            this.c = wj7Var;
            wj7Var.y(this.b);
            this.w.add(this.c);
            pj7 pj7Var = new pj7(this.a.getPageContext());
            this.d = pj7Var;
            pj7Var.x(this.b);
            this.w.add(this.d);
            kj7 kj7Var = new kj7(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.R1());
            this.e = kj7Var;
            kj7Var.z(this.b);
            this.w.add(this.e);
            mj7 mj7Var = new mj7(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.R1());
            this.f = mj7Var;
            mj7Var.y(this.b);
            this.w.add(this.f);
            lj7 lj7Var = new lj7(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.R1());
            this.g = lj7Var;
            lj7Var.y(this.b);
            this.w.add(this.g);
            nj7 nj7Var = new nj7(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.R1());
            this.h = nj7Var;
            nj7Var.y(this.b);
            this.w.add(this.h);
            xj7 xj7Var = new xj7(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.R1());
            this.i = xj7Var;
            xj7Var.B(this.b);
            this.w.add(this.i);
            oj7 oj7Var = new oj7(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.R1());
            this.j = oj7Var;
            oj7Var.y(this.b);
            if ("fashion".equals(this.a.Q1()) || "local".equals(this.a.Q1())) {
                this.w.add(this.j);
            }
            rj7 rj7Var = new rj7(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.R1());
            this.k = rj7Var;
            rj7Var.u(this.b);
            this.w.add(this.k);
            tj7 tj7Var = new tj7(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.R1());
            this.l = tj7Var;
            tj7Var.x(this.b);
            this.w.add(this.l);
            sj7 sj7Var = new sj7(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.R1());
            this.m = sj7Var;
            sj7Var.u(this.b);
            this.w.add(this.m);
            vj7 vj7Var = new vj7(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.R1());
            this.n = vj7Var;
            vj7Var.x(this.b);
            this.w.add(this.n);
            ij7 ij7Var = new ij7(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.R1());
            this.o = ij7Var;
            ij7Var.z(this.b);
            this.w.add(this.o);
            hj7 hj7Var = new hj7(this.a.getPageContext(), zf6.Q0, this.a.R1());
            this.r = hj7Var;
            this.w.add(hj7Var);
            gj7 gj7Var = new gj7(this.a.getPageContext(), bz4.e);
            this.p = gj7Var;
            gj7Var.x(this.b);
            this.w.add(this.p);
            fj7 fj7Var = new fj7(this.a.getPageContext(), gx4.b);
            this.q = fj7Var;
            fj7Var.A(this.b);
            this.w.add(this.q);
            qj7 qj7Var = new qj7(this.a.getPageContext());
            this.s = qj7Var;
            qj7Var.u(this.b);
            this.w.add(this.s);
            uj7 uj7Var = new uj7(this.a.getPageContext());
            this.t = uj7Var;
            uj7Var.u(this.b);
            this.w.add(this.t);
            jj7 jj7Var = new jj7(this.a.getPageContext(), b());
            this.u = jj7Var;
            this.w.add(jj7Var);
            yj7 yj7Var = new yj7(this.a.getPageContext());
            this.v = yj7Var;
            this.w.add(yj7Var);
            this.b.addAdapters(this.w);
        }
    }
}
