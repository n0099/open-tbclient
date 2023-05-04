package com.baidu.tieba;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.data.VirtualImageCustomFigure;
import com.baidu.tbadk.data.VirtualImageCustomState;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.pb.data.PbFirstFloorRecommendData;
import com.baidu.tieba.pb.pb.adapter.PbReplyLoadMoreAdapter;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.PbPrivateTitleAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorEnterForumAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorItemAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorRecommendAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorWebViewAdapter;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class ey8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fy8 A;
    public uy8 B;
    public g09 C;
    public PbFirstFloorWebViewAdapter D;
    public ix8 E;
    public qv8 F;
    public ArrayList<pp9> G;
    public ArrayList<in> H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public int R;
    public String S;
    public pp9 T;
    public pp9 U;
    public View.OnClickListener V;
    public View.OnClickListener W;
    public View.OnClickListener X;
    public TbRichTextView.a0 Y;
    public View.OnClickListener Z;
    public PbFragment a;
    public uw8 a0;
    public BdTypeListView b;
    public View.OnLongClickListener b0;
    public my8 c;
    public SortSwitchButton.f c0;
    public ny8 d;
    public final List<vm> d0;
    public PbFirstFloorCommentAndPraiseAdapter e;
    public final List<vm> e0;
    public PbFirstFloorEnterForumAdapter f;
    public Runnable f0;
    public PbFirstFloorItemAdapter g;
    public int g0;
    public PbFirstFloorRecommendAdapter h;
    public int h0;
    public e09 i;
    public int i0;
    public kz8 j;
    public ThreadData j0;
    public yy8 k;
    public List<pp9> k0;
    public kz8 l;
    public final CustomMessageListener l0;
    public hy8 m;
    public CustomMessageListener m0;
    public nz8 n;
    public final CustomMessageListener n0;
    public w29 o;
    public final View.OnClickListener o0;
    public fj6 p;
    public CustomMessageListener p0;
    public vm q;
    public List<vm> q0;
    public vm r;
    public vm s;
    public vm t;
    public vm u;
    public gz8 v;
    public iz8 w;
    public fz8 x;
    public PbReplyLoadMoreAdapter y;
    public ArrayList<hx8> z;

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ey8 a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.d0();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ey8 ey8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ey8Var, Integer.valueOf(i)};
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
            this.a = ey8Var;
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.F != null && !g9.c(this.a.a.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
                boolean z = false;
                Iterator<DownloadData> it = data.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (it.next().getStatus() == 0) {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    jg.a().postDelayed(new a(this), TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }
    }

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ey8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ey8 ey8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ey8Var, Integer.valueOf(i)};
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
            this.a = ey8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof np9)) {
                np9 np9Var = (np9) customResponsedMessage.getData();
                if (this.a.j0 != null && this.a.j0.funAdData == np9Var) {
                    this.a.j0.funAdData.p(true);
                    this.a.b.setData(this.a.H);
                    this.a.d0();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ey8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ey8 ey8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ey8Var, Integer.valueOf(i)};
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
            this.a = ey8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof ep9)) {
                AbsDelegateAdapterList a = ((ep9) customResponsedMessage.getData()).a();
                Iterator<vm<?, ?>> it = a.iterator();
                while (it.hasNext()) {
                    vm<?, ?> next = it.next();
                    if (next instanceof jy8) {
                        ((jy8) next).t(this.a.a);
                        if (next instanceof hx8) {
                            this.a.z.add((hx8) next);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(a);
                this.a.e0.clear();
                this.a.e0.addAll(arrayList);
                if (this.a.b != null) {
                    this.a.b.addAdapters(arrayList);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ey8 a;

        public d(ey8 ey8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ey8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ey8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a != null && this.a.F != null && this.a.F.R() != null) {
                this.a.a.I5().Y0().v();
                TiebaStatic.log(new StatisticItem("c12040"));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ ey8 b;

        public e(ey8 ey8Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ey8Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ey8Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.b.setSelectionFromTop(this.b.b.getHeaderViewsCount() + this.a.size(), 0 - this.b.h0);
                this.b.P = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ey8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(ey8 ey8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ey8Var, Integer.valueOf(i)};
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
            this.a = ey8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.q0)) {
                this.a.n();
                ey8 ey8Var = this.a;
                ey8Var.l0(ey8Var.F, false);
            }
        }
    }

    public ey8(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.z = new ArrayList<>();
        this.G = new ArrayList<>();
        this.I = false;
        this.J = false;
        this.K = true;
        this.L = true;
        this.M = false;
        this.N = false;
        this.Q = false;
        this.R = 0;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.a0 = null;
        this.b0 = null;
        this.c0 = null;
        this.d0 = new ArrayList();
        this.e0 = new ArrayList();
        this.g0 = -1;
        this.h0 = 0;
        this.i0 = -1;
        this.k0 = new ArrayList();
        this.l0 = new a(this, 2921523);
        this.m0 = new b(this, 2004015);
        this.n0 = new c(this, 2001118);
        this.o0 = new d(this);
        this.p0 = new f(this, 2016470);
        this.R = ii.l(pbFragment.getPageContext().getPageActivity());
        this.a = pbFragment;
        this.b = bdTypeListView;
        M(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.n0);
        this.h0 = ii.j(this.a.getContext()) / 3;
    }

    public BdUniqueId A(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (this.b.G(i) != null) {
                return this.b.G(i).getType();
            }
            return null;
        }
        return (BdUniqueId) invokeI.objValue;
    }

    public void A0(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onLongClickListener) == null) {
            this.b0 = onLongClickListener;
        }
    }

    public void B0(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.c0 = fVar;
        }
    }

    public void C0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.W = onClickListener;
        }
    }

    public void D0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onClickListener) == null) {
            this.Z = onClickListener;
        }
    }

    public void E0(uw8 uw8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, uw8Var) == null) {
            this.a0 = uw8Var;
        }
    }

    public final void O(PbFragment pbFragment) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, pbFragment) == null) && pbFragment != null && pbFragment.getPageContext() != null) {
            DefaultLog.getInstance().c("PbAdapterManager", "初始化PbFirstFloorWebViewAdapter");
            this.D = new PbFirstFloorWebViewAdapter(pbFragment, uv8.c);
        }
    }

    public void h0(boolean z) {
        my8 my8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048618, this, z) == null) && (my8Var = this.c) != null) {
            my8Var.V(z);
        }
    }

    public void n0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            this.J = z;
        }
    }

    public void o0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
            this.M = z;
        }
    }

    public void p0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z) == null) {
            this.K = z;
        }
    }

    public void q0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048633, this, z) == null) {
            this.Q = z;
        }
    }

    public void r0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            this.N = z;
        }
    }

    public final pp9 s(qv8 qv8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048636, this, qv8Var)) == null) {
            if (qv8Var != null && qv8Var.S() != null) {
                pp9 S = qv8Var.S();
                this.U = S;
                return S;
            }
            return null;
        }
        return (pp9) invokeL.objValue;
    }

    public void s0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
            this.O = z;
        }
    }

    public void t0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048639, this, z) == null) {
            this.L = z;
        }
    }

    public void u0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048641, this, z) == null) {
            this.P = z;
        }
    }

    public void v0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, onClickListener) == null) {
            this.X = onClickListener;
        }
    }

    public void w0(boolean z) {
        hy8 hy8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048645, this, z) == null) && (hy8Var = this.m) != null) {
            hy8Var.p0(z);
        }
    }

    public void x0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, onClickListener) == null) {
            this.V = onClickListener;
        }
    }

    public in z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048650, this, i)) == null) {
            return this.b.G(i);
        }
        return (in) invokeI.objValue;
    }

    public void z0(TbRichTextView.a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, a0Var) == null) {
            this.Y = a0Var;
        }
    }

    public PbFirstFloorCommentAndPraiseAdapter B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    public void F0() {
        yy8 yy8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (yy8Var = this.k) != null) {
            yy8Var.z(2);
        }
    }

    public int I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.g0;
        }
        return invokeV.intValue;
    }

    public void I0() {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (i = this.i0) > 0 && S(this.H, i) != null) {
            this.i0 = -1;
            this.b.setData(this.H);
            d0();
        }
    }

    public boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.I;
        }
        return invokeV.booleanValue;
    }

    public boolean c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.K;
        }
        return invokeV.booleanValue;
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.g0 = D();
            if (this.b.getAdapter2() instanceof zm) {
                this.b.getAdapter2().notifyDataSetChanged();
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048624, this) == null) && this.a != null && !n()) {
            this.a.registerListener(this.p0);
        }
    }

    public View u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return this.E.b();
        }
        return (View) invokeV.objValue;
    }

    public ArrayList<in> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            return this.H;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            return this.b.getHeaderViewsCount();
        }
        return invokeV.intValue;
    }

    public final int C(qv8 qv8Var, ArrayList<in> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, qv8Var, arrayList)) == null) {
            if (qv8Var == null || ListUtils.isEmpty(qv8Var.F()) || ListUtils.isEmpty(arrayList) || ((pp9) ListUtils.getItem(qv8Var.F(), 0)) == null) {
                return 0;
            }
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    in inVar = arrayList.get(i);
                    if (inVar instanceof pp9) {
                        pp9 pp9Var = (pp9) inVar;
                        if (pp9Var.D() == 1 && pp9Var.O == 0) {
                            z = true;
                            break;
                        }
                    }
                    i++;
                } else {
                    z = false;
                    i = 0;
                    break;
                }
            }
            if (!z) {
                return 0;
            }
            return i + 1;
        }
        return invokeLL.intValue;
    }

    public final int H(qv8 qv8Var, ArrayList<in> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, qv8Var, arrayList)) == null) {
            int i = -1;
            if (qv8Var == null || qv8Var.y() == null) {
                return -1;
            }
            int i2 = 0;
            if (qv8Var.y().c() == 1) {
                z = true;
            } else {
                z = false;
            }
            int size = arrayList.size();
            if (!z || !this.J) {
                return -1;
            }
            while (true) {
                if (i2 >= size) {
                    break;
                } else if (arrayList.get(i2) instanceof ew8) {
                    i = i2 + 1;
                    break;
                } else {
                    i2++;
                }
            }
            if (qv8Var.J() == 4) {
                return i + 1;
            }
            return i;
        }
        return invokeLL.intValue;
    }

    public final void L(ArrayList<in> arrayList, Boolean bool) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048596, this, arrayList, bool) != null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        int i = c85.i();
        int j = c85.j() - 1;
        if (bool.booleanValue()) {
            in inVar = arrayList.get(0);
            if ((inVar instanceof pp9) && ((pp9) inVar).D() == 1) {
                j++;
            }
        }
        int k = c85.k() + 1;
        PbFragment pbFragment = this.a;
        if (pbFragment != null && pbFragment.Q() != null && this.a.Q().J1() == 3) {
            this.k0.clear();
        }
        T(j, i, k, arrayList);
    }

    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            BdTypeListView bdTypeListView = this.b;
            if (bdTypeListView != null && bdTypeListView.getData() != null) {
                for (int i = 0; i < this.b.getData().size(); i++) {
                    in inVar = this.b.getData().get(i);
                    if (inVar != null && inVar.getType() == ew8.g) {
                        return i;
                    }
                }
                return -1;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            jg.a().removeCallbacks(this.f0);
            kz8 kz8Var = this.j;
            if (kz8Var != null) {
                kz8Var.onDestroy();
            }
            kz8 kz8Var2 = this.l;
            if (kz8Var2 != null) {
                kz8Var2.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.e;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
            e09 e09Var = this.i;
            if (e09Var != null) {
                e09Var.onDestroy();
            }
            zz5.k().q(false);
        }
    }

    public int E(qv8 qv8Var, ArrayList<in> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, qv8Var, arrayList, z)) == null) {
            if (qv8Var == null || qv8Var.F() == null || qv8Var.C() == null || qv8Var.F().size() == 0 || qv8Var.M() == null || arrayList == null || !qv8Var.C().s1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (qv8Var.F().get(0) == null || qv8Var.F().get(0).D() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (qv8Var.y() == null || qv8Var.y().a() != qv8Var.y().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public int F(qv8 qv8Var, ArrayList<in> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048586, this, qv8Var, arrayList, z)) == null) {
            if (qv8Var == null || qv8Var.F() == null || qv8Var.D() == null || qv8Var.F().size() == 0 || qv8Var.M() == null || arrayList == null || !qv8Var.D().s1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (qv8Var.F().get(0) == null || qv8Var.F().get(0).D() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (qv8Var.y() == null || qv8Var.y().a() != qv8Var.y().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final in U(qv8 qv8Var, ArrayList<in> arrayList, int i) {
        InterceptResult invokeLLI;
        sv8 sv8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048605, this, qv8Var, arrayList, i)) == null) {
            if (qv8Var.k() != null && !StringUtils.isNull(qv8Var.k().getName())) {
                if (!TextUtils.equals(qv8Var.k().getName(), this.a.Q().Y0()) || !this.a.Q().e1()) {
                    if (!this.a.z0() && !ListUtils.isEmpty(qv8Var.o())) {
                        sv8Var = new sv8(qv8Var.o().get(0));
                    } else {
                        sv8Var = new sv8(qv8Var.k());
                    }
                    sv8Var.g = this.a.Q().S1();
                    ListUtils.add(arrayList, i + 1, sv8Var);
                    return sv8Var;
                }
                return null;
            }
            return null;
        }
        return (in) invokeLLI.objValue;
    }

    public final int G(qv8 qv8Var, ArrayList<in> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048588, this, qv8Var, arrayList, z)) == null) {
            if (qv8Var != null && !ListUtils.isEmpty(qv8Var.F()) && arrayList != null && arrayList.size() > 0) {
                if (!z) {
                    return 0;
                }
                if (qv8Var.F().get(0) == null || qv8Var.F().get(0).D() != 1) {
                    return -1;
                }
                return 1;
            } else if (qv8Var == null || !qv8Var.v0()) {
                return -1;
            } else {
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final void Y(qv8 qv8Var, ArrayList<in> arrayList, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048609, this, qv8Var, arrayList, i) == null) {
            ew8 ew8Var = new ew8(ew8.g);
            ThreadData M = qv8Var.M();
            ew8Var.c = this.a.a6();
            ew8Var.b = qv8Var.g;
            ew8Var.d = qv8Var.h0();
            ew8Var.e = qv8Var.f;
            if (M != null && M.isQuestionThread()) {
                z = true;
            } else {
                z = false;
            }
            ew8Var.f = z;
            ListUtils.add(arrayList, i, ew8Var);
            if (qv8Var.J() == 4) {
                ListUtils.add(arrayList, i + 1, new dw8());
            }
        }
    }

    public final boolean G0(pp9 pp9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, pp9Var)) == null) {
            if (this.a.Q() != null && pp9Var != null && pp9Var.N() != null && pp9Var.N().equals(this.a.Q().Y1())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.I = z;
            my8 my8Var = this.c;
            if (my8Var != null) {
                my8Var.setFromCDN(z);
            }
            vm vmVar = this.r;
            if (vmVar != null && (vmVar instanceof vd9)) {
                ((vd9) vmVar).setIsFromCDN(z);
            }
            Iterator<hx8> it = this.z.iterator();
            while (it.hasNext()) {
                it.next().setFromCDN(z);
            }
        }
    }

    public final pp9 r(ArrayList<in> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, arrayList)) == null) {
            Iterator<in> it = arrayList.iterator();
            while (it.hasNext()) {
                in next = it.next();
                if (next instanceof pp9) {
                    pp9 pp9Var = (pp9) next;
                    if (pp9Var.D() == 1) {
                        return pp9Var;
                    }
                }
            }
            return null;
        }
        return (pp9) invokeL.objValue;
    }

    public void y0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048649, this, z) == null) {
            hy8 hy8Var = this.m;
            if (hy8Var != null) {
                hy8Var.q0(z);
            }
            kz8 kz8Var = this.j;
            if (kz8Var != null) {
                kz8Var.A(z);
            }
            vm vmVar = this.u;
            if (vmVar != null) {
                vmVar.setMulDel(z);
            }
            vm vmVar2 = this.r;
            if (vmVar2 != null) {
                vmVar2.setMulDel(z);
            }
            my8 my8Var = this.c;
            if (my8Var != null) {
                my8Var.setMulDel(z);
            }
        }
    }

    public final void H0() {
        qv8 qv8Var;
        op9 op9Var;
        op9 op9Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || (qv8Var = this.F) == null || qv8Var.Z || qv8Var.a0 == 2) {
            return;
        }
        ArrayList<pp9> F = qv8Var.F();
        ArrayList<op9> d2 = this.F.d();
        if (!ch8.e(F) && !ch8.e(d2)) {
            StringBuilder sb = new StringBuilder();
            Iterator<op9> it = d2.iterator();
            while (it.hasNext()) {
                op9 next = it.next();
                if (next != null && next.t1() != null) {
                    sb.append(next.t1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<op9> it2 = d2.iterator();
            while (it2.hasNext()) {
                op9 next2 = it2.next();
                if (next2 != null) {
                    next2.j1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<op9> it3 = d2.iterator();
            while (it3.hasNext()) {
                op9 next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int h = next3.getAdvertAppInfo().h();
                    if (h != 0) {
                        of9.j(next3, h);
                        if (h != 28 && h != 31) {
                            next3.getAdvertAppInfo().c = -1001;
                        }
                    }
                    sparseArray.put(next3.getPosition(), next3);
                }
            }
            d2.clear();
            HashMap hashMap = new HashMap();
            for (int i = 0; i < sparseArray.size(); i++) {
                op9 op9Var3 = (op9) sparseArray.valueAt(i);
                if (op9Var3 != null && (op9Var2 = (op9) hashMap.put(op9Var3.s1(), op9Var3)) != null) {
                    of9.j(op9Var2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (op9Var = (op9) entry.getValue()) != null) {
                    sparseArray.put(op9Var.getPosition(), op9Var);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                ch8.a(arrayList, Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList);
            int i3 = 1;
            for (int i4 = 0; i4 < ch8.i(arrayList); i4++) {
                op9 op9Var4 = (op9) sparseArray.get(((Integer) ch8.d(arrayList, i4)).intValue());
                if (this.F.k() != null) {
                    op9Var4.d1 = this.F.k().getId();
                }
                if (this.F.M() != null) {
                    op9Var4.g1 = gg.g(this.F.M().getId(), 0L);
                }
                qv8 qv8Var2 = this.F;
                if (qv8Var2 != null && qv8Var2.y() != null) {
                    op9Var4.h1 = this.F.y().a();
                }
                l(op9Var4);
                int position = op9Var4.getPosition() + this.F.Y;
                if (position >= ch8.i(F)) {
                    op9Var4.j1 = position;
                    of9.k(op9Var4, 2, position, ch8.i(F));
                    return;
                }
                if (!this.L) {
                    position--;
                    op9Var4.j1 = position;
                }
                if (position < 0) {
                    of9.j(op9Var4, 23);
                } else {
                    op9Var4.k1 = i3;
                    ch8.b(F, op9Var4, position);
                    i3++;
                    PbFragment pbFragment = this.a;
                    if (pbFragment != null && pbFragment.getPageContext() != null && this.a.getPageContext().getContext() != null) {
                        TiebaStatic.eventStat(this.a.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", op9Var4.getAdvertAppInfo().p);
                    }
                }
            }
        }
    }

    public final ArrayList<in> J(List<in> list, List<in> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, list, list2)) == null) {
            ArrayList<in> arrayList = new ArrayList<>(list.size() + list2.size() + 2);
            arrayList.addAll(list);
            xv8 xv8Var = new xv8();
            PbListView c1 = this.a.I5().c1();
            if (c1 != null && c1.p()) {
                xv8Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0edb);
                xv8Var.b = true;
            } else {
                xv8Var.a = TbadkCoreApplication.getInst().getString(R.string.list_has_no_more);
                xv8Var.b = false;
            }
            arrayList.add(xv8Var);
            ij6 ij6Var = new ij6();
            ij6Var.a = TbadkCoreApplication.getInst().getString(R.string.recommed_for_you);
            ij6Var.needTopMargin = false;
            arrayList.add(ij6Var);
            arrayList.addAll(list2);
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public final int w(qv8 qv8Var, ArrayList<in> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048644, this, qv8Var, arrayList)) == null) {
            if (!this.N && qv8Var != null && !ListUtils.isEmpty(qv8Var.F()) && arrayList != null && arrayList.size() > 0) {
                if (this.a.Q() != null && this.a.Q().i1()) {
                    return -1;
                }
                if (this.a.I5() != null && this.a.I5().U0()) {
                    return -1;
                }
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    if (i < size) {
                        in inVar = arrayList.get(i);
                        if (inVar instanceof pp9) {
                            pp9 pp9Var = (pp9) inVar;
                            if (pp9Var.D() == 1 && pp9Var.O == 0) {
                                z = true;
                                break;
                            }
                        }
                        i++;
                    } else {
                        z = false;
                        i = -1;
                        break;
                    }
                }
                if (!z) {
                    if (qv8Var.v0()) {
                        return 0;
                    }
                    return -1;
                }
                return i + 1;
            } else if (qv8Var != null && qv8Var.v0() && this.L) {
                return 0;
            } else {
                return -1;
            }
        }
        return invokeLL.intValue;
    }

    public View K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            my8 my8Var = this.c;
            if (my8Var != null && my8Var.Q() != null) {
                if (this.c.Q().z != null && this.c.Q().z.isShown()) {
                    return this.c.Q().z;
                }
                return this.c.Q().y;
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void j0() {
        pp9 pp9Var;
        my8 my8Var;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048620, this) == null) && this.F != null && (pp9Var = this.T) != null && pp9Var.W() != null && (my8Var = this.c) != null && my8Var.Q() != null) {
            String O = this.F.O();
            String l = this.F.l();
            if (this.F.M() != null) {
                i = this.F.M().getThreadType();
            } else {
                i = 0;
            }
            ul5.a().c(O, l, this.T.W(), this.c.Q().s, i);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048630, this) == null) && this.d0 != null) {
            DefaultLog.getInstance().c("PbAdapterManager", "动态修正Adapter");
            this.d0.remove(this.c);
            if (this.d == null) {
                this.d = new ny8(this.a, pp9.R0);
            }
            if (!this.d0.contains(this.d)) {
                this.d0.add(this.d);
            }
            if (this.D == null) {
                O(this.a);
            }
            if (!this.d0.contains(this.D)) {
                this.d0.add(this.D);
            }
        }
    }

    public void M(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        ny8 ny8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, pbFragment, bdTypeListView) == null) {
            if (sz8.B(pbFragment)) {
                DefaultLog.getInstance().c("PbAdapterManager", "初始化PbFirstFloorEmptyAdapter");
                this.d = new ny8(pbFragment, pp9.R0);
            } else {
                DefaultLog.getInstance().c("PbAdapterManager", "初始化PbFirstFloorAdapter");
                my8 my8Var = new my8(pbFragment, pp9.R0);
                this.c = my8Var;
                my8Var.g0(pbFragment);
            }
            this.e = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, fw8.f);
            this.f = new PbFirstFloorEnterForumAdapter(pbFragment, sv8.j);
            this.g = new PbFirstFloorItemAdapter(pbFragment.getContext(), tv8.c);
            this.h = new PbFirstFloorRecommendAdapter(pbFragment.getContext(), PbFirstFloorRecommendData.d);
            this.i = new e09(pbFragment, nv8.c);
            this.j = new kz8(pbFragment, ew8.g);
            this.k = new yy8(pbFragment, zv8.c);
            this.l = new kz8(pbFragment, ew8.h);
            hy8 hy8Var = new hy8(pbFragment, pp9.S0);
            this.m = hy8Var;
            hy8Var.s0(pbFragment);
            nz8 nz8Var = new nz8(pbFragment, pp9.T0);
            this.n = nz8Var;
            nz8Var.v0(pbFragment);
            this.q = ae9.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.x);
            this.r = ae9.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.z);
            this.s = am7.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.F);
            this.t = am7.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.G);
            this.u = am7.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.I);
            this.x = new fz8(pbFragment, bw8.f1);
            this.v = new gz8(pbFragment, ez8.e1);
            this.w = new iz8(pbFragment, gz4.k1);
            this.y = new PbReplyLoadMoreAdapter(pbFragment, pp9.Z0);
            this.o = new w29(pbFragment, x29.a);
            this.p = new fj6(pbFragment.getPageContext());
            this.A = new fy8(pbFragment, rx4.e);
            this.B = new uy8(pbFragment, pbFragment.getUniqueId());
            this.C = new g09(pbFragment.getPageContext(), x06.g);
            if (sz8.B(pbFragment)) {
                O(pbFragment);
            }
            ix8 ix8Var = new ix8(pbFragment, pbFragment.getUniqueId(), this.b);
            this.E = ix8Var;
            this.d0.addAll(ix8Var.a());
            if (sz8.B(pbFragment) && (ny8Var = this.d) != null) {
                this.d0.add(ny8Var);
            } else {
                my8 my8Var2 = this.c;
                if (my8Var2 != null) {
                    this.d0.add(my8Var2);
                }
            }
            this.d0.add(this.e);
            this.d0.add(this.f);
            this.d0.add(this.g);
            this.d0.add(this.h);
            this.d0.add(this.i);
            this.d0.add(this.m);
            this.d0.add(this.n);
            this.d0.add(this.j);
            this.d0.add(this.k);
            this.d0.add(this.l);
            this.d0.add(this.q);
            this.d0.add(this.r);
            this.d0.add(this.s);
            this.d0.add(this.t);
            this.d0.add(this.u);
            this.d0.add(this.x);
            this.d0.add(this.v);
            this.d0.add(this.w);
            this.d0.add(this.o);
            this.d0.add(this.y);
            this.d0.add(this.p);
            this.d0.add(this.A);
            this.d0.add(this.B);
            this.d0.add(new PbPrivateTitleAdapter(pbFragment));
            this.d0.add(this.C);
            if (sz8.B(pbFragment)) {
                this.d0.add(this.D);
            }
            this.m0.setPriority(1);
            this.m0.setSelfListener(true);
            pbFragment.registerListener(this.m0);
            pbFragment.registerListener(this.l0);
            m();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new ep9(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
            CustomMessage customMessage = new CustomMessage(2004015);
            customMessage.setTag(pbFragment.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            bdTypeListView.addAdapters(this.d0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:227:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:251:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void l0(qv8 qv8Var, boolean z) {
        pp9 pp9Var;
        boolean z2;
        boolean z3;
        pp9 pp9Var2;
        boolean z4;
        boolean z5;
        int i;
        boolean z6;
        boolean z7;
        int i2;
        boolean z8;
        int i3;
        vy8 vy8Var;
        List<in> list;
        int i4;
        my8 my8Var;
        boolean z9;
        boolean z10;
        boolean z11;
        in inVar;
        int i5;
        boolean z12;
        pp9 pp9Var3;
        pp9 pp9Var4;
        pp9 pp9Var5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048623, this, qv8Var, z) != null) || qv8Var == null) {
            return;
        }
        this.F = qv8Var;
        q(qv8Var);
        if (!UbsABTestHelper.isPbCommentFunAdABTest()) {
            H0();
        }
        if (this.G == null) {
            this.G = new ArrayList<>();
        }
        this.G.clear();
        qv8 qv8Var2 = this.F;
        if (qv8Var2 != null && qv8Var2.F() != null && this.F.F().size() > 0) {
            this.G.addAll(this.F.F());
        }
        if (qv8Var.M() != null && qv8Var.M().getAuthor() != null) {
            this.S = qv8Var.M().getAuthor().getUserId();
        }
        if (this.c == null && !sz8.B(this.a)) {
            return;
        }
        N(qv8Var);
        ArrayList<in> arrayList = new ArrayList<>(qv8Var.F());
        pp9 r = r(arrayList);
        if (this.F.M().isQuestionThread()) {
            pp9Var = s(qv8Var);
        } else {
            pp9Var = null;
        }
        if (pp9Var != null) {
            arrayList.remove(pp9Var);
        }
        if (r != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!gm7.f() && UbsABTestHelper.isPbCommentFunAdABTest() && this.F.r0()) {
            L(arrayList, Boolean.valueOf(z2));
        }
        if (r != null) {
            this.T = r;
        }
        if (!this.L && r != null) {
            arrayList.remove(r);
            if (qv8Var.v0() && r.a0() != null) {
                r.d1(null);
            }
            z2 = true;
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z2 && qv8Var.i() != null) {
            pp9 i6 = qv8Var.i();
            if (!this.L && qv8Var.v0() && i6.a0() != null) {
                i6.d1(null);
            }
            if (!this.L && (pp9Var5 = this.T) != null && i6.i0 == null) {
                qv8Var.E0(pp9Var5);
                pp9Var2 = pp9Var5;
            } else {
                pp9Var2 = i6;
            }
            z2 = true;
            z4 = true;
        } else {
            pp9Var2 = r;
            z4 = z3;
        }
        o(arrayList);
        if (this.a.z5()) {
            if (qv8Var.F().size() > 0 && (pp9Var4 = qv8Var.F().get(0)) != null && pp9Var4.D() == 1 && !ListUtils.isEmpty(arrayList)) {
                arrayList.remove(0);
            }
        } else {
            int E = E(this.F, arrayList, this.L);
            if (E >= 0) {
                ListUtils.add(arrayList, E, this.F.C());
            }
        }
        int F = F(this.F, arrayList, this.L);
        if (F >= 0) {
            ListUtils.add(arrayList, F, this.F.D());
        }
        oo9.f(arrayList, 1);
        int C = C(qv8Var, arrayList);
        if (C >= 0) {
            Y(qv8Var, arrayList, C);
            z5 = true;
        } else {
            z5 = false;
        }
        int H = H(qv8Var, arrayList);
        if (H >= 0) {
            zv8 zv8Var = new zv8(zv8.c);
            zv8Var.b(true);
            ListUtils.add(arrayList, H, zv8Var);
        }
        int w = w(qv8Var, arrayList);
        List<in> x = x(qv8Var);
        if (!ListUtils.isEmpty(x) && w >= 0) {
            in inVar2 = (in) ListUtils.getItem(arrayList, w);
            if (inVar2 instanceof pp9) {
                ((pp9) inVar2).R = true;
            }
            ListUtils.addAll(arrayList, w, x);
            z5 = true;
        }
        if (z2) {
            i = G(qv8Var, arrayList, this.L);
        } else {
            i = -1;
        }
        if (i >= 0 && qv8Var.Q() != null) {
            pp9 V = qv8Var.V();
            ThreadData c2 = qv8Var.Q().c();
            if (V != null && V.q0() != null && c2 != null && c2.getCustomFigure() == null) {
                VirtualImageCustomFigure q0 = V.q0();
                VirtualImageCustomState r0 = V.r0();
                c2.setCustomFigure(q0);
                c2.setCustomState(r0);
            }
            ListUtils.add(arrayList, i, qv8Var.Q());
            z6 = true;
            z7 = true;
        } else {
            if (pp9Var2 != null) {
                pp9Var2.Q = true;
            }
            z6 = z5;
            z7 = false;
        }
        if ((this.F.M().isQuestionThread() && pp9Var != null) || (this.F.M().isQuestionThread() && this.U != null)) {
            if (pp9Var == null && (pp9Var3 = this.U) != null) {
                pp9Var = pp9Var3;
            }
            if (!arrayList.contains(pp9Var)) {
                i++;
                a0(pp9Var, arrayList, i);
            }
        }
        if (W(qv8Var, pp9Var2, arrayList, i) != null || V(qv8Var, pp9Var2, arrayList, i) != null || U(qv8Var, arrayList, i) != null) {
            i++;
        }
        if (R(qv8Var, arrayList, i) != null) {
            i++;
        }
        if (z2) {
            in Z = Z(arrayList, i);
            if (Z != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                if (i >= 0) {
                    i5 = i + 1;
                } else if (w >= 0) {
                    i5 = w;
                } else if (C >= 0) {
                    i5 = C;
                } else {
                    i5 = -1;
                }
                inVar = P(arrayList, i5);
                if (inVar != null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
            } else {
                z11 = z10;
                inVar = Z;
                i5 = -1;
            }
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() == 1) {
                z12 = false;
            } else {
                z12 = true;
            }
            if (z12 && this.F.r0()) {
                this.i0 = i5;
                if (S(arrayList, i5) != null) {
                    this.i0 = -1;
                    i++;
                }
            }
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && z12) {
                z8 = z11;
                i2 = i;
                vy8Var = null;
            } else {
                vy8 X = X(arrayList, inVar, i, i5);
                if (X != null) {
                    if (!z11) {
                        vy8Var = X;
                        i2 = i;
                        z8 = true;
                    } else if (i5 > 0) {
                        i5++;
                    } else {
                        i++;
                    }
                }
                vy8Var = X;
                z8 = z11;
                i2 = i;
            }
            i3 = i5;
        } else {
            i2 = i;
            z8 = false;
            i3 = -1;
            vy8Var = null;
        }
        if (z2) {
            if (vy8Var != null) {
                z9 = true;
            } else {
                z9 = false;
            }
            list = x;
            int i7 = i2;
            i4 = w;
            boolean Q = Q(qv8Var, arrayList, z8, z9, i3, i7, w, C);
            if (vy8Var != null) {
                vy8Var.n = Q;
            }
        } else {
            list = x;
            i4 = w;
        }
        if (sz8.B(this.a)) {
            uv8 uv8Var = new uv8();
            if (qv8Var.M().getTaskInfoData() != null) {
                uv8Var.f(qv8Var.M().getTaskInfoData().r());
                uv8Var.e(qv8Var.M().getTaskInfoData().q());
            }
            ch8.b(arrayList, uv8Var, 0);
            if (!z7 && qv8Var.Q() != null) {
                pp9 V2 = qv8Var.V();
                ThreadData c3 = qv8Var.Q().c();
                if (V2 != null && V2.q0() != null && c3 != null && c3.getCustomFigure() == null) {
                    VirtualImageCustomFigure q02 = V2.q0();
                    VirtualImageCustomState r02 = V2.r0();
                    c3.setCustomFigure(q02);
                    c3.setCustomState(r02);
                }
                ListUtils.add(arrayList, 1, qv8Var.Q());
                z6 = true;
                z7 = true;
                my8Var = this.c;
                if (my8Var != null) {
                    my8Var.e0(!z6);
                }
                boolean G0 = G0(pp9Var2);
                if (this.M && !G0) {
                    arrayList.remove(pp9Var2);
                    this.M = false;
                }
                if (qv8Var.Q() != null) {
                    qv8Var.Q().g(!z7);
                }
                if (this.b != null) {
                    this.H = arrayList;
                    List<in> P = qv8Var.P();
                    if (!ListUtils.isEmpty(P)) {
                        this.b.setData(J(arrayList, P));
                    } else {
                        this.b.setData(this.H);
                    }
                }
                i0(G0, z, i4, list);
                if (!t(pp9Var2, arrayList, z4)) {
                    List<in> P2 = qv8Var.P();
                    if (!ListUtils.isEmpty(P2)) {
                        this.b.setData(J(arrayList, P2));
                        return;
                    } else {
                        this.b.setData(arrayList);
                        return;
                    }
                }
                return;
            }
        }
        my8Var = this.c;
        if (my8Var != null) {
        }
        boolean G02 = G0(pp9Var2);
        if (this.M) {
            arrayList.remove(pp9Var2);
            this.M = false;
        }
        if (qv8Var.Q() != null) {
        }
        if (this.b != null) {
        }
        i0(G02, z, i4, list);
        if (!t(pp9Var2, arrayList, z4)) {
        }
    }

    public final void N(@NonNull qv8 qv8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, qv8Var) == null) {
            my8 my8Var = this.c;
            if (my8Var != null) {
                my8Var.r(qv8Var);
                this.c.setFromCDN(this.I);
                this.c.l(this.R);
                this.c.c(this.K);
                this.c.e(this.W);
                this.c.k(this.V);
                this.c.n(this.Y);
                this.c.d(this.b0);
                this.c.d0(this.Z);
                this.c.f0(this.a0);
            }
            this.g.y(this.Z);
            this.m.r(qv8Var);
            this.m.setFromCDN(this.I);
            this.m.o(this.S);
            this.m.c(this.K);
            this.m.e(this.W);
            this.m.k(this.V);
            this.m.n(this.Y);
            this.m.d(this.b0);
            this.m.r0(this.a0);
            this.n.r(qv8Var);
            this.n.setFromCDN(this.I);
            this.n.o(this.S);
            this.n.c(this.K);
            this.n.e(this.W);
            this.n.k(this.V);
            this.n.n(this.Y);
            this.n.d(this.b0);
            this.n.u0(this.a0);
            this.e.J(this.W);
            this.y.y(this.W);
            this.o.y(this.o0);
            vm vmVar = this.r;
            if (vmVar != null && (vmVar instanceof vd9)) {
                ((vd9) vmVar).setIsFromCDN(this.I);
            }
            Iterator<hx8> it = this.z.iterator();
            while (it.hasNext()) {
                hx8 next = it.next();
                if (next != null) {
                    next.r(qv8Var);
                    next.setFromCDN(this.I);
                    next.o(this.S);
                    next.l(this.R);
                    next.c(this.K);
                    next.f(this.L);
                    next.q(this.Q);
                    next.e(this.W);
                    next.k(this.V);
                    next.n(this.Y);
                    next.d(this.b0);
                }
            }
            this.j.e(this.W);
            this.j.B(this.c0);
            this.k.e(this.X);
            this.l.e(this.W);
            this.j.r(qv8Var);
            this.i.r(qv8Var);
            this.l.r(qv8Var);
            this.v.r(qv8Var);
            this.w.r(qv8Var);
            this.A.A(qv8Var);
            this.A.z(this.a.q1);
            this.B.y(qv8Var);
        }
    }

    public final in P(ArrayList<in> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048600, this, arrayList, i)) == null) {
            if (this.F == null) {
                return null;
            }
            op9 S0 = this.a.Q().S0();
            if (S0 == null) {
                S0 = this.F.z();
            }
            if (S0 == null) {
                return null;
            }
            AdvertAppInfo.ILegoAdvert v1 = S0.v1();
            if (v1 != null) {
                v1.setAdvertAppInfo(S0.getAdvertAppInfo());
            }
            int h = S0.getAdvertAppInfo().h();
            if (h != 0) {
                of9.j(S0, h);
                if (h != 28 && h != 31) {
                    S0.getAdvertAppInfo().c = -1001;
                }
                return null;
            }
            if (this.F.k() != null) {
                S0.d1 = this.F.k().getId();
            }
            if (this.F.M() != null) {
                S0.g1 = gg.g(this.F.M().getId(), 0L);
            }
            qv8 qv8Var = this.F;
            if (qv8Var != null && qv8Var.y() != null) {
                S0.h1 = this.F.y().a();
            }
            l(S0);
            if (i < 0) {
                return null;
            }
            S0.k1 = 1;
            zz5.k().q(true);
            ch8.b(arrayList, S0, i);
            if (s06.i().q()) {
                s06.i().n(arrayList, i + 1, 4);
            }
            return S0;
        }
        return (in) invokeLI.objValue;
    }

    public final in S(ArrayList<in> arrayList, int i) {
        InterceptResult invokeLI;
        qv8 qv8Var;
        np9 np9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048603, this, arrayList, i)) == null) {
            if (sz8.B(this.a)) {
                return null;
            }
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && i > 0 && (qv8Var = this.F) != null && qv8Var.r0()) {
                String d2 = fm7.e().d("pb_banner");
                if (this.j0 == null && zl7.m().v(d2)) {
                    ThreadData threadData = new ThreadData();
                    this.j0 = threadData;
                    threadData.funAdData = new np9();
                    qv8 qv8Var2 = this.F;
                    if (qv8Var2 != null) {
                        this.j0.funAdData.m(qv8Var2.l());
                        this.j0.funAdData.r(this.F.O());
                    }
                }
                ThreadData threadData2 = this.j0;
                if (threadData2 != null && (np9Var = threadData2.funAdData) != null) {
                    np9Var.j(1);
                    zz5.k().q(true);
                    ListUtils.add(arrayList, i, this.j0);
                    if (s06.i().q()) {
                        s06.i().n(arrayList, i + 1, 4);
                    }
                }
            }
            return this.j0;
        }
        return (in) invokeLI.objValue;
    }

    public final boolean Q(qv8 qv8Var, ArrayList<in> arrayList, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{qv8Var, arrayList, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            ArrayList arrayList2 = new ArrayList();
            if (!ListUtils.isEmpty(qv8Var.e()) && qv8Var.e().size() > 2) {
                int min = Math.min(qv8Var.e().size(), 7);
                for (int i6 = 0; i6 < min; i6++) {
                    rx4 rx4Var = qv8Var.e().get(i6);
                    if (!z2 && i6 == 0) {
                        rx4Var.h(true);
                    }
                    if (rx4Var.getThreadVideoInfo() == null) {
                        if (i6 == min - 1) {
                            rx4Var.k(true);
                        }
                    } else if (i6 == min - 2) {
                        rx4Var.k(true);
                    } else if (i6 == min - 1) {
                        rx4Var.j(true);
                    }
                    arrayList2.add(rx4Var);
                }
            }
            if (arrayList2.size() > 0) {
                if (z && i >= 0) {
                    i5 = i + 1;
                } else if (z) {
                    i5 = i2 + 2;
                } else if (i2 >= 0) {
                    i5 = i2 + 1;
                } else if (i3 >= 0) {
                    i5 = i3;
                } else if (i4 >= 0) {
                    i5 = i4;
                } else {
                    i5 = -1;
                }
                if (i5 >= 0 && arrayList2.size() > 1) {
                    for (int size = arrayList2.size() - 1; size >= 0; size--) {
                        ListUtils.add(arrayList, i5, arrayList2.get(size));
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final in R(qv8 qv8Var, ArrayList<in> arrayList, int i) {
        InterceptResult invokeLLI;
        nv8 nv8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048602, this, qv8Var, arrayList, i)) == null) {
            if (i >= 0 && qv8Var != null && qv8Var.k && (nv8Var = qv8Var.l) != null) {
                ListUtils.add(arrayList, i, nv8Var);
                return nv8Var;
            }
            return null;
        }
        return (in) invokeLLI.objValue;
    }

    public final void a0(pp9 pp9Var, ArrayList<in> arrayList, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048611, this, pp9Var, arrayList, i) == null) {
            pp9Var.j1(true);
            arrayList.add(i, pp9Var);
        }
    }

    public final void T(int i, int i2, int i3, ArrayList<in> arrayList) {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), arrayList}) == null) && !ListUtils.isEmpty(arrayList) && i >= 0 && i2 >= 1) {
            ListIterator<in> listIterator = arrayList.listIterator();
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 1;
            while (true) {
                str = "";
                if (!listIterator.hasNext()) {
                    break;
                }
                if (i4 == i || (i4 > i && (i4 - i) % i2 == 0)) {
                    if (i5 >= i3) {
                        break;
                    }
                    if (i5 < this.k0.size()) {
                        listIterator.add(this.k0.get(i5));
                    } else {
                        pp9 pp9Var = new pp9();
                        np9 np9Var = new np9();
                        qv8 qv8Var = this.F;
                        if (qv8Var == null) {
                            str3 = "";
                        } else {
                            str3 = qv8Var.l();
                        }
                        np9Var.m(str3);
                        qv8 qv8Var2 = this.F;
                        if (qv8Var2 != null) {
                            str = qv8Var2.O();
                        }
                        np9Var.r(str);
                        np9Var.n(true);
                        pp9Var.w0 = np9Var;
                        np9Var.j(i7);
                        listIterator.add(pp9Var);
                        i7++;
                        this.k0.add(pp9Var);
                    }
                    i5++;
                    if (i6 == 0) {
                        i6 = i4 + 1;
                    }
                }
                listIterator.next();
                i4++;
            }
            if (i6 > 0 && s06.i().q()) {
                s06.i().n(arrayList, i6, 5);
            }
            if (i4 == i && i5 < i3) {
                pp9 pp9Var2 = new pp9();
                np9 np9Var2 = new np9();
                qv8 qv8Var3 = this.F;
                if (qv8Var3 == null) {
                    str2 = "";
                } else {
                    str2 = qv8Var3.l();
                }
                np9Var2.m(str2);
                qv8 qv8Var4 = this.F;
                if (qv8Var4 != null) {
                    str = qv8Var4.O();
                }
                np9Var2.r(str);
                np9Var2.n(true);
                pp9Var2.w0 = np9Var2;
                np9Var2.j(1);
                listIterator.add(pp9Var2);
                this.k0.add(pp9Var2);
                if (s06.i().q()) {
                    s06.i().n(arrayList, -1, 4);
                }
            }
        }
    }

    public final in V(qv8 qv8Var, pp9 pp9Var, ArrayList<in> arrayList, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048606, this, qv8Var, pp9Var, arrayList, i)) == null) {
            tv8 tv8Var = null;
            if (qv8Var.k() != null && !StringUtils.isNull(qv8Var.k().getName()) && TextUtils.equals(qv8Var.k().getName(), this.a.Q().Y0()) && this.a.Q().e1()) {
                return null;
            }
            if (pp9Var != null) {
                if (pp9Var.r0 != null) {
                    tv8Var = new tv8(pp9Var.r0);
                }
            } else {
                pp9 pp9Var2 = this.T;
                if (pp9Var2 != null && pp9Var2.r0 != null) {
                    tv8Var = new tv8(this.T.r0);
                }
            }
            if (tv8Var != null) {
                tv8Var.b = this.a.Q().S1();
                ListUtils.add(arrayList, i + 1, tv8Var);
            }
            return tv8Var;
        }
        return (in) invokeLLLI.objValue;
    }

    public final in W(qv8 qv8Var, pp9 pp9Var, ArrayList<in> arrayList, int i) {
        InterceptResult invokeLLLI;
        PbFirstFloorRecommendData pbFirstFloorRecommendData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048607, this, qv8Var, pp9Var, arrayList, i)) == null) {
            if (pp9Var != null && pp9Var.X() != null) {
                pbFirstFloorRecommendData = new PbFirstFloorRecommendData(pp9Var.X());
            } else {
                pp9 pp9Var2 = this.T;
                if (pp9Var2 != null && pp9Var2.X() != null) {
                    pbFirstFloorRecommendData = new PbFirstFloorRecommendData(this.T.X());
                } else {
                    pbFirstFloorRecommendData = null;
                }
            }
            if (pbFirstFloorRecommendData != null) {
                if (qv8Var != null && !TextUtils.isEmpty(qv8Var.O())) {
                    pbFirstFloorRecommendData.f(qv8Var.O());
                }
                ListUtils.add(arrayList, i + 1, pbFirstFloorRecommendData);
            }
            return pbFirstFloorRecommendData;
        }
        return (in) invokeLLLI.objValue;
    }

    public final void i0(boolean z, boolean z2, int i, List<in> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), list}) == null) && !z && !z2) {
            if ((this.O || this.N) && i != -1 && !ListUtils.isEmpty(list) && !this.P) {
                this.f0 = new e(this, list);
                jg.a().post(this.f0);
            }
        }
    }

    public final vy8 X(ArrayList<in> arrayList, in inVar, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048608, this, arrayList, inVar, i, i2)) == null) {
            vy8 B = this.F.B();
            if (B != null) {
                if (inVar != null) {
                    if (i2 < 0 && inVar.getType() != AdvertAppInfo.z) {
                        i2 = i + 2;
                    } else if (inVar.getType() != AdvertAppInfo.z) {
                        i2++;
                    } else {
                        i2 = -1;
                    }
                }
                if (i2 > 0 && (B instanceof vy8)) {
                    ListUtils.add(arrayList, i2, B);
                    return B;
                }
                return null;
            }
            return null;
        }
        return (vy8) invokeLLII.objValue;
    }

    public final in Z(ArrayList<in> arrayList, int i) {
        InterceptResult invokeLI;
        PbModel Q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048610, this, arrayList, i)) == null) {
            if (i < 0 || (Q = this.a.Q()) == null || TextUtils.isEmpty(Q.D1())) {
                return null;
            }
            op9 op9Var = new op9();
            l(op9Var);
            ListUtils.add(arrayList, i + 1, op9Var);
            return op9Var;
        }
        return (in) invokeLI.objValue;
    }

    public void f0(boolean z, int i) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048616, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && (pbFragment = this.a) != null && pbFragment.I5() != null) {
            this.a.I5().Z1(z, i);
        }
    }

    public void e0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        my8 my8Var = this.c;
                        if (my8Var != null) {
                            my8Var.X();
                        }
                        PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter = this.D;
                        if (pbFirstFloorWebViewAdapter != null) {
                            pbFirstFloorWebViewAdapter.onDestroy();
                        }
                        vm vmVar = this.r;
                        if (vmVar instanceof qd9) {
                            ((qd9) vmVar).onDestroy();
                        }
                        vm vmVar2 = this.s;
                        if (vmVar2 instanceof qd9) {
                            ((qd9) vmVar2).onDestroy();
                        }
                        vm vmVar3 = this.u;
                        if (vmVar3 instanceof qd9) {
                            ((qd9) vmVar3).onDestroy();
                        }
                        iy8.a().d();
                        return;
                    }
                    return;
                }
                my8 my8Var2 = this.c;
                if (my8Var2 != null) {
                    my8Var2.Y();
                }
                PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter2 = this.D;
                if (pbFirstFloorWebViewAdapter2 != null) {
                    pbFirstFloorWebViewAdapter2.onResume();
                }
                vm vmVar4 = this.r;
                if (vmVar4 instanceof qd9) {
                    ((qd9) vmVar4).onResume();
                }
                vm vmVar5 = this.s;
                if (vmVar5 instanceof qd9) {
                    ((qd9) vmVar5).onResume();
                }
                vm vmVar6 = this.u;
                if (vmVar6 instanceof qd9) {
                    ((qd9) vmVar6).onResume();
                }
                k0(false);
                j0();
                return;
            }
            my8 my8Var3 = this.c;
            if (my8Var3 != null) {
                my8Var3.W();
            }
            PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter3 = this.D;
            if (pbFirstFloorWebViewAdapter3 != null) {
                pbFirstFloorWebViewAdapter3.onPause();
            }
            vm vmVar7 = this.r;
            if (vmVar7 instanceof qd9) {
                ((qd9) vmVar7).onPause();
            }
            vm vmVar8 = this.s;
            if (vmVar8 instanceof qd9) {
                ((qd9) vmVar8).onPause();
            }
            vm vmVar9 = this.u;
            if (vmVar9 instanceof qd9) {
                ((qd9) vmVar9).onPause();
            }
            iy8.a().i(this.a.R());
            ul5.a().d();
        }
    }

    public void k0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048621, this, z) == null) && this.a.I5() != null && this.a.R() != null && this.a.R().K1() != null) {
            iy8.a().f(this.a.R().K1().m2(), this.j.x(), this.a.I5().e1(), this.a.R().getPageStayDurationItem(), z, this.E.b(), this.a.getListView());
        }
    }

    public final void o(List<in> list) {
        int size;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048628, this, list) == null) && list != null && (size = list.size()) > 0) {
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (list.get(i2) instanceof pp9) {
                    if (i == 0 && (list.get(i2) instanceof op9)) {
                        i = i2 + 1;
                    }
                    pp9 pp9Var = (pp9) list.get(i2);
                    if (!TextUtils.isEmpty(pp9Var.U())) {
                        ry4 ry4Var = new ry4();
                        ry4Var.e(pp9Var.U());
                        list.set(i2, ry4Var);
                    }
                }
            }
            if (i > 0 && s06.i().q()) {
                s06.i().n(list, i, 5);
            }
        }
    }

    public void q(qv8 qv8Var) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048632, this, qv8Var) == null) && qv8Var.M() != null && qv8Var.M().getTaskInfoData() != null && ThreadCardUtils.isHeadlinesCard(qv8Var.M().getTaskInfoData())) {
            DefaultLog.getInstance().c("PbAdapterManager", "动态修正头条卡信息");
            if (this.D == null && this.b != null) {
                sz8.F(this.a, qv8Var.M().getTaskInfoData().j());
                p();
                this.b.F();
                this.b.addAdapters(this.d0);
            }
            PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter = this.D;
            if (pbFirstFloorWebViewAdapter != null && pbFirstFloorWebViewAdapter.t() != 1 && (pbFragment = this.a) != null && pbFragment.I5() != null) {
                this.a.I5().d4();
            }
        }
    }

    public final void l(op9 op9Var) {
        ForumData k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048622, this, op9Var) == null) && op9Var != null && this.F != null && op9Var.getAdvertAppInfo() != null) {
            op9Var.getAdvertAppInfo().i = new fx4();
            if (this.F.y() != null) {
                op9Var.getAdvertAppInfo().i.b = this.F.y().a();
            }
            op9Var.getAdvertAppInfo().i.a = op9Var.u1();
            if (this.F.k() != null && (k = this.F.k()) != null) {
                op9Var.getAdvertAppInfo().i.c = k.getId();
                op9Var.getAdvertAppInfo().i.d = k.getFirst_class();
                op9Var.getAdvertAppInfo().i.e = k.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                op9Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            op9Var.getAdvertAppInfo().i.g = op9Var.getAdvertAppInfo().g;
            op9Var.getAdvertAppInfo().i.h = false;
        }
    }

    public final List<in> x(qv8 qv8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048646, this, qv8Var)) == null) {
            if (qv8Var == null || qv8Var.R() == null || ListUtils.isEmpty(qv8Var.R().a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<pp9> list = qv8Var.R().a;
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            int min = Math.min(2, list.size());
            for (int i = 0; i < min; i++) {
                pp9 pp9Var = list.get(i);
                if (pp9Var != null) {
                    pp9Var.c0 = true;
                    pp9Var.P = true;
                    arrayList.add(pp9Var);
                }
            }
            if (ListUtils.getCount(qv8Var.R().b) > 2) {
                in inVar = (in) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (inVar instanceof pp9) {
                    ((pp9) inVar).P = false;
                }
                arrayList.add(new x29());
            } else {
                in inVar2 = (in) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (inVar2 instanceof pp9) {
                    ((pp9) inVar2).P = true;
                }
            }
            arrayList.add(0, new ew8(ew8.h));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            if (this.a == null) {
                return false;
            }
            this.q0 = new ArrayList();
            ArrayList<BdUniqueId> g = oo9.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                ug8 b2 = zh8.d().b(this.a.getPageContext(), g.get(i), 2);
                if (b2 != null) {
                    this.d0.add(b2);
                    this.q0.add(b2);
                }
            }
            if (!ListUtils.isEmpty(this.q0)) {
                this.b.addAdapters(this.q0);
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean t(pp9 pp9Var, ArrayList<in> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048638, this, pp9Var, arrayList, z)) == null) {
            if (pp9Var == null) {
                pp9 pp9Var2 = this.T;
                if (pp9Var2 != null && !this.N) {
                    ListUtils.add(arrayList, 0, pp9Var2);
                } else {
                    pp9 pp9Var3 = new pp9();
                    pp9Var3.L0(1);
                    ListUtils.add(arrayList, 0, pp9Var3);
                }
                return true;
            } else if (!z) {
                return false;
            } else {
                ListUtils.add(arrayList, 0, pp9Var);
                return true;
            }
        }
        return invokeLLZ.booleanValue;
    }
}
