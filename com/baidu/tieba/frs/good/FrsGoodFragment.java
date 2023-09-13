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
import com.baidu.tieba.b35;
import com.baidu.tieba.b46;
import com.baidu.tieba.bg;
import com.baidu.tieba.bga;
import com.baidu.tieba.bi5;
import com.baidu.tieba.c46;
import com.baidu.tieba.cn;
import com.baidu.tieba.d46;
import com.baidu.tieba.e3a;
import com.baidu.tieba.ei5;
import com.baidu.tieba.ep6;
import com.baidu.tieba.eq7;
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
import com.baidu.tieba.qga;
import com.baidu.tieba.qr7;
import com.baidu.tieba.sn5;
import com.baidu.tieba.sp7;
import com.baidu.tieba.sw7;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.uia;
import com.baidu.tieba.ut7;
import com.baidu.tieba.vfa;
import com.baidu.tieba.vt7;
import com.baidu.tieba.vu6;
import com.baidu.tieba.xia;
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
public class FrsGoodFragment extends BaseFragment implements VoiceManager.j, qr7, UserIconBox.c, BdListView.p, FrsCommonImageLayout.e, nj7, ActivityCompat.OnRequestPermissionsResultCallback, e3a, oj7, d46, pj7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public CustomMessageListener B;
    public Runnable C;
    public CustomMessageListener D;
    public CustomMessageListener E;
    public final qga F;
    public final CustomMessageListener G;
    public final RecyclerView.OnScrollListener H;
    public final CustomMessageListener I;
    public mn J;
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
    public eq7 o;
    public int p;
    public int q;
    public int r;
    public boolean s;
    public SparseArray<c46> t;
    public sp7 u;
    public boolean v;
    public sn5 w;
    public String x;
    public int y;
    public int z;

    @Override // com.baidu.tieba.d46
    public void Z(b46 b46Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, b46Var) == null) {
        }
    }

    @Override // com.baidu.tieba.oj7
    public NavigationBar o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return null;
        }
        return (NavigationBar) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.IPlayView r1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    @Override // com.baidu.tieba.nj7
    public void y0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048639, this, z) == null) {
        }
    }

    public final int z2(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048641, this, i2, i3)) == null) {
            if (i2 != 1) {
                return (i2 != 2 || i3 == 1) ? 0 : 3;
            }
            return 3;
        }
        return invokeII.intValue;
    }

    /* loaded from: classes5.dex */
    public class c implements mn {
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

        @Override // com.baidu.tieba.mn
        public void b(View view2, cn cnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z;
            String str;
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
                    eq7 eq7Var = this.a.o;
                    if (eq7Var != null) {
                        eq7Var.x();
                    }
                }
                String ad_url = threadData.getAd_url();
                boolean z2 = false;
                if (ad_url != null && !ad_url.equals("")) {
                    vu6.a(new a(this, ad_url), "requestAdFrsGood", 3);
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
                    vt7 vt7Var = new vt7();
                    if (this.a.h.needLog == 1) {
                        z2 = true;
                    }
                    vt7Var.a = z2;
                    vt7Var.c = this.a.h.getForum().getId();
                    vt7Var.d = this.a.h.getForum().getName();
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
                ep6.b().e(true);
                vfa.g().h(this.a.getUniqueId(), true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                FrsGoodFragment.l2(this.a, i2);
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
            this.a.x2(customResponsedMessage);
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
            eq7 eq7Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (eq7Var = this.a.o) != null) {
                eq7Var.A();
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
                    this.a.R2(null);
                } else {
                    this.a.H2(false);
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
                this.a.T2(threadData.getPraise().getIsLike());
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
                if (this.a.y2() != null) {
                    this.a.y2().setSelection(0);
                }
                if (this.a.w == null || !this.a.w.isViewAttached()) {
                    eq7 eq7Var = this.a.o;
                    if (eq7Var != null) {
                        eq7Var.b0();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                        return;
                    }
                    return;
                }
                this.a.H2(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements qga {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public final /* synthetic */ FrsGoodFragment b;

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

        @Override // com.baidu.tieba.qga
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

        @Override // com.baidu.tieba.qga
        public void d(int i, boolean z, bga bgaVar) {
            ArrayList<cn> T2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), bgaVar}) == null) {
                if (this.b.v) {
                    if (this.b.B2().N() == null) {
                        this.b.v = false;
                        return;
                    } else if (this.b.B2().N().getThreadList().size() >= 10) {
                        this.b.v = false;
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
                    this.b.n.f0();
                }
                this.b.o.K(false);
                if (this.b.B2().N() != null) {
                    FrsGoodFragment frsGoodFragment = this.b;
                    frsGoodFragment.h = frsGoodFragment.B2().N();
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
                    ArrayList<cn> T3 = this.b.n.T(false, false, false, this.b.h.getThreadList(), null, this.b.h.adMixFloor, this.b.h.adShowSelect);
                    if (T3 != null) {
                        this.b.h.setThreadList(T3);
                        FrsGoodFragment frsGoodFragment3 = this.b;
                        frsGoodFragment3.o.V(T3, frsGoodFragment3.e, this.b.h, this.b.p);
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
                    this.b.R2(bgaVar);
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
                    if (this.b.h != null && this.b.h.getThreadList() != null && this.b.h.getThreadList().size() == 0 && this.b.B2().getType() == 4) {
                        FrsGoodFragment frsGoodFragment8 = this.b;
                        frsGoodFragment8.showToast(frsGoodFragment8.getPageContext().getString(R.string.no_more_to_load));
                        if (this.b.e > 1) {
                            FrsGoodFragment.d2(this.b);
                        }
                        if (this.b.j > -1) {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            FrsGoodFragment frsGoodFragment9 = this.b;
                            long P = frsGoodFragment9.B2().P();
                            FrsGoodFragment frsGoodFragment10 = this.b;
                            TiebaStatic.page("op_frs_enter", currentTimeMillis2 - frsGoodFragment9.j, P - frsGoodFragment10.j, frsGoodFragment10.B2().R(), this.b.B2().Q(), currentTimeMillis2 - this.b.B2().O());
                            this.b.j = -1L;
                        }
                        this.b.k = System.currentTimeMillis() - currentTimeMillis;
                        return;
                    }
                    if (this.b.h != null && (T2 = this.b.n.T(false, false, true, this.b.h.getThreadList(), null, this.b.h.adMixFloor, this.b.h.adShowSelect)) != null && T2.size() > 0) {
                        this.b.h.setThreadList(T2);
                    }
                    this.b.K2();
                }
                if (this.b.j > -1) {
                    long currentTimeMillis3 = System.currentTimeMillis();
                    FrsGoodFragment frsGoodFragment11 = this.b;
                    long P2 = frsGoodFragment11.B2().P();
                    FrsGoodFragment frsGoodFragment12 = this.b;
                    TiebaStatic.page("op_frs_enter", currentTimeMillis3 - frsGoodFragment11.j, P2 - frsGoodFragment12.j, frsGoodFragment12.B2().R(), this.b.B2().Q(), currentTimeMillis3 - this.b.B2().O());
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
            eq7 eq7Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (eq7Var = this.a.o) != null) {
                eq7Var.b0();
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
                uia.o(this.a.b);
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
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            if (!BdUtilHelper.isNetOk()) {
                this.o.r();
            } else if (!this.m.S()) {
                this.o.r();
            } else {
                P2();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
                if (!this.n.isLoading && !this.m.U()) {
                    ArrayList<cn> arrayList = null;
                    if (this.n.Q(this.h.getThreadListIds())) {
                        FrsViewData frsViewData = this.h;
                        if (frsViewData != null) {
                            arrayList = frsViewData.getThreadList();
                        }
                        String e2 = l2a.e(arrayList, false);
                        this.o.V(this.n.d0(), this.e, this.h, 0);
                        this.n.e0(JavaTypesHelper.toLong(this.g, 0L), this.h.getThreadListIds(), this.b, this.e, this.h.isBrandForum, e2);
                    } else if (this.p != 0) {
                        FrsViewData frsViewData2 = this.h;
                        if (frsViewData2 != null) {
                            arrayList = frsViewData2.getThreadList();
                        }
                        String e3 = l2a.e(arrayList, false);
                        this.o.V(this.n.d0(), this.e, this.h, 0);
                        int i2 = this.e + 1;
                        this.e = i2;
                        this.m.W(i2, e3);
                        FrsLoadMoreModel frsLoadMoreModel = this.n;
                        frsLoadMoreModel.loadingDone = false;
                        frsLoadMoreModel.loadIndex = 0;
                    }
                }
            }
        }
    }

    public static /* synthetic */ int d2(FrsGoodFragment frsGoodFragment) {
        int i2 = frsGoodFragment.e;
        frsGoodFragment.e = i2 - 1;
        return i2;
    }

    public void G2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.q = i2;
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                H2(false);
            } else {
                R2(null);
            }
        }
    }

    public final void H2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.s = true;
            S2();
            C2();
            if (!z) {
                C2();
                Q2();
            }
            FrsGoodModelController frsGoodModelController = this.m;
            if (frsGoodModelController != null) {
                frsGoodModelController.V(this.q);
            }
        }
    }

    public void M2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.d = i2;
        }
    }

    public void N2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.b = str;
        }
    }

    public void O2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.e = i2;
        }
    }

    @Override // com.baidu.tieba.d46
    public c46 o1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048612, this, i2)) == null) {
            return this.t.get(i2);
        }
        return (c46) invokeI.objValue;
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void onFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, str) == null) {
            P2();
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, str) == null) {
            this.c = str;
        }
    }

    public static /* synthetic */ int l2(FrsGoodFragment frsGoodFragment, int i2) {
        int i3 = frsGoodFragment.z + i2;
        frsGoodFragment.z = i3;
        return i3;
    }

    @Override // com.baidu.tieba.d46
    public void J0(int i2, c46 c46Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i2, c46Var) == null) {
            this.t.put(i2, c46Var);
        }
    }

    public FrsLoadMoreModel A2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.n;
        }
        return (FrsLoadMoreModel) invokeV.objValue;
    }

    public FrsGoodModelController B2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.m;
        }
        return (FrsGoodModelController) invokeV.objValue;
    }

    public final void D2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            registerListener(2001118, this.I);
        }
    }

    @Override // com.baidu.tieba.e3a
    public void E0() {
        FrsGoodModelController frsGoodModelController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (frsGoodModelController = this.m) != null) {
            frsGoodModelController.c0();
        }
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

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.i == null) {
                this.i = VoiceManager.instance();
            }
            return this.i;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public final void I2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.d == 1) {
                lg.a().b(new l(this));
            }
            this.d = 0;
        }
    }

    public void L2() {
        eq7 eq7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (eq7Var = this.o) != null) {
            eq7Var.C();
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

    public final void Q2() {
        eq7 eq7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048597, this) != null) || (eq7Var = this.o) == null) {
            return;
        }
        eq7Var.L(false);
        showLoadingView(this.o.p(), true, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703aa));
    }

    @Override // com.baidu.tieba.nj7
    public void S1() {
        eq7 eq7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (eq7Var = this.o) != null && eq7Var.o() != null) {
            this.o.o().scrollToPosition(0);
        }
    }

    public void S2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            VoiceManager H0 = H0();
            this.i = H0;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            TbPageTag tbPageTag = super.getTbPageTag();
            FrsViewData frsViewData = this.h;
            if (frsViewData != null) {
                i2 = frsViewData.getSortType();
            } else {
                i2 = -1;
            }
            tbPageTag.sortType = sw7.g(i2);
            tbPageTag.locatePage = "a072";
            return tbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nj7
    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && this.o != null) {
            S1();
            this.o.b0();
        }
    }

    public final void hideLoadingView() {
        eq7 eq7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048606, this) != null) || (eq7Var = this.o) == null) {
            return;
        }
        eq7Var.L(true);
        hideLoadingView(this.o.p());
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public bg<TbImageView> i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qr7
    public FrsViewData m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.h;
        }
        return (FrsViewData) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public gn onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            if (y2() == null) {
                return null;
            }
            return y2().getPreLoadHandle();
        }
        return (gn) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            super.onLazyLoad();
            if (this.s) {
                return;
            }
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                H2(false);
            } else {
                R2(null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048622, this) != null) || !BdNetTypeUtil.isNetWorkAvailable()) {
            return;
        }
        H2(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            super.onPause();
            VoiceManager H0 = H0();
            this.i = H0;
            H0.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            super.onResume();
            eq7 eq7Var = this.o;
            if (eq7Var != null) {
                eq7Var.x();
            }
            VoiceManager H0 = H0();
            this.i = H0;
            H0.onResume(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            super.onStart();
            VoiceManager H0 = H0();
            this.i = H0;
            H0.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tieba.e3a
    public TbPageContext<?> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return getPageContext();
        }
        return (TbPageContext) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pj7
    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            vfa.g().h(getUniqueId(), false);
        }
    }

    @Override // com.baidu.tieba.qr7, com.baidu.tieba.rj7
    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public BdTypeRecyclerView y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            eq7 eq7Var = this.o;
            if (eq7Var == null) {
                return null;
            }
            return eq7Var.o();
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public final void C2() {
        eq7 eq7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (eq7Var = this.o) == null) {
            return;
        }
        eq7Var.L(true);
        this.o.P(true);
        sn5 sn5Var = this.w;
        if (sn5Var != null && sn5Var.isViewAttached()) {
            this.w.dettachView(this.o.p());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            TiebaStatic.log(new StatisticItem("c13008").param("fid", this.x).param("obj_type", "7").param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
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

    @Override // com.baidu.tieba.pj7
    public void w1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            if (getPageContext() != null) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            }
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                m56.c().f("page_frs_good");
                H2(true);
                return;
            }
            this.o.K(false);
        }
    }

    public final void E2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            D2();
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

    public final void T2(int i2) {
        ArrayList<cn> threadList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048601, this, i2) == null) && (threadList = this.h.getThreadList()) != null) {
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
            this.o.n().w(threadList, this.h);
            this.o.n().p();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void l(ArrayList<cn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, arrayList) == null) {
            P2();
            if (arrayList != null && arrayList.size() != 0) {
                FrsLoadMoreModel frsLoadMoreModel = this.n;
                FrsViewData frsViewData = this.h;
                ArrayList<cn> T2 = frsLoadMoreModel.T(false, false, false, arrayList, null, frsViewData.adMixFloor, frsViewData.adShowSelect);
                if (T2 != null) {
                    this.h.setThreadList(T2);
                    this.o.V(T2, this.e, this.h, 0);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.h.getForum()));
            }
        }
    }

    public final void x2(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048638, this, responsedMessage) != null) || this.h == null || this.o == null || !(responsedMessage instanceof DownloadMessage) || (data = ((DownloadMessage) responsedMessage).getData()) == null) {
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

    public final void F2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.d != 0) {
                this.d = 1;
            }
            this.u = new sp7(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
            this.o.N(this.J);
            this.o.O(this.H);
            this.o.o().setOnTouchListener(new k(this));
        }
    }

    public final void J2() {
        eq7 eq7Var;
        HashMap<Integer, ThreadData> j2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (eq7Var = this.o) != null && eq7Var.n() != null && (j2 = this.o.n().j()) != null) {
            ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, ThreadData> entry : j2.entrySet()) {
                ThreadData value = entry.getValue();
                if (value != null && (value instanceof AdvertAppInfo)) {
                    arrayList.add((AdvertAppInfo) value);
                }
            }
            ei5.q().u(arrayList);
        }
    }

    public final void P2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (this.p == 0 && !this.n.Q(this.h.getThreadListIds())) {
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

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            super.onStop();
            ep6.b().e(false);
            vfa.g().h(getUniqueId(), false);
            FrsViewData frsViewData = this.h;
            if (frsViewData != null && frsViewData.getForum() != null) {
                bi5.j().x(getPageContext().getPageActivity(), "frs", this.h.getForum().getId(), 0L);
            }
            VoiceManager H0 = H0();
            this.i = H0;
            if (H0 != null) {
                H0.onStop(getPageContext());
            }
        }
    }

    public final void K2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            S2();
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
                I2();
                if (!this.o.n().o(ThreadData.TYPE_VIDEO_ALA_ONLIVE)) {
                    this.h.removeAlaLiveThreadData();
                }
                ArrayList<cn> threadList = this.h.getThreadList();
                if (threadList != null) {
                    this.o.V(threadList, this.e, this.h, this.h.getPage().b());
                    J2();
                    this.o.J();
                    if (this.h.getIsNewUrl() == 1) {
                        this.o.n().x(true);
                    } else {
                        this.o.n().x(false);
                    }
                    this.o.M(z2(B2().getType(), this.e));
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public final void R2(bga bgaVar) {
        eq7 eq7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048598, this, bgaVar) != null) || (eq7Var = this.o) == null) {
            return;
        }
        eq7Var.L(false);
        this.o.P(false);
        this.o.r();
        this.o.o().getData().clear();
        this.o.x();
        if (this.w == null) {
            sn5 sn5Var = new sn5(getPageContext().getContext(), getNetRefreshListener());
            this.w = sn5Var;
            sn5Var.d(null);
            this.w.b(null);
            this.w.e();
            this.w.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (bgaVar != null) {
            this.w.c(getPageContext().getResources().getString(R.string.net_error_text, bgaVar.d, Integer.valueOf(bgaVar.c)));
        } else {
            this.w.c(null);
        }
        this.w.onChangeSkinType();
        this.w.attachView(this.o.p(), true);
        this.w.a(0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        ThreadData threadDataById;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048613, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1 && i2 == 18003) {
                this.o.n().p();
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra != null && (threadDataById = this.h.getThreadDataById(stringExtra)) != null) {
                    int intExtra = intent.getIntExtra("type", -1);
                    if (intExtra == 2) {
                        threadDataById.setIs_good(intent.getIntExtra("good_data", 0));
                        threadDataById.parser_title();
                        H2(false);
                    } else if (intExtra == 0) {
                        this.h.removeThreadData(threadDataById);
                        ArrayList<cn> threadList = this.h.getThreadList();
                        if (threadList != null && threadList.size() <= 0) {
                            threadList.add(new ni7());
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
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            if (this.r == 3 && this.o == null) {
                return;
            }
            this.r = i2;
            super.onChangeSkinType(i2);
            eq7 eq7Var = this.o;
            if (eq7Var != null) {
                eq7Var.y(i2);
            }
            sn5 sn5Var = this.w;
            if (sn5Var != null && sn5Var.isViewAttached()) {
                this.w.onChangeSkinType();
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
            bundle.putBoolean("is_game_frs", this.f);
            this.m.Y(bundle);
            VoiceManager H0 = H0();
            this.i = H0;
            if (H0 != null) {
                H0.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, bundle) == null) {
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
            vfa.g().i(getUniqueId());
            FrsGoodModelController frsGoodModelController = new FrsGoodModelController(this);
            this.m = frsGoodModelController;
            if (arguments != null) {
                frsGoodModelController.T(arguments);
                this.f = arguments.getBoolean("is_game_frs", false);
            } else if (bundle != null) {
                frsGoodModelController.T(bundle);
                this.f = bundle.getBoolean("is_game_frs", false);
            } else {
                frsGoodModelController.T(null);
            }
            VoiceManager H0 = H0();
            this.i = H0;
            H0.onCreate(getPageContext());
            E2(bundle);
            registerListener(this.G);
            registerListener(this.D);
            registerListener(this.E);
            registerListener(this.K);
            registerListener(this.B);
            FrsLoadMoreModel frsLoadMoreModel = new FrsLoadMoreModel(this, null);
            this.n = frsLoadMoreModel;
            frsLoadMoreModel.registerListener();
            this.n.j0(2);
            this.n.h0(true);
            this.n.g0(py7.a(this.A));
            System.currentTimeMillis();
            this.y = UtilHelper.getScreenHeight(getActivity());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048616, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0369, (ViewGroup) null);
            eq7 eq7Var = new eq7(this, inflate, this.f);
            this.o = eq7Var;
            eq7Var.n().A();
            F2();
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            eq7 eq7Var = this.o;
            if (eq7Var != null) {
                eq7Var.z();
                this.o.O(null);
                if (this.o.o() != null) {
                    this.o.o().setOnTouchListener(null);
                }
            }
            MessageManager.getInstance().unRegisterListener(this.B);
            vfa.g().k(getUniqueId());
            ep6.b().e(false);
            super.onDestroy();
            this.m.X();
            VoiceManager H0 = H0();
            this.i = H0;
            H0.onDestory(getPageContext());
            SafeHandler.getInst().removeCallbacks(this.C);
        }
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

    public void w2(b35 b35Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048637, this, b35Var) == null) && b35Var != null && m1() != null && m1().getThreadList() != null) {
            if (ListUtils.isEmpty(m1().getThreadList())) {
                m1().getThreadList().add(b35Var);
            } else {
                if (m1().getThreadList().size() == 1 && (m1().getThreadList().get(0) instanceof ni7)) {
                    m1().getThreadList().remove(0);
                }
                m1().getThreadList().add(0, b35Var);
            }
            eq7 eq7Var = this.o;
            ArrayList<cn> threadList = this.h.getThreadList();
            int i2 = this.e;
            FrsViewData frsViewData = this.h;
            eq7Var.V(threadList, i2, frsViewData, frsViewData.getPage().b());
            this.o.J();
            this.o.M(0);
        }
    }
}
