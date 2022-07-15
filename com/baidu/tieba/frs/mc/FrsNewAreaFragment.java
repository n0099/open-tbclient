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
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ak5;
import com.repackage.c15;
import com.repackage.cy5;
import com.repackage.d9;
import com.repackage.dh8;
import com.repackage.do6;
import com.repackage.eg;
import com.repackage.eo6;
import com.repackage.f55;
import com.repackage.gm6;
import com.repackage.go6;
import com.repackage.gr6;
import com.repackage.ie6;
import com.repackage.je6;
import com.repackage.kd6;
import com.repackage.ke6;
import com.repackage.kh8;
import com.repackage.lo6;
import com.repackage.ng;
import com.repackage.ni;
import com.repackage.nm6;
import com.repackage.nn;
import com.repackage.oj8;
import com.repackage.op6;
import com.repackage.p98;
import com.repackage.pg8;
import com.repackage.pi;
import com.repackage.qg;
import com.repackage.qq4;
import com.repackage.ri5;
import com.repackage.rj8;
import com.repackage.rn;
import com.repackage.si5;
import com.repackage.tg;
import com.repackage.ti5;
import com.repackage.vg8;
import com.repackage.w88;
import com.repackage.xn;
import com.repackage.z05;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class FrsNewAreaFragment extends BaseFragment implements VoiceManager.j, gm6, UserIconBox.c, BdListView.p, FrsCommonImageLayout.e, ie6, ActivityCompat.OnRequestPermissionsResultCallback, p98, je6, ti5, ke6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener A;
    public final kh8 B;
    public final CustomMessageListener C;
    public final RecyclerView.OnScrollListener D;
    public final CustomMessageListener E;
    public xn F;
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
    public nm6 n;
    public int o;
    public int p;
    public boolean q;
    public boolean r;
    public f55 s;
    public SparseArray<si5> t;
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
            nm6 nm6Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (nm6Var = this.a.n) == null || nm6Var.l() == null || this.a.n.l().isComputingLayout()) {
                return;
            }
            this.a.n.w();
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
                this.a.W1(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements xn {
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

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) || bdUniqueId == null || nnVar == null || !(nnVar instanceof qq4)) {
                return;
            }
            ThreadData threadData = ((qq4) nnVar).s;
            if (threadData.getAnchorInfoData() == null || threadData.getAnchorInfoData().getGroup_id() == 0 || ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                if (threadData.getActInfoType() != 1 || ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                    rj8 readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null && !readThreadHistory.d(threadData.getId())) {
                        readThreadHistory.a(threadData.getId());
                        nm6 nm6Var = this.a.n;
                        if (nm6Var != null) {
                            nm6Var.q();
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
                    eo6 eo6Var = new eo6();
                    eo6Var.a = this.a.g.needLog == 1;
                    eo6Var.c = this.a.g.getForum().getId();
                    eo6Var.d = this.a.g.getForum().getName();
                    eo6Var.b = this.a.l.C();
                    eo6 eo6Var2 = go6.f0;
                    if (eo6Var2 != null) {
                        eo6Var.e = eo6Var2.e;
                        eo6Var.f = eo6Var2.f;
                    }
                    do6.e(threadData, 1, this.a.getUniqueId(), eo6Var, this.a.getTbPageTag());
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
                if (!ni.z() || this.a.q) {
                    this.a.t2(null);
                } else {
                    this.a.h2(false);
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
                this.a.w2(threadData.getPraise().getIsLike());
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
                if (this.a.Z1() != null) {
                    this.a.Z1().setSelection(0);
                }
                if (this.a.s != null && this.a.s.isViewAttached()) {
                    this.a.h2(false);
                    return;
                }
                nm6 nm6Var = this.a.n;
                if (nm6Var != null) {
                    nm6Var.O();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements kh8 {
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

        @Override // com.repackage.kh8
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.b.r) {
                return;
            }
            if (i == 1 || i == 2) {
                this.b.n.q();
            } else if (i != 3) {
            } else {
                this.b.n.D(true);
            }
        }

        @Override // com.repackage.kh8
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.repackage.kh8
        public void c(dh8 dh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dh8Var) == null) {
            }
        }

        @Override // com.repackage.kh8
        public void d(int i, boolean z, vg8 vg8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), vg8Var}) == null) {
                if (this.b.r) {
                    if (this.b.c2().D() == null) {
                        this.b.r = false;
                        return;
                    } else if (this.b.c2().D().getThreadList().size() >= 10) {
                        this.b.r = false;
                        lo6 lo6Var = new lo6();
                        lo6Var.b = 301;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384, lo6Var));
                        return;
                    }
                }
                if (vg8Var == null) {
                    this.a = 1L;
                } else if (vg8Var.b) {
                    this.a = 0L;
                } else {
                    this.a = 1L;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (i == 3) {
                    this.b.m.T();
                }
                this.b.n.D(false);
                if (this.b.c2().D() != null) {
                    FrsNewAreaFragment frsNewAreaFragment = this.b;
                    frsNewAreaFragment.g = frsNewAreaFragment.c2().D();
                }
                FrsNewAreaFragment frsNewAreaFragment2 = this.b;
                frsNewAreaFragment2.o = frsNewAreaFragment2.g.getPage().b();
                if (this.b.o == 0 && (this.b.g.getThreadListIds() == null || this.b.g.getThreadListIds().size() == 0)) {
                    if (this.b.g.getThreadList() != null && this.b.g.getThreadList().size() != 0) {
                        this.b.n.N();
                    } else {
                        this.b.n.n();
                    }
                } else {
                    this.b.n.M();
                }
                if (i != 4) {
                    if (i == 1) {
                        this.b.n.q();
                    } else if (i != 2) {
                        if (i == 3 && this.b.g.isShowRedTip()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, Boolean.TRUE));
                        }
                    } else {
                        this.b.n.q();
                    }
                    this.b.m();
                    if (this.a != 0) {
                        this.b.t2(vg8Var);
                    } else {
                        this.b.d2();
                        if (this.b.g != null) {
                            FrsNewAreaFragment frsNewAreaFragment3 = this.b;
                            frsNewAreaFragment3.b = frsNewAreaFragment3.g.getForum().getName();
                            FrsNewAreaFragment frsNewAreaFragment4 = this.b;
                            frsNewAreaFragment4.f = frsNewAreaFragment4.g.getForum().getId();
                            FrsNewAreaFragment frsNewAreaFragment5 = this.b;
                            frsNewAreaFragment5.n.v(frsNewAreaFragment5.g.getForum(), this.b.g.getUserData());
                        }
                        if (this.b.g != null) {
                            this.b.g.addNoticeThreadToThreadList();
                        }
                        if (this.b.g == null || this.b.g.getThreadList() == null || this.b.g.getThreadList().size() != 0 || this.b.c2().getType() != 4) {
                            if (this.b.g != null) {
                                ArrayList<nn> H = this.b.m.H(false, i == 3, true, this.b.g.getThreadList(), null, this.b.g.adMixFloor, this.b.g.adShowSelect);
                                if (H != null && H.size() > 0) {
                                    this.b.g.setThreadList(H);
                                }
                            }
                            this.b.m2();
                        } else {
                            FrsNewAreaFragment frsNewAreaFragment6 = this.b;
                            frsNewAreaFragment6.showToast(frsNewAreaFragment6.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c60));
                            if (this.b.e > 1) {
                                FrsNewAreaFragment.x1(this.b);
                            }
                            if (this.b.i > -1) {
                                long currentTimeMillis2 = System.currentTimeMillis();
                                FrsNewAreaFragment frsNewAreaFragment7 = this.b;
                                long F = frsNewAreaFragment7.c2().F();
                                FrsNewAreaFragment frsNewAreaFragment8 = this.b;
                                TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis2 - frsNewAreaFragment7.i, F - frsNewAreaFragment8.i, frsNewAreaFragment8.c2().H(), this.b.c2().G(), currentTimeMillis2 - this.b.c2().E());
                                this.b.i = -1L;
                            }
                            this.b.j = System.currentTimeMillis() - currentTimeMillis;
                            return;
                        }
                    }
                    if (this.b.i > -1) {
                        long currentTimeMillis3 = System.currentTimeMillis();
                        FrsNewAreaFragment frsNewAreaFragment9 = this.b;
                        long F2 = frsNewAreaFragment9.c2().F();
                        FrsNewAreaFragment frsNewAreaFragment10 = this.b;
                        TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis3 - frsNewAreaFragment9.i, F2 - frsNewAreaFragment10.i, frsNewAreaFragment10.c2().H(), this.b.c2().G(), currentTimeMillis3 - this.b.c2().E());
                        this.b.i = -1L;
                    }
                    this.b.j = System.currentTimeMillis() - currentTimeMillis;
                    System.gc();
                    return;
                }
                ArrayList<nn> H2 = this.b.m.H(false, false, false, this.b.g.getThreadList(), null, this.b.g.adMixFloor, this.b.g.adShowSelect);
                if (H2 != null) {
                    this.b.g.setThreadList(H2);
                    FrsNewAreaFragment frsNewAreaFragment11 = this.b;
                    frsNewAreaFragment11.n.K(H2, frsNewAreaFragment11.e, this.b.g, this.b.o);
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
            nm6 nm6Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || (nm6Var = this.a.n) == null) {
                return;
            }
            nm6Var.O();
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
                oj8.o(this.a.b);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                    cy5.b().e(true);
                    pg8.g().h(this.c.getUniqueId(), true);
                    this.c.n.s(this.a, this.b);
                }
                if (i == 1) {
                    this.c.n.r();
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
                if (this.c.v < this.c.u * 2 || i2 >= 0) {
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

    public static /* synthetic */ int x1(FrsNewAreaFragment frsNewAreaFragment) {
        int i2 = frsNewAreaFragment.e;
        frsNewAreaFragment.e = i2 - 1;
        return i2;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public eg<TbImageView> I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (getBaseFragmentActivity() instanceof FrsActivity) {
                return ((FrsActivity) getBaseFragmentActivity()).I();
            }
            return null;
        }
        return (eg) invokeV.objValue;
    }

    @Override // com.repackage.ti5
    public void L(ri5 ri5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ri5Var) == null) {
        }
    }

    @Override // com.repackage.je6
    public NavigationBar N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (NavigationBar) invokeV.objValue;
    }

    @Override // com.repackage.gm6
    public FrsViewData Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.g : (FrsViewData) invokeV.objValue;
    }

    @Override // com.repackage.ti5
    public si5 R0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.t.get(i2) : (si5) invokeI.objValue;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public eg<TbImageView> S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (getBaseFragmentActivity() instanceof FrsActivity) {
                return ((FrsActivity) getBaseFragmentActivity()).S();
            }
            return null;
        }
        return (eg) invokeV.objValue;
    }

    @Override // com.repackage.p98
    public String U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f : (String) invokeV.objValue;
    }

    public void U1(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, threadData) == null) || threadData == null) {
            return;
        }
        this.l.A(threadData);
    }

    public final void V1(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        ArrayList<nn> threadList = this.g.getThreadList();
        if (ListUtils.isEmpty(threadList) || this.n.l() == null || this.n.l().getData() == null) {
            return;
        }
        Iterator<nn> it = threadList.iterator();
        List<nn> data = this.n.l().getData();
        int i2 = 0;
        while (it.hasNext()) {
            nn next = it.next();
            if (next instanceof qq4) {
                ThreadData threadData = ((qq4) next).s;
                int i3 = 0;
                while (true) {
                    if (i3 >= list.size()) {
                        break;
                    } else if (StringHelper.equals(list.get(i3), threadData.getId())) {
                        it.remove();
                        data.remove(next);
                        this.m.P(next);
                        this.n.l().getAdapter().notifyItemRemoved(i2);
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            i2++;
        }
    }

    @Override // com.repackage.ke6
    public void W0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (getPageContext() != null) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            }
            if (ni.z()) {
                ak5.c().f("page_frs_good");
                h2(true);
                return;
            }
            this.n.D(false);
        }
    }

    public final void W1(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, responsedMessage) == null) || this.g == null || this.n == null || !(responsedMessage instanceof DownloadMessage) || (data = ((DownloadMessage) responsedMessage).getData()) == null) {
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
            this.n.q();
        }
    }

    public final void X1() {
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

    public nm6 Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.n : (nm6) invokeV.objValue;
    }

    public BdTypeRecyclerView Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            nm6 nm6Var = this.n;
            if (nm6Var == null) {
                return null;
            }
            return nm6Var.l();
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public final int a2(int i2, int i3) {
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

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.m.isLoading || this.l.K()) {
            return;
        }
        if (this.m.E(this.g.getThreadListIds())) {
            String e2 = this.l.D() != null ? w88.e(this.l.D().getThreadList(), false) : "";
            this.n.K(this.m.R(), this.e, this.g, 0);
            this.m.S(ng.g(this.f, 0L), this.g.getThreadListIds(), this.b, this.e, this.g.isBrandForum, e2);
        } else if (this.o != 0) {
            this.n.K(this.m.R(), this.e, this.g, 0);
            int i2 = this.e + 1;
            this.e = i2;
            this.l.L(i2);
            FrsLoadMoreModel frsLoadMoreModel = this.m;
            frsLoadMoreModel.loadingDone = false;
            frsLoadMoreModel.loadIndex = 0;
        }
    }

    public FrsLoadMoreModel b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.m : (FrsLoadMoreModel) invokeV.objValue;
    }

    @Override // com.repackage.gm6, com.repackage.me6
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public FrsNewAreaModelController c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.l : (FrsNewAreaModelController) invokeV.objValue;
    }

    @Override // com.repackage.ke6
    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            pg8.g().h(getUniqueId(), false);
        }
    }

    @Override // com.repackage.p98
    public int d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.e : invokeV.intValue;
    }

    public final void d2() {
        nm6 nm6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (nm6Var = this.n) == null) {
            return;
        }
        nm6Var.E(true);
        this.n.J(true);
        f55 f55Var = this.s;
        if (f55Var == null || !f55Var.isViewAttached()) {
            return;
        }
        this.s.dettachView(this.n.m());
    }

    public final void e2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            registerListener(2001118, this.E);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i f1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    public final void f2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bundle) == null) {
            e2();
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

    public final void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (this.d != 0) {
                this.d = 1;
            }
            this.n.H(this.F);
            this.n.I(this.D);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.repackage.gm6
    public /* bridge */ /* synthetic */ d9 getPageContext() {
        return super.getPageContext();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            TbPageTag tbPageTag = super.getTbPageTag();
            FrsViewData frsViewData = this.g;
            tbPageTag.sortType = op6.g(frsViewData != null ? frsViewData.getSortType() : -1);
            tbPageTag.locatePage = "a071";
            return tbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void h(ArrayList<nn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, arrayList) == null) {
            r2();
            if (arrayList == null || arrayList.size() == 0) {
                return;
            }
            FrsLoadMoreModel frsLoadMoreModel = this.m;
            FrsViewData frsViewData = this.g;
            ArrayList<nn> H = frsLoadMoreModel.H(false, false, false, arrayList, null, frsViewData.adMixFloor, frsViewData.adShowSelect);
            if (H != null) {
                this.g.setThreadList(H);
                this.n.K(H, this.e, this.g, 0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.g.getForum()));
        }
    }

    public final void h2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.q = true;
            u2();
            d2();
            if (!z) {
                d2();
                s2();
            }
            FrsNewAreaModelController frsNewAreaModelController = this.l;
            if (frsNewAreaModelController != null) {
                frsNewAreaModelController.loadData();
            }
        }
    }

    @Override // com.repackage.ie6
    public void i0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
        }
    }

    public void i2(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, frsViewData) == null) || frsViewData == null) {
            return;
        }
        this.g = frsViewData;
        hideLoadingView(this.n.m());
        nm6 nm6Var = this.n;
        if (nm6Var != null) {
            nm6Var.D(false);
            this.n.K(null, this.e, this.g, this.o);
        }
    }

    public void j2(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, list) == null) {
            V1(list);
            int i2 = 0;
            for (nn nnVar : this.g.getThreadList()) {
                if (nnVar instanceof qq4) {
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

    public final void k2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            if (this.d == 1) {
                tg.a().b(new j(this));
            }
            this.d = 0;
        }
    }

    public final void l2() {
        nm6 nm6Var;
        HashMap<Integer, ThreadData> h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (nm6Var = this.n) == null || nm6Var.k() == null || (h2 = this.n.k().h()) == null) {
            return;
        }
        ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
        for (Map.Entry<Integer, ThreadData> entry : h2.entrySet()) {
            ThreadData value = entry.getValue();
            if (value != null && (value instanceof AdvertAppInfo)) {
                arrayList.add((AdvertAppInfo) value);
            }
        }
        c15.q().u(arrayList);
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.n.E(true);
            hideLoadingView(this.n.m());
        }
    }

    public final void m2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            u2();
            try {
                if (this.g == null) {
                    return;
                }
                this.n.B();
                this.n.L();
                this.b = this.g.getForum().getName();
                this.f = this.g.getForum().getId();
                TbadkCoreApplication.getInst().setDefaultBubble(this.g.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.g.getUserData().getBimg_end_time());
                k2();
                ArrayList<nn> threadList = this.g.getThreadList();
                if (threadList != null) {
                    this.n.K(threadList, this.e, this.g, this.g.getPage().b());
                    l2();
                    this.n.C();
                    if (this.g.getIsNewUrl() == 1) {
                        this.n.k().r(true);
                    } else {
                        this.n.k().r(false);
                    }
                    this.n.F(a2(c2().getType(), this.e));
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    @Override // com.repackage.p98
    public void n0() {
        FrsNewAreaModelController frsNewAreaModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || (frsNewAreaModelController = this.l) == null) {
            return;
        }
        frsNewAreaModelController.S();
    }

    public void n2() {
        nm6 nm6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || (nm6Var = this.n) == null || nm6Var.l() == null) {
            return;
        }
        this.n.l().post(new a(this));
    }

    @Override // com.repackage.p98
    public TbPageContext<?> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? getPageContext() : (TbPageContext) invokeV.objValue;
    }

    public void o2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            this.d = i2;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        ThreadData threadDataById;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048617, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1 && i2 == 18003) {
                this.n.k().l();
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra == null || (threadDataById = this.g.getThreadDataById(stringExtra)) == null) {
                    return;
                }
                int intExtra = intent.getIntExtra("type", -1);
                if (intExtra == 2) {
                    threadDataById.setIs_good(intent.getIntExtra("good_data", 0));
                    threadDataById.parser_title();
                    h2(false);
                } else if (intExtra == 0) {
                    this.g.removeThreadData(threadDataById);
                    ArrayList<nn> threadList = this.g.getThreadList();
                    if (threadList != null && threadList.size() <= 0) {
                        threadList.add(new kd6());
                    }
                    this.n.C();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            if (this.p == 3 && this.n == null) {
                return;
            }
            this.p = i2;
            super.onChangeSkinType(i2);
            nm6 nm6Var = this.n;
            if (nm6Var != null) {
                nm6Var.t(i2);
            }
            f55 f55Var = this.s;
            if (f55Var == null || !f55Var.isViewAttached()) {
                return;
            }
            this.s.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, bundle) == null) {
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
            pg8.g().i(getUniqueId());
            FrsNewAreaModelController frsNewAreaModelController = new FrsNewAreaModelController(this);
            this.l = frsNewAreaModelController;
            if (arguments != null) {
                frsNewAreaModelController.J(arguments);
            } else if (bundle != null) {
                frsNewAreaModelController.J(bundle);
            } else {
                frsNewAreaModelController.J(null);
            }
            VoiceManager u0 = u0();
            this.h = u0;
            u0.onCreate(getPageContext());
            f2(bundle);
            registerListener(this.C);
            registerListener(this.z);
            registerListener(this.A);
            registerListener(this.x);
            FrsLoadMoreModel frsLoadMoreModel = new FrsLoadMoreModel(this, null);
            this.m = frsLoadMoreModel;
            frsLoadMoreModel.registerListener();
            this.m.X(3);
            this.m.V(true);
            this.m.U(gr6.a(this.w));
            System.currentTimeMillis();
            this.u = UtilHelper.getScreenHeight(getActivity());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048620, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0309, (ViewGroup) null);
            this.n = new nm6(this, inflate);
            g2();
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            nm6 nm6Var = this.n;
            if (nm6Var != null) {
                nm6Var.u();
            }
            MessageManager.getInstance().unRegisterListener(this.x);
            pg8.g().k(getUniqueId());
            cy5.b().e(false);
            super.onDestroy();
            this.l.M();
            VoiceManager u0 = u0();
            this.h = u0;
            u0.onDestory(getPageContext());
            qg.a().removeCallbacks(this.y);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void onFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            r2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public rn onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            if (Z1() == null) {
                return null;
            }
            return Z1().getPreLoadHandle();
        }
        return (rn) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            super.onLazyLoad();
            if (this.q) {
                return;
            }
            if (ni.z()) {
                h2(false);
            } else {
                t2(null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            X1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048626, this) == null) && ni.z()) {
            h2(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            super.onPause();
            VoiceManager u0 = u0();
            this.h = u0;
            u0.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                if (this.p == 3) {
                    onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                }
                if (this.q) {
                    return;
                }
                qg.a().post(this.y);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048629, this, i2, strArr, iArr) == null) && i2 == 1) {
            if (PermissionUtil.checkCamera(getActivity().getApplicationContext())) {
                SelectImageHelper.takePhoto(getPageContext());
            } else {
                showToast(R.string.obfuscated_res_0x7f0f1353);
            }
            ArrayMap<String, Boolean> transformPermissionResult = PermissionUtil.transformPermissionResult(strArr, iArr);
            if (!transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") || transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                return;
            }
            showToast(R.string.obfuscated_res_0x7f0f10a7);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            super.onResume();
            nm6 nm6Var = this.n;
            if (nm6Var != null) {
                nm6Var.q();
            }
            VoiceManager u0 = u0();
            this.h = u0;
            u0.onResume(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("name", this.b);
            bundle.putString("from", this.c);
            this.l.N(bundle);
            VoiceManager u0 = u0();
            this.h = u0;
            if (u0 != null) {
                u0.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            if (!pi.D()) {
                this.n.n();
            } else if (this.n.A()) {
            } else {
                if (!this.l.I()) {
                    this.n.n();
                    return;
                }
                r2();
                b();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            super.onStart();
            VoiceManager u0 = u0();
            this.h = u0;
            u0.onStart(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            super.onStop();
            cy5.b().e(false);
            pg8.g().h(getUniqueId(), false);
            FrsViewData frsViewData = this.g;
            if (frsViewData != null && frsViewData.getForum() != null) {
                z05.j().x(getPageContext().getPageActivity(), "frs", this.g.getForum().getId(), 0L);
            }
            VoiceManager u0 = u0();
            this.h = u0;
            if (u0 != null) {
                u0.onStop(getPageContext());
            }
        }
    }

    @Override // com.repackage.ie6
    public void p1() {
        nm6 nm6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048635, this) == null) || (nm6Var = this.n) == null || nm6Var.l() == null) {
            return;
        }
        this.n.l().scrollToPosition(0);
    }

    public void p2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, str) == null) {
            this.b = str;
        }
    }

    @Override // com.repackage.ti5
    public void q0(int i2, si5 si5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048637, this, i2, si5Var) == null) {
            this.t.put(i2, si5Var);
        }
    }

    public void q2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i2) == null) {
            this.e = i2;
        }
    }

    public final void r2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            if (this.o == 0 && !this.m.E(this.g.getThreadListIds())) {
                if (this.g.getThreadList() != null && this.g.getThreadList().size() != 0) {
                    this.n.N();
                    return;
                } else {
                    this.n.n();
                    return;
                }
            }
            this.n.M();
        }
    }

    public final void s2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            this.n.E(false);
            showLoadingView(this.n.m(), true, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07028a));
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, str) == null) {
            this.c = str;
        }
    }

    public final void t2(vg8 vg8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, vg8Var) == null) {
            this.n.E(false);
            this.n.J(false);
            this.n.n();
            this.n.l().getData().clear();
            this.n.q();
            if (this.s == null) {
                f55 f55Var = new f55(getPageContext().getContext(), getNetRefreshListener());
                this.s = f55Var;
                f55Var.e(null);
                this.s.c(null);
                this.s.f();
                this.s.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            if (vg8Var != null) {
                this.s.d(getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c2a, vg8Var.d, Integer.valueOf(vg8Var.c)));
            } else {
                this.s.d(null);
            }
            this.s.onChangeSkinType();
            this.s.attachView(this.n.m(), true);
            this.s.a(0);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            if (this.h == null) {
                this.h = VoiceManager.instance();
            }
            return this.h;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public void u2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048644, this) == null) {
            VoiceManager u0 = u0();
            this.h = u0;
            u0.stopPlay();
        }
    }

    public final void v2(ThreadData threadData, int i2) {
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

    @Override // com.repackage.ie6
    public void w() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048646, this) == null) || this.n == null) {
            return;
        }
        p1();
        this.n.O();
    }

    public final void w2(int i2) {
        ArrayList<nn> threadList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048647, this, i2) == null) || (threadList = this.g.getThreadList()) == null) {
            return;
        }
        Iterator<nn> it = threadList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            nn next = it.next();
            if (next instanceof qq4) {
                ThreadData threadData = ((qq4) next).s;
                if (threadData.getId() != null && threadData.getId().equals(this.a)) {
                    v2(threadData, i2);
                    this.a = null;
                    break;
                }
            }
        }
        this.n.k().q(threadList, this.g);
        this.n.k().l();
    }
}
