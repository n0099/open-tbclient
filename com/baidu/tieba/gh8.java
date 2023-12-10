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
public class gh8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yg8 A;
    public ah8 B;
    public xg8 C;
    public pg8 D;
    public tg8 E;
    public wg8 F;
    public eg8 G;
    public dh8 H;
    public bc8 I;
    public cc8 J;
    public dc8 K;
    public fc8 L;
    public qg8 M;
    public ec8 N;
    public cg8 O;
    public ci P;
    public ci Q;
    public ci R;
    public ci S;

    /* renamed from: T  reason: collision with root package name */
    public ci f1100T;
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
    public bg8 e;
    public CustomMessageListener e0;
    public eh8 f;
    public dg8 g;
    public pg8 h;
    public bh8 i;
    public jg8 j;
    public kg8 k;
    public lg8 l;
    public vg8 m;
    public ug8 n;
    public mg8 o;
    public sg8 p;
    public og8 q;
    public rg8 r;
    public ig8 s;
    public hg8 t;
    public gg8 u;
    public ch8 v;
    public fg8 w;
    public ng8 x;
    public HomePageAlaLiveThreadAdapter y;
    public zg8 z;

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
        public final /* synthetic */ gh8 b;

        /* renamed from: com.baidu.tieba.gh8$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0297a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0297a(a aVar) {
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

        public a(gh8 gh8Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gh8Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gh8Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a0 != null) {
                this.b.a0.e(new RunnableC0297a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gh8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(gh8 gh8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gh8Var, Integer.valueOf(i)};
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
            this.a = gh8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                this.a.i();
                if (this.a.c != null) {
                    gh8 gh8Var = this.a;
                    gh8Var.B(gh8Var.c);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gh8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(gh8 gh8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gh8Var, Integer.valueOf(i)};
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
            this.a = gh8Var;
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
        public final /* synthetic */ gh8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(gh8 gh8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gh8Var, Integer.valueOf(i)};
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
            this.a = gh8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                sg9 sg9Var = new sg9();
                sg9Var.a = String.valueOf(customResponsedMessage.getData());
                sg9Var.b = true;
                this.a.j(sg9Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gh8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(gh8 gh8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gh8Var, Integer.valueOf(i)};
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
            this.a = gh8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                sg9 sg9Var = new sg9();
                sg9Var.a = String.valueOf(customResponsedMessage.getData());
                sg9Var.b = false;
                this.a.j(sg9Var);
            }
        }
    }

    public gh8(Context context, vi viVar) {
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
            if (ciVar instanceof e26) {
                ((e26) ciVar).g(str);
            }
        }
    }

    public void t(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) {
            for (ci ciVar : this.a) {
                if (ciVar instanceof qa8) {
                    ((qa8) ciVar).t(aVar);
                }
            }
        }
    }

    public void u(sf8 sf8Var) {
        kg8 kg8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, sf8Var) == null) && (kg8Var = this.k) != null) {
            kg8Var.C(sf8Var);
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
            pg8 pg8Var = this.h;
            if (pg8Var != null) {
                pg8Var.E(nEGFeedbackEventCallback);
            }
            vg8 vg8Var = this.m;
            if (vg8Var != null) {
                vg8Var.D(nEGFeedbackEventCallback);
            }
            kg8 kg8Var = this.k;
            if (kg8Var != null) {
                kg8Var.B(nEGFeedbackEventCallback);
            }
            ng8 ng8Var = this.x;
            if (ng8Var != null) {
                ng8Var.A(nEGFeedbackEventCallback);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.y;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.A(nEGFeedbackEventCallback);
            }
            zg8 zg8Var = this.z;
            if (zg8Var != null) {
                zg8Var.A(nEGFeedbackEventCallback);
            }
            yg8 yg8Var = this.A;
            if (yg8Var != null) {
                yg8Var.F(nEGFeedbackEventCallback);
            }
            xg8 xg8Var = this.C;
            if (xg8Var != null) {
                xg8Var.C(nEGFeedbackEventCallback);
            }
            ah8 ah8Var = this.B;
            if (ah8Var != null) {
                ah8Var.D(nEGFeedbackEventCallback);
            }
            pg8 pg8Var2 = this.D;
            if (pg8Var2 != null) {
                pg8Var2.E(nEGFeedbackEventCallback);
            }
            tg8 tg8Var = this.E;
            if (tg8Var != null) {
                tg8Var.D(nEGFeedbackEventCallback);
            }
            wg8 wg8Var = this.F;
            if (wg8Var != null) {
                wg8Var.y(nEGFeedbackEventCallback);
            }
            eg8 eg8Var = this.G;
            if (eg8Var != null) {
                eg8Var.C(nEGFeedbackEventCallback);
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
        ch8 ch8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (ch8Var = this.v) != null) {
            ch8Var.onPause();
        }
    }

    public void r() {
        ch8 ch8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (ch8Var = this.v) != null) {
            ch8Var.onResume();
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
                wf9 b2 = ah9.d().b(this.d, g.get(i), 2);
                if (this.X) {
                    b2.t(3);
                }
                pg8 pg8Var = this.h;
                if (pg8Var != null && (bdUniqueId = pg8Var.b) != null) {
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
            pg8 pg8Var = this.h;
            if (pg8Var != null) {
                pg8Var.setFromCDN(z);
                this.D.setFromCDN(z);
                this.x.setFromCDN(z);
                this.z.setFromCDN(z);
            }
            lg8 lg8Var = this.l;
            if (lg8Var != null) {
                lg8Var.setFromCDN(z);
            }
            fg8 fg8Var = this.w;
            if (fg8Var != null) {
                fg8Var.setFromCDN(z);
            }
            ci ciVar = this.Q;
            if (ciVar != null && (ciVar instanceof rha)) {
                ((rha) ciVar).setIsFromCDN(z);
            }
        }
    }

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            this.e = new bg8(this.d);
            this.f = new eh8(this.d);
            this.g = new dg8(this.d, oh8.b);
            this.h = new pg8(this.d, dn6.r0);
            this.i = new bh8(this.d, dn6.E0);
            this.j = new jg8(this.d, dn6.M0);
            this.k = new kg8(this.d, dn6.F0);
            this.l = new lg8(this.d, dn6.N0);
            this.m = new vg8(this.d, dn6.L0);
            this.n = new ug8(this.d, zm6.a);
            this.o = new mg8(this.d, dn6.O0);
            this.p = new sg8(this.d, dn6.P0);
            this.q = new og8(this.d, dn6.Q0);
            this.r = new rg8(this.d, dn6.R0);
            this.s = new ig8(this.d, dn6.G0);
            this.t = new hg8(this.d, dn6.H0);
            this.u = new gg8(this.d, dn6.I0);
            this.v = new ch8(this.d, en6.U);
            this.x = new ng8(this.d, dn6.t0);
            this.y = new HomePageAlaLiveThreadAdapter(this.d, cn6.S0);
            this.H = new dh8(this.d, dn6.K0);
            this.z = new zg8(this.d, dn6.u0);
            this.A = new yg8(this.d, dn6.v0);
            this.B = new ah8(this.d, dn6.x0);
            this.C = new xg8(this.d, dn6.w0);
            this.D = new pg8(this.d, dn6.s0);
            this.E = new tg8(this.d, dn6.y0);
            this.F = new wg8(this.d, pk8.d0);
            this.G = new eg8(this.d, xm6.S0);
            this.w = new fg8(this.d, dn6.J0);
            this.I = new bc8(this.d, dn6.z0, (byte) 3);
            this.J = new cc8(this.d, dn6.A0, (byte) 3);
            this.K = new dc8(this.d, dn6.B0, (byte) 3);
            this.L = new fc8(this.d, dn6.C0);
            this.O = new cg8(this.d, l36.g);
            this.M = new qg8(this.d, qh8.h);
            this.N = new ec8(this.d, in6.j);
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
            this.a.add(new ReadProgessDelegetAdapter(this.d, gi8.c));
            this.a.add(this.y);
            this.a.add(this.z);
            this.a.add(this.A);
            this.a.add(this.C);
            this.a.add(this.B);
            this.a.add(new fh8(this.d, sh8.h));
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
            this.P = wha.m().h(this.d, AdvertAppInfo.A, "INDEX");
            this.Q = wha.m().h(this.d, AdvertAppInfo.B, "INDEX");
            this.R = wha.m().h(this.d, AdvertAppInfo.C, "INDEX");
            this.S = wha.m().h(this.d, AdvertAppInfo.D, "INDEX");
            this.f1100T = wha.m().h(this.d, AdvertAppInfo.E, "INDEX");
            this.U = wha.m().h(this.d, AdvertAppInfo.G, "INDEX");
            this.V = wha.m().h(this.d, AdvertAppInfo.F, "INDEX");
            this.a.add(this.P);
            this.a.add(this.Q);
            this.a.add(this.R);
            this.a.add(this.S);
            this.a.add(this.f1100T);
            this.a.add(this.U);
            this.a.add(this.V);
            if (this.d.getPageActivity() instanceof BaseFragmentActivity) {
                this.a.add(r88.h().c((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.J));
                this.a.add(r88.h().c((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.I));
            }
            AdvertAppInfo.x.set(true);
        }
    }

    public void y(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bdUniqueId) == null) {
            dg8 dg8Var = this.g;
            if (dg8Var != null) {
                dg8Var.x(bdUniqueId);
            }
            pg8 pg8Var = this.h;
            if (pg8Var != null) {
                pg8Var.b = bdUniqueId;
            }
            bh8 bh8Var = this.i;
            if (bh8Var != null) {
                bh8Var.b = bdUniqueId;
            }
            jg8 jg8Var = this.j;
            if (jg8Var != null) {
                jg8Var.a = bdUniqueId;
            }
            kg8 kg8Var = this.k;
            if (kg8Var != null) {
                kg8Var.a = bdUniqueId;
            }
            lg8 lg8Var = this.l;
            if (lg8Var != null) {
                lg8Var.a = bdUniqueId;
            }
            vg8 vg8Var = this.m;
            if (vg8Var != null) {
                vg8Var.a = bdUniqueId;
            }
            mg8 mg8Var = this.o;
            if (mg8Var != null) {
                mg8Var.a = bdUniqueId;
            }
            sg8 sg8Var = this.p;
            if (sg8Var != null) {
                sg8Var.a = bdUniqueId;
            }
            og8 og8Var = this.q;
            if (og8Var != null) {
                og8Var.a = bdUniqueId;
            }
            rg8 rg8Var = this.r;
            if (rg8Var != null) {
                rg8Var.a = bdUniqueId;
            }
            ig8 ig8Var = this.s;
            if (ig8Var != null) {
                ig8Var.a = bdUniqueId;
            }
            hg8 hg8Var = this.t;
            if (hg8Var != null) {
                hg8Var.a = bdUniqueId;
            }
            gg8 gg8Var = this.u;
            if (gg8Var != null) {
                gg8Var.a = bdUniqueId;
            }
            ng8 ng8Var = this.x;
            if (ng8Var != null) {
                ng8Var.b = bdUniqueId;
            }
            ch8 ch8Var = this.v;
            if (ch8Var != null) {
                ch8Var.a = bdUniqueId;
            }
            bg8 bg8Var = this.e;
            if (bg8Var != null) {
                bg8Var.y(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.y;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.a = bdUniqueId;
            }
            dh8 dh8Var = this.H;
            if (dh8Var != null) {
                dh8Var.a = bdUniqueId;
            }
            zg8 zg8Var = this.z;
            if (zg8Var != null) {
                zg8Var.b = bdUniqueId;
            }
            yg8 yg8Var = this.A;
            if (yg8Var != null) {
                yg8Var.b = bdUniqueId;
            }
            xg8 xg8Var = this.C;
            if (xg8Var != null) {
                xg8Var.b = bdUniqueId;
            }
            ah8 ah8Var = this.B;
            if (ah8Var != null) {
                ah8Var.b = bdUniqueId;
            }
            pg8 pg8Var2 = this.D;
            if (pg8Var2 != null) {
                pg8Var2.b = bdUniqueId;
            }
            tg8 tg8Var = this.E;
            if (tg8Var != null) {
                tg8Var.a = bdUniqueId;
            }
            wg8 wg8Var = this.F;
            if (wg8Var != null) {
                wg8Var.a = bdUniqueId;
            }
            eg8 eg8Var = this.G;
            if (eg8Var != null) {
                eg8Var.b = bdUniqueId;
            }
            fg8 fg8Var = this.w;
            if (fg8Var != null) {
                fg8Var.a = bdUniqueId;
            }
            bc8 bc8Var = this.I;
            if (bc8Var != null) {
                bc8Var.b = bdUniqueId;
            }
            cc8 cc8Var = this.J;
            if (cc8Var != null) {
                cc8Var.b = bdUniqueId;
            }
            dc8 dc8Var = this.K;
            if (dc8Var != null) {
                dc8Var.b = bdUniqueId;
            }
            qg8 qg8Var = this.M;
            if (qg8Var != null) {
                qg8Var.a = bdUniqueId;
            }
            ec8 ec8Var = this.N;
            if (ec8Var != null) {
                ec8Var.b = bdUniqueId;
            }
            fc8 fc8Var = this.L;
            if (fc8Var != null) {
                fc8Var.b = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.W)) {
                for (ci ciVar : this.W) {
                    if (ciVar instanceof wf9) {
                        ((wf9) ciVar).setUniqueId(bdUniqueId);
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

    public void z(di8 di8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, di8Var) == null) {
            this.h.F(di8Var);
            this.i.E(di8Var);
            this.j.C(di8Var);
            this.l.C(di8Var);
            this.m.E(di8Var);
            this.r.B(di8Var);
            this.s.D(di8Var);
            this.t.C(di8Var);
            this.u.C(di8Var);
            this.v.F(di8Var);
            this.w.D(di8Var);
        }
    }
}
