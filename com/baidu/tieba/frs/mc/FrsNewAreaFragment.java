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
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
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
import com.baidu.tieba.a78;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.b28;
import com.baidu.tieba.bk5;
import com.baidu.tieba.c26;
import com.baidu.tieba.e68;
import com.baidu.tieba.em6;
import com.baidu.tieba.eva;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.g36;
import com.baidu.tieba.i68;
import com.baidu.tieba.ix7;
import com.baidu.tieba.lva;
import com.baidu.tieba.m58;
import com.baidu.tieba.mz4;
import com.baidu.tieba.n26;
import com.baidu.tieba.pb;
import com.baidu.tieba.pi;
import com.baidu.tieba.pr6;
import com.baidu.tieba.ps7;
import com.baidu.tieba.pt7;
import com.baidu.tieba.pxa;
import com.baidu.tieba.qd5;
import com.baidu.tieba.qt7;
import com.baidu.tieba.qua;
import com.baidu.tieba.r06;
import com.baidu.tieba.rt7;
import com.baidu.tieba.s06;
import com.baidu.tieba.sha;
import com.baidu.tieba.sxa;
import com.baidu.tieba.t06;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.td5;
import com.baidu.tieba.ti;
import com.baidu.tieba.u18;
import com.baidu.tieba.u38;
import com.baidu.tieba.v38;
import com.baidu.tieba.wua;
import com.baidu.tieba.x38;
import com.baidu.tieba.x88;
import com.baidu.tieba.z68;
import com.baidu.tieba.zb;
import com.baidu.tieba.zga;
import com.baidu.tieba.zi;
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
/* loaded from: classes6.dex */
public class FrsNewAreaFragment extends BaseFragment implements VoiceManager.j, u18, UserIconBox.c, BdListView.p, FrsCommonImageLayout.e, pt7, ActivityCompat.OnRequestPermissionsResultCallback, sha, qt7, t06, rt7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener A;
    public final lva B;
    public final CustomMessageListener C;
    public final RecyclerView.OnScrollListener D;
    public final CustomMessageListener E;
    public zi F;
    public String a;
    public String b;
    public String c;
    public int d;
    public int e;
    public String f;
    public FrsViewData g;
    public VoiceManager h;
    public long i;
    public long j;
    public long k;
    public FrsNewAreaModelController l;
    public FrsLoadMoreModel m;
    public b28 n;
    public int o;
    public int p;
    public boolean q;
    public boolean r;
    public bk5 s;
    public SparseArray<s06> t;
    public int u;
    public int v;
    public boolean w;
    public CustomMessageListener x;
    public Runnable y;
    public CustomMessageListener z;

    @Override // com.baidu.tieba.pt7
    public void S0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.IPlayView V1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    @Override // com.baidu.tieba.t06
    public void o0(r06 r06Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, r06Var) == null) {
        }
    }

    public final int o3(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048612, this, i2, i3)) == null) {
            if (i2 != 1) {
                return (i2 != 2 || i3 == 1) ? 0 : 3;
            }
            return 3;
        }
        return invokeII.intValue;
    }

    @Override // com.baidu.tieba.qt7
    public NavigationBar x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            return null;
        }
        return (NavigationBar) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class c implements zi {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsNewAreaFragment a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            public a(c cVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    NetWork netWork = new NetWork(this.a);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsNewAreaFragment;
        }

        @Override // com.baidu.tieba.zi
        public void b(View view2, pi piVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, piVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && bdUniqueId != null && piVar != null && (piVar instanceof mz4)) {
                ThreadData threadData = ((mz4) piVar).t;
                if (threadData.getAnchorInfoData() != null && threadData.getAnchorInfoData().getGroup_id() != 0 && !ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                    return;
                }
                if (threadData.getActInfoType() == 1 && !ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                    return;
                }
                sxa readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                if (readThreadHistory != null && !readThreadHistory.d(threadData.getId())) {
                    readThreadHistory.a(threadData.getId());
                    b28 b28Var = this.a.n;
                    if (b28Var != null) {
                        b28Var.s();
                    }
                }
                String ad_url = threadData.getAd_url();
                boolean z2 = false;
                if (ad_url != null && !ad_url.equals("")) {
                    pr6.a(new a(this, ad_url), "requestAdFrsNewArea", 3);
                    z = true;
                } else {
                    z = false;
                }
                String tid = threadData.getTid();
                if (tid == null) {
                    tid = "";
                }
                if (threadData.getIs_top() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{tid, "", null});
                    return;
                }
                if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && tid.length() > 3) {
                    threadData.setId(tid.substring(3));
                }
                PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.a.getPageContext().getPageActivity()).createFromThreadCfg(threadData, this.a.b, "frs_page", 18003, true, false, z);
                createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
                createFromThreadCfg.setStartFrom(3);
                this.a.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                if (this.a.g != null && this.a.g.getForum() != null) {
                    v38 v38Var = new v38();
                    if (this.a.g.needLog == 1) {
                        z2 = true;
                    }
                    v38Var.a = z2;
                    v38Var.c = this.a.g.getForum().getId();
                    v38Var.d = this.a.g.getForum().getName();
                    v38Var.b = this.a.l.Q();
                    v38 v38Var2 = x38.q0;
                    if (v38Var2 != null) {
                        v38Var.e = v38Var2.e;
                        v38Var.f = v38Var2.f;
                    }
                    u38.e(threadData, 1, this.a.getUniqueId(), v38Var, this.a.getTbPageTag());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsNewAreaFragment a;

        public a(FrsNewAreaFragment frsNewAreaFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsNewAreaFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsNewAreaFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            b28 b28Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (b28Var = this.a.n) != null && b28Var.n() != null && !this.a.n.n().isComputingLayout()) {
                this.a.n.s();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsNewAreaFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(FrsNewAreaFragment frsNewAreaFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsNewAreaFragment, Integer.valueOf(i)};
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
            this.a = frsNewAreaFragment;
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2001118) {
                return;
            }
            this.a.k3(customResponsedMessage);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }
    }

    /* loaded from: classes6.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsNewAreaFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(FrsNewAreaFragment frsNewAreaFragment, int i, boolean z) {
            super(i, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsNewAreaFragment, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && this.a.s != null && this.a.s.isViewAttached()) {
                this.a.s.a(num.intValue());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsNewAreaFragment a;

        public e(FrsNewAreaFragment frsNewAreaFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsNewAreaFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsNewAreaFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!BdNetTypeUtil.isNetWorkAvailable() || this.a.q) {
                    this.a.H3(null);
                } else {
                    this.a.v3(false);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsNewAreaFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(FrsNewAreaFragment frsNewAreaFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsNewAreaFragment, Integer.valueOf(i)};
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
            this.a = frsNewAreaFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ThreadData)) {
                ThreadData threadData = (ThreadData) customResponsedMessage.getData();
                this.a.a = threadData.getId();
                if (TextUtils.isEmpty(this.a.a) || threadData.getPraise() == null) {
                    return;
                }
                this.a.J3(threadData.getPraise().getIsLike());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsNewAreaFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(FrsNewAreaFragment frsNewAreaFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsNewAreaFragment, Integer.valueOf(i)};
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
            this.a = frsNewAreaFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 503) {
                if (this.a.n3() != null) {
                    this.a.n3().setSelection(0);
                }
                if (this.a.s == null || !this.a.s.isViewAttached()) {
                    b28 b28Var = this.a.n;
                    if (b28Var != null) {
                        b28Var.P();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                        return;
                    }
                    return;
                }
                this.a.v3(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements lva {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public final /* synthetic */ FrsNewAreaFragment b;

        @Override // com.baidu.tieba.lva
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.baidu.tieba.lva
        public void c(eva evaVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, evaVar) == null) {
            }
        }

        public h(FrsNewAreaFragment frsNewAreaFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsNewAreaFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = frsNewAreaFragment;
            this.a = 1L;
        }

        @Override // com.baidu.tieba.lva
        public void a(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || this.b.r) {
                return;
            }
            if (i != 1 && i != 2) {
                if (i == 3) {
                    this.b.n.D(true);
                    return;
                }
                return;
            }
            this.b.n.s();
        }

        @Override // com.baidu.tieba.lva
        public void d(int i, boolean z, wua wuaVar) {
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), wuaVar}) == null) {
                if (this.b.r) {
                    if (this.b.q3().R() == null) {
                        this.b.r = false;
                        return;
                    } else if (this.b.q3().R().getThreadList().size() >= 10) {
                        this.b.r = false;
                        m58 m58Var = new m58();
                        m58Var.b = 301;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384, m58Var));
                        return;
                    }
                }
                if (wuaVar == null) {
                    this.a = 1L;
                } else if (wuaVar.b) {
                    this.a = 0L;
                } else {
                    this.a = 1L;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (i == 3) {
                    this.b.m.h0();
                }
                this.b.n.D(false);
                if (this.b.q3().R() != null) {
                    FrsNewAreaFragment frsNewAreaFragment = this.b;
                    frsNewAreaFragment.g = frsNewAreaFragment.q3().R();
                }
                FrsNewAreaFragment frsNewAreaFragment2 = this.b;
                frsNewAreaFragment2.o = frsNewAreaFragment2.g.getPage().b();
                if (this.b.o == 0 && (this.b.g.getThreadListIds() == null || this.b.g.getThreadListIds().size() == 0)) {
                    if (this.b.g.getThreadList() != null && this.b.g.getThreadList().size() != 0) {
                        this.b.n.N();
                    } else {
                        this.b.n.p();
                    }
                } else {
                    this.b.n.M();
                }
                if (i == 4) {
                    ArrayList<pi> V = this.b.m.V(false, false, false, this.b.g.getThreadList(), null, this.b.g.adMixFloor, this.b.g.adShowSelect);
                    if (V != null) {
                        this.b.g.setThreadList(V);
                        FrsNewAreaFragment frsNewAreaFragment3 = this.b;
                        frsNewAreaFragment3.n.K(V, frsNewAreaFragment3.e, this.b.g, this.b.o);
                        return;
                    }
                    return;
                }
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3 && this.b.g.isShowRedTip()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, Boolean.TRUE));
                        }
                    } else {
                        this.b.n.s();
                    }
                } else {
                    this.b.n.s();
                }
                this.b.hideLoadingView();
                if (this.a == 0) {
                    this.b.r3();
                    if (this.b.g != null) {
                        FrsNewAreaFragment frsNewAreaFragment4 = this.b;
                        frsNewAreaFragment4.b = frsNewAreaFragment4.g.getForum().getName();
                        FrsNewAreaFragment frsNewAreaFragment5 = this.b;
                        frsNewAreaFragment5.f = frsNewAreaFragment5.g.getForum().getId();
                        FrsNewAreaFragment frsNewAreaFragment6 = this.b;
                        frsNewAreaFragment6.n.x(frsNewAreaFragment6.g.getForum(), this.b.g.getUserData());
                    }
                    if (this.b.g != null) {
                        this.b.g.addNoticeThreadToThreadList();
                    }
                    if (this.b.g != null && this.b.g.getThreadList() != null && this.b.g.getThreadList().size() == 0 && this.b.q3().getType() == 4) {
                        FrsNewAreaFragment frsNewAreaFragment7 = this.b;
                        frsNewAreaFragment7.showToast(frsNewAreaFragment7.getPageContext().getString(R.string.no_more_to_load));
                        if (this.b.e > 1) {
                            FrsNewAreaFragment.L2(this.b);
                        }
                        if (this.b.i > -1) {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            FrsNewAreaFragment frsNewAreaFragment8 = this.b;
                            long T2 = frsNewAreaFragment8.q3().T();
                            FrsNewAreaFragment frsNewAreaFragment9 = this.b;
                            TiebaStatic.page("op_frs_enter", currentTimeMillis2 - frsNewAreaFragment8.i, T2 - frsNewAreaFragment9.i, frsNewAreaFragment9.q3().V(), this.b.q3().U(), currentTimeMillis2 - this.b.q3().S());
                            this.b.i = -1L;
                        }
                        this.b.j = System.currentTimeMillis() - currentTimeMillis;
                        return;
                    }
                    if (this.b.g != null) {
                        ArrayList<pi> arrayList = new ArrayList<>();
                        if (!ListUtils.isEmpty(this.b.g.getThreadList())) {
                            arrayList.addAll(this.b.g.getThreadList());
                            if (i == 3 && i68.a(this.b.f) && this.b.g.frsForumGroup != null && this.b.g.frsForumGroup.feed_card != null && !ListUtils.isEmpty(this.b.g.frsForumGroup.feed_card.group_list) && this.b.g.frsForumGroup.feed_card.index.intValue() >= 0 && this.b.g.frsForumGroup.feed_card.index.intValue() <= arrayList.size()) {
                                ix7.f(this.b.g.frsForumGroup, arrayList, this.b.f);
                            }
                        }
                        FrsLoadMoreModel frsLoadMoreModel = this.b.m;
                        if (i == 3) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        ArrayList<pi> V2 = frsLoadMoreModel.V(false, z2, true, arrayList, null, this.b.g.adMixFloor, this.b.g.adShowSelect);
                        if (V2 != null && V2.size() > 0) {
                            this.b.g.setThreadList(V2);
                        }
                    }
                    this.b.A3();
                    b28 b28Var = this.b.n;
                    if (b28Var != null) {
                        b28Var.O();
                    }
                } else {
                    this.b.H3(wuaVar);
                }
                if (this.b.i > -1) {
                    long currentTimeMillis3 = System.currentTimeMillis();
                    FrsNewAreaFragment frsNewAreaFragment10 = this.b;
                    long T3 = frsNewAreaFragment10.q3().T();
                    FrsNewAreaFragment frsNewAreaFragment11 = this.b;
                    TiebaStatic.page("op_frs_enter", currentTimeMillis3 - frsNewAreaFragment10.i, T3 - frsNewAreaFragment11.i, frsNewAreaFragment11.q3().V(), this.b.q3().U(), currentTimeMillis3 - this.b.q3().S());
                    this.b.i = -1L;
                }
                this.b.j = System.currentTimeMillis() - currentTimeMillis;
                System.gc();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsNewAreaFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(FrsNewAreaFragment frsNewAreaFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsNewAreaFragment, Integer.valueOf(i)};
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
            this.a = frsNewAreaFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b28 b28Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (b28Var = this.a.n) != null) {
                b28Var.P();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsNewAreaFragment a;

        public j(FrsNewAreaFragment frsNewAreaFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsNewAreaFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsNewAreaFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                pxa.o(this.a.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public final /* synthetic */ FrsNewAreaFragment c;

        public k(FrsNewAreaFragment frsNewAreaFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsNewAreaFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = frsNewAreaFragment;
            this.a = 0;
            this.b = 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                if (i == 0) {
                    em6.b().e(true);
                    qua.g().h(this.c.getUniqueId(), true);
                    this.c.n.u(this.a, this.b);
                }
                if (i == 1) {
                    this.c.n.t();
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                boolean z = false;
                this.a = 0;
                this.b = 0;
                if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                    BdRecyclerView bdRecyclerView = (BdRecyclerView) recyclerView;
                    this.a = bdRecyclerView.getFirstVisiblePosition();
                    this.b = bdRecyclerView.getLastVisiblePosition();
                }
                FrsNewAreaFragment.U2(this.c, i2);
                if (i2 < 0) {
                    MessageManager messageManager = MessageManager.getInstance();
                    if (this.c.v >= this.c.u * 2) {
                        z = true;
                    }
                    messageManager.dispatchResponsedMessage(new CustomResponsedMessage(2921437, Boolean.valueOf(z)));
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
        this.b = null;
        this.c = null;
        this.d = 0;
        this.e = 1;
        this.f = null;
        this.g = new FrsViewData();
        this.i = -1L;
        this.k = -1L;
        this.n = null;
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
        this.B = new h(this);
        this.C = new i(this, 2003003);
        this.D = new k(this);
        this.E = new b(this, 0);
        this.F = new c(this);
    }

    public static /* synthetic */ int L2(FrsNewAreaFragment frsNewAreaFragment) {
        int i2 = frsNewAreaFragment.e;
        frsNewAreaFragment.e = i2 - 1;
        return i2;
    }

    public void C3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.d = i2;
        }
    }

    public void D3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.b = str;
        }
    }

    public void E3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.e = i2;
        }
    }

    @Override // com.baidu.tieba.t06
    public s06 T1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            return this.t.get(i2);
        }
        return (s06) invokeI.objValue;
    }

    public void i3(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048603, this, threadData) != null) || threadData == null) {
            return;
        }
        this.l.O(threadData);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void onFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, str) == null) {
            F3();
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, str) == null) {
            this.c = str;
        }
    }

    public final void v3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048640, this, z) == null) {
            this.q = true;
            I3();
            r3();
            if (!z) {
                r3();
                G3();
            }
            FrsNewAreaModelController frsNewAreaModelController = this.l;
            if (frsNewAreaModelController != null) {
                frsNewAreaModelController.loadData();
            }
        }
    }

    public void w3(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048641, this, frsViewData) != null) || frsViewData == null) {
            return;
        }
        this.g = frsViewData;
        hideLoadingView(this.n.o());
        b28 b28Var = this.n;
        if (b28Var != null) {
            b28Var.D(false);
            this.n.K(null, this.e, this.g, this.o);
        }
    }

    public static /* synthetic */ int U2(FrsNewAreaFragment frsNewAreaFragment, int i2) {
        int i3 = frsNewAreaFragment.v + i2;
        frsNewAreaFragment.v = i3;
        return i3;
    }

    @Override // com.baidu.tieba.t06
    public void f1(int i2, s06 s06Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048599, this, i2, s06Var) == null) {
            this.t.put(i2, s06Var);
        }
    }

    public final void A3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            I3();
            try {
                if (this.g == null) {
                    return;
                }
                this.n.C();
                this.n.L();
                this.b = this.g.getForum().getName();
                this.f = this.g.getForum().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.g.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(this.g.getUserData().getDynamicUrl());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.g.getUserData().getBimg_end_time());
                y3();
                ArrayList<pi> threadList = this.g.getThreadList();
                if (threadList != null) {
                    this.n.K(threadList, this.e, this.g, this.g.getPage().b());
                    z3();
                    this.n.s();
                    if (this.g.getIsNewUrl() == 1) {
                        this.n.m().q(true);
                    } else {
                        this.n.m().q(false);
                    }
                    this.n.F(o3(q3().getType(), this.e));
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void B3() {
        b28 b28Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (b28Var = this.n) != null && b28Var.n() != null) {
            this.n.n().post(new a(this));
        }
    }

    @Override // com.baidu.tieba.sha
    public String C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pt7
    public void F() {
        b28 b28Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (b28Var = this.n) != null && b28Var.n() != null) {
            this.n.n().scrollToPosition(0);
        }
    }

    public final void G3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.n.E(false);
            showLoadingView(this.n.o(), true, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703a7));
        }
    }

    @Override // com.baidu.tieba.sha
    public TbPageContext<?> I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return getPageContext();
        }
        return (TbPageContext) invokeV.objValue;
    }

    public void I3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            VoiceManager d1 = d1();
            this.h = d1;
            d1.stopPlay();
        }
    }

    @Override // com.baidu.tieba.rt7
    public void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            qua.g().h(getUniqueId(), false);
        }
    }

    @Override // com.baidu.tieba.u18
    public FrsViewData Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.g;
        }
        return (FrsViewData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sha
    public void Z0() {
        FrsNewAreaModelController frsNewAreaModelController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (frsNewAreaModelController = this.l) != null) {
            frsNewAreaModelController.g0();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public pb<TbImageView> c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (getBaseFragmentActivity() instanceof FrsActivity) {
                return ((FrsActivity) getBaseFragmentActivity()).c0();
            }
            return null;
        }
        return (pb) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.h == null) {
                this.h = VoiceManager.instance();
            }
            return this.h;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tieba.u18
    public /* bridge */ /* synthetic */ BdPageContext getPageContext() {
        return super.getPageContext();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            TbPageTag tbPageTag = super.getTbPageTag();
            FrsViewData frsViewData = this.g;
            if (frsViewData != null) {
                i2 = frsViewData.getSortType();
            } else {
                i2 = -1;
            }
            tbPageTag.sortType = z68.g(i2);
            tbPageTag.locatePage = "a071";
            return tbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    public final void hideLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.n.E(true);
            hideLoadingView(this.n.o());
        }
    }

    @Override // com.baidu.tieba.pt7
    public void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && this.n != null) {
            F();
            this.n.P();
        }
    }

    @Override // com.baidu.tieba.sha
    public int m2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public b28 m3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.n;
        }
        return (b28) invokeV.objValue;
    }

    public BdTypeRecyclerView n3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            b28 b28Var = this.n;
            if (b28Var == null) {
                return null;
            }
            return b28Var.n();
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public ti onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            if (n3() == null) {
                return null;
            }
            return n3().getPreLoadHandle();
        }
        return (ti) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            super.onLazyLoad();
            if (this.q) {
                return;
            }
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                v3(false);
            } else {
                H3(null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            l3();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048622, this) != null) || !BdNetTypeUtil.isNetWorkAvailable()) {
            return;
        }
        v3(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            super.onPause();
            VoiceManager d1 = d1();
            this.h = d1;
            d1.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            super.onResume();
            b28 b28Var = this.n;
            if (b28Var != null) {
                b28Var.s();
            }
            VoiceManager d1 = d1();
            this.h = d1;
            d1.onResume(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            super.onStart();
            VoiceManager d1 = d1();
            this.h = d1;
            d1.onStart(getPageContext());
        }
    }

    public FrsLoadMoreModel p3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.m;
        }
        return (FrsLoadMoreModel) invokeV.objValue;
    }

    public FrsNewAreaModelController q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.l;
        }
        return (FrsNewAreaModelController) invokeV.objValue;
    }

    public final void r3() {
        b28 b28Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048634, this) == null) && (b28Var = this.n) != null) {
            b28Var.E(true);
            this.n.J(true);
            bk5 bk5Var = this.s;
            if (bk5Var != null && bk5Var.isViewAttached()) {
                this.s.dettachView(this.n.o());
            }
        }
    }

    public final void s3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            registerListener(2001118, this.E);
        }
    }

    public final void u3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            if (this.d != 0) {
                this.d = 1;
            }
            this.n.H(this.F);
            this.n.I(this.D);
        }
    }

    @Override // com.baidu.tieba.u18, com.baidu.tieba.tt7
    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public pb<TbImageView> y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            if (getBaseFragmentActivity() instanceof FrsActivity) {
                return ((FrsActivity) getBaseFragmentActivity()).y0();
            }
            return null;
        }
        return (pb) invokeV.objValue;
    }

    public final void y3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            if (this.d == 1) {
                zb.a().b(new j(this));
            }
            this.d = 0;
        }
    }

    public final void F3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.o == 0 && !this.m.S(this.g.getThreadListIds())) {
                if (this.g.getThreadList() != null && this.g.getThreadList().size() != 0) {
                    this.n.N();
                    return;
                } else {
                    this.n.p();
                    return;
                }
            }
            this.n.M();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            b28 b28Var = this.n;
            if (b28Var != null) {
                b28Var.w();
                this.n.I(null);
            }
            MessageManager.getInstance().unRegisterListener(this.x);
            qua.g().k(getUniqueId());
            em6.b().e(false);
            super.onDestroy();
            this.l.a0();
            VoiceManager d1 = d1();
            this.h = d1;
            d1.onDestory(getPageContext());
            SafeHandler.getInst().removeCallbacks(this.y);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            super.onStop();
            em6.b().e(false);
            qua.g().h(getUniqueId(), false);
            FrsViewData frsViewData = this.g;
            if (frsViewData != null && frsViewData.getForum() != null) {
                qd5.j().x(getPageContext().getPageActivity(), "frs", this.g.getForum().getId(), 0L);
            }
            VoiceManager d1 = d1();
            this.h = d1;
            if (d1 != null) {
                d1.onStop(getPageContext());
            }
        }
    }

    public final void z3() {
        b28 b28Var;
        HashMap<Integer, ThreadData> h2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048646, this) == null) && (b28Var = this.n) != null && b28Var.m() != null && (h2 = this.n.m().h()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, ThreadData> entry : h2.entrySet()) {
                ThreadData value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            td5.q().u(arrayList);
        }
    }

    public final void H3(wua wuaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, wuaVar) == null) {
            this.n.E(false);
            this.n.J(false);
            this.n.p();
            this.n.n().getData().clear();
            this.n.s();
            if (this.s == null) {
                bk5 bk5Var = new bk5(getPageContext().getContext(), getNetRefreshListener());
                this.s = bk5Var;
                bk5Var.d(null);
                this.s.b(null);
                this.s.e();
                this.s.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            if (wuaVar != null) {
                this.s.c(getPageContext().getResources().getString(R.string.net_error_text, wuaVar.d, Integer.valueOf(wuaVar.c)));
            } else {
                this.s.c(null);
            }
            this.s.onChangeSkinType();
            this.s.attachView(this.n.o(), true);
            this.s.a(0);
        }
    }

    public final void j3(List<String> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        ArrayList<pi> threadList = this.g.getThreadList();
        if (!ListUtils.isEmpty(threadList) && this.n.n() != null && this.n.n().getData() != null) {
            Iterator<pi> it = threadList.iterator();
            List<pi> data = this.n.n().getData();
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                try {
                    pi next = it.next();
                    if (next instanceof mz4) {
                        ThreadData threadData = ((mz4) next).t;
                        int i4 = 0;
                        while (true) {
                            if (i4 >= list.size()) {
                                break;
                            } else if (StringHelper.equals(list.get(i4), threadData.getId())) {
                                it.remove();
                                data.remove(next);
                                this.m.d0(next);
                                this.n.n().getAdapter().notifyItemRemoved(i3);
                                break;
                            } else {
                                i4++;
                            }
                        }
                    }
                    i3++;
                } catch (Exception e2) {
                    BdLog.e(e2);
                    if (this.n.n().getAdapter() != null) {
                        i2 = this.n.n().getAdapter().getItemCount();
                    }
                    a78.f("frsNewAreafragment-doDeleteThread()", i3, i2, e2);
                    throw null;
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, bundle) == null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.i = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
            } else {
                this.i = System.currentTimeMillis();
            }
            if (arguments != null) {
                this.f = arguments.getString("forum_id", "");
                this.w = arguments.getBoolean(FrsActivityConfig.FLAG_SHOW_AD);
            }
            this.k = System.currentTimeMillis();
            super.onCreate(bundle);
            qua.g().i(getUniqueId());
            FrsNewAreaModelController frsNewAreaModelController = new FrsNewAreaModelController(this);
            this.l = frsNewAreaModelController;
            if (arguments != null) {
                frsNewAreaModelController.X(arguments);
            } else if (bundle != null) {
                frsNewAreaModelController.X(bundle);
            } else {
                frsNewAreaModelController.X(null);
            }
            VoiceManager d1 = d1();
            this.h = d1;
            d1.onCreate(getPageContext());
            t3(bundle);
            registerListener(this.C);
            registerListener(this.z);
            registerListener(this.A);
            registerListener(this.x);
            FrsLoadMoreModel frsLoadMoreModel = new FrsLoadMoreModel(this, null);
            this.m = frsLoadMoreModel;
            frsLoadMoreModel.registerListener();
            this.m.l0(3);
            this.m.j0(true);
            this.m.i0(x88.a(this.w));
            System.currentTimeMillis();
            this.u = UtilHelper.getScreenHeight(getActivity());
        }
    }

    public final void J3(int i2) {
        ArrayList<pi> threadList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048588, this, i2) == null) && (threadList = this.g.getThreadList()) != null) {
            Iterator<pi> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                pi next = it.next();
                if (next instanceof mz4) {
                    ThreadData threadData = ((mz4) next).t;
                    if (threadData.getId() != null && threadData.getId().equals(this.a)) {
                        e68.d(threadData, i2);
                        this.a = null;
                        break;
                    }
                }
            }
            this.n.m().p(threadList, this.g);
            this.n.m().l();
        }
    }

    public final void k3(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048605, this, responsedMessage) != null) || this.g == null || this.n == null || !(responsedMessage instanceof DownloadMessage) || (data = ((DownloadMessage) responsedMessage).getData()) == null) {
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
            this.n.s();
        }
    }

    public final void t3(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, bundle) == null) {
            s3();
            if (bundle != null) {
                this.b = bundle.getString("name");
                this.c = bundle.getString("from");
                this.d = bundle.getInt("flag", 0);
            } else {
                Bundle arguments = getArguments();
                if (arguments != null) {
                    this.b = arguments.getString("name");
                    this.c = arguments.getString("from");
                    this.d = arguments.getInt("flag", 0);
                }
            }
            if (!TextUtils.isEmpty(this.c) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.c)) {
                getBaseFragmentActivity().setSwipeBackEnabled(false);
            }
        }
    }

    @Override // com.baidu.tieba.rt7
    public void a2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (getPageContext() != null) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            }
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                c26.c().f("page_frs_good");
                v3(true);
                return;
            }
            this.n.D(false);
        }
    }

    public final void l3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13008");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", this.f);
            statisticItem.param("obj_type", 6);
            statisticItem.param("obj_locate", 2);
            statisticItem.eventStat();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                if (this.p == 3) {
                    onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                }
                if (!this.q) {
                    SafeHandler.getInst().post(this.y);
                }
                b28 b28Var = this.n;
                if (b28Var != null) {
                    b28Var.O();
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            if (!BdUtilHelper.isNetOk()) {
                this.n.p();
            } else if (this.n.B()) {
            } else {
                if (!this.l.W()) {
                    this.n.p();
                    return;
                }
                F3();
                b();
            }
        }
    }

    public void b() {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && !this.m.isLoading && !this.l.Y()) {
            if (this.m.S(this.g.getThreadListIds())) {
                if (this.l.R() != null) {
                    str = zga.e(this.l.R().getThreadList(), false);
                } else {
                    str = "";
                }
                this.n.K(this.m.f0(), this.e, this.g, 0);
                this.m.g0(JavaTypesHelper.toLong(this.f, 0L), this.g.getThreadListIds(), this.b, this.e, this.g.isBrandForum, str);
            } else if (this.o != 0) {
                this.n.K(this.m.f0(), this.e, this.g, 0);
                int i2 = this.e + 1;
                this.e = i2;
                this.l.Z(i2);
                FrsLoadMoreModel frsLoadMoreModel = this.m;
                frsLoadMoreModel.loadingDone = false;
                frsLoadMoreModel.loadIndex = 0;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        ThreadData threadDataById;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048613, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1 && i2 == 18003) {
                this.n.m().l();
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra != null && (threadDataById = this.g.getThreadDataById(stringExtra)) != null) {
                    int intExtra = intent.getIntExtra("type", -1);
                    if (intExtra == 2) {
                        threadDataById.setIs_good(intent.getIntExtra("good_data", 0));
                        threadDataById.parser_title();
                        v3(false);
                    } else if (intExtra == 0) {
                        this.g.removeThreadData(threadDataById);
                        ArrayList<pi> threadList = this.g.getThreadList();
                        if (threadList != null && threadList.size() <= 0) {
                            threadList.add(new ps7());
                        }
                        this.n.s();
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            if (this.p == 3 && this.n == null) {
                return;
            }
            this.p = i2;
            super.onChangeSkinType(i2);
            b28 b28Var = this.n;
            if (b28Var != null) {
                b28Var.v(i2);
                this.n.O();
            }
            bk5 bk5Var = this.s;
            if (bk5Var != null && bk5Var.isViewAttached()) {
                this.s.onChangeSkinType();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("name", this.b);
            bundle.putString("from", this.c);
            this.l.b0(bundle);
            VoiceManager d1 = d1();
            this.h = d1;
            if (d1 != null) {
                d1.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    public void x3(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, list) == null) {
            j3(list);
            int i2 = 0;
            for (pi piVar : this.g.getThreadList()) {
                if (piVar instanceof mz4) {
                    i2++;
                    continue;
                }
                if (i2 >= 6) {
                    break;
                }
            }
            if (i2 < 6) {
                b();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048616, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0382, (ViewGroup) null);
            this.n = new b28(this, inflate);
            u3();
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048625, this, i2, strArr, iArr) == null) && i2 == 1) {
            if (PermissionUtil.checkCamera(getActivity().getApplicationContext())) {
                SelectImageHelper.takePhoto(getPageContext());
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = PermissionUtil.transformPermissionResult(strArr, iArr);
            if (transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(R.string.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void q(ArrayList<pi> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, arrayList) == null) {
            F3();
            if (n26.k().l(AbsDataRecorder.Scene.FRS_NEW)) {
                n26.k().g(AbsDataRecorder.Scene.FRS_NEW).b();
            }
            if (g36.i().o(AbsDataRecorder.Scene.FRS_NEW)) {
                g36.i().g(AbsDataRecorder.Scene.FRS_NEW).b();
            }
            if (arrayList != null && arrayList.size() != 0) {
                FrsLoadMoreModel frsLoadMoreModel = this.m;
                FrsViewData frsViewData = this.g;
                ArrayList<pi> V = frsLoadMoreModel.V(false, false, false, arrayList, null, frsViewData.adMixFloor, frsViewData.adShowSelect);
                if (V != null) {
                    this.g.setThreadList(V);
                    this.n.K(V, this.e, this.g, 0);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.g.getForum()));
            }
        }
    }
}
