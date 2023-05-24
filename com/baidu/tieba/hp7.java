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
public class hp7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mp7 A;
    public eq7 B;
    public pp7 C;
    public bq7 D;
    public qp7 E;
    public cq7 F;
    public ConcernEmotionTipAdapter G;
    public mq7 H;
    public ArrayList<en> I;
    public List<rn> J;
    public List<en> a;
    public BdTypeRecyclerView b;
    public TbPageContext<?> c;
    public ConcernTipAdapter d;
    public ConcernEmotionTipAdapter e;
    public np7 f;
    public lp7 g;
    public hq7 h;
    public ArrayList<dq7> i;
    public jq7 j;
    public jq7 k;
    public vp7 l;
    public iq7 m;
    public xp7 n;
    public gq7 o;
    public up7 p;
    public tp7 q;
    public sp7 r;
    public rp7 s;
    public kq7 t;
    public wp7 u;
    public yp7 v;
    public zp7 w;
    public fq7 x;
    public aq7 y;
    public lq7 z;

    public hp7(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.c = (TbPageContext) m9.a(context);
        b(context);
        i(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.a);
    }

    public List<rn> a() {
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
            for (int i = 0; i < dk6.O.size(); i++) {
                for (int i2 = 0; i2 < dk6.P.size(); i2++) {
                    this.i.add(new dq7(this.c, dk6.Q[i][i2], dk6.O.get(i), dk6.P.get(i2)));
                }
            }
            this.j = new jq7(this.c, ThreadData.TYPE_VIDEO, dk6.D);
            this.k = new jq7(this.c, ThreadData.TYPE_VIDEO_WITH_FORUM_HEADER, dk6.E);
            this.l = new vp7(this.c, ThreadData.TYPE_FAKE_VIDEO, dk6.D);
            this.m = new iq7(this.c, lk6.C0);
            this.n = new xp7(this.c, lk6.D0);
            this.u = new wp7(this.c, lk6.K0);
            this.v = new yp7(this.c, lk6.L0);
            this.o = new gq7(this.c, lk6.J0);
            this.p = new up7(this.c, lk6.E0);
            this.q = new tp7(this.c, lk6.F0);
            this.r = new sp7(this.c, lk6.G0);
            this.t = new kq7(this.c, mk6.U);
            this.C = new pp7(this.c, gk6.Q0);
            this.s = new rp7(this.c, lk6.H0);
            this.B = new eq7(this.c, d15.e);
            this.w = new zp7(this.c, lk6.M0);
            this.x = new fq7(this.c, lk6.N0);
            this.y = new aq7(this.c, lk6.O0);
            this.z = new lq7(this.c, ThreadData.TYPE_CONTENT_VOICE_ROOM);
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
            this.e = new ConcernEmotionTipAdapter(this.c);
            this.f = new np7(this.c, kk6.Q0);
            this.A = new mp7(this.c, pq7.b);
            this.g = new lp7(this.c, kk6.R0);
            this.h = new hq7(this.c, lk6.t0);
            this.D = new bq7(this.c, lk6.u0);
            this.E = new qp7(this.c, lk6.v0);
            this.F = new cq7(this.c, lk6.w0);
            this.G = new ConcernEmotionTipAdapter(this.c, qq7.f);
            this.H = new mq7(this.c, lk6.z0, (byte) 4);
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
            en<?, ?> g = xf9.l().g(this.c, AdvertAppInfo.y, "CONCERN");
            en<?, ?> g2 = xf9.l().g(this.c, AdvertAppInfo.z, "CONCERN");
            en<?, ?> g3 = xf9.l().g(this.c, AdvertAppInfo.A, "CONCERN");
            en<?, ?> g4 = xf9.l().g(this.c, AdvertAppInfo.B, "CONCERN");
            en<?, ?> g5 = xf9.l().g(this.c, AdvertAppInfo.C, "CONCERN");
            en<?, ?> g6 = xf9.l().g(this.c, AdvertAppInfo.E, "CONCERN");
            en<?, ?> g7 = xf9.l().g(this.c, AdvertAppInfo.D, "CONCERN");
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
        List<en> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || (list = this.a) == null) {
            return;
        }
        for (en enVar : list) {
            if (enVar instanceof c16) {
                ((c16) enVar).g(str);
            }
        }
    }

    public void j(List<rn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.J = list;
            this.b.setData(list);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || yi8.e(this.J)) {
            return;
        }
        Iterator<en> it = this.I.iterator();
        while (it.hasNext()) {
            en next = it.next();
            if (next instanceof nf9) {
                ((nf9) next).onDestroy();
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator<dq7> it = this.i.iterator();
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

    public final void i(xn xnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, xnVar) == null) {
            Iterator<dq7> it = this.i.iterator();
            while (it.hasNext()) {
                it.next().J(xnVar);
            }
            this.j.E(xnVar);
            this.k.E(xnVar);
            this.l.z(xnVar);
            this.m.z(xnVar);
            this.n.A(xnVar);
            this.u.z(xnVar);
            this.v.z(xnVar);
            this.o.z(xnVar);
            this.B.x(xnVar);
            this.w.u(xnVar);
            this.x.x(xnVar);
            this.y.u(xnVar);
            this.z.z(xnVar);
            this.p.z(xnVar);
            this.q.z(xnVar);
            this.r.z(xnVar);
            this.t.C(xnVar);
            this.s.A(xnVar);
            this.C.A(xnVar);
            this.E.z(xnVar);
            this.D.A(xnVar);
            this.F.A(xnVar);
            this.H.u(xnVar);
        }
    }
}
