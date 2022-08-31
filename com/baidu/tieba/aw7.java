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
/* loaded from: classes3.dex */
public class aw7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public av7 A;
    public kt7 B;
    public ArrayList<PostData> C;
    public ArrayList<pn> D;
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
    public mu7 W;
    public View.OnLongClickListener X;
    public SortSwitchButton.f Y;
    public final List<cn> Z;
    public PbFragment a;
    public final List<cn> a0;
    public BdTypeListView b;
    public Runnable b0;
    public kw7 c;
    public int c0;
    public PbFirstFloorCommentAndPraiseAdapter d;
    public int d0;
    public PbFirstFloorEnterForumAdapter e;
    public int e0;
    public PbFirstFloorItemAdapter f;
    public ThreadData f0;
    public ay7 g;
    public List<PostData> g0;
    public ix7 h;
    public final CustomMessageListener h0;
    public xw7 i;
    public CustomMessageListener i0;
    public ix7 j;
    public final CustomMessageListener j0;
    public ew7 k;
    public final View.OnClickListener k0;
    public mx7 l;
    public CustomMessageListener l0;
    public o08 m;
    public List<cn> m0;
    public b16 n;
    public cn o;
    public cn p;
    public cn q;
    public cn r;
    public cn s;
    public fx7 t;
    public gx7 u;
    public ex7 v;
    public PbReplyLoadMoreAdapter w;
    public ArrayList<zu7> x;
    public bw7 y;
    public rw7 z;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aw7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(aw7 aw7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aw7Var, Integer.valueOf(i)};
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
            this.a = aw7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof fl8)) {
                return;
            }
            fl8 fl8Var = (fl8) customResponsedMessage.getData();
            if (this.a.f0 == null || this.a.f0.funAdData != fl8Var) {
                return;
            }
            this.a.f0.funAdData.p(true);
            this.a.b.setData(this.a.D);
            this.a.a0();
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aw7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(aw7 aw7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aw7Var, Integer.valueOf(i)};
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
            this.a = aw7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof wk8)) {
                AbsDelegateAdapterList a = ((wk8) customResponsedMessage.getData()).a();
                Iterator<cn<?, ?>> it = a.iterator();
                while (it.hasNext()) {
                    cn<?, ?> next = it.next();
                    if (next instanceof gw7) {
                        ((gw7) next).t(this.a.a);
                        if (next instanceof zu7) {
                            this.a.x.add((zu7) next);
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

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aw7 a;

        /* loaded from: classes3.dex */
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
        public c(aw7 aw7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aw7Var, Integer.valueOf(i)};
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
            this.a = aw7Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.B == null || i9.c(this.a.a.getActivity()).isScroll() || customResponsedMessage.getCmd() != 2001118 || !(customResponsedMessage instanceof DownloadMessage) || (data = ((DownloadMessage) customResponsedMessage).getData()) == null || data.size() == 0) {
                return;
            }
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
                sg.a().postDelayed(new a(this), TimeUnit.SECONDS.toMillis(2L));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aw7 a;

        public d(aw7 aw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aw7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.a == null || this.a.B == null || this.a.B.T() == null) {
                return;
            }
            this.a.a.S5().T0().v();
            TiebaStatic.log(new StatisticItem("c12040"));
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ aw7 b;

        public e(aw7 aw7Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aw7Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = aw7Var;
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

    /* loaded from: classes3.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aw7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(aw7 aw7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aw7Var, Integer.valueOf(i)};
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
            this.a = aw7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.m0)) {
                this.a.n();
                aw7 aw7Var = this.a;
                aw7Var.i0(aw7Var.B, false);
            }
        }
    }

    public aw7(PbFragment pbFragment, BdTypeListView bdTypeListView) {
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
        this.C = new ArrayList<>();
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
        this.N = ri.k(pbFragment.getPageContext().getPageActivity());
        this.a = pbFragment;
        this.b = bdTypeListView;
        L(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.j0);
        this.d0 = ri.i(this.a.getContext()) / 3;
    }

    public final int A(kt7 kt7Var, ArrayList<pn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, kt7Var, arrayList)) == null) {
            if (kt7Var == null || ListUtils.isEmpty(kt7Var.F()) || ListUtils.isEmpty(arrayList) || ((PostData) ListUtils.getItem(kt7Var.F(), 0)) == null) {
                return 0;
            }
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    z = false;
                    i = 0;
                    break;
                }
                pn pnVar = arrayList.get(i);
                if (pnVar instanceof PostData) {
                    PostData postData = (PostData) pnVar;
                    if (postData.B() == 1 && postData.M == 0) {
                        z = true;
                        break;
                    }
                }
                i++;
            }
            if (z) {
                return i + 1;
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    public void A0(mu7 mu7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mu7Var) == null) {
            this.W = mu7Var;
        }
    }

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BdTypeListView bdTypeListView = this.b;
            if (bdTypeListView == null || bdTypeListView.getData() == null) {
                return -1;
            }
            for (int i = 0; i < this.b.getData().size(); i++) {
                pn pnVar = this.b.getData().get(i);
                if (pnVar != null && pnVar.getType() == xt7.i) {
                    return i;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void B0() {
        xw7 xw7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (xw7Var = this.i) == null) {
            return;
        }
        xw7Var.x(2);
    }

    public int C(kt7 kt7Var, ArrayList<pn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048580, this, kt7Var, arrayList, z)) == null) {
            if (kt7Var == null || kt7Var.F() == null || kt7Var.D() == null || kt7Var.F().size() == 0 || kt7Var.O() == null || arrayList == null || !kt7Var.D().i1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                return (kt7Var.F().get(0) == null || kt7Var.F().get(0).B() != 1) ? -1 : 1;
            } else if (size == 0) {
                return 0;
            } else {
                return (kt7Var.y() == null || kt7Var.y().a() != kt7Var.y().h()) ? -1 : 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final boolean C0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, postData)) == null) ? (this.a.K() == null || postData == null || postData.K() == null || !postData.K().equals(this.a.K().s2())) ? false : true : invokeL.booleanValue;
    }

    public int D(kt7 kt7Var, ArrayList<pn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048582, this, kt7Var, arrayList, z)) == null) {
            if (kt7Var == null || kt7Var.F() == null || kt7Var.E() == null || kt7Var.F().size() == 0 || kt7Var.O() == null || arrayList == null || !kt7Var.E().i1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                return (kt7Var.F().get(0) == null || kt7Var.F().get(0).B() != 1) ? -1 : 1;
            } else if (size == 0) {
                return 0;
            } else {
                return (kt7Var.y() == null || kt7Var.y().a() != kt7Var.y().h()) ? -1 : 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final void D0() {
        kt7 kt7Var;
        gl8 gl8Var;
        gl8 gl8Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (kt7Var = this.B) == null || kt7Var.b0 || kt7Var.c0 == 2) {
            return;
        }
        ArrayList<PostData> F = kt7Var.F();
        ArrayList<gl8> e2 = this.B.e();
        if (gf7.e(F) || gf7.e(e2)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<gl8> it = e2.iterator();
        while (it.hasNext()) {
            gl8 next = it.next();
            if (next != null && next.j1() != null) {
                sb.append(next.j1());
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        Iterator<gl8> it2 = e2.iterator();
        while (it2.hasNext()) {
            gl8 next2 = it2.next();
            if (next2 != null) {
                next2.b1 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<gl8> it3 = e2.iterator();
        while (it3.hasNext()) {
            gl8 next3 = it3.next();
            if (next3.getAdvertAppInfo() != null) {
                int n = next3.getAdvertAppInfo().n();
                if (n != 0) {
                    rd8.j(next3, n);
                    if (n != 28 && n != 31) {
                        next3.getAdvertAppInfo().c = -1001;
                    }
                }
                sparseArray.put(next3.getPosition(), next3);
            }
        }
        e2.clear();
        HashMap hashMap = new HashMap();
        for (int i = 0; i < sparseArray.size(); i++) {
            gl8 gl8Var3 = (gl8) sparseArray.valueAt(i);
            if (gl8Var3 != null && (gl8Var2 = (gl8) hashMap.put(gl8Var3.i1(), gl8Var3)) != null) {
                rd8.j(gl8Var2, 30);
            }
        }
        sparseArray.clear();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry != null && (gl8Var = (gl8) entry.getValue()) != null) {
                sparseArray.put(gl8Var.getPosition(), gl8Var);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            gf7.a(arrayList, Integer.valueOf(sparseArray.keyAt(i2)));
        }
        Collections.sort(arrayList);
        int i3 = 1;
        for (int i4 = 0; i4 < gf7.i(arrayList); i4++) {
            gl8 gl8Var4 = (gl8) sparseArray.get(((Integer) gf7.d(arrayList, i4)).intValue());
            if (this.B.l() != null) {
                gl8Var4.V0 = this.B.l().getId();
            }
            if (this.B.O() != null) {
                gl8Var4.Y0 = pg.g(this.B.O().getId(), 0L);
            }
            kt7 kt7Var2 = this.B;
            if (kt7Var2 != null && kt7Var2.y() != null) {
                gl8Var4.Z0 = this.B.y().a();
            }
            l(gl8Var4);
            int position = gl8Var4.getPosition() + this.B.a0;
            if (position >= gf7.i(F)) {
                gl8Var4.b1 = position;
                rd8.k(gl8Var4, 2, position, gf7.i(F));
                return;
            }
            if (!this.H) {
                position--;
                gl8Var4.b1 = position;
            }
            if (position < 0) {
                rd8.j(gl8Var4, 23);
            } else {
                gl8Var4.c1 = i3;
                gf7.b(F, gl8Var4, position);
                i3++;
                PbFragment pbFragment = this.a;
                if (pbFragment != null && pbFragment.getPageContext() != null && this.a.getPageContext().getContext() != null) {
                    TiebaStatic.eventStat(this.a.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", gl8Var4.getAdvertAppInfo().p);
                }
            }
        }
    }

    public ArrayList<PostData> E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.C : (ArrayList) invokeV.objValue;
    }

    public void E0() {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (i = this.e0) <= 0 || Q(this.D, i) == null) {
            return;
        }
        this.e0 = -1;
        this.b.setData(this.D);
        a0();
    }

    public final int F(kt7 kt7Var, ArrayList<pn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048586, this, kt7Var, arrayList, z)) == null) {
            if (kt7Var == null || ListUtils.isEmpty(kt7Var.F()) || arrayList == null || arrayList.size() <= 0) {
                return (kt7Var == null || !kt7Var.u0()) ? -1 : 0;
            }
            arrayList.size();
            if (z) {
                return (kt7Var.F().get(0) == null || kt7Var.F().get(0).B() != 1) ? -1 : 1;
            }
            return 0;
        }
        return invokeLLZ.intValue;
    }

    public final int G(kt7 kt7Var, ArrayList<pn> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, kt7Var, arrayList)) == null) {
            int i = -1;
            if (kt7Var == null || kt7Var.y() == null) {
                return -1;
            }
            int i2 = 0;
            boolean z = kt7Var.y().c() == 1;
            int size = arrayList.size();
            if (z && this.F) {
                while (true) {
                    if (i2 >= size) {
                        break;
                    } else if (arrayList.get(i2) instanceof xt7) {
                        i = i2 + 1;
                        break;
                    } else {
                        i2++;
                    }
                }
                return kt7Var.L() == 4 ? i + 1 : i;
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public int H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.c0 : invokeV.intValue;
    }

    public final ArrayList<pn> I(List<pn> list, List<pn> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, list, list2)) == null) {
            ArrayList<pn> arrayList = new ArrayList<>(list.size() + list2.size() + 2);
            arrayList.addAll(list);
            qt7 qt7Var = new qt7();
            PbListView X0 = this.a.S5().X0();
            if (X0 != null && X0.n()) {
                qt7Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0de2);
                qt7Var.b = true;
            } else {
                qt7Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f09ec);
                qt7Var.b = false;
            }
            arrayList.add(qt7Var);
            e16 e16Var = new e16();
            e16Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f94);
            e16Var.needTopMargin = false;
            arrayList.add(e16Var);
            arrayList.addAll(list2);
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public View J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            kw7 kw7Var = this.c;
            if (kw7Var == null || kw7Var.J() == null) {
                return null;
            }
            if (this.c.J().w != null && this.c.J().w.isShown()) {
                return this.c.J().w;
            }
            return this.c.J().v;
        }
        return (View) invokeV.objValue;
    }

    public final void K(ArrayList<pn> arrayList, Boolean bool) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048591, this, arrayList, bool) == null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        int i = px4.i();
        int j = px4.j() - 1;
        if (bool.booleanValue()) {
            pn pnVar = arrayList.get(0);
            if ((pnVar instanceof PostData) && ((PostData) pnVar).B() == 1) {
                j++;
            }
        }
        int k = px4.k() + 1;
        PbFragment pbFragment = this.a;
        if (pbFragment != null && pbFragment.K() != null && this.a.K().c2() == 3) {
            this.g0.clear();
        }
        R(j, i, k, arrayList);
    }

    public void L(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, pbFragment, bdTypeListView) == null) {
            kw7 kw7Var = new kw7(pbFragment, PostData.J0);
            this.c = kw7Var;
            kw7Var.W(pbFragment);
            this.d = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, yt7.f);
            this.e = new PbFirstFloorEnterForumAdapter(pbFragment, mt7.i);
            this.f = new PbFirstFloorItemAdapter(pbFragment.getContext(), nt7.c);
            this.g = new ay7(pbFragment, ft7.c);
            this.h = new ix7(pbFragment, xt7.i);
            this.i = new xw7(pbFragment, st7.c);
            this.j = new ix7(pbFragment, xt7.j);
            ew7 ew7Var = new ew7(pbFragment, PostData.K0);
            this.k = ew7Var;
            ew7Var.w0(pbFragment);
            mx7 mx7Var = new mx7(pbFragment, PostData.L0);
            this.l = mx7Var;
            mx7Var.s0(pbFragment);
            this.o = ec8.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.x);
            this.p = ec8.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.z);
            this.q = ys6.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.F);
            this.r = ys6.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.G);
            this.s = ys6.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.I);
            this.v = new ex7(pbFragment, ut7.Z0);
            this.t = new fx7(pbFragment, dx7.W0);
            this.u = new gx7(pbFragment, lq4.c1);
            this.w = new PbReplyLoadMoreAdapter(pbFragment, PostData.R0);
            this.m = new o08(pbFragment, p08.a);
            this.n = new b16(pbFragment.getPageContext());
            this.y = new bw7(pbFragment, xo4.e);
            this.z = new rw7(pbFragment, pbFragment.getUniqueId());
            av7 av7Var = new av7(pbFragment, pbFragment.getUniqueId(), this.b);
            this.A = av7Var;
            this.Z.addAll(av7Var.a());
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
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new wk8(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
            CustomMessage customMessage = new CustomMessage(2004015);
            customMessage.setTag(pbFragment.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            bdTypeListView.a(this.Z);
        }
    }

    public final void M(@NonNull kt7 kt7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, kt7Var) == null) {
            this.c.r(kt7Var);
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
            this.k.r(kt7Var);
            this.k.setFromCDN(this.E);
            this.k.o(this.O);
            this.k.c(this.G);
            this.k.e(this.S);
            this.k.k(this.R);
            this.k.n(this.U);
            this.k.d(this.X);
            this.k.v0(this.W);
            this.l.r(kt7Var);
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
            cn cnVar = this.p;
            if (cnVar != null && (cnVar instanceof ac8)) {
                ((ac8) cnVar).setIsFromCDN(this.E);
            }
            Iterator<zu7> it = this.x.iterator();
            while (it.hasNext()) {
                zu7 next = it.next();
                if (next != null) {
                    next.r(kt7Var);
                    next.setFromCDN(this.E);
                    next.o(this.O);
                    next.l(this.N);
                    next.c(this.G);
                    next.f(this.H);
                    next.q(this.M);
                    next.e(this.S);
                    next.k(this.R);
                    next.n(this.U);
                    next.d(this.X);
                }
            }
            this.h.e(this.S);
            this.h.z(this.Y);
            this.i.e(this.T);
            this.j.e(this.S);
            this.h.r(kt7Var);
            this.g.r(kt7Var);
            this.j.r(kt7Var);
            this.t.r(kt7Var);
            this.u.r(kt7Var);
            this.y.y(kt7Var);
            this.y.x(this.a.u1);
            this.z.w(kt7Var);
            this.A.f(kt7Var);
        }
    }

    public final pn N(ArrayList<pn> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048594, this, arrayList, i)) == null) {
            if (this.B == null) {
                return null;
            }
            gl8 l1 = this.a.K().l1();
            if (l1 == null) {
                l1 = this.B.z();
            }
            if (l1 == null) {
                return null;
            }
            AdvertAppInfo.ILegoAdvert l12 = l1.l1();
            if (l12 != null) {
                l12.setAdvertAppInfo(l1.getAdvertAppInfo());
            }
            int n = l1.getAdvertAppInfo().n();
            if (n != 0) {
                rd8.j(l1, n);
                if (n != 28 && n != 31) {
                    l1.getAdvertAppInfo().c = -1001;
                }
                return null;
            }
            if (this.B.l() != null) {
                l1.V0 = this.B.l().getId();
            }
            if (this.B.O() != null) {
                l1.Y0 = pg.g(this.B.O().getId(), 0L);
            }
            kt7 kt7Var = this.B;
            if (kt7Var != null && kt7Var.y() != null) {
                l1.Z0 = this.B.y().a();
            }
            l(l1);
            if (i >= 0) {
                l1.c1 = 1;
                dm5.k().q(true);
                gf7.b(arrayList, l1, i);
                return l1;
            }
            return null;
        }
        return (pn) invokeLI.objValue;
    }

    public final boolean O(kt7 kt7Var, ArrayList<pn> arrayList, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{kt7Var, arrayList, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            ArrayList arrayList2 = new ArrayList();
            if (!ListUtils.isEmpty(kt7Var.f()) && kt7Var.f().size() > 2) {
                int min = Math.min(kt7Var.f().size(), 7);
                for (int i5 = 0; i5 < min; i5++) {
                    xo4 xo4Var = kt7Var.f().get(i5);
                    if (!z2 && i5 == 0) {
                        xo4Var.n(true);
                    }
                    if (xo4Var.getThreadVideoInfo() == null) {
                        if (i5 == min - 1) {
                            xo4Var.s(true);
                        }
                    } else if (i5 == min - 2) {
                        xo4Var.s(true);
                    } else if (i5 == min - 1) {
                        xo4Var.r(true);
                    }
                    arrayList2.add(xo4Var);
                }
            }
            if (arrayList2.size() > 0) {
                int i6 = (!z || i < 0) ? z ? i2 + 2 : i2 >= 0 ? i2 + 1 : i3 >= 0 ? i3 : i4 >= 0 ? i4 : -1 : i + 1;
                if (i6 >= 0 && arrayList2.size() > 1) {
                    for (int size = arrayList2.size() - 1; size >= 0; size--) {
                        ListUtils.add(arrayList, i6, arrayList2.get(size));
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final pn P(kt7 kt7Var, ArrayList<pn> arrayList, int i) {
        InterceptResult invokeLLI;
        ft7 ft7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048596, this, kt7Var, arrayList, i)) == null) {
            if (i < 0 || kt7Var == null || !kt7Var.k || (ft7Var = kt7Var.l) == null) {
                return null;
            }
            ListUtils.add(arrayList, i, ft7Var);
            return ft7Var;
        }
        return (pn) invokeLLI.objValue;
    }

    public final pn Q(ArrayList<pn> arrayList, int i) {
        InterceptResult invokeLI;
        kt7 kt7Var;
        fl8 fl8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048597, this, arrayList, i)) == null) {
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && i > 0 && (kt7Var = this.B) != null && kt7Var.q0()) {
                String d2 = dt6.e().d("pb_banner");
                if (this.f0 == null && xs6.m().v(d2)) {
                    ThreadData threadData = new ThreadData();
                    this.f0 = threadData;
                    threadData.funAdData = new fl8();
                    kt7 kt7Var2 = this.B;
                    if (kt7Var2 != null) {
                        this.f0.funAdData.m(kt7Var2.m());
                        this.f0.funAdData.r(this.B.Q());
                    }
                }
                ThreadData threadData2 = this.f0;
                if (threadData2 != null && (fl8Var = threadData2.funAdData) != null) {
                    fl8Var.j(1);
                    dm5.k().q(true);
                    ListUtils.add(arrayList, i, this.f0);
                }
            }
            return this.f0;
        }
        return (pn) invokeLI.objValue;
    }

    public final void R(int i, int i2, int i3, ArrayList<pn> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), arrayList}) == null) || ListUtils.isEmpty(arrayList) || i < 0 || i2 < 1) {
            return;
        }
        ListIterator<pn> listIterator = arrayList.listIterator();
        int i4 = 0;
        int i5 = 0;
        int i6 = 1;
        while (true) {
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
                    fl8 fl8Var = new fl8();
                    kt7 kt7Var = this.B;
                    fl8Var.m(kt7Var != null ? kt7Var.m() : "");
                    kt7 kt7Var2 = this.B;
                    fl8Var.r(kt7Var2 != null ? kt7Var2.Q() : "");
                    fl8Var.n(true);
                    postData.t0 = fl8Var;
                    fl8Var.j(i6);
                    listIterator.add(postData);
                    i6++;
                    this.g0.add(postData);
                }
                i5++;
            }
            listIterator.next();
            i4++;
        }
        if (i4 != i || i5 >= i3) {
            return;
        }
        PostData postData2 = new PostData();
        fl8 fl8Var2 = new fl8();
        kt7 kt7Var3 = this.B;
        fl8Var2.m(kt7Var3 != null ? kt7Var3.m() : "");
        kt7 kt7Var4 = this.B;
        fl8Var2.r(kt7Var4 != null ? kt7Var4.Q() : "");
        fl8Var2.n(true);
        postData2.t0 = fl8Var2;
        fl8Var2.j(1);
        listIterator.add(postData2);
        this.g0.add(postData2);
    }

    public final pn S(kt7 kt7Var, ArrayList<pn> arrayList, int i) {
        InterceptResult invokeLLI;
        mt7 mt7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048599, this, kt7Var, arrayList, i)) == null) {
            if (kt7Var.l() == null || StringUtils.isNull(kt7Var.l().getName())) {
                return null;
            }
            if (TextUtils.equals(kt7Var.l().getName(), this.a.K().r1()) && this.a.K().x1()) {
                return null;
            }
            if (!this.a.u0() && !ListUtils.isEmpty(kt7Var.p())) {
                mt7Var = new mt7(kt7Var.p().get(0));
            } else {
                mt7Var = new mt7(kt7Var.l());
            }
            mt7Var.g = this.a.K().m2();
            ListUtils.add(arrayList, i + 1, mt7Var);
            return mt7Var;
        }
        return (pn) invokeLLI.objValue;
    }

    public final pn T(kt7 kt7Var, PostData postData, ArrayList<pn> arrayList, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048600, this, kt7Var, postData, arrayList, i)) == null) {
            nt7 nt7Var = null;
            if (kt7Var.l() == null || StringUtils.isNull(kt7Var.l().getName()) || !TextUtils.equals(kt7Var.l().getName(), this.a.K().r1()) || !this.a.K().x1()) {
                if (postData != null) {
                    if (postData.i0 != null) {
                        nt7Var = new nt7(postData.i0);
                    }
                } else {
                    PostData postData2 = this.P;
                    if (postData2 != null && postData2.i0 != null) {
                        nt7Var = new nt7(this.P.i0);
                    }
                }
                if (nt7Var != null) {
                    nt7Var.b = this.a.K().m2();
                    ListUtils.add(arrayList, i + 1, nt7Var);
                }
                return nt7Var;
            }
            return null;
        }
        return (pn) invokeLLLI.objValue;
    }

    public final sw7 U(ArrayList<pn> arrayList, pn pnVar, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048601, this, arrayList, pnVar, i, i2)) == null) {
            sw7 B = this.B.B();
            if (B != null) {
                if (pnVar != null) {
                    if (i2 >= 0 || pnVar.getType() == AdvertAppInfo.z) {
                        i2 = pnVar.getType() != AdvertAppInfo.z ? i2 + 1 : -1;
                    } else {
                        i2 = i + 2;
                    }
                }
                if (i2 <= 0 || !(B instanceof sw7)) {
                    return null;
                }
                ListUtils.add(arrayList, i2, B);
                return B;
            }
            return null;
        }
        return (sw7) invokeLLII.objValue;
    }

    public final void V(kt7 kt7Var, ArrayList<pn> arrayList, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048602, this, kt7Var, arrayList, i) == null) {
            xt7 xt7Var = new xt7(xt7.i);
            ThreadData O = kt7Var.O();
            if (O != null) {
                O.getReply_num();
            }
            xt7Var.d = this.a.o6();
            xt7Var.c = kt7Var.g;
            kt7Var.c();
            xt7Var.e = kt7Var.i0();
            xt7Var.g = kt7Var.f;
            xt7Var.h = O != null && O.isQuestionThread();
            ListUtils.add(arrayList, i, xt7Var);
            if (kt7Var.L() == 4) {
                ListUtils.add(arrayList, i + 1, new wt7());
            }
        }
    }

    public final pn W(ArrayList<pn> arrayList, int i) {
        InterceptResult invokeLI;
        PbModel K;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048603, this, arrayList, i)) == null) {
            if (i < 0 || (K = this.a.K()) == null || TextUtils.isEmpty(K.W1())) {
                return null;
            }
            gl8 gl8Var = new gl8();
            l(gl8Var);
            ListUtils.add(arrayList, i + 1, gl8Var);
            return gl8Var;
        }
        return (pn) invokeLI.objValue;
    }

    public final void X(PostData postData, ArrayList<pn> arrayList, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048604, this, postData, arrayList, i) == null) {
            postData.a1(true);
            arrayList.add(i, postData);
        }
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.E : invokeV.booleanValue;
    }

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.G : invokeV.booleanValue;
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.c0 = B();
            if (this.b.getAdapter2() instanceof gn) {
                this.b.getAdapter2().notifyDataSetChanged();
            }
        }
    }

    public void b0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            if (i == 1) {
                kw7 kw7Var = this.c;
                if (kw7Var != null) {
                    kw7Var.P();
                }
                cn cnVar = this.p;
                if (cnVar instanceof vb8) {
                    ((vb8) cnVar).onPause();
                }
                cn cnVar2 = this.q;
                if (cnVar2 instanceof vb8) {
                    ((vb8) cnVar2).onPause();
                }
                cn cnVar3 = this.s;
                if (cnVar3 instanceof vb8) {
                    ((vb8) cnVar3).onPause();
                }
                fw7.a().j(this.a.P());
                o95.a().d();
            } else if (i == 2) {
                kw7 kw7Var2 = this.c;
                if (kw7Var2 != null) {
                    kw7Var2.R();
                }
                cn cnVar4 = this.p;
                if (cnVar4 instanceof vb8) {
                    ((vb8) cnVar4).onResume();
                }
                cn cnVar5 = this.q;
                if (cnVar5 instanceof vb8) {
                    ((vb8) cnVar5).onResume();
                }
                cn cnVar6 = this.s;
                if (cnVar6 instanceof vb8) {
                    ((vb8) cnVar6).onResume();
                }
                h0(false);
                g0();
            } else if (i != 3) {
            } else {
                kw7 kw7Var3 = this.c;
                if (kw7Var3 != null) {
                    kw7Var3.Q();
                }
                cn cnVar7 = this.p;
                if (cnVar7 instanceof vb8) {
                    ((vb8) cnVar7).onDestroy();
                }
                cn cnVar8 = this.q;
                if (cnVar8 instanceof vb8) {
                    ((vb8) cnVar8).onDestroy();
                }
                cn cnVar9 = this.s;
                if (cnVar9 instanceof vb8) {
                    ((vb8) cnVar9).onDestroy();
                }
                fw7.a().d();
            }
        }
    }

    public void c0(boolean z, int i) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) || (pbFragment = this.a) == null || pbFragment.S5() == null) {
            return;
        }
        this.a.S5().e2(z, i);
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            sg.a().removeCallbacks(this.b0);
            ix7 ix7Var = this.h;
            if (ix7Var != null) {
                ix7Var.onDestroy();
            }
            ix7 ix7Var2 = this.j;
            if (ix7Var2 != null) {
                ix7Var2.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.d;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
            ay7 ay7Var = this.g;
            if (ay7Var != null) {
                ay7Var.onDestroy();
            }
            dm5.k().q(false);
        }
    }

    public void e0(boolean z) {
        kw7 kw7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048611, this, z) == null) || (kw7Var = this.c) == null) {
            return;
        }
        kw7Var.O(z);
    }

    public final void f0(boolean z, boolean z2, int i, List<pn> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), list}) == null) || z || z2) {
            return;
        }
        if ((!this.K && !this.J) || i == -1 || ListUtils.isEmpty(list) || this.L) {
            return;
        }
        this.b0 = new e(this, list);
        sg.a().post(this.b0);
    }

    public void g0() {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || this.B == null || (postData = this.P) == null || postData.S() == null || this.c.J() == null) {
            return;
        }
        o95.a().c(this.B.Q(), this.B.m(), this.P.S(), this.c.J().p);
    }

    public void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048614, this, z) == null) || this.a.S5() == null || this.a.P() == null || this.a.P().b1() == null) {
            return;
        }
        fw7.a().g(this.a.P().b1().D2(), this.h.v(), this.a.S5().Z0(), this.a.P().getPageStayDurationItem(), z, this.A.b(), this.a.getListView());
    }

    public void i0(kt7 kt7Var, boolean z) {
        boolean z2;
        PostData postData;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i;
        int i2;
        sw7 sw7Var;
        boolean z7;
        List<pn> list;
        int i3;
        pn pnVar;
        int i4;
        PostData postData2;
        PostData postData3;
        PostData postData4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048615, this, kt7Var, z) == null) || kt7Var == null) {
            return;
        }
        this.B = kt7Var;
        if (!UbsABTestHelper.isPbCommentFunAdABTest()) {
            D0();
        }
        if (this.C == null) {
            this.C = new ArrayList<>();
        }
        this.C.clear();
        kt7 kt7Var2 = this.B;
        if (kt7Var2 != null && kt7Var2.F() != null && this.B.F().size() > 0) {
            this.C.addAll(this.B.F());
        }
        if (kt7Var.O() != null && kt7Var.O().getAuthor() != null) {
            this.O = kt7Var.O().getAuthor().getUserId();
        }
        if (this.c == null) {
            return;
        }
        M(kt7Var);
        ArrayList<pn> arrayList = new ArrayList<>(kt7Var.F());
        PostData p = p(arrayList);
        PostData q = this.B.O().isQuestionThread() ? q(kt7Var) : null;
        if (q != null) {
            arrayList.remove(q);
        }
        boolean z8 = p != null;
        if (!et6.f() && UbsABTestHelper.isPbCommentFunAdABTest() && this.B.q0()) {
            K(arrayList, Boolean.valueOf(z8));
        }
        if (p != null) {
            this.P = p;
        }
        if (this.H || p == null) {
            z2 = false;
        } else {
            arrayList.remove(p);
            if (kt7Var.u0() && p.V() != null) {
                p.U0(null);
            }
            z8 = true;
            z2 = true;
        }
        if (z8 || kt7Var.j() == null) {
            postData = p;
            z3 = z2;
        } else {
            PostData j = kt7Var.j();
            if (!this.H && kt7Var.u0() && j.V() != null) {
                j.U0(null);
            }
            if (this.H || (postData4 = this.P) == null || j.g0 != null) {
                postData = j;
            } else {
                kt7Var.D0(postData4);
                postData = postData4;
            }
            z8 = true;
            z3 = true;
        }
        o(arrayList);
        if (this.a.F5()) {
            if (kt7Var.F().size() > 0 && (postData3 = kt7Var.F().get(0)) != null && postData3.B() == 1 && !ListUtils.isEmpty(arrayList)) {
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
        gk8.f(arrayList, 1);
        int A = A(kt7Var, arrayList);
        if (A >= 0) {
            V(kt7Var, arrayList, A);
            z4 = true;
        } else {
            z4 = false;
        }
        int G = G(kt7Var, arrayList);
        if (G >= 0) {
            st7 st7Var = new st7(st7.c);
            st7Var.b(true);
            ListUtils.add(arrayList, G, st7Var);
        }
        int u = u(kt7Var, arrayList);
        List<pn> v = v(kt7Var);
        if (!ListUtils.isEmpty(v) && u >= 0) {
            pn pnVar2 = (pn) ListUtils.getItem(arrayList, u);
            if (pnVar2 instanceof PostData) {
                ((PostData) pnVar2).P = true;
            }
            ListUtils.addAll(arrayList, u, v);
            z4 = true;
        }
        int F = z8 ? F(kt7Var, arrayList, this.H) : -1;
        if (F < 0 || kt7Var.S() == null) {
            if (postData != null) {
                postData.O = true;
            }
            z5 = z4;
            z6 = false;
        } else {
            ListUtils.add(arrayList, F, kt7Var.S());
            z5 = true;
            z6 = true;
        }
        if ((this.B.O().isQuestionThread() && q != null) || (this.B.O().isQuestionThread() && this.Q != null)) {
            if (q == null && (postData2 = this.Q) != null) {
                q = postData2;
            }
            if (!arrayList.contains(q)) {
                F++;
                X(q, arrayList, F);
            }
        }
        boolean z9 = T(kt7Var, postData, arrayList, F) != null;
        if (z9) {
            F++;
        }
        if (!z9 && S(kt7Var, arrayList, F) != null) {
            F++;
        }
        if (P(kt7Var, arrayList, F) != null) {
            F++;
        }
        if (z8) {
            pn W = W(arrayList, F);
            boolean z10 = W != null;
            if (z10) {
                z7 = z10;
                pnVar = W;
                i4 = -1;
            } else {
                i4 = F >= 0 ? F + 1 : u >= 0 ? u : A >= 0 ? A : -1;
                pnVar = N(arrayList, i4);
                z7 = pnVar != null;
            }
            boolean z11 = TbadkCoreApplication.getCurrentAccountInfo() == null || TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() != 1;
            if (z11 && this.B.q0()) {
                this.e0 = i4;
                if (Q(arrayList, i4) != null) {
                    this.e0 = -1;
                    F++;
                }
            }
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && z11) {
                i = F;
                sw7Var = null;
            } else {
                sw7 U = U(arrayList, pnVar, F, i4);
                if (U != null) {
                    if (!z7) {
                        sw7Var = U;
                        i = F;
                        z7 = true;
                    } else if (i4 > 0) {
                        i4++;
                    } else {
                        F++;
                    }
                }
                sw7Var = U;
                i = F;
            }
            i2 = i4;
        } else {
            i = F;
            i2 = -1;
            sw7Var = null;
            z7 = false;
        }
        if (z8) {
            list = v;
            i3 = u;
            boolean O = O(kt7Var, arrayList, z7, sw7Var != null, i2, i, u, A);
            if (sw7Var != null) {
                sw7Var.n = O;
            }
        } else {
            list = v;
            i3 = u;
        }
        this.c.U(!z5);
        boolean C0 = C0(postData);
        if (this.I && !C0) {
            arrayList.remove(postData);
            this.I = false;
        }
        if (kt7Var.S() != null) {
            kt7Var.S().j(!z6);
        }
        if (this.b != null) {
            this.D = arrayList;
            List<pn> R = kt7Var.R();
            if (!ListUtils.isEmpty(R)) {
                this.b.setData(I(arrayList, R));
            } else {
                this.b.setData(this.D);
            }
        }
        f0(C0, z, i3, list);
        if (r(postData, arrayList, z3)) {
            List<pn> R2 = kt7Var.R();
            if (!ListUtils.isEmpty(R2)) {
                this.b.setData(I(arrayList, R2));
            } else {
                this.b.setData(arrayList);
            }
        }
    }

    public void j0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.E = z;
            this.c.setFromCDN(z);
            cn cnVar = this.p;
            if (cnVar != null && (cnVar instanceof ac8)) {
                ((ac8) cnVar).setIsFromCDN(z);
            }
            Iterator<zu7> it = this.x.iterator();
            while (it.hasNext()) {
                it.next().setFromCDN(z);
            }
        }
    }

    public void k0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.I = z;
        }
    }

    public final void l(gl8 gl8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048618, this, gl8Var) == null) || gl8Var == null || this.B == null || gl8Var.getAdvertAppInfo() == null) {
            return;
        }
        gl8Var.getAdvertAppInfo().i = new lo4();
        if (this.B.y() != null) {
            gl8Var.getAdvertAppInfo().i.b = this.B.y().a();
        }
        gl8Var.getAdvertAppInfo().i.a = gl8Var.k1();
        if (this.B.l() != null && (l = this.B.l()) != null) {
            gl8Var.getAdvertAppInfo().i.c = l.getId();
            gl8Var.getAdvertAppInfo().i.d = l.getFirst_class();
            gl8Var.getAdvertAppInfo().i.e = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            gl8Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        gl8Var.getAdvertAppInfo().i.g = gl8Var.getAdvertAppInfo().g;
        gl8Var.getAdvertAppInfo().i.h = false;
    }

    public void l0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.G = z;
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || this.a == null || n()) {
            return;
        }
        this.a.registerListener(this.l0);
    }

    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.M = z;
        }
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            if (this.a == null) {
                return false;
            }
            this.m0 = new ArrayList();
            ArrayList<BdUniqueId> g = gk8.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                ye7 b2 = dg7.d().b(this.a.getPageContext(), g.get(i), 2);
                if (b2 != null) {
                    this.Z.add(b2);
                    this.m0.add(b2);
                }
            }
            if (ListUtils.isEmpty(this.m0)) {
                return true;
            }
            this.b.a(this.m0);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void n0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.J = z;
        }
    }

    public final void o(List<pn> list) {
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048624, this, list) == null) || list == null || (size = list.size()) <= 0) {
            return;
        }
        for (int i = 0; i < size; i++) {
            if (list.get(i) instanceof PostData) {
                PostData postData = (PostData) list.get(i);
                if (!TextUtils.isEmpty(postData.Q())) {
                    wp4 wp4Var = new wp4();
                    wp4Var.h(postData.Q());
                    list.set(i, wp4Var);
                }
            }
        }
    }

    public void o0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.K = z;
        }
    }

    public final PostData p(ArrayList<pn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, arrayList)) == null) {
            Iterator<pn> it = arrayList.iterator();
            while (it.hasNext()) {
                pn next = it.next();
                if (next instanceof PostData) {
                    PostData postData = (PostData) next;
                    if (postData.B() == 1) {
                        return postData;
                    }
                }
            }
            return null;
        }
        return (PostData) invokeL.objValue;
    }

    public void p0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            this.H = z;
        }
    }

    public final PostData q(kt7 kt7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, kt7Var)) == null) {
            if (kt7Var == null || kt7Var.U() == null) {
                return null;
            }
            PostData U = kt7Var.U();
            this.Q = U;
            return U;
        }
        return (PostData) invokeL.objValue;
    }

    public void q0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
            this.L = z;
        }
    }

    public final boolean r(PostData postData, ArrayList<pn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048630, this, postData, arrayList, z)) == null) {
            if (postData != null) {
                if (z) {
                    ListUtils.add(arrayList, 0, postData);
                    return true;
                }
                return false;
            }
            PostData postData2 = this.P;
            if (postData2 != null && !this.J) {
                ListUtils.add(arrayList, 0, postData2);
            } else {
                PostData postData3 = new PostData();
                postData3.C0(1);
                ListUtils.add(arrayList, 0, postData3);
            }
            return true;
        }
        return invokeLLZ.booleanValue;
    }

    public void r0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, onClickListener) == null) {
            this.T = onClickListener;
        }
    }

    public View s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.A.b() : (View) invokeV.objValue;
    }

    public void s0(boolean z) {
        ew7 ew7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048633, this, z) == null) || (ew7Var = this.k) == null) {
            return;
        }
        ew7Var.t0(z);
    }

    public ArrayList<pn> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.D : (ArrayList) invokeV.objValue;
    }

    public void t0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, onClickListener) == null) {
            this.R = onClickListener;
        }
    }

    public final int u(kt7 kt7Var, ArrayList<pn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048636, this, kt7Var, arrayList)) == null) {
            if (this.J || kt7Var == null || ListUtils.isEmpty(kt7Var.F()) || arrayList == null || arrayList.size() <= 0) {
                return (kt7Var != null && kt7Var.u0() && this.H) ? 0 : -1;
            } else if (this.a.K() == null || !this.a.K().B1()) {
                if (this.a.S5() == null || !this.a.S5().P0()) {
                    int size = arrayList.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            z = false;
                            i = -1;
                            break;
                        }
                        pn pnVar = arrayList.get(i);
                        if (pnVar instanceof PostData) {
                            PostData postData = (PostData) pnVar;
                            if (postData.B() == 1 && postData.M == 0) {
                                z = true;
                                break;
                            }
                        }
                        i++;
                    }
                    return !z ? kt7Var.u0() ? 0 : -1 : i + 1;
                }
                return -1;
            } else {
                return -1;
            }
        }
        return invokeLL.intValue;
    }

    public void u0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
            ew7 ew7Var = this.k;
            if (ew7Var != null) {
                ew7Var.u0(z);
            }
            ix7 ix7Var = this.h;
            if (ix7Var != null) {
                ix7Var.y(z);
            }
            cn cnVar = this.s;
            if (cnVar != null) {
                cnVar.setMulDel(z);
            }
            cn cnVar2 = this.p;
            if (cnVar2 != null) {
                cnVar2.setMulDel(z);
            }
            kw7 kw7Var = this.c;
            if (kw7Var != null) {
                kw7Var.setMulDel(z);
            }
        }
    }

    public final List<pn> v(kt7 kt7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, kt7Var)) == null) {
            if (kt7Var == null || kt7Var.T() == null || ListUtils.isEmpty(kt7Var.T().a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<PostData> list = kt7Var.T().a;
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            int min = Math.min(2, list.size());
            for (int i = 0; i < min; i++) {
                PostData postData = list.get(i);
                if (postData != null) {
                    postData.a0 = true;
                    postData.N = true;
                    arrayList.add(postData);
                }
            }
            if (ListUtils.getCount(kt7Var.T().b) > 2) {
                pn pnVar = (pn) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (pnVar instanceof PostData) {
                    ((PostData) pnVar).N = false;
                }
                arrayList.add(new p08());
            } else {
                pn pnVar2 = (pn) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (pnVar2 instanceof PostData) {
                    ((PostData) pnVar2).N = true;
                }
            }
            xt7 xt7Var = new xt7(xt7.j);
            xt7Var.a = kt7Var.T().c;
            arrayList.add(0, xt7Var);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void v0(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, yVar) == null) {
            this.U = yVar;
        }
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.b.getHeaderViewsCount() : invokeV.intValue;
    }

    public void w0(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, onLongClickListener) == null) {
            this.X = onLongClickListener;
        }
    }

    public pn x(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048642, this, i)) == null) ? this.b.G(i) : (pn) invokeI.objValue;
    }

    public void x0(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, fVar) == null) {
            this.Y = fVar;
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
            this.S = onClickListener;
        }
    }

    public PbFirstFloorCommentAndPraiseAdapter z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? this.d : (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    public void z0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, onClickListener) == null) {
            this.V = onClickListener;
        }
    }
}
