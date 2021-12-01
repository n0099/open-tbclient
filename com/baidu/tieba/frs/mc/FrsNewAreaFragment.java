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
import c.a.d.m.e.n;
import c.a.d.m.e.q;
import c.a.d.m.e.w;
import c.a.q0.s.q.c2;
import c.a.q0.s.q.d2;
import c.a.r0.d1.d1;
import c.a.r0.d1.g1;
import c.a.r0.d1.i1;
import c.a.r0.d1.q0;
import c.a.r0.d1.r0;
import c.a.r0.d1.s;
import c.a.r0.d1.s0;
import c.a.r0.g0.v;
import c.a.r0.h3.u;
import c.a.r0.t3.m;
import c.a.r0.t3.t;
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
/* loaded from: classes10.dex */
public class FrsNewAreaFragment extends BaseFragment implements VoiceManager.j, c.a.r0.d1.p2.a, UserIconBox.c, BdListView.p, FrsCommonImageLayout.e, q0, ActivityCompat.OnRequestPermissionsResultCallback, u, r0, c.a.r0.h.e.b, s0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener A;
    public final CustomMessageListener B;
    public final RecyclerView.OnScrollListener C;
    public final CustomMessageListener D;
    public w E;
    public long beginTime;
    public long createTime;
    public long drawTime;

    /* renamed from: e  reason: collision with root package name */
    public String f44626e;

    /* renamed from: f  reason: collision with root package name */
    public String f44627f;
    public c.a.r0.d1.q2.g frsNewAreaView;

    /* renamed from: g  reason: collision with root package name */
    public String f44628g;

    /* renamed from: h  reason: collision with root package name */
    public int f44629h;

    /* renamed from: i  reason: collision with root package name */
    public int f44630i;
    public long initTime;

    /* renamed from: j  reason: collision with root package name */
    public String f44631j;

    /* renamed from: k  reason: collision with root package name */
    public FrsViewData f44632k;
    public VoiceManager l;
    public FrsNewAreaModelController m;
    public final t mForumModelCallback;
    public FrsLoadMoreModel n;
    public int o;
    public int p;
    public boolean q;
    public boolean r;
    public c.a.q0.g0.c s;
    public long sysCreateTime;
    public SparseArray<c.a.r0.h.e.a> t;
    public int u;
    public int v;
    public boolean w;
    public CustomMessageListener x;
    public Runnable y;
    public CustomMessageListener z;

    /* loaded from: classes10.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsNewAreaFragment f44633e;

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
            this.f44633e = frsNewAreaFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.r0.d1.q2.g gVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (gVar = this.f44633e.frsNewAreaView) == null || gVar.k() == null || this.f44633e.frsNewAreaView.k().isComputingLayout()) {
                return;
            }
            this.f44633e.frsNewAreaView.t();
        }
    }

    /* loaded from: classes10.dex */
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
                this.a.G(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsNewAreaFragment f44634e;

        /* loaded from: classes10.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f44635e;

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
                this.f44635e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    NetWork netWork = new NetWork(this.f44635e);
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
            this.f44634e = frsNewAreaFragment;
        }

        @Override // c.a.d.m.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || bdUniqueId == null || nVar == null || !(nVar instanceof c2)) {
                return;
            }
            d2 d2Var = ((c2) nVar).w;
            if (d2Var.E() == null || d2Var.E().getGroup_id() == 0 || ViewHelper.checkUpIsLogin(this.f44634e.getActivity())) {
                if (d2Var.w() != 1 || ViewHelper.checkUpIsLogin(this.f44634e.getActivity())) {
                    c.a.r0.t3.p0.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null && !readThreadHistory.d(d2Var.g0())) {
                        readThreadHistory.a(d2Var.g0());
                        c.a.r0.d1.q2.g gVar = this.f44634e.frsNewAreaView;
                        if (gVar != null) {
                            gVar.p();
                        }
                    }
                    String z2 = d2Var.z();
                    if (z2 == null || z2.equals("")) {
                        z = false;
                    } else {
                        new Thread(new a(this, z2)).start();
                        z = true;
                    }
                    String v1 = d2Var.v1();
                    if (v1 == null) {
                        v1 = "";
                    }
                    if (d2Var.s0() == 2 && !v1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                        UrlManager.getInstance().dealOneLink(this.f44634e.getPageContext(), new String[]{v1, "", null});
                        return;
                    }
                    if (v1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && v1.length() > 3) {
                        d2Var.S3(v1.substring(3));
                    }
                    PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.f44634e.getPageContext().getPageActivity()).createFromThreadCfg(d2Var, this.f44634e.f44627f, FrsFragment.STAR_FRS, 18003, true, false, z);
                    createFromThreadCfg.setForumId(String.valueOf(d2Var.U()));
                    createFromThreadCfg.setStartFrom(3);
                    this.f44634e.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                    if (this.f44634e.f44632k == null || this.f44634e.f44632k.getForum() == null) {
                        return;
                    }
                    c.a.r0.d1.v2.b bVar = new c.a.r0.d1.v2.b();
                    bVar.a = this.f44634e.f44632k.needLog == 1;
                    bVar.f16084c = this.f44634e.f44632k.getForum().getId();
                    bVar.f16083b = this.f44634e.m.y();
                    c.a.r0.d1.v2.b bVar2 = c.a.r0.d1.v2.d.p0;
                    if (bVar2 != null) {
                        bVar.f16085d = bVar2.f16085d;
                        bVar.f16086e = bVar2.f16086e;
                    }
                    c.a.r0.d1.v2.a.e(d2Var, 1, this.f44634e.getUniqueId(), bVar, this.f44634e.getTbPageTag());
                }
            }
        }
    }

    /* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsNewAreaFragment f44636e;

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
            this.f44636e = frsNewAreaFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.d.f.p.j.z() || this.f44636e.q) {
                    this.f44636e.X(null);
                } else {
                    this.f44636e.Q(false);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof d2)) {
                d2 d2Var = (d2) customResponsedMessage.getData();
                this.a.f44626e = d2Var.g0();
                if (TextUtils.isEmpty(this.a.f44626e) || d2Var.M0() == null) {
                    return;
                }
                this.a.Z(d2Var.M0().getIsLike());
            }
        }
    }

    /* loaded from: classes10.dex */
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
                    this.a.Q(false);
                    return;
                }
                c.a.r0.d1.q2.g gVar = this.a.frsNewAreaView;
                if (gVar != null) {
                    gVar.L();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class h implements t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrsNewAreaFragment f44637b;

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
            this.f44637b = frsNewAreaFragment;
            this.a = 1L;
        }

        @Override // c.a.r0.t3.t
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f44637b.r) {
                return;
            }
            if (i2 == 1 || i2 == 2) {
                this.f44637b.frsNewAreaView.p();
            } else if (i2 != 3) {
            } else {
                this.f44637b.frsNewAreaView.A(true);
            }
        }

        @Override // c.a.r0.t3.t
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // c.a.r0.t3.t
        public void c(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar) == null) {
            }
        }

        @Override // c.a.r0.t3.t
        public void d(int i2, boolean z, c.a.r0.t3.f fVar) {
            ArrayList<n> C;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), fVar}) == null) {
                if (this.f44637b.r) {
                    if (this.f44637b.getModelController().z() == null) {
                        this.f44637b.r = false;
                        return;
                    } else if (this.f44637b.getModelController().z().getThreadList().size() >= 10) {
                        this.f44637b.r = false;
                        c.a.r0.d1.w2.e eVar = new c.a.r0.d1.w2.e();
                        eVar.f16141b = 301;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384, eVar));
                        return;
                    }
                }
                if (fVar == null) {
                    this.a = 1L;
                } else if (fVar.f23770b) {
                    this.a = 0L;
                } else {
                    this.a = 1L;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (i2 == 3) {
                    this.f44637b.n.N();
                }
                this.f44637b.frsNewAreaView.A(false);
                if (this.f44637b.getModelController().z() != null) {
                    FrsNewAreaFragment frsNewAreaFragment = this.f44637b;
                    frsNewAreaFragment.f44632k = frsNewAreaFragment.getModelController().z();
                }
                FrsNewAreaFragment frsNewAreaFragment2 = this.f44637b;
                frsNewAreaFragment2.o = frsNewAreaFragment2.f44632k.getPage().b();
                if (this.f44637b.o == 0 && (this.f44637b.f44632k.getThreadListIds() == null || this.f44637b.f44632k.getThreadListIds().size() == 0)) {
                    if (this.f44637b.f44632k.getThreadList() != null && this.f44637b.f44632k.getThreadList().size() != 0) {
                        this.f44637b.frsNewAreaView.K();
                    } else {
                        this.f44637b.frsNewAreaView.m();
                    }
                } else {
                    this.f44637b.frsNewAreaView.J();
                }
                if (i2 == 4) {
                    ArrayList<n> C2 = this.f44637b.n.C(false, false, false, this.f44637b.f44632k.getThreadList(), null);
                    if (C2 != null) {
                        this.f44637b.f44632k.setThreadList(C2);
                        FrsNewAreaFragment frsNewAreaFragment3 = this.f44637b;
                        frsNewAreaFragment3.frsNewAreaView.H(C2, frsNewAreaFragment3.f44630i, this.f44637b.f44632k, this.f44637b.o);
                        return;
                    }
                    return;
                }
                if (i2 == 1) {
                    this.f44637b.frsNewAreaView.p();
                } else if (i2 != 2) {
                    if (i2 == 3 && this.f44637b.f44632k.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, Boolean.TRUE));
                    }
                } else {
                    this.f44637b.frsNewAreaView.p();
                }
                this.f44637b.hideLoadingView();
                if (this.a != 0) {
                    this.f44637b.X(fVar);
                } else {
                    this.f44637b.hideNetRefreshView();
                    if (this.f44637b.f44632k != null) {
                        FrsNewAreaFragment frsNewAreaFragment4 = this.f44637b;
                        frsNewAreaFragment4.f44627f = frsNewAreaFragment4.f44632k.getForum().getName();
                        FrsNewAreaFragment frsNewAreaFragment5 = this.f44637b;
                        frsNewAreaFragment5.f44631j = frsNewAreaFragment5.f44632k.getForum().getId();
                        FrsNewAreaFragment frsNewAreaFragment6 = this.f44637b;
                        frsNewAreaFragment6.frsNewAreaView.s(frsNewAreaFragment6.f44632k.getForum(), this.f44637b.f44632k.getUserData());
                    }
                    if (this.f44637b.f44632k != null) {
                        this.f44637b.f44632k.addNoticeThreadToThreadList();
                    }
                    if (this.f44637b.f44632k == null || this.f44637b.f44632k.getThreadList() == null || this.f44637b.f44632k.getThreadList().size() != 0 || this.f44637b.getModelController().getType() != 4) {
                        if (this.f44637b.f44632k != null && (C = this.f44637b.n.C(false, false, true, this.f44637b.f44632k.getThreadList(), null)) != null && C.size() > 0) {
                            this.f44637b.f44632k.setThreadList(C);
                        }
                        this.f44637b.V();
                    } else {
                        FrsNewAreaFragment frsNewAreaFragment7 = this.f44637b;
                        frsNewAreaFragment7.showToast(frsNewAreaFragment7.getPageContext().getString(i1.no_more_to_load));
                        if (this.f44637b.f44630i > 1) {
                            FrsNewAreaFragment.i(this.f44637b);
                        }
                        if (this.f44637b.initTime > -1) {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            FrsNewAreaFragment frsNewAreaFragment8 = this.f44637b;
                            long B = frsNewAreaFragment8.getModelController().B();
                            FrsNewAreaFragment frsNewAreaFragment9 = this.f44637b;
                            TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis2 - frsNewAreaFragment8.initTime, B - frsNewAreaFragment9.initTime, frsNewAreaFragment9.getModelController().D(), this.f44637b.getModelController().C(), currentTimeMillis2 - this.f44637b.getModelController().A());
                            this.f44637b.initTime = -1L;
                        }
                        this.f44637b.drawTime = System.currentTimeMillis() - currentTimeMillis;
                        return;
                    }
                }
                if (this.f44637b.initTime > -1) {
                    long currentTimeMillis3 = System.currentTimeMillis();
                    FrsNewAreaFragment frsNewAreaFragment10 = this.f44637b;
                    long B2 = frsNewAreaFragment10.getModelController().B();
                    FrsNewAreaFragment frsNewAreaFragment11 = this.f44637b;
                    TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis3 - frsNewAreaFragment10.initTime, B2 - frsNewAreaFragment11.initTime, frsNewAreaFragment11.getModelController().D(), this.f44637b.getModelController().C(), currentTimeMillis3 - this.f44637b.getModelController().A());
                    this.f44637b.initTime = -1L;
                }
                this.f44637b.drawTime = System.currentTimeMillis() - currentTimeMillis;
                System.gc();
            }
        }
    }

    /* loaded from: classes10.dex */
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
            c.a.r0.d1.q2.g gVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || (gVar = this.a.frsNewAreaView) == null) {
                return;
            }
            gVar.L();
        }
    }

    /* loaded from: classes10.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsNewAreaFragment f44638e;

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
            this.f44638e = frsNewAreaFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.t3.p0.a.o(this.f44638e.f44627f);
            }
        }
    }

    /* loaded from: classes10.dex */
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
                v.b().e(true);
                c.a.r0.s3.c.g().h(this.a.getUniqueId(), true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                this.a.v += i3;
                if (this.a.v < this.a.u * 2 || i3 >= 0) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, Boolean.TRUE));
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
        this.f44627f = null;
        this.f44628g = null;
        this.f44629h = 0;
        this.f44630i = 1;
        this.f44631j = null;
        this.f44632k = new FrsViewData();
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

    public static /* synthetic */ int i(FrsNewAreaFragment frsNewAreaFragment) {
        int i2 = frsNewAreaFragment.f44630i;
        frsNewAreaFragment.f44630i = i2 - 1;
        return i2;
    }

    public final void F(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        ArrayList<n> threadList = this.f44632k.getThreadList();
        if (ListUtils.isEmpty(threadList) || this.frsNewAreaView.k() == null || this.frsNewAreaView.k().getData() == null) {
            return;
        }
        Iterator<n> it = threadList.iterator();
        List<n> data = this.frsNewAreaView.k().getData();
        int i2 = 0;
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof c2) {
                d2 d2Var = ((c2) next).w;
                int i3 = 0;
                while (true) {
                    if (i3 >= list.size()) {
                        break;
                    } else if (StringHelper.equals(list.get(i3), d2Var.g0())) {
                        it.remove();
                        data.remove(next);
                        this.n.K(next);
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

    public final void G(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, responsedMessage) == null) || this.f44632k == null || this.frsNewAreaView == null || !(responsedMessage instanceof DownloadMessage) || (data = ((DownloadMessage) responsedMessage).getData()) == null) {
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

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13008");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", this.f44631j);
            statisticItem.param("obj_type", 6);
            statisticItem.param("obj_locate", 2);
            statisticItem.eventStat();
        }
    }

    public final int L(int i2, int i3) {
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

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            registerListener(2001118, this.D);
        }
    }

    public final void O(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            M();
            if (bundle != null) {
                this.f44627f = bundle.getString("name");
                this.f44628g = bundle.getString("from");
                this.f44629h = bundle.getInt("flag", 0);
            } else {
                Bundle arguments = getArguments();
                if (arguments != null) {
                    this.f44627f = arguments.getString("name");
                    this.f44628g = arguments.getString("from");
                    this.f44629h = arguments.getInt("flag", 0);
                }
            }
            if (TextUtils.isEmpty(this.f44628g) || !FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.f44628g)) {
                return;
            }
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    public final void Q(boolean z) {
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

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.f44629h == 1) {
                c.a.d.f.m.h.a().b(new j(this));
            }
            this.f44629h = 0;
        }
    }

    public final void T() {
        c.a.r0.d1.q2.g gVar;
        HashMap<Integer, d2> h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (gVar = this.frsNewAreaView) == null || gVar.j() == null || (h2 = this.frsNewAreaView.j().h()) == null) {
            return;
        }
        ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
        for (Map.Entry<Integer, d2> entry : h2.entrySet()) {
            d2 value = entry.getValue();
            if (value != null && (value instanceof AdvertAppInfo)) {
                arrayList.add((AdvertAppInfo) value);
            }
        }
        c.a.q0.w.c.q().u(arrayList);
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            stopVoice();
            try {
                if (this.f44632k == null) {
                    return;
                }
                this.frsNewAreaView.y();
                this.frsNewAreaView.I();
                this.f44627f = this.f44632k.getForum().getName();
                this.f44631j = this.f44632k.getForum().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.f44632k.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.f44632k.getUserData().getBimg_end_time());
                S();
                ArrayList<n> threadList = this.f44632k.getThreadList();
                if (threadList != null) {
                    this.frsNewAreaView.H(threadList, this.f44630i, this.f44632k, this.f44632k.getPage().b());
                    T();
                    this.frsNewAreaView.z();
                    if (this.f44632k.getIsNewUrl() == 1) {
                        this.frsNewAreaView.j().r(true);
                    } else {
                        this.frsNewAreaView.j().r(false);
                    }
                    this.frsNewAreaView.C(L(getModelController().getType(), this.f44630i));
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.o == 0 && !this.n.A(this.f44632k.getThreadListIds())) {
                if (this.f44632k.getThreadList() != null && this.f44632k.getThreadList().size() != 0) {
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

    public final void X(c.a.r0.t3.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, fVar) == null) {
            this.frsNewAreaView.B(false);
            this.frsNewAreaView.G(false);
            this.frsNewAreaView.m();
            this.frsNewAreaView.k().getData().clear();
            this.frsNewAreaView.p();
            if (this.s == null) {
                c.a.q0.g0.c cVar = new c.a.q0.g0.c(getPageContext().getContext(), getNetRefreshListener());
                this.s = cVar;
                cVar.e(null);
                this.s.c(null);
                this.s.f();
                this.s.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            if (fVar != null) {
                this.s.d(getPageContext().getResources().getString(i1.net_error_text, fVar.f23772d, Integer.valueOf(fVar.f23771c)));
            } else {
                this.s.d(null);
            }
            this.s.onChangeSkinType();
            this.s.attachView(this.frsNewAreaView.l(), true);
            this.s.a(0);
        }
    }

    public final void Y(d2 d2Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, d2Var, i2) == null) {
            if (i2 == 1) {
                PraiseData M0 = d2Var.M0();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (M0 == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i2);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        d2Var.q4(praiseData);
                        return;
                    }
                    d2Var.M0().getUser().add(0, metaData);
                    d2Var.M0().setNum(d2Var.M0().getNum() + 1);
                    d2Var.M0().setIsLike(i2);
                }
            } else if (d2Var.M0() != null) {
                d2Var.M0().setIsLike(i2);
                d2Var.M0().setNum(d2Var.M0().getNum() - 1);
                ArrayList<MetaData> user = d2Var.M0().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            d2Var.M0().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public final void Z(int i2) {
        ArrayList<n> threadList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || (threadList = this.f44632k.getThreadList()) == null) {
            return;
        }
        Iterator<n> it = threadList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            n next = it.next();
            if (next instanceof c2) {
                d2 d2Var = ((c2) next).w;
                if (d2Var.g0() != null && d2Var.g0().equals(this.f44626e)) {
                    Y(d2Var, i2);
                    this.f44626e = null;
                    break;
                }
            }
        }
        this.frsNewAreaView.j().q(threadList, this.f44632k);
        this.frsNewAreaView.j().l();
    }

    public void addThreadData(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, d2Var) == null) || d2Var == null) {
            return;
        }
        this.m.w(d2Var);
    }

    @Override // c.a.r0.d1.q0
    public void changeToSpecialFrs(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
        }
    }

    public c.a.d.m.e.a createFrsExtraAdapter(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, bdUniqueId)) == null) ? c.a.r0.d1.e.e().d(getPageContext(), bdUniqueId, getPageContext().getUniqueId()) : (c.a.d.m.e.a) invokeL.objValue;
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

    @Override // c.a.r0.h3.u
    public String getFid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f44631j : (String) invokeV.objValue;
    }

    @Override // c.a.r0.d1.p2.a, c.a.r0.d1.u0
    public String getForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f44627f : (String) invokeV.objValue;
    }

    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f44628g : (String) invokeV.objValue;
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

    public c.a.r0.d1.q2.g getFrsView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.frsNewAreaView : (c.a.r0.d1.q2.g) invokeV.objValue;
    }

    @Override // c.a.r0.d1.p2.a
    public FrsViewData getFrsViewData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f44632k : (FrsViewData) invokeV.objValue;
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

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.r0.d1.p2.a
    public /* bridge */ /* synthetic */ c.a.d.a.f getPageContext() {
        return super.getPageContext();
    }

    @Override // c.a.r0.h3.u
    public int getPageNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f44630i : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, voiceData$VoiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // c.a.r0.h3.u
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
            FrsViewData frsViewData = this.f44632k;
            tbPageTag.sortType = c.a.r0.d1.y2.k.g(frsViewData != null ? frsViewData.getSortType() : -1);
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            c.a.r0.d1.q2.g gVar = this.frsNewAreaView;
            if (gVar != null) {
                gVar.B(true);
                this.frsNewAreaView.G(true);
            }
            c.a.q0.g0.c cVar = this.s;
            if (cVar == null || !cVar.isViewAttached()) {
                return;
            }
            this.s.dettachView(this.frsNewAreaView.l());
        }
    }

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            if (this.f44629h != 0) {
                this.f44629h = 1;
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
        if (this.n.A(this.f44632k.getThreadListIds())) {
            String e2 = this.m.z() != null ? c.a.r0.h3.a.e(this.m.z().getThreadList(), false) : "";
            this.frsNewAreaView.H(this.n.L(), this.f44630i, this.f44632k, 0);
            this.n.M(c.a.d.f.m.b.g(this.f44631j, 0L), this.f44632k.getThreadListIds(), this.f44627f, this.f44630i, this.f44632k.isBrandForum, e2);
        } else if (this.o != 0) {
            this.frsNewAreaView.H(this.n.L(), this.f44630i, this.f44632k, 0);
            int i2 = this.f44630i + 1;
            this.f44630i = i2;
            this.m.H(i2);
            FrsLoadMoreModel frsLoadMoreModel = this.n;
            frsLoadMoreModel.loadingDone = false;
            frsLoadMoreModel.loadIndex = 0;
        }
    }

    public void loadTabData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            if (c.a.d.f.p.j.z()) {
                Q(false);
            } else {
                X(null);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        d2 threadDataById;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048620, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1 && i2 == 18003) {
                this.frsNewAreaView.j().l();
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra == null || (threadDataById = this.f44632k.getThreadDataById(stringExtra)) == null) {
                    return;
                }
                int intExtra = intent.getIntExtra("type", -1);
                if (intExtra == 2) {
                    threadDataById.b4(intent.getIntExtra("good_data", 0));
                    threadDataById.g3();
                    Q(false);
                } else if (intExtra == 0) {
                    this.f44632k.removeThreadData(threadDataById);
                    ArrayList<n> threadList = this.f44632k.getThreadList();
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
            c.a.r0.d1.q2.g gVar = this.frsNewAreaView;
            if (gVar != null) {
                gVar.q(i2);
            }
            c.a.q0.g0.c cVar = this.s;
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
                this.f44631j = arguments.getString("forum_id", "");
                this.w = arguments.getBoolean(FrsActivityConfig.FLAG_SHOW_AD);
            }
            long currentTimeMillis = System.currentTimeMillis();
            this.beginTime = currentTimeMillis;
            this.sysCreateTime = currentTimeMillis - this.initTime;
            super.onCreate(bundle);
            c.a.r0.s3.c.g().i(getUniqueId());
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
            O(bundle);
            registerListener(this.B);
            registerListener(this.z);
            registerListener(this.A);
            registerListener(this.x);
            FrsLoadMoreModel frsLoadMoreModel = new FrsLoadMoreModel(this, null);
            this.n = frsLoadMoreModel;
            frsLoadMoreModel.registerListener();
            this.n.R(3);
            this.n.P(true);
            this.n.O(c.a.r0.f1.a.a(this.w));
            this.createTime = System.currentTimeMillis() - this.beginTime;
            this.u = UtilHelper.getScreenHeight(getActivity());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048623, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(g1.frs_good_activity, (ViewGroup) null);
            this.frsNewAreaView = new c.a.r0.d1.q2.g(this, inflate);
            initUI();
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            c.a.r0.d1.q2.g gVar = this.frsNewAreaView;
            if (gVar != null) {
                gVar.r();
            }
            MessageManager.getInstance().unRegisterListener(this.x);
            c.a.r0.s3.c.g().k(getUniqueId());
            v.b().e(false);
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
            W();
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
            if (c.a.d.f.p.j.z()) {
                Q(false);
            } else {
                X(null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            K();
        }
    }

    @Override // c.a.r0.d1.s0
    public void onLoadingComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            c.a.r0.s3.c.g().h(getUniqueId(), false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048630, this) == null) && c.a.d.f.p.j.z()) {
            Q(false);
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
            if (c.a.d.f.p.j.z()) {
                c.a.r0.t.d.c().f("page_frs_good");
                Q(true);
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
                showToast(i1.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = PermissionUtil.transformPermissionResult(strArr, iArr);
            if (!transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") || transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                return;
            }
            showToast(i1.sdcard_permission_denied_advert_for_camera);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            super.onResume();
            c.a.r0.d1.q2.g gVar = this.frsNewAreaView;
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
            bundle.putString("name", this.f44627f);
            bundle.putString("from", this.f44628g);
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
            if (!l.C()) {
                this.frsNewAreaView.m();
            } else if (this.frsNewAreaView.x()) {
            } else {
                if (!this.m.E()) {
                    this.frsNewAreaView.m();
                    return;
                }
                W();
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
            v.b().e(false);
            c.a.r0.s3.c.g().h(getUniqueId(), false);
            FrsViewData frsViewData = this.f44632k;
            if (frsViewData != null && frsViewData.getForum() != null) {
                c.a.q0.v.a.k().y(getPageContext().getPageActivity(), "frs", this.f44632k.getForum().getId(), 0L);
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
            W();
            if (arrayList == null || arrayList.size() == 0) {
                return;
            }
            ArrayList<n> C = this.n.C(false, false, false, arrayList, null);
            if (C != null) {
                this.f44632k.setThreadList(C);
                this.frsNewAreaView.H(C, this.f44630i, this.f44632k, 0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.f44632k.getForum()));
        }
    }

    public void onViewDataChange(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048641, this, frsViewData) == null) || frsViewData == null) {
            return;
        }
        this.f44632k = frsViewData;
        hideLoadingView(this.frsNewAreaView.l());
        c.a.r0.d1.q2.g gVar = this.frsNewAreaView;
        if (gVar != null) {
            gVar.A(false);
            this.frsNewAreaView.H(null, this.f44630i, this.f44632k, this.o);
        }
    }

    public void processBatchDelete(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, list) == null) {
            F(list);
            int i2 = 0;
            for (n nVar : this.f44632k.getThreadList()) {
                if (nVar instanceof c2) {
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
        c.a.r0.d1.q2.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048643, this) == null) || (gVar = this.frsNewAreaView) == null || gVar.k() == null) {
            return;
        }
        this.frsNewAreaView.k().post(new a(this));
    }

    @Override // c.a.r0.d1.q0
    public void scrollToTop() {
        c.a.r0.d1.q2.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048644, this) == null) || (gVar = this.frsNewAreaView) == null || gVar.k() == null) {
            return;
        }
        this.frsNewAreaView.k().scrollToPosition(0);
    }

    public void setFlag(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048645, this, i2) == null) {
            this.f44629h = i2;
        }
    }

    public void setForum(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, str) == null) {
            this.f44627f = str;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, str) == null) {
            this.f44628g = str;
        }
    }

    public void setFrsView(c.a.r0.d1.q2.g gVar) {
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
            this.f44630i = i2;
        }
    }

    public final void showLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            this.frsNewAreaView.B(false);
            showLoadingView(this.frsNewAreaView.l(), true, getResources().getDimensionPixelSize(d1.ds250));
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

    @Override // c.a.r0.h3.u
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
            c.a.r0.d1.q2.g gVar = this.frsNewAreaView;
            if (gVar == null) {
                return null;
            }
            return gVar.k();
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }
}
