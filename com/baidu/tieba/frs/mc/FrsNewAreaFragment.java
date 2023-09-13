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
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.b46;
import com.baidu.tieba.bg;
import com.baidu.tieba.bga;
import com.baidu.tieba.bi5;
import com.baidu.tieba.c46;
import com.baidu.tieba.cn;
import com.baidu.tieba.d46;
import com.baidu.tieba.dw7;
import com.baidu.tieba.e3a;
import com.baidu.tieba.ei5;
import com.baidu.tieba.en7;
import com.baidu.tieba.ep6;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.gn;
import com.baidu.tieba.h45;
import com.baidu.tieba.jga;
import com.baidu.tieba.jv7;
import com.baidu.tieba.l2a;
import com.baidu.tieba.lg;
import com.baidu.tieba.m56;
import com.baidu.tieba.mn;
import com.baidu.tieba.ni7;
import com.baidu.tieba.nj7;
import com.baidu.tieba.oj7;
import com.baidu.tieba.pj7;
import com.baidu.tieba.py7;
import com.baidu.tieba.q66;
import com.baidu.tieba.qga;
import com.baidu.tieba.qr7;
import com.baidu.tieba.sn5;
import com.baidu.tieba.sw7;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tw7;
import com.baidu.tieba.uia;
import com.baidu.tieba.ut7;
import com.baidu.tieba.vfa;
import com.baidu.tieba.vt7;
import com.baidu.tieba.vu6;
import com.baidu.tieba.x56;
import com.baidu.tieba.xia;
import com.baidu.tieba.xr7;
import com.baidu.tieba.xt7;
import com.baidu.tieba.zv7;
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
public class FrsNewAreaFragment extends BaseFragment implements VoiceManager.j, qr7, UserIconBox.c, BdListView.p, FrsCommonImageLayout.e, nj7, ActivityCompat.OnRequestPermissionsResultCallback, e3a, oj7, d46, pj7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener A;
    public final qga B;
    public final CustomMessageListener C;
    public final RecyclerView.OnScrollListener D;
    public final CustomMessageListener E;
    public mn F;
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
    public xr7 n;
    public int o;
    public int p;
    public boolean q;
    public boolean r;
    public sn5 s;
    public SparseArray<c46> t;
    public int u;
    public int v;
    public boolean w;
    public CustomMessageListener x;
    public Runnable y;
    public CustomMessageListener z;

    public final int E2(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048581, this, i2, i3)) == null) {
            if (i2 != 1) {
                return (i2 != 2 || i3 == 1) ? 0 : 3;
            }
            return 3;
        }
        return invokeII.intValue;
    }

    @Override // com.baidu.tieba.d46
    public void Z(b46 b46Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, b46Var) == null) {
        }
    }

    @Override // com.baidu.tieba.oj7
    public NavigationBar o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return null;
        }
        return (NavigationBar) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.IPlayView r1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    @Override // com.baidu.tieba.nj7
    public void y0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048644, this, z) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class c implements mn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsNewAreaFragment a;

        /* loaded from: classes5.dex */
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

        @Override // com.baidu.tieba.mn
        public void b(View view2, cn cnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && bdUniqueId != null && cnVar != null && (cnVar instanceof h45)) {
                ThreadData threadData = ((h45) cnVar).t;
                if (threadData.getAnchorInfoData() != null && threadData.getAnchorInfoData().getGroup_id() != 0 && !ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                    return;
                }
                if (threadData.getActInfoType() == 1 && !ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                    return;
                }
                xia readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                if (readThreadHistory != null && !readThreadHistory.d(threadData.getId())) {
                    readThreadHistory.a(threadData.getId());
                    xr7 xr7Var = this.a.n;
                    if (xr7Var != null) {
                        xr7Var.s();
                    }
                }
                String ad_url = threadData.getAd_url();
                boolean z2 = false;
                if (ad_url != null && !ad_url.equals("")) {
                    vu6.a(new a(this, ad_url), "requestAdFrsNewArea", 3);
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
                    vt7 vt7Var = new vt7();
                    if (this.a.g.needLog == 1) {
                        z2 = true;
                    }
                    vt7Var.a = z2;
                    vt7Var.c = this.a.g.getForum().getId();
                    vt7Var.d = this.a.g.getForum().getName();
                    vt7Var.b = this.a.l.O();
                    vt7 vt7Var2 = xt7.q0;
                    if (vt7Var2 != null) {
                        vt7Var.e = vt7Var2.e;
                        vt7Var.f = vt7Var2.f;
                    }
                    ut7.e(threadData, 1, this.a.getUniqueId(), vt7Var, this.a.getTbPageTag());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
            xr7 xr7Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (xr7Var = this.a.n) != null && xr7Var.n() != null && !this.a.n.n().isComputingLayout()) {
                this.a.n.s();
            }
        }
    }

    /* loaded from: classes5.dex */
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
            this.a.A2(customResponsedMessage);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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
                    this.a.X2(null);
                } else {
                    this.a.L2(false);
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
                this.a.Z2(threadData.getPraise().getIsLike());
            }
        }
    }

    /* loaded from: classes5.dex */
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
                if (this.a.D2() != null) {
                    this.a.D2().setSelection(0);
                }
                if (this.a.s == null || !this.a.s.isViewAttached()) {
                    xr7 xr7Var = this.a.n;
                    if (xr7Var != null) {
                        xr7Var.P();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                        return;
                    }
                    return;
                }
                this.a.L2(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements qga {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public final /* synthetic */ FrsNewAreaFragment b;

        @Override // com.baidu.tieba.qga
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.baidu.tieba.qga
        public void c(jga jgaVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jgaVar) == null) {
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

        @Override // com.baidu.tieba.qga
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

        @Override // com.baidu.tieba.qga
        public void d(int i, boolean z, bga bgaVar) {
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), bgaVar}) == null) {
                if (this.b.r) {
                    if (this.b.G2().P() == null) {
                        this.b.r = false;
                        return;
                    } else if (this.b.G2().P().getThreadList().size() >= 10) {
                        this.b.r = false;
                        jv7 jv7Var = new jv7();
                        jv7Var.b = 301;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384, jv7Var));
                        return;
                    }
                }
                if (bgaVar == null) {
                    this.a = 1L;
                } else if (bgaVar.b) {
                    this.a = 0L;
                } else {
                    this.a = 1L;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (i == 3) {
                    this.b.m.f0();
                }
                this.b.n.D(false);
                if (this.b.G2().P() != null) {
                    FrsNewAreaFragment frsNewAreaFragment = this.b;
                    frsNewAreaFragment.g = frsNewAreaFragment.G2().P();
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
                    ArrayList<cn> T2 = this.b.m.T(false, false, false, this.b.g.getThreadList(), null, this.b.g.adMixFloor, this.b.g.adShowSelect);
                    if (T2 != null) {
                        this.b.g.setThreadList(T2);
                        FrsNewAreaFragment frsNewAreaFragment3 = this.b;
                        frsNewAreaFragment3.n.K(T2, frsNewAreaFragment3.e, this.b.g, this.b.o);
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
                    this.b.H2();
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
                    if (this.b.g != null && this.b.g.getThreadList() != null && this.b.g.getThreadList().size() == 0 && this.b.G2().getType() == 4) {
                        FrsNewAreaFragment frsNewAreaFragment7 = this.b;
                        frsNewAreaFragment7.showToast(frsNewAreaFragment7.getPageContext().getString(R.string.no_more_to_load));
                        if (this.b.e > 1) {
                            FrsNewAreaFragment.b2(this.b);
                        }
                        if (this.b.i > -1) {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            FrsNewAreaFragment frsNewAreaFragment8 = this.b;
                            long R = frsNewAreaFragment8.G2().R();
                            FrsNewAreaFragment frsNewAreaFragment9 = this.b;
                            TiebaStatic.page("op_frs_enter", currentTimeMillis2 - frsNewAreaFragment8.i, R - frsNewAreaFragment9.i, frsNewAreaFragment9.G2().T(), this.b.G2().S(), currentTimeMillis2 - this.b.G2().Q());
                            this.b.i = -1L;
                        }
                        this.b.j = System.currentTimeMillis() - currentTimeMillis;
                        return;
                    }
                    if (this.b.g != null) {
                        ArrayList<cn> arrayList = new ArrayList<>();
                        if (!ListUtils.isEmpty(this.b.g.getThreadList())) {
                            arrayList.addAll(this.b.g.getThreadList());
                            if (i == 3 && dw7.a(this.b.f) && this.b.g.frsForumGroup != null && this.b.g.frsForumGroup.feed_card != null && !ListUtils.isEmpty(this.b.g.frsForumGroup.feed_card.group_list) && this.b.g.frsForumGroup.feed_card.index.intValue() >= 0 && this.b.g.frsForumGroup.feed_card.index.intValue() <= arrayList.size()) {
                                en7.f(this.b.g.frsForumGroup, arrayList, this.b.f);
                            }
                        }
                        FrsLoadMoreModel frsLoadMoreModel = this.b.m;
                        if (i == 3) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        ArrayList<cn> T3 = frsLoadMoreModel.T(false, z2, true, arrayList, null, this.b.g.adMixFloor, this.b.g.adShowSelect);
                        if (T3 != null && T3.size() > 0) {
                            this.b.g.setThreadList(T3);
                        }
                    }
                    this.b.Q2();
                    xr7 xr7Var = this.b.n;
                    if (xr7Var != null) {
                        xr7Var.O();
                    }
                } else {
                    this.b.X2(bgaVar);
                }
                if (this.b.i > -1) {
                    long currentTimeMillis3 = System.currentTimeMillis();
                    FrsNewAreaFragment frsNewAreaFragment10 = this.b;
                    long R2 = frsNewAreaFragment10.G2().R();
                    FrsNewAreaFragment frsNewAreaFragment11 = this.b;
                    TiebaStatic.page("op_frs_enter", currentTimeMillis3 - frsNewAreaFragment10.i, R2 - frsNewAreaFragment11.i, frsNewAreaFragment11.G2().T(), this.b.G2().S(), currentTimeMillis3 - this.b.G2().Q());
                    this.b.i = -1L;
                }
                this.b.j = System.currentTimeMillis() - currentTimeMillis;
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
            xr7 xr7Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (xr7Var = this.a.n) != null) {
                xr7Var.P();
            }
        }
    }

    /* loaded from: classes5.dex */
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
                uia.o(this.a.b);
            }
        }
    }

    /* loaded from: classes5.dex */
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
                    ep6.b().e(true);
                    vfa.g().h(this.c.getUniqueId(), true);
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
                FrsNewAreaFragment.k2(this.c, i2);
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

    public static /* synthetic */ int b2(FrsNewAreaFragment frsNewAreaFragment) {
        int i2 = frsNewAreaFragment.e;
        frsNewAreaFragment.e = i2 - 1;
        return i2;
    }

    public final void L2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.q = true;
            Y2();
            H2();
            if (!z) {
                H2();
                W2();
            }
            FrsNewAreaModelController frsNewAreaModelController = this.l;
            if (frsNewAreaModelController != null) {
                frsNewAreaModelController.loadData();
            }
        }
    }

    public void M2(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048592, this, frsViewData) != null) || frsViewData == null) {
            return;
        }
        this.g = frsViewData;
        hideLoadingView(this.n.o());
        xr7 xr7Var = this.n;
        if (xr7Var != null) {
            xr7Var.D(false);
            this.n.K(null, this.e, this.g, this.o);
        }
    }

    public void S2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.d = i2;
        }
    }

    public void T2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.b = str;
        }
    }

    public void U2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            this.e = i2;
        }
    }

    @Override // com.baidu.tieba.d46
    public c46 o1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048619, this, i2)) == null) {
            return this.t.get(i2);
        }
        return (c46) invokeI.objValue;
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void onFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, str) == null) {
            V2();
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, str) == null) {
            this.c = str;
        }
    }

    public void y2(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048645, this, threadData) != null) || threadData == null) {
            return;
        }
        this.l.M(threadData);
    }

    public static /* synthetic */ int k2(FrsNewAreaFragment frsNewAreaFragment, int i2) {
        int i3 = frsNewAreaFragment.v + i2;
        frsNewAreaFragment.v = i3;
        return i3;
    }

    @Override // com.baidu.tieba.d46
    public void J0(int i2, c46 c46Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i2, c46Var) == null) {
            this.t.put(i2, c46Var);
        }
    }

    public final void A2(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || this.g == null || this.n == null || !(responsedMessage instanceof DownloadMessage) || (data = ((DownloadMessage) responsedMessage).getData()) == null) {
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

    public final void J2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            I2();
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

    public final void Z2(int i2) {
        ArrayList<cn> threadList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048608, this, i2) == null) && (threadList = this.g.getThreadList()) != null) {
            Iterator<cn> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                cn next = it.next();
                if (next instanceof h45) {
                    ThreadData threadData = ((h45) next).t;
                    if (threadData.getId() != null && threadData.getId().equals(this.a)) {
                        zv7.d(threadData, i2);
                        this.a = null;
                        break;
                    }
                }
            }
            this.n.m().p(threadList, this.g);
            this.n.m().l();
        }
    }

    public final void B2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                if (this.p == 3) {
                    onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                }
                if (!this.q) {
                    SafeHandler.getInst().post(this.y);
                }
                xr7 xr7Var = this.n;
                if (xr7Var != null) {
                    xr7Var.O();
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            if (!BdUtilHelper.isNetOk()) {
                this.n.p();
            } else if (this.n.B()) {
            } else {
                if (!this.l.U()) {
                    this.n.p();
                    return;
                }
                V2();
                b();
            }
        }
    }

    @Override // com.baidu.tieba.pj7
    public void w1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            if (getPageContext() != null) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            }
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                m56.c().f("page_frs_good");
                L2(true);
                return;
            }
            this.n.D(false);
        }
    }

    public xr7 C2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.n;
        }
        return (xr7) invokeV.objValue;
    }

    public BdTypeRecyclerView D2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            xr7 xr7Var = this.n;
            if (xr7Var == null) {
                return null;
            }
            return xr7Var.n();
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e3a
    public void E0() {
        FrsNewAreaModelController frsNewAreaModelController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (frsNewAreaModelController = this.l) != null) {
            frsNewAreaModelController.e0();
        }
    }

    public FrsLoadMoreModel F2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.m;
        }
        return (FrsLoadMoreModel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e3a
    public int G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public FrsNewAreaModelController G2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.l;
        }
        return (FrsNewAreaModelController) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.h == null) {
                this.h = VoiceManager.instance();
            }
            return this.h;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public final void H2() {
        xr7 xr7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (xr7Var = this.n) != null) {
            xr7Var.E(true);
            this.n.J(true);
            sn5 sn5Var = this.s;
            if (sn5Var != null && sn5Var.isViewAttached()) {
                this.s.dettachView(this.n.o());
            }
        }
    }

    public final void I2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            registerListener(2001118, this.E);
        }
    }

    public final void K2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (this.d != 0) {
                this.d = 1;
            }
            this.n.H(this.F);
            this.n.I(this.D);
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public bg<TbImageView> O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (getBaseFragmentActivity() instanceof FrsActivity) {
                return ((FrsActivity) getBaseFragmentActivity()).O();
            }
            return null;
        }
        return (bg) invokeV.objValue;
    }

    public final void O2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.d == 1) {
                lg.a().b(new j(this));
            }
            this.d = 0;
        }
    }

    public void R2() {
        xr7 xr7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (xr7Var = this.n) != null && xr7Var.n() != null) {
            this.n.n().post(new a(this));
        }
    }

    @Override // com.baidu.tieba.nj7
    public void S1() {
        xr7 xr7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (xr7Var = this.n) != null && xr7Var.n() != null) {
            this.n.n().scrollToPosition(0);
        }
    }

    public final void W2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.n.E(false);
            showLoadingView(this.n.o(), true, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703aa));
        }
    }

    public void Y2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            VoiceManager H0 = H0();
            this.h = H0;
            H0.stopPlay();
        }
    }

    @Override // com.baidu.tieba.qr7
    public /* bridge */ /* synthetic */ BdPageContext getPageContext() {
        return super.getPageContext();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            TbPageTag tbPageTag = super.getTbPageTag();
            FrsViewData frsViewData = this.g;
            if (frsViewData != null) {
                i2 = frsViewData.getSortType();
            } else {
                i2 = -1;
            }
            tbPageTag.sortType = sw7.g(i2);
            tbPageTag.locatePage = "a071";
            return tbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nj7
    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && this.n != null) {
            S1();
            this.n.P();
        }
    }

    public final void hideLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.n.E(true);
            hideLoadingView(this.n.o());
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public bg<TbImageView> i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (getBaseFragmentActivity() instanceof FrsActivity) {
                return ((FrsActivity) getBaseFragmentActivity()).i0();
            }
            return null;
        }
        return (bg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e3a
    public String l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qr7
    public FrsViewData m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.g;
        }
        return (FrsViewData) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public gn onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            if (D2() == null) {
                return null;
            }
            return D2().getPreLoadHandle();
        }
        return (gn) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            super.onLazyLoad();
            if (this.q) {
                return;
            }
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                L2(false);
            } else {
                X2(null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            B2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048629, this) != null) || !BdNetTypeUtil.isNetWorkAvailable()) {
            return;
        }
        L2(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            super.onPause();
            VoiceManager H0 = H0();
            this.h = H0;
            H0.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            super.onResume();
            xr7 xr7Var = this.n;
            if (xr7Var != null) {
                xr7Var.s();
            }
            VoiceManager H0 = H0();
            this.h = H0;
            H0.onResume(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            super.onStart();
            VoiceManager H0 = H0();
            this.h = H0;
            H0.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tieba.e3a
    public TbPageContext<?> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return getPageContext();
        }
        return (TbPageContext) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pj7
    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            vfa.g().h(getUniqueId(), false);
        }
    }

    @Override // com.baidu.tieba.qr7, com.baidu.tieba.rj7
    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public void N2(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, list) == null) {
            z2(list);
            int i2 = 0;
            for (cn cnVar : this.g.getThreadList()) {
                if (cnVar instanceof h45) {
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

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            if (this.p == 3 && this.n == null) {
                return;
            }
            this.p = i2;
            super.onChangeSkinType(i2);
            xr7 xr7Var = this.n;
            if (xr7Var != null) {
                xr7Var.v(i2);
                this.n.O();
            }
            sn5 sn5Var = this.s;
            if (sn5Var != null && sn5Var.isViewAttached()) {
                this.s.onChangeSkinType();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("name", this.b);
            bundle.putString("from", this.c);
            this.l.Z(bundle);
            VoiceManager H0 = H0();
            this.h = H0;
            if (H0 != null) {
                H0.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    public final void P2() {
        xr7 xr7Var;
        HashMap<Integer, ThreadData> h2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (xr7Var = this.n) != null && xr7Var.m() != null && (h2 = this.n.m().h()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, ThreadData> entry : h2.entrySet()) {
                ThreadData value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            ei5.q().u(arrayList);
        }
    }

    public final void V2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            if (this.o == 0 && !this.m.Q(this.g.getThreadListIds())) {
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
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            xr7 xr7Var = this.n;
            if (xr7Var != null) {
                xr7Var.w();
                this.n.I(null);
            }
            MessageManager.getInstance().unRegisterListener(this.x);
            vfa.g().k(getUniqueId());
            ep6.b().e(false);
            super.onDestroy();
            this.l.Y();
            VoiceManager H0 = H0();
            this.h = H0;
            H0.onDestory(getPageContext());
            SafeHandler.getInst().removeCallbacks(this.y);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            super.onStop();
            ep6.b().e(false);
            vfa.g().h(getUniqueId(), false);
            FrsViewData frsViewData = this.g;
            if (frsViewData != null && frsViewData.getForum() != null) {
                bi5.j().x(getPageContext().getPageActivity(), "frs", this.g.getForum().getId(), 0L);
            }
            VoiceManager H0 = H0();
            this.h = H0;
            if (H0 != null) {
                H0.onStop(getPageContext());
            }
        }
    }

    public final void Q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            Y2();
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
                O2();
                ArrayList<cn> threadList = this.g.getThreadList();
                if (threadList != null) {
                    this.n.K(threadList, this.e, this.g, this.g.getPage().b());
                    P2();
                    this.n.s();
                    if (this.g.getIsNewUrl() == 1) {
                        this.n.m().q(true);
                    } else {
                        this.n.m().q(false);
                    }
                    this.n.F(E2(G2().getType(), this.e));
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public final void X2(bga bgaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, bgaVar) == null) {
            this.n.E(false);
            this.n.J(false);
            this.n.p();
            this.n.n().getData().clear();
            this.n.s();
            if (this.s == null) {
                sn5 sn5Var = new sn5(getPageContext().getContext(), getNetRefreshListener());
                this.s = sn5Var;
                sn5Var.d(null);
                this.s.b(null);
                this.s.e();
                this.s.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            if (bgaVar != null) {
                this.s.c(getPageContext().getResources().getString(R.string.net_error_text, bgaVar.d, Integer.valueOf(bgaVar.c)));
            } else {
                this.s.c(null);
            }
            this.s.onChangeSkinType();
            this.s.attachView(this.n.o(), true);
            this.s.a(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, bundle) == null) {
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
            vfa.g().i(getUniqueId());
            FrsNewAreaModelController frsNewAreaModelController = new FrsNewAreaModelController(this);
            this.l = frsNewAreaModelController;
            if (arguments != null) {
                frsNewAreaModelController.V(arguments);
            } else if (bundle != null) {
                frsNewAreaModelController.V(bundle);
            } else {
                frsNewAreaModelController.V(null);
            }
            VoiceManager H0 = H0();
            this.h = H0;
            H0.onCreate(getPageContext());
            J2(bundle);
            registerListener(this.C);
            registerListener(this.z);
            registerListener(this.A);
            registerListener(this.x);
            FrsLoadMoreModel frsLoadMoreModel = new FrsLoadMoreModel(this, null);
            this.m = frsLoadMoreModel;
            frsLoadMoreModel.registerListener();
            this.m.j0(3);
            this.m.h0(true);
            this.m.g0(py7.a(this.w));
            System.currentTimeMillis();
            this.u = UtilHelper.getScreenHeight(getActivity());
        }
    }

    public final void z2(List<String> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048646, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        ArrayList<cn> threadList = this.g.getThreadList();
        if (!ListUtils.isEmpty(threadList) && this.n.n() != null && this.n.n().getData() != null) {
            Iterator<cn> it = threadList.iterator();
            List<cn> data = this.n.n().getData();
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                try {
                    cn next = it.next();
                    if (next instanceof h45) {
                        ThreadData threadData = ((h45) next).t;
                        int i4 = 0;
                        while (true) {
                            if (i4 >= list.size()) {
                                break;
                            } else if (StringHelper.equals(list.get(i4), threadData.getId())) {
                                it.remove();
                                data.remove(next);
                                this.m.b0(next);
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
                    tw7.f("frsNewAreafragment-doDeleteThread()", i3, i2, e2);
                    throw null;
                }
            }
        }
    }

    public void b() {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && !this.m.isLoading && !this.l.W()) {
            if (this.m.Q(this.g.getThreadListIds())) {
                if (this.l.P() != null) {
                    str = l2a.e(this.l.P().getThreadList(), false);
                } else {
                    str = "";
                }
                this.n.K(this.m.d0(), this.e, this.g, 0);
                this.m.e0(JavaTypesHelper.toLong(this.f, 0L), this.g.getThreadListIds(), this.b, this.e, this.g.isBrandForum, str);
            } else if (this.o != 0) {
                this.n.K(this.m.d0(), this.e, this.g, 0);
                int i2 = this.e + 1;
                this.e = i2;
                this.l.X(i2);
                FrsLoadMoreModel frsLoadMoreModel = this.m;
                frsLoadMoreModel.loadingDone = false;
                frsLoadMoreModel.loadIndex = 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void l(ArrayList<cn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, arrayList) == null) {
            V2();
            if (x56.k().l(AbsDataRecorder.Scene.FRS_NEW)) {
                x56.k().g(AbsDataRecorder.Scene.FRS_NEW).b();
            }
            if (q66.i().o(AbsDataRecorder.Scene.FRS_NEW)) {
                q66.i().g(AbsDataRecorder.Scene.FRS_NEW).b();
            }
            if (arrayList != null && arrayList.size() != 0) {
                FrsLoadMoreModel frsLoadMoreModel = this.m;
                FrsViewData frsViewData = this.g;
                ArrayList<cn> T2 = frsLoadMoreModel.T(false, false, false, arrayList, null, frsViewData.adMixFloor, frsViewData.adShowSelect);
                if (T2 != null) {
                    this.g.setThreadList(T2);
                    this.n.K(T2, this.e, this.g, 0);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.g.getForum()));
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        ThreadData threadDataById;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048620, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1 && i2 == 18003) {
                this.n.m().l();
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra != null && (threadDataById = this.g.getThreadDataById(stringExtra)) != null) {
                    int intExtra = intent.getIntExtra("type", -1);
                    if (intExtra == 2) {
                        threadDataById.setIs_good(intent.getIntExtra("good_data", 0));
                        threadDataById.parser_title();
                        L2(false);
                    } else if (intExtra == 0) {
                        this.g.removeThreadData(threadDataById);
                        ArrayList<cn> threadList = this.g.getThreadList();
                        if (threadList != null && threadList.size() <= 0) {
                            threadList.add(new ni7());
                        }
                        this.n.s();
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048623, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0369, (ViewGroup) null);
            this.n = new xr7(this, inflate);
            K2();
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048632, this, i2, strArr, iArr) == null) && i2 == 1) {
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
}
