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
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.c.k.e.q;
import d.a.c.k.e.w;
import d.a.o0.r.q.a2;
import d.a.o0.r.q.b2;
import d.a.p0.h3.m;
import d.a.p0.h3.s;
import d.a.p0.u0.p0;
import d.a.p0.u0.q0;
import d.a.p0.u0.r0;
import d.a.p0.w2.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class FrsNewAreaFragment extends BaseFragment implements VoiceManager.j, d.a.p0.u0.d2.a, UserIconBox.c, BdListView.p, FrsCommonImageLayout.e, p0, ActivityCompat.OnRequestPermissionsResultCallback, t, q0, d.a.p0.e.e.b, r0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public CustomMessageListener B;
    public Runnable C;
    public CustomMessageListener D;
    public CustomMessageListener E;
    public final s F;
    public final CustomMessageListener G;
    public final RecyclerView.OnScrollListener H;
    public final CustomMessageListener I;
    public w J;

    /* renamed from: e  reason: collision with root package name */
    public String f15972e;

    /* renamed from: f  reason: collision with root package name */
    public String f15973f;

    /* renamed from: g  reason: collision with root package name */
    public String f15974g;

    /* renamed from: h  reason: collision with root package name */
    public int f15975h;

    /* renamed from: i  reason: collision with root package name */
    public int f15976i;
    public String j;
    public FrsViewData k;
    public VoiceManager l;
    public long m;
    public long n;
    public long o;
    public FrsNewAreaModelController p;
    public FrsLoadMoreModel q;
    public d.a.p0.u0.e2.g r;
    public int s;
    public int t;
    public boolean u;
    public boolean v;
    public d.a.o0.d0.c w;
    public SparseArray<d.a.p0.e.e.a> x;
    public int y;
    public int z;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsNewAreaFragment f15977e;

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
            this.f15977e = frsNewAreaFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.p0.u0.e2.g gVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (gVar = this.f15977e.r) == null || gVar.k() == null || this.f15977e.r.k().isComputingLayout()) {
                return;
            }
            this.f15977e.r.t();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsNewAreaFragment f15978a;

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
            this.f15978a = frsNewAreaFragment;
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
                this.f15978a.k1(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsNewAreaFragment f15979e;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f15980e;

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
                this.f15980e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    NetWork netWork = new NetWork(this.f15980e);
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
            this.f15979e = frsNewAreaFragment;
        }

        @Override // d.a.c.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) || bdUniqueId == null || nVar == null || !(nVar instanceof a2)) {
                return;
            }
            b2 b2Var = ((a2) nVar).w;
            if (b2Var.C() == null || b2Var.C().getGroup_id() == 0 || ViewHelper.checkUpIsLogin(this.f15979e.getActivity())) {
                if (b2Var.q() != 1 || ViewHelper.checkUpIsLogin(this.f15979e.getActivity())) {
                    d.a.p0.h3.n0.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null && !readThreadHistory.d(b2Var.c0())) {
                        readThreadHistory.a(b2Var.c0());
                        d.a.p0.u0.e2.g gVar = this.f15979e.r;
                        if (gVar != null) {
                            gVar.p();
                        }
                    }
                    String x = b2Var.x();
                    if (x == null || x.equals("")) {
                        z = false;
                    } else {
                        new Thread(new a(this, x)).start();
                        z = true;
                    }
                    String n1 = b2Var.n1();
                    if (n1 == null) {
                        n1 = "";
                    }
                    if (b2Var.m0() == 2 && !n1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                        UrlManager.getInstance().dealOneLink(this.f15979e.getPageContext(), new String[]{n1, "", null});
                        return;
                    }
                    if (n1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && n1.length() > 3) {
                        b2Var.v3(n1.substring(3));
                    }
                    PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.f15979e.getPageContext().getPageActivity()).createFromThreadCfg(b2Var, this.f15979e.f15973f, "frs_page", 18003, true, false, z);
                    createFromThreadCfg.setForumId(String.valueOf(b2Var.Q()));
                    createFromThreadCfg.setStartFrom(3);
                    this.f15979e.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                    if (this.f15979e.k == null || this.f15979e.k.getForum() == null) {
                        return;
                    }
                    d.a.p0.u0.j2.b bVar = new d.a.p0.u0.j2.b();
                    bVar.f62956a = this.f15979e.k.needLog == 1;
                    bVar.f62958c = this.f15979e.k.getForum().getId();
                    bVar.f62957b = this.f15979e.p.y();
                    d.a.p0.u0.j2.b bVar2 = d.a.p0.u0.j2.d.h0;
                    if (bVar2 != null) {
                        bVar.f62959d = bVar2.f62959d;
                        bVar.f62960e = bVar2.f62960e;
                    }
                    d.a.p0.u0.j2.a.c(b2Var, 1, this.f15979e.getUniqueId(), bVar, this.f15979e.getTbPageTag());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsNewAreaFragment f15981a;

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
            this.f15981a = frsNewAreaFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer) || (num = (Integer) customResponsedMessage.getData()) == null || this.f15981a.w == null || !this.f15981a.w.isViewAttached()) {
                return;
            }
            this.f15981a.w.a(num.intValue());
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsNewAreaFragment f15982e;

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
            this.f15982e = frsNewAreaFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!d.a.c.e.p.j.z() || this.f15982e.u) {
                    this.f15982e.H1(null);
                } else {
                    this.f15982e.v1(false);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsNewAreaFragment f15983a;

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
            this.f15983a = frsNewAreaFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof b2)) {
                b2 b2Var = (b2) customResponsedMessage.getData();
                this.f15983a.f15972e = b2Var.c0();
                if (TextUtils.isEmpty(this.f15983a.f15972e) || b2Var.G0() == null) {
                    return;
                }
                this.f15983a.K1(b2Var.G0().getIsLike());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsNewAreaFragment f15984a;

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
            this.f15984a = frsNewAreaFragment;
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
                if (this.f15984a.n1() != null) {
                    this.f15984a.n1().setSelection(0);
                }
                if (this.f15984a.w != null && this.f15984a.w.isViewAttached()) {
                    this.f15984a.v1(false);
                    return;
                }
                d.a.p0.u0.e2.g gVar = this.f15984a.r;
                if (gVar != null) {
                    gVar.L();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f15985a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrsNewAreaFragment f15986b;

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
            this.f15986b = frsNewAreaFragment;
            this.f15985a = 1L;
        }

        @Override // d.a.p0.h3.s
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f15986b.v) {
                return;
            }
            if (i2 == 1 || i2 == 2) {
                this.f15986b.r.p();
            } else if (i2 != 3) {
            } else {
                this.f15986b.r.A(true);
            }
        }

        @Override // d.a.p0.h3.s
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // d.a.p0.h3.s
        public void c(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar) == null) {
            }
        }

        @Override // d.a.p0.h3.s
        public void d(int i2, boolean z, d.a.p0.h3.f fVar) {
            ArrayList<n> C;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), fVar}) == null) {
                if (this.f15986b.v) {
                    if (this.f15986b.q1().z() == null) {
                        this.f15986b.v = false;
                        return;
                    } else if (this.f15986b.q1().z().getThreadList().size() >= 10) {
                        this.f15986b.v = false;
                        d.a.p0.u0.k2.e eVar = new d.a.p0.u0.k2.e();
                        eVar.f63013b = 301;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384, eVar));
                        return;
                    }
                }
                if (fVar == null) {
                    this.f15985a = 1L;
                } else if (fVar.f57934b) {
                    this.f15985a = 0L;
                } else {
                    this.f15985a = 1L;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (i2 == 3) {
                    this.f15986b.q.N();
                }
                this.f15986b.r.A(false);
                if (this.f15986b.q1().z() != null) {
                    FrsNewAreaFragment frsNewAreaFragment = this.f15986b;
                    frsNewAreaFragment.k = frsNewAreaFragment.q1().z();
                }
                FrsNewAreaFragment frsNewAreaFragment2 = this.f15986b;
                frsNewAreaFragment2.s = frsNewAreaFragment2.k.getPage().b();
                if (this.f15986b.s == 0 && (this.f15986b.k.getThreadListIds() == null || this.f15986b.k.getThreadListIds().size() == 0)) {
                    if (this.f15986b.k.getThreadList() != null && this.f15986b.k.getThreadList().size() != 0) {
                        this.f15986b.r.K();
                    } else {
                        this.f15986b.r.m();
                    }
                } else {
                    this.f15986b.r.J();
                }
                if (i2 == 4) {
                    ArrayList<n> C2 = this.f15986b.q.C(false, false, false, this.f15986b.k.getThreadList(), null);
                    if (C2 != null) {
                        this.f15986b.k.setThreadList(C2);
                        FrsNewAreaFragment frsNewAreaFragment3 = this.f15986b;
                        frsNewAreaFragment3.r.H(C2, frsNewAreaFragment3.f15976i, this.f15986b.k, this.f15986b.s);
                        return;
                    }
                    return;
                }
                if (i2 == 1) {
                    this.f15986b.r.p();
                } else if (i2 != 2) {
                    if (i2 == 3 && this.f15986b.k.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, Boolean.TRUE));
                    }
                } else {
                    this.f15986b.r.p();
                }
                this.f15986b.l();
                if (this.f15985a != 0) {
                    this.f15986b.H1(fVar);
                } else {
                    this.f15986b.r1();
                    if (this.f15986b.k != null) {
                        FrsNewAreaFragment frsNewAreaFragment4 = this.f15986b;
                        frsNewAreaFragment4.f15973f = frsNewAreaFragment4.k.getForum().getName();
                        FrsNewAreaFragment frsNewAreaFragment5 = this.f15986b;
                        frsNewAreaFragment5.j = frsNewAreaFragment5.k.getForum().getId();
                        FrsNewAreaFragment frsNewAreaFragment6 = this.f15986b;
                        frsNewAreaFragment6.r.s(frsNewAreaFragment6.k.getForum(), this.f15986b.k.getUserData());
                    }
                    if (this.f15986b.k != null) {
                        this.f15986b.k.addNoticeThreadToThreadList();
                    }
                    if (this.f15986b.k == null || this.f15986b.k.getThreadList() == null || this.f15986b.k.getThreadList().size() != 0 || this.f15986b.q1().getType() != 4) {
                        if (this.f15986b.k != null && (C = this.f15986b.q.C(false, false, true, this.f15986b.k.getThreadList(), null)) != null && C.size() > 0) {
                            this.f15986b.k.setThreadList(C);
                        }
                        this.f15986b.A1();
                    } else {
                        FrsNewAreaFragment frsNewAreaFragment7 = this.f15986b;
                        frsNewAreaFragment7.showToast(frsNewAreaFragment7.getPageContext().getString(R.string.no_more_to_load));
                        if (this.f15986b.f15976i > 1) {
                            FrsNewAreaFragment.M0(this.f15986b);
                        }
                        if (this.f15986b.m > -1) {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            FrsNewAreaFragment frsNewAreaFragment8 = this.f15986b;
                            long B = frsNewAreaFragment8.q1().B();
                            FrsNewAreaFragment frsNewAreaFragment9 = this.f15986b;
                            TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis2 - frsNewAreaFragment8.m, B - frsNewAreaFragment9.m, frsNewAreaFragment9.q1().D(), this.f15986b.q1().C(), currentTimeMillis2 - this.f15986b.q1().A());
                            this.f15986b.m = -1L;
                        }
                        this.f15986b.n = System.currentTimeMillis() - currentTimeMillis;
                        return;
                    }
                }
                if (this.f15986b.m > -1) {
                    long currentTimeMillis3 = System.currentTimeMillis();
                    FrsNewAreaFragment frsNewAreaFragment10 = this.f15986b;
                    long B2 = frsNewAreaFragment10.q1().B();
                    FrsNewAreaFragment frsNewAreaFragment11 = this.f15986b;
                    TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis3 - frsNewAreaFragment10.m, B2 - frsNewAreaFragment11.m, frsNewAreaFragment11.q1().D(), this.f15986b.q1().C(), currentTimeMillis3 - this.f15986b.q1().A());
                    this.f15986b.m = -1L;
                }
                this.f15986b.n = System.currentTimeMillis() - currentTimeMillis;
                System.gc();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsNewAreaFragment f15987a;

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
            this.f15987a = frsNewAreaFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.p0.u0.e2.g gVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || (gVar = this.f15987a.r) == null) {
                return;
            }
            gVar.L();
        }
    }

    /* loaded from: classes4.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsNewAreaFragment f15988e;

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
            this.f15988e = frsNewAreaFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.p0.h3.n0.a.o(this.f15988e.f15973f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsNewAreaFragment f15989a;

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
            this.f15989a = frsNewAreaFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) && i2 == 0) {
                d.a.p0.a0.t.b().e(true);
                d.a.p0.g3.c.g().h(this.f15989a.getUniqueId(), true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                this.f15989a.z += i3;
                if (this.f15989a.z < this.f15989a.y * 2 || i3 >= 0) {
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
        this.f15973f = null;
        this.f15974g = null;
        this.f15975h = 0;
        this.f15976i = 1;
        this.j = null;
        this.k = new FrsViewData();
        this.m = -1L;
        this.o = -1L;
        this.r = null;
        this.s = -1;
        this.t = 3;
        this.u = false;
        this.v = false;
        this.x = new SparseArray<>();
        this.y = 0;
        this.z = 0;
        this.B = new d(this, 2921397, true);
        this.C = new e(this);
        this.D = new f(this, 2004004);
        this.E = new g(this, 2001624);
        this.F = new h(this);
        this.G = new i(this, 2003003);
        this.H = new k(this);
        this.I = new b(this, 0);
        this.J = new c(this);
    }

    public static /* synthetic */ int M0(FrsNewAreaFragment frsNewAreaFragment) {
        int i2 = frsNewAreaFragment.f15976i;
        frsNewAreaFragment.f15976i = i2 - 1;
        return i2;
    }

    @Override // d.a.p0.w2.t
    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    public final void A1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            I1();
            try {
                if (this.k == null) {
                    return;
                }
                this.r.y();
                this.r.I();
                this.f15973f = this.k.getForum().getName();
                this.j = this.k.getForum().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.k.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.k.getUserData().getBimg_end_time());
                y1();
                ArrayList<n> threadList = this.k.getThreadList();
                if (threadList != null) {
                    this.r.H(threadList, this.f15976i, this.k, this.k.getPage().b());
                    z1();
                    this.r.z();
                    if (this.k.getIsNewUrl() == 1) {
                        this.r.j().r(true);
                    } else {
                        this.r.j().r(false);
                    }
                    this.r.C(o1(q1().getType(), this.f15976i));
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void B1() {
        d.a.p0.u0.e2.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (gVar = this.r) == null || gVar.k() == null) {
            return;
        }
        this.r.k().post(new a(this));
    }

    public void C1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f15975h = i2;
        }
    }

    public void D1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f15973f = str;
        }
    }

    @Override // d.a.p0.u0.p0
    public void E0() {
        d.a.p0.u0.e2.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (gVar = this.r) == null || gVar.k() == null) {
            return;
        }
        this.r.k().scrollToPosition(0);
    }

    public void E1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f15976i = i2;
        }
    }

    public final void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.s == 0 && !this.q.A(this.k.getThreadListIds())) {
                if (this.k.getThreadList() != null && this.k.getThreadList().size() != 0) {
                    this.r.K();
                    return;
                } else {
                    this.r.m();
                    return;
                }
            }
            this.r.J();
        }
    }

    public final void G1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.r.B(false);
            showLoadingView(this.r.l(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
        }
    }

    @Override // d.a.p0.u0.r0
    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            d.a.p0.g3.c.g().h(getUniqueId(), false);
        }
    }

    public final void H1(d.a.p0.h3.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) {
            this.r.B(false);
            this.r.G(false);
            this.r.m();
            this.r.k().getData().clear();
            this.r.p();
            if (this.w == null) {
                d.a.o0.d0.c cVar = new d.a.o0.d0.c(getPageContext().getContext(), getNetRefreshListener());
                this.w = cVar;
                cVar.e(null);
                this.w.c(null);
                this.w.f();
                this.w.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            if (fVar != null) {
                this.w.d(getPageContext().getResources().getString(R.string.net_error_text, fVar.f57936d, Integer.valueOf(fVar.f57935c)));
            } else {
                this.w.d(null);
            }
            this.w.onChangeSkinType();
            this.w.attachView(this.r.l(), true);
            this.w.a(0);
        }
    }

    public void I1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            VoiceManager voiceManager = getVoiceManager();
            this.l = voiceManager;
            voiceManager.stopPlay();
        }
    }

    public final void J1(b2 b2Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, b2Var, i2) == null) {
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

    public final void K1(int i2) {
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
            if (next instanceof a2) {
                b2 b2Var = ((a2) next).w;
                if (b2Var.c0() != null && b2Var.c0().equals(this.f15972e)) {
                    J1(b2Var, i2);
                    this.f15972e = null;
                    break;
                }
            }
        }
        this.r.j().q(threadList, this.k);
        this.r.j().l();
    }

    @Override // d.a.p0.w2.t
    public void O() {
        FrsNewAreaModelController frsNewAreaModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (frsNewAreaModelController = this.p) == null) {
            return;
        }
        frsNewAreaModelController.O();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void a(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, arrayList) == null) {
            F1();
            if (arrayList == null || arrayList.size() == 0) {
                return;
            }
            ArrayList<n> C = this.q.C(false, false, false, arrayList, null);
            if (C != null) {
                this.k.setThreadList(C);
                this.r.H(C, this.f15976i, this.k, 0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.k.getForum()));
        }
    }

    @Override // d.a.p0.e.e.b
    public void dispatchInjectPluginMessage(d.a.p0.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, dVar) == null) {
        }
    }

    @Override // d.a.p0.u0.d2.a, d.a.p0.u0.t0
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f15973f : (String) invokeV.objValue;
    }

    @Override // d.a.p0.u0.q0
    public NavigationBar g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return null;
        }
        return (NavigationBar) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public d.a.c.e.k.b<TbImageView> getFrsCommonImageLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (getBaseFragmentActivity() instanceof FrsActivity) {
                return ((FrsActivity) getBaseFragmentActivity()).getFrsCommonImageLayoutPool();
            }
            return null;
        }
        return (d.a.c.e.k.b) invokeV.objValue;
    }

    @Override // d.a.p0.e.e.b
    public d.a.p0.e.e.a getInjectPlugin(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) ? this.x.get(i2) : (d.a.p0.e.e.a) invokeI.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.p0.u0.d2.a
    public /* bridge */ /* synthetic */ d.a.c.a.f getPageContext() {
        return super.getPageContext();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, voiceData$VoiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            TbPageTag tbPageTag = super.getTbPageTag();
            FrsViewData frsViewData = this.k;
            tbPageTag.sortType = d.a.p0.u0.n2.k.g(frsViewData != null ? frsViewData.getSortType() : -1);
            tbPageTag.locatePage = "a071";
            return tbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public d.a.c.e.k.b<TbImageView> getUserIconPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (this.l == null) {
                this.l = VoiceManager.instance();
            }
            return this.l;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // d.a.p0.u0.d2.a
    public FrsViewData i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.k : (FrsViewData) invokeV.objValue;
    }

    public void i1(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, b2Var) == null) || b2Var == null) {
            return;
        }
        this.p.w(b2Var);
    }

    public final void j1(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        ArrayList<n> threadList = this.k.getThreadList();
        if (ListUtils.isEmpty(threadList) || this.r.k() == null || this.r.k().getData() == null) {
            return;
        }
        Iterator<n> it = threadList.iterator();
        List<n> data = this.r.k().getData();
        int i2 = 0;
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof a2) {
                b2 b2Var = ((a2) next).w;
                int i3 = 0;
                while (true) {
                    if (i3 >= list.size()) {
                        break;
                    } else if (StringHelper.equals(list.get(i3), b2Var.c0())) {
                        it.remove();
                        data.remove(next);
                        this.q.K(next);
                        this.r.k().getAdapter().notifyItemRemoved(i2);
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            i2++;
        }
    }

    public final void k1(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, responsedMessage) == null) || this.k == null || this.r == null || !(responsedMessage instanceof DownloadMessage) || (data = ((DownloadMessage) responsedMessage).getData()) == null) {
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
            this.r.p();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.r.B(true);
            hideLoadingView(this.r.l());
        }
    }

    @Override // d.a.p0.u0.r0
    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            if (getPageContext() != null) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            }
            if (d.a.c.e.p.j.z()) {
                d.a.p0.o.d.c().f("page_frs_good");
                v1(true);
                return;
            }
            this.r.A(false);
        }
    }

    public final void l1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13008");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", this.j);
            statisticItem.param("obj_type", 6);
            statisticItem.param("obj_locate", 2);
            statisticItem.eventStat();
        }
    }

    public void loadMore() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || this.q.isLoading || this.p.G()) {
            return;
        }
        if (this.q.A(this.k.getThreadListIds())) {
            String e2 = this.p.z() != null ? d.a.p0.w2.a.e(this.p.z().getThreadList(), false) : "";
            this.r.H(this.q.L(), this.f15976i, this.k, 0);
            this.q.M(d.a.c.e.m.b.f(this.j, 0L), this.k.getThreadListIds(), this.f15973f, this.f15976i, this.k.isBrandForum, e2);
        } else if (this.s != 0) {
            this.r.H(this.q.L(), this.f15976i, this.k, 0);
            int i2 = this.f15976i + 1;
            this.f15976i = i2;
            this.p.I(i2);
            FrsLoadMoreModel frsLoadMoreModel = this.q;
            frsLoadMoreModel.loadingDone = false;
            frsLoadMoreModel.loadIndex = 0;
        }
    }

    @Override // d.a.p0.w2.t
    public TbPageContext<?> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? getPageContext() : (TbPageContext) invokeV.objValue;
    }

    public d.a.p0.u0.e2.g m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.r : (d.a.p0.u0.e2.g) invokeV.objValue;
    }

    public BdTypeRecyclerView n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            d.a.p0.u0.e2.g gVar = this.r;
            if (gVar == null) {
                return null;
            }
            return gVar.k();
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public final int o1(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048613, this, i2, i3)) == null) {
            if (i2 != 1) {
                return (i2 != 2 || i3 == 1) ? 0 : 3;
            }
            return 3;
        }
        return invokeII.intValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        b2 threadDataById;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048614, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1 && i2 == 18003) {
                this.r.j().l();
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra == null || (threadDataById = this.k.getThreadDataById(stringExtra)) == null) {
                    return;
                }
                int intExtra = intent.getIntExtra("type", -1);
                if (intExtra == 2) {
                    threadDataById.C3(intent.getIntExtra("good_data", 0));
                    threadDataById.M2();
                    v1(false);
                } else if (intExtra == 0) {
                    this.k.removeThreadData(threadDataById);
                    ArrayList<n> threadList = this.k.getThreadList();
                    if (threadList != null && threadList.size() <= 0) {
                        threadList.add(new d.a.p0.u0.s());
                    }
                    this.r.z();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            if (this.t == 3 && this.r == null) {
                return;
            }
            this.t = i2;
            super.onChangeSkinType(i2);
            d.a.p0.u0.e2.g gVar = this.r;
            if (gVar != null) {
                gVar.q(i2);
            }
            d.a.o0.d0.c cVar = this.w;
            if (cVar == null || !cVar.isViewAttached()) {
                return;
            }
            this.w.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, bundle) == null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.m = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
            } else {
                this.m = System.currentTimeMillis();
            }
            if (arguments != null) {
                this.j = arguments.getString("forum_id", "");
                this.A = arguments.getBoolean(FrsActivityConfig.FLAG_SHOW_AD);
            }
            this.o = System.currentTimeMillis();
            super.onCreate(bundle);
            d.a.p0.g3.c.g().i(getUniqueId());
            FrsNewAreaModelController frsNewAreaModelController = new FrsNewAreaModelController(this);
            this.p = frsNewAreaModelController;
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
            t1(bundle);
            registerListener(this.G);
            registerListener(this.D);
            registerListener(this.E);
            registerListener(this.B);
            FrsLoadMoreModel frsLoadMoreModel = new FrsLoadMoreModel(this, null);
            this.q = frsLoadMoreModel;
            frsLoadMoreModel.registerListener();
            this.q.S(3);
            this.q.P(true);
            this.q.O(d.a.p0.w0.a.a(this.A));
            System.currentTimeMillis();
            this.y = UtilHelper.getScreenHeight(getActivity());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048617, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
            this.r = new d.a.p0.u0.e2.g(this, inflate);
            u1();
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            d.a.p0.u0.e2.g gVar = this.r;
            if (gVar != null) {
                gVar.r();
            }
            MessageManager.getInstance().unRegisterListener(this.B);
            d.a.p0.g3.c.g().k(getUniqueId());
            d.a.p0.a0.t.b().e(false);
            super.onDestroy();
            this.p.J();
            VoiceManager voiceManager = getVoiceManager();
            this.l = voiceManager;
            voiceManager.onDestory(getPageContext());
            d.a.c.e.m.e.a().removeCallbacks(this.C);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void onFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            F1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public q onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (n1() == null) {
                return null;
            }
            return n1().getPreLoadHandle();
        }
        return (q) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            super.onLazyLoad();
            if (this.u) {
                return;
            }
            if (d.a.c.e.p.j.z()) {
                v1(false);
            } else {
                H1(null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            l1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048623, this) == null) && d.a.c.e.p.j.z()) {
            v1(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            super.onPause();
            VoiceManager voiceManager = getVoiceManager();
            this.l = voiceManager;
            voiceManager.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                if (this.t == 3) {
                    onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                }
                if (this.u) {
                    return;
                }
                d.a.c.e.m.e.a().post(this.C);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048626, this, i2, strArr, iArr) == null) && i2 == 1) {
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
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            super.onResume();
            d.a.p0.u0.e2.g gVar = this.r;
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
        if (interceptable == null || interceptable.invokeL(1048628, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("name", this.f15973f);
            bundle.putString("from", this.f15974g);
            this.p.onSaveInstanceState(bundle);
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
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            if (!l.D()) {
                this.r.m();
            } else if (this.r.x()) {
            } else {
                if (!this.p.E()) {
                    this.r.m();
                    return;
                }
                F1();
                loadMore();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            super.onStart();
            VoiceManager voiceManager = getVoiceManager();
            this.l = voiceManager;
            voiceManager.onStart(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            super.onStop();
            d.a.p0.a0.t.b().e(false);
            d.a.p0.g3.c.g().h(getUniqueId(), false);
            FrsViewData frsViewData = this.k;
            if (frsViewData != null && frsViewData.getForum() != null) {
                d.a.o0.u.a.k().y(getPageContext().getPageActivity(), "frs", this.k.getForum().getId(), 0L);
            }
            VoiceManager voiceManager = getVoiceManager();
            this.l = voiceManager;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
        }
    }

    public FrsLoadMoreModel p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.q : (FrsLoadMoreModel) invokeV.objValue;
    }

    public FrsNewAreaModelController q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.p : (FrsNewAreaModelController) invokeV.objValue;
    }

    public final void r1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            d.a.p0.u0.e2.g gVar = this.r;
            if (gVar != null) {
                gVar.B(true);
                this.r.G(true);
            }
            d.a.o0.d0.c cVar = this.w;
            if (cVar == null || !cVar.isViewAttached()) {
                return;
            }
            this.w.dettachView(this.r.l());
        }
    }

    @Override // d.a.p0.u0.p0
    public void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048635, this) == null) || this.r == null) {
            return;
        }
        E0();
        this.r.L();
    }

    public final void s1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            registerListener(2001118, this.I);
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, str) == null) {
            this.f15974g = str;
        }
    }

    @Override // d.a.p0.e.e.b
    public void setInjectPlugin(int i2, d.a.p0.e.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048638, this, i2, aVar) == null) {
            this.x.put(i2, aVar);
        }
    }

    public final void t1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, bundle) == null) {
            s1();
            if (bundle != null) {
                this.f15973f = bundle.getString("name");
                this.f15974g = bundle.getString("from");
                this.f15975h = bundle.getInt("flag", 0);
            } else {
                Bundle arguments = getArguments();
                if (arguments != null) {
                    this.f15973f = arguments.getString("name");
                    this.f15974g = arguments.getString("from");
                    this.f15975h = arguments.getInt("flag", 0);
                }
            }
            if (TextUtils.isEmpty(this.f15974g) || !FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.f15974g)) {
                return;
            }
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    public final void u1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            if (this.f15975h != 0) {
                this.f15975h = 1;
            }
            this.r.E(this.J);
            this.r.F(this.H);
        }
    }

    public final void v1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048641, this, z) == null) {
            this.u = true;
            I1();
            r1();
            if (!z) {
                r1();
                G1();
            }
            FrsNewAreaModelController frsNewAreaModelController = this.p;
            if (frsNewAreaModelController != null) {
                frsNewAreaModelController.H();
            }
        }
    }

    @Override // d.a.p0.w2.t
    public int w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.f15976i : invokeV.intValue;
    }

    public void w1(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048643, this, frsViewData) == null) || frsViewData == null) {
            return;
        }
        this.k = frsViewData;
        hideLoadingView(this.r.l());
        d.a.p0.u0.e2.g gVar = this.r;
        if (gVar != null) {
            gVar.A(false);
            this.r.H(null, this.f15976i, this.k, this.s);
        }
    }

    public void x1(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, list) == null) {
            j1(list);
            int i2 = 0;
            for (n nVar : this.k.getThreadList()) {
                if (nVar instanceof a2) {
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

    public final void y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            if (this.f15975h == 1) {
                d.a.c.e.m.h.a().b(new j(this));
            }
            this.f15975h = 0;
        }
    }

    public final void z1() {
        d.a.p0.u0.e2.g gVar;
        HashMap<Integer, b2> h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048646, this) == null) || (gVar = this.r) == null || gVar.j() == null || (h2 = this.r.j().h()) == null) {
            return;
        }
        ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
        for (Map.Entry<Integer, b2> entry : h2.entrySet()) {
            b2 value = entry.getValue();
            if (value != null && (value instanceof AdvertAppInfo)) {
                arrayList.add((AdvertAppInfo) value);
            }
        }
        d.a.o0.v.b.l().m(arrayList);
    }
}
