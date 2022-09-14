package com.baidu.tieba;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.homepage.concern.adapter.ConcernEmotionTipAdapter;
import com.baidu.tieba.homepage.concern.adapter.ConcernTipAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class cw6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hw6 A;
    public zw6 B;
    public kw6 C;
    public ww6 D;
    public lw6 E;
    public xw6 F;
    public ConcernEmotionTipAdapter G;
    public hx6 H;
    public ArrayList<qn> I;
    public List<Cdo> J;
    public List<qn> a;
    public BdTypeRecyclerView b;
    public TbPageContext<?> c;
    public ConcernTipAdapter d;
    public ConcernEmotionTipAdapter e;
    public iw6 f;
    public gw6 g;
    public cx6 h;
    public ArrayList<yw6> i;
    public ex6 j;
    public ex6 k;
    public qw6 l;
    public dx6 m;
    public sw6 n;
    public bx6 o;
    public pw6 p;
    public ow6 q;
    public nw6 r;
    public mw6 s;
    public fx6 t;
    public rw6 u;
    public tw6 v;
    public uw6 w;
    public ax6 x;
    public vw6 y;
    public gx6 z;

    public cw6(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new ArrayList<>();
        this.a = new ArrayList();
        this.b = bdTypeRecyclerView;
        this.c = (TbPageContext) w9.a(context);
        b(context);
        i(bdTypeRecyclerView);
        bdTypeRecyclerView.a(this.a);
    }

    public List<Cdo> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.J : (List) invokeV.objValue;
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            for (int i = 0; i < c26.O.size(); i++) {
                for (int i2 = 0; i2 < c26.P.size(); i2++) {
                    this.i.add(new yw6(this.c, c26.Q[i][i2], c26.O.get(i), c26.P.get(i2)));
                }
            }
            this.j = new ex6(this.c, ThreadData.TYPE_VIDEO, c26.D);
            this.k = new ex6(this.c, ThreadData.TYPE_VIDEO_WITH_FORUM_HEADER, c26.E);
            this.l = new qw6(this.c, ThreadData.TYPE_FAKE_VIDEO, c26.D);
            this.m = new dx6(this.c, k26.z0);
            this.n = new sw6(this.c, k26.A0);
            this.u = new rw6(this.c, k26.H0);
            this.v = new tw6(this.c, k26.I0);
            this.o = new bx6(this.c, k26.G0);
            this.p = new pw6(this.c, k26.B0);
            this.q = new ow6(this.c, k26.C0);
            this.r = new nw6(this.c, k26.D0);
            this.t = new fx6(this.c, l26.U);
            this.C = new kw6(this.c, f26.N0);
            this.s = new mw6(this.c, k26.E0);
            this.B = new zw6(this.c, ft4.e);
            this.w = new uw6(this.c, k26.J0);
            this.x = new ax6(this.c, k26.K0);
            this.y = new vw6(this.c, k26.L0);
            this.z = new gx6(this.c, ThreadData.TYPE_CONTENT_VOICE_ROOM);
            this.a.addAll(this.i);
            this.a.add(this.j);
            this.a.add(this.k);
            this.a.add(this.l);
            this.a.add(this.m);
            this.a.add(this.n);
            this.a.add(this.u);
            this.a.add(this.v);
            this.a.add(this.o);
            this.a.add(this.p);
            this.a.add(this.q);
            this.a.add(this.r);
            this.a.add(this.t);
            this.a.add(this.s);
            this.a.add(this.B);
            this.a.add(this.w);
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.d = new ConcernTipAdapter(this.c.getContext());
            this.e = new ConcernEmotionTipAdapter(this.c.getContext());
            this.f = new iw6(this.c, j26.N0);
            this.A = new hw6(this.c, jx6.b);
            this.g = new gw6(this.c, j26.O0);
            this.h = new cx6(this.c, k26.r0);
            this.D = new ww6(this.c, k26.s0);
            this.E = new lw6(this.c, k26.t0);
            this.F = new xw6(this.c, k26.u0);
            this.G = new ConcernEmotionTipAdapter(this.c.getContext(), kx6.f);
            this.H = new hx6(this.c, k26.x0, (byte) 4);
            this.a.add(this.d);
            this.a.add(this.e);
            this.a.add(this.f);
            this.a.add(this.A);
            this.a.add(this.g);
            this.a.add(this.h);
            this.a.add(this.D);
            this.a.add(this.E);
            this.a.add(this.F);
            this.a.add(this.C);
            this.a.add(this.G);
            this.a.add(this.H);
            g("page_concern");
            c();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!ThreadData.isRecAppLoaded.get()) {
                AdvertAppInfo.v.set(false);
                return;
            }
            this.I = new ArrayList<>();
            qn<?, ?> g = md8.l().g(this.c, AdvertAppInfo.y, "CONCERN");
            qn<?, ?> g2 = md8.l().g(this.c, AdvertAppInfo.z, "CONCERN");
            qn<?, ?> g3 = md8.l().g(this.c, AdvertAppInfo.A, "CONCERN");
            qn<?, ?> g4 = md8.l().g(this.c, AdvertAppInfo.B, "CONCERN");
            qn<?, ?> g5 = md8.l().g(this.c, AdvertAppInfo.C, "CONCERN");
            qn<?, ?> g6 = md8.l().g(this.c, AdvertAppInfo.E, "CONCERN");
            qn<?, ?> g7 = md8.l().g(this.c, AdvertAppInfo.D, "CONCERN");
            this.I.add(g);
            this.I.add(g2);
            this.I.add(g3);
            this.I.add(g4);
            this.I.add(g5);
            this.I.add(g6);
            this.I.add(g7);
            this.a.addAll(this.I);
            AdvertAppInfo.v.set(true);
        }
    }

    public void d() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bdTypeRecyclerView = this.b) == null) {
            return;
        }
        bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            d();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || mg7.e(this.J)) {
            return;
        }
        Iterator<qn> it = this.I.iterator();
        while (it.hasNext()) {
            qn next = it.next();
            if (next instanceof dd8) {
                ((dd8) next).onDestroy();
            }
        }
    }

    public final void g(String str) {
        List<qn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (list = this.a) == null) {
            return;
        }
        for (qn qnVar : list) {
            if (qnVar instanceof go5) {
                ((go5) qnVar).g(str);
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator<yw6> it = this.i.iterator();
            while (it.hasNext()) {
                it.next().a = bdUniqueId;
            }
            this.f.a = bdUniqueId;
            this.g.a = bdUniqueId;
            this.h.a = bdUniqueId;
            this.F.a = bdUniqueId;
            this.D.a = bdUniqueId;
            this.E.a = bdUniqueId;
            this.C.a = bdUniqueId;
            this.s.a = bdUniqueId;
            this.B.a = bdUniqueId;
            this.H.b = bdUniqueId;
            this.z.a = bdUniqueId;
            this.A.u(bdUniqueId);
        }
    }

    public final void i(jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, joVar) == null) {
            Iterator<yw6> it = this.i.iterator();
            while (it.hasNext()) {
                it.next().H(joVar);
            }
            this.j.C(joVar);
            this.k.C(joVar);
            this.l.x(joVar);
            this.m.x(joVar);
            this.n.y(joVar);
            this.u.x(joVar);
            this.v.x(joVar);
            this.o.x(joVar);
            this.B.v(joVar);
            this.w.u(joVar);
            this.x.v(joVar);
            this.y.u(joVar);
            this.z.x(joVar);
            this.p.x(joVar);
            this.q.x(joVar);
            this.r.x(joVar);
            this.t.A(joVar);
            this.s.y(joVar);
            this.C.y(joVar);
            this.E.x(joVar);
            this.D.y(joVar);
            this.F.y(joVar);
            this.H.u(joVar);
        }
    }

    public void j(List<Cdo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.J = list;
            this.b.setData(list);
        }
    }
}
