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
import com.baidu.tieba.aaa;
import com.baidu.tieba.ag;
import com.baidu.tieba.an7;
import com.baidu.tieba.bh5;
import com.baidu.tieba.cn;
import com.baidu.tieba.eh5;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.fs7;
import com.baidu.tieba.gs6;
import com.baidu.tieba.iaa;
import com.baidu.tieba.in;
import com.baidu.tieba.ix9;
import com.baidu.tieba.kg;
import com.baidu.tieba.km5;
import com.baidu.tieba.kv7;
import com.baidu.tieba.mo7;
import com.baidu.tieba.nt7;
import com.baidu.tieba.o26;
import com.baidu.tieba.om7;
import com.baidu.tieba.p26;
import com.baidu.tieba.paa;
import com.baidu.tieba.pf7;
import com.baidu.tieba.pg7;
import com.baidu.tieba.pw9;
import com.baidu.tieba.q25;
import com.baidu.tieba.q26;
import com.baidu.tieba.qg7;
import com.baidu.tieba.qq7;
import com.baidu.tieba.rg7;
import com.baidu.tieba.rq7;
import com.baidu.tieba.sca;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tq7;
import com.baidu.tieba.u9a;
import com.baidu.tieba.vca;
import com.baidu.tieba.vm6;
import com.baidu.tieba.w35;
import com.baidu.tieba.ym;
import com.baidu.tieba.z36;
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
public class FrsGoodFragment extends BaseFragment implements VoiceManager.i, mo7, UserIconBox.c, BdListView.p, FrsCommonImageLayout.e, pg7, ActivityCompat.OnRequestPermissionsResultCallback, ix9, qg7, q26, rg7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public CustomMessageListener B;
    public Runnable C;
    public CustomMessageListener D;
    public CustomMessageListener E;
    public final paa F;
    public final CustomMessageListener G;
    public final RecyclerView.OnScrollListener H;
    public final CustomMessageListener I;
    public in J;
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
    public an7 o;
    public int p;
    public int q;
    public int r;
    public boolean s;
    public SparseArray<p26> t;
    public om7 u;
    public boolean v;
    public km5 w;
    public String x;
    public int y;
    public int z;

    @Override // com.baidu.tieba.q26
    public void T(o26 o26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, o26Var) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceManager.IPlayView g1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    public final int l2(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048601, this, i2, i3)) == null) {
            if (i2 != 1) {
                return (i2 != 2 || i3 == 1) ? 0 : 3;
            }
            return 3;
        }
        return invokeII.intValue;
    }

    @Override // com.baidu.tieba.qg7
    public NavigationBar o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return null;
        }
        return (NavigationBar) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pg7
    public void r0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class c implements in {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsGoodFragment a;

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

        @Override // com.baidu.tieba.in
        public void b(View view2, ym ymVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z;
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ymVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && bdUniqueId != null && ymVar != null && (ymVar instanceof w35)) {
                ThreadData threadData = ((w35) ymVar).t;
                if (threadData.getAnchorInfoData() != null && threadData.getAnchorInfoData().getGroup_id() != 0 && !ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                    return;
                }
                if (threadData.getActInfoType() == 1 && !ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                    return;
                }
                vca readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                if (readThreadHistory != null && !readThreadHistory.d(threadData.getId())) {
                    readThreadHistory.a(threadData.getId());
                    an7 an7Var = this.a.o;
                    if (an7Var != null) {
                        an7Var.y();
                    }
                }
                String ad_url = threadData.getAd_url();
                boolean z2 = false;
                if (ad_url != null && !ad_url.equals("")) {
                    gs6.a(new a(this, ad_url), "requestAdFrsGood", 3);
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
                    rq7 rq7Var = new rq7();
                    if (this.a.h.needLog == 1) {
                        z2 = true;
                    }
                    rq7Var.a = z2;
                    rq7Var.c = this.a.h.getForum().getId();
                    rq7Var.d = this.a.h.getForum().getName();
                    rq7 rq7Var2 = tq7.q0;
                    if (rq7Var2 != null) {
                        rq7Var.e = rq7Var2.e;
                        rq7Var.f = rq7Var2.f;
                    }
                    qq7.e(threadData, 1, this.a.getUniqueId(), rq7Var, this.a.getTbPageTag());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
                vm6.b().e(true);
                u9a.g().h(this.a.getUniqueId(), true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                this.a.z += i2;
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

    /* loaded from: classes5.dex */
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
            this.a.j2(customResponsedMessage);
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
            an7 an7Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (an7Var = this.a.o) != null) {
                an7Var.B();
            }
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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
                    this.a.D2(null);
                } else {
                    this.a.t2(false);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
                this.a.G2(threadData.getPraise().getIsLike());
            }
        }
    }

    /* loaded from: classes5.dex */
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
                if (this.a.k2() != null) {
                    this.a.k2().setSelection(0);
                }
                if (this.a.w == null || !this.a.w.isViewAttached()) {
                    an7 an7Var = this.a.o;
                    if (an7Var != null) {
                        an7Var.c0();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                        return;
                    }
                    return;
                }
                this.a.t2(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements paa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public final /* synthetic */ FrsGoodFragment b;

        @Override // com.baidu.tieba.paa
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.baidu.tieba.paa
        public void c(iaa iaaVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iaaVar) == null) {
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

        @Override // com.baidu.tieba.paa
        public void a(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || this.b.v) {
                return;
            }
            if (i != 1 && i != 2) {
                if (i == 3) {
                    this.b.o.L(true);
                    return;
                }
                return;
            }
            this.b.o.y();
        }

        @Override // com.baidu.tieba.paa
        public void d(int i, boolean z, aaa aaaVar) {
            ArrayList<ym> U;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), aaaVar}) == null) {
                if (this.b.v) {
                    if (this.b.n2().O() == null) {
                        this.b.v = false;
                        return;
                    } else if (this.b.n2().O().getThreadList().size() >= 10) {
                        this.b.v = false;
                        fs7 fs7Var = new fs7();
                        fs7Var.b = 301;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384, fs7Var));
                        return;
                    }
                }
                if (aaaVar == null) {
                    this.a = 1L;
                } else if (aaaVar.b) {
                    this.a = 0L;
                } else {
                    this.a = 1L;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (i == 3) {
                    this.b.n.g0();
                }
                this.b.o.L(false);
                if (this.b.n2().O() != null) {
                    FrsGoodFragment frsGoodFragment = this.b;
                    frsGoodFragment.h = frsGoodFragment.n2().O();
                }
                FrsGoodFragment frsGoodFragment2 = this.b;
                frsGoodFragment2.p = frsGoodFragment2.h.getPage().b();
                if (this.b.p == 0 && (this.b.h.getThreadListIds() == null || this.b.h.getThreadListIds().size() == 0)) {
                    if (this.b.h.getThreadList() != null && this.b.h.getThreadList().size() != 0) {
                        this.b.o.b0();
                    } else {
                        this.b.o.s();
                    }
                } else if (ListUtils.getCount(this.b.h.getThreadList()) > 3) {
                    this.b.o.a0();
                } else {
                    this.b.o.X();
                }
                if (i == 4) {
                    ArrayList<ym> U2 = this.b.n.U(false, false, false, this.b.h.getThreadList(), null, this.b.h.adMixFloor, this.b.h.adShowSelect);
                    if (U2 != null) {
                        this.b.h.setThreadList(U2);
                        FrsGoodFragment frsGoodFragment3 = this.b;
                        frsGoodFragment3.o.W(U2, frsGoodFragment3.e, this.b.h, this.b.p);
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
                        this.b.o.y();
                    }
                } else {
                    this.b.o.y();
                }
                this.b.hideLoadingView();
                if (this.a != 0) {
                    this.b.D2(aaaVar);
                } else {
                    if (this.b.h != null) {
                        FrsGoodFragment frsGoodFragment4 = this.b;
                        frsGoodFragment4.b = frsGoodFragment4.h.getForum().getName();
                        FrsGoodFragment frsGoodFragment5 = this.b;
                        frsGoodFragment5.g = frsGoodFragment5.h.getForum().getId();
                        FrsGoodFragment frsGoodFragment6 = this.b;
                        frsGoodFragment6.o.C(frsGoodFragment6.h.getForum(), this.b.h.getUserData());
                    }
                    if (this.b.h != null) {
                        this.b.h.addNoticeThreadToThreadList();
                    }
                    FrsGoodFragment frsGoodFragment7 = this.b;
                    frsGoodFragment7.o.R(frsGoodFragment7.h);
                    if (this.b.h != null && this.b.h.getThreadList() != null && this.b.h.getThreadList().size() == 0 && this.b.n2().getType() == 4) {
                        FrsGoodFragment frsGoodFragment8 = this.b;
                        frsGoodFragment8.showToast(frsGoodFragment8.getPageContext().getString(R.string.no_more_to_load));
                        if (this.b.e > 1) {
                            FrsGoodFragment.P1(this.b);
                        }
                        if (this.b.j > -1) {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            FrsGoodFragment frsGoodFragment9 = this.b;
                            long Q = frsGoodFragment9.n2().Q();
                            FrsGoodFragment frsGoodFragment10 = this.b;
                            TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis2 - frsGoodFragment9.j, Q - frsGoodFragment10.j, frsGoodFragment10.n2().S(), this.b.n2().R(), currentTimeMillis2 - this.b.n2().P());
                            this.b.j = -1L;
                        }
                        this.b.k = System.currentTimeMillis() - currentTimeMillis;
                        return;
                    }
                    if (this.b.h != null && (U = this.b.n.U(false, false, true, this.b.h.getThreadList(), null, this.b.h.adMixFloor, this.b.h.adShowSelect)) != null && U.size() > 0) {
                        this.b.h.setThreadList(U);
                    }
                    this.b.w2();
                }
                if (this.b.j > -1) {
                    long currentTimeMillis3 = System.currentTimeMillis();
                    FrsGoodFragment frsGoodFragment11 = this.b;
                    long Q2 = frsGoodFragment11.n2().Q();
                    FrsGoodFragment frsGoodFragment12 = this.b;
                    TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis3 - frsGoodFragment11.j, Q2 - frsGoodFragment12.j, frsGoodFragment12.n2().S(), this.b.n2().R(), currentTimeMillis3 - this.b.n2().P());
                    this.b.j = -1L;
                }
                this.b.k = System.currentTimeMillis() - currentTimeMillis;
                System.gc();
            }
        }
    }

    /* loaded from: classes5.dex */
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
            an7 an7Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (an7Var = this.a.o) != null) {
                an7Var.c0();
            }
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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
                sca.o(this.a.b);
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
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            if (!BdUtilHelper.isNetOk()) {
                this.o.s();
            } else if (!this.m.T()) {
                this.o.s();
            } else {
                B2();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
                if (!this.n.isLoading && !this.m.V()) {
                    ArrayList<ym> arrayList = null;
                    if (this.n.R(this.h.getThreadListIds())) {
                        FrsViewData frsViewData = this.h;
                        if (frsViewData != null) {
                            arrayList = frsViewData.getThreadList();
                        }
                        String e2 = pw9.e(arrayList, false);
                        this.o.W(this.n.e0(), this.e, this.h, 0);
                        this.n.f0(JavaTypesHelper.toLong(this.g, 0L), this.h.getThreadListIds(), this.b, this.e, this.h.isBrandForum, e2);
                    } else if (this.p != 0) {
                        FrsViewData frsViewData2 = this.h;
                        if (frsViewData2 != null) {
                            arrayList = frsViewData2.getThreadList();
                        }
                        String e3 = pw9.e(arrayList, false);
                        this.o.W(this.n.e0(), this.e, this.h, 0);
                        int i2 = this.e + 1;
                        this.e = i2;
                        this.m.X(i2, e3);
                        FrsLoadMoreModel frsLoadMoreModel = this.n;
                        frsLoadMoreModel.loadingDone = false;
                        frsLoadMoreModel.loadIndex = 0;
                    }
                }
            }
        }
    }

    public static /* synthetic */ int P1(FrsGoodFragment frsGoodFragment) {
        int i2 = frsGoodFragment.e;
        frsGoodFragment.e = i2 - 1;
        return i2;
    }

    public void A2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.e = i2;
        }
    }

    @Override // com.baidu.tieba.q26
    public p26 e1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            return this.t.get(i2);
        }
        return (p26) invokeI.objValue;
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void onFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            B2();
        }
    }

    public void s2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i2) == null) {
            this.q = i2;
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                t2(false);
            } else {
                D2(null);
            }
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, str) == null) {
            this.c = str;
        }
    }

    public final void t2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
            this.s = true;
            E2();
            o2();
            if (!z) {
                o2();
                C2();
            }
            FrsGoodModelController frsGoodModelController = this.m;
            if (frsGoodModelController != null) {
                frsGoodModelController.W(this.q);
            }
        }
    }

    public void y2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048640, this, i2) == null) {
            this.d = i2;
        }
    }

    public void z2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, str) == null) {
            this.b = str;
        }
    }

    @Override // com.baidu.tieba.q26
    public void B0(int i2, p26 p26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, p26Var) == null) {
            this.t.put(i2, p26Var);
        }
    }

    public final void B2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.p == 0 && !this.n.R(this.h.getThreadListIds())) {
                if (this.h.getThreadList() != null && this.h.getThreadList().size() != 0) {
                    this.o.b0();
                } else {
                    this.o.s();
                }
            } else if (ListUtils.getCount(this.h.getThreadList()) > 3) {
                this.o.a0();
            } else {
                this.o.X();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            super.onStop();
            vm6.b().e(false);
            u9a.g().h(getUniqueId(), false);
            FrsViewData frsViewData = this.h;
            if (frsViewData != null && frsViewData.getForum() != null) {
                bh5.j().x(getPageContext().getPageActivity(), "frs", this.h.getForum().getId(), 0L);
            }
            VoiceManager z0 = z0();
            this.i = z0;
            if (z0 != null) {
                z0.onStop(getPageContext());
            }
        }
    }

    public final void r2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            if (this.d != 0) {
                this.d = 1;
            }
            this.u = new om7(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
            this.o.O(this.J);
            this.o.P(this.H);
            this.o.p().setOnTouchListener(new k(this));
        }
    }

    public final void v2() {
        an7 an7Var;
        HashMap<Integer, ThreadData> j2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048636, this) == null) && (an7Var = this.o) != null && an7Var.o() != null && (j2 = this.o.o().j()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, ThreadData> entry : j2.entrySet()) {
                ThreadData value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            eh5.q().u(arrayList);
        }
    }

    public final void C2() {
        an7 an7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (an7Var = this.o) == null) {
            return;
        }
        an7Var.M(false);
        showLoadingView(this.o.q(), true, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703a6));
    }

    @Override // com.baidu.tieba.pg7
    public void E1() {
        an7 an7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (an7Var = this.o) != null && an7Var.p() != null) {
            this.o.p().scrollToPosition(0);
        }
    }

    public void E2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            VoiceManager z0 = z0();
            this.i = z0;
            z0.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public ag<TbImageView> J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (getBaseFragmentActivity() instanceof FrsActivity) {
                return ((FrsActivity) getBaseFragmentActivity()).J();
            }
            return null;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public ag<TbImageView> b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (getBaseFragmentActivity() instanceof FrsActivity) {
                return ((FrsActivity) getBaseFragmentActivity()).b0();
            }
            return null;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mo7
    public FrsViewData d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.h;
        }
        return (FrsViewData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ix9
    public String e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mo7
    public /* bridge */ /* synthetic */ BdPageContext getPageContext() {
        return super.getPageContext();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            TbPageTag tbPageTag = super.getTbPageTag();
            FrsViewData frsViewData = this.h;
            if (frsViewData != null) {
                i2 = frsViewData.getSortType();
            } else {
                i2 = -1;
            }
            tbPageTag.sortType = nt7.g(i2);
            tbPageTag.locatePage = "a072";
            return tbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pg7
    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && this.o != null) {
            E1();
            this.o.c0();
        }
    }

    public final void hideLoadingView() {
        an7 an7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048595, this) != null) || (an7Var = this.o) == null) {
            return;
        }
        an7Var.M(true);
        hideLoadingView(this.o.q());
    }

    public BdTypeRecyclerView k2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            an7 an7Var = this.o;
            if (an7Var == null) {
                return null;
            }
            return an7Var.p();
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public FrsLoadMoreModel m2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.n;
        }
        return (FrsLoadMoreModel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rg7
    public void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            u9a.g().h(getUniqueId(), false);
        }
    }

    public FrsGoodModelController n2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.m;
        }
        return (FrsGoodModelController) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public cn onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            if (k2() == null) {
                return null;
            }
            return k2().getPreLoadHandle();
        }
        return (cn) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            super.onLazyLoad();
            if (this.s) {
                return;
            }
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                t2(false);
            } else {
                D2(null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048616, this) != null) || !BdNetTypeUtil.isNetWorkAvailable()) {
            return;
        }
        t2(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            super.onPause();
            VoiceManager z0 = z0();
            this.i = z0;
            z0.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            super.onResume();
            an7 an7Var = this.o;
            if (an7Var != null) {
                an7Var.y();
            }
            VoiceManager z0 = z0();
            this.i = z0;
            z0.onResume(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            super.onStart();
            VoiceManager z0 = z0();
            this.i = z0;
            z0.onStart(getPageContext());
        }
    }

    public final void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            registerListener(2001118, this.I);
        }
    }

    @Override // com.baidu.tieba.ix9
    public int s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ix9
    public TbPageContext<?> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return getPageContext();
        }
        return (TbPageContext) invokeV.objValue;
    }

    public final void u2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            if (this.d == 1) {
                kg.a().b(new l(this));
            }
            this.d = 0;
        }
    }

    @Override // com.baidu.tieba.mo7, com.baidu.tieba.tg7
    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ix9
    public void w0() {
        FrsGoodModelController frsGoodModelController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048637, this) == null) && (frsGoodModelController = this.m) != null) {
            frsGoodModelController.d0();
        }
    }

    public void x2() {
        an7 an7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048639, this) == null) && (an7Var = this.o) != null) {
            an7Var.D();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceManager z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            if (this.i == null) {
                this.i = VoiceManager.instance();
            }
            return this.i;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public final void D2(aaa aaaVar) {
        an7 an7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, aaaVar) != null) || (an7Var = this.o) == null) {
            return;
        }
        an7Var.M(false);
        this.o.Q(false);
        this.o.s();
        this.o.p().getData().clear();
        this.o.y();
        if (this.w == null) {
            km5 km5Var = new km5(getPageContext().getContext(), getNetRefreshListener());
            this.w = km5Var;
            km5Var.d(null);
            this.w.b(null);
            this.w.e();
            this.w.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (aaaVar != null) {
            this.w.c(getPageContext().getResources().getString(R.string.net_error_text, aaaVar.d, Integer.valueOf(aaaVar.c)));
        } else {
            this.w.c(null);
        }
        this.w.onChangeSkinType();
        this.w.attachView(this.o.q(), true);
        this.w.a(0);
    }

    public final void F2(ThreadData threadData, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, threadData, i2) == null) {
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

    public final void G2(int i2) {
        ArrayList<ym> threadList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) && (threadList = this.h.getThreadList()) != null) {
            Iterator<ym> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ym next = it.next();
                if (next instanceof w35) {
                    ThreadData threadData = ((w35) next).t;
                    if (threadData.getId() != null && threadData.getId().equals(this.a)) {
                        F2(threadData, i2);
                        this.a = null;
                        break;
                    }
                }
            }
            this.o.o().w(threadList, this.h);
            this.o.o().p();
        }
    }

    public final void j2(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, responsedMessage) != null) || this.h == null || this.o == null || !(responsedMessage instanceof DownloadMessage) || (data = ((DownloadMessage) responsedMessage).getData()) == null) {
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
            this.o.y();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void l(ArrayList<ym> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, arrayList) == null) {
            B2();
            if (arrayList != null && arrayList.size() != 0) {
                FrsLoadMoreModel frsLoadMoreModel = this.n;
                FrsViewData frsViewData = this.h;
                ArrayList<ym> U = frsLoadMoreModel.U(false, false, false, arrayList, null, frsViewData.adMixFloor, frsViewData.adShowSelect);
                if (U != null) {
                    this.h.setThreadList(U);
                    this.o.W(U, this.e, this.h, 0);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.h.getForum()));
            }
        }
    }

    public final void q2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, bundle) == null) {
            p2();
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

    public void i2(q25 q25Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, q25Var) == null) && q25Var != null && d1() != null && d1().getThreadList() != null) {
            if (ListUtils.isEmpty(d1().getThreadList())) {
                d1().getThreadList().add(q25Var);
            } else {
                if (d1().getThreadList().size() == 1 && (d1().getThreadList().get(0) instanceof pf7)) {
                    d1().getThreadList().remove(0);
                }
                d1().getThreadList().add(0, q25Var);
            }
            an7 an7Var = this.o;
            ArrayList<ym> threadList = this.h.getThreadList();
            int i2 = this.e;
            FrsViewData frsViewData = this.h;
            an7Var.W(threadList, i2, frsViewData, frsViewData.getPage().b());
            this.o.K();
            this.o.N(0);
        }
    }

    @Override // com.baidu.tieba.rg7
    public void l1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (getPageContext() != null) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            }
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                z36.c().f("page_frs_good");
                t2(true);
                return;
            }
            this.o.L(false);
        }
    }

    public final void o2() {
        an7 an7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048606, this) != null) || (an7Var = this.o) == null) {
            return;
        }
        an7Var.M(true);
        this.o.Q(true);
        km5 km5Var = this.w;
        if (km5Var != null && km5Var.isViewAttached()) {
            this.w.dettachView(this.o.q());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            TiebaStatic.log(new StatisticItem("c13008").param("fid", this.x).param("obj_type", "7").param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
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

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        ThreadData threadDataById;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048607, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1 && i2 == 18003) {
                this.o.o().p();
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra != null && (threadDataById = this.h.getThreadDataById(stringExtra)) != null) {
                    int intExtra = intent.getIntExtra("type", -1);
                    if (intExtra == 2) {
                        threadDataById.setIs_good(intent.getIntExtra("good_data", 0));
                        threadDataById.parser_title();
                        t2(false);
                    } else if (intExtra == 0) {
                        this.h.removeThreadData(threadDataById);
                        ArrayList<ym> threadList = this.h.getThreadList();
                        if (threadList != null && threadList.size() <= 0) {
                            threadList.add(new pf7());
                        }
                        this.o.K();
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            if (this.r == 3 && this.o == null) {
                return;
            }
            this.r = i2;
            super.onChangeSkinType(i2);
            an7 an7Var = this.o;
            if (an7Var != null) {
                an7Var.z(i2);
            }
            km5 km5Var = this.w;
            if (km5Var != null && km5Var.isViewAttached()) {
                this.w.onChangeSkinType();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("name", this.b);
            bundle.putString("from", this.c);
            bundle.putBoolean("is_game_frs", this.f);
            this.m.Z(bundle);
            VoiceManager z0 = z0();
            this.i = z0;
            if (z0 != null) {
                z0.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, bundle) == null) {
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
            u9a.g().i(getUniqueId());
            FrsGoodModelController frsGoodModelController = new FrsGoodModelController(this);
            this.m = frsGoodModelController;
            if (arguments != null) {
                frsGoodModelController.U(arguments);
                this.f = arguments.getBoolean("is_game_frs", false);
            } else if (bundle != null) {
                frsGoodModelController.U(bundle);
                this.f = bundle.getBoolean("is_game_frs", false);
            } else {
                frsGoodModelController.U(null);
            }
            VoiceManager z0 = z0();
            this.i = z0;
            z0.onCreate(getPageContext());
            q2(bundle);
            registerListener(this.G);
            registerListener(this.D);
            registerListener(this.E);
            registerListener(this.K);
            registerListener(this.B);
            FrsLoadMoreModel frsLoadMoreModel = new FrsLoadMoreModel(this, null);
            this.n = frsLoadMoreModel;
            frsLoadMoreModel.registerListener();
            this.n.k0(2);
            this.n.i0(true);
            this.n.h0(kv7.a(this.A));
            System.currentTimeMillis();
            this.y = UtilHelper.getScreenHeight(getActivity());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048610, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d035f, (ViewGroup) null);
            an7 an7Var = new an7(this, inflate, this.f);
            this.o = an7Var;
            an7Var.o().A();
            r2();
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            an7 an7Var = this.o;
            if (an7Var != null) {
                an7Var.A();
                this.o.P(null);
                if (this.o.p() != null) {
                    this.o.p().setOnTouchListener(null);
                }
            }
            MessageManager.getInstance().unRegisterListener(this.B);
            u9a.g().k(getUniqueId());
            vm6.b().e(false);
            super.onDestroy();
            this.m.Y();
            VoiceManager z0 = z0();
            this.i = z0;
            z0.onDestory(getPageContext());
            SafeHandler.getInst().removeCallbacks(this.C);
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048619, this, i2, strArr, iArr) == null) && i2 == 1) {
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

    public final void w2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            E2();
            try {
                if (this.h == null) {
                    return;
                }
                this.o.I();
                this.o.Z();
                this.b = this.h.getForum().getName();
                this.g = this.h.getForum().getId();
                if (this.h != null && this.h.getForum() != null) {
                    this.o.V(this.h.getForum().getThemeColorInfo());
                    this.o.R(this.h);
                }
                TbadkCoreApplication.getInst().setDefaultBubble(this.h.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(this.h.getUserData().getDynamicUrl());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.h.getUserData().getBimg_end_time());
                u2();
                if (!this.o.o().o(ThreadData.TYPE_VIDEO_ALA_ONLIVE)) {
                    this.h.removeAlaLiveThreadData();
                }
                ArrayList<ym> threadList = this.h.getThreadList();
                if (threadList != null) {
                    this.o.W(threadList, this.e, this.h, this.h.getPage().b());
                    v2();
                    this.o.K();
                    if (this.h.getIsNewUrl() == 1) {
                        this.o.o().x(true);
                    } else {
                        this.o.o().x(false);
                    }
                    this.o.N(l2(n2().getType(), this.e));
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }
}
