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
import c.a.d.n.e.n;
import c.a.d.n.e.q;
import c.a.d.n.e.v;
import c.a.s0.s.q.d2;
import c.a.s0.s.q.e2;
import c.a.s0.s.q.y0;
import c.a.t0.e1.d1;
import c.a.t0.e1.g1;
import c.a.t0.e1.i1;
import c.a.t0.e1.q0;
import c.a.t0.e1.r0;
import c.a.t0.e1.s;
import c.a.t0.e1.s0;
import c.a.t0.e1.z2.p;
import c.a.t0.k3.u;
import c.a.t0.x3.m;
import c.a.t0.x3.t;
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
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
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
/* loaded from: classes12.dex */
public class FrsGoodFragment extends BaseFragment implements VoiceManager.j, c.a.t0.e1.q2.a, UserIconBox.c, BdListView.p, FrsCommonImageLayout.e, q0, ActivityCompat.OnRequestPermissionsResultCallback, u, r0, c.a.t0.h.e.b, s0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String IS_GAME_FRS = "is_game_frs";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public CustomMessageListener B;
    public Runnable C;
    public CustomMessageListener D;
    public CustomMessageListener E;
    public final CustomMessageListener F;
    public final RecyclerView.OnScrollListener G;
    public final CustomMessageListener H;
    public v I;
    public CustomMessageListener J;
    public long beginTime;
    public long createTime;
    public long drawTime;

    /* renamed from: e  reason: collision with root package name */
    public String f43516e;

    /* renamed from: f  reason: collision with root package name */
    public String f43517f;
    public c.a.t0.e1.m2.a frsGoodView;

    /* renamed from: g  reason: collision with root package name */
    public String f43518g;

    /* renamed from: h  reason: collision with root package name */
    public int f43519h;

    /* renamed from: i  reason: collision with root package name */
    public int f43520i;
    public long initTime;

    /* renamed from: j  reason: collision with root package name */
    public boolean f43521j;
    public String k;
    public FrsViewData l;
    public VoiceManager m;
    public final t mForumModelCallback;
    public FrsGoodModelController n;
    public FrsLoadMoreModel o;
    public int p;
    public int q;
    public int r;
    public boolean s;
    public long sysCreateTime;
    public SparseArray<c.a.t0.h.e.a> t;
    public c.a.t0.e1.j2.b u;
    public boolean v;
    public c.a.s0.g0.c w;
    public String x;
    public int y;
    public int z;

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsGoodFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) && i2 == 0) {
                c.a.t0.g0.v.b().e(true);
                c.a.t0.w3.c.g().h(this.a.getUniqueId(), true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                this.a.z += i3;
                if (this.a.z < this.a.y * 2 || i3 >= 0) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsGoodFragment a;

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
                this.a.F(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements v {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGoodFragment f43522e;

        /* loaded from: classes12.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43523e;

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
                this.f43523e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    NetWork netWork = new NetWork(this.f43523e);
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
            this.f43522e = frsGoodFragment;
        }

        @Override // c.a.d.n.e.v
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || bdUniqueId == null || nVar == null || !(nVar instanceof d2)) {
                return;
            }
            e2 e2Var = ((d2) nVar).w;
            if (e2Var.E() == null || e2Var.E().getGroup_id() == 0 || ViewHelper.checkUpIsLogin(this.f43522e.getActivity())) {
                if (e2Var.w() != 1 || ViewHelper.checkUpIsLogin(this.f43522e.getActivity())) {
                    c.a.t0.x3.p0.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null && !readThreadHistory.d(e2Var.h0())) {
                        readThreadHistory.a(e2Var.h0());
                        c.a.t0.e1.m2.a aVar = this.f43522e.frsGoodView;
                        if (aVar != null) {
                            aVar.v();
                        }
                    }
                    String z2 = e2Var.z();
                    if (z2 == null || z2.equals("")) {
                        z = false;
                    } else {
                        new Thread(new a(this, z2)).start();
                        z = true;
                    }
                    String w1 = e2Var != null ? e2Var.w1() : null;
                    if (w1 == null) {
                        w1 = "";
                    }
                    if (e2Var.t0() == 2 && !w1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                        UrlManager.getInstance().dealOneLink(this.f43522e.getPageContext(), new String[]{w1, "", null});
                        return;
                    }
                    if (w1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && w1.length() > 3 && w1.length() > 3) {
                        e2Var.T3(w1.substring(3));
                    }
                    PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.f43522e.getPageContext().getPageActivity()).createFromThreadCfg(e2Var, this.f43522e.f43517f, FrsFragment.STAR_FRS, 18003, true, false, z);
                    createFromThreadCfg.setForumId(String.valueOf(e2Var.U()));
                    createFromThreadCfg.setStartFrom(3);
                    this.f43522e.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                    if (this.f43522e.l == null || this.f43522e.l.getForum() == null) {
                        return;
                    }
                    c.a.t0.e1.w2.b bVar = new c.a.t0.e1.w2.b();
                    bVar.a = this.f43522e.l.needLog == 1;
                    bVar.f17048c = this.f43522e.l.getForum().getId();
                    c.a.t0.e1.w2.b bVar2 = c.a.t0.e1.w2.d.p0;
                    if (bVar2 != null) {
                        bVar.f17049d = bVar2.f17049d;
                        bVar.f17050e = bVar2.f17050e;
                    }
                    c.a.t0.e1.w2.a.e(e2Var, 1, this.f43522e.getUniqueId(), bVar, this.f43522e.getTbPageTag());
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsGoodFragment a;

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
            this.a = frsGoodFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.a.t0.e1.m2.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || (aVar = this.a.frsGoodView) == null) {
                return;
            }
            aVar.y();
        }
    }

    /* loaded from: classes12.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsGoodFragment a;

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

    /* loaded from: classes12.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGoodFragment f43524e;

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
            this.f43524e = frsGoodFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.d.f.p.l.z() || this.f43524e.s) {
                    this.f43524e.O(null);
                } else {
                    this.f43524e.J(false);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsGoodFragment a;

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
            this.a = frsGoodFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof e2)) {
                e2 e2Var = (e2) customResponsedMessage.getData();
                this.a.f43516e = e2Var.h0();
                if (TextUtils.isEmpty(this.a.f43516e) || e2Var.N0() == null) {
                    return;
                }
                this.a.Q(e2Var.N0().getIsLike());
            }
        }
    }

    /* loaded from: classes12.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsGoodFragment a;

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
                if (this.a.getListView() != null) {
                    this.a.getListView().setSelection(0);
                }
                if (this.a.w != null && this.a.w.isViewAttached()) {
                    this.a.J(false);
                    return;
                }
                c.a.t0.e1.m2.a aVar = this.a.frsGoodView;
                if (aVar != null) {
                    aVar.Z();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class i implements t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrsGoodFragment f43525b;

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
            this.f43525b = frsGoodFragment;
            this.a = 1L;
        }

        @Override // c.a.t0.x3.t
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f43525b.v) {
                return;
            }
            if (i2 == 1 || i2 == 2) {
                this.f43525b.frsGoodView.v();
            } else if (i2 != 3) {
            } else {
                this.f43525b.frsGoodView.I(true);
            }
        }

        @Override // c.a.t0.x3.t
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // c.a.t0.x3.t
        public void c(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar) == null) {
            }
        }

        @Override // c.a.t0.x3.t
        public void d(int i2, boolean z, c.a.t0.x3.f fVar) {
            ArrayList<n> D;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), fVar}) == null) {
                if (this.f43525b.v) {
                    if (this.f43525b.getModelController().x() == null) {
                        this.f43525b.v = false;
                        return;
                    } else if (this.f43525b.getModelController().x().getThreadList().size() >= 10) {
                        this.f43525b.v = false;
                        c.a.t0.e1.x2.e eVar = new c.a.t0.e1.x2.e();
                        eVar.f17097b = 301;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384, eVar));
                        return;
                    }
                }
                if (fVar == null) {
                    this.a = 1L;
                } else if (fVar.f25055b) {
                    this.a = 0L;
                } else {
                    this.a = 1L;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (i2 == 3) {
                    this.f43525b.o.P();
                }
                this.f43525b.frsGoodView.I(false);
                if (this.f43525b.getModelController().x() != null) {
                    FrsGoodFragment frsGoodFragment = this.f43525b;
                    frsGoodFragment.l = frsGoodFragment.getModelController().x();
                }
                FrsGoodFragment frsGoodFragment2 = this.f43525b;
                frsGoodFragment2.p = frsGoodFragment2.l.getPage().b();
                if (this.f43525b.p != 0 || (this.f43525b.l.getThreadListIds() != null && this.f43525b.l.getThreadListIds().size() != 0)) {
                    if (ListUtils.getCount(this.f43525b.l.getThreadList()) > 3) {
                        this.f43525b.frsGoodView.X();
                    } else {
                        this.f43525b.frsGoodView.U();
                    }
                } else if (this.f43525b.l.getThreadList() != null && this.f43525b.l.getThreadList().size() != 0) {
                    this.f43525b.frsGoodView.Y();
                } else {
                    this.f43525b.frsGoodView.p();
                }
                if (i2 == 4) {
                    ArrayList<n> D2 = this.f43525b.o.D(false, false, false, this.f43525b.l.getThreadList(), null);
                    if (D2 != null) {
                        this.f43525b.l.setThreadList(D2);
                        FrsGoodFragment frsGoodFragment3 = this.f43525b;
                        frsGoodFragment3.frsGoodView.T(D2, frsGoodFragment3.f43520i, this.f43525b.l, this.f43525b.p);
                        return;
                    }
                    return;
                }
                if (i2 == 1) {
                    this.f43525b.frsGoodView.v();
                } else if (i2 != 2) {
                    if (i2 == 3 && this.f43525b.l.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, Boolean.TRUE));
                    }
                } else {
                    this.f43525b.frsGoodView.v();
                }
                this.f43525b.hideLoadingView();
                if (this.a != 0) {
                    this.f43525b.O(fVar);
                } else {
                    if (this.f43525b.l != null) {
                        FrsGoodFragment frsGoodFragment4 = this.f43525b;
                        frsGoodFragment4.f43517f = frsGoodFragment4.l.getForum().getName();
                        FrsGoodFragment frsGoodFragment5 = this.f43525b;
                        frsGoodFragment5.k = frsGoodFragment5.l.getForum().getId();
                        FrsGoodFragment frsGoodFragment6 = this.f43525b;
                        frsGoodFragment6.frsGoodView.z(frsGoodFragment6.l.getForum(), this.f43525b.l.getUserData());
                    }
                    if (this.f43525b.l != null) {
                        this.f43525b.l.addNoticeThreadToThreadList();
                    }
                    FrsGoodFragment frsGoodFragment7 = this.f43525b;
                    frsGoodFragment7.frsGoodView.O(frsGoodFragment7.l);
                    if (this.f43525b.l == null || this.f43525b.l.getThreadList() == null || this.f43525b.l.getThreadList().size() != 0 || this.f43525b.getModelController().getType() != 4) {
                        if (this.f43525b.l != null && (D = this.f43525b.o.D(false, false, true, this.f43525b.l.getThreadList(), null)) != null && D.size() > 0) {
                            this.f43525b.l.setThreadList(D);
                        }
                        this.f43525b.M();
                    } else {
                        FrsGoodFragment frsGoodFragment8 = this.f43525b;
                        frsGoodFragment8.showToast(frsGoodFragment8.getPageContext().getString(i1.no_more_to_load));
                        if (this.f43525b.f43520i > 1) {
                            FrsGoodFragment.l(this.f43525b);
                        }
                        if (this.f43525b.initTime > -1) {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            FrsGoodFragment frsGoodFragment9 = this.f43525b;
                            long z2 = frsGoodFragment9.getModelController().z();
                            FrsGoodFragment frsGoodFragment10 = this.f43525b;
                            TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis2 - frsGoodFragment9.initTime, z2 - frsGoodFragment10.initTime, frsGoodFragment10.getModelController().B(), this.f43525b.getModelController().A(), currentTimeMillis2 - this.f43525b.getModelController().y());
                            this.f43525b.initTime = -1L;
                        }
                        this.f43525b.drawTime = System.currentTimeMillis() - currentTimeMillis;
                        return;
                    }
                }
                if (this.f43525b.initTime > -1) {
                    long currentTimeMillis3 = System.currentTimeMillis();
                    FrsGoodFragment frsGoodFragment11 = this.f43525b;
                    long z3 = frsGoodFragment11.getModelController().z();
                    FrsGoodFragment frsGoodFragment12 = this.f43525b;
                    TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis3 - frsGoodFragment11.initTime, z3 - frsGoodFragment12.initTime, frsGoodFragment12.getModelController().B(), this.f43525b.getModelController().A(), currentTimeMillis3 - this.f43525b.getModelController().y());
                    this.f43525b.initTime = -1L;
                }
                this.f43525b.drawTime = System.currentTimeMillis() - currentTimeMillis;
                System.gc();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsGoodFragment a;

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
            this.a = frsGoodFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.a.t0.e1.m2.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || (aVar = this.a.frsGoodView) == null) {
                return;
            }
            aVar.Z();
        }
    }

    /* loaded from: classes12.dex */
    public class k implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGoodFragment f43526e;

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
            this.f43526e = frsGoodFragment;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (this.f43526e.u != null) {
                    this.f43526e.u.b(view, motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGoodFragment f43527e;

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
            this.f43527e = frsGoodFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.t0.x3.p0.a.o(this.f43527e.f43517f);
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
        this.f43517f = null;
        this.f43518g = null;
        this.f43519h = 0;
        this.f43520i = 1;
        this.f43521j = false;
        this.k = null;
        this.l = new FrsViewData();
        this.initTime = -1L;
        this.sysCreateTime = 0L;
        this.drawTime = 0L;
        this.createTime = 0L;
        this.beginTime = -1L;
        this.frsGoodView = null;
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
        this.mForumModelCallback = new i(this);
        this.F = new j(this, 2003003);
        this.G = new a(this);
        this.H = new b(this, 0);
        this.I = new c(this);
        this.J = new d(this, 2921414);
    }

    public static /* synthetic */ int l(FrsGoodFragment frsGoodFragment) {
        int i2 = frsGoodFragment.f43520i;
        frsGoodFragment.f43520i = i2 - 1;
        return i2;
    }

    public final void F(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || this.l == null || this.frsGoodView == null || !(responsedMessage instanceof DownloadMessage) || (data = ((DownloadMessage) responsedMessage).getData()) == null) {
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
            this.frsGoodView.v();
        }
    }

    public final int G(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) {
            if (i2 != 1) {
                return (i2 != 2 || i3 == 1) ? 0 : 3;
            }
            return 3;
        }
        return invokeII.intValue;
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            registerListener(2001118, this.H);
        }
    }

    public final void I(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            H();
            if (bundle != null) {
                this.f43517f = bundle.getString("name");
                this.f43518g = bundle.getString("from");
                this.f43519h = bundle.getInt("flag", 0);
            } else {
                Bundle arguments = getArguments();
                if (arguments != null) {
                    this.f43517f = arguments.getString("name");
                    this.f43518g = arguments.getString("from");
                    this.f43519h = arguments.getInt("flag", 0);
                }
            }
            if (TextUtils.isEmpty(this.f43518g) || !FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.f43518g)) {
                return;
            }
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    public final void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.s = true;
            stopVoice();
            hideNetRefreshView();
            if (!z) {
                hideNetRefreshView();
                showLoadingView();
            }
            FrsGoodModelController frsGoodModelController = this.n;
            if (frsGoodModelController != null) {
                frsGoodModelController.F(this.q);
            }
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f43519h == 1) {
                c.a.d.f.m.h.a().b(new l(this));
            }
            this.f43519h = 0;
        }
    }

    public final void L() {
        c.a.t0.e1.m2.a aVar;
        HashMap<Integer, e2> j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.frsGoodView) == null || aVar.m() == null || (j2 = this.frsGoodView.m().j()) == null) {
            return;
        }
        ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
        for (Map.Entry<Integer, e2> entry : j2.entrySet()) {
            e2 value = entry.getValue();
            if (value != null && (value instanceof AdvertAppInfo)) {
                arrayList.add((AdvertAppInfo) value);
            }
        }
        c.a.s0.w.c.q().u(arrayList);
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            stopVoice();
            try {
                if (this.l == null) {
                    return;
                }
                this.frsGoodView.F();
                this.frsGoodView.W();
                this.f43517f = this.l.getForum().getName();
                this.k = this.l.getForum().getId();
                if (this.l != null && this.l.getForum() != null) {
                    this.frsGoodView.S(this.l.getForum().getThemeColorInfo());
                    this.frsGoodView.O(this.l);
                }
                TbadkCoreApplication.getInst().setDefaultBubble(this.l.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.l.getUserData().getBimg_end_time());
                K();
                if (!this.frsGoodView.m().o(e2.I3)) {
                    this.l.removeAlaLiveThreadData();
                }
                ArrayList<n> threadList = this.l.getThreadList();
                if (threadList != null) {
                    this.frsGoodView.T(threadList, this.f43520i, this.l, this.l.getPage().b());
                    L();
                    this.frsGoodView.H();
                    if (this.l.getIsNewUrl() == 1) {
                        this.frsGoodView.m().x(true);
                    } else {
                        this.frsGoodView.m().x(false);
                    }
                    this.frsGoodView.K(G(getModelController().getType(), this.f43520i));
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.p == 0 && !this.o.A(this.l.getThreadListIds())) {
                if (this.l.getThreadList() != null && this.l.getThreadList().size() != 0) {
                    this.frsGoodView.Y();
                } else {
                    this.frsGoodView.p();
                }
            } else if (ListUtils.getCount(this.l.getThreadList()) > 3) {
                this.frsGoodView.X();
            } else {
                this.frsGoodView.U();
            }
        }
    }

    public final void O(c.a.t0.x3.f fVar) {
        c.a.t0.e1.m2.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, fVar) == null) || (aVar = this.frsGoodView) == null) {
            return;
        }
        aVar.J(false);
        this.frsGoodView.N(false);
        this.frsGoodView.p();
        this.frsGoodView.n().getData().clear();
        this.frsGoodView.v();
        if (this.w == null) {
            c.a.s0.g0.c cVar = new c.a.s0.g0.c(getPageContext().getContext(), getNetRefreshListener());
            this.w = cVar;
            cVar.e(null);
            this.w.c(null);
            this.w.f();
            this.w.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.w.d(getPageContext().getResources().getString(i1.net_error_text, fVar.f25057d, Integer.valueOf(fVar.f25056c)));
        } else {
            this.w.d(null);
        }
        this.w.onChangeSkinType();
        this.w.attachView(this.frsGoodView.o(), true);
        this.w.a(0);
    }

    public final void P(e2 e2Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, e2Var, i2) == null) {
            if (i2 == 1) {
                PraiseData N0 = e2Var.N0();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (N0 == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i2);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        e2Var.r4(praiseData);
                        return;
                    }
                    e2Var.N0().getUser().add(0, metaData);
                    e2Var.N0().setNum(e2Var.N0().getNum() + 1);
                    e2Var.N0().setIsLike(i2);
                }
            } else if (e2Var.N0() != null) {
                e2Var.N0().setIsLike(i2);
                e2Var.N0().setNum(e2Var.N0().getNum() - 1);
                ArrayList<MetaData> user = e2Var.N0().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            e2Var.N0().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public final void Q(int i2) {
        ArrayList<n> threadList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (threadList = this.l.getThreadList()) == null) {
            return;
        }
        Iterator<n> it = threadList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            n next = it.next();
            if (next instanceof d2) {
                e2 e2Var = ((d2) next).w;
                if (e2Var.h0() != null && e2Var.h0().equals(this.f43516e)) {
                    P(e2Var, i2);
                    this.f43516e = null;
                    break;
                }
            }
        }
        this.frsGoodView.m().w(threadList, this.l);
        this.frsGoodView.m().p();
    }

    public void addThreadData(y0 y0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, y0Var) == null) || y0Var == null || getFrsViewData() == null || getFrsViewData().getThreadList() == null) {
            return;
        }
        if (ListUtils.isEmpty(getFrsViewData().getThreadList())) {
            getFrsViewData().getThreadList().add(y0Var);
        } else {
            if (getFrsViewData().getThreadList().size() == 1 && (getFrsViewData().getThreadList().get(0) instanceof s)) {
                getFrsViewData().getThreadList().remove(0);
            }
            getFrsViewData().getThreadList().add(0, y0Var);
        }
        c.a.t0.e1.m2.a aVar = this.frsGoodView;
        ArrayList<n> threadList = this.l.getThreadList();
        int i2 = this.f43520i;
        FrsViewData frsViewData = this.l;
        aVar.T(threadList, i2, frsViewData, frsViewData.getPage().b());
        this.frsGoodView.H();
        this.frsGoodView.K(0);
    }

    @Override // c.a.t0.e1.q0
    public void changeToSpecialFrs(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
        }
    }

    public c.a.d.n.e.a createFrsExtraAdapter(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, bdUniqueId)) == null) ? c.a.t0.e1.e.e().d(getPageContext(), bdUniqueId, getPageContext().getUniqueId()) : (c.a.d.n.e.a) invokeL.objValue;
    }

    @Override // c.a.t0.h.e.b
    public void dispatchInjectPluginMessage(c.a.t0.h.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, dVar) == null) {
        }
    }

    @Override // c.a.t0.e1.q0
    public void forceRefresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.frsGoodView == null) {
            return;
        }
        scrollToTop();
        this.frsGoodView.Z();
    }

    public String getCurrentPageKeyForTabId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? "a072" : (String) invokeV.objValue;
    }

    @Override // c.a.t0.k3.u
    public String getFid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    @Override // c.a.t0.e1.q2.a, c.a.t0.e1.u0
    public String getForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f43517f : (String) invokeV.objValue;
    }

    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f43518g : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public c.a.d.f.k.b<TbImageView> getFrsCommonImageLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (getBaseFragmentActivity() instanceof FrsActivity) {
                return ((FrsActivity) getBaseFragmentActivity()).getFrsCommonImageLayoutPool();
            }
            return null;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    @Override // c.a.t0.e1.q2.a
    public FrsViewData getFrsViewData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.l : (FrsViewData) invokeV.objValue;
    }

    @Override // c.a.t0.h.e.b
    public c.a.t0.h.e.a getInjectPlugin(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) ? this.t.get(i2) : (c.a.t0.h.e.a) invokeI.objValue;
    }

    public FrsLoadMoreModel getLoadMoreModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.o : (FrsLoadMoreModel) invokeV.objValue;
    }

    public FrsGoodModelController getModelController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.n : (FrsGoodModelController) invokeV.objValue;
    }

    @Override // c.a.t0.e1.r0
    public NavigationBar getNavigationBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return null;
        }
        return (NavigationBar) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.t0.e1.q2.a
    public /* bridge */ /* synthetic */ c.a.d.a.f getPageContext() {
        return super.getPageContext();
    }

    @Override // c.a.t0.k3.u
    public int getPageNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f43520i : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, voiceData$VoiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // c.a.t0.k3.u
    public TbPageContext<?> getTbPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? getPageContext() : (TbPageContext) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            TbPageTag tbPageTag = super.getTbPageTag();
            FrsViewData frsViewData = this.l;
            tbPageTag.sortType = p.g(frsViewData != null ? frsViewData.getSortType() : -1);
            tbPageTag.locatePage = "a072";
            return tbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public c.a.d.f.k.b<TbImageView> getUserIconPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            if (getBaseFragmentActivity() instanceof FrsActivity) {
                return ((FrsActivity) getBaseFragmentActivity()).getUserIconPool();
            }
            return null;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    public int getUserIconViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            if (this.m == null) {
                this.m = VoiceManager.instance();
            }
            return this.m;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public final void hideLoadingView() {
        c.a.t0.e1.m2.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || (aVar = this.frsGoodView) == null) {
            return;
        }
        aVar.J(true);
        hideLoadingView(this.frsGoodView.o());
    }

    public final void hideNetRefreshView() {
        c.a.t0.e1.m2.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || (aVar = this.frsGoodView) == null) {
            return;
        }
        aVar.J(true);
        this.frsGoodView.N(true);
        c.a.s0.g0.c cVar = this.w;
        if (cVar == null || !cVar.isViewAttached()) {
            return;
        }
        this.w.dettachView(this.frsGoodView.o());
    }

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            if (this.f43519h != 0) {
                this.f43519h = 1;
            }
            this.u = new c.a.t0.e1.j2.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
            this.frsGoodView.L(this.I);
            this.frsGoodView.M(this.G);
            this.frsGoodView.n().setOnTouchListener(new k(this));
        }
    }

    public void loadTabData(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            this.q = i2;
            if (c.a.d.f.p.l.z()) {
                J(false);
            } else {
                O(null);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        e2 threadDataById;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048617, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1 && i2 == 18003) {
                this.frsGoodView.m().p();
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra == null || (threadDataById = this.l.getThreadDataById(stringExtra)) == null) {
                    return;
                }
                int intExtra = intent.getIntExtra("type", -1);
                if (intExtra == 2) {
                    threadDataById.c4(intent.getIntExtra("good_data", 0));
                    threadDataById.h3();
                    J(false);
                } else if (intExtra == 0) {
                    this.l.removeThreadData(threadDataById);
                    ArrayList<n> threadList = this.l.getThreadList();
                    if (threadList != null && threadList.size() <= 0) {
                        threadList.add(new s());
                    }
                    this.frsGoodView.H();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            if (this.r == 3 && this.frsGoodView == null) {
                return;
            }
            this.r = i2;
            super.onChangeSkinType(i2);
            c.a.t0.e1.m2.a aVar = this.frsGoodView;
            if (aVar != null) {
                aVar.w(i2);
            }
            c.a.s0.g0.c cVar = this.w;
            if (cVar == null || !cVar.isViewAttached()) {
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
                this.initTime = arguments.getLong("TibaStatic.StartTime", System.currentTimeMillis());
            } else {
                this.initTime = System.currentTimeMillis();
            }
            if (arguments != null) {
                this.x = arguments.getString("forum_id", "");
                this.A = arguments.getBoolean(FrsActivityConfig.FLAG_SHOW_AD);
            }
            long currentTimeMillis = System.currentTimeMillis();
            this.beginTime = currentTimeMillis;
            this.sysCreateTime = currentTimeMillis - this.initTime;
            super.onCreate(bundle);
            c.a.t0.w3.c.g().i(getUniqueId());
            FrsGoodModelController frsGoodModelController = new FrsGoodModelController(this);
            this.n = frsGoodModelController;
            if (arguments != null) {
                frsGoodModelController.D(arguments);
                this.f43521j = arguments.getBoolean(IS_GAME_FRS, false);
            } else if (bundle != null) {
                frsGoodModelController.D(bundle);
                this.f43521j = bundle.getBoolean(IS_GAME_FRS, false);
            } else {
                frsGoodModelController.D(null);
            }
            VoiceManager voiceManager = getVoiceManager();
            this.m = voiceManager;
            voiceManager.onCreate(getPageContext());
            I(bundle);
            registerListener(this.F);
            registerListener(this.D);
            registerListener(this.E);
            registerListener(this.J);
            registerListener(this.B);
            FrsLoadMoreModel frsLoadMoreModel = new FrsLoadMoreModel(this, null);
            this.o = frsLoadMoreModel;
            frsLoadMoreModel.registerListener();
            this.o.T(2);
            this.o.R(true);
            this.o.Q(c.a.t0.g1.a.a(this.A));
            this.createTime = System.currentTimeMillis() - this.beginTime;
            this.y = UtilHelper.getScreenHeight(getActivity());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048620, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(g1.frs_good_activity, (ViewGroup) null);
            c.a.t0.e1.m2.a aVar = new c.a.t0.e1.m2.a(this, inflate, this.f43521j);
            this.frsGoodView = aVar;
            aVar.m().A();
            initUI();
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            c.a.t0.e1.m2.a aVar = this.frsGoodView;
            if (aVar != null) {
                aVar.x();
            }
            MessageManager.getInstance().unRegisterListener(this.B);
            c.a.t0.w3.c.g().k(getUniqueId());
            c.a.t0.g0.v.b().e(false);
            super.onDestroy();
            this.n.H();
            VoiceManager voiceManager = getVoiceManager();
            this.m = voiceManager;
            voiceManager.onDestory(getPageContext());
            c.a.d.f.m.e.a().removeCallbacks(this.C);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void onFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            N();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public q onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            if (getListView() == null) {
                return null;
            }
            return getListView().getPreLoadHandle();
        }
        return (q) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            super.onLazyLoad();
            if (this.s) {
                return;
            }
            if (c.a.d.f.p.l.z()) {
                J(false);
            } else {
                O(null);
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

    @Override // c.a.t0.e1.s0
    public void onLoadingComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            c.a.t0.w3.c.g().h(getUniqueId(), false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048627, this) == null) && c.a.d.f.p.l.z()) {
            J(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            super.onPause();
            VoiceManager voiceManager = getVoiceManager();
            this.m = voiceManager;
            voiceManager.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                if (this.r == 3) {
                    onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                }
                if (this.s) {
                    return;
                }
                c.a.d.f.m.e.a().post(this.C);
            }
        }
    }

    @Override // c.a.t0.e1.s0
    public void onPullRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            if (getPageContext() != null) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            }
            if (c.a.d.f.p.l.z()) {
                c.a.t0.t.d.c().f("page_frs_good");
                J(true);
                return;
            }
            this.frsGoodView.I(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048631, this, i2, strArr, iArr) == null) && i2 == 1) {
            if (PermissionUtil.checkCamera(getActivity().getApplicationContext())) {
                SelectImageHelper.takePhoto(getPageContext());
            } else {
                showToast(i1.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = PermissionUtil.transformPermissionResult(strArr, iArr);
            if (!transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") || transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                return;
            }
            showToast(i1.sdcard_permission_denied_advert_for_camera);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            super.onResume();
            c.a.t0.e1.m2.a aVar = this.frsGoodView;
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
        if (interceptable == null || interceptable.invokeL(1048633, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("name", this.f43517f);
            bundle.putString("from", this.f43518g);
            bundle.putBoolean(IS_GAME_FRS, this.f43521j);
            this.n.onSaveInstanceState(bundle);
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
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            if (!c.a.d.f.p.n.C()) {
                this.frsGoodView.p();
            } else if (!this.n.C()) {
                this.frsGoodView.p();
            } else {
                N();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
                if (this.o.isLoading || this.n.E()) {
                    return;
                }
                if (this.o.A(this.l.getThreadListIds())) {
                    FrsViewData frsViewData = this.l;
                    String e2 = c.a.t0.k3.a.e(frsViewData != null ? frsViewData.getThreadList() : null, false);
                    this.frsGoodView.T(this.o.N(), this.f43520i, this.l, 0);
                    this.o.O(c.a.d.f.m.b.g(this.k, 0L), this.l.getThreadListIds(), this.f43517f, this.f43520i, this.l.isBrandForum, e2);
                } else if (this.p != 0) {
                    FrsViewData frsViewData2 = this.l;
                    String e3 = c.a.t0.k3.a.e(frsViewData2 != null ? frsViewData2.getThreadList() : null, false);
                    this.frsGoodView.T(this.o.N(), this.f43520i, this.l, 0);
                    int i2 = this.f43520i + 1;
                    this.f43520i = i2;
                    this.n.G(i2, e3);
                    FrsLoadMoreModel frsLoadMoreModel = this.o;
                    frsLoadMoreModel.loadingDone = false;
                    frsLoadMoreModel.loadIndex = 0;
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            super.onStart();
            VoiceManager voiceManager = getVoiceManager();
            this.m = voiceManager;
            voiceManager.onStart(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            super.onStop();
            c.a.t0.g0.v.b().e(false);
            c.a.t0.w3.c.g().h(getUniqueId(), false);
            FrsViewData frsViewData = this.l;
            if (frsViewData != null && frsViewData.getForum() != null) {
                c.a.s0.v.a.k().y(getPageContext().getPageActivity(), "frs", this.l.getForum().getId(), 0L);
            }
            VoiceManager voiceManager = getVoiceManager();
            this.m = voiceManager;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void onSuccess(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, arrayList) == null) {
            N();
            if (arrayList == null || arrayList.size() == 0) {
                return;
            }
            ArrayList<n> D = this.o.D(false, false, false, arrayList, null);
            if (D != null) {
                this.l.setThreadList(D);
                this.frsGoodView.T(D, this.f43520i, this.l, 0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.l.getForum()));
        }
    }

    public void refreshRecyclerView() {
        c.a.t0.e1.m2.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048638, this) == null) || (aVar = this.frsGoodView) == null) {
            return;
        }
        aVar.A();
    }

    @Override // c.a.t0.e1.q0
    public void scrollToTop() {
        c.a.t0.e1.m2.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048639, this) == null) || (aVar = this.frsGoodView) == null || aVar.n() == null) {
            return;
        }
        this.frsGoodView.n().scrollToPosition(0);
    }

    public void setFlag(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048640, this, i2) == null) {
            this.f43519h = i2;
        }
    }

    public void setForum(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, str) == null) {
            this.f43517f = str;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, str) == null) {
            this.f43518g = str;
        }
    }

    public void setFrsView(c.a.t0.e1.m2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, aVar) == null) {
            this.frsGoodView = aVar;
        }
    }

    @Override // c.a.t0.h.e.b
    public void setInjectPlugin(int i2, c.a.t0.h.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048644, this, i2, aVar) == null) {
            this.t.put(i2, aVar);
        }
    }

    public void setPn(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048645, this, i2) == null) {
            this.f43520i = i2;
        }
    }

    public final void showLoadingView() {
        c.a.t0.e1.m2.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048646, this) == null) || (aVar = this.frsGoodView) == null) {
            return;
        }
        aVar.J(false);
        showLoadingView(this.frsGoodView.o(), true, getResources().getDimensionPixelSize(d1.ds250));
    }

    public void stopVoice() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            VoiceManager voiceManager = getVoiceManager();
            this.m = voiceManager;
            voiceManager.stopPlay();
        }
    }

    @Override // c.a.t0.k3.u
    public void updateLastIds() {
        FrsGoodModelController frsGoodModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048648, this) == null) || (frsGoodModelController = this.n) == null) {
            return;
        }
        frsGoodModelController.L();
    }

    /* JADX DEBUG: Method merged with bridge method */
    public BdTypeRecyclerView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            c.a.t0.e1.m2.a aVar = this.frsGoodView;
            if (aVar == null) {
                return null;
            }
            return aVar.n();
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }
}
