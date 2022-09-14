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
/* loaded from: classes4.dex */
public class gx7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public lw7 A;
    public vu7 B;
    public ArrayList<PostData> C;
    public ArrayList<Cdo> D;
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
    public xv7 W;
    public View.OnLongClickListener X;
    public SortSwitchButton.f Y;
    public final List<qn> Z;
    public PbFragment a;
    public final List<qn> a0;
    public BdTypeListView b;
    public Runnable b0;
    public qx7 c;
    public int c0;
    public PbFirstFloorCommentAndPraiseAdapter d;
    public int d0;
    public PbFirstFloorEnterForumAdapter e;
    public int e0;
    public PbFirstFloorItemAdapter f;
    public ThreadData f0;
    public hz7 g;
    public List<PostData> g0;
    public py7 h;
    public final CustomMessageListener h0;
    public dy7 i;
    public CustomMessageListener i0;
    public py7 j;
    public final CustomMessageListener j0;
    public kx7 k;
    public final View.OnClickListener k0;
    public ty7 l;
    public CustomMessageListener l0;
    public w18 m;
    public List<qn> m0;
    public r26 n;
    public qn o;
    public qn p;
    public qn q;
    public qn r;
    public qn s;
    public ly7 t;
    public ny7 u;
    public ky7 v;
    public PbReplyLoadMoreAdapter w;
    public ArrayList<kw7> x;
    public hx7 y;
    public xx7 z;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gx7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(gx7 gx7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gx7Var, Integer.valueOf(i)};
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
            this.a = gx7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof tm8)) {
                return;
            }
            tm8 tm8Var = (tm8) customResponsedMessage.getData();
            if (this.a.f0 == null || this.a.f0.funAdData != tm8Var) {
                return;
            }
            this.a.f0.funAdData.p(true);
            this.a.b.setData(this.a.D);
            this.a.a0();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gx7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(gx7 gx7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gx7Var, Integer.valueOf(i)};
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
            this.a = gx7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof km8)) {
                AbsDelegateAdapterList a = ((km8) customResponsedMessage.getData()).a();
                Iterator<qn<?, ?>> it = a.iterator();
                while (it.hasNext()) {
                    qn<?, ?> next = it.next();
                    if (next instanceof mx7) {
                        ((mx7) next).t(this.a.a);
                        if (next instanceof kw7) {
                            this.a.x.add((kw7) next);
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
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gx7 a;

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
        public c(gx7 gx7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gx7Var, Integer.valueOf(i)};
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
            this.a = gx7Var;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.B == null || w9.c(this.a.a.getActivity()).isScroll() || customResponsedMessage.getCmd() != 2001118 || !(customResponsedMessage instanceof DownloadMessage) || (data = ((DownloadMessage) customResponsedMessage).getData()) == null || data.size() == 0) {
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
                gh.a().postDelayed(new a(this), TimeUnit.SECONDS.toMillis(2L));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gx7 a;

        public d(gx7 gx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gx7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.a == null || this.a.B == null || this.a.B.T() == null) {
                return;
            }
            this.a.a.P5().W0().v();
            TiebaStatic.log(new StatisticItem("c12040"));
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ gx7 b;

        public e(gx7 gx7Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gx7Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gx7Var;
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
        public final /* synthetic */ gx7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(gx7 gx7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gx7Var, Integer.valueOf(i)};
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
            this.a = gx7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.m0)) {
                this.a.n();
                gx7 gx7Var = this.a;
                gx7Var.i0(gx7Var.B, false);
            }
        }
    }

    public gx7(PbFragment pbFragment, BdTypeListView bdTypeListView) {
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
        this.N = ej.k(pbFragment.getPageContext().getPageActivity());
        this.a = pbFragment;
        this.b = bdTypeListView;
        L(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.j0);
        this.d0 = ej.i(this.a.getContext()) / 3;
    }

    public final int A(vu7 vu7Var, ArrayList<Cdo> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, vu7Var, arrayList)) == null) {
            if (vu7Var == null || ListUtils.isEmpty(vu7Var.F()) || ListUtils.isEmpty(arrayList) || ((PostData) ListUtils.getItem(vu7Var.F(), 0)) == null) {
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
                Cdo cdo = arrayList.get(i);
                if (cdo instanceof PostData) {
                    PostData postData = (PostData) cdo;
                    if (postData.C() == 1 && postData.M == 0) {
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

    public void A0(xv7 xv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xv7Var) == null) {
            this.W = xv7Var;
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
                Cdo cdo = this.b.getData().get(i);
                if (cdo != null && cdo.getType() == iv7.i) {
                    return i;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void B0() {
        dy7 dy7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (dy7Var = this.i) == null) {
            return;
        }
        dy7Var.x(2);
    }

    public int C(vu7 vu7Var, ArrayList<Cdo> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048580, this, vu7Var, arrayList, z)) == null) {
            if (vu7Var == null || vu7Var.F() == null || vu7Var.D() == null || vu7Var.F().size() == 0 || vu7Var.O() == null || arrayList == null || !vu7Var.D().j1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                return (vu7Var.F().get(0) == null || vu7Var.F().get(0).C() != 1) ? -1 : 1;
            } else if (size == 0) {
                return 0;
            } else {
                return (vu7Var.y() == null || vu7Var.y().a() != vu7Var.y().h()) ? -1 : 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final boolean C0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, postData)) == null) ? (this.a.K() == null || postData == null || postData.L() == null || !postData.L().equals(this.a.K().s2())) ? false : true : invokeL.booleanValue;
    }

    public int D(vu7 vu7Var, ArrayList<Cdo> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048582, this, vu7Var, arrayList, z)) == null) {
            if (vu7Var == null || vu7Var.F() == null || vu7Var.E() == null || vu7Var.F().size() == 0 || vu7Var.O() == null || arrayList == null || !vu7Var.E().j1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                return (vu7Var.F().get(0) == null || vu7Var.F().get(0).C() != 1) ? -1 : 1;
            } else if (size == 0) {
                return 0;
            } else {
                return (vu7Var.y() == null || vu7Var.y().a() != vu7Var.y().h()) ? -1 : 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final void D0() {
        vu7 vu7Var;
        um8 um8Var;
        um8 um8Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (vu7Var = this.B) == null || vu7Var.b0 || vu7Var.c0 == 2) {
            return;
        }
        ArrayList<PostData> F = vu7Var.F();
        ArrayList<um8> e2 = this.B.e();
        if (mg7.e(F) || mg7.e(e2)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<um8> it = e2.iterator();
        while (it.hasNext()) {
            um8 next = it.next();
            if (next != null && next.k1() != null) {
                sb.append(next.k1());
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        Iterator<um8> it2 = e2.iterator();
        while (it2.hasNext()) {
            um8 next2 = it2.next();
            if (next2 != null) {
                next2.b1 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<um8> it3 = e2.iterator();
        while (it3.hasNext()) {
            um8 next3 = it3.next();
            if (next3.getAdvertAppInfo() != null) {
                int n = next3.getAdvertAppInfo().n();
                if (n != 0) {
                    ze8.j(next3, n);
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
            um8 um8Var3 = (um8) sparseArray.valueAt(i);
            if (um8Var3 != null && (um8Var2 = (um8) hashMap.put(um8Var3.j1(), um8Var3)) != null) {
                ze8.j(um8Var2, 30);
            }
        }
        sparseArray.clear();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry != null && (um8Var = (um8) entry.getValue()) != null) {
                sparseArray.put(um8Var.getPosition(), um8Var);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            mg7.a(arrayList, Integer.valueOf(sparseArray.keyAt(i2)));
        }
        Collections.sort(arrayList);
        int i3 = 1;
        for (int i4 = 0; i4 < mg7.i(arrayList); i4++) {
            um8 um8Var4 = (um8) sparseArray.get(((Integer) mg7.d(arrayList, i4)).intValue());
            if (this.B.l() != null) {
                um8Var4.V0 = this.B.l().getId();
            }
            if (this.B.O() != null) {
                um8Var4.Y0 = dh.g(this.B.O().getId(), 0L);
            }
            vu7 vu7Var2 = this.B;
            if (vu7Var2 != null && vu7Var2.y() != null) {
                um8Var4.Z0 = this.B.y().a();
            }
            l(um8Var4);
            int position = um8Var4.getPosition() + this.B.a0;
            if (position >= mg7.i(F)) {
                um8Var4.b1 = position;
                ze8.k(um8Var4, 2, position, mg7.i(F));
                return;
            }
            if (!this.H) {
                position--;
                um8Var4.b1 = position;
            }
            if (position < 0) {
                ze8.j(um8Var4, 23);
            } else {
                um8Var4.c1 = i3;
                mg7.b(F, um8Var4, position);
                i3++;
                PbFragment pbFragment = this.a;
                if (pbFragment != null && pbFragment.getPageContext() != null && this.a.getPageContext().getContext() != null) {
                    TiebaStatic.eventStat(this.a.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", um8Var4.getAdvertAppInfo().p);
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

    public final int F(vu7 vu7Var, ArrayList<Cdo> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048586, this, vu7Var, arrayList, z)) == null) {
            if (vu7Var == null || ListUtils.isEmpty(vu7Var.F()) || arrayList == null || arrayList.size() <= 0) {
                return (vu7Var == null || !vu7Var.u0()) ? -1 : 0;
            }
            arrayList.size();
            if (z) {
                return (vu7Var.F().get(0) == null || vu7Var.F().get(0).C() != 1) ? -1 : 1;
            }
            return 0;
        }
        return invokeLLZ.intValue;
    }

    public final int G(vu7 vu7Var, ArrayList<Cdo> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, vu7Var, arrayList)) == null) {
            int i = -1;
            if (vu7Var == null || vu7Var.y() == null) {
                return -1;
            }
            int i2 = 0;
            boolean z = vu7Var.y().c() == 1;
            int size = arrayList.size();
            if (z && this.F) {
                while (true) {
                    if (i2 >= size) {
                        break;
                    } else if (arrayList.get(i2) instanceof iv7) {
                        i = i2 + 1;
                        break;
                    } else {
                        i2++;
                    }
                }
                return vu7Var.L() == 4 ? i + 1 : i;
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

    public final ArrayList<Cdo> I(List<Cdo> list, List<Cdo> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, list, list2)) == null) {
            ArrayList<Cdo> arrayList = new ArrayList<>(list.size() + list2.size() + 2);
            arrayList.addAll(list);
            bv7 bv7Var = new bv7();
            PbListView a1 = this.a.P5().a1();
            if (a1 != null && a1.n()) {
                bv7Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0dfc);
                bv7Var.b = true;
            } else {
                bv7Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f09ff);
                bv7Var.b = false;
            }
            arrayList.add(bv7Var);
            u26 u26Var = new u26();
            u26Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fb2);
            u26Var.needTopMargin = false;
            arrayList.add(u26Var);
            arrayList.addAll(list2);
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public View J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            qx7 qx7Var = this.c;
            if (qx7Var == null || qx7Var.I() == null) {
                return null;
            }
            if (this.c.I().y != null && this.c.I().y.isShown()) {
                return this.c.I().y;
            }
            return this.c.I().x;
        }
        return (View) invokeV.objValue;
    }

    public final void K(ArrayList<Cdo> arrayList, Boolean bool) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048591, this, arrayList, bool) == null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        int i = zz4.i();
        int j = zz4.j() - 1;
        if (bool.booleanValue()) {
            Cdo cdo = arrayList.get(0);
            if ((cdo instanceof PostData) && ((PostData) cdo).C() == 1) {
                j++;
            }
        }
        int k = zz4.k() + 1;
        PbFragment pbFragment = this.a;
        if (pbFragment != null && pbFragment.K() != null && this.a.K().c2() == 3) {
            this.g0.clear();
        }
        R(j, i, k, arrayList);
    }

    public void L(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, pbFragment, bdTypeListView) == null) {
            qx7 qx7Var = new qx7(pbFragment, PostData.J0);
            this.c = qx7Var;
            qx7Var.W(pbFragment);
            this.d = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, jv7.f);
            this.e = new PbFirstFloorEnterForumAdapter(pbFragment, xu7.i);
            this.f = new PbFirstFloorItemAdapter(pbFragment.getContext(), yu7.c);
            this.g = new hz7(pbFragment, qu7.c);
            this.h = new py7(pbFragment, iv7.i);
            this.i = new dy7(pbFragment, dv7.c);
            this.j = new py7(pbFragment, iv7.j);
            kx7 kx7Var = new kx7(pbFragment, PostData.K0);
            this.k = kx7Var;
            kx7Var.w0(pbFragment);
            ty7 ty7Var = new ty7(pbFragment, PostData.L0);
            this.l = ty7Var;
            ty7Var.s0(pbFragment);
            this.o = md8.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.x);
            this.p = md8.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.z);
            this.q = ju6.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.F);
            this.r = ju6.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.G);
            this.s = ju6.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.I);
            this.v = new ky7(pbFragment, fv7.Z0);
            this.t = new ly7(pbFragment, jy7.W0);
            this.u = new ny7(pbFragment, qs4.c1);
            this.w = new PbReplyLoadMoreAdapter(pbFragment, PostData.R0);
            this.m = new w18(pbFragment, x18.a);
            this.n = new r26(pbFragment.getPageContext());
            this.y = new hx7(pbFragment, cr4.e);
            this.z = new xx7(pbFragment, pbFragment.getUniqueId());
            lw7 lw7Var = new lw7(pbFragment, pbFragment.getUniqueId(), this.b);
            this.A = lw7Var;
            this.Z.addAll(lw7Var.a());
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
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new km8(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
            CustomMessage customMessage = new CustomMessage(2004015);
            customMessage.setTag(pbFragment.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            bdTypeListView.a(this.Z);
        }
    }

    public final void M(@NonNull vu7 vu7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, vu7Var) == null) {
            this.c.r(vu7Var);
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
            this.k.r(vu7Var);
            this.k.setFromCDN(this.E);
            this.k.o(this.O);
            this.k.c(this.G);
            this.k.e(this.S);
            this.k.k(this.R);
            this.k.n(this.U);
            this.k.d(this.X);
            this.k.v0(this.W);
            this.l.r(vu7Var);
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
            qn qnVar = this.p;
            if (qnVar != null && (qnVar instanceof id8)) {
                ((id8) qnVar).setIsFromCDN(this.E);
            }
            Iterator<kw7> it = this.x.iterator();
            while (it.hasNext()) {
                kw7 next = it.next();
                if (next != null) {
                    next.r(vu7Var);
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
            this.h.r(vu7Var);
            this.g.r(vu7Var);
            this.j.r(vu7Var);
            this.t.r(vu7Var);
            this.u.r(vu7Var);
            this.y.y(vu7Var);
            this.y.x(this.a.r1);
            this.z.w(vu7Var);
            this.A.f(vu7Var);
        }
    }

    public final Cdo N(ArrayList<Cdo> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048594, this, arrayList, i)) == null) {
            if (this.B == null) {
                return null;
            }
            um8 l1 = this.a.K().l1();
            if (l1 == null) {
                l1 = this.B.z();
            }
            if (l1 == null) {
                return null;
            }
            AdvertAppInfo.ILegoAdvert m1 = l1.m1();
            if (m1 != null) {
                m1.setAdvertAppInfo(l1.getAdvertAppInfo());
            }
            int n = l1.getAdvertAppInfo().n();
            if (n != 0) {
                ze8.j(l1, n);
                if (n != 28 && n != 31) {
                    l1.getAdvertAppInfo().c = -1001;
                }
                return null;
            }
            if (this.B.l() != null) {
                l1.V0 = this.B.l().getId();
            }
            if (this.B.O() != null) {
                l1.Y0 = dh.g(this.B.O().getId(), 0L);
            }
            vu7 vu7Var = this.B;
            if (vu7Var != null && vu7Var.y() != null) {
                l1.Z0 = this.B.y().a();
            }
            l(l1);
            if (i >= 0) {
                l1.c1 = 1;
                oo5.k().q(true);
                mg7.b(arrayList, l1, i);
                return l1;
            }
            return null;
        }
        return (Cdo) invokeLI.objValue;
    }

    public final boolean O(vu7 vu7Var, ArrayList<Cdo> arrayList, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{vu7Var, arrayList, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            ArrayList arrayList2 = new ArrayList();
            if (!ListUtils.isEmpty(vu7Var.f()) && vu7Var.f().size() > 2) {
                int min = Math.min(vu7Var.f().size(), 7);
                for (int i5 = 0; i5 < min; i5++) {
                    cr4 cr4Var = vu7Var.f().get(i5);
                    if (!z2 && i5 == 0) {
                        cr4Var.n(true);
                    }
                    if (cr4Var.getThreadVideoInfo() == null) {
                        if (i5 == min - 1) {
                            cr4Var.s(true);
                        }
                    } else if (i5 == min - 2) {
                        cr4Var.s(true);
                    } else if (i5 == min - 1) {
                        cr4Var.r(true);
                    }
                    arrayList2.add(cr4Var);
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

    public final Cdo P(vu7 vu7Var, ArrayList<Cdo> arrayList, int i) {
        InterceptResult invokeLLI;
        qu7 qu7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048596, this, vu7Var, arrayList, i)) == null) {
            if (i < 0 || vu7Var == null || !vu7Var.k || (qu7Var = vu7Var.l) == null) {
                return null;
            }
            ListUtils.add(arrayList, i, qu7Var);
            return qu7Var;
        }
        return (Cdo) invokeLLI.objValue;
    }

    public final Cdo Q(ArrayList<Cdo> arrayList, int i) {
        InterceptResult invokeLI;
        vu7 vu7Var;
        tm8 tm8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048597, this, arrayList, i)) == null) {
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && i > 0 && (vu7Var = this.B) != null && vu7Var.q0()) {
                String d2 = ou6.e().d("pb_banner");
                if (this.f0 == null && iu6.m().v(d2)) {
                    ThreadData threadData = new ThreadData();
                    this.f0 = threadData;
                    threadData.funAdData = new tm8();
                    vu7 vu7Var2 = this.B;
                    if (vu7Var2 != null) {
                        this.f0.funAdData.m(vu7Var2.m());
                        this.f0.funAdData.r(this.B.Q());
                    }
                }
                ThreadData threadData2 = this.f0;
                if (threadData2 != null && (tm8Var = threadData2.funAdData) != null) {
                    tm8Var.j(1);
                    oo5.k().q(true);
                    ListUtils.add(arrayList, i, this.f0);
                }
            }
            return this.f0;
        }
        return (Cdo) invokeLI.objValue;
    }

    public final void R(int i, int i2, int i3, ArrayList<Cdo> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), arrayList}) == null) || ListUtils.isEmpty(arrayList) || i < 0 || i2 < 1) {
            return;
        }
        ListIterator<Cdo> listIterator = arrayList.listIterator();
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
                    tm8 tm8Var = new tm8();
                    vu7 vu7Var = this.B;
                    tm8Var.m(vu7Var != null ? vu7Var.m() : "");
                    vu7 vu7Var2 = this.B;
                    tm8Var.r(vu7Var2 != null ? vu7Var2.Q() : "");
                    tm8Var.n(true);
                    postData.t0 = tm8Var;
                    tm8Var.j(i6);
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
        tm8 tm8Var2 = new tm8();
        vu7 vu7Var3 = this.B;
        tm8Var2.m(vu7Var3 != null ? vu7Var3.m() : "");
        vu7 vu7Var4 = this.B;
        tm8Var2.r(vu7Var4 != null ? vu7Var4.Q() : "");
        tm8Var2.n(true);
        postData2.t0 = tm8Var2;
        tm8Var2.j(1);
        listIterator.add(postData2);
        this.g0.add(postData2);
    }

    public final Cdo S(vu7 vu7Var, ArrayList<Cdo> arrayList, int i) {
        InterceptResult invokeLLI;
        xu7 xu7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048599, this, vu7Var, arrayList, i)) == null) {
            if (vu7Var.l() == null || StringUtils.isNull(vu7Var.l().getName())) {
                return null;
            }
            if (TextUtils.equals(vu7Var.l().getName(), this.a.K().r1()) && this.a.K().x1()) {
                return null;
            }
            if (!this.a.u0() && !ListUtils.isEmpty(vu7Var.p())) {
                xu7Var = new xu7(vu7Var.p().get(0));
            } else {
                xu7Var = new xu7(vu7Var.l());
            }
            xu7Var.g = this.a.K().m2();
            ListUtils.add(arrayList, i + 1, xu7Var);
            return xu7Var;
        }
        return (Cdo) invokeLLI.objValue;
    }

    public final Cdo T(vu7 vu7Var, PostData postData, ArrayList<Cdo> arrayList, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048600, this, vu7Var, postData, arrayList, i)) == null) {
            yu7 yu7Var = null;
            if (vu7Var.l() == null || StringUtils.isNull(vu7Var.l().getName()) || !TextUtils.equals(vu7Var.l().getName(), this.a.K().r1()) || !this.a.K().x1()) {
                if (postData != null) {
                    if (postData.i0 != null) {
                        yu7Var = new yu7(postData.i0);
                    }
                } else {
                    PostData postData2 = this.P;
                    if (postData2 != null && postData2.i0 != null) {
                        yu7Var = new yu7(this.P.i0);
                    }
                }
                if (yu7Var != null) {
                    yu7Var.b = this.a.K().m2();
                    ListUtils.add(arrayList, i + 1, yu7Var);
                }
                return yu7Var;
            }
            return null;
        }
        return (Cdo) invokeLLLI.objValue;
    }

    public final yx7 U(ArrayList<Cdo> arrayList, Cdo cdo, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048601, this, arrayList, cdo, i, i2)) == null) {
            yx7 B = this.B.B();
            if (B != null) {
                if (cdo != null) {
                    if (i2 >= 0 || cdo.getType() == AdvertAppInfo.z) {
                        i2 = cdo.getType() != AdvertAppInfo.z ? i2 + 1 : -1;
                    } else {
                        i2 = i + 2;
                    }
                }
                if (i2 <= 0 || !(B instanceof yx7)) {
                    return null;
                }
                ListUtils.add(arrayList, i2, B);
                return B;
            }
            return null;
        }
        return (yx7) invokeLLII.objValue;
    }

    public final void V(vu7 vu7Var, ArrayList<Cdo> arrayList, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048602, this, vu7Var, arrayList, i) == null) {
            iv7 iv7Var = new iv7(iv7.i);
            ThreadData O = vu7Var.O();
            if (O != null) {
                O.getReply_num();
            }
            iv7Var.d = this.a.l6();
            iv7Var.c = vu7Var.g;
            vu7Var.c();
            iv7Var.e = vu7Var.i0();
            iv7Var.g = vu7Var.f;
            iv7Var.h = O != null && O.isQuestionThread();
            ListUtils.add(arrayList, i, iv7Var);
            if (vu7Var.L() == 4) {
                ListUtils.add(arrayList, i + 1, new hv7());
            }
        }
    }

    public final Cdo W(ArrayList<Cdo> arrayList, int i) {
        InterceptResult invokeLI;
        PbModel K;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048603, this, arrayList, i)) == null) {
            if (i < 0 || (K = this.a.K()) == null || TextUtils.isEmpty(K.W1())) {
                return null;
            }
            um8 um8Var = new um8();
            l(um8Var);
            ListUtils.add(arrayList, i + 1, um8Var);
            return um8Var;
        }
        return (Cdo) invokeLI.objValue;
    }

    public final void X(PostData postData, ArrayList<Cdo> arrayList, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048604, this, postData, arrayList, i) == null) {
            postData.b1(true);
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
            if (this.b.getAdapter2() instanceof un) {
                this.b.getAdapter2().notifyDataSetChanged();
            }
        }
    }

    public void b0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            if (i == 1) {
                qx7 qx7Var = this.c;
                if (qx7Var != null) {
                    qx7Var.P();
                }
                qn qnVar = this.p;
                if (qnVar instanceof dd8) {
                    ((dd8) qnVar).onPause();
                }
                qn qnVar2 = this.q;
                if (qnVar2 instanceof dd8) {
                    ((dd8) qnVar2).onPause();
                }
                qn qnVar3 = this.s;
                if (qnVar3 instanceof dd8) {
                    ((dd8) qnVar3).onPause();
                }
                lx7.a().j(this.a.P());
                wb5.a().d();
            } else if (i == 2) {
                qx7 qx7Var2 = this.c;
                if (qx7Var2 != null) {
                    qx7Var2.R();
                }
                qn qnVar4 = this.p;
                if (qnVar4 instanceof dd8) {
                    ((dd8) qnVar4).onResume();
                }
                qn qnVar5 = this.q;
                if (qnVar5 instanceof dd8) {
                    ((dd8) qnVar5).onResume();
                }
                qn qnVar6 = this.s;
                if (qnVar6 instanceof dd8) {
                    ((dd8) qnVar6).onResume();
                }
                h0(false);
                g0();
            } else if (i != 3) {
            } else {
                qx7 qx7Var3 = this.c;
                if (qx7Var3 != null) {
                    qx7Var3.Q();
                }
                qn qnVar7 = this.p;
                if (qnVar7 instanceof dd8) {
                    ((dd8) qnVar7).onDestroy();
                }
                qn qnVar8 = this.q;
                if (qnVar8 instanceof dd8) {
                    ((dd8) qnVar8).onDestroy();
                }
                qn qnVar9 = this.s;
                if (qnVar9 instanceof dd8) {
                    ((dd8) qnVar9).onDestroy();
                }
                lx7.a().d();
            }
        }
    }

    public void c0(boolean z, int i) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) || (pbFragment = this.a) == null || pbFragment.P5() == null) {
            return;
        }
        this.a.P5().c2(z, i);
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            gh.a().removeCallbacks(this.b0);
            py7 py7Var = this.h;
            if (py7Var != null) {
                py7Var.onDestroy();
            }
            py7 py7Var2 = this.j;
            if (py7Var2 != null) {
                py7Var2.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.d;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
            hz7 hz7Var = this.g;
            if (hz7Var != null) {
                hz7Var.onDestroy();
            }
            oo5.k().q(false);
        }
    }

    public void e0(boolean z) {
        qx7 qx7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048611, this, z) == null) || (qx7Var = this.c) == null) {
            return;
        }
        qx7Var.O(z);
    }

    public final void f0(boolean z, boolean z2, int i, List<Cdo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), list}) == null) || z || z2) {
            return;
        }
        if ((!this.K && !this.J) || i == -1 || ListUtils.isEmpty(list) || this.L) {
            return;
        }
        this.b0 = new e(this, list);
        gh.a().post(this.b0);
    }

    public void g0() {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || this.B == null || (postData = this.P) == null || postData.T() == null || this.c.I() == null) {
            return;
        }
        wb5.a().c(this.B.Q(), this.B.m(), this.P.T(), this.c.I().r, this.B.O() != null ? this.B.O().getThreadType() : 0);
    }

    public void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048614, this, z) == null) || this.a.P5() == null || this.a.P() == null || this.a.P().j1() == null) {
            return;
        }
        lx7.a().g(this.a.P().j1().D2(), this.h.v(), this.a.P5().c1(), this.a.P().getPageStayDurationItem(), z, this.A.b(), this.a.getListView());
    }

    public void i0(vu7 vu7Var, boolean z) {
        boolean z2;
        PostData postData;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i;
        int i2;
        yx7 yx7Var;
        boolean z7;
        List<Cdo> list;
        int i3;
        Cdo cdo;
        int i4;
        PostData postData2;
        PostData postData3;
        PostData postData4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048615, this, vu7Var, z) == null) || vu7Var == null) {
            return;
        }
        this.B = vu7Var;
        if (!UbsABTestHelper.isPbCommentFunAdABTest()) {
            D0();
        }
        if (this.C == null) {
            this.C = new ArrayList<>();
        }
        this.C.clear();
        vu7 vu7Var2 = this.B;
        if (vu7Var2 != null && vu7Var2.F() != null && this.B.F().size() > 0) {
            this.C.addAll(this.B.F());
        }
        if (vu7Var.O() != null && vu7Var.O().getAuthor() != null) {
            this.O = vu7Var.O().getAuthor().getUserId();
        }
        if (this.c == null) {
            return;
        }
        M(vu7Var);
        ArrayList<Cdo> arrayList = new ArrayList<>(vu7Var.F());
        PostData p = p(arrayList);
        PostData q = this.B.O().isQuestionThread() ? q(vu7Var) : null;
        if (q != null) {
            arrayList.remove(q);
        }
        boolean z8 = p != null;
        if (!pu6.f() && UbsABTestHelper.isPbCommentFunAdABTest() && this.B.q0()) {
            K(arrayList, Boolean.valueOf(z8));
        }
        if (p != null) {
            this.P = p;
        }
        if (this.H || p == null) {
            z2 = false;
        } else {
            arrayList.remove(p);
            if (vu7Var.u0() && p.W() != null) {
                p.V0(null);
            }
            z8 = true;
            z2 = true;
        }
        if (z8 || vu7Var.j() == null) {
            postData = p;
            z3 = z2;
        } else {
            PostData j = vu7Var.j();
            if (!this.H && vu7Var.u0() && j.W() != null) {
                j.V0(null);
            }
            if (this.H || (postData4 = this.P) == null || j.g0 != null) {
                postData = j;
            } else {
                vu7Var.D0(postData4);
                postData = postData4;
            }
            z8 = true;
            z3 = true;
        }
        o(arrayList);
        if (this.a.C5()) {
            if (vu7Var.F().size() > 0 && (postData3 = vu7Var.F().get(0)) != null && postData3.C() == 1 && !ListUtils.isEmpty(arrayList)) {
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
        ul8.f(arrayList, 1);
        int A = A(vu7Var, arrayList);
        if (A >= 0) {
            V(vu7Var, arrayList, A);
            z4 = true;
        } else {
            z4 = false;
        }
        int G = G(vu7Var, arrayList);
        if (G >= 0) {
            dv7 dv7Var = new dv7(dv7.c);
            dv7Var.b(true);
            ListUtils.add(arrayList, G, dv7Var);
        }
        int u = u(vu7Var, arrayList);
        List<Cdo> v = v(vu7Var);
        if (!ListUtils.isEmpty(v) && u >= 0) {
            Cdo cdo2 = (Cdo) ListUtils.getItem(arrayList, u);
            if (cdo2 instanceof PostData) {
                ((PostData) cdo2).P = true;
            }
            ListUtils.addAll(arrayList, u, v);
            z4 = true;
        }
        int F = z8 ? F(vu7Var, arrayList, this.H) : -1;
        if (F < 0 || vu7Var.S() == null) {
            if (postData != null) {
                postData.O = true;
            }
            z5 = z4;
            z6 = false;
        } else {
            ListUtils.add(arrayList, F, vu7Var.S());
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
        boolean z9 = T(vu7Var, postData, arrayList, F) != null;
        if (z9) {
            F++;
        }
        if (!z9 && S(vu7Var, arrayList, F) != null) {
            F++;
        }
        if (P(vu7Var, arrayList, F) != null) {
            F++;
        }
        if (z8) {
            Cdo W = W(arrayList, F);
            boolean z10 = W != null;
            if (z10) {
                z7 = z10;
                cdo = W;
                i4 = -1;
            } else {
                i4 = F >= 0 ? F + 1 : u >= 0 ? u : A >= 0 ? A : -1;
                cdo = N(arrayList, i4);
                z7 = cdo != null;
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
                yx7Var = null;
            } else {
                yx7 U = U(arrayList, cdo, F, i4);
                if (U != null) {
                    if (!z7) {
                        yx7Var = U;
                        i = F;
                        z7 = true;
                    } else if (i4 > 0) {
                        i4++;
                    } else {
                        F++;
                    }
                }
                yx7Var = U;
                i = F;
            }
            i2 = i4;
        } else {
            i = F;
            i2 = -1;
            yx7Var = null;
            z7 = false;
        }
        if (z8) {
            list = v;
            i3 = u;
            boolean O = O(vu7Var, arrayList, z7, yx7Var != null, i2, i, u, A);
            if (yx7Var != null) {
                yx7Var.n = O;
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
        if (vu7Var.S() != null) {
            vu7Var.S().j(!z6);
        }
        if (this.b != null) {
            this.D = arrayList;
            List<Cdo> R = vu7Var.R();
            if (!ListUtils.isEmpty(R)) {
                this.b.setData(I(arrayList, R));
            } else {
                this.b.setData(this.D);
            }
        }
        f0(C0, z, i3, list);
        if (r(postData, arrayList, z3)) {
            List<Cdo> R2 = vu7Var.R();
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
            qn qnVar = this.p;
            if (qnVar != null && (qnVar instanceof id8)) {
                ((id8) qnVar).setIsFromCDN(z);
            }
            Iterator<kw7> it = this.x.iterator();
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

    public final void l(um8 um8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048618, this, um8Var) == null) || um8Var == null || this.B == null || um8Var.getAdvertAppInfo() == null) {
            return;
        }
        um8Var.getAdvertAppInfo().i = new qq4();
        if (this.B.y() != null) {
            um8Var.getAdvertAppInfo().i.b = this.B.y().a();
        }
        um8Var.getAdvertAppInfo().i.a = um8Var.l1();
        if (this.B.l() != null && (l = this.B.l()) != null) {
            um8Var.getAdvertAppInfo().i.c = l.getId();
            um8Var.getAdvertAppInfo().i.d = l.getFirst_class();
            um8Var.getAdvertAppInfo().i.e = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            um8Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        um8Var.getAdvertAppInfo().i.g = um8Var.getAdvertAppInfo().g;
        um8Var.getAdvertAppInfo().i.h = false;
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
            ArrayList<BdUniqueId> g = ul8.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                eg7 b2 = jh7.d().b(this.a.getPageContext(), g.get(i), 2);
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

    public final void o(List<Cdo> list) {
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048624, this, list) == null) || list == null || (size = list.size()) <= 0) {
            return;
        }
        for (int i = 0; i < size; i++) {
            if (list.get(i) instanceof PostData) {
                PostData postData = (PostData) list.get(i);
                if (!TextUtils.isEmpty(postData.R())) {
                    bs4 bs4Var = new bs4();
                    bs4Var.h(postData.R());
                    list.set(i, bs4Var);
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

    public final PostData p(ArrayList<Cdo> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, arrayList)) == null) {
            Iterator<Cdo> it = arrayList.iterator();
            while (it.hasNext()) {
                Cdo next = it.next();
                if (next instanceof PostData) {
                    PostData postData = (PostData) next;
                    if (postData.C() == 1) {
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

    public final PostData q(vu7 vu7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, vu7Var)) == null) {
            if (vu7Var == null || vu7Var.U() == null) {
                return null;
            }
            PostData U = vu7Var.U();
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

    public final boolean r(PostData postData, ArrayList<Cdo> arrayList, boolean z) {
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
                postData3.D0(1);
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
        kx7 kx7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048633, this, z) == null) || (kx7Var = this.k) == null) {
            return;
        }
        kx7Var.t0(z);
    }

    public ArrayList<Cdo> t() {
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

    public final int u(vu7 vu7Var, ArrayList<Cdo> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048636, this, vu7Var, arrayList)) == null) {
            if (this.J || vu7Var == null || ListUtils.isEmpty(vu7Var.F()) || arrayList == null || arrayList.size() <= 0) {
                return (vu7Var != null && vu7Var.u0() && this.H) ? 0 : -1;
            } else if (this.a.K() == null || !this.a.K().B1()) {
                if (this.a.P5() == null || !this.a.P5().S0()) {
                    int size = arrayList.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            z = false;
                            i = -1;
                            break;
                        }
                        Cdo cdo = arrayList.get(i);
                        if (cdo instanceof PostData) {
                            PostData postData = (PostData) cdo;
                            if (postData.C() == 1 && postData.M == 0) {
                                z = true;
                                break;
                            }
                        }
                        i++;
                    }
                    return !z ? vu7Var.u0() ? 0 : -1 : i + 1;
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
            kx7 kx7Var = this.k;
            if (kx7Var != null) {
                kx7Var.u0(z);
            }
            py7 py7Var = this.h;
            if (py7Var != null) {
                py7Var.y(z);
            }
            qn qnVar = this.s;
            if (qnVar != null) {
                qnVar.setMulDel(z);
            }
            qn qnVar2 = this.p;
            if (qnVar2 != null) {
                qnVar2.setMulDel(z);
            }
            qx7 qx7Var = this.c;
            if (qx7Var != null) {
                qx7Var.setMulDel(z);
            }
        }
    }

    public final List<Cdo> v(vu7 vu7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, vu7Var)) == null) {
            if (vu7Var == null || vu7Var.T() == null || ListUtils.isEmpty(vu7Var.T().a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<PostData> list = vu7Var.T().a;
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
            if (ListUtils.getCount(vu7Var.T().b) > 2) {
                Cdo cdo = (Cdo) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (cdo instanceof PostData) {
                    ((PostData) cdo).N = false;
                }
                arrayList.add(new x18());
            } else {
                Cdo cdo2 = (Cdo) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (cdo2 instanceof PostData) {
                    ((PostData) cdo2).N = true;
                }
            }
            iv7 iv7Var = new iv7(iv7.j);
            iv7Var.a = vu7Var.T().c;
            arrayList.add(0, iv7Var);
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

    public Cdo x(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048642, this, i)) == null) ? this.b.G(i) : (Cdo) invokeI.objValue;
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
