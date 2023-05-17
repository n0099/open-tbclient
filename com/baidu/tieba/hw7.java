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
public class hw7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public BdTypeRecyclerView b;
    public dx7 c;
    public ww7 d;
    public rw7 e;
    public tw7 f;
    public sw7 g;
    public uw7 h;
    public ex7 i;
    public vw7 j;
    public yw7 k;
    public ax7 l;
    public zw7 m;
    public cx7 n;
    public pw7 o;
    public nw7 p;
    public mw7 q;
    public ow7 r;
    public xw7 s;
    public bx7 t;
    public qw7 u;
    public fx7 v;
    public List<en> w;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hw7 a;

        public a(hw7 hw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hw7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.b.getCount() != 0 && (this.a.b.getItem(0) instanceof gx7)) {
                    this.a.b.removeItem(0);
                }
            }
        }
    }

    public hw7(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void e(ArrayList<rn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void f(boolean z) {
        fx7 fx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (fx7Var = this.v) != null) {
            fx7Var.u(z);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (en enVar : this.w) {
                if (enVar instanceof jw7) {
                    ((jw7) enVar).h(str);
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
            dx7 dx7Var = new dx7(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.T1(), this.a.S1());
            this.c = dx7Var;
            dx7Var.y(this.b);
            this.w.add(this.c);
            ww7 ww7Var = new ww7(this.a.getPageContext());
            this.d = ww7Var;
            ww7Var.x(this.b);
            this.w.add(this.d);
            rw7 rw7Var = new rw7(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.T1());
            this.e = rw7Var;
            rw7Var.z(this.b);
            this.w.add(this.e);
            tw7 tw7Var = new tw7(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.T1());
            this.f = tw7Var;
            tw7Var.y(this.b);
            this.w.add(this.f);
            sw7 sw7Var = new sw7(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.T1());
            this.g = sw7Var;
            sw7Var.y(this.b);
            this.w.add(this.g);
            uw7 uw7Var = new uw7(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.T1());
            this.h = uw7Var;
            uw7Var.y(this.b);
            this.w.add(this.h);
            ex7 ex7Var = new ex7(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.T1());
            this.i = ex7Var;
            ex7Var.B(this.b);
            this.w.add(this.i);
            vw7 vw7Var = new vw7(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.T1());
            this.j = vw7Var;
            vw7Var.y(this.b);
            if ("fashion".equals(this.a.S1()) || "local".equals(this.a.S1())) {
                this.w.add(this.j);
            }
            yw7 yw7Var = new yw7(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.T1());
            this.k = yw7Var;
            yw7Var.u(this.b);
            this.w.add(this.k);
            ax7 ax7Var = new ax7(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.T1());
            this.l = ax7Var;
            ax7Var.x(this.b);
            this.w.add(this.l);
            zw7 zw7Var = new zw7(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.T1());
            this.m = zw7Var;
            zw7Var.u(this.b);
            this.w.add(this.m);
            cx7 cx7Var = new cx7(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.T1());
            this.n = cx7Var;
            cx7Var.x(this.b);
            this.w.add(this.n);
            pw7 pw7Var = new pw7(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.T1());
            this.o = pw7Var;
            pw7Var.z(this.b);
            this.w.add(this.o);
            ow7 ow7Var = new ow7(this.a.getPageContext(), jk6.Q0, this.a.T1());
            this.r = ow7Var;
            this.w.add(ow7Var);
            nw7 nw7Var = new nw7(this.a.getPageContext(), d15.e);
            this.p = nw7Var;
            nw7Var.x(this.b);
            this.w.add(this.p);
            mw7 mw7Var = new mw7(this.a.getPageContext(), iz4.b);
            this.q = mw7Var;
            mw7Var.A(this.b);
            this.w.add(this.q);
            xw7 xw7Var = new xw7(this.a.getPageContext());
            this.s = xw7Var;
            xw7Var.u(this.b);
            this.w.add(this.s);
            bx7 bx7Var = new bx7(this.a.getPageContext());
            this.t = bx7Var;
            bx7Var.u(this.b);
            this.w.add(this.t);
            qw7 qw7Var = new qw7(this.a.getPageContext(), b());
            this.u = qw7Var;
            this.w.add(qw7Var);
            fx7 fx7Var = new fx7(this.a.getPageContext());
            this.v = fx7Var;
            this.w.add(fx7Var);
            this.b.addAdapters(this.w);
        }
    }
}
