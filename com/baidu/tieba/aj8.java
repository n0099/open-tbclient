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
public class aj8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public BdTypeRecyclerView b;
    public wj8 c;
    public pj8 d;
    public kj8 e;
    public mj8 f;
    public lj8 g;
    public nj8 h;
    public xj8 i;
    public oj8 j;
    public rj8 k;
    public tj8 l;
    public sj8 m;
    public vj8 n;
    public ij8 o;
    public gj8 p;
    public fj8 q;
    public hj8 r;
    public qj8 s;
    public uj8 t;
    public jj8 u;
    public yj8 v;
    public List<ci> w;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aj8 a;

        public a(aj8 aj8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aj8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aj8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.b.getCount() != 0 && (this.a.b.getItem(0) instanceof zj8)) {
                    this.a.b.removeItem(0);
                }
            }
        }
    }

    public aj8(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void e(ArrayList<pi> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void f(boolean z) {
        yj8 yj8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (yj8Var = this.v) != null) {
            yj8Var.x(z);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (ci ciVar : this.w) {
                if (ciVar instanceof cj8) {
                    ((cj8) ciVar).h(str);
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
            wj8 wj8Var = new wj8(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.T2(), this.a.S2());
            this.c = wj8Var;
            wj8Var.z(this.b);
            this.w.add(this.c);
            pj8 pj8Var = new pj8(this.a.getPageContext());
            this.d = pj8Var;
            pj8Var.y(this.b);
            this.w.add(this.d);
            kj8 kj8Var = new kj8(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.T2());
            this.e = kj8Var;
            kj8Var.A(this.b);
            this.w.add(this.e);
            mj8 mj8Var = new mj8(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.T2());
            this.f = mj8Var;
            mj8Var.z(this.b);
            this.w.add(this.f);
            lj8 lj8Var = new lj8(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.T2());
            this.g = lj8Var;
            lj8Var.z(this.b);
            this.w.add(this.g);
            nj8 nj8Var = new nj8(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.T2());
            this.h = nj8Var;
            nj8Var.z(this.b);
            this.w.add(this.h);
            xj8 xj8Var = new xj8(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.T2());
            this.i = xj8Var;
            xj8Var.C(this.b);
            this.w.add(this.i);
            oj8 oj8Var = new oj8(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.T2());
            this.j = oj8Var;
            oj8Var.z(this.b);
            if ("fashion".equals(this.a.S2()) || "local".equals(this.a.S2())) {
                this.w.add(this.j);
            }
            rj8 rj8Var = new rj8(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.T2());
            this.k = rj8Var;
            rj8Var.x(this.b);
            this.w.add(this.k);
            tj8 tj8Var = new tj8(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.T2());
            this.l = tj8Var;
            tj8Var.y(this.b);
            this.w.add(this.l);
            sj8 sj8Var = new sj8(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.T2());
            this.m = sj8Var;
            sj8Var.x(this.b);
            this.w.add(this.m);
            vj8 vj8Var = new vj8(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.T2());
            this.n = vj8Var;
            vj8Var.y(this.b);
            this.w.add(this.n);
            ij8 ij8Var = new ij8(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.T2());
            this.o = ij8Var;
            ij8Var.A(this.b);
            this.w.add(this.o);
            hj8 hj8Var = new hj8(this.a.getPageContext(), cn6.S0, this.a.T2());
            this.r = hj8Var;
            this.w.add(hj8Var);
            gj8 gj8Var = new gj8(this.a.getPageContext(), bz4.e);
            this.p = gj8Var;
            gj8Var.y(this.b);
            this.w.add(this.p);
            fj8 fj8Var = new fj8(this.a.getPageContext(), gx4.b);
            this.q = fj8Var;
            fj8Var.B(this.b);
            this.w.add(this.q);
            qj8 qj8Var = new qj8(this.a.getPageContext());
            this.s = qj8Var;
            qj8Var.x(this.b);
            this.w.add(this.s);
            uj8 uj8Var = new uj8(this.a.getPageContext());
            this.t = uj8Var;
            uj8Var.x(this.b);
            this.w.add(this.t);
            jj8 jj8Var = new jj8(this.a.getPageContext(), b());
            this.u = jj8Var;
            this.w.add(jj8Var);
            yj8 yj8Var = new yj8(this.a.getPageContext());
            this.v = yj8Var;
            this.w.add(yj8Var);
            this.b.addAdapters(this.w);
        }
    }
}
