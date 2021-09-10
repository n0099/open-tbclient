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
import c.a.e.l.e.n;
import c.a.e.l.e.q;
import c.a.e.l.e.w;
import c.a.q0.s.q.c2;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.y0;
import c.a.r0.a0.t;
import c.a.r0.j3.m;
import c.a.r0.j3.s;
import c.a.r0.w0.p0;
import c.a.r0.w0.q0;
import c.a.r0.w0.r0;
import c.a.r0.y2.u;
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
/* loaded from: classes7.dex */
public class FrsGoodFragment extends BaseFragment implements VoiceManager.j, c.a.r0.w0.e2.a, UserIconBox.c, BdListView.p, FrsCommonImageLayout.e, p0, ActivityCompat.OnRequestPermissionsResultCallback, u, q0, c.a.r0.f.e.b, r0 {
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
    public w I;
    public CustomMessageListener J;
    public long beginTime;
    public long createTime;
    public long drawTime;

    /* renamed from: e  reason: collision with root package name */
    public String f51365e;

    /* renamed from: f  reason: collision with root package name */
    public String f51366f;
    public c.a.r0.w0.a2.a frsGoodView;

    /* renamed from: g  reason: collision with root package name */
    public String f51367g;

    /* renamed from: h  reason: collision with root package name */
    public int f51368h;

    /* renamed from: i  reason: collision with root package name */
    public int f51369i;
    public long initTime;

    /* renamed from: j  reason: collision with root package name */
    public boolean f51370j;
    public String k;
    public FrsViewData l;
    public VoiceManager m;
    public final s mForumModelCallback;
    public FrsGoodModelController n;
    public FrsLoadMoreModel o;
    public int p;
    public int q;
    public int r;
    public boolean s;
    public long sysCreateTime;
    public SparseArray<c.a.r0.f.e.a> t;
    public c.a.r0.w0.x1.b u;
    public boolean v;
    public c.a.q0.g0.c w;
    public String x;
    public int y;
    public int z;

    /* loaded from: classes7.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsGoodFragment f51371a;

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
            this.f51371a = frsGoodFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) && i2 == 0) {
                t.b().e(true);
                c.a.r0.i3.c.g().h(this.f51371a.getUniqueId(), true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                this.f51371a.z += i3;
                if (this.f51371a.z < this.f51371a.y * 2 || i3 >= 0) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsGoodFragment f51372a;

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
            this.f51372a = frsGoodFragment;
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
                this.f51372a.A(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGoodFragment f51373e;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f51374e;

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
                this.f51374e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    NetWork netWork = new NetWork(this.f51374e);
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
            this.f51373e = frsGoodFragment;
        }

        @Override // c.a.e.l.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || bdUniqueId == null || nVar == null || !(nVar instanceof c2)) {
                return;
            }
            d2 d2Var = ((c2) nVar).w;
            if (d2Var.E() == null || d2Var.E().getGroup_id() == 0 || ViewHelper.checkUpIsLogin(this.f51373e.getActivity())) {
                if (d2Var.w() != 1 || ViewHelper.checkUpIsLogin(this.f51373e.getActivity())) {
                    c.a.r0.j3.o0.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null && !readThreadHistory.d(d2Var.f0())) {
                        readThreadHistory.a(d2Var.f0());
                        c.a.r0.w0.a2.a aVar = this.f51373e.frsGoodView;
                        if (aVar != null) {
                            aVar.v();
                        }
                    }
                    String z2 = d2Var.z();
                    if (z2 == null || z2.equals("")) {
                        z = false;
                    } else {
                        new Thread(new a(this, z2)).start();
                        z = true;
                    }
                    String s1 = d2Var != null ? d2Var.s1() : null;
                    if (s1 == null) {
                        s1 = "";
                    }
                    if (d2Var.r0() == 2 && !s1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                        UrlManager.getInstance().dealOneLink(this.f51373e.getPageContext(), new String[]{s1, "", null});
                        return;
                    }
                    if (s1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && s1.length() > 3 && s1.length() > 3) {
                        d2Var.O3(s1.substring(3));
                    }
                    PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.f51373e.getPageContext().getPageActivity()).createFromThreadCfg(d2Var, this.f51373e.f51366f, FrsFragment.STAR_FRS, 18003, true, false, z);
                    createFromThreadCfg.setForumId(String.valueOf(d2Var.T()));
                    createFromThreadCfg.setStartFrom(3);
                    this.f51373e.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                    if (this.f51373e.l == null || this.f51373e.l.getForum() == null) {
                        return;
                    }
                    c.a.r0.w0.k2.b bVar = new c.a.r0.w0.k2.b();
                    bVar.f26939a = this.f51373e.l.needLog == 1;
                    bVar.f26941c = this.f51373e.l.getForum().getId();
                    c.a.r0.w0.k2.b bVar2 = c.a.r0.w0.k2.d.h0;
                    if (bVar2 != null) {
                        bVar.f26942d = bVar2.f26942d;
                        bVar.f26943e = bVar2.f26943e;
                    }
                    c.a.r0.w0.k2.a.e(d2Var, 1, this.f51373e.getUniqueId(), bVar, this.f51373e.getTbPageTag());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsGoodFragment f51375a;

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
            this.f51375a = frsGoodFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.a.r0.w0.a2.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || (aVar = this.f51375a.frsGoodView) == null) {
                return;
            }
            aVar.y();
        }
    }

    /* loaded from: classes7.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsGoodFragment f51376a;

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
            this.f51376a = frsGoodFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer) || (num = (Integer) customResponsedMessage.getData()) == null || this.f51376a.w == null || !this.f51376a.w.isViewAttached()) {
                return;
            }
            this.f51376a.w.a(num.intValue());
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGoodFragment f51377e;

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
            this.f51377e = frsGoodFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.e.e.p.j.z() || this.f51377e.s) {
                    this.f51377e.Q(null);
                } else {
                    this.f51377e.K(false);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsGoodFragment f51378a;

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
            this.f51378a = frsGoodFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof d2)) {
                d2 d2Var = (d2) customResponsedMessage.getData();
                this.f51378a.f51365e = d2Var.f0();
                if (TextUtils.isEmpty(this.f51378a.f51365e) || d2Var.L0() == null) {
                    return;
                }
                this.f51378a.S(d2Var.L0().getIsLike());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsGoodFragment f51379a;

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
            this.f51379a = frsGoodFragment;
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
                if (this.f51379a.getListView() != null) {
                    this.f51379a.getListView().setSelection(0);
                }
                if (this.f51379a.w != null && this.f51379a.w.isViewAttached()) {
                    this.f51379a.K(false);
                    return;
                }
                c.a.r0.w0.a2.a aVar = this.f51379a.frsGoodView;
                if (aVar != null) {
                    aVar.Z();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f51380a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrsGoodFragment f51381b;

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
            this.f51381b = frsGoodFragment;
            this.f51380a = 1L;
        }

        @Override // c.a.r0.j3.s
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f51381b.v) {
                return;
            }
            if (i2 == 1 || i2 == 2) {
                this.f51381b.frsGoodView.v();
            } else if (i2 != 3) {
            } else {
                this.f51381b.frsGoodView.I(true);
            }
        }

        @Override // c.a.r0.j3.s
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // c.a.r0.j3.s
        public void c(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar) == null) {
            }
        }

        @Override // c.a.r0.j3.s
        public void d(int i2, boolean z, c.a.r0.j3.f fVar) {
            ArrayList<n> C;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), fVar}) == null) {
                if (this.f51381b.v) {
                    if (this.f51381b.getModelController().x() == null) {
                        this.f51381b.v = false;
                        return;
                    } else if (this.f51381b.getModelController().x().getThreadList().size() >= 10) {
                        this.f51381b.v = false;
                        c.a.r0.w0.l2.e eVar = new c.a.r0.w0.l2.e();
                        eVar.f27001b = 301;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921384, eVar));
                        return;
                    }
                }
                if (fVar == null) {
                    this.f51380a = 1L;
                } else if (fVar.f20793b) {
                    this.f51380a = 0L;
                } else {
                    this.f51380a = 1L;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (i2 == 3) {
                    this.f51381b.o.N();
                }
                this.f51381b.frsGoodView.I(false);
                if (this.f51381b.getModelController().x() != null) {
                    FrsGoodFragment frsGoodFragment = this.f51381b;
                    frsGoodFragment.l = frsGoodFragment.getModelController().x();
                }
                FrsGoodFragment frsGoodFragment2 = this.f51381b;
                frsGoodFragment2.p = frsGoodFragment2.l.getPage().b();
                if (this.f51381b.p != 0 || (this.f51381b.l.getThreadListIds() != null && this.f51381b.l.getThreadListIds().size() != 0)) {
                    if (ListUtils.getCount(this.f51381b.l.getThreadList()) > 3) {
                        this.f51381b.frsGoodView.X();
                    } else {
                        this.f51381b.frsGoodView.U();
                    }
                } else if (this.f51381b.l.getThreadList() != null && this.f51381b.l.getThreadList().size() != 0) {
                    this.f51381b.frsGoodView.Y();
                } else {
                    this.f51381b.frsGoodView.p();
                }
                if (i2 == 4) {
                    ArrayList<n> C2 = this.f51381b.o.C(false, false, false, this.f51381b.l.getThreadList(), null);
                    if (C2 != null) {
                        this.f51381b.l.setThreadList(C2);
                        FrsGoodFragment frsGoodFragment3 = this.f51381b;
                        frsGoodFragment3.frsGoodView.T(C2, frsGoodFragment3.f51369i, this.f51381b.l, this.f51381b.p);
                        return;
                    }
                    return;
                }
                if (i2 == 1) {
                    this.f51381b.frsGoodView.v();
                } else if (i2 != 2) {
                    if (i2 == 3 && this.f51381b.l.isShowRedTip()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, Boolean.TRUE));
                    }
                } else {
                    this.f51381b.frsGoodView.v();
                }
                this.f51381b.hideLoadingView();
                if (this.f51380a != 0) {
                    this.f51381b.Q(fVar);
                } else {
                    if (this.f51381b.l != null) {
                        FrsGoodFragment frsGoodFragment4 = this.f51381b;
                        frsGoodFragment4.f51366f = frsGoodFragment4.l.getForum().getName();
                        FrsGoodFragment frsGoodFragment5 = this.f51381b;
                        frsGoodFragment5.k = frsGoodFragment5.l.getForum().getId();
                        FrsGoodFragment frsGoodFragment6 = this.f51381b;
                        frsGoodFragment6.frsGoodView.z(frsGoodFragment6.l.getForum(), this.f51381b.l.getUserData());
                    }
                    if (this.f51381b.l != null) {
                        this.f51381b.l.addNoticeThreadToThreadList();
                    }
                    FrsGoodFragment frsGoodFragment7 = this.f51381b;
                    frsGoodFragment7.frsGoodView.O(frsGoodFragment7.l);
                    if (this.f51381b.l == null || this.f51381b.l.getThreadList() == null || this.f51381b.l.getThreadList().size() != 0 || this.f51381b.getModelController().getType() != 4) {
                        if (this.f51381b.l != null && (C = this.f51381b.o.C(false, false, true, this.f51381b.l.getThreadList(), null)) != null && C.size() > 0) {
                            this.f51381b.l.setThreadList(C);
                        }
                        this.f51381b.O();
                    } else {
                        FrsGoodFragment frsGoodFragment8 = this.f51381b;
                        frsGoodFragment8.showToast(frsGoodFragment8.getPageContext().getString(R.string.no_more_to_load));
                        if (this.f51381b.f51369i > 1) {
                            FrsGoodFragment.h(this.f51381b);
                        }
                        if (this.f51381b.initTime > -1) {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            FrsGoodFragment frsGoodFragment9 = this.f51381b;
                            long z2 = frsGoodFragment9.getModelController().z();
                            FrsGoodFragment frsGoodFragment10 = this.f51381b;
                            TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis2 - frsGoodFragment9.initTime, z2 - frsGoodFragment10.initTime, frsGoodFragment10.getModelController().B(), this.f51381b.getModelController().A(), currentTimeMillis2 - this.f51381b.getModelController().y());
                            this.f51381b.initTime = -1L;
                        }
                        this.f51381b.drawTime = System.currentTimeMillis() - currentTimeMillis;
                        return;
                    }
                }
                if (this.f51381b.initTime > -1) {
                    long currentTimeMillis3 = System.currentTimeMillis();
                    FrsGoodFragment frsGoodFragment11 = this.f51381b;
                    long z3 = frsGoodFragment11.getModelController().z();
                    FrsGoodFragment frsGoodFragment12 = this.f51381b;
                    TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis3 - frsGoodFragment11.initTime, z3 - frsGoodFragment12.initTime, frsGoodFragment12.getModelController().B(), this.f51381b.getModelController().A(), currentTimeMillis3 - this.f51381b.getModelController().y());
                    this.f51381b.initTime = -1L;
                }
                this.f51381b.drawTime = System.currentTimeMillis() - currentTimeMillis;
                System.gc();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsGoodFragment f51382a;

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
            this.f51382a = frsGoodFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.a.r0.w0.a2.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || (aVar = this.f51382a.frsGoodView) == null) {
                return;
            }
            aVar.Z();
        }
    }

    /* loaded from: classes7.dex */
    public class k implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGoodFragment f51383e;

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
            this.f51383e = frsGoodFragment;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (this.f51383e.u != null) {
                    this.f51383e.u.b(view, motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGoodFragment f51384e;

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
            this.f51384e = frsGoodFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.j3.o0.a.o(this.f51384e.f51366f);
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
        this.f51366f = null;
        this.f51367g = null;
        this.f51368h = 0;
        this.f51369i = 1;
        this.f51370j = false;
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

    public static /* synthetic */ int h(FrsGoodFragment frsGoodFragment) {
        int i2 = frsGoodFragment.f51369i;
        frsGoodFragment.f51369i = i2 - 1;
        return i2;
    }

    public final void A(ResponsedMessage<?> responsedMessage) {
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

    public final int B(int i2, int i3) {
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

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            registerListener(2001118, this.H);
        }
    }

    public final void J(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            D();
            if (bundle != null) {
                this.f51366f = bundle.getString("name");
                this.f51367g = bundle.getString("from");
                this.f51368h = bundle.getInt("flag", 0);
            } else {
                Bundle arguments = getArguments();
                if (arguments != null) {
                    this.f51366f = arguments.getString("name");
                    this.f51367g = arguments.getString("from");
                    this.f51368h = arguments.getInt("flag", 0);
                }
            }
            if (TextUtils.isEmpty(this.f51367g) || !FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.f51367g)) {
                return;
            }
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    public final void K(boolean z) {
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

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f51368h == 1) {
                c.a.e.e.m.h.a().b(new l(this));
            }
            this.f51368h = 0;
        }
    }

    public final void N() {
        c.a.r0.w0.a2.a aVar;
        HashMap<Integer, d2> j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.frsGoodView) == null || aVar.m() == null || (j2 = this.frsGoodView.m().j()) == null) {
            return;
        }
        ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
        for (Map.Entry<Integer, d2> entry : j2.entrySet()) {
            d2 value = entry.getValue();
            if (value != null && (value instanceof AdvertAppInfo)) {
                arrayList.add((AdvertAppInfo) value);
            }
        }
        c.a.q0.w.c.q().u(arrayList);
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            stopVoice();
            try {
                if (this.l == null) {
                    return;
                }
                this.frsGoodView.F();
                this.frsGoodView.W();
                this.f51366f = this.l.getForum().getName();
                this.k = this.l.getForum().getId();
                if (this.l != null && this.l.getForum() != null) {
                    this.frsGoodView.S(this.l.getForum().getThemeColorInfo());
                    this.frsGoodView.O(this.l);
                }
                TbadkCoreApplication.getInst().setDefaultBubble(this.l.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.l.getUserData().getBimg_end_time());
                L();
                if (!this.frsGoodView.m().o(d2.x3)) {
                    this.l.removeAlaLiveThreadData();
                }
                ArrayList<n> threadList = this.l.getThreadList();
                if (threadList != null) {
                    this.frsGoodView.T(threadList, this.f51369i, this.l, this.l.getPage().b());
                    N();
                    this.frsGoodView.H();
                    if (this.l.getIsNewUrl() == 1) {
                        this.frsGoodView.m().x(true);
                    } else {
                        this.frsGoodView.m().x(false);
                    }
                    this.frsGoodView.K(B(getModelController().getType(), this.f51369i));
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public final void P() {
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

    public final void Q(c.a.r0.j3.f fVar) {
        c.a.r0.w0.a2.a aVar;
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
            c.a.q0.g0.c cVar = new c.a.q0.g0.c(getPageContext().getContext(), getNetRefreshListener());
            this.w = cVar;
            cVar.e(null);
            this.w.c(null);
            this.w.f();
            this.w.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (fVar != null) {
            this.w.d(getPageContext().getResources().getString(R.string.net_error_text, fVar.f20795d, Integer.valueOf(fVar.f20794c)));
        } else {
            this.w.d(null);
        }
        this.w.onChangeSkinType();
        this.w.attachView(this.frsGoodView.o(), true);
        this.w.a(0);
    }

    public final void R(d2 d2Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, d2Var, i2) == null) {
            if (i2 == 1) {
                PraiseData L0 = d2Var.L0();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (L0 == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i2);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        d2Var.m4(praiseData);
                        return;
                    }
                    d2Var.L0().getUser().add(0, metaData);
                    d2Var.L0().setNum(d2Var.L0().getNum() + 1);
                    d2Var.L0().setIsLike(i2);
                }
            } else if (d2Var.L0() != null) {
                d2Var.L0().setIsLike(i2);
                d2Var.L0().setNum(d2Var.L0().getNum() - 1);
                ArrayList<MetaData> user = d2Var.L0().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            d2Var.L0().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    public final void S(int i2) {
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
            if (next instanceof c2) {
                d2 d2Var = ((c2) next).w;
                if (d2Var.f0() != null && d2Var.f0().equals(this.f51365e)) {
                    R(d2Var, i2);
                    this.f51365e = null;
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
            if (getFrsViewData().getThreadList().size() == 1 && (getFrsViewData().getThreadList().get(0) instanceof c.a.r0.w0.s)) {
                getFrsViewData().getThreadList().remove(0);
            }
            getFrsViewData().getThreadList().add(0, y0Var);
        }
        c.a.r0.w0.a2.a aVar = this.frsGoodView;
        ArrayList<n> threadList = this.l.getThreadList();
        int i2 = this.f51369i;
        FrsViewData frsViewData = this.l;
        aVar.T(threadList, i2, frsViewData, frsViewData.getPage().b());
        this.frsGoodView.H();
        this.frsGoodView.K(0);
    }

    @Override // c.a.r0.w0.p0
    public void changeToSpecialFrs(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
        }
    }

    public c.a.e.l.e.a createFrsExtraAdapter(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, bdUniqueId)) == null) ? c.a.r0.w0.e.e().d(getPageContext(), bdUniqueId, getPageContext().getUniqueId()) : (c.a.e.l.e.a) invokeL.objValue;
    }

    @Override // c.a.r0.f.e.b
    public void dispatchInjectPluginMessage(c.a.r0.f.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, dVar) == null) {
        }
    }

    @Override // c.a.r0.w0.p0
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

    @Override // c.a.r0.y2.u
    public String getFid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    @Override // c.a.r0.w0.e2.a, c.a.r0.w0.t0
    public String getForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f51366f : (String) invokeV.objValue;
    }

    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f51367g : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public c.a.e.e.k.b<TbImageView> getFrsCommonImageLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (getBaseFragmentActivity() instanceof FrsActivity) {
                return ((FrsActivity) getBaseFragmentActivity()).getFrsCommonImageLayoutPool();
            }
            return null;
        }
        return (c.a.e.e.k.b) invokeV.objValue;
    }

    @Override // c.a.r0.w0.e2.a
    public FrsViewData getFrsViewData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.l : (FrsViewData) invokeV.objValue;
    }

    @Override // c.a.r0.f.e.b
    public c.a.r0.f.e.a getInjectPlugin(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) ? this.t.get(i2) : (c.a.r0.f.e.a) invokeI.objValue;
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

    @Override // c.a.r0.w0.q0
    public NavigationBar getNavigationBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return null;
        }
        return (NavigationBar) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.r0.w0.e2.a
    public /* bridge */ /* synthetic */ c.a.e.a.f getPageContext() {
        return super.getPageContext();
    }

    @Override // c.a.r0.y2.u
    public int getPageNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f51369i : invokeV.intValue;
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

    @Override // c.a.r0.y2.u
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
            tbPageTag.sortType = c.a.r0.w0.n2.k.g(frsViewData != null ? frsViewData.getSortType() : -1);
            tbPageTag.locatePage = "a072";
            return tbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public c.a.e.e.k.b<TbImageView> getUserIconPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            if (getBaseFragmentActivity() instanceof FrsActivity) {
                return ((FrsActivity) getBaseFragmentActivity()).getUserIconPool();
            }
            return null;
        }
        return (c.a.e.e.k.b) invokeV.objValue;
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
        c.a.r0.w0.a2.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || (aVar = this.frsGoodView) == null) {
            return;
        }
        aVar.J(true);
        hideLoadingView(this.frsGoodView.o());
    }

    public final void hideNetRefreshView() {
        c.a.r0.w0.a2.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || (aVar = this.frsGoodView) == null) {
            return;
        }
        aVar.J(true);
        this.frsGoodView.N(true);
        c.a.q0.g0.c cVar = this.w;
        if (cVar == null || !cVar.isViewAttached()) {
            return;
        }
        this.w.dettachView(this.frsGoodView.o());
    }

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            if (this.f51368h != 0) {
                this.f51368h = 1;
            }
            this.u = new c.a.r0.w0.x1.b(getActivity(), getBaseFragmentActivity().getUniqueId(), getBaseFragmentActivity() instanceof FrsActivity);
            this.frsGoodView.L(this.I);
            this.frsGoodView.M(this.G);
            this.frsGoodView.n().setOnTouchListener(new k(this));
        }
    }

    public void loadTabData(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            this.q = i2;
            if (c.a.e.e.p.j.z()) {
                K(false);
            } else {
                Q(null);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        d2 threadDataById;
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
                    threadDataById.X3(intent.getIntExtra("good_data", 0));
                    threadDataById.c3();
                    K(false);
                } else if (intExtra == 0) {
                    this.l.removeThreadData(threadDataById);
                    ArrayList<n> threadList = this.l.getThreadList();
                    if (threadList != null && threadList.size() <= 0) {
                        threadList.add(new c.a.r0.w0.s());
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
            c.a.r0.w0.a2.a aVar = this.frsGoodView;
            if (aVar != null) {
                aVar.w(i2);
            }
            c.a.q0.g0.c cVar = this.w;
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
            c.a.r0.i3.c.g().i(getUniqueId());
            FrsGoodModelController frsGoodModelController = new FrsGoodModelController(this);
            this.n = frsGoodModelController;
            if (arguments != null) {
                frsGoodModelController.D(arguments);
                this.f51370j = arguments.getBoolean(IS_GAME_FRS, false);
            } else if (bundle != null) {
                frsGoodModelController.D(bundle);
                this.f51370j = bundle.getBoolean(IS_GAME_FRS, false);
            } else {
                frsGoodModelController.D(null);
            }
            VoiceManager voiceManager = getVoiceManager();
            this.m = voiceManager;
            voiceManager.onCreate(getPageContext());
            J(bundle);
            registerListener(this.F);
            registerListener(this.D);
            registerListener(this.E);
            registerListener(this.J);
            registerListener(this.B);
            FrsLoadMoreModel frsLoadMoreModel = new FrsLoadMoreModel(this, null);
            this.o = frsLoadMoreModel;
            frsLoadMoreModel.registerListener();
            this.o.R(2);
            this.o.P(true);
            this.o.O(c.a.r0.y0.a.a(this.A));
            this.createTime = System.currentTimeMillis() - this.beginTime;
            this.y = UtilHelper.getScreenHeight(getActivity());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048620, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.frs_good_activity, (ViewGroup) null);
            c.a.r0.w0.a2.a aVar = new c.a.r0.w0.a2.a(this, inflate, this.f51370j);
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
            c.a.r0.w0.a2.a aVar = this.frsGoodView;
            if (aVar != null) {
                aVar.x();
            }
            MessageManager.getInstance().unRegisterListener(this.B);
            c.a.r0.i3.c.g().k(getUniqueId());
            t.b().e(false);
            super.onDestroy();
            this.n.H();
            VoiceManager voiceManager = getVoiceManager();
            this.m = voiceManager;
            voiceManager.onDestory(getPageContext());
            c.a.e.e.m.e.a().removeCallbacks(this.C);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void onFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            P();
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
            if (c.a.e.e.p.j.z()) {
                K(false);
            } else {
                Q(null);
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

    @Override // c.a.r0.w0.r0
    public void onLoadingComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            c.a.r0.i3.c.g().h(getUniqueId(), false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048627, this) == null) && c.a.e.e.p.j.z()) {
            K(false);
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
                c.a.e.e.m.e.a().post(this.C);
            }
        }
    }

    @Override // c.a.r0.w0.r0
    public void onPullRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            if (getPageContext() != null) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            }
            if (c.a.e.e.p.j.z()) {
                c.a.r0.o.d.c().f("page_frs_good");
                K(true);
                return;
            }
            this.frsGoodView.I(false);
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048631, this, i2, strArr, iArr) == null) && i2 == 1) {
            if (PermissionUtil.checkCamera(getActivity().getApplicationContext())) {
                SelectImageHelper.takePhoto(getPageContext());
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = PermissionUtil.transformPermissionResult(strArr, iArr);
            if (!transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") || transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                return;
            }
            showToast(R.string.sdcard_permission_denied_advert_for_camera);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            super.onResume();
            c.a.r0.w0.a2.a aVar = this.frsGoodView;
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
            bundle.putString("name", this.f51366f);
            bundle.putString("from", this.f51367g);
            bundle.putBoolean(IS_GAME_FRS, this.f51370j);
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
            if (!c.a.e.e.p.l.D()) {
                this.frsGoodView.p();
            } else if (!this.n.C()) {
                this.frsGoodView.p();
            } else {
                P();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
                if (this.o.isLoading || this.n.E()) {
                    return;
                }
                if (this.o.A(this.l.getThreadListIds())) {
                    FrsViewData frsViewData = this.l;
                    String e2 = c.a.r0.y2.a.e(frsViewData != null ? frsViewData.getThreadList() : null, false);
                    this.frsGoodView.T(this.o.L(), this.f51369i, this.l, 0);
                    this.o.M(c.a.e.e.m.b.g(this.k, 0L), this.l.getThreadListIds(), this.f51366f, this.f51369i, this.l.isBrandForum, e2);
                } else if (this.p != 0) {
                    FrsViewData frsViewData2 = this.l;
                    String e3 = c.a.r0.y2.a.e(frsViewData2 != null ? frsViewData2.getThreadList() : null, false);
                    this.frsGoodView.T(this.o.L(), this.f51369i, this.l, 0);
                    int i2 = this.f51369i + 1;
                    this.f51369i = i2;
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
            t.b().e(false);
            c.a.r0.i3.c.g().h(getUniqueId(), false);
            FrsViewData frsViewData = this.l;
            if (frsViewData != null && frsViewData.getForum() != null) {
                c.a.q0.v.a.k().y(getPageContext().getPageActivity(), "frs", this.l.getForum().getId(), 0L);
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
            P();
            if (arrayList == null || arrayList.size() == 0) {
                return;
            }
            ArrayList<n> C = this.o.C(false, false, false, arrayList, null);
            if (C != null) {
                this.l.setThreadList(C);
                this.frsGoodView.T(C, this.f51369i, this.l, 0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.l.getForum()));
        }
    }

    public void refreshRecyclerView() {
        c.a.r0.w0.a2.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048638, this) == null) || (aVar = this.frsGoodView) == null) {
            return;
        }
        aVar.A();
    }

    @Override // c.a.r0.w0.p0
    public void scrollToTop() {
        c.a.r0.w0.a2.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048639, this) == null) || (aVar = this.frsGoodView) == null || aVar.n() == null) {
            return;
        }
        this.frsGoodView.n().scrollToPosition(0);
    }

    public void setFlag(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048640, this, i2) == null) {
            this.f51368h = i2;
        }
    }

    public void setForum(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, str) == null) {
            this.f51366f = str;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, str) == null) {
            this.f51367g = str;
        }
    }

    public void setFrsView(c.a.r0.w0.a2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, aVar) == null) {
            this.frsGoodView = aVar;
        }
    }

    @Override // c.a.r0.f.e.b
    public void setInjectPlugin(int i2, c.a.r0.f.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048644, this, i2, aVar) == null) {
            this.t.put(i2, aVar);
        }
    }

    public void setPn(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048645, this, i2) == null) {
            this.f51369i = i2;
        }
    }

    public final void showLoadingView() {
        c.a.r0.w0.a2.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048646, this) == null) || (aVar = this.frsGoodView) == null) {
            return;
        }
        aVar.J(false);
        showLoadingView(this.frsGoodView.o(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    public void stopVoice() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            VoiceManager voiceManager = getVoiceManager();
            this.m = voiceManager;
            voiceManager.stopPlay();
        }
    }

    @Override // c.a.r0.y2.u
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
            c.a.r0.w0.a2.a aVar = this.frsGoodView;
            if (aVar == null) {
                return null;
            }
            return aVar.n();
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }
}
