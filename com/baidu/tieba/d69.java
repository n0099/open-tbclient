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
/* loaded from: classes5.dex */
public class d69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbReplyLoadMoreAdapter A;
    public ArrayList<f59> B;
    public e69 C;
    public w69 D;
    public j89 E;
    public PbFirstFloorWebViewAdapter F;
    public g59 G;
    public m39 H;
    public ArrayList<jy9> I;
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
    public int f1093T;
    public String U;
    public jy9 V;
    public jy9 W;
    public View.OnClickListener X;
    public View.OnClickListener Y;
    public View.OnClickListener Z;
    public PbFragment a;
    public TbRichTextView.a0 a0;
    public BdTypeListView b;
    public View.OnClickListener b0;
    public o69 c;
    public s49 c0;
    public p69 d;
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
    public k89 j;
    public int j0;
    public h89 k;
    public int k0;
    public m79 l;
    public ThreadData l0;
    public a79 m;
    public List<jy9> m0;
    public m79 n;
    public final CustomMessageListener n0;
    public g69 o;
    public CustomMessageListener o0;
    public p79 p;
    public final CustomMessageListener p0;
    public cb9 q;
    public final View.OnClickListener q0;
    public dp6 r;
    public CustomMessageListener r0;
    public in s;
    public List<in> s0;
    public in t;
    public in u;
    public in v;
    public in w;
    public i79 x;
    public k79 y;
    public h79 z;

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d69 a;

        /* loaded from: classes5.dex */
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
        public c(d69 d69Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d69Var, Integer.valueOf(i)};
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
            this.a = d69Var;
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

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d69 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d69 d69Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d69Var, Integer.valueOf(i)};
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
            this.a = d69Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof hy9)) {
                hy9 hy9Var = (hy9) customResponsedMessage.getData();
                if (this.a.l0 != null && this.a.l0.funAdData == hy9Var) {
                    this.a.l0.funAdData.p(true);
                    this.a.b.setData(this.a.J);
                    this.a.f0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d69 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d69 d69Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d69Var, Integer.valueOf(i)};
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
            this.a = d69Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof yx9)) {
                AbsDelegateAdapterList a = ((yx9) customResponsedMessage.getData()).a();
                Iterator<in<?, ?>> it = a.iterator();
                while (it.hasNext()) {
                    in<?, ?> next = it.next();
                    if (next instanceof i69) {
                        ((i69) next).t(this.a.a);
                        if (next instanceof f59) {
                            this.a.B.add((f59) next);
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

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d69 a;

        public d(d69 d69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d69Var;
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

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ d69 b;

        public e(d69 d69Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d69Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = d69Var;
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

    /* loaded from: classes5.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d69 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(d69 d69Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d69Var, Integer.valueOf(i)};
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
            this.a = d69Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.s0)) {
                this.a.n();
                d69 d69Var = this.a;
                d69Var.n0(d69Var.H, false);
            }
        }
    }

    public d69(PbFragment pbFragment, BdTypeListView bdTypeListView) {
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
        this.f1093T = 0;
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
        this.f1093T = vi.l(pbFragment.getPageContext().getPageActivity());
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
            iy9 R0 = this.a.Q().R0();
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
                xn9.j(R0, i2);
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
            m39 m39Var = this.H;
            if (m39Var != null && m39Var.y() != null) {
                R0.h1 = this.H.y().a();
            }
            l(R0);
            if (i < 0) {
                return null;
            }
            R0.k1 = 1;
            o56.k().q(true);
            yo8.b(arrayList, R0, i);
            m39 m39Var2 = this.H;
            if (m39Var2 != null) {
                m39Var2.L0(R0);
            }
            if (h66.i().q()) {
                h66.i().n(arrayList, i + 1, 4);
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

    public void G0(s49 s49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, s49Var) == null) {
            this.c0 = s49Var;
        }
    }

    public void I0(@NonNull m39 m39Var) {
        o69 o69Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, m39Var) == null) && (o69Var = this.c) != null) {
            o69Var.i0(m39Var);
        }
    }

    public final void P(PbFragment pbFragment) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048603, this, pbFragment) == null) && pbFragment != null && pbFragment.getPageContext() != null) {
            DefaultLog.getInstance().c("PbAdapterManager", "初始化PbFirstFloorWebViewAdapter");
            this.F = new PbFirstFloorWebViewAdapter(pbFragment, s39.c);
        }
    }

    public void j0(boolean z) {
        o69 o69Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048623, this, z) == null) && (o69Var = this.c) != null) {
            o69Var.V(z);
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

    public final jy9 s(m39 m39Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, m39Var)) == null) {
            if (m39Var != null && m39Var.T() != null) {
                jy9 T2 = m39Var.T();
                this.W = T2;
                return T2;
            }
            return null;
        }
        return (jy9) invokeL.objValue;
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
        g69 g69Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048652, this, z) == null) && (g69Var = this.o) != null) {
            g69Var.p0(z);
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

    public final int I(q39 q39Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, q39Var, i)) == null) {
            if (q39Var.e0()) {
                if (i == 25) {
                    return 4;
                }
                return 5;
            }
            if (q39Var.f0()) {
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
            g69 g69Var = this.o;
            if (g69Var != null) {
                g69Var.q0(z);
            }
            m79 m79Var = this.l;
            if (m79Var != null) {
                m79Var.A(z);
            }
            in inVar = this.w;
            if (inVar != null) {
                inVar.setMulDel(z);
            }
            in inVar2 = this.t;
            if (inVar2 != null) {
                inVar2.setMulDel(z);
            }
            o69 o69Var = this.c;
            if (o69Var != null) {
                o69Var.setMulDel(z);
            }
        }
    }

    public final boolean J0(jy9 jy9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, jy9Var)) == null) {
            if (this.a.Q() != null && jy9Var != null && jy9Var.O() != null && jy9Var.O().equals(this.a.Q().X1())) {
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
            o69 o69Var = this.c;
            if (o69Var != null) {
                o69Var.setFromCDN(z);
            }
            in inVar = this.t;
            if (inVar != null && (inVar instanceof em9)) {
                ((em9) inVar).setIsFromCDN(z);
            }
            Iterator<f59> it = this.B.iterator();
            while (it.hasNext()) {
                it.next().setFromCDN(z);
            }
        }
    }

    public final jy9 r(ArrayList<vn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, arrayList)) == null) {
            Iterator<vn> it = arrayList.iterator();
            while (it.hasNext()) {
                vn next = it.next();
                if (next instanceof jy9) {
                    jy9 jy9Var = (jy9) next;
                    if (jy9Var.D() == 1) {
                        return jy9Var;
                    }
                }
            }
            return null;
        }
        return (jy9) invokeL.objValue;
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
        a79 a79Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (a79Var = this.m) != null) {
            a79Var.z(2);
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

    public final int C(m39 m39Var, ArrayList<vn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, m39Var, arrayList)) == null) {
            if (m39Var == null || ListUtils.isEmpty(m39Var.F()) || ListUtils.isEmpty(arrayList) || ((jy9) ListUtils.getItem(m39Var.F(), 0)) == null) {
                return 0;
            }
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    vn vnVar = arrayList.get(i);
                    if (vnVar instanceof jy9) {
                        jy9 jy9Var = (jy9) vnVar;
                        if (jy9Var.D() == 1 && jy9Var.O == 0) {
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

    public final int H(m39 m39Var, ArrayList<vn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, m39Var, arrayList)) == null) {
            int i = -1;
            if (m39Var == null || m39Var.y() == null) {
                return -1;
            }
            int i2 = 0;
            if (m39Var.y().c() == 1) {
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
                } else if (arrayList.get(i2) instanceof c49) {
                    i = i2 + 1;
                    break;
                } else {
                    i2++;
                }
            }
            if (m39Var.J() == 4) {
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
        int i = jc5.i();
        int j = jc5.j() - 1;
        if (bool.booleanValue()) {
            vn vnVar = arrayList.get(0);
            if ((vnVar instanceof jy9) && ((jy9) vnVar).D() == 1) {
                j++;
            }
        }
        int k = jc5.k() + 1;
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
                    if (vnVar != null && vnVar.getType() == c49.g) {
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
            m79 m79Var = this.l;
            if (m79Var != null) {
                m79Var.onDestroy();
            }
            m79 m79Var2 = this.n;
            if (m79Var2 != null) {
                m79Var2.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.e;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
            h89 h89Var = this.k;
            if (h89Var != null) {
                h89Var.onDestroy();
            }
            o56.k().q(false);
        }
    }

    public int E(m39 m39Var, ArrayList<vn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, m39Var, arrayList, z)) == null) {
            if (m39Var == null || m39Var.F() == null || m39Var.C() == null || m39Var.F().size() == 0 || m39Var.N() == null || arrayList == null || !m39Var.C().s1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (m39Var.F().get(0) == null || m39Var.F().get(0).D() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (m39Var.y() == null || m39Var.y().a() != m39Var.y().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public int F(m39 m39Var, ArrayList<vn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048586, this, m39Var, arrayList, z)) == null) {
            if (m39Var == null || m39Var.F() == null || m39Var.D() == null || m39Var.F().size() == 0 || m39Var.N() == null || arrayList == null || !m39Var.D().s1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (m39Var.F().get(0) == null || m39Var.F().get(0).D() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (m39Var.y() == null || m39Var.y().a() != m39Var.y().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final vn V(m39 m39Var, ArrayList<vn> arrayList, int i) {
        InterceptResult invokeLLI;
        o39 o39Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048609, this, m39Var, arrayList, i)) == null) {
            if (m39Var.k() != null && !StringUtils.isNull(m39Var.k().getName()) && !m39Var.m) {
                if (!TextUtils.equals(m39Var.k().getName(), this.a.Q().X0()) || !this.a.Q().d1()) {
                    if (!this.a.z0() && !ListUtils.isEmpty(m39Var.o())) {
                        o39Var = new o39(m39Var.o().get(0));
                    } else {
                        o39Var = new o39(m39Var.k());
                    }
                    o39Var.g = this.a.Q().R1();
                    if (!UbsABTestHelper.isPbEnterForum()) {
                        i++;
                    }
                    ListUtils.add(arrayList, i, o39Var);
                    return o39Var;
                }
                return null;
            }
            return null;
        }
        return (vn) invokeLLI.objValue;
    }

    public final int b0(m39 m39Var, ArrayList<vn> arrayList, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048615, this, m39Var, arrayList, i)) == null) {
            q39 q39Var = new q39(m39Var.M());
            String tid = q39Var.d0().getTid();
            int x1 = this.a.Q().x1();
            m39Var.N0(I(q39Var, x1));
            r39 r39Var = new r39(q39Var.b0(), q39Var.c0());
            r39Var.a = q39Var.d0();
            r39Var.C = x1;
            r39Var.g = tid;
            int i2 = i + 1;
            ListUtils.add(arrayList, i2, r39Var);
            q39Var.d0().isLinkThread();
            q39Var.d0().isSmartAppThreadType();
            if (!q39Var.d0().isLinkThread() && !q39Var.d0().isSmartAppThreadType()) {
                q39Var.d0().isGodThread();
            }
            q39Var.a = q39Var.d0();
            q39Var.C = x1;
            q39Var.g = tid;
            q39Var.setSupportType(BaseCardInfo.SupportType.NONE);
            ListUtils.add(arrayList, i2 + 1, q39Var);
            return i2;
        }
        return invokeLLI.intValue;
    }

    public final int G(m39 m39Var, ArrayList<vn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048588, this, m39Var, arrayList, z)) == null) {
            if (m39Var != null && !ListUtils.isEmpty(m39Var.F()) && arrayList != null && arrayList.size() > 0) {
                if (!z) {
                    return 0;
                }
                if (m39Var.F().get(0) != null && m39Var.F().get(0).D() == 1) {
                    return 1;
                }
                if (!this.P) {
                    return -1;
                }
                return 0;
            } else if (m39Var == null || !m39Var.w0()) {
                return -1;
            } else {
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final void Z(m39 m39Var, ArrayList<vn> arrayList, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048613, this, m39Var, arrayList, i) == null) {
            c49 c49Var = new c49(c49.g);
            ThreadData N = m39Var.N();
            c49Var.c = this.a.d6();
            c49Var.b = m39Var.g;
            c49Var.d = m39Var.i0();
            c49Var.e = m39Var.f;
            if (N != null && N.isQuestionThread()) {
                z = true;
            } else {
                z = false;
            }
            c49Var.f = z;
            ListUtils.add(arrayList, i, c49Var);
            if (m39Var.J() == 4) {
                ListUtils.add(arrayList, i + 1, new b49());
            }
        }
    }

    public final ArrayList<vn> K(List<vn> list, List<vn> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, list, list2)) == null) {
            ArrayList<vn> arrayList = new ArrayList<>(list.size() + list2.size() + 2);
            arrayList.addAll(list);
            v39 v39Var = new v39();
            PbListView g1 = this.a.L5().g1();
            if (g1 != null && g1.q()) {
                v39Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fb0);
                v39Var.b = true;
            } else {
                v39Var.a = TbadkCoreApplication.getInst().getString(R.string.list_has_all_comments);
                v39Var.b = false;
            }
            arrayList.add(v39Var);
            gp6 gp6Var = new gp6();
            gp6Var.a = TbadkCoreApplication.getInst().getString(R.string.recommed_for_you);
            gp6Var.needTopMargin = false;
            arrayList.add(gp6Var);
            arrayList.addAll(list2);
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public final int w(m39 m39Var, ArrayList<vn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048647, this, m39Var, arrayList)) == null) {
            if (!this.P && m39Var != null && !ListUtils.isEmpty(m39Var.F()) && arrayList != null && arrayList.size() > 0) {
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
                        if (vnVar instanceof jy9) {
                            jy9 jy9Var = (jy9) vnVar;
                            if (jy9Var.D() == 1 && jy9Var.O == 0) {
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
                    if (m39Var.w0()) {
                        return 0;
                    }
                    return -1;
                }
                return i + 1;
            } else if (m39Var != null && m39Var.w0() && this.N) {
                return 0;
            } else {
                return -1;
            }
        }
        return invokeLL.intValue;
    }

    public final void K0() {
        m39 m39Var;
        iy9 iy9Var;
        iy9 iy9Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048597, this) != null) || (m39Var = this.H) == null || m39Var.Z || m39Var.a0 == 2) {
            return;
        }
        ArrayList<jy9> F = m39Var.F();
        ArrayList<iy9> d2 = this.H.d();
        if (!yo8.e(F) && !yo8.e(d2)) {
            StringBuilder sb = new StringBuilder();
            Iterator<iy9> it = d2.iterator();
            while (it.hasNext()) {
                iy9 next = it.next();
                if (next != null && next.t1() != null) {
                    sb.append(next.t1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<iy9> it2 = d2.iterator();
            while (it2.hasNext()) {
                iy9 next2 = it2.next();
                if (next2 != null) {
                    next2.j1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<iy9> it3 = d2.iterator();
            while (it3.hasNext()) {
                iy9 next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int i = next3.getAdvertAppInfo().i();
                    if (i != 0) {
                        xn9.j(next3, i);
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
                iy9 iy9Var3 = (iy9) sparseArray.valueAt(i2);
                if (iy9Var3 != null && (iy9Var2 = (iy9) hashMap.put(iy9Var3.s1(), iy9Var3)) != null) {
                    xn9.j(iy9Var2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (iy9Var = (iy9) entry.getValue()) != null) {
                    sparseArray.put(iy9Var.getPosition(), iy9Var);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                yo8.a(arrayList, Integer.valueOf(sparseArray.keyAt(i3)));
            }
            Collections.sort(arrayList);
            int i4 = 1;
            for (int i5 = 0; i5 < yo8.i(arrayList); i5++) {
                iy9 iy9Var4 = (iy9) sparseArray.get(((Integer) yo8.d(arrayList, i5)).intValue());
                if (this.H.k() != null) {
                    iy9Var4.d1 = this.H.k().getId();
                }
                if (this.H.N() != null) {
                    iy9Var4.g1 = tg.g(this.H.N().getId(), 0L);
                }
                m39 m39Var2 = this.H;
                if (m39Var2 != null && m39Var2.y() != null) {
                    iy9Var4.h1 = this.H.y().a();
                }
                l(iy9Var4);
                int position = iy9Var4.getPosition() + this.H.Y;
                if (position >= yo8.i(F)) {
                    iy9Var4.j1 = position;
                    xn9.k(iy9Var4, 2, position, yo8.i(F));
                    return;
                }
                if (!this.N) {
                    position--;
                    iy9Var4.j1 = position;
                }
                if (position < 0) {
                    xn9.j(iy9Var4, 23);
                } else {
                    iy9Var4.k1 = i4;
                    yo8.b(F, iy9Var4, position);
                    i4++;
                    PbFragment pbFragment = this.a;
                    if (pbFragment != null && pbFragment.getPageContext() != null && this.a.getPageContext().getContext() != null) {
                        TiebaStatic.eventStat(this.a.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", iy9Var4.getAdvertAppInfo().p);
                    }
                }
            }
        }
    }

    public View L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            o69 o69Var = this.c;
            if (o69Var != null && o69Var.Q() != null) {
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
        jy9 jy9Var;
        o69 o69Var;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048626, this) == null) && this.H != null && (jy9Var = this.V) != null && jy9Var.W() != null && (o69Var = this.c) != null && o69Var.Q() != null) {
            String P = this.H.P();
            String l = this.H.l();
            if (this.H.N() != null) {
                i = this.H.N().getThreadType();
            } else {
                i = 0;
            }
            hr5.a().c(P, l, this.V.W(), this.c.Q().s, i);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048633, this) == null) && this.f0 != null) {
            DefaultLog.getInstance().c("PbAdapterManager", "动态修正Adapter");
            this.f0.remove(this.c);
            if (this.d == null) {
                this.d = new p69(this.a, jy9.R0);
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
        p69 p69Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, pbFragment, bdTypeListView) == null) {
            if (u79.D(pbFragment)) {
                DefaultLog.getInstance().c("PbAdapterManager", "初始化PbFirstFloorEmptyAdapter");
                this.d = new p69(pbFragment, jy9.R0);
            } else {
                DefaultLog.getInstance().c("PbAdapterManager", "初始化PbFirstFloorAdapter");
                o69 o69Var = new o69(pbFragment, jy9.R0);
                this.c = o69Var;
                o69Var.g0(pbFragment);
            }
            this.e = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, d49.f);
            this.f = new PbFirstFloorEnterForumAdapter(pbFragment, o39.k);
            this.g = new PbFirstFloorItemAdapter(pbFragment.getContext(), p39.c);
            this.h = new PbFirstFloorRecommendAdapter(pbFragment.getContext(), PbFirstFloorRecommendData.d);
            this.i = new PbFirstFloorSimilarTitleAdapter(pbFragment.getPageContext(), r39.f1160T);
            this.j = new k89(pbFragment.getPageContext(), q39.V0);
            this.k = new h89(pbFragment, j39.c);
            this.l = new m79(pbFragment, c49.g);
            this.m = new a79(pbFragment, x39.c);
            this.n = new m79(pbFragment, c49.h);
            g69 g69Var = new g69(pbFragment, jy9.S0);
            this.o = g69Var;
            g69Var.s0(pbFragment);
            p79 p79Var = new p79(pbFragment, jy9.T0);
            this.p = p79Var;
            p79Var.v0(pbFragment);
            this.s = jm9.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.x);
            this.t = jm9.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.z);
            this.u = ts7.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.F);
            this.v = ts7.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.G);
            this.w = ts7.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.I);
            this.z = new h79(pbFragment, z39.f1);
            this.x = new i79(pbFragment, g79.e1);
            this.y = new k79(pbFragment, o35.k1);
            this.A = new PbReplyLoadMoreAdapter(pbFragment, jy9.Z0);
            this.q = new cb9(pbFragment, db9.a);
            this.r = new dp6(pbFragment.getPageContext());
            this.C = new e69(pbFragment, y15.e);
            this.D = new w69(pbFragment, pbFragment.getUniqueId());
            this.E = new j89(pbFragment.getPageContext(), m66.g);
            if (u79.D(pbFragment)) {
                P(pbFragment);
            }
            g59 g59Var = new g59(pbFragment, pbFragment.getUniqueId(), this.b);
            this.G = g59Var;
            this.f0.addAll(g59Var.a());
            if (u79.D(pbFragment) && (p69Var = this.d) != null) {
                this.f0.add(p69Var);
            } else {
                o69 o69Var2 = this.c;
                if (o69Var2 != null) {
                    this.f0.add(o69Var2);
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
            if (u79.D(pbFragment)) {
                this.f0.add(this.F);
            }
            this.o0.setPriority(1);
            this.o0.setSelfListener(true);
            pbFragment.registerListener(this.o0);
            pbFragment.registerListener(this.n0);
            m();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new yx9(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
            CustomMessage customMessage = new CustomMessage(2004015);
            customMessage.setTag(pbFragment.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            bdTypeListView.addAdapters(this.f0);
        }
    }

    public final void O(@NonNull m39 m39Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, m39Var) == null) {
            o69 o69Var = this.c;
            if (o69Var != null) {
                o69Var.r(m39Var);
                this.c.setFromCDN(this.K);
                this.c.l(this.f1093T);
                this.c.c(this.M);
                this.c.e(this.Y);
                this.c.k(this.X);
                this.c.n(this.a0);
                this.c.d(this.d0);
                this.c.d0(this.b0);
                this.c.f0(this.c0);
            }
            this.g.y(this.b0);
            this.o.r(m39Var);
            this.o.setFromCDN(this.K);
            this.o.o(this.U);
            this.o.c(this.M);
            this.o.e(this.Y);
            this.o.k(this.X);
            this.o.n(this.a0);
            this.o.d(this.d0);
            this.o.r0(this.c0);
            this.p.r(m39Var);
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
            if (inVar != null && (inVar instanceof em9)) {
                ((em9) inVar).setIsFromCDN(this.K);
            }
            Iterator<f59> it = this.B.iterator();
            while (it.hasNext()) {
                f59 next = it.next();
                if (next != null) {
                    next.r(m39Var);
                    next.setFromCDN(this.K);
                    next.o(this.U);
                    next.l(this.f1093T);
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
            this.l.r(m39Var);
            this.k.r(m39Var);
            this.n.r(m39Var);
            this.x.r(m39Var);
            this.y.r(m39Var);
            this.C.A(m39Var);
            this.C.z(this.a.r1);
            this.D.y(m39Var);
        }
    }

    public final boolean R(m39 m39Var, ArrayList<vn> arrayList, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048605, this, new Object[]{m39Var, arrayList, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            ArrayList arrayList2 = new ArrayList();
            if (!ListUtils.isEmpty(m39Var.e()) && m39Var.e().size() > 2) {
                int min = Math.min(m39Var.e().size(), 7);
                for (int i6 = 0; i6 < min; i6++) {
                    y15 y15Var = m39Var.e().get(i6);
                    if (!z2 && i6 == 0) {
                        y15Var.i(true);
                    }
                    if (y15Var.getThreadVideoInfo() == null) {
                        if (i6 == min - 1) {
                            y15Var.l(true);
                        }
                    } else if (i6 == min - 2) {
                        y15Var.l(true);
                    } else if (i6 == min - 1) {
                        y15Var.k(true);
                    }
                    arrayList2.add(y15Var);
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

    public final vn S(m39 m39Var, ArrayList<vn> arrayList, int i) {
        InterceptResult invokeLLI;
        j39 j39Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048606, this, m39Var, arrayList, i)) == null) {
            if (i >= 0 && m39Var != null && m39Var.k && (j39Var = m39Var.l) != null) {
                ListUtils.add(arrayList, i, j39Var);
                return j39Var;
            }
            return null;
        }
        return (vn) invokeLLI.objValue;
    }

    public final void c0(jy9 jy9Var, ArrayList<vn> arrayList, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048616, this, jy9Var, arrayList, i) == null) {
            jy9Var.j1(true);
            arrayList.add(i, jy9Var);
        }
    }

    public final vn T(ArrayList<vn> arrayList, int i) {
        InterceptResult invokeLI;
        m39 m39Var;
        hy9 hy9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048607, this, arrayList, i)) == null) {
            if (u79.D(this.a)) {
                return null;
            }
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && i > 0 && (m39Var = this.H) != null && m39Var.s0()) {
                String d2 = ys7.e().d("pb_banner");
                if (this.l0 == null && ss7.m().v(d2)) {
                    ThreadData threadData = new ThreadData();
                    this.l0 = threadData;
                    threadData.funAdData = new hy9();
                    m39 m39Var2 = this.H;
                    if (m39Var2 != null) {
                        this.l0.funAdData.m(m39Var2.l());
                        this.l0.funAdData.r(this.H.P());
                    }
                }
                ThreadData threadData2 = this.l0;
                if (threadData2 != null && (hy9Var = threadData2.funAdData) != null) {
                    hy9Var.j(1);
                    o56.k().q(true);
                    ListUtils.add(arrayList, i, this.l0);
                    if (h66.i().q()) {
                        h66.i().n(arrayList, i + 1, 4);
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
                        jy9 jy9Var = new jy9();
                        hy9 hy9Var = new hy9();
                        m39 m39Var = this.H;
                        if (m39Var == null) {
                            str3 = "";
                        } else {
                            str3 = m39Var.l();
                        }
                        hy9Var.m(str3);
                        m39 m39Var2 = this.H;
                        if (m39Var2 != null) {
                            str = m39Var2.P();
                        }
                        hy9Var.r(str);
                        hy9Var.n(true);
                        jy9Var.w0 = hy9Var;
                        hy9Var.j(i7);
                        listIterator.add(jy9Var);
                        i7++;
                        this.m0.add(jy9Var);
                    }
                    i5++;
                    if (i6 == 0) {
                        i6 = i4 + 1;
                    }
                }
                listIterator.next();
                i4++;
            }
            if (i6 > 0 && h66.i().q()) {
                h66.i().n(arrayList, i6, 5);
            }
            if (i4 == i && i5 < i3) {
                jy9 jy9Var2 = new jy9();
                hy9 hy9Var2 = new hy9();
                m39 m39Var3 = this.H;
                if (m39Var3 == null) {
                    str2 = "";
                } else {
                    str2 = m39Var3.l();
                }
                hy9Var2.m(str2);
                m39 m39Var4 = this.H;
                if (m39Var4 != null) {
                    str = m39Var4.P();
                }
                hy9Var2.r(str);
                hy9Var2.n(true);
                jy9Var2.w0 = hy9Var2;
                hy9Var2.j(1);
                listIterator.add(jy9Var2);
                this.m0.add(jy9Var2);
                if (h66.i().q()) {
                    h66.i().n(arrayList, -1, 4);
                }
            }
        }
    }

    public final vn W(m39 m39Var, jy9 jy9Var, ArrayList<vn> arrayList, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048610, this, m39Var, jy9Var, arrayList, i)) == null) {
            p39 p39Var = null;
            if (m39Var.k() != null && !StringUtils.isNull(m39Var.k().getName()) && TextUtils.equals(m39Var.k().getName(), this.a.Q().X0()) && this.a.Q().d1()) {
                return null;
            }
            if (jy9Var != null) {
                if (jy9Var.r0 != null) {
                    p39Var = new p39(jy9Var.r0);
                }
            } else {
                jy9 jy9Var2 = this.V;
                if (jy9Var2 != null && jy9Var2.r0 != null) {
                    p39Var = new p39(this.V.r0);
                }
            }
            if (p39Var != null) {
                p39Var.b = this.a.Q().R1();
                ListUtils.add(arrayList, i + 1, p39Var);
            }
            return p39Var;
        }
        return (vn) invokeLLLI.objValue;
    }

    public final vn X(m39 m39Var, jy9 jy9Var, ArrayList<vn> arrayList, int i) {
        InterceptResult invokeLLLI;
        PbFirstFloorRecommendData pbFirstFloorRecommendData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048611, this, m39Var, jy9Var, arrayList, i)) == null) {
            if (jy9Var != null && jy9Var.X() != null) {
                pbFirstFloorRecommendData = new PbFirstFloorRecommendData(jy9Var.X());
            } else {
                jy9 jy9Var2 = this.V;
                if (jy9Var2 != null && jy9Var2.X() != null) {
                    pbFirstFloorRecommendData = new PbFirstFloorRecommendData(this.V.X());
                } else {
                    pbFirstFloorRecommendData = null;
                }
            }
            if (pbFirstFloorRecommendData != null) {
                if (m39Var != null && !TextUtils.isEmpty(m39Var.P())) {
                    pbFirstFloorRecommendData.f(m39Var.P());
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

    public final x69 Y(ArrayList<vn> arrayList, vn vnVar, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048612, this, arrayList, vnVar, i, i2)) == null) {
            x69 B = this.H.B();
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
                if (i2 > 0 && (B instanceof x69)) {
                    ListUtils.add(arrayList, i2, B);
                    return B;
                }
                return null;
            }
            return null;
        }
        return (x69) invokeLLII.objValue;
    }

    public final vn a0(ArrayList<vn> arrayList, int i) {
        InterceptResult invokeLI;
        PbModel Q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048614, this, arrayList, i)) == null) {
            if (i < 0 || (Q = this.a.Q()) == null || TextUtils.isEmpty(Q.C1())) {
                return null;
            }
            iy9 iy9Var = new iy9();
            l(iy9Var);
            ListUtils.add(arrayList, i + 1, iy9Var);
            return iy9Var;
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
                        o69 o69Var = this.c;
                        if (o69Var != null) {
                            o69Var.X();
                        }
                        PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter = this.F;
                        if (pbFirstFloorWebViewAdapter != null) {
                            pbFirstFloorWebViewAdapter.onDestroy();
                        }
                        in inVar = this.t;
                        if (inVar instanceof zl9) {
                            ((zl9) inVar).onDestroy();
                        }
                        in inVar2 = this.u;
                        if (inVar2 instanceof zl9) {
                            ((zl9) inVar2).onDestroy();
                        }
                        in inVar3 = this.w;
                        if (inVar3 instanceof zl9) {
                            ((zl9) inVar3).onDestroy();
                        }
                        h69.a().d();
                        return;
                    }
                    return;
                }
                o69 o69Var2 = this.c;
                if (o69Var2 != null) {
                    o69Var2.Y();
                }
                PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter2 = this.F;
                if (pbFirstFloorWebViewAdapter2 != null) {
                    pbFirstFloorWebViewAdapter2.onResume();
                }
                in inVar4 = this.t;
                if (inVar4 instanceof zl9) {
                    ((zl9) inVar4).onResume();
                }
                in inVar5 = this.u;
                if (inVar5 instanceof zl9) {
                    ((zl9) inVar5).onResume();
                }
                in inVar6 = this.w;
                if (inVar6 instanceof zl9) {
                    ((zl9) inVar6).onResume();
                }
                m0(false);
                l0();
                return;
            }
            o69 o69Var3 = this.c;
            if (o69Var3 != null) {
                o69Var3.W();
            }
            PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter3 = this.F;
            if (pbFirstFloorWebViewAdapter3 != null) {
                pbFirstFloorWebViewAdapter3.onPause();
            }
            in inVar7 = this.t;
            if (inVar7 instanceof zl9) {
                ((zl9) inVar7).onPause();
            }
            in inVar8 = this.u;
            if (inVar8 instanceof zl9) {
                ((zl9) inVar8).onPause();
            }
            in inVar9 = this.w;
            if (inVar9 instanceof zl9) {
                ((zl9) inVar9).onPause();
            }
            h69.a().i(this.a.V());
            hr5.a().d();
        }
    }

    public final void l(iy9 iy9Var) {
        ForumData k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048625, this, iy9Var) == null) && iy9Var != null && this.H != null && iy9Var.getAdvertAppInfo() != null) {
            iy9Var.getAdvertAppInfo().i = new m15();
            if (this.H.y() != null) {
                iy9Var.getAdvertAppInfo().i.b = this.H.y().a();
            }
            iy9Var.getAdvertAppInfo().i.a = iy9Var.u1();
            if (this.H.k() != null && (k = this.H.k()) != null) {
                iy9Var.getAdvertAppInfo().i.c = k.getId();
                iy9Var.getAdvertAppInfo().i.d = k.getFirst_class();
                iy9Var.getAdvertAppInfo().i.e = k.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                iy9Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            iy9Var.getAdvertAppInfo().i.g = iy9Var.getAdvertAppInfo().g;
            iy9Var.getAdvertAppInfo().i.h = false;
        }
    }

    public final List<vn> x(m39 m39Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048649, this, m39Var)) == null) {
            if (m39Var == null || m39Var.S() == null || ListUtils.isEmpty(m39Var.S().a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<jy9> list = m39Var.S().a;
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            int min = Math.min(2, list.size());
            for (int i = 0; i < min; i++) {
                jy9 jy9Var = list.get(i);
                if (jy9Var != null) {
                    jy9Var.c0 = true;
                    jy9Var.P = true;
                    arrayList.add(jy9Var);
                }
            }
            if (ListUtils.getCount(m39Var.S().b) > 2) {
                vn vnVar = (vn) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (vnVar instanceof jy9) {
                    ((jy9) vnVar).P = false;
                }
                arrayList.add(new db9());
            } else {
                vn vnVar2 = (vn) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (vnVar2 instanceof jy9) {
                    ((jy9) vnVar2).P = true;
                }
            }
            arrayList.add(0, new c49(c49.h));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048628, this, z) == null) && this.a.L5() != null && this.a.V() != null && this.a.V().K1() != null) {
            h69.a().f(this.a.V().K1().l2(), this.l.x(), this.a.L5().i1(), this.a.V().getPageStayDurationItem(), z, this.G.b(), this.a.getListView());
        }
    }

    public final void o(List<vn> list) {
        int size;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048631, this, list) == null) && list != null && (size = list.size()) > 0) {
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (list.get(i2) instanceof jy9) {
                    if (i == 0 && (list.get(i2) instanceof iy9)) {
                        i = i2 + 1;
                    }
                    jy9 jy9Var = (jy9) list.get(i2);
                    if (!TextUtils.isEmpty(jy9Var.U())) {
                        z25 z25Var = new z25();
                        z25Var.e(jy9Var.U());
                        list.set(i2, z25Var);
                    }
                }
            }
            if (i > 0 && h66.i().q()) {
                h66.i().n(list, i, 5);
            }
        }
    }

    public void q(m39 m39Var) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048635, this, m39Var) == null) && m39Var.N() != null && m39Var.N().getTaskInfoData() != null && ThreadCardUtils.isHeadlinesCard(m39Var.N().getTaskInfoData())) {
            DefaultLog.getInstance().c("PbAdapterManager", "动态修正头条卡信息");
            if (this.F == null && this.b != null) {
                u79.H(this.a, m39Var.N().getTaskInfoData().j());
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
            ArrayList<BdUniqueId> g = ix9.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                qo8 b2 = vp8.d().b(this.a.getPageContext(), g.get(i), 2);
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
    public void n0(m39 m39Var, boolean z) {
        jy9 jy9Var;
        boolean z2;
        boolean z3;
        jy9 jy9Var2;
        boolean z4;
        boolean z5;
        int i;
        boolean z6;
        boolean z7;
        int i2;
        boolean z8;
        int i3;
        x69 x69Var;
        boolean z9;
        List<vn> list;
        int i4;
        boolean z10;
        boolean z11;
        vn vnVar;
        int i5;
        boolean z12;
        o69 o69Var;
        jy9 jy9Var3;
        jy9 jy9Var4;
        jy9 jy9Var5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048630, this, m39Var, z) != null) || m39Var == null) {
            return;
        }
        this.H = m39Var;
        q(m39Var);
        if (!UbsABTestHelper.isPbCommentFunAdABTest()) {
            K0();
        }
        if (this.I == null) {
            this.I = new ArrayList<>();
        }
        this.I.clear();
        m39 m39Var2 = this.H;
        if (m39Var2 != null && m39Var2.F() != null && this.H.F().size() > 0) {
            this.I.addAll(this.H.F());
        }
        if (m39Var.N() != null && m39Var.N().getAuthor() != null) {
            this.U = m39Var.N().getAuthor().getUserId();
        }
        if (this.c == null && !u79.D(this.a)) {
            return;
        }
        O(m39Var);
        ArrayList<vn> arrayList = new ArrayList<>(m39Var.F());
        jy9 r = r(arrayList);
        if (this.H.N().isQuestionThread()) {
            jy9Var = s(m39Var);
        } else {
            jy9Var = null;
        }
        if (jy9Var != null) {
            arrayList.remove(jy9Var);
        }
        if (r != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!zs7.f() && UbsABTestHelper.isPbCommentFunAdABTest() && this.H.s0()) {
            M(arrayList, Boolean.valueOf(z2));
        }
        if (r != null) {
            this.V = r;
        }
        if (!this.N && r != null) {
            arrayList.remove(r);
            if (m39Var.w0() && r.a0() != null) {
                r.d1(null);
            }
            z2 = true;
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z2 && m39Var.i() != null) {
            jy9 i6 = m39Var.i();
            if (!this.N && m39Var.w0() && i6.a0() != null) {
                i6.d1(null);
            }
            boolean z13 = this.N;
            if ((!z13 || (z13 && this.P)) && (jy9Var5 = this.V) != null && i6.i0 == null) {
                m39Var.F0(jy9Var5);
                jy9Var2 = jy9Var5;
            } else {
                jy9Var2 = i6;
            }
            z2 = true;
            z4 = true;
        } else {
            jy9Var2 = r;
            z4 = z3;
        }
        o(arrayList);
        if (this.a.B5()) {
            if (m39Var.F().size() > 0 && (jy9Var4 = m39Var.F().get(0)) != null && jy9Var4.D() == 1 && !ListUtils.isEmpty(arrayList)) {
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
        ix9.f(arrayList, 1);
        int C = C(m39Var, arrayList);
        if (C >= 0) {
            Z(m39Var, arrayList, C);
            z5 = true;
        } else {
            z5 = false;
        }
        int H = H(m39Var, arrayList);
        if (H >= 0) {
            x39 x39Var = new x39(x39.c);
            x39Var.b(true);
            ListUtils.add(arrayList, H, x39Var);
        }
        int w = w(m39Var, arrayList);
        List<vn> x = x(m39Var);
        if (!ListUtils.isEmpty(x) && w >= 0) {
            vn vnVar2 = (vn) ListUtils.getItem(arrayList, w);
            if (vnVar2 instanceof jy9) {
                ((jy9) vnVar2).R = true;
            }
            ListUtils.addAll(arrayList, w, x);
            z5 = true;
        }
        if (z2) {
            i = G(m39Var, arrayList, this.N);
        } else {
            i = -1;
        }
        if (i >= 0 && m39Var.R() != null) {
            jy9 W = m39Var.W();
            ThreadData c2 = m39Var.R().c();
            if (W != null && W.q0() != null && c2 != null && c2.getCustomFigure() == null) {
                VirtualImageCustomFigure q0 = W.q0();
                VirtualImageCustomState r0 = W.r0();
                c2.setCustomFigure(q0);
                c2.setCustomState(r0);
            }
            ListUtils.add(arrayList, i, m39Var.R());
            z6 = true;
            z7 = true;
        } else {
            if (jy9Var2 != null) {
                jy9Var2.Q = true;
            }
            z6 = z5;
            z7 = false;
        }
        if ((this.H.N().isQuestionThread() && jy9Var != null) || (this.H.N().isQuestionThread() && this.W != null)) {
            if (jy9Var == null && (jy9Var3 = this.W) != null) {
                jy9Var = jy9Var3;
            }
            if (!arrayList.contains(jy9Var)) {
                i++;
                c0(jy9Var, arrayList, i);
            }
        }
        if (X(m39Var, jy9Var2, arrayList, i) != null || W(m39Var, jy9Var2, arrayList, i) != null || V(m39Var, arrayList, i) != null) {
            i++;
        }
        if (S(m39Var, arrayList, i) != null) {
            i++;
        }
        if (z2 && m39Var.M() != null && m39Var.M().similar_thread != null && m39Var.M().similar_thread.id.longValue() > 0) {
            b0(m39Var, arrayList, i);
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
                    x69Var = null;
                } else {
                    x69 Y = Y(arrayList, vnVar, i, i5);
                    if (Y != null) {
                        if (!z11) {
                            x69Var = Y;
                            i2 = i;
                            z8 = true;
                        } else if (i5 > 0) {
                            i5++;
                        } else {
                            i++;
                        }
                    }
                    x69Var = Y;
                    z8 = z11;
                    i2 = i;
                }
                i3 = i5;
            } else {
                i2 = i;
                z8 = false;
                i3 = -1;
                x69Var = null;
            }
            if (z2) {
                if (x69Var != null) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                list = x;
                int i7 = i2;
                i4 = w;
                boolean R = R(m39Var, arrayList, z8, z9, i3, i7, w, C);
                if (x69Var != null) {
                    x69Var.n = R;
                }
                if (u79.D(this.a)) {
                    s39 s39Var = new s39();
                    if (m39Var.N().getTaskInfoData() != null) {
                        s39Var.f(m39Var.N().getTaskInfoData().r());
                        s39Var.e(m39Var.N().getTaskInfoData().q());
                    }
                    yo8.b(arrayList, s39Var, 0);
                    if (!z7 && m39Var.R() != null) {
                        jy9 W2 = m39Var.W();
                        ThreadData c3 = m39Var.R().c();
                        if (W2 != null && W2.q0() != null && c3 != null && c3.getCustomFigure() == null) {
                            VirtualImageCustomFigure q02 = W2.q0();
                            VirtualImageCustomState r02 = W2.r0();
                            c3.setCustomFigure(q02);
                            c3.setCustomState(r02);
                        }
                        ListUtils.add(arrayList, 1, m39Var.R());
                        z6 = true;
                        z7 = true;
                        o69Var = this.c;
                        if (o69Var != null) {
                            o69Var.e0(!z6);
                        }
                        boolean J0 = J0(jy9Var2);
                        if (this.O && !J0) {
                            arrayList.remove(jy9Var2);
                            this.O = false;
                        }
                        if (m39Var.R() != null) {
                            m39Var.R().h(!z7);
                        }
                        if (this.b != null) {
                            this.J = arrayList;
                            List<vn> Q = m39Var.Q();
                            if (!ListUtils.isEmpty(Q)) {
                                this.b.setData(K(arrayList, Q));
                            } else {
                                this.b.setData(this.J);
                            }
                        }
                        k0(J0, z, i4, list);
                        if (t(jy9Var2, arrayList, z4)) {
                            List<vn> Q2 = m39Var.Q();
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
                o69Var = this.c;
                if (o69Var != null) {
                }
                boolean J02 = J0(jy9Var2);
                if (this.O) {
                    arrayList.remove(jy9Var2);
                    this.O = false;
                }
                if (m39Var.R() != null) {
                }
                if (this.b != null) {
                }
                k0(J02, z, i4, list);
                if (t(jy9Var2, arrayList, z4)) {
                }
            }
        }
        list = x;
        i4 = w;
        if (u79.D(this.a)) {
        }
        o69Var = this.c;
        if (o69Var != null) {
        }
        boolean J022 = J0(jy9Var2);
        if (this.O) {
        }
        if (m39Var.R() != null) {
        }
        if (this.b != null) {
        }
        k0(J022, z, i4, list);
        if (t(jy9Var2, arrayList, z4)) {
        }
    }

    public final boolean t(jy9 jy9Var, ArrayList<vn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048641, this, jy9Var, arrayList, z)) == null) {
            if (jy9Var == null) {
                jy9 jy9Var2 = this.V;
                if (jy9Var2 != null && !this.P) {
                    ListUtils.add(arrayList, 0, jy9Var2);
                } else {
                    jy9 jy9Var3 = new jy9();
                    jy9Var3.L0(1);
                    ListUtils.add(arrayList, 0, jy9Var3);
                }
                return true;
            } else if (!z) {
                return false;
            } else {
                ListUtils.add(arrayList, 0, jy9Var);
                return true;
            }
        }
        return invokeLLZ.booleanValue;
    }
}
