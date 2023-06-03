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
import com.baidu.tieba.card.data.BaseCardInfo;
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
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorSimilarTitleAdapter;
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
public class a69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbReplyLoadMoreAdapter A;
    public ArrayList<c59> B;
    public b69 C;
    public t69 D;
    public g89 E;
    public PbFirstFloorWebViewAdapter F;
    public d59 G;
    public j39 H;
    public ArrayList<ey9> I;
    public ArrayList<vn> J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;

    /* renamed from: T  reason: collision with root package name */
    public int f1087T;
    public String U;
    public ey9 V;
    public ey9 W;
    public View.OnClickListener X;
    public View.OnClickListener Y;
    public View.OnClickListener Z;
    public PbFragment a;
    public TbRichTextView.a0 a0;
    public BdTypeListView b;
    public View.OnClickListener b0;
    public l69 c;
    public p49 c0;
    public m69 d;
    public View.OnLongClickListener d0;
    public PbFirstFloorCommentAndPraiseAdapter e;
    public SortSwitchButton.f e0;
    public PbFirstFloorEnterForumAdapter f;
    public final List<in> f0;
    public PbFirstFloorItemAdapter g;
    public final List<in> g0;
    public PbFirstFloorRecommendAdapter h;
    public Runnable h0;
    public PbFirstFloorSimilarTitleAdapter i;
    public int i0;
    public h89 j;
    public int j0;
    public e89 k;
    public int k0;
    public j79 l;
    public ThreadData l0;
    public x69 m;
    public List<ey9> m0;
    public j79 n;
    public final CustomMessageListener n0;
    public d69 o;
    public CustomMessageListener o0;
    public m79 p;
    public final CustomMessageListener p0;
    public za9 q;
    public final View.OnClickListener q0;
    public bp6 r;
    public CustomMessageListener r0;
    public in s;
    public List<in> s0;
    public in t;
    public in u;
    public in v;
    public in w;
    public f79 x;
    public h79 y;
    public e79 z;

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a69 a;

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
                    this.a.a.f0();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a69 a69Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a69Var, Integer.valueOf(i)};
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
            this.a = a69Var;
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.H != null && !q9.c(this.a.a.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    wg.a().postDelayed(new a(this), TimeUnit.SECONDS.toMillis(2L));
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
        public final /* synthetic */ a69 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(a69 a69Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a69Var, Integer.valueOf(i)};
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
            this.a = a69Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof cy9)) {
                cy9 cy9Var = (cy9) customResponsedMessage.getData();
                if (this.a.l0 != null && this.a.l0.funAdData == cy9Var) {
                    this.a.l0.funAdData.p(true);
                    this.a.b.setData(this.a.J);
                    this.a.f0();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a69 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a69 a69Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a69Var, Integer.valueOf(i)};
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
            this.a = a69Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof tx9)) {
                AbsDelegateAdapterList a = ((tx9) customResponsedMessage.getData()).a();
                Iterator<in<?, ?>> it = a.iterator();
                while (it.hasNext()) {
                    in<?, ?> next = it.next();
                    if (next instanceof f69) {
                        ((f69) next).t(this.a.a);
                        if (next instanceof c59) {
                            this.a.B.add((c59) next);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(a);
                this.a.g0.clear();
                this.a.g0.addAll(arrayList);
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
        public final /* synthetic */ a69 a;

        public d(a69 a69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a69Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a != null && this.a.H != null && this.a.H.S() != null) {
                this.a.a.L5().c1().v();
                TiebaStatic.log(new StatisticItem("c12040"));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ a69 b;

        public e(a69 a69Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a69Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a69Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.b.setSelectionFromTop(this.b.b.getHeaderViewsCount() + this.a.size(), 0 - this.b.j0);
                this.b.R = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a69 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(a69 a69Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a69Var, Integer.valueOf(i)};
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
            this.a = a69Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.s0)) {
                this.a.n();
                a69 a69Var = this.a;
                a69Var.n0(a69Var.H, false);
            }
        }
    }

    public a69(PbFragment pbFragment, BdTypeListView bdTypeListView) {
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
        this.B = new ArrayList<>();
        this.I = new ArrayList<>();
        this.K = false;
        this.L = false;
        this.M = true;
        this.N = true;
        this.O = false;
        this.P = false;
        this.S = false;
        this.f1087T = 0;
        this.U = null;
        this.V = null;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.a0 = null;
        this.b0 = null;
        this.c0 = null;
        this.d0 = null;
        this.e0 = null;
        this.f0 = new ArrayList();
        this.g0 = new ArrayList();
        this.i0 = -1;
        this.j0 = 0;
        this.k0 = -1;
        this.m0 = new ArrayList();
        this.n0 = new a(this, 2921523);
        this.o0 = new b(this, 2004015);
        this.p0 = new c(this, 2001118);
        this.q0 = new d(this);
        this.r0 = new f(this, 2016470);
        this.f1087T = vi.l(pbFragment.getPageContext().getPageActivity());
        this.a = pbFragment;
        this.b = bdTypeListView;
        N(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.p0);
        this.j0 = vi.j(this.a.getContext()) / 3;
    }

    public final vn Q(ArrayList<vn> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048604, this, arrayList, i)) == null) {
            if (this.H == null) {
                return null;
            }
            dy9 R0 = this.a.Q().R0();
            if (R0 == null) {
                R0 = this.H.z();
            }
            if (R0 == null) {
                return null;
            }
            AdvertAppInfo.ILegoAdvert v1 = R0.v1();
            if (v1 != null) {
                v1.setAdvertAppInfo(R0.getAdvertAppInfo());
            }
            int i2 = R0.getAdvertAppInfo().i();
            if (i2 != 0) {
                sn9.j(R0, i2);
                if (i2 != 28 && i2 != 31) {
                    R0.getAdvertAppInfo().c = -1001;
                }
                return null;
            }
            if (this.H.k() != null) {
                R0.d1 = this.H.k().getId();
            }
            if (this.H.N() != null) {
                R0.g1 = tg.g(this.H.N().getId(), 0L);
            }
            j39 j39Var = this.H;
            if (j39Var != null && j39Var.y() != null) {
                R0.h1 = this.H.y().a();
            }
            l(R0);
            if (i < 0) {
                return null;
            }
            R0.k1 = 1;
            m56.k().q(true);
            vo8.b(arrayList, R0, i);
            j39 j39Var2 = this.H;
            if (j39Var2 != null) {
                j39Var2.L0(R0);
            }
            if (f66.i().q()) {
                f66.i().n(arrayList, i + 1, 4);
            }
            return R0;
        }
        return (vn) invokeLI.objValue;
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

    public void B0(TbRichTextView.a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, a0Var) == null) {
            this.a0 = a0Var;
        }
    }

    public void C0(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onLongClickListener) == null) {
            this.d0 = onLongClickListener;
        }
    }

    public void D0(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) {
            this.e0 = fVar;
        }
    }

    public void E0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onClickListener) == null) {
            this.Y = onClickListener;
        }
    }

    public void F0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) {
            this.b0 = onClickListener;
        }
    }

    public void G0(p49 p49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, p49Var) == null) {
            this.c0 = p49Var;
        }
    }

    public void I0(@NonNull j39 j39Var) {
        l69 l69Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, j39Var) == null) && (l69Var = this.c) != null) {
            l69Var.i0(j39Var);
        }
    }

    public final void P(PbFragment pbFragment) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048603, this, pbFragment) == null) && pbFragment != null && pbFragment.getPageContext() != null) {
            DefaultLog.getInstance().c("PbAdapterManager", "初始化PbFirstFloorWebViewAdapter");
            this.F = new PbFirstFloorWebViewAdapter(pbFragment, p39.c);
        }
    }

    public void j0(boolean z) {
        l69 l69Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048623, this, z) == null) && (l69Var = this.c) != null) {
            l69Var.V(z);
        }
    }

    public void p0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048634, this, z) == null) {
            this.L = z;
        }
    }

    public void q0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048636, this, z) == null) {
            this.O = z;
        }
    }

    public void r0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048638, this, z) == null) {
            this.M = z;
        }
    }

    public final ey9 s(j39 j39Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, j39Var)) == null) {
            if (j39Var != null && j39Var.T() != null) {
                ey9 T2 = j39Var.T();
                this.W = T2;
                return T2;
            }
            return null;
        }
        return (ey9) invokeL.objValue;
    }

    public void s0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048640, this, z) == null) {
            this.S = z;
        }
    }

    public void t0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z) == null) {
            this.P = z;
        }
    }

    public void u0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048644, this, z) == null) {
            this.Q = z;
        }
    }

    public void v0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048646, this, z) == null) {
            this.N = z;
        }
    }

    public void w0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048648, this, z) == null) {
            this.R = z;
        }
    }

    public void x0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, onClickListener) == null) {
            this.Z = onClickListener;
        }
    }

    public void y0(boolean z) {
        d69 d69Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048652, this, z) == null) && (d69Var = this.o) != null) {
            d69Var.p0(z);
        }
    }

    public vn z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048653, this, i)) == null) {
            return this.b.G(i);
        }
        return (vn) invokeI.objValue;
    }

    public void z0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, onClickListener) == null) {
            this.X = onClickListener;
        }
    }

    public final int I(n39 n39Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, n39Var, i)) == null) {
            if (n39Var.e0()) {
                if (i == 25) {
                    return 4;
                }
                return 5;
            }
            if (n39Var.f0()) {
                if (i == 2) {
                    return 1;
                }
                if (i == 3) {
                    return 2;
                }
            }
            return 3;
        }
        return invokeLI.intValue;
    }

    public void A0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            d69 d69Var = this.o;
            if (d69Var != null) {
                d69Var.q0(z);
            }
            j79 j79Var = this.l;
            if (j79Var != null) {
                j79Var.A(z);
            }
            in inVar = this.w;
            if (inVar != null) {
                inVar.setMulDel(z);
            }
            in inVar2 = this.t;
            if (inVar2 != null) {
                inVar2.setMulDel(z);
            }
            l69 l69Var = this.c;
            if (l69Var != null) {
                l69Var.setMulDel(z);
            }
        }
    }

    public final boolean J0(ey9 ey9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, ey9Var)) == null) {
            if (this.a.Q() != null && ey9Var != null && ey9Var.O() != null && ey9Var.O().equals(this.a.Q().X1())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void o0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
            this.K = z;
            l69 l69Var = this.c;
            if (l69Var != null) {
                l69Var.setFromCDN(z);
            }
            in inVar = this.t;
            if (inVar != null && (inVar instanceof zl9)) {
                ((zl9) inVar).setIsFromCDN(z);
            }
            Iterator<c59> it = this.B.iterator();
            while (it.hasNext()) {
                it.next().setFromCDN(z);
            }
        }
    }

    public final ey9 r(ArrayList<vn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, arrayList)) == null) {
            Iterator<vn> it = arrayList.iterator();
            while (it.hasNext()) {
                vn next = it.next();
                if (next instanceof ey9) {
                    ey9 ey9Var = (ey9) next;
                    if (ey9Var.D() == 1) {
                        return ey9Var;
                    }
                }
            }
            return null;
        }
        return (ey9) invokeL.objValue;
    }

    public PbFirstFloorCommentAndPraiseAdapter B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    public void H0() {
        x69 x69Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (x69Var = this.m) != null) {
            x69Var.z(2);
        }
    }

    public int J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.i0;
        }
        return invokeV.intValue;
    }

    public void L0() {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (i = this.k0) > 0 && T(this.J, i) != null) {
            this.k0 = -1;
            this.b.setData(this.J);
            f0();
        }
    }

    public boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.K;
        }
        return invokeV.booleanValue;
    }

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.M;
        }
        return invokeV.booleanValue;
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.i0 = D();
            if (this.b.getAdapter2() instanceof mn) {
                this.b.getAdapter2().notifyDataSetChanged();
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048627, this) == null) && this.a != null && !n()) {
            this.a.registerListener(this.r0);
        }
    }

    public View u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            return this.G.b();
        }
        return (View) invokeV.objValue;
    }

    public ArrayList<vn> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            return this.J;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            return this.b.getHeaderViewsCount();
        }
        return invokeV.intValue;
    }

    public final int C(j39 j39Var, ArrayList<vn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, j39Var, arrayList)) == null) {
            if (j39Var == null || ListUtils.isEmpty(j39Var.F()) || ListUtils.isEmpty(arrayList) || ((ey9) ListUtils.getItem(j39Var.F(), 0)) == null) {
                return 0;
            }
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    vn vnVar = arrayList.get(i);
                    if (vnVar instanceof ey9) {
                        ey9 ey9Var = (ey9) vnVar;
                        if (ey9Var.D() == 1 && ey9Var.O == 0) {
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

    public final int H(j39 j39Var, ArrayList<vn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, j39Var, arrayList)) == null) {
            int i = -1;
            if (j39Var == null || j39Var.y() == null) {
                return -1;
            }
            int i2 = 0;
            if (j39Var.y().c() == 1) {
                z = true;
            } else {
                z = false;
            }
            int size = arrayList.size();
            if (!z || !this.L) {
                return -1;
            }
            while (true) {
                if (i2 >= size) {
                    break;
                } else if (arrayList.get(i2) instanceof z39) {
                    i = i2 + 1;
                    break;
                } else {
                    i2++;
                }
            }
            if (j39Var.J() == 4) {
                return i + 1;
            }
            return i;
        }
        return invokeLL.intValue;
    }

    public final void M(ArrayList<vn> arrayList, Boolean bool) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048600, this, arrayList, bool) != null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        int i = hc5.i();
        int j = hc5.j() - 1;
        if (bool.booleanValue()) {
            vn vnVar = arrayList.get(0);
            if ((vnVar instanceof ey9) && ((ey9) vnVar).D() == 1) {
                j++;
            }
        }
        int k = hc5.k() + 1;
        PbFragment pbFragment = this.a;
        if (pbFragment != null && pbFragment.Q() != null && this.a.Q().I1() == 3) {
            this.m0.clear();
        }
        U(j, i, k, arrayList);
    }

    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            BdTypeListView bdTypeListView = this.b;
            if (bdTypeListView != null && bdTypeListView.getData() != null) {
                for (int i = 0; i < this.b.getData().size(); i++) {
                    vn vnVar = this.b.getData().get(i);
                    if (vnVar != null && vnVar.getType() == z39.g) {
                        return i;
                    }
                }
                return -1;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            wg.a().removeCallbacks(this.h0);
            j79 j79Var = this.l;
            if (j79Var != null) {
                j79Var.onDestroy();
            }
            j79 j79Var2 = this.n;
            if (j79Var2 != null) {
                j79Var2.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.e;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
            e89 e89Var = this.k;
            if (e89Var != null) {
                e89Var.onDestroy();
            }
            m56.k().q(false);
        }
    }

    public int E(j39 j39Var, ArrayList<vn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j39Var, arrayList, z)) == null) {
            if (j39Var == null || j39Var.F() == null || j39Var.C() == null || j39Var.F().size() == 0 || j39Var.N() == null || arrayList == null || !j39Var.C().s1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (j39Var.F().get(0) == null || j39Var.F().get(0).D() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (j39Var.y() == null || j39Var.y().a() != j39Var.y().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public int F(j39 j39Var, ArrayList<vn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048586, this, j39Var, arrayList, z)) == null) {
            if (j39Var == null || j39Var.F() == null || j39Var.D() == null || j39Var.F().size() == 0 || j39Var.N() == null || arrayList == null || !j39Var.D().s1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (j39Var.F().get(0) == null || j39Var.F().get(0).D() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (j39Var.y() == null || j39Var.y().a() != j39Var.y().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final vn V(j39 j39Var, ArrayList<vn> arrayList, int i) {
        InterceptResult invokeLLI;
        l39 l39Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048609, this, j39Var, arrayList, i)) == null) {
            if (j39Var.k() != null && !StringUtils.isNull(j39Var.k().getName()) && !j39Var.m) {
                if (!TextUtils.equals(j39Var.k().getName(), this.a.Q().X0()) || !this.a.Q().d1()) {
                    if (!this.a.z0() && !ListUtils.isEmpty(j39Var.o())) {
                        l39Var = new l39(j39Var.o().get(0));
                    } else {
                        l39Var = new l39(j39Var.k());
                    }
                    l39Var.g = this.a.Q().R1();
                    if (!UbsABTestHelper.isPbEnterForum()) {
                        i++;
                    }
                    ListUtils.add(arrayList, i, l39Var);
                    return l39Var;
                }
                return null;
            }
            return null;
        }
        return (vn) invokeLLI.objValue;
    }

    public final int b0(j39 j39Var, ArrayList<vn> arrayList, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048615, this, j39Var, arrayList, i)) == null) {
            n39 n39Var = new n39(j39Var.M());
            String tid = n39Var.d0().getTid();
            int x1 = this.a.Q().x1();
            j39Var.N0(I(n39Var, x1));
            o39 o39Var = new o39(n39Var.b0(), n39Var.c0());
            o39Var.a = n39Var.d0();
            o39Var.C = x1;
            o39Var.g = tid;
            int i2 = i + 1;
            ListUtils.add(arrayList, i2, o39Var);
            n39Var.d0().isLinkThread();
            n39Var.d0().isSmartAppThreadType();
            if (!n39Var.d0().isLinkThread() && !n39Var.d0().isSmartAppThreadType()) {
                n39Var.d0().isGodThread();
            }
            n39Var.a = n39Var.d0();
            n39Var.C = x1;
            n39Var.g = tid;
            n39Var.setSupportType(BaseCardInfo.SupportType.NONE);
            ListUtils.add(arrayList, i2 + 1, n39Var);
            return i2;
        }
        return invokeLLI.intValue;
    }

    public final int G(j39 j39Var, ArrayList<vn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048588, this, j39Var, arrayList, z)) == null) {
            if (j39Var != null && !ListUtils.isEmpty(j39Var.F()) && arrayList != null && arrayList.size() > 0) {
                if (!z) {
                    return 0;
                }
                if (j39Var.F().get(0) != null && j39Var.F().get(0).D() == 1) {
                    return 1;
                }
                if (!this.P) {
                    return -1;
                }
                return 0;
            } else if (j39Var == null || !j39Var.w0()) {
                return -1;
            } else {
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final void Z(j39 j39Var, ArrayList<vn> arrayList, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048613, this, j39Var, arrayList, i) == null) {
            z39 z39Var = new z39(z39.g);
            ThreadData N = j39Var.N();
            z39Var.c = this.a.d6();
            z39Var.b = j39Var.g;
            z39Var.d = j39Var.i0();
            z39Var.e = j39Var.f;
            if (N != null && N.isQuestionThread()) {
                z = true;
            } else {
                z = false;
            }
            z39Var.f = z;
            ListUtils.add(arrayList, i, z39Var);
            if (j39Var.J() == 4) {
                ListUtils.add(arrayList, i + 1, new y39());
            }
        }
    }

    public final ArrayList<vn> K(List<vn> list, List<vn> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, list, list2)) == null) {
            ArrayList<vn> arrayList = new ArrayList<>(list.size() + list2.size() + 2);
            arrayList.addAll(list);
            s39 s39Var = new s39();
            PbListView g1 = this.a.L5().g1();
            if (g1 != null && g1.q()) {
                s39Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fb0);
                s39Var.b = true;
            } else {
                s39Var.a = TbadkCoreApplication.getInst().getString(R.string.list_has_all_comments);
                s39Var.b = false;
            }
            arrayList.add(s39Var);
            ep6 ep6Var = new ep6();
            ep6Var.a = TbadkCoreApplication.getInst().getString(R.string.recommed_for_you);
            ep6Var.needTopMargin = false;
            arrayList.add(ep6Var);
            arrayList.addAll(list2);
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public final int w(j39 j39Var, ArrayList<vn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048647, this, j39Var, arrayList)) == null) {
            if (!this.P && j39Var != null && !ListUtils.isEmpty(j39Var.F()) && arrayList != null && arrayList.size() > 0) {
                if (this.a.Q() != null && this.a.Q().h1()) {
                    return -1;
                }
                if (this.a.L5() != null && this.a.L5().Y0()) {
                    return -1;
                }
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    if (i < size) {
                        vn vnVar = arrayList.get(i);
                        if (vnVar instanceof ey9) {
                            ey9 ey9Var = (ey9) vnVar;
                            if (ey9Var.D() == 1 && ey9Var.O == 0) {
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
                    if (j39Var.w0()) {
                        return 0;
                    }
                    return -1;
                }
                return i + 1;
            } else if (j39Var != null && j39Var.w0() && this.N) {
                return 0;
            } else {
                return -1;
            }
        }
        return invokeLL.intValue;
    }

    public final void K0() {
        j39 j39Var;
        dy9 dy9Var;
        dy9 dy9Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048597, this) != null) || (j39Var = this.H) == null || j39Var.Z || j39Var.a0 == 2) {
            return;
        }
        ArrayList<ey9> F = j39Var.F();
        ArrayList<dy9> d2 = this.H.d();
        if (!vo8.e(F) && !vo8.e(d2)) {
            StringBuilder sb = new StringBuilder();
            Iterator<dy9> it = d2.iterator();
            while (it.hasNext()) {
                dy9 next = it.next();
                if (next != null && next.t1() != null) {
                    sb.append(next.t1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<dy9> it2 = d2.iterator();
            while (it2.hasNext()) {
                dy9 next2 = it2.next();
                if (next2 != null) {
                    next2.j1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<dy9> it3 = d2.iterator();
            while (it3.hasNext()) {
                dy9 next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int i = next3.getAdvertAppInfo().i();
                    if (i != 0) {
                        sn9.j(next3, i);
                        if (i != 28 && i != 31) {
                            next3.getAdvertAppInfo().c = -1001;
                        }
                    }
                    sparseArray.put(next3.getPosition(), next3);
                }
            }
            d2.clear();
            HashMap hashMap = new HashMap();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                dy9 dy9Var3 = (dy9) sparseArray.valueAt(i2);
                if (dy9Var3 != null && (dy9Var2 = (dy9) hashMap.put(dy9Var3.s1(), dy9Var3)) != null) {
                    sn9.j(dy9Var2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (dy9Var = (dy9) entry.getValue()) != null) {
                    sparseArray.put(dy9Var.getPosition(), dy9Var);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                vo8.a(arrayList, Integer.valueOf(sparseArray.keyAt(i3)));
            }
            Collections.sort(arrayList);
            int i4 = 1;
            for (int i5 = 0; i5 < vo8.i(arrayList); i5++) {
                dy9 dy9Var4 = (dy9) sparseArray.get(((Integer) vo8.d(arrayList, i5)).intValue());
                if (this.H.k() != null) {
                    dy9Var4.d1 = this.H.k().getId();
                }
                if (this.H.N() != null) {
                    dy9Var4.g1 = tg.g(this.H.N().getId(), 0L);
                }
                j39 j39Var2 = this.H;
                if (j39Var2 != null && j39Var2.y() != null) {
                    dy9Var4.h1 = this.H.y().a();
                }
                l(dy9Var4);
                int position = dy9Var4.getPosition() + this.H.Y;
                if (position >= vo8.i(F)) {
                    dy9Var4.j1 = position;
                    sn9.k(dy9Var4, 2, position, vo8.i(F));
                    return;
                }
                if (!this.N) {
                    position--;
                    dy9Var4.j1 = position;
                }
                if (position < 0) {
                    sn9.j(dy9Var4, 23);
                } else {
                    dy9Var4.k1 = i4;
                    vo8.b(F, dy9Var4, position);
                    i4++;
                    PbFragment pbFragment = this.a;
                    if (pbFragment != null && pbFragment.getPageContext() != null && this.a.getPageContext().getContext() != null) {
                        TiebaStatic.eventStat(this.a.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", dy9Var4.getAdvertAppInfo().p);
                    }
                }
            }
        }
    }

    public View L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            l69 l69Var = this.c;
            if (l69Var != null && l69Var.Q() != null) {
                if (this.c.Q().z != null && this.c.Q().z.isShown()) {
                    return this.c.Q().z;
                }
                return this.c.Q().y;
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void l0() {
        ey9 ey9Var;
        l69 l69Var;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048626, this) == null) && this.H != null && (ey9Var = this.V) != null && ey9Var.W() != null && (l69Var = this.c) != null && l69Var.Q() != null) {
            String P = this.H.P();
            String l = this.H.l();
            if (this.H.N() != null) {
                i = this.H.N().getThreadType();
            } else {
                i = 0;
            }
            fr5.a().c(P, l, this.V.W(), this.c.Q().s, i);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048633, this) == null) && this.f0 != null) {
            DefaultLog.getInstance().c("PbAdapterManager", "动态修正Adapter");
            this.f0.remove(this.c);
            if (this.d == null) {
                this.d = new m69(this.a, ey9.R0);
            }
            if (!this.f0.contains(this.d)) {
                this.f0.add(this.d);
            }
            if (this.F == null) {
                P(this.a);
            }
            if (!this.f0.contains(this.F)) {
                this.f0.add(this.F);
            }
        }
    }

    public void N(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        m69 m69Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, pbFragment, bdTypeListView) == null) {
            if (r79.D(pbFragment)) {
                DefaultLog.getInstance().c("PbAdapterManager", "初始化PbFirstFloorEmptyAdapter");
                this.d = new m69(pbFragment, ey9.R0);
            } else {
                DefaultLog.getInstance().c("PbAdapterManager", "初始化PbFirstFloorAdapter");
                l69 l69Var = new l69(pbFragment, ey9.R0);
                this.c = l69Var;
                l69Var.g0(pbFragment);
            }
            this.e = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, a49.f);
            this.f = new PbFirstFloorEnterForumAdapter(pbFragment, l39.k);
            this.g = new PbFirstFloorItemAdapter(pbFragment.getContext(), m39.c);
            this.h = new PbFirstFloorRecommendAdapter(pbFragment.getContext(), PbFirstFloorRecommendData.d);
            this.i = new PbFirstFloorSimilarTitleAdapter(pbFragment.getPageContext(), o39.f1144T);
            this.j = new h89(pbFragment.getPageContext(), n39.V0);
            this.k = new e89(pbFragment, g39.c);
            this.l = new j79(pbFragment, z39.g);
            this.m = new x69(pbFragment, u39.c);
            this.n = new j79(pbFragment, z39.h);
            d69 d69Var = new d69(pbFragment, ey9.S0);
            this.o = d69Var;
            d69Var.s0(pbFragment);
            m79 m79Var = new m79(pbFragment, ey9.T0);
            this.p = m79Var;
            m79Var.v0(pbFragment);
            this.s = em9.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.x);
            this.t = em9.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.z);
            this.u = rs7.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.F);
            this.v = rs7.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.G);
            this.w = rs7.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.I);
            this.z = new e79(pbFragment, w39.f1);
            this.x = new f79(pbFragment, d79.e1);
            this.y = new h79(pbFragment, m35.k1);
            this.A = new PbReplyLoadMoreAdapter(pbFragment, ey9.Z0);
            this.q = new za9(pbFragment, ab9.a);
            this.r = new bp6(pbFragment.getPageContext());
            this.C = new b69(pbFragment, w15.e);
            this.D = new t69(pbFragment, pbFragment.getUniqueId());
            this.E = new g89(pbFragment.getPageContext(), k66.g);
            if (r79.D(pbFragment)) {
                P(pbFragment);
            }
            d59 d59Var = new d59(pbFragment, pbFragment.getUniqueId(), this.b);
            this.G = d59Var;
            this.f0.addAll(d59Var.a());
            if (r79.D(pbFragment) && (m69Var = this.d) != null) {
                this.f0.add(m69Var);
            } else {
                l69 l69Var2 = this.c;
                if (l69Var2 != null) {
                    this.f0.add(l69Var2);
                }
            }
            this.f0.add(this.e);
            this.f0.add(this.f);
            this.f0.add(this.g);
            this.f0.add(this.h);
            this.f0.add(this.i);
            this.f0.add(this.j);
            this.f0.add(this.k);
            this.f0.add(this.o);
            this.f0.add(this.p);
            this.f0.add(this.l);
            this.f0.add(this.m);
            this.f0.add(this.n);
            this.f0.add(this.s);
            this.f0.add(this.t);
            this.f0.add(this.u);
            this.f0.add(this.v);
            this.f0.add(this.w);
            this.f0.add(this.z);
            this.f0.add(this.x);
            this.f0.add(this.y);
            this.f0.add(this.q);
            this.f0.add(this.A);
            this.f0.add(this.r);
            this.f0.add(this.C);
            this.f0.add(this.D);
            this.f0.add(new PbPrivateTitleAdapter(pbFragment));
            this.f0.add(this.E);
            if (r79.D(pbFragment)) {
                this.f0.add(this.F);
            }
            this.o0.setPriority(1);
            this.o0.setSelfListener(true);
            pbFragment.registerListener(this.o0);
            pbFragment.registerListener(this.n0);
            m();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new tx9(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
            CustomMessage customMessage = new CustomMessage(2004015);
            customMessage.setTag(pbFragment.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            bdTypeListView.addAdapters(this.f0);
        }
    }

    public final void O(@NonNull j39 j39Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, j39Var) == null) {
            l69 l69Var = this.c;
            if (l69Var != null) {
                l69Var.r(j39Var);
                this.c.setFromCDN(this.K);
                this.c.l(this.f1087T);
                this.c.c(this.M);
                this.c.e(this.Y);
                this.c.k(this.X);
                this.c.n(this.a0);
                this.c.d(this.d0);
                this.c.d0(this.b0);
                this.c.f0(this.c0);
            }
            this.g.y(this.b0);
            this.o.r(j39Var);
            this.o.setFromCDN(this.K);
            this.o.o(this.U);
            this.o.c(this.M);
            this.o.e(this.Y);
            this.o.k(this.X);
            this.o.n(this.a0);
            this.o.d(this.d0);
            this.o.r0(this.c0);
            this.p.r(j39Var);
            this.p.setFromCDN(this.K);
            this.p.o(this.U);
            this.p.c(this.M);
            this.p.e(this.Y);
            this.p.k(this.X);
            this.p.n(this.a0);
            this.p.d(this.d0);
            this.p.u0(this.c0);
            this.e.J(this.Y);
            this.A.y(this.Y);
            this.q.y(this.q0);
            in inVar = this.t;
            if (inVar != null && (inVar instanceof zl9)) {
                ((zl9) inVar).setIsFromCDN(this.K);
            }
            Iterator<c59> it = this.B.iterator();
            while (it.hasNext()) {
                c59 next = it.next();
                if (next != null) {
                    next.r(j39Var);
                    next.setFromCDN(this.K);
                    next.o(this.U);
                    next.l(this.f1087T);
                    next.c(this.M);
                    next.f(this.N);
                    next.q(this.S);
                    next.e(this.Y);
                    next.k(this.X);
                    next.n(this.a0);
                    next.d(this.d0);
                }
            }
            this.l.e(this.Y);
            this.l.B(this.e0);
            this.m.e(this.Z);
            this.n.e(this.Y);
            this.l.r(j39Var);
            this.k.r(j39Var);
            this.n.r(j39Var);
            this.x.r(j39Var);
            this.y.r(j39Var);
            this.C.A(j39Var);
            this.C.z(this.a.r1);
            this.D.y(j39Var);
        }
    }

    public final boolean R(j39 j39Var, ArrayList<vn> arrayList, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048605, this, new Object[]{j39Var, arrayList, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            ArrayList arrayList2 = new ArrayList();
            if (!ListUtils.isEmpty(j39Var.e()) && j39Var.e().size() > 2) {
                int min = Math.min(j39Var.e().size(), 7);
                for (int i6 = 0; i6 < min; i6++) {
                    w15 w15Var = j39Var.e().get(i6);
                    if (!z2 && i6 == 0) {
                        w15Var.i(true);
                    }
                    if (w15Var.getThreadVideoInfo() == null) {
                        if (i6 == min - 1) {
                            w15Var.l(true);
                        }
                    } else if (i6 == min - 2) {
                        w15Var.l(true);
                    } else if (i6 == min - 1) {
                        w15Var.k(true);
                    }
                    arrayList2.add(w15Var);
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

    public final vn S(j39 j39Var, ArrayList<vn> arrayList, int i) {
        InterceptResult invokeLLI;
        g39 g39Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048606, this, j39Var, arrayList, i)) == null) {
            if (i >= 0 && j39Var != null && j39Var.k && (g39Var = j39Var.l) != null) {
                ListUtils.add(arrayList, i, g39Var);
                return g39Var;
            }
            return null;
        }
        return (vn) invokeLLI.objValue;
    }

    public final void c0(ey9 ey9Var, ArrayList<vn> arrayList, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048616, this, ey9Var, arrayList, i) == null) {
            ey9Var.j1(true);
            arrayList.add(i, ey9Var);
        }
    }

    public final vn T(ArrayList<vn> arrayList, int i) {
        InterceptResult invokeLI;
        j39 j39Var;
        cy9 cy9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048607, this, arrayList, i)) == null) {
            if (r79.D(this.a)) {
                return null;
            }
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && i > 0 && (j39Var = this.H) != null && j39Var.s0()) {
                String d2 = ws7.e().d("pb_banner");
                if (this.l0 == null && qs7.m().v(d2)) {
                    ThreadData threadData = new ThreadData();
                    this.l0 = threadData;
                    threadData.funAdData = new cy9();
                    j39 j39Var2 = this.H;
                    if (j39Var2 != null) {
                        this.l0.funAdData.m(j39Var2.l());
                        this.l0.funAdData.r(this.H.P());
                    }
                }
                ThreadData threadData2 = this.l0;
                if (threadData2 != null && (cy9Var = threadData2.funAdData) != null) {
                    cy9Var.j(1);
                    m56.k().q(true);
                    ListUtils.add(arrayList, i, this.l0);
                    if (f66.i().q()) {
                        f66.i().n(arrayList, i + 1, 4);
                    }
                }
            }
            return this.l0;
        }
        return (vn) invokeLI.objValue;
    }

    public final void U(int i, int i2, int i3, ArrayList<vn> arrayList) {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), arrayList}) == null) && !ListUtils.isEmpty(arrayList) && i >= 0 && i2 >= 1) {
            ListIterator<vn> listIterator = arrayList.listIterator();
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
                    if (i5 < this.m0.size()) {
                        listIterator.add(this.m0.get(i5));
                    } else {
                        ey9 ey9Var = new ey9();
                        cy9 cy9Var = new cy9();
                        j39 j39Var = this.H;
                        if (j39Var == null) {
                            str3 = "";
                        } else {
                            str3 = j39Var.l();
                        }
                        cy9Var.m(str3);
                        j39 j39Var2 = this.H;
                        if (j39Var2 != null) {
                            str = j39Var2.P();
                        }
                        cy9Var.r(str);
                        cy9Var.n(true);
                        ey9Var.w0 = cy9Var;
                        cy9Var.j(i7);
                        listIterator.add(ey9Var);
                        i7++;
                        this.m0.add(ey9Var);
                    }
                    i5++;
                    if (i6 == 0) {
                        i6 = i4 + 1;
                    }
                }
                listIterator.next();
                i4++;
            }
            if (i6 > 0 && f66.i().q()) {
                f66.i().n(arrayList, i6, 5);
            }
            if (i4 == i && i5 < i3) {
                ey9 ey9Var2 = new ey9();
                cy9 cy9Var2 = new cy9();
                j39 j39Var3 = this.H;
                if (j39Var3 == null) {
                    str2 = "";
                } else {
                    str2 = j39Var3.l();
                }
                cy9Var2.m(str2);
                j39 j39Var4 = this.H;
                if (j39Var4 != null) {
                    str = j39Var4.P();
                }
                cy9Var2.r(str);
                cy9Var2.n(true);
                ey9Var2.w0 = cy9Var2;
                cy9Var2.j(1);
                listIterator.add(ey9Var2);
                this.m0.add(ey9Var2);
                if (f66.i().q()) {
                    f66.i().n(arrayList, -1, 4);
                }
            }
        }
    }

    public final vn W(j39 j39Var, ey9 ey9Var, ArrayList<vn> arrayList, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048610, this, j39Var, ey9Var, arrayList, i)) == null) {
            m39 m39Var = null;
            if (j39Var.k() != null && !StringUtils.isNull(j39Var.k().getName()) && TextUtils.equals(j39Var.k().getName(), this.a.Q().X0()) && this.a.Q().d1()) {
                return null;
            }
            if (ey9Var != null) {
                if (ey9Var.r0 != null) {
                    m39Var = new m39(ey9Var.r0);
                }
            } else {
                ey9 ey9Var2 = this.V;
                if (ey9Var2 != null && ey9Var2.r0 != null) {
                    m39Var = new m39(this.V.r0);
                }
            }
            if (m39Var != null) {
                m39Var.b = this.a.Q().R1();
                ListUtils.add(arrayList, i + 1, m39Var);
            }
            return m39Var;
        }
        return (vn) invokeLLLI.objValue;
    }

    public final vn X(j39 j39Var, ey9 ey9Var, ArrayList<vn> arrayList, int i) {
        InterceptResult invokeLLLI;
        PbFirstFloorRecommendData pbFirstFloorRecommendData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048611, this, j39Var, ey9Var, arrayList, i)) == null) {
            if (ey9Var != null && ey9Var.X() != null) {
                pbFirstFloorRecommendData = new PbFirstFloorRecommendData(ey9Var.X());
            } else {
                ey9 ey9Var2 = this.V;
                if (ey9Var2 != null && ey9Var2.X() != null) {
                    pbFirstFloorRecommendData = new PbFirstFloorRecommendData(this.V.X());
                } else {
                    pbFirstFloorRecommendData = null;
                }
            }
            if (pbFirstFloorRecommendData != null) {
                if (j39Var != null && !TextUtils.isEmpty(j39Var.P())) {
                    pbFirstFloorRecommendData.f(j39Var.P());
                }
                ListUtils.add(arrayList, i + 1, pbFirstFloorRecommendData);
            }
            return pbFirstFloorRecommendData;
        }
        return (vn) invokeLLLI.objValue;
    }

    public final void k0(boolean z, boolean z2, int i, List<vn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), list}) == null) && !z && !z2) {
            if ((this.Q || this.P) && i != -1 && !ListUtils.isEmpty(list) && !this.R) {
                this.h0 = new e(this, list);
                wg.a().post(this.h0);
            }
        }
    }

    public final u69 Y(ArrayList<vn> arrayList, vn vnVar, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048612, this, arrayList, vnVar, i, i2)) == null) {
            u69 B = this.H.B();
            if (B != null) {
                if (vnVar != null) {
                    if (i2 < 0 && vnVar.getType() != AdvertAppInfo.z) {
                        i2 = i + 2;
                    } else if (vnVar.getType() != AdvertAppInfo.z) {
                        i2++;
                    } else {
                        i2 = -1;
                    }
                }
                if (i2 > 0 && (B instanceof u69)) {
                    ListUtils.add(arrayList, i2, B);
                    return B;
                }
                return null;
            }
            return null;
        }
        return (u69) invokeLLII.objValue;
    }

    public final vn a0(ArrayList<vn> arrayList, int i) {
        InterceptResult invokeLI;
        PbModel Q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048614, this, arrayList, i)) == null) {
            if (i < 0 || (Q = this.a.Q()) == null || TextUtils.isEmpty(Q.C1())) {
                return null;
            }
            dy9 dy9Var = new dy9();
            l(dy9Var);
            ListUtils.add(arrayList, i + 1, dy9Var);
            return dy9Var;
        }
        return (vn) invokeLI.objValue;
    }

    public void h0(boolean z, int i) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && (pbFragment = this.a) != null && pbFragment.L5() != null) {
            this.a.L5().h2(z, i);
        }
    }

    public void g0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        l69 l69Var = this.c;
                        if (l69Var != null) {
                            l69Var.X();
                        }
                        PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter = this.F;
                        if (pbFirstFloorWebViewAdapter != null) {
                            pbFirstFloorWebViewAdapter.onDestroy();
                        }
                        in inVar = this.t;
                        if (inVar instanceof ul9) {
                            ((ul9) inVar).onDestroy();
                        }
                        in inVar2 = this.u;
                        if (inVar2 instanceof ul9) {
                            ((ul9) inVar2).onDestroy();
                        }
                        in inVar3 = this.w;
                        if (inVar3 instanceof ul9) {
                            ((ul9) inVar3).onDestroy();
                        }
                        e69.a().d();
                        return;
                    }
                    return;
                }
                l69 l69Var2 = this.c;
                if (l69Var2 != null) {
                    l69Var2.Y();
                }
                PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter2 = this.F;
                if (pbFirstFloorWebViewAdapter2 != null) {
                    pbFirstFloorWebViewAdapter2.onResume();
                }
                in inVar4 = this.t;
                if (inVar4 instanceof ul9) {
                    ((ul9) inVar4).onResume();
                }
                in inVar5 = this.u;
                if (inVar5 instanceof ul9) {
                    ((ul9) inVar5).onResume();
                }
                in inVar6 = this.w;
                if (inVar6 instanceof ul9) {
                    ((ul9) inVar6).onResume();
                }
                m0(false);
                l0();
                return;
            }
            l69 l69Var3 = this.c;
            if (l69Var3 != null) {
                l69Var3.W();
            }
            PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter3 = this.F;
            if (pbFirstFloorWebViewAdapter3 != null) {
                pbFirstFloorWebViewAdapter3.onPause();
            }
            in inVar7 = this.t;
            if (inVar7 instanceof ul9) {
                ((ul9) inVar7).onPause();
            }
            in inVar8 = this.u;
            if (inVar8 instanceof ul9) {
                ((ul9) inVar8).onPause();
            }
            in inVar9 = this.w;
            if (inVar9 instanceof ul9) {
                ((ul9) inVar9).onPause();
            }
            e69.a().i(this.a.V());
            fr5.a().d();
        }
    }

    public final void l(dy9 dy9Var) {
        ForumData k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048625, this, dy9Var) == null) && dy9Var != null && this.H != null && dy9Var.getAdvertAppInfo() != null) {
            dy9Var.getAdvertAppInfo().i = new k15();
            if (this.H.y() != null) {
                dy9Var.getAdvertAppInfo().i.b = this.H.y().a();
            }
            dy9Var.getAdvertAppInfo().i.a = dy9Var.u1();
            if (this.H.k() != null && (k = this.H.k()) != null) {
                dy9Var.getAdvertAppInfo().i.c = k.getId();
                dy9Var.getAdvertAppInfo().i.d = k.getFirst_class();
                dy9Var.getAdvertAppInfo().i.e = k.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                dy9Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            dy9Var.getAdvertAppInfo().i.g = dy9Var.getAdvertAppInfo().g;
            dy9Var.getAdvertAppInfo().i.h = false;
        }
    }

    public final List<vn> x(j39 j39Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048649, this, j39Var)) == null) {
            if (j39Var == null || j39Var.S() == null || ListUtils.isEmpty(j39Var.S().a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<ey9> list = j39Var.S().a;
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            int min = Math.min(2, list.size());
            for (int i = 0; i < min; i++) {
                ey9 ey9Var = list.get(i);
                if (ey9Var != null) {
                    ey9Var.c0 = true;
                    ey9Var.P = true;
                    arrayList.add(ey9Var);
                }
            }
            if (ListUtils.getCount(j39Var.S().b) > 2) {
                vn vnVar = (vn) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (vnVar instanceof ey9) {
                    ((ey9) vnVar).P = false;
                }
                arrayList.add(new ab9());
            } else {
                vn vnVar2 = (vn) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (vnVar2 instanceof ey9) {
                    ((ey9) vnVar2).P = true;
                }
            }
            arrayList.add(0, new z39(z39.h));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048628, this, z) == null) && this.a.L5() != null && this.a.V() != null && this.a.V().K1() != null) {
            e69.a().f(this.a.V().K1().l2(), this.l.x(), this.a.L5().i1(), this.a.V().getPageStayDurationItem(), z, this.G.b(), this.a.getListView());
        }
    }

    public final void o(List<vn> list) {
        int size;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048631, this, list) == null) && list != null && (size = list.size()) > 0) {
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (list.get(i2) instanceof ey9) {
                    if (i == 0 && (list.get(i2) instanceof dy9)) {
                        i = i2 + 1;
                    }
                    ey9 ey9Var = (ey9) list.get(i2);
                    if (!TextUtils.isEmpty(ey9Var.U())) {
                        x25 x25Var = new x25();
                        x25Var.e(ey9Var.U());
                        list.set(i2, x25Var);
                    }
                }
            }
            if (i > 0 && f66.i().q()) {
                f66.i().n(list, i, 5);
            }
        }
    }

    public void q(j39 j39Var) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048635, this, j39Var) == null) && j39Var.N() != null && j39Var.N().getTaskInfoData() != null && ThreadCardUtils.isHeadlinesCard(j39Var.N().getTaskInfoData())) {
            DefaultLog.getInstance().c("PbAdapterManager", "动态修正头条卡信息");
            if (this.F == null && this.b != null) {
                r79.H(this.a, j39Var.N().getTaskInfoData().j());
                p();
                this.b.F();
                this.b.addAdapters(this.f0);
            }
            PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter = this.F;
            if (pbFirstFloorWebViewAdapter != null && pbFirstFloorWebViewAdapter.u() != 1 && (pbFragment = this.a) != null && pbFragment.L5() != null) {
                this.a.L5().m4();
            }
        }
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            if (this.a == null) {
                return false;
            }
            this.s0 = new ArrayList();
            ArrayList<BdUniqueId> g = dx9.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                no8 b2 = sp8.d().b(this.a.getPageContext(), g.get(i), 2);
                if (b2 != null) {
                    this.f0.add(b2);
                    this.s0.add(b2);
                }
            }
            if (!ListUtils.isEmpty(this.s0)) {
                this.b.addAdapters(this.s0);
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:219:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x03a3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:245:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:262:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void n0(j39 j39Var, boolean z) {
        ey9 ey9Var;
        boolean z2;
        boolean z3;
        ey9 ey9Var2;
        boolean z4;
        boolean z5;
        int i;
        boolean z6;
        boolean z7;
        int i2;
        boolean z8;
        int i3;
        u69 u69Var;
        boolean z9;
        List<vn> list;
        int i4;
        boolean z10;
        boolean z11;
        vn vnVar;
        int i5;
        boolean z12;
        l69 l69Var;
        ey9 ey9Var3;
        ey9 ey9Var4;
        ey9 ey9Var5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048630, this, j39Var, z) != null) || j39Var == null) {
            return;
        }
        this.H = j39Var;
        q(j39Var);
        if (!UbsABTestHelper.isPbCommentFunAdABTest()) {
            K0();
        }
        if (this.I == null) {
            this.I = new ArrayList<>();
        }
        this.I.clear();
        j39 j39Var2 = this.H;
        if (j39Var2 != null && j39Var2.F() != null && this.H.F().size() > 0) {
            this.I.addAll(this.H.F());
        }
        if (j39Var.N() != null && j39Var.N().getAuthor() != null) {
            this.U = j39Var.N().getAuthor().getUserId();
        }
        if (this.c == null && !r79.D(this.a)) {
            return;
        }
        O(j39Var);
        ArrayList<vn> arrayList = new ArrayList<>(j39Var.F());
        ey9 r = r(arrayList);
        if (this.H.N().isQuestionThread()) {
            ey9Var = s(j39Var);
        } else {
            ey9Var = null;
        }
        if (ey9Var != null) {
            arrayList.remove(ey9Var);
        }
        if (r != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!xs7.f() && UbsABTestHelper.isPbCommentFunAdABTest() && this.H.s0()) {
            M(arrayList, Boolean.valueOf(z2));
        }
        if (r != null) {
            this.V = r;
        }
        if (!this.N && r != null) {
            arrayList.remove(r);
            if (j39Var.w0() && r.a0() != null) {
                r.d1(null);
            }
            z2 = true;
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z2 && j39Var.i() != null) {
            ey9 i6 = j39Var.i();
            if (!this.N && j39Var.w0() && i6.a0() != null) {
                i6.d1(null);
            }
            boolean z13 = this.N;
            if ((!z13 || (z13 && this.P)) && (ey9Var5 = this.V) != null && i6.i0 == null) {
                j39Var.F0(ey9Var5);
                ey9Var2 = ey9Var5;
            } else {
                ey9Var2 = i6;
            }
            z2 = true;
            z4 = true;
        } else {
            ey9Var2 = r;
            z4 = z3;
        }
        o(arrayList);
        if (this.a.B5()) {
            if (j39Var.F().size() > 0 && (ey9Var4 = j39Var.F().get(0)) != null && ey9Var4.D() == 1 && !ListUtils.isEmpty(arrayList)) {
                arrayList.remove(0);
            }
        } else {
            int E = E(this.H, arrayList, this.N);
            if (E >= 0) {
                ListUtils.add(arrayList, E, this.H.C());
            }
        }
        int F = F(this.H, arrayList, this.N);
        if (F >= 0) {
            ListUtils.add(arrayList, F, this.H.D());
        }
        dx9.f(arrayList, 1);
        int C = C(j39Var, arrayList);
        if (C >= 0) {
            Z(j39Var, arrayList, C);
            z5 = true;
        } else {
            z5 = false;
        }
        int H = H(j39Var, arrayList);
        if (H >= 0) {
            u39 u39Var = new u39(u39.c);
            u39Var.b(true);
            ListUtils.add(arrayList, H, u39Var);
        }
        int w = w(j39Var, arrayList);
        List<vn> x = x(j39Var);
        if (!ListUtils.isEmpty(x) && w >= 0) {
            vn vnVar2 = (vn) ListUtils.getItem(arrayList, w);
            if (vnVar2 instanceof ey9) {
                ((ey9) vnVar2).R = true;
            }
            ListUtils.addAll(arrayList, w, x);
            z5 = true;
        }
        if (z2) {
            i = G(j39Var, arrayList, this.N);
        } else {
            i = -1;
        }
        if (i >= 0 && j39Var.R() != null) {
            ey9 W = j39Var.W();
            ThreadData c2 = j39Var.R().c();
            if (W != null && W.q0() != null && c2 != null && c2.getCustomFigure() == null) {
                VirtualImageCustomFigure q0 = W.q0();
                VirtualImageCustomState r0 = W.r0();
                c2.setCustomFigure(q0);
                c2.setCustomState(r0);
            }
            ListUtils.add(arrayList, i, j39Var.R());
            z6 = true;
            z7 = true;
        } else {
            if (ey9Var2 != null) {
                ey9Var2.Q = true;
            }
            z6 = z5;
            z7 = false;
        }
        if ((this.H.N().isQuestionThread() && ey9Var != null) || (this.H.N().isQuestionThread() && this.W != null)) {
            if (ey9Var == null && (ey9Var3 = this.W) != null) {
                ey9Var = ey9Var3;
            }
            if (!arrayList.contains(ey9Var)) {
                i++;
                c0(ey9Var, arrayList, i);
            }
        }
        if (X(j39Var, ey9Var2, arrayList, i) != null || W(j39Var, ey9Var2, arrayList, i) != null || V(j39Var, arrayList, i) != null) {
            i++;
        }
        if (S(j39Var, arrayList, i) != null) {
            i++;
        }
        if (z2 && j39Var.M() != null && j39Var.M().similar_thread != null && j39Var.M().similar_thread.id.longValue() > 0) {
            b0(j39Var, arrayList, i);
        } else {
            if (z2) {
                vn a0 = a0(arrayList, i);
                if (a0 != null) {
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
                    vnVar = Q(arrayList, i5);
                    if (vnVar != null) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                } else {
                    z11 = z10;
                    vnVar = a0;
                    i5 = -1;
                }
                if (TbadkCoreApplication.getCurrentAccountInfo() != null && TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() == 1) {
                    z12 = false;
                } else {
                    z12 = true;
                }
                if (z12 && this.H.s0()) {
                    this.k0 = i5;
                    if (T(arrayList, i5) != null) {
                        this.k0 = -1;
                        i++;
                    }
                }
                if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && z12) {
                    z8 = z11;
                    i2 = i;
                    u69Var = null;
                } else {
                    u69 Y = Y(arrayList, vnVar, i, i5);
                    if (Y != null) {
                        if (!z11) {
                            u69Var = Y;
                            i2 = i;
                            z8 = true;
                        } else if (i5 > 0) {
                            i5++;
                        } else {
                            i++;
                        }
                    }
                    u69Var = Y;
                    z8 = z11;
                    i2 = i;
                }
                i3 = i5;
            } else {
                i2 = i;
                z8 = false;
                i3 = -1;
                u69Var = null;
            }
            if (z2) {
                if (u69Var != null) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                list = x;
                int i7 = i2;
                i4 = w;
                boolean R = R(j39Var, arrayList, z8, z9, i3, i7, w, C);
                if (u69Var != null) {
                    u69Var.n = R;
                }
                if (r79.D(this.a)) {
                    p39 p39Var = new p39();
                    if (j39Var.N().getTaskInfoData() != null) {
                        p39Var.f(j39Var.N().getTaskInfoData().r());
                        p39Var.e(j39Var.N().getTaskInfoData().q());
                    }
                    vo8.b(arrayList, p39Var, 0);
                    if (!z7 && j39Var.R() != null) {
                        ey9 W2 = j39Var.W();
                        ThreadData c3 = j39Var.R().c();
                        if (W2 != null && W2.q0() != null && c3 != null && c3.getCustomFigure() == null) {
                            VirtualImageCustomFigure q02 = W2.q0();
                            VirtualImageCustomState r02 = W2.r0();
                            c3.setCustomFigure(q02);
                            c3.setCustomState(r02);
                        }
                        ListUtils.add(arrayList, 1, j39Var.R());
                        z6 = true;
                        z7 = true;
                        l69Var = this.c;
                        if (l69Var != null) {
                            l69Var.e0(!z6);
                        }
                        boolean J0 = J0(ey9Var2);
                        if (this.O && !J0) {
                            arrayList.remove(ey9Var2);
                            this.O = false;
                        }
                        if (j39Var.R() != null) {
                            j39Var.R().h(!z7);
                        }
                        if (this.b != null) {
                            this.J = arrayList;
                            List<vn> Q = j39Var.Q();
                            if (!ListUtils.isEmpty(Q)) {
                                this.b.setData(K(arrayList, Q));
                            } else {
                                this.b.setData(this.J);
                            }
                        }
                        k0(J0, z, i4, list);
                        if (t(ey9Var2, arrayList, z4)) {
                            List<vn> Q2 = j39Var.Q();
                            if (!ListUtils.isEmpty(Q2)) {
                                this.b.setData(K(arrayList, Q2));
                                return;
                            } else {
                                this.b.setData(arrayList);
                                return;
                            }
                        }
                        return;
                    }
                }
                l69Var = this.c;
                if (l69Var != null) {
                }
                boolean J02 = J0(ey9Var2);
                if (this.O) {
                    arrayList.remove(ey9Var2);
                    this.O = false;
                }
                if (j39Var.R() != null) {
                }
                if (this.b != null) {
                }
                k0(J02, z, i4, list);
                if (t(ey9Var2, arrayList, z4)) {
                }
            }
        }
        list = x;
        i4 = w;
        if (r79.D(this.a)) {
        }
        l69Var = this.c;
        if (l69Var != null) {
        }
        boolean J022 = J0(ey9Var2);
        if (this.O) {
        }
        if (j39Var.R() != null) {
        }
        if (this.b != null) {
        }
        k0(J022, z, i4, list);
        if (t(ey9Var2, arrayList, z4)) {
        }
    }

    public final boolean t(ey9 ey9Var, ArrayList<vn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048641, this, ey9Var, arrayList, z)) == null) {
            if (ey9Var == null) {
                ey9 ey9Var2 = this.V;
                if (ey9Var2 != null && !this.P) {
                    ListUtils.add(arrayList, 0, ey9Var2);
                } else {
                    ey9 ey9Var3 = new ey9();
                    ey9Var3.L0(1);
                    ListUtils.add(arrayList, 0, ey9Var3);
                }
                return true;
            } else if (!z) {
                return false;
            } else {
                ListUtils.add(arrayList, 0, ey9Var);
                return true;
            }
        }
        return invokeLLZ.booleanValue;
    }
}
