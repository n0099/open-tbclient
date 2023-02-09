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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.data.VirtualImageCustomFigure;
import com.baidu.tbadk.data.VirtualImageCustomState;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.pb.pb.adapter.PbReplyLoadMoreAdapter;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.PbPrivateTitleAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorEnterForumAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorItemAdapter;
import com.baidu.tieba.tbadkCore.data.PostData;
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
public class gc8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public je8 A;
    public lb8 B;
    public v98 C;
    public ArrayList<PostData> D;
    public ArrayList<Cdo> E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public int O;
    public String P;
    public PostData Q;
    public PostData R;
    public View.OnClickListener S;
    public View.OnClickListener T;
    public View.OnClickListener U;
    public TbRichTextView.a0 V;
    public View.OnClickListener W;
    public xa8 X;
    public View.OnLongClickListener Y;
    public SortSwitchButton.f Z;
    public PbFragment a;
    public final List<qn> a0;
    public BdTypeListView b;
    public final List<qn> b0;
    public qc8 c;
    public Runnable c0;
    public PbFirstFloorCommentAndPraiseAdapter d;
    public int d0;
    public PbFirstFloorEnterForumAdapter e;
    public int e0;
    public PbFirstFloorItemAdapter f;
    public int f0;
    public he8 g;
    public ThreadData g0;
    public pd8 h;
    public List<PostData> h0;
    public dd8 i;
    public final CustomMessageListener i0;
    public pd8 j;
    public CustomMessageListener j0;
    public kc8 k;
    public final CustomMessageListener k0;
    public td8 l;
    public final View.OnClickListener l0;
    public yg8 m;
    public CustomMessageListener m0;
    public he6 n;
    public List<qn> n0;
    public qn o;
    public qn p;
    public qn q;
    public qn r;
    public qn s;
    public ld8 t;
    public nd8 u;
    public kd8 v;
    public PbReplyLoadMoreAdapter w;
    public ArrayList<kb8> x;
    public hc8 y;
    public xc8 z;

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gc8 a;

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
                    this.a.a.Z();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(gc8 gc8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc8Var, Integer.valueOf(i)};
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
            this.a = gc8Var;
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.C != null && !da.c(this.a.a.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    gh.a().postDelayed(new a(this), TimeUnit.SECONDS.toMillis(2L));
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
        public final /* synthetic */ gc8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(gc8 gc8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc8Var, Integer.valueOf(i)};
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
            this.a = gc8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof i29)) {
                i29 i29Var = (i29) customResponsedMessage.getData();
                if (this.a.g0 != null && this.a.g0.funAdData == i29Var) {
                    this.a.g0.funAdData.p(true);
                    this.a.b.setData(this.a.E);
                    this.a.Z();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gc8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(gc8 gc8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc8Var, Integer.valueOf(i)};
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
            this.a = gc8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof z19)) {
                AbsDelegateAdapterList a = ((z19) customResponsedMessage.getData()).a();
                Iterator<qn<?, ?>> it = a.iterator();
                while (it.hasNext()) {
                    qn<?, ?> next = it.next();
                    if (next instanceof mc8) {
                        ((mc8) next).t(this.a.a);
                        if (next instanceof kb8) {
                            this.a.x.add((kb8) next);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(a);
                this.a.b0.clear();
                this.a.b0.addAll(arrayList);
                if (this.a.b != null) {
                    this.a.b.a(arrayList);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gc8 a;

        public d(gc8 gc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gc8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a != null && this.a.C != null && this.a.C.V() != null) {
                this.a.a.K5().b1().v();
                TiebaStatic.log(new StatisticItem("c12040"));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ gc8 b;

        public e(gc8 gc8Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc8Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gc8Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.b.setSelectionFromTop(this.b.b.getHeaderViewsCount() + this.a.size(), 0 - this.b.e0);
                this.b.M = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gc8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(gc8 gc8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc8Var, Integer.valueOf(i)};
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
            this.a = gc8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.n0)) {
                this.a.n();
                gc8 gc8Var = this.a;
                gc8Var.h0(gc8Var.C, false);
            }
        }
    }

    public gc8(PbFragment pbFragment, BdTypeListView bdTypeListView) {
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
        this.x = new ArrayList<>();
        this.D = new ArrayList<>();
        this.F = false;
        this.G = false;
        this.H = true;
        this.I = true;
        this.J = false;
        this.K = false;
        this.N = false;
        this.O = 0;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.a0 = new ArrayList();
        this.b0 = new ArrayList();
        this.d0 = -1;
        this.e0 = 0;
        this.f0 = -1;
        this.h0 = new ArrayList();
        this.i0 = new a(this, 2921523);
        this.j0 = new b(this, 2004015);
        this.k0 = new c(this, 2001118);
        this.l0 = new d(this);
        this.m0 = new f(this, 2016470);
        this.O = ej.l(pbFragment.getPageContext().getPageActivity());
        this.a = pbFragment;
        this.b = bdTypeListView;
        K(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.k0);
        this.e0 = ej.j(this.a.getContext()) / 3;
    }

    public void A0(xa8 xa8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xa8Var) == null) {
            this.X = xa8Var;
        }
    }

    public void d0(boolean z) {
        qc8 qc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048610, this, z) == null) && (qc8Var = this.c) != null) {
            qc8Var.T(z);
        }
    }

    public void j0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.G = z;
        }
    }

    public void k0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.J = z;
        }
    }

    public void l0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.H = z;
        }
    }

    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.N = z;
        }
    }

    public void n0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.K = z;
        }
    }

    public void o0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.L = z;
        }
    }

    public void p0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            this.I = z;
        }
    }

    public final PostData q(v98 v98Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, v98Var)) == null) {
            if (v98Var != null && v98Var.W() != null) {
                PostData W = v98Var.W();
                this.R = W;
                return W;
            }
            return null;
        }
        return (PostData) invokeL.objValue;
    }

    public void q0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
            this.M = z;
        }
    }

    public void r0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, onClickListener) == null) {
            this.U = onClickListener;
        }
    }

    public void s0(boolean z) {
        kc8 kc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048633, this, z) == null) && (kc8Var = this.k) != null) {
            kc8Var.u0(z);
        }
    }

    public void t0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, onClickListener) == null) {
            this.S = onClickListener;
        }
    }

    public void v0(TbRichTextView.a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, a0Var) == null) {
            this.V = a0Var;
        }
    }

    public void w0(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, onLongClickListener) == null) {
            this.Y = onLongClickListener;
        }
    }

    public Cdo x(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048642, this, i)) == null) {
            return this.b.G(i);
        }
        return (Cdo) invokeI.objValue;
    }

    public void x0(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, fVar) == null) {
            this.Z = fVar;
        }
    }

    public BdUniqueId y(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048644, this, i)) == null) {
            if (this.b.G(i) != null) {
                return this.b.G(i).getType();
            }
            return null;
        }
        return (BdUniqueId) invokeI.objValue;
    }

    public void y0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, onClickListener) == null) {
            this.T = onClickListener;
        }
    }

    public void z0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, onClickListener) == null) {
            this.W = onClickListener;
        }
    }

    public final int A(v98 v98Var, ArrayList<Cdo> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, v98Var, arrayList)) == null) {
            if (v98Var == null || ListUtils.isEmpty(v98Var.H()) || ListUtils.isEmpty(arrayList) || ((PostData) ListUtils.getItem(v98Var.H(), 0)) == null) {
                return 0;
            }
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    Cdo cdo = arrayList.get(i);
                    if (cdo instanceof PostData) {
                        PostData postData = (PostData) cdo;
                        if (postData.F() == 1 && postData.O == 0) {
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

    public final int F(v98 v98Var, ArrayList<Cdo> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, v98Var, arrayList)) == null) {
            int i = -1;
            if (v98Var == null || v98Var.z() == null) {
                return -1;
            }
            int i2 = 0;
            if (v98Var.z().c() == 1) {
                z = true;
            } else {
                z = false;
            }
            int size = arrayList.size();
            if (!z || !this.G) {
                return -1;
            }
            while (true) {
                if (i2 >= size) {
                    break;
                } else if (arrayList.get(i2) instanceof ia8) {
                    i = i2 + 1;
                    break;
                } else {
                    i2++;
                }
            }
            if (v98Var.N() == 4) {
                return i + 1;
            }
            return i;
        }
        return invokeLL.intValue;
    }

    public final void J(ArrayList<Cdo> arrayList, Boolean bool) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048590, this, arrayList, bool) != null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        int i = l65.i();
        int j = l65.j() - 1;
        if (bool.booleanValue()) {
            Cdo cdo = arrayList.get(0);
            if ((cdo instanceof PostData) && ((PostData) cdo).F() == 1) {
                j++;
            }
        }
        int k = l65.k() + 1;
        PbFragment pbFragment = this.a;
        if (pbFragment != null && pbFragment.M() != null && this.a.M().v1() == 3) {
            this.h0.clear();
        }
        Q(j, i, k, arrayList);
    }

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BdTypeListView bdTypeListView = this.b;
            if (bdTypeListView != null && bdTypeListView.getData() != null) {
                for (int i = 0; i < this.b.getData().size(); i++) {
                    Cdo cdo = this.b.getData().get(i);
                    if (cdo != null && cdo.getType() == ia8.i) {
                        return i;
                    }
                }
                return -1;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            gh.a().removeCallbacks(this.c0);
            pd8 pd8Var = this.h;
            if (pd8Var != null) {
                pd8Var.onDestroy();
            }
            pd8 pd8Var2 = this.j;
            if (pd8Var2 != null) {
                pd8Var2.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.d;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
            he8 he8Var = this.g;
            if (he8Var != null) {
                he8Var.onDestroy();
            }
            vw5.k().q(false);
        }
    }

    public void B0() {
        dd8 dd8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (dd8Var = this.i) != null) {
            dd8Var.x(2);
        }
    }

    public void E0() {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (i = this.f0) > 0 && P(this.E, i) != null) {
            this.f0 = -1;
            this.b.setData(this.E);
            Z();
        }
    }

    public int G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.d0;
        }
        return invokeV.intValue;
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.F;
        }
        return invokeV.booleanValue;
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.H;
        }
        return invokeV.booleanValue;
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.d0 = B();
            if (this.b.getAdapter2() instanceof un) {
                this.b.getAdapter2().notifyDataSetChanged();
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048620, this) == null) && this.a != null && !n()) {
            this.a.registerListener(this.m0);
        }
    }

    public View s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.B.b();
        }
        return (View) invokeV.objValue;
    }

    public ArrayList<Cdo> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.E;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return this.b.getHeaderViewsCount();
        }
        return invokeV.intValue;
    }

    public PbFirstFloorCommentAndPraiseAdapter z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            return this.d;
        }
        return (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    public int C(v98 v98Var, ArrayList<Cdo> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048580, this, v98Var, arrayList, z)) == null) {
            if (v98Var == null || v98Var.H() == null || v98Var.E() == null || v98Var.H().size() == 0 || v98Var.Q() == null || arrayList == null || !v98Var.E().p1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (v98Var.H().get(0) == null || v98Var.H().get(0).F() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (v98Var.z() == null || v98Var.z().a() != v98Var.z().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public int D(v98 v98Var, ArrayList<Cdo> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048582, this, v98Var, arrayList, z)) == null) {
            if (v98Var == null || v98Var.H() == null || v98Var.F() == null || v98Var.H().size() == 0 || v98Var.Q() == null || arrayList == null || !v98Var.F().p1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (v98Var.H().get(0) == null || v98Var.H().get(0).F() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (v98Var.z() == null || v98Var.z().a() != v98Var.z().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final Cdo R(v98 v98Var, ArrayList<Cdo> arrayList, int i) {
        InterceptResult invokeLLI;
        x98 x98Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048598, this, v98Var, arrayList, i)) == null) {
            if (v98Var.l() != null && !StringUtils.isNull(v98Var.l().getName())) {
                if (!TextUtils.equals(v98Var.l().getName(), this.a.M().K0()) || !this.a.M().Q0()) {
                    if (!this.a.v0() && !ListUtils.isEmpty(v98Var.p())) {
                        x98Var = new x98(v98Var.p().get(0));
                    } else {
                        x98Var = new x98(v98Var.l());
                    }
                    x98Var.g = this.a.M().F1();
                    ListUtils.add(arrayList, i + 1, x98Var);
                    return x98Var;
                }
                return null;
            }
            return null;
        }
        return (Cdo) invokeLLI.objValue;
    }

    public final boolean C0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, postData)) == null) {
            if (this.a.M() != null && postData != null && postData.O() != null && postData.O().equals(this.a.M().L1())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void i0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.F = z;
            this.c.setFromCDN(z);
            qn qnVar = this.p;
            if (qnVar != null && (qnVar instanceof ms8)) {
                ((ms8) qnVar).setIsFromCDN(z);
            }
            Iterator<kb8> it = this.x.iterator();
            while (it.hasNext()) {
                it.next().setFromCDN(z);
            }
        }
    }

    public final PostData p(ArrayList<Cdo> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, arrayList)) == null) {
            Iterator<Cdo> it = arrayList.iterator();
            while (it.hasNext()) {
                Cdo next = it.next();
                if (next instanceof PostData) {
                    PostData postData = (PostData) next;
                    if (postData.F() == 1) {
                        return postData;
                    }
                }
            }
            return null;
        }
        return (PostData) invokeL.objValue;
    }

    public void u0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
            kc8 kc8Var = this.k;
            if (kc8Var != null) {
                kc8Var.v0(z);
            }
            pd8 pd8Var = this.h;
            if (pd8Var != null) {
                pd8Var.y(z);
            }
            qn qnVar = this.s;
            if (qnVar != null) {
                qnVar.setMulDel(z);
            }
            qn qnVar2 = this.p;
            if (qnVar2 != null) {
                qnVar2.setMulDel(z);
            }
            qc8 qc8Var = this.c;
            if (qc8Var != null) {
                qc8Var.setMulDel(z);
            }
        }
    }

    public final void D0() {
        v98 v98Var;
        j29 j29Var;
        j29 j29Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (v98Var = this.C) == null || v98Var.c0 || v98Var.d0 == 2) {
            return;
        }
        ArrayList<PostData> H = v98Var.H();
        ArrayList<j29> e2 = this.C.e();
        if (!mv7.e(H) && !mv7.e(e2)) {
            StringBuilder sb = new StringBuilder();
            Iterator<j29> it = e2.iterator();
            while (it.hasNext()) {
                j29 next = it.next();
                if (next != null && next.q1() != null) {
                    sb.append(next.q1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<j29> it2 = e2.iterator();
            while (it2.hasNext()) {
                j29 next2 = it2.next();
                if (next2 != null) {
                    next2.h1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<j29> it3 = e2.iterator();
            while (it3.hasNext()) {
                j29 next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int m = next3.getAdvertAppInfo().m();
                    if (m != 0) {
                        du8.j(next3, m);
                        if (m != 28 && m != 31) {
                            next3.getAdvertAppInfo().c = -1001;
                        }
                    }
                    sparseArray.put(next3.getPosition(), next3);
                }
            }
            e2.clear();
            HashMap hashMap = new HashMap();
            for (int i = 0; i < sparseArray.size(); i++) {
                j29 j29Var3 = (j29) sparseArray.valueAt(i);
                if (j29Var3 != null && (j29Var2 = (j29) hashMap.put(j29Var3.p1(), j29Var3)) != null) {
                    du8.j(j29Var2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (j29Var = (j29) entry.getValue()) != null) {
                    sparseArray.put(j29Var.getPosition(), j29Var);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                mv7.a(arrayList, Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList);
            int i3 = 1;
            for (int i4 = 0; i4 < mv7.i(arrayList); i4++) {
                j29 j29Var4 = (j29) sparseArray.get(((Integer) mv7.d(arrayList, i4)).intValue());
                if (this.C.l() != null) {
                    j29Var4.b1 = this.C.l().getId();
                }
                if (this.C.Q() != null) {
                    j29Var4.e1 = dh.g(this.C.Q().getId(), 0L);
                }
                v98 v98Var2 = this.C;
                if (v98Var2 != null && v98Var2.z() != null) {
                    j29Var4.f1 = this.C.z().a();
                }
                l(j29Var4);
                int position = j29Var4.getPosition() + this.C.b0;
                if (position >= mv7.i(H)) {
                    j29Var4.h1 = position;
                    du8.k(j29Var4, 2, position, mv7.i(H));
                    return;
                }
                if (!this.I) {
                    position--;
                    j29Var4.h1 = position;
                }
                if (position < 0) {
                    du8.j(j29Var4, 23);
                } else {
                    j29Var4.i1 = i3;
                    mv7.b(H, j29Var4, position);
                    i3++;
                    PbFragment pbFragment = this.a;
                    if (pbFragment != null && pbFragment.getPageContext() != null && this.a.getPageContext().getContext() != null) {
                        TiebaStatic.eventStat(this.a.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", j29Var4.getAdvertAppInfo().p);
                    }
                }
            }
        }
    }

    public final int E(v98 v98Var, ArrayList<Cdo> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, v98Var, arrayList, z)) == null) {
            if (v98Var != null && !ListUtils.isEmpty(v98Var.H()) && arrayList != null && arrayList.size() > 0) {
                arrayList.size();
                if (!z) {
                    return 0;
                }
                if (v98Var.H().get(0) == null || v98Var.H().get(0).F() != 1) {
                    return -1;
                }
                return 1;
            } else if (v98Var == null || !v98Var.y0()) {
                return -1;
            } else {
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final void U(v98 v98Var, ArrayList<Cdo> arrayList, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048601, this, v98Var, arrayList, i) == null) {
            ia8 ia8Var = new ia8(ia8.i);
            ThreadData Q = v98Var.Q();
            if (Q != null) {
                Q.getReply_num();
            }
            ia8Var.d = this.a.f6();
            ia8Var.c = v98Var.g;
            v98Var.c();
            ia8Var.e = v98Var.l0();
            ia8Var.g = v98Var.f;
            if (Q != null && Q.isQuestionThread()) {
                z = true;
            } else {
                z = false;
            }
            ia8Var.h = z;
            ListUtils.add(arrayList, i, ia8Var);
            if (v98Var.N() == 4) {
                ListUtils.add(arrayList, i + 1, new ha8());
            }
        }
    }

    public final ArrayList<Cdo> H(List<Cdo> list, List<Cdo> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, list, list2)) == null) {
            ArrayList<Cdo> arrayList = new ArrayList<>(list.size() + list2.size() + 2);
            arrayList.addAll(list);
            ba8 ba8Var = new ba8();
            PbListView f1 = this.a.K5().f1();
            if (f1 != null && f1.p()) {
                ba8Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0eb0);
                ba8Var.b = true;
            } else {
                ba8Var.a = TbadkCoreApplication.getInst().getString(R.string.list_has_no_more);
                ba8Var.b = false;
            }
            arrayList.add(ba8Var);
            ke6 ke6Var = new ke6();
            ke6Var.a = TbadkCoreApplication.getInst().getString(R.string.recommed_for_you);
            ke6Var.needTopMargin = false;
            arrayList.add(ke6Var);
            arrayList.addAll(list2);
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public final Cdo P(ArrayList<Cdo> arrayList, int i) {
        InterceptResult invokeLI;
        v98 v98Var;
        i29 i29Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048596, this, arrayList, i)) == null) {
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && i > 0 && (v98Var = this.C) != null && v98Var.u0()) {
                String d2 = k67.e().d("pb_banner");
                if (this.g0 == null && e67.m().v(d2)) {
                    ThreadData threadData = new ThreadData();
                    this.g0 = threadData;
                    threadData.funAdData = new i29();
                    v98 v98Var2 = this.C;
                    if (v98Var2 != null) {
                        this.g0.funAdData.m(v98Var2.m());
                        this.g0.funAdData.r(this.C.S());
                    }
                }
                ThreadData threadData2 = this.g0;
                if (threadData2 != null && (i29Var = threadData2.funAdData) != null) {
                    i29Var.j(1);
                    vw5.k().q(true);
                    ListUtils.add(arrayList, i, this.g0);
                    if (nx5.i().q()) {
                        nx5.i().n(arrayList, i + 1, 4);
                    }
                }
            }
            return this.g0;
        }
        return (Cdo) invokeLI.objValue;
    }

    public final int u(v98 v98Var, ArrayList<Cdo> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048636, this, v98Var, arrayList)) == null) {
            if (!this.K && v98Var != null && !ListUtils.isEmpty(v98Var.H()) && arrayList != null && arrayList.size() > 0) {
                if (this.a.M() != null && this.a.M().U0()) {
                    return -1;
                }
                if (this.a.K5() != null && this.a.K5().X0()) {
                    return -1;
                }
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    if (i < size) {
                        Cdo cdo = arrayList.get(i);
                        if (cdo instanceof PostData) {
                            PostData postData = (PostData) cdo;
                            if (postData.F() == 1 && postData.O == 0) {
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
                    if (v98Var.y0()) {
                        return 0;
                    }
                    return -1;
                }
                return i + 1;
            } else if (v98Var != null && v98Var.y0() && this.I) {
                return 0;
            } else {
                return -1;
            }
        }
        return invokeLL.intValue;
    }

    public View I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            qc8 qc8Var = this.c;
            if (qc8Var != null && qc8Var.O() != null) {
                if (this.c.O().A != null && this.c.O().A.isShown()) {
                    return this.c.O().A;
                }
                return this.c.O().z;
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void f0() {
        PostData postData;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && this.C != null && (postData = this.Q) != null && postData.W() != null && this.c.O() != null) {
            String S = this.C.S();
            String m = this.C.m();
            if (this.C.Q() != null) {
                i = this.C.Q().getThreadType();
            } else {
                i = 0;
            }
            kj5.a().c(S, m, this.Q.W(), this.c.O().t, i);
        }
    }

    public void K(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, pbFragment, bdTypeListView) == null) {
            qc8 qc8Var = new qc8(pbFragment, PostData.P0);
            this.c = qc8Var;
            qc8Var.e0(pbFragment);
            this.d = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, ja8.f);
            this.e = new PbFirstFloorEnterForumAdapter(pbFragment, x98.i);
            this.f = new PbFirstFloorItemAdapter(pbFragment.getContext(), y98.c);
            this.g = new he8(pbFragment, q98.c);
            this.h = new pd8(pbFragment, ia8.i);
            this.i = new dd8(pbFragment, da8.c);
            this.j = new pd8(pbFragment, ia8.j);
            kc8 kc8Var = new kc8(pbFragment, PostData.Q0);
            this.k = kc8Var;
            kc8Var.x0(pbFragment);
            td8 td8Var = new td8(pbFragment, PostData.R0);
            this.l = td8Var;
            td8Var.t0(pbFragment);
            this.o = qs8.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.x);
            this.p = qs8.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.z);
            this.q = f67.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.F);
            this.r = f67.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.G);
            this.s = f67.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.I);
            this.v = new kd8(pbFragment, fa8.f1);
            this.t = new ld8(pbFragment, jd8.c1);
            this.u = new nd8(pbFragment, xy4.i1);
            this.w = new PbReplyLoadMoreAdapter(pbFragment, PostData.X0);
            this.m = new yg8(pbFragment, zg8.a);
            this.n = new he6(pbFragment.getPageContext());
            this.y = new hc8(pbFragment, jx4.e);
            this.z = new xc8(pbFragment, pbFragment.getUniqueId());
            this.A = new je8(pbFragment.getPageContext(), sx5.g);
            lb8 lb8Var = new lb8(pbFragment, pbFragment.getUniqueId(), this.b);
            this.B = lb8Var;
            this.a0.addAll(lb8Var.a());
            this.a0.add(this.c);
            this.a0.add(this.d);
            this.a0.add(this.e);
            this.a0.add(this.f);
            this.a0.add(this.g);
            this.a0.add(this.k);
            this.a0.add(this.l);
            this.a0.add(this.h);
            this.a0.add(this.i);
            this.a0.add(this.j);
            this.a0.add(this.o);
            this.a0.add(this.p);
            this.a0.add(this.q);
            this.a0.add(this.r);
            this.a0.add(this.s);
            this.a0.add(this.v);
            this.a0.add(this.t);
            this.a0.add(this.u);
            this.a0.add(this.m);
            this.a0.add(this.w);
            this.a0.add(this.n);
            this.a0.add(this.y);
            this.a0.add(this.z);
            this.a0.add(new PbPrivateTitleAdapter(pbFragment));
            this.a0.add(this.A);
            this.j0.setPriority(1);
            this.j0.setSelfListener(true);
            pbFragment.registerListener(this.j0);
            pbFragment.registerListener(this.i0);
            m();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new z19(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
            CustomMessage customMessage = new CustomMessage(2004015);
            customMessage.setTag(pbFragment.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            bdTypeListView.a(this.a0);
        }
    }

    public final void L(@NonNull v98 v98Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, v98Var) == null) {
            this.c.r(v98Var);
            this.c.setFromCDN(this.F);
            this.c.l(this.O);
            this.c.c(this.H);
            this.c.e(this.T);
            this.c.k(this.S);
            this.c.n(this.V);
            this.c.d(this.Y);
            this.c.b0(this.W);
            this.c.d0(this.X);
            this.f.w(this.W);
            this.k.r(v98Var);
            this.k.setFromCDN(this.F);
            this.k.o(this.P);
            this.k.c(this.H);
            this.k.e(this.T);
            this.k.k(this.S);
            this.k.n(this.V);
            this.k.d(this.Y);
            this.k.w0(this.X);
            this.l.r(v98Var);
            this.l.setFromCDN(this.F);
            this.l.o(this.P);
            this.l.c(this.H);
            this.l.e(this.T);
            this.l.k(this.S);
            this.l.n(this.V);
            this.l.d(this.Y);
            this.l.s0(this.X);
            this.d.H(this.T);
            this.w.w(this.T);
            this.m.w(this.l0);
            qn qnVar = this.p;
            if (qnVar != null && (qnVar instanceof ms8)) {
                ((ms8) qnVar).setIsFromCDN(this.F);
            }
            Iterator<kb8> it = this.x.iterator();
            while (it.hasNext()) {
                kb8 next = it.next();
                if (next != null) {
                    next.r(v98Var);
                    next.setFromCDN(this.F);
                    next.o(this.P);
                    next.l(this.O);
                    next.c(this.H);
                    next.f(this.I);
                    next.q(this.N);
                    next.e(this.T);
                    next.k(this.S);
                    next.n(this.V);
                    next.d(this.Y);
                }
            }
            this.h.e(this.T);
            this.h.z(this.Z);
            this.i.e(this.U);
            this.j.e(this.T);
            this.h.r(v98Var);
            this.g.r(v98Var);
            this.j.r(v98Var);
            this.t.r(v98Var);
            this.u.r(v98Var);
            this.y.y(v98Var);
            this.y.x(this.a.t1);
            this.z.w(v98Var);
            this.B.f(v98Var);
        }
    }

    public final Cdo M(ArrayList<Cdo> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048593, this, arrayList, i)) == null) {
            if (this.C == null) {
                return null;
            }
            j29 E0 = this.a.M().E0();
            if (E0 == null) {
                E0 = this.C.A();
            }
            if (E0 == null) {
                return null;
            }
            AdvertAppInfo.ILegoAdvert s1 = E0.s1();
            if (s1 != null) {
                s1.setAdvertAppInfo(E0.getAdvertAppInfo());
            }
            int m = E0.getAdvertAppInfo().m();
            if (m != 0) {
                du8.j(E0, m);
                if (m != 28 && m != 31) {
                    E0.getAdvertAppInfo().c = -1001;
                }
                return null;
            }
            if (this.C.l() != null) {
                E0.b1 = this.C.l().getId();
            }
            if (this.C.Q() != null) {
                E0.e1 = dh.g(this.C.Q().getId(), 0L);
            }
            v98 v98Var = this.C;
            if (v98Var != null && v98Var.z() != null) {
                E0.f1 = this.C.z().a();
            }
            l(E0);
            if (i < 0) {
                return null;
            }
            E0.i1 = 1;
            vw5.k().q(true);
            mv7.b(arrayList, E0, i);
            if (nx5.i().q()) {
                nx5.i().n(arrayList, i + 1, 4);
            }
            return E0;
        }
        return (Cdo) invokeLI.objValue;
    }

    public final boolean N(v98 v98Var, ArrayList<Cdo> arrayList, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{v98Var, arrayList, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            ArrayList arrayList2 = new ArrayList();
            if (!ListUtils.isEmpty(v98Var.f()) && v98Var.f().size() > 2) {
                int min = Math.min(v98Var.f().size(), 7);
                for (int i6 = 0; i6 < min; i6++) {
                    jx4 jx4Var = v98Var.f().get(i6);
                    if (!z2 && i6 == 0) {
                        jx4Var.m(true);
                    }
                    if (jx4Var.getThreadVideoInfo() == null) {
                        if (i6 == min - 1) {
                            jx4Var.p(true);
                        }
                    } else if (i6 == min - 2) {
                        jx4Var.p(true);
                    } else if (i6 == min - 1) {
                        jx4Var.o(true);
                    }
                    arrayList2.add(jx4Var);
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

    public final Cdo O(v98 v98Var, ArrayList<Cdo> arrayList, int i) {
        InterceptResult invokeLLI;
        q98 q98Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048595, this, v98Var, arrayList, i)) == null) {
            if (i >= 0 && v98Var != null && v98Var.k && (q98Var = v98Var.l) != null) {
                ListUtils.add(arrayList, i, q98Var);
                return q98Var;
            }
            return null;
        }
        return (Cdo) invokeLLI.objValue;
    }

    public final void W(PostData postData, ArrayList<Cdo> arrayList, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048603, this, postData, arrayList, i) == null) {
            postData.h1(true);
            arrayList.add(i, postData);
        }
    }

    public final void Q(int i, int i2, int i3, ArrayList<Cdo> arrayList) {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), arrayList}) == null) && !ListUtils.isEmpty(arrayList) && i >= 0 && i2 >= 1) {
            ListIterator<Cdo> listIterator = arrayList.listIterator();
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
                    if (i5 < this.h0.size()) {
                        listIterator.add(this.h0.get(i5));
                    } else {
                        PostData postData = new PostData();
                        i29 i29Var = new i29();
                        v98 v98Var = this.C;
                        if (v98Var == null) {
                            str3 = "";
                        } else {
                            str3 = v98Var.m();
                        }
                        i29Var.m(str3);
                        v98 v98Var2 = this.C;
                        if (v98Var2 != null) {
                            str = v98Var2.S();
                        }
                        i29Var.r(str);
                        i29Var.n(true);
                        postData.w0 = i29Var;
                        i29Var.j(i7);
                        listIterator.add(postData);
                        i7++;
                        this.h0.add(postData);
                    }
                    i5++;
                    if (i6 == 0) {
                        i6 = i4 + 1;
                    }
                }
                listIterator.next();
                i4++;
            }
            if (i6 > 0 && nx5.i().q()) {
                nx5.i().n(arrayList, i6, 5);
            }
            if (i4 == i && i5 < i3) {
                PostData postData2 = new PostData();
                i29 i29Var2 = new i29();
                v98 v98Var3 = this.C;
                if (v98Var3 == null) {
                    str2 = "";
                } else {
                    str2 = v98Var3.m();
                }
                i29Var2.m(str2);
                v98 v98Var4 = this.C;
                if (v98Var4 != null) {
                    str = v98Var4.S();
                }
                i29Var2.r(str);
                i29Var2.n(true);
                postData2.w0 = i29Var2;
                i29Var2.j(1);
                listIterator.add(postData2);
                this.h0.add(postData2);
                if (nx5.i().q()) {
                    nx5.i().n(arrayList, -1, 4);
                }
            }
        }
    }

    public final Cdo S(v98 v98Var, PostData postData, ArrayList<Cdo> arrayList, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048599, this, v98Var, postData, arrayList, i)) == null) {
            y98 y98Var = null;
            if (v98Var.l() != null && !StringUtils.isNull(v98Var.l().getName()) && TextUtils.equals(v98Var.l().getName(), this.a.M().K0()) && this.a.M().Q0()) {
                return null;
            }
            if (postData != null) {
                if (postData.r0 != null) {
                    y98Var = new y98(postData.r0);
                }
            } else {
                PostData postData2 = this.Q;
                if (postData2 != null && postData2.r0 != null) {
                    y98Var = new y98(this.Q.r0);
                }
            }
            if (y98Var != null) {
                y98Var.b = this.a.M().F1();
                ListUtils.add(arrayList, i + 1, y98Var);
            }
            return y98Var;
        }
        return (Cdo) invokeLLLI.objValue;
    }

    public final yc8 T(ArrayList<Cdo> arrayList, Cdo cdo, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048600, this, arrayList, cdo, i, i2)) == null) {
            yc8 C = this.C.C();
            if (C != null) {
                if (cdo != null) {
                    if (i2 < 0 && cdo.getType() != AdvertAppInfo.z) {
                        i2 = i + 2;
                    } else if (cdo.getType() != AdvertAppInfo.z) {
                        i2++;
                    } else {
                        i2 = -1;
                    }
                }
                if (i2 > 0 && (C instanceof yc8)) {
                    ListUtils.add(arrayList, i2, C);
                    return C;
                }
                return null;
            }
            return null;
        }
        return (yc8) invokeLLII.objValue;
    }

    public final Cdo V(ArrayList<Cdo> arrayList, int i) {
        InterceptResult invokeLI;
        PbModel M;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048602, this, arrayList, i)) == null) {
            if (i < 0 || (M = this.a.M()) == null || TextUtils.isEmpty(M.p1())) {
                return null;
            }
            j29 j29Var = new j29();
            l(j29Var);
            ListUtils.add(arrayList, i + 1, j29Var);
            return j29Var;
        }
        return (Cdo) invokeLI.objValue;
    }

    public void b0(boolean z, int i) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && (pbFragment = this.a) != null && pbFragment.K5() != null) {
            this.a.K5().g2(z, i);
        }
    }

    public void a0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        qc8 qc8Var = this.c;
                        if (qc8Var != null) {
                            qc8Var.V();
                        }
                        qn qnVar = this.p;
                        if (qnVar instanceof hs8) {
                            ((hs8) qnVar).onDestroy();
                        }
                        qn qnVar2 = this.q;
                        if (qnVar2 instanceof hs8) {
                            ((hs8) qnVar2).onDestroy();
                        }
                        qn qnVar3 = this.s;
                        if (qnVar3 instanceof hs8) {
                            ((hs8) qnVar3).onDestroy();
                        }
                        lc8.a().d();
                        return;
                    }
                    return;
                }
                qc8 qc8Var2 = this.c;
                if (qc8Var2 != null) {
                    qc8Var2.W();
                }
                qn qnVar4 = this.p;
                if (qnVar4 instanceof hs8) {
                    ((hs8) qnVar4).onResume();
                }
                qn qnVar5 = this.q;
                if (qnVar5 instanceof hs8) {
                    ((hs8) qnVar5).onResume();
                }
                qn qnVar6 = this.s;
                if (qnVar6 instanceof hs8) {
                    ((hs8) qnVar6).onResume();
                }
                g0(false);
                f0();
                return;
            }
            qc8 qc8Var3 = this.c;
            if (qc8Var3 != null) {
                qc8Var3.U();
            }
            qn qnVar7 = this.p;
            if (qnVar7 instanceof hs8) {
                ((hs8) qnVar7).onPause();
            }
            qn qnVar8 = this.q;
            if (qnVar8 instanceof hs8) {
                ((hs8) qnVar8).onPause();
            }
            qn qnVar9 = this.s;
            if (qnVar9 instanceof hs8) {
                ((hs8) qnVar9).onPause();
            }
            lc8.a().j(this.a.N());
            kj5.a().d();
        }
    }

    public final void l(j29 j29Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048618, this, j29Var) == null) && j29Var != null && this.C != null && j29Var.getAdvertAppInfo() != null) {
            j29Var.getAdvertAppInfo().i = new xw4();
            if (this.C.z() != null) {
                j29Var.getAdvertAppInfo().i.b = this.C.z().a();
            }
            j29Var.getAdvertAppInfo().i.a = j29Var.r1();
            if (this.C.l() != null && (l = this.C.l()) != null) {
                j29Var.getAdvertAppInfo().i.c = l.getId();
                j29Var.getAdvertAppInfo().i.d = l.getFirst_class();
                j29Var.getAdvertAppInfo().i.e = l.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                j29Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            j29Var.getAdvertAppInfo().i.g = j29Var.getAdvertAppInfo().g;
            j29Var.getAdvertAppInfo().i.h = false;
        }
    }

    public final List<Cdo> v(v98 v98Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, v98Var)) == null) {
            if (v98Var == null || v98Var.V() == null || ListUtils.isEmpty(v98Var.V().a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<PostData> list = v98Var.V().a;
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            int min = Math.min(2, list.size());
            for (int i = 0; i < min; i++) {
                PostData postData = list.get(i);
                if (postData != null) {
                    postData.c0 = true;
                    postData.P = true;
                    arrayList.add(postData);
                }
            }
            if (ListUtils.getCount(v98Var.V().b) > 2) {
                Cdo cdo = (Cdo) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (cdo instanceof PostData) {
                    ((PostData) cdo).P = false;
                }
                arrayList.add(new zg8());
            } else {
                Cdo cdo2 = (Cdo) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (cdo2 instanceof PostData) {
                    ((PostData) cdo2).P = true;
                }
            }
            ia8 ia8Var = new ia8(ia8.j);
            ia8Var.a = v98Var.V().c;
            arrayList.add(0, ia8Var);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void e0(boolean z, boolean z2, int i, List<Cdo> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), list}) == null) && !z && !z2) {
            if ((this.L || this.K) && i != -1 && !ListUtils.isEmpty(list) && !this.M) {
                this.c0 = new e(this, list);
                gh.a().post(this.c0);
            }
        }
    }

    public void g0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048613, this, z) == null) && this.a.K5() != null && this.a.N() != null && this.a.N().H1() != null) {
            lc8.a().g(this.a.N().H1().Z1(), this.h.v(), this.a.K5().h1(), this.a.N().getPageStayDurationItem(), z, this.B.b(), this.a.getListView());
        }
    }

    public final void o(List<Cdo> list) {
        int size;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048624, this, list) == null) && list != null && (size = list.size()) > 0) {
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (list.get(i2) instanceof PostData) {
                    if (i == 0 && (list.get(i2) instanceof j29)) {
                        i = i2 + 1;
                    }
                    PostData postData = (PostData) list.get(i2);
                    if (!TextUtils.isEmpty(postData.U())) {
                        iy4 iy4Var = new iy4();
                        iy4Var.h(postData.U());
                        list.set(i2, iy4Var);
                    }
                }
            }
            if (i > 0 && nx5.i().q()) {
                nx5.i().n(list, i, 5);
            }
        }
    }

    public void h0(v98 v98Var, boolean z) {
        PostData postData;
        boolean z2;
        boolean z3;
        PostData postData2;
        boolean z4;
        boolean z5;
        int i;
        boolean z6;
        boolean z7;
        boolean z8;
        int i2;
        boolean z9;
        int i3;
        yc8 yc8Var;
        List<Cdo> list;
        int i4;
        boolean z10;
        boolean z11;
        boolean z12;
        Cdo cdo;
        int i5;
        boolean z13;
        PostData postData3;
        PostData postData4;
        PostData postData5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048614, this, v98Var, z) != null) || v98Var == null) {
            return;
        }
        this.C = v98Var;
        if (!UbsABTestHelper.isPbCommentFunAdABTest()) {
            D0();
        }
        if (this.D == null) {
            this.D = new ArrayList<>();
        }
        this.D.clear();
        v98 v98Var2 = this.C;
        if (v98Var2 != null && v98Var2.H() != null && this.C.H().size() > 0) {
            this.D.addAll(this.C.H());
        }
        if (v98Var.Q() != null && v98Var.Q().getAuthor() != null) {
            this.P = v98Var.Q().getAuthor().getUserId();
        }
        if (this.c == null) {
            return;
        }
        L(v98Var);
        ArrayList<Cdo> arrayList = new ArrayList<>(v98Var.H());
        PostData p = p(arrayList);
        if (this.C.Q().isQuestionThread()) {
            postData = q(v98Var);
        } else {
            postData = null;
        }
        if (postData != null) {
            arrayList.remove(postData);
        }
        if (p != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!l67.f() && UbsABTestHelper.isPbCommentFunAdABTest() && this.C.u0()) {
            J(arrayList, Boolean.valueOf(z2));
        }
        if (p != null) {
            this.Q = p;
        }
        if (!this.I && p != null) {
            arrayList.remove(p);
            if (v98Var.y0() && p.Z() != null) {
                p.b1(null);
            }
            z2 = true;
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z2 && v98Var.j() != null) {
            PostData j = v98Var.j();
            if (!this.I && v98Var.y0() && j.Z() != null) {
                j.b1(null);
            }
            if (!this.I && (postData5 = this.Q) != null && j.i0 == null) {
                v98Var.H0(postData5);
                postData2 = postData5;
            } else {
                postData2 = j;
            }
            z2 = true;
            z4 = true;
        } else {
            postData2 = p;
            z4 = z3;
        }
        o(arrayList);
        if (this.a.B5()) {
            if (v98Var.H().size() > 0 && (postData4 = v98Var.H().get(0)) != null && postData4.F() == 1 && !ListUtils.isEmpty(arrayList)) {
                arrayList.remove(0);
            }
        } else {
            int C = C(this.C, arrayList, this.I);
            if (C >= 0) {
                ListUtils.add(arrayList, C, this.C.E());
            }
        }
        int D = D(this.C, arrayList, this.I);
        if (D >= 0) {
            ListUtils.add(arrayList, D, this.C.F());
        }
        j19.f(arrayList, 1);
        int A = A(v98Var, arrayList);
        if (A >= 0) {
            U(v98Var, arrayList, A);
            z5 = true;
        } else {
            z5 = false;
        }
        int F = F(v98Var, arrayList);
        if (F >= 0) {
            da8 da8Var = new da8(da8.c);
            da8Var.b(true);
            ListUtils.add(arrayList, F, da8Var);
        }
        int u = u(v98Var, arrayList);
        List<Cdo> v = v(v98Var);
        if (!ListUtils.isEmpty(v) && u >= 0) {
            Cdo cdo2 = (Cdo) ListUtils.getItem(arrayList, u);
            if (cdo2 instanceof PostData) {
                ((PostData) cdo2).R = true;
            }
            ListUtils.addAll(arrayList, u, v);
            z5 = true;
        }
        if (z2) {
            i = E(v98Var, arrayList, this.I);
        } else {
            i = -1;
        }
        if (i >= 0 && v98Var.U() != null) {
            PostData Z = v98Var.Z();
            ThreadData c2 = v98Var.U().c();
            if (Z != null && Z.o0() != null && c2 != null && c2.getCustomFigure() == null) {
                VirtualImageCustomFigure o0 = Z.o0();
                VirtualImageCustomState p0 = Z.p0();
                c2.setCustomFigure(o0);
                c2.setCustomState(p0);
            }
            ListUtils.add(arrayList, i, v98Var.U());
            z6 = true;
            z7 = true;
        } else {
            if (postData2 != null) {
                postData2.Q = true;
            }
            z6 = z5;
            z7 = false;
        }
        if ((this.C.Q().isQuestionThread() && postData != null) || (this.C.Q().isQuestionThread() && this.R != null)) {
            if (postData == null && (postData3 = this.R) != null) {
                postData = postData3;
            }
            if (!arrayList.contains(postData)) {
                i++;
                W(postData, arrayList, i);
            }
        }
        if (S(v98Var, postData2, arrayList, i) != null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z8) {
            i++;
        }
        if (!z8 && R(v98Var, arrayList, i) != null) {
            i++;
        }
        if (O(v98Var, arrayList, i) != null) {
            i++;
        }
        if (z2) {
            Cdo V = V(arrayList, i);
            if (V != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                if (i >= 0) {
                    i5 = i + 1;
                } else if (u >= 0) {
                    i5 = u;
                } else if (A >= 0) {
                    i5 = A;
                } else {
                    i5 = -1;
                }
                cdo = M(arrayList, i5);
                if (cdo != null) {
                    z12 = true;
                } else {
                    z12 = false;
                }
            } else {
                z12 = z11;
                cdo = V;
                i5 = -1;
            }
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() == 1) {
                z13 = false;
            } else {
                z13 = true;
            }
            if (z13 && this.C.u0()) {
                this.f0 = i5;
                if (P(arrayList, i5) != null) {
                    this.f0 = -1;
                    i++;
                }
            }
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && z13) {
                z9 = z12;
                i2 = i;
                yc8Var = null;
            } else {
                yc8 T = T(arrayList, cdo, i, i5);
                if (T != null) {
                    if (!z12) {
                        yc8Var = T;
                        i2 = i;
                        z9 = true;
                    } else if (i5 > 0) {
                        i5++;
                    } else {
                        i++;
                    }
                }
                yc8Var = T;
                z9 = z12;
                i2 = i;
            }
            i3 = i5;
        } else {
            i2 = i;
            z9 = false;
            i3 = -1;
            yc8Var = null;
        }
        if (z2) {
            if (yc8Var != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            list = v;
            int i6 = i2;
            i4 = u;
            boolean N = N(v98Var, arrayList, z9, z10, i3, i6, u, A);
            if (yc8Var != null) {
                yc8Var.n = N;
            }
        } else {
            list = v;
            i4 = u;
        }
        this.c.c0(!z6);
        boolean C0 = C0(postData2);
        if (this.J && !C0) {
            arrayList.remove(postData2);
            this.J = false;
        }
        if (v98Var.U() != null) {
            v98Var.U().i(!z7);
        }
        if (this.b != null) {
            this.E = arrayList;
            List<Cdo> T2 = v98Var.T();
            if (!ListUtils.isEmpty(T2)) {
                this.b.setData(H(arrayList, T2));
            } else {
                this.b.setData(this.E);
            }
        }
        e0(C0, z, i4, list);
        if (r(postData2, arrayList, z4)) {
            List<Cdo> T3 = v98Var.T();
            if (!ListUtils.isEmpty(T3)) {
                this.b.setData(H(arrayList, T3));
            } else {
                this.b.setData(arrayList);
            }
        }
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            if (this.a == null) {
                return false;
            }
            this.n0 = new ArrayList();
            ArrayList<BdUniqueId> g = j19.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                ev7 b2 = jw7.d().b(this.a.getPageContext(), g.get(i), 2);
                if (b2 != null) {
                    this.a0.add(b2);
                    this.n0.add(b2);
                }
            }
            if (!ListUtils.isEmpty(this.n0)) {
                this.b.a(this.n0);
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean r(PostData postData, ArrayList<Cdo> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048630, this, postData, arrayList, z)) == null) {
            if (postData == null) {
                PostData postData2 = this.Q;
                if (postData2 != null && !this.K) {
                    ListUtils.add(arrayList, 0, postData2);
                } else {
                    PostData postData3 = new PostData();
                    postData3.J0(1);
                    ListUtils.add(arrayList, 0, postData3);
                }
                return true;
            } else if (!z) {
                return false;
            } else {
                ListUtils.add(arrayList, 0, postData);
                return true;
            }
        }
        return invokeLLZ.booleanValue;
    }
}
