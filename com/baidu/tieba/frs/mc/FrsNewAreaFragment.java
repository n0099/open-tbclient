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
import com.baidu.tieba.a16;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.ci;
import com.baidu.tieba.ci5;
import com.baidu.tieba.ct7;
import com.baidu.tieba.er7;
import com.baidu.tieba.fda;
import com.baidu.tieba.fo7;
import com.baidu.tieba.fr7;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.gd7;
import com.baidu.tieba.ge7;
import com.baidu.tieba.go7;
import com.baidu.tieba.h06;
import com.baidu.tieba.he7;
import com.baidu.tieba.ib;
import com.baidu.tieba.ie7;
import com.baidu.tieba.ii;
import com.baidu.tieba.io7;
import com.baidu.tieba.jm7;
import com.baidu.tieba.kp6;
import com.baidu.tieba.lc5;
import com.baidu.tieba.lq7;
import com.baidu.tieba.ly5;
import com.baidu.tieba.mda;
import com.baidu.tieba.my5;
import com.baidu.tieba.ny5;
import com.baidu.tieba.oc5;
import com.baidu.tieba.pq7;
import com.baidu.tieba.py4;
import com.baidu.tieba.pz9;
import com.baidu.tieba.qfa;
import com.baidu.tieba.qm7;
import com.baidu.tieba.rca;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tfa;
import com.baidu.tieba.tj6;
import com.baidu.tieba.vp7;
import com.baidu.tieba.wy9;
import com.baidu.tieba.wz5;
import com.baidu.tieba.xca;
import com.baidu.tieba.xh7;
import com.baidu.tieba.ya;
import com.baidu.tieba.yh;
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
public class FrsNewAreaFragment extends BaseFragment implements VoiceManager.j, jm7, UserIconBox.c, BdListView.p, FrsCommonImageLayout.e, ge7, ActivityCompat.OnRequestPermissionsResultCallback, pz9, he7, ny5, ie7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener A;
    public final mda B;
    public final CustomMessageListener C;
    public final RecyclerView.OnScrollListener D;
    public final CustomMessageListener E;
    public ii F;
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
    public qm7 n;
    public int o;
    public int p;
    public boolean q;
    public boolean r;
    public ci5 s;
    public SparseArray<my5> t;
    public int u;
    public int v;
    public boolean w;
    public CustomMessageListener x;
    public Runnable y;
    public CustomMessageListener z;

    @Override // com.baidu.tieba.ge7
    public void F0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
        }
    }

    public final int K2(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048586, this, i2, i3)) == null) {
            if (i2 != 1) {
                return (i2 != 2 || i3 == 1) ? 0 : 3;
            }
            return 3;
        }
        return invokeII.intValue;
    }

    @Override // com.baidu.tieba.ny5
    public void g0(ly5 ly5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, ly5Var) == null) {
        }
    }

    @Override // com.baidu.tieba.he7
    public NavigationBar r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return null;
        }
        return (NavigationBar) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.IPlayView v1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048645, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    /* loaded from: classes6.dex */
    public class c implements ii {
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

        @Override // com.baidu.tieba.ii
        public void b(View view2, yh yhVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, yhVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && bdUniqueId != null && yhVar != null && (yhVar instanceof py4)) {
                ThreadData threadData = ((py4) yhVar).t;
                if (threadData.getAnchorInfoData() != null && threadData.getAnchorInfoData().getGroup_id() != 0 && !ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                    return;
                }
                if (threadData.getActInfoType() == 1 && !ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                    return;
                }
                tfa readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                if (readThreadHistory != null && !readThreadHistory.d(threadData.getId())) {
                    readThreadHistory.a(threadData.getId());
                    qm7 qm7Var = this.a.n;
                    if (qm7Var != null) {
                        qm7Var.s();
                    }
                }
                String ad_url = threadData.getAd_url();
                boolean z2 = false;
                if (ad_url != null && !ad_url.equals("")) {
                    kp6.a(new a(this, ad_url), "requestAdFrsNewArea", 3);
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
                    go7 go7Var = new go7();
                    if (this.a.g.needLog == 1) {
                        z2 = true;
                    }
                    go7Var.a = z2;
                    go7Var.c = this.a.g.getForum().getId();
                    go7Var.d = this.a.g.getForum().getName();
                    go7Var.b = this.a.l.P();
                    go7 go7Var2 = io7.q0;
                    if (go7Var2 != null) {
                        go7Var.e = go7Var2.e;
                        go7Var.f = go7Var2.f;
                    }
                    fo7.e(threadData, 1, this.a.getUniqueId(), go7Var, this.a.getTbPageTag());
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
            qm7 qm7Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (qm7Var = this.a.n) != null && qm7Var.n() != null && !this.a.n.n().isComputingLayout()) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                this.a.G2(customResponsedMessage);
            }
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
                    this.a.d3(null);
                } else {
                    this.a.R2(false);
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
                if (!TextUtils.isEmpty(this.a.a) && threadData.getPraise() != null) {
                    this.a.f3(threadData.getPraise().getIsLike());
                }
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
                if (this.a.J2() != null) {
                    this.a.J2().setSelection(0);
                }
                if (this.a.s != null && this.a.s.isViewAttached()) {
                    this.a.R2(false);
                    return;
                }
                qm7 qm7Var = this.a.n;
                if (qm7Var != null) {
                    qm7Var.P();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements mda {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public final /* synthetic */ FrsNewAreaFragment b;

        @Override // com.baidu.tieba.mda
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.baidu.tieba.mda
        public void c(fda fdaVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fdaVar) == null) {
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

        @Override // com.baidu.tieba.mda
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

        @Override // com.baidu.tieba.mda
        public void d(int i, boolean z, xca xcaVar) {
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), xcaVar}) == null) {
                if (this.b.r) {
                    if (this.b.M2().Q() == null) {
                        this.b.r = false;
                        return;
                    } else if (this.b.M2().Q().getThreadList().size() >= 10) {
                        this.b.r = false;
                        vp7 vp7Var = new vp7();
                        vp7Var.b = 301;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384, vp7Var));
                        return;
                    }
                }
                if (xcaVar == null) {
                    this.a = 1L;
                } else if (xcaVar.b) {
                    this.a = 0L;
                } else {
                    this.a = 1L;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (i == 3) {
                    this.b.m.g0();
                }
                this.b.n.D(false);
                if (this.b.M2().Q() != null) {
                    FrsNewAreaFragment frsNewAreaFragment = this.b;
                    frsNewAreaFragment.g = frsNewAreaFragment.M2().Q();
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
                    ArrayList<yh> U = this.b.m.U(false, false, false, this.b.g.getThreadList(), null, this.b.g.adMixFloor, this.b.g.adShowSelect);
                    if (U != null) {
                        this.b.g.setThreadList(U);
                        FrsNewAreaFragment frsNewAreaFragment3 = this.b;
                        frsNewAreaFragment3.n.K(U, frsNewAreaFragment3.e, this.b.g, this.b.o);
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
                if (this.a != 0) {
                    this.b.d3(xcaVar);
                } else {
                    this.b.N2();
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
                    if (this.b.g != null && this.b.g.getThreadList() != null && this.b.g.getThreadList().size() == 0 && this.b.M2().getType() == 4) {
                        FrsNewAreaFragment frsNewAreaFragment7 = this.b;
                        frsNewAreaFragment7.showToast(frsNewAreaFragment7.getPageContext().getString(R.string.no_more_to_load));
                        if (this.b.e > 1) {
                            FrsNewAreaFragment.h2(this.b);
                        }
                        if (this.b.i > -1) {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            FrsNewAreaFragment frsNewAreaFragment8 = this.b;
                            long S = frsNewAreaFragment8.M2().S();
                            FrsNewAreaFragment frsNewAreaFragment9 = this.b;
                            TiebaStatic.page("op_frs_enter", currentTimeMillis2 - frsNewAreaFragment8.i, S - frsNewAreaFragment9.i, frsNewAreaFragment9.M2().U(), this.b.M2().T(), currentTimeMillis2 - this.b.M2().R());
                            this.b.i = -1L;
                        }
                        this.b.j = System.currentTimeMillis() - currentTimeMillis;
                        return;
                    }
                    if (this.b.g != null) {
                        ArrayList<yh> arrayList = new ArrayList<>();
                        if (!ListUtils.isEmpty(this.b.g.getThreadList())) {
                            arrayList.addAll(this.b.g.getThreadList());
                            if (i == 3 && pq7.a(this.b.f) && this.b.g.frsForumGroup != null && this.b.g.frsForumGroup.feed_card != null && !ListUtils.isEmpty(this.b.g.frsForumGroup.feed_card.group_list) && this.b.g.frsForumGroup.feed_card.index.intValue() >= 0 && this.b.g.frsForumGroup.feed_card.index.intValue() <= arrayList.size()) {
                                xh7.f(this.b.g.frsForumGroup, arrayList, this.b.f);
                            }
                        }
                        FrsLoadMoreModel frsLoadMoreModel = this.b.m;
                        if (i == 3) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        ArrayList<yh> U2 = frsLoadMoreModel.U(false, z2, true, arrayList, null, this.b.g.adMixFloor, this.b.g.adShowSelect);
                        if (U2 != null && U2.size() > 0) {
                            this.b.g.setThreadList(U2);
                        }
                    }
                    this.b.W2();
                    qm7 qm7Var = this.b.n;
                    if (qm7Var != null) {
                        qm7Var.O();
                    }
                }
                if (this.b.i > -1) {
                    long currentTimeMillis3 = System.currentTimeMillis();
                    FrsNewAreaFragment frsNewAreaFragment10 = this.b;
                    long S2 = frsNewAreaFragment10.M2().S();
                    FrsNewAreaFragment frsNewAreaFragment11 = this.b;
                    TiebaStatic.page("op_frs_enter", currentTimeMillis3 - frsNewAreaFragment10.i, S2 - frsNewAreaFragment11.i, frsNewAreaFragment11.M2().U(), this.b.M2().T(), currentTimeMillis3 - this.b.M2().R());
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
            qm7 qm7Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (qm7Var = this.a.n) != null) {
                qm7Var.P();
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
                qfa.o(this.a.b);
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
                    tj6.b().e(true);
                    rca.g().h(this.c.getUniqueId(), true);
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
                FrsNewAreaFragment.q2(this.c, i2);
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

    public static /* synthetic */ int q2(FrsNewAreaFragment frsNewAreaFragment, int i2) {
        int i3 = frsNewAreaFragment.v + i2;
        frsNewAreaFragment.v = i3;
        return i3;
    }

    @Override // com.baidu.tieba.ny5
    public void Q0(int i2, my5 my5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048594, this, i2, my5Var) == null) {
            this.t.put(i2, my5Var);
        }
    }

    public static /* synthetic */ int h2(FrsNewAreaFragment frsNewAreaFragment) {
        int i2 = frsNewAreaFragment.e;
        frsNewAreaFragment.e = i2 - 1;
        return i2;
    }

    public void E2(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData) != null) || threadData == null) {
            return;
        }
        this.l.N(threadData);
    }

    public final void R2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.q = true;
            e3();
            N2();
            if (!z) {
                N2();
                c3();
            }
            FrsNewAreaModelController frsNewAreaModelController = this.l;
            if (frsNewAreaModelController != null) {
                frsNewAreaModelController.loadData();
            }
        }
    }

    public void S2(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, frsViewData) != null) || frsViewData == null) {
            return;
        }
        this.g = frsViewData;
        hideLoadingView(this.n.o());
        qm7 qm7Var = this.n;
        if (qm7Var != null) {
            qm7Var.D(false);
            this.n.K(null, this.e, this.g, this.o);
        }
    }

    public void Y2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            this.d = i2;
        }
    }

    public void Z2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.b = str;
        }
    }

    public void a3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            this.e = i2;
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void onFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, str) == null) {
            b3();
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, str) == null) {
            this.c = str;
        }
    }

    @Override // com.baidu.tieba.ny5
    public my5 t1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048643, this, i2)) == null) {
            return this.t.get(i2);
        }
        return (my5) invokeI.objValue;
    }

    @Override // com.baidu.tieba.ie7
    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            rca.g().h(getUniqueId(), false);
        }
    }

    @Override // com.baidu.tieba.pz9
    public TbPageContext<?> D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return getPageContext();
        }
        return (TbPageContext) invokeV.objValue;
    }

    public qm7 I2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.n;
        }
        return (qm7) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pz9
    public int J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public BdTypeRecyclerView J2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            qm7 qm7Var = this.n;
            if (qm7Var == null) {
                return null;
            }
            return qm7Var.n();
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pz9
    public void L0() {
        FrsNewAreaModelController frsNewAreaModelController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (frsNewAreaModelController = this.l) != null) {
            frsNewAreaModelController.f0();
        }
    }

    public FrsLoadMoreModel L2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.m;
        }
        return (FrsLoadMoreModel) invokeV.objValue;
    }

    public FrsNewAreaModelController M2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.l;
        }
        return (FrsNewAreaModelController) invokeV.objValue;
    }

    public final void N2() {
        qm7 qm7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (qm7Var = this.n) != null) {
            qm7Var.E(true);
            this.n.J(true);
            ci5 ci5Var = this.s;
            if (ci5Var != null && ci5Var.isViewAttached()) {
                this.s.dettachView(this.n.o());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.h == null) {
                this.h = VoiceManager.instance();
            }
            return this.h;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public final void O2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            registerListener(2001118, this.E);
        }
    }

    public final void Q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.d != 0) {
                this.d = 1;
            }
            this.n.H(this.F);
            this.n.I(this.D);
        }
    }

    public final void U2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (this.d == 1) {
                ib.a().b(new j(this));
            }
            this.d = 0;
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public ya<TbImageView> V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (getBaseFragmentActivity() instanceof FrsActivity) {
                return ((FrsActivity) getBaseFragmentActivity()).V();
            }
            return null;
        }
        return (ya) invokeV.objValue;
    }

    public void X2() {
        qm7 qm7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (qm7Var = this.n) != null && qm7Var.n() != null) {
            this.n.n().post(new a(this));
        }
    }

    @Override // com.baidu.tieba.ge7
    public void Y1() {
        qm7 qm7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && (qm7Var = this.n) != null && qm7Var.n() != null) {
            this.n.n().scrollToPosition(0);
        }
    }

    public final void c3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.n.E(false);
            showLoadingView(this.n.o(), true, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703a6));
        }
    }

    public void e3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            VoiceManager O0 = O0();
            this.h = O0;
            O0.stopPlay();
        }
    }

    @Override // com.baidu.tieba.jm7
    public /* bridge */ /* synthetic */ BdPageContext getPageContext() {
        return super.getPageContext();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            TbPageTag tbPageTag = super.getTbPageTag();
            FrsViewData frsViewData = this.g;
            if (frsViewData != null) {
                i2 = frsViewData.getSortType();
            } else {
                i2 = -1;
            }
            tbPageTag.sortType = er7.g(i2);
            tbPageTag.locatePage = "a071";
            return tbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    public final void hideLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.n.E(true);
            hideLoadingView(this.n.o());
        }
    }

    @Override // com.baidu.tieba.ge7
    public void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048618, this) == null) && this.n != null) {
            Y1();
            this.n.P();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public ya<TbImageView> o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (getBaseFragmentActivity() instanceof FrsActivity) {
                return ((FrsActivity) getBaseFragmentActivity()).o0();
            }
            return null;
        }
        return (ya) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public ci onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            if (J2() == null) {
                return null;
            }
            return J2().getPreLoadHandle();
        }
        return (ci) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            super.onLazyLoad();
            if (this.q) {
                return;
            }
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                R2(false);
            } else {
                d3(null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            H2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048630, this) != null) || !BdNetTypeUtil.isNetWorkAvailable()) {
            return;
        }
        R2(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            super.onPause();
            VoiceManager O0 = O0();
            this.h = O0;
            O0.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            super.onResume();
            qm7 qm7Var = this.n;
            if (qm7Var != null) {
                qm7Var.s();
            }
            VoiceManager O0 = O0();
            this.h = O0;
            O0.onResume(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            super.onStart();
            VoiceManager O0 = O0();
            this.h = O0;
            O0.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tieba.pz9
    public String r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jm7
    public FrsViewData s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return this.g;
        }
        return (FrsViewData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jm7, com.baidu.tieba.ke7
    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public final void F2(List<String> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        ArrayList<yh> threadList = this.g.getThreadList();
        if (!ListUtils.isEmpty(threadList) && this.n.n() != null && this.n.n().getData() != null) {
            Iterator<yh> it = threadList.iterator();
            List<yh> data = this.n.n().getData();
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                try {
                    yh next = it.next();
                    if (next instanceof py4) {
                        ThreadData threadData = ((py4) next).t;
                        int i4 = 0;
                        while (true) {
                            if (i4 >= list.size()) {
                                break;
                            } else if (StringHelper.equals(list.get(i4), threadData.getId())) {
                                it.remove();
                                data.remove(next);
                                this.m.c0(next);
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
                    fr7.f("frsNewAreafragment-doDeleteThread()", i3, i2, e2);
                    throw null;
                }
            }
        }
    }

    public final void d3(xca xcaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, xcaVar) == null) {
            this.n.E(false);
            this.n.J(false);
            this.n.p();
            this.n.n().getData().clear();
            this.n.s();
            if (this.s == null) {
                ci5 ci5Var = new ci5(getPageContext().getContext(), getNetRefreshListener());
                this.s = ci5Var;
                ci5Var.d(null);
                this.s.b(null);
                this.s.e();
                this.s.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            if (xcaVar != null) {
                this.s.c(getPageContext().getResources().getString(R.string.net_error_text, xcaVar.d, Integer.valueOf(xcaVar.c)));
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
        if (interceptable == null || interceptable.invokeL(1048623, this, bundle) == null) {
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
            rca.g().i(getUniqueId());
            FrsNewAreaModelController frsNewAreaModelController = new FrsNewAreaModelController(this);
            this.l = frsNewAreaModelController;
            if (arguments != null) {
                frsNewAreaModelController.W(arguments);
            } else if (bundle != null) {
                frsNewAreaModelController.W(bundle);
            } else {
                frsNewAreaModelController.W(null);
            }
            VoiceManager O0 = O0();
            this.h = O0;
            O0.onCreate(getPageContext());
            P2(bundle);
            registerListener(this.C);
            registerListener(this.z);
            registerListener(this.A);
            registerListener(this.x);
            FrsLoadMoreModel frsLoadMoreModel = new FrsLoadMoreModel(this, null);
            this.m = frsLoadMoreModel;
            frsLoadMoreModel.registerListener();
            this.m.k0(3);
            this.m.i0(true);
            this.m.h0(ct7.a(this.w));
            System.currentTimeMillis();
            this.u = UtilHelper.getScreenHeight(getActivity());
        }
    }

    public final void G2(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, responsedMessage) != null) || this.g == null || this.n == null || !(responsedMessage instanceof DownloadMessage) || (data = ((DownloadMessage) responsedMessage).getData()) == null) {
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

    public final void P2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            O2();
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

    public final void f3(int i2) {
        ArrayList<yh> threadList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048613, this, i2) == null) && (threadList = this.g.getThreadList()) != null) {
            Iterator<yh> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                yh next = it.next();
                if (next instanceof py4) {
                    ThreadData threadData = ((py4) next).t;
                    if (threadData.getId() != null && threadData.getId().equals(this.a)) {
                        lq7.d(threadData, i2);
                        this.a = null;
                        break;
                    }
                }
            }
            this.n.m().p(threadList, this.g);
            this.n.m().l();
        }
    }

    public final void H2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                if (this.p == 3) {
                    onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                }
                if (!this.q) {
                    SafeHandler.getInst().post(this.y);
                }
                qm7 qm7Var = this.n;
                if (qm7Var != null) {
                    qm7Var.O();
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            if (!BdUtilHelper.isNetOk()) {
                this.n.p();
            } else if (this.n.B()) {
            } else {
                if (!this.l.V()) {
                    this.n.p();
                    return;
                }
                b3();
                b();
            }
        }
    }

    @Override // com.baidu.tieba.ie7
    public void z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            if (getPageContext() != null) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            }
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                wz5.c().f("page_frs_good");
                R2(true);
                return;
            }
            this.n.D(false);
        }
    }

    public void T2(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, list) == null) {
            F2(list);
            int i2 = 0;
            for (yh yhVar : this.g.getThreadList()) {
                if (yhVar instanceof py4) {
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
        if (interceptable == null || interceptable.invokeI(1048622, this, i2) == null) {
            if (this.p == 3 && this.n == null) {
                return;
            }
            this.p = i2;
            super.onChangeSkinType(i2);
            qm7 qm7Var = this.n;
            if (qm7Var != null) {
                qm7Var.v(i2);
                this.n.O();
            }
            ci5 ci5Var = this.s;
            if (ci5Var != null && ci5Var.isViewAttached()) {
                this.s.onChangeSkinType();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("name", this.b);
            bundle.putString("from", this.c);
            this.l.a0(bundle);
            VoiceManager O0 = O0();
            this.h = O0;
            if (O0 != null) {
                O0.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    public final void V2() {
        qm7 qm7Var;
        HashMap<Integer, ThreadData> h2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (qm7Var = this.n) != null && qm7Var.m() != null && (h2 = this.n.m().h()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, ThreadData> entry : h2.entrySet()) {
                ThreadData value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            oc5.q().u(arrayList);
        }
    }

    public final void b3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            if (this.o == 0 && !this.m.R(this.g.getThreadListIds())) {
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
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            qm7 qm7Var = this.n;
            if (qm7Var != null) {
                qm7Var.w();
                this.n.I(null);
            }
            MessageManager.getInstance().unRegisterListener(this.x);
            rca.g().k(getUniqueId());
            tj6.b().e(false);
            super.onDestroy();
            this.l.Z();
            VoiceManager O0 = O0();
            this.h = O0;
            O0.onDestory(getPageContext());
            SafeHandler.getInst().removeCallbacks(this.y);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            super.onStop();
            tj6.b().e(false);
            rca.g().h(getUniqueId(), false);
            FrsViewData frsViewData = this.g;
            if (frsViewData != null && frsViewData.getForum() != null) {
                lc5.j().x(getPageContext().getPageActivity(), "frs", this.g.getForum().getId(), 0L);
            }
            VoiceManager O0 = O0();
            this.h = O0;
            if (O0 != null) {
                O0.onStop(getPageContext());
            }
        }
    }

    public final void W2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            e3();
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
                U2();
                ArrayList<yh> threadList = this.g.getThreadList();
                if (threadList != null) {
                    this.n.K(threadList, this.e, this.g, this.g.getPage().b());
                    V2();
                    this.n.s();
                    if (this.g.getIsNewUrl() == 1) {
                        this.n.m().q(true);
                    } else {
                        this.n.m().q(false);
                    }
                    this.n.F(K2(M2().getType(), this.e));
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void b() {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && !this.m.isLoading && !this.l.X()) {
            if (this.m.R(this.g.getThreadListIds())) {
                if (this.l.Q() != null) {
                    str = wy9.e(this.l.Q().getThreadList(), false);
                } else {
                    str = "";
                }
                this.n.K(this.m.e0(), this.e, this.g, 0);
                this.m.f0(JavaTypesHelper.toLong(this.f, 0L), this.g.getThreadListIds(), this.b, this.e, this.g.isBrandForum, str);
            } else if (this.o != 0) {
                this.n.K(this.m.e0(), this.e, this.g, 0);
                int i2 = this.e + 1;
                this.e = i2;
                this.l.Y(i2);
                FrsLoadMoreModel frsLoadMoreModel = this.m;
                frsLoadMoreModel.loadingDone = false;
                frsLoadMoreModel.loadIndex = 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void n(ArrayList<yh> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, arrayList) == null) {
            b3();
            if (h06.k().l(AbsDataRecorder.Scene.FRS_NEW)) {
                h06.k().g(AbsDataRecorder.Scene.FRS_NEW).b();
            }
            if (a16.i().o(AbsDataRecorder.Scene.FRS_NEW)) {
                a16.i().g(AbsDataRecorder.Scene.FRS_NEW).b();
            }
            if (arrayList != null && arrayList.size() != 0) {
                FrsLoadMoreModel frsLoadMoreModel = this.m;
                FrsViewData frsViewData = this.g;
                ArrayList<yh> U = frsLoadMoreModel.U(false, false, false, arrayList, null, frsViewData.adMixFloor, frsViewData.adShowSelect);
                if (U != null) {
                    this.g.setThreadList(U);
                    this.n.K(U, this.e, this.g, 0);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.g.getForum()));
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        ThreadData threadDataById;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048621, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1 && i2 == 18003) {
                this.n.m().l();
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra != null && (threadDataById = this.g.getThreadDataById(stringExtra)) != null) {
                    int intExtra = intent.getIntExtra("type", -1);
                    if (intExtra == 2) {
                        threadDataById.setIs_good(intent.getIntExtra("good_data", 0));
                        threadDataById.parser_title();
                        R2(false);
                    } else if (intExtra == 0) {
                        this.g.removeThreadData(threadDataById);
                        ArrayList<yh> threadList = this.g.getThreadList();
                        if (threadList != null && threadList.size() <= 0) {
                            threadList.add(new gd7());
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048624, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0369, (ViewGroup) null);
            this.n = new qm7(this, inflate);
            Q2();
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048633, this, i2, strArr, iArr) == null) && i2 == 1) {
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
