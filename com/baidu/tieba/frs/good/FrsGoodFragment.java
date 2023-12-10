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
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.permissionhelper.app.ActivityCompat;
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
import com.baidu.tieba.bk5;
import com.baidu.tieba.c26;
import com.baidu.tieba.e68;
import com.baidu.tieba.em6;
import com.baidu.tieba.eva;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.gy4;
import com.baidu.tieba.i08;
import com.baidu.tieba.lva;
import com.baidu.tieba.m58;
import com.baidu.tieba.mz4;
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
import com.baidu.tieba.wz7;
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
public class FrsGoodFragment extends BaseFragment implements VoiceManager.j, u18, UserIconBox.c, BdListView.p, FrsCommonImageLayout.e, pt7, ActivityCompat.OnRequestPermissionsResultCallback, sha, qt7, t06, rt7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public CustomMessageListener B;
    public Runnable C;
    public CustomMessageListener D;
    public CustomMessageListener E;
    public final lva F;
    public final CustomMessageListener G;
    public final RecyclerView.OnScrollListener H;
    public final CustomMessageListener I;
    public zi J;
    public CustomMessageListener K;
    public String a;
    public String b;
    public String c;
    public int d;
    public int e;
    public boolean f;
    public String g;
    public FrsViewData h;
    public VoiceManager i;
    public long j;
    public long k;
    public long l;
    public FrsGoodModelController m;
    public FrsLoadMoreModel n;
    public i08 o;
    public int p;
    public int q;
    public int r;
    public boolean s;
    public SparseArray<s06> t;
    public wz7 u;
    public boolean v;
    public bk5 w;
    public String x;
    public int y;
    public int z;

    @Override // com.baidu.tieba.pt7
    public void S0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.IPlayView V1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    public final int j3(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048599, this, i2, i3)) == null) {
            if (i2 != 1) {
                return (i2 != 2 || i3 == 1) ? 0 : 3;
            }
            return 3;
        }
        return invokeII.intValue;
    }

    @Override // com.baidu.tieba.t06
    public void o0(r06 r06Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, r06Var) == null) {
        }
    }

    @Override // com.baidu.tieba.qt7
    public NavigationBar x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return null;
        }
        return (NavigationBar) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class c implements zi {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsGoodFragment a;

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

        public c(FrsGoodFragment frsGoodFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGoodFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsGoodFragment;
        }

        @Override // com.baidu.tieba.zi
        public void b(View view2, pi piVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z;
            String str;
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
                    i08 i08Var = this.a.o;
                    if (i08Var != null) {
                        i08Var.x();
                    }
                }
                String ad_url = threadData.getAd_url();
                boolean z2 = false;
                if (ad_url != null && !ad_url.equals("")) {
                    pr6.a(new a(this, ad_url), "requestAdFrsGood", 3);
                    z = true;
                } else {
                    z = false;
                }
                if (threadData != null) {
                    str = threadData.getTid();
                } else {
                    str = null;
                }
                if (str == null) {
                    str = "";
                }
                if (threadData.getIs_top() == 2 && !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{str, "", null});
                    return;
                }
                if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && str.length() > 3 && str.length() > 3) {
                    threadData.setId(str.substring(3));
                }
                PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.a.getPageContext().getPageActivity()).createFromThreadCfg(threadData, this.a.b, "frs_page", 18003, true, false, z);
                createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
                createFromThreadCfg.setStartFrom(3);
                this.a.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                if (this.a.h != null && this.a.h.getForum() != null) {
                    v38 v38Var = new v38();
                    if (this.a.h.needLog == 1) {
                        z2 = true;
                    }
                    v38Var.a = z2;
                    v38Var.c = this.a.h.getForum().getId();
                    v38Var.d = this.a.h.getForum().getName();
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
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsGoodFragment a;

        public a(FrsGoodFragment frsGoodFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGoodFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsGoodFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) && i == 0) {
                em6.b().e(true);
                qua.g().h(this.a.getUniqueId(), true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                FrsGoodFragment.V2(this.a, i2);
                if (i2 < 0) {
                    MessageManager messageManager = MessageManager.getInstance();
                    if (this.a.z >= this.a.y * 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    messageManager.dispatchResponsedMessage(new CustomResponsedMessage(2921437, Boolean.valueOf(z)));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsGoodFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(FrsGoodFragment frsGoodFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGoodFragment, Integer.valueOf(i)};
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
            this.a = frsGoodFragment;
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2001118) {
                return;
            }
            this.a.h3(customResponsedMessage);
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
        public final /* synthetic */ FrsGoodFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(FrsGoodFragment frsGoodFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGoodFragment, Integer.valueOf(i)};
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
            this.a = frsGoodFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            i08 i08Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (i08Var = this.a.o) != null) {
                i08Var.A();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsGoodFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(FrsGoodFragment frsGoodFragment, int i, boolean z) {
            super(i, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGoodFragment, Integer.valueOf(i), Boolean.valueOf(z)};
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
            this.a = frsGoodFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && this.a.w != null && this.a.w.isViewAttached()) {
                this.a.w.a(num.intValue());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsGoodFragment a;

        public f(FrsGoodFragment frsGoodFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGoodFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsGoodFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!BdNetTypeUtil.isNetWorkAvailable() || this.a.s) {
                    this.a.B3(null);
                } else {
                    this.a.r3(false);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsGoodFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(FrsGoodFragment frsGoodFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGoodFragment, Integer.valueOf(i)};
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
            this.a = frsGoodFragment;
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
                this.a.D3(threadData.getPraise().getIsLike());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsGoodFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(FrsGoodFragment frsGoodFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGoodFragment, Integer.valueOf(i)};
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
            this.a = frsGoodFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 301) {
                if (this.a.i3() != null) {
                    this.a.i3().setSelection(0);
                }
                if (this.a.w == null || !this.a.w.isViewAttached()) {
                    i08 i08Var = this.a.o;
                    if (i08Var != null) {
                        i08Var.b0();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                        return;
                    }
                    return;
                }
                this.a.r3(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements lva {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public final /* synthetic */ FrsGoodFragment b;

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

        public i(FrsGoodFragment frsGoodFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGoodFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = frsGoodFragment;
            this.a = 1L;
        }

        @Override // com.baidu.tieba.lva
        public void a(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || this.b.v) {
                return;
            }
            if (i != 1 && i != 2) {
                if (i == 3) {
                    this.b.o.K(true);
                    return;
                }
                return;
            }
            this.b.o.x();
        }

        @Override // com.baidu.tieba.lva
        public void d(int i, boolean z, wua wuaVar) {
            ArrayList<pi> V;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), wuaVar}) == null) {
                if (this.b.v) {
                    if (this.b.l3().P() == null) {
                        this.b.v = false;
                        return;
                    } else if (this.b.l3().P().getThreadList().size() >= 10) {
                        this.b.v = false;
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
                    this.b.n.h0();
                }
                this.b.o.K(false);
                if (this.b.l3().P() != null) {
                    FrsGoodFragment frsGoodFragment = this.b;
                    frsGoodFragment.h = frsGoodFragment.l3().P();
                }
                FrsGoodFragment frsGoodFragment2 = this.b;
                frsGoodFragment2.p = frsGoodFragment2.h.getPage().b();
                if (this.b.p == 0 && (this.b.h.getThreadListIds() == null || this.b.h.getThreadListIds().size() == 0)) {
                    if (this.b.h.getThreadList() != null && this.b.h.getThreadList().size() != 0) {
                        this.b.o.a0();
                    } else {
                        this.b.o.r();
                    }
                } else if (ListUtils.getCount(this.b.h.getThreadList()) > 3) {
                    this.b.o.Z();
                } else {
                    this.b.o.W();
                }
                if (i == 4) {
                    ArrayList<pi> V2 = this.b.n.V(false, false, false, this.b.h.getThreadList(), null, this.b.h.adMixFloor, this.b.h.adShowSelect);
                    if (V2 != null) {
                        this.b.h.setThreadList(V2);
                        FrsGoodFragment frsGoodFragment3 = this.b;
                        frsGoodFragment3.o.V(V2, frsGoodFragment3.e, this.b.h, this.b.p);
                        return;
                    }
                    return;
                }
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3 && this.b.h.isShowRedTip()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, Boolean.TRUE));
                        }
                    } else {
                        this.b.o.x();
                    }
                } else {
                    this.b.o.x();
                }
                this.b.hideLoadingView();
                if (this.a != 0) {
                    this.b.B3(wuaVar);
                } else {
                    if (this.b.h != null) {
                        FrsGoodFragment frsGoodFragment4 = this.b;
                        frsGoodFragment4.b = frsGoodFragment4.h.getForum().getName();
                        FrsGoodFragment frsGoodFragment5 = this.b;
                        frsGoodFragment5.g = frsGoodFragment5.h.getForum().getId();
                        FrsGoodFragment frsGoodFragment6 = this.b;
                        frsGoodFragment6.o.B(frsGoodFragment6.h.getForum(), this.b.h.getUserData());
                    }
                    if (this.b.h != null) {
                        this.b.h.addNoticeThreadToThreadList();
                    }
                    FrsGoodFragment frsGoodFragment7 = this.b;
                    frsGoodFragment7.o.Q(frsGoodFragment7.h);
                    if (this.b.h != null && this.b.h.getThreadList() != null && this.b.h.getThreadList().size() == 0 && this.b.l3().getType() == 4) {
                        FrsGoodFragment frsGoodFragment8 = this.b;
                        frsGoodFragment8.showToast(frsGoodFragment8.getPageContext().getString(R.string.no_more_to_load));
                        if (this.b.e > 1) {
                            FrsGoodFragment.N2(this.b);
                        }
                        if (this.b.j > -1) {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            FrsGoodFragment frsGoodFragment9 = this.b;
                            long R = frsGoodFragment9.l3().R();
                            FrsGoodFragment frsGoodFragment10 = this.b;
                            TiebaStatic.page("op_frs_enter", currentTimeMillis2 - frsGoodFragment9.j, R - frsGoodFragment10.j, frsGoodFragment10.l3().T(), this.b.l3().S(), currentTimeMillis2 - this.b.l3().Q());
                            this.b.j = -1L;
                        }
                        this.b.k = System.currentTimeMillis() - currentTimeMillis;
                        return;
                    }
                    if (this.b.h != null && (V = this.b.n.V(false, false, true, this.b.h.getThreadList(), null, this.b.h.adMixFloor, this.b.h.adShowSelect)) != null && V.size() > 0) {
                        this.b.h.setThreadList(V);
                    }
                    this.b.u3();
                }
                if (this.b.j > -1) {
                    long currentTimeMillis3 = System.currentTimeMillis();
                    FrsGoodFragment frsGoodFragment11 = this.b;
                    long R2 = frsGoodFragment11.l3().R();
                    FrsGoodFragment frsGoodFragment12 = this.b;
                    TiebaStatic.page("op_frs_enter", currentTimeMillis3 - frsGoodFragment11.j, R2 - frsGoodFragment12.j, frsGoodFragment12.l3().T(), this.b.l3().S(), currentTimeMillis3 - this.b.l3().Q());
                    this.b.j = -1L;
                }
                this.b.k = System.currentTimeMillis() - currentTimeMillis;
                System.gc();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsGoodFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(FrsGoodFragment frsGoodFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGoodFragment, Integer.valueOf(i)};
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
            this.a = frsGoodFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            i08 i08Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (i08Var = this.a.o) != null) {
                i08Var.b0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsGoodFragment a;

        public k(FrsGoodFragment frsGoodFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGoodFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsGoodFragment;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.a.u != null) {
                    this.a.u.b(view2, motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsGoodFragment a;

        public l(FrsGoodFragment frsGoodFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGoodFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsGoodFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                pxa.o(this.a.b);
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
        this.b = null;
        this.c = null;
        this.d = 0;
        this.e = 1;
        this.f = false;
        this.g = null;
        this.h = new FrsViewData();
        this.j = -1L;
        this.l = -1L;
        this.o = null;
        this.p = -1;
        this.q = 0;
        this.r = 3;
        this.s = false;
        this.t = new SparseArray<>();
        this.v = false;
        this.y = 0;
        this.z = 0;
        this.B = new e(this, 2921397, true);
        this.C = new f(this);
        this.D = new g(this, 2004004);
        this.E = new h(this, 2001624);
        this.F = new i(this);
        this.G = new j(this, 2003003);
        this.H = new a(this);
        this.I = new b(this, 0);
        this.J = new c(this);
        this.K = new d(this, 2921414);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            if (!BdUtilHelper.isNetOk()) {
                this.o.r();
            } else if (!this.m.U()) {
                this.o.r();
            } else {
                z3();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
                if (!this.n.isLoading && !this.m.W()) {
                    ArrayList<pi> arrayList = null;
                    if (this.n.S(this.h.getThreadListIds())) {
                        FrsViewData frsViewData = this.h;
                        if (frsViewData != null) {
                            arrayList = frsViewData.getThreadList();
                        }
                        String e2 = zga.e(arrayList, false);
                        this.o.V(this.n.f0(), this.e, this.h, 0);
                        this.n.g0(JavaTypesHelper.toLong(this.g, 0L), this.h.getThreadListIds(), this.b, this.e, this.h.isBrandForum, e2);
                    } else if (this.p != 0) {
                        FrsViewData frsViewData2 = this.h;
                        if (frsViewData2 != null) {
                            arrayList = frsViewData2.getThreadList();
                        }
                        String e3 = zga.e(arrayList, false);
                        this.o.V(this.n.f0(), this.e, this.h, 0);
                        int i2 = this.e + 1;
                        this.e = i2;
                        this.m.Y(i2, e3);
                        FrsLoadMoreModel frsLoadMoreModel = this.n;
                        frsLoadMoreModel.loadingDone = false;
                        frsLoadMoreModel.loadIndex = 0;
                    }
                }
            }
        }
    }

    public static /* synthetic */ int N2(FrsGoodFragment frsGoodFragment) {
        int i2 = frsGoodFragment.e;
        frsGoodFragment.e = i2 - 1;
        return i2;
    }

    @Override // com.baidu.tieba.t06
    public s06 T1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            return this.t.get(i2);
        }
        return (s06) invokeI.objValue;
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void onFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            z3();
        }
    }

    public void q3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048628, this, i2) == null) {
            this.q = i2;
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                r3(false);
            } else {
                B3(null);
            }
        }
    }

    public final void r3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
            this.s = true;
            C3();
            m3();
            if (!z) {
                m3();
                A3();
            }
            FrsGoodModelController frsGoodModelController = this.m;
            if (frsGoodModelController != null) {
                frsGoodModelController.X(this.q);
            }
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, str) == null) {
            this.c = str;
        }
    }

    public void w3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048636, this, i2) == null) {
            this.d = i2;
        }
    }

    public void x3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, str) == null) {
            this.b = str;
        }
    }

    public void y3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048640, this, i2) == null) {
            this.e = i2;
        }
    }

    public static /* synthetic */ int V2(FrsGoodFragment frsGoodFragment, int i2) {
        int i3 = frsGoodFragment.z + i2;
        frsGoodFragment.z = i3;
        return i3;
    }

    @Override // com.baidu.tieba.t06
    public void f1(int i2, s06 s06Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048592, this, i2, s06Var) == null) {
            this.t.put(i2, s06Var);
        }
    }

    public final void A3() {
        i08 i08Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (i08Var = this.o) == null) {
            return;
        }
        i08Var.L(false);
        showLoadingView(this.o.p(), true, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703a7));
    }

    @Override // com.baidu.tieba.sha
    public String C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public void C3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            VoiceManager d1 = d1();
            this.i = d1;
            d1.stopPlay();
        }
    }

    @Override // com.baidu.tieba.pt7
    public void F() {
        i08 i08Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (i08Var = this.o) != null && i08Var.o() != null) {
            this.o.o().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.sha
    public TbPageContext<?> I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return getPageContext();
        }
        return (TbPageContext) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rt7
    public void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            qua.g().h(getUniqueId(), false);
        }
    }

    @Override // com.baidu.tieba.u18
    public FrsViewData Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.h;
        }
        return (FrsViewData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sha
    public void Z0() {
        FrsGoodModelController frsGoodModelController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (frsGoodModelController = this.m) != null) {
            frsGoodModelController.e0();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public pb<TbImageView> c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.i == null) {
                this.i = VoiceManager.instance();
            }
            return this.i;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            TbPageTag tbPageTag = super.getTbPageTag();
            FrsViewData frsViewData = this.h;
            if (frsViewData != null) {
                i2 = frsViewData.getSortType();
            } else {
                i2 = -1;
            }
            tbPageTag.sortType = z68.g(i2);
            tbPageTag.locatePage = "a072";
            return tbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    public final void hideLoadingView() {
        i08 i08Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048597, this) != null) || (i08Var = this.o) == null) {
            return;
        }
        i08Var.L(true);
        hideLoadingView(this.o.p());
    }

    public BdTypeRecyclerView i3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            i08 i08Var = this.o;
            if (i08Var == null) {
                return null;
            }
            return i08Var.o();
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public FrsLoadMoreModel k3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.n;
        }
        return (FrsLoadMoreModel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pt7
    public void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && this.o != null) {
            F();
            this.o.b0();
        }
    }

    public FrsGoodModelController l3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.m;
        }
        return (FrsGoodModelController) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sha
    public int m2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public final void n3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            registerListener(2001118, this.I);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public ti onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (i3() == null) {
                return null;
            }
            return i3().getPreLoadHandle();
        }
        return (ti) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            super.onLazyLoad();
            if (this.s) {
                return;
            }
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                r3(false);
            } else {
                B3(null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048617, this) != null) || !BdNetTypeUtil.isNetWorkAvailable()) {
            return;
        }
        r3(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            super.onPause();
            VoiceManager d1 = d1();
            this.i = d1;
            d1.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            super.onResume();
            i08 i08Var = this.o;
            if (i08Var != null) {
                i08Var.x();
            }
            VoiceManager d1 = d1();
            this.i = d1;
            d1.onResume(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            super.onStart();
            VoiceManager d1 = d1();
            this.i = d1;
            d1.onStart(getPageContext());
        }
    }

    public final void s3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            if (this.d == 1) {
                zb.a().b(new l(this));
            }
            this.d = 0;
        }
    }

    @Override // com.baidu.tieba.u18, com.baidu.tieba.tt7
    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public void v3() {
        i08 i08Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048635, this) == null) && (i08Var = this.o) != null) {
            i08Var.C();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public pb<TbImageView> y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            if (getBaseFragmentActivity() instanceof FrsActivity) {
                return ((FrsActivity) getBaseFragmentActivity()).y0();
            }
            return null;
        }
        return (pb) invokeV.objValue;
    }

    public final void B3(wua wuaVar) {
        i08 i08Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wuaVar) != null) || (i08Var = this.o) == null) {
            return;
        }
        i08Var.L(false);
        this.o.P(false);
        this.o.r();
        this.o.o().getData().clear();
        this.o.x();
        if (this.w == null) {
            bk5 bk5Var = new bk5(getPageContext().getContext(), getNetRefreshListener());
            this.w = bk5Var;
            bk5Var.d(null);
            this.w.b(null);
            this.w.e();
            this.w.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (wuaVar != null) {
            this.w.c(getPageContext().getResources().getString(R.string.net_error_text, wuaVar.d, Integer.valueOf(wuaVar.c)));
        } else {
            this.w.c(null);
        }
        this.w.onChangeSkinType();
        this.w.attachView(this.o.p(), true);
        this.w.a(0);
    }

    public final void D3(int i2) {
        ArrayList<pi> threadList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i2) == null) && (threadList = this.h.getThreadList()) != null) {
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
            this.o.n().w(threadList, this.h);
            this.o.n().p();
        }
    }

    public final void h3(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, responsedMessage) != null) || this.h == null || this.o == null || !(responsedMessage instanceof DownloadMessage) || (data = ((DownloadMessage) responsedMessage).getData()) == null) {
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
            this.o.x();
        }
    }

    public final void o3(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bundle) == null) {
            n3();
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

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void q(ArrayList<pi> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, arrayList) == null) {
            z3();
            if (arrayList != null && arrayList.size() != 0) {
                FrsLoadMoreModel frsLoadMoreModel = this.n;
                FrsViewData frsViewData = this.h;
                ArrayList<pi> V = frsLoadMoreModel.V(false, false, false, arrayList, null, frsViewData.adMixFloor, frsViewData.adShowSelect);
                if (V != null) {
                    this.h.setThreadList(V);
                    this.o.V(V, this.e, this.h, 0);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.h.getForum()));
            }
        }
    }

    @Override // com.baidu.tieba.rt7
    public void a2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (getPageContext() != null) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            }
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                c26.c().f("page_frs_good");
                r3(true);
                return;
            }
            this.o.K(false);
        }
    }

    public final void m3() {
        i08 i08Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048604, this) != null) || (i08Var = this.o) == null) {
            return;
        }
        i08Var.L(true);
        this.o.P(true);
        bk5 bk5Var = this.w;
        if (bk5Var != null && bk5Var.isViewAttached()) {
            this.w.dettachView(this.o.p());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            TiebaStatic.log(new StatisticItem("c13008").param("fid", this.x).param("obj_type", "7").param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                if (this.r == 3) {
                    onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                }
                if (!this.s) {
                    SafeHandler.getInst().post(this.C);
                }
            }
        }
    }

    public void g3(gy4 gy4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, gy4Var) == null) && gy4Var != null && Q1() != null && Q1().getThreadList() != null) {
            if (ListUtils.isEmpty(Q1().getThreadList())) {
                Q1().getThreadList().add(gy4Var);
            } else {
                if (Q1().getThreadList().size() == 1 && (Q1().getThreadList().get(0) instanceof ps7)) {
                    Q1().getThreadList().remove(0);
                }
                Q1().getThreadList().add(0, gy4Var);
            }
            i08 i08Var = this.o;
            ArrayList<pi> threadList = this.h.getThreadList();
            int i2 = this.e;
            FrsViewData frsViewData = this.h;
            i08Var.V(threadList, i2, frsViewData, frsViewData.getPage().b());
            this.o.J();
            this.o.M(0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        ThreadData threadDataById;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048608, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1 && i2 == 18003) {
                this.o.n().p();
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra != null && (threadDataById = this.h.getThreadDataById(stringExtra)) != null) {
                    int intExtra = intent.getIntExtra("type", -1);
                    if (intExtra == 2) {
                        threadDataById.setIs_good(intent.getIntExtra("good_data", 0));
                        threadDataById.parser_title();
                        r3(false);
                    } else if (intExtra == 0) {
                        this.h.removeThreadData(threadDataById);
                        ArrayList<pi> threadList = this.h.getThreadList();
                        if (threadList != null && threadList.size() <= 0) {
                            threadList.add(new ps7());
                        }
                        this.o.J();
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            if (this.r == 3 && this.o == null) {
                return;
            }
            this.r = i2;
            super.onChangeSkinType(i2);
            i08 i08Var = this.o;
            if (i08Var != null) {
                i08Var.y(i2);
            }
            bk5 bk5Var = this.w;
            if (bk5Var != null && bk5Var.isViewAttached()) {
                this.w.onChangeSkinType();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("name", this.b);
            bundle.putString("from", this.c);
            bundle.putBoolean("is_game_frs", this.f);
            this.m.a0(bundle);
            VoiceManager d1 = d1();
            this.i = d1;
            if (d1 != null) {
                d1.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, bundle) == null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.j = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
            } else {
                this.j = System.currentTimeMillis();
            }
            if (arguments != null) {
                this.x = arguments.getString("forum_id", "");
                this.A = arguments.getBoolean(FrsActivityConfig.FLAG_SHOW_AD);
            }
            this.l = System.currentTimeMillis();
            super.onCreate(bundle);
            qua.g().i(getUniqueId());
            FrsGoodModelController frsGoodModelController = new FrsGoodModelController(this);
            this.m = frsGoodModelController;
            if (arguments != null) {
                frsGoodModelController.V(arguments);
                this.f = arguments.getBoolean("is_game_frs", false);
            } else if (bundle != null) {
                frsGoodModelController.V(bundle);
                this.f = bundle.getBoolean("is_game_frs", false);
            } else {
                frsGoodModelController.V(null);
            }
            VoiceManager d1 = d1();
            this.i = d1;
            d1.onCreate(getPageContext());
            o3(bundle);
            registerListener(this.G);
            registerListener(this.D);
            registerListener(this.E);
            registerListener(this.K);
            registerListener(this.B);
            FrsLoadMoreModel frsLoadMoreModel = new FrsLoadMoreModel(this, null);
            this.n = frsLoadMoreModel;
            frsLoadMoreModel.registerListener();
            this.n.l0(2);
            this.n.j0(true);
            this.n.i0(x88.a(this.A));
            System.currentTimeMillis();
            this.y = UtilHelper.getScreenHeight(getActivity());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048611, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0382, (ViewGroup) null);
            i08 i08Var = new i08(this, inflate, this.f);
            this.o = i08Var;
            i08Var.n().A();
            p3();
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            i08 i08Var = this.o;
            if (i08Var != null) {
                i08Var.z();
                this.o.O(null);
                if (this.o.o() != null) {
                    this.o.o().setOnTouchListener(null);
                }
            }
            MessageManager.getInstance().unRegisterListener(this.B);
            qua.g().k(getUniqueId());
            em6.b().e(false);
            super.onDestroy();
            this.m.Z();
            VoiceManager d1 = d1();
            this.i = d1;
            d1.onDestory(getPageContext());
            SafeHandler.getInst().removeCallbacks(this.C);
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048620, this, i2, strArr, iArr) == null) && i2 == 1) {
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

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            super.onStop();
            em6.b().e(false);
            qua.g().h(getUniqueId(), false);
            FrsViewData frsViewData = this.h;
            if (frsViewData != null && frsViewData.getForum() != null) {
                qd5.j().x(getPageContext().getPageActivity(), "frs", this.h.getForum().getId(), 0L);
            }
            VoiceManager d1 = d1();
            this.i = d1;
            if (d1 != null) {
                d1.onStop(getPageContext());
            }
        }
    }

    public final void p3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            if (this.d != 0) {
                this.d = 1;
            }
            this.u = new wz7(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
            this.o.N(this.J);
            this.o.O(this.H);
            this.o.o().setOnTouchListener(new k(this));
        }
    }

    public final void t3() {
        i08 i08Var;
        HashMap<Integer, ThreadData> j2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048632, this) == null) && (i08Var = this.o) != null && i08Var.n() != null && (j2 = this.o.n().j()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, ThreadData> entry : j2.entrySet()) {
                ThreadData value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            td5.q().u(arrayList);
        }
    }

    public final void z3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            if (this.p == 0 && !this.n.S(this.h.getThreadListIds())) {
                if (this.h.getThreadList() != null && this.h.getThreadList().size() != 0) {
                    this.o.a0();
                } else {
                    this.o.r();
                }
            } else if (ListUtils.getCount(this.h.getThreadList()) > 3) {
                this.o.Z();
            } else {
                this.o.W();
            }
        }
    }

    public final void u3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            C3();
            try {
                if (this.h == null) {
                    return;
                }
                this.o.H();
                this.o.Y();
                this.b = this.h.getForum().getName();
                this.g = this.h.getForum().getId();
                if (this.h != null && this.h.getForum() != null) {
                    this.o.U(this.h.getForum().getThemeColorInfo());
                    this.o.Q(this.h);
                }
                TbadkCoreApplication.getInst().setDefaultBubble(this.h.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(this.h.getUserData().getDynamicUrl());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.h.getUserData().getBimg_end_time());
                s3();
                if (!this.o.n().o(ThreadData.TYPE_VIDEO_ALA_ONLIVE)) {
                    this.h.removeAlaLiveThreadData();
                }
                ArrayList<pi> threadList = this.h.getThreadList();
                if (threadList != null) {
                    this.o.V(threadList, this.e, this.h, this.h.getPage().b());
                    t3();
                    this.o.J();
                    if (this.h.getIsNewUrl() == 1) {
                        this.o.n().x(true);
                    } else {
                        this.o.n().x(false);
                    }
                    this.o.M(j3(l3().getType(), this.e));
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }
}
