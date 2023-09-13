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
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
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
/* loaded from: classes6.dex */
public class gm9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbReplyLoadMoreAdapter A;
    public ArrayList<il9> B;
    public hm9 C;
    public zm9 D;
    public lo9 E;
    public PbFirstFloorWebViewAdapter F;
    public jl9 G;
    public aj9 H;
    public ArrayList<tha> I;
    public ArrayList<cn> J;
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
    public int f1103T;
    public String U;
    public tha V;
    public tha W;
    public View.OnClickListener X;
    public View.OnClickListener Y;
    public View.OnClickListener Z;
    public PbFragment a;
    public TbRichTextView.z a0;
    public BdTypeListView b;
    public View.OnClickListener b0;
    public sm9 c;
    public vk9 c0;
    public tm9 d;
    public View.OnLongClickListener d0;
    public PbFirstFloorCommentAndPraiseAdapter e;
    public SortSwitchButton.f e0;
    public PbFirstFloorEnterForumAdapter f;
    public final List<pm> f0;
    public PbFirstFloorItemAdapter g;
    public final List<pm> g0;
    public PbFirstFloorRecommendAdapter h;
    public Runnable h0;
    public PbFirstFloorSimilarTitleAdapter i;
    public int i0;
    public mo9 j;
    public int j0;
    public jo9 k;
    public int k0;
    public pn9 l;
    public ThreadData l0;
    public dn9 m;
    public List<tha> m0;
    public pn9 n;
    public final CustomMessageListener n0;
    public jm9 o;
    public CustomMessageListener o0;
    public sn9 p;
    public final CustomMessageListener p0;
    public or9 q;
    public final View.OnClickListener q0;
    public kq6 r;
    public CustomMessageListener r0;
    public pm s;
    public List<pm> s0;
    public pm t;
    public pm u;
    public pm v;
    public pm w;
    public ln9 x;
    public nn9 y;
    public kn9 z;

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gm9 a;

        /* loaded from: classes6.dex */
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
        public c(gm9 gm9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gm9Var, Integer.valueOf(i)};
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
            this.a = gm9Var;
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.H != null && !m9.c(this.a.a.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    SafeHandler.getInst().postDelayed(new a(this), TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }
    }

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gm9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(gm9 gm9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gm9Var, Integer.valueOf(i)};
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
            this.a = gm9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof rha)) {
                rha rhaVar = (rha) customResponsedMessage.getData();
                if (this.a.l0 != null && this.a.l0.funAdData == rhaVar) {
                    this.a.l0.funAdData.p(true);
                    this.a.b.setData(this.a.J);
                    this.a.f0();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gm9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(gm9 gm9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gm9Var, Integer.valueOf(i)};
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
            this.a = gm9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof iha)) {
                AbsDelegateAdapterList a = ((iha) customResponsedMessage.getData()).a();
                Iterator<pm<?, ?>> it = a.iterator();
                while (it.hasNext()) {
                    pm<?, ?> next = it.next();
                    if (next instanceof lm9) {
                        ((lm9) next).t(this.a.a);
                        if (next instanceof il9) {
                            this.a.B.add((il9) next);
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

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gm9 a;

        public d(gm9 gm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gm9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a != null && this.a.H != null && this.a.H.T() != null) {
                this.a.a.H6().o1().u();
                TiebaStatic.log(new StatisticItem("c12040"));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ gm9 b;

        public e(gm9 gm9Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gm9Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gm9Var;
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

    /* loaded from: classes6.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gm9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(gm9 gm9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gm9Var, Integer.valueOf(i)};
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
            this.a = gm9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.s0)) {
                this.a.n();
                gm9 gm9Var = this.a;
                gm9Var.n0(gm9Var.H, false);
            }
        }
    }

    public gm9(PbFragment pbFragment, BdTypeListView bdTypeListView) {
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
        this.f1103T = 0;
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
        this.f1103T = BdUtilHelper.getEquipmentWidth(pbFragment.getPageContext().getPageActivity());
        this.a = pbFragment;
        this.b = bdTypeListView;
        N(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.p0);
        this.j0 = BdUtilHelper.getEquipmentHeight(this.a.getContext()) / 3;
    }

    public final cn Q(ArrayList<cn> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048605, this, arrayList, i)) == null) {
            if (this.H == null) {
                return null;
            }
            sha J0 = this.a.X().J0();
            if (J0 == null) {
                J0 = this.H.z();
            }
            if (J0 == null) {
                return null;
            }
            AdvertAppInfo.ILegoAdvert G1 = J0.G1();
            if (G1 != null) {
                G1.setAdvertAppInfo(J0.getAdvertAppInfo());
            }
            int h = J0.getAdvertAppInfo().h();
            if (h != 0) {
                x4a.j(J0, h);
                if (h != 28 && h != 31) {
                    J0.getAdvertAppInfo().c = -1001;
                }
                return null;
            }
            if (this.H.k() != null) {
                J0.i1 = this.H.k().getId();
            }
            if (this.H.O() != null) {
                J0.l1 = JavaTypesHelper.toLong(this.H.O().getId(), 0L);
            }
            aj9 aj9Var = this.H;
            if (aj9Var != null && aj9Var.y() != null) {
                J0.m1 = this.H.y().a();
            }
            l(J0);
            if (i < 0) {
                return null;
            }
            J0.p1 = 1;
            x56.k().q(true);
            i39.b(arrayList, J0, i);
            aj9 aj9Var2 = this.H;
            if (aj9Var2 != null) {
                aj9Var2.N0(J0);
            }
            if (q66.i().q()) {
                q66.i().n(arrayList, i + 1, 4);
            }
            return J0;
        }
        return (cn) invokeLI.objValue;
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

    public void B0(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, zVar) == null) {
            this.a0 = zVar;
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

    public void H0(vk9 vk9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, vk9Var) == null) {
            this.c0 = vk9Var;
        }
    }

    public void J0(@NonNull aj9 aj9Var) {
        sm9 sm9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, aj9Var) == null) && (sm9Var = this.c) != null) {
            sm9Var.h0(aj9Var);
        }
    }

    public final void P(PbFragment pbFragment) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048604, this, pbFragment) == null) && pbFragment != null && pbFragment.getPageContext() != null) {
            DefaultLog.getInstance().i("PbAdapterManager", "初始化PbFirstFloorWebViewAdapter");
            this.F = new PbFirstFloorWebViewAdapter(pbFragment, gj9.c);
        }
    }

    public void j0(boolean z) {
        sm9 sm9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048624, this, z) == null) && (sm9Var = this.c) != null) {
            sm9Var.T(z);
        }
    }

    public void p0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            this.L = z;
        }
    }

    public void q0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
            this.O = z;
        }
    }

    public void r0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048639, this, z) == null) {
            this.M = z;
        }
    }

    public final tha s(aj9 aj9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048640, this, aj9Var)) == null) {
            if (aj9Var != null && aj9Var.U() != null) {
                tha U = aj9Var.U();
                this.W = U;
                return U;
            }
            return null;
        }
        return (tha) invokeL.objValue;
    }

    public void s0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048641, this, z) == null) {
            this.S = z;
        }
    }

    public void t0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048643, this, z) == null) {
            this.P = z;
        }
    }

    public void u0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048645, this, z) == null) {
            this.Q = z;
        }
    }

    public void v0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048647, this, z) == null) {
            this.N = z;
        }
    }

    public void w0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048649, this, z) == null) {
            this.R = z;
        }
    }

    public void x0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, onClickListener) == null) {
            this.Z = onClickListener;
        }
    }

    public void y0(boolean z) {
        jm9 jm9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048653, this, z) == null) && (jm9Var = this.o) != null) {
            jm9Var.B0(z);
        }
    }

    public cn z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048654, this, i)) == null) {
            return this.b.G(i);
        }
        return (cn) invokeI.objValue;
    }

    public void z0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, onClickListener) == null) {
            this.X = onClickListener;
        }
    }

    public final void G0(aj9 aj9Var, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, aj9Var, threadData) == null) && aj9Var != null && aj9Var.K() != null && threadData != null) {
            threadData.setRobotEntrance(aj9Var.K());
        }
    }

    public final int I(ej9 ej9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, ej9Var, i)) == null) {
            if (ej9Var.Y()) {
                if (i == 25) {
                    return 4;
                }
                return 5;
            }
            if (ej9Var.Z()) {
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
            jm9 jm9Var = this.o;
            if (jm9Var != null) {
                jm9Var.C0(z);
            }
            pn9 pn9Var = this.l;
            if (pn9Var != null) {
                pn9Var.A(z);
            }
            pm pmVar = this.w;
            if (pmVar != null) {
                pmVar.setMulDel(z);
            }
            pm pmVar2 = this.t;
            if (pmVar2 != null) {
                pmVar2.setMulDel(z);
            }
            sm9 sm9Var = this.c;
            if (sm9Var != null) {
                sm9Var.setMulDel(z);
            }
        }
    }

    public final boolean K0(tha thaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, thaVar)) == null) {
            if (this.a.X() != null && thaVar != null && thaVar.U() != null && thaVar.U().equals(this.a.X().R1())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void o0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048633, this, z) == null) {
            this.K = z;
            sm9 sm9Var = this.c;
            if (sm9Var != null) {
                sm9Var.setFromCDN(z);
            }
            pm pmVar = this.t;
            if (pmVar != null && (pmVar instanceof d3a)) {
                ((d3a) pmVar).setIsFromCDN(z);
            }
            Iterator<il9> it = this.B.iterator();
            while (it.hasNext()) {
                it.next().setFromCDN(z);
            }
        }
    }

    public final tha r(ArrayList<cn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, arrayList)) == null) {
            Iterator<cn> it = arrayList.iterator();
            while (it.hasNext()) {
                cn next = it.next();
                if (next instanceof tha) {
                    tha thaVar = (tha) next;
                    if (thaVar.L() == 1) {
                        return thaVar;
                    }
                }
            }
            return null;
        }
        return (tha) invokeL.objValue;
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
        dn9 dn9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (dn9Var = this.m) != null) {
            dn9Var.z(2);
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
            if (this.b.getAdapter2() instanceof tm) {
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

    public ArrayList<cn> v() {
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

    public final int C(aj9 aj9Var, ArrayList<cn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, aj9Var, arrayList)) == null) {
            if (aj9Var == null || ListUtils.isEmpty(aj9Var.F()) || ListUtils.isEmpty(arrayList) || ((tha) ListUtils.getItem(aj9Var.F(), 0)) == null) {
                return 0;
            }
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    cn cnVar = arrayList.get(i);
                    if (cnVar instanceof tha) {
                        tha thaVar = (tha) cnVar;
                        if (thaVar.L() == 1 && thaVar.O == 0) {
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

    public final int H(aj9 aj9Var, ArrayList<cn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, aj9Var, arrayList)) == null) {
            int i = -1;
            if (aj9Var == null || aj9Var.y() == null) {
                return -1;
            }
            int i2 = 0;
            if (aj9Var.y().c() == 1) {
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
                } else if (arrayList.get(i2) instanceof pj9) {
                    i = i2 + 1;
                    break;
                } else {
                    i2++;
                }
            }
            if (aj9Var.J() == 4) {
                return i + 1;
            }
            return i;
        }
        return invokeLL.intValue;
    }

    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            BdTypeListView bdTypeListView = this.b;
            if (bdTypeListView != null && bdTypeListView.getData() != null) {
                for (int i = 0; i < this.b.getData().size(); i++) {
                    cn cnVar = this.b.getData().get(i);
                    if (cnVar != null && cnVar.getType() == pj9.g) {
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
            SafeHandler.getInst().removeCallbacks(this.h0);
            pn9 pn9Var = this.l;
            if (pn9Var != null) {
                pn9Var.onDestroy();
            }
            pn9 pn9Var2 = this.n;
            if (pn9Var2 != null) {
                pn9Var2.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.e;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
            jo9 jo9Var = this.k;
            if (jo9Var != null) {
                jo9Var.onDestroy();
            }
            x56.k().q(false);
        }
    }

    public int E(aj9 aj9Var, ArrayList<cn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, aj9Var, arrayList, z)) == null) {
            if (aj9Var == null || aj9Var.F() == null || aj9Var.C() == null || aj9Var.F().size() == 0 || aj9Var.O() == null || arrayList == null || !aj9Var.C().D1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (aj9Var.F().get(0) == null || aj9Var.F().get(0).L() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (aj9Var.y() == null || aj9Var.y().a() != aj9Var.y().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public int F(aj9 aj9Var, ArrayList<cn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048586, this, aj9Var, arrayList, z)) == null) {
            if (aj9Var == null || aj9Var.F() == null || aj9Var.D() == null || aj9Var.F().size() == 0 || aj9Var.O() == null || arrayList == null || !aj9Var.D().D1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (aj9Var.F().get(0) == null || aj9Var.F().get(0).L() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (aj9Var.y() == null || aj9Var.y().a() != aj9Var.y().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final cn V(aj9 aj9Var, ArrayList<cn> arrayList, int i) {
        InterceptResult invokeLLI;
        cj9 cj9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048610, this, aj9Var, arrayList, i)) == null) {
            if (aj9Var.k() != null && !StringUtils.isNull(aj9Var.k().getName()) && !aj9Var.m) {
                if (!TextUtils.equals(aj9Var.k().getName(), this.a.X().Q0()) || !this.a.X().W0()) {
                    if (!this.a.I0() && !ListUtils.isEmpty(aj9Var.o())) {
                        cj9Var = new cj9(aj9Var.o().get(0));
                    } else {
                        cj9Var = new cj9(aj9Var.k());
                    }
                    cj9Var.g = this.a.X().L1();
                    ListUtils.add(arrayList, i, cj9Var);
                    return cj9Var;
                }
                return null;
            }
            return null;
        }
        return (cn) invokeLLI.objValue;
    }

    public final int b0(aj9 aj9Var, ArrayList<cn> arrayList, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048616, this, aj9Var, arrayList, i)) == null) {
            ej9 ej9Var = new ej9(aj9Var.N());
            String tid = ej9Var.X().getTid();
            int q1 = this.a.X().q1();
            aj9Var.P0(I(ej9Var, q1));
            fj9 fj9Var = new fj9(ej9Var.V(), ej9Var.W());
            fj9Var.a = ej9Var.X();
            fj9Var.C = q1;
            fj9Var.g = tid;
            int i2 = i + 1;
            ListUtils.add(arrayList, i2, fj9Var);
            ej9Var.X().isLinkThread();
            ej9Var.X().isSmartAppThreadType();
            if (!ej9Var.X().isLinkThread() && !ej9Var.X().isSmartAppThreadType()) {
                ej9Var.X().isGodThread();
            }
            ej9Var.a = ej9Var.X();
            ej9Var.C = q1;
            ej9Var.g = tid;
            ej9Var.setSupportType(BaseCardInfo.SupportType.NONE);
            ListUtils.add(arrayList, i2 + 1, ej9Var);
            return i2;
        }
        return invokeLLI.intValue;
    }

    public final int G(aj9 aj9Var, ArrayList<cn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048588, this, aj9Var, arrayList, z)) == null) {
            if (aj9Var != null && !ListUtils.isEmpty(aj9Var.F()) && arrayList != null && arrayList.size() > 0) {
                if (!z) {
                    return 0;
                }
                if (aj9Var.F().get(0) != null && aj9Var.F().get(0).L() == 1) {
                    return 1;
                }
                if (aj9Var.i() == null) {
                    return -1;
                }
                return 0;
            } else if (aj9Var == null || !aj9Var.x0()) {
                return -1;
            } else {
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final void Z(aj9 aj9Var, ArrayList<cn> arrayList, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048614, this, aj9Var, arrayList, i) == null) {
            pj9 pj9Var = new pj9(pj9.g);
            ThreadData O = aj9Var.O();
            pj9Var.c = this.a.c7();
            pj9Var.b = aj9Var.g;
            pj9Var.d = aj9Var.j0();
            pj9Var.e = aj9Var.f;
            if (O != null && O.isQuestionThread()) {
                z = true;
            } else {
                z = false;
            }
            pj9Var.f = z;
            ListUtils.add(arrayList, i, pj9Var);
            if (aj9Var.J() == 4) {
                ListUtils.add(arrayList, i + 1, new oj9());
            }
        }
    }

    public final ArrayList<cn> K(List<cn> list, List<cn> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, list, list2)) == null) {
            ArrayList<cn> arrayList = new ArrayList<>(list.size() + list2.size() + 2);
            arrayList.addAll(list);
            ij9 ij9Var = new ij9();
            PbListView s1 = this.a.H6().s1();
            if (s1 != null && s1.q()) {
                ij9Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1006);
                ij9Var.b = true;
            } else {
                ij9Var.a = TbadkCoreApplication.getInst().getString(R.string.list_has_all_comments);
                ij9Var.b = false;
            }
            arrayList.add(ij9Var);
            nq6 nq6Var = new nq6();
            nq6Var.a = TbadkCoreApplication.getInst().getString(R.string.recommed_for_you);
            nq6Var.needTopMargin = false;
            arrayList.add(nq6Var);
            arrayList.addAll(list2);
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public final void M(ArrayList<cn> arrayList, Boolean bool) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048600, this, arrayList, bool) != null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        int i = kc5.i();
        int j = kc5.j() - 1;
        if (bool.booleanValue()) {
            boolean z2 = false;
            cn cnVar = arrayList.get(0);
            if ((cnVar instanceof tha) && ((tha) cnVar).L() == 1) {
                z = true;
            } else {
                z = false;
            }
            cn cnVar2 = arrayList.get(arrayList.size() - 1);
            if ((cnVar2 instanceof tha) && ((tha) cnVar2).L() == 1) {
                z2 = true;
            }
            if (z || z2) {
                j++;
            }
        }
        int k = kc5.k() + 1;
        PbFragment pbFragment = this.a;
        if (pbFragment != null && pbFragment.X() != null && this.a.X().C1() == 3) {
            this.m0.clear();
        }
        U(j, i, k, arrayList);
    }

    public final int w(aj9 aj9Var, ArrayList<cn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048648, this, aj9Var, arrayList)) == null) {
            if (!this.P && aj9Var != null && !ListUtils.isEmpty(aj9Var.F()) && arrayList != null && arrayList.size() > 0) {
                if (this.a.X() != null && this.a.X().a1()) {
                    return -1;
                }
                if (this.a.H6() != null && this.a.H6().k1()) {
                    return -1;
                }
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    if (i < size) {
                        cn cnVar = arrayList.get(i);
                        if (cnVar instanceof tha) {
                            tha thaVar = (tha) cnVar;
                            if (thaVar.L() == 1 && thaVar.O == 0) {
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
                    if (aj9Var.x0()) {
                        return 0;
                    }
                    return -1;
                }
                return i + 1;
            } else if (aj9Var != null && aj9Var.x0() && this.N) {
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
            sm9 sm9Var = this.c;
            if (sm9Var != null && sm9Var.P() != null) {
                if (this.c.P().z != null && this.c.P().z.isShown()) {
                    return this.c.P().z;
                }
                return this.c.P().y;
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048634, this) == null) && this.f0 != null) {
            DefaultLog.getInstance().i("PbAdapterManager", "动态修正Adapter");
            this.f0.remove(this.c);
            if (this.d == null) {
                this.d = new tm9(this.a, tha.W0);
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
        aj9 aj9Var;
        sha shaVar;
        sha shaVar2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || (aj9Var = this.H) == null || aj9Var.Z || aj9Var.a0 == 2) {
            return;
        }
        ArrayList<tha> F = aj9Var.F();
        ArrayList<sha> d2 = this.H.d();
        if (!i39.e(F) && !i39.e(d2)) {
            StringBuilder sb = new StringBuilder();
            Iterator<sha> it = d2.iterator();
            while (it.hasNext()) {
                sha next = it.next();
                if (next != null && next.E1() != null) {
                    sb.append(next.E1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<sha> it2 = d2.iterator();
            while (it2.hasNext()) {
                sha next2 = it2.next();
                if (next2 != null) {
                    next2.o1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<sha> it3 = d2.iterator();
            while (it3.hasNext()) {
                sha next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int h = next3.getAdvertAppInfo().h();
                    if (h != 0) {
                        x4a.j(next3, h);
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
                sha shaVar3 = (sha) sparseArray.valueAt(i);
                if (shaVar3 != null && (shaVar2 = (sha) hashMap.put(shaVar3.D1(), shaVar3)) != null) {
                    x4a.j(shaVar2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (shaVar = (sha) entry.getValue()) != null) {
                    sparseArray.put(shaVar.getPosition(), shaVar);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                i39.a(arrayList, Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList);
            int i3 = 1;
            for (int i4 = 0; i4 < i39.i(arrayList); i4++) {
                sha shaVar4 = (sha) sparseArray.get(((Integer) i39.d(arrayList, i4)).intValue());
                if (this.H.k() != null) {
                    shaVar4.i1 = this.H.k().getId();
                }
                if (this.H.O() != null) {
                    shaVar4.l1 = JavaTypesHelper.toLong(this.H.O().getId(), 0L);
                }
                aj9 aj9Var2 = this.H;
                if (aj9Var2 != null && aj9Var2.y() != null) {
                    shaVar4.m1 = this.H.y().a();
                }
                l(shaVar4);
                int position = shaVar4.getPosition() + this.H.Y;
                if (position >= i39.i(F)) {
                    shaVar4.o1 = position;
                    x4a.k(shaVar4, 2, position, i39.i(F));
                    return;
                }
                if (!this.N) {
                    position--;
                    shaVar4.o1 = position;
                }
                if (position < 0) {
                    x4a.j(shaVar4, 23);
                } else {
                    shaVar4.p1 = i3;
                    i39.b(F, shaVar4, position);
                    i3++;
                    PbFragment pbFragment = this.a;
                    if (pbFragment != null && pbFragment.getPageContext() != null && this.a.getPageContext().getContext() != null) {
                        TiebaStatic.eventStat(this.a.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", shaVar4.getAdvertAppInfo().q);
                    }
                }
            }
        }
    }

    public void N(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        tm9 tm9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, pbFragment, bdTypeListView) == null) {
            if (wn9.C(pbFragment)) {
                DefaultLog.getInstance().i("PbAdapterManager", "初始化PbFirstFloorEmptyAdapter");
                this.d = new tm9(pbFragment, tha.W0);
            } else {
                DefaultLog.getInstance().i("PbAdapterManager", "初始化PbFirstFloorAdapter");
                sm9 sm9Var = new sm9(pbFragment, tha.W0);
                this.c = sm9Var;
                sm9Var.f0(pbFragment);
            }
            this.e = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, qj9.f);
            this.f = new PbFirstFloorEnterForumAdapter(pbFragment, cj9.k);
            this.g = new PbFirstFloorItemAdapter(pbFragment.getContext(), dj9.c);
            this.h = new PbFirstFloorRecommendAdapter(pbFragment.getContext(), PbFirstFloorRecommendData.d);
            this.i = new PbFirstFloorSimilarTitleAdapter(pbFragment.getPageContext(), fj9.f1094T);
            this.j = new mo9(pbFragment.getPageContext(), ej9.X0);
            this.k = new jo9(pbFragment, xi9.c);
            this.l = new pn9(pbFragment, pj9.g);
            this.m = new dn9(pbFragment, kj9.c);
            this.n = new pn9(pbFragment, pj9.h);
            jm9 jm9Var = new jm9(pbFragment, tha.X0);
            this.o = jm9Var;
            jm9Var.F0(pbFragment);
            sn9 sn9Var = new sn9(pbFragment, tha.Y0);
            this.p = sn9Var;
            sn9Var.F0(pbFragment);
            this.s = i3a.m().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.y);
            this.t = i3a.m().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.A);
            this.u = jy7.h().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.G);
            this.v = jy7.h().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.H);
            this.w = jy7.h().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.J);
            this.z = new kn9(pbFragment, mj9.k1);
            this.x = new ln9(pbFragment, jn9.j1);
            this.y = new nn9(pbFragment, i35.p1);
            this.A = new PbReplyLoadMoreAdapter(pbFragment, tha.e1);
            this.q = new or9(pbFragment, pr9.a);
            this.r = new kq6(pbFragment.getPageContext());
            this.C = new hm9(pbFragment, s15.e);
            this.D = new zm9(pbFragment, pbFragment.getUniqueId());
            this.E = new lo9(pbFragment.getPageContext(), v66.g);
            if (wn9.C(pbFragment)) {
                P(pbFragment);
            }
            jl9 jl9Var = new jl9(pbFragment, pbFragment.getUniqueId(), this.b);
            this.G = jl9Var;
            this.f0.addAll(jl9Var.a());
            if (wn9.C(pbFragment) && (tm9Var = this.d) != null) {
                this.f0.add(tm9Var);
            } else {
                sm9 sm9Var2 = this.c;
                if (sm9Var2 != null) {
                    this.f0.add(sm9Var2);
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
            if (wn9.C(pbFragment)) {
                this.f0.add(this.F);
            }
            this.o0.setPriority(1);
            this.o0.setSelfListener(true);
            pbFragment.registerListener(this.o0);
            pbFragment.registerListener(this.n0);
            m();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new iha(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
            CustomMessage customMessage = new CustomMessage(2004015);
            customMessage.setTag(pbFragment.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            bdTypeListView.addAdapters(this.f0);
        }
    }

    public final void O(@NonNull aj9 aj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, aj9Var) == null) {
            sm9 sm9Var = this.c;
            if (sm9Var != null) {
                sm9Var.r(aj9Var);
                this.c.setFromCDN(this.K);
                this.c.l(this.f1103T);
                this.c.c(this.M);
                this.c.e(this.Y);
                this.c.k(this.X);
                this.c.n(this.a0);
                this.c.d(this.d0);
                this.c.c0(this.b0);
                this.c.e0(this.c0);
            }
            this.g.y(this.b0);
            this.o.r(aj9Var);
            this.o.setFromCDN(this.K);
            this.o.o(this.U);
            this.o.c(this.M);
            this.o.e(this.Y);
            this.o.k(this.X);
            this.o.n(this.a0);
            this.o.d(this.d0);
            this.o.E0(this.c0);
            this.p.r(aj9Var);
            this.p.setFromCDN(this.K);
            this.p.o(this.U);
            this.p.c(this.M);
            this.p.e(this.Y);
            this.p.k(this.X);
            this.p.n(this.a0);
            this.p.d(this.d0);
            this.p.E0(this.c0);
            this.e.X(this.Y);
            this.A.y(this.Y);
            this.q.y(this.q0);
            pm pmVar = this.t;
            if (pmVar != null && (pmVar instanceof d3a)) {
                ((d3a) pmVar).setIsFromCDN(this.K);
            }
            Iterator<il9> it = this.B.iterator();
            while (it.hasNext()) {
                il9 next = it.next();
                if (next != null) {
                    next.r(aj9Var);
                    next.setFromCDN(this.K);
                    next.o(this.U);
                    next.l(this.f1103T);
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
            this.l.r(aj9Var);
            this.k.r(aj9Var);
            this.n.r(aj9Var);
            this.x.r(aj9Var);
            this.y.r(aj9Var);
            this.C.A(aj9Var);
            this.C.z(this.a.u1);
            this.D.y(aj9Var);
        }
    }

    public final boolean R(aj9 aj9Var, ArrayList<cn> arrayList, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{aj9Var, arrayList, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            ArrayList arrayList2 = new ArrayList();
            if (!ListUtils.isEmpty(aj9Var.e()) && aj9Var.e().size() > 2) {
                int min = Math.min(aj9Var.e().size(), 7);
                for (int i6 = 0; i6 < min; i6++) {
                    s15 s15Var = aj9Var.e().get(i6);
                    if (!z2 && i6 == 0) {
                        s15Var.h(true);
                    }
                    if (s15Var.getThreadVideoInfo() == null) {
                        if (i6 == min - 1) {
                            s15Var.l(true);
                        }
                    } else if (i6 == min - 2) {
                        s15Var.l(true);
                    } else if (i6 == min - 1) {
                        s15Var.i(true);
                    }
                    arrayList2.add(s15Var);
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
                        ListUtils.add(arrayList, i5, (cn) arrayList2.get(size));
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final cn S(aj9 aj9Var, ArrayList<cn> arrayList, int i) {
        InterceptResult invokeLLI;
        xi9 xi9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048607, this, aj9Var, arrayList, i)) == null) {
            if (i >= 0 && aj9Var != null && aj9Var.k && (xi9Var = aj9Var.l) != null) {
                ListUtils.add(arrayList, i, xi9Var);
                return xi9Var;
            }
            return null;
        }
        return (cn) invokeLLI.objValue;
    }

    public final void c0(tha thaVar, ArrayList<cn> arrayList, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048617, this, thaVar, arrayList, i) == null) {
            thaVar.u1(true);
            arrayList.add(i, thaVar);
        }
    }

    public final cn T(ArrayList<cn> arrayList, int i) {
        InterceptResult invokeLI;
        aj9 aj9Var;
        rha rhaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048608, this, arrayList, i)) == null) {
            if (wn9.C(this.a)) {
                return null;
            }
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && i > 0 && (aj9Var = this.H) != null && aj9Var.t0()) {
                String d2 = oy7.e().d("pb_banner");
                if (this.l0 == null && iy7.m().v(d2)) {
                    ThreadData threadData = new ThreadData();
                    this.l0 = threadData;
                    threadData.funAdData = new rha();
                    aj9 aj9Var2 = this.H;
                    if (aj9Var2 != null) {
                        this.l0.funAdData.m(aj9Var2.l());
                        this.l0.funAdData.r(this.H.Q());
                    }
                }
                ThreadData threadData2 = this.l0;
                if (threadData2 != null && (rhaVar = threadData2.funAdData) != null) {
                    rhaVar.j(1);
                    x56.k().q(true);
                    ListUtils.add(arrayList, i, this.l0);
                    if (q66.i().q()) {
                        q66.i().n(arrayList, i + 1, 4);
                    }
                }
            }
            return this.l0;
        }
        return (cn) invokeLI.objValue;
    }

    public final void U(int i, int i2, int i3, ArrayList<cn> arrayList) {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), arrayList}) == null) && !ListUtils.isEmpty(arrayList) && i >= 0 && i2 >= 1) {
            ListIterator<cn> listIterator = arrayList.listIterator();
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
                        tha thaVar = new tha();
                        rha rhaVar = new rha();
                        aj9 aj9Var = this.H;
                        if (aj9Var == null) {
                            str3 = "";
                        } else {
                            str3 = aj9Var.l();
                        }
                        rhaVar.m(str3);
                        aj9 aj9Var2 = this.H;
                        if (aj9Var2 != null) {
                            str = aj9Var2.Q();
                        }
                        rhaVar.r(str);
                        rhaVar.n(true);
                        thaVar.y0 = rhaVar;
                        rhaVar.j(i7);
                        listIterator.add(thaVar);
                        i7++;
                        this.m0.add(thaVar);
                    }
                    i5++;
                    if (i6 == 0) {
                        i6 = i4 + 1;
                    }
                }
                listIterator.next();
                i4++;
            }
            if (i6 > 0 && q66.i().q()) {
                q66.i().n(arrayList, i6, 5);
            }
            if (i4 == i && i5 < i3) {
                tha thaVar2 = new tha();
                rha rhaVar2 = new rha();
                aj9 aj9Var3 = this.H;
                if (aj9Var3 == null) {
                    str2 = "";
                } else {
                    str2 = aj9Var3.l();
                }
                rhaVar2.m(str2);
                aj9 aj9Var4 = this.H;
                if (aj9Var4 != null) {
                    str = aj9Var4.Q();
                }
                rhaVar2.r(str);
                rhaVar2.n(true);
                thaVar2.y0 = rhaVar2;
                rhaVar2.j(1);
                listIterator.add(thaVar2);
                this.m0.add(thaVar2);
                if (q66.i().q()) {
                    q66.i().n(arrayList, -1, 4);
                }
            }
        }
    }

    public final cn W(aj9 aj9Var, tha thaVar, ArrayList<cn> arrayList, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048611, this, aj9Var, thaVar, arrayList, i)) == null) {
            dj9 dj9Var = null;
            if (aj9Var.k() != null && !StringUtils.isNull(aj9Var.k().getName()) && TextUtils.equals(aj9Var.k().getName(), this.a.X().Q0()) && this.a.X().W0()) {
                return null;
            }
            if (thaVar != null) {
                if (thaVar.t0 != null) {
                    dj9Var = new dj9(thaVar.t0);
                }
            } else {
                tha thaVar2 = this.V;
                if (thaVar2 != null && thaVar2.t0 != null) {
                    dj9Var = new dj9(this.V.t0);
                }
            }
            if (dj9Var != null) {
                dj9Var.b = this.a.X().L1();
                ListUtils.add(arrayList, i + 1, dj9Var);
            }
            return dj9Var;
        }
        return (cn) invokeLLLI.objValue;
    }

    public final cn X(aj9 aj9Var, tha thaVar, ArrayList<cn> arrayList, int i) {
        InterceptResult invokeLLLI;
        PbFirstFloorRecommendData pbFirstFloorRecommendData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048612, this, aj9Var, thaVar, arrayList, i)) == null) {
            if (thaVar != null && thaVar.c0() != null) {
                pbFirstFloorRecommendData = new PbFirstFloorRecommendData(thaVar.c0());
            } else {
                tha thaVar2 = this.V;
                if (thaVar2 != null && thaVar2.c0() != null) {
                    pbFirstFloorRecommendData = new PbFirstFloorRecommendData(this.V.c0());
                } else {
                    pbFirstFloorRecommendData = null;
                }
            }
            if (pbFirstFloorRecommendData != null) {
                if (aj9Var != null && !TextUtils.isEmpty(aj9Var.Q())) {
                    pbFirstFloorRecommendData.f(aj9Var.Q());
                }
                ListUtils.add(arrayList, i + 1, pbFirstFloorRecommendData);
            }
            return pbFirstFloorRecommendData;
        }
        return (cn) invokeLLLI.objValue;
    }

    public final void k0(boolean z, boolean z2, int i, List<cn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), list}) == null) && !z && !z2) {
            if ((this.Q || this.P) && i != -1 && !ListUtils.isEmpty(list) && !this.R) {
                this.h0 = new e(this, list);
                SafeHandler.getInst().post(this.h0);
            }
        }
    }

    public final an9 Y(ArrayList<cn> arrayList, cn cnVar, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048613, this, arrayList, cnVar, i, i2)) == null) {
            an9 B = this.H.B();
            if (B != null) {
                if (cnVar != null) {
                    if (i2 < 0 && cnVar.getType() != AdvertAppInfo.A) {
                        i2 = i + 2;
                    } else if (cnVar.getType() != AdvertAppInfo.A) {
                        i2++;
                    } else {
                        i2 = -1;
                    }
                }
                if (i2 > 0 && (B instanceof an9)) {
                    ListUtils.add(arrayList, i2, B);
                    return B;
                }
                return null;
            }
            return null;
        }
        return (an9) invokeLLII.objValue;
    }

    public final cn a0(ArrayList<cn> arrayList, int i) {
        InterceptResult invokeLI;
        PbModel X;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048615, this, arrayList, i)) == null) {
            if (i < 0 || (X = this.a.X()) == null || TextUtils.isEmpty(X.v1())) {
                return null;
            }
            sha shaVar = new sha();
            l(shaVar);
            ListUtils.add(arrayList, i + 1, shaVar);
            return shaVar;
        }
        return (cn) invokeLI.objValue;
    }

    public void h0(boolean z, int i) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && (pbFragment = this.a) != null && pbFragment.H6() != null) {
            this.a.H6().w2(z, i);
        }
    }

    public void g0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        sm9 sm9Var = this.c;
                        if (sm9Var != null) {
                            sm9Var.W();
                        }
                        PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter = this.F;
                        if (pbFirstFloorWebViewAdapter != null) {
                            pbFirstFloorWebViewAdapter.onDestroy();
                        }
                        pm pmVar = this.t;
                        if (pmVar instanceof y2a) {
                            ((y2a) pmVar).onDestroy();
                        }
                        pm pmVar2 = this.u;
                        if (pmVar2 instanceof y2a) {
                            ((y2a) pmVar2).onDestroy();
                        }
                        pm pmVar3 = this.w;
                        if (pmVar3 instanceof y2a) {
                            ((y2a) pmVar3).onDestroy();
                        }
                        km9.a().d();
                        return;
                    }
                    return;
                }
                sm9 sm9Var2 = this.c;
                if (sm9Var2 != null) {
                    sm9Var2.X();
                }
                PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter2 = this.F;
                if (pbFirstFloorWebViewAdapter2 != null) {
                    pbFirstFloorWebViewAdapter2.onResume();
                }
                pm pmVar4 = this.t;
                if (pmVar4 instanceof y2a) {
                    ((y2a) pmVar4).onResume();
                }
                pm pmVar5 = this.u;
                if (pmVar5 instanceof y2a) {
                    ((y2a) pmVar5).onResume();
                }
                pm pmVar6 = this.w;
                if (pmVar6 instanceof y2a) {
                    ((y2a) pmVar6).onResume();
                }
                m0(false);
                l0();
                return;
            }
            sm9 sm9Var3 = this.c;
            if (sm9Var3 != null) {
                sm9Var3.U();
            }
            PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter3 = this.F;
            if (pbFirstFloorWebViewAdapter3 != null) {
                pbFirstFloorWebViewAdapter3.onPause();
            }
            pm pmVar7 = this.t;
            if (pmVar7 instanceof y2a) {
                ((y2a) pmVar7).onPause();
            }
            pm pmVar8 = this.u;
            if (pmVar8 instanceof y2a) {
                ((y2a) pmVar8).onPause();
            }
            pm pmVar9 = this.w;
            if (pmVar9 instanceof y2a) {
                ((y2a) pmVar9).onPause();
            }
            km9.a().i(this.a.e0());
            gs5.a().d();
        }
    }

    public final void l(sha shaVar) {
        ForumData k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048626, this, shaVar) == null) && shaVar != null && this.H != null && shaVar.getAdvertAppInfo() != null) {
            shaVar.getAdvertAppInfo().i = new g15();
            if (this.H.y() != null) {
                shaVar.getAdvertAppInfo().i.b = this.H.y().a();
            }
            shaVar.getAdvertAppInfo().i.a = shaVar.F1();
            if (this.H.k() != null && (k = this.H.k()) != null) {
                shaVar.getAdvertAppInfo().i.c = k.getId();
                shaVar.getAdvertAppInfo().i.d = k.getFirst_class();
                shaVar.getAdvertAppInfo().i.e = k.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                shaVar.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            shaVar.getAdvertAppInfo().i.g = shaVar.getAdvertAppInfo().g;
            shaVar.getAdvertAppInfo().i.h = false;
        }
    }

    public final List<cn> x(aj9 aj9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048650, this, aj9Var)) == null) {
            if (aj9Var == null || aj9Var.T() == null || ListUtils.isEmpty(aj9Var.T().a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<tha> list = aj9Var.T().a;
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            int min = Math.min(2, list.size());
            for (int i = 0; i < min; i++) {
                tha thaVar = list.get(i);
                if (thaVar != null) {
                    thaVar.e0 = true;
                    thaVar.P = true;
                    arrayList.add(thaVar);
                }
            }
            if (ListUtils.getCount(aj9Var.T().b) > 2) {
                cn cnVar = (cn) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (cnVar instanceof tha) {
                    ((tha) cnVar).P = false;
                }
                arrayList.add(new pr9());
            } else {
                cn cnVar2 = (cn) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (cnVar2 instanceof tha) {
                    ((tha) cnVar2).P = true;
                }
            }
            arrayList.add(0, new pj9(pj9.h));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void l0() {
        tha thaVar;
        sm9 sm9Var;
        int i;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048627, this) == null) && this.H != null && (thaVar = this.V) != null && thaVar.b0() != null && (sm9Var = this.c) != null && sm9Var.P() != null) {
            String Q = this.H.Q();
            String l = this.H.l();
            if (this.H.O() != null) {
                i = this.H.O().getThreadType();
            } else {
                i = 0;
            }
            PbFragment pbFragment = this.a;
            if (pbFragment == null || pbFragment.X() == null) {
                str = "";
            } else {
                str = this.a.X().K0();
            }
            PbFragment pbFragment2 = this.a;
            if (pbFragment2 == null || pbFragment2.X() == null) {
                str2 = "";
            } else {
                str2 = this.a.X().w1();
            }
            gs5.a().c(Q, l, this.V.b0(), this.c.P().s, i, str, str2);
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
            ArrayList<BdUniqueId> g = tga.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                a39 b2 = e49.d().b(this.a.getPageContext(), g.get(i), 2);
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

    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048629, this, z) == null) && this.a.H6() != null && this.a.e0() != null && this.a.e0().J1() != null) {
            km9.a().f(this.a.e0().J1().f2(), this.l.x(), this.a.H6().u1(), this.a.e0().getPageStayDurationItem(), z, this.G.b(), this.a.getListView());
        }
    }

    public final void o(List<cn> list) {
        int size;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048632, this, list) == null) && list != null && (size = list.size()) > 0) {
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (list.get(i2) instanceof tha) {
                    if (i == 0 && (list.get(i2) instanceof sha)) {
                        i = i2 + 1;
                    }
                    tha thaVar = (tha) list.get(i2);
                    if (!TextUtils.isEmpty(thaVar.Z())) {
                        u25 u25Var = new u25();
                        u25Var.e(thaVar.Z());
                        list.set(i2, u25Var);
                    }
                }
            }
            if (i > 0 && q66.i().q()) {
                q66.i().n(list, i, 5);
            }
        }
    }

    public void q(aj9 aj9Var) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048636, this, aj9Var) == null) && aj9Var.O() != null && aj9Var.O().getTaskInfoData() != null && ThreadCardUtils.isHeadlinesCard(aj9Var.O().getTaskInfoData())) {
            DefaultLog.getInstance().i("PbAdapterManager", "动态修正头条卡信息");
            if (this.F == null && this.b != null) {
                wn9.G(this.a, aj9Var.O().getTaskInfoData().j());
                p();
                this.b.F();
                this.b.addAdapters(this.f0);
            }
            PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter = this.F;
            if (pbFirstFloorWebViewAdapter != null && pbFirstFloorWebViewAdapter.u() != 1 && (pbFragment = this.a) != null && pbFragment.H6() != null) {
                this.a.H6().E4();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:219:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x03ad A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:245:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:262:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void n0(aj9 aj9Var, boolean z) {
        tha thaVar;
        boolean z2;
        boolean z3;
        tha thaVar2;
        boolean z4;
        boolean z5;
        int i;
        boolean z6;
        boolean z7;
        int i2;
        boolean z8;
        int i3;
        an9 an9Var;
        boolean z9;
        List<cn> list;
        int i4;
        boolean z10;
        boolean z11;
        cn cnVar;
        int i5;
        boolean z12;
        sm9 sm9Var;
        tha thaVar3;
        tha thaVar4;
        tha thaVar5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048631, this, aj9Var, z) != null) || aj9Var == null) {
            return;
        }
        this.H = aj9Var;
        q(aj9Var);
        if (!UbsABTestHelper.isPbCommentFunAdABTest()) {
            L0();
        }
        if (this.I == null) {
            this.I = new ArrayList<>();
        }
        this.I.clear();
        aj9 aj9Var2 = this.H;
        if (aj9Var2 != null && aj9Var2.F() != null && this.H.F().size() > 0) {
            this.I.addAll(this.H.F());
        }
        if (aj9Var.O() != null && aj9Var.O().getAuthor() != null) {
            this.U = aj9Var.O().getAuthor().getUserId();
        }
        if (this.c == null && !wn9.C(this.a)) {
            return;
        }
        O(aj9Var);
        ArrayList<cn> arrayList = new ArrayList<>(aj9Var.F());
        tha r = r(arrayList);
        if (this.H.O().isQuestionThread()) {
            thaVar = s(aj9Var);
        } else {
            thaVar = null;
        }
        if (thaVar != null) {
            arrayList.remove(thaVar);
        }
        if (r != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!py7.f() && UbsABTestHelper.isPbCommentFunAdABTest() && this.H.t0()) {
            M(arrayList, Boolean.valueOf(z2));
        }
        if (r != null) {
            this.V = r;
        }
        if (!this.N && r != null) {
            arrayList.remove(r);
            if (aj9Var.x0() && r.f0() != null) {
                r.o1(null);
            }
            z2 = true;
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z2 && aj9Var.i() != null) {
            tha i6 = aj9Var.i();
            if (!this.N && aj9Var.x0() && i6.f0() != null) {
                i6.o1(null);
            }
            boolean z13 = this.N;
            if ((!z13 || (z13 && this.P)) && (thaVar5 = this.V) != null && i6.r0 == null) {
                aj9Var.H0(thaVar5);
                thaVar2 = thaVar5;
            } else {
                thaVar2 = i6;
            }
            z2 = true;
            z4 = true;
        } else {
            thaVar2 = r;
            z4 = z3;
        }
        o(arrayList);
        if (this.a.x6()) {
            if (aj9Var.F().size() > 0 && (thaVar4 = aj9Var.F().get(0)) != null && thaVar4.L() == 1 && !ListUtils.isEmpty(arrayList)) {
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
        tga.f(arrayList, 1);
        int C = C(aj9Var, arrayList);
        if (C >= 0) {
            Z(aj9Var, arrayList, C);
            z5 = true;
        } else {
            z5 = false;
        }
        int H = H(aj9Var, arrayList);
        if (H >= 0) {
            kj9 kj9Var = new kj9(kj9.c);
            kj9Var.b(true);
            ListUtils.add(arrayList, H, kj9Var);
        }
        int w = w(aj9Var, arrayList);
        List<cn> x = x(aj9Var);
        if (!ListUtils.isEmpty(x) && w >= 0) {
            cn cnVar2 = (cn) ListUtils.getItem(arrayList, w);
            if (cnVar2 instanceof tha) {
                ((tha) cnVar2).R = true;
            }
            ListUtils.addAll(arrayList, w, x);
            z5 = true;
        }
        if (z2) {
            i = G(aj9Var, arrayList, this.N);
        } else {
            i = -1;
        }
        if (i >= 0 && aj9Var.S() != null) {
            tha X = aj9Var.X();
            ThreadData c2 = aj9Var.S().c();
            if (X != null && X.v0() != null && c2 != null && c2.getCustomFigure() == null) {
                VirtualImageCustomFigure v0 = X.v0();
                VirtualImageCustomState w0 = X.w0();
                c2.setCustomFigure(v0);
                c2.setCustomState(w0);
            }
            G0(this.H, c2);
            ListUtils.add(arrayList, i, aj9Var.S());
            z6 = true;
            z7 = true;
        } else {
            if (thaVar2 != null) {
                thaVar2.Q = true;
            }
            z6 = z5;
            z7 = false;
        }
        if ((this.H.O().isQuestionThread() && thaVar != null) || (this.H.O().isQuestionThread() && this.W != null)) {
            if (thaVar == null && (thaVar3 = this.W) != null) {
                thaVar = thaVar3;
            }
            if (!arrayList.contains(thaVar)) {
                i++;
                c0(thaVar, arrayList, i);
            }
        }
        if (X(aj9Var, thaVar2, arrayList, i) != null || W(aj9Var, thaVar2, arrayList, i) != null || V(aj9Var, arrayList, i) != null) {
            i++;
        }
        if (S(aj9Var, arrayList, i) != null) {
            i++;
        }
        if (z2 && aj9Var.N() != null && aj9Var.N().similar_thread != null && aj9Var.N().similar_thread.id.longValue() > 0) {
            b0(aj9Var, arrayList, i);
        } else {
            if (z2) {
                cn a0 = a0(arrayList, i);
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
                    cnVar = Q(arrayList, i5);
                    if (cnVar != null) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                } else {
                    z11 = z10;
                    cnVar = a0;
                    i5 = -1;
                }
                if (TbadkCoreApplication.getCurrentAccountInfo() != null && TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() == 1) {
                    z12 = false;
                } else {
                    z12 = true;
                }
                if (z12 && this.H.t0()) {
                    this.k0 = i5;
                    if (T(arrayList, i5) != null) {
                        this.k0 = -1;
                        i++;
                    }
                }
                if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && z12) {
                    z8 = z11;
                    i2 = i;
                    an9Var = null;
                } else {
                    an9 Y = Y(arrayList, cnVar, i, i5);
                    if (Y != null) {
                        if (!z11) {
                            an9Var = Y;
                            i2 = i;
                            z8 = true;
                        } else if (i5 > 0) {
                            i5++;
                        } else {
                            i++;
                        }
                    }
                    an9Var = Y;
                    z8 = z11;
                    i2 = i;
                }
                i3 = i5;
            } else {
                i2 = i;
                z8 = false;
                i3 = -1;
                an9Var = null;
            }
            if (z2) {
                if (an9Var != null) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                list = x;
                int i7 = i2;
                i4 = w;
                boolean R = R(aj9Var, arrayList, z8, z9, i3, i7, w, C);
                if (an9Var != null) {
                    an9Var.n = R;
                }
                if (wn9.C(this.a)) {
                    gj9 gj9Var = new gj9();
                    if (aj9Var.O().getTaskInfoData() != null) {
                        gj9Var.f(aj9Var.O().getTaskInfoData().r());
                        gj9Var.e(aj9Var.O().getTaskInfoData().q());
                    }
                    i39.b(arrayList, gj9Var, 0);
                    if (!z7 && aj9Var.S() != null) {
                        tha X2 = aj9Var.X();
                        ThreadData c3 = aj9Var.S().c();
                        if (X2 != null && X2.v0() != null && c3 != null && c3.getCustomFigure() == null) {
                            VirtualImageCustomFigure v02 = X2.v0();
                            VirtualImageCustomState w02 = X2.w0();
                            c3.setCustomFigure(v02);
                            c3.setCustomState(w02);
                        }
                        G0(this.H, c3);
                        ListUtils.add(arrayList, 1, aj9Var.S());
                        z6 = true;
                        z7 = true;
                        sm9Var = this.c;
                        if (sm9Var != null) {
                            sm9Var.d0(!z6);
                        }
                        boolean K0 = K0(thaVar2);
                        if (this.O && !K0) {
                            arrayList.remove(thaVar2);
                            this.O = false;
                        }
                        if (aj9Var.S() != null) {
                            aj9Var.S().g(!z7);
                        }
                        if (this.b != null) {
                            this.J = arrayList;
                            List<cn> R2 = aj9Var.R();
                            if (!ListUtils.isEmpty(R2)) {
                                this.b.setData(K(arrayList, R2));
                            } else {
                                this.b.setData(this.J);
                            }
                        }
                        k0(K0, z, i4, list);
                        if (t(thaVar2, arrayList, z4)) {
                            List<cn> R3 = aj9Var.R();
                            if (!ListUtils.isEmpty(R3)) {
                                this.b.setData(K(arrayList, R3));
                                return;
                            } else {
                                this.b.setData(arrayList);
                                return;
                            }
                        }
                        return;
                    }
                }
                sm9Var = this.c;
                if (sm9Var != null) {
                }
                boolean K02 = K0(thaVar2);
                if (this.O) {
                    arrayList.remove(thaVar2);
                    this.O = false;
                }
                if (aj9Var.S() != null) {
                }
                if (this.b != null) {
                }
                k0(K02, z, i4, list);
                if (t(thaVar2, arrayList, z4)) {
                }
            }
        }
        list = x;
        i4 = w;
        if (wn9.C(this.a)) {
        }
        sm9Var = this.c;
        if (sm9Var != null) {
        }
        boolean K022 = K0(thaVar2);
        if (this.O) {
        }
        if (aj9Var.S() != null) {
        }
        if (this.b != null) {
        }
        k0(K022, z, i4, list);
        if (t(thaVar2, arrayList, z4)) {
        }
    }

    public final boolean t(tha thaVar, ArrayList<cn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048642, this, thaVar, arrayList, z)) == null) {
            if (thaVar == null) {
                tha thaVar2 = this.V;
                if (thaVar2 != null && !this.P) {
                    ListUtils.add(arrayList, 0, thaVar2);
                } else {
                    tha thaVar3 = new tha();
                    thaVar3.W0(1);
                    ListUtils.add(arrayList, 0, thaVar3);
                }
                return true;
            } else if (!z) {
                return false;
            } else {
                ListUtils.add(arrayList, 0, thaVar);
                return true;
            }
        }
        return invokeLLZ.booleanValue;
    }
}
