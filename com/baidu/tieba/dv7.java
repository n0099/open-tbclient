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
/* loaded from: classes5.dex */
public class dv7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zv7 A;
    public kv7 B;
    public wv7 C;
    public lv7 D;
    public xv7 E;
    public ConcernEmotionTipAdapter F;
    public hw7 G;
    public ArrayList<jn> H;
    public List<wn> I;
    public List<jn> a;
    public BdTypeRecyclerView b;
    public TbPageContext<?> c;
    public ConcernTipAdapter d;
    public ConcernEmotionTipAdapter e;
    public iv7 f;
    public cw7 g;
    public ArrayList<yv7> h;
    public ew7 i;
    public ew7 j;
    public qv7 k;
    public dw7 l;
    public sv7 m;
    public bw7 n;
    public pv7 o;
    public ov7 p;
    public nv7 q;
    public mv7 r;
    public fw7 s;
    public rv7 t;
    public tv7 u;
    public uv7 v;
    public aw7 w;
    public vv7 x;
    public gw7 y;
    public hv7 z;

    public dv7(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.h = new ArrayList<>();
        this.a = new ArrayList();
        this.b = bdTypeRecyclerView;
        this.c = (TbPageContext) q9.a(context);
        b(context);
        i(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.a);
    }

    public List<wn> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.I;
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
            for (int i = 0; i < to6.O.size(); i++) {
                for (int i2 = 0; i2 < to6.P.size(); i2++) {
                    this.h.add(new yv7(this.c, to6.Q[i][i2], to6.O.get(i), to6.P.get(i2)));
                }
            }
            this.i = new ew7(this.c, ThreadData.TYPE_VIDEO, to6.D);
            this.j = new ew7(this.c, ThreadData.TYPE_VIDEO_WITH_FORUM_HEADER, to6.E);
            this.k = new qv7(this.c, ThreadData.TYPE_FAKE_VIDEO, to6.D);
            this.l = new dw7(this.c, bp6.D0);
            this.m = new sv7(this.c, bp6.E0);
            this.t = new rv7(this.c, bp6.L0);
            this.u = new tv7(this.c, bp6.M0);
            this.n = new bw7(this.c, bp6.K0);
            this.o = new pv7(this.c, bp6.F0);
            this.p = new ov7(this.c, bp6.G0);
            this.q = new nv7(this.c, bp6.H0);
            this.s = new fw7(this.c, cp6.U);
            this.B = new kv7(this.c, wo6.R0);
            this.r = new mv7(this.c, bp6.I0);
            this.A = new zv7(this.c, d45.e);
            this.v = new uv7(this.c, bp6.N0);
            this.w = new aw7(this.c, bp6.O0);
            this.x = new vv7(this.c, bp6.P0);
            this.y = new gw7(this.c, ThreadData.TYPE_CONTENT_VOICE_ROOM);
            this.a.addAll(this.h);
            this.a.add(this.i);
            this.a.add(this.j);
            this.a.add(this.k);
            this.a.add(this.l);
            this.a.add(this.m);
            this.a.add(this.t);
            this.a.add(this.u);
            this.a.add(this.n);
            this.a.add(this.o);
            this.a.add(this.p);
            this.a.add(this.q);
            this.a.add(this.s);
            this.a.add(this.r);
            this.a.add(this.A);
            this.a.add(this.v);
            this.a.add(this.w);
            this.a.add(this.x);
            this.a.add(this.y);
            this.d = new ConcernTipAdapter(this.c.getContext());
            this.e = new ConcernEmotionTipAdapter(this.c);
            this.f = new iv7(this.c, ap6.R0);
            this.z = new hv7(this.c, lw7.b);
            this.g = new cw7(this.c, bp6.u0);
            this.C = new wv7(this.c, bp6.v0);
            this.D = new lv7(this.c, bp6.w0);
            this.E = new xv7(this.c, bp6.x0);
            this.F = new ConcernEmotionTipAdapter(this.c, mw7.f);
            this.G = new hw7(this.c, bp6.z0, (byte) 4);
            this.a.add(this.d);
            this.a.add(this.e);
            this.a.add(this.f);
            this.a.add(this.z);
            this.a.add(this.g);
            this.a.add(this.C);
            this.a.add(this.D);
            this.a.add(this.E);
            this.a.add(this.B);
            this.a.add(this.F);
            this.a.add(this.G);
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
            this.H = new ArrayList<>();
            jn<?, ?> g = bo9.l().g(this.c, AdvertAppInfo.y, "CONCERN");
            jn<?, ?> g2 = bo9.l().g(this.c, AdvertAppInfo.z, "CONCERN");
            jn<?, ?> g3 = bo9.l().g(this.c, AdvertAppInfo.A, "CONCERN");
            jn<?, ?> g4 = bo9.l().g(this.c, AdvertAppInfo.B, "CONCERN");
            jn<?, ?> g5 = bo9.l().g(this.c, AdvertAppInfo.C, "CONCERN");
            jn<?, ?> g6 = bo9.l().g(this.c, AdvertAppInfo.E, "CONCERN");
            jn<?, ?> g7 = bo9.l().g(this.c, AdvertAppInfo.D, "CONCERN");
            this.H.add(g);
            this.H.add(g2);
            this.H.add(g3);
            this.H.add(g4);
            this.H.add(g5);
            this.H.add(g6);
            this.H.add(g7);
            this.a.addAll(this.H);
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
            if (jnVar instanceof k56) {
                ((k56) jnVar).g(str);
            }
        }
    }

    public void j(List<wn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.I = list;
            this.b.setData(list);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || sp8.e(this.I)) {
            return;
        }
        Iterator<jn> it = this.H.iterator();
        while (it.hasNext()) {
            jn next = it.next();
            if (next instanceof rn9) {
                ((rn9) next).onDestroy();
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator<yv7> it = this.h.iterator();
            while (it.hasNext()) {
                it.next().a = bdUniqueId;
            }
            this.f.a = bdUniqueId;
            this.g.a = bdUniqueId;
            this.E.a = bdUniqueId;
            this.C.a = bdUniqueId;
            this.D.a = bdUniqueId;
            this.B.a = bdUniqueId;
            this.r.a = bdUniqueId;
            this.A.a = bdUniqueId;
            this.G.b = bdUniqueId;
            this.y.a = bdUniqueId;
            this.z.u(bdUniqueId);
        }
    }

    public final void i(co coVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, coVar) == null) {
            Iterator<yv7> it = this.h.iterator();
            while (it.hasNext()) {
                it.next().J(coVar);
            }
            this.i.E(coVar);
            this.j.E(coVar);
            this.k.z(coVar);
            this.l.z(coVar);
            this.m.A(coVar);
            this.t.z(coVar);
            this.u.z(coVar);
            this.n.z(coVar);
            this.A.x(coVar);
            this.v.u(coVar);
            this.w.x(coVar);
            this.x.u(coVar);
            this.y.z(coVar);
            this.o.z(coVar);
            this.p.z(coVar);
            this.q.z(coVar);
            this.s.C(coVar);
            this.r.A(coVar);
            this.B.A(coVar);
            this.D.z(coVar);
            this.C.A(coVar);
            this.E.A(coVar);
            this.G.u(coVar);
        }
    }
}
