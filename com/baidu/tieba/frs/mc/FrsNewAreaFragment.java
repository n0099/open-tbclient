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
import com.baidu.tieba.aba;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.aea;
import com.baidu.tieba.by7;
import com.baidu.tieba.c76;
import com.baidu.tieba.ch;
import com.baidu.tieba.co;
import com.baidu.tieba.dr7;
import com.baidu.tieba.ew7;
import com.baidu.tieba.fba;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.g56;
import com.baidu.tieba.gi7;
import com.baidu.tieba.gj7;
import com.baidu.tieba.h56;
import com.baidu.tieba.hj7;
import com.baidu.tieba.ht7;
import com.baidu.tieba.i56;
import com.baidu.tieba.ij7;
import com.baidu.tieba.io;
import com.baidu.tieba.it7;
import com.baidu.tieba.kr7;
import com.baidu.tieba.kt7;
import com.baidu.tieba.l9;
import com.baidu.tieba.nba;
import com.baidu.tieba.ng;
import com.baidu.tieba.np6;
import com.baidu.tieba.pi5;
import com.baidu.tieba.pv7;
import com.baidu.tieba.qy9;
import com.baidu.tieba.r66;
import com.baidu.tieba.rm7;
import com.baidu.tieba.si5;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.uba;
import com.baidu.tieba.v76;
import com.baidu.tieba.wg;
import com.baidu.tieba.wu7;
import com.baidu.tieba.xda;
import com.baidu.tieba.xx9;
import com.baidu.tieba.yi;
import com.baidu.tieba.yn;
import com.baidu.tieba.yn5;
import com.baidu.tieba.z45;
import com.baidu.tieba.zg;
import com.baidu.tieba.zu6;
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
public class FrsNewAreaFragment extends BaseFragment implements VoiceManager.j, dr7, UserIconBox.c, BdListView.p, FrsCommonImageLayout.e, gj7, ActivityCompat.OnRequestPermissionsResultCallback, qy9, hj7, i56, ij7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener A;
    public final uba B;
    public final CustomMessageListener C;
    public final RecyclerView.OnScrollListener D;
    public final CustomMessageListener E;
    public io F;
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
    public kr7 n;
    public int o;
    public int p;
    public boolean q;
    public boolean r;
    public yn5 s;
    public SparseArray<h56> t;
    public int u;
    public int v;
    public boolean w;
    public CustomMessageListener x;
    public Runnable y;
    public CustomMessageListener z;

    @Override // com.baidu.tieba.i56
    public void S(g56 g56Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, g56Var) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i f1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tieba.hj7
    public NavigationBar n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return null;
        }
        return (NavigationBar) invokeV.objValue;
    }

    public final int p2(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048630, this, i2, i3)) == null) {
            if (i2 != 1) {
                return (i2 != 2 || i3 == 1) ? 0 : 3;
            }
            return 3;
        }
        return invokeII.intValue;
    }

    @Override // com.baidu.tieba.gj7
    public void q0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class c implements io {
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

        @Override // com.baidu.tieba.io
        public void b(View view2, yn ynVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ynVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && bdUniqueId != null && ynVar != null && (ynVar instanceof z45)) {
                ThreadData threadData = ((z45) ynVar).t;
                if (threadData.getAnchorInfoData() != null && threadData.getAnchorInfoData().getGroup_id() != 0 && !ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                    return;
                }
                if (threadData.getActInfoType() == 1 && !ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                    return;
                }
                aea readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                if (readThreadHistory != null && !readThreadHistory.d(threadData.getId())) {
                    readThreadHistory.a(threadData.getId());
                    kr7 kr7Var = this.a.n;
                    if (kr7Var != null) {
                        kr7Var.s();
                    }
                }
                String ad_url = threadData.getAd_url();
                boolean z2 = false;
                if (ad_url != null && !ad_url.equals("")) {
                    zu6.a(new a(this, ad_url), "requestAdFrsNewArea", 3);
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
                    it7 it7Var = new it7();
                    if (this.a.g.needLog == 1) {
                        z2 = true;
                    }
                    it7Var.a = z2;
                    it7Var.c = this.a.g.getForum().getId();
                    it7Var.d = this.a.g.getForum().getName();
                    it7Var.b = this.a.l.X();
                    it7 it7Var2 = kt7.q0;
                    if (it7Var2 != null) {
                        it7Var.e = it7Var2.e;
                        it7Var.f = it7Var2.f;
                    }
                    ht7.e(threadData, 1, this.a.getUniqueId(), it7Var, this.a.getTbPageTag());
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
            kr7 kr7Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (kr7Var = this.a.n) != null && kr7Var.n() != null && !this.a.n.n().isComputingLayout()) {
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
            this.a.l2(customResponsedMessage);
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
                    this.a.I2(null);
                } else {
                    this.a.w2(false);
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
                this.a.L2(threadData.getPraise().getIsLike());
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
                if (this.a.o2() != null) {
                    this.a.o2().setSelection(0);
                }
                if (this.a.s == null || !this.a.s.isViewAttached()) {
                    kr7 kr7Var = this.a.n;
                    if (kr7Var != null) {
                        kr7Var.P();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                        return;
                    }
                    return;
                }
                this.a.w2(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements uba {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public final /* synthetic */ FrsNewAreaFragment b;

        @Override // com.baidu.tieba.uba
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.baidu.tieba.uba
        public void c(nba nbaVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nbaVar) == null) {
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

        @Override // com.baidu.tieba.uba
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

        @Override // com.baidu.tieba.uba
        public void d(int i, boolean z, fba fbaVar) {
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), fbaVar}) == null) {
                if (this.b.r) {
                    if (this.b.r2().Y() == null) {
                        this.b.r = false;
                        return;
                    } else if (this.b.r2().Y().getThreadList().size() >= 10) {
                        this.b.r = false;
                        wu7 wu7Var = new wu7();
                        wu7Var.b = 301;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384, wu7Var));
                        return;
                    }
                }
                if (fbaVar == null) {
                    this.a = 1L;
                } else if (fbaVar.b) {
                    this.a = 0L;
                } else {
                    this.a = 1L;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (i == 3) {
                    this.b.m.o0();
                }
                this.b.n.D(false);
                if (this.b.r2().Y() != null) {
                    FrsNewAreaFragment frsNewAreaFragment = this.b;
                    frsNewAreaFragment.g = frsNewAreaFragment.r2().Y();
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
                    ArrayList<yn> c0 = this.b.m.c0(false, false, false, this.b.g.getThreadList(), null, this.b.g.adMixFloor, this.b.g.adShowSelect);
                    if (c0 != null) {
                        this.b.g.setThreadList(c0);
                        FrsNewAreaFragment frsNewAreaFragment3 = this.b;
                        frsNewAreaFragment3.n.K(c0, frsNewAreaFragment3.e, this.b.g, this.b.o);
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
                    this.b.s2();
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
                    if (this.b.g != null && this.b.g.getThreadList() != null && this.b.g.getThreadList().size() == 0 && this.b.r2().getType() == 4) {
                        FrsNewAreaFragment frsNewAreaFragment7 = this.b;
                        frsNewAreaFragment7.showToast(frsNewAreaFragment7.getPageContext().getString(R.string.no_more_to_load));
                        if (this.b.e > 1) {
                            FrsNewAreaFragment.M1(this.b);
                        }
                        if (this.b.i > -1) {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            FrsNewAreaFragment frsNewAreaFragment8 = this.b;
                            long a0 = frsNewAreaFragment8.r2().a0();
                            FrsNewAreaFragment frsNewAreaFragment9 = this.b;
                            TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis2 - frsNewAreaFragment8.i, a0 - frsNewAreaFragment9.i, frsNewAreaFragment9.r2().c0(), this.b.r2().b0(), currentTimeMillis2 - this.b.r2().Z());
                            this.b.i = -1L;
                        }
                        this.b.j = System.currentTimeMillis() - currentTimeMillis;
                        return;
                    }
                    if (this.b.g != null) {
                        ArrayList<yn> arrayList = new ArrayList<>();
                        if (!ListUtils.isEmpty(this.b.g.getThreadList())) {
                            arrayList.addAll(this.b.g.getThreadList());
                            if (i == 3 && pv7.a(this.b.f) && this.b.g.frsForumGroup != null && this.b.g.frsForumGroup.feed_card != null && !ListUtils.isEmpty(this.b.g.frsForumGroup.feed_card.group_list) && this.b.g.frsForumGroup.feed_card.index.intValue() >= 0 && this.b.g.frsForumGroup.feed_card.index.intValue() <= arrayList.size()) {
                                rm7.f(this.b.g.frsForumGroup, arrayList, this.b.f);
                            }
                        }
                        FrsLoadMoreModel frsLoadMoreModel = this.b.m;
                        if (i == 3) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        ArrayList<yn> c02 = frsLoadMoreModel.c0(false, z2, true, arrayList, null, this.b.g.adMixFloor, this.b.g.adShowSelect);
                        if (c02 != null && c02.size() > 0) {
                            this.b.g.setThreadList(c02);
                        }
                    }
                    this.b.B2();
                    kr7 kr7Var = this.b.n;
                    if (kr7Var != null) {
                        kr7Var.O();
                    }
                } else {
                    this.b.I2(fbaVar);
                }
                if (this.b.i > -1) {
                    long currentTimeMillis3 = System.currentTimeMillis();
                    FrsNewAreaFragment frsNewAreaFragment10 = this.b;
                    long a02 = frsNewAreaFragment10.r2().a0();
                    FrsNewAreaFragment frsNewAreaFragment11 = this.b;
                    TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis3 - frsNewAreaFragment10.i, a02 - frsNewAreaFragment11.i, frsNewAreaFragment11.r2().c0(), this.b.r2().b0(), currentTimeMillis3 - this.b.r2().Z());
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
            kr7 kr7Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (kr7Var = this.a.n) != null) {
                kr7Var.P();
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
                xda.o(this.a.b);
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
                    np6.b().e(true);
                    aba.g().h(this.c.getUniqueId(), true);
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
                this.c.v += i2;
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

    public static /* synthetic */ int M1(FrsNewAreaFragment frsNewAreaFragment) {
        int i2 = frsNewAreaFragment.e;
        frsNewAreaFragment.e = i2 - 1;
        return i2;
    }

    public void D2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.d = i2;
        }
    }

    public void E2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.b = str;
        }
    }

    public void F2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.e = i2;
        }
    }

    @Override // com.baidu.tieba.i56
    public h56 d1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
            return this.t.get(i2);
        }
        return (h56) invokeI.objValue;
    }

    public void j2(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048602, this, threadData) != null) || threadData == null) {
            return;
        }
        this.l.V(threadData);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void onFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            G2();
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, str) == null) {
            this.c = str;
        }
    }

    public final void w2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048643, this, z) == null) {
            this.q = true;
            J2();
            s2();
            if (!z) {
                s2();
                H2();
            }
            FrsNewAreaModelController frsNewAreaModelController = this.l;
            if (frsNewAreaModelController != null) {
                frsNewAreaModelController.loadData();
            }
        }
    }

    public void x2(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048644, this, frsViewData) != null) || frsViewData == null) {
            return;
        }
        this.g = frsViewData;
        hideLoadingView(this.n.o());
        kr7 kr7Var = this.n;
        if (kr7Var != null) {
            kr7Var.D(false);
            this.n.K(null, this.e, this.g, this.o);
        }
    }

    @Override // com.baidu.tieba.i56
    public void A0(int i2, h56 h56Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, h56Var) == null) {
            this.t.put(i2, h56Var);
        }
    }

    public final void A2() {
        kr7 kr7Var;
        HashMap<Integer, ThreadData> h2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (kr7Var = this.n) != null && kr7Var.m() != null && (h2 = this.n.m().h()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, ThreadData> entry : h2.entrySet()) {
                ThreadData value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            si5.q().u(arrayList);
        }
    }

    public final void G2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.o == 0 && !this.m.Z(this.g.getThreadListIds())) {
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
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            kr7 kr7Var = this.n;
            if (kr7Var != null) {
                kr7Var.w();
                this.n.I(null);
            }
            MessageManager.getInstance().unRegisterListener(this.x);
            aba.g().k(getUniqueId());
            np6.b().e(false);
            super.onDestroy();
            this.l.h0();
            VoiceManager y0 = y0();
            this.h = y0;
            y0.onDestory(getPageContext());
            zg.a().removeCallbacks(this.y);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            super.onStop();
            np6.b().e(false);
            aba.g().h(getUniqueId(), false);
            FrsViewData frsViewData = this.g;
            if (frsViewData != null && frsViewData.getForum() != null) {
                pi5.j().x(getPageContext().getPageActivity(), "frs", this.g.getForum().getId(), 0L);
            }
            VoiceManager y0 = y0();
            this.h = y0;
            if (y0 != null) {
                y0.onStop(getPageContext());
            }
        }
    }

    public final void B2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            J2();
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
                z2();
                ArrayList<yn> threadList = this.g.getThreadList();
                if (threadList != null) {
                    this.n.K(threadList, this.e, this.g, this.g.getPage().b());
                    A2();
                    this.n.s();
                    if (this.g.getIsNewUrl() == 1) {
                        this.n.m().q(true);
                    } else {
                        this.n.m().q(false);
                    }
                    this.n.F(p2(r2().getType(), this.e));
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void C2() {
        kr7 kr7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (kr7Var = this.n) != null && kr7Var.n() != null) {
            this.n.n().post(new a(this));
        }
    }

    @Override // com.baidu.tieba.gj7
    public void D1() {
        kr7 kr7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (kr7Var = this.n) != null && kr7Var.n() != null) {
            this.n.n().scrollToPosition(0);
        }
    }

    public final void H2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.n.E(false);
            showLoadingView(this.n.o(), true, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703a6));
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public ng<TbImageView> I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (getBaseFragmentActivity() instanceof FrsActivity) {
                return ((FrsActivity) getBaseFragmentActivity()).I();
            }
            return null;
        }
        return (ng) invokeV.objValue;
    }

    public void J2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            VoiceManager y0 = y0();
            this.h = y0;
            y0.stopPlay();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public ng<TbImageView> a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (getBaseFragmentActivity() instanceof FrsActivity) {
                return ((FrsActivity) getBaseFragmentActivity()).a0();
            }
            return null;
        }
        return (ng) invokeV.objValue;
    }

    @Override // com.baidu.tieba.dr7
    public FrsViewData c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.g;
        }
        return (FrsViewData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qy9
    public String d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gj7
    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && this.n != null) {
            D1();
            this.n.P();
        }
    }

    @Override // com.baidu.tieba.dr7
    public /* bridge */ /* synthetic */ l9 getPageContext() {
        return super.getPageContext();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            TbPageTag tbPageTag = super.getTbPageTag();
            FrsViewData frsViewData = this.g;
            if (frsViewData != null) {
                i2 = frsViewData.getSortType();
            } else {
                i2 = -1;
            }
            tbPageTag.sortType = ew7.g(i2);
            tbPageTag.locatePage = "a071";
            return tbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    public final void hideLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.n.E(true);
            hideLoadingView(this.n.o());
        }
    }

    @Override // com.baidu.tieba.ij7
    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            aba.g().h(getUniqueId(), false);
        }
    }

    public kr7 n2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.n;
        }
        return (kr7) invokeV.objValue;
    }

    public BdTypeRecyclerView o2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            kr7 kr7Var = this.n;
            if (kr7Var == null) {
                return null;
            }
            return kr7Var.n();
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public co onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (o2() == null) {
                return null;
            }
            return o2().getPreLoadHandle();
        }
        return (co) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            super.onLazyLoad();
            if (this.q) {
                return;
            }
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                w2(false);
            } else {
                I2(null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            m2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048621, this) != null) || !BdNetTypeUtil.isNetWorkAvailable()) {
            return;
        }
        w2(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            super.onPause();
            VoiceManager y0 = y0();
            this.h = y0;
            y0.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            super.onResume();
            kr7 kr7Var = this.n;
            if (kr7Var != null) {
                kr7Var.s();
            }
            VoiceManager y0 = y0();
            this.h = y0;
            y0.onResume(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            super.onStart();
            VoiceManager y0 = y0();
            this.h = y0;
            y0.onStart(getPageContext());
        }
    }

    public FrsLoadMoreModel q2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.m;
        }
        return (FrsLoadMoreModel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qy9
    public int r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public FrsNewAreaModelController r2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.l;
        }
        return (FrsNewAreaModelController) invokeV.objValue;
    }

    public final void s2() {
        kr7 kr7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048635, this) == null) && (kr7Var = this.n) != null) {
            kr7Var.E(true);
            this.n.J(true);
            yn5 yn5Var = this.s;
            if (yn5Var != null && yn5Var.isViewAttached()) {
                this.s.dettachView(this.n.o());
            }
        }
    }

    @Override // com.baidu.tieba.qy9
    public TbPageContext<?> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return getPageContext();
        }
        return (TbPageContext) invokeV.objValue;
    }

    public final void t2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            registerListener(2001118, this.E);
        }
    }

    @Override // com.baidu.tieba.dr7, com.baidu.tieba.kj7
    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qy9
    public void v0() {
        FrsNewAreaModelController frsNewAreaModelController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048641, this) == null) && (frsNewAreaModelController = this.l) != null) {
            frsNewAreaModelController.n0();
        }
    }

    public final void v2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            if (this.d != 0) {
                this.d = 1;
            }
            this.n.H(this.F);
            this.n.I(this.D);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            if (this.h == null) {
                this.h = VoiceManager.instance();
            }
            return this.h;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public final void z2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            if (this.d == 1) {
                ch.a().b(new j(this));
            }
            this.d = 0;
        }
    }

    public final void I2(fba fbaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, fbaVar) == null) {
            this.n.E(false);
            this.n.J(false);
            this.n.p();
            this.n.n().getData().clear();
            this.n.s();
            if (this.s == null) {
                yn5 yn5Var = new yn5(getPageContext().getContext(), getNetRefreshListener());
                this.s = yn5Var;
                yn5Var.e(null);
                this.s.c(null);
                this.s.f();
                this.s.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            if (fbaVar != null) {
                this.s.d(getPageContext().getResources().getString(R.string.net_error_text, fbaVar.d, Integer.valueOf(fbaVar.c)));
            } else {
                this.s.d(null);
            }
            this.s.onChangeSkinType();
            this.s.attachView(this.n.o(), true);
            this.s.a(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, bundle) == null) {
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
            aba.g().i(getUniqueId());
            FrsNewAreaModelController frsNewAreaModelController = new FrsNewAreaModelController(this);
            this.l = frsNewAreaModelController;
            if (arguments != null) {
                frsNewAreaModelController.e0(arguments);
            } else if (bundle != null) {
                frsNewAreaModelController.e0(bundle);
            } else {
                frsNewAreaModelController.e0(null);
            }
            VoiceManager y0 = y0();
            this.h = y0;
            y0.onCreate(getPageContext());
            u2(bundle);
            registerListener(this.C);
            registerListener(this.z);
            registerListener(this.A);
            registerListener(this.x);
            FrsLoadMoreModel frsLoadMoreModel = new FrsLoadMoreModel(this, null);
            this.m = frsLoadMoreModel;
            frsLoadMoreModel.registerListener();
            this.m.s0(3);
            this.m.q0(true);
            this.m.p0(by7.a(this.w));
            System.currentTimeMillis();
            this.u = UtilHelper.getScreenHeight(getActivity());
        }
    }

    public final void K2(ThreadData threadData, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, threadData, i2) == null) {
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

    public final void L2(int i2) {
        ArrayList<yn> threadList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048590, this, i2) == null) && (threadList = this.g.getThreadList()) != null) {
            Iterator<yn> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                yn next = it.next();
                if (next instanceof z45) {
                    ThreadData threadData = ((z45) next).t;
                    if (threadData.getId() != null && threadData.getId().equals(this.a)) {
                        K2(threadData, i2);
                        this.a = null;
                        break;
                    }
                }
            }
            this.n.m().p(threadList, this.g);
            this.n.m().l();
        }
    }

    public final void l2(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048606, this, responsedMessage) != null) || this.g == null || this.n == null || !(responsedMessage instanceof DownloadMessage) || (data = ((DownloadMessage) responsedMessage).getData()) == null) {
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

    public final void u2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, bundle) == null) {
            t2();
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

    public void b() {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && !this.m.isLoading && !this.l.f0()) {
            if (this.m.Z(this.g.getThreadListIds())) {
                if (this.l.Y() != null) {
                    str = xx9.e(this.l.Y().getThreadList(), false);
                } else {
                    str = "";
                }
                this.n.K(this.m.m0(), this.e, this.g, 0);
                this.m.n0(wg.g(this.f, 0L), this.g.getThreadListIds(), this.b, this.e, this.g.isBrandForum, str);
            } else if (this.o != 0) {
                this.n.K(this.m.m0(), this.e, this.g, 0);
                int i2 = this.e + 1;
                this.e = i2;
                this.l.g0(i2);
                FrsLoadMoreModel frsLoadMoreModel = this.m;
                frsLoadMoreModel.loadingDone = false;
                frsLoadMoreModel.loadIndex = 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void k(ArrayList<yn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, arrayList) == null) {
            G2();
            if (c76.k().l(AbsDataRecorder.Scene.FRS_NEW)) {
                c76.k().g(AbsDataRecorder.Scene.FRS_NEW).b();
            }
            if (v76.i().o(AbsDataRecorder.Scene.FRS_NEW)) {
                v76.i().g(AbsDataRecorder.Scene.FRS_NEW).b();
            }
            if (arrayList != null && arrayList.size() != 0) {
                FrsLoadMoreModel frsLoadMoreModel = this.m;
                FrsViewData frsViewData = this.g;
                ArrayList<yn> c0 = frsLoadMoreModel.c0(false, false, false, arrayList, null, frsViewData.adMixFloor, frsViewData.adShowSelect);
                if (c0 != null) {
                    this.g.setThreadList(c0);
                    this.n.K(c0, this.e, this.g, 0);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.g.getForum()));
            }
        }
    }

    public final void k2(List<String> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048605, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        ArrayList<yn> threadList = this.g.getThreadList();
        if (!ListUtils.isEmpty(threadList) && this.n.n() != null && this.n.n().getData() != null) {
            Iterator<yn> it = threadList.iterator();
            List<yn> data = this.n.n().getData();
            int i2 = 0;
            while (it.hasNext()) {
                yn next = it.next();
                if (next instanceof z45) {
                    ThreadData threadData = ((z45) next).t;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= list.size()) {
                            break;
                        } else if (StringHelper.equals(list.get(i3), threadData.getId())) {
                            it.remove();
                            data.remove(next);
                            this.m.k0(next);
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

    @Override // com.baidu.tieba.ij7
    public void k1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (getPageContext() != null) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            }
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                r66.c().f("page_frs_good");
                w2(true);
                return;
            }
            this.n.D(false);
        }
    }

    public final void m2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                if (this.p == 3) {
                    onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                }
                if (!this.q) {
                    zg.a().post(this.y);
                }
                kr7 kr7Var = this.n;
                if (kr7Var != null) {
                    kr7Var.O();
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            if (!yi.G()) {
                this.n.p();
            } else if (this.n.B()) {
            } else {
                if (!this.l.d0()) {
                    this.n.p();
                    return;
                }
                G2();
                b();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        ThreadData threadDataById;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048612, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1 && i2 == 18003) {
                this.n.m().l();
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra != null && (threadDataById = this.g.getThreadDataById(stringExtra)) != null) {
                    int intExtra = intent.getIntExtra("type", -1);
                    if (intExtra == 2) {
                        threadDataById.setIs_good(intent.getIntExtra("good_data", 0));
                        threadDataById.parser_title();
                        w2(false);
                    } else if (intExtra == 0) {
                        this.g.removeThreadData(threadDataById);
                        ArrayList<yn> threadList = this.g.getThreadList();
                        if (threadList != null && threadList.size() <= 0) {
                            threadList.add(new gi7());
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
        if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
            if (this.p == 3 && this.n == null) {
                return;
            }
            this.p = i2;
            super.onChangeSkinType(i2);
            kr7 kr7Var = this.n;
            if (kr7Var != null) {
                kr7Var.v(i2);
                this.n.O();
            }
            yn5 yn5Var = this.s;
            if (yn5Var != null && yn5Var.isViewAttached()) {
                this.s.onChangeSkinType();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("name", this.b);
            bundle.putString("from", this.c);
            this.l.i0(bundle);
            VoiceManager y0 = y0();
            this.h = y0;
            if (y0 != null) {
                y0.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    public void y2(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, list) == null) {
            k2(list);
            int i2 = 0;
            for (yn ynVar : this.g.getThreadList()) {
                if (ynVar instanceof z45) {
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048615, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d035c, (ViewGroup) null);
            this.n = new kr7(this, inflate);
            v2();
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048624, this, i2, strArr, iArr) == null) && i2 == 1) {
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
