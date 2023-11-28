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
/* loaded from: classes5.dex */
public class bh8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public tg8 A;
    public vg8 B;
    public sg8 C;
    public kg8 D;
    public og8 E;
    public rg8 F;
    public zf8 G;
    public yg8 H;
    public wb8 I;
    public xb8 J;
    public yb8 K;
    public ac8 L;
    public lg8 M;
    public zb8 N;
    public xf8 O;
    public ci P;
    public ci Q;
    public ci R;
    public ci S;

    /* renamed from: T  reason: collision with root package name */
    public ci f1086T;
    public ci U;
    public ci V;
    public List<ci> W;
    public boolean X;
    public boolean Y;
    public f Z;
    public List<ci> a;
    @Nullable
    public bj a0;
    public vi b;
    public CustomMessageListener b0;
    public List<pi> c;
    public CustomMessageListener c0;
    public TbPageContext<?> d;
    public CustomMessageListener d0;
    public wf8 e;
    public CustomMessageListener e0;
    public zg8 f;
    public yf8 g;
    public kg8 h;
    public wg8 i;
    public eg8 j;
    public fg8 k;
    public gg8 l;
    public qg8 m;
    public pg8 n;
    public hg8 o;
    public ng8 p;
    public jg8 q;
    public mg8 r;
    public dg8 s;
    public cg8 t;
    public bg8 u;
    public xg8 v;
    public ag8 w;
    public ig8 x;
    public HomePageAlaLiveThreadAdapter y;
    public ug8 z;

    /* loaded from: classes5.dex */
    public interface f {
        void a();
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ bh8 b;

        /* renamed from: com.baidu.tieba.bh8$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0245a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0245a(a aVar) {
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
                    if (this.a.b.Z != null) {
                        this.a.b.Z.a();
                    }
                }
            }
        }

        public a(bh8 bh8Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bh8Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bh8Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a0 != null) {
                this.b.a0.e(new RunnableC0245a(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bh8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(bh8 bh8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bh8Var, Integer.valueOf(i)};
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
            this.a = bh8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                this.a.i();
                if (this.a.c != null) {
                    bh8 bh8Var = this.a;
                    bh8Var.B(bh8Var.c);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bh8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(bh8 bh8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bh8Var, Integer.valueOf(i)};
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
            this.a = bh8Var;
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

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bh8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(bh8 bh8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bh8Var, Integer.valueOf(i)};
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
            this.a = bh8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                ng9 ng9Var = new ng9();
                ng9Var.a = String.valueOf(customResponsedMessage.getData());
                ng9Var.b = true;
                this.a.j(ng9Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bh8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(bh8 bh8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bh8Var, Integer.valueOf(i)};
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
            this.a = bh8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                ng9 ng9Var = new ng9();
                ng9Var.a = String.valueOf(customResponsedMessage.getData());
                ng9Var.b = false;
                this.a.j(ng9Var);
            }
        }
    }

    public bh8(Context context, vi viVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b0 = new b(this, 2016470);
        this.c0 = new c(this, 2001115);
        this.d0 = new d(this, 2001335);
        this.e0 = new e(this, 2001336);
        this.a = new ArrayList();
        this.b = viVar;
        this.d = (TbPageContext) a5.a(context);
        l(context);
        A(viVar);
        viVar.addAdapters(this.a);
        if (viVar instanceof RecyclerView) {
            this.a0 = new bj((RecyclerView) viVar);
        }
    }

    public void B(List<pi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            ova.f(list, 2);
            this.b.setData(list);
            this.c = list;
            f fVar = this.Z;
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    public final void D(List<pi> list) {
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
            this.e.t(i);
        }
    }

    public final void s(String str) {
        List<ci> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, str) != null) || (list = this.a) == null) {
            return;
        }
        for (ci ciVar : list) {
            if (ciVar instanceof a26) {
                ((a26) ciVar).g(str);
            }
        }
    }

    public void t(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) {
            for (ci ciVar : this.a) {
                if (ciVar instanceof la8) {
                    ((la8) ciVar).t(aVar);
                }
            }
        }
    }

    public void u(nf8 nf8Var) {
        fg8 fg8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, nf8Var) == null) && (fg8Var = this.k) != null) {
            fg8Var.C(nf8Var);
        }
    }

    public void x(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, fVar) == null) {
            this.Z = fVar;
        }
    }

    public final void A(vi viVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, viVar) == null) {
            this.i.F(viVar);
            this.j.D(viVar);
            this.k.D(viVar);
            this.l.D(viVar);
            this.m.F(viVar);
            this.o.x(viVar);
            this.p.y(viVar);
            this.q.x(viVar);
            this.r.C(viVar);
            this.s.E(viVar);
            this.t.D(viVar);
            this.u.D(viVar);
            this.w.E(viVar);
            this.v.G(viVar);
            this.G.D(viVar);
            this.A.G(viVar);
            this.A.G(viVar);
            this.C.D(viVar);
            this.I.x(viVar);
            this.J.x(viVar);
            this.K.x(viVar);
            this.L.x(viVar);
            this.M.x(viVar);
            this.N.x(viVar);
        }
    }

    public void w(NEGFeedBackView.NEGFeedbackEventCallback nEGFeedbackEventCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, nEGFeedbackEventCallback) == null) {
            kg8 kg8Var = this.h;
            if (kg8Var != null) {
                kg8Var.E(nEGFeedbackEventCallback);
            }
            qg8 qg8Var = this.m;
            if (qg8Var != null) {
                qg8Var.D(nEGFeedbackEventCallback);
            }
            fg8 fg8Var = this.k;
            if (fg8Var != null) {
                fg8Var.B(nEGFeedbackEventCallback);
            }
            ig8 ig8Var = this.x;
            if (ig8Var != null) {
                ig8Var.A(nEGFeedbackEventCallback);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.y;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.A(nEGFeedbackEventCallback);
            }
            ug8 ug8Var = this.z;
            if (ug8Var != null) {
                ug8Var.A(nEGFeedbackEventCallback);
            }
            tg8 tg8Var = this.A;
            if (tg8Var != null) {
                tg8Var.F(nEGFeedbackEventCallback);
            }
            sg8 sg8Var = this.C;
            if (sg8Var != null) {
                sg8Var.C(nEGFeedbackEventCallback);
            }
            vg8 vg8Var = this.B;
            if (vg8Var != null) {
                vg8Var.D(nEGFeedbackEventCallback);
            }
            kg8 kg8Var2 = this.D;
            if (kg8Var2 != null) {
                kg8Var2.E(nEGFeedbackEventCallback);
            }
            og8 og8Var = this.E;
            if (og8Var != null) {
                og8Var.D(nEGFeedbackEventCallback);
            }
            rg8 rg8Var = this.F;
            if (rg8Var != null) {
                rg8Var.y(nEGFeedbackEventCallback);
            }
            zf8 zf8Var = this.G;
            if (zf8Var != null) {
                zf8Var.C(nEGFeedbackEventCallback);
            }
        }
    }

    public void C(List<pi> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, list, i) == null) {
            ova.f(list, 2);
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
            this.Y = i();
        }
    }

    public List<pi> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    public void n() {
        vi viVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (viVar = this.b) != null) {
            viVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void q() {
        xg8 xg8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (xg8Var = this.v) != null) {
            xg8Var.onPause();
        }
    }

    public void r() {
        xg8 xg8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (xg8Var = this.v) != null) {
            xg8Var.onResume();
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<ci> list = this.W;
            if (list != null && list.size() > 0) {
                return true;
            }
            this.W = new ArrayList();
            ArrayList<BdUniqueId> g = ova.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                rf9 b2 = vg9.d().b(this.d, g.get(i), 2);
                if (this.X) {
                    b2.t(3);
                }
                kg8 kg8Var = this.h;
                if (kg8Var != null && (bdUniqueId = kg8Var.b) != null) {
                    b2.setUniqueId(bdUniqueId);
                }
                this.W.add(b2);
            }
            this.b.addAdapters(this.W);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void j(Object obj) {
        List<pi> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, obj) == null) && (list = this.c) != null) {
            boolean z = false;
            for (pi piVar : list) {
                if ((piVar instanceof ICardInfo) && ((ICardInfo) piVar).responseAttention(obj)) {
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
            kg8 kg8Var = this.h;
            if (kg8Var != null) {
                kg8Var.setFromCDN(z);
                this.D.setFromCDN(z);
                this.x.setFromCDN(z);
                this.z.setFromCDN(z);
            }
            gg8 gg8Var = this.l;
            if (gg8Var != null) {
                gg8Var.setFromCDN(z);
            }
            ag8 ag8Var = this.w;
            if (ag8Var != null) {
                ag8Var.setFromCDN(z);
            }
            ci ciVar = this.Q;
            if (ciVar != null && (ciVar instanceof mha)) {
                ((mha) ciVar).setIsFromCDN(z);
            }
        }
    }

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            this.e = new wf8(this.d);
            this.f = new zg8(this.d);
            this.g = new yf8(this.d, jh8.b);
            this.h = new kg8(this.d, zm6.r0);
            this.i = new wg8(this.d, zm6.E0);
            this.j = new eg8(this.d, zm6.M0);
            this.k = new fg8(this.d, zm6.F0);
            this.l = new gg8(this.d, zm6.N0);
            this.m = new qg8(this.d, zm6.L0);
            this.n = new pg8(this.d, vm6.a);
            this.o = new hg8(this.d, zm6.O0);
            this.p = new ng8(this.d, zm6.P0);
            this.q = new jg8(this.d, zm6.Q0);
            this.r = new mg8(this.d, zm6.R0);
            this.s = new dg8(this.d, zm6.G0);
            this.t = new cg8(this.d, zm6.H0);
            this.u = new bg8(this.d, zm6.I0);
            this.v = new xg8(this.d, an6.U);
            this.x = new ig8(this.d, zm6.t0);
            this.y = new HomePageAlaLiveThreadAdapter(this.d, ym6.S0);
            this.H = new yg8(this.d, zm6.K0);
            this.z = new ug8(this.d, zm6.u0);
            this.A = new tg8(this.d, zm6.v0);
            this.B = new vg8(this.d, zm6.x0);
            this.C = new sg8(this.d, zm6.w0);
            this.D = new kg8(this.d, zm6.s0);
            this.E = new og8(this.d, zm6.y0);
            this.F = new rg8(this.d, kk8.d0);
            this.G = new zf8(this.d, tm6.S0);
            this.w = new ag8(this.d, zm6.J0);
            this.I = new wb8(this.d, zm6.z0, (byte) 3);
            this.J = new xb8(this.d, zm6.A0, (byte) 3);
            this.K = new yb8(this.d, zm6.B0, (byte) 3);
            this.L = new ac8(this.d, zm6.C0);
            this.O = new xf8(this.d, h36.g);
            this.M = new lg8(this.d, lh8.h);
            this.N = new zb8(this.d, en6.j);
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
            this.a.add(this.v);
            this.a.add(this.x);
            this.a.add(this.D);
            this.a.add(new ReadProgessDelegetAdapter(this.d, bi8.c));
            this.a.add(this.y);
            this.a.add(this.z);
            this.a.add(this.A);
            this.a.add(this.C);
            this.a.add(this.B);
            this.a.add(new ah8(this.d, nh8.h));
            this.a.add(this.E);
            this.a.add(this.F);
            this.a.add(this.G);
            this.a.add(this.w);
            this.a.add(this.I);
            this.a.add(this.J);
            this.a.add(this.K);
            this.a.add(this.L);
            this.a.add(this.M);
            this.a.add(this.N);
            this.a.add(this.H);
            this.a.add(this.O);
            h();
            m();
            s("page_recommend");
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (!ThreadData.isRecAppLoaded.get()) {
                AdvertAppInfo.x.set(false);
                return;
            }
            this.P = rha.m().h(this.d, AdvertAppInfo.A, "INDEX");
            this.Q = rha.m().h(this.d, AdvertAppInfo.B, "INDEX");
            this.R = rha.m().h(this.d, AdvertAppInfo.C, "INDEX");
            this.S = rha.m().h(this.d, AdvertAppInfo.D, "INDEX");
            this.f1086T = rha.m().h(this.d, AdvertAppInfo.E, "INDEX");
            this.U = rha.m().h(this.d, AdvertAppInfo.G, "INDEX");
            this.V = rha.m().h(this.d, AdvertAppInfo.F, "INDEX");
            this.a.add(this.P);
            this.a.add(this.Q);
            this.a.add(this.R);
            this.a.add(this.S);
            this.a.add(this.f1086T);
            this.a.add(this.U);
            this.a.add(this.V);
            if (this.d.getPageActivity() instanceof BaseFragmentActivity) {
                this.a.add(m88.h().c((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.J));
                this.a.add(m88.h().c((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.I));
            }
            AdvertAppInfo.x.set(true);
        }
    }

    public void y(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bdUniqueId) == null) {
            yf8 yf8Var = this.g;
            if (yf8Var != null) {
                yf8Var.x(bdUniqueId);
            }
            kg8 kg8Var = this.h;
            if (kg8Var != null) {
                kg8Var.b = bdUniqueId;
            }
            wg8 wg8Var = this.i;
            if (wg8Var != null) {
                wg8Var.b = bdUniqueId;
            }
            eg8 eg8Var = this.j;
            if (eg8Var != null) {
                eg8Var.a = bdUniqueId;
            }
            fg8 fg8Var = this.k;
            if (fg8Var != null) {
                fg8Var.a = bdUniqueId;
            }
            gg8 gg8Var = this.l;
            if (gg8Var != null) {
                gg8Var.a = bdUniqueId;
            }
            qg8 qg8Var = this.m;
            if (qg8Var != null) {
                qg8Var.a = bdUniqueId;
            }
            hg8 hg8Var = this.o;
            if (hg8Var != null) {
                hg8Var.a = bdUniqueId;
            }
            ng8 ng8Var = this.p;
            if (ng8Var != null) {
                ng8Var.a = bdUniqueId;
            }
            jg8 jg8Var = this.q;
            if (jg8Var != null) {
                jg8Var.a = bdUniqueId;
            }
            mg8 mg8Var = this.r;
            if (mg8Var != null) {
                mg8Var.a = bdUniqueId;
            }
            dg8 dg8Var = this.s;
            if (dg8Var != null) {
                dg8Var.a = bdUniqueId;
            }
            cg8 cg8Var = this.t;
            if (cg8Var != null) {
                cg8Var.a = bdUniqueId;
            }
            bg8 bg8Var = this.u;
            if (bg8Var != null) {
                bg8Var.a = bdUniqueId;
            }
            ig8 ig8Var = this.x;
            if (ig8Var != null) {
                ig8Var.b = bdUniqueId;
            }
            xg8 xg8Var = this.v;
            if (xg8Var != null) {
                xg8Var.a = bdUniqueId;
            }
            wf8 wf8Var = this.e;
            if (wf8Var != null) {
                wf8Var.y(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.y;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.a = bdUniqueId;
            }
            yg8 yg8Var = this.H;
            if (yg8Var != null) {
                yg8Var.a = bdUniqueId;
            }
            ug8 ug8Var = this.z;
            if (ug8Var != null) {
                ug8Var.b = bdUniqueId;
            }
            tg8 tg8Var = this.A;
            if (tg8Var != null) {
                tg8Var.b = bdUniqueId;
            }
            sg8 sg8Var = this.C;
            if (sg8Var != null) {
                sg8Var.b = bdUniqueId;
            }
            vg8 vg8Var = this.B;
            if (vg8Var != null) {
                vg8Var.b = bdUniqueId;
            }
            kg8 kg8Var2 = this.D;
            if (kg8Var2 != null) {
                kg8Var2.b = bdUniqueId;
            }
            og8 og8Var = this.E;
            if (og8Var != null) {
                og8Var.a = bdUniqueId;
            }
            rg8 rg8Var = this.F;
            if (rg8Var != null) {
                rg8Var.a = bdUniqueId;
            }
            zf8 zf8Var = this.G;
            if (zf8Var != null) {
                zf8Var.b = bdUniqueId;
            }
            ag8 ag8Var = this.w;
            if (ag8Var != null) {
                ag8Var.a = bdUniqueId;
            }
            wb8 wb8Var = this.I;
            if (wb8Var != null) {
                wb8Var.b = bdUniqueId;
            }
            xb8 xb8Var = this.J;
            if (xb8Var != null) {
                xb8Var.b = bdUniqueId;
            }
            yb8 yb8Var = this.K;
            if (yb8Var != null) {
                yb8Var.b = bdUniqueId;
            }
            lg8 lg8Var = this.M;
            if (lg8Var != null) {
                lg8Var.a = bdUniqueId;
            }
            zb8 zb8Var = this.N;
            if (zb8Var != null) {
                zb8Var.b = bdUniqueId;
            }
            ac8 ac8Var = this.L;
            if (ac8Var != null) {
                ac8Var.b = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.W)) {
                for (ci ciVar : this.W) {
                    if (ciVar instanceof rf9) {
                        ((rf9) ciVar).setUniqueId(bdUniqueId);
                    }
                }
            }
            this.c0.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.c0);
            this.d0.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.d0);
            this.e0.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.e0);
            if (!this.Y) {
                this.b0.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.b0);
            }
        }
    }

    public void z(yh8 yh8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, yh8Var) == null) {
            this.h.F(yh8Var);
            this.i.E(yh8Var);
            this.j.C(yh8Var);
            this.l.C(yh8Var);
            this.m.E(yh8Var);
            this.r.B(yh8Var);
            this.s.D(yh8Var);
            this.t.C(yh8Var);
            this.u.C(yh8Var);
            this.v.F(yh8Var);
            this.w.D(yh8Var);
        }
    }
}
