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
public class b18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public v08 A;
    public s08 B;
    public m08 C;
    public p08 D;
    public r08 E;
    public b08 F;
    public y08 G;
    public hw7 H;
    public iw7 I;
    public jw7 J;
    public zz7 K;
    public jn L;
    public jn M;
    public jn N;
    public jn O;
    public jn P;
    public jn Q;
    public jn R;
    public List<jn> S;

    /* renamed from: T  reason: collision with root package name */
    public boolean f1089T;
    public boolean U;
    public f V;
    public CustomMessageListener W;
    public CustomMessageListener X;
    public CustomMessageListener Y;
    public CustomMessageListener Z;
    public List<jn> a;
    public co b;
    public List<wn> c;
    public TbPageContext<?> d;
    public yz7 e;
    public z08 f;
    public a08 g;
    public m08 h;
    public w08 i;
    public g08 j;
    public h08 k;
    public i08 l;
    public q08 m;
    public j08 n;
    public o08 o;
    public l08 p;
    public n08 q;
    public f08 r;
    public e08 s;
    public d08 t;
    public x08 u;
    public c08 v;
    public k08 w;
    public HomePageAlaLiveThreadAdapter x;
    public u08 y;
    public t08 z;

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
        public final /* synthetic */ b18 b;

        public a(b18 b18Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b18Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = b18Var;
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
        public final /* synthetic */ b18 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(b18 b18Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b18Var, Integer.valueOf(i)};
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
            this.a = b18Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                this.a.f();
                if (this.a.c != null) {
                    b18 b18Var = this.a;
                    b18Var.z(b18Var.c);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b18 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(b18 b18Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b18Var, Integer.valueOf(i)};
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
            this.a = b18Var;
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
        public final /* synthetic */ b18 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(b18 b18Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b18Var, Integer.valueOf(i)};
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
            this.a = b18Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                hq8 hq8Var = new hq8();
                hq8Var.a = String.valueOf(customResponsedMessage.getData());
                hq8Var.b = true;
                this.a.g(hq8Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b18 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(b18 b18Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b18Var, Integer.valueOf(i)};
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
            this.a = b18Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                hq8 hq8Var = new hq8();
                hq8Var.a = String.valueOf(customResponsedMessage.getData());
                hq8Var.b = false;
                this.a.g(hq8Var);
            }
        }
    }

    public b18(Context context, co coVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, coVar};
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
        this.b = coVar;
        this.d = (TbPageContext) q9.a(context);
        j(context);
        y(coVar);
        coVar.addAdapters(this.a);
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            l();
            this.e.s(i);
        }
    }

    public final void q(String str) {
        List<jn> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, str) != null) || (list = this.a) == null) {
            return;
        }
        for (jn jnVar : list) {
            if (jnVar instanceof k56) {
                ((k56) jnVar).g(str);
            }
        }
    }

    public void r(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
            for (jn jnVar : this.a) {
                if (jnVar instanceof yu7) {
                    ((yu7) jnVar).s(aVar);
                }
            }
        }
    }

    public void s(qz7 qz7Var) {
        h08 h08Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, qz7Var) == null) && (h08Var = this.k) != null) {
            h08Var.B(qz7Var);
        }
    }

    public void v(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, fVar) == null) {
            this.V = fVar;
        }
    }

    public void z(List<wn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, list) == null) {
            az9.f(list, 2);
            this.b.setData(list);
            this.c = list;
            f fVar = this.V;
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    public void A(List<wn> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, list, i) == null) {
            az9.f(list, 2);
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
            bh.e(new a(this, list));
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

    public List<wn> h() {
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
        co coVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (coVar = this.b) != null) {
            coVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void o() {
        x08 x08Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (x08Var = this.u) != null) {
            x08Var.onPause();
        }
    }

    public void p() {
        x08 x08Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (x08Var = this.u) != null) {
            x08Var.onResume();
        }
    }

    public final boolean f() {
        InterceptResult invokeV;
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<jn> list = this.S;
            if (list != null && list.size() > 0) {
                return true;
            }
            this.S = new ArrayList();
            ArrayList<BdUniqueId> g = az9.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                kp8 b2 = pq8.d().b(this.d, g.get(i), 2);
                if (this.f1089T) {
                    b2.s(3);
                }
                m08 m08Var = this.h;
                if (m08Var != null && (bdUniqueId = m08Var.b) != null) {
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
        List<wn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, obj) == null) && (list = this.c) != null) {
            boolean z = false;
            for (wn wnVar : list) {
                if ((wnVar instanceof ICardInfo) && ((ICardInfo) wnVar).responseAttention(obj)) {
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
            m08 m08Var = this.h;
            if (m08Var != null) {
                m08Var.setFromCDN(z);
                this.C.setFromCDN(z);
                this.w.setFromCDN(z);
                this.y.setFromCDN(z);
            }
            i08 i08Var = this.l;
            if (i08Var != null) {
                i08Var.setFromCDN(z);
            }
            c08 c08Var = this.v;
            if (c08Var != null) {
                c08Var.setFromCDN(z);
            }
            jn jnVar = this.M;
            if (jnVar != null && (jnVar instanceof wn9)) {
                ((wn9) jnVar).setIsFromCDN(z);
            }
        }
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            this.e = new yz7(this.d);
            this.f = new z08(this.d);
            this.g = new a08(this.d, j18.b);
            this.h = new m08(this.d, bp6.r0);
            this.i = new w08(this.d, bp6.D0);
            this.j = new g08(this.d, bp6.L0);
            this.k = new h08(this.d, bp6.E0);
            this.l = new i08(this.d, bp6.M0);
            this.m = new q08(this.d, bp6.K0);
            this.n = new j08(this.d, bp6.N0);
            this.o = new o08(this.d, bp6.O0);
            this.p = new l08(this.d, bp6.P0);
            this.q = new n08(this.d, bp6.Q0);
            this.r = new f08(this.d, bp6.F0);
            this.s = new e08(this.d, bp6.G0);
            this.t = new d08(this.d, bp6.H0);
            this.u = new x08(this.d, cp6.U);
            this.w = new k08(this.d, bp6.t0);
            this.x = new HomePageAlaLiveThreadAdapter(this.d, ap6.R0);
            this.G = new y08(this.d, bp6.J0);
            this.y = new u08(this.d, bp6.u0);
            this.z = new t08(this.d, bp6.v0);
            this.A = new v08(this.d, bp6.x0);
            this.B = new s08(this.d, bp6.w0);
            this.C = new m08(this.d, bp6.s0);
            this.D = new p08(this.d, bp6.y0);
            this.E = new r08(this.d, t48.d0);
            this.F = new b08(this.d, wo6.R0);
            this.v = new c08(this.d, bp6.I0);
            this.H = new hw7(this.d, bp6.z0, (byte) 3);
            this.I = new iw7(this.d, bp6.A0, (byte) 3);
            this.J = new jw7(this.d, bp6.B0, (byte) 3);
            this.K = new zz7(this.d, r66.g);
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
            this.a.add(new ReadProgessDelegetAdapter(this.d, w18.c));
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.a.add(this.B);
            this.a.add(this.A);
            this.a.add(new a18(this.d, m18.h));
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
            this.L = bo9.l().g(this.d, AdvertAppInfo.y, "INDEX");
            this.M = bo9.l().g(this.d, AdvertAppInfo.z, "INDEX");
            this.N = bo9.l().g(this.d, AdvertAppInfo.A, "INDEX");
            this.O = bo9.l().g(this.d, AdvertAppInfo.B, "INDEX");
            this.P = bo9.l().g(this.d, AdvertAppInfo.C, "INDEX");
            this.Q = bo9.l().g(this.d, AdvertAppInfo.E, "INDEX");
            this.R = bo9.l().g(this.d, AdvertAppInfo.D, "INDEX");
            this.a.add(this.L);
            this.a.add(this.M);
            this.a.add(this.N);
            this.a.add(this.O);
            this.a.add(this.P);
            this.a.add(this.Q);
            this.a.add(this.R);
            if (this.d.getPageActivity() instanceof BaseFragmentActivity) {
                this.a.add(bt7.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.H));
                this.a.add(bt7.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.G));
            }
            AdvertAppInfo.v.set(true);
        }
    }

    public void u(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) {
            m08 m08Var = this.h;
            if (m08Var != null) {
                m08Var.D(bVar);
            }
            q08 q08Var = this.m;
            if (q08Var != null) {
                q08Var.C(bVar);
            }
            h08 h08Var = this.k;
            if (h08Var != null) {
                h08Var.A(bVar);
            }
            k08 k08Var = this.w;
            if (k08Var != null) {
                k08Var.z(bVar);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.z(bVar);
            }
            u08 u08Var = this.y;
            if (u08Var != null) {
                u08Var.z(bVar);
            }
            t08 t08Var = this.z;
            if (t08Var != null) {
                t08Var.E(bVar);
            }
            s08 s08Var = this.B;
            if (s08Var != null) {
                s08Var.B(bVar);
            }
            v08 v08Var = this.A;
            if (v08Var != null) {
                v08Var.C(bVar);
            }
            m08 m08Var2 = this.C;
            if (m08Var2 != null) {
                m08Var2.D(bVar);
            }
            p08 p08Var = this.D;
            if (p08Var != null) {
                p08Var.C(bVar);
            }
            r08 r08Var = this.E;
            if (r08Var != null) {
                r08Var.x(bVar);
            }
            b08 b08Var = this.F;
            if (b08Var != null) {
                b08Var.B(bVar);
            }
        }
    }

    public final void y(co coVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, coVar) == null) {
            this.i.E(coVar);
            this.j.C(coVar);
            this.k.C(coVar);
            this.l.C(coVar);
            this.m.E(coVar);
            this.n.u(coVar);
            this.o.x(coVar);
            this.p.u(coVar);
            this.q.C(coVar);
            this.r.C(coVar);
            this.s.C(coVar);
            this.t.C(coVar);
            this.v.D(coVar);
            this.u.F(coVar);
            this.F.C(coVar);
            this.z.F(coVar);
            this.z.F(coVar);
            this.B.C(coVar);
            this.H.u(coVar);
            this.I.u(coVar);
            this.J.u(coVar);
        }
    }

    public void w(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bdUniqueId) == null) {
            a08 a08Var = this.g;
            if (a08Var != null) {
                a08Var.u(bdUniqueId);
            }
            m08 m08Var = this.h;
            if (m08Var != null) {
                m08Var.b = bdUniqueId;
            }
            w08 w08Var = this.i;
            if (w08Var != null) {
                w08Var.b = bdUniqueId;
            }
            g08 g08Var = this.j;
            if (g08Var != null) {
                g08Var.a = bdUniqueId;
            }
            h08 h08Var = this.k;
            if (h08Var != null) {
                h08Var.a = bdUniqueId;
            }
            i08 i08Var = this.l;
            if (i08Var != null) {
                i08Var.a = bdUniqueId;
            }
            q08 q08Var = this.m;
            if (q08Var != null) {
                q08Var.a = bdUniqueId;
            }
            j08 j08Var = this.n;
            if (j08Var != null) {
                j08Var.a = bdUniqueId;
            }
            o08 o08Var = this.o;
            if (o08Var != null) {
                o08Var.a = bdUniqueId;
            }
            l08 l08Var = this.p;
            if (l08Var != null) {
                l08Var.a = bdUniqueId;
            }
            n08 n08Var = this.q;
            if (n08Var != null) {
                n08Var.a = bdUniqueId;
            }
            f08 f08Var = this.r;
            if (f08Var != null) {
                f08Var.a = bdUniqueId;
            }
            e08 e08Var = this.s;
            if (e08Var != null) {
                e08Var.a = bdUniqueId;
            }
            d08 d08Var = this.t;
            if (d08Var != null) {
                d08Var.a = bdUniqueId;
            }
            k08 k08Var = this.w;
            if (k08Var != null) {
                k08Var.b = bdUniqueId;
            }
            x08 x08Var = this.u;
            if (x08Var != null) {
                x08Var.a = bdUniqueId;
            }
            yz7 yz7Var = this.e;
            if (yz7Var != null) {
                yz7Var.x(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.a = bdUniqueId;
            }
            y08 y08Var = this.G;
            if (y08Var != null) {
                y08Var.a = bdUniqueId;
            }
            u08 u08Var = this.y;
            if (u08Var != null) {
                u08Var.b = bdUniqueId;
            }
            t08 t08Var = this.z;
            if (t08Var != null) {
                t08Var.b = bdUniqueId;
            }
            s08 s08Var = this.B;
            if (s08Var != null) {
                s08Var.b = bdUniqueId;
            }
            v08 v08Var = this.A;
            if (v08Var != null) {
                v08Var.b = bdUniqueId;
            }
            m08 m08Var2 = this.C;
            if (m08Var2 != null) {
                m08Var2.b = bdUniqueId;
            }
            p08 p08Var = this.D;
            if (p08Var != null) {
                p08Var.a = bdUniqueId;
            }
            r08 r08Var = this.E;
            if (r08Var != null) {
                r08Var.a = bdUniqueId;
            }
            b08 b08Var = this.F;
            if (b08Var != null) {
                b08Var.b = bdUniqueId;
            }
            c08 c08Var = this.v;
            if (c08Var != null) {
                c08Var.a = bdUniqueId;
            }
            hw7 hw7Var = this.H;
            if (hw7Var != null) {
                hw7Var.b = bdUniqueId;
            }
            iw7 iw7Var = this.I;
            if (iw7Var != null) {
                iw7Var.b = bdUniqueId;
            }
            jw7 jw7Var = this.J;
            if (jw7Var != null) {
                jw7Var.b = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.S)) {
                for (jn jnVar : this.S) {
                    if (jnVar instanceof kp8) {
                        ((kp8) jnVar).setUniqueId(bdUniqueId);
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

    public void x(t18 t18Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, t18Var) == null) {
            this.h.E(t18Var);
            this.i.D(t18Var);
            this.j.B(t18Var);
            this.l.B(t18Var);
            this.m.D(t18Var);
            this.q.B(t18Var);
            this.r.B(t18Var);
            this.s.B(t18Var);
            this.t.B(t18Var);
            this.u.E(t18Var);
            this.v.C(t18Var);
        }
    }
}
