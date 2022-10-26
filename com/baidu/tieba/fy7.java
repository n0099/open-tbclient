package com.baidu.tieba;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
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
public class fy7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public kx7 A;
    public uv7 B;
    public ArrayList C;
    public ArrayList D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public int N;
    public String O;
    public PostData P;
    public PostData Q;
    public View.OnClickListener R;
    public View.OnClickListener S;
    public View.OnClickListener T;
    public TbRichTextView.y U;
    public View.OnClickListener V;
    public ww7 W;
    public View.OnLongClickListener X;
    public SortSwitchButton.f Y;
    public final List Z;
    public PbFragment a;
    public final List a0;
    public BdTypeListView b;
    public Runnable b0;
    public py7 c;
    public int c0;
    public PbFirstFloorCommentAndPraiseAdapter d;
    public int d0;
    public PbFirstFloorEnterForumAdapter e;
    public int e0;
    public PbFirstFloorItemAdapter f;
    public ThreadData f0;
    public g08 g;
    public List g0;
    public oz7 h;
    public final CustomMessageListener h0;
    public cz7 i;
    public CustomMessageListener i0;
    public oz7 j;
    public final CustomMessageListener j0;
    public jy7 k;
    public final View.OnClickListener k0;
    public sz7 l;
    public CustomMessageListener l0;
    public v28 m;
    public List m0;
    public l36 n;
    public rn o;
    public rn p;
    public rn q;
    public rn r;
    public rn s;
    public kz7 t;
    public mz7 u;
    public jz7 v;
    public PbReplyLoadMoreAdapter w;
    public ArrayList x;
    public gy7 y;
    public wy7 z;

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fy7 a;

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
                    this.a.a.a0();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(fy7 fy7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fy7Var, Integer.valueOf(i)};
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
            this.a = fy7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            List list;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.B != null && !w9.c(this.a.a.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (list = (List) ((DownloadMessage) customResponsedMessage).getData()) != null && list.size() != 0) {
                boolean z = false;
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (((DownloadData) it.next()).getStatus() == 0) {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    hh.a().postDelayed(new a(this), TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fy7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(fy7 fy7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fy7Var, Integer.valueOf(i)};
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
            this.a = fy7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof pn8)) {
                pn8 pn8Var = (pn8) customResponsedMessage.getData();
                if (this.a.f0 != null && this.a.f0.funAdData == pn8Var) {
                    this.a.f0.funAdData.p(true);
                    this.a.b.setData(this.a.D);
                    this.a.a0();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fy7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(fy7 fy7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fy7Var, Integer.valueOf(i)};
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
            this.a = fy7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof gn8)) {
                AbsDelegateAdapterList a = ((gn8) customResponsedMessage.getData()).a();
                Iterator<E> it = a.iterator();
                while (it.hasNext()) {
                    rn rnVar = (rn) it.next();
                    if (rnVar instanceof ly7) {
                        ((ly7) rnVar).t(this.a.a);
                        if (rnVar instanceof jx7) {
                            this.a.x.add((jx7) rnVar);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(a);
                this.a.a0.clear();
                this.a.a0.addAll(arrayList);
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
        public final /* synthetic */ fy7 a;

        public d(fy7 fy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fy7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a != null && this.a.B != null && this.a.B.U() != null) {
                this.a.a.O5().V0().v();
                TiebaStatic.log(new StatisticItem("c12040"));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ fy7 b;

        public e(fy7 fy7Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fy7Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fy7Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.b.setSelectionFromTop(this.b.b.getHeaderViewsCount() + this.a.size(), 0 - this.b.d0);
                this.b.L = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fy7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(fy7 fy7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fy7Var, Integer.valueOf(i)};
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
            this.a = fy7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.m0)) {
                this.a.n();
                fy7 fy7Var = this.a;
                fy7Var.i0(fy7Var.B, false);
            }
        }
    }

    public fy7(PbFragment pbFragment, BdTypeListView bdTypeListView) {
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
        this.x = new ArrayList();
        this.C = new ArrayList();
        this.E = false;
        this.F = false;
        this.G = true;
        this.H = true;
        this.I = false;
        this.J = false;
        this.M = false;
        this.N = 0;
        this.O = null;
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
        this.Z = new ArrayList();
        this.a0 = new ArrayList();
        this.c0 = -1;
        this.d0 = 0;
        this.e0 = -1;
        this.g0 = new ArrayList();
        this.h0 = new a(this, 2921523);
        this.i0 = new b(this, 2004015);
        this.j0 = new c(this, 2001118);
        this.k0 = new d(this);
        this.l0 = new f(this, 2016470);
        this.N = fj.k(pbFragment.getPageContext().getPageActivity());
        this.a = pbFragment;
        this.b = bdTypeListView;
        L(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.j0);
        this.d0 = fj.i(this.a.getContext()) / 3;
    }

    public void A0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.V = onClickListener;
        }
    }

    public void B0(ww7 ww7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ww7Var) == null) {
            this.W = ww7Var;
        }
    }

    public void e0(boolean z) {
        py7 py7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048612, this, z) == null) && (py7Var = this.c) != null) {
            py7Var.O(z);
        }
    }

    public void k0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            this.F = z;
        }
    }

    public void l0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            this.I = z;
        }
    }

    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            this.G = z;
        }
    }

    public void n0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            this.M = z;
        }
    }

    public void o0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            this.J = z;
        }
    }

    public void p0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z) == null) {
            this.K = z;
        }
    }

    public final PostData q(uv7 uv7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, uv7Var)) == null) {
            if (uv7Var != null && uv7Var.V() != null) {
                PostData V = uv7Var.V();
                this.Q = V;
                return V;
            }
            return null;
        }
        return (PostData) invokeL.objValue;
    }

    public void q0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z) == null) {
            this.H = z;
        }
    }

    public void r0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
            this.L = z;
        }
    }

    public void s0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, onClickListener) == null) {
            this.T = onClickListener;
        }
    }

    public void t0(boolean z) {
        jy7 jy7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048636, this, z) == null) && (jy7Var = this.k) != null) {
            jy7Var.s0(z);
        }
    }

    public void u0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, onClickListener) == null) {
            this.R = onClickListener;
        }
    }

    public void w0(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, yVar) == null) {
            this.U = yVar;
        }
    }

    public eo x(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048643, this, i)) == null) {
            return this.b.G(i);
        }
        return (eo) invokeI.objValue;
    }

    public void x0(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, onLongClickListener) == null) {
            this.X = onLongClickListener;
        }
    }

    public BdUniqueId y(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048645, this, i)) == null) {
            if (this.b.G(i) != null) {
                return this.b.G(i).getType();
            }
            return null;
        }
        return (BdUniqueId) invokeI.objValue;
    }

    public void y0(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, fVar) == null) {
            this.Y = fVar;
        }
    }

    public void z0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, onClickListener) == null) {
            this.S = onClickListener;
        }
    }

    public final int A(uv7 uv7Var, ArrayList arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, uv7Var, arrayList)) == null) {
            if (uv7Var == null || ListUtils.isEmpty(uv7Var.G()) || ListUtils.isEmpty(arrayList) || ((PostData) ListUtils.getItem(uv7Var.G(), 0)) == null) {
                return 0;
            }
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    eo eoVar = (eo) arrayList.get(i);
                    if (eoVar instanceof PostData) {
                        PostData postData = (PostData) eoVar;
                        if (postData.D() == 1 && postData.N == 0) {
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

    public final int G(uv7 uv7Var, ArrayList arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, uv7Var, arrayList)) == null) {
            int i = -1;
            if (uv7Var == null || uv7Var.y() == null) {
                return -1;
            }
            int i2 = 0;
            if (uv7Var.y().c() == 1) {
                z = true;
            } else {
                z = false;
            }
            int size = arrayList.size();
            if (!z || !this.F) {
                return -1;
            }
            while (true) {
                if (i2 >= size) {
                    break;
                } else if (((eo) arrayList.get(i2)) instanceof hw7) {
                    i = i2 + 1;
                    break;
                } else {
                    i2++;
                }
            }
            if (uv7Var.M() == 4) {
                return i + 1;
            }
            return i;
        }
        return invokeLL.intValue;
    }

    public final void K(ArrayList arrayList, Boolean bool) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048592, this, arrayList, bool) != null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        int i = r05.i();
        int j = r05.j() - 1;
        if (bool.booleanValue()) {
            eo eoVar = (eo) arrayList.get(0);
            if ((eoVar instanceof PostData) && ((PostData) eoVar).D() == 1) {
                j++;
            }
        }
        int k = r05.k() + 1;
        PbFragment pbFragment = this.a;
        if (pbFragment != null && pbFragment.K() != null && this.a.K().c2() == 3) {
            this.g0.clear();
        }
        R(j, i, k, arrayList);
    }

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BdTypeListView bdTypeListView = this.b;
            if (bdTypeListView != null && bdTypeListView.getData() != null) {
                for (int i = 0; i < this.b.getData().size(); i++) {
                    eo eoVar = (eo) this.b.getData().get(i);
                    if (eoVar != null && eoVar.getType() == hw7.i) {
                        return i;
                    }
                }
                return -1;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            hh.a().removeCallbacks(this.b0);
            oz7 oz7Var = this.h;
            if (oz7Var != null) {
                oz7Var.onDestroy();
            }
            oz7 oz7Var2 = this.j;
            if (oz7Var2 != null) {
                oz7Var2.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.d;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
            g08 g08Var = this.g;
            if (g08Var != null) {
                g08Var.onDestroy();
            }
            ip5.k().q(false);
        }
    }

    public int C(uv7 uv7Var, ArrayList arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048580, this, uv7Var, arrayList, z)) == null) {
            if (uv7Var == null || uv7Var.G() == null || uv7Var.D() == null || uv7Var.G().size() == 0 || uv7Var.P() == null || arrayList == null || !uv7Var.D().k1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (uv7Var.G().get(0) == null || ((PostData) uv7Var.G().get(0)).D() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (uv7Var.y() == null || uv7Var.y().a() != uv7Var.y().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public int D(uv7 uv7Var, ArrayList arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048582, this, uv7Var, arrayList, z)) == null) {
            if (uv7Var == null || uv7Var.G() == null || uv7Var.E() == null || uv7Var.G().size() == 0 || uv7Var.P() == null || arrayList == null || !uv7Var.E().k1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                if (uv7Var.G().get(0) == null || ((PostData) uv7Var.G().get(0)).D() != 1) {
                    return -1;
                }
                return 1;
            } else if (size == 0) {
                return 0;
            } else {
                if (uv7Var.y() == null || uv7Var.y().a() != uv7Var.y().h()) {
                    return -1;
                }
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final eo S(uv7 uv7Var, ArrayList arrayList, int i) {
        InterceptResult invokeLLI;
        wv7 wv7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048600, this, uv7Var, arrayList, i)) == null) {
            if (uv7Var.l() != null && !StringUtils.isNull(uv7Var.l().getName())) {
                if (!TextUtils.equals(uv7Var.l().getName(), this.a.K().r1()) || !this.a.K().x1()) {
                    if (!this.a.u0() && !ListUtils.isEmpty(uv7Var.p())) {
                        wv7Var = new wv7((zt4) uv7Var.p().get(0));
                    } else {
                        wv7Var = new wv7(uv7Var.l());
                    }
                    wv7Var.g = this.a.K().m2();
                    ListUtils.add(arrayList, i + 1, wv7Var);
                    return wv7Var;
                }
                return null;
            }
            return null;
        }
        return (eo) invokeLLI.objValue;
    }

    public void C0() {
        cz7 cz7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (cz7Var = this.i) != null) {
            cz7Var.x(2);
        }
    }

    public ArrayList E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.C;
        }
        return (ArrayList) invokeV.objValue;
    }

    public void F0() {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (i = this.e0) > 0 && Q(this.D, i) != null) {
            this.e0 = -1;
            this.b.setData(this.D);
            a0();
        }
    }

    public int H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.c0;
        }
        return invokeV.intValue;
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.E;
        }
        return invokeV.booleanValue;
    }

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.G;
        }
        return invokeV.booleanValue;
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.c0 = B();
            if (this.b.getAdapter2() instanceof vn) {
                this.b.getAdapter2().notifyDataSetChanged();
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048621, this) == null) && this.a != null && !n()) {
            this.a.registerListener(this.l0);
        }
    }

    public View s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.A.b();
        }
        return (View) invokeV.objValue;
    }

    public ArrayList t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.D;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return this.b.getHeaderViewsCount();
        }
        return invokeV.intValue;
    }

    public PbFirstFloorCommentAndPraiseAdapter z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            return this.d;
        }
        return (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    public final boolean D0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, postData)) == null) {
            if (this.a.K() != null && postData != null && postData.M() != null && postData.M().equals(this.a.K().s2())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void j0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.E = z;
            this.c.setFromCDN(z);
            rn rnVar = this.p;
            if (rnVar != null && (rnVar instanceof he8)) {
                ((he8) rnVar).setIsFromCDN(z);
            }
            Iterator it = this.x.iterator();
            while (it.hasNext()) {
                ((jx7) it.next()).setFromCDN(z);
            }
        }
    }

    public final void o(List list) {
        int size;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048625, this, list) == null) && list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.S())) {
                        qs4 qs4Var = new qs4();
                        qs4Var.h(postData.S());
                        list.set(i, qs4Var);
                    }
                }
            }
        }
    }

    public final PostData p(ArrayList arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, arrayList)) == null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                eo eoVar = (eo) it.next();
                if (eoVar instanceof PostData) {
                    PostData postData = (PostData) eoVar;
                    if (postData.D() == 1) {
                        return postData;
                    }
                }
            }
            return null;
        }
        return (PostData) invokeL.objValue;
    }

    public void v0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048640, this, z) == null) {
            jy7 jy7Var = this.k;
            if (jy7Var != null) {
                jy7Var.t0(z);
            }
            oz7 oz7Var = this.h;
            if (oz7Var != null) {
                oz7Var.y(z);
            }
            rn rnVar = this.s;
            if (rnVar != null) {
                rnVar.setMulDel(z);
            }
            rn rnVar2 = this.p;
            if (rnVar2 != null) {
                rnVar2.setMulDel(z);
            }
            py7 py7Var = this.c;
            if (py7Var != null) {
                py7Var.setMulDel(z);
            }
        }
    }

    public final void E0() {
        uv7 uv7Var;
        qn8 qn8Var;
        qn8 qn8Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || (uv7Var = this.B) == null || uv7Var.b0 || uv7Var.c0 == 2) {
            return;
        }
        ArrayList G = uv7Var.G();
        ArrayList e2 = this.B.e();
        if (!lh7.e(G) && !lh7.e(e2)) {
            StringBuilder sb = new StringBuilder();
            Iterator it = e2.iterator();
            while (it.hasNext()) {
                qn8 qn8Var3 = (qn8) it.next();
                if (qn8Var3 != null && qn8Var3.l1() != null) {
                    sb.append(qn8Var3.l1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator it2 = e2.iterator();
            while (it2.hasNext()) {
                qn8 qn8Var4 = (qn8) it2.next();
                if (qn8Var4 != null) {
                    qn8Var4.c1 = qn8Var4.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator it3 = e2.iterator();
            while (it3.hasNext()) {
                qn8 qn8Var5 = (qn8) it3.next();
                if (qn8Var5.getAdvertAppInfo() != null) {
                    int n = qn8Var5.getAdvertAppInfo().n();
                    if (n != 0) {
                        yf8.j(qn8Var5, n);
                        if (n != 28 && n != 31) {
                            qn8Var5.getAdvertAppInfo().c = -1001;
                        }
                    }
                    sparseArray.put(qn8Var5.getPosition(), qn8Var5);
                }
            }
            e2.clear();
            HashMap hashMap = new HashMap();
            for (int i = 0; i < sparseArray.size(); i++) {
                qn8 qn8Var6 = (qn8) sparseArray.valueAt(i);
                if (qn8Var6 != null && (qn8Var2 = (qn8) hashMap.put(qn8Var6.k1(), qn8Var6)) != null) {
                    yf8.j(qn8Var2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (qn8Var = (qn8) entry.getValue()) != null) {
                    sparseArray.put(qn8Var.getPosition(), qn8Var);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                lh7.a(arrayList, Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList);
            int i3 = 1;
            for (int i4 = 0; i4 < lh7.i(arrayList); i4++) {
                qn8 qn8Var7 = (qn8) sparseArray.get(((Integer) lh7.d(arrayList, i4)).intValue());
                if (this.B.l() != null) {
                    qn8Var7.W0 = this.B.l().getId();
                }
                if (this.B.P() != null) {
                    qn8Var7.Z0 = eh.g(this.B.P().getId(), 0L);
                }
                uv7 uv7Var2 = this.B;
                if (uv7Var2 != null && uv7Var2.y() != null) {
                    qn8Var7.a1 = this.B.y().a();
                }
                l(qn8Var7);
                int position = qn8Var7.getPosition() + this.B.a0;
                if (position >= lh7.i(G)) {
                    qn8Var7.c1 = position;
                    yf8.k(qn8Var7, 2, position, lh7.i(G));
                    return;
                }
                if (!this.H) {
                    position--;
                    qn8Var7.c1 = position;
                }
                if (position < 0) {
                    yf8.j(qn8Var7, 23);
                } else {
                    qn8Var7.d1 = i3;
                    lh7.b(G, qn8Var7, position);
                    i3++;
                    PbFragment pbFragment = this.a;
                    if (pbFragment != null && pbFragment.getPageContext() != null && this.a.getPageContext().getContext() != null) {
                        TiebaStatic.eventStat(this.a.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", qn8Var7.getAdvertAppInfo().p);
                    }
                }
            }
        }
    }

    public final int F(uv7 uv7Var, ArrayList arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048586, this, uv7Var, arrayList, z)) == null) {
            if (uv7Var != null && !ListUtils.isEmpty(uv7Var.G()) && arrayList != null && arrayList.size() > 0) {
                arrayList.size();
                if (!z) {
                    return 0;
                }
                if (uv7Var.G().get(0) == null || ((PostData) uv7Var.G().get(0)).D() != 1) {
                    return -1;
                }
                return 1;
            } else if (uv7Var == null || !uv7Var.x0()) {
                return -1;
            } else {
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final void V(uv7 uv7Var, ArrayList arrayList, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048603, this, uv7Var, arrayList, i) == null) {
            hw7 hw7Var = new hw7(hw7.i);
            ThreadData P = uv7Var.P();
            if (P != null) {
                P.getReply_num();
            }
            hw7Var.d = this.a.k6();
            hw7Var.c = uv7Var.g;
            uv7Var.c();
            hw7Var.e = uv7Var.k0();
            hw7Var.g = uv7Var.f;
            if (P != null && P.isQuestionThread()) {
                z = true;
            } else {
                z = false;
            }
            hw7Var.h = z;
            ListUtils.add(arrayList, i, hw7Var);
            if (uv7Var.M() == 4) {
                ListUtils.add(arrayList, i + 1, new gw7());
            }
        }
    }

    public final ArrayList I(List list, List list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, list, list2)) == null) {
            ArrayList arrayList = new ArrayList(list.size() + list2.size() + 2);
            arrayList.addAll(list);
            aw7 aw7Var = new aw7();
            PbListView Z0 = this.a.O5().Z0();
            if (Z0 != null && Z0.n()) {
                aw7Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e0d);
                aw7Var.b = true;
            } else {
                aw7Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0a0c);
                aw7Var.b = false;
            }
            arrayList.add(aw7Var);
            o36 o36Var = new o36();
            o36Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fc5);
            o36Var.needTopMargin = false;
            arrayList.add(o36Var);
            arrayList.addAll(list2);
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public final eo Q(ArrayList arrayList, int i) {
        InterceptResult invokeLI;
        uv7 uv7Var;
        pn8 pn8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048598, this, arrayList, i)) == null) {
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && i > 0 && (uv7Var = this.B) != null && uv7Var.t0()) {
                String d2 = jv6.e().d("pb_banner");
                if (this.f0 == null && dv6.m().v(d2)) {
                    ThreadData threadData = new ThreadData();
                    this.f0 = threadData;
                    threadData.funAdData = new pn8();
                    uv7 uv7Var2 = this.B;
                    if (uv7Var2 != null) {
                        this.f0.funAdData.m(uv7Var2.m());
                        this.f0.funAdData.r(this.B.R());
                    }
                }
                ThreadData threadData2 = this.f0;
                if (threadData2 != null && (pn8Var = threadData2.funAdData) != null) {
                    pn8Var.j(1);
                    ip5.k().q(true);
                    ListUtils.add(arrayList, i, this.f0);
                }
            }
            return this.f0;
        }
        return (eo) invokeLI.objValue;
    }

    public final int u(uv7 uv7Var, ArrayList arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048637, this, uv7Var, arrayList)) == null) {
            if (!this.J && uv7Var != null && !ListUtils.isEmpty(uv7Var.G()) && arrayList != null && arrayList.size() > 0) {
                if (this.a.K() != null && this.a.K().B1()) {
                    return -1;
                }
                if (this.a.O5() != null && this.a.O5().R0()) {
                    return -1;
                }
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    if (i < size) {
                        eo eoVar = (eo) arrayList.get(i);
                        if (eoVar instanceof PostData) {
                            PostData postData = (PostData) eoVar;
                            if (postData.D() == 1 && postData.N == 0) {
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
                    if (uv7Var.x0()) {
                        return 0;
                    }
                    return -1;
                }
                return i + 1;
            } else if (uv7Var != null && uv7Var.x0() && this.H) {
                return 0;
            } else {
                return -1;
            }
        }
        return invokeLL.intValue;
    }

    public View J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            py7 py7Var = this.c;
            if (py7Var != null && py7Var.I() != null) {
                if (this.c.I().A != null && this.c.I().A.isShown()) {
                    return this.c.I().A;
                }
                return this.c.I().z;
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void g0() {
        PostData postData;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && this.B != null && (postData = this.P) != null && postData.U() != null && this.c.I() != null) {
            String R = this.B.R();
            String m = this.B.m();
            if (this.B.P() != null) {
                i = this.B.P().getThreadType();
            } else {
                i = 0;
            }
            oc5.a().c(R, m, this.P.U(), this.c.I().t, i);
        }
    }

    public void L(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, pbFragment, bdTypeListView) == null) {
            py7 py7Var = new py7(pbFragment, PostData.K0);
            this.c = py7Var;
            py7Var.W(pbFragment);
            this.d = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, iw7.f);
            this.e = new PbFirstFloorEnterForumAdapter(pbFragment, wv7.i);
            this.f = new PbFirstFloorItemAdapter(pbFragment.getContext(), xv7.c);
            this.g = new g08(pbFragment, pv7.c);
            this.h = new oz7(pbFragment, hw7.i);
            this.i = new cz7(pbFragment, cw7.c);
            this.j = new oz7(pbFragment, hw7.j);
            jy7 jy7Var = new jy7(pbFragment, PostData.L0);
            this.k = jy7Var;
            jy7Var.v0(pbFragment);
            sz7 sz7Var = new sz7(pbFragment, PostData.M0);
            this.l = sz7Var;
            sz7Var.s0(pbFragment);
            this.o = le8.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.x);
            this.p = le8.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.z);
            this.q = ev6.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.F);
            this.r = ev6.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.G);
            this.s = ev6.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.I);
            this.v = new jz7(pbFragment, ew7.a1);
            this.t = new kz7(pbFragment, iz7.X0);
            this.u = new mz7(pbFragment, ft4.d1);
            this.w = new PbReplyLoadMoreAdapter(pbFragment, PostData.S0);
            this.m = new v28(pbFragment, w28.a);
            this.n = new l36(pbFragment.getPageContext());
            this.y = new gy7(pbFragment, rr4.e);
            this.z = new wy7(pbFragment, pbFragment.getUniqueId());
            kx7 kx7Var = new kx7(pbFragment, pbFragment.getUniqueId(), this.b);
            this.A = kx7Var;
            this.Z.addAll(kx7Var.a());
            this.Z.add(this.c);
            this.Z.add(this.d);
            this.Z.add(this.e);
            this.Z.add(this.f);
            this.Z.add(this.g);
            this.Z.add(this.k);
            this.Z.add(this.l);
            this.Z.add(this.h);
            this.Z.add(this.i);
            this.Z.add(this.j);
            this.Z.add(this.o);
            this.Z.add(this.p);
            this.Z.add(this.q);
            this.Z.add(this.r);
            this.Z.add(this.s);
            this.Z.add(this.v);
            this.Z.add(this.t);
            this.Z.add(this.u);
            this.Z.add(this.m);
            this.Z.add(this.w);
            this.Z.add(this.n);
            this.Z.add(this.y);
            this.Z.add(this.z);
            this.Z.add(new PbPrivateTitleAdapter(pbFragment));
            this.i0.setPriority(1);
            this.i0.setSelfListener(true);
            pbFragment.registerListener(this.i0);
            pbFragment.registerListener(this.h0);
            m();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new gn8(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
            CustomMessage customMessage = new CustomMessage(2004015);
            customMessage.setTag(pbFragment.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            bdTypeListView.a(this.Z);
        }
    }

    public final void M(uv7 uv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, uv7Var) == null) {
            this.c.r(uv7Var);
            this.c.setFromCDN(this.E);
            this.c.l(this.N);
            this.c.c(this.G);
            this.c.e(this.S);
            this.c.k(this.R);
            this.c.n(this.U);
            this.c.d(this.X);
            this.c.T(this.V);
            this.c.V(this.W);
            this.f.w(this.V);
            this.k.r(uv7Var);
            this.k.setFromCDN(this.E);
            this.k.o(this.O);
            this.k.c(this.G);
            this.k.e(this.S);
            this.k.k(this.R);
            this.k.n(this.U);
            this.k.d(this.X);
            this.k.u0(this.W);
            this.l.r(uv7Var);
            this.l.setFromCDN(this.E);
            this.l.o(this.O);
            this.l.c(this.G);
            this.l.e(this.S);
            this.l.k(this.R);
            this.l.n(this.U);
            this.l.d(this.X);
            this.l.r0(this.W);
            this.d.G(this.S);
            this.w.w(this.S);
            this.m.w(this.k0);
            rn rnVar = this.p;
            if (rnVar != null && (rnVar instanceof he8)) {
                ((he8) rnVar).setIsFromCDN(this.E);
            }
            Iterator it = this.x.iterator();
            while (it.hasNext()) {
                jx7 jx7Var = (jx7) it.next();
                if (jx7Var != null) {
                    jx7Var.r(uv7Var);
                    jx7Var.setFromCDN(this.E);
                    jx7Var.o(this.O);
                    jx7Var.l(this.N);
                    jx7Var.c(this.G);
                    jx7Var.f(this.H);
                    jx7Var.q(this.M);
                    jx7Var.e(this.S);
                    jx7Var.k(this.R);
                    jx7Var.n(this.U);
                    jx7Var.d(this.X);
                }
            }
            this.h.e(this.S);
            this.h.z(this.Y);
            this.i.e(this.T);
            this.j.e(this.S);
            this.h.r(uv7Var);
            this.g.r(uv7Var);
            this.j.r(uv7Var);
            this.t.r(uv7Var);
            this.u.r(uv7Var);
            this.y.y(uv7Var);
            this.y.x(this.a.q1);
            this.z.w(uv7Var);
            this.A.f(uv7Var);
        }
    }

    public final eo N(ArrayList arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048595, this, arrayList, i)) == null) {
            if (this.B == null) {
                return null;
            }
            qn8 l1 = this.a.K().l1();
            if (l1 == null) {
                l1 = this.B.z();
            }
            if (l1 == null) {
                return null;
            }
            AdvertAppInfo.ILegoAdvert n1 = l1.n1();
            if (n1 != null) {
                n1.setAdvertAppInfo(l1.getAdvertAppInfo());
            }
            int n = l1.getAdvertAppInfo().n();
            if (n != 0) {
                yf8.j(l1, n);
                if (n != 28 && n != 31) {
                    l1.getAdvertAppInfo().c = -1001;
                }
                return null;
            }
            if (this.B.l() != null) {
                l1.W0 = this.B.l().getId();
            }
            if (this.B.P() != null) {
                l1.Z0 = eh.g(this.B.P().getId(), 0L);
            }
            uv7 uv7Var = this.B;
            if (uv7Var != null && uv7Var.y() != null) {
                l1.a1 = this.B.y().a();
            }
            l(l1);
            if (i < 0) {
                return null;
            }
            l1.d1 = 1;
            ip5.k().q(true);
            lh7.b(arrayList, l1, i);
            return l1;
        }
        return (eo) invokeLI.objValue;
    }

    public final boolean O(uv7 uv7Var, ArrayList arrayList, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{uv7Var, arrayList, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            ArrayList arrayList2 = new ArrayList();
            if (!ListUtils.isEmpty(uv7Var.f()) && uv7Var.f().size() > 2) {
                int min = Math.min(uv7Var.f().size(), 7);
                for (int i6 = 0; i6 < min; i6++) {
                    rr4 rr4Var = (rr4) uv7Var.f().get(i6);
                    if (!z2 && i6 == 0) {
                        rr4Var.n(true);
                    }
                    if (rr4Var.getThreadVideoInfo() == null) {
                        if (i6 == min - 1) {
                            rr4Var.s(true);
                        }
                    } else if (i6 == min - 2) {
                        rr4Var.s(true);
                    } else if (i6 == min - 1) {
                        rr4Var.r(true);
                    }
                    arrayList2.add(rr4Var);
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

    public final eo P(uv7 uv7Var, ArrayList arrayList, int i) {
        InterceptResult invokeLLI;
        pv7 pv7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048597, this, uv7Var, arrayList, i)) == null) {
            if (i >= 0 && uv7Var != null && uv7Var.k && (pv7Var = uv7Var.l) != null) {
                ListUtils.add(arrayList, i, pv7Var);
                return pv7Var;
            }
            return null;
        }
        return (eo) invokeLLI.objValue;
    }

    public final void X(PostData postData, ArrayList arrayList, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048605, this, postData, arrayList, i) == null) {
            postData.c1(true);
            arrayList.add(i, postData);
        }
    }

    public final void R(int i, int i2, int i3, ArrayList arrayList) {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), arrayList}) == null) && !ListUtils.isEmpty(arrayList) && i >= 0 && i2 >= 1) {
            ListIterator listIterator = arrayList.listIterator();
            int i4 = 0;
            int i5 = 0;
            int i6 = 1;
            while (true) {
                str = "";
                if (!listIterator.hasNext()) {
                    break;
                }
                if (i4 == i || (i4 > i && (i4 - i) % i2 == 0)) {
                    if (i5 >= i3) {
                        break;
                    }
                    if (i5 < this.g0.size()) {
                        listIterator.add(this.g0.get(i5));
                    } else {
                        PostData postData = new PostData();
                        pn8 pn8Var = new pn8();
                        uv7 uv7Var = this.B;
                        if (uv7Var == null) {
                            str3 = "";
                        } else {
                            str3 = uv7Var.m();
                        }
                        pn8Var.m(str3);
                        uv7 uv7Var2 = this.B;
                        if (uv7Var2 != null) {
                            str = uv7Var2.R();
                        }
                        pn8Var.r(str);
                        pn8Var.n(true);
                        postData.u0 = pn8Var;
                        pn8Var.j(i6);
                        listIterator.add(postData);
                        i6++;
                        this.g0.add(postData);
                    }
                    i5++;
                }
                listIterator.next();
                i4++;
            }
            if (i4 == i && i5 < i3) {
                PostData postData2 = new PostData();
                pn8 pn8Var2 = new pn8();
                uv7 uv7Var3 = this.B;
                if (uv7Var3 == null) {
                    str2 = "";
                } else {
                    str2 = uv7Var3.m();
                }
                pn8Var2.m(str2);
                uv7 uv7Var4 = this.B;
                if (uv7Var4 != null) {
                    str = uv7Var4.R();
                }
                pn8Var2.r(str);
                pn8Var2.n(true);
                postData2.u0 = pn8Var2;
                pn8Var2.j(1);
                listIterator.add(postData2);
                this.g0.add(postData2);
            }
        }
    }

    public final eo T(uv7 uv7Var, PostData postData, ArrayList arrayList, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048601, this, uv7Var, postData, arrayList, i)) == null) {
            xv7 xv7Var = null;
            if (uv7Var.l() != null && !StringUtils.isNull(uv7Var.l().getName()) && TextUtils.equals(uv7Var.l().getName(), this.a.K().r1()) && this.a.K().x1()) {
                return null;
            }
            if (postData != null) {
                if (postData.j0 != null) {
                    xv7Var = new xv7(postData.j0);
                }
            } else {
                PostData postData2 = this.P;
                if (postData2 != null && postData2.j0 != null) {
                    xv7Var = new xv7(this.P.j0);
                }
            }
            if (xv7Var != null) {
                xv7Var.b = this.a.K().m2();
                ListUtils.add(arrayList, i + 1, xv7Var);
            }
            return xv7Var;
        }
        return (eo) invokeLLLI.objValue;
    }

    public final xy7 U(ArrayList arrayList, eo eoVar, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048602, this, arrayList, eoVar, i, i2)) == null) {
            xy7 B = this.B.B();
            if (B != null) {
                if (eoVar != null) {
                    if (i2 < 0 && eoVar.getType() != AdvertAppInfo.z) {
                        i2 = i + 2;
                    } else if (eoVar.getType() != AdvertAppInfo.z) {
                        i2++;
                    } else {
                        i2 = -1;
                    }
                }
                if (i2 > 0 && (B instanceof xy7)) {
                    ListUtils.add(arrayList, i2, B);
                    return B;
                }
                return null;
            }
            return null;
        }
        return (xy7) invokeLLII.objValue;
    }

    public final eo W(ArrayList arrayList, int i) {
        InterceptResult invokeLI;
        PbModel K;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048604, this, arrayList, i)) == null) {
            if (i < 0 || (K = this.a.K()) == null || TextUtils.isEmpty(K.W1())) {
                return null;
            }
            qn8 qn8Var = new qn8();
            l(qn8Var);
            ListUtils.add(arrayList, i + 1, qn8Var);
            return qn8Var;
        }
        return (eo) invokeLI.objValue;
    }

    public void c0(boolean z, int i) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && (pbFragment = this.a) != null && pbFragment.O5() != null) {
            this.a.O5().Z1(z, i);
        }
    }

    public void b0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        py7 py7Var = this.c;
                        if (py7Var != null) {
                            py7Var.Q();
                        }
                        rn rnVar = this.p;
                        if (rnVar instanceof ce8) {
                            ((ce8) rnVar).onDestroy();
                        }
                        rn rnVar2 = this.q;
                        if (rnVar2 instanceof ce8) {
                            ((ce8) rnVar2).onDestroy();
                        }
                        rn rnVar3 = this.s;
                        if (rnVar3 instanceof ce8) {
                            ((ce8) rnVar3).onDestroy();
                        }
                        ky7.a().d();
                        return;
                    }
                    return;
                }
                py7 py7Var2 = this.c;
                if (py7Var2 != null) {
                    py7Var2.R();
                }
                rn rnVar4 = this.p;
                if (rnVar4 instanceof ce8) {
                    ((ce8) rnVar4).onResume();
                }
                rn rnVar5 = this.q;
                if (rnVar5 instanceof ce8) {
                    ((ce8) rnVar5).onResume();
                }
                rn rnVar6 = this.s;
                if (rnVar6 instanceof ce8) {
                    ((ce8) rnVar6).onResume();
                }
                h0(false);
                g0();
                return;
            }
            py7 py7Var3 = this.c;
            if (py7Var3 != null) {
                py7Var3.P();
            }
            rn rnVar7 = this.p;
            if (rnVar7 instanceof ce8) {
                ((ce8) rnVar7).onPause();
            }
            rn rnVar8 = this.q;
            if (rnVar8 instanceof ce8) {
                ((ce8) rnVar8).onPause();
            }
            rn rnVar9 = this.s;
            if (rnVar9 instanceof ce8) {
                ((ce8) rnVar9).onPause();
            }
            ky7.a().j(this.a.P());
            oc5.a().d();
        }
    }

    public final void l(qn8 qn8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048619, this, qn8Var) == null) && qn8Var != null && this.B != null && qn8Var.getAdvertAppInfo() != null) {
            qn8Var.getAdvertAppInfo().i = new fr4();
            if (this.B.y() != null) {
                qn8Var.getAdvertAppInfo().i.b = this.B.y().a();
            }
            qn8Var.getAdvertAppInfo().i.a = qn8Var.m1();
            if (this.B.l() != null && (l = this.B.l()) != null) {
                qn8Var.getAdvertAppInfo().i.c = l.getId();
                qn8Var.getAdvertAppInfo().i.d = l.getFirst_class();
                qn8Var.getAdvertAppInfo().i.e = l.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                qn8Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            qn8Var.getAdvertAppInfo().i.g = qn8Var.getAdvertAppInfo().g;
            qn8Var.getAdvertAppInfo().i.h = false;
        }
    }

    public final List v(uv7 uv7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, uv7Var)) == null) {
            if (uv7Var == null || uv7Var.U() == null || ListUtils.isEmpty(uv7Var.U().a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List list = uv7Var.U().a;
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            int min = Math.min(2, list.size());
            for (int i = 0; i < min; i++) {
                PostData postData = (PostData) list.get(i);
                if (postData != null) {
                    postData.b0 = true;
                    postData.O = true;
                    arrayList.add(postData);
                }
            }
            if (ListUtils.getCount(uv7Var.U().b) > 2) {
                eo eoVar = (eo) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (eoVar instanceof PostData) {
                    ((PostData) eoVar).O = false;
                }
                arrayList.add(new w28());
            } else {
                eo eoVar2 = (eo) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (eoVar2 instanceof PostData) {
                    ((PostData) eoVar2).O = true;
                }
            }
            hw7 hw7Var = new hw7(hw7.j);
            hw7Var.a = uv7Var.U().c;
            arrayList.add(0, hw7Var);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void f0(boolean z, boolean z2, int i, List list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), list}) == null) && !z && !z2) {
            if ((this.K || this.J) && i != -1 && !ListUtils.isEmpty(list) && !this.L) {
                this.b0 = new e(this, list);
                hh.a().post(this.b0);
            }
        }
    }

    public void h0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048615, this, z) == null) && this.a.O5() != null && this.a.P() != null && this.a.P().i1() != null) {
            ky7.a().g(this.a.P().i1().D2(), this.h.v(), this.a.O5().b1(), this.a.P().getPageStayDurationItem(), z, this.A.b(), this.a.getListView());
        }
    }

    public void i0(uv7 uv7Var, boolean z) {
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
        xy7 xy7Var;
        List list;
        int i4;
        boolean z10;
        boolean z11;
        boolean z12;
        eo eoVar;
        int i5;
        boolean z13;
        PostData postData3;
        PostData postData4;
        PostData postData5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048616, this, uv7Var, z) != null) || uv7Var == null) {
            return;
        }
        this.B = uv7Var;
        if (!UbsABTestHelper.isPbCommentFunAdABTest()) {
            E0();
        }
        if (this.C == null) {
            this.C = new ArrayList();
        }
        this.C.clear();
        uv7 uv7Var2 = this.B;
        if (uv7Var2 != null && uv7Var2.G() != null && this.B.G().size() > 0) {
            this.C.addAll(this.B.G());
        }
        if (uv7Var.P() != null && uv7Var.P().getAuthor() != null) {
            this.O = uv7Var.P().getAuthor().getUserId();
        }
        if (this.c == null) {
            return;
        }
        M(uv7Var);
        ArrayList arrayList = new ArrayList(uv7Var.G());
        PostData p = p(arrayList);
        if (this.B.P().isQuestionThread()) {
            postData = q(uv7Var);
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
        if (!kv6.f() && UbsABTestHelper.isPbCommentFunAdABTest() && this.B.t0()) {
            K(arrayList, Boolean.valueOf(z2));
        }
        if (p != null) {
            this.P = p;
        }
        if (!this.H && p != null) {
            arrayList.remove(p);
            if (uv7Var.x0() && p.X() != null) {
                p.W0(null);
            }
            z2 = true;
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z2 && uv7Var.j() != null) {
            PostData j = uv7Var.j();
            if (!this.H && uv7Var.x0() && j.X() != null) {
                j.W0(null);
            }
            if (!this.H && (postData5 = this.P) != null && j.h0 == null) {
                uv7Var.G0(postData5);
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
            if (uv7Var.G().size() > 0 && (postData4 = (PostData) uv7Var.G().get(0)) != null && postData4.D() == 1 && !ListUtils.isEmpty(arrayList)) {
                arrayList.remove(0);
            }
        } else {
            int C = C(this.B, arrayList, this.H);
            if (C >= 0) {
                ListUtils.add(arrayList, C, this.B.D());
            }
        }
        int D = D(this.B, arrayList, this.H);
        if (D >= 0) {
            ListUtils.add(arrayList, D, this.B.E());
        }
        qm8.f(arrayList, 1);
        int A = A(uv7Var, arrayList);
        if (A >= 0) {
            V(uv7Var, arrayList, A);
            z5 = true;
        } else {
            z5 = false;
        }
        int G = G(uv7Var, arrayList);
        if (G >= 0) {
            cw7 cw7Var = new cw7(cw7.c);
            cw7Var.b(true);
            ListUtils.add(arrayList, G, cw7Var);
        }
        int u = u(uv7Var, arrayList);
        List v = v(uv7Var);
        if (!ListUtils.isEmpty(v) && u >= 0) {
            eo eoVar2 = (eo) ListUtils.getItem(arrayList, u);
            if (eoVar2 instanceof PostData) {
                ((PostData) eoVar2).Q = true;
            }
            ListUtils.addAll(arrayList, u, v);
            z5 = true;
        }
        if (z2) {
            i = F(uv7Var, arrayList, this.H);
        } else {
            i = -1;
        }
        if (i >= 0 && uv7Var.T() != null) {
            PostData Y = uv7Var.Y();
            ThreadData c2 = uv7Var.T().c();
            if (Y != null && Y.k0() != null && c2 != null && c2.getCustomFigure() == null) {
                VirtualImageCustomFigure k0 = Y.k0();
                VirtualImageCustomState l0 = Y.l0();
                c2.setCustomFigure(k0);
                c2.setCustomState(l0);
            }
            ListUtils.add(arrayList, i, uv7Var.T());
            z6 = true;
            z7 = true;
        } else {
            if (postData2 != null) {
                postData2.P = true;
            }
            z6 = z5;
            z7 = false;
        }
        if ((this.B.P().isQuestionThread() && postData != null) || (this.B.P().isQuestionThread() && this.Q != null)) {
            if (postData == null && (postData3 = this.Q) != null) {
                postData = postData3;
            }
            if (!arrayList.contains(postData)) {
                i++;
                X(postData, arrayList, i);
            }
        }
        if (T(uv7Var, postData2, arrayList, i) != null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z8) {
            i++;
        }
        if (!z8 && S(uv7Var, arrayList, i) != null) {
            i++;
        }
        if (P(uv7Var, arrayList, i) != null) {
            i++;
        }
        if (z2) {
            eo W = W(arrayList, i);
            if (W != null) {
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
                eoVar = N(arrayList, i5);
                if (eoVar != null) {
                    z12 = true;
                } else {
                    z12 = false;
                }
            } else {
                z12 = z11;
                eoVar = W;
                i5 = -1;
            }
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() == 1) {
                z13 = false;
            } else {
                z13 = true;
            }
            if (z13 && this.B.t0()) {
                this.e0 = i5;
                if (Q(arrayList, i5) != null) {
                    this.e0 = -1;
                    i++;
                }
            }
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && z13) {
                z9 = z12;
                i2 = i;
                xy7Var = null;
            } else {
                xy7 U = U(arrayList, eoVar, i, i5);
                if (U != null) {
                    if (!z12) {
                        xy7Var = U;
                        i2 = i;
                        z9 = true;
                    } else if (i5 > 0) {
                        i5++;
                    } else {
                        i++;
                    }
                }
                xy7Var = U;
                z9 = z12;
                i2 = i;
            }
            i3 = i5;
        } else {
            i2 = i;
            z9 = false;
            i3 = -1;
            xy7Var = null;
        }
        if (z2) {
            if (xy7Var != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            list = v;
            int i6 = i2;
            i4 = u;
            boolean O = O(uv7Var, arrayList, z9, z10, i3, i6, u, A);
            if (xy7Var != null) {
                xy7Var.n = O;
            }
        } else {
            list = v;
            i4 = u;
        }
        this.c.U(!z6);
        boolean D0 = D0(postData2);
        if (this.I && !D0) {
            arrayList.remove(postData2);
            this.I = false;
        }
        if (uv7Var.T() != null) {
            uv7Var.T().j(!z7);
        }
        if (this.b != null) {
            this.D = arrayList;
            List S = uv7Var.S();
            if (!ListUtils.isEmpty(S)) {
                this.b.setData(I(arrayList, S));
            } else {
                this.b.setData(this.D);
            }
        }
        f0(D0, z, i4, list);
        if (r(postData2, arrayList, z4)) {
            List S2 = uv7Var.S();
            if (!ListUtils.isEmpty(S2)) {
                this.b.setData(I(arrayList, S2));
            } else {
                this.b.setData(arrayList);
            }
        }
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            if (this.a == null) {
                return false;
            }
            this.m0 = new ArrayList();
            ArrayList g = qm8.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                dh7 b2 = ii7.d().b(this.a.getPageContext(), (BdUniqueId) g.get(i), 2);
                if (b2 != null) {
                    this.Z.add(b2);
                    this.m0.add(b2);
                }
            }
            if (!ListUtils.isEmpty(this.m0)) {
                this.b.a(this.m0);
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean r(PostData postData, ArrayList arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048631, this, postData, arrayList, z)) == null) {
            if (postData == null) {
                PostData postData2 = this.P;
                if (postData2 != null && !this.J) {
                    ListUtils.add(arrayList, 0, postData2);
                } else {
                    PostData postData3 = new PostData();
                    postData3.E0(1);
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
