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
public class i07 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a07 A;
    public c07 B;
    public zz6 C;
    public sz6 D;
    public vz6 E;
    public wz6 F;
    public yz6 G;
    public hz6 H;
    public f07 I;
    public wv6 J;
    public cn K;
    public cn L;
    public cn M;
    public cn N;
    public cn O;
    public cn P;
    public cn Q;
    public List<cn> R;
    public boolean S;
    public boolean T;
    public f U;
    public CustomMessageListener V;
    public CustomMessageListener W;
    public CustomMessageListener X;
    public CustomMessageListener Y;
    public List<cn> a;
    public vn b;
    public List<pn> c;
    public TbPageContext<?> d;
    public fz6 e;
    public g07 f;
    public gz6 g;
    public sz6 h;
    public d07 i;
    public mz6 j;
    public nz6 k;
    public oz6 l;
    public xz6 m;
    public pz6 n;
    public uz6 o;
    public rz6 p;
    public tz6 q;
    public lz6 r;
    public kz6 s;
    public jz6 t;
    public e07 u;
    public iz6 v;
    public qz6 w;
    public HomePageAlaLiveThreadAdapter x;
    public HomePageAlaFriendRoomAdapter y;
    public b07 z;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ i07 b;

        public a(i07 i07Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i07Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i07Var;
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
        public final /* synthetic */ i07 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(i07 i07Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i07Var, Integer.valueOf(i)};
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
            this.a = i07Var;
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
                i07 i07Var = this.a;
                i07Var.y(i07Var.c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i07 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(i07 i07Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i07Var, Integer.valueOf(i)};
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
            this.a = i07Var;
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
        public final /* synthetic */ i07 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(i07 i07Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i07Var, Integer.valueOf(i)};
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
            this.a = i07Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                vf7 vf7Var = new vf7();
                vf7Var.a = String.valueOf(customResponsedMessage.getData());
                vf7Var.b = true;
                this.a.g(vf7Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i07 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(i07 i07Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i07Var, Integer.valueOf(i)};
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
            this.a = i07Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                vf7 vf7Var = new vf7();
                vf7Var.a = String.valueOf(customResponsedMessage.getData());
                vf7Var.b = false;
                this.a.g(vf7Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a();
    }

    public i07(Context context, vn vnVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, vnVar};
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
        this.b = vnVar;
        this.d = (TbPageContext) i9.a(context);
        j(context);
        x(vnVar);
        vnVar.a(this.a);
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
            List<cn> list = this.R;
            if (list == null || list.size() <= 0) {
                this.R = new ArrayList();
                ArrayList<BdUniqueId> g = gk8.g();
                if (g == null || g.size() <= 0) {
                    return false;
                }
                int size = g.size();
                for (int i = 0; i < size; i++) {
                    ye7 b2 = dg7.d().b(this.d, g.get(i), 2);
                    if (this.S) {
                        b2.s(3);
                    }
                    sz6 sz6Var = this.h;
                    if (sz6Var != null && (bdUniqueId = sz6Var.b) != null) {
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
        List<pn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) || (list = this.c) == null) {
            return;
        }
        boolean z = false;
        for (pn pnVar : list) {
            if ((pnVar instanceof ICardInfo) && ((ICardInfo) pnVar).responseAttention(obj)) {
                z = true;
            }
        }
        if (z) {
            l();
        }
    }

    public List<pn> h() {
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
            this.e = new fz6(this.d);
            this.f = new g07(this.d);
            this.g = new gz6(this.d, q07.b);
            this.h = new sz6(this.d, t06.i0);
            this.i = new d07(this.d, t06.z0);
            this.j = new mz6(this.d, t06.H0);
            this.k = new nz6(this.d, t06.A0);
            this.l = new oz6(this.d, t06.I0);
            this.m = new xz6(this.d, t06.G0);
            this.n = new pz6(this.d, t06.J0);
            this.o = new uz6(this.d, t06.K0);
            this.p = new rz6(this.d, t06.L0);
            this.q = new tz6(this.d, t06.M0);
            this.r = new lz6(this.d, t06.B0);
            this.s = new kz6(this.d, t06.C0);
            this.t = new jz6(this.d, t06.D0);
            this.u = new e07(this.d, u06.U);
            this.w = new qz6(this.d, t06.q0);
            this.x = new HomePageAlaLiveThreadAdapter(this.d, s06.N0);
            this.I = new f07(this.d, t06.F0);
            this.y = new HomePageAlaFriendRoomAdapter(this.d, s06.O0);
            this.z = new b07(this.d, t06.r0);
            this.A = new a07(this.d, t06.s0);
            this.B = new c07(this.d, t06.u0);
            this.C = new zz6(this.d, t06.t0);
            this.D = new sz6(this.d, t06.j0);
            this.E = new vz6(this.d, t06.v0);
            this.F = new wz6(this.d, t06.w0);
            this.G = new yz6(this.d, u37.d0);
            this.H = new hz6(this.d, o06.N0);
            this.v = new iz6(this.d, t06.E0);
            this.J = new wv6(this.d, t06.x0, (byte) 3);
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
            this.a.add(new ReadProgessDelegetAdapter(this.d, e17.c));
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.a.add(this.A);
            this.a.add(this.C);
            this.a.add(this.B);
            this.a.add(new h07(this.d, s07.e));
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
            this.K = ec8.l().g(this.d, AdvertAppInfo.y, "INDEX");
            this.L = ec8.l().g(this.d, AdvertAppInfo.z, "INDEX");
            this.M = ec8.l().g(this.d, AdvertAppInfo.A, "INDEX");
            this.N = ec8.l().g(this.d, AdvertAppInfo.B, "INDEX");
            this.O = ec8.l().g(this.d, AdvertAppInfo.C, "INDEX");
            this.P = ec8.l().g(this.d, AdvertAppInfo.E, "INDEX");
            this.Q = ec8.l().g(this.d, AdvertAppInfo.D, "INDEX");
            this.a.add(this.K);
            this.a.add(this.L);
            this.a.add(this.M);
            this.a.add(this.N);
            this.a.add(this.O);
            this.a.add(this.P);
            this.a.add(this.Q);
            if (this.d.getPageActivity() instanceof BaseFragmentActivity) {
                this.a.add(ys6.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.H));
                this.a.add(ys6.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.G));
            }
            AdvertAppInfo.v.set(true);
        }
    }

    public void l() {
        vn vnVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (vnVar = this.b) == null) {
            return;
        }
        vnVar.getListAdapter().notifyDataSetChanged();
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
        e07 e07Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (e07Var = this.u) == null) {
            return;
        }
        e07Var.onPause();
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            e07 e07Var = this.u;
            if (e07Var != null) {
                e07Var.onResume();
            }
            if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                return;
            }
            l();
        }
    }

    public final void q(String str) {
        List<cn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || (list = this.a) == null) {
            return;
        }
        for (cn cnVar : list) {
            if (cnVar instanceof vl5) {
                ((vl5) cnVar).g(str);
            }
        }
    }

    public void r(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            for (cn cnVar : this.a) {
                if (cnVar instanceof mu6) {
                    ((mu6) cnVar).s(aVar);
                }
            }
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            sz6 sz6Var = this.h;
            if (sz6Var != null) {
                sz6Var.setFromCDN(z);
                this.D.setFromCDN(z);
                this.w.setFromCDN(z);
                this.z.setFromCDN(z);
            }
            oz6 oz6Var = this.l;
            if (oz6Var != null) {
                oz6Var.setFromCDN(z);
            }
            iz6 iz6Var = this.v;
            if (iz6Var != null) {
                iz6Var.setFromCDN(z);
            }
            cn cnVar = this.L;
            if (cnVar == null || !(cnVar instanceof ac8)) {
                return;
            }
            ((ac8) cnVar).setIsFromCDN(z);
        }
    }

    public void t(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            sz6 sz6Var = this.h;
            if (sz6Var != null) {
                sz6Var.B(bVar);
            }
            xz6 xz6Var = this.m;
            if (xz6Var != null) {
                xz6Var.A(bVar);
            }
            nz6 nz6Var = this.k;
            if (nz6Var != null) {
                nz6Var.y(bVar);
            }
            qz6 qz6Var = this.w;
            if (qz6Var != null) {
                qz6Var.x(bVar);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.x(bVar);
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.x(bVar);
            }
            b07 b07Var = this.z;
            if (b07Var != null) {
                b07Var.x(bVar);
            }
            a07 a07Var = this.A;
            if (a07Var != null) {
                a07Var.C(bVar);
            }
            zz6 zz6Var = this.C;
            if (zz6Var != null) {
                zz6Var.z(bVar);
            }
            c07 c07Var = this.B;
            if (c07Var != null) {
                c07Var.A(bVar);
            }
            sz6 sz6Var2 = this.D;
            if (sz6Var2 != null) {
                sz6Var2.B(bVar);
            }
            vz6 vz6Var = this.E;
            if (vz6Var != null) {
                vz6Var.A(bVar);
            }
            wz6 wz6Var = this.F;
            if (wz6Var != null) {
                wz6Var.z(bVar);
            }
            yz6 yz6Var = this.G;
            if (yz6Var != null) {
                yz6Var.v(bVar);
            }
            hz6 hz6Var = this.H;
            if (hz6Var != null) {
                hz6Var.z(bVar);
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
            gz6 gz6Var = this.g;
            if (gz6Var != null) {
                gz6Var.u(bdUniqueId);
            }
            sz6 sz6Var = this.h;
            if (sz6Var != null) {
                sz6Var.b = bdUniqueId;
            }
            d07 d07Var = this.i;
            if (d07Var != null) {
                d07Var.b = bdUniqueId;
            }
            mz6 mz6Var = this.j;
            if (mz6Var != null) {
                mz6Var.a = bdUniqueId;
            }
            nz6 nz6Var = this.k;
            if (nz6Var != null) {
                nz6Var.a = bdUniqueId;
            }
            oz6 oz6Var = this.l;
            if (oz6Var != null) {
                oz6Var.a = bdUniqueId;
            }
            xz6 xz6Var = this.m;
            if (xz6Var != null) {
                xz6Var.a = bdUniqueId;
            }
            pz6 pz6Var = this.n;
            if (pz6Var != null) {
                pz6Var.a = bdUniqueId;
            }
            uz6 uz6Var = this.o;
            if (uz6Var != null) {
                uz6Var.a = bdUniqueId;
            }
            rz6 rz6Var = this.p;
            if (rz6Var != null) {
                rz6Var.a = bdUniqueId;
            }
            tz6 tz6Var = this.q;
            if (tz6Var != null) {
                tz6Var.a = bdUniqueId;
            }
            lz6 lz6Var = this.r;
            if (lz6Var != null) {
                lz6Var.a = bdUniqueId;
            }
            kz6 kz6Var = this.s;
            if (kz6Var != null) {
                kz6Var.a = bdUniqueId;
            }
            jz6 jz6Var = this.t;
            if (jz6Var != null) {
                jz6Var.a = bdUniqueId;
            }
            qz6 qz6Var = this.w;
            if (qz6Var != null) {
                qz6Var.b = bdUniqueId;
            }
            e07 e07Var = this.u;
            if (e07Var != null) {
                e07Var.a = bdUniqueId;
            }
            fz6 fz6Var = this.e;
            if (fz6Var != null) {
                fz6Var.v(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.a = bdUniqueId;
            }
            f07 f07Var = this.I;
            if (f07Var != null) {
                f07Var.a = bdUniqueId;
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.a = bdUniqueId;
            }
            b07 b07Var = this.z;
            if (b07Var != null) {
                b07Var.b = bdUniqueId;
            }
            a07 a07Var = this.A;
            if (a07Var != null) {
                a07Var.b = bdUniqueId;
            }
            zz6 zz6Var = this.C;
            if (zz6Var != null) {
                zz6Var.b = bdUniqueId;
            }
            c07 c07Var = this.B;
            if (c07Var != null) {
                c07Var.b = bdUniqueId;
            }
            sz6 sz6Var2 = this.D;
            if (sz6Var2 != null) {
                sz6Var2.b = bdUniqueId;
            }
            vz6 vz6Var = this.E;
            if (vz6Var != null) {
                vz6Var.a = bdUniqueId;
            }
            wz6 wz6Var = this.F;
            if (wz6Var != null) {
                wz6Var.a = bdUniqueId;
            }
            yz6 yz6Var = this.G;
            if (yz6Var != null) {
                yz6Var.a = bdUniqueId;
            }
            hz6 hz6Var = this.H;
            if (hz6Var != null) {
                hz6Var.b = bdUniqueId;
            }
            iz6 iz6Var = this.v;
            if (iz6Var != null) {
                iz6Var.a = bdUniqueId;
            }
            wv6 wv6Var = this.J;
            if (wv6Var != null) {
                wv6Var.b = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.R)) {
                for (cn cnVar : this.R) {
                    if (cnVar instanceof ye7) {
                        ((ye7) cnVar).setUniqueId(bdUniqueId);
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

    public void w(a17 a17Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, a17Var) == null) {
            this.h.C(a17Var);
            this.i.B(a17Var);
            this.j.z(a17Var);
            this.l.z(a17Var);
            this.m.B(a17Var);
            this.q.z(a17Var);
            this.r.z(a17Var);
            this.s.z(a17Var);
            this.t.z(a17Var);
            this.u.C(a17Var);
            this.v.A(a17Var);
        }
    }

    public final void x(vn vnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, vnVar) == null) {
            this.i.C(vnVar);
            this.j.A(vnVar);
            this.k.z(vnVar);
            this.l.A(vnVar);
            this.m.C(vnVar);
            this.n.u(vnVar);
            this.o.v(vnVar);
            this.p.u(vnVar);
            this.q.A(vnVar);
            this.r.A(vnVar);
            this.s.A(vnVar);
            this.t.A(vnVar);
            this.v.B(vnVar);
            this.u.D(vnVar);
            this.H.A(vnVar);
            this.A.D(vnVar);
            this.A.D(vnVar);
            this.C.A(vnVar);
            this.J.u(vnVar);
        }
    }

    public void y(List<pn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, list) == null) {
            gk8.f(list, 2);
            this.b.setData(list);
            this.c = list;
            f fVar = this.U;
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    public void z(List<pn> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048597, this, list, i) == null) {
            gk8.f(list, 2);
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
            wg.b(new a(this, list));
            this.c = list;
            f fVar = this.U;
            if (fVar != null) {
                fVar.a();
            }
        }
    }
}
