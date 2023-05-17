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
/* loaded from: classes5.dex */
public class bv7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public tu7 A;
    public vu7 B;
    public su7 C;
    public lu7 D;
    public ou7 E;
    public pu7 F;
    public ru7 G;
    public au7 H;
    public yu7 I;
    public lq7 J;
    public mq7 K;
    public yt7 L;
    public en M;
    public en N;
    public en O;
    public en P;
    public en Q;
    public en R;
    public en S;
    public List<en> T;
    public boolean U;
    public boolean V;
    public f W;
    public CustomMessageListener X;
    public CustomMessageListener Y;
    public CustomMessageListener Z;
    public List<en> a;
    public CustomMessageListener a0;
    public xn b;
    public List<rn> c;
    public TbPageContext<?> d;
    public xt7 e;
    public zu7 f;
    public zt7 g;
    public lu7 h;
    public wu7 i;
    public fu7 j;
    public gu7 k;
    public hu7 l;
    public qu7 m;
    public iu7 n;
    public nu7 o;
    public ku7 p;
    public mu7 q;
    public eu7 r;
    public du7 s;
    public cu7 t;
    public xu7 u;
    public bu7 v;
    public ju7 w;
    public HomePageAlaLiveThreadAdapter x;
    public HomePageAlaFriendRoomAdapter y;
    public uu7 z;

    /* loaded from: classes5.dex */
    public interface f {
        void a();
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ bv7 b;

        public a(bv7 bv7Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bv7Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bv7Var;
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
        public final /* synthetic */ bv7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(bv7 bv7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bv7Var, Integer.valueOf(i)};
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
            this.a = bv7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                this.a.f();
                if (this.a.c != null) {
                    bv7 bv7Var = this.a;
                    bv7Var.y(bv7Var.c);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bv7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(bv7 bv7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bv7Var, Integer.valueOf(i)};
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
            this.a = bv7Var;
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
        public final /* synthetic */ bv7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(bv7 bv7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bv7Var, Integer.valueOf(i)};
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
            this.a = bv7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                mj8 mj8Var = new mj8();
                mj8Var.a = String.valueOf(customResponsedMessage.getData());
                mj8Var.b = true;
                this.a.g(mj8Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bv7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(bv7 bv7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bv7Var, Integer.valueOf(i)};
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
            this.a = bv7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                mj8 mj8Var = new mj8();
                mj8Var.a = String.valueOf(customResponsedMessage.getData());
                mj8Var.b = false;
                this.a.g(mj8Var);
            }
        }
    }

    public bv7(Context context, xn xnVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, xnVar};
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
        this.b = xnVar;
        this.d = (TbPageContext) m9.a(context);
        j(context);
        x(xnVar);
        xnVar.addAdapters(this.a);
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            l();
            this.e.s(i);
        }
    }

    public final void q(String str) {
        List<en> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, str) != null) || (list = this.a) == null) {
            return;
        }
        for (en enVar : list) {
            if (enVar instanceof c16) {
                ((c16) enVar).g(str);
            }
        }
    }

    public void r(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            for (en enVar : this.a) {
                if (enVar instanceof bp7) {
                    ((bp7) enVar).s(aVar);
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

    public void y(List<rn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, list) == null) {
            qq9.f(list, 2);
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

    public List<rn> h() {
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
        xn xnVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (xnVar = this.b) != null) {
            xnVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void o() {
        xu7 xu7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (xu7Var = this.u) != null) {
            xu7Var.onPause();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            xu7 xu7Var = this.u;
            if (xu7Var != null) {
                xu7Var.onResume();
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
            List<en> list = this.T;
            if (list != null && list.size() > 0) {
                return true;
            }
            this.T = new ArrayList();
            ArrayList<BdUniqueId> g = qq9.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                pi8 b2 = uj8.d().b(this.d, g.get(i), 2);
                if (this.U) {
                    b2.s(3);
                }
                lu7 lu7Var = this.h;
                if (lu7Var != null && (bdUniqueId = lu7Var.b) != null) {
                    b2.setUniqueId(bdUniqueId);
                }
                this.T.add(b2);
            }
            this.b.addAdapters(this.T);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void g(Object obj) {
        List<rn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) && (list = this.c) != null) {
            boolean z = false;
            for (rn rnVar : list) {
                if ((rnVar instanceof ICardInfo) && ((ICardInfo) rnVar).responseAttention(obj)) {
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
            lu7 lu7Var = this.h;
            if (lu7Var != null) {
                lu7Var.setFromCDN(z);
                this.D.setFromCDN(z);
                this.w.setFromCDN(z);
                this.z.setFromCDN(z);
            }
            hu7 hu7Var = this.l;
            if (hu7Var != null) {
                hu7Var.setFromCDN(z);
            }
            bu7 bu7Var = this.v;
            if (bu7Var != null) {
                bu7Var.setFromCDN(z);
            }
            en enVar = this.N;
            if (enVar != null && (enVar instanceof rf9)) {
                ((rf9) enVar).setIsFromCDN(z);
            }
        }
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            this.e = new xt7(this.d);
            this.f = new zu7(this.d);
            this.g = new zt7(this.d, jv7.b);
            this.h = new lu7(this.d, kk6.j0);
            this.i = new wu7(this.d, kk6.C0);
            this.j = new fu7(this.d, kk6.K0);
            this.k = new gu7(this.d, kk6.D0);
            this.l = new hu7(this.d, kk6.L0);
            this.m = new qu7(this.d, kk6.J0);
            this.n = new iu7(this.d, kk6.M0);
            this.o = new nu7(this.d, kk6.N0);
            this.p = new ku7(this.d, kk6.O0);
            this.q = new mu7(this.d, kk6.P0);
            this.r = new eu7(this.d, kk6.E0);
            this.s = new du7(this.d, kk6.F0);
            this.t = new cu7(this.d, kk6.G0);
            this.u = new xu7(this.d, lk6.U);
            this.w = new ju7(this.d, kk6.s0);
            this.x = new HomePageAlaLiveThreadAdapter(this.d, jk6.Q0);
            this.I = new yu7(this.d, kk6.I0);
            this.y = new HomePageAlaFriendRoomAdapter(this.d, jk6.R0);
            this.z = new uu7(this.d, kk6.t0);
            this.A = new tu7(this.d, kk6.u0);
            this.B = new vu7(this.d, kk6.w0);
            this.C = new su7(this.d, kk6.v0);
            this.D = new lu7(this.d, kk6.r0);
            this.E = new ou7(this.d, kk6.x0);
            this.F = new pu7(this.d, kk6.y0);
            this.G = new ru7(this.d, ly7.d0);
            this.H = new au7(this.d, fk6.Q0);
            this.v = new bu7(this.d, kk6.H0);
            this.J = new lq7(this.d, kk6.z0, (byte) 3);
            this.K = new mq7(this.d, kk6.A0, (byte) 3);
            this.L = new yt7(this.d, j26.g);
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
            this.a.add(new ReadProgessDelegetAdapter(this.d, uv7.c));
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.a.add(this.A);
            this.a.add(this.C);
            this.a.add(this.B);
            this.a.add(new av7(this.d, lv7.h));
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
            this.M = wf9.l().g(this.d, AdvertAppInfo.y, "INDEX");
            this.N = wf9.l().g(this.d, AdvertAppInfo.z, "INDEX");
            this.O = wf9.l().g(this.d, AdvertAppInfo.A, "INDEX");
            this.P = wf9.l().g(this.d, AdvertAppInfo.B, "INDEX");
            this.Q = wf9.l().g(this.d, AdvertAppInfo.C, "INDEX");
            this.R = wf9.l().g(this.d, AdvertAppInfo.E, "INDEX");
            this.S = wf9.l().g(this.d, AdvertAppInfo.D, "INDEX");
            this.a.add(this.M);
            this.a.add(this.N);
            this.a.add(this.O);
            this.a.add(this.P);
            this.a.add(this.Q);
            this.a.add(this.R);
            this.a.add(this.S);
            if (this.d.getPageActivity() instanceof BaseFragmentActivity) {
                this.a.add(nn7.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.H));
                this.a.add(nn7.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.G));
            }
            AdvertAppInfo.v.set(true);
        }
    }

    public void t(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            lu7 lu7Var = this.h;
            if (lu7Var != null) {
                lu7Var.D(bVar);
            }
            qu7 qu7Var = this.m;
            if (qu7Var != null) {
                qu7Var.C(bVar);
            }
            gu7 gu7Var = this.k;
            if (gu7Var != null) {
                gu7Var.A(bVar);
            }
            ju7 ju7Var = this.w;
            if (ju7Var != null) {
                ju7Var.z(bVar);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.z(bVar);
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.z(bVar);
            }
            uu7 uu7Var = this.z;
            if (uu7Var != null) {
                uu7Var.z(bVar);
            }
            tu7 tu7Var = this.A;
            if (tu7Var != null) {
                tu7Var.E(bVar);
            }
            su7 su7Var = this.C;
            if (su7Var != null) {
                su7Var.B(bVar);
            }
            vu7 vu7Var = this.B;
            if (vu7Var != null) {
                vu7Var.C(bVar);
            }
            lu7 lu7Var2 = this.D;
            if (lu7Var2 != null) {
                lu7Var2.D(bVar);
            }
            ou7 ou7Var = this.E;
            if (ou7Var != null) {
                ou7Var.C(bVar);
            }
            pu7 pu7Var = this.F;
            if (pu7Var != null) {
                pu7Var.B(bVar);
            }
            ru7 ru7Var = this.G;
            if (ru7Var != null) {
                ru7Var.x(bVar);
            }
            au7 au7Var = this.H;
            if (au7Var != null) {
                au7Var.B(bVar);
            }
        }
    }

    public final void x(xn xnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, xnVar) == null) {
            this.i.E(xnVar);
            this.j.C(xnVar);
            this.k.B(xnVar);
            this.l.C(xnVar);
            this.m.E(xnVar);
            this.n.u(xnVar);
            this.o.x(xnVar);
            this.p.u(xnVar);
            this.q.C(xnVar);
            this.r.C(xnVar);
            this.s.C(xnVar);
            this.t.C(xnVar);
            this.v.D(xnVar);
            this.u.F(xnVar);
            this.H.C(xnVar);
            this.A.F(xnVar);
            this.A.F(xnVar);
            this.C.C(xnVar);
            this.J.u(xnVar);
            this.K.u(xnVar);
        }
    }

    public void v(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bdUniqueId) == null) {
            zt7 zt7Var = this.g;
            if (zt7Var != null) {
                zt7Var.u(bdUniqueId);
            }
            lu7 lu7Var = this.h;
            if (lu7Var != null) {
                lu7Var.b = bdUniqueId;
            }
            wu7 wu7Var = this.i;
            if (wu7Var != null) {
                wu7Var.b = bdUniqueId;
            }
            fu7 fu7Var = this.j;
            if (fu7Var != null) {
                fu7Var.a = bdUniqueId;
            }
            gu7 gu7Var = this.k;
            if (gu7Var != null) {
                gu7Var.a = bdUniqueId;
            }
            hu7 hu7Var = this.l;
            if (hu7Var != null) {
                hu7Var.a = bdUniqueId;
            }
            qu7 qu7Var = this.m;
            if (qu7Var != null) {
                qu7Var.a = bdUniqueId;
            }
            iu7 iu7Var = this.n;
            if (iu7Var != null) {
                iu7Var.a = bdUniqueId;
            }
            nu7 nu7Var = this.o;
            if (nu7Var != null) {
                nu7Var.a = bdUniqueId;
            }
            ku7 ku7Var = this.p;
            if (ku7Var != null) {
                ku7Var.a = bdUniqueId;
            }
            mu7 mu7Var = this.q;
            if (mu7Var != null) {
                mu7Var.a = bdUniqueId;
            }
            eu7 eu7Var = this.r;
            if (eu7Var != null) {
                eu7Var.a = bdUniqueId;
            }
            du7 du7Var = this.s;
            if (du7Var != null) {
                du7Var.a = bdUniqueId;
            }
            cu7 cu7Var = this.t;
            if (cu7Var != null) {
                cu7Var.a = bdUniqueId;
            }
            ju7 ju7Var = this.w;
            if (ju7Var != null) {
                ju7Var.b = bdUniqueId;
            }
            xu7 xu7Var = this.u;
            if (xu7Var != null) {
                xu7Var.a = bdUniqueId;
            }
            xt7 xt7Var = this.e;
            if (xt7Var != null) {
                xt7Var.x(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.a = bdUniqueId;
            }
            yu7 yu7Var = this.I;
            if (yu7Var != null) {
                yu7Var.a = bdUniqueId;
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.a = bdUniqueId;
            }
            uu7 uu7Var = this.z;
            if (uu7Var != null) {
                uu7Var.b = bdUniqueId;
            }
            tu7 tu7Var = this.A;
            if (tu7Var != null) {
                tu7Var.b = bdUniqueId;
            }
            su7 su7Var = this.C;
            if (su7Var != null) {
                su7Var.b = bdUniqueId;
            }
            vu7 vu7Var = this.B;
            if (vu7Var != null) {
                vu7Var.b = bdUniqueId;
            }
            lu7 lu7Var2 = this.D;
            if (lu7Var2 != null) {
                lu7Var2.b = bdUniqueId;
            }
            ou7 ou7Var = this.E;
            if (ou7Var != null) {
                ou7Var.a = bdUniqueId;
            }
            pu7 pu7Var = this.F;
            if (pu7Var != null) {
                pu7Var.a = bdUniqueId;
            }
            ru7 ru7Var = this.G;
            if (ru7Var != null) {
                ru7Var.a = bdUniqueId;
            }
            au7 au7Var = this.H;
            if (au7Var != null) {
                au7Var.b = bdUniqueId;
            }
            bu7 bu7Var = this.v;
            if (bu7Var != null) {
                bu7Var.a = bdUniqueId;
            }
            lq7 lq7Var = this.J;
            if (lq7Var != null) {
                lq7Var.b = bdUniqueId;
            }
            mq7 mq7Var = this.K;
            if (mq7Var != null) {
                mq7Var.b = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.T)) {
                for (en enVar : this.T) {
                    if (enVar instanceof pi8) {
                        ((pi8) enVar).setUniqueId(bdUniqueId);
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

    public void w(rv7 rv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, rv7Var) == null) {
            this.h.E(rv7Var);
            this.i.D(rv7Var);
            this.j.B(rv7Var);
            this.l.B(rv7Var);
            this.m.D(rv7Var);
            this.q.B(rv7Var);
            this.r.B(rv7Var);
            this.s.B(rv7Var);
            this.t.B(rv7Var);
            this.u.E(rv7Var);
            this.v.C(rv7Var);
        }
    }

    public void z(List<rn> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048597, this, list, i) == null) {
            qq9.f(list, 2);
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
            wg.e(new a(this, list));
            this.c = list;
            f fVar = this.W;
            if (fVar != null) {
                fVar.a();
            }
        }
    }
}
