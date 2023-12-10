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
public class bj8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public BdTypeRecyclerView b;
    public xj8 c;
    public qj8 d;
    public lj8 e;
    public nj8 f;
    public mj8 g;
    public oj8 h;
    public yj8 i;
    public pj8 j;
    public sj8 k;
    public uj8 l;
    public tj8 m;
    public wj8 n;
    public jj8 o;
    public hj8 p;
    public gj8 q;
    public ij8 r;
    public rj8 s;
    public vj8 t;
    public kj8 u;
    public zj8 v;
    public List<ci> w;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bj8 a;

        public a(bj8 bj8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bj8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bj8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.b.getCount() != 0 && (this.a.b.getItem(0) instanceof ak8)) {
                    this.a.b.removeItem(0);
                }
            }
        }
    }

    public bj8(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        zj8 zj8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (zj8Var = this.v) != null) {
            zj8Var.x(z);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (ci ciVar : this.w) {
                if (ciVar instanceof dj8) {
                    ((dj8) ciVar).h(str);
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
            xj8 xj8Var = new xj8(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.T2(), this.a.S2());
            this.c = xj8Var;
            xj8Var.z(this.b);
            this.w.add(this.c);
            qj8 qj8Var = new qj8(this.a.getPageContext());
            this.d = qj8Var;
            qj8Var.y(this.b);
            this.w.add(this.d);
            lj8 lj8Var = new lj8(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.T2());
            this.e = lj8Var;
            lj8Var.A(this.b);
            this.w.add(this.e);
            nj8 nj8Var = new nj8(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.T2());
            this.f = nj8Var;
            nj8Var.z(this.b);
            this.w.add(this.f);
            mj8 mj8Var = new mj8(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.T2());
            this.g = mj8Var;
            mj8Var.z(this.b);
            this.w.add(this.g);
            oj8 oj8Var = new oj8(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.T2());
            this.h = oj8Var;
            oj8Var.z(this.b);
            this.w.add(this.h);
            yj8 yj8Var = new yj8(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.T2());
            this.i = yj8Var;
            yj8Var.C(this.b);
            this.w.add(this.i);
            pj8 pj8Var = new pj8(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.T2());
            this.j = pj8Var;
            pj8Var.z(this.b);
            if ("fashion".equals(this.a.S2()) || "local".equals(this.a.S2())) {
                this.w.add(this.j);
            }
            sj8 sj8Var = new sj8(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.T2());
            this.k = sj8Var;
            sj8Var.x(this.b);
            this.w.add(this.k);
            uj8 uj8Var = new uj8(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.T2());
            this.l = uj8Var;
            uj8Var.y(this.b);
            this.w.add(this.l);
            tj8 tj8Var = new tj8(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.T2());
            this.m = tj8Var;
            tj8Var.x(this.b);
            this.w.add(this.m);
            wj8 wj8Var = new wj8(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.T2());
            this.n = wj8Var;
            wj8Var.y(this.b);
            this.w.add(this.n);
            jj8 jj8Var = new jj8(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.T2());
            this.o = jj8Var;
            jj8Var.A(this.b);
            this.w.add(this.o);
            ij8 ij8Var = new ij8(this.a.getPageContext(), cn6.S0, this.a.T2());
            this.r = ij8Var;
            this.w.add(ij8Var);
            hj8 hj8Var = new hj8(this.a.getPageContext(), bz4.e);
            this.p = hj8Var;
            hj8Var.y(this.b);
            this.w.add(this.p);
            gj8 gj8Var = new gj8(this.a.getPageContext(), gx4.b);
            this.q = gj8Var;
            gj8Var.B(this.b);
            this.w.add(this.q);
            rj8 rj8Var = new rj8(this.a.getPageContext());
            this.s = rj8Var;
            rj8Var.x(this.b);
            this.w.add(this.s);
            vj8 vj8Var = new vj8(this.a.getPageContext());
            this.t = vj8Var;
            vj8Var.x(this.b);
            this.w.add(this.t);
            kj8 kj8Var = new kj8(this.a.getPageContext(), b());
            this.u = kj8Var;
            this.w.add(kj8Var);
            zj8 zj8Var = new zj8(this.a.getPageContext());
            this.v = zj8Var;
            this.w.add(zj8Var);
            this.b.addAdapters(this.w);
        }
    }
}
