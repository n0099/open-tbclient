package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.FollowUserButton;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.homepage.personalize.adapter.HomePageAlaLiveThreadAdapter;
import com.baidu.tieba.homepage.personalize.readProgressBar.ReadProgessDelegetAdapter;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class g18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a18 A;
    public x08 B;
    public r08 C;
    public u08 D;
    public w08 E;
    public g08 F;
    public d18 G;
    public mw7 H;
    public nw7 I;
    public ow7 J;
    public e08 K;
    public kn L;
    public kn M;
    public kn N;
    public kn O;
    public kn P;
    public kn Q;
    public kn R;
    public List<kn> S;

    /* renamed from: T  reason: collision with root package name */
    public boolean f1098T;
    public boolean U;
    public f V;
    public CustomMessageListener W;
    public CustomMessageListener X;
    public CustomMessageListener Y;
    public CustomMessageListener Z;
    public List<kn> a;
    public Cdo b;
    public List<xn> c;
    public TbPageContext<?> d;
    public d08 e;
    public e18 f;
    public f08 g;
    public r08 h;
    public b18 i;
    public l08 j;
    public m08 k;
    public n08 l;
    public v08 m;
    public o08 n;
    public t08 o;
    public q08 p;
    public s08 q;
    public k08 r;
    public j08 s;
    public i08 t;
    public c18 u;
    public h08 v;
    public p08 w;
    public HomePageAlaLiveThreadAdapter x;
    public z08 y;
    public y08 z;

    /* loaded from: classes5.dex */
    public interface f {
        void a();
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ g18 b;

        public a(g18 g18Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g18Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g18Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.b.setData(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g18 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(g18 g18Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g18Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g18Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                this.a.f();
                if (this.a.c != null) {
                    g18 g18Var = this.a;
                    g18Var.z(g18Var.c);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g18 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(g18 g18Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g18Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g18Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) == null || updateAttentionMessage.getData() == null || !updateAttentionMessage.getData().a) {
                return;
            }
            this.a.g(updateAttentionMessage.getData());
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g18 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(g18 g18Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g18Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g18Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                su8 su8Var = new su8();
                su8Var.a = String.valueOf(customResponsedMessage.getData());
                su8Var.b = true;
                this.a.g(su8Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g18 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(g18 g18Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g18Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g18Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                su8 su8Var = new su8();
                su8Var.a = String.valueOf(customResponsedMessage.getData());
                su8Var.b = false;
                this.a.g(su8Var);
            }
        }
    }

    public g18(Context context, Cdo cdo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cdo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.W = new b(this, 2016470);
        this.X = new c(this, 2001115);
        this.Y = new d(this, 2001335);
        this.Z = new e(this, 2001336);
        this.a = new ArrayList();
        this.b = cdo;
        this.d = (TbPageContext) r9.a(context);
        j(context);
        y(cdo);
        cdo.addAdapters(this.a);
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            l();
            this.e.s(i);
        }
    }

    public final void q(String str) {
        List<kn> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, str) != null) || (list = this.a) == null) {
            return;
        }
        for (kn knVar : list) {
            if (knVar instanceof p56) {
                ((p56) knVar).g(str);
            }
        }
    }

    public void r(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
            for (kn knVar : this.a) {
                if (knVar instanceof dv7) {
                    ((dv7) knVar).s(aVar);
                }
            }
        }
    }

    public void s(vz7 vz7Var) {
        m08 m08Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, vz7Var) == null) && (m08Var = this.k) != null) {
            m08Var.B(vz7Var);
        }
    }

    public void v(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, fVar) == null) {
            this.V = fVar;
        }
    }

    public void z(List<xn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, list) == null) {
            m3a.f(list, 2);
            this.b.setData(list);
            this.c = list;
            f fVar = this.V;
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    public void A(List<xn> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, list, i) == null) {
            m3a.f(list, 2);
            ViewGroup listView = this.b.getListView();
            if (i > 0 && (listView instanceof BdRecyclerView)) {
                BdRecyclerView bdRecyclerView = (BdRecyclerView) listView;
                int firstVisiblePosition = bdRecyclerView.getFirstVisiblePosition();
                int i2 = 0;
                View childAt = bdRecyclerView.getChildAt(0);
                if (childAt != null) {
                    i2 = childAt.getTop();
                }
                RecyclerView.LayoutManager layoutManager = bdRecyclerView.getLayoutManager();
                int i3 = firstVisiblePosition - i;
                if (layoutManager instanceof LinearLayoutManager) {
                    bdRecyclerView.startInterceptLayout();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i3, i2);
                    bdRecyclerView.stopIntercerceptLayout();
                }
            }
            ch.g(new a(this, list));
            this.c = list;
            f fVar = this.V;
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.U = f();
        }
    }

    public List<xn> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    public TbPageContext<?> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.d;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public void l() {
        Cdo cdo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (cdo = this.b) != null) {
            cdo.getListAdapter().notifyDataSetChanged();
        }
    }

    public void o() {
        c18 c18Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (c18Var = this.u) != null) {
            c18Var.onPause();
        }
    }

    public void p() {
        c18 c18Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (c18Var = this.u) != null) {
            c18Var.onResume();
        }
    }

    public final boolean f() {
        InterceptResult invokeV;
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<kn> list = this.S;
            if (list != null && list.size() > 0) {
                return true;
            }
            this.S = new ArrayList();
            ArrayList<BdUniqueId> g = m3a.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                vt8 b2 = av8.d().b(this.d, g.get(i), 2);
                if (this.f1098T) {
                    b2.s(3);
                }
                r08 r08Var = this.h;
                if (r08Var != null && (bdUniqueId = r08Var.b) != null) {
                    b2.setUniqueId(bdUniqueId);
                }
                this.S.add(b2);
            }
            this.b.addAdapters(this.S);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void g(Object obj) {
        List<xn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, obj) == null) && (list = this.c) != null) {
            boolean z = false;
            for (xn xnVar : list) {
                if ((xnVar instanceof ICardInfo) && ((ICardInfo) xnVar).responseAttention(obj)) {
                    z = true;
                }
            }
            if (z) {
                l();
            }
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            r08 r08Var = this.h;
            if (r08Var != null) {
                r08Var.setFromCDN(z);
                this.C.setFromCDN(z);
                this.w.setFromCDN(z);
                this.y.setFromCDN(z);
            }
            n08 n08Var = this.l;
            if (n08Var != null) {
                n08Var.setFromCDN(z);
            }
            h08 h08Var = this.v;
            if (h08Var != null) {
                h08Var.setFromCDN(z);
            }
            kn knVar = this.M;
            if (knVar != null && (knVar instanceof is9)) {
                ((is9) knVar).setIsFromCDN(z);
            }
        }
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            this.e = new d08(this.d);
            this.f = new e18(this.d);
            this.g = new f08(this.d, o18.b);
            this.h = new r08(this.d, gp6.r0);
            this.i = new b18(this.d, gp6.D0);
            this.j = new l08(this.d, gp6.L0);
            this.k = new m08(this.d, gp6.E0);
            this.l = new n08(this.d, gp6.M0);
            this.m = new v08(this.d, gp6.K0);
            this.n = new o08(this.d, gp6.N0);
            this.o = new t08(this.d, gp6.O0);
            this.p = new q08(this.d, gp6.P0);
            this.q = new s08(this.d, gp6.Q0);
            this.r = new k08(this.d, gp6.F0);
            this.s = new j08(this.d, gp6.G0);
            this.t = new i08(this.d, gp6.H0);
            this.u = new c18(this.d, hp6.U);
            this.w = new p08(this.d, gp6.t0);
            this.x = new HomePageAlaLiveThreadAdapter(this.d, fp6.R0);
            this.G = new d18(this.d, gp6.J0);
            this.y = new z08(this.d, gp6.u0);
            this.z = new y08(this.d, gp6.v0);
            this.A = new a18(this.d, gp6.x0);
            this.B = new x08(this.d, gp6.w0);
            this.C = new r08(this.d, gp6.s0);
            this.D = new u08(this.d, gp6.y0);
            this.E = new w08(this.d, y48.d0);
            this.F = new g08(this.d, bp6.R0);
            this.v = new h08(this.d, gp6.I0);
            this.H = new mw7(this.d, gp6.z0, (byte) 3);
            this.I = new nw7(this.d, gp6.A0, (byte) 3);
            this.J = new ow7(this.d, gp6.B0, (byte) 3);
            this.K = new e08(this.d, w66.g);
            this.a.add(this.e);
            this.a.add(this.f);
            this.a.add(this.g);
            this.a.add(this.h);
            this.a.add(this.i);
            this.a.add(this.j);
            this.a.add(this.k);
            this.a.add(this.l);
            this.a.add(this.m);
            this.a.add(this.n);
            this.a.add(this.o);
            this.a.add(this.p);
            this.a.add(this.q);
            this.a.add(this.r);
            this.a.add(this.s);
            this.a.add(this.t);
            this.a.add(this.u);
            this.a.add(this.w);
            this.a.add(this.C);
            this.a.add(new ReadProgessDelegetAdapter(this.d, b28.c));
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.a.add(this.B);
            this.a.add(this.A);
            this.a.add(new f18(this.d, r18.h));
            this.a.add(this.D);
            this.a.add(this.E);
            this.a.add(this.F);
            this.a.add(this.v);
            this.a.add(this.H);
            this.a.add(this.I);
            this.a.add(this.J);
            this.a.add(this.G);
            this.a.add(this.K);
            e();
            k();
            q("page_recommend");
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (!ThreadData.isRecAppLoaded.get()) {
                AdvertAppInfo.v.set(false);
                return;
            }
            this.L = ns9.l().g(this.d, AdvertAppInfo.y, "INDEX");
            this.M = ns9.l().g(this.d, AdvertAppInfo.z, "INDEX");
            this.N = ns9.l().g(this.d, AdvertAppInfo.A, "INDEX");
            this.O = ns9.l().g(this.d, AdvertAppInfo.B, "INDEX");
            this.P = ns9.l().g(this.d, AdvertAppInfo.C, "INDEX");
            this.Q = ns9.l().g(this.d, AdvertAppInfo.E, "INDEX");
            this.R = ns9.l().g(this.d, AdvertAppInfo.D, "INDEX");
            this.a.add(this.L);
            this.a.add(this.M);
            this.a.add(this.N);
            this.a.add(this.O);
            this.a.add(this.P);
            this.a.add(this.Q);
            this.a.add(this.R);
            if (this.d.getPageActivity() instanceof BaseFragmentActivity) {
                this.a.add(gt7.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.H));
                this.a.add(gt7.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.G));
            }
            AdvertAppInfo.v.set(true);
        }
    }

    public void u(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) {
            r08 r08Var = this.h;
            if (r08Var != null) {
                r08Var.D(bVar);
            }
            v08 v08Var = this.m;
            if (v08Var != null) {
                v08Var.C(bVar);
            }
            m08 m08Var = this.k;
            if (m08Var != null) {
                m08Var.A(bVar);
            }
            p08 p08Var = this.w;
            if (p08Var != null) {
                p08Var.z(bVar);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.z(bVar);
            }
            z08 z08Var = this.y;
            if (z08Var != null) {
                z08Var.z(bVar);
            }
            y08 y08Var = this.z;
            if (y08Var != null) {
                y08Var.E(bVar);
            }
            x08 x08Var = this.B;
            if (x08Var != null) {
                x08Var.B(bVar);
            }
            a18 a18Var = this.A;
            if (a18Var != null) {
                a18Var.C(bVar);
            }
            r08 r08Var2 = this.C;
            if (r08Var2 != null) {
                r08Var2.D(bVar);
            }
            u08 u08Var = this.D;
            if (u08Var != null) {
                u08Var.C(bVar);
            }
            w08 w08Var = this.E;
            if (w08Var != null) {
                w08Var.x(bVar);
            }
            g08 g08Var = this.F;
            if (g08Var != null) {
                g08Var.B(bVar);
            }
        }
    }

    public final void y(Cdo cdo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, cdo) == null) {
            this.i.E(cdo);
            this.j.C(cdo);
            this.k.C(cdo);
            this.l.C(cdo);
            this.m.E(cdo);
            this.n.u(cdo);
            this.o.x(cdo);
            this.p.u(cdo);
            this.q.C(cdo);
            this.r.C(cdo);
            this.s.C(cdo);
            this.t.C(cdo);
            this.v.D(cdo);
            this.u.F(cdo);
            this.F.C(cdo);
            this.z.F(cdo);
            this.z.F(cdo);
            this.B.C(cdo);
            this.H.u(cdo);
            this.I.u(cdo);
            this.J.u(cdo);
        }
    }

    public void w(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bdUniqueId) == null) {
            f08 f08Var = this.g;
            if (f08Var != null) {
                f08Var.u(bdUniqueId);
            }
            r08 r08Var = this.h;
            if (r08Var != null) {
                r08Var.b = bdUniqueId;
            }
            b18 b18Var = this.i;
            if (b18Var != null) {
                b18Var.b = bdUniqueId;
            }
            l08 l08Var = this.j;
            if (l08Var != null) {
                l08Var.a = bdUniqueId;
            }
            m08 m08Var = this.k;
            if (m08Var != null) {
                m08Var.a = bdUniqueId;
            }
            n08 n08Var = this.l;
            if (n08Var != null) {
                n08Var.a = bdUniqueId;
            }
            v08 v08Var = this.m;
            if (v08Var != null) {
                v08Var.a = bdUniqueId;
            }
            o08 o08Var = this.n;
            if (o08Var != null) {
                o08Var.a = bdUniqueId;
            }
            t08 t08Var = this.o;
            if (t08Var != null) {
                t08Var.a = bdUniqueId;
            }
            q08 q08Var = this.p;
            if (q08Var != null) {
                q08Var.a = bdUniqueId;
            }
            s08 s08Var = this.q;
            if (s08Var != null) {
                s08Var.a = bdUniqueId;
            }
            k08 k08Var = this.r;
            if (k08Var != null) {
                k08Var.a = bdUniqueId;
            }
            j08 j08Var = this.s;
            if (j08Var != null) {
                j08Var.a = bdUniqueId;
            }
            i08 i08Var = this.t;
            if (i08Var != null) {
                i08Var.a = bdUniqueId;
            }
            p08 p08Var = this.w;
            if (p08Var != null) {
                p08Var.b = bdUniqueId;
            }
            c18 c18Var = this.u;
            if (c18Var != null) {
                c18Var.a = bdUniqueId;
            }
            d08 d08Var = this.e;
            if (d08Var != null) {
                d08Var.x(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.a = bdUniqueId;
            }
            d18 d18Var = this.G;
            if (d18Var != null) {
                d18Var.a = bdUniqueId;
            }
            z08 z08Var = this.y;
            if (z08Var != null) {
                z08Var.b = bdUniqueId;
            }
            y08 y08Var = this.z;
            if (y08Var != null) {
                y08Var.b = bdUniqueId;
            }
            x08 x08Var = this.B;
            if (x08Var != null) {
                x08Var.b = bdUniqueId;
            }
            a18 a18Var = this.A;
            if (a18Var != null) {
                a18Var.b = bdUniqueId;
            }
            r08 r08Var2 = this.C;
            if (r08Var2 != null) {
                r08Var2.b = bdUniqueId;
            }
            u08 u08Var = this.D;
            if (u08Var != null) {
                u08Var.a = bdUniqueId;
            }
            w08 w08Var = this.E;
            if (w08Var != null) {
                w08Var.a = bdUniqueId;
            }
            g08 g08Var = this.F;
            if (g08Var != null) {
                g08Var.b = bdUniqueId;
            }
            h08 h08Var = this.v;
            if (h08Var != null) {
                h08Var.a = bdUniqueId;
            }
            mw7 mw7Var = this.H;
            if (mw7Var != null) {
                mw7Var.b = bdUniqueId;
            }
            nw7 nw7Var = this.I;
            if (nw7Var != null) {
                nw7Var.b = bdUniqueId;
            }
            ow7 ow7Var = this.J;
            if (ow7Var != null) {
                ow7Var.b = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.S)) {
                for (kn knVar : this.S) {
                    if (knVar instanceof vt8) {
                        ((vt8) knVar).setUniqueId(bdUniqueId);
                    }
                }
            }
            this.X.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.X);
            this.Y.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.Y);
            this.Z.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.Z);
            if (!this.U) {
                this.W.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.W);
            }
        }
    }

    public void x(y18 y18Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, y18Var) == null) {
            this.h.E(y18Var);
            this.i.D(y18Var);
            this.j.B(y18Var);
            this.l.B(y18Var);
            this.m.D(y18Var);
            this.q.B(y18Var);
            this.r.B(y18Var);
            this.s.B(y18Var);
            this.t.B(y18Var);
            this.u.E(y18Var);
            this.v.C(y18Var);
        }
    }
}
