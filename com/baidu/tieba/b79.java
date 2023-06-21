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
public class b79 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbReplyLoadMoreAdapter A;
    public ArrayList<d69> B;
    public c79 C;
    public s79 D;
    public f99 E;
    public PbFirstFloorWebViewAdapter F;
    public e69 G;
    public j49 H;
    public ArrayList<b0a> I;
    public ArrayList<wn> J;
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
    public int f1090T;
    public String U;
    public b0a V;
    public b0a W;
    public View.OnClickListener X;
    public View.OnClickListener Y;
    public View.OnClickListener Z;
    public PbFragment a;
    public TbRichTextView.z a0;
    public BdTypeListView b;
    public View.OnClickListener b0;
    public m79 c;
    public q59 c0;
    public n79 d;
    public View.OnLongClickListener d0;
    public PbFirstFloorCommentAndPraiseAdapter e;
    public SortSwitchButton.f e0;
    public PbFirstFloorEnterForumAdapter f;
    public final List<jn> f0;
    public PbFirstFloorItemAdapter g;
    public final List<jn> g0;
    public PbFirstFloorRecommendAdapter h;
    public Runnable h0;
    public PbFirstFloorSimilarTitleAdapter i;
    public int i0;
    public g99 j;
    public int j0;
    public d99 k;
    public int k0;
    public i89 l;
    public ThreadData l0;
    public w79 m;
    public List<b0a> m0;
    public i89 n;
    public final CustomMessageListener n0;
    public e79 o;
    public CustomMessageListener o0;
    public l89 p;
    public final CustomMessageListener p0;
    public gc9 q;
    public final View.OnClickListener q0;
    public ip6 r;
    public CustomMessageListener r0;
    public jn s;
    public List<jn> s0;
    public jn t;
    public jn u;
    public jn v;
    public jn w;
    public e89 x;
    public g89 y;
    public d89 z;

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b79 a;

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
        public c(b79 b79Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b79Var, Integer.valueOf(i)};
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
            this.a = b79Var;
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
                    xg.a().postDelayed(new a(this), TimeUnit.SECONDS.toMillis(2L));
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
        public final /* synthetic */ b79 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b79 b79Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b79Var, Integer.valueOf(i)};
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
            this.a = b79Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof zz9)) {
                zz9 zz9Var = (zz9) customResponsedMessage.getData();
                if (this.a.l0 != null && this.a.l0.funAdData == zz9Var) {
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
        public final /* synthetic */ b79 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(b79 b79Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b79Var, Integer.valueOf(i)};
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
            this.a = b79Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof qz9)) {
                AbsDelegateAdapterList a = ((qz9) customResponsedMessage.getData()).a();
                Iterator<jn<?, ?>> it = a.iterator();
                while (it.hasNext()) {
                    jn<?, ?> next = it.next();
                    if (next instanceof g79) {
                        ((g79) next).t(this.a.a);
                        if (next instanceof d69) {
                            this.a.B.add((d69) next);
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
        public final /* synthetic */ b79 a;

        public d(b79 b79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b79Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a != null && this.a.H != null && this.a.H.S() != null) {
                this.a.a.L5().Z0().v();
                TiebaStatic.log(new StatisticItem("c12040"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ b79 b;

        public e(b79 b79Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b79Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = b79Var;
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
        public final /* synthetic */ b79 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(b79 b79Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b79Var, Integer.valueOf(i)};
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
            this.a = b79Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.s0)) {
                this.a.n();
                b79 b79Var = this.a;
                b79Var.o0(b79Var.H, false);
            }
        }
    }

    public b79(PbFragment pbFragment, BdTypeListView bdTypeListView) {
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
        this.f1090T = 0;
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
        this.f1090T = wi.l(pbFragment.getPageContext().getPageActivity());
        this.a = pbFragment;
        this.b = bdTypeListView;
        N(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.p0);
        this.j0 = wi.j(this.a.getContext()) / 3;
    }

    public final wn Q(ArrayList<wn> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048605, this, arrayList, i)) == null) {
            if (this.H == null) {
                return null;
            }
            a0a R0 = this.a.Q().R0();
            if (R0 == null) {
                R0 = this.H.z();
            }
            if (R0 == null) {
                return null;
            }
            AdvertAppInfo.ILegoAdvert C1 = R0.C1();
            if (C1 != null) {
                C1.setAdvertAppInfo(R0.getAdvertAppInfo());
            }
            int i2 = R0.getAdvertAppInfo().i();
            if (i2 != 0) {
                pp9.j(R0, i2);
                if (i2 != 28 && i2 != 31) {
                    R0.getAdvertAppInfo().c = -1001;
                }
                return null;
            }
            if (this.H.k() != null) {
                R0.i1 = this.H.k().getId();
            }
            if (this.H.N() != null) {
                R0.l1 = ug.g(this.H.N().getId(), 0L);
            }
            j49 j49Var = this.H;
            if (j49Var != null && j49Var.y() != null) {
                R0.m1 = this.H.y().a();
            }
            l(R0);
            if (i < 0) {
                return null;
            }
            R0.p1 = 1;
            t56.k().q(true);
            sp8.b(arrayList, R0, i);
            j49 j49Var2 = this.H;
            if (j49Var2 != null) {
                j49Var2.L0(R0);
            }
            if (m66.i().q()) {
                m66.i().n(arrayList, i + 1, 4);
            }
            return R0;
        }
        return (wn) invokeLI.objValue;
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

    public void A0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.X = onClickListener;
        }
    }

    public void C0(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, zVar) == null) {
            this.a0 = zVar;
        }
    }

    public void D0(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onLongClickListener) == null) {
            this.d0 = onLongClickListener;
        }
    }

    public void E0(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, fVar) == null) {
            this.e0 = fVar;
        }
    }

    public void F0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) {
            this.Y = onClickListener;
        }
    }

    public void G0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onClickListener) == null) {
            this.b0 = onClickListener;
        }
    }

    public void H0(q59 q59Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, q59Var) == null) {
            this.c0 = q59Var;
        }
    }

    public void J0(@NonNull j49 j49Var) {
        m79 m79Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, j49Var) == null) && (m79Var = this.c) != null) {
            m79Var.i0(j49Var);
        }
    }

    public final void P(PbFragment pbFragment) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048604, this, pbFragment) == null) && pbFragment != null && pbFragment.getPageContext() != null) {
            DefaultLog.getInstance().c("PbAdapterManager", "初始化PbFirstFloorWebViewAdapter");
            this.F = new PbFirstFloorWebViewAdapter(pbFragment, p49.c);
        }
    }

    public void j0(boolean z) {
        m79 m79Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048624, this, z) == null) && (m79Var = this.c) != null) {
            m79Var.V(z);
        }
    }

    public void q0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
            this.L = z;
        }
    }

    public void r0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048639, this, z) == null) {
            this.O = z;
        }
    }

    public final b0a s(j49 j49Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048640, this, j49Var)) == null) {
            if (j49Var != null && j49Var.T() != null) {
                b0a T2 = j49Var.T();
                this.W = T2;
                return T2;
            }
            return null;
        }
        return (b0a) invokeL.objValue;
    }

    public void s0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048641, this, z) == null) {
            this.M = z;
        }
    }

    public void t0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048643, this, z) == null) {
            this.S = z;
        }
    }

    public void u0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048645, this, z) == null) {
            this.P = z;
        }
    }

    public void v0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048647, this, z) == null) {
            this.Q = z;
        }
    }

    public void w0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048649, this, z) == null) {
            this.N = z;
        }
    }

    public void x0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048651, this, z) == null) {
            this.R = z;
        }
    }

    public void y0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, onClickListener) == null) {
            this.Z = onClickListener;
        }
    }

    public wn z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048654, this, i)) == null) {
            return this.b.G(i);
        }
        return (wn) invokeI.objValue;
    }

    public void z0(boolean z) {
        e79 e79Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048655, this, z) == null) && (e79Var = this.o) != null) {
            e79Var.q0(z);
        }
    }

    public final int I(n49 n49Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, n49Var, i)) == null) {
            if (n49Var.e0()) {
                if (i == 25) {
                    return 4;
                }
                return 5;
            }
            if (n49Var.f0()) {
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

    public final void n0(b0a b0aVar, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048631, this, b0aVar, threadData) == null) && b0aVar != null && b0aVar.x() != null && threadData != null && threadData.getCallRobotEntrance() == null) {
            threadData.setCallRobotEntrance(b0aVar.x());
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

    public void I0() {
        w79 w79Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (w79Var = this.m) != null) {
            w79Var.z(2);
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

    public void M0() {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (i = this.k0) > 0 && T(this.J, i) != null) {
            this.k0 = -1;
            this.b.setData(this.J);
            f0();
        }
    }

    public boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.K;
        }
        return invokeV.booleanValue;
    }

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.M;
        }
        return invokeV.booleanValue;
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.i0 = D();
            if (this.b.getAdapter2() instanceof nn) {
                this.b.getAdapter2().notifyDataSetChanged();
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048628, this) == null) && this.a != null && !n()) {
            this.a.registerListener(this.r0);
        }
    }

    public View u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return this.G.b();
        }
        return (View) invokeV.objValue;
    }

    public ArrayList<wn> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            return this.J;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            return this.b.getHeaderViewsCount();
        }
        return invokeV.intValue;
    }

    public void B0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            e79 e79Var = this.o;
            if (e79Var != null) {
                e79Var.r0(z);
            }
            i89 i89Var = this.l;
            if (i89Var != null) {
                i89Var.A(z);
            }
            jn jnVar = this.w;
            if (jnVar != null) {
                jnVar.setMulDel(z);
            }
            jn jnVar2 = this.t;
            if (jnVar2 != null) {
                jnVar2.setMulDel(z);
            }
            m79 m79Var = this.c;
            if (m79Var != null) {
                m79Var.setMulDel(z);
            }
        }
    }

    public final boolean K0(b0a b0aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, b0aVar)) == null) {
            if (this.a.Q() != null && b0aVar != null && b0aVar.S() != null && b0aVar.S().equals(this.a.Q().X1())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void p0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            this.K = z;
            m79 m79Var = this.c;
            if (m79Var != null) {
                m79Var.setFromCDN(z);
            }
            jn jnVar = this.t;
            if (jnVar != null && (jnVar instanceof wn9)) {
                ((wn9) jnVar).setIsFromCDN(z);
            }
            Iterator<d69> it = this.B.iterator();
            while (it.hasNext()) {
                it.next().setFromCDN(z);
            }
        }
    }

    public final b0a r(ArrayList<wn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, arrayList)) == null) {
            Iterator<wn> it = arrayList.iterator();
            while (it.hasNext()) {
                wn next = it.next();
                if (next instanceof b0a) {
                    b0a b0aVar = (b0a) next;
                    if (b0aVar.I() == 1) {
                        return b0aVar;
                    }
                }
            }
            return null;
        }
        return (b0a) invokeL.objValue;
    }

    public final int C(j49 j49Var, ArrayList<wn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, j49Var, arrayList)) == null) {
            if (j49Var == null || ListUtils.isEmpty(j49Var.F()) || ListUtils.isEmpty(arrayList) || ((b0a) ListUtils.getItem(j49Var.F(), 0)) == null) {
                return 0;
            }
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    wn wnVar = arrayList.get(i);
                    if (wnVar instanceof b0a) {
                        b0a b0aVar = (b0a) wnVar;
                        if (b0aVar.I() == 1 && b0aVar.O == 0) {
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

    public final int H(j49 j49Var, ArrayList<wn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, j49Var, arrayList)) == null) {
            int i = -1;
            if (j49Var == null || j49Var.y() == null) {
                return -1;
            }
            int i2 = 0;
            if (j49Var.y().c() == 1) {
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
                } else if (arrayList.get(i2) instanceof y49) {
                    i = i2 + 1;
                    break;
                } else {
                    i2++;
                }
            }
            if (j49Var.J() == 4) {
                return i + 1;
            }
            return i;
        }
        return invokeLL.intValue;
    }

    public final void M(ArrayList<wn> arrayList, Boolean bool) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048600, this, arrayList, bool) != null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        int i = kc5.i();
        int j = kc5.j() - 1;
        if (bool.booleanValue()) {
            wn wnVar = arrayList.get(0);
            if ((wnVar instanceof b0a) && ((b0a) wnVar).I() == 1) {
                j++;
            }
        }
        int k = kc5.k() + 1;
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
                    wn wnVar = this.b.getData().get(i);
                    if (wnVar != null && wnVar.getType() == y49.g) {
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
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            xg.a().removeCallbacks(this.h0);
            i89 i89Var = this.l;
            if (i89Var != null) {
                i89Var.onDestroy();
            }
            i89 i89Var2 = this.n;
            if (i89Var2 != null) {
                i89Var2.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.e;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
            d99 d99Var = this.k;
            if (d99Var != null) {
                d99Var.onDestroy();
            }
            t56.k().q(false);
        }
    }

    public int E(j49 j49Var, ArrayList<wn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j49Var, arrayList, z)) == null) {
            if (j49Var == null || j49Var.F() == null || j49Var.C() == null || j49Var.F().size() == 0 || j49Var.N() == null || arrayList == null || !j49Var.C().z1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (j49Var.F().get(0) == null || j49Var.F().get(0).I() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (j49Var.y() == null || j49Var.y().a() != j49Var.y().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public int F(j49 j49Var, ArrayList<wn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048586, this, j49Var, arrayList, z)) == null) {
            if (j49Var == null || j49Var.F() == null || j49Var.D() == null || j49Var.F().size() == 0 || j49Var.N() == null || arrayList == null || !j49Var.D().z1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (j49Var.F().get(0) == null || j49Var.F().get(0).I() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (j49Var.y() == null || j49Var.y().a() != j49Var.y().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final wn V(j49 j49Var, ArrayList<wn> arrayList, int i) {
        InterceptResult invokeLLI;
        l49 l49Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048610, this, j49Var, arrayList, i)) == null) {
            if (j49Var.k() != null && !StringUtils.isNull(j49Var.k().getName()) && !j49Var.m) {
                if (!TextUtils.equals(j49Var.k().getName(), this.a.Q().X0()) || !this.a.Q().d1()) {
                    if (!this.a.z0() && !ListUtils.isEmpty(j49Var.o())) {
                        l49Var = new l49(j49Var.o().get(0));
                    } else {
                        l49Var = new l49(j49Var.k());
                    }
                    l49Var.g = this.a.Q().R1();
                    if (!UbsABTestHelper.isPbEnterForum()) {
                        i++;
                    }
                    ListUtils.add(arrayList, i, l49Var);
                    return l49Var;
                }
                return null;
            }
            return null;
        }
        return (wn) invokeLLI.objValue;
    }

    public final int b0(j49 j49Var, ArrayList<wn> arrayList, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048616, this, j49Var, arrayList, i)) == null) {
            n49 n49Var = new n49(j49Var.M());
            String tid = n49Var.d0().getTid();
            int x1 = this.a.Q().x1();
            j49Var.N0(I(n49Var, x1));
            o49 o49Var = new o49(n49Var.b0(), n49Var.c0());
            o49Var.a = n49Var.d0();
            o49Var.C = x1;
            o49Var.g = tid;
            int i2 = i + 1;
            ListUtils.add(arrayList, i2, o49Var);
            n49Var.d0().isLinkThread();
            n49Var.d0().isSmartAppThreadType();
            if (!n49Var.d0().isLinkThread() && !n49Var.d0().isSmartAppThreadType()) {
                n49Var.d0().isGodThread();
            }
            n49Var.a = n49Var.d0();
            n49Var.C = x1;
            n49Var.g = tid;
            n49Var.setSupportType(BaseCardInfo.SupportType.NONE);
            ListUtils.add(arrayList, i2 + 1, n49Var);
            return i2;
        }
        return invokeLLI.intValue;
    }

    public final int G(j49 j49Var, ArrayList<wn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048588, this, j49Var, arrayList, z)) == null) {
            if (j49Var != null && !ListUtils.isEmpty(j49Var.F()) && arrayList != null && arrayList.size() > 0) {
                if (!z) {
                    return 0;
                }
                if (j49Var.F().get(0) != null && j49Var.F().get(0).I() == 1) {
                    return 1;
                }
                if (j49Var.i() == null) {
                    return -1;
                }
                return 0;
            } else if (j49Var == null || !j49Var.w0()) {
                return -1;
            } else {
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final void Z(j49 j49Var, ArrayList<wn> arrayList, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048614, this, j49Var, arrayList, i) == null) {
            y49 y49Var = new y49(y49.g);
            ThreadData N = j49Var.N();
            y49Var.c = this.a.d6();
            y49Var.b = j49Var.g;
            y49Var.d = j49Var.i0();
            y49Var.e = j49Var.f;
            if (N != null && N.isQuestionThread()) {
                z = true;
            } else {
                z = false;
            }
            y49Var.f = z;
            ListUtils.add(arrayList, i, y49Var);
            if (j49Var.J() == 4) {
                ListUtils.add(arrayList, i + 1, new x49());
            }
        }
    }

    public final ArrayList<wn> K(List<wn> list, List<wn> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, list, list2)) == null) {
            ArrayList<wn> arrayList = new ArrayList<>(list.size() + list2.size() + 2);
            arrayList.addAll(list);
            r49 r49Var = new r49();
            PbListView d1 = this.a.L5().d1();
            if (d1 != null && d1.q()) {
                r49Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fb3);
                r49Var.b = true;
            } else {
                r49Var.a = TbadkCoreApplication.getInst().getString(R.string.list_has_all_comments);
                r49Var.b = false;
            }
            arrayList.add(r49Var);
            lp6 lp6Var = new lp6();
            lp6Var.a = TbadkCoreApplication.getInst().getString(R.string.recommed_for_you);
            lp6Var.needTopMargin = false;
            arrayList.add(lp6Var);
            arrayList.addAll(list2);
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public final int w(j49 j49Var, ArrayList<wn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048648, this, j49Var, arrayList)) == null) {
            if (!this.P && j49Var != null && !ListUtils.isEmpty(j49Var.F()) && arrayList != null && arrayList.size() > 0) {
                if (this.a.Q() != null && this.a.Q().h1()) {
                    return -1;
                }
                if (this.a.L5() != null && this.a.L5().V0()) {
                    return -1;
                }
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    if (i < size) {
                        wn wnVar = arrayList.get(i);
                        if (wnVar instanceof b0a) {
                            b0a b0aVar = (b0a) wnVar;
                            if (b0aVar.I() == 1 && b0aVar.O == 0) {
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
                    if (j49Var.w0()) {
                        return 0;
                    }
                    return -1;
                }
                return i + 1;
            } else if (j49Var != null && j49Var.w0() && this.N) {
                return 0;
            } else {
                return -1;
            }
        }
        return invokeLL.intValue;
    }

    public View L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            m79 m79Var = this.c;
            if (m79Var != null && m79Var.Q() != null) {
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
        b0a b0aVar;
        m79 m79Var;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048627, this) == null) && this.H != null && (b0aVar = this.V) != null && b0aVar.a0() != null && (m79Var = this.c) != null && m79Var.Q() != null) {
            String P = this.H.P();
            String l = this.H.l();
            if (this.H.N() != null) {
                i = this.H.N().getThreadType();
            } else {
                i = 0;
            }
            mr5.a().c(P, l, this.V.a0(), this.c.Q().s, i);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048634, this) == null) && this.f0 != null) {
            DefaultLog.getInstance().c("PbAdapterManager", "动态修正Adapter");
            this.f0.remove(this.c);
            if (this.d == null) {
                this.d = new n79(this.a, b0a.W0);
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

    public final void L0() {
        j49 j49Var;
        a0a a0aVar;
        a0a a0aVar2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || (j49Var = this.H) == null || j49Var.Z || j49Var.a0 == 2) {
            return;
        }
        ArrayList<b0a> F = j49Var.F();
        ArrayList<a0a> d2 = this.H.d();
        if (!sp8.e(F) && !sp8.e(d2)) {
            StringBuilder sb = new StringBuilder();
            Iterator<a0a> it = d2.iterator();
            while (it.hasNext()) {
                a0a next = it.next();
                if (next != null && next.A1() != null) {
                    sb.append(next.A1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<a0a> it2 = d2.iterator();
            while (it2.hasNext()) {
                a0a next2 = it2.next();
                if (next2 != null) {
                    next2.o1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<a0a> it3 = d2.iterator();
            while (it3.hasNext()) {
                a0a next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int i = next3.getAdvertAppInfo().i();
                    if (i != 0) {
                        pp9.j(next3, i);
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
                a0a a0aVar3 = (a0a) sparseArray.valueAt(i2);
                if (a0aVar3 != null && (a0aVar2 = (a0a) hashMap.put(a0aVar3.z1(), a0aVar3)) != null) {
                    pp9.j(a0aVar2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (a0aVar = (a0a) entry.getValue()) != null) {
                    sparseArray.put(a0aVar.getPosition(), a0aVar);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                sp8.a(arrayList, Integer.valueOf(sparseArray.keyAt(i3)));
            }
            Collections.sort(arrayList);
            int i4 = 1;
            for (int i5 = 0; i5 < sp8.i(arrayList); i5++) {
                a0a a0aVar4 = (a0a) sparseArray.get(((Integer) sp8.d(arrayList, i5)).intValue());
                if (this.H.k() != null) {
                    a0aVar4.i1 = this.H.k().getId();
                }
                if (this.H.N() != null) {
                    a0aVar4.l1 = ug.g(this.H.N().getId(), 0L);
                }
                j49 j49Var2 = this.H;
                if (j49Var2 != null && j49Var2.y() != null) {
                    a0aVar4.m1 = this.H.y().a();
                }
                l(a0aVar4);
                int position = a0aVar4.getPosition() + this.H.Y;
                if (position >= sp8.i(F)) {
                    a0aVar4.o1 = position;
                    pp9.k(a0aVar4, 2, position, sp8.i(F));
                    return;
                }
                if (!this.N) {
                    position--;
                    a0aVar4.o1 = position;
                }
                if (position < 0) {
                    pp9.j(a0aVar4, 23);
                } else {
                    a0aVar4.p1 = i4;
                    sp8.b(F, a0aVar4, position);
                    i4++;
                    PbFragment pbFragment = this.a;
                    if (pbFragment != null && pbFragment.getPageContext() != null && this.a.getPageContext().getContext() != null) {
                        TiebaStatic.eventStat(this.a.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", a0aVar4.getAdvertAppInfo().p);
                    }
                }
            }
        }
    }

    public void N(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        n79 n79Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, pbFragment, bdTypeListView) == null) {
            if (q89.D(pbFragment)) {
                DefaultLog.getInstance().c("PbAdapterManager", "初始化PbFirstFloorEmptyAdapter");
                this.d = new n79(pbFragment, b0a.W0);
            } else {
                DefaultLog.getInstance().c("PbAdapterManager", "初始化PbFirstFloorAdapter");
                m79 m79Var = new m79(pbFragment, b0a.W0);
                this.c = m79Var;
                m79Var.g0(pbFragment);
            }
            this.e = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, z49.f);
            this.f = new PbFirstFloorEnterForumAdapter(pbFragment, l49.k);
            this.g = new PbFirstFloorItemAdapter(pbFragment.getContext(), m49.c);
            this.h = new PbFirstFloorRecommendAdapter(pbFragment.getContext(), PbFirstFloorRecommendData.d);
            this.i = new PbFirstFloorSimilarTitleAdapter(pbFragment.getPageContext(), o49.f1147T);
            this.j = new g99(pbFragment.getPageContext(), n49.W0);
            this.k = new d99(pbFragment, g49.c);
            this.l = new i89(pbFragment, y49.g);
            this.m = new w79(pbFragment, t49.c);
            this.n = new i89(pbFragment, y49.h);
            e79 e79Var = new e79(pbFragment, b0a.X0);
            this.o = e79Var;
            e79Var.t0(pbFragment);
            l89 l89Var = new l89(pbFragment, b0a.Y0);
            this.p = l89Var;
            l89Var.v0(pbFragment);
            this.s = bo9.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.x);
            this.t = bo9.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.z);
            this.u = bt7.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.F);
            this.v = bt7.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.G);
            this.w = bt7.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.I);
            this.z = new d89(pbFragment, v49.k1);
            this.x = new e89(pbFragment, c89.j1);
            this.y = new g89(pbFragment, p35.p1);
            this.A = new PbReplyLoadMoreAdapter(pbFragment, b0a.e1);
            this.q = new gc9(pbFragment, hc9.a);
            this.r = new ip6(pbFragment.getPageContext());
            this.C = new c79(pbFragment, z15.e);
            this.D = new s79(pbFragment, pbFragment.getUniqueId());
            this.E = new f99(pbFragment.getPageContext(), r66.g);
            if (q89.D(pbFragment)) {
                P(pbFragment);
            }
            e69 e69Var = new e69(pbFragment, pbFragment.getUniqueId(), this.b);
            this.G = e69Var;
            this.f0.addAll(e69Var.a());
            if (q89.D(pbFragment) && (n79Var = this.d) != null) {
                this.f0.add(n79Var);
            } else {
                m79 m79Var2 = this.c;
                if (m79Var2 != null) {
                    this.f0.add(m79Var2);
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
            if (q89.D(pbFragment)) {
                this.f0.add(this.F);
            }
            this.o0.setPriority(1);
            this.o0.setSelfListener(true);
            pbFragment.registerListener(this.o0);
            pbFragment.registerListener(this.n0);
            m();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new qz9(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
            CustomMessage customMessage = new CustomMessage(2004015);
            customMessage.setTag(pbFragment.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            bdTypeListView.addAdapters(this.f0);
        }
    }

    public final void O(@NonNull j49 j49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, j49Var) == null) {
            m79 m79Var = this.c;
            if (m79Var != null) {
                m79Var.r(j49Var);
                this.c.setFromCDN(this.K);
                this.c.l(this.f1090T);
                this.c.c(this.M);
                this.c.e(this.Y);
                this.c.k(this.X);
                this.c.n(this.a0);
                this.c.d(this.d0);
                this.c.d0(this.b0);
                this.c.f0(this.c0);
            }
            this.g.y(this.b0);
            this.o.r(j49Var);
            this.o.setFromCDN(this.K);
            this.o.o(this.U);
            this.o.c(this.M);
            this.o.e(this.Y);
            this.o.k(this.X);
            this.o.n(this.a0);
            this.o.d(this.d0);
            this.o.s0(this.c0);
            this.p.r(j49Var);
            this.p.setFromCDN(this.K);
            this.p.o(this.U);
            this.p.c(this.M);
            this.p.e(this.Y);
            this.p.k(this.X);
            this.p.n(this.a0);
            this.p.d(this.d0);
            this.p.u0(this.c0);
            this.e.W(this.Y);
            this.A.y(this.Y);
            this.q.y(this.q0);
            jn jnVar = this.t;
            if (jnVar != null && (jnVar instanceof wn9)) {
                ((wn9) jnVar).setIsFromCDN(this.K);
            }
            Iterator<d69> it = this.B.iterator();
            while (it.hasNext()) {
                d69 next = it.next();
                if (next != null) {
                    next.r(j49Var);
                    next.setFromCDN(this.K);
                    next.o(this.U);
                    next.l(this.f1090T);
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
            this.l.r(j49Var);
            this.k.r(j49Var);
            this.n.r(j49Var);
            this.x.r(j49Var);
            this.y.r(j49Var);
            this.C.A(j49Var);
            this.C.z(this.a.s1);
            this.D.y(j49Var);
        }
    }

    public final boolean R(j49 j49Var, ArrayList<wn> arrayList, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{j49Var, arrayList, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            ArrayList arrayList2 = new ArrayList();
            if (!ListUtils.isEmpty(j49Var.e()) && j49Var.e().size() > 2) {
                int min = Math.min(j49Var.e().size(), 7);
                for (int i6 = 0; i6 < min; i6++) {
                    z15 z15Var = j49Var.e().get(i6);
                    if (!z2 && i6 == 0) {
                        z15Var.i(true);
                    }
                    if (z15Var.getThreadVideoInfo() == null) {
                        if (i6 == min - 1) {
                            z15Var.l(true);
                        }
                    } else if (i6 == min - 2) {
                        z15Var.l(true);
                    } else if (i6 == min - 1) {
                        z15Var.k(true);
                    }
                    arrayList2.add(z15Var);
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

    public final wn S(j49 j49Var, ArrayList<wn> arrayList, int i) {
        InterceptResult invokeLLI;
        g49 g49Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048607, this, j49Var, arrayList, i)) == null) {
            if (i >= 0 && j49Var != null && j49Var.k && (g49Var = j49Var.l) != null) {
                ListUtils.add(arrayList, i, g49Var);
                return g49Var;
            }
            return null;
        }
        return (wn) invokeLLI.objValue;
    }

    public final void c0(b0a b0aVar, ArrayList<wn> arrayList, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048617, this, b0aVar, arrayList, i) == null) {
            b0aVar.q1(true);
            arrayList.add(i, b0aVar);
        }
    }

    public final wn T(ArrayList<wn> arrayList, int i) {
        InterceptResult invokeLI;
        j49 j49Var;
        zz9 zz9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048608, this, arrayList, i)) == null) {
            if (q89.D(this.a)) {
                return null;
            }
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && i > 0 && (j49Var = this.H) != null && j49Var.s0()) {
                String d2 = gt7.e().d("pb_banner");
                if (this.l0 == null && at7.m().v(d2)) {
                    ThreadData threadData = new ThreadData();
                    this.l0 = threadData;
                    threadData.funAdData = new zz9();
                    j49 j49Var2 = this.H;
                    if (j49Var2 != null) {
                        this.l0.funAdData.m(j49Var2.l());
                        this.l0.funAdData.r(this.H.P());
                    }
                }
                ThreadData threadData2 = this.l0;
                if (threadData2 != null && (zz9Var = threadData2.funAdData) != null) {
                    zz9Var.j(1);
                    t56.k().q(true);
                    ListUtils.add(arrayList, i, this.l0);
                    if (m66.i().q()) {
                        m66.i().n(arrayList, i + 1, 4);
                    }
                }
            }
            return this.l0;
        }
        return (wn) invokeLI.objValue;
    }

    public final void U(int i, int i2, int i3, ArrayList<wn> arrayList) {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), arrayList}) == null) && !ListUtils.isEmpty(arrayList) && i >= 0 && i2 >= 1) {
            ListIterator<wn> listIterator = arrayList.listIterator();
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
                        b0a b0aVar = new b0a();
                        zz9 zz9Var = new zz9();
                        j49 j49Var = this.H;
                        if (j49Var == null) {
                            str3 = "";
                        } else {
                            str3 = j49Var.l();
                        }
                        zz9Var.m(str3);
                        j49 j49Var2 = this.H;
                        if (j49Var2 != null) {
                            str = j49Var2.P();
                        }
                        zz9Var.r(str);
                        zz9Var.n(true);
                        b0aVar.x0 = zz9Var;
                        zz9Var.j(i7);
                        listIterator.add(b0aVar);
                        i7++;
                        this.m0.add(b0aVar);
                    }
                    i5++;
                    if (i6 == 0) {
                        i6 = i4 + 1;
                    }
                }
                listIterator.next();
                i4++;
            }
            if (i6 > 0 && m66.i().q()) {
                m66.i().n(arrayList, i6, 5);
            }
            if (i4 == i && i5 < i3) {
                b0a b0aVar2 = new b0a();
                zz9 zz9Var2 = new zz9();
                j49 j49Var3 = this.H;
                if (j49Var3 == null) {
                    str2 = "";
                } else {
                    str2 = j49Var3.l();
                }
                zz9Var2.m(str2);
                j49 j49Var4 = this.H;
                if (j49Var4 != null) {
                    str = j49Var4.P();
                }
                zz9Var2.r(str);
                zz9Var2.n(true);
                b0aVar2.x0 = zz9Var2;
                zz9Var2.j(1);
                listIterator.add(b0aVar2);
                this.m0.add(b0aVar2);
                if (m66.i().q()) {
                    m66.i().n(arrayList, -1, 4);
                }
            }
        }
    }

    public final wn W(j49 j49Var, b0a b0aVar, ArrayList<wn> arrayList, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048611, this, j49Var, b0aVar, arrayList, i)) == null) {
            m49 m49Var = null;
            if (j49Var.k() != null && !StringUtils.isNull(j49Var.k().getName()) && TextUtils.equals(j49Var.k().getName(), this.a.Q().X0()) && this.a.Q().d1()) {
                return null;
            }
            if (b0aVar != null) {
                if (b0aVar.s0 != null) {
                    m49Var = new m49(b0aVar.s0);
                }
            } else {
                b0a b0aVar2 = this.V;
                if (b0aVar2 != null && b0aVar2.s0 != null) {
                    m49Var = new m49(this.V.s0);
                }
            }
            if (m49Var != null) {
                m49Var.b = this.a.Q().R1();
                ListUtils.add(arrayList, i + 1, m49Var);
            }
            return m49Var;
        }
        return (wn) invokeLLLI.objValue;
    }

    public final wn X(j49 j49Var, b0a b0aVar, ArrayList<wn> arrayList, int i) {
        InterceptResult invokeLLLI;
        PbFirstFloorRecommendData pbFirstFloorRecommendData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048612, this, j49Var, b0aVar, arrayList, i)) == null) {
            if (b0aVar != null && b0aVar.b0() != null) {
                pbFirstFloorRecommendData = new PbFirstFloorRecommendData(b0aVar.b0());
            } else {
                b0a b0aVar2 = this.V;
                if (b0aVar2 != null && b0aVar2.b0() != null) {
                    pbFirstFloorRecommendData = new PbFirstFloorRecommendData(this.V.b0());
                } else {
                    pbFirstFloorRecommendData = null;
                }
            }
            if (pbFirstFloorRecommendData != null) {
                if (j49Var != null && !TextUtils.isEmpty(j49Var.P())) {
                    pbFirstFloorRecommendData.f(j49Var.P());
                }
                ListUtils.add(arrayList, i + 1, pbFirstFloorRecommendData);
            }
            return pbFirstFloorRecommendData;
        }
        return (wn) invokeLLLI.objValue;
    }

    public final void k0(boolean z, boolean z2, int i, List<wn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), list}) == null) && !z && !z2) {
            if ((this.Q || this.P) && i != -1 && !ListUtils.isEmpty(list) && !this.R) {
                this.h0 = new e(this, list);
                xg.a().post(this.h0);
            }
        }
    }

    public final t79 Y(ArrayList<wn> arrayList, wn wnVar, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048613, this, arrayList, wnVar, i, i2)) == null) {
            t79 B = this.H.B();
            if (B != null) {
                if (wnVar != null) {
                    if (i2 < 0 && wnVar.getType() != AdvertAppInfo.z) {
                        i2 = i + 2;
                    } else if (wnVar.getType() != AdvertAppInfo.z) {
                        i2++;
                    } else {
                        i2 = -1;
                    }
                }
                if (i2 > 0 && (B instanceof t79)) {
                    ListUtils.add(arrayList, i2, B);
                    return B;
                }
                return null;
            }
            return null;
        }
        return (t79) invokeLLII.objValue;
    }

    public final wn a0(ArrayList<wn> arrayList, int i) {
        InterceptResult invokeLI;
        PbModel Q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048615, this, arrayList, i)) == null) {
            if (i < 0 || (Q = this.a.Q()) == null || TextUtils.isEmpty(Q.C1())) {
                return null;
            }
            a0a a0aVar = new a0a();
            l(a0aVar);
            ListUtils.add(arrayList, i + 1, a0aVar);
            return a0aVar;
        }
        return (wn) invokeLI.objValue;
    }

    public void h0(boolean z, int i) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && (pbFragment = this.a) != null && pbFragment.L5() != null) {
            this.a.L5().e2(z, i);
        }
    }

    public void g0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        m79 m79Var = this.c;
                        if (m79Var != null) {
                            m79Var.X();
                        }
                        PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter = this.F;
                        if (pbFirstFloorWebViewAdapter != null) {
                            pbFirstFloorWebViewAdapter.onDestroy();
                        }
                        jn jnVar = this.t;
                        if (jnVar instanceof rn9) {
                            ((rn9) jnVar).onDestroy();
                        }
                        jn jnVar2 = this.u;
                        if (jnVar2 instanceof rn9) {
                            ((rn9) jnVar2).onDestroy();
                        }
                        jn jnVar3 = this.w;
                        if (jnVar3 instanceof rn9) {
                            ((rn9) jnVar3).onDestroy();
                        }
                        f79.a().d();
                        return;
                    }
                    return;
                }
                m79 m79Var2 = this.c;
                if (m79Var2 != null) {
                    m79Var2.Y();
                }
                PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter2 = this.F;
                if (pbFirstFloorWebViewAdapter2 != null) {
                    pbFirstFloorWebViewAdapter2.onResume();
                }
                jn jnVar4 = this.t;
                if (jnVar4 instanceof rn9) {
                    ((rn9) jnVar4).onResume();
                }
                jn jnVar5 = this.u;
                if (jnVar5 instanceof rn9) {
                    ((rn9) jnVar5).onResume();
                }
                jn jnVar6 = this.w;
                if (jnVar6 instanceof rn9) {
                    ((rn9) jnVar6).onResume();
                }
                m0(false);
                l0();
                return;
            }
            m79 m79Var3 = this.c;
            if (m79Var3 != null) {
                m79Var3.W();
            }
            PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter3 = this.F;
            if (pbFirstFloorWebViewAdapter3 != null) {
                pbFirstFloorWebViewAdapter3.onPause();
            }
            jn jnVar7 = this.t;
            if (jnVar7 instanceof rn9) {
                ((rn9) jnVar7).onPause();
            }
            jn jnVar8 = this.u;
            if (jnVar8 instanceof rn9) {
                ((rn9) jnVar8).onPause();
            }
            jn jnVar9 = this.w;
            if (jnVar9 instanceof rn9) {
                ((rn9) jnVar9).onPause();
            }
            f79.a().i(this.a.V());
            mr5.a().d();
        }
    }

    public final void l(a0a a0aVar) {
        ForumData k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048626, this, a0aVar) == null) && a0aVar != null && this.H != null && a0aVar.getAdvertAppInfo() != null) {
            a0aVar.getAdvertAppInfo().i = new n15();
            if (this.H.y() != null) {
                a0aVar.getAdvertAppInfo().i.b = this.H.y().a();
            }
            a0aVar.getAdvertAppInfo().i.a = a0aVar.B1();
            if (this.H.k() != null && (k = this.H.k()) != null) {
                a0aVar.getAdvertAppInfo().i.c = k.getId();
                a0aVar.getAdvertAppInfo().i.d = k.getFirst_class();
                a0aVar.getAdvertAppInfo().i.e = k.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                a0aVar.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            a0aVar.getAdvertAppInfo().i.g = a0aVar.getAdvertAppInfo().g;
            a0aVar.getAdvertAppInfo().i.h = false;
        }
    }

    public final List<wn> x(j49 j49Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048650, this, j49Var)) == null) {
            if (j49Var == null || j49Var.S() == null || ListUtils.isEmpty(j49Var.S().a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<b0a> list = j49Var.S().a;
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            int min = Math.min(2, list.size());
            for (int i = 0; i < min; i++) {
                b0a b0aVar = list.get(i);
                if (b0aVar != null) {
                    b0aVar.d0 = true;
                    b0aVar.P = true;
                    arrayList.add(b0aVar);
                }
            }
            if (ListUtils.getCount(j49Var.S().b) > 2) {
                wn wnVar = (wn) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (wnVar instanceof b0a) {
                    ((b0a) wnVar).P = false;
                }
                arrayList.add(new hc9());
            } else {
                wn wnVar2 = (wn) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (wnVar2 instanceof b0a) {
                    ((b0a) wnVar2).P = true;
                }
            }
            arrayList.add(0, new y49(y49.h));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048629, this, z) == null) && this.a.L5() != null && this.a.V() != null && this.a.V().K1() != null) {
            f79.a().f(this.a.V().K1().l2(), this.l.x(), this.a.L5().f1(), this.a.V().getPageStayDurationItem(), z, this.G.b(), this.a.getListView());
        }
    }

    public final void o(List<wn> list) {
        int size;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048632, this, list) == null) && list != null && (size = list.size()) > 0) {
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (list.get(i2) instanceof b0a) {
                    if (i == 0 && (list.get(i2) instanceof a0a)) {
                        i = i2 + 1;
                    }
                    b0a b0aVar = (b0a) list.get(i2);
                    if (!TextUtils.isEmpty(b0aVar.Y())) {
                        a35 a35Var = new a35();
                        a35Var.e(b0aVar.Y());
                        list.set(i2, a35Var);
                    }
                }
            }
            if (i > 0 && m66.i().q()) {
                m66.i().n(list, i, 5);
            }
        }
    }

    public void q(j49 j49Var) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048636, this, j49Var) == null) && j49Var.N() != null && j49Var.N().getTaskInfoData() != null && ThreadCardUtils.isHeadlinesCard(j49Var.N().getTaskInfoData())) {
            DefaultLog.getInstance().c("PbAdapterManager", "动态修正头条卡信息");
            if (this.F == null && this.b != null) {
                q89.H(this.a, j49Var.N().getTaskInfoData().j());
                p();
                this.b.F();
                this.b.addAdapters(this.f0);
            }
            PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter = this.F;
            if (pbFirstFloorWebViewAdapter != null && pbFirstFloorWebViewAdapter.u() != 1 && (pbFragment = this.a) != null && pbFragment.L5() != null) {
                this.a.L5().j4();
            }
        }
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            if (this.a == null) {
                return false;
            }
            this.s0 = new ArrayList();
            ArrayList<BdUniqueId> g = az9.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                kp8 b2 = pq8.d().b(this.a.getPageContext(), g.get(i), 2);
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

    /* JADX WARN: Removed duplicated region for block: B:219:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x03a9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:245:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:262:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void o0(j49 j49Var, boolean z) {
        b0a b0aVar;
        boolean z2;
        boolean z3;
        b0a b0aVar2;
        boolean z4;
        boolean z5;
        int i;
        boolean z6;
        boolean z7;
        int i2;
        boolean z8;
        int i3;
        t79 t79Var;
        boolean z9;
        List<wn> list;
        int i4;
        boolean z10;
        boolean z11;
        wn wnVar;
        int i5;
        boolean z12;
        m79 m79Var;
        b0a b0aVar3;
        b0a b0aVar4;
        b0a b0aVar5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048633, this, j49Var, z) != null) || j49Var == null) {
            return;
        }
        this.H = j49Var;
        q(j49Var);
        if (!UbsABTestHelper.isPbCommentFunAdABTest()) {
            L0();
        }
        if (this.I == null) {
            this.I = new ArrayList<>();
        }
        this.I.clear();
        j49 j49Var2 = this.H;
        if (j49Var2 != null && j49Var2.F() != null && this.H.F().size() > 0) {
            this.I.addAll(this.H.F());
        }
        if (j49Var.N() != null && j49Var.N().getAuthor() != null) {
            this.U = j49Var.N().getAuthor().getUserId();
        }
        if (this.c == null && !q89.D(this.a)) {
            return;
        }
        O(j49Var);
        ArrayList<wn> arrayList = new ArrayList<>(j49Var.F());
        b0a r = r(arrayList);
        if (this.H.N().isQuestionThread()) {
            b0aVar = s(j49Var);
        } else {
            b0aVar = null;
        }
        if (b0aVar != null) {
            arrayList.remove(b0aVar);
        }
        if (r != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!ht7.f() && UbsABTestHelper.isPbCommentFunAdABTest() && this.H.s0()) {
            M(arrayList, Boolean.valueOf(z2));
        }
        if (r != null) {
            this.V = r;
        }
        if (!this.N && r != null) {
            arrayList.remove(r);
            if (j49Var.w0() && r.e0() != null) {
                r.k1(null);
            }
            z2 = true;
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z2 && j49Var.i() != null) {
            b0a i6 = j49Var.i();
            if (!this.N && j49Var.w0() && i6.e0() != null) {
                i6.k1(null);
            }
            boolean z13 = this.N;
            if ((!z13 || (z13 && this.P)) && (b0aVar5 = this.V) != null && i6.j0 == null) {
                j49Var.F0(b0aVar5);
                b0aVar2 = b0aVar5;
            } else {
                b0aVar2 = i6;
            }
            z2 = true;
            z4 = true;
        } else {
            b0aVar2 = r;
            z4 = z3;
        }
        o(arrayList);
        if (this.a.B5()) {
            if (j49Var.F().size() > 0 && (b0aVar4 = j49Var.F().get(0)) != null && b0aVar4.I() == 1 && !ListUtils.isEmpty(arrayList)) {
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
        az9.f(arrayList, 1);
        int C = C(j49Var, arrayList);
        if (C >= 0) {
            Z(j49Var, arrayList, C);
            z5 = true;
        } else {
            z5 = false;
        }
        int H = H(j49Var, arrayList);
        if (H >= 0) {
            t49 t49Var = new t49(t49.c);
            t49Var.b(true);
            ListUtils.add(arrayList, H, t49Var);
        }
        int w = w(j49Var, arrayList);
        List<wn> x = x(j49Var);
        if (!ListUtils.isEmpty(x) && w >= 0) {
            wn wnVar2 = (wn) ListUtils.getItem(arrayList, w);
            if (wnVar2 instanceof b0a) {
                ((b0a) wnVar2).R = true;
            }
            ListUtils.addAll(arrayList, w, x);
            z5 = true;
        }
        if (z2) {
            i = G(j49Var, arrayList, this.N);
        } else {
            i = -1;
        }
        if (i >= 0 && j49Var.R() != null) {
            b0a W = j49Var.W();
            ThreadData c2 = j49Var.R().c();
            if (W != null && W.u0() != null && c2 != null && c2.getCustomFigure() == null) {
                VirtualImageCustomFigure u0 = W.u0();
                VirtualImageCustomState v0 = W.v0();
                c2.setCustomFigure(u0);
                c2.setCustomState(v0);
            }
            n0(W, c2);
            ListUtils.add(arrayList, i, j49Var.R());
            z6 = true;
            z7 = true;
        } else {
            if (b0aVar2 != null) {
                b0aVar2.Q = true;
            }
            z6 = z5;
            z7 = false;
        }
        if ((this.H.N().isQuestionThread() && b0aVar != null) || (this.H.N().isQuestionThread() && this.W != null)) {
            if (b0aVar == null && (b0aVar3 = this.W) != null) {
                b0aVar = b0aVar3;
            }
            if (!arrayList.contains(b0aVar)) {
                i++;
                c0(b0aVar, arrayList, i);
            }
        }
        if (X(j49Var, b0aVar2, arrayList, i) != null || W(j49Var, b0aVar2, arrayList, i) != null || V(j49Var, arrayList, i) != null) {
            i++;
        }
        if (S(j49Var, arrayList, i) != null) {
            i++;
        }
        if (z2 && j49Var.M() != null && j49Var.M().similar_thread != null && j49Var.M().similar_thread.id.longValue() > 0) {
            b0(j49Var, arrayList, i);
        } else {
            if (z2) {
                wn a0 = a0(arrayList, i);
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
                    wnVar = Q(arrayList, i5);
                    if (wnVar != null) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                } else {
                    z11 = z10;
                    wnVar = a0;
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
                    t79Var = null;
                } else {
                    t79 Y = Y(arrayList, wnVar, i, i5);
                    if (Y != null) {
                        if (!z11) {
                            t79Var = Y;
                            i2 = i;
                            z8 = true;
                        } else if (i5 > 0) {
                            i5++;
                        } else {
                            i++;
                        }
                    }
                    t79Var = Y;
                    z8 = z11;
                    i2 = i;
                }
                i3 = i5;
            } else {
                i2 = i;
                z8 = false;
                i3 = -1;
                t79Var = null;
            }
            if (z2) {
                if (t79Var != null) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                list = x;
                int i7 = i2;
                i4 = w;
                boolean R = R(j49Var, arrayList, z8, z9, i3, i7, w, C);
                if (t79Var != null) {
                    t79Var.n = R;
                }
                if (q89.D(this.a)) {
                    p49 p49Var = new p49();
                    if (j49Var.N().getTaskInfoData() != null) {
                        p49Var.f(j49Var.N().getTaskInfoData().r());
                        p49Var.e(j49Var.N().getTaskInfoData().q());
                    }
                    sp8.b(arrayList, p49Var, 0);
                    if (!z7 && j49Var.R() != null) {
                        b0a W2 = j49Var.W();
                        ThreadData c3 = j49Var.R().c();
                        if (W2 != null && W2.u0() != null && c3 != null && c3.getCustomFigure() == null) {
                            VirtualImageCustomFigure u02 = W2.u0();
                            VirtualImageCustomState v02 = W2.v0();
                            c3.setCustomFigure(u02);
                            c3.setCustomState(v02);
                        }
                        n0(W2, c3);
                        ListUtils.add(arrayList, 1, j49Var.R());
                        z6 = true;
                        z7 = true;
                        m79Var = this.c;
                        if (m79Var != null) {
                            m79Var.e0(!z6);
                        }
                        boolean K0 = K0(b0aVar2);
                        if (this.O && !K0) {
                            arrayList.remove(b0aVar2);
                            this.O = false;
                        }
                        if (j49Var.R() != null) {
                            j49Var.R().h(!z7);
                        }
                        if (this.b != null) {
                            this.J = arrayList;
                            List<wn> Q = j49Var.Q();
                            if (!ListUtils.isEmpty(Q)) {
                                this.b.setData(K(arrayList, Q));
                            } else {
                                this.b.setData(this.J);
                            }
                        }
                        k0(K0, z, i4, list);
                        if (t(b0aVar2, arrayList, z4)) {
                            List<wn> Q2 = j49Var.Q();
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
                m79Var = this.c;
                if (m79Var != null) {
                }
                boolean K02 = K0(b0aVar2);
                if (this.O) {
                    arrayList.remove(b0aVar2);
                    this.O = false;
                }
                if (j49Var.R() != null) {
                }
                if (this.b != null) {
                }
                k0(K02, z, i4, list);
                if (t(b0aVar2, arrayList, z4)) {
                }
            }
        }
        list = x;
        i4 = w;
        if (q89.D(this.a)) {
        }
        m79Var = this.c;
        if (m79Var != null) {
        }
        boolean K022 = K0(b0aVar2);
        if (this.O) {
        }
        if (j49Var.R() != null) {
        }
        if (this.b != null) {
        }
        k0(K022, z, i4, list);
        if (t(b0aVar2, arrayList, z4)) {
        }
    }

    public final boolean t(b0a b0aVar, ArrayList<wn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048642, this, b0aVar, arrayList, z)) == null) {
            if (b0aVar == null) {
                b0a b0aVar2 = this.V;
                if (b0aVar2 != null && !this.P) {
                    ListUtils.add(arrayList, 0, b0aVar2);
                } else {
                    b0a b0aVar3 = new b0a();
                    b0aVar3.S0(1);
                    ListUtils.add(arrayList, 0, b0aVar3);
                }
                return true;
            } else if (!z) {
                return false;
            } else {
                ListUtils.add(arrayList, 0, b0aVar);
                return true;
            }
        }
        return invokeLLZ.booleanValue;
    }
}
