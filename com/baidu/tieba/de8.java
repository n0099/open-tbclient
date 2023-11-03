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
public class de8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xd8 A;
    public ud8 B;
    public nd8 C;
    public rd8 D;
    public td8 E;
    public cd8 F;
    public ae8 G;
    public a98 H;
    public b98 I;
    public c98 J;
    public e98 K;
    public od8 L;
    public d98 M;
    public ad8 N;
    public bi O;
    public bi P;
    public bi Q;
    public bi R;
    public bi S;

    /* renamed from: T  reason: collision with root package name */
    public bi f1092T;
    public bi U;
    public List<bi> V;
    public boolean W;
    public boolean X;
    public f Y;
    @Nullable
    public aj Z;
    public List<bi> a;
    public CustomMessageListener a0;
    public ui b;
    public CustomMessageListener b0;
    public List<oi> c;
    public CustomMessageListener c0;
    public TbPageContext<?> d;
    public CustomMessageListener d0;
    public zc8 e;
    public be8 f;
    public bd8 g;
    public nd8 h;
    public yd8 i;
    public hd8 j;
    public id8 k;
    public jd8 l;
    public sd8 m;
    public kd8 n;
    public qd8 o;
    public md8 p;
    public pd8 q;
    public gd8 r;
    public fd8 s;
    public ed8 t;
    public zd8 u;
    public dd8 v;
    public ld8 w;
    public HomePageAlaLiveThreadAdapter x;
    public wd8 y;
    public vd8 z;

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
        public final /* synthetic */ de8 b;

        /* renamed from: com.baidu.tieba.de8$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0259a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0259a(a aVar) {
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

        public a(de8 de8Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {de8Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = de8Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.Z != null) {
                this.b.Z.e(new RunnableC0259a(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ de8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(de8 de8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {de8Var, Integer.valueOf(i)};
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
            this.a = de8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                this.a.i();
                if (this.a.c != null) {
                    de8 de8Var = this.a;
                    de8Var.B(de8Var.c);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ de8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(de8 de8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {de8Var, Integer.valueOf(i)};
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
            this.a = de8Var;
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
        public final /* synthetic */ de8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(de8 de8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {de8Var, Integer.valueOf(i)};
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
            this.a = de8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                wc9 wc9Var = new wc9();
                wc9Var.a = String.valueOf(customResponsedMessage.getData());
                wc9Var.b = true;
                this.a.j(wc9Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ de8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(de8 de8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {de8Var, Integer.valueOf(i)};
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
            this.a = de8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                wc9 wc9Var = new wc9();
                wc9Var.a = String.valueOf(customResponsedMessage.getData());
                wc9Var.b = false;
                this.a.j(wc9Var);
            }
        }
    }

    public de8(Context context, ui uiVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, uiVar};
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
        this.b = uiVar;
        this.d = (TbPageContext) a5.a(context);
        l(context);
        A(uiVar);
        uiVar.addAdapters(this.a);
        if (uiVar instanceof RecyclerView) {
            this.Z = new aj((RecyclerView) uiVar);
        }
    }

    public void B(List<oi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            uqa.f(list, 2);
            this.b.setData(list);
            this.c = list;
            f fVar = this.Y;
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    public final void D(List<oi> list) {
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
        List<bi> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, str) != null) || (list = this.a) == null) {
            return;
        }
        for (bi biVar : list) {
            if (biVar instanceof s16) {
                ((s16) biVar).g(str);
            }
        }
    }

    public void t(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) {
            for (bi biVar : this.a) {
                if (biVar instanceof q78) {
                    ((q78) biVar).t(aVar);
                }
            }
        }
    }

    public void u(qc8 qc8Var) {
        id8 id8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, qc8Var) == null) && (id8Var = this.k) != null) {
            id8Var.C(qc8Var);
        }
    }

    public void x(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, fVar) == null) {
            this.Y = fVar;
        }
    }

    public final void A(ui uiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, uiVar) == null) {
            this.i.F(uiVar);
            this.j.D(uiVar);
            this.k.D(uiVar);
            this.l.D(uiVar);
            this.m.F(uiVar);
            this.n.x(uiVar);
            this.o.y(uiVar);
            this.p.x(uiVar);
            this.q.C(uiVar);
            this.r.E(uiVar);
            this.s.D(uiVar);
            this.t.D(uiVar);
            this.v.E(uiVar);
            this.u.G(uiVar);
            this.F.D(uiVar);
            this.z.G(uiVar);
            this.z.G(uiVar);
            this.B.D(uiVar);
            this.H.x(uiVar);
            this.I.x(uiVar);
            this.J.x(uiVar);
            this.K.x(uiVar);
            this.L.x(uiVar);
            this.M.x(uiVar);
        }
    }

    public void w(NEGFeedBackView.NEGFeedbackEventCallback nEGFeedbackEventCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, nEGFeedbackEventCallback) == null) {
            nd8 nd8Var = this.h;
            if (nd8Var != null) {
                nd8Var.E(nEGFeedbackEventCallback);
            }
            sd8 sd8Var = this.m;
            if (sd8Var != null) {
                sd8Var.D(nEGFeedbackEventCallback);
            }
            id8 id8Var = this.k;
            if (id8Var != null) {
                id8Var.B(nEGFeedbackEventCallback);
            }
            ld8 ld8Var = this.w;
            if (ld8Var != null) {
                ld8Var.A(nEGFeedbackEventCallback);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.A(nEGFeedbackEventCallback);
            }
            wd8 wd8Var = this.y;
            if (wd8Var != null) {
                wd8Var.A(nEGFeedbackEventCallback);
            }
            vd8 vd8Var = this.z;
            if (vd8Var != null) {
                vd8Var.F(nEGFeedbackEventCallback);
            }
            ud8 ud8Var = this.B;
            if (ud8Var != null) {
                ud8Var.C(nEGFeedbackEventCallback);
            }
            xd8 xd8Var = this.A;
            if (xd8Var != null) {
                xd8Var.D(nEGFeedbackEventCallback);
            }
            nd8 nd8Var2 = this.C;
            if (nd8Var2 != null) {
                nd8Var2.E(nEGFeedbackEventCallback);
            }
            rd8 rd8Var = this.D;
            if (rd8Var != null) {
                rd8Var.D(nEGFeedbackEventCallback);
            }
            td8 td8Var = this.E;
            if (td8Var != null) {
                td8Var.y(nEGFeedbackEventCallback);
            }
            cd8 cd8Var = this.F;
            if (cd8Var != null) {
                cd8Var.C(nEGFeedbackEventCallback);
            }
        }
    }

    public void C(List<oi> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, list, i) == null) {
            uqa.f(list, 2);
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

    public List<oi> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    public void n() {
        ui uiVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (uiVar = this.b) != null) {
            uiVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void q() {
        zd8 zd8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (zd8Var = this.u) != null) {
            zd8Var.onPause();
        }
    }

    public void r() {
        zd8 zd8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (zd8Var = this.u) != null) {
            zd8Var.onResume();
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<bi> list = this.V;
            if (list != null && list.size() > 0) {
                return true;
            }
            this.V = new ArrayList();
            ArrayList<BdUniqueId> g = uqa.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                ac9 b2 = ed9.d().b(this.d, g.get(i), 2);
                if (this.W) {
                    b2.t(3);
                }
                nd8 nd8Var = this.h;
                if (nd8Var != null && (bdUniqueId = nd8Var.b) != null) {
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
        List<oi> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, obj) == null) && (list = this.c) != null) {
            boolean z = false;
            for (oi oiVar : list) {
                if ((oiVar instanceof ICardInfo) && ((ICardInfo) oiVar).responseAttention(obj)) {
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
            nd8 nd8Var = this.h;
            if (nd8Var != null) {
                nd8Var.setFromCDN(z);
                this.C.setFromCDN(z);
                this.w.setFromCDN(z);
                this.y.setFromCDN(z);
            }
            jd8 jd8Var = this.l;
            if (jd8Var != null) {
                jd8Var.setFromCDN(z);
            }
            dd8 dd8Var = this.v;
            if (dd8Var != null) {
                dd8Var.setFromCDN(z);
            }
            bi biVar = this.P;
            if (biVar != null && (biVar instanceof tca)) {
                ((tca) biVar).setIsFromCDN(z);
            }
        }
    }

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            this.e = new zc8(this.d);
            this.f = new be8(this.d);
            this.g = new bd8(this.d, le8.b);
            this.h = new nd8(this.d, nm6.r0);
            this.i = new yd8(this.d, nm6.E0);
            this.j = new hd8(this.d, nm6.M0);
            this.k = new id8(this.d, nm6.F0);
            this.l = new jd8(this.d, nm6.N0);
            this.m = new sd8(this.d, nm6.L0);
            this.n = new kd8(this.d, nm6.O0);
            this.o = new qd8(this.d, nm6.P0);
            this.p = new md8(this.d, nm6.Q0);
            this.q = new pd8(this.d, nm6.R0);
            this.r = new gd8(this.d, nm6.G0);
            this.s = new fd8(this.d, nm6.H0);
            this.t = new ed8(this.d, nm6.I0);
            this.u = new zd8(this.d, om6.U);
            this.w = new ld8(this.d, nm6.t0);
            this.x = new HomePageAlaLiveThreadAdapter(this.d, mm6.S0);
            this.G = new ae8(this.d, nm6.K0);
            this.y = new wd8(this.d, nm6.u0);
            this.z = new vd8(this.d, nm6.v0);
            this.A = new xd8(this.d, nm6.x0);
            this.B = new ud8(this.d, nm6.w0);
            this.C = new nd8(this.d, nm6.s0);
            this.D = new rd8(this.d, nm6.y0);
            this.E = new td8(this.d, mh8.d0);
            this.F = new cd8(this.d, im6.S0);
            this.v = new dd8(this.d, nm6.J0);
            this.H = new a98(this.d, nm6.z0, (byte) 3);
            this.I = new b98(this.d, nm6.A0, (byte) 3);
            this.J = new c98(this.d, nm6.B0, (byte) 3);
            this.K = new e98(this.d, nm6.C0);
            this.N = new ad8(this.d, z26.g);
            this.L = new od8(this.d, ne8.g);
            this.M = new d98(this.d, sm6.j);
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
            this.a.add(new ReadProgessDelegetAdapter(this.d, df8.c));
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.a.add(this.B);
            this.a.add(this.A);
            this.a.add(new ce8(this.d, pe8.h));
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
                AdvertAppInfo.x.set(false);
                return;
            }
            this.O = yca.m().h(this.d, AdvertAppInfo.A, "INDEX");
            this.P = yca.m().h(this.d, AdvertAppInfo.B, "INDEX");
            this.Q = yca.m().h(this.d, AdvertAppInfo.C, "INDEX");
            this.R = yca.m().h(this.d, AdvertAppInfo.D, "INDEX");
            this.S = yca.m().h(this.d, AdvertAppInfo.E, "INDEX");
            this.f1092T = yca.m().h(this.d, AdvertAppInfo.G, "INDEX");
            this.U = yca.m().h(this.d, AdvertAppInfo.F, "INDEX");
            this.a.add(this.O);
            this.a.add(this.P);
            this.a.add(this.Q);
            this.a.add(this.R);
            this.a.add(this.S);
            this.a.add(this.f1092T);
            this.a.add(this.U);
            if (this.d.getPageActivity() instanceof BaseFragmentActivity) {
                this.a.add(r58.h().c((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.J));
                this.a.add(r58.h().c((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.I));
            }
            AdvertAppInfo.x.set(true);
        }
    }

    public void y(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bdUniqueId) == null) {
            bd8 bd8Var = this.g;
            if (bd8Var != null) {
                bd8Var.x(bdUniqueId);
            }
            nd8 nd8Var = this.h;
            if (nd8Var != null) {
                nd8Var.b = bdUniqueId;
            }
            yd8 yd8Var = this.i;
            if (yd8Var != null) {
                yd8Var.b = bdUniqueId;
            }
            hd8 hd8Var = this.j;
            if (hd8Var != null) {
                hd8Var.a = bdUniqueId;
            }
            id8 id8Var = this.k;
            if (id8Var != null) {
                id8Var.a = bdUniqueId;
            }
            jd8 jd8Var = this.l;
            if (jd8Var != null) {
                jd8Var.a = bdUniqueId;
            }
            sd8 sd8Var = this.m;
            if (sd8Var != null) {
                sd8Var.a = bdUniqueId;
            }
            kd8 kd8Var = this.n;
            if (kd8Var != null) {
                kd8Var.a = bdUniqueId;
            }
            qd8 qd8Var = this.o;
            if (qd8Var != null) {
                qd8Var.a = bdUniqueId;
            }
            md8 md8Var = this.p;
            if (md8Var != null) {
                md8Var.a = bdUniqueId;
            }
            pd8 pd8Var = this.q;
            if (pd8Var != null) {
                pd8Var.a = bdUniqueId;
            }
            gd8 gd8Var = this.r;
            if (gd8Var != null) {
                gd8Var.a = bdUniqueId;
            }
            fd8 fd8Var = this.s;
            if (fd8Var != null) {
                fd8Var.a = bdUniqueId;
            }
            ed8 ed8Var = this.t;
            if (ed8Var != null) {
                ed8Var.a = bdUniqueId;
            }
            ld8 ld8Var = this.w;
            if (ld8Var != null) {
                ld8Var.b = bdUniqueId;
            }
            zd8 zd8Var = this.u;
            if (zd8Var != null) {
                zd8Var.a = bdUniqueId;
            }
            zc8 zc8Var = this.e;
            if (zc8Var != null) {
                zc8Var.y(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.a = bdUniqueId;
            }
            ae8 ae8Var = this.G;
            if (ae8Var != null) {
                ae8Var.a = bdUniqueId;
            }
            wd8 wd8Var = this.y;
            if (wd8Var != null) {
                wd8Var.b = bdUniqueId;
            }
            vd8 vd8Var = this.z;
            if (vd8Var != null) {
                vd8Var.b = bdUniqueId;
            }
            ud8 ud8Var = this.B;
            if (ud8Var != null) {
                ud8Var.b = bdUniqueId;
            }
            xd8 xd8Var = this.A;
            if (xd8Var != null) {
                xd8Var.b = bdUniqueId;
            }
            nd8 nd8Var2 = this.C;
            if (nd8Var2 != null) {
                nd8Var2.b = bdUniqueId;
            }
            rd8 rd8Var = this.D;
            if (rd8Var != null) {
                rd8Var.a = bdUniqueId;
            }
            td8 td8Var = this.E;
            if (td8Var != null) {
                td8Var.a = bdUniqueId;
            }
            cd8 cd8Var = this.F;
            if (cd8Var != null) {
                cd8Var.b = bdUniqueId;
            }
            dd8 dd8Var = this.v;
            if (dd8Var != null) {
                dd8Var.a = bdUniqueId;
            }
            a98 a98Var = this.H;
            if (a98Var != null) {
                a98Var.b = bdUniqueId;
            }
            b98 b98Var = this.I;
            if (b98Var != null) {
                b98Var.b = bdUniqueId;
            }
            c98 c98Var = this.J;
            if (c98Var != null) {
                c98Var.b = bdUniqueId;
            }
            od8 od8Var = this.L;
            if (od8Var != null) {
                od8Var.a = bdUniqueId;
            }
            d98 d98Var = this.M;
            if (d98Var != null) {
                d98Var.b = bdUniqueId;
            }
            e98 e98Var = this.K;
            if (e98Var != null) {
                e98Var.b = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.V)) {
                for (bi biVar : this.V) {
                    if (biVar instanceof ac9) {
                        ((ac9) biVar).setUniqueId(bdUniqueId);
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

    public void z(af8 af8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, af8Var) == null) {
            this.h.F(af8Var);
            this.i.E(af8Var);
            this.j.C(af8Var);
            this.l.C(af8Var);
            this.m.E(af8Var);
            this.q.B(af8Var);
            this.r.D(af8Var);
            this.s.C(af8Var);
            this.t.C(af8Var);
            this.u.F(af8Var);
            this.v.D(af8Var);
        }
    }
}
