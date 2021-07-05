package com.baidu.tieba.frs.good;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.permissionhelper.app.ActivityCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.SelectImageHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.c.k.e.n;
import d.a.c.k.e.q;
import d.a.c.k.e.w;
import d.a.r0.r.q.a2;
import d.a.r0.r.q.b2;
import d.a.r0.r.q.x0;
import d.a.s0.h3.m;
import d.a.s0.h3.s;
import d.a.s0.u0.p0;
import d.a.s0.u0.q0;
import d.a.s0.u0.r0;
import d.a.s0.w2.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class FrsGoodFragment extends BaseFragment implements VoiceManager.j, d.a.s0.u0.d2.a, UserIconBox.c, BdListView.p, FrsCommonImageLayout.e, p0, ActivityCompat.OnRequestPermissionsResultCallback, t, q0, d.a.s0.e.e.b, r0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.r0.d0.c A;
    public String B;
    public int C;
    public int D;
    public boolean E;
    public CustomMessageListener F;
    public Runnable G;
    public CustomMessageListener H;
    public CustomMessageListener I;
    public final s J;
    public final CustomMessageListener K;
    public final RecyclerView.OnScrollListener L;
    public final CustomMessageListener M;
    public w N;
    public CustomMessageListener O;

    /* renamed from: e  reason: collision with root package name */
    public String f15830e;

    /* renamed from: f  reason: collision with root package name */
    public String f15831f;

    /* renamed from: g  reason: collision with root package name */
    public String f15832g;

    /* renamed from: h  reason: collision with root package name */
    public int f15833h;

    /* renamed from: i  reason: collision with root package name */
    public int f15834i;
    public boolean j;
    public String k;
    public FrsViewData l;
    public VoiceManager m;
    public long n;
    public long o;
    public long p;
    public FrsGoodModelController q;
    public FrsLoadMoreModel r;
    public d.a.s0.u0.z1.a s;
    public int t;
    public int u;
    public int v;
    public boolean w;
    public SparseArray<d.a.s0.e.e.a> x;
    public d.a.s0.u0.w1.b y;
    public boolean z;

    /* loaded from: classes5.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsGoodFragment f15835a;

        public a(FrsGoodFragment frsGoodFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGoodFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15835a = frsGoodFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) && i2 == 0) {
                d.a.s0.a0.t.b().e(true);
                d.a.s0.g3.c.g().h(this.f15835a.getUniqueId(), true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                this.f15835a.D += i3;
                if (this.f15835a.D < this.f15835a.C * 2 || i3 >= 0) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsGoodFragment f15836a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(FrsGoodFragment frsGoodFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGoodFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15836a = frsGoodFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                this.f15836a.h1(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGoodFragment f15837e;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f15838e;

            public a(c cVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f15838e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    NetWork netWork = new NetWork(this.f15838e);
                    netWork.getNetContext().getRequest().mIsNeedAddCommenParam = false;
                    netWork.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                    netWork.getNetData();
                }
            }
        }

        public c(FrsGoodFragment frsGoodFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGoodFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15837e = frsGoodFragment;
        }

        @Override // d.a.c.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) || bdUniqueId == null || nVar == null || !(nVar instanceof a2)) {
                return;
            }
            b2 b2Var = ((a2) nVar).w;
            if (b2Var.C() == null || b2Var.C().getGroup_id() == 0 || ViewHelper.checkUpIsLogin(this.f15837e.getActivity())) {
                if (b2Var.q() != 1 || ViewHelper.checkUpIsLogin(this.f15837e.getActivity())) {
                    d.a.s0.h3.n0.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null && !readThreadHistory.d(b2Var.c0())) {
                        readThreadHistory.a(b2Var.c0());
                        d.a.s0.u0.z1.a aVar = this.f15837e.s;
                        if (aVar != null) {
                            aVar.v();
                        }
                    }
                    String x = b2Var.x();
                    if (x == null || x.equals("")) {
                        z = false;
                    } else {
                        new Thread(new a(this, x)).start();
                        z = true;
                    }
                    String n1 = b2Var != null ? b2Var.n1() : null;
                    if (n1 == null) {
                        n1 = "";
                    }
                    if (b2Var.m0() == 2 && !n1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                        UrlManager.getInstance().dealOneLink(this.f15837e.getPageContext(), new String[]{n1, "", null});
                        return;
                    }
                    if (n1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && n1.length() > 3 && n1.length() > 3) {
                        b2Var.v3(n1.substring(3));
                    }
                    PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.f15837e.getPageContext().getPageActivity()).createFromThreadCfg(b2Var, this.f15837e.f15831f, "frs_page", 18003, true, false, z);
                    createFromThreadCfg.setForumId(String.valueOf(b2Var.Q()));
                    createFromThreadCfg.setStartFrom(3);
                    this.f15837e.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                    if (this.f15837e.l == null || this.f15837e.l.getForum() == null) {
                        return;
                    }
                    d.a.s0.u0.j2.b bVar = new d.a.s0.u0.j2.b();
                    bVar.f66175a = this.f15837e.l.needLog == 1;
                    bVar.f66177c = this.f15837e.l.getForum().getId();
                    d.a.s0.u0.j2.b bVar2 = d.a.s0.u0.j2.d.h0;
                    if (bVar2 != null) {
                        bVar.f66178d = bVar2.f66178d;
                        bVar.f66179e = bVar2.f66179e;
                    }
                    d.a.s0.u0.j2.a.c(b2Var, 1, this.f15837e.getUniqueId(), bVar, this.f15837e.getTbPageTag());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsGoodFragment f15839a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(FrsGoodFragment frsGoodFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGoodFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15839a = frsGoodFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.s0.u0.z1.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || (aVar = this.f15839a.s) == null) {
                return;
            }
            aVar.y();
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsGoodFragment f15840a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(FrsGoodFragment frsGoodFragment, int i2, boolean z) {
            super(i2, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGoodFragment, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15840a = frsGoodFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer) || (num = (Integer) customResponsedMessage.getData()) == null || this.f15840a.A == null || !this.f15840a.A.isViewAttached()) {
                return;
            }
            this.f15840a.A.a(num.intValue());
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGoodFragment f15841e;

        public f(FrsGoodFragment frsGoodFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGoodFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15841e = frsGoodFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!d.a.c.e.p.j.z() || this.f15841e.w) {
                    this.f15841e.B1(null);
                } else {
                    this.f15841e.r1(false);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsGoodFragment f15842a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(FrsGoodFragment frsGoodFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGoodFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15842a = frsGoodFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof b2)) {
                b2 b2Var = (b2) customResponsedMessage.getData();
                this.f15842a.f15830e = b2Var.c0();
                if (TextUtils.isEmpty(this.f15842a.f15830e) || b2Var.G0() == null) {
                    return;
                }
                this.f15842a.E1(b2Var.G0().getIsLike());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsGoodFragment f15843a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(FrsGoodFragment frsGoodFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGoodFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15843a = frsGoodFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 301) {
                if (this.f15843a.i1() != null) {
                    this.f15843a.i1().setSelection(0);
                }
                if (this.f15843a.A != null && this.f15843a.A.isViewAttached()) {
                    this.f15843a.r1(false);
                    return;
                }
                d.a.s0.u0.z1.a aVar = this.f15843a.s;
                if (aVar != null) {
                    aVar.Z();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f15844a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrsGoodFragment f15845b;

        public i(FrsGoodFragment frsGoodFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGoodFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15845b = frsGoodFragment;
            this.f15844a = 1L;
        }

        @Override // d.a.s0.h3.s
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f15845b.z) {
                return;
            }
            if (i2 == 1 || i2 == 2) {
                this.f15845b.s.v();
            } else if (i2 != 3) {
            } else {
                this.f15845b.s.I(true);
            }
        }

        @Override // d.a.s0.h3.s
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // d.a.s0.h3.s
        public void c(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar) == null) {
            }
        }

        @Override // d.a.s0.h3.s
        public void d(int i2, boolean z, d.a.s0.h3.f fVar) {
            ArrayList<n> C;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), fVar}) == null) {
                if (this.f15845b.z) {
                    if (this.f15845b.l1().x() == null) {
                        this.f15845b.z = false;
                        return;
                    } else if (this.f15845b.l1().x().getThreadList().size() >= 10) {
                        this.f15845b.z = false;
                        d.a.s0.u0.k2.e eVar = new d.a.s0.u0.k2.e();
                        eVar.f66232b = 301;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384, eVar));
                        return;
                    }
                }
                if (fVar == null) {
                    this.f15844a = 1L;
                } else if (fVar.f61178b) {
                    this.f15844a = 0L;
                } else {
                    this.f15844a = 1L;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (i2 == 3) {
                    this.f15845b.r.N();
                }
                this.f15845b.s.I(false);
                if (this.f15845b.l1().x() != null) {
                    FrsGoodFragment frsGoodFragment = this.f15845b;
                    frsGoodFragment.l = frsGoodFragment.l1().x();
                }
                FrsGoodFragment frsGoodFragment2 = this.f15845b;
                frsGoodFragment2.t = frsGoodFragment2.l.getPage().b();
                if (this.f15845b.t != 0 || (this.f15845b.l.getThreadListIds() != null && this.f15845b.l.getThreadListIds().size() != 0)) {
                    if (ListUtils.getCount(this.f15845b.l.getThreadList()) > 3) {
                        this.f15845b.s.X();
                    } else {
                        this.f15845b.s.U();
                    }
                } else if (this.f15845b.l.getThreadList() != null && this.f15845b.l.getThreadList().size() != 0) {
                    this.f15845b.s.Y();
                } else {
                    this.f15845b.s.p();
                }
                if (i2 == 4) {
                    ArrayList<n> C2 = this.f15845b.r.C(false, false, false, this.f15845b.l.getThreadList(), null);
                    if (C2 != null) {
                        this.f15845b.l.setThreadList(C2);
                        FrsGoodFragment frsGoodFragment3 = this.f15845b;
                        frsGoodFragment3.s.T(C2, frsGoodFragment3.f15834i, this.f15845b.l, this.f15845b.t);
                        return;
                    }
                    return;
                }
                if (i2 == 1) {
                    this.f15845b.s.v();
                } else if (i2 != 2) {
                    if (i2 == 3 && this.f15845b.l.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, Boolean.TRUE));
                    }
                } else {
                    this.f15845b.s.v();
                }
                this.f15845b.m();
                if (this.f15844a != 0) {
                    this.f15845b.B1(fVar);
                } else {
                    if (this.f15845b.l != null) {
                        FrsGoodFragment frsGoodFragment4 = this.f15845b;
                        frsGoodFragment4.f15831f = frsGoodFragment4.l.getForum().getName();
                        FrsGoodFragment frsGoodFragment5 = this.f15845b;
                        frsGoodFragment5.k = frsGoodFragment5.l.getForum().getId();
                        FrsGoodFragment frsGoodFragment6 = this.f15845b;
                        frsGoodFragment6.s.z(frsGoodFragment6.l.getForum(), this.f15845b.l.getUserData());
                    }
                    if (this.f15845b.l != null) {
                        this.f15845b.l.addNoticeThreadToThreadList();
                    }
                    FrsGoodFragment frsGoodFragment7 = this.f15845b;
                    frsGoodFragment7.s.O(frsGoodFragment7.l);
                    if (this.f15845b.l == null || this.f15845b.l.getThreadList() == null || this.f15845b.l.getThreadList().size() != 0 || this.f15845b.l1().getType() != 4) {
                        if (this.f15845b.l != null && (C = this.f15845b.r.C(false, false, true, this.f15845b.l.getThreadList(), null)) != null && C.size() > 0) {
                            this.f15845b.l.setThreadList(C);
                        }
                        this.f15845b.u1();
                    } else {
                        FrsGoodFragment frsGoodFragment8 = this.f15845b;
                        frsGoodFragment8.showToast(frsGoodFragment8.getPageContext().getString(R.string.no_more_to_load));
                        if (this.f15845b.f15834i > 1) {
                            FrsGoodFragment.N0(this.f15845b);
                        }
                        if (this.f15845b.n > -1) {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            FrsGoodFragment frsGoodFragment9 = this.f15845b;
                            long z2 = frsGoodFragment9.l1().z();
                            FrsGoodFragment frsGoodFragment10 = this.f15845b;
                            TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis2 - frsGoodFragment9.n, z2 - frsGoodFragment10.n, frsGoodFragment10.l1().B(), this.f15845b.l1().A(), currentTimeMillis2 - this.f15845b.l1().y());
                            this.f15845b.n = -1L;
                        }
                        this.f15845b.o = System.currentTimeMillis() - currentTimeMillis;
                        return;
                    }
                }
                if (this.f15845b.n > -1) {
                    long currentTimeMillis3 = System.currentTimeMillis();
                    FrsGoodFragment frsGoodFragment11 = this.f15845b;
                    long z3 = frsGoodFragment11.l1().z();
                    FrsGoodFragment frsGoodFragment12 = this.f15845b;
                    TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis3 - frsGoodFragment11.n, z3 - frsGoodFragment12.n, frsGoodFragment12.l1().B(), this.f15845b.l1().A(), currentTimeMillis3 - this.f15845b.l1().y());
                    this.f15845b.n = -1L;
                }
                this.f15845b.o = System.currentTimeMillis() - currentTimeMillis;
                System.gc();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsGoodFragment f15846a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(FrsGoodFragment frsGoodFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGoodFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15846a = frsGoodFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.s0.u0.z1.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || (aVar = this.f15846a.s) == null) {
                return;
            }
            aVar.Z();
        }
    }

    /* loaded from: classes5.dex */
    public class k implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGoodFragment f15847e;

        public k(FrsGoodFragment frsGoodFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGoodFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15847e = frsGoodFragment;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (this.f15847e.y != null) {
                    this.f15847e.y.b(view, motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGoodFragment f15848e;

        public l(FrsGoodFragment frsGoodFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGoodFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15848e = frsGoodFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.s0.h3.n0.a.o(this.f15848e.f15831f);
            }
        }
    }

    public FrsGoodFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15831f = null;
        this.f15832g = null;
        this.f15833h = 0;
        this.f15834i = 1;
        this.j = false;
        this.k = null;
        this.l = new FrsViewData();
        this.n = -1L;
        this.p = -1L;
        this.s = null;
        this.t = -1;
        this.u = 0;
        this.v = 3;
        this.w = false;
        this.x = new SparseArray<>();
        this.z = false;
        this.C = 0;
        this.D = 0;
        this.F = new e(this, 2921397, true);
        this.G = new f(this);
        this.H = new g(this, 2004004);
        this.I = new h(this, 2001624);
        this.J = new i(this);
        this.K = new j(this, 2003003);
        this.L = new a(this);
        this.M = new b(this, 0);
        this.N = new c(this);
        this.O = new d(this, 2921414);
    }

    public static /* synthetic */ int N0(FrsGoodFragment frsGoodFragment) {
        int i2 = frsGoodFragment.f15834i;
        frsGoodFragment.f15834i = i2 - 1;
        return i2;
    }

    @Override // d.a.s0.w2.t
    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public final void A1() {
        d.a.s0.u0.z1.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.s) == null) {
            return;
        }
        aVar.J(false);
        showLoadingView(this.s.o(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    public final void B1(d.a.s0.h3.f fVar) {
        d.a.s0.u0.z1.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) || (aVar = this.s) == null) {
            return;
        }
        aVar.J(false);
        this.s.N(false);
        this.s.p();
        this.s.n().getData().clear();
        this.s.v();
        if (this.A == null) {
            d.a.r0.d0.c cVar = new d.a.r0.d0.c(getPageContext().getContext(), getNetRefreshListener());
            this.A = cVar;
            cVar.e(null);
            this.A.c(null);
            this.A.f();
            this.A.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.A.d(getPageContext().getResources().getString(R.string.net_error_text, fVar.f61180d, Integer.valueOf(fVar.f61179c)));
        } else {
            this.A.d(null);
        }
        this.A.onChangeSkinType();
        this.A.attachView(this.s.o(), true);
        this.A.a(0);
    }

    public void C1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            VoiceManager voiceManager = getVoiceManager();
            this.m = voiceManager;
            voiceManager.stopPlay();
        }
    }

    public final void D1(b2 b2Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, b2Var, i2) == null) {
            if (i2 == 1) {
                PraiseData G0 = b2Var.G0();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (G0 == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i2);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        b2Var.Q3(praiseData);
                        return;
                    }
                    b2Var.G0().getUser().add(0, metaData);
                    b2Var.G0().setNum(b2Var.G0().getNum() + 1);
                    b2Var.G0().setIsLike(i2);
                }
            } else if (b2Var.G0() != null) {
                b2Var.G0().setIsLike(i2);
                b2Var.G0().setNum(b2Var.G0().getNum() - 1);
                ArrayList<MetaData> user = b2Var.G0().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            b2Var.G0().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    @Override // d.a.s0.u0.p0
    public void E0() {
        d.a.s0.u0.z1.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (aVar = this.s) == null || aVar.n() == null) {
            return;
        }
        this.s.n().scrollToPosition(0);
    }

    public final void E1(int i2) {
        ArrayList<n> threadList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (threadList = this.l.getThreadList()) == null) {
            return;
        }
        Iterator<n> it = threadList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            n next = it.next();
            if (next instanceof a2) {
                b2 b2Var = ((a2) next).w;
                if (b2Var.c0() != null && b2Var.c0().equals(this.f15830e)) {
                    D1(b2Var, i2);
                    this.f15830e = null;
                    break;
                }
            }
        }
        this.s.m().w(threadList, this.l);
        this.s.m().p();
    }

    @Override // d.a.s0.u0.r0
    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            d.a.s0.g3.c.g().h(getUniqueId(), false);
        }
    }

    @Override // d.a.s0.w2.t
    public void O() {
        FrsGoodModelController frsGoodModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (frsGoodModelController = this.q) == null) {
            return;
        }
        frsGoodModelController.L();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void a(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, arrayList) == null) {
            z1();
            if (arrayList == null || arrayList.size() == 0) {
                return;
            }
            ArrayList<n> C = this.r.C(false, false, false, arrayList, null);
            if (C != null) {
                this.l.setThreadList(C);
                this.s.T(C, this.f15834i, this.l, 0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.l.getForum()));
        }
    }

    @Override // d.a.s0.e.e.b
    public void dispatchInjectPluginMessage(d.a.s0.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dVar) == null) {
        }
    }

    @Override // d.a.s0.u0.q0
    public NavigationBar g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return null;
        }
        return (NavigationBar) invokeV.objValue;
    }

    public void g1(x0 x0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, x0Var) == null) || x0Var == null || i0() == null || i0().getThreadList() == null) {
            return;
        }
        if (ListUtils.isEmpty(i0().getThreadList())) {
            i0().getThreadList().add(x0Var);
        } else {
            if (i0().getThreadList().size() == 1 && (i0().getThreadList().get(0) instanceof d.a.s0.u0.s)) {
                i0().getThreadList().remove(0);
            }
            i0().getThreadList().add(0, x0Var);
        }
        d.a.s0.u0.z1.a aVar = this.s;
        ArrayList<n> threadList = this.l.getThreadList();
        int i2 = this.f15834i;
        FrsViewData frsViewData = this.l;
        aVar.T(threadList, i2, frsViewData, frsViewData.getPage().b());
        this.s.H();
        this.s.K(0);
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public d.a.c.e.k.b<TbImageView> getFrsCommonImageLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (getBaseFragmentActivity() instanceof FrsActivity) {
                return ((FrsActivity) getBaseFragmentActivity()).getFrsCommonImageLayoutPool();
            }
            return null;
        }
        return (d.a.c.e.k.b) invokeV.objValue;
    }

    @Override // d.a.s0.e.e.b
    public d.a.s0.e.e.a getInjectPlugin(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) ? this.x.get(i2) : (d.a.s0.e.e.a) invokeI.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.s0.u0.d2.a
    public /* bridge */ /* synthetic */ d.a.c.a.f getPageContext() {
        return super.getPageContext();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, voiceData$VoiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            TbPageTag tbPageTag = super.getTbPageTag();
            FrsViewData frsViewData = this.l;
            tbPageTag.sortType = d.a.s0.u0.n2.k.g(frsViewData != null ? frsViewData.getSortType() : -1);
            tbPageTag.locatePage = "a072";
            return tbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public d.a.c.e.k.b<TbImageView> getUserIconPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (getBaseFragmentActivity() instanceof FrsActivity) {
                return ((FrsActivity) getBaseFragmentActivity()).getUserIconPool();
            }
            return null;
        }
        return (d.a.c.e.k.b) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.m == null) {
                this.m = VoiceManager.instance();
            }
            return this.m;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // d.a.s0.u0.d2.a, d.a.s0.u0.t0
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f15831f : (String) invokeV.objValue;
    }

    public final void h1(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, responsedMessage) == null) || this.l == null || this.s == null || !(responsedMessage instanceof DownloadMessage) || (data = ((DownloadMessage) responsedMessage).getData()) == null) {
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
            this.s.v();
        }
    }

    @Override // d.a.s0.u0.d2.a
    public FrsViewData i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.l : (FrsViewData) invokeV.objValue;
    }

    public BdTypeRecyclerView i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            d.a.s0.u0.z1.a aVar = this.s;
            if (aVar == null) {
                return null;
            }
            return aVar.n();
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public final int j1(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048600, this, i2, i3)) == null) {
            if (i2 != 1) {
                return (i2 != 2 || i3 == 1) ? 0 : 3;
            }
            return 3;
        }
        return invokeII.intValue;
    }

    public FrsLoadMoreModel k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.r : (FrsLoadMoreModel) invokeV.objValue;
    }

    @Override // d.a.s0.u0.r0
    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (getPageContext() != null) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            }
            if (d.a.c.e.p.j.z()) {
                d.a.s0.o.d.c().f("page_frs_good");
                r1(true);
                return;
            }
            this.s.I(false);
        }
    }

    public FrsGoodModelController l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.q : (FrsGoodModelController) invokeV.objValue;
    }

    public final void m() {
        d.a.s0.u0.z1.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (aVar = this.s) == null) {
            return;
        }
        aVar.J(true);
        hideLoadingView(this.s.o());
    }

    public final void m1() {
        d.a.s0.u0.z1.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (aVar = this.s) == null) {
            return;
        }
        aVar.J(true);
        this.s.N(true);
        d.a.r0.d0.c cVar = this.A;
        if (cVar == null || !cVar.isViewAttached()) {
            return;
        }
        this.A.dettachView(this.s.o());
    }

    @Override // d.a.s0.w2.t
    public TbPageContext<?> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? getPageContext() : (TbPageContext) invokeV.objValue;
    }

    public final void n1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            registerListener(2001118, this.M);
        }
    }

    public final void o1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, bundle) == null) {
            n1();
            if (bundle != null) {
                this.f15831f = bundle.getString("name");
                this.f15832g = bundle.getString("from");
                this.f15833h = bundle.getInt("flag", 0);
            } else {
                Bundle arguments = getArguments();
                if (arguments != null) {
                    this.f15831f = arguments.getString("name");
                    this.f15832g = arguments.getString("from");
                    this.f15833h = arguments.getInt("flag", 0);
                }
            }
            if (TextUtils.isEmpty(this.f15832g) || !FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.f15832g)) {
                return;
            }
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        b2 threadDataById;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048609, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1 && i2 == 18003) {
                this.s.m().p();
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra == null || (threadDataById = this.l.getThreadDataById(stringExtra)) == null) {
                    return;
                }
                int intExtra = intent.getIntExtra("type", -1);
                if (intExtra == 2) {
                    threadDataById.C3(intent.getIntExtra("good_data", 0));
                    threadDataById.M2();
                    r1(false);
                } else if (intExtra == 0) {
                    this.l.removeThreadData(threadDataById);
                    ArrayList<n> threadList = this.l.getThreadList();
                    if (threadList != null && threadList.size() <= 0) {
                        threadList.add(new d.a.s0.u0.s());
                    }
                    this.s.H();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            if (this.v == 3 && this.s == null) {
                return;
            }
            this.v = i2;
            super.onChangeSkinType(i2);
            d.a.s0.u0.z1.a aVar = this.s;
            if (aVar != null) {
                aVar.w(i2);
            }
            d.a.r0.d0.c cVar = this.A;
            if (cVar == null || !cVar.isViewAttached()) {
                return;
            }
            this.A.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, bundle) == null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.n = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
            } else {
                this.n = System.currentTimeMillis();
            }
            if (arguments != null) {
                this.B = arguments.getString("forum_id", "");
                this.E = arguments.getBoolean(FrsActivityConfig.FLAG_SHOW_AD);
            }
            this.p = System.currentTimeMillis();
            super.onCreate(bundle);
            d.a.s0.g3.c.g().i(getUniqueId());
            FrsGoodModelController frsGoodModelController = new FrsGoodModelController(this);
            this.q = frsGoodModelController;
            if (arguments != null) {
                frsGoodModelController.D(arguments);
                this.j = arguments.getBoolean("is_game_frs", false);
            } else if (bundle != null) {
                frsGoodModelController.D(bundle);
                this.j = bundle.getBoolean("is_game_frs", false);
            } else {
                frsGoodModelController.D(null);
            }
            VoiceManager voiceManager = getVoiceManager();
            this.m = voiceManager;
            voiceManager.onCreate(getPageContext());
            o1(bundle);
            registerListener(this.K);
            registerListener(this.H);
            registerListener(this.I);
            registerListener(this.O);
            registerListener(this.F);
            FrsLoadMoreModel frsLoadMoreModel = new FrsLoadMoreModel(this, null);
            this.r = frsLoadMoreModel;
            frsLoadMoreModel.registerListener();
            this.r.S(2);
            this.r.P(true);
            this.r.O(d.a.s0.w0.a.a(this.E));
            System.currentTimeMillis();
            this.C = UtilHelper.getScreenHeight(getActivity());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048612, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
            d.a.s0.u0.z1.a aVar = new d.a.s0.u0.z1.a(this, inflate, this.j);
            this.s = aVar;
            aVar.m().A();
            p1();
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            d.a.s0.u0.z1.a aVar = this.s;
            if (aVar != null) {
                aVar.x();
            }
            MessageManager.getInstance().unRegisterListener(this.F);
            d.a.s0.g3.c.g().k(getUniqueId());
            d.a.s0.a0.t.b().e(false);
            super.onDestroy();
            this.q.H();
            VoiceManager voiceManager = getVoiceManager();
            this.m = voiceManager;
            voiceManager.onDestory(getPageContext());
            d.a.c.e.m.e.a().removeCallbacks(this.G);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void onFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            z1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public q onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            if (i1() == null) {
                return null;
            }
            return i1().getPreLoadHandle();
        }
        return (q) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            super.onLazyLoad();
            if (this.w) {
                return;
            }
            if (d.a.c.e.p.j.z()) {
                r1(false);
            } else {
                B1(null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            TiebaStatic.log(new StatisticItem("c13008").param("fid", this.B).param("obj_type", "7").param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048618, this) == null) && d.a.c.e.p.j.z()) {
            r1(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            super.onPause();
            VoiceManager voiceManager = getVoiceManager();
            this.m = voiceManager;
            voiceManager.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                if (this.v == 3) {
                    onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                }
                if (this.w) {
                    return;
                }
                d.a.c.e.m.e.a().post(this.G);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048621, this, i2, strArr, iArr) == null) && i2 == 1) {
            if (PermissionUtil.checkCamera(getActivity().getApplicationContext())) {
                SelectImageHelper.takePhoto(getPageContext());
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = PermissionUtil.transformPermissionResult(strArr, iArr);
            if (!transformPermissionResult.containsKey(StorageUtils.EXTERNAL_STORAGE_PERMISSION) || transformPermissionResult.get(StorageUtils.EXTERNAL_STORAGE_PERMISSION).booleanValue()) {
                return;
            }
            showToast(R.string.sdcard_permission_denied_advert_for_camera);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            super.onResume();
            d.a.s0.u0.z1.a aVar = this.s;
            if (aVar != null) {
                aVar.v();
            }
            VoiceManager voiceManager = getVoiceManager();
            this.m = voiceManager;
            voiceManager.onResume(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("name", this.f15831f);
            bundle.putString("from", this.f15832g);
            bundle.putBoolean("is_game_frs", this.j);
            this.q.onSaveInstanceState(bundle);
            VoiceManager voiceManager = getVoiceManager();
            this.m = voiceManager;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            if (!d.a.c.e.p.l.D()) {
                this.s.p();
            } else if (!this.q.C()) {
                this.s.p();
            } else {
                z1();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
                if (this.r.isLoading || this.q.E()) {
                    return;
                }
                if (this.r.A(this.l.getThreadListIds())) {
                    FrsViewData frsViewData = this.l;
                    String e2 = d.a.s0.w2.a.e(frsViewData != null ? frsViewData.getThreadList() : null, false);
                    this.s.T(this.r.L(), this.f15834i, this.l, 0);
                    this.r.M(d.a.c.e.m.b.f(this.k, 0L), this.l.getThreadListIds(), this.f15831f, this.f15834i, this.l.isBrandForum, e2);
                } else if (this.t != 0) {
                    FrsViewData frsViewData2 = this.l;
                    String e3 = d.a.s0.w2.a.e(frsViewData2 != null ? frsViewData2.getThreadList() : null, false);
                    this.s.T(this.r.L(), this.f15834i, this.l, 0);
                    int i2 = this.f15834i + 1;
                    this.f15834i = i2;
                    this.q.G(i2, e3);
                    FrsLoadMoreModel frsLoadMoreModel = this.r;
                    frsLoadMoreModel.loadingDone = false;
                    frsLoadMoreModel.loadIndex = 0;
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            super.onStart();
            VoiceManager voiceManager = getVoiceManager();
            this.m = voiceManager;
            voiceManager.onStart(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            super.onStop();
            d.a.s0.a0.t.b().e(false);
            d.a.s0.g3.c.g().h(getUniqueId(), false);
            FrsViewData frsViewData = this.l;
            if (frsViewData != null && frsViewData.getForum() != null) {
                d.a.r0.u.a.k().y(getPageContext().getPageActivity(), "frs", this.l.getForum().getId(), 0L);
            }
            VoiceManager voiceManager = getVoiceManager();
            this.m = voiceManager;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
        }
    }

    public final void p1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            if (this.f15833h != 0) {
                this.f15833h = 1;
            }
            this.y = new d.a.s0.u0.w1.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
            this.s.L(this.N);
            this.s.M(this.L);
            this.s.n().setOnTouchListener(new k(this));
        }
    }

    public void q1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048628, this, i2) == null) {
            this.u = i2;
            if (d.a.c.e.p.j.z()) {
                r1(false);
            } else {
                B1(null);
            }
        }
    }

    public final void r1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
            this.w = true;
            C1();
            m1();
            if (!z) {
                m1();
                A1();
            }
            FrsGoodModelController frsGoodModelController = this.q;
            if (frsGoodModelController != null) {
                frsGoodModelController.F(this.u);
            }
        }
    }

    @Override // d.a.s0.u0.p0
    public void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048630, this) == null) || this.s == null) {
            return;
        }
        E0();
        this.s.Z();
    }

    public final void s1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            if (this.f15833h == 1) {
                d.a.c.e.m.h.a().b(new l(this));
            }
            this.f15833h = 0;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, str) == null) {
            this.f15832g = str;
        }
    }

    @Override // d.a.s0.e.e.b
    public void setInjectPlugin(int i2, d.a.s0.e.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048633, this, i2, aVar) == null) {
            this.x.put(i2, aVar);
        }
    }

    public final void t1() {
        d.a.s0.u0.z1.a aVar;
        HashMap<Integer, b2> j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048634, this) == null) || (aVar = this.s) == null || aVar.m() == null || (j2 = this.s.m().j()) == null) {
            return;
        }
        ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
        for (Map.Entry<Integer, b2> entry : j2.entrySet()) {
            b2 value = entry.getValue();
            if (value != null && (value instanceof AdvertAppInfo)) {
                arrayList.add((AdvertAppInfo) value);
            }
        }
        d.a.r0.v.b.l().m(arrayList);
    }

    public final void u1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            C1();
            try {
                if (this.l == null) {
                    return;
                }
                this.s.F();
                this.s.W();
                this.f15831f = this.l.getForum().getName();
                this.k = this.l.getForum().getId();
                if (this.l != null && this.l.getForum() != null) {
                    this.s.S(this.l.getForum().getThemeColorInfo());
                    this.s.O(this.l);
                }
                TbadkCoreApplication.getInst().setDefaultBubble(this.l.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.l.getUserData().getBimg_end_time());
                s1();
                if (!this.s.m().o(b2.m3)) {
                    this.l.removeAlaLiveThreadData();
                }
                ArrayList<n> threadList = this.l.getThreadList();
                if (threadList != null) {
                    this.s.T(threadList, this.f15834i, this.l, this.l.getPage().b());
                    t1();
                    this.s.H();
                    if (this.l.getIsNewUrl() == 1) {
                        this.s.m().x(true);
                    } else {
                        this.s.m().x(false);
                    }
                    this.s.K(j1(l1().getType(), this.f15834i));
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void v1() {
        d.a.s0.u0.z1.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048636, this) == null) || (aVar = this.s) == null) {
            return;
        }
        aVar.A();
    }

    @Override // d.a.s0.w2.t
    public int w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.f15834i : invokeV.intValue;
    }

    public void w1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i2) == null) {
            this.f15833h = i2;
        }
    }

    public void x1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, str) == null) {
            this.f15831f = str;
        }
    }

    public void y1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048640, this, i2) == null) {
            this.f15834i = i2;
        }
    }

    public final void z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            if (this.t == 0 && !this.r.A(this.l.getThreadListIds())) {
                if (this.l.getThreadList() != null && this.l.getThreadList().size() != 0) {
                    this.s.Y();
                } else {
                    this.s.p();
                }
            } else if (ListUtils.getCount(this.l.getThreadList()) > 3) {
                this.s.X();
            } else {
                this.s.U();
            }
        }
    }
}
