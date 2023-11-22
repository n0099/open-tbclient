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
public class ee8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yd8 A;
    public vd8 B;
    public od8 C;
    public sd8 D;
    public ud8 E;
    public dd8 F;
    public be8 G;
    public b98 H;
    public c98 I;
    public d98 J;
    public f98 K;
    public pd8 L;
    public e98 M;
    public bd8 N;
    public bi O;
    public bi P;
    public bi Q;
    public bi R;
    public bi S;

    /* renamed from: T  reason: collision with root package name */
    public bi f1093T;
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
    public ad8 e;
    public ce8 f;
    public cd8 g;
    public od8 h;
    public zd8 i;
    public id8 j;
    public jd8 k;
    public kd8 l;
    public td8 m;
    public ld8 n;
    public rd8 o;
    public nd8 p;
    public qd8 q;
    public hd8 r;
    public gd8 s;
    public fd8 t;
    public ae8 u;
    public ed8 v;
    public md8 w;
    public HomePageAlaLiveThreadAdapter x;
    public xd8 y;
    public wd8 z;

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
        public final /* synthetic */ ee8 b;

        /* renamed from: com.baidu.tieba.ee8$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0266a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0266a(a aVar) {
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

        public a(ee8 ee8Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ee8Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ee8Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.Z != null) {
                this.b.Z.e(new RunnableC0266a(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ee8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ee8 ee8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ee8Var, Integer.valueOf(i)};
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
            this.a = ee8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                this.a.i();
                if (this.a.c != null) {
                    ee8 ee8Var = this.a;
                    ee8Var.B(ee8Var.c);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ee8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ee8 ee8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ee8Var, Integer.valueOf(i)};
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
            this.a = ee8Var;
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
        public final /* synthetic */ ee8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ee8 ee8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ee8Var, Integer.valueOf(i)};
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
            this.a = ee8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                xc9 xc9Var = new xc9();
                xc9Var.a = String.valueOf(customResponsedMessage.getData());
                xc9Var.b = true;
                this.a.j(xc9Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ee8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ee8 ee8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ee8Var, Integer.valueOf(i)};
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
            this.a = ee8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                xc9 xc9Var = new xc9();
                xc9Var.a = String.valueOf(customResponsedMessage.getData());
                xc9Var.b = false;
                this.a.j(xc9Var);
            }
        }
    }

    public ee8(Context context, ui uiVar) {
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
            vqa.f(list, 2);
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
            if (biVar instanceof t16) {
                ((t16) biVar).g(str);
            }
        }
    }

    public void t(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) {
            for (bi biVar : this.a) {
                if (biVar instanceof r78) {
                    ((r78) biVar).t(aVar);
                }
            }
        }
    }

    public void u(rc8 rc8Var) {
        jd8 jd8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, rc8Var) == null) && (jd8Var = this.k) != null) {
            jd8Var.C(rc8Var);
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
            od8 od8Var = this.h;
            if (od8Var != null) {
                od8Var.E(nEGFeedbackEventCallback);
            }
            td8 td8Var = this.m;
            if (td8Var != null) {
                td8Var.D(nEGFeedbackEventCallback);
            }
            jd8 jd8Var = this.k;
            if (jd8Var != null) {
                jd8Var.B(nEGFeedbackEventCallback);
            }
            md8 md8Var = this.w;
            if (md8Var != null) {
                md8Var.A(nEGFeedbackEventCallback);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.A(nEGFeedbackEventCallback);
            }
            xd8 xd8Var = this.y;
            if (xd8Var != null) {
                xd8Var.A(nEGFeedbackEventCallback);
            }
            wd8 wd8Var = this.z;
            if (wd8Var != null) {
                wd8Var.F(nEGFeedbackEventCallback);
            }
            vd8 vd8Var = this.B;
            if (vd8Var != null) {
                vd8Var.C(nEGFeedbackEventCallback);
            }
            yd8 yd8Var = this.A;
            if (yd8Var != null) {
                yd8Var.D(nEGFeedbackEventCallback);
            }
            od8 od8Var2 = this.C;
            if (od8Var2 != null) {
                od8Var2.E(nEGFeedbackEventCallback);
            }
            sd8 sd8Var = this.D;
            if (sd8Var != null) {
                sd8Var.D(nEGFeedbackEventCallback);
            }
            ud8 ud8Var = this.E;
            if (ud8Var != null) {
                ud8Var.y(nEGFeedbackEventCallback);
            }
            dd8 dd8Var = this.F;
            if (dd8Var != null) {
                dd8Var.C(nEGFeedbackEventCallback);
            }
        }
    }

    public void C(List<oi> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, list, i) == null) {
            vqa.f(list, 2);
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
        ae8 ae8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (ae8Var = this.u) != null) {
            ae8Var.onPause();
        }
    }

    public void r() {
        ae8 ae8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (ae8Var = this.u) != null) {
            ae8Var.onResume();
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
            ArrayList<BdUniqueId> g = vqa.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                bc9 b2 = fd9.d().b(this.d, g.get(i), 2);
                if (this.W) {
                    b2.t(3);
                }
                od8 od8Var = this.h;
                if (od8Var != null && (bdUniqueId = od8Var.b) != null) {
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
            od8 od8Var = this.h;
            if (od8Var != null) {
                od8Var.setFromCDN(z);
                this.C.setFromCDN(z);
                this.w.setFromCDN(z);
                this.y.setFromCDN(z);
            }
            kd8 kd8Var = this.l;
            if (kd8Var != null) {
                kd8Var.setFromCDN(z);
            }
            ed8 ed8Var = this.v;
            if (ed8Var != null) {
                ed8Var.setFromCDN(z);
            }
            bi biVar = this.P;
            if (biVar != null && (biVar instanceof uca)) {
                ((uca) biVar).setIsFromCDN(z);
            }
        }
    }

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            this.e = new ad8(this.d);
            this.f = new ce8(this.d);
            this.g = new cd8(this.d, me8.b);
            this.h = new od8(this.d, om6.r0);
            this.i = new zd8(this.d, om6.E0);
            this.j = new id8(this.d, om6.M0);
            this.k = new jd8(this.d, om6.F0);
            this.l = new kd8(this.d, om6.N0);
            this.m = new td8(this.d, om6.L0);
            this.n = new ld8(this.d, om6.O0);
            this.o = new rd8(this.d, om6.P0);
            this.p = new nd8(this.d, om6.Q0);
            this.q = new qd8(this.d, om6.R0);
            this.r = new hd8(this.d, om6.G0);
            this.s = new gd8(this.d, om6.H0);
            this.t = new fd8(this.d, om6.I0);
            this.u = new ae8(this.d, pm6.U);
            this.w = new md8(this.d, om6.t0);
            this.x = new HomePageAlaLiveThreadAdapter(this.d, nm6.S0);
            this.G = new be8(this.d, om6.K0);
            this.y = new xd8(this.d, om6.u0);
            this.z = new wd8(this.d, om6.v0);
            this.A = new yd8(this.d, om6.x0);
            this.B = new vd8(this.d, om6.w0);
            this.C = new od8(this.d, om6.s0);
            this.D = new sd8(this.d, om6.y0);
            this.E = new ud8(this.d, nh8.d0);
            this.F = new dd8(this.d, jm6.S0);
            this.v = new ed8(this.d, om6.J0);
            this.H = new b98(this.d, om6.z0, (byte) 3);
            this.I = new c98(this.d, om6.A0, (byte) 3);
            this.J = new d98(this.d, om6.B0, (byte) 3);
            this.K = new f98(this.d, om6.C0);
            this.N = new bd8(this.d, a36.g);
            this.L = new pd8(this.d, oe8.g);
            this.M = new e98(this.d, tm6.j);
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
            this.a.add(new ReadProgessDelegetAdapter(this.d, ef8.c));
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.a.add(this.B);
            this.a.add(this.A);
            this.a.add(new de8(this.d, qe8.h));
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
            this.O = zca.m().h(this.d, AdvertAppInfo.A, "INDEX");
            this.P = zca.m().h(this.d, AdvertAppInfo.B, "INDEX");
            this.Q = zca.m().h(this.d, AdvertAppInfo.C, "INDEX");
            this.R = zca.m().h(this.d, AdvertAppInfo.D, "INDEX");
            this.S = zca.m().h(this.d, AdvertAppInfo.E, "INDEX");
            this.f1093T = zca.m().h(this.d, AdvertAppInfo.G, "INDEX");
            this.U = zca.m().h(this.d, AdvertAppInfo.F, "INDEX");
            this.a.add(this.O);
            this.a.add(this.P);
            this.a.add(this.Q);
            this.a.add(this.R);
            this.a.add(this.S);
            this.a.add(this.f1093T);
            this.a.add(this.U);
            if (this.d.getPageActivity() instanceof BaseFragmentActivity) {
                this.a.add(s58.h().c((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.J));
                this.a.add(s58.h().c((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.I));
            }
            AdvertAppInfo.x.set(true);
        }
    }

    public void y(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bdUniqueId) == null) {
            cd8 cd8Var = this.g;
            if (cd8Var != null) {
                cd8Var.x(bdUniqueId);
            }
            od8 od8Var = this.h;
            if (od8Var != null) {
                od8Var.b = bdUniqueId;
            }
            zd8 zd8Var = this.i;
            if (zd8Var != null) {
                zd8Var.b = bdUniqueId;
            }
            id8 id8Var = this.j;
            if (id8Var != null) {
                id8Var.a = bdUniqueId;
            }
            jd8 jd8Var = this.k;
            if (jd8Var != null) {
                jd8Var.a = bdUniqueId;
            }
            kd8 kd8Var = this.l;
            if (kd8Var != null) {
                kd8Var.a = bdUniqueId;
            }
            td8 td8Var = this.m;
            if (td8Var != null) {
                td8Var.a = bdUniqueId;
            }
            ld8 ld8Var = this.n;
            if (ld8Var != null) {
                ld8Var.a = bdUniqueId;
            }
            rd8 rd8Var = this.o;
            if (rd8Var != null) {
                rd8Var.a = bdUniqueId;
            }
            nd8 nd8Var = this.p;
            if (nd8Var != null) {
                nd8Var.a = bdUniqueId;
            }
            qd8 qd8Var = this.q;
            if (qd8Var != null) {
                qd8Var.a = bdUniqueId;
            }
            hd8 hd8Var = this.r;
            if (hd8Var != null) {
                hd8Var.a = bdUniqueId;
            }
            gd8 gd8Var = this.s;
            if (gd8Var != null) {
                gd8Var.a = bdUniqueId;
            }
            fd8 fd8Var = this.t;
            if (fd8Var != null) {
                fd8Var.a = bdUniqueId;
            }
            md8 md8Var = this.w;
            if (md8Var != null) {
                md8Var.b = bdUniqueId;
            }
            ae8 ae8Var = this.u;
            if (ae8Var != null) {
                ae8Var.a = bdUniqueId;
            }
            ad8 ad8Var = this.e;
            if (ad8Var != null) {
                ad8Var.y(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.a = bdUniqueId;
            }
            be8 be8Var = this.G;
            if (be8Var != null) {
                be8Var.a = bdUniqueId;
            }
            xd8 xd8Var = this.y;
            if (xd8Var != null) {
                xd8Var.b = bdUniqueId;
            }
            wd8 wd8Var = this.z;
            if (wd8Var != null) {
                wd8Var.b = bdUniqueId;
            }
            vd8 vd8Var = this.B;
            if (vd8Var != null) {
                vd8Var.b = bdUniqueId;
            }
            yd8 yd8Var = this.A;
            if (yd8Var != null) {
                yd8Var.b = bdUniqueId;
            }
            od8 od8Var2 = this.C;
            if (od8Var2 != null) {
                od8Var2.b = bdUniqueId;
            }
            sd8 sd8Var = this.D;
            if (sd8Var != null) {
                sd8Var.a = bdUniqueId;
            }
            ud8 ud8Var = this.E;
            if (ud8Var != null) {
                ud8Var.a = bdUniqueId;
            }
            dd8 dd8Var = this.F;
            if (dd8Var != null) {
                dd8Var.b = bdUniqueId;
            }
            ed8 ed8Var = this.v;
            if (ed8Var != null) {
                ed8Var.a = bdUniqueId;
            }
            b98 b98Var = this.H;
            if (b98Var != null) {
                b98Var.b = bdUniqueId;
            }
            c98 c98Var = this.I;
            if (c98Var != null) {
                c98Var.b = bdUniqueId;
            }
            d98 d98Var = this.J;
            if (d98Var != null) {
                d98Var.b = bdUniqueId;
            }
            pd8 pd8Var = this.L;
            if (pd8Var != null) {
                pd8Var.a = bdUniqueId;
            }
            e98 e98Var = this.M;
            if (e98Var != null) {
                e98Var.b = bdUniqueId;
            }
            f98 f98Var = this.K;
            if (f98Var != null) {
                f98Var.b = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.V)) {
                for (bi biVar : this.V) {
                    if (biVar instanceof bc9) {
                        ((bc9) biVar).setUniqueId(bdUniqueId);
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

    public void z(bf8 bf8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bf8Var) == null) {
            this.h.F(bf8Var);
            this.i.E(bf8Var);
            this.j.C(bf8Var);
            this.l.C(bf8Var);
            this.m.E(bf8Var);
            this.q.B(bf8Var);
            this.r.D(bf8Var);
            this.s.C(bf8Var);
            this.t.C(bf8Var);
            this.u.F(bf8Var);
            this.v.D(bf8Var);
        }
    }
}
