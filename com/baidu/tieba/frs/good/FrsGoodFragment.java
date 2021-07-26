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
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
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
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.d.k.e.n;
import d.a.d.k.e.q;
import d.a.d.k.e.w;
import d.a.p0.s.q.a2;
import d.a.p0.s.q.b2;
import d.a.p0.s.q.x0;
import d.a.q0.h3.m;
import d.a.q0.h3.s;
import d.a.q0.u0.p0;
import d.a.q0.u0.q0;
import d.a.q0.u0.r0;
import d.a.q0.w2.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class FrsGoodFragment extends BaseFragment implements VoiceManager.j, d.a.q0.u0.d2.a, UserIconBox.c, BdListView.p, FrsCommonImageLayout.e, p0, ActivityCompat.OnRequestPermissionsResultCallback, t, q0, d.a.q0.e.e.b, r0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.p0.f0.c A;
    public String B;
    public int C;
    public int D;
    public boolean E;
    public CustomMessageListener F;
    public Runnable G;
    public CustomMessageListener H;
    public CustomMessageListener I;
    public final s J;
    public final CustomMessageListener K;
    public final RecyclerView.OnScrollListener L;
    public final CustomMessageListener M;
    public w N;
    public CustomMessageListener O;

    /* renamed from: e  reason: collision with root package name */
    public String f15917e;

    /* renamed from: f  reason: collision with root package name */
    public String f15918f;

    /* renamed from: g  reason: collision with root package name */
    public String f15919g;

    /* renamed from: h  reason: collision with root package name */
    public int f15920h;

    /* renamed from: i  reason: collision with root package name */
    public int f15921i;
    public boolean j;
    public String k;
    public FrsViewData l;
    public VoiceManager m;
    public long n;
    public long o;
    public long p;
    public FrsGoodModelController q;
    public FrsLoadMoreModel r;
    public d.a.q0.u0.z1.a s;
    public int t;
    public int u;
    public int v;
    public boolean w;
    public SparseArray<d.a.q0.e.e.a> x;
    public d.a.q0.u0.w1.b y;
    public boolean z;

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsGoodFragment f15922a;

        public a(FrsGoodFragment frsGoodFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGoodFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15922a = frsGoodFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) && i2 == 0) {
                d.a.q0.a0.t.b().e(true);
                d.a.q0.g3.c.g().h(this.f15922a.getUniqueId(), true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                this.f15922a.D += i3;
                if (this.f15922a.D < this.f15922a.C * 2 || i3 >= 0) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsGoodFragment f15923a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(FrsGoodFragment frsGoodFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGoodFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15923a = frsGoodFragment;
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
                this.f15923a.n1(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGoodFragment f15924e;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f15925e;

            public a(c cVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f15925e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    NetWork netWork = new NetWork(this.f15925e);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15924e = frsGoodFragment;
        }

        @Override // d.a.d.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) || bdUniqueId == null || nVar == null || !(nVar instanceof a2)) {
                return;
            }
            b2 b2Var = ((a2) nVar).w;
            if (b2Var.C() == null || b2Var.C().getGroup_id() == 0 || ViewHelper.checkUpIsLogin(this.f15924e.getActivity())) {
                if (b2Var.q() != 1 || ViewHelper.checkUpIsLogin(this.f15924e.getActivity())) {
                    d.a.q0.h3.n0.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null && !readThreadHistory.d(b2Var.d0())) {
                        readThreadHistory.a(b2Var.d0());
                        d.a.q0.u0.z1.a aVar = this.f15924e.s;
                        if (aVar != null) {
                            aVar.v();
                        }
                    }
                    String x = b2Var.x();
                    if (x == null || x.equals("")) {
                        z = false;
                    } else {
                        new Thread(new a(this, x)).start();
                        z = true;
                    }
                    String o1 = b2Var != null ? b2Var.o1() : null;
                    if (o1 == null) {
                        o1 = "";
                    }
                    if (b2Var.n0() == 2 && !o1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                        UrlManager.getInstance().dealOneLink(this.f15924e.getPageContext(), new String[]{o1, "", null});
                        return;
                    }
                    if (o1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && o1.length() > 3 && o1.length() > 3) {
                        b2Var.y3(o1.substring(3));
                    }
                    PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.f15924e.getPageContext().getPageActivity()).createFromThreadCfg(b2Var, this.f15924e.f15918f, "frs_page", 18003, true, false, z);
                    createFromThreadCfg.setForumId(String.valueOf(b2Var.R()));
                    createFromThreadCfg.setStartFrom(3);
                    this.f15924e.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                    if (this.f15924e.l == null || this.f15924e.l.getForum() == null) {
                        return;
                    }
                    d.a.q0.u0.j2.b bVar = new d.a.q0.u0.j2.b();
                    bVar.f63599a = this.f15924e.l.needLog == 1;
                    bVar.f63601c = this.f15924e.l.getForum().getId();
                    d.a.q0.u0.j2.b bVar2 = d.a.q0.u0.j2.d.h0;
                    if (bVar2 != null) {
                        bVar.f63602d = bVar2.f63602d;
                        bVar.f63603e = bVar2.f63603e;
                    }
                    d.a.q0.u0.j2.a.e(b2Var, 1, this.f15924e.getUniqueId(), bVar, this.f15924e.getTbPageTag());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsGoodFragment f15926a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(FrsGoodFragment frsGoodFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGoodFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15926a = frsGoodFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.q0.u0.z1.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || (aVar = this.f15926a.s) == null) {
                return;
            }
            aVar.y();
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsGoodFragment f15927a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(FrsGoodFragment frsGoodFragment, int i2, boolean z) {
            super(i2, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGoodFragment, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15927a = frsGoodFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer) || (num = (Integer) customResponsedMessage.getData()) == null || this.f15927a.A == null || !this.f15927a.A.isViewAttached()) {
                return;
            }
            this.f15927a.A.a(num.intValue());
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGoodFragment f15928e;

        public f(FrsGoodFragment frsGoodFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGoodFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15928e = frsGoodFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!d.a.d.e.p.j.z() || this.f15928e.w) {
                    this.f15928e.H1(null);
                } else {
                    this.f15928e.x1(false);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsGoodFragment f15929a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(FrsGoodFragment frsGoodFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGoodFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15929a = frsGoodFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof b2)) {
                b2 b2Var = (b2) customResponsedMessage.getData();
                this.f15929a.f15917e = b2Var.d0();
                if (TextUtils.isEmpty(this.f15929a.f15917e) || b2Var.H0() == null) {
                    return;
                }
                this.f15929a.K1(b2Var.H0().getIsLike());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsGoodFragment f15930a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(FrsGoodFragment frsGoodFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGoodFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15930a = frsGoodFragment;
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
                if (this.f15930a.o1() != null) {
                    this.f15930a.o1().setSelection(0);
                }
                if (this.f15930a.A != null && this.f15930a.A.isViewAttached()) {
                    this.f15930a.x1(false);
                    return;
                }
                d.a.q0.u0.z1.a aVar = this.f15930a.s;
                if (aVar != null) {
                    aVar.Z();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f15931a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrsGoodFragment f15932b;

        public i(FrsGoodFragment frsGoodFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGoodFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15932b = frsGoodFragment;
            this.f15931a = 1L;
        }

        @Override // d.a.q0.h3.s
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f15932b.z) {
                return;
            }
            if (i2 == 1 || i2 == 2) {
                this.f15932b.s.v();
            } else if (i2 != 3) {
            } else {
                this.f15932b.s.I(true);
            }
        }

        @Override // d.a.q0.h3.s
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // d.a.q0.h3.s
        public void c(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar) == null) {
            }
        }

        @Override // d.a.q0.h3.s
        public void d(int i2, boolean z, d.a.q0.h3.f fVar) {
            ArrayList<n> C;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), fVar}) == null) {
                if (this.f15932b.z) {
                    if (this.f15932b.r1().x() == null) {
                        this.f15932b.z = false;
                        return;
                    } else if (this.f15932b.r1().x().getThreadList().size() >= 10) {
                        this.f15932b.z = false;
                        d.a.q0.u0.k2.e eVar = new d.a.q0.u0.k2.e();
                        eVar.f63656b = 301;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384, eVar));
                        return;
                    }
                }
                if (fVar == null) {
                    this.f15931a = 1L;
                } else if (fVar.f58509b) {
                    this.f15931a = 0L;
                } else {
                    this.f15931a = 1L;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (i2 == 3) {
                    this.f15932b.r.N();
                }
                this.f15932b.s.I(false);
                if (this.f15932b.r1().x() != null) {
                    FrsGoodFragment frsGoodFragment = this.f15932b;
                    frsGoodFragment.l = frsGoodFragment.r1().x();
                }
                FrsGoodFragment frsGoodFragment2 = this.f15932b;
                frsGoodFragment2.t = frsGoodFragment2.l.getPage().b();
                if (this.f15932b.t != 0 || (this.f15932b.l.getThreadListIds() != null && this.f15932b.l.getThreadListIds().size() != 0)) {
                    if (ListUtils.getCount(this.f15932b.l.getThreadList()) > 3) {
                        this.f15932b.s.X();
                    } else {
                        this.f15932b.s.U();
                    }
                } else if (this.f15932b.l.getThreadList() != null && this.f15932b.l.getThreadList().size() != 0) {
                    this.f15932b.s.Y();
                } else {
                    this.f15932b.s.p();
                }
                if (i2 == 4) {
                    ArrayList<n> C2 = this.f15932b.r.C(false, false, false, this.f15932b.l.getThreadList(), null);
                    if (C2 != null) {
                        this.f15932b.l.setThreadList(C2);
                        FrsGoodFragment frsGoodFragment3 = this.f15932b;
                        frsGoodFragment3.s.T(C2, frsGoodFragment3.f15921i, this.f15932b.l, this.f15932b.t);
                        return;
                    }
                    return;
                }
                if (i2 == 1) {
                    this.f15932b.s.v();
                } else if (i2 != 2) {
                    if (i2 == 3 && this.f15932b.l.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, Boolean.TRUE));
                    }
                } else {
                    this.f15932b.s.v();
                }
                this.f15932b.l();
                if (this.f15931a != 0) {
                    this.f15932b.H1(fVar);
                } else {
                    if (this.f15932b.l != null) {
                        FrsGoodFragment frsGoodFragment4 = this.f15932b;
                        frsGoodFragment4.f15918f = frsGoodFragment4.l.getForum().getName();
                        FrsGoodFragment frsGoodFragment5 = this.f15932b;
                        frsGoodFragment5.k = frsGoodFragment5.l.getForum().getId();
                        FrsGoodFragment frsGoodFragment6 = this.f15932b;
                        frsGoodFragment6.s.z(frsGoodFragment6.l.getForum(), this.f15932b.l.getUserData());
                    }
                    if (this.f15932b.l != null) {
                        this.f15932b.l.addNoticeThreadToThreadList();
                    }
                    FrsGoodFragment frsGoodFragment7 = this.f15932b;
                    frsGoodFragment7.s.O(frsGoodFragment7.l);
                    if (this.f15932b.l == null || this.f15932b.l.getThreadList() == null || this.f15932b.l.getThreadList().size() != 0 || this.f15932b.r1().getType() != 4) {
                        if (this.f15932b.l != null && (C = this.f15932b.r.C(false, false, true, this.f15932b.l.getThreadList(), null)) != null && C.size() > 0) {
                            this.f15932b.l.setThreadList(C);
                        }
                        this.f15932b.A1();
                    } else {
                        FrsGoodFragment frsGoodFragment8 = this.f15932b;
                        frsGoodFragment8.showToast(frsGoodFragment8.getPageContext().getString(R.string.no_more_to_load));
                        if (this.f15932b.f15921i > 1) {
                            FrsGoodFragment.T0(this.f15932b);
                        }
                        if (this.f15932b.n > -1) {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            FrsGoodFragment frsGoodFragment9 = this.f15932b;
                            long z2 = frsGoodFragment9.r1().z();
                            FrsGoodFragment frsGoodFragment10 = this.f15932b;
                            TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis2 - frsGoodFragment9.n, z2 - frsGoodFragment10.n, frsGoodFragment10.r1().B(), this.f15932b.r1().A(), currentTimeMillis2 - this.f15932b.r1().y());
                            this.f15932b.n = -1L;
                        }
                        this.f15932b.o = System.currentTimeMillis() - currentTimeMillis;
                        return;
                    }
                }
                if (this.f15932b.n > -1) {
                    long currentTimeMillis3 = System.currentTimeMillis();
                    FrsGoodFragment frsGoodFragment11 = this.f15932b;
                    long z3 = frsGoodFragment11.r1().z();
                    FrsGoodFragment frsGoodFragment12 = this.f15932b;
                    TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis3 - frsGoodFragment11.n, z3 - frsGoodFragment12.n, frsGoodFragment12.r1().B(), this.f15932b.r1().A(), currentTimeMillis3 - this.f15932b.r1().y());
                    this.f15932b.n = -1L;
                }
                this.f15932b.o = System.currentTimeMillis() - currentTimeMillis;
                System.gc();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsGoodFragment f15933a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(FrsGoodFragment frsGoodFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGoodFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15933a = frsGoodFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.q0.u0.z1.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || (aVar = this.f15933a.s) == null) {
                return;
            }
            aVar.Z();
        }
    }

    /* loaded from: classes4.dex */
    public class k implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGoodFragment f15934e;

        public k(FrsGoodFragment frsGoodFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGoodFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15934e = frsGoodFragment;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (this.f15934e.y != null) {
                    this.f15934e.y.b(view, motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGoodFragment f15935e;

        public l(FrsGoodFragment frsGoodFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGoodFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15935e = frsGoodFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.q0.h3.n0.a.o(this.f15935e.f15918f);
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
        this.f15918f = null;
        this.f15919g = null;
        this.f15920h = 0;
        this.f15921i = 1;
        this.j = false;
        this.k = null;
        this.l = new FrsViewData();
        this.n = -1L;
        this.p = -1L;
        this.s = null;
        this.t = -1;
        this.u = 0;
        this.v = 3;
        this.w = false;
        this.x = new SparseArray<>();
        this.z = false;
        this.C = 0;
        this.D = 0;
        this.F = new e(this, 2921397, true);
        this.G = new f(this);
        this.H = new g(this, 2004004);
        this.I = new h(this, 2001624);
        this.J = new i(this);
        this.K = new j(this, 2003003);
        this.L = new a(this);
        this.M = new b(this, 0);
        this.N = new c(this);
        this.O = new d(this, 2921414);
    }

    public static /* synthetic */ int T0(FrsGoodFragment frsGoodFragment) {
        int i2 = frsGoodFragment.f15921i;
        frsGoodFragment.f15921i = i2 - 1;
        return i2;
    }

    @Override // d.a.q0.w2.t
    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    @Override // d.a.q0.w2.t
    public int A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15921i : invokeV.intValue;
    }

    public final void A1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            I1();
            try {
                if (this.l == null) {
                    return;
                }
                this.s.F();
                this.s.W();
                this.f15918f = this.l.getForum().getName();
                this.k = this.l.getForum().getId();
                if (this.l != null && this.l.getForum() != null) {
                    this.s.S(this.l.getForum().getThemeColorInfo());
                    this.s.O(this.l);
                }
                TbadkCoreApplication.getInst().setDefaultBubble(this.l.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.l.getUserData().getBimg_end_time());
                y1();
                if (!this.s.m().o(b2.s3)) {
                    this.l.removeAlaLiveThreadData();
                }
                ArrayList<n> threadList = this.l.getThreadList();
                if (threadList != null) {
                    this.s.T(threadList, this.f15921i, this.l, this.l.getPage().b());
                    z1();
                    this.s.H();
                    if (this.l.getIsNewUrl() == 1) {
                        this.s.m().x(true);
                    } else {
                        this.s.m().x(false);
                    }
                    this.s.K(p1(r1().getType(), this.f15921i));
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void B1() {
        d.a.q0.u0.z1.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (aVar = this.s) == null) {
            return;
        }
        aVar.A();
    }

    public void C1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f15920h = i2;
        }
    }

    public void D1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f15918f = str;
        }
    }

    public void E1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f15921i = i2;
        }
    }

    public final void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.t == 0 && !this.r.A(this.l.getThreadListIds())) {
                if (this.l.getThreadList() != null && this.l.getThreadList().size() != 0) {
                    this.s.Y();
                } else {
                    this.s.p();
                }
            } else if (ListUtils.getCount(this.l.getThreadList()) > 3) {
                this.s.X();
            } else {
                this.s.U();
            }
        }
    }

    public final void G1() {
        d.a.q0.u0.z1.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (aVar = this.s) == null) {
            return;
        }
        aVar.J(false);
        showLoadingView(this.s.o(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    @Override // d.a.q0.u0.r0
    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            d.a.q0.g3.c.g().h(getUniqueId(), false);
        }
    }

    public final void H1(d.a.q0.h3.f fVar) {
        d.a.q0.u0.z1.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) || (aVar = this.s) == null) {
            return;
        }
        aVar.J(false);
        this.s.N(false);
        this.s.p();
        this.s.n().getData().clear();
        this.s.v();
        if (this.A == null) {
            d.a.p0.f0.c cVar = new d.a.p0.f0.c(getPageContext().getContext(), getNetRefreshListener());
            this.A = cVar;
            cVar.e(null);
            this.A.c(null);
            this.A.f();
            this.A.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.A.d(getPageContext().getResources().getString(R.string.net_error_text, fVar.f58511d, Integer.valueOf(fVar.f58510c)));
        } else {
            this.A.d(null);
        }
        this.A.onChangeSkinType();
        this.A.attachView(this.s.o(), true);
        this.A.a(0);
    }

    public void I1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            VoiceManager voiceManager = getVoiceManager();
            this.m = voiceManager;
            voiceManager.stopPlay();
        }
    }

    @Override // d.a.q0.u0.p0
    public void J0() {
        d.a.q0.u0.z1.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (aVar = this.s) == null || aVar.n() == null) {
            return;
        }
        this.s.n().scrollToPosition(0);
    }

    public final void J1(b2 b2Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, b2Var, i2) == null) {
            if (i2 == 1) {
                PraiseData H0 = b2Var.H0();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (H0 == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i2);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        b2Var.T3(praiseData);
                        return;
                    }
                    b2Var.H0().getUser().add(0, metaData);
                    b2Var.H0().setNum(b2Var.H0().getNum() + 1);
                    b2Var.H0().setIsLike(i2);
                }
            } else if (b2Var.H0() != null) {
                b2Var.H0().setIsLike(i2);
                b2Var.H0().setNum(b2Var.H0().getNum() - 1);
                ArrayList<MetaData> user = b2Var.H0().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            b2Var.H0().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    @Override // d.a.q0.u0.p0
    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
        }
    }

    public final void K1(int i2) {
        ArrayList<n> threadList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i2) == null) || (threadList = this.l.getThreadList()) == null) {
            return;
        }
        Iterator<n> it = threadList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            n next = it.next();
            if (next instanceof a2) {
                b2 b2Var = ((a2) next).w;
                if (b2Var.d0() != null && b2Var.d0().equals(this.f15917e)) {
                    J1(b2Var, i2);
                    this.f15917e = null;
                    break;
                }
            }
        }
        this.s.m().w(threadList, this.l);
        this.s.m().p();
    }

    @Override // d.a.q0.w2.t
    public void P() {
        FrsGoodModelController frsGoodModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (frsGoodModelController = this.q) == null) {
            return;
        }
        frsGoodModelController.L();
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void a(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, arrayList) == null) {
            F1();
            if (arrayList == null || arrayList.size() == 0) {
                return;
            }
            ArrayList<n> C = this.r.C(false, false, false, arrayList, null);
            if (C != null) {
                this.l.setThreadList(C);
                this.s.T(C, this.f15921i, this.l, 0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.l.getForum()));
        }
    }

    @Override // d.a.q0.e.e.b
    public void dispatchInjectPluginMessage(d.a.q0.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, dVar) == null) {
        }
    }

    @Override // d.a.q0.u0.d2.a, d.a.q0.u0.t0
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f15918f : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public d.a.d.e.k.b<TbImageView> getFrsCommonImageLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (getBaseFragmentActivity() instanceof FrsActivity) {
                return ((FrsActivity) getBaseFragmentActivity()).getFrsCommonImageLayoutPool();
            }
            return null;
        }
        return (d.a.d.e.k.b) invokeV.objValue;
    }

    @Override // d.a.q0.e.e.b
    public d.a.q0.e.e.a getInjectPlugin(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) ? this.x.get(i2) : (d.a.q0.e.e.a) invokeI.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.q0.u0.d2.a
    public /* bridge */ /* synthetic */ d.a.d.a.f getPageContext() {
        return super.getPageContext();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, voiceData$VoiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            TbPageTag tbPageTag = super.getTbPageTag();
            FrsViewData frsViewData = this.l;
            tbPageTag.sortType = d.a.q0.u0.n2.k.g(frsViewData != null ? frsViewData.getSortType() : -1);
            tbPageTag.locatePage = "a072";
            return tbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public d.a.d.e.k.b<TbImageView> getUserIconPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (getBaseFragmentActivity() instanceof FrsActivity) {
                return ((FrsActivity) getBaseFragmentActivity()).getUserIconPool();
            }
            return null;
        }
        return (d.a.d.e.k.b) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (this.m == null) {
                this.m = VoiceManager.instance();
            }
            return this.m;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // d.a.q0.u0.q0
    public NavigationBar j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return null;
        }
        return (NavigationBar) invokeV.objValue;
    }

    public final void l() {
        d.a.q0.u0.z1.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (aVar = this.s) == null) {
            return;
        }
        aVar.J(true);
        hideLoadingView(this.s.o());
    }

    @Override // d.a.q0.u0.d2.a
    public FrsViewData l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.l : (FrsViewData) invokeV.objValue;
    }

    @Override // d.a.q0.w2.t
    public TbPageContext<?> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? getPageContext() : (TbPageContext) invokeV.objValue;
    }

    public void m1(x0 x0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, x0Var) == null) || x0Var == null || l0() == null || l0().getThreadList() == null) {
            return;
        }
        if (ListUtils.isEmpty(l0().getThreadList())) {
            l0().getThreadList().add(x0Var);
        } else {
            if (l0().getThreadList().size() == 1 && (l0().getThreadList().get(0) instanceof d.a.q0.u0.s)) {
                l0().getThreadList().remove(0);
            }
            l0().getThreadList().add(0, x0Var);
        }
        d.a.q0.u0.z1.a aVar = this.s;
        ArrayList<n> threadList = this.l.getThreadList();
        int i2 = this.f15921i;
        FrsViewData frsViewData = this.l;
        aVar.T(threadList, i2, frsViewData, frsViewData.getPage().b());
        this.s.H();
        this.s.K(0);
    }

    public final void n1(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, responsedMessage) == null) || this.l == null || this.s == null || !(responsedMessage instanceof DownloadMessage) || (data = ((DownloadMessage) responsedMessage).getData()) == null) {
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
            this.s.v();
        }
    }

    @Override // d.a.q0.u0.r0
    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            if (getPageContext() != null) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            }
            if (d.a.d.e.p.j.z()) {
                d.a.q0.o.d.c().f("page_frs_good");
                x1(true);
                return;
            }
            this.s.I(false);
        }
    }

    public BdTypeRecyclerView o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            d.a.q0.u0.z1.a aVar = this.s;
            if (aVar == null) {
                return null;
            }
            return aVar.n();
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        b2 threadDataById;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048611, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1 && i2 == 18003) {
                this.s.m().p();
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra == null || (threadDataById = this.l.getThreadDataById(stringExtra)) == null) {
                    return;
                }
                int intExtra = intent.getIntExtra("type", -1);
                if (intExtra == 2) {
                    threadDataById.F3(intent.getIntExtra("good_data", 0));
                    threadDataById.O2();
                    x1(false);
                } else if (intExtra == 0) {
                    this.l.removeThreadData(threadDataById);
                    ArrayList<n> threadList = this.l.getThreadList();
                    if (threadList != null && threadList.size() <= 0) {
                        threadList.add(new d.a.q0.u0.s());
                    }
                    this.s.H();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
            if (this.v == 3 && this.s == null) {
                return;
            }
            this.v = i2;
            super.onChangeSkinType(i2);
            d.a.q0.u0.z1.a aVar = this.s;
            if (aVar != null) {
                aVar.w(i2);
            }
            d.a.p0.f0.c cVar = this.A;
            if (cVar == null || !cVar.isViewAttached()) {
                return;
            }
            this.A.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, bundle) == null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.n = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
            } else {
                this.n = System.currentTimeMillis();
            }
            if (arguments != null) {
                this.B = arguments.getString("forum_id", "");
                this.E = arguments.getBoolean(FrsActivityConfig.FLAG_SHOW_AD);
            }
            this.p = System.currentTimeMillis();
            super.onCreate(bundle);
            d.a.q0.g3.c.g().i(getUniqueId());
            FrsGoodModelController frsGoodModelController = new FrsGoodModelController(this);
            this.q = frsGoodModelController;
            if (arguments != null) {
                frsGoodModelController.D(arguments);
                this.j = arguments.getBoolean("is_game_frs", false);
            } else if (bundle != null) {
                frsGoodModelController.D(bundle);
                this.j = bundle.getBoolean("is_game_frs", false);
            } else {
                frsGoodModelController.D(null);
            }
            VoiceManager voiceManager = getVoiceManager();
            this.m = voiceManager;
            voiceManager.onCreate(getPageContext());
            u1(bundle);
            registerListener(this.K);
            registerListener(this.H);
            registerListener(this.I);
            registerListener(this.O);
            registerListener(this.F);
            FrsLoadMoreModel frsLoadMoreModel = new FrsLoadMoreModel(this, null);
            this.r = frsLoadMoreModel;
            frsLoadMoreModel.registerListener();
            this.r.S(2);
            this.r.P(true);
            this.r.O(d.a.q0.w0.a.a(this.E));
            System.currentTimeMillis();
            this.C = UtilHelper.getScreenHeight(getActivity());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048614, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
            d.a.q0.u0.z1.a aVar = new d.a.q0.u0.z1.a(this, inflate, this.j);
            this.s = aVar;
            aVar.m().A();
            v1();
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            d.a.q0.u0.z1.a aVar = this.s;
            if (aVar != null) {
                aVar.x();
            }
            MessageManager.getInstance().unRegisterListener(this.F);
            d.a.q0.g3.c.g().k(getUniqueId());
            d.a.q0.a0.t.b().e(false);
            super.onDestroy();
            this.q.H();
            VoiceManager voiceManager = getVoiceManager();
            this.m = voiceManager;
            voiceManager.onDestory(getPageContext());
            d.a.d.e.m.e.a().removeCallbacks(this.G);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void onFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            F1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public q onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (o1() == null) {
                return null;
            }
            return o1().getPreLoadHandle();
        }
        return (q) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            super.onLazyLoad();
            if (this.w) {
                return;
            }
            if (d.a.d.e.p.j.z()) {
                x1(false);
            } else {
                H1(null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            TiebaStatic.log(new StatisticItem("c13008").param("fid", this.B).param("obj_type", "7").param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048620, this) == null) && d.a.d.e.p.j.z()) {
            x1(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            super.onPause();
            VoiceManager voiceManager = getVoiceManager();
            this.m = voiceManager;
            voiceManager.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                if (this.v == 3) {
                    onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                }
                if (this.w) {
                    return;
                }
                d.a.d.e.m.e.a().post(this.G);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048623, this, i2, strArr, iArr) == null) && i2 == 1) {
            if (PermissionUtil.checkCamera(getActivity().getApplicationContext())) {
                SelectImageHelper.takePhoto(getPageContext());
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = PermissionUtil.transformPermissionResult(strArr, iArr);
            if (!transformPermissionResult.containsKey(StorageUtils.EXTERNAL_STORAGE_PERMISSION) || transformPermissionResult.get(StorageUtils.EXTERNAL_STORAGE_PERMISSION).booleanValue()) {
                return;
            }
            showToast(R.string.sdcard_permission_denied_advert_for_camera);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            super.onResume();
            d.a.q0.u0.z1.a aVar = this.s;
            if (aVar != null) {
                aVar.v();
            }
            VoiceManager voiceManager = getVoiceManager();
            this.m = voiceManager;
            voiceManager.onResume(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("name", this.f15918f);
            bundle.putString("from", this.f15919g);
            bundle.putBoolean("is_game_frs", this.j);
            this.q.onSaveInstanceState(bundle);
            VoiceManager voiceManager = getVoiceManager();
            this.m = voiceManager;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            if (!d.a.d.e.p.l.D()) {
                this.s.p();
            } else if (!this.q.C()) {
                this.s.p();
            } else {
                F1();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
                if (this.r.isLoading || this.q.E()) {
                    return;
                }
                if (this.r.A(this.l.getThreadListIds())) {
                    FrsViewData frsViewData = this.l;
                    String e2 = d.a.q0.w2.a.e(frsViewData != null ? frsViewData.getThreadList() : null, false);
                    this.s.T(this.r.L(), this.f15921i, this.l, 0);
                    this.r.M(d.a.d.e.m.b.f(this.k, 0L), this.l.getThreadListIds(), this.f15918f, this.f15921i, this.l.isBrandForum, e2);
                } else if (this.t != 0) {
                    FrsViewData frsViewData2 = this.l;
                    String e3 = d.a.q0.w2.a.e(frsViewData2 != null ? frsViewData2.getThreadList() : null, false);
                    this.s.T(this.r.L(), this.f15921i, this.l, 0);
                    int i2 = this.f15921i + 1;
                    this.f15921i = i2;
                    this.q.G(i2, e3);
                    FrsLoadMoreModel frsLoadMoreModel = this.r;
                    frsLoadMoreModel.loadingDone = false;
                    frsLoadMoreModel.loadIndex = 0;
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            super.onStart();
            VoiceManager voiceManager = getVoiceManager();
            this.m = voiceManager;
            voiceManager.onStart(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            super.onStop();
            d.a.q0.a0.t.b().e(false);
            d.a.q0.g3.c.g().h(getUniqueId(), false);
            FrsViewData frsViewData = this.l;
            if (frsViewData != null && frsViewData.getForum() != null) {
                d.a.p0.v.a.k().y(getPageContext().getPageActivity(), "frs", this.l.getForum().getId(), 0L);
            }
            VoiceManager voiceManager = getVoiceManager();
            this.m = voiceManager;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
        }
    }

    public final int p1(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048629, this, i2, i3)) == null) {
            if (i2 != 1) {
                return (i2 != 2 || i3 == 1) ? 0 : 3;
            }
            return 3;
        }
        return invokeII.intValue;
    }

    public FrsLoadMoreModel q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.r : (FrsLoadMoreModel) invokeV.objValue;
    }

    public FrsGoodModelController r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.q : (FrsGoodModelController) invokeV.objValue;
    }

    @Override // d.a.q0.u0.p0
    public void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048632, this) == null) || this.s == null) {
            return;
        }
        J0();
        this.s.Z();
    }

    public final void s1() {
        d.a.q0.u0.z1.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048633, this) == null) || (aVar = this.s) == null) {
            return;
        }
        aVar.J(true);
        this.s.N(true);
        d.a.p0.f0.c cVar = this.A;
        if (cVar == null || !cVar.isViewAttached()) {
            return;
        }
        this.A.dettachView(this.s.o());
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, str) == null) {
            this.f15919g = str;
        }
    }

    @Override // d.a.q0.e.e.b
    public void setInjectPlugin(int i2, d.a.q0.e.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048635, this, i2, aVar) == null) {
            this.x.put(i2, aVar);
        }
    }

    public final void t1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            registerListener(2001118, this.M);
        }
    }

    public final void u1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, bundle) == null) {
            t1();
            if (bundle != null) {
                this.f15918f = bundle.getString("name");
                this.f15919g = bundle.getString("from");
                this.f15920h = bundle.getInt("flag", 0);
            } else {
                Bundle arguments = getArguments();
                if (arguments != null) {
                    this.f15918f = arguments.getString("name");
                    this.f15919g = arguments.getString("from");
                    this.f15920h = arguments.getInt("flag", 0);
                }
            }
            if (TextUtils.isEmpty(this.f15919g) || !FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.f15919g)) {
                return;
            }
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    public final void v1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            if (this.f15920h != 0) {
                this.f15920h = 1;
            }
            this.y = new d.a.q0.u0.w1.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
            this.s.L(this.N);
            this.s.M(this.L);
            this.s.n().setOnTouchListener(new k(this));
        }
    }

    public void w1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i2) == null) {
            this.u = i2;
            if (d.a.d.e.p.j.z()) {
                x1(false);
            } else {
                H1(null);
            }
        }
    }

    public final void x1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048640, this, z) == null) {
            this.w = true;
            I1();
            s1();
            if (!z) {
                s1();
                G1();
            }
            FrsGoodModelController frsGoodModelController = this.q;
            if (frsGoodModelController != null) {
                frsGoodModelController.F(this.u);
            }
        }
    }

    public final void y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            if (this.f15920h == 1) {
                d.a.d.e.m.h.a().b(new l(this));
            }
            this.f15920h = 0;
        }
    }

    public final void z1() {
        d.a.q0.u0.z1.a aVar;
        HashMap<Integer, b2> j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048642, this) == null) || (aVar = this.s) == null || aVar.m() == null || (j2 = this.s.m().j()) == null) {
            return;
        }
        ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
        for (Map.Entry<Integer, b2> entry : j2.entrySet()) {
            b2 value = entry.getValue();
            if (value != null && (value instanceof AdvertAppInfo)) {
                arrayList.add((AdvertAppInfo) value);
            }
        }
        d.a.p0.w.c.l().m(arrayList);
    }
}
