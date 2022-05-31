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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
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
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ag;
import com.repackage.ai5;
import com.repackage.ai8;
import com.repackage.b9;
import com.repackage.bf8;
import com.repackage.di8;
import com.repackage.gk6;
import com.repackage.gw5;
import com.repackage.hf8;
import com.repackage.iz4;
import com.repackage.jg;
import com.repackage.ji;
import com.repackage.jn;
import com.repackage.lc6;
import com.repackage.li;
import com.repackage.lz4;
import com.repackage.mc6;
import com.repackage.me8;
import com.repackage.mg;
import com.repackage.mm6;
import com.repackage.n78;
import com.repackage.nb6;
import com.repackage.nc6;
import com.repackage.nk6;
import com.repackage.nm6;
import com.repackage.nn;
import com.repackage.o35;
import com.repackage.pf8;
import com.repackage.pg;
import com.repackage.pm6;
import com.repackage.rg5;
import com.repackage.rp4;
import com.repackage.rp6;
import com.repackage.sg5;
import com.repackage.tg5;
import com.repackage.tn;
import com.repackage.u68;
import com.repackage.um6;
import com.repackage.wf8;
import com.repackage.xn6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class FrsNewAreaFragment extends BaseFragment implements VoiceManager.j, gk6, UserIconBox.c, BdListView.p, FrsCommonImageLayout.e, lc6, ActivityCompat.OnRequestPermissionsResultCallback, n78, mc6, tg5, nc6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener A;
    public final wf8 B;
    public final CustomMessageListener C;
    public final RecyclerView.OnScrollListener D;
    public final CustomMessageListener E;
    public tn F;
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
    public nk6 n;
    public int o;
    public int p;
    public boolean q;
    public boolean r;
    public o35 s;
    public SparseArray<sg5> t;
    public int u;
    public int v;
    public boolean w;
    public CustomMessageListener x;
    public Runnable y;
    public CustomMessageListener z;

    /* loaded from: classes3.dex */
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
            nk6 nk6Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (nk6Var = this.a.n) == null || nk6Var.k() == null || this.a.n.k().isComputingLayout()) {
                return;
            }
            this.a.n.t();
        }
    }

    /* loaded from: classes3.dex */
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                this.a.h1(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements tn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsNewAreaFragment a;

        /* loaded from: classes3.dex */
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

        @Override // com.repackage.tn
        public void b(View view2, jn jnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, jnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) || bdUniqueId == null || jnVar == null || !(jnVar instanceof rp4)) {
                return;
            }
            ThreadData threadData = ((rp4) jnVar).s;
            if (threadData.getAnchorInfoData() == null || threadData.getAnchorInfoData().getGroup_id() == 0 || ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                if (threadData.getActInfoType() != 1 || ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                    di8 readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null && !readThreadHistory.d(threadData.getId())) {
                        readThreadHistory.a(threadData.getId());
                        nk6 nk6Var = this.a.n;
                        if (nk6Var != null) {
                            nk6Var.p();
                        }
                    }
                    String ad_url = threadData.getAd_url();
                    if (ad_url == null || ad_url.equals("")) {
                        z = false;
                    } else {
                        new Thread(new a(this, ad_url)).start();
                        z = true;
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
                    if (this.a.g == null || this.a.g.getForum() == null) {
                        return;
                    }
                    nm6 nm6Var = new nm6();
                    nm6Var.a = this.a.g.needLog == 1;
                    nm6Var.c = this.a.g.getForum().getId();
                    nm6Var.d = this.a.g.getForum().getName();
                    nm6Var.b = this.a.l.A();
                    nm6 nm6Var2 = pm6.f0;
                    if (nm6Var2 != null) {
                        nm6Var.e = nm6Var2.e;
                        nm6Var.f = nm6Var2.f;
                    }
                    mm6.e(threadData, 1, this.a.getUniqueId(), nm6Var, this.a.getTbPageTag());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer) || (num = (Integer) customResponsedMessage.getData()) == null || this.a.s == null || !this.a.s.isViewAttached()) {
                return;
            }
            this.a.s.a(num.intValue());
        }
    }

    /* loaded from: classes3.dex */
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
                if (!ji.z() || this.a.q) {
                    this.a.E1(null);
                } else {
                    this.a.s1(false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.H1(threadData.getPraise().getIsLike());
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 503) {
                if (this.a.k1() != null) {
                    this.a.k1().setSelection(0);
                }
                if (this.a.s != null && this.a.s.isViewAttached()) {
                    this.a.s1(false);
                    return;
                }
                nk6 nk6Var = this.a.n;
                if (nk6Var != null) {
                    nk6Var.L();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements wf8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public final /* synthetic */ FrsNewAreaFragment b;

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

        @Override // com.repackage.wf8
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.b.r) {
                return;
            }
            if (i == 1 || i == 2) {
                this.b.n.p();
            } else if (i != 3) {
            } else {
                this.b.n.A(true);
            }
        }

        @Override // com.repackage.wf8
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.repackage.wf8
        public void c(pf8 pf8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pf8Var) == null) {
            }
        }

        @Override // com.repackage.wf8
        public void d(int i, boolean z, hf8 hf8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), hf8Var}) == null) {
                if (this.b.r) {
                    if (this.b.n1().B() == null) {
                        this.b.r = false;
                        return;
                    } else if (this.b.n1().B().getThreadList().size() >= 10) {
                        this.b.r = false;
                        um6 um6Var = new um6();
                        um6Var.b = 301;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384, um6Var));
                        return;
                    }
                }
                if (hf8Var == null) {
                    this.a = 1L;
                } else if (hf8Var.b) {
                    this.a = 0L;
                } else {
                    this.a = 1L;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (i == 3) {
                    this.b.m.R();
                }
                this.b.n.A(false);
                if (this.b.n1().B() != null) {
                    FrsNewAreaFragment frsNewAreaFragment = this.b;
                    frsNewAreaFragment.g = frsNewAreaFragment.n1().B();
                }
                FrsNewAreaFragment frsNewAreaFragment2 = this.b;
                frsNewAreaFragment2.o = frsNewAreaFragment2.g.getPage().b();
                if (this.b.o == 0 && (this.b.g.getThreadListIds() == null || this.b.g.getThreadListIds().size() == 0)) {
                    if (this.b.g.getThreadList() != null && this.b.g.getThreadList().size() != 0) {
                        this.b.n.K();
                    } else {
                        this.b.n.m();
                    }
                } else {
                    this.b.n.J();
                }
                if (i != 4) {
                    if (i == 1) {
                        this.b.n.p();
                    } else if (i != 2) {
                        if (i == 3 && this.b.g.isShowRedTip()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, Boolean.TRUE));
                        }
                    } else {
                        this.b.n.p();
                    }
                    this.b.g();
                    if (this.a != 0) {
                        this.b.E1(hf8Var);
                    } else {
                        this.b.o1();
                        if (this.b.g != null) {
                            FrsNewAreaFragment frsNewAreaFragment3 = this.b;
                            frsNewAreaFragment3.b = frsNewAreaFragment3.g.getForum().getName();
                            FrsNewAreaFragment frsNewAreaFragment4 = this.b;
                            frsNewAreaFragment4.f = frsNewAreaFragment4.g.getForum().getId();
                            FrsNewAreaFragment frsNewAreaFragment5 = this.b;
                            frsNewAreaFragment5.n.s(frsNewAreaFragment5.g.getForum(), this.b.g.getUserData());
                        }
                        if (this.b.g != null) {
                            this.b.g.addNoticeThreadToThreadList();
                        }
                        if (this.b.g == null || this.b.g.getThreadList() == null || this.b.g.getThreadList().size() != 0 || this.b.n1().getType() != 4) {
                            if (this.b.g != null) {
                                ArrayList<jn> F = this.b.m.F(false, i == 3, true, this.b.g.getThreadList(), null, this.b.g.adMixFloor, this.b.g.adShowSelect);
                                if (F != null && F.size() > 0) {
                                    this.b.g.setThreadList(F);
                                }
                            }
                            this.b.x1();
                        } else {
                            FrsNewAreaFragment frsNewAreaFragment6 = this.b;
                            frsNewAreaFragment6.showToast(frsNewAreaFragment6.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c69));
                            if (this.b.e > 1) {
                                FrsNewAreaFragment.J0(this.b);
                            }
                            if (this.b.i > -1) {
                                long currentTimeMillis2 = System.currentTimeMillis();
                                FrsNewAreaFragment frsNewAreaFragment7 = this.b;
                                long D = frsNewAreaFragment7.n1().D();
                                FrsNewAreaFragment frsNewAreaFragment8 = this.b;
                                TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis2 - frsNewAreaFragment7.i, D - frsNewAreaFragment8.i, frsNewAreaFragment8.n1().F(), this.b.n1().E(), currentTimeMillis2 - this.b.n1().C());
                                this.b.i = -1L;
                            }
                            this.b.j = System.currentTimeMillis() - currentTimeMillis;
                            return;
                        }
                    }
                    if (this.b.i > -1) {
                        long currentTimeMillis3 = System.currentTimeMillis();
                        FrsNewAreaFragment frsNewAreaFragment9 = this.b;
                        long D2 = frsNewAreaFragment9.n1().D();
                        FrsNewAreaFragment frsNewAreaFragment10 = this.b;
                        TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis3 - frsNewAreaFragment9.i, D2 - frsNewAreaFragment10.i, frsNewAreaFragment10.n1().F(), this.b.n1().E(), currentTimeMillis3 - this.b.n1().C());
                        this.b.i = -1L;
                    }
                    this.b.j = System.currentTimeMillis() - currentTimeMillis;
                    System.gc();
                    return;
                }
                ArrayList<jn> F2 = this.b.m.F(false, false, false, this.b.g.getThreadList(), null, this.b.g.adMixFloor, this.b.g.adShowSelect);
                if (F2 != null) {
                    this.b.g.setThreadList(F2);
                    FrsNewAreaFragment frsNewAreaFragment11 = this.b;
                    frsNewAreaFragment11.n.H(F2, frsNewAreaFragment11.e, this.b.g, this.b.o);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
            nk6 nk6Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || (nk6Var = this.a.n) == null) {
                return;
            }
            nk6Var.L();
        }
    }

    /* loaded from: classes3.dex */
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
                ai8.o(this.a.b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsNewAreaFragment a;

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
            this.a = frsNewAreaFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) && i == 0) {
                gw5.b().e(true);
                bf8.g().h(this.a.getUniqueId(), true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                this.a.v += i2;
                if (this.a.v >= this.a.u * 2 && i2 < 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, Boolean.TRUE));
                }
                if (TbadkCoreApplication.isLogin() && TbSingleton.getInstance().showStampMissionDialog && UbsABTestHelper.isStampMissionDialogABTestB() && i2 > 0) {
                    me8.r().A(3, 2);
                    me8.r().G();
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

    public static /* synthetic */ int J0(FrsNewAreaFragment frsNewAreaFragment) {
        int i2 = frsNewAreaFragment.e;
        frsNewAreaFragment.e = i2 - 1;
        return i2;
    }

    public void A1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.b = str;
        }
    }

    @Override // com.repackage.lc6
    public void B0() {
        nk6 nk6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (nk6Var = this.n) == null || nk6Var.k() == null) {
            return;
        }
        this.n.k().scrollToPosition(0);
    }

    public void B1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.e = i2;
        }
    }

    public final void C1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.o == 0 && !this.m.C(this.g.getThreadListIds())) {
                if (this.g.getThreadList() != null && this.g.getThreadList().size() != 0) {
                    this.n.K();
                    return;
                } else {
                    this.n.m();
                    return;
                }
            }
            this.n.J();
        }
    }

    @Override // com.repackage.nc6
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            bf8.g().h(getUniqueId(), false);
        }
    }

    public final void D1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.n.B(false);
            showLoadingView(this.n.l(), true, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07028b));
        }
    }

    public final void E1(hf8 hf8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, hf8Var) == null) {
            this.n.B(false);
            this.n.G(false);
            this.n.m();
            this.n.k().getData().clear();
            this.n.p();
            if (this.s == null) {
                o35 o35Var = new o35(getPageContext().getContext(), getNetRefreshListener());
                this.s = o35Var;
                o35Var.e(null);
                this.s.c(null);
                this.s.f();
                this.s.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            if (hf8Var != null) {
                this.s.d(getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c32, hf8Var.d, Integer.valueOf(hf8Var.c)));
            } else {
                this.s.d(null);
            }
            this.s.onChangeSkinType();
            this.s.attachView(this.n.l(), true);
            this.s.a(0);
        }
    }

    public void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            VoiceManager voiceManager = getVoiceManager();
            this.h = voiceManager;
            voiceManager.stopPlay();
        }
    }

    @Override // com.repackage.lc6
    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    public final void G1(ThreadData threadData, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, threadData, i2) == null) {
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

    public final void H1(int i2) {
        ArrayList<jn> threadList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || (threadList = this.g.getThreadList()) == null) {
            return;
        }
        Iterator<jn> it = threadList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            jn next = it.next();
            if (next instanceof rp4) {
                ThreadData threadData = ((rp4) next).s;
                if (threadData.getId() != null && threadData.getId().equals(this.a)) {
                    G1(threadData, i2);
                    this.a = null;
                    break;
                }
            }
        }
        this.n.j().q(threadList, this.g);
        this.n.j().l();
    }

    @Override // com.repackage.n78
    public void L() {
        FrsNewAreaModelController frsNewAreaModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (frsNewAreaModelController = this.l) == null) {
            return;
        }
        frsNewAreaModelController.Q();
    }

    @Override // com.repackage.gk6, com.repackage.pc6
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    @Override // com.repackage.tg5
    public void dispatchInjectPluginMessage(rg5 rg5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, rg5Var) == null) {
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void e(ArrayList<jn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, arrayList) == null) {
            C1();
            if (arrayList == null || arrayList.size() == 0) {
                return;
            }
            FrsLoadMoreModel frsLoadMoreModel = this.m;
            FrsViewData frsViewData = this.g;
            ArrayList<jn> F = frsLoadMoreModel.F(false, false, false, arrayList, null, frsViewData.adMixFloor, frsViewData.adShowSelect);
            if (F != null) {
                this.g.setThreadList(F);
                this.n.H(F, this.e, this.g, 0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.g.getForum()));
        }
    }

    @Override // com.repackage.mc6
    public NavigationBar e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return null;
        }
        return (NavigationBar) invokeV.objValue;
    }

    public void f1(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, threadData) == null) || threadData == null) {
            return;
        }
        this.l.y(threadData);
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.n.B(true);
            hideLoadingView(this.n.l());
        }
    }

    public final void g1(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        ArrayList<jn> threadList = this.g.getThreadList();
        if (ListUtils.isEmpty(threadList) || this.n.k() == null || this.n.k().getData() == null) {
            return;
        }
        Iterator<jn> it = threadList.iterator();
        List<jn> data = this.n.k().getData();
        int i2 = 0;
        while (it.hasNext()) {
            jn next = it.next();
            if (next instanceof rp4) {
                ThreadData threadData = ((rp4) next).s;
                int i3 = 0;
                while (true) {
                    if (i3 >= list.size()) {
                        break;
                    } else if (StringHelper.equals(list.get(i3), threadData.getId())) {
                        it.remove();
                        data.remove(next);
                        this.m.N(next);
                        this.n.k().getAdapter().notifyItemRemoved(i2);
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            i2++;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public ag<TbImageView> getFrsCommonImageLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (getBaseFragmentActivity() instanceof FrsActivity) {
                return ((FrsActivity) getBaseFragmentActivity()).getFrsCommonImageLayoutPool();
            }
            return null;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.repackage.tg5
    public sg5 getInjectPlugin(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) ? this.t.get(i2) : (sg5) invokeI.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.repackage.gk6
    public /* bridge */ /* synthetic */ b9 getPageContext() {
        return super.getPageContext();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, voiceModel)) == null) {
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
            FrsViewData frsViewData = this.g;
            tbPageTag.sortType = xn6.g(frsViewData != null ? frsViewData.getSortType() : -1);
            tbPageTag.locatePage = "a071";
            return tbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public ag<TbImageView> getUserIconPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (getBaseFragmentActivity() instanceof FrsActivity) {
                return ((FrsActivity) getBaseFragmentActivity()).getUserIconPool();
            }
            return null;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (this.h == null) {
                this.h = VoiceManager.instance();
            }
            return this.h;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.repackage.gk6
    public FrsViewData h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.g : (FrsViewData) invokeV.objValue;
    }

    public final void h1(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, responsedMessage) == null) || this.g == null || this.n == null || !(responsedMessage instanceof DownloadMessage) || (data = ((DownloadMessage) responsedMessage).getData()) == null) {
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
            this.n.p();
        }
    }

    @Override // com.repackage.n78
    public TbPageContext<?> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? getPageContext() : (TbPageContext) invokeV.objValue;
    }

    public final void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13008");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", this.f);
            statisticItem.param("obj_type", 6);
            statisticItem.param("obj_locate", 2);
            statisticItem.eventStat();
        }
    }

    public nk6 j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.n : (nk6) invokeV.objValue;
    }

    public BdTypeRecyclerView k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            nk6 nk6Var = this.n;
            if (nk6Var == null) {
                return null;
            }
            return nk6Var.k();
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public final int l1(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048608, this, i2, i3)) == null) {
            if (i2 != 1) {
                return (i2 != 2 || i3 == 1) ? 0 : 3;
            }
            return 3;
        }
        return invokeII.intValue;
    }

    public void loadMore() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || this.m.isLoading || this.l.I()) {
            return;
        }
        if (this.m.C(this.g.getThreadListIds())) {
            String e2 = this.l.B() != null ? u68.e(this.l.B().getThreadList(), false) : "";
            this.n.H(this.m.P(), this.e, this.g, 0);
            this.m.Q(jg.g(this.f, 0L), this.g.getThreadListIds(), this.b, this.e, this.g.isBrandForum, e2);
        } else if (this.o != 0) {
            this.n.H(this.m.P(), this.e, this.g, 0);
            int i2 = this.e + 1;
            this.e = i2;
            this.l.J(i2);
            FrsLoadMoreModel frsLoadMoreModel = this.m;
            frsLoadMoreModel.loadingDone = false;
            frsLoadMoreModel.loadIndex = 0;
        }
    }

    @Override // com.repackage.nc6
    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            if (getPageContext() != null) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            }
            if (ji.z()) {
                ai5.c().f("page_frs_good");
                s1(true);
                return;
            }
            this.n.A(false);
        }
    }

    public FrsLoadMoreModel m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.m : (FrsLoadMoreModel) invokeV.objValue;
    }

    public FrsNewAreaModelController n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.l : (FrsNewAreaModelController) invokeV.objValue;
    }

    @Override // com.repackage.lc6
    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || this.n == null) {
            return;
        }
        B0();
        this.n.L();
    }

    public final void o1() {
        nk6 nk6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || (nk6Var = this.n) == null) {
            return;
        }
        nk6Var.B(true);
        this.n.G(true);
        o35 o35Var = this.s;
        if (o35Var == null || !o35Var.isViewAttached()) {
            return;
        }
        this.s.dettachView(this.n.l());
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        ThreadData threadDataById;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048615, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1 && i2 == 18003) {
                this.n.j().l();
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra == null || (threadDataById = this.g.getThreadDataById(stringExtra)) == null) {
                    return;
                }
                int intExtra = intent.getIntExtra("type", -1);
                if (intExtra == 2) {
                    threadDataById.setIs_good(intent.getIntExtra("good_data", 0));
                    threadDataById.parser_title();
                    s1(false);
                } else if (intExtra == 0) {
                    this.g.removeThreadData(threadDataById);
                    ArrayList<jn> threadList = this.g.getThreadList();
                    if (threadList != null && threadList.size() <= 0) {
                        threadList.add(new nb6());
                    }
                    this.n.z();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            if (this.p == 3 && this.n == null) {
                return;
            }
            this.p = i2;
            super.onChangeSkinType(i2);
            nk6 nk6Var = this.n;
            if (nk6Var != null) {
                nk6Var.q(i2);
            }
            o35 o35Var = this.s;
            if (o35Var == null || !o35Var.isViewAttached()) {
                return;
            }
            this.s.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, bundle) == null) {
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
            bf8.g().i(getUniqueId());
            FrsNewAreaModelController frsNewAreaModelController = new FrsNewAreaModelController(this);
            this.l = frsNewAreaModelController;
            if (arguments != null) {
                frsNewAreaModelController.H(arguments);
            } else if (bundle != null) {
                frsNewAreaModelController.H(bundle);
            } else {
                frsNewAreaModelController.H(null);
            }
            VoiceManager voiceManager = getVoiceManager();
            this.h = voiceManager;
            voiceManager.onCreate(getPageContext());
            q1(bundle);
            registerListener(this.C);
            registerListener(this.z);
            registerListener(this.A);
            registerListener(this.x);
            FrsLoadMoreModel frsLoadMoreModel = new FrsLoadMoreModel(this, null);
            this.m = frsLoadMoreModel;
            frsLoadMoreModel.registerListener();
            this.m.V(3);
            this.m.T(true);
            this.m.S(rp6.a(this.w));
            System.currentTimeMillis();
            this.u = UtilHelper.getScreenHeight(getActivity());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048618, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d030d, (ViewGroup) null);
            this.n = new nk6(this, inflate);
            r1();
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            nk6 nk6Var = this.n;
            if (nk6Var != null) {
                nk6Var.r();
            }
            MessageManager.getInstance().unRegisterListener(this.x);
            bf8.g().k(getUniqueId());
            gw5.b().e(false);
            super.onDestroy();
            this.l.K();
            VoiceManager voiceManager = getVoiceManager();
            this.h = voiceManager;
            voiceManager.onDestory(getPageContext());
            mg.a().removeCallbacks(this.y);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void onFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            C1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public nn onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            if (k1() == null) {
                return null;
            }
            return k1().getPreLoadHandle();
        }
        return (nn) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            super.onLazyLoad();
            if (this.q) {
                return;
            }
            if (ji.z()) {
                s1(false);
            } else {
                E1(null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            i1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048624, this) == null) && ji.z()) {
            s1(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            super.onPause();
            VoiceManager voiceManager = getVoiceManager();
            this.h = voiceManager;
            voiceManager.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                if (this.p == 3) {
                    onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                }
                if (this.q) {
                    return;
                }
                mg.a().post(this.y);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048627, this, i2, strArr, iArr) == null) && i2 == 1) {
            if (PermissionUtil.checkCamera(getActivity().getApplicationContext())) {
                SelectImageHelper.takePhoto(getPageContext());
            } else {
                showToast(R.string.obfuscated_res_0x7f0f134d);
            }
            ArrayMap<String, Boolean> transformPermissionResult = PermissionUtil.transformPermissionResult(strArr, iArr);
            if (!transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") || transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                return;
            }
            showToast(R.string.obfuscated_res_0x7f0f10a5);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            super.onResume();
            nk6 nk6Var = this.n;
            if (nk6Var != null) {
                nk6Var.p();
            }
            VoiceManager voiceManager = getVoiceManager();
            this.h = voiceManager;
            voiceManager.onResume(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("name", this.b);
            bundle.putString("from", this.c);
            this.l.L(bundle);
            VoiceManager voiceManager = getVoiceManager();
            this.h = voiceManager;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            if (!li.D()) {
                this.n.m();
            } else if (this.n.x()) {
            } else {
                if (!this.l.G()) {
                    this.n.m();
                    return;
                }
                C1();
                loadMore();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            super.onStart();
            VoiceManager voiceManager = getVoiceManager();
            this.h = voiceManager;
            voiceManager.onStart(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            super.onStop();
            gw5.b().e(false);
            bf8.g().h(getUniqueId(), false);
            FrsViewData frsViewData = this.g;
            if (frsViewData != null && frsViewData.getForum() != null) {
                iz4.j().x(getPageContext().getPageActivity(), "frs", this.g.getForum().getId(), 0L);
            }
            VoiceManager voiceManager = getVoiceManager();
            this.h = voiceManager;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
        }
    }

    public final void p1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            registerListener(2001118, this.E);
        }
    }

    public final void q1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, bundle) == null) {
            p1();
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
            if (TextUtils.isEmpty(this.c) || !FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.c)) {
                return;
            }
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    public final void r1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            if (this.d != 0) {
                this.d = 1;
            }
            this.n.E(this.F);
            this.n.F(this.D);
        }
    }

    @Override // com.repackage.n78
    public int s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.e : invokeV.intValue;
    }

    public final void s1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
            this.q = true;
            F1();
            o1();
            if (!z) {
                o1();
                D1();
            }
            FrsNewAreaModelController frsNewAreaModelController = this.l;
            if (frsNewAreaModelController != null) {
                frsNewAreaModelController.loadData();
            }
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, str) == null) {
            this.c = str;
        }
    }

    @Override // com.repackage.tg5
    public void setInjectPlugin(int i2, sg5 sg5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048639, this, i2, sg5Var) == null) {
            this.t.put(i2, sg5Var);
        }
    }

    public void t1(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048640, this, frsViewData) == null) || frsViewData == null) {
            return;
        }
        this.g = frsViewData;
        hideLoadingView(this.n.l());
        nk6 nk6Var = this.n;
        if (nk6Var != null) {
            nk6Var.A(false);
            this.n.H(null, this.e, this.g, this.o);
        }
    }

    public void u1(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, list) == null) {
            g1(list);
            int i2 = 0;
            for (jn jnVar : this.g.getThreadList()) {
                if (jnVar instanceof rp4) {
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

    public final void v1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            if (this.d == 1) {
                pg.a().b(new j(this));
            }
            this.d = 0;
        }
    }

    public final void w1() {
        nk6 nk6Var;
        HashMap<Integer, ThreadData> h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048643, this) == null) || (nk6Var = this.n) == null || nk6Var.j() == null || (h2 = this.n.j().h()) == null) {
            return;
        }
        ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
        for (Map.Entry<Integer, ThreadData> entry : h2.entrySet()) {
            ThreadData value = entry.getValue();
            if (value != null && (value instanceof AdvertAppInfo)) {
                arrayList.add((AdvertAppInfo) value);
            }
        }
        lz4.q().u(arrayList);
    }

    public final void x1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048644, this) == null) {
            F1();
            try {
                if (this.g == null) {
                    return;
                }
                this.n.y();
                this.n.I();
                this.b = this.g.getForum().getName();
                this.f = this.g.getForum().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.g.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.g.getUserData().getBimg_end_time());
                v1();
                ArrayList<jn> threadList = this.g.getThreadList();
                if (threadList != null) {
                    this.n.H(threadList, this.e, this.g, this.g.getPage().b());
                    w1();
                    this.n.z();
                    if (this.g.getIsNewUrl() == 1) {
                        this.n.j().r(true);
                    } else {
                        this.n.j().r(false);
                    }
                    this.n.C(l1(n1().getType(), this.e));
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    @Override // com.repackage.n78
    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? this.f : (String) invokeV.objValue;
    }

    public void y1() {
        nk6 nk6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048646, this) == null) || (nk6Var = this.n) == null || nk6Var.k() == null) {
            return;
        }
        this.n.k().post(new a(this));
    }

    public void z1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048647, this, i2) == null) {
            this.d = i2;
        }
    }
}
