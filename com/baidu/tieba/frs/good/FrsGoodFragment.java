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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
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
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a15;
import com.repackage.ak5;
import com.repackage.cy5;
import com.repackage.d15;
import com.repackage.d9;
import com.repackage.dh8;
import com.repackage.do6;
import com.repackage.eg;
import com.repackage.eo6;
import com.repackage.g55;
import com.repackage.gm6;
import com.repackage.go6;
import com.repackage.gr6;
import com.repackage.ie6;
import com.repackage.je6;
import com.repackage.kd6;
import com.repackage.ke6;
import com.repackage.kh8;
import com.repackage.kk6;
import com.repackage.lo6;
import com.repackage.mp4;
import com.repackage.ng;
import com.repackage.ni;
import com.repackage.nn;
import com.repackage.oj8;
import com.repackage.op6;
import com.repackage.p98;
import com.repackage.pg8;
import com.repackage.pi;
import com.repackage.qg;
import com.repackage.ri5;
import com.repackage.rj8;
import com.repackage.rn;
import com.repackage.rq4;
import com.repackage.si5;
import com.repackage.tg;
import com.repackage.ti5;
import com.repackage.uk6;
import com.repackage.vg8;
import com.repackage.w88;
import com.repackage.xn;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class FrsGoodFragment extends BaseFragment implements VoiceManager.j, gm6, UserIconBox.c, BdListView.p, FrsCommonImageLayout.e, ie6, ActivityCompat.OnRequestPermissionsResultCallback, p98, je6, ti5, ke6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public CustomMessageListener B;
    public Runnable C;
    public CustomMessageListener D;
    public CustomMessageListener E;
    public final kh8 F;
    public final CustomMessageListener G;
    public final RecyclerView.OnScrollListener H;
    public final CustomMessageListener I;
    public xn J;
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
    public uk6 o;
    public int p;
    public int q;
    public int r;
    public boolean s;
    public SparseArray<si5> t;
    public kk6 u;
    public boolean v;
    public g55 w;
    public String x;
    public int y;
    public int z;

    /* loaded from: classes3.dex */
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
                cy5.b().e(true);
                pg8.g().h(this.a.getUniqueId(), true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                this.a.z += i2;
                if (this.a.z < this.a.y * 2 || i2 >= 0) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes3.dex */
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                this.a.U1(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsGoodFragment a;

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

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) || bdUniqueId == null || nnVar == null || !(nnVar instanceof rq4)) {
                return;
            }
            ThreadData threadData = ((rq4) nnVar).s;
            if (threadData.getAnchorInfoData() == null || threadData.getAnchorInfoData().getGroup_id() == 0 || ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                if (threadData.getActInfoType() != 1 || ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                    rj8 readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null && !readThreadHistory.d(threadData.getId())) {
                        readThreadHistory.a(threadData.getId());
                        uk6 uk6Var = this.a.o;
                        if (uk6Var != null) {
                            uk6Var.v();
                        }
                    }
                    String ad_url = threadData.getAd_url();
                    if (ad_url == null || ad_url.equals("")) {
                        z = false;
                    } else {
                        new Thread(new a(this, ad_url)).start();
                        z = true;
                    }
                    String tid = threadData != null ? threadData.getTid() : null;
                    if (tid == null) {
                        tid = "";
                    }
                    if (threadData.getIs_top() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{tid, "", null});
                        return;
                    }
                    if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && tid.length() > 3 && tid.length() > 3) {
                        threadData.setId(tid.substring(3));
                    }
                    PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.a.getPageContext().getPageActivity()).createFromThreadCfg(threadData, this.a.b, "frs_page", 18003, true, false, z);
                    createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
                    createFromThreadCfg.setStartFrom(3);
                    this.a.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                    if (this.a.h == null || this.a.h.getForum() == null) {
                        return;
                    }
                    eo6 eo6Var = new eo6();
                    eo6Var.a = this.a.h.needLog == 1;
                    eo6Var.c = this.a.h.getForum().getId();
                    eo6Var.d = this.a.h.getForum().getName();
                    eo6 eo6Var2 = go6.p0;
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
            uk6 uk6Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || (uk6Var = this.a.o) == null) {
                return;
            }
            uk6Var.y();
        }
    }

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer) || (num = (Integer) customResponsedMessage.getData()) == null || this.a.w == null || !this.a.w.isViewAttached()) {
                return;
            }
            this.a.w.a(num.intValue());
        }
    }

    /* loaded from: classes3.dex */
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
                if (!ni.z() || this.a.s) {
                    this.a.o2(null);
                } else {
                    this.a.e2(false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.r2(threadData.getPraise().getIsLike());
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 301) {
                if (this.a.V1() != null) {
                    this.a.V1().setSelection(0);
                }
                if (this.a.w != null && this.a.w.isViewAttached()) {
                    this.a.e2(false);
                    return;
                }
                uk6 uk6Var = this.a.o;
                if (uk6Var != null) {
                    uk6Var.Z();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements kh8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public final /* synthetic */ FrsGoodFragment b;

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

        @Override // com.repackage.kh8
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.b.v) {
                return;
            }
            if (i == 1 || i == 2) {
                this.b.o.v();
            } else if (i != 3) {
            } else {
                this.b.o.I(true);
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
            ArrayList<nn> H;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), vg8Var}) == null) {
                if (this.b.v) {
                    if (this.b.Y1().B() == null) {
                        this.b.v = false;
                        return;
                    } else if (this.b.Y1().B().getThreadList().size() >= 10) {
                        this.b.v = false;
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
                    this.b.n.T();
                }
                this.b.o.I(false);
                if (this.b.Y1().B() != null) {
                    FrsGoodFragment frsGoodFragment = this.b;
                    frsGoodFragment.h = frsGoodFragment.Y1().B();
                }
                FrsGoodFragment frsGoodFragment2 = this.b;
                frsGoodFragment2.p = frsGoodFragment2.h.getPage().b();
                if (this.b.p != 0 || (this.b.h.getThreadListIds() != null && this.b.h.getThreadListIds().size() != 0)) {
                    if (ListUtils.getCount(this.b.h.getThreadList()) > 3) {
                        this.b.o.X();
                    } else {
                        this.b.o.U();
                    }
                } else if (this.b.h.getThreadList() != null && this.b.h.getThreadList().size() != 0) {
                    this.b.o.Y();
                } else {
                    this.b.o.p();
                }
                if (i != 4) {
                    if (i == 1) {
                        this.b.o.v();
                    } else if (i != 2) {
                        if (i == 3 && this.b.h.isShowRedTip()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, Boolean.TRUE));
                        }
                    } else {
                        this.b.o.v();
                    }
                    this.b.m();
                    if (this.a != 0) {
                        this.b.o2(vg8Var);
                    } else {
                        if (this.b.h != null) {
                            FrsGoodFragment frsGoodFragment3 = this.b;
                            frsGoodFragment3.b = frsGoodFragment3.h.getForum().getName();
                            FrsGoodFragment frsGoodFragment4 = this.b;
                            frsGoodFragment4.g = frsGoodFragment4.h.getForum().getId();
                            FrsGoodFragment frsGoodFragment5 = this.b;
                            frsGoodFragment5.o.z(frsGoodFragment5.h.getForum(), this.b.h.getUserData());
                        }
                        if (this.b.h != null) {
                            this.b.h.addNoticeThreadToThreadList();
                        }
                        FrsGoodFragment frsGoodFragment6 = this.b;
                        frsGoodFragment6.o.O(frsGoodFragment6.h);
                        if (this.b.h == null || this.b.h.getThreadList() == null || this.b.h.getThreadList().size() != 0 || this.b.Y1().getType() != 4) {
                            if (this.b.h != null && (H = this.b.n.H(false, false, true, this.b.h.getThreadList(), null, this.b.h.adMixFloor, this.b.h.adShowSelect)) != null && H.size() > 0) {
                                this.b.h.setThreadList(H);
                            }
                            this.b.h2();
                        } else {
                            FrsGoodFragment frsGoodFragment7 = this.b;
                            frsGoodFragment7.showToast(frsGoodFragment7.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c4c));
                            if (this.b.e > 1) {
                                FrsGoodFragment.A1(this.b);
                            }
                            if (this.b.j > -1) {
                                long currentTimeMillis2 = System.currentTimeMillis();
                                FrsGoodFragment frsGoodFragment8 = this.b;
                                long D = frsGoodFragment8.Y1().D();
                                FrsGoodFragment frsGoodFragment9 = this.b;
                                TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis2 - frsGoodFragment8.j, D - frsGoodFragment9.j, frsGoodFragment9.Y1().F(), this.b.Y1().E(), currentTimeMillis2 - this.b.Y1().C());
                                this.b.j = -1L;
                            }
                            this.b.k = System.currentTimeMillis() - currentTimeMillis;
                            return;
                        }
                    }
                    if (this.b.j > -1) {
                        long currentTimeMillis3 = System.currentTimeMillis();
                        FrsGoodFragment frsGoodFragment10 = this.b;
                        long D2 = frsGoodFragment10.Y1().D();
                        FrsGoodFragment frsGoodFragment11 = this.b;
                        TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis3 - frsGoodFragment10.j, D2 - frsGoodFragment11.j, frsGoodFragment11.Y1().F(), this.b.Y1().E(), currentTimeMillis3 - this.b.Y1().C());
                        this.b.j = -1L;
                    }
                    this.b.k = System.currentTimeMillis() - currentTimeMillis;
                    System.gc();
                    return;
                }
                ArrayList<nn> H2 = this.b.n.H(false, false, false, this.b.h.getThreadList(), null, this.b.h.adMixFloor, this.b.h.adShowSelect);
                if (H2 != null) {
                    this.b.h.setThreadList(H2);
                    FrsGoodFragment frsGoodFragment12 = this.b;
                    frsGoodFragment12.o.T(H2, frsGoodFragment12.e, this.b.h, this.b.p);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
            uk6 uk6Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || (uk6Var = this.a.o) == null) {
                return;
            }
            uk6Var.Z();
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
                oj8.o(this.a.b);
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

    public static /* synthetic */ int A1(FrsGoodFragment frsGoodFragment) {
        int i2 = frsGoodFragment.e;
        frsGoodFragment.e = i2 - 1;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.h : (FrsViewData) invokeV.objValue;
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

    public void T1(mp4 mp4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, mp4Var) == null) || mp4Var == null || Q0() == null || Q0().getThreadList() == null) {
            return;
        }
        if (ListUtils.isEmpty(Q0().getThreadList())) {
            Q0().getThreadList().add(mp4Var);
        } else {
            if (Q0().getThreadList().size() == 1 && (Q0().getThreadList().get(0) instanceof kd6)) {
                Q0().getThreadList().remove(0);
            }
            Q0().getThreadList().add(0, mp4Var);
        }
        uk6 uk6Var = this.o;
        ArrayList<nn> threadList = this.h.getThreadList();
        int i2 = this.e;
        FrsViewData frsViewData = this.h;
        uk6Var.T(threadList, i2, frsViewData, frsViewData.getPage().b());
        this.o.H();
        this.o.K(0);
    }

    @Override // com.repackage.p98
    public String U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.g : (String) invokeV.objValue;
    }

    public final void U1(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, responsedMessage) == null) || this.h == null || this.o == null || !(responsedMessage instanceof DownloadMessage) || (data = ((DownloadMessage) responsedMessage).getData()) == null) {
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
            this.o.v();
        }
    }

    public BdTypeRecyclerView V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            uk6 uk6Var = this.o;
            if (uk6Var == null) {
                return null;
            }
            return uk6Var.n();
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    @Override // com.repackage.ke6
    public void W0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (getPageContext() != null) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            }
            if (ni.z()) {
                ak5.c().f("page_frs_good");
                e2(true);
                return;
            }
            this.o.I(false);
        }
    }

    public final int W1(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048587, this, i2, i3)) == null) {
            if (i2 != 1) {
                return (i2 != 2 || i3 == 1) ? 0 : 3;
            }
            return 3;
        }
        return invokeII.intValue;
    }

    public FrsLoadMoreModel X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.n : (FrsLoadMoreModel) invokeV.objValue;
    }

    public FrsGoodModelController Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.m : (FrsGoodModelController) invokeV.objValue;
    }

    public final void Z1() {
        uk6 uk6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (uk6Var = this.o) == null) {
            return;
        }
        uk6Var.J(true);
        this.o.N(true);
        g55 g55Var = this.w;
        if (g55Var == null || !g55Var.isViewAttached()) {
            return;
        }
        this.w.dettachView(this.o.o());
    }

    public final void a2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            registerListener(2001118, this.I);
        }
    }

    public final void b2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            a2();
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

    @Override // com.repackage.gm6, com.repackage.me6
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public final void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (this.d != 0) {
                this.d = 1;
            }
            this.u = new kk6(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
            this.o.L(this.J);
            this.o.M(this.H);
            this.o.n().setOnTouchListener(new k(this));
        }
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

    public void d2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.q = i2;
            if (ni.z()) {
                e2(false);
            } else {
                o2(null);
            }
        }
    }

    public final void e2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.s = true;
            p2();
            Z1();
            if (!z) {
                Z1();
                n2();
            }
            FrsGoodModelController frsGoodModelController = this.m;
            if (frsGoodModelController != null) {
                frsGoodModelController.J(this.q);
            }
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

    public final void f2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (this.d == 1) {
                tg.a().b(new l(this));
            }
            this.d = 0;
        }
    }

    public final void g2() {
        uk6 uk6Var;
        HashMap<Integer, ThreadData> j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (uk6Var = this.o) == null || uk6Var.m() == null || (j2 = this.o.m().j()) == null) {
            return;
        }
        ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
        for (Map.Entry<Integer, ThreadData> entry : j2.entrySet()) {
            ThreadData value = entry.getValue();
            if (value != null && (value instanceof AdvertAppInfo)) {
                arrayList.add((AdvertAppInfo) value);
            }
        }
        d15.q().u(arrayList);
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
            FrsViewData frsViewData = this.h;
            tbPageTag.sortType = op6.g(frsViewData != null ? frsViewData.getSortType() : -1);
            tbPageTag.locatePage = "a072";
            return tbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void h(ArrayList<nn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, arrayList) == null) {
            m2();
            if (arrayList == null || arrayList.size() == 0) {
                return;
            }
            FrsLoadMoreModel frsLoadMoreModel = this.n;
            FrsViewData frsViewData = this.h;
            ArrayList<nn> H = frsLoadMoreModel.H(false, false, false, arrayList, null, frsViewData.adMixFloor, frsViewData.adShowSelect);
            if (H != null) {
                this.h.setThreadList(H);
                this.o.T(H, this.e, this.h, 0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.h.getForum()));
        }
    }

    public final void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            p2();
            try {
                if (this.h == null) {
                    return;
                }
                this.o.F();
                this.o.W();
                this.b = this.h.getForum().getName();
                this.g = this.h.getForum().getId();
                if (this.h != null && this.h.getForum() != null) {
                    this.o.S(this.h.getForum().getThemeColorInfo());
                    this.o.O(this.h);
                }
                TbadkCoreApplication.getInst().setDefaultBubble(this.h.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.h.getUserData().getBimg_end_time());
                f2();
                if (!this.o.m().o(ThreadData.TYPE_VIDEO_ALA_ONLIVE)) {
                    this.h.removeAlaLiveThreadData();
                }
                ArrayList<nn> threadList = this.h.getThreadList();
                if (threadList != null) {
                    this.o.T(threadList, this.e, this.h, this.h.getPage().b());
                    g2();
                    this.o.H();
                    if (this.h.getIsNewUrl() == 1) {
                        this.o.m().x(true);
                    } else {
                        this.o.m().x(false);
                    }
                    this.o.K(W1(Y1().getType(), this.e));
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    @Override // com.repackage.ie6
    public void i0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
        }
    }

    public void i2() {
        uk6 uk6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || (uk6Var = this.o) == null) {
            return;
        }
        uk6Var.A();
    }

    public void j2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            this.d = i2;
        }
    }

    public void k2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            this.b = str;
        }
    }

    public void l2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            this.e = i2;
        }
    }

    public final void m() {
        uk6 uk6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || (uk6Var = this.o) == null) {
            return;
        }
        uk6Var.J(true);
        hideLoadingView(this.o.o());
    }

    public final void m2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            if (this.p == 0 && !this.n.E(this.h.getThreadListIds())) {
                if (this.h.getThreadList() != null && this.h.getThreadList().size() != 0) {
                    this.o.Y();
                } else {
                    this.o.p();
                }
            } else if (ListUtils.getCount(this.h.getThreadList()) > 3) {
                this.o.X();
            } else {
                this.o.U();
            }
        }
    }

    @Override // com.repackage.p98
    public void n0() {
        FrsGoodModelController frsGoodModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || (frsGoodModelController = this.m) == null) {
            return;
        }
        frsGoodModelController.Q();
    }

    public final void n2() {
        uk6 uk6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || (uk6Var = this.o) == null) {
            return;
        }
        uk6Var.J(false);
        showLoadingView(this.o.o(), true, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070288));
    }

    @Override // com.repackage.p98
    public TbPageContext<?> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? getPageContext() : (TbPageContext) invokeV.objValue;
    }

    public final void o2(vg8 vg8Var) {
        uk6 uk6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048616, this, vg8Var) == null) || (uk6Var = this.o) == null) {
            return;
        }
        uk6Var.J(false);
        this.o.N(false);
        this.o.p();
        this.o.n().getData().clear();
        this.o.v();
        if (this.w == null) {
            g55 g55Var = new g55(getPageContext().getContext(), getNetRefreshListener());
            this.w = g55Var;
            g55Var.e(null);
            this.w.c(null);
            this.w.f();
            this.w.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (vg8Var != null) {
            this.w.d(getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c16, vg8Var.d, Integer.valueOf(vg8Var.c)));
        } else {
            this.w.d(null);
        }
        this.w.onChangeSkinType();
        this.w.attachView(this.o.o(), true);
        this.w.a(0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        ThreadData threadDataById;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048617, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1 && i2 == 18003) {
                this.o.m().p();
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra == null || (threadDataById = this.h.getThreadDataById(stringExtra)) == null) {
                    return;
                }
                int intExtra = intent.getIntExtra("type", -1);
                if (intExtra == 2) {
                    threadDataById.setIs_good(intent.getIntExtra("good_data", 0));
                    threadDataById.parser_title();
                    e2(false);
                } else if (intExtra == 0) {
                    this.h.removeThreadData(threadDataById);
                    ArrayList<nn> threadList = this.h.getThreadList();
                    if (threadList != null && threadList.size() <= 0) {
                        threadList.add(new kd6());
                    }
                    this.o.H();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            if (this.r == 3 && this.o == null) {
                return;
            }
            this.r = i2;
            super.onChangeSkinType(i2);
            uk6 uk6Var = this.o;
            if (uk6Var != null) {
                uk6Var.w(i2);
            }
            g55 g55Var = this.w;
            if (g55Var == null || !g55Var.isViewAttached()) {
                return;
            }
            this.w.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, bundle) == null) {
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
            pg8.g().i(getUniqueId());
            FrsGoodModelController frsGoodModelController = new FrsGoodModelController(this);
            this.m = frsGoodModelController;
            if (arguments != null) {
                frsGoodModelController.H(arguments);
                this.f = arguments.getBoolean("is_game_frs", false);
            } else if (bundle != null) {
                frsGoodModelController.H(bundle);
                this.f = bundle.getBoolean("is_game_frs", false);
            } else {
                frsGoodModelController.H(null);
            }
            VoiceManager u0 = u0();
            this.i = u0;
            u0.onCreate(getPageContext());
            b2(bundle);
            registerListener(this.G);
            registerListener(this.D);
            registerListener(this.E);
            registerListener(this.K);
            registerListener(this.B);
            FrsLoadMoreModel frsLoadMoreModel = new FrsLoadMoreModel(this, null);
            this.n = frsLoadMoreModel;
            frsLoadMoreModel.registerListener();
            this.n.X(2);
            this.n.V(true);
            this.n.U(gr6.a(this.A));
            System.currentTimeMillis();
            this.y = UtilHelper.getScreenHeight(getActivity());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048620, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0309, (ViewGroup) null);
            uk6 uk6Var = new uk6(this, inflate, this.f);
            this.o = uk6Var;
            uk6Var.m().A();
            c2();
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            uk6 uk6Var = this.o;
            if (uk6Var != null) {
                uk6Var.x();
            }
            MessageManager.getInstance().unRegisterListener(this.B);
            pg8.g().k(getUniqueId());
            cy5.b().e(false);
            super.onDestroy();
            this.m.L();
            VoiceManager u0 = u0();
            this.i = u0;
            u0.onDestory(getPageContext());
            qg.a().removeCallbacks(this.C);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void onFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            m2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public rn onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            if (V1() == null) {
                return null;
            }
            return V1().getPreLoadHandle();
        }
        return (rn) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            super.onLazyLoad();
            if (this.s) {
                return;
            }
            if (ni.z()) {
                e2(false);
            } else {
                o2(null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            TiebaStatic.log(new StatisticItem("c13008").param("fid", this.x).param("obj_type", "7").param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048626, this) == null) && ni.z()) {
            e2(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            super.onPause();
            VoiceManager u0 = u0();
            this.i = u0;
            u0.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                if (this.r == 3) {
                    onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                }
                if (this.s) {
                    return;
                }
                qg.a().post(this.C);
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
                showToast(R.string.obfuscated_res_0x7f0f1302);
            }
            ArrayMap<String, Boolean> transformPermissionResult = PermissionUtil.transformPermissionResult(strArr, iArr);
            if (!transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") || transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                return;
            }
            showToast(R.string.obfuscated_res_0x7f0f1063);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            super.onResume();
            uk6 uk6Var = this.o;
            if (uk6Var != null) {
                uk6Var.v();
            }
            VoiceManager u0 = u0();
            this.i = u0;
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
            bundle.putBoolean("is_game_frs", this.f);
            this.m.M(bundle);
            VoiceManager u0 = u0();
            this.i = u0;
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
                this.o.p();
            } else if (!this.m.G()) {
                this.o.p();
            } else {
                m2();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
                if (this.n.isLoading || this.m.I()) {
                    return;
                }
                if (this.n.E(this.h.getThreadListIds())) {
                    FrsViewData frsViewData = this.h;
                    String e2 = w88.e(frsViewData != null ? frsViewData.getThreadList() : null, false);
                    this.o.T(this.n.R(), this.e, this.h, 0);
                    this.n.S(ng.g(this.g, 0L), this.h.getThreadListIds(), this.b, this.e, this.h.isBrandForum, e2);
                } else if (this.p != 0) {
                    FrsViewData frsViewData2 = this.h;
                    String e3 = w88.e(frsViewData2 != null ? frsViewData2.getThreadList() : null, false);
                    this.o.T(this.n.R(), this.e, this.h, 0);
                    int i2 = this.e + 1;
                    this.e = i2;
                    this.m.K(i2, e3);
                    FrsLoadMoreModel frsLoadMoreModel = this.n;
                    frsLoadMoreModel.loadingDone = false;
                    frsLoadMoreModel.loadIndex = 0;
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            super.onStart();
            VoiceManager u0 = u0();
            this.i = u0;
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
            FrsViewData frsViewData = this.h;
            if (frsViewData != null && frsViewData.getForum() != null) {
                a15.j().x(getPageContext().getPageActivity(), "frs", this.h.getForum().getId(), 0L);
            }
            VoiceManager u0 = u0();
            this.i = u0;
            if (u0 != null) {
                u0.onStop(getPageContext());
            }
        }
    }

    @Override // com.repackage.ie6
    public void p1() {
        uk6 uk6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048635, this) == null) || (uk6Var = this.o) == null || uk6Var.n() == null) {
            return;
        }
        this.o.n().scrollToPosition(0);
    }

    public void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            VoiceManager u0 = u0();
            this.i = u0;
            u0.stopPlay();
        }
    }

    @Override // com.repackage.ti5
    public void q0(int i2, si5 si5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048637, this, i2, si5Var) == null) {
            this.t.put(i2, si5Var);
        }
    }

    public final void q2(ThreadData threadData, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048638, this, threadData, i2) == null) {
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

    public final void r2(int i2) {
        ArrayList<nn> threadList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048639, this, i2) == null) || (threadList = this.h.getThreadList()) == null) {
            return;
        }
        Iterator<nn> it = threadList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            nn next = it.next();
            if (next instanceof rq4) {
                ThreadData threadData = ((rq4) next).s;
                if (threadData.getId() != null && threadData.getId().equals(this.a)) {
                    q2(threadData, i2);
                    this.a = null;
                    break;
                }
            }
        }
        this.o.m().w(threadList, this.h);
        this.o.m().p();
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, str) == null) {
            this.c = str;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager u0() {
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

    @Override // com.repackage.ie6
    public void w() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048642, this) == null) || this.o == null) {
            return;
        }
        p1();
        this.o.Z();
    }
}
