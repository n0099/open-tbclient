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
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.FollowUserButton;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.homepage.personalize.adapter.HomePageAlaFriendRoomAdapter;
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
/* loaded from: classes4.dex */
public class i97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a97 A;
    public c97 B;
    public z87 C;
    public s87 D;
    public v87 E;
    public w87 F;
    public y87 G;
    public h87 H;
    public f97 I;
    public s47 J;
    public t47 K;
    public f87 L;
    public ln M;
    public ln N;
    public ln O;
    public ln P;
    public ln Q;
    public ln R;
    public ln S;
    public List<ln> T;
    public boolean U;
    public boolean V;
    public f W;
    public CustomMessageListener X;
    public CustomMessageListener Y;
    public CustomMessageListener Z;
    public List<ln> a;
    public CustomMessageListener a0;
    public eo b;
    public List<yn> c;
    public TbPageContext<?> d;
    public e87 e;
    public g97 f;
    public g87 g;
    public s87 h;
    public d97 i;
    public m87 j;
    public n87 k;
    public o87 l;
    public x87 m;
    public p87 n;
    public u87 o;
    public r87 p;
    public t87 q;
    public l87 r;
    public k87 s;
    public j87 t;
    public e97 u;
    public i87 v;
    public q87 w;
    public HomePageAlaLiveThreadAdapter x;
    public HomePageAlaFriendRoomAdapter y;
    public b97 z;

    /* loaded from: classes4.dex */
    public interface f {
        void a();
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ i97 b;

        public a(i97 i97Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i97Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i97Var;
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

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i97 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(i97 i97Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i97Var, Integer.valueOf(i)};
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
            this.a = i97Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                this.a.f();
                if (this.a.c != null) {
                    i97 i97Var = this.a;
                    i97Var.y(i97Var.c);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i97 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(i97 i97Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i97Var, Integer.valueOf(i)};
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
            this.a = i97Var;
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

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i97 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(i97 i97Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i97Var, Integer.valueOf(i)};
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
            this.a = i97Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                jr7 jr7Var = new jr7();
                jr7Var.a = String.valueOf(customResponsedMessage.getData());
                jr7Var.b = true;
                this.a.g(jr7Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i97 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(i97 i97Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i97Var, Integer.valueOf(i)};
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
            this.a = i97Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                jr7 jr7Var = new jr7();
                jr7Var.a = String.valueOf(customResponsedMessage.getData());
                jr7Var.b = false;
                this.a.g(jr7Var);
            }
        }
    }

    public i97(Context context, eo eoVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, eoVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.X = new b(this, 2016470);
        this.Y = new c(this, 2001115);
        this.Z = new d(this, 2001335);
        this.a0 = new e(this, 2001336);
        this.a = new ArrayList();
        this.b = eoVar;
        this.d = (TbPageContext) y9.a(context);
        j(context);
        x(eoVar);
        eoVar.a(this.a);
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            l();
            this.e.s(i);
        }
    }

    public final void q(String str) {
        List<ln> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, str) != null) || (list = this.a) == null) {
            return;
        }
        for (ln lnVar : list) {
            if (lnVar instanceof bs5) {
                ((bs5) lnVar).g(str);
            }
        }
    }

    public void r(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            for (ln lnVar : this.a) {
                if (lnVar instanceof i37) {
                    ((i37) lnVar).s(aVar);
                }
            }
        }
    }

    public void u(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, fVar) == null) {
            this.W = fVar;
        }
    }

    public void y(List<yn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, list) == null) {
            hw8.f(list, 2);
            this.b.setData(list);
            this.c = list;
            f fVar = this.W;
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.V = f();
        }
    }

    public List<yn> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    public TbPageContext<?> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public void l() {
        eo eoVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (eoVar = this.b) != null) {
            eoVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void o() {
        e97 e97Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (e97Var = this.u) != null) {
            e97Var.onPause();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            e97 e97Var = this.u;
            if (e97Var != null) {
                e97Var.onResume();
            }
            if (!UbsABTestHelper.isFeedVideoImmersionTransition()) {
                l();
            }
        }
    }

    public final boolean f() {
        InterceptResult invokeV;
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<ln> list = this.T;
            if (list != null && list.size() > 0) {
                return true;
            }
            this.T = new ArrayList();
            ArrayList<BdUniqueId> g = hw8.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                mq7 b2 = rr7.d().b(this.d, g.get(i), 2);
                if (this.U) {
                    b2.s(3);
                }
                s87 s87Var = this.h;
                if (s87Var != null && (bdUniqueId = s87Var.b) != null) {
                    b2.setUniqueId(bdUniqueId);
                }
                this.T.add(b2);
            }
            this.b.a(this.T);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void g(Object obj) {
        List<yn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) && (list = this.c) != null) {
            boolean z = false;
            for (yn ynVar : list) {
                if ((ynVar instanceof ICardInfo) && ((ICardInfo) ynVar).responseAttention(obj)) {
                    z = true;
                }
            }
            if (z) {
                l();
            }
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            s87 s87Var = this.h;
            if (s87Var != null) {
                s87Var.setFromCDN(z);
                this.D.setFromCDN(z);
                this.w.setFromCDN(z);
                this.z.setFromCDN(z);
            }
            o87 o87Var = this.l;
            if (o87Var != null) {
                o87Var.setFromCDN(z);
            }
            i87 i87Var = this.v;
            if (i87Var != null) {
                i87Var.setFromCDN(z);
            }
            ln lnVar = this.N;
            if (lnVar != null && (lnVar instanceof nn8)) {
                ((nn8) lnVar).setIsFromCDN(z);
            }
        }
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            this.e = new e87(this.d);
            this.f = new g97(this.d);
            this.g = new g87(this.d, q97.b);
            this.h = new s87(this.d, o96.i0);
            this.i = new d97(this.d, o96.A0);
            this.j = new m87(this.d, o96.I0);
            this.k = new n87(this.d, o96.B0);
            this.l = new o87(this.d, o96.J0);
            this.m = new x87(this.d, o96.H0);
            this.n = new p87(this.d, o96.K0);
            this.o = new u87(this.d, o96.L0);
            this.p = new r87(this.d, o96.M0);
            this.q = new t87(this.d, o96.N0);
            this.r = new l87(this.d, o96.C0);
            this.s = new k87(this.d, o96.D0);
            this.t = new j87(this.d, o96.E0);
            this.u = new e97(this.d, p96.U);
            this.w = new q87(this.d, o96.q0);
            this.x = new HomePageAlaLiveThreadAdapter(this.d, n96.O0);
            this.I = new f97(this.d, o96.G0);
            this.y = new HomePageAlaFriendRoomAdapter(this.d, n96.P0);
            this.z = new b97(this.d, o96.r0);
            this.A = new a97(this.d, o96.s0);
            this.B = new c97(this.d, o96.u0);
            this.C = new z87(this.d, o96.t0);
            this.D = new s87(this.d, o96.j0);
            this.E = new v87(this.d, o96.v0);
            this.F = new w87(this.d, o96.w0);
            this.G = new y87(this.d, qc7.d0);
            this.H = new h87(this.d, j96.O0);
            this.v = new i87(this.d, o96.F0);
            this.J = new s47(this.d, o96.x0, (byte) 3);
            this.K = new t47(this.d, o96.y0, (byte) 3);
            this.L = new f87(this.d, gt5.g);
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
            this.a.add(this.D);
            this.a.add(new ReadProgessDelegetAdapter(this.d, ba7.c));
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.a.add(this.A);
            this.a.add(this.C);
            this.a.add(this.B);
            this.a.add(new h97(this.d, s97.e));
            this.a.add(this.E);
            this.a.add(this.F);
            this.a.add(this.G);
            this.a.add(this.H);
            this.a.add(this.v);
            this.a.add(this.J);
            this.a.add(this.K);
            this.a.add(this.I);
            this.a.add(this.L);
            e();
            k();
            q("page_recommend");
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (!ThreadData.isRecAppLoaded.get()) {
                AdvertAppInfo.v.set(false);
                return;
            }
            this.M = rn8.l().g(this.d, AdvertAppInfo.y, "INDEX");
            this.N = rn8.l().g(this.d, AdvertAppInfo.z, "INDEX");
            this.O = rn8.l().g(this.d, AdvertAppInfo.A, "INDEX");
            this.P = rn8.l().g(this.d, AdvertAppInfo.B, "INDEX");
            this.Q = rn8.l().g(this.d, AdvertAppInfo.C, "INDEX");
            this.R = rn8.l().g(this.d, AdvertAppInfo.E, "INDEX");
            this.S = rn8.l().g(this.d, AdvertAppInfo.D, "INDEX");
            this.a.add(this.M);
            this.a.add(this.N);
            this.a.add(this.O);
            this.a.add(this.P);
            this.a.add(this.Q);
            this.a.add(this.R);
            this.a.add(this.S);
            if (this.d.getPageActivity() instanceof BaseFragmentActivity) {
                this.a.add(u17.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.H));
                this.a.add(u17.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.G));
            }
            AdvertAppInfo.v.set(true);
        }
    }

    public void t(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            s87 s87Var = this.h;
            if (s87Var != null) {
                s87Var.B(bVar);
            }
            x87 x87Var = this.m;
            if (x87Var != null) {
                x87Var.A(bVar);
            }
            n87 n87Var = this.k;
            if (n87Var != null) {
                n87Var.y(bVar);
            }
            q87 q87Var = this.w;
            if (q87Var != null) {
                q87Var.x(bVar);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.x(bVar);
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.x(bVar);
            }
            b97 b97Var = this.z;
            if (b97Var != null) {
                b97Var.x(bVar);
            }
            a97 a97Var = this.A;
            if (a97Var != null) {
                a97Var.C(bVar);
            }
            z87 z87Var = this.C;
            if (z87Var != null) {
                z87Var.z(bVar);
            }
            c97 c97Var = this.B;
            if (c97Var != null) {
                c97Var.A(bVar);
            }
            s87 s87Var2 = this.D;
            if (s87Var2 != null) {
                s87Var2.B(bVar);
            }
            v87 v87Var = this.E;
            if (v87Var != null) {
                v87Var.A(bVar);
            }
            w87 w87Var = this.F;
            if (w87Var != null) {
                w87Var.z(bVar);
            }
            y87 y87Var = this.G;
            if (y87Var != null) {
                y87Var.v(bVar);
            }
            h87 h87Var = this.H;
            if (h87Var != null) {
                h87Var.z(bVar);
            }
        }
    }

    public final void x(eo eoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, eoVar) == null) {
            this.i.C(eoVar);
            this.j.A(eoVar);
            this.k.z(eoVar);
            this.l.A(eoVar);
            this.m.C(eoVar);
            this.n.u(eoVar);
            this.o.v(eoVar);
            this.p.u(eoVar);
            this.q.A(eoVar);
            this.r.A(eoVar);
            this.s.A(eoVar);
            this.t.A(eoVar);
            this.v.B(eoVar);
            this.u.D(eoVar);
            this.H.A(eoVar);
            this.A.D(eoVar);
            this.A.D(eoVar);
            this.C.A(eoVar);
            this.J.u(eoVar);
            this.K.u(eoVar);
        }
    }

    public void v(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bdUniqueId) == null) {
            g87 g87Var = this.g;
            if (g87Var != null) {
                g87Var.u(bdUniqueId);
            }
            s87 s87Var = this.h;
            if (s87Var != null) {
                s87Var.b = bdUniqueId;
            }
            d97 d97Var = this.i;
            if (d97Var != null) {
                d97Var.b = bdUniqueId;
            }
            m87 m87Var = this.j;
            if (m87Var != null) {
                m87Var.a = bdUniqueId;
            }
            n87 n87Var = this.k;
            if (n87Var != null) {
                n87Var.a = bdUniqueId;
            }
            o87 o87Var = this.l;
            if (o87Var != null) {
                o87Var.a = bdUniqueId;
            }
            x87 x87Var = this.m;
            if (x87Var != null) {
                x87Var.a = bdUniqueId;
            }
            p87 p87Var = this.n;
            if (p87Var != null) {
                p87Var.a = bdUniqueId;
            }
            u87 u87Var = this.o;
            if (u87Var != null) {
                u87Var.a = bdUniqueId;
            }
            r87 r87Var = this.p;
            if (r87Var != null) {
                r87Var.a = bdUniqueId;
            }
            t87 t87Var = this.q;
            if (t87Var != null) {
                t87Var.a = bdUniqueId;
            }
            l87 l87Var = this.r;
            if (l87Var != null) {
                l87Var.a = bdUniqueId;
            }
            k87 k87Var = this.s;
            if (k87Var != null) {
                k87Var.a = bdUniqueId;
            }
            j87 j87Var = this.t;
            if (j87Var != null) {
                j87Var.a = bdUniqueId;
            }
            q87 q87Var = this.w;
            if (q87Var != null) {
                q87Var.b = bdUniqueId;
            }
            e97 e97Var = this.u;
            if (e97Var != null) {
                e97Var.a = bdUniqueId;
            }
            e87 e87Var = this.e;
            if (e87Var != null) {
                e87Var.v(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.a = bdUniqueId;
            }
            f97 f97Var = this.I;
            if (f97Var != null) {
                f97Var.a = bdUniqueId;
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.a = bdUniqueId;
            }
            b97 b97Var = this.z;
            if (b97Var != null) {
                b97Var.b = bdUniqueId;
            }
            a97 a97Var = this.A;
            if (a97Var != null) {
                a97Var.b = bdUniqueId;
            }
            z87 z87Var = this.C;
            if (z87Var != null) {
                z87Var.b = bdUniqueId;
            }
            c97 c97Var = this.B;
            if (c97Var != null) {
                c97Var.b = bdUniqueId;
            }
            s87 s87Var2 = this.D;
            if (s87Var2 != null) {
                s87Var2.b = bdUniqueId;
            }
            v87 v87Var = this.E;
            if (v87Var != null) {
                v87Var.a = bdUniqueId;
            }
            w87 w87Var = this.F;
            if (w87Var != null) {
                w87Var.a = bdUniqueId;
            }
            y87 y87Var = this.G;
            if (y87Var != null) {
                y87Var.a = bdUniqueId;
            }
            h87 h87Var = this.H;
            if (h87Var != null) {
                h87Var.b = bdUniqueId;
            }
            i87 i87Var = this.v;
            if (i87Var != null) {
                i87Var.a = bdUniqueId;
            }
            s47 s47Var = this.J;
            if (s47Var != null) {
                s47Var.b = bdUniqueId;
            }
            t47 t47Var = this.K;
            if (t47Var != null) {
                t47Var.b = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.T)) {
                for (ln lnVar : this.T) {
                    if (lnVar instanceof mq7) {
                        ((mq7) lnVar).setUniqueId(bdUniqueId);
                    }
                }
            }
            this.Y.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.Y);
            this.Z.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.Z);
            this.a0.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.a0);
            if (!this.V) {
                this.X.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.X);
            }
        }
    }

    public void w(y97 y97Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, y97Var) == null) {
            this.h.C(y97Var);
            this.i.B(y97Var);
            this.j.z(y97Var);
            this.l.z(y97Var);
            this.m.B(y97Var);
            this.q.z(y97Var);
            this.r.z(y97Var);
            this.s.z(y97Var);
            this.t.z(y97Var);
            this.u.C(y97Var);
            this.v.A(y97Var);
        }
    }

    public void z(List<yn> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048597, this, list, i) == null) {
            hw8.f(list, 2);
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
                    bdRecyclerView.B();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i3, i2);
                    bdRecyclerView.C();
                }
            }
            fh.e(new a(this, list));
            this.c = list;
            f fVar = this.W;
            if (fVar != null) {
                fVar.a();
            }
        }
    }
}
