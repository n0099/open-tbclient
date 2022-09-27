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
public class h27 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public z17 A;
    public b27 B;
    public y17 C;
    public r17 D;
    public u17 E;
    public v17 F;
    public x17 G;
    public g17 H;
    public e27 I;
    public vx6 J;
    public qn K;
    public qn L;
    public qn M;
    public qn N;
    public qn O;
    public qn P;
    public qn Q;
    public List<qn> R;
    public boolean S;
    public boolean T;
    public f U;
    public CustomMessageListener V;
    public CustomMessageListener W;
    public CustomMessageListener X;
    public CustomMessageListener Y;
    public List<qn> a;
    public jo b;
    public List<Cdo> c;
    public TbPageContext<?> d;
    public e17 e;
    public f27 f;
    public f17 g;
    public r17 h;
    public c27 i;
    public l17 j;
    public m17 k;
    public n17 l;
    public w17 m;
    public o17 n;
    public t17 o;
    public q17 p;
    public s17 q;
    public k17 r;
    public j17 s;
    public i17 t;
    public d27 u;
    public h17 v;
    public p17 w;
    public HomePageAlaLiveThreadAdapter x;
    public HomePageAlaFriendRoomAdapter y;
    public a27 z;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ h27 b;

        public a(h27 h27Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h27Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h27Var;
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
        public final /* synthetic */ h27 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(h27 h27Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h27Var, Integer.valueOf(i)};
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
            this.a = h27Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.a.f();
            if (this.a.c != null) {
                h27 h27Var = this.a;
                h27Var.y(h27Var.c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h27 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(h27 h27Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h27Var, Integer.valueOf(i)};
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
            this.a = h27Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) == null || updateAttentionMessage.getData() == null || !updateAttentionMessage.getData().a) {
                return;
            }
            this.a.g(updateAttentionMessage.getData());
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h27 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(h27 h27Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h27Var, Integer.valueOf(i)};
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
            this.a = h27Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                ph7 ph7Var = new ph7();
                ph7Var.a = String.valueOf(customResponsedMessage.getData());
                ph7Var.b = true;
                this.a.g(ph7Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h27 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(h27 h27Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h27Var, Integer.valueOf(i)};
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
            this.a = h27Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                ph7 ph7Var = new ph7();
                ph7Var.a = String.valueOf(customResponsedMessage.getData());
                ph7Var.b = false;
                this.a.g(ph7Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a();
    }

    public h27(Context context, jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, joVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.V = new b(this, 2016470);
        this.W = new c(this, 2001115);
        this.X = new d(this, 2001335);
        this.Y = new e(this, 2001336);
        this.a = new ArrayList();
        this.b = joVar;
        this.d = (TbPageContext) w9.a(context);
        j(context);
        x(joVar);
        joVar.a(this.a);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.T = f();
        }
    }

    public final boolean f() {
        InterceptResult invokeV;
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<qn> list = this.R;
            if (list == null || list.size() <= 0) {
                this.R = new ArrayList();
                ArrayList<BdUniqueId> g = jm8.g();
                if (g == null || g.size() <= 0) {
                    return false;
                }
                int size = g.size();
                for (int i = 0; i < size; i++) {
                    sg7 b2 = xh7.d().b(this.d, g.get(i), 2);
                    if (this.S) {
                        b2.s(3);
                    }
                    r17 r17Var = this.h;
                    if (r17Var != null && (bdUniqueId = r17Var.b) != null) {
                        b2.setUniqueId(bdUniqueId);
                    }
                    this.R.add(b2);
                }
                this.b.a(this.R);
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void g(Object obj) {
        List<Cdo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) || (list = this.c) == null) {
            return;
        }
        boolean z = false;
        for (Cdo cdo : list) {
            if ((cdo instanceof ICardInfo) && ((ICardInfo) cdo).responseAttention(obj)) {
                z = true;
            }
        }
        if (z) {
            l();
        }
    }

    public List<Cdo> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c : (List) invokeV.objValue;
    }

    public TbPageContext<?> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.d : (TbPageContext) invokeV.objValue;
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            this.e = new e17(this.d);
            this.f = new f27(this.d);
            this.g = new f17(this.d, p27.b);
            this.h = new r17(this.d, x26.i0);
            this.i = new c27(this.d, x26.z0);
            this.j = new l17(this.d, x26.H0);
            this.k = new m17(this.d, x26.A0);
            this.l = new n17(this.d, x26.I0);
            this.m = new w17(this.d, x26.G0);
            this.n = new o17(this.d, x26.J0);
            this.o = new t17(this.d, x26.K0);
            this.p = new q17(this.d, x26.L0);
            this.q = new s17(this.d, x26.M0);
            this.r = new k17(this.d, x26.B0);
            this.s = new j17(this.d, x26.C0);
            this.t = new i17(this.d, x26.D0);
            this.u = new d27(this.d, y26.U);
            this.w = new p17(this.d, x26.q0);
            this.x = new HomePageAlaLiveThreadAdapter(this.d, w26.N0);
            this.I = new e27(this.d, x26.F0);
            this.y = new HomePageAlaFriendRoomAdapter(this.d, w26.O0);
            this.z = new a27(this.d, x26.r0);
            this.A = new z17(this.d, x26.s0);
            this.B = new b27(this.d, x26.u0);
            this.C = new y17(this.d, x26.t0);
            this.D = new r17(this.d, x26.j0);
            this.E = new u17(this.d, x26.v0);
            this.F = new v17(this.d, x26.w0);
            this.G = new x17(this.d, p57.d0);
            this.H = new g17(this.d, s26.N0);
            this.v = new h17(this.d, x26.E0);
            this.J = new vx6(this.d, x26.x0, (byte) 3);
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
            this.a.add(new ReadProgessDelegetAdapter(this.d, b37.c));
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.a.add(this.A);
            this.a.add(this.C);
            this.a.add(this.B);
            this.a.add(new g27(this.d, r27.e));
            this.a.add(this.E);
            this.a.add(this.F);
            this.a.add(this.G);
            this.a.add(this.H);
            this.a.add(this.v);
            this.a.add(this.J);
            this.a.add(this.I);
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
            this.K = be8.l().g(this.d, AdvertAppInfo.y, "INDEX");
            this.L = be8.l().g(this.d, AdvertAppInfo.z, "INDEX");
            this.M = be8.l().g(this.d, AdvertAppInfo.A, "INDEX");
            this.N = be8.l().g(this.d, AdvertAppInfo.B, "INDEX");
            this.O = be8.l().g(this.d, AdvertAppInfo.C, "INDEX");
            this.P = be8.l().g(this.d, AdvertAppInfo.E, "INDEX");
            this.Q = be8.l().g(this.d, AdvertAppInfo.D, "INDEX");
            this.a.add(this.K);
            this.a.add(this.L);
            this.a.add(this.M);
            this.a.add(this.N);
            this.a.add(this.O);
            this.a.add(this.P);
            this.a.add(this.Q);
            if (this.d.getPageActivity() instanceof BaseFragmentActivity) {
                this.a.add(xu6.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.H));
                this.a.add(xu6.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.G));
            }
            AdvertAppInfo.v.set(true);
        }
    }

    public void l() {
        jo joVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (joVar = this.b) == null) {
            return;
        }
        joVar.getListAdapter().notifyDataSetChanged();
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            l();
            this.e.s(i);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    public void o() {
        d27 d27Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (d27Var = this.u) == null) {
            return;
        }
        d27Var.onPause();
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            d27 d27Var = this.u;
            if (d27Var != null) {
                d27Var.onResume();
            }
            if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                return;
            }
            l();
        }
    }

    public final void q(String str) {
        List<qn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || (list = this.a) == null) {
            return;
        }
        for (qn qnVar : list) {
            if (qnVar instanceof to5) {
                ((to5) qnVar).g(str);
            }
        }
    }

    public void r(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            for (qn qnVar : this.a) {
                if (qnVar instanceof lw6) {
                    ((lw6) qnVar).s(aVar);
                }
            }
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            r17 r17Var = this.h;
            if (r17Var != null) {
                r17Var.setFromCDN(z);
                this.D.setFromCDN(z);
                this.w.setFromCDN(z);
                this.z.setFromCDN(z);
            }
            n17 n17Var = this.l;
            if (n17Var != null) {
                n17Var.setFromCDN(z);
            }
            h17 h17Var = this.v;
            if (h17Var != null) {
                h17Var.setFromCDN(z);
            }
            qn qnVar = this.L;
            if (qnVar == null || !(qnVar instanceof xd8)) {
                return;
            }
            ((xd8) qnVar).setIsFromCDN(z);
        }
    }

    public void t(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            r17 r17Var = this.h;
            if (r17Var != null) {
                r17Var.B(bVar);
            }
            w17 w17Var = this.m;
            if (w17Var != null) {
                w17Var.A(bVar);
            }
            m17 m17Var = this.k;
            if (m17Var != null) {
                m17Var.y(bVar);
            }
            p17 p17Var = this.w;
            if (p17Var != null) {
                p17Var.x(bVar);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.x(bVar);
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.x(bVar);
            }
            a27 a27Var = this.z;
            if (a27Var != null) {
                a27Var.x(bVar);
            }
            z17 z17Var = this.A;
            if (z17Var != null) {
                z17Var.C(bVar);
            }
            y17 y17Var = this.C;
            if (y17Var != null) {
                y17Var.z(bVar);
            }
            b27 b27Var = this.B;
            if (b27Var != null) {
                b27Var.A(bVar);
            }
            r17 r17Var2 = this.D;
            if (r17Var2 != null) {
                r17Var2.B(bVar);
            }
            u17 u17Var = this.E;
            if (u17Var != null) {
                u17Var.A(bVar);
            }
            v17 v17Var = this.F;
            if (v17Var != null) {
                v17Var.z(bVar);
            }
            x17 x17Var = this.G;
            if (x17Var != null) {
                x17Var.v(bVar);
            }
            g17 g17Var = this.H;
            if (g17Var != null) {
                g17Var.z(bVar);
            }
        }
    }

    public void u(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, fVar) == null) {
            this.U = fVar;
        }
    }

    public void v(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bdUniqueId) == null) {
            f17 f17Var = this.g;
            if (f17Var != null) {
                f17Var.u(bdUniqueId);
            }
            r17 r17Var = this.h;
            if (r17Var != null) {
                r17Var.b = bdUniqueId;
            }
            c27 c27Var = this.i;
            if (c27Var != null) {
                c27Var.b = bdUniqueId;
            }
            l17 l17Var = this.j;
            if (l17Var != null) {
                l17Var.a = bdUniqueId;
            }
            m17 m17Var = this.k;
            if (m17Var != null) {
                m17Var.a = bdUniqueId;
            }
            n17 n17Var = this.l;
            if (n17Var != null) {
                n17Var.a = bdUniqueId;
            }
            w17 w17Var = this.m;
            if (w17Var != null) {
                w17Var.a = bdUniqueId;
            }
            o17 o17Var = this.n;
            if (o17Var != null) {
                o17Var.a = bdUniqueId;
            }
            t17 t17Var = this.o;
            if (t17Var != null) {
                t17Var.a = bdUniqueId;
            }
            q17 q17Var = this.p;
            if (q17Var != null) {
                q17Var.a = bdUniqueId;
            }
            s17 s17Var = this.q;
            if (s17Var != null) {
                s17Var.a = bdUniqueId;
            }
            k17 k17Var = this.r;
            if (k17Var != null) {
                k17Var.a = bdUniqueId;
            }
            j17 j17Var = this.s;
            if (j17Var != null) {
                j17Var.a = bdUniqueId;
            }
            i17 i17Var = this.t;
            if (i17Var != null) {
                i17Var.a = bdUniqueId;
            }
            p17 p17Var = this.w;
            if (p17Var != null) {
                p17Var.b = bdUniqueId;
            }
            d27 d27Var = this.u;
            if (d27Var != null) {
                d27Var.a = bdUniqueId;
            }
            e17 e17Var = this.e;
            if (e17Var != null) {
                e17Var.v(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.a = bdUniqueId;
            }
            e27 e27Var = this.I;
            if (e27Var != null) {
                e27Var.a = bdUniqueId;
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.a = bdUniqueId;
            }
            a27 a27Var = this.z;
            if (a27Var != null) {
                a27Var.b = bdUniqueId;
            }
            z17 z17Var = this.A;
            if (z17Var != null) {
                z17Var.b = bdUniqueId;
            }
            y17 y17Var = this.C;
            if (y17Var != null) {
                y17Var.b = bdUniqueId;
            }
            b27 b27Var = this.B;
            if (b27Var != null) {
                b27Var.b = bdUniqueId;
            }
            r17 r17Var2 = this.D;
            if (r17Var2 != null) {
                r17Var2.b = bdUniqueId;
            }
            u17 u17Var = this.E;
            if (u17Var != null) {
                u17Var.a = bdUniqueId;
            }
            v17 v17Var = this.F;
            if (v17Var != null) {
                v17Var.a = bdUniqueId;
            }
            x17 x17Var = this.G;
            if (x17Var != null) {
                x17Var.a = bdUniqueId;
            }
            g17 g17Var = this.H;
            if (g17Var != null) {
                g17Var.b = bdUniqueId;
            }
            h17 h17Var = this.v;
            if (h17Var != null) {
                h17Var.a = bdUniqueId;
            }
            vx6 vx6Var = this.J;
            if (vx6Var != null) {
                vx6Var.b = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.R)) {
                for (qn qnVar : this.R) {
                    if (qnVar instanceof sg7) {
                        ((sg7) qnVar).setUniqueId(bdUniqueId);
                    }
                }
            }
            this.W.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.W);
            this.X.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.X);
            this.Y.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.Y);
            if (this.T) {
                return;
            }
            this.V.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.V);
        }
    }

    public void w(y27 y27Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, y27Var) == null) {
            this.h.C(y27Var);
            this.i.B(y27Var);
            this.j.z(y27Var);
            this.l.z(y27Var);
            this.m.B(y27Var);
            this.q.z(y27Var);
            this.r.z(y27Var);
            this.s.z(y27Var);
            this.t.z(y27Var);
            this.u.C(y27Var);
            this.v.A(y27Var);
        }
    }

    public final void x(jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, joVar) == null) {
            this.i.C(joVar);
            this.j.A(joVar);
            this.k.z(joVar);
            this.l.A(joVar);
            this.m.C(joVar);
            this.n.u(joVar);
            this.o.v(joVar);
            this.p.u(joVar);
            this.q.A(joVar);
            this.r.A(joVar);
            this.s.A(joVar);
            this.t.A(joVar);
            this.v.B(joVar);
            this.u.D(joVar);
            this.H.A(joVar);
            this.A.D(joVar);
            this.A.D(joVar);
            this.C.A(joVar);
            this.J.u(joVar);
        }
    }

    public void y(List<Cdo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, list) == null) {
            jm8.f(list, 2);
            this.b.setData(list);
            this.c = list;
            f fVar = this.U;
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    public void z(List<Cdo> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048597, this, list, i) == null) {
            jm8.f(list, 2);
            ViewGroup listView = this.b.getListView();
            if (i > 0 && (listView instanceof BdRecyclerView)) {
                BdRecyclerView bdRecyclerView = (BdRecyclerView) listView;
                int firstVisiblePosition = bdRecyclerView.getFirstVisiblePosition();
                View childAt = bdRecyclerView.getChildAt(0);
                int top = childAt != null ? childAt.getTop() : 0;
                RecyclerView.LayoutManager layoutManager = bdRecyclerView.getLayoutManager();
                int i2 = firstVisiblePosition - i;
                if (layoutManager instanceof LinearLayoutManager) {
                    bdRecyclerView.z();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, top);
                    bdRecyclerView.A();
                }
            }
            kh.b(new a(this, list));
            this.c = list;
            f fVar = this.U;
            if (fVar != null) {
                fVar.a();
            }
        }
    }
}
