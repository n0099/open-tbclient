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
/* loaded from: classes4.dex */
public class gy6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ly6 A;
    public dz6 B;
    public oy6 C;
    public az6 D;
    public py6 E;
    public bz6 F;
    public ConcernEmotionTipAdapter G;
    public lz6 H;
    public ArrayList<jn> I;
    public List<wn> J;
    public List<jn> a;
    public BdTypeRecyclerView b;
    public TbPageContext<?> c;
    public ConcernTipAdapter d;
    public ConcernEmotionTipAdapter e;
    public my6 f;
    public ky6 g;
    public gz6 h;
    public ArrayList<cz6> i;
    public iz6 j;
    public iz6 k;
    public uy6 l;
    public hz6 m;
    public wy6 n;
    public fz6 o;
    public ty6 p;
    public sy6 q;
    public ry6 r;
    public qy6 s;
    public jz6 t;
    public vy6 u;
    public xy6 v;
    public yy6 w;
    public ez6 x;
    public zy6 y;
    public kz6 z;

    public gy6(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public List<wn> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.J;
        }
        return (List) invokeV.objValue;
    }

    public void d() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (bdTypeRecyclerView = this.b) != null) {
            bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            for (int i = 0; i < g46.O.size(); i++) {
                for (int i2 = 0; i2 < g46.P.size(); i2++) {
                    this.i.add(new cz6(this.c, g46.Q[i][i2], g46.O.get(i), g46.P.get(i2)));
                }
            }
            this.j = new iz6(this.c, ThreadData.TYPE_VIDEO, g46.D);
            this.k = new iz6(this.c, ThreadData.TYPE_VIDEO_WITH_FORUM_HEADER, g46.E);
            this.l = new uy6(this.c, ThreadData.TYPE_FAKE_VIDEO, g46.D);
            this.m = new hz6(this.c, o46.z0);
            this.n = new wy6(this.c, o46.A0);
            this.u = new vy6(this.c, o46.H0);
            this.v = new xy6(this.c, o46.I0);
            this.o = new fz6(this.c, o46.G0);
            this.p = new ty6(this.c, o46.B0);
            this.q = new sy6(this.c, o46.C0);
            this.r = new ry6(this.c, o46.D0);
            this.t = new jz6(this.c, p46.U);
            this.C = new oy6(this.c, j46.N0);
            this.s = new qy6(this.c, o46.E0);
            this.B = new dz6(this.c, ku4.e);
            this.w = new yy6(this.c, o46.J0);
            this.x = new ez6(this.c, o46.K0);
            this.y = new zy6(this.c, o46.L0);
            this.z = new kz6(this.c, ThreadData.TYPE_CONTENT_VOICE_ROOM);
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
            this.f = new my6(this.c, n46.N0);
            this.A = new ly6(this.c, nz6.b);
            this.g = new ky6(this.c, n46.O0);
            this.h = new gz6(this.c, o46.r0);
            this.D = new az6(this.c, o46.s0);
            this.E = new py6(this.c, o46.t0);
            this.F = new bz6(this.c, o46.u0);
            this.G = new ConcernEmotionTipAdapter(this.c.getContext(), oz6.f);
            this.H = new lz6(this.c, o46.x0, (byte) 4);
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
            jn<?, ?> g = vf8.l().g(this.c, AdvertAppInfo.y, "CONCERN");
            jn<?, ?> g2 = vf8.l().g(this.c, AdvertAppInfo.z, "CONCERN");
            jn<?, ?> g3 = vf8.l().g(this.c, AdvertAppInfo.A, "CONCERN");
            jn<?, ?> g4 = vf8.l().g(this.c, AdvertAppInfo.B, "CONCERN");
            jn<?, ?> g5 = vf8.l().g(this.c, AdvertAppInfo.C, "CONCERN");
            jn<?, ?> g6 = vf8.l().g(this.c, AdvertAppInfo.E, "CONCERN");
            jn<?, ?> g7 = vf8.l().g(this.c, AdvertAppInfo.D, "CONCERN");
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

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            d();
        }
    }

    public final void g(String str) {
        List<jn> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || (list = this.a) == null) {
            return;
        }
        for (jn jnVar : list) {
            if (jnVar instanceof zp5) {
                ((zp5) jnVar).g(str);
            }
        }
    }

    public void j(List<wn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.J = list;
            this.b.setData(list);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || vi7.e(this.J)) {
            return;
        }
        Iterator<jn> it = this.I.iterator();
        while (it.hasNext()) {
            jn next = it.next();
            if (next instanceof mf8) {
                ((mf8) next).onDestroy();
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator<cz6> it = this.i.iterator();
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

    public final void i(co coVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, coVar) == null) {
            Iterator<cz6> it = this.i.iterator();
            while (it.hasNext()) {
                it.next().H(coVar);
            }
            this.j.C(coVar);
            this.k.C(coVar);
            this.l.x(coVar);
            this.m.x(coVar);
            this.n.y(coVar);
            this.u.x(coVar);
            this.v.x(coVar);
            this.o.x(coVar);
            this.B.v(coVar);
            this.w.u(coVar);
            this.x.v(coVar);
            this.y.u(coVar);
            this.z.x(coVar);
            this.p.x(coVar);
            this.q.x(coVar);
            this.r.x(coVar);
            this.t.A(coVar);
            this.s.y(coVar);
            this.C.y(coVar);
            this.E.x(coVar);
            this.D.y(coVar);
            this.F.y(coVar);
            this.H.u(coVar);
        }
    }
}
