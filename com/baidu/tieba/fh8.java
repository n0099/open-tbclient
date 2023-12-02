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
public class fh8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xg8 A;
    public zg8 B;
    public wg8 C;
    public og8 D;
    public sg8 E;
    public vg8 F;
    public dg8 G;
    public ch8 H;
    public ac8 I;
    public bc8 J;
    public cc8 K;
    public ec8 L;
    public pg8 M;
    public dc8 N;
    public bg8 O;
    public ci P;
    public ci Q;
    public ci R;
    public ci S;

    /* renamed from: T  reason: collision with root package name */
    public ci f1093T;
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
    public ag8 e;
    public CustomMessageListener e0;
    public dh8 f;
    public cg8 g;
    public og8 h;
    public ah8 i;
    public ig8 j;
    public jg8 k;
    public kg8 l;
    public ug8 m;
    public tg8 n;
    public lg8 o;
    public rg8 p;
    public ng8 q;
    public qg8 r;
    public hg8 s;
    public gg8 t;
    public fg8 u;
    public bh8 v;
    public eg8 w;
    public mg8 x;
    public HomePageAlaLiveThreadAdapter y;
    public yg8 z;

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
        public final /* synthetic */ fh8 b;

        /* renamed from: com.baidu.tieba.fh8$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0276a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0276a(a aVar) {
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

        public a(fh8 fh8Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fh8Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fh8Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a0 != null) {
                this.b.a0.e(new RunnableC0276a(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fh8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(fh8 fh8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fh8Var, Integer.valueOf(i)};
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
            this.a = fh8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                this.a.i();
                if (this.a.c != null) {
                    fh8 fh8Var = this.a;
                    fh8Var.B(fh8Var.c);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fh8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(fh8 fh8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fh8Var, Integer.valueOf(i)};
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
            this.a = fh8Var;
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
        public final /* synthetic */ fh8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(fh8 fh8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fh8Var, Integer.valueOf(i)};
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
            this.a = fh8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                rg9 rg9Var = new rg9();
                rg9Var.a = String.valueOf(customResponsedMessage.getData());
                rg9Var.b = true;
                this.a.j(rg9Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fh8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(fh8 fh8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fh8Var, Integer.valueOf(i)};
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
            this.a = fh8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                rg9 rg9Var = new rg9();
                rg9Var.a = String.valueOf(customResponsedMessage.getData());
                rg9Var.b = false;
                this.a.j(rg9Var);
            }
        }
    }

    public fh8(Context context, vi viVar) {
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
            nva.f(list, 2);
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
                if (ciVar instanceof pa8) {
                    ((pa8) ciVar).t(aVar);
                }
            }
        }
    }

    public void u(rf8 rf8Var) {
        jg8 jg8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, rf8Var) == null) && (jg8Var = this.k) != null) {
            jg8Var.C(rf8Var);
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
            og8 og8Var = this.h;
            if (og8Var != null) {
                og8Var.E(nEGFeedbackEventCallback);
            }
            ug8 ug8Var = this.m;
            if (ug8Var != null) {
                ug8Var.D(nEGFeedbackEventCallback);
            }
            jg8 jg8Var = this.k;
            if (jg8Var != null) {
                jg8Var.B(nEGFeedbackEventCallback);
            }
            mg8 mg8Var = this.x;
            if (mg8Var != null) {
                mg8Var.A(nEGFeedbackEventCallback);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.y;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.A(nEGFeedbackEventCallback);
            }
            yg8 yg8Var = this.z;
            if (yg8Var != null) {
                yg8Var.A(nEGFeedbackEventCallback);
            }
            xg8 xg8Var = this.A;
            if (xg8Var != null) {
                xg8Var.F(nEGFeedbackEventCallback);
            }
            wg8 wg8Var = this.C;
            if (wg8Var != null) {
                wg8Var.C(nEGFeedbackEventCallback);
            }
            zg8 zg8Var = this.B;
            if (zg8Var != null) {
                zg8Var.D(nEGFeedbackEventCallback);
            }
            og8 og8Var2 = this.D;
            if (og8Var2 != null) {
                og8Var2.E(nEGFeedbackEventCallback);
            }
            sg8 sg8Var = this.E;
            if (sg8Var != null) {
                sg8Var.D(nEGFeedbackEventCallback);
            }
            vg8 vg8Var = this.F;
            if (vg8Var != null) {
                vg8Var.y(nEGFeedbackEventCallback);
            }
            dg8 dg8Var = this.G;
            if (dg8Var != null) {
                dg8Var.C(nEGFeedbackEventCallback);
            }
        }
    }

    public void C(List<pi> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, list, i) == null) {
            nva.f(list, 2);
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
        bh8 bh8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (bh8Var = this.v) != null) {
            bh8Var.onPause();
        }
    }

    public void r() {
        bh8 bh8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (bh8Var = this.v) != null) {
            bh8Var.onResume();
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
            ArrayList<BdUniqueId> g = nva.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                vf9 b2 = zg9.d().b(this.d, g.get(i), 2);
                if (this.X) {
                    b2.t(3);
                }
                og8 og8Var = this.h;
                if (og8Var != null && (bdUniqueId = og8Var.b) != null) {
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
            og8 og8Var = this.h;
            if (og8Var != null) {
                og8Var.setFromCDN(z);
                this.D.setFromCDN(z);
                this.x.setFromCDN(z);
                this.z.setFromCDN(z);
            }
            kg8 kg8Var = this.l;
            if (kg8Var != null) {
                kg8Var.setFromCDN(z);
            }
            eg8 eg8Var = this.w;
            if (eg8Var != null) {
                eg8Var.setFromCDN(z);
            }
            ci ciVar = this.Q;
            if (ciVar != null && (ciVar instanceof qha)) {
                ((qha) ciVar).setIsFromCDN(z);
            }
        }
    }

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            this.e = new ag8(this.d);
            this.f = new dh8(this.d);
            this.g = new cg8(this.d, nh8.b);
            this.h = new og8(this.d, dn6.r0);
            this.i = new ah8(this.d, dn6.E0);
            this.j = new ig8(this.d, dn6.M0);
            this.k = new jg8(this.d, dn6.F0);
            this.l = new kg8(this.d, dn6.N0);
            this.m = new ug8(this.d, dn6.L0);
            this.n = new tg8(this.d, zm6.a);
            this.o = new lg8(this.d, dn6.O0);
            this.p = new rg8(this.d, dn6.P0);
            this.q = new ng8(this.d, dn6.Q0);
            this.r = new qg8(this.d, dn6.R0);
            this.s = new hg8(this.d, dn6.G0);
            this.t = new gg8(this.d, dn6.H0);
            this.u = new fg8(this.d, dn6.I0);
            this.v = new bh8(this.d, en6.U);
            this.x = new mg8(this.d, dn6.t0);
            this.y = new HomePageAlaLiveThreadAdapter(this.d, cn6.S0);
            this.H = new ch8(this.d, dn6.K0);
            this.z = new yg8(this.d, dn6.u0);
            this.A = new xg8(this.d, dn6.v0);
            this.B = new zg8(this.d, dn6.x0);
            this.C = new wg8(this.d, dn6.w0);
            this.D = new og8(this.d, dn6.s0);
            this.E = new sg8(this.d, dn6.y0);
            this.F = new vg8(this.d, ok8.d0);
            this.G = new dg8(this.d, xm6.S0);
            this.w = new eg8(this.d, dn6.J0);
            this.I = new ac8(this.d, dn6.z0, (byte) 3);
            this.J = new bc8(this.d, dn6.A0, (byte) 3);
            this.K = new cc8(this.d, dn6.B0, (byte) 3);
            this.L = new ec8(this.d, dn6.C0);
            this.O = new bg8(this.d, l36.g);
            this.M = new pg8(this.d, ph8.h);
            this.N = new dc8(this.d, in6.j);
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
            this.a.add(new ReadProgessDelegetAdapter(this.d, fi8.c));
            this.a.add(this.y);
            this.a.add(this.z);
            this.a.add(this.A);
            this.a.add(this.C);
            this.a.add(this.B);
            this.a.add(new eh8(this.d, rh8.h));
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
            this.P = vha.m().h(this.d, AdvertAppInfo.A, "INDEX");
            this.Q = vha.m().h(this.d, AdvertAppInfo.B, "INDEX");
            this.R = vha.m().h(this.d, AdvertAppInfo.C, "INDEX");
            this.S = vha.m().h(this.d, AdvertAppInfo.D, "INDEX");
            this.f1093T = vha.m().h(this.d, AdvertAppInfo.E, "INDEX");
            this.U = vha.m().h(this.d, AdvertAppInfo.G, "INDEX");
            this.V = vha.m().h(this.d, AdvertAppInfo.F, "INDEX");
            this.a.add(this.P);
            this.a.add(this.Q);
            this.a.add(this.R);
            this.a.add(this.S);
            this.a.add(this.f1093T);
            this.a.add(this.U);
            this.a.add(this.V);
            if (this.d.getPageActivity() instanceof BaseFragmentActivity) {
                this.a.add(q88.h().c((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.J));
                this.a.add(q88.h().c((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.I));
            }
            AdvertAppInfo.x.set(true);
        }
    }

    public void y(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bdUniqueId) == null) {
            cg8 cg8Var = this.g;
            if (cg8Var != null) {
                cg8Var.x(bdUniqueId);
            }
            og8 og8Var = this.h;
            if (og8Var != null) {
                og8Var.b = bdUniqueId;
            }
            ah8 ah8Var = this.i;
            if (ah8Var != null) {
                ah8Var.b = bdUniqueId;
            }
            ig8 ig8Var = this.j;
            if (ig8Var != null) {
                ig8Var.a = bdUniqueId;
            }
            jg8 jg8Var = this.k;
            if (jg8Var != null) {
                jg8Var.a = bdUniqueId;
            }
            kg8 kg8Var = this.l;
            if (kg8Var != null) {
                kg8Var.a = bdUniqueId;
            }
            ug8 ug8Var = this.m;
            if (ug8Var != null) {
                ug8Var.a = bdUniqueId;
            }
            lg8 lg8Var = this.o;
            if (lg8Var != null) {
                lg8Var.a = bdUniqueId;
            }
            rg8 rg8Var = this.p;
            if (rg8Var != null) {
                rg8Var.a = bdUniqueId;
            }
            ng8 ng8Var = this.q;
            if (ng8Var != null) {
                ng8Var.a = bdUniqueId;
            }
            qg8 qg8Var = this.r;
            if (qg8Var != null) {
                qg8Var.a = bdUniqueId;
            }
            hg8 hg8Var = this.s;
            if (hg8Var != null) {
                hg8Var.a = bdUniqueId;
            }
            gg8 gg8Var = this.t;
            if (gg8Var != null) {
                gg8Var.a = bdUniqueId;
            }
            fg8 fg8Var = this.u;
            if (fg8Var != null) {
                fg8Var.a = bdUniqueId;
            }
            mg8 mg8Var = this.x;
            if (mg8Var != null) {
                mg8Var.b = bdUniqueId;
            }
            bh8 bh8Var = this.v;
            if (bh8Var != null) {
                bh8Var.a = bdUniqueId;
            }
            ag8 ag8Var = this.e;
            if (ag8Var != null) {
                ag8Var.y(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.y;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.a = bdUniqueId;
            }
            ch8 ch8Var = this.H;
            if (ch8Var != null) {
                ch8Var.a = bdUniqueId;
            }
            yg8 yg8Var = this.z;
            if (yg8Var != null) {
                yg8Var.b = bdUniqueId;
            }
            xg8 xg8Var = this.A;
            if (xg8Var != null) {
                xg8Var.b = bdUniqueId;
            }
            wg8 wg8Var = this.C;
            if (wg8Var != null) {
                wg8Var.b = bdUniqueId;
            }
            zg8 zg8Var = this.B;
            if (zg8Var != null) {
                zg8Var.b = bdUniqueId;
            }
            og8 og8Var2 = this.D;
            if (og8Var2 != null) {
                og8Var2.b = bdUniqueId;
            }
            sg8 sg8Var = this.E;
            if (sg8Var != null) {
                sg8Var.a = bdUniqueId;
            }
            vg8 vg8Var = this.F;
            if (vg8Var != null) {
                vg8Var.a = bdUniqueId;
            }
            dg8 dg8Var = this.G;
            if (dg8Var != null) {
                dg8Var.b = bdUniqueId;
            }
            eg8 eg8Var = this.w;
            if (eg8Var != null) {
                eg8Var.a = bdUniqueId;
            }
            ac8 ac8Var = this.I;
            if (ac8Var != null) {
                ac8Var.b = bdUniqueId;
            }
            bc8 bc8Var = this.J;
            if (bc8Var != null) {
                bc8Var.b = bdUniqueId;
            }
            cc8 cc8Var = this.K;
            if (cc8Var != null) {
                cc8Var.b = bdUniqueId;
            }
            pg8 pg8Var = this.M;
            if (pg8Var != null) {
                pg8Var.a = bdUniqueId;
            }
            dc8 dc8Var = this.N;
            if (dc8Var != null) {
                dc8Var.b = bdUniqueId;
            }
            ec8 ec8Var = this.L;
            if (ec8Var != null) {
                ec8Var.b = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.W)) {
                for (ci ciVar : this.W) {
                    if (ciVar instanceof vf9) {
                        ((vf9) ciVar).setUniqueId(bdUniqueId);
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

    public void z(ci8 ci8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, ci8Var) == null) {
            this.h.F(ci8Var);
            this.i.E(ci8Var);
            this.j.C(ci8Var);
            this.l.C(ci8Var);
            this.m.E(ci8Var);
            this.r.B(ci8Var);
            this.s.D(ci8Var);
            this.t.C(ci8Var);
            this.u.C(ci8Var);
            this.v.F(ci8Var);
            this.w.D(ci8Var);
        }
    }
}
