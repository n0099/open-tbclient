package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.UiUtils;
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
/* loaded from: classes6.dex */
public class i18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c18 A;
    public z08 B;
    public s08 C;
    public w08 D;
    public y08 E;
    public h08 F;
    public f18 G;
    public fw7 H;
    public gw7 I;
    public hw7 J;
    public jw7 K;
    public t08 L;
    public iw7 M;
    public f08 N;
    public lh O;
    public lh P;
    public lh Q;
    public lh R;
    public lh S;

    /* renamed from: T  reason: collision with root package name */
    public lh f1118T;
    public lh U;
    public List<lh> V;
    public boolean W;
    public boolean X;
    public f Y;
    @Nullable
    public ki Z;
    public List<lh> a;
    public CustomMessageListener a0;
    public ei b;
    public CustomMessageListener b0;
    public List<yh> c;
    public CustomMessageListener c0;
    public TbPageContext<?> d;
    public CustomMessageListener d0;
    public e08 e;
    public g18 f;
    public g08 g;
    public s08 h;
    public d18 i;
    public m08 j;
    public n08 k;
    public o08 l;
    public x08 m;
    public p08 n;
    public v08 o;
    public r08 p;
    public u08 q;
    public l08 r;
    public k08 s;
    public j08 t;
    public e18 u;
    public i08 v;
    public q08 w;
    public HomePageAlaLiveThreadAdapter x;
    public b18 y;
    public a18 z;

    /* loaded from: classes6.dex */
    public interface f {
        void a();
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ i18 b;

        /* renamed from: com.baidu.tieba.i18$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0324a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0324a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.b.b.setData(this.a.a);
                    a aVar = this.a;
                    aVar.b.c = aVar.a;
                    if (this.a.b.Y != null) {
                        this.a.b.Y.a();
                    }
                }
            }
        }

        public a(i18 i18Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i18Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i18Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.Z != null) {
                this.b.Z.e(new RunnableC0324a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i18 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(i18 i18Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i18Var, Integer.valueOf(i)};
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
            this.a = i18Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                this.a.i();
                if (this.a.c != null) {
                    i18 i18Var = this.a;
                    i18Var.B(i18Var.c);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i18 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(i18 i18Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i18Var, Integer.valueOf(i)};
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
            this.a = i18Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) == null || updateAttentionMessage.getData() == null || !updateAttentionMessage.getData().isSucc) {
                return;
            }
            this.a.j(updateAttentionMessage.getData());
        }
    }

    /* loaded from: classes6.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i18 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(i18 i18Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i18Var, Integer.valueOf(i)};
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
            this.a = i18Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                sz8 sz8Var = new sz8();
                sz8Var.a = String.valueOf(customResponsedMessage.getData());
                sz8Var.b = true;
                this.a.j(sz8Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i18 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(i18 i18Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i18Var, Integer.valueOf(i)};
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
            this.a = i18Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                sz8 sz8Var = new sz8();
                sz8Var.a = String.valueOf(customResponsedMessage.getData());
                sz8Var.b = false;
                this.a.j(sz8Var);
            }
        }
    }

    public i18(Context context, ei eiVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, eiVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a0 = new b(this, 2016470);
        this.b0 = new c(this, 2001115);
        this.c0 = new d(this, 2001335);
        this.d0 = new e(this, 2001336);
        this.a = new ArrayList();
        this.b = eiVar;
        this.d = (TbPageContext) k4.a(context);
        l(context);
        A(eiVar);
        eiVar.addAdapters(this.a);
        if (eiVar instanceof RecyclerView) {
            this.Z = new ki((RecyclerView) eiVar);
        }
    }

    public void B(List<yh> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            pda.f(list, 2);
            this.b.setData(list);
            this.c = list;
            f fVar = this.Y;
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    public final void D(List<yh> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, list) != null) || list == null) {
            return;
        }
        UiUtils.runOnUiThread(new a(this, list));
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            n();
            this.e.s(i);
        }
    }

    public final void s(String str) {
        List<lh> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, str) != null) || (list = this.a) == null) {
            return;
        }
        for (lh lhVar : list) {
            if (lhVar instanceof yz5) {
                ((yz5) lhVar).g(str);
            }
        }
    }

    public void t(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) {
            for (lh lhVar : this.a) {
                if (lhVar instanceof vu7) {
                    ((vu7) lhVar).s(aVar);
                }
            }
        }
    }

    public void u(vz7 vz7Var) {
        n08 n08Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, vz7Var) == null) && (n08Var = this.k) != null) {
            n08Var.B(vz7Var);
        }
    }

    public void x(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, fVar) == null) {
            this.Y = fVar;
        }
    }

    public final void A(ei eiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eiVar) == null) {
            this.i.E(eiVar);
            this.j.C(eiVar);
            this.k.C(eiVar);
            this.l.C(eiVar);
            this.m.E(eiVar);
            this.n.u(eiVar);
            this.o.x(eiVar);
            this.p.u(eiVar);
            this.q.B(eiVar);
            this.r.D(eiVar);
            this.s.C(eiVar);
            this.t.C(eiVar);
            this.v.D(eiVar);
            this.u.F(eiVar);
            this.F.C(eiVar);
            this.z.F(eiVar);
            this.z.F(eiVar);
            this.B.C(eiVar);
            this.H.u(eiVar);
            this.I.u(eiVar);
            this.J.u(eiVar);
            this.K.u(eiVar);
            this.L.u(eiVar);
            this.M.u(eiVar);
        }
    }

    public void w(NEGFeedBackView.NEGFeedbackEventCallback nEGFeedbackEventCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, nEGFeedbackEventCallback) == null) {
            s08 s08Var = this.h;
            if (s08Var != null) {
                s08Var.D(nEGFeedbackEventCallback);
            }
            x08 x08Var = this.m;
            if (x08Var != null) {
                x08Var.C(nEGFeedbackEventCallback);
            }
            n08 n08Var = this.k;
            if (n08Var != null) {
                n08Var.A(nEGFeedbackEventCallback);
            }
            q08 q08Var = this.w;
            if (q08Var != null) {
                q08Var.z(nEGFeedbackEventCallback);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.z(nEGFeedbackEventCallback);
            }
            b18 b18Var = this.y;
            if (b18Var != null) {
                b18Var.z(nEGFeedbackEventCallback);
            }
            a18 a18Var = this.z;
            if (a18Var != null) {
                a18Var.E(nEGFeedbackEventCallback);
            }
            z08 z08Var = this.B;
            if (z08Var != null) {
                z08Var.B(nEGFeedbackEventCallback);
            }
            c18 c18Var = this.A;
            if (c18Var != null) {
                c18Var.C(nEGFeedbackEventCallback);
            }
            s08 s08Var2 = this.C;
            if (s08Var2 != null) {
                s08Var2.D(nEGFeedbackEventCallback);
            }
            w08 w08Var = this.D;
            if (w08Var != null) {
                w08Var.C(nEGFeedbackEventCallback);
            }
            y08 y08Var = this.E;
            if (y08Var != null) {
                y08Var.x(nEGFeedbackEventCallback);
            }
            h08 h08Var = this.F;
            if (h08Var != null) {
                h08Var.B(nEGFeedbackEventCallback);
            }
        }
    }

    public void C(List<yh> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, list, i) == null) {
            pda.f(list, 2);
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
            D(list);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.X = i();
        }
    }

    public List<yh> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    public void n() {
        ei eiVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (eiVar = this.b) != null) {
            eiVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void q() {
        e18 e18Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (e18Var = this.u) != null) {
            e18Var.onPause();
        }
    }

    public void r() {
        e18 e18Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (e18Var = this.u) != null) {
            e18Var.onResume();
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<lh> list = this.V;
            if (list != null && list.size() > 0) {
                return true;
            }
            this.V = new ArrayList();
            ArrayList<BdUniqueId> g = pda.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                wy8 b2 = a09.d().b(this.d, g.get(i), 2);
                if (this.W) {
                    b2.s(3);
                }
                s08 s08Var = this.h;
                if (s08Var != null && (bdUniqueId = s08Var.b) != null) {
                    b2.setUniqueId(bdUniqueId);
                }
                this.V.add(b2);
            }
            this.b.addAdapters(this.V);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void j(Object obj) {
        List<yh> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, obj) == null) && (list = this.c) != null) {
            boolean z = false;
            for (yh yhVar : list) {
                if ((yhVar instanceof ICardInfo) && ((ICardInfo) yhVar).responseAttention(obj)) {
                    z = true;
                }
            }
            if (z) {
                n();
            }
        }
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            s08 s08Var = this.h;
            if (s08Var != null) {
                s08Var.setFromCDN(z);
                this.C.setFromCDN(z);
                this.w.setFromCDN(z);
                this.y.setFromCDN(z);
            }
            o08 o08Var = this.l;
            if (o08Var != null) {
                o08Var.setFromCDN(z);
            }
            i08 i08Var = this.v;
            if (i08Var != null) {
                i08Var.setFromCDN(z);
            }
            lh lhVar = this.P;
            if (lhVar != null && (lhVar instanceof oz9)) {
                ((oz9) lhVar).setIsFromCDN(z);
            }
        }
    }

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            this.e = new e08(this.d);
            this.f = new g18(this.d);
            this.g = new g08(this.d, q18.b);
            this.h = new s08(this.d, rk6.r0);
            this.i = new d18(this.d, rk6.E0);
            this.j = new m08(this.d, rk6.M0);
            this.k = new n08(this.d, rk6.F0);
            this.l = new o08(this.d, rk6.N0);
            this.m = new x08(this.d, rk6.L0);
            this.n = new p08(this.d, rk6.O0);
            this.o = new v08(this.d, rk6.P0);
            this.p = new r08(this.d, rk6.Q0);
            this.q = new u08(this.d, rk6.R0);
            this.r = new l08(this.d, rk6.G0);
            this.s = new k08(this.d, rk6.H0);
            this.t = new j08(this.d, rk6.I0);
            this.u = new e18(this.d, sk6.U);
            this.w = new q08(this.d, rk6.t0);
            this.x = new HomePageAlaLiveThreadAdapter(this.d, qk6.S0);
            this.G = new f18(this.d, rk6.K0);
            this.y = new b18(this.d, rk6.u0);
            this.z = new a18(this.d, rk6.v0);
            this.A = new c18(this.d, rk6.x0);
            this.B = new z08(this.d, rk6.w0);
            this.C = new s08(this.d, rk6.s0);
            this.D = new w08(this.d, rk6.y0);
            this.E = new y08(this.d, r48.d0);
            this.F = new h08(this.d, mk6.S0);
            this.v = new i08(this.d, rk6.J0);
            this.H = new fw7(this.d, rk6.z0, (byte) 3);
            this.I = new gw7(this.d, rk6.A0, (byte) 3);
            this.J = new hw7(this.d, rk6.B0, (byte) 3);
            this.K = new jw7(this.d, rk6.C0);
            this.N = new f08(this.d, f16.g);
            this.L = new t08(this.d, s18.g);
            this.M = new iw7(this.d, wk6.j);
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
            this.a.add(new ReadProgessDelegetAdapter(this.d, i28.c));
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.a.add(this.B);
            this.a.add(this.A);
            this.a.add(new h18(this.d, u18.h));
            this.a.add(this.D);
            this.a.add(this.E);
            this.a.add(this.F);
            this.a.add(this.v);
            this.a.add(this.H);
            this.a.add(this.I);
            this.a.add(this.J);
            this.a.add(this.K);
            this.a.add(this.L);
            this.a.add(this.M);
            this.a.add(this.G);
            this.a.add(this.N);
            h();
            m();
            s("page_recommend");
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (!ThreadData.isRecAppLoaded.get()) {
                AdvertAppInfo.w.set(false);
                return;
            }
            this.O = tz9.m().h(this.d, AdvertAppInfo.z, "INDEX");
            this.P = tz9.m().h(this.d, AdvertAppInfo.A, "INDEX");
            this.Q = tz9.m().h(this.d, AdvertAppInfo.B, "INDEX");
            this.R = tz9.m().h(this.d, AdvertAppInfo.C, "INDEX");
            this.S = tz9.m().h(this.d, AdvertAppInfo.D, "INDEX");
            this.f1118T = tz9.m().h(this.d, AdvertAppInfo.F, "INDEX");
            this.U = tz9.m().h(this.d, AdvertAppInfo.E, "INDEX");
            this.a.add(this.O);
            this.a.add(this.P);
            this.a.add(this.Q);
            this.a.add(this.R);
            this.a.add(this.S);
            this.a.add(this.f1118T);
            this.a.add(this.U);
            if (this.d.getPageActivity() instanceof BaseFragmentActivity) {
                this.a.add(ws7.h().c((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.I));
                this.a.add(ws7.h().c((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.H));
            }
            AdvertAppInfo.w.set(true);
        }
    }

    public void y(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bdUniqueId) == null) {
            g08 g08Var = this.g;
            if (g08Var != null) {
                g08Var.u(bdUniqueId);
            }
            s08 s08Var = this.h;
            if (s08Var != null) {
                s08Var.b = bdUniqueId;
            }
            d18 d18Var = this.i;
            if (d18Var != null) {
                d18Var.b = bdUniqueId;
            }
            m08 m08Var = this.j;
            if (m08Var != null) {
                m08Var.a = bdUniqueId;
            }
            n08 n08Var = this.k;
            if (n08Var != null) {
                n08Var.a = bdUniqueId;
            }
            o08 o08Var = this.l;
            if (o08Var != null) {
                o08Var.a = bdUniqueId;
            }
            x08 x08Var = this.m;
            if (x08Var != null) {
                x08Var.a = bdUniqueId;
            }
            p08 p08Var = this.n;
            if (p08Var != null) {
                p08Var.a = bdUniqueId;
            }
            v08 v08Var = this.o;
            if (v08Var != null) {
                v08Var.a = bdUniqueId;
            }
            r08 r08Var = this.p;
            if (r08Var != null) {
                r08Var.a = bdUniqueId;
            }
            u08 u08Var = this.q;
            if (u08Var != null) {
                u08Var.a = bdUniqueId;
            }
            l08 l08Var = this.r;
            if (l08Var != null) {
                l08Var.a = bdUniqueId;
            }
            k08 k08Var = this.s;
            if (k08Var != null) {
                k08Var.a = bdUniqueId;
            }
            j08 j08Var = this.t;
            if (j08Var != null) {
                j08Var.a = bdUniqueId;
            }
            q08 q08Var = this.w;
            if (q08Var != null) {
                q08Var.b = bdUniqueId;
            }
            e18 e18Var = this.u;
            if (e18Var != null) {
                e18Var.a = bdUniqueId;
            }
            e08 e08Var = this.e;
            if (e08Var != null) {
                e08Var.x(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.a = bdUniqueId;
            }
            f18 f18Var = this.G;
            if (f18Var != null) {
                f18Var.a = bdUniqueId;
            }
            b18 b18Var = this.y;
            if (b18Var != null) {
                b18Var.b = bdUniqueId;
            }
            a18 a18Var = this.z;
            if (a18Var != null) {
                a18Var.b = bdUniqueId;
            }
            z08 z08Var = this.B;
            if (z08Var != null) {
                z08Var.b = bdUniqueId;
            }
            c18 c18Var = this.A;
            if (c18Var != null) {
                c18Var.b = bdUniqueId;
            }
            s08 s08Var2 = this.C;
            if (s08Var2 != null) {
                s08Var2.b = bdUniqueId;
            }
            w08 w08Var = this.D;
            if (w08Var != null) {
                w08Var.a = bdUniqueId;
            }
            y08 y08Var = this.E;
            if (y08Var != null) {
                y08Var.a = bdUniqueId;
            }
            h08 h08Var = this.F;
            if (h08Var != null) {
                h08Var.b = bdUniqueId;
            }
            i08 i08Var = this.v;
            if (i08Var != null) {
                i08Var.a = bdUniqueId;
            }
            fw7 fw7Var = this.H;
            if (fw7Var != null) {
                fw7Var.b = bdUniqueId;
            }
            gw7 gw7Var = this.I;
            if (gw7Var != null) {
                gw7Var.b = bdUniqueId;
            }
            hw7 hw7Var = this.J;
            if (hw7Var != null) {
                hw7Var.b = bdUniqueId;
            }
            t08 t08Var = this.L;
            if (t08Var != null) {
                t08Var.a = bdUniqueId;
            }
            iw7 iw7Var = this.M;
            if (iw7Var != null) {
                iw7Var.b = bdUniqueId;
            }
            jw7 jw7Var = this.K;
            if (jw7Var != null) {
                jw7Var.b = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.V)) {
                for (lh lhVar : this.V) {
                    if (lhVar instanceof wy8) {
                        ((wy8) lhVar).setUniqueId(bdUniqueId);
                    }
                }
            }
            this.b0.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.b0);
            this.c0.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.c0);
            this.d0.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.d0);
            if (!this.X) {
                this.a0.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.a0);
            }
        }
    }

    public void z(f28 f28Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, f28Var) == null) {
            this.h.E(f28Var);
            this.i.D(f28Var);
            this.j.B(f28Var);
            this.l.B(f28Var);
            this.m.D(f28Var);
            this.q.A(f28Var);
            this.r.C(f28Var);
            this.s.B(f28Var);
            this.t.B(f28Var);
            this.u.E(f28Var);
            this.v.C(f28Var);
        }
    }
}
