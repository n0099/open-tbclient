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
public class ac7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fc7 A;
    public xc7 B;
    public ic7 C;
    public uc7 D;
    public jc7 E;
    public vc7 F;
    public ConcernEmotionTipAdapter G;
    public fd7 H;
    public ArrayList<tm> I;
    public List<gn> J;
    public List<tm> a;
    public BdTypeRecyclerView b;
    public TbPageContext<?> c;
    public ConcernTipAdapter d;
    public ConcernEmotionTipAdapter e;
    public gc7 f;
    public ec7 g;
    public ad7 h;
    public ArrayList<wc7> i;
    public cd7 j;
    public cd7 k;
    public oc7 l;
    public bd7 m;
    public qc7 n;
    public zc7 o;
    public nc7 p;
    public mc7 q;
    public lc7 r;
    public kc7 s;
    public dd7 t;
    public pc7 u;
    public rc7 v;
    public sc7 w;
    public yc7 x;
    public tc7 y;
    public ed7 z;

    public ac7(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.c = (TbPageContext) g9.a(context);
        b(context);
        i(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.a);
    }

    public List<gn> a() {
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
            for (int i = 0; i < sf6.O.size(); i++) {
                for (int i2 = 0; i2 < sf6.P.size(); i2++) {
                    this.i.add(new wc7(this.c, sf6.Q[i][i2], sf6.O.get(i), sf6.P.get(i2)));
                }
            }
            this.j = new cd7(this.c, ThreadData.TYPE_VIDEO, sf6.D);
            this.k = new cd7(this.c, ThreadData.TYPE_VIDEO_WITH_FORUM_HEADER, sf6.E);
            this.l = new oc7(this.c, ThreadData.TYPE_FAKE_VIDEO, sf6.D);
            this.m = new bd7(this.c, ag6.C0);
            this.n = new qc7(this.c, ag6.D0);
            this.u = new pc7(this.c, ag6.K0);
            this.v = new rc7(this.c, ag6.L0);
            this.o = new zc7(this.c, ag6.J0);
            this.p = new nc7(this.c, ag6.E0);
            this.q = new mc7(this.c, ag6.F0);
            this.r = new lc7(this.c, ag6.G0);
            this.t = new dd7(this.c, bg6.U);
            this.C = new ic7(this.c, vf6.Q0);
            this.s = new kc7(this.c, ag6.H0);
            this.B = new xc7(this.c, bz4.e);
            this.w = new sc7(this.c, ag6.M0);
            this.x = new yc7(this.c, ag6.N0);
            this.y = new tc7(this.c, ag6.O0);
            this.z = new ed7(this.c, ThreadData.TYPE_CONTENT_VOICE_ROOM);
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
            this.f = new gc7(this.c, zf6.Q0);
            this.A = new fc7(this.c, id7.b);
            this.g = new ec7(this.c, zf6.R0);
            this.h = new ad7(this.c, ag6.t0);
            this.D = new uc7(this.c, ag6.u0);
            this.E = new jc7(this.c, ag6.v0);
            this.F = new vc7(this.c, ag6.w0);
            this.G = new ConcernEmotionTipAdapter(this.c.getContext(), jd7.f);
            this.H = new fd7(this.c, ag6.z0, (byte) 4);
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
            tm<?, ?> g = f19.l().g(this.c, AdvertAppInfo.y, "CONCERN");
            tm<?, ?> g2 = f19.l().g(this.c, AdvertAppInfo.z, "CONCERN");
            tm<?, ?> g3 = f19.l().g(this.c, AdvertAppInfo.A, "CONCERN");
            tm<?, ?> g4 = f19.l().g(this.c, AdvertAppInfo.B, "CONCERN");
            tm<?, ?> g5 = f19.l().g(this.c, AdvertAppInfo.C, "CONCERN");
            tm<?, ?> g6 = f19.l().g(this.c, AdvertAppInfo.E, "CONCERN");
            tm<?, ?> g7 = f19.l().g(this.c, AdvertAppInfo.D, "CONCERN");
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
        List<tm> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || (list = this.a) == null) {
            return;
        }
        for (tm tmVar : list) {
            if (tmVar instanceof jx5) {
                ((jx5) tmVar).g(str);
            }
        }
    }

    public void j(List<gn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.J = list;
            this.b.setData(list);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || v38.e(this.J)) {
            return;
        }
        Iterator<tm> it = this.I.iterator();
        while (it.hasNext()) {
            tm next = it.next();
            if (next instanceof w09) {
                ((w09) next).onDestroy();
            }
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            Iterator<wc7> it = this.i.iterator();
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

    public final void i(mn mnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mnVar) == null) {
            Iterator<wc7> it = this.i.iterator();
            while (it.hasNext()) {
                it.next().J(mnVar);
            }
            this.j.E(mnVar);
            this.k.E(mnVar);
            this.l.z(mnVar);
            this.m.z(mnVar);
            this.n.A(mnVar);
            this.u.z(mnVar);
            this.v.z(mnVar);
            this.o.z(mnVar);
            this.B.x(mnVar);
            this.w.u(mnVar);
            this.x.x(mnVar);
            this.y.u(mnVar);
            this.z.z(mnVar);
            this.p.z(mnVar);
            this.q.z(mnVar);
            this.r.z(mnVar);
            this.t.C(mnVar);
            this.s.A(mnVar);
            this.C.A(mnVar);
            this.E.z(mnVar);
            this.D.A(mnVar);
            this.F.A(mnVar);
            this.H.u(mnVar);
        }
    }
}
