package com.baidu.tieba.frs.mc;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.core.app.ActivityCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.l;
import c.a.d.o.e.n;
import c.a.d.o.e.q;
import c.a.q0.r.r.d2;
import c.a.q0.r.r.e2;
import c.a.r0.d1.q0;
import c.a.r0.d1.r0;
import c.a.r0.d1.r2.p;
import c.a.r0.d1.s;
import c.a.r0.d1.s0;
import c.a.r0.j3.v;
import c.a.r0.y3.u;
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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.SelectImageHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
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
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class FrsNewAreaFragment extends BaseFragment implements VoiceManager.j, c.a.r0.d1.g2.a, UserIconBox.c, BdListView.p, FrsCommonImageLayout.e, q0, ActivityCompat.OnRequestPermissionsResultCallback, v, r0, c.a.r0.h.e.b, s0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener A;
    public final CustomMessageListener B;
    public final RecyclerView.OnScrollListener C;
    public final CustomMessageListener D;
    public c.a.d.o.e.v E;
    public long beginTime;
    public long createTime;
    public long drawTime;

    /* renamed from: e  reason: collision with root package name */
    public String f42320e;

    /* renamed from: f  reason: collision with root package name */
    public String f42321f;
    public c.a.r0.d1.h2.g frsNewAreaView;

    /* renamed from: g  reason: collision with root package name */
    public String f42322g;

    /* renamed from: h  reason: collision with root package name */
    public int f42323h;

    /* renamed from: i  reason: collision with root package name */
    public int f42324i;
    public long initTime;

    /* renamed from: j  reason: collision with root package name */
    public String f42325j;
    public FrsViewData k;
    public VoiceManager l;
    public FrsNewAreaModelController m;
    public final u mForumModelCallback;
    public FrsLoadMoreModel n;
    public int o;
    public int p;
    public boolean q;
    public boolean r;
    public c.a.q0.f0.c s;
    public long sysCreateTime;
    public SparseArray<c.a.r0.h.e.a> t;
    public int u;
    public int v;
    public boolean w;
    public CustomMessageListener x;
    public Runnable y;
    public CustomMessageListener z;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsNewAreaFragment f42326e;

        public a(FrsNewAreaFragment frsNewAreaFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsNewAreaFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42326e = frsNewAreaFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.r0.d1.h2.g gVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (gVar = this.f42326e.frsNewAreaView) == null || gVar.k() == null || this.f42326e.frsNewAreaView.k().isComputingLayout()) {
                return;
            }
            this.f42326e.frsNewAreaView.t();
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsNewAreaFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(FrsNewAreaFragment frsNewAreaFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsNewAreaFragment, Integer.valueOf(i2)};
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
            this.a = frsNewAreaFragment;
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
                this.a.H(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements c.a.d.o.e.v {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsNewAreaFragment f42327e;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f42328e;

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
                this.f42328e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    NetWork netWork = new NetWork(this.f42328e);
                    netWork.getNetContext().getRequest().mIsNeedAddCommenParam = false;
                    netWork.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                    netWork.getNetData();
                }
            }
        }

        public c(FrsNewAreaFragment frsNewAreaFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsNewAreaFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42327e = frsNewAreaFragment;
        }

        @Override // c.a.d.o.e.v
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || bdUniqueId == null || nVar == null || !(nVar instanceof d2)) {
                return;
            }
            e2 e2Var = ((d2) nVar).w;
            if (e2Var.E() == null || e2Var.E().getGroup_id() == 0 || ViewHelper.checkUpIsLogin(this.f42327e.getActivity())) {
                if (e2Var.w() != 1 || ViewHelper.checkUpIsLogin(this.f42327e.getActivity())) {
                    c.a.r0.y3.q0.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null && !readThreadHistory.d(e2Var.h0())) {
                        readThreadHistory.a(e2Var.h0());
                        c.a.r0.d1.h2.g gVar = this.f42327e.frsNewAreaView;
                        if (gVar != null) {
                            gVar.p();
                        }
                    }
                    String z2 = e2Var.z();
                    if (z2 == null || z2.equals("")) {
                        z = false;
                    } else {
                        new Thread(new a(this, z2)).start();
                        z = true;
                    }
                    String w1 = e2Var.w1();
                    if (w1 == null) {
                        w1 = "";
                    }
                    if (e2Var.t0() == 2 && !w1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                        UrlManager.getInstance().dealOneLink(this.f42327e.getPageContext(), new String[]{w1, "", null});
                        return;
                    }
                    if (w1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && w1.length() > 3) {
                        e2Var.T3(w1.substring(3));
                    }
                    PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.f42327e.getPageContext().getPageActivity()).createFromThreadCfg(e2Var, this.f42327e.f42321f, FrsFragment.STAR_FRS, 18003, true, false, z);
                    createFromThreadCfg.setForumId(String.valueOf(e2Var.U()));
                    createFromThreadCfg.setStartFrom(3);
                    this.f42327e.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                    if (this.f42327e.k == null || this.f42327e.k.getForum() == null) {
                        return;
                    }
                    c.a.r0.d1.o2.b bVar = new c.a.r0.d1.o2.b();
                    bVar.a = this.f42327e.k.needLog == 1;
                    bVar.f15918c = this.f42327e.k.getForum().getId();
                    bVar.f15919d = this.f42327e.k.getForum().getName();
                    bVar.f15917b = this.f42327e.m.y();
                    c.a.r0.d1.o2.b bVar2 = c.a.r0.d1.o2.d.p0;
                    if (bVar2 != null) {
                        bVar.f15920e = bVar2.f15920e;
                        bVar.f15921f = bVar2.f15921f;
                    }
                    c.a.r0.d1.o2.a.e(e2Var, 1, this.f42327e.getUniqueId(), bVar, this.f42327e.getTbPageTag());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsNewAreaFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(FrsNewAreaFragment frsNewAreaFragment, int i2, boolean z) {
            super(i2, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsNewAreaFragment, Integer.valueOf(i2), Boolean.valueOf(z)};
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
            this.a = frsNewAreaFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer) || (num = (Integer) customResponsedMessage.getData()) == null || this.a.s == null || !this.a.s.isViewAttached()) {
                return;
            }
            this.a.s.a(num.intValue());
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsNewAreaFragment f42329e;

        public e(FrsNewAreaFragment frsNewAreaFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsNewAreaFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42329e = frsNewAreaFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!l.z() || this.f42329e.q) {
                    this.f42329e.R(null);
                } else {
                    this.f42329e.M(false);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsNewAreaFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(FrsNewAreaFragment frsNewAreaFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsNewAreaFragment, Integer.valueOf(i2)};
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
            this.a = frsNewAreaFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof e2)) {
                e2 e2Var = (e2) customResponsedMessage.getData();
                this.a.f42320e = e2Var.h0();
                if (TextUtils.isEmpty(this.a.f42320e) || e2Var.N0() == null) {
                    return;
                }
                this.a.T(e2Var.N0().getIsLike());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsNewAreaFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(FrsNewAreaFragment frsNewAreaFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsNewAreaFragment, Integer.valueOf(i2)};
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
            this.a = frsNewAreaFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 503) {
                if (this.a.getListView() != null) {
                    this.a.getListView().setSelection(0);
                }
                if (this.a.s != null && this.a.s.isViewAttached()) {
                    this.a.M(false);
                    return;
                }
                c.a.r0.d1.h2.g gVar = this.a.frsNewAreaView;
                if (gVar != null) {
                    gVar.L();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrsNewAreaFragment f42330b;

        public h(FrsNewAreaFragment frsNewAreaFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsNewAreaFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42330b = frsNewAreaFragment;
            this.a = 1L;
        }

        @Override // c.a.r0.y3.u
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f42330b.r) {
                return;
            }
            if (i2 == 1 || i2 == 2) {
                this.f42330b.frsNewAreaView.p();
            } else if (i2 != 3) {
            } else {
                this.f42330b.frsNewAreaView.A(true);
            }
        }

        @Override // c.a.r0.y3.u
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // c.a.r0.y3.u
        public void c(c.a.r0.y3.n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nVar) == null) {
            }
        }

        @Override // c.a.r0.y3.u
        public void d(int i2, boolean z, c.a.r0.y3.f fVar) {
            ArrayList<n> D;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), fVar}) == null) {
                if (this.f42330b.r) {
                    if (this.f42330b.getModelController().z() == null) {
                        this.f42330b.r = false;
                        return;
                    } else if (this.f42330b.getModelController().z().getThreadList().size() >= 10) {
                        this.f42330b.r = false;
                        c.a.r0.d1.p2.e eVar = new c.a.r0.d1.p2.e();
                        eVar.f16047b = 301;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384, eVar));
                        return;
                    }
                }
                if (fVar == null) {
                    this.a = 1L;
                } else if (fVar.f24982b) {
                    this.a = 0L;
                } else {
                    this.a = 1L;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (i2 == 3) {
                    this.f42330b.n.P();
                }
                this.f42330b.frsNewAreaView.A(false);
                if (this.f42330b.getModelController().z() != null) {
                    FrsNewAreaFragment frsNewAreaFragment = this.f42330b;
                    frsNewAreaFragment.k = frsNewAreaFragment.getModelController().z();
                }
                FrsNewAreaFragment frsNewAreaFragment2 = this.f42330b;
                frsNewAreaFragment2.o = frsNewAreaFragment2.k.getPage().b();
                if (this.f42330b.o == 0 && (this.f42330b.k.getThreadListIds() == null || this.f42330b.k.getThreadListIds().size() == 0)) {
                    if (this.f42330b.k.getThreadList() != null && this.f42330b.k.getThreadList().size() != 0) {
                        this.f42330b.frsNewAreaView.K();
                    } else {
                        this.f42330b.frsNewAreaView.m();
                    }
                } else {
                    this.f42330b.frsNewAreaView.J();
                }
                if (i2 == 4) {
                    ArrayList<n> D2 = this.f42330b.n.D(false, false, false, this.f42330b.k.getThreadList(), null);
                    if (D2 != null) {
                        this.f42330b.k.setThreadList(D2);
                        FrsNewAreaFragment frsNewAreaFragment3 = this.f42330b;
                        frsNewAreaFragment3.frsNewAreaView.H(D2, frsNewAreaFragment3.f42324i, this.f42330b.k, this.f42330b.o);
                        return;
                    }
                    return;
                }
                if (i2 == 1) {
                    this.f42330b.frsNewAreaView.p();
                } else if (i2 != 2) {
                    if (i2 == 3 && this.f42330b.k.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, Boolean.TRUE));
                    }
                } else {
                    this.f42330b.frsNewAreaView.p();
                }
                this.f42330b.hideLoadingView();
                if (this.a != 0) {
                    this.f42330b.R(fVar);
                } else {
                    this.f42330b.hideNetRefreshView();
                    if (this.f42330b.k != null) {
                        FrsNewAreaFragment frsNewAreaFragment4 = this.f42330b;
                        frsNewAreaFragment4.f42321f = frsNewAreaFragment4.k.getForum().getName();
                        FrsNewAreaFragment frsNewAreaFragment5 = this.f42330b;
                        frsNewAreaFragment5.f42325j = frsNewAreaFragment5.k.getForum().getId();
                        FrsNewAreaFragment frsNewAreaFragment6 = this.f42330b;
                        frsNewAreaFragment6.frsNewAreaView.s(frsNewAreaFragment6.k.getForum(), this.f42330b.k.getUserData());
                    }
                    if (this.f42330b.k != null) {
                        this.f42330b.k.addNoticeThreadToThreadList();
                    }
                    if (this.f42330b.k == null || this.f42330b.k.getThreadList() == null || this.f42330b.k.getThreadList().size() != 0 || this.f42330b.getModelController().getType() != 4) {
                        if (this.f42330b.k != null && (D = this.f42330b.n.D(false, false, true, this.f42330b.k.getThreadList(), null)) != null && D.size() > 0) {
                            this.f42330b.k.setThreadList(D);
                        }
                        this.f42330b.P();
                    } else {
                        FrsNewAreaFragment frsNewAreaFragment7 = this.f42330b;
                        frsNewAreaFragment7.showToast(frsNewAreaFragment7.getPageContext().getString(R.string.no_more_to_load));
                        if (this.f42330b.f42324i > 1) {
                            FrsNewAreaFragment.j(this.f42330b);
                        }
                        if (this.f42330b.initTime > -1) {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            FrsNewAreaFragment frsNewAreaFragment8 = this.f42330b;
                            long B = frsNewAreaFragment8.getModelController().B();
                            FrsNewAreaFragment frsNewAreaFragment9 = this.f42330b;
                            TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis2 - frsNewAreaFragment8.initTime, B - frsNewAreaFragment9.initTime, frsNewAreaFragment9.getModelController().D(), this.f42330b.getModelController().C(), currentTimeMillis2 - this.f42330b.getModelController().A());
                            this.f42330b.initTime = -1L;
                        }
                        this.f42330b.drawTime = System.currentTimeMillis() - currentTimeMillis;
                        return;
                    }
                }
                if (this.f42330b.initTime > -1) {
                    long currentTimeMillis3 = System.currentTimeMillis();
                    FrsNewAreaFragment frsNewAreaFragment10 = this.f42330b;
                    long B2 = frsNewAreaFragment10.getModelController().B();
                    FrsNewAreaFragment frsNewAreaFragment11 = this.f42330b;
                    TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis3 - frsNewAreaFragment10.initTime, B2 - frsNewAreaFragment11.initTime, frsNewAreaFragment11.getModelController().D(), this.f42330b.getModelController().C(), currentTimeMillis3 - this.f42330b.getModelController().A());
                    this.f42330b.initTime = -1L;
                }
                this.f42330b.drawTime = System.currentTimeMillis() - currentTimeMillis;
                System.gc();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsNewAreaFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(FrsNewAreaFragment frsNewAreaFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsNewAreaFragment, Integer.valueOf(i2)};
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
            this.a = frsNewAreaFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.a.r0.d1.h2.g gVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || (gVar = this.a.frsNewAreaView) == null) {
                return;
            }
            gVar.L();
        }
    }

    /* loaded from: classes5.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsNewAreaFragment f42331e;

        public j(FrsNewAreaFragment frsNewAreaFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsNewAreaFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42331e = frsNewAreaFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.y3.q0.a.o(this.f42331e.f42321f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsNewAreaFragment a;

        public k(FrsNewAreaFragment frsNewAreaFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsNewAreaFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsNewAreaFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) && i2 == 0) {
                c.a.r0.f0.u.b().e(true);
                c.a.r0.x3.c.g().h(this.a.getUniqueId(), true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                this.a.v += i3;
                if (this.a.v >= this.a.u * 2 && i3 < 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, Boolean.TRUE));
                }
                if (TbadkCoreApplication.isLogin() && TbSingleton.getInstance().showStampMissionDialog && UbsABTestHelper.isStampMissionDialogABTestB() && i3 > 0) {
                    c.a.r0.v3.b.r().A(3, 2);
                    c.a.r0.v3.b.r().G();
                }
            }
        }
    }

    public FrsNewAreaFragment() {
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
        this.f42321f = null;
        this.f42322g = null;
        this.f42323h = 0;
        this.f42324i = 1;
        this.f42325j = null;
        this.k = new FrsViewData();
        this.initTime = -1L;
        this.sysCreateTime = 0L;
        this.drawTime = 0L;
        this.createTime = 0L;
        this.beginTime = -1L;
        this.frsNewAreaView = null;
        this.o = -1;
        this.p = 3;
        this.q = false;
        this.r = false;
        this.t = new SparseArray<>();
        this.u = 0;
        this.v = 0;
        this.x = new d(this, 2921397, true);
        this.y = new e(this);
        this.z = new f(this, 2004004);
        this.A = new g(this, 2001624);
        this.mForumModelCallback = new h(this);
        this.B = new i(this, 2003003);
        this.C = new k(this);
        this.D = new b(this, 0);
        this.E = new c(this);
    }

    public static /* synthetic */ int j(FrsNewAreaFragment frsNewAreaFragment) {
        int i2 = frsNewAreaFragment.f42324i;
        frsNewAreaFragment.f42324i = i2 - 1;
        return i2;
    }

    public final void G(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        ArrayList<n> threadList = this.k.getThreadList();
        if (ListUtils.isEmpty(threadList) || this.frsNewAreaView.k() == null || this.frsNewAreaView.k().getData() == null) {
            return;
        }
        Iterator<n> it = threadList.iterator();
        List<n> data = this.frsNewAreaView.k().getData();
        int i2 = 0;
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof d2) {
                e2 e2Var = ((d2) next).w;
                int i3 = 0;
                while (true) {
                    if (i3 >= list.size()) {
                        break;
                    } else if (StringHelper.equals(list.get(i3), e2Var.h0())) {
                        it.remove();
                        data.remove(next);
                        this.n.L(next);
                        this.frsNewAreaView.k().getAdapter().notifyItemRemoved(i2);
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            i2++;
        }
    }

    public final void H(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, responsedMessage) == null) || this.k == null || this.frsNewAreaView == null || !(responsedMessage instanceof DownloadMessage) || (data = ((DownloadMessage) responsedMessage).getData()) == null) {
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
            this.frsNewAreaView.p();
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13008");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", this.f42325j);
            statisticItem.param("obj_type", 6);
            statisticItem.param("obj_locate", 2);
            statisticItem.eventStat();
        }
    }

    public final int J(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i2, i3)) == null) {
            if (i2 != 1) {
                return (i2 != 2 || i3 == 1) ? 0 : 3;
            }
            return 3;
        }
        return invokeII.intValue;
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            registerListener(2001118, this.D);
        }
    }

    public final void L(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            K();
            if (bundle != null) {
                this.f42321f = bundle.getString("name");
                this.f42322g = bundle.getString("from");
                this.f42323h = bundle.getInt("flag", 0);
            } else {
                Bundle arguments = getArguments();
                if (arguments != null) {
                    this.f42321f = arguments.getString("name");
                    this.f42322g = arguments.getString("from");
                    this.f42323h = arguments.getInt("flag", 0);
                }
            }
            if (TextUtils.isEmpty(this.f42322g) || !FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.f42322g)) {
                return;
            }
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    public final void M(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.q = true;
            stopVoice();
            hideNetRefreshView();
            if (!z) {
                hideNetRefreshView();
                showLoadingView();
            }
            FrsNewAreaModelController frsNewAreaModelController = this.m;
            if (frsNewAreaModelController != null) {
                frsNewAreaModelController.loadData();
            }
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.f42323h == 1) {
                c.a.d.f.m.h.a().b(new j(this));
            }
            this.f42323h = 0;
        }
    }

    public final void O() {
        c.a.r0.d1.h2.g gVar;
        HashMap<Integer, e2> h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (gVar = this.frsNewAreaView) == null || gVar.j() == null || (h2 = this.frsNewAreaView.j().h()) == null) {
            return;
        }
        ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
        for (Map.Entry<Integer, e2> entry : h2.entrySet()) {
            e2 value = entry.getValue();
            if (value != null && (value instanceof AdvertAppInfo)) {
                arrayList.add((AdvertAppInfo) value);
            }
        }
        c.a.q0.v.c.q().u(arrayList);
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            stopVoice();
            try {
                if (this.k == null) {
                    return;
                }
                this.frsNewAreaView.y();
                this.frsNewAreaView.I();
                this.f42321f = this.k.getForum().getName();
                this.f42325j = this.k.getForum().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.k.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.k.getUserData().getBimg_end_time());
                N();
                ArrayList<n> threadList = this.k.getThreadList();
                if (threadList != null) {
                    this.frsNewAreaView.H(threadList, this.f42324i, this.k, this.k.getPage().b());
                    O();
                    this.frsNewAreaView.z();
                    if (this.k.getIsNewUrl() == 1) {
                        this.frsNewAreaView.j().r(true);
                    } else {
                        this.frsNewAreaView.j().r(false);
                    }
                    this.frsNewAreaView.C(J(getModelController().getType(), this.f42324i));
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.o == 0 && !this.n.A(this.k.getThreadListIds())) {
                if (this.k.getThreadList() != null && this.k.getThreadList().size() != 0) {
                    this.frsNewAreaView.K();
                    return;
                } else {
                    this.frsNewAreaView.m();
                    return;
                }
            }
            this.frsNewAreaView.J();
        }
    }

    public final void R(c.a.r0.y3.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, fVar) == null) {
            this.frsNewAreaView.B(false);
            this.frsNewAreaView.G(false);
            this.frsNewAreaView.m();
            this.frsNewAreaView.k().getData().clear();
            this.frsNewAreaView.p();
            if (this.s == null) {
                c.a.q0.f0.c cVar = new c.a.q0.f0.c(getPageContext().getContext(), getNetRefreshListener());
                this.s = cVar;
                cVar.e(null);
                this.s.c(null);
                this.s.f();
                this.s.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            if (fVar != null) {
                this.s.d(getPageContext().getResources().getString(R.string.net_error_text, fVar.f24984d, Integer.valueOf(fVar.f24983c)));
            } else {
                this.s.d(null);
            }
            this.s.onChangeSkinType();
            this.s.attachView(this.frsNewAreaView.l(), true);
            this.s.a(0);
        }
    }

    public final void S(e2 e2Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, e2Var, i2) == null) {
            if (i2 == 1) {
                PraiseData N0 = e2Var.N0();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (N0 == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i2);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        e2Var.r4(praiseData);
                        return;
                    }
                    e2Var.N0().getUser().add(0, metaData);
                    e2Var.N0().setNum(e2Var.N0().getNum() + 1);
                    e2Var.N0().setIsLike(i2);
                }
            } else if (e2Var.N0() != null) {
                e2Var.N0().setIsLike(i2);
                e2Var.N0().setNum(e2Var.N0().getNum() - 1);
                ArrayList<MetaData> user = e2Var.N0().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            e2Var.N0().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public final void T(int i2) {
        ArrayList<n> threadList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || (threadList = this.k.getThreadList()) == null) {
            return;
        }
        Iterator<n> it = threadList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            n next = it.next();
            if (next instanceof d2) {
                e2 e2Var = ((d2) next).w;
                if (e2Var.h0() != null && e2Var.h0().equals(this.f42320e)) {
                    S(e2Var, i2);
                    this.f42320e = null;
                    break;
                }
            }
        }
        this.frsNewAreaView.j().q(threadList, this.k);
        this.frsNewAreaView.j().l();
    }

    public void addThreadData(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, e2Var) == null) || e2Var == null) {
            return;
        }
        this.m.w(e2Var);
    }

    @Override // c.a.r0.d1.q0
    public void changeToSpecialFrs(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
        }
    }

    public c.a.d.o.e.a createFrsExtraAdapter(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, bdUniqueId)) == null) ? c.a.r0.d1.e.e().d(getPageContext(), bdUniqueId, getPageContext().getUniqueId()) : (c.a.d.o.e.a) invokeL.objValue;
    }

    @Override // c.a.r0.h.e.b
    public void dispatchInjectPluginMessage(c.a.r0.h.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, dVar) == null) {
        }
    }

    @Override // c.a.r0.d1.q0
    public void forceRefresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || this.frsNewAreaView == null) {
            return;
        }
        scrollToTop();
        this.frsNewAreaView.L();
    }

    @Override // c.a.r0.j3.v
    public String getFid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f42325j : (String) invokeV.objValue;
    }

    @Override // c.a.r0.d1.g2.a, c.a.r0.d1.u0
    public String getForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f42321f : (String) invokeV.objValue;
    }

    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f42322g : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public c.a.d.f.k.b<TbImageView> getFrsCommonImageLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (getBaseFragmentActivity() instanceof FrsActivity) {
                return ((FrsActivity) getBaseFragmentActivity()).getFrsCommonImageLayoutPool();
            }
            return null;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    public c.a.r0.d1.h2.g getFrsView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.frsNewAreaView : (c.a.r0.d1.h2.g) invokeV.objValue;
    }

    @Override // c.a.r0.d1.g2.a
    public FrsViewData getFrsViewData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.k : (FrsViewData) invokeV.objValue;
    }

    @Override // c.a.r0.h.e.b
    public c.a.r0.h.e.a getInjectPlugin(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) ? this.t.get(i2) : (c.a.r0.h.e.a) invokeI.objValue;
    }

    public FrsLoadMoreModel getLoadMoreModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.n : (FrsLoadMoreModel) invokeV.objValue;
    }

    public FrsNewAreaModelController getModelController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.m : (FrsNewAreaModelController) invokeV.objValue;
    }

    @Override // c.a.r0.d1.r0
    public NavigationBar getNavigationBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return null;
        }
        return (NavigationBar) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.r0.d1.g2.a
    public /* bridge */ /* synthetic */ c.a.d.a.f getPageContext() {
        return super.getPageContext();
    }

    @Override // c.a.r0.j3.v
    public int getPageNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f42324i : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // c.a.r0.j3.v
    public TbPageContext<?> getTbPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? getPageContext() : (TbPageContext) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            TbPageTag tbPageTag = super.getTbPageTag();
            FrsViewData frsViewData = this.k;
            tbPageTag.sortType = p.g(frsViewData != null ? frsViewData.getSortType() : -1);
            tbPageTag.locatePage = "a071";
            return tbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public c.a.d.f.k.b<TbImageView> getUserIconPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            if (getBaseFragmentActivity() instanceof FrsActivity) {
                return ((FrsActivity) getBaseFragmentActivity()).getUserIconPool();
            }
            return null;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    public int getUserIconViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (this.l == null) {
                this.l = VoiceManager.instance();
            }
            return this.l;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public final void hideLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.frsNewAreaView.B(true);
            hideLoadingView(this.frsNewAreaView.l());
        }
    }

    public final void hideNetRefreshView() {
        c.a.r0.d1.h2.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || (gVar = this.frsNewAreaView) == null) {
            return;
        }
        gVar.B(true);
        this.frsNewAreaView.G(true);
        c.a.q0.f0.c cVar = this.s;
        if (cVar == null || !cVar.isViewAttached()) {
            return;
        }
        this.s.dettachView(this.frsNewAreaView.l());
    }

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            if (this.f42323h != 0) {
                this.f42323h = 1;
            }
            this.frsNewAreaView.E(this.E);
            this.frsNewAreaView.F(this.C);
        }
    }

    public void loadMore() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048618, this) == null) || this.n.isLoading || this.m.G()) {
            return;
        }
        if (this.n.A(this.k.getThreadListIds())) {
            String e2 = this.m.z() != null ? c.a.r0.j3.a.e(this.m.z().getThreadList(), false) : "";
            this.frsNewAreaView.H(this.n.N(), this.f42324i, this.k, 0);
            this.n.O(c.a.d.f.m.b.g(this.f42325j, 0L), this.k.getThreadListIds(), this.f42321f, this.f42324i, this.k.isBrandForum, e2);
        } else if (this.o != 0) {
            this.frsNewAreaView.H(this.n.N(), this.f42324i, this.k, 0);
            int i2 = this.f42324i + 1;
            this.f42324i = i2;
            this.m.H(i2);
            FrsLoadMoreModel frsLoadMoreModel = this.n;
            frsLoadMoreModel.loadingDone = false;
            frsLoadMoreModel.loadIndex = 0;
        }
    }

    public void loadTabData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            if (l.z()) {
                M(false);
            } else {
                R(null);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        e2 threadDataById;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048620, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1 && i2 == 18003) {
                this.frsNewAreaView.j().l();
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra == null || (threadDataById = this.k.getThreadDataById(stringExtra)) == null) {
                    return;
                }
                int intExtra = intent.getIntExtra("type", -1);
                if (intExtra == 2) {
                    threadDataById.c4(intent.getIntExtra("good_data", 0));
                    threadDataById.h3();
                    M(false);
                } else if (intExtra == 0) {
                    this.k.removeThreadData(threadDataById);
                    ArrayList<n> threadList = this.k.getThreadList();
                    if (threadList != null && threadList.size() <= 0) {
                        threadList.add(new s());
                    }
                    this.frsNewAreaView.z();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            if (this.p == 3 && this.frsNewAreaView == null) {
                return;
            }
            this.p = i2;
            super.onChangeSkinType(i2);
            c.a.r0.d1.h2.g gVar = this.frsNewAreaView;
            if (gVar != null) {
                gVar.q(i2);
            }
            c.a.q0.f0.c cVar = this.s;
            if (cVar == null || !cVar.isViewAttached()) {
                return;
            }
            this.s.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, bundle) == null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.initTime = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
            } else {
                this.initTime = System.currentTimeMillis();
            }
            if (arguments != null) {
                this.f42325j = arguments.getString("forum_id", "");
                this.w = arguments.getBoolean(FrsActivityConfig.FLAG_SHOW_AD);
            }
            long currentTimeMillis = System.currentTimeMillis();
            this.beginTime = currentTimeMillis;
            this.sysCreateTime = currentTimeMillis - this.initTime;
            super.onCreate(bundle);
            c.a.r0.x3.c.g().i(getUniqueId());
            FrsNewAreaModelController frsNewAreaModelController = new FrsNewAreaModelController(this);
            this.m = frsNewAreaModelController;
            if (arguments != null) {
                frsNewAreaModelController.F(arguments);
            } else if (bundle != null) {
                frsNewAreaModelController.F(bundle);
            } else {
                frsNewAreaModelController.F(null);
            }
            VoiceManager voiceManager = getVoiceManager();
            this.l = voiceManager;
            voiceManager.onCreate(getPageContext());
            L(bundle);
            registerListener(this.B);
            registerListener(this.z);
            registerListener(this.A);
            registerListener(this.x);
            FrsLoadMoreModel frsLoadMoreModel = new FrsLoadMoreModel(this, null);
            this.n = frsLoadMoreModel;
            frsLoadMoreModel.registerListener();
            this.n.T(3);
            this.n.R(true);
            this.n.Q(c.a.r0.f1.a.a(this.w));
            this.createTime = System.currentTimeMillis() - this.beginTime;
            this.u = UtilHelper.getScreenHeight(getActivity());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048623, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
            this.frsNewAreaView = new c.a.r0.d1.h2.g(this, inflate);
            initUI();
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            c.a.r0.d1.h2.g gVar = this.frsNewAreaView;
            if (gVar != null) {
                gVar.r();
            }
            MessageManager.getInstance().unRegisterListener(this.x);
            c.a.r0.x3.c.g().k(getUniqueId());
            c.a.r0.f0.u.b().e(false);
            super.onDestroy();
            this.m.I();
            VoiceManager voiceManager = getVoiceManager();
            this.l = voiceManager;
            voiceManager.onDestory(getPageContext());
            c.a.d.f.m.e.a().removeCallbacks(this.y);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void onFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, str) == null) {
            Q();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public q onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            if (getListView() == null) {
                return null;
            }
            return getListView().getPreLoadHandle();
        }
        return (q) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            super.onLazyLoad();
            if (this.q) {
                return;
            }
            if (l.z()) {
                M(false);
            } else {
                R(null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            I();
        }
    }

    @Override // c.a.r0.d1.s0
    public void onLoadingComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            c.a.r0.x3.c.g().h(getUniqueId(), false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048630, this) == null) && l.z()) {
            M(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            super.onPause();
            VoiceManager voiceManager = getVoiceManager();
            this.l = voiceManager;
            voiceManager.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                if (this.p == 3) {
                    onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                }
                if (this.q) {
                    return;
                }
                c.a.d.f.m.e.a().post(this.y);
            }
        }
    }

    @Override // c.a.r0.d1.s0
    public void onPullRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            if (getPageContext() != null) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            }
            if (l.z()) {
                c.a.r0.t.d.c().f("page_frs_good");
                M(true);
                return;
            }
            this.frsNewAreaView.A(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048634, this, i2, strArr, iArr) == null) && i2 == 1) {
            if (PermissionUtil.checkCamera(getActivity().getApplicationContext())) {
                SelectImageHelper.takePhoto(getPageContext());
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = PermissionUtil.transformPermissionResult(strArr, iArr);
            if (!transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") || transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                return;
            }
            showToast(R.string.sdcard_permission_denied_advert_for_camera);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            super.onResume();
            c.a.r0.d1.h2.g gVar = this.frsNewAreaView;
            if (gVar != null) {
                gVar.p();
            }
            VoiceManager voiceManager = getVoiceManager();
            this.l = voiceManager;
            voiceManager.onResume(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("name", this.f42321f);
            bundle.putString("from", this.f42322g);
            this.m.onSaveInstanceState(bundle);
            VoiceManager voiceManager = getVoiceManager();
            this.l = voiceManager;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            if (!c.a.d.f.p.n.C()) {
                this.frsNewAreaView.m();
            } else if (this.frsNewAreaView.x()) {
            } else {
                if (!this.m.E()) {
                    this.frsNewAreaView.m();
                    return;
                }
                Q();
                loadMore();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            super.onStart();
            VoiceManager voiceManager = getVoiceManager();
            this.l = voiceManager;
            voiceManager.onStart(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            super.onStop();
            c.a.r0.f0.u.b().e(false);
            c.a.r0.x3.c.g().h(getUniqueId(), false);
            FrsViewData frsViewData = this.k;
            if (frsViewData != null && frsViewData.getForum() != null) {
                c.a.q0.u.a.k().y(getPageContext().getPageActivity(), "frs", this.k.getForum().getId(), 0L);
            }
            VoiceManager voiceManager = getVoiceManager();
            this.l = voiceManager;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void onSuccess(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, arrayList) == null) {
            Q();
            if (arrayList == null || arrayList.size() == 0) {
                return;
            }
            ArrayList<n> D = this.n.D(false, false, false, arrayList, null);
            if (D != null) {
                this.k.setThreadList(D);
                this.frsNewAreaView.H(D, this.f42324i, this.k, 0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.k.getForum()));
        }
    }

    public void onViewDataChange(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048641, this, frsViewData) == null) || frsViewData == null) {
            return;
        }
        this.k = frsViewData;
        hideLoadingView(this.frsNewAreaView.l());
        c.a.r0.d1.h2.g gVar = this.frsNewAreaView;
        if (gVar != null) {
            gVar.A(false);
            this.frsNewAreaView.H(null, this.f42324i, this.k, this.o);
        }
    }

    public void processBatchDelete(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, list) == null) {
            G(list);
            int i2 = 0;
            for (n nVar : this.k.getThreadList()) {
                if (nVar instanceof d2) {
                    i2++;
                    continue;
                }
                if (i2 >= 6) {
                    break;
                }
            }
            if (i2 < 6) {
                loadMore();
            }
        }
    }

    public void refreshRecyclerView() {
        c.a.r0.d1.h2.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048643, this) == null) || (gVar = this.frsNewAreaView) == null || gVar.k() == null) {
            return;
        }
        this.frsNewAreaView.k().post(new a(this));
    }

    @Override // c.a.r0.d1.q0
    public void scrollToTop() {
        c.a.r0.d1.h2.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048644, this) == null) || (gVar = this.frsNewAreaView) == null || gVar.k() == null) {
            return;
        }
        this.frsNewAreaView.k().scrollToPosition(0);
    }

    public void setFlag(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048645, this, i2) == null) {
            this.f42323h = i2;
        }
    }

    public void setForum(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, str) == null) {
            this.f42321f = str;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, str) == null) {
            this.f42322g = str;
        }
    }

    public void setFrsView(c.a.r0.d1.h2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, gVar) == null) {
            this.frsNewAreaView = gVar;
        }
    }

    @Override // c.a.r0.h.e.b
    public void setInjectPlugin(int i2, c.a.r0.h.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048649, this, i2, aVar) == null) {
            this.t.put(i2, aVar);
        }
    }

    public void setPn(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048650, this, i2) == null) {
            this.f42324i = i2;
        }
    }

    public final void showLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            this.frsNewAreaView.B(false);
            showLoadingView(this.frsNewAreaView.l(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
        }
    }

    public void stopVoice() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048652, this) == null) {
            VoiceManager voiceManager = getVoiceManager();
            this.l = voiceManager;
            voiceManager.stopPlay();
        }
    }

    @Override // c.a.r0.j3.v
    public void updateLastIds() {
        FrsNewAreaModelController frsNewAreaModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048653, this) == null) || (frsNewAreaModelController = this.m) == null) {
            return;
        }
        frsNewAreaModelController.N();
    }

    /* JADX DEBUG: Method merged with bridge method */
    public BdTypeRecyclerView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            c.a.r0.d1.h2.g gVar = this.frsNewAreaView;
            if (gVar == null) {
                return null;
            }
            return gVar.k();
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }
}
