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
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
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
import com.baidu.tieba.ao;
import com.baidu.tieba.bk6;
import com.baidu.tieba.bq8;
import com.baidu.tieba.bv6;
import com.baidu.tieba.ch;
import com.baidu.tieba.cj6;
import com.baidu.tieba.ck6;
import com.baidu.tieba.cn8;
import com.baidu.tieba.dk6;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.go;
import com.baidu.tieba.hn8;
import com.baidu.tieba.hq5;
import com.baidu.tieba.mo5;
import com.baidu.tieba.ng;
import com.baidu.tieba.no5;
import com.baidu.tieba.nr6;
import com.baidu.tieba.oo5;
import com.baidu.tieba.pn8;
import com.baidu.tieba.pt6;
import com.baidu.tieba.qt6;
import com.baidu.tieba.r9;
import com.baidu.tieba.s36;
import com.baidu.tieba.sf8;
import com.baidu.tieba.st6;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tw6;
import com.baidu.tieba.u55;
import com.baidu.tieba.ur6;
import com.baidu.tieba.vu4;
import com.baidu.tieba.wg;
import com.baidu.tieba.wn;
import com.baidu.tieba.wn8;
import com.baidu.tieba.x55;
import com.baidu.tieba.xi;
import com.baidu.tieba.xp5;
import com.baidu.tieba.xt6;
import com.baidu.tieba.y95;
import com.baidu.tieba.yp8;
import com.baidu.tieba.ze8;
import com.baidu.tieba.zg;
import com.baidu.tieba.zq5;
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
/* loaded from: classes4.dex */
public class FrsNewAreaFragment extends BaseFragment implements VoiceManager.j, nr6, UserIconBox.c, BdListView.p, FrsCommonImageLayout.e, bk6, ActivityCompat.OnRequestPermissionsResultCallback, sf8, ck6, oo5, dk6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener A;
    public final wn8 B;
    public final CustomMessageListener C;
    public final RecyclerView.OnScrollListener D;
    public final CustomMessageListener E;
    public go F;
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
    public ur6 n;
    public int o;
    public int p;
    public boolean q;
    public boolean r;
    public y95 s;
    public SparseArray<no5> t;
    public int u;
    public int v;
    public boolean w;
    public CustomMessageListener x;
    public Runnable y;
    public CustomMessageListener z;

    @Override // com.baidu.tieba.ck6
    public NavigationBar L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (NavigationBar) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oo5
    public void M(mo5 mo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mo5Var) == null) {
        }
    }

    public final int Y1(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048590, this, i2, i3)) == null) {
            if (i2 != 1) {
                return (i2 != 2 || i3 == 1) ? 0 : 3;
            }
            return 3;
        }
        return invokeII.intValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i c1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tieba.bk6
    public void g0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class c implements go {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsNewAreaFragment a;

        /* loaded from: classes4.dex */
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

        @Override // com.baidu.tieba.go
        public void b(View view2, wn wnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, wnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && bdUniqueId != null && wnVar != null && (wnVar instanceof vu4)) {
                ThreadData threadData = ((vu4) wnVar).t;
                if (threadData.getAnchorInfoData() != null && threadData.getAnchorInfoData().getGroup_id() != 0 && !ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                    return;
                }
                if (threadData.getActInfoType() == 1 && !ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                    return;
                }
                bq8 readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                if (readThreadHistory != null && !readThreadHistory.d(threadData.getId())) {
                    readThreadHistory.a(threadData.getId());
                    ur6 ur6Var = this.a.n;
                    if (ur6Var != null) {
                        ur6Var.s();
                    }
                }
                String ad_url = threadData.getAd_url();
                boolean z2 = false;
                if (ad_url != null && !ad_url.equals("")) {
                    new Thread(new a(this, ad_url)).start();
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
                    qt6 qt6Var = new qt6();
                    if (this.a.g.needLog == 1) {
                        z2 = true;
                    }
                    qt6Var.a = z2;
                    qt6Var.c = this.a.g.getForum().getId();
                    qt6Var.d = this.a.g.getForum().getName();
                    qt6Var.b = this.a.l.B();
                    qt6 qt6Var2 = st6.p0;
                    if (qt6Var2 != null) {
                        qt6Var.e = qt6Var2.e;
                        qt6Var.f = qt6Var2.f;
                    }
                    pt6.e(threadData, 1, this.a.getUniqueId(), qt6Var, this.a.getTbPageTag());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
            ur6 ur6Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (ur6Var = this.a.n) != null && ur6Var.n() != null && !this.a.n.n().isComputingLayout()) {
                this.a.n.y();
            }
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.U1(customResponsedMessage);
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
                    this.a.r2(null);
                } else {
                    this.a.f2(false);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                    this.a.u2(threadData.getPraise().getIsLike());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                if (this.a.X1() != null) {
                    this.a.X1().setSelection(0);
                }
                if (this.a.s != null && this.a.s.isViewAttached()) {
                    this.a.f2(false);
                    return;
                }
                ur6 ur6Var = this.a.n;
                if (ur6Var != null) {
                    ur6Var.R();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements wn8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public final /* synthetic */ FrsNewAreaFragment b;

        @Override // com.baidu.tieba.wn8
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.baidu.tieba.wn8
        public void c(pn8 pn8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pn8Var) == null) {
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

        @Override // com.baidu.tieba.wn8
        public void a(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || this.b.r) {
                return;
            }
            if (i != 1 && i != 2) {
                if (i == 3) {
                    this.b.n.F(true);
                    return;
                }
                return;
            }
            this.b.n.s();
        }

        @Override // com.baidu.tieba.wn8
        public void d(int i, boolean z, hn8 hn8Var) {
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), hn8Var}) == null) {
                if (this.b.r) {
                    if (this.b.a2().C() == null) {
                        this.b.r = false;
                        return;
                    } else if (this.b.a2().C().getThreadList().size() >= 10) {
                        this.b.r = false;
                        xt6 xt6Var = new xt6();
                        xt6Var.b = 301;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384, xt6Var));
                        return;
                    }
                }
                if (hn8Var == null) {
                    this.a = 1L;
                } else if (hn8Var.b) {
                    this.a = 0L;
                } else {
                    this.a = 1L;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (i == 3) {
                    this.b.m.S();
                }
                this.b.n.F(false);
                if (this.b.a2().C() != null) {
                    FrsNewAreaFragment frsNewAreaFragment = this.b;
                    frsNewAreaFragment.g = frsNewAreaFragment.a2().C();
                }
                FrsNewAreaFragment frsNewAreaFragment2 = this.b;
                frsNewAreaFragment2.o = frsNewAreaFragment2.g.getPage().b();
                if (this.b.o == 0 && (this.b.g.getThreadListIds() == null || this.b.g.getThreadListIds().size() == 0)) {
                    if (this.b.g.getThreadList() != null && this.b.g.getThreadList().size() != 0) {
                        this.b.n.P();
                    } else {
                        this.b.n.p();
                    }
                } else {
                    this.b.n.O();
                }
                if (i == 4) {
                    ArrayList<wn> G = this.b.m.G(false, false, false, this.b.g.getThreadList(), null, this.b.g.adMixFloor, this.b.g.adShowSelect);
                    if (G != null) {
                        this.b.g.setThreadList(G);
                        FrsNewAreaFragment frsNewAreaFragment3 = this.b;
                        frsNewAreaFragment3.n.M(G, frsNewAreaFragment3.e, this.b.g, this.b.o);
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
                this.b.m();
                if (this.a != 0) {
                    this.b.r2(hn8Var);
                } else {
                    this.b.b2();
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
                    if (this.b.g != null && this.b.g.getThreadList() != null && this.b.g.getThreadList().size() == 0 && this.b.a2().getType() == 4) {
                        FrsNewAreaFragment frsNewAreaFragment7 = this.b;
                        frsNewAreaFragment7.showToast(frsNewAreaFragment7.getPageContext().getString(R.string.obfuscated_res_0x7f0f0cb6));
                        if (this.b.e > 1) {
                            FrsNewAreaFragment.v1(this.b);
                        }
                        if (this.b.i > -1) {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            FrsNewAreaFragment frsNewAreaFragment8 = this.b;
                            long E = frsNewAreaFragment8.a2().E();
                            FrsNewAreaFragment frsNewAreaFragment9 = this.b;
                            TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis2 - frsNewAreaFragment8.i, E - frsNewAreaFragment9.i, frsNewAreaFragment9.a2().G(), this.b.a2().F(), currentTimeMillis2 - this.b.a2().D());
                            this.b.i = -1L;
                        }
                        this.b.j = System.currentTimeMillis() - currentTimeMillis;
                        return;
                    }
                    if (this.b.g != null) {
                        FrsLoadMoreModel frsLoadMoreModel = this.b.m;
                        if (i == 3) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        ArrayList<wn> G2 = frsLoadMoreModel.G(false, z2, true, this.b.g.getThreadList(), null, this.b.g.adMixFloor, this.b.g.adShowSelect);
                        if (G2 != null && G2.size() > 0) {
                            this.b.g.setThreadList(G2);
                        }
                    }
                    this.b.k2();
                    ur6 ur6Var = this.b.n;
                    if (ur6Var != null) {
                        ur6Var.Q();
                    }
                }
                if (this.b.i > -1) {
                    long currentTimeMillis3 = System.currentTimeMillis();
                    FrsNewAreaFragment frsNewAreaFragment10 = this.b;
                    long E2 = frsNewAreaFragment10.a2().E();
                    FrsNewAreaFragment frsNewAreaFragment11 = this.b;
                    TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis3 - frsNewAreaFragment10.i, E2 - frsNewAreaFragment11.i, frsNewAreaFragment11.a2().G(), this.b.a2().F(), currentTimeMillis3 - this.b.a2().D());
                    this.b.i = -1L;
                }
                this.b.j = System.currentTimeMillis() - currentTimeMillis;
                System.gc();
            }
        }
    }

    /* loaded from: classes4.dex */
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
            ur6 ur6Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (ur6Var = this.a.n) != null) {
                ur6Var.R();
            }
        }
    }

    /* loaded from: classes4.dex */
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
                yp8.o(this.a.b);
            }
        }
    }

    /* loaded from: classes4.dex */
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
                    s36.b().e(true);
                    cn8.g().h(this.c.getUniqueId(), true);
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
                this.a = 0;
                this.b = 0;
                if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                    BdRecyclerView bdRecyclerView = (BdRecyclerView) recyclerView;
                    this.a = bdRecyclerView.getFirstVisiblePosition();
                    this.b = bdRecyclerView.getLastVisiblePosition();
                }
                this.c.v += i2;
                if (this.c.v >= this.c.u * 2 && i2 < 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, Boolean.TRUE));
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

    @Override // com.baidu.tieba.oo5
    public void o0(int i2, no5 no5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048619, this, i2, no5Var) == null) {
            this.t.put(i2, no5Var);
        }
    }

    public static /* synthetic */ int v1(FrsNewAreaFragment frsNewAreaFragment) {
        int i2 = frsNewAreaFragment.e;
        frsNewAreaFragment.e = i2 - 1;
        return i2;
    }

    @Override // com.baidu.tieba.oo5
    public no5 P0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            return this.t.get(i2);
        }
        return (no5) invokeI.objValue;
    }

    public void S1(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, threadData) != null) || threadData == null) {
            return;
        }
        this.l.z(threadData);
    }

    public final void f2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.q = true;
            s2();
            b2();
            if (!z) {
                b2();
                q2();
            }
            FrsNewAreaModelController frsNewAreaModelController = this.l;
            if (frsNewAreaModelController != null) {
                frsNewAreaModelController.loadData();
            }
        }
    }

    public void g2(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048605, this, frsViewData) != null) || frsViewData == null) {
            return;
        }
        this.g = frsViewData;
        hideLoadingView(this.n.o());
        ur6 ur6Var = this.n;
        if (ur6Var != null) {
            ur6Var.F(false);
            this.n.M(null, this.e, this.g, this.o);
        }
    }

    public void m2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            this.d = i2;
        }
    }

    public void n2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            this.b = str;
        }
    }

    public void o2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i2) == null) {
            this.e = i2;
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void onFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, str) == null) {
            p2();
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, str) == null) {
            this.c = str;
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public ng<TbImageView> H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (getBaseFragmentActivity() instanceof FrsActivity) {
                return ((FrsActivity) getBaseFragmentActivity()).H();
            }
            return null;
        }
        return (ng) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nr6
    public FrsViewData O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.g;
        }
        return (FrsViewData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public ng<TbImageView> S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (getBaseFragmentActivity() instanceof FrsActivity) {
                return ((FrsActivity) getBaseFragmentActivity()).S();
            }
            return null;
        }
        return (ng) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sf8
    public String U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public ur6 W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.n;
        }
        return (ur6) invokeV.objValue;
    }

    public BdTypeRecyclerView X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            ur6 ur6Var = this.n;
            if (ur6Var == null) {
                return null;
            }
            return ur6Var.n();
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public FrsLoadMoreModel Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.m;
        }
        return (FrsLoadMoreModel) invokeV.objValue;
    }

    public FrsNewAreaModelController a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.l;
        }
        return (FrsNewAreaModelController) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sf8
    public int b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public final void b2() {
        ur6 ur6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (ur6Var = this.n) != null) {
            ur6Var.G(true);
            this.n.L(true);
            y95 y95Var = this.s;
            if (y95Var != null && y95Var.isViewAttached()) {
                this.s.dettachView(this.n.o());
            }
        }
    }

    @Override // com.baidu.tieba.nr6, com.baidu.tieba.fk6
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public final void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            registerListener(2001118, this.E);
        }
    }

    @Override // com.baidu.tieba.dk6
    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            cn8.g().h(getUniqueId(), false);
        }
    }

    public final void e2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (this.d != 0) {
                this.d = 1;
            }
            this.n.J(this.F);
            this.n.K(this.D);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.nr6
    public /* bridge */ /* synthetic */ r9 getPageContext() {
        return super.getPageContext();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            TbPageTag tbPageTag = super.getTbPageTag();
            FrsViewData frsViewData = this.g;
            if (frsViewData != null) {
                i2 = frsViewData.getSortType();
            } else {
                i2 = -1;
            }
            tbPageTag.sortType = bv6.g(i2);
            tbPageTag.locatePage = "a071";
            return tbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    public final void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            if (this.d == 1) {
                ch.a().b(new j(this));
            }
            this.d = 0;
        }
    }

    @Override // com.baidu.tieba.sf8
    public void l0() {
        FrsNewAreaModelController frsNewAreaModelController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && (frsNewAreaModelController = this.l) != null) {
            frsNewAreaModelController.R();
        }
    }

    public void l2() {
        ur6 ur6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048613, this) == null) && (ur6Var = this.n) != null && ur6Var.n() != null) {
            this.n.n().post(new a(this));
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.n.G(true);
            hideLoadingView(this.n.o());
        }
    }

    @Override // com.baidu.tieba.bk6
    public void n1() {
        ur6 ur6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048616, this) == null) && (ur6Var = this.n) != null && ur6Var.n() != null) {
            this.n.n().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.sf8
    public TbPageContext<?> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return getPageContext();
        }
        return (TbPageContext) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public ao onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            if (X1() == null) {
                return null;
            }
            return X1().getPreLoadHandle();
        }
        return (ao) invokeV.objValue;
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
                f2(false);
            } else {
                r2(null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            V1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048630, this) != null) || !BdNetTypeUtil.isNetWorkAvailable()) {
            return;
        }
        f2(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            super.onPause();
            VoiceManager s0 = s0();
            this.h = s0;
            s0.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            super.onResume();
            ur6 ur6Var = this.n;
            if (ur6Var != null) {
                ur6Var.s();
            }
            VoiceManager s0 = s0();
            this.h = s0;
            s0.onResume(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            super.onStart();
            VoiceManager s0 = s0();
            this.h = s0;
            s0.onStart(getPageContext());
        }
    }

    public final void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            this.n.G(false);
            showLoadingView(this.n.o(), true, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070288));
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            if (this.h == null) {
                this.h = VoiceManager.instance();
            }
            return this.h;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public void s2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            VoiceManager s0 = s0();
            this.h = s0;
            s0.stopPlay();
        }
    }

    @Override // com.baidu.tieba.bk6
    public void x() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048647, this) == null) && this.n != null) {
            n1();
            this.n.R();
        }
    }

    public final void T1(List<String> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        ArrayList<wn> threadList = this.g.getThreadList();
        if (!ListUtils.isEmpty(threadList) && this.n.n() != null && this.n.n().getData() != null) {
            Iterator<wn> it = threadList.iterator();
            List<wn> data = this.n.n().getData();
            int i2 = 0;
            while (it.hasNext()) {
                wn next = it.next();
                if (next instanceof vu4) {
                    ThreadData threadData = ((vu4) next).t;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= list.size()) {
                            break;
                        } else if (StringHelper.equals(list.get(i3), threadData.getId())) {
                            it.remove();
                            data.remove(next);
                            this.m.O(next);
                            this.n.n().getAdapter().notifyItemRemoved(i2);
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
                i2++;
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void g(ArrayList<wn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, arrayList) == null) {
            p2();
            if (hq5.k().l(AbsDataRecorder.Scene.FRS_NEW)) {
                hq5.k().g(AbsDataRecorder.Scene.FRS_NEW).b();
            }
            if (zq5.i().o(AbsDataRecorder.Scene.FRS_NEW)) {
                zq5.i().g(AbsDataRecorder.Scene.FRS_NEW).b();
            }
            if (arrayList != null && arrayList.size() != 0) {
                FrsLoadMoreModel frsLoadMoreModel = this.m;
                FrsViewData frsViewData = this.g;
                ArrayList<wn> G = frsLoadMoreModel.G(false, false, false, arrayList, null, frsViewData.adMixFloor, frsViewData.adShowSelect);
                if (G != null) {
                    this.g.setThreadList(G);
                    this.n.M(G, this.e, this.g, 0);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.g.getForum()));
            }
        }
    }

    @Override // com.baidu.tieba.dk6
    public void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (getPageContext() != null) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            }
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                xp5.c().f("page_frs_good");
                f2(true);
                return;
            }
            this.n.F(false);
        }
    }

    public final void V1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
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
                    zg.a().post(this.y);
                }
                ur6 ur6Var = this.n;
                if (ur6Var != null) {
                    ur6Var.Q();
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            if (!xi.F()) {
                this.n.p();
            } else if (this.n.C()) {
            } else {
                if (!this.l.H()) {
                    this.n.p();
                    return;
                }
                p2();
                b();
            }
        }
    }

    public final void U1(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, responsedMessage) != null) || this.g == null || this.n == null || !(responsedMessage instanceof DownloadMessage) || (data = ((DownloadMessage) responsedMessage).getData()) == null) {
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

    public final void d2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bundle) == null) {
            c2();
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

    public final void u2(int i2) {
        ArrayList<wn> threadList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048646, this, i2) == null) && (threadList = this.g.getThreadList()) != null) {
            Iterator<wn> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                wn next = it.next();
                if (next instanceof vu4) {
                    ThreadData threadData = ((vu4) next).t;
                    if (threadData.getId() != null && threadData.getId().equals(this.a)) {
                        t2(threadData, i2);
                        this.a = null;
                        break;
                    }
                }
            }
            this.n.m().q(threadList, this.g);
            this.n.m().l();
        }
    }

    public void b() {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && !this.m.isLoading && !this.l.J()) {
            if (this.m.D(this.g.getThreadListIds())) {
                if (this.l.C() != null) {
                    str = ze8.e(this.l.C().getThreadList(), false);
                } else {
                    str = "";
                }
                this.n.M(this.m.Q(), this.e, this.g, 0);
                this.m.R(wg.g(this.f, 0L), this.g.getThreadListIds(), this.b, this.e, this.g.isBrandForum, str);
            } else if (this.o != 0) {
                this.n.M(this.m.Q(), this.e, this.g, 0);
                int i2 = this.e + 1;
                this.e = i2;
                this.l.K(i2);
                FrsLoadMoreModel frsLoadMoreModel = this.m;
                frsLoadMoreModel.loadingDone = false;
                frsLoadMoreModel.loadIndex = 0;
            }
        }
    }

    public void h2(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, list) == null) {
            T1(list);
            int i2 = 0;
            for (wn wnVar : this.g.getThreadList()) {
                if (wnVar instanceof vu4) {
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
            ur6 ur6Var = this.n;
            if (ur6Var != null) {
                ur6Var.v(i2);
                this.n.Q();
            }
            y95 y95Var = this.s;
            if (y95Var != null && y95Var.isViewAttached()) {
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
            this.l.M(bundle);
            VoiceManager s0 = s0();
            this.h = s0;
            if (s0 != null) {
                s0.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    public final void j2() {
        ur6 ur6Var;
        HashMap<Integer, ThreadData> h2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && (ur6Var = this.n) != null && ur6Var.m() != null && (h2 = this.n.m().h()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, ThreadData> entry : h2.entrySet()) {
                ThreadData value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            x55.q().u(arrayList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            ur6 ur6Var = this.n;
            if (ur6Var != null) {
                ur6Var.w();
            }
            MessageManager.getInstance().unRegisterListener(this.x);
            cn8.g().k(getUniqueId());
            s36.b().e(false);
            super.onDestroy();
            this.l.L();
            VoiceManager s0 = s0();
            this.h = s0;
            s0.onDestory(getPageContext());
            zg.a().removeCallbacks(this.y);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            super.onStop();
            s36.b().e(false);
            cn8.g().h(getUniqueId(), false);
            FrsViewData frsViewData = this.g;
            if (frsViewData != null && frsViewData.getForum() != null) {
                u55.j().x(getPageContext().getPageActivity(), "frs", this.g.getForum().getId(), 0L);
            }
            VoiceManager s0 = s0();
            this.h = s0;
            if (s0 != null) {
                s0.onStop(getPageContext());
            }
        }
    }

    public final void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            if (this.o == 0 && !this.m.D(this.g.getThreadListIds())) {
                if (this.g.getThreadList() != null && this.g.getThreadList().size() != 0) {
                    this.n.P();
                    return;
                } else {
                    this.n.p();
                    return;
                }
            }
            this.n.O();
        }
    }

    public final void k2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            s2();
            try {
                if (this.g == null) {
                    return;
                }
                this.n.D();
                this.n.N();
                this.b = this.g.getForum().getName();
                this.f = this.g.getForum().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.g.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(this.g.getUserData().getDynamicUrl());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.g.getUserData().getBimg_end_time());
                i2();
                ArrayList<wn> threadList = this.g.getThreadList();
                if (threadList != null) {
                    this.n.M(threadList, this.e, this.g, this.g.getPage().b());
                    j2();
                    this.n.E();
                    if (this.g.getIsNewUrl() == 1) {
                        this.n.m().r(true);
                    } else {
                        this.n.m().r(false);
                    }
                    this.n.H(Y1(a2().getType(), this.e));
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
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
                        f2(false);
                    } else if (intExtra == 0) {
                        this.g.removeThreadData(threadDataById);
                        ArrayList<wn> threadList = this.g.getThreadList();
                        if (threadList != null && threadList.size() <= 0) {
                            threadList.add(new cj6());
                        }
                        this.n.E();
                    }
                }
            }
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
            cn8.g().i(getUniqueId());
            FrsNewAreaModelController frsNewAreaModelController = new FrsNewAreaModelController(this);
            this.l = frsNewAreaModelController;
            if (arguments != null) {
                frsNewAreaModelController.I(arguments);
            } else if (bundle != null) {
                frsNewAreaModelController.I(bundle);
            } else {
                frsNewAreaModelController.I(null);
            }
            VoiceManager s0 = s0();
            this.h = s0;
            s0.onCreate(getPageContext());
            d2(bundle);
            registerListener(this.C);
            registerListener(this.z);
            registerListener(this.A);
            registerListener(this.x);
            FrsLoadMoreModel frsLoadMoreModel = new FrsLoadMoreModel(this, null);
            this.m = frsLoadMoreModel;
            frsLoadMoreModel.registerListener();
            this.m.W(3);
            this.m.U(true);
            this.m.T(tw6.a(this.w));
            System.currentTimeMillis();
            this.u = UtilHelper.getScreenHeight(getActivity());
        }
    }

    public final void r2(hn8 hn8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, hn8Var) == null) {
            this.n.G(false);
            this.n.L(false);
            this.n.p();
            this.n.n().getData().clear();
            this.n.s();
            if (this.s == null) {
                y95 y95Var = new y95(getPageContext().getContext(), getNetRefreshListener());
                this.s = y95Var;
                y95Var.e(null);
                this.s.c(null);
                this.s.f();
                this.s.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            if (hn8Var != null) {
                this.s.d(getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c7e, hn8Var.d, Integer.valueOf(hn8Var.c)));
            } else {
                this.s.d(null);
            }
            this.s.onChangeSkinType();
            this.s.attachView(this.n.o(), true);
            this.s.a(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048624, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0312, (ViewGroup) null);
            this.n = new ur6(this, inflate);
            e2();
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
                showToast(R.string.obfuscated_res_0x7f0f1394);
            }
            ArrayMap<String, Boolean> transformPermissionResult = PermissionUtil.transformPermissionResult(strArr, iArr);
            if (transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(R.string.obfuscated_res_0x7f0f10eb);
            }
        }
    }

    public final void t2(ThreadData threadData, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048645, this, threadData, i2) == null) {
            if (i2 == 1) {
                PraiseData praise = threadData.getPraise();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (praise == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i2);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        threadData.setPraise(praiseData);
                        return;
                    }
                    threadData.getPraise().getUser().add(0, metaData);
                    threadData.getPraise().setNum(threadData.getPraise().getNum() + 1);
                    threadData.getPraise().setIsLike(i2);
                }
            } else if (threadData.getPraise() != null) {
                threadData.getPraise().setIsLike(i2);
                threadData.getPraise().setNum(threadData.getPraise().getNum() - 1);
                ArrayList<MetaData> user = threadData.getPraise().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            threadData.getPraise().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }
}
