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
import c.a.e.e.p.l;
import c.a.e.k.e.n;
import c.a.e.k.e.q;
import c.a.e.k.e.w;
import c.a.o0.s.q.b2;
import c.a.o0.s.q.c2;
import c.a.p0.a0.t;
import c.a.p0.i3.m;
import c.a.p0.i3.s;
import c.a.p0.v0.p0;
import c.a.p0.v0.q0;
import c.a.p0.v0.r0;
import c.a.p0.x2.u;
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
/* loaded from: classes7.dex */
public class FrsNewAreaFragment extends BaseFragment implements VoiceManager.j, c.a.p0.v0.d2.a, UserIconBox.c, BdListView.p, FrsCommonImageLayout.e, p0, ActivityCompat.OnRequestPermissionsResultCallback, u, q0, c.a.p0.f.e.b, r0 {
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
    public String f51210e;

    /* renamed from: f  reason: collision with root package name */
    public String f51211f;
    public c.a.p0.v0.e2.g frsNewAreaView;

    /* renamed from: g  reason: collision with root package name */
    public String f51212g;

    /* renamed from: h  reason: collision with root package name */
    public int f51213h;

    /* renamed from: i  reason: collision with root package name */
    public int f51214i;
    public long initTime;

    /* renamed from: j  reason: collision with root package name */
    public String f51215j;
    public FrsViewData k;
    public VoiceManager l;
    public FrsNewAreaModelController m;
    public final s mForumModelCallback;
    public FrsLoadMoreModel n;
    public int o;
    public int p;
    public boolean q;
    public boolean r;
    public c.a.o0.f0.c s;
    public long sysCreateTime;
    public SparseArray<c.a.p0.f.e.a> t;
    public int u;
    public int v;
    public boolean w;
    public CustomMessageListener x;
    public Runnable y;
    public CustomMessageListener z;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsNewAreaFragment f51216e;

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
            this.f51216e = frsNewAreaFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.p0.v0.e2.g gVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (gVar = this.f51216e.frsNewAreaView) == null || gVar.k() == null || this.f51216e.frsNewAreaView.k().isComputingLayout()) {
                return;
            }
            this.f51216e.frsNewAreaView.t();
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsNewAreaFragment f51217a;

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
            this.f51217a = frsNewAreaFragment;
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
                this.f51217a.D(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsNewAreaFragment f51218e;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f51219e;

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
                this.f51219e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    NetWork netWork = new NetWork(this.f51219e);
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
            this.f51218e = frsNewAreaFragment;
        }

        @Override // c.a.e.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || bdUniqueId == null || nVar == null || !(nVar instanceof b2)) {
                return;
            }
            c2 c2Var = ((b2) nVar).w;
            if (c2Var.E() == null || c2Var.E().getGroup_id() == 0 || ViewHelper.checkUpIsLogin(this.f51218e.getActivity())) {
                if (c2Var.w() != 1 || ViewHelper.checkUpIsLogin(this.f51218e.getActivity())) {
                    c.a.p0.i3.n0.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null && !readThreadHistory.d(c2Var.f0())) {
                        readThreadHistory.a(c2Var.f0());
                        c.a.p0.v0.e2.g gVar = this.f51218e.frsNewAreaView;
                        if (gVar != null) {
                            gVar.p();
                        }
                    }
                    String z2 = c2Var.z();
                    if (z2 == null || z2.equals("")) {
                        z = false;
                    } else {
                        new Thread(new a(this, z2)).start();
                        z = true;
                    }
                    String q1 = c2Var.q1();
                    if (q1 == null) {
                        q1 = "";
                    }
                    if (c2Var.p0() == 2 && !q1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                        UrlManager.getInstance().dealOneLink(this.f51218e.getPageContext(), new String[]{q1, "", null});
                        return;
                    }
                    if (q1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && q1.length() > 3) {
                        c2Var.H3(q1.substring(3));
                    }
                    PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.f51218e.getPageContext().getPageActivity()).createFromThreadCfg(c2Var, this.f51218e.f51211f, FrsFragment.STAR_FRS, 18003, true, false, z);
                    createFromThreadCfg.setForumId(String.valueOf(c2Var.T()));
                    createFromThreadCfg.setStartFrom(3);
                    this.f51218e.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                    if (this.f51218e.k == null || this.f51218e.k.getForum() == null) {
                        return;
                    }
                    c.a.p0.v0.j2.b bVar = new c.a.p0.v0.j2.b();
                    bVar.f25937a = this.f51218e.k.needLog == 1;
                    bVar.f25939c = this.f51218e.k.getForum().getId();
                    bVar.f25938b = this.f51218e.m.y();
                    c.a.p0.v0.j2.b bVar2 = c.a.p0.v0.j2.d.h0;
                    if (bVar2 != null) {
                        bVar.f25940d = bVar2.f25940d;
                        bVar.f25941e = bVar2.f25941e;
                    }
                    c.a.p0.v0.j2.a.e(c2Var, 1, this.f51218e.getUniqueId(), bVar, this.f51218e.getTbPageTag());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsNewAreaFragment f51220a;

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
            this.f51220a = frsNewAreaFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer) || (num = (Integer) customResponsedMessage.getData()) == null || this.f51220a.s == null || !this.f51220a.s.isViewAttached()) {
                return;
            }
            this.f51220a.s.a(num.intValue());
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsNewAreaFragment f51221e;

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
            this.f51221e = frsNewAreaFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.e.e.p.j.z() || this.f51221e.q) {
                    this.f51221e.T(null);
                } else {
                    this.f51221e.O(false);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsNewAreaFragment f51222a;

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
            this.f51222a = frsNewAreaFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c2)) {
                c2 c2Var = (c2) customResponsedMessage.getData();
                this.f51222a.f51210e = c2Var.f0();
                if (TextUtils.isEmpty(this.f51222a.f51210e) || c2Var.J0() == null) {
                    return;
                }
                this.f51222a.V(c2Var.J0().getIsLike());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsNewAreaFragment f51223a;

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
            this.f51223a = frsNewAreaFragment;
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
                if (this.f51223a.getListView() != null) {
                    this.f51223a.getListView().setSelection(0);
                }
                if (this.f51223a.s != null && this.f51223a.s.isViewAttached()) {
                    this.f51223a.O(false);
                    return;
                }
                c.a.p0.v0.e2.g gVar = this.f51223a.frsNewAreaView;
                if (gVar != null) {
                    gVar.L();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f51224a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrsNewAreaFragment f51225b;

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
            this.f51225b = frsNewAreaFragment;
            this.f51224a = 1L;
        }

        @Override // c.a.p0.i3.s
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f51225b.r) {
                return;
            }
            if (i2 == 1 || i2 == 2) {
                this.f51225b.frsNewAreaView.p();
            } else if (i2 != 3) {
            } else {
                this.f51225b.frsNewAreaView.A(true);
            }
        }

        @Override // c.a.p0.i3.s
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // c.a.p0.i3.s
        public void c(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar) == null) {
            }
        }

        @Override // c.a.p0.i3.s
        public void d(int i2, boolean z, c.a.p0.i3.f fVar) {
            ArrayList<n> C;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), fVar}) == null) {
                if (this.f51225b.r) {
                    if (this.f51225b.getModelController().z() == null) {
                        this.f51225b.r = false;
                        return;
                    } else if (this.f51225b.getModelController().z().getThreadList().size() >= 10) {
                        this.f51225b.r = false;
                        c.a.p0.v0.k2.e eVar = new c.a.p0.v0.k2.e();
                        eVar.f25998b = 301;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384, eVar));
                        return;
                    }
                }
                if (fVar == null) {
                    this.f51224a = 1L;
                } else if (fVar.f19900b) {
                    this.f51224a = 0L;
                } else {
                    this.f51224a = 1L;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (i2 == 3) {
                    this.f51225b.n.N();
                }
                this.f51225b.frsNewAreaView.A(false);
                if (this.f51225b.getModelController().z() != null) {
                    FrsNewAreaFragment frsNewAreaFragment = this.f51225b;
                    frsNewAreaFragment.k = frsNewAreaFragment.getModelController().z();
                }
                FrsNewAreaFragment frsNewAreaFragment2 = this.f51225b;
                frsNewAreaFragment2.o = frsNewAreaFragment2.k.getPage().b();
                if (this.f51225b.o == 0 && (this.f51225b.k.getThreadListIds() == null || this.f51225b.k.getThreadListIds().size() == 0)) {
                    if (this.f51225b.k.getThreadList() != null && this.f51225b.k.getThreadList().size() != 0) {
                        this.f51225b.frsNewAreaView.K();
                    } else {
                        this.f51225b.frsNewAreaView.m();
                    }
                } else {
                    this.f51225b.frsNewAreaView.J();
                }
                if (i2 == 4) {
                    ArrayList<n> C2 = this.f51225b.n.C(false, false, false, this.f51225b.k.getThreadList(), null);
                    if (C2 != null) {
                        this.f51225b.k.setThreadList(C2);
                        FrsNewAreaFragment frsNewAreaFragment3 = this.f51225b;
                        frsNewAreaFragment3.frsNewAreaView.H(C2, frsNewAreaFragment3.f51214i, this.f51225b.k, this.f51225b.o);
                        return;
                    }
                    return;
                }
                if (i2 == 1) {
                    this.f51225b.frsNewAreaView.p();
                } else if (i2 != 2) {
                    if (i2 == 3 && this.f51225b.k.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, Boolean.TRUE));
                    }
                } else {
                    this.f51225b.frsNewAreaView.p();
                }
                this.f51225b.hideLoadingView();
                if (this.f51224a != 0) {
                    this.f51225b.T(fVar);
                } else {
                    this.f51225b.hideNetRefreshView();
                    if (this.f51225b.k != null) {
                        FrsNewAreaFragment frsNewAreaFragment4 = this.f51225b;
                        frsNewAreaFragment4.f51211f = frsNewAreaFragment4.k.getForum().getName();
                        FrsNewAreaFragment frsNewAreaFragment5 = this.f51225b;
                        frsNewAreaFragment5.f51215j = frsNewAreaFragment5.k.getForum().getId();
                        FrsNewAreaFragment frsNewAreaFragment6 = this.f51225b;
                        frsNewAreaFragment6.frsNewAreaView.s(frsNewAreaFragment6.k.getForum(), this.f51225b.k.getUserData());
                    }
                    if (this.f51225b.k != null) {
                        this.f51225b.k.addNoticeThreadToThreadList();
                    }
                    if (this.f51225b.k == null || this.f51225b.k.getThreadList() == null || this.f51225b.k.getThreadList().size() != 0 || this.f51225b.getModelController().getType() != 4) {
                        if (this.f51225b.k != null && (C = this.f51225b.n.C(false, false, true, this.f51225b.k.getThreadList(), null)) != null && C.size() > 0) {
                            this.f51225b.k.setThreadList(C);
                        }
                        this.f51225b.R();
                    } else {
                        FrsNewAreaFragment frsNewAreaFragment7 = this.f51225b;
                        frsNewAreaFragment7.showToast(frsNewAreaFragment7.getPageContext().getString(R.string.no_more_to_load));
                        if (this.f51225b.f51214i > 1) {
                            FrsNewAreaFragment.f(this.f51225b);
                        }
                        if (this.f51225b.initTime > -1) {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            FrsNewAreaFragment frsNewAreaFragment8 = this.f51225b;
                            long B = frsNewAreaFragment8.getModelController().B();
                            FrsNewAreaFragment frsNewAreaFragment9 = this.f51225b;
                            TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis2 - frsNewAreaFragment8.initTime, B - frsNewAreaFragment9.initTime, frsNewAreaFragment9.getModelController().D(), this.f51225b.getModelController().C(), currentTimeMillis2 - this.f51225b.getModelController().A());
                            this.f51225b.initTime = -1L;
                        }
                        this.f51225b.drawTime = System.currentTimeMillis() - currentTimeMillis;
                        return;
                    }
                }
                if (this.f51225b.initTime > -1) {
                    long currentTimeMillis3 = System.currentTimeMillis();
                    FrsNewAreaFragment frsNewAreaFragment10 = this.f51225b;
                    long B2 = frsNewAreaFragment10.getModelController().B();
                    FrsNewAreaFragment frsNewAreaFragment11 = this.f51225b;
                    TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis3 - frsNewAreaFragment10.initTime, B2 - frsNewAreaFragment11.initTime, frsNewAreaFragment11.getModelController().D(), this.f51225b.getModelController().C(), currentTimeMillis3 - this.f51225b.getModelController().A());
                    this.f51225b.initTime = -1L;
                }
                this.f51225b.drawTime = System.currentTimeMillis() - currentTimeMillis;
                System.gc();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsNewAreaFragment f51226a;

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
            this.f51226a = frsNewAreaFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.a.p0.v0.e2.g gVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || (gVar = this.f51226a.frsNewAreaView) == null) {
                return;
            }
            gVar.L();
        }
    }

    /* loaded from: classes7.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsNewAreaFragment f51227e;

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
            this.f51227e = frsNewAreaFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.i3.n0.a.o(this.f51227e.f51211f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsNewAreaFragment f51228a;

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
            this.f51228a = frsNewAreaFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) && i2 == 0) {
                t.b().e(true);
                c.a.p0.h3.c.g().h(this.f51228a.getUniqueId(), true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                this.f51228a.v += i3;
                if (this.f51228a.v < this.f51228a.u * 2 || i3 >= 0) {
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
        this.f51211f = null;
        this.f51212g = null;
        this.f51213h = 0;
        this.f51214i = 1;
        this.f51215j = null;
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

    public static /* synthetic */ int f(FrsNewAreaFragment frsNewAreaFragment) {
        int i2 = frsNewAreaFragment.f51214i;
        frsNewAreaFragment.f51214i = i2 - 1;
        return i2;
    }

    public final void B(List<String> list) {
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
            if (next instanceof b2) {
                c2 c2Var = ((b2) next).w;
                int i3 = 0;
                while (true) {
                    if (i3 >= list.size()) {
                        break;
                    } else if (StringHelper.equals(list.get(i3), c2Var.f0())) {
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

    public final void D(ResponsedMessage<?> responsedMessage) {
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

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13008");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", this.f51215j);
            statisticItem.param("obj_type", 6);
            statisticItem.param("obj_locate", 2);
            statisticItem.eventStat();
        }
    }

    public final int K(int i2, int i3) {
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

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            registerListener(2001118, this.D);
        }
    }

    public final void N(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            L();
            if (bundle != null) {
                this.f51211f = bundle.getString("name");
                this.f51212g = bundle.getString("from");
                this.f51213h = bundle.getInt("flag", 0);
            } else {
                Bundle arguments = getArguments();
                if (arguments != null) {
                    this.f51211f = arguments.getString("name");
                    this.f51212g = arguments.getString("from");
                    this.f51213h = arguments.getInt("flag", 0);
                }
            }
            if (TextUtils.isEmpty(this.f51212g) || !FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.f51212g)) {
                return;
            }
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    public final void O(boolean z) {
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
                frsNewAreaModelController.H();
            }
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.f51213h == 1) {
                c.a.e.e.m.h.a().b(new j(this));
            }
            this.f51213h = 0;
        }
    }

    public final void Q() {
        c.a.p0.v0.e2.g gVar;
        HashMap<Integer, c2> h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (gVar = this.frsNewAreaView) == null || gVar.j() == null || (h2 = this.frsNewAreaView.j().h()) == null) {
            return;
        }
        ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
        for (Map.Entry<Integer, c2> entry : h2.entrySet()) {
            c2 value = entry.getValue();
            if (value != null && (value instanceof AdvertAppInfo)) {
                arrayList.add((AdvertAppInfo) value);
            }
        }
        c.a.o0.w.c.q().u(arrayList);
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            stopVoice();
            try {
                if (this.k == null) {
                    return;
                }
                this.frsNewAreaView.y();
                this.frsNewAreaView.I();
                this.f51211f = this.k.getForum().getName();
                this.f51215j = this.k.getForum().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.k.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.k.getUserData().getBimg_end_time());
                P();
                ArrayList<n> threadList = this.k.getThreadList();
                if (threadList != null) {
                    this.frsNewAreaView.H(threadList, this.f51214i, this.k, this.k.getPage().b());
                    Q();
                    this.frsNewAreaView.z();
                    if (this.k.getIsNewUrl() == 1) {
                        this.frsNewAreaView.j().r(true);
                    } else {
                        this.frsNewAreaView.j().r(false);
                    }
                    this.frsNewAreaView.C(K(getModelController().getType(), this.f51214i));
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public final void S() {
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

    public final void T(c.a.p0.i3.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, fVar) == null) {
            this.frsNewAreaView.B(false);
            this.frsNewAreaView.G(false);
            this.frsNewAreaView.m();
            this.frsNewAreaView.k().getData().clear();
            this.frsNewAreaView.p();
            if (this.s == null) {
                c.a.o0.f0.c cVar = new c.a.o0.f0.c(getPageContext().getContext(), getNetRefreshListener());
                this.s = cVar;
                cVar.e(null);
                this.s.c(null);
                this.s.f();
                this.s.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            if (fVar != null) {
                this.s.d(getPageContext().getResources().getString(R.string.net_error_text, fVar.f19902d, Integer.valueOf(fVar.f19901c)));
            } else {
                this.s.d(null);
            }
            this.s.onChangeSkinType();
            this.s.attachView(this.frsNewAreaView.l(), true);
            this.s.a(0);
        }
    }

    public final void U(c2 c2Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, c2Var, i2) == null) {
            if (i2 == 1) {
                PraiseData J0 = c2Var.J0();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (J0 == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i2);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        c2Var.c4(praiseData);
                        return;
                    }
                    c2Var.J0().getUser().add(0, metaData);
                    c2Var.J0().setNum(c2Var.J0().getNum() + 1);
                    c2Var.J0().setIsLike(i2);
                }
            } else if (c2Var.J0() != null) {
                c2Var.J0().setIsLike(i2);
                c2Var.J0().setNum(c2Var.J0().getNum() - 1);
                ArrayList<MetaData> user = c2Var.J0().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            c2Var.J0().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public final void V(int i2) {
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
            if (next instanceof b2) {
                c2 c2Var = ((b2) next).w;
                if (c2Var.f0() != null && c2Var.f0().equals(this.f51210e)) {
                    U(c2Var, i2);
                    this.f51210e = null;
                    break;
                }
            }
        }
        this.frsNewAreaView.j().q(threadList, this.k);
        this.frsNewAreaView.j().l();
    }

    public void addThreadData(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, c2Var) == null) || c2Var == null) {
            return;
        }
        this.m.w(c2Var);
    }

    @Override // c.a.p0.v0.p0
    public void changeToSpecialFrs(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
        }
    }

    public c.a.e.k.e.a createFrsExtraAdapter(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, bdUniqueId)) == null) ? c.a.p0.v0.e.e().d(getPageContext(), bdUniqueId, getPageContext().getUniqueId()) : (c.a.e.k.e.a) invokeL.objValue;
    }

    @Override // c.a.p0.f.e.b
    public void dispatchInjectPluginMessage(c.a.p0.f.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, dVar) == null) {
        }
    }

    @Override // c.a.p0.v0.p0
    public void forceRefresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || this.frsNewAreaView == null) {
            return;
        }
        scrollToTop();
        this.frsNewAreaView.L();
    }

    @Override // c.a.p0.x2.u
    public String getFid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f51215j : (String) invokeV.objValue;
    }

    @Override // c.a.p0.v0.d2.a, c.a.p0.v0.t0
    public String getForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f51211f : (String) invokeV.objValue;
    }

    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f51212g : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public c.a.e.e.k.b<TbImageView> getFrsCommonImageLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (getBaseFragmentActivity() instanceof FrsActivity) {
                return ((FrsActivity) getBaseFragmentActivity()).getFrsCommonImageLayoutPool();
            }
            return null;
        }
        return (c.a.e.e.k.b) invokeV.objValue;
    }

    public c.a.p0.v0.e2.g getFrsView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.frsNewAreaView : (c.a.p0.v0.e2.g) invokeV.objValue;
    }

    @Override // c.a.p0.v0.d2.a
    public FrsViewData getFrsViewData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.k : (FrsViewData) invokeV.objValue;
    }

    @Override // c.a.p0.f.e.b
    public c.a.p0.f.e.a getInjectPlugin(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) ? this.t.get(i2) : (c.a.p0.f.e.a) invokeI.objValue;
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

    @Override // c.a.p0.v0.q0
    public NavigationBar getNavigationBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return null;
        }
        return (NavigationBar) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.p0.v0.d2.a
    public /* bridge */ /* synthetic */ c.a.e.a.f getPageContext() {
        return super.getPageContext();
    }

    @Override // c.a.p0.x2.u
    public int getPageNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f51214i : invokeV.intValue;
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

    @Override // c.a.p0.x2.u
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
            tbPageTag.sortType = c.a.p0.v0.n2.k.g(frsViewData != null ? frsViewData.getSortType() : -1);
            tbPageTag.locatePage = "a071";
            return tbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public c.a.e.e.k.b<TbImageView> getUserIconPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            if (getBaseFragmentActivity() instanceof FrsActivity) {
                return ((FrsActivity) getBaseFragmentActivity()).getUserIconPool();
            }
            return null;
        }
        return (c.a.e.e.k.b) invokeV.objValue;
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
            c.a.p0.v0.e2.g gVar = this.frsNewAreaView;
            if (gVar != null) {
                gVar.B(true);
                this.frsNewAreaView.G(true);
            }
            c.a.o0.f0.c cVar = this.s;
            if (cVar == null || !cVar.isViewAttached()) {
                return;
            }
            this.s.dettachView(this.frsNewAreaView.l());
        }
    }

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            if (this.f51213h != 0) {
                this.f51213h = 1;
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
            String e2 = this.m.z() != null ? c.a.p0.x2.a.e(this.m.z().getThreadList(), false) : "";
            this.frsNewAreaView.H(this.n.L(), this.f51214i, this.k, 0);
            this.n.M(c.a.e.e.m.b.f(this.f51215j, 0L), this.k.getThreadListIds(), this.f51211f, this.f51214i, this.k.isBrandForum, e2);
        } else if (this.o != 0) {
            this.frsNewAreaView.H(this.n.L(), this.f51214i, this.k, 0);
            int i2 = this.f51214i + 1;
            this.f51214i = i2;
            this.m.I(i2);
            FrsLoadMoreModel frsLoadMoreModel = this.n;
            frsLoadMoreModel.loadingDone = false;
            frsLoadMoreModel.loadIndex = 0;
        }
    }

    public void loadTabData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            if (c.a.e.e.p.j.z()) {
                O(false);
            } else {
                T(null);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        c2 threadDataById;
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
                    threadDataById.O3(intent.getIntExtra("good_data", 0));
                    threadDataById.W2();
                    O(false);
                } else if (intExtra == 0) {
                    this.k.removeThreadData(threadDataById);
                    ArrayList<n> threadList = this.k.getThreadList();
                    if (threadList != null && threadList.size() <= 0) {
                        threadList.add(new c.a.p0.v0.s());
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
            c.a.p0.v0.e2.g gVar = this.frsNewAreaView;
            if (gVar != null) {
                gVar.q(i2);
            }
            c.a.o0.f0.c cVar = this.s;
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
                this.f51215j = arguments.getString("forum_id", "");
                this.w = arguments.getBoolean(FrsActivityConfig.FLAG_SHOW_AD);
            }
            long currentTimeMillis = System.currentTimeMillis();
            this.beginTime = currentTimeMillis;
            this.sysCreateTime = currentTimeMillis - this.initTime;
            super.onCreate(bundle);
            c.a.p0.h3.c.g().i(getUniqueId());
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
            N(bundle);
            registerListener(this.B);
            registerListener(this.z);
            registerListener(this.A);
            registerListener(this.x);
            FrsLoadMoreModel frsLoadMoreModel = new FrsLoadMoreModel(this, null);
            this.n = frsLoadMoreModel;
            frsLoadMoreModel.registerListener();
            this.n.R(3);
            this.n.P(true);
            this.n.O(c.a.p0.x0.a.a(this.w));
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
            this.frsNewAreaView = new c.a.p0.v0.e2.g(this, inflate);
            initUI();
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            c.a.p0.v0.e2.g gVar = this.frsNewAreaView;
            if (gVar != null) {
                gVar.r();
            }
            MessageManager.getInstance().unRegisterListener(this.x);
            c.a.p0.h3.c.g().k(getUniqueId());
            t.b().e(false);
            super.onDestroy();
            this.m.J();
            VoiceManager voiceManager = getVoiceManager();
            this.l = voiceManager;
            voiceManager.onDestory(getPageContext());
            c.a.e.e.m.e.a().removeCallbacks(this.y);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void onFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, str) == null) {
            S();
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
            if (c.a.e.e.p.j.z()) {
                O(false);
            } else {
                T(null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            J();
        }
    }

    @Override // c.a.p0.v0.r0
    public void onLoadingComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            c.a.p0.h3.c.g().h(getUniqueId(), false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048630, this) == null) && c.a.e.e.p.j.z()) {
            O(false);
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
                c.a.e.e.m.e.a().post(this.y);
            }
        }
    }

    @Override // c.a.p0.v0.r0
    public void onPullRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            if (getPageContext() != null) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            }
            if (c.a.e.e.p.j.z()) {
                c.a.p0.o.d.c().f("page_frs_good");
                O(true);
                return;
            }
            this.frsNewAreaView.A(false);
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
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
            c.a.p0.v0.e2.g gVar = this.frsNewAreaView;
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
            bundle.putString("name", this.f51211f);
            bundle.putString("from", this.f51212g);
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
            if (!l.D()) {
                this.frsNewAreaView.m();
            } else if (this.frsNewAreaView.x()) {
            } else {
                if (!this.m.E()) {
                    this.frsNewAreaView.m();
                    return;
                }
                S();
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
            t.b().e(false);
            c.a.p0.h3.c.g().h(getUniqueId(), false);
            FrsViewData frsViewData = this.k;
            if (frsViewData != null && frsViewData.getForum() != null) {
                c.a.o0.v.a.k().y(getPageContext().getPageActivity(), "frs", this.k.getForum().getId(), 0L);
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
            S();
            if (arrayList == null || arrayList.size() == 0) {
                return;
            }
            ArrayList<n> C = this.n.C(false, false, false, arrayList, null);
            if (C != null) {
                this.k.setThreadList(C);
                this.frsNewAreaView.H(C, this.f51214i, this.k, 0);
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
        c.a.p0.v0.e2.g gVar = this.frsNewAreaView;
        if (gVar != null) {
            gVar.A(false);
            this.frsNewAreaView.H(null, this.f51214i, this.k, this.o);
        }
    }

    public void processBatchDelete(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, list) == null) {
            B(list);
            int i2 = 0;
            for (n nVar : this.k.getThreadList()) {
                if (nVar instanceof b2) {
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
        c.a.p0.v0.e2.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048643, this) == null) || (gVar = this.frsNewAreaView) == null || gVar.k() == null) {
            return;
        }
        this.frsNewAreaView.k().post(new a(this));
    }

    @Override // c.a.p0.v0.p0
    public void scrollToTop() {
        c.a.p0.v0.e2.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048644, this) == null) || (gVar = this.frsNewAreaView) == null || gVar.k() == null) {
            return;
        }
        this.frsNewAreaView.k().scrollToPosition(0);
    }

    public void setFlag(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048645, this, i2) == null) {
            this.f51213h = i2;
        }
    }

    public void setForum(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, str) == null) {
            this.f51211f = str;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, str) == null) {
            this.f51212g = str;
        }
    }

    public void setFrsView(c.a.p0.v0.e2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, gVar) == null) {
            this.frsNewAreaView = gVar;
        }
    }

    @Override // c.a.p0.f.e.b
    public void setInjectPlugin(int i2, c.a.p0.f.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048649, this, i2, aVar) == null) {
            this.t.put(i2, aVar);
        }
    }

    public void setPn(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048650, this, i2) == null) {
            this.f51214i = i2;
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

    @Override // c.a.p0.x2.u
    public void updateLastIds() {
        FrsNewAreaModelController frsNewAreaModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048653, this) == null) || (frsNewAreaModelController = this.m) == null) {
            return;
        }
        frsNewAreaModelController.O();
    }

    /* JADX DEBUG: Method merged with bridge method */
    public BdTypeRecyclerView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            c.a.p0.v0.e2.g gVar = this.frsNewAreaView;
            if (gVar == null) {
                return null;
            }
            return gVar.k();
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }
}
