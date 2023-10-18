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
public class bv7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xv7 A;
    public iv7 B;
    public uv7 C;
    public jv7 D;
    public vv7 E;
    public ConcernEmotionTipAdapter F;
    public fw7 G;
    public ArrayList<lh> H;
    public List<yh> I;
    public List<lh> a;
    public BdTypeRecyclerView b;
    public TbPageContext<?> c;
    public ConcernTipAdapter d;
    public ConcernEmotionTipAdapter e;
    public gv7 f;
    public aw7 g;
    public ArrayList<wv7> h;
    public cw7 i;
    public cw7 j;
    public ov7 k;
    public bw7 l;
    public qv7 m;
    public zv7 n;
    public nv7 o;
    public mv7 p;
    public lv7 q;
    public kv7 r;
    public dw7 s;
    public pv7 t;
    public rv7 u;
    public sv7 v;
    public yv7 w;
    public tv7 x;
    public ew7 y;
    public fv7 z;

    public bv7(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.c = (TbPageContext) k4.a(context);
        b(context);
        i(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.a);
    }

    public List<yh> a() {
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
            for (int i = 0; i < jk6.O.size(); i++) {
                for (int i2 = 0; i2 < jk6.P.size(); i2++) {
                    this.h.add(new wv7(this.c, jk6.Q[i][i2], jk6.O.get(i), jk6.P.get(i2)));
                }
            }
            this.i = new cw7(this.c, ThreadData.TYPE_VIDEO, jk6.D);
            this.j = new cw7(this.c, ThreadData.TYPE_VIDEO_WITH_FORUM_HEADER, jk6.E);
            this.k = new ov7(this.c, ThreadData.TYPE_FAKE_VIDEO, jk6.D);
            this.l = new bw7(this.c, rk6.E0);
            this.m = new qv7(this.c, rk6.F0);
            this.t = new pv7(this.c, rk6.M0);
            this.u = new rv7(this.c, rk6.N0);
            this.n = new zv7(this.c, rk6.L0);
            this.o = new nv7(this.c, rk6.G0);
            this.p = new mv7(this.c, rk6.H0);
            this.q = new lv7(this.c, rk6.I0);
            this.s = new dw7(this.c, sk6.U);
            this.B = new iv7(this.c, mk6.S0);
            this.r = new kv7(this.c, rk6.J0);
            this.A = new xv7(this.c, ey4.e);
            this.v = new sv7(this.c, rk6.O0);
            this.w = new yv7(this.c, rk6.P0);
            this.x = new tv7(this.c, rk6.Q0);
            this.y = new ew7(this.c, ThreadData.TYPE_CONTENT_VOICE_ROOM);
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
            this.f = new gv7(this.c, qk6.S0);
            this.z = new fv7(this.c, lw7.b);
            this.g = new aw7(this.c, rk6.u0);
            this.C = new uv7(this.c, rk6.v0);
            this.D = new jv7(this.c, rk6.w0);
            this.E = new vv7(this.c, rk6.x0);
            this.F = new ConcernEmotionTipAdapter(this.c, mw7.f);
            this.G = new fw7(this.c, rk6.z0, (byte) 4);
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
                AdvertAppInfo.w.set(false);
                return;
            }
            this.H = new ArrayList<>();
            lh<?, ?> h = tz9.m().h(this.c, AdvertAppInfo.z, "CONCERN");
            lh<?, ?> h2 = tz9.m().h(this.c, AdvertAppInfo.A, "CONCERN");
            lh<?, ?> h3 = tz9.m().h(this.c, AdvertAppInfo.B, "CONCERN");
            lh<?, ?> h4 = tz9.m().h(this.c, AdvertAppInfo.C, "CONCERN");
            lh<?, ?> h5 = tz9.m().h(this.c, AdvertAppInfo.D, "CONCERN");
            lh<?, ?> h6 = tz9.m().h(this.c, AdvertAppInfo.F, "CONCERN");
            lh<?, ?> h7 = tz9.m().h(this.c, AdvertAppInfo.E, "CONCERN");
            this.H.add(h);
            this.H.add(h2);
            this.H.add(h3);
            this.H.add(h4);
            this.H.add(h5);
            this.H.add(h6);
            this.H.add(h7);
            this.a.addAll(this.H);
            AdvertAppInfo.w.set(true);
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            d();
        }
    }

    public final void g(String str) {
        List<lh> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || (list = this.a) == null) {
            return;
        }
        for (lh lhVar : list) {
            if (lhVar instanceof yz5) {
                ((yz5) lhVar).g(str);
            }
        }
    }

    public void j(List<yh> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.I = list;
            this.b.setData(list);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || ez8.e(this.I)) {
            return;
        }
        Iterator<lh> it = this.H.iterator();
        while (it.hasNext()) {
            lh next = it.next();
            if (next instanceof jz9) {
                ((jz9) next).onDestroy();
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator<wv7> it = this.h.iterator();
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

    public final void i(ei eiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eiVar) == null) {
            Iterator<wv7> it = this.h.iterator();
            while (it.hasNext()) {
                it.next().J(eiVar);
            }
            this.i.E(eiVar);
            this.j.E(eiVar);
            this.k.z(eiVar);
            this.l.z(eiVar);
            this.m.A(eiVar);
            this.t.z(eiVar);
            this.u.z(eiVar);
            this.n.z(eiVar);
            this.A.x(eiVar);
            this.v.u(eiVar);
            this.w.x(eiVar);
            this.x.u(eiVar);
            this.y.z(eiVar);
            this.o.z(eiVar);
            this.p.z(eiVar);
            this.q.z(eiVar);
            this.s.C(eiVar);
            this.r.A(eiVar);
            this.B.A(eiVar);
            this.D.z(eiVar);
            this.C.A(eiVar);
            this.E.A(eiVar);
            this.G.u(eiVar);
        }
    }
}
