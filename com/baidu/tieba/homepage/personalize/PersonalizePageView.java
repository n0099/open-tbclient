package com.baidu.tieba.homepage.personalize;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdActivityStack;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.controller.CustomRule;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.idlehelp.IdleHandlerManager;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.view.ThreadCardView;
import com.baidu.searchbox.fluency.BdTracesManager;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.searchbox.performance.speed.SpeedStats;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.data.NegativeFeedBackData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.leveiconlivepolling.PollingModel;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.FollowUserButton;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.util.PushOpenUtil;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.loading.LoadingView;
import com.baidu.tbadk.mainTab.dynamicIcon.MainTabBottomDynamicIconManager;
import com.baidu.tbadk.switchs.BigdaySwitch;
import com.baidu.tbadk.switchs.LaunchViewOptSwitch;
import com.baidu.tbadk.widget.RightFloatLayerLottieView;
import com.baidu.tbadk.widget.RightFloatLayerView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.a67;
import com.baidu.tieba.b48;
import com.baidu.tieba.bi;
import com.baidu.tieba.c28;
import com.baidu.tieba.d67;
import com.baidu.tieba.dk5;
import com.baidu.tieba.e58;
import com.baidu.tieba.e67;
import com.baidu.tieba.ea7;
import com.baidu.tieba.fb7;
import com.baidu.tieba.fc7;
import com.baidu.tieba.feed.list.FeedTemplateAdapter;
import com.baidu.tieba.fk5;
import com.baidu.tieba.gha;
import com.baidu.tieba.gn6;
import com.baidu.tieba.h28;
import com.baidu.tieba.h55;
import com.baidu.tieba.homepage.concern.data.RecommendBarCardModel;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.adapter.HomePageCardVideoViewHolder;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.hx5;
import com.baidu.tieba.i37;
import com.baidu.tieba.i57;
import com.baidu.tieba.i95;
import com.baidu.tieba.ix5;
import com.baidu.tieba.j05;
import com.baidu.tieba.j0a;
import com.baidu.tieba.j37;
import com.baidu.tieba.jha;
import com.baidu.tieba.jx5;
import com.baidu.tieba.jz7;
import com.baidu.tieba.k05;
import com.baidu.tieba.k0a;
import com.baidu.tieba.k37;
import com.baidu.tieba.k48;
import com.baidu.tieba.kf5;
import com.baidu.tieba.l0a;
import com.baidu.tieba.l9;
import com.baidu.tieba.l97;
import com.baidu.tieba.lg;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.ls6;
import com.baidu.tieba.lz7;
import com.baidu.tieba.m0a;
import com.baidu.tieba.m48;
import com.baidu.tieba.my;
import com.baidu.tieba.mz7;
import com.baidu.tieba.n57;
import com.baidu.tieba.nd5;
import com.baidu.tieba.nx9;
import com.baidu.tieba.nz7;
import com.baidu.tieba.od5;
import com.baidu.tieba.om5;
import com.baidu.tieba.p38;
import com.baidu.tieba.play.AutoPlayController;
import com.baidu.tieba.q38;
import com.baidu.tieba.qd5;
import com.baidu.tieba.r38;
import com.baidu.tieba.rd5;
import com.baidu.tieba.rm6;
import com.baidu.tieba.rr6;
import com.baidu.tieba.rz9;
import com.baidu.tieba.s97;
import com.baidu.tieba.s9a;
import com.baidu.tieba.sd5;
import com.baidu.tieba.sn6;
import com.baidu.tieba.sr6;
import com.baidu.tieba.st4;
import com.baidu.tieba.sz9;
import com.baidu.tieba.tbadkCore.writeModel.AttentionBarData;
import com.baidu.tieba.td5;
import com.baidu.tieba.u5a;
import com.baidu.tieba.uv9;
import com.baidu.tieba.v97;
import com.baidu.tieba.vb5;
import com.baidu.tieba.vm6;
import com.baidu.tieba.vr6;
import com.baidu.tieba.w38;
import com.baidu.tieba.w67;
import com.baidu.tieba.w97;
import com.baidu.tieba.wr5;
import com.baidu.tieba.xu5;
import com.baidu.tieba.xz9;
import com.baidu.tieba.y38;
import com.baidu.tieba.ym;
import com.baidu.tieba.yr5;
import com.baidu.tieba.yz9;
import com.baidu.tieba.z36;
import com.baidu.tieba.z3a;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.AlaLiveInfo;
import tbclient.Personalized.DataRes;
/* loaded from: classes6.dex */
public class PersonalizePageView extends FrameLayout implements hx5 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean M0;
    public static final int N0;
    public transient /* synthetic */ FieldHolder $fh;
    public rm6 A;
    public i95.h A0;
    public int B;
    public i95.e B0;
    public int C;
    public i95.f C0;
    public boolean D;
    public Runnable D0;
    public LinearLayoutManager E;
    public AutoPlayController.a E0;
    public RightFloatLayerView F;
    public final CustomMessageListener F0;
    public int G;
    public View.OnClickListener G0;
    public jz7 H;
    public CustomMessageListener H0;
    public volatile boolean I;
    public CustomMessageListener I0;
    public FrameLayout J;
    public CustomMessageListener J0;
    public boolean K;
    public CustomMessageListener K0;
    public boolean L;
    public CustomMessageListener L0;
    public boolean M;
    public Object N;
    public String O;
    public String P;
    public boolean Q;
    public boolean R;
    public kf5 S;

    /* renamed from: T  reason: collision with root package name */
    public PollingModel f1106T;
    public BdUniqueId U;
    public p38.f V;
    public CustomMessageListener W;
    public BigdaySwipeRefreshLayout a;
    public CustomMessageListener a0;
    public BdTypeRecyclerView b;
    public CustomMessageListener b0;
    public r38 c;
    public CustomMessageListener c0;
    public q38 d;
    public NEGFeedBackView.NEGFeedbackEventCallback d0;
    public a1 e;
    public FollowUserButton.a e0;
    public PbListView f;
    public nz7 f0;
    public l97 g;
    public int g0;
    public xz9 h;
    public RecyclerView.OnScrollListener h0;
    public AutoPlayController i;
    public ScrollFragmentTabHost.s i0;
    public yz9 j;
    public View.OnClickListener j0;
    public p38 k;
    public TbPageContext<?> l;
    public mz7 m;
    public h28 n;
    public c28 o;
    public m48 p;
    public long q;
    public LoadingView r;
    public CustomMessageListener r0;
    public om5 s;
    public CustomMessageListener s0;
    public long t;
    public CustomMessageListener t0;
    public int u;
    public h28.n0 u0;
    public boolean v;
    public CustomMessageListener v0;
    public boolean w;
    public final CustomMessageListener w0;
    public long x;
    public final CustomRule x0;
    public boolean y;
    public final ea7.a y0;
    public boolean z;
    public i95.g z0;

    /* loaded from: classes6.dex */
    public interface a1 {
        void a(i95.g gVar);

        void b(i95.h hVar);

        void d(i95.e eVar);

        void g(i95.f fVar);
    }

    public final void d1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class m0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ m0 a;

            public a(m0 m0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {m0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = m0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.R0();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m0(PersonalizePageView personalizePageView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, Integer.valueOf(i)};
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
            this.a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<DownloadData> data;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
                boolean z = false;
                for (DownloadData downloadData : data) {
                    if (downloadData.getStatus() == 0) {
                        z = true;
                    }
                }
                if (z) {
                    SafeHandler.getInst().postDelayed(new a(this), TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements h28.n0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ PersonalizePageView b;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ String b;
            public final /* synthetic */ n c;

            public a(n nVar, int i, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar, Integer.valueOf(i), str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = nVar;
                this.a = i;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                    return;
                }
                this.c.b.A0();
                if (this.a == 1) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        this.c.b.l.showToast(this.b);
                    }
                    this.c.g();
                } else if (this.c.a) {
                    this.c.g();
                    this.c.b.m1(false);
                    return;
                } else {
                    this.c.b.a.setVisibility(8);
                    this.c.b.H.r(false);
                    PersonalizePageView personalizePageView = this.c.b;
                    personalizePageView.j1(personalizePageView, this.b, true);
                }
                IdleHandlerManager.getInstance().runIdleTaskImmediately();
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ boolean a;
            public final /* synthetic */ n b;

            public b(n nVar, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar, Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = nVar;
                this.a = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.g();
                    this.b.b.a.setVisibility(0);
                    this.b.b.H.r(true);
                    this.b.b.A0();
                    this.b.b.B0();
                    this.b.b.w = true;
                    if (this.a) {
                        this.b.b.x = System.currentTimeMillis();
                    }
                }
            }
        }

        /* loaded from: classes6.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ n a;

            public c(n nVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = nVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b.f != null) {
                    this.a.b.f.H(this.a.b.getContext().getString(R.string.recommend_no_more_data));
                    this.a.b.f.g();
                    this.a.b.f.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
            }
        }

        public n(PersonalizePageView personalizePageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = personalizePageView;
            this.a = SharedPrefHelper.getInstance().getBoolean("key_first_install", true);
        }

        @Override // com.baidu.tieba.h28.n0
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                lg.g(new b(this, z));
            }
        }

        @Override // com.baidu.tieba.h28.n0
        public void b(int i, xu5 xu5Var, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), xu5Var, Integer.valueOf(i2)}) == null) {
                if (this.b.m == null) {
                    PersonalizePageView personalizePageView = this.b;
                    personalizePageView.j1(personalizePageView, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e21), true);
                    this.b.A0();
                    return;
                }
                boolean M0 = this.b.M0();
                this.b.B0();
                if (M0) {
                    this.b.i1(true);
                }
                this.b.m.c(i, xu5Var, i2);
                st4.f().m();
            }
        }

        @Override // com.baidu.tieba.h28.n0
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                lg.g(new c(this));
            }
        }

        public final void g() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.a) {
                this.a = false;
                SharedPrefHelper.getInstance().putBoolean("key_first_install", false);
            }
        }

        @Override // com.baidu.tieba.h28.n0
        public void d(int i, int i2, xu5 xu5Var, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), xu5Var, Integer.valueOf(i3)}) == null) && this.b.m != null) {
                PersonalizePageView personalizePageView = this.b;
                if (personalizePageView.N0(personalizePageView.b)) {
                    this.b.q = System.currentTimeMillis();
                }
                this.b.m.d(i, i2, xu5Var, i3);
            }
        }

        @Override // com.baidu.tieba.h28.n0
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) {
                lg.g(new a(this, i, str));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a extends vr6<rd5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PersonalizePageView personalizePageView, Class cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vr6
        public void onEvent(@NonNull rd5 rd5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, rd5Var) == null) {
                if ("recommend_post".equals(rd5Var.getType()) && (rd5Var.a() instanceof JSONObject)) {
                    String optString = ((JSONObject) rd5Var.a()).optString("tid");
                    if (StringUtils.isNull(optString)) {
                        return;
                    }
                    this.b.h.t(optString);
                    this.b.h.O((JSONObject) rd5Var.a());
                } else if ("recommend_fun_ad".equals(rd5Var.getType()) && this.b.b != null && this.b.b.getListAdapter() != null) {
                    this.b.b.getListAdapter().notifyDataSetChanged();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a0 implements i95.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public a0(PersonalizePageView personalizePageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalizePageView;
        }

        @Override // com.baidu.tieba.i95.e
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.a.D) {
                return;
            }
            this.a.C = 0;
            this.a.D = false;
        }
    }

    /* loaded from: classes6.dex */
    public class b extends vr6<td5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PersonalizePageView personalizePageView, Class cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vr6
        public void onEvent(@NonNull td5 td5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, td5Var) == null) {
                String a = td5Var.a();
                if (!TextUtils.isEmpty(a) && this.b.h != null) {
                    this.b.h.t(a);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b0 implements i95.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public b0(PersonalizePageView personalizePageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalizePageView;
        }

        @Override // com.baidu.tieba.i95.f
        public void a(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (PersonalizePageView.M0) {
                    this.a.i.p(true);
                    this.a.i.r();
                } else if (this.a.n != null) {
                    this.a.n.d1(true);
                    this.a.n.S0();
                }
                TbSingleton.getInstance().mIsForceLayoutMaintab = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, Boolean.TRUE));
                j05 j05Var = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > SharedPrefHelper.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    j05Var = k05.i().h(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, j05Var));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends vr6<sd5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PersonalizePageView personalizePageView, Class cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vr6
        public void onEvent(@NonNull sd5 sd5Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, sd5Var) == null) && (sd5Var.a() instanceof d67) && ((d67) sd5Var.a()).getType().equals("recommend_post")) {
                Object a = ((d67) sd5Var.a()).a();
                if (!(a instanceof e67)) {
                    return;
                }
                this.b.y0((e67) a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c0 extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public c0(PersonalizePageView personalizePageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalizePageView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                if (this.a.E != null && i == 0) {
                    nd5 wlConfigData = TbSingleton.getInstance().getWlConfigData();
                    int i3 = 3;
                    if (wlConfigData != null && wlConfigData.I() != 0) {
                        i3 = wlConfigData.I();
                    }
                    int itemCount = this.a.E.getItemCount() - this.a.E.findLastVisibleItemPosition();
                    if (PersonalizePageView.M0) {
                        i2 = 1;
                    } else {
                        i2 = 5;
                    }
                    if (itemCount <= i3 * i2) {
                        this.a.O0();
                    }
                }
                if (this.a.Q && i == 0 && SharedPrefHelper.getInstance().getBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount(fc7.a(this.a.P, this.a.O)), true)) {
                    PersonalizePageView personalizePageView = this.a;
                    personalizePageView.e1(personalizePageView.P, this.a.O);
                    this.a.Q = false;
                }
                if (i == 0) {
                    if (this.a.F != null) {
                        this.a.F.p();
                    }
                    if (this.a.N != null) {
                        BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(this.a.N);
                        this.a.N = null;
                    }
                } else if (i == 1) {
                    if (this.a.N == null) {
                        this.a.N = BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect("home", "1", "scroll");
                    }
                    if (this.a.F != null) {
                        this.a.F.o();
                    }
                } else if (i == 2) {
                    if (this.a.N == null) {
                        this.a.N = BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect("home", "1", "scroll");
                    }
                    if (this.a.F != null) {
                        this.a.F.q();
                    }
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                this.a.C += i2;
                if (UbsABTestHelper.isHomePagePromoteLoginUbsABTestA() && !TbadkCoreApplication.isLogin() && SharedPrefHelper.getInstance().getInt("home_page_login_dialog_show_key", 0) == 0 && this.a.C >= BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst().getContext())[1] * 2) {
                    SharedPrefHelper.getInstance().putInt("home_page_login_dialog_show_key", 1);
                    DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getContext(), LoginDialogData.HOME_PAGE_RESULT_PAGE));
                }
                if (this.a.H != null) {
                    this.a.H.j();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends vr6<qd5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(PersonalizePageView personalizePageView, Class cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vr6
        public void onEvent(@NonNull qd5 qd5Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, qd5Var) == null) && (qd5Var.a() instanceof d67) && ((d67) qd5Var.a()).getType().equals("recommend_post")) {
                Object a = ((d67) qd5Var.a()).a();
                if (!(a instanceof e67)) {
                    return;
                }
                this.b.x0(qd5Var.b(), qd5Var.c(), (e67) a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d0 implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public d0(PersonalizePageView personalizePageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalizePageView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.O0();
        }
    }

    /* loaded from: classes6.dex */
    public class e extends vr6<rz9> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(PersonalizePageView personalizePageView, Class cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vr6
        public void onEvent(@NonNull rz9 rz9Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, rz9Var) != null) || this.b.p == null) {
                return;
            }
            this.b.p.e(rz9Var.d(), rz9Var.e(), rz9Var.c(), rz9Var.b(), rz9Var.a(), rz9Var.getType(), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, null);
        }
    }

    /* loaded from: classes6.dex */
    public class e0 implements BdListView.o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public e0(PersonalizePageView personalizePageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalizePageView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.o
        public void onScrollStop(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && System.currentTimeMillis() - this.a.t >= 5000 && this.a.n != null) {
                this.a.n.R0(i, i2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends vr6<sz9> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(PersonalizePageView personalizePageView, Class cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vr6
        public void onEvent(@NonNull sz9 sz9Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, sz9Var) != null) || this.b.o == null) {
                return;
            }
            this.b.o.e(sz9Var.b(), JavaTypesHelper.toLong(sz9Var.a(), 0L), sz9Var.c());
        }
    }

    /* loaded from: classes6.dex */
    public class f0 implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public f0(PersonalizePageView personalizePageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalizePageView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, viewHolder) != null) || viewHolder == null || (view2 = viewHolder.itemView) == null) {
                return;
            }
            if (this.a.n != null && this.a.n.k0() != null) {
                this.a.n.k0().k(view2);
            }
            if (view2.getTag() instanceof HomePageCardVideoViewHolder) {
                ((HomePageCardVideoViewHolder) view2.getTag()).b().stopPlay();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends vr6<od5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(PersonalizePageView personalizePageView, Class cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vr6
        public void onEvent(@NonNull od5 od5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, od5Var) == null) {
                UpdateAttentionMessage.UpdateAttentionData a = od5Var.a();
                if (a.blockData != null || !a.isSucc || TextUtils.isEmpty(a.toUid)) {
                    return;
                }
                this.b.h.S(a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g0(PersonalizePageView personalizePageView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, Integer.valueOf(i)};
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
            this.a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof AttentionBarData) {
                AttentionBarData attentionBarData = (AttentionBarData) data;
                if (attentionBarData.isSuccess) {
                    attentionBarData.isLike = false;
                    if (this.a.h != null) {
                        this.a.h.S(data);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h extends vr6<dk5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(PersonalizePageView personalizePageView, Class cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vr6
        public void onEvent(@NonNull dk5 dk5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dk5Var) == null) {
                if (this.b.n != null) {
                    this.b.n.s0(dk5Var);
                }
                if (this.b.h != null) {
                    this.b.h.B(dk5Var);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public h0(PersonalizePageView personalizePageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalizePageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.f != null) {
                this.a.f.H(this.a.getContext().getString(R.string.pb_load_more));
                this.a.f.g();
                this.a.f.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public i(PersonalizePageView personalizePageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalizePageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null) {
                this.a.b.removeHeaderView(this.a.A.b());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public i0(PersonalizePageView personalizePageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalizePageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.f != null) {
                this.a.f.H(this.a.getContext().getString(R.string.pb_load_more));
                this.a.f.g();
                this.a.f.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(PersonalizePageView personalizePageView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, Integer.valueOf(i)};
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
            this.a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (!TbSingleton.getInstance().isAddBanner) {
                    this.a.d1();
                }
                PersonalizePageView personalizePageView = this.a;
                personalizePageView.K = true;
                if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW || personalizePageView.L) {
                    return;
                }
                personalizePageView.I0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public j0(PersonalizePageView personalizePageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalizePageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (PersonalizePageView.M0) {
                    if (this.a.h != null) {
                        this.a.h.I();
                    }
                } else if (this.a.n == null) {
                } else {
                    this.a.p0();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements p38.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public k(PersonalizePageView personalizePageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalizePageView;
        }

        @Override // com.baidu.tieba.p38.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (TbSingleton.getInstance().isAddBanner) {
                    if (this.a.b != null && this.a.A != null) {
                        this.a.b.removeHeaderView(this.a.A.b());
                        return;
                    }
                    return;
                }
                this.a.d1();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public k0(PersonalizePageView personalizePageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalizePageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.l != null) {
                SharedPrefHelper.getInstance().putInt("show_is_uninterest_tag", PersonalizePageView.c0(this.a));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(this.a.l.getContext(), 2)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(PersonalizePageView personalizePageView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, Integer.valueOf(i)};
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
            this.a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && SpeedStatsUtils.UBC_VALUE_SPLASH.equals(customResponsedMessage.getData())) {
                PersonalizePageView personalizePageView = this.a;
                if (personalizePageView.K && !personalizePageView.L) {
                    personalizePageView.I0();
                }
                if (this.a.y) {
                    PersonalizePageView personalizePageView2 = this.a;
                    if (!personalizePageView2.M) {
                        personalizePageView2.M = true;
                        SpeedStats.getInstance().onMainPageStatsEnd(this.a.getContext());
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l0 implements AutoPlayController.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public l0(PersonalizePageView personalizePageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalizePageView;
        }

        @Override // com.baidu.tieba.play.AutoPlayController.a
        public void onBackground(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.i.h() != null && (this.a.i.h().getTag() instanceof k37.q)) {
                ((k37.q) this.a.i.h().getTag()).onBackground(z);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(PersonalizePageView personalizePageView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, Integer.valueOf(i)};
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
            this.a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && e58.a()) {
                PersonalizePageView personalizePageView = this.a;
                personalizePageView.S = PushOpenUtil.showPushOpenView(personalizePageView.l, DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, 0L);
                if (this.a.S != null) {
                    uv9.e().h(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public n0(PersonalizePageView personalizePageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalizePageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.O0();
        }
    }

    /* loaded from: classes6.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(PersonalizePageView personalizePageView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, Integer.valueOf(i)};
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
            this.a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue() && MainTabBottomDynamicIconManager.getInstance().canShowDynamicIcon() && this.a.f != null && this.a.f.l() == 0) {
                this.a.f.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o0(PersonalizePageView personalizePageView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, Integer.valueOf(i)};
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
            this.a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (!(data instanceof String) || TextUtils.isEmpty((String) data)) {
                    return;
                }
                this.a.v = true;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(PersonalizePageView personalizePageView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, Integer.valueOf(i)};
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
            this.a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
                u5a.a().d(true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p0(PersonalizePageView personalizePageView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, Integer.valueOf(i)};
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
            this.a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.G0(customResponsedMessage.getData());
        }
    }

    /* loaded from: classes6.dex */
    public class q extends CustomRule {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(PersonalizePageView personalizePageView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, Integer.valueOf(i)};
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
            this.a = personalizePageView;
        }

        /* renamed from: process  reason: avoid collision after fix types in other method */
        public CustomMessage<?> process2(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, customMessage, customMessageTask)) == null) {
                if (customMessage != null && (customMessage.getData() instanceof SignAllForumActivityConfig)) {
                    u5a.a().d(true);
                }
                return customMessage;
            }
            return (CustomMessage) invokeLL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.Message, com.baidu.adp.framework.task.MessageTask] */
        /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.Message' to match base method */
        @Override // com.baidu.adp.framework.controller.MessageRule
        public /* bridge */ /* synthetic */ CustomMessage<?> process(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
            CustomMessage<?> customMessage2 = customMessage;
            process2(customMessage2, customMessageTask);
            return customMessage2;
        }
    }

    /* loaded from: classes6.dex */
    public class q0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j05 a;
        public final /* synthetic */ PersonalizePageView b;

        public q0(PersonalizePageView personalizePageView, j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, j05Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = personalizePageView;
            this.a = j05Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.c.D(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r implements k48.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        @Override // com.baidu.tieba.k48.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public r(PersonalizePageView personalizePageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalizePageView;
        }

        @Override // com.baidu.tieba.k48.c
        public void a(y38 y38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, y38Var) != null) {
                return;
            }
            this.a.z0(y38Var);
        }
    }

    /* loaded from: classes6.dex */
    public class r0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r0(PersonalizePageView personalizePageView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, Integer.valueOf(i)};
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
            this.a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof AttentionBarData) {
                AttentionBarData attentionBarData = (AttentionBarData) data;
                if (attentionBarData.isSuccess) {
                    attentionBarData.isLike = true;
                    if (this.a.h != null) {
                        this.a.h.S(data);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s implements PollingModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public s(PersonalizePageView personalizePageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalizePageView;
        }

        @Override // com.baidu.tbadk.core.leveiconlivepolling.PollingModel.d
        public void onFail() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.n != null) {
                this.a.n.r0();
            }
        }

        @Override // com.baidu.tbadk.core.leveiconlivepolling.PollingModel.d
        public void onSuccess(List<AlaLiveInfo> list) {
            List<v97<?>> b;
            boolean z;
            List<AlaLiveInfo> liveIndexSecondFloor;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                if (this.a.n != null) {
                    this.a.n.q0();
                }
                if (this.a.h != null && (b = this.a.h.b()) != null && b.size() > 0) {
                    Iterator<v97<?>> it = b.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if ("ala_live_attention".equals(it.next().a())) {
                                z = true;
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (!z && (liveIndexSecondFloor = TbSingleton.getInstance().getLiveIndexSecondFloor()) != null && liveIndexSecondFloor.size() > 0) {
                        gn6 gn6Var = new gn6(null, liveIndexSecondFloor, "recommend");
                        w67 w67Var = new w67();
                        w67Var.a = gn6Var;
                        this.a.h.F(new w97(new j37(w67Var), "ala_live_attention"), 0);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s0(PersonalizePageView personalizePageView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, Integer.valueOf(i)};
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
            this.a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.D0();
        }
    }

    /* loaded from: classes6.dex */
    public class t implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public t(PersonalizePageView personalizePageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalizePageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MainTabBottomDynamicIconManager.getInstance().loadImages();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t0(PersonalizePageView personalizePageView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, Integer.valueOf(i)};
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
            this.a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (!this.a.R) {
                        return;
                    }
                    this.a.R = false;
                    this.a.k1();
                } else if (this.a.F == null || this.a.F.getVisibility() != 0) {
                } else {
                    this.a.R = true;
                    this.a.D0();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u implements ea7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public u(PersonalizePageView personalizePageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalizePageView;
        }

        @Override // com.baidu.tieba.ea7.a
        public void a(a67 a67Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, a67Var) != null) {
                return;
            }
            this.a.w = true;
            this.a.A0();
            if (a67Var.d == 0) {
                if (ListUtils.isEmpty(a67Var.a)) {
                    this.a.a.setRefreshing(false);
                    PersonalizePageView personalizePageView = this.a;
                    personalizePageView.j1(personalizePageView, a67Var.e, true);
                    this.a.H.r(false);
                    this.a.a.setVisibility(8);
                    this.a.f.O(8);
                } else {
                    this.a.s0(a67Var.b);
                    this.a.B0();
                    this.a.f.O(0);
                    if (a67Var.c) {
                        this.a.g1();
                    } else {
                        this.a.h1();
                    }
                }
                this.a.g.setList(a67Var.a);
                this.a.i.r();
                return;
            }
            this.a.a.setRefreshing(false);
            if (ListUtils.isEmpty(a67Var.a)) {
                PersonalizePageView personalizePageView2 = this.a;
                personalizePageView2.j1(personalizePageView2, a67Var.e, true);
                this.a.H.r(false);
                this.a.a.setVisibility(8);
                this.a.f.O(8);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u0(PersonalizePageView personalizePageView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, Integer.valueOf(i)};
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
            this.a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && this.a.i.h() != null && (this.a.i.h().getTag() instanceof k37.q)) {
                    ((k37.q) this.a.i.h().getTag()).onVolumeUp();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class v extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(PersonalizePageView personalizePageView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, Integer.valueOf(i)};
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
            this.a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Integer) {
                this.a.G = ((Integer) data).intValue();
                if (this.a.F != null) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.F.getLayoutParams();
                    layoutParams.gravity = 85;
                    layoutParams.bottomMargin = PersonalizePageView.N0 + this.a.G;
                    this.a.F.requestLayout();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class v0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v0(PersonalizePageView personalizePageView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, Integer.valueOf(i)};
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
            this.a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (this.a.n != null) {
                    this.a.n.o0(customResponsedMessage);
                }
                if (this.a.h != null) {
                    this.a.h.A(customResponsedMessage);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class w implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vb5 a;
        public final /* synthetic */ PersonalizePageView b;

        public w(PersonalizePageView personalizePageView, vb5 vb5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, vb5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = personalizePageView;
            this.a = vb5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a != null && this.b.F != null) {
                this.b.F.g(this.a);
                this.b.F.setAutoCompleteShown(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class w0 implements NEGFeedBackView.NEGFeedbackEventCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.NEGFeedbackEventCallback
        public void onCheckedChanged(NegativeFeedBackData negativeFeedBackData, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048576, this, negativeFeedBackData, compoundButton, z) == null) {
            }
        }

        public w0(PersonalizePageView personalizePageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalizePageView;
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.NEGFeedbackEventCallback
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, NegativeFeedBackData negativeFeedBackData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, str, negativeFeedBackData) == null) && arrayList != null && negativeFeedBackData != null) {
                StringBuilder sb = new StringBuilder();
                int size = arrayList.size();
                int i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    sb.append(arrayList.get(i2));
                    sb.append(",");
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                int i3 = negativeFeedBackData.threadType;
                if (i3 == 0) {
                    i = 1;
                } else if (i3 == 40) {
                    i = 2;
                } else if (i3 == 49 || i3 == 69) {
                    i = 3;
                }
                if (this.a.k != null) {
                    this.a.k.n();
                }
                this.a.P0();
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.NEG_FEEDBACK_KEY).param("tid", negativeFeedBackData.getTid()).param("nid", negativeFeedBackData.getNid()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", negativeFeedBackData.getFid()).param("obj_param1", negativeFeedBackData.weight).param("obj_source", negativeFeedBackData.source).param("obj_id", negativeFeedBackData.extra).param("obj_type", sb.toString()).param("obj_name", str).param(TiebaStatic.Params.OBJ_PARAM2, i).param("obj_locate", "1"));
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.NEGFeedbackEventCallback
        public void onNEGFeedbackWindowShow(NegativeFeedBackData negativeFeedBackData) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, negativeFeedBackData) != null) || negativeFeedBackData == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.NEG_FEEDBACK_KEY).param("obj_locate", "1").param("fid", negativeFeedBackData.getFid()).param("tid", negativeFeedBackData.getTid()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("nid", negativeFeedBackData.getNid()));
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.NEGATIVE_FEEDBACK_OPEN_CLICK).param("obj_locate", "1").param("fid", negativeFeedBackData.getFid()).param("tid", negativeFeedBackData.getTid()).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    /* loaded from: classes6.dex */
    public class x implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vb5 a;
        public final /* synthetic */ PersonalizePageView b;

        public x(PersonalizePageView personalizePageView, vb5 vb5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, vb5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = personalizePageView;
            this.a = vb5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.F.setHomePbFloatLastCloseTime();
                this.b.C0();
                this.b.F.t(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class x0 implements FollowUserButton.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public x0(PersonalizePageView personalizePageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalizePageView;
        }

        @Override // com.baidu.tbadk.core.view.FollowUserButton.a
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || view2 == null) {
                return;
            }
            Object tag = view2.getTag();
            if (tag instanceof ThreadData) {
                TiebaStatic.log(s9a.j("c13696", (ThreadData) tag));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class y implements i95.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public y(PersonalizePageView personalizePageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalizePageView;
        }

        @Override // com.baidu.tieba.i95.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048576, this, z) != null) {
                return;
            }
            this.a.D = true;
            z36.c().f("page_recommend");
            if (PersonalizePageView.M0) {
                this.a.h.I();
                if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    TiebaStatic.log(new StatisticItem("c11032").param("obj_source", 1));
                }
                this.a.i.p(false);
                this.a.Y0();
                return;
            }
            this.a.p0();
            this.a.n.d1(false);
        }
    }

    /* loaded from: classes6.dex */
    public class y0 extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public y0(PersonalizePageView personalizePageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalizePageView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLI(1048576, this, recyclerView, i) != null) || this.a.g0 == i || this.a.f0 == null) {
                return;
            }
            this.a.g0 = i;
            if (this.a.g0 == 1) {
                this.a.f0.a();
            } else if (this.a.Z0(recyclerView)) {
                this.a.f0.c();
            } else {
                this.a.f0.a();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class z implements i95.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public z(PersonalizePageView personalizePageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalizePageView;
        }

        @Override // com.baidu.tieba.i95.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.n != null && this.a.n.k0() != null) {
                    this.a.n.k0().y();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921792));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class z0 extends ScrollFragmentTabHost.s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public z0(PersonalizePageView personalizePageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalizePageView;
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.s
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.f0 == null) {
                return;
            }
            this.a.g0 = -1;
            PersonalizePageView personalizePageView = this.a;
            if (personalizePageView.Z0(personalizePageView.b)) {
                this.a.f0.c();
            } else {
                this.a.f0.a();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-470541215, "Lcom/baidu/tieba/homepage/personalize/PersonalizePageView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-470541215, "Lcom/baidu/tieba/homepage/personalize/PersonalizePageView;");
                return;
            }
        }
        M0 = L0();
        N0 = UtilHelper.getDimenPixelSize(R.dimen.tbds437);
    }

    public static boolean L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            return UbsABTestHelper.isRecommendFeedTest();
        }
        return invokeV.booleanValue;
    }

    public final void B0() {
        om5 om5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (om5Var = this.s) != null) {
            om5Var.dettachView(this);
            this.s = null;
        }
    }

    public void C0() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (rightFloatLayerView = this.F) != null) {
            rightFloatLayerView.c();
        }
    }

    public final void D0() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (rightFloatLayerView = this.F) != null) {
            rightFloatLayerView.setAutoCompleteShown(false);
            this.F.clearAnimation();
            this.F.setVisibility(8);
        }
    }

    public void H0() {
        a1 a1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (a1Var = this.e) != null) {
            a1Var.a(this.z0);
            this.e.b(this.A0);
            this.e.d(this.B0);
            this.e.g(this.C0);
        }
    }

    public final void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.L = true;
            vb5 homeAdFloatViewItemData = TbSingleton.getInstance().getHomeAdFloatViewItemData();
            if (homeAdFloatViewItemData != null && !homeAdFloatViewItemData.a()) {
                p1(homeAdFloatViewItemData);
            }
        }
    }

    public final boolean M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            om5 om5Var = this.s;
            if (om5Var != null) {
                return om5Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void P0() {
        jz7 jz7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (jz7Var = this.H) != null) {
            jz7Var.f();
        }
    }

    public void Q0() {
        h28 h28Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (h28Var = this.n) != null) {
            h28Var.A0();
        }
    }

    public void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            p38 p38Var = this.k;
            if (p38Var != null) {
                p38Var.n();
            }
            P0();
        }
    }

    public void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            h28 h28Var = this.n;
            if (h28Var != null) {
                h28Var.M0();
            }
            p38 p38Var = this.k;
            if (p38Var != null) {
                p38Var.q();
            }
            RightFloatLayerView rightFloatLayerView = this.F;
            if (rightFloatLayerView != null && (rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                ((RightFloatLayerLottieView) rightFloatLayerView).G(600);
            }
        }
    }

    public final void Y0() {
        PollingModel pollingModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (pollingModel = this.f1106T) != null) {
            pollingModel.getData("live,level,icon,festival_info,live_follow_second_floor,member_broadcast,activity_broadcast,live_index_second_floor");
        }
    }

    @Override // com.baidu.tieba.hx5
    @NonNull
    public List<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("home_banner");
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void b1() {
        h28 h28Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && (h28Var = this.n) != null) {
            h28Var.Y0();
        }
    }

    public void c1() {
        h28 h28Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && (h28Var = this.n) != null) {
            h28Var.h1();
        }
    }

    public final void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.f.U();
            this.f.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f.w(BdUtilHelper.getDimens(getContext(), R.dimen.tbds150));
        }
    }

    public FrameLayout getmTaskFloatingView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.J;
        }
        return (FrameLayout) invokeV.objValue;
    }

    public final void h1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.f.h();
            this.f.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f.w(BdUtilHelper.getDimens(getContext(), R.dimen.tbds150));
        }
    }

    public void k1() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048615, this) == null) && (rightFloatLayerView = this.F) != null) {
            rightFloatLayerView.d();
        }
    }

    public void o0() {
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048619, this) == null) && (bigdaySwipeRefreshLayout = this.a) != null) {
            bigdaySwipeRefreshLayout.r();
        }
    }

    public final void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            q0(false);
        }
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            if (this.s != null) {
                a1();
            } else if (this.n != null) {
                p0();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalizePageView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.t = 0L;
        this.u = 3;
        this.v = false;
        this.w = false;
        this.x = -1L;
        this.y = false;
        this.z = false;
        this.B = 0;
        this.C = 0;
        this.D = false;
        this.I = false;
        this.K = false;
        this.L = false;
        this.M = false;
        this.O = "";
        this.P = "";
        this.Q = false;
        this.R = false;
        this.U = BdUniqueId.gen();
        this.V = new k(this);
        this.W = new v(this, 2921553);
        this.a0 = new g0(this, 2001438);
        this.b0 = new r0(this, 2001437);
        this.c0 = new v0(this, 2016331);
        this.d0 = new w0(this);
        this.e0 = new x0(this);
        this.g0 = -1;
        this.h0 = new y0(this);
        this.i0 = new z0(this);
        this.j0 = new i(this);
        this.r0 = new j(this, 2001371);
        this.s0 = new l(this, 2921736);
        this.t0 = new m(this, 2921482);
        this.u0 = new n(this);
        this.v0 = new o(this, 2921551);
        this.w0 = new p(this, 2001222);
        this.x0 = new q(this, 2002001);
        this.y0 = new u(this);
        this.z0 = new y(this);
        this.A0 = new z(this);
        this.B0 = new a0(this);
        this.C0 = new b0(this);
        this.D0 = new k0(this);
        this.E0 = new l0(this);
        this.F0 = new m0(this, 2001118);
        this.G0 = new n0(this);
        this.H0 = new o0(this, 2921033);
        this.I0 = new p0(this, 2921349);
        this.J0 = new s0(this, 2921664);
        this.K0 = new t0(this, 2921667);
        this.L0 = new u0(this, 2921381);
        J0(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.t = 0L;
        this.u = 3;
        this.v = false;
        this.w = false;
        this.x = -1L;
        this.y = false;
        this.z = false;
        this.B = 0;
        this.C = 0;
        this.D = false;
        this.I = false;
        this.K = false;
        this.L = false;
        this.M = false;
        this.O = "";
        this.P = "";
        this.Q = false;
        this.R = false;
        this.U = BdUniqueId.gen();
        this.V = new k(this);
        this.W = new v(this, 2921553);
        this.a0 = new g0(this, 2001438);
        this.b0 = new r0(this, 2001437);
        this.c0 = new v0(this, 2016331);
        this.d0 = new w0(this);
        this.e0 = new x0(this);
        this.g0 = -1;
        this.h0 = new y0(this);
        this.i0 = new z0(this);
        this.j0 = new i(this);
        this.r0 = new j(this, 2001371);
        this.s0 = new l(this, 2921736);
        this.t0 = new m(this, 2921482);
        this.u0 = new n(this);
        this.v0 = new o(this, 2921551);
        this.w0 = new p(this, 2001222);
        this.x0 = new q(this, 2002001);
        this.y0 = new u(this);
        this.z0 = new y(this);
        this.A0 = new z(this);
        this.B0 = new a0(this);
        this.C0 = new b0(this);
        this.D0 = new k0(this);
        this.E0 = new l0(this);
        this.F0 = new m0(this, 2001118);
        this.G0 = new n0(this);
        this.H0 = new o0(this, 2921033);
        this.I0 = new p0(this, 2921349);
        this.J0 = new s0(this, 2921664);
        this.K0 = new t0(this, 2921667);
        this.L0 = new u0(this, 2921381);
        J0(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalizePageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.t = 0L;
        this.u = 3;
        this.v = false;
        this.w = false;
        this.x = -1L;
        this.y = false;
        this.z = false;
        this.B = 0;
        this.C = 0;
        this.D = false;
        this.I = false;
        this.K = false;
        this.L = false;
        this.M = false;
        this.O = "";
        this.P = "";
        this.Q = false;
        this.R = false;
        this.U = BdUniqueId.gen();
        this.V = new k(this);
        this.W = new v(this, 2921553);
        this.a0 = new g0(this, 2001438);
        this.b0 = new r0(this, 2001437);
        this.c0 = new v0(this, 2016331);
        this.d0 = new w0(this);
        this.e0 = new x0(this);
        this.g0 = -1;
        this.h0 = new y0(this);
        this.i0 = new z0(this);
        this.j0 = new i(this);
        this.r0 = new j(this, 2001371);
        this.s0 = new l(this, 2921736);
        this.t0 = new m(this, 2921482);
        this.u0 = new n(this);
        this.v0 = new o(this, 2921551);
        this.w0 = new p(this, 2001222);
        this.x0 = new q(this, 2002001);
        this.y0 = new u(this);
        this.z0 = new y(this);
        this.A0 = new z(this);
        this.B0 = new a0(this);
        this.C0 = new b0(this);
        this.D0 = new k0(this);
        this.E0 = new l0(this);
        this.F0 = new m0(this, 2001118);
        this.G0 = new n0(this);
        this.H0 = new o0(this, 2921033);
        this.I0 = new p0(this, 2921349);
        this.J0 = new s0(this, 2921664);
        this.K0 = new t0(this, 2921667);
        this.L0 = new u0(this, 2921381);
        J0(context);
    }

    public void o1(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048620, this, str, i2) == null) {
            lg.g(new i0(this));
            h28 h28Var = this.n;
            if (h28Var != null) {
                h28Var.K0(true, false, null, i2, str);
            }
        }
    }

    public static /* synthetic */ int c0(PersonalizePageView personalizePageView) {
        int i2 = personalizePageView.B + 1;
        personalizePageView.B = i2;
        return i2;
    }

    public final boolean K0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            if (i2 < 0) {
                return false;
            }
            int findFirstVisibleItemPosition = this.E.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = this.E.findLastVisibleItemPosition();
            if (i2 < findFirstVisibleItemPosition || i2 > findLastVisibleItemPosition) {
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public boolean N0(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, recyclerView)) == null) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            int childCount = linearLayoutManager.getChildCount();
            int itemCount = linearLayoutManager.getItemCount();
            int scrollState = recyclerView.getScrollState();
            if (childCount > 0 && findLastVisibleItemPosition == itemCount - 1 && scrollState == 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean Z0(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, recyclerView)) == null) {
            if (recyclerView == null || !recyclerView.canScrollVertically(-1)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, canvas) == null) {
            super.dispatchDraw(canvas);
            if (this.w) {
                if (!this.z) {
                    this.z = true;
                }
                W0();
            }
        }
    }

    public final void q0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z2) == null) {
            h28 h28Var = this.n;
            if (h28Var != null) {
                h28Var.update(z2);
            }
            Y0();
        }
    }

    public void r0(Long l2) {
        h28 h28Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048625, this, l2) == null) && (h28Var = this.n) != null) {
            h28Var.b0(l2);
        }
    }

    public void setCallback(mz7 mz7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, mz7Var) == null) {
            this.m = mz7Var;
        }
    }

    public void setScrollFragmentTabHost(nz7 nz7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, nz7Var) == null) {
            this.f0 = nz7Var;
            if (nz7Var != null) {
                nz7Var.e(this.i0);
                this.f0.b(this.i0);
            }
            h28 h28Var = this.n;
            if (h28Var != null) {
                h28Var.f1(nz7Var);
            }
        }
    }

    public void setTabInForeBackgroundState(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z2) == null) {
            if (M0) {
                this.i.n(z2);
                return;
            }
            h28 h28Var = this.n;
            if (h28Var != null) {
                h28Var.g1(z2);
            }
        }
    }

    public void setViewForeground(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z2) == null) {
            h28 h28Var = this.n;
            if (h28Var != null) {
                h28Var.N0(z2);
            }
            nz7 nz7Var = this.f0;
            if (nz7Var != null) {
                nz7Var.e(this.i0);
                this.f0.b(this.i0);
                this.i0.b();
            }
        }
    }

    public final void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LoadingView loadingView = this.r;
            if (loadingView != null) {
                loadingView.dettachView(this);
                this.r = null;
                this.b.setNextPage(this.f);
                this.f.H(getContext().getString(R.string.pb_load_more));
                this.f.g();
                this.f.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, Boolean.TRUE));
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.a;
            if (bigdaySwipeRefreshLayout != null) {
                bigdaySwipeRefreshLayout.setVisibility(0);
            }
            this.H.r(true);
            mz7 mz7Var = this.m;
            if (mz7Var != null) {
                mz7Var.b();
            }
            if (this.q != 0) {
                this.q = 0L;
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_PERSONALIZE_LOAD_MORE);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param(TiebaStatic.Params.OBJ_DURATION, new DecimalFormat("#.00").format(((System.currentTimeMillis() - this.q) * 1.0d) / 1000.0d));
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public final void W0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (!this.y) {
                long f2 = lz7.d().f(1) + lz7.d().b();
                long a2 = lz7.d().a(1);
                if (a2 > 0) {
                    f2 = System.currentTimeMillis() - a2;
                }
                yr5 yr5Var = new yr5();
                yr5Var.a();
                yr5Var.b();
                wr5.a().n(f2);
                if (this.x > 0) {
                    wr5.a().D(System.currentTimeMillis() - this.x);
                }
                wr5.a().H(yr5Var.c());
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.SECOND_DRAW_DISPATCH_STAMP_KEY);
                if (!MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW && !this.M) {
                    this.M = true;
                    SpeedStats.getInstance().onMainPageStatsEnd(getContext());
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921637, ""));
            }
            this.y = true;
        }
    }

    public void f1() {
        Uri data;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            if (fk5.b.a().a("show_reply_tip") || fk5.b.a().a("show_agree_tip")) {
                Intent intent = null;
                Context context = getContext();
                if (context instanceof TbPageContextSupport) {
                    TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) context;
                    if (tbPageContextSupport.getPageContext() != null && tbPageContextSupport.getPageContext().getPageActivity() != null) {
                        intent = tbPageContextSupport.getPageContext().getPageActivity().getIntent();
                    }
                }
                if (intent == null || (data = intent.getData()) == null) {
                    return;
                }
                String queryParameter = data.getQueryParameter(BdUniDispatchSchemeController.PARAM_EXT_DATA);
                if (TextUtils.isEmpty(queryParameter)) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(queryParameter);
                    this.O = jSONObject.optString("taskname");
                    String optString = jSONObject.optString("active");
                    this.P = optString;
                    if (!StringUtils.isNull(optString) && !StringUtils.isNull(this.O) && SharedPrefHelper.getInstance().getBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount(fc7.a(this.P, this.O)), true)) {
                        l1(this.P, this.O);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public synchronized void E0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            synchronized (this) {
                if (this.I) {
                    return;
                }
                this.I = true;
                Context context2 = getContext();
                if (context2 instanceof ls6) {
                    ((ls6) context2).setBaseContext(context);
                }
                MessageManager.getInstance().registerListener(this.s0);
                MessageManager.getInstance().registerListener(this.r0);
                MessageManager.getInstance().registerListener(this.W);
                MessageManager.getInstance().registerListener(this.I0);
                MessageManager.getInstance().registerListener(this.H0);
                MessageManager.getInstance().registerListener(this.J0);
                MessageManager.getInstance().registerListener(this.K0);
                MessageManager.getInstance().registerListener(this.v0);
                MessageManager.getInstance().registerListener(this.a0);
                MessageManager.getInstance().registerListener(this.b0);
                MessageManager.getInstance().registerListener(this.c0);
                if (M0) {
                    MessageManager.getInstance().registerListener(this.L0);
                }
                MessageManager.getInstance().registerListener(this.w0);
                this.x0.setPriority(-1);
                MessageManager.getInstance().addMessageRule(this.x0);
                BdPageContext<?> a2 = l9.a(context);
                if (a2 instanceof TbPageContext) {
                    this.l = (TbPageContext) a2;
                }
                this.H.p(this.l);
                j05 j05Var = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > SharedPrefHelper.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    j05Var = k05.i().h(1);
                }
                if (LaunchViewOptSwitch.getIsOn()) {
                    try {
                        G0(j05Var);
                    } catch (Exception unused) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, j05Var));
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, j05Var));
                }
                this.o = new c28(this.l);
                this.o.b().q(new r(this));
                this.p = new m48();
                if (M0) {
                    if (i37.a.getBaseContext() == null) {
                        i37.a.a(TbadkCoreApplication.getInst());
                    }
                    FeedTemplateAdapter feedTemplateAdapter = new FeedTemplateAdapter();
                    this.g = feedTemplateAdapter;
                    feedTemplateAdapter.j(new fb7());
                    this.g.j(new s97());
                    l97 l97Var = this.g;
                    gha ghaVar = new gha(2);
                    ghaVar.c(this.l);
                    ghaVar.b("INDEX");
                    l97Var.j(ghaVar);
                    this.g.j(new jha());
                    this.g.f(this.b);
                    xz9 xz9Var = new xz9(this.l.getPageActivity());
                    this.h = xz9Var;
                    xz9Var.e(this.y0);
                    AutoPlayController autoPlayController = new AutoPlayController(a2, this.b);
                    this.i = autoPlayController;
                    autoPlayController.o(this.E0);
                    this.j = new yz9(this.h);
                    nx9.n();
                } else {
                    p38 p38Var = new p38(context, this.b);
                    this.k = p38Var;
                    p38Var.z(this.p);
                    this.k.x(this.V);
                    this.k.u(this.o);
                    h28 h28Var = new h28(this.l, this.b, this.k, this.a, this);
                    this.n = h28Var;
                    h28Var.Z0(this.o);
                }
                PollingModel pollingModel = new PollingModel(this.l, this.U);
                this.f1106T = pollingModel;
                pollingModel.setDialogTime(h55.d);
                this.f1106T.setLiveIndexSecondFloorCallback(new s(this));
                S0(TbadkCoreApplication.getInst().getSkinType());
                this.B = SharedPrefHelper.getInstance().getInt("show_is_uninterest_tag", 0);
                if (!MainTabBottomDynamicIconManager.getInstance().checkIsHasShowIcon()) {
                    SafeHandler.getInst().post(new t(this));
                }
            }
        }
    }

    public void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            p38 p38Var = this.k;
            if (p38Var != null) {
                p38Var.w(this.d0);
                this.k.t(this.e0);
            }
            h28 h28Var = this.n;
            if (h28Var != null) {
                h28Var.c1(this.u0);
            }
            H0();
            this.b.addOnScrollListener(new c0(this));
            this.b.setOnSrollToBottomListener(new d0(this));
            this.b.setOnScrollStopDelayedListener(new e0(this), 1L);
            this.b.setRecyclerListener(new f0(this));
            this.b.removeOnScrollListener(this.h0);
            this.b.addOnScrollListener(this.h0);
            ix5.b().a(this);
        }
    }

    public final void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            lz7.d().j(System.currentTimeMillis(), 1);
            PbListView pbListView = this.f;
            if (pbListView != null && !pbListView.p()) {
                this.f.U();
                this.f.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            if (M0) {
                this.h.K();
                if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    TiebaStatic.log(new StatisticItem("c11032").param("obj_source", 2));
                }
                if (N0(this.b)) {
                    this.q = System.currentTimeMillis();
                    return;
                }
                return;
            }
            this.n.D0();
        }
    }

    public void a1() {
        xz9 xz9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (M0) {
                if (this.s != null && (xz9Var = this.h) != null) {
                    xz9Var.I();
                    Y0();
                    return;
                }
            } else {
                h28 h28Var = this.n;
                if (h28Var != null && h28Var.m0() != null) {
                    this.n.m0().e();
                }
                if (this.s != null && this.n != null) {
                    p0();
                    return;
                }
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.b;
            if (bdTypeRecyclerView != null && this.a != null) {
                bdTypeRecyclerView.setSelection(0);
                if (!this.a.t()) {
                    if (M0) {
                        this.i.p(false);
                    } else {
                        h28 h28Var2 = this.n;
                        if (h28Var2 != null && h28Var2.k0() != null) {
                            this.n.k0().y();
                            this.n.d1(false);
                        }
                    }
                    this.a.setRefreshing(true);
                }
                ScrollFragmentTabHost.s sVar = this.i0;
                if (sVar != null) {
                    sVar.b();
                }
            }
        }
    }

    public final void G0(Object obj) {
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, obj) == null) && (bigdaySwipeRefreshLayout = this.a) != null && !bigdaySwipeRefreshLayout.t()) {
            if (obj != null && (obj instanceof j05)) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                q38 q38Var = this.d;
                if (q38Var == null) {
                    q38 q38Var2 = new q38(this.l);
                    this.d = q38Var2;
                    q38Var2.C(this.u);
                    this.e = this.d;
                    H0();
                } else if (this.e == q38Var) {
                    return;
                } else {
                    this.e = q38Var;
                }
                this.d.v(true);
                this.a.setProgressView(this.d);
                int i2 = (int) (getResources().getDisplayMetrics().density * 86.0f);
                this.a.setCustomDistances(i2, i2, i2 * 2);
                return;
            }
            j05 j05Var = (j05) obj;
            r38 r38Var = this.c;
            if (r38Var == null) {
                r38 r38Var2 = new r38(this.l.getContext());
                this.c = r38Var2;
                this.e = r38Var2;
                H0();
            } else if (this.e == r38Var && j05Var.equals(r38Var.A())) {
                return;
            } else {
                this.e = this.c;
            }
            this.c.v(true);
            this.a.setProgressView(this.c);
            lg.g(new q0(this, j05Var));
            this.a.setCustomDistances((int) getResources().getDimension(R.dimen.tbds236), (int) (BdUtilHelper.getEquipmentHeight(this.l.getContext()) * 0.8d), BdUtilHelper.getEquipmentHeight(this.l.getContext()));
        }
    }

    public final void J0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = new BdTypeRecyclerView(context);
            this.b = bdTypeRecyclerView;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(bdTypeRecyclerView.getContext());
            this.E = linearLayoutManager;
            this.b.setLayoutManager(linearLayoutManager);
            this.b.setFadingEdgeLength(0);
            this.b.setOverScrollMode(2);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.b.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            rm6 rm6Var = new rm6(context);
            this.A = rm6Var;
            rm6Var.setFrom("from_personaize");
            this.A.a().setVisibility(0);
            this.A.a().setOnClickListener(this.j0);
            jz7 jz7Var = new jz7(this, this.b);
            this.H = jz7Var;
            jz7Var.q(context.getString(R.string.obfuscated_res_0x7f0f15ba));
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = new BigdaySwipeRefreshLayout(context);
            this.a = bigdaySwipeRefreshLayout;
            bigdaySwipeRefreshLayout.addView(this.b);
            this.a.setNeedInterceptOnLayout(!M0);
            PbListView pbListView = new PbListView(context);
            this.f = pbListView;
            pbListView.c();
            this.f.s(R.color.transparent);
            this.f.B();
            this.f.J(SkinManager.getColor(R.color.CAM_X0107));
            this.f.L(R.dimen.tbfontsize33);
            this.f.F(R.color.CAM_X0110);
            this.f.w(BdUtilHelper.getDimens(context, R.dimen.tbds182));
            this.f.G(this.G0);
            this.f.v();
            this.b.setNextPage(this.f);
            addView(this.a);
            this.J = new FrameLayout(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 5;
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
            layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X011);
            addView(this.J, layoutParams);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, bdUniqueId) == null) {
            if (M0) {
                this.g.e(new m0a(new l0a(), bdUniqueId));
                l97 l97Var = this.g;
                k0a k0aVar = new k0a();
                k0aVar.d("1");
                l97Var.b(new j0a(k0aVar, bdUniqueId));
                this.i.q(bdUniqueId);
                this.h.P(bdUniqueId);
            }
            p38 p38Var = this.k;
            if (p38Var != null) {
                p38Var.y(bdUniqueId);
            }
            h28 h28Var = this.n;
            if (h28Var != null) {
                h28Var.U0(bdUniqueId);
            }
            m48 m48Var = this.p;
            if (m48Var != null) {
                m48Var.a(bdUniqueId);
            }
            q38 q38Var = this.d;
            if (q38Var != null) {
                q38Var.V(bdUniqueId);
            }
            k05.i().n(bdUniqueId);
            CustomMessageListener customMessageListener = this.F0;
            if (customMessageListener != null) {
                customMessageListener.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.F0);
            }
            sr6.b().a(new rr6(bdUniqueId, rd5.class), new a(this, rd5.class));
            sr6.b().a(new rr6(bdUniqueId, td5.class), new b(this, td5.class));
            sr6.b().a(new rr6(bdUniqueId, sd5.class), new c(this, sd5.class));
            sr6.b().a(new rr6(bdUniqueId, qd5.class), new d(this, qd5.class));
            sr6.b().a(new rr6(bdUniqueId, rz9.class), new e(this, rz9.class));
            sr6.b().a(new rr6(bdUniqueId, sz9.class), new f(this, sz9.class));
            sr6.b().a(new rr6(bdUniqueId, od5.class), new g(this, od5.class));
            sr6.b().a(new rr6(bdUniqueId, dk5.class), new h(this, dk5.class));
        }
    }

    public void S0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            if (this.u != i2) {
                LoadingView loadingView = this.r;
                if (loadingView != null) {
                    loadingView.onChangeSkinType();
                }
                om5 om5Var = this.s;
                if (om5Var != null) {
                    om5Var.onChangeSkinType();
                }
                q38 q38Var = this.d;
                if (q38Var != null) {
                    q38Var.C(i2);
                }
                PbListView pbListView = this.f;
                if (pbListView != null) {
                    pbListView.J(SkinManager.getColor(R.color.CAM_X0109));
                    this.f.e(i2);
                }
                p38 p38Var = this.k;
                if (p38Var != null) {
                    p38Var.o(i2);
                }
                h28 h28Var = this.n;
                if (h28Var != null) {
                    h28Var.I0(i2);
                }
                rm6 rm6Var = this.A;
                if (rm6Var != null) {
                    rm6Var.d(i2);
                }
                RightFloatLayerView rightFloatLayerView = this.F;
                if (rightFloatLayerView != null) {
                    rightFloatLayerView.n();
                }
                jz7 jz7Var = this.H;
                if (jz7Var != null) {
                    jz7Var.o();
                }
                kf5 kf5Var = this.S;
                if (kf5Var != null) {
                    kf5Var.w();
                }
                l97 l97Var = this.g;
                if (l97Var != null) {
                    l97Var.c();
                }
            }
            this.u = i2;
        }
    }

    public final void i1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z2) == null) {
            if (this.r == null) {
                this.r = new LoadingView(getContext());
                this.r.setBottomMargin(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + BdUtilHelper.getDimens(getContext(), R.dimen.tbds60));
                this.r.cancelCenterVertical();
                this.r.setWrapStyle(true);
                this.r.onChangeSkinType();
            }
            this.r.attachView(this, z2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, Boolean.FALSE));
            this.b.setNextPage(null);
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.a;
            if (bigdaySwipeRefreshLayout != null) {
                bigdaySwipeRefreshLayout.setVisibility(8);
            }
            this.H.r(false);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921457, this.l.getUniqueId()));
        }
    }

    public final boolean p1(vb5 vb5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, vb5Var)) == null) {
            if (!RightFloatLayerView.k()) {
                C0();
                return false;
            } else if (vb5Var == null) {
                return false;
            } else {
                if (this.F == null) {
                    RightFloatLayerView E = RightFloatLayerLottieView.E(vb5Var, getContext());
                    this.F = E;
                    E.setPageContext(this.l);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 85;
                    layoutParams.bottomMargin = N0 + this.G;
                    this.F.c();
                    addView(this.F, layoutParams);
                }
                this.F.setAutoCompleteShown(true);
                if (vb5Var.a()) {
                    return false;
                }
                this.F.setData(vb5Var);
                this.F.setLogoListener(new w(this, vb5Var));
                this.F.setFeedBackListener(new x(this, vb5Var));
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final void y0(e67 e67Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048638, this, e67Var) != null) || e67Var == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.NEG_FEEDBACK_KEY).param("obj_locate", "1").param("fid", e67Var.d()).param("tid", e67Var.h()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("nid", e67Var.e()));
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.NEGATIVE_FEEDBACK_OPEN_CLICK).param("obj_locate", "1").param("fid", e67Var.d()).param("tid", e67Var.h()).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public final void z0(y38 y38Var) {
        List<v97<?>> b2;
        int u02;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, y38Var) == null) {
            h28 h28Var = this.n;
            if (h28Var != null) {
                h28Var.p0(y38Var);
            }
            if (this.h != null) {
                int firstVisiblePosition = this.b.getFirstVisiblePosition();
                RecommendBarCardModel d2 = RecommendBarCardModel.d(y38Var);
                if (d2 != null && (b2 = this.h.b()) != null && (u02 = u0(y38Var.b(), b2)) >= 0 && (i2 = u02 + 1) >= 0 && i2 <= b2.size() && i2 > firstVisiblePosition) {
                    d2.n(y38Var.b());
                    d2.q(RecommendBarCardModel.RecDataSource.FORUMBACKCONCERN);
                    this.h.F(new w97(new j37(new w67(d2)), "recommend_bar_layout"), i2);
                    c28 c28Var = this.o;
                    if (c28Var != null) {
                        c28Var.c();
                        h28.t0(y38Var.a());
                    }
                }
            }
        }
    }

    public void T0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.s0);
            MessageManager.getInstance().unRegisterListener(this.r0);
            MessageManager.getInstance().unRegisterListener(this.H0);
            MessageManager.getInstance().unRegisterListener(this.I0);
            MessageManager.getInstance().unRegisterListener(this.W);
            MessageManager.getInstance().unRegisterListener(this.J0);
            MessageManager.getInstance().unRegisterListener(this.K0);
            MessageManager.getInstance().unRegisterListener(this.v0);
            MessageManager.getInstance().unRegisterListener(this.t0);
            MessageManager.getInstance().unRegisterListener(this.a0);
            MessageManager.getInstance().unRegisterListener(this.b0);
            MessageManager.getInstance().registerListener(this.c0);
            if (M0) {
                MessageManager.getInstance().unRegisterListener(this.L0);
                this.h.w();
                this.j.c();
            }
            if (M0) {
                this.i.l();
            }
            h28 h28Var = this.n;
            if (h28Var != null) {
                h28Var.J0();
            }
            PollingModel pollingModel = this.f1106T;
            if (pollingModel != null) {
                pollingModel.onDestroy();
            }
            p38 p38Var = this.k;
            if (p38Var != null) {
                p38Var.w(null);
                this.k.p();
            }
            MessageManager.getInstance().unRegisterListener(this.w0);
            MessageManager.getInstance().removeMessageRule(this.x0);
            this.I = false;
            h28 h28Var2 = this.n;
            if (h28Var2 != null) {
                h28Var2.c1(null);
            }
            r38 r38Var = this.c;
            if (r38Var != null) {
                r38Var.a(null);
                this.c.b(null);
                this.c.d(null);
                this.c.g(null);
                this.c.B();
            }
            q38 q38Var = this.d;
            if (q38Var != null) {
                q38Var.a(null);
                this.d.b(null);
                this.d.d(null);
                this.d.g(null);
                this.d.T();
            }
            this.b.setOnSrollToBottomListener(null);
            nz7 nz7Var = this.f0;
            if (nz7Var != null) {
                nz7Var.e(this.i0);
            }
            this.b.removeOnScrollListener(this.h0);
            LoadingView loadingView = this.r;
            if (loadingView != null) {
                loadingView.release();
            }
            this.b.setRecyclerListener(null);
            k05.i().e();
            SafeHandler.getInst().removeCallbacks(this.D0);
            ix5.b().d(this);
        }
    }

    public void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (this.v) {
                a1();
                this.v = false;
            }
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.a;
            if (bigdaySwipeRefreshLayout != null) {
                bigdaySwipeRefreshLayout.D();
            }
            p38 p38Var = this.k;
            if (p38Var != null) {
                p38Var.r();
            }
            if (!RightFloatLayerView.k()) {
                D0();
            }
            q1();
            if (!M0 && u5a.a().c()) {
                u5a.a().d(false);
                DefaultLog.getInstance().i("RecentForumLog", "首页刷新最近逛的吧");
                h28 h28Var = this.n;
                if (h28Var != null) {
                    h28Var.T0();
                }
            }
        }
    }

    public void X0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (M0) {
                this.i.k(true);
            } else {
                h28 h28Var = this.n;
                if (h28Var != null) {
                    h28Var.G0(true);
                }
            }
            kf5 kf5Var = this.S;
            if (kf5Var != null) {
                kf5Var.q();
            }
            vm6.b().d(false);
            z36.c().h("page_recommend", "show_");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            SafeHandler.getInst().removeCallbacks(this.D0);
        }
    }

    public final void q1() {
        ThreadCardViewHolder threadCardViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            for (int i2 = 0; i2 < this.b.getChildCount(); i2++) {
                View childAt = this.b.getChildAt(i2);
                if ((childAt instanceof ThreadCardView) && (childAt.getTag() instanceof ThreadCardViewHolder) && (threadCardViewHolder = (ThreadCardViewHolder) childAt.getTag()) != null && threadCardViewHolder.b() != null && (threadCardViewHolder.b().f() instanceof my)) {
                    ((my) threadCardViewHolder.b().f()).Q();
                }
            }
        }
    }

    public void setViewForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            setViewForeground(false);
            if (M0) {
                this.i.k(false);
            } else {
                h28 h28Var = this.n;
                if (h28Var != null) {
                    h28Var.G0(false);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            if (this.B < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
                SafeHandler.getInst().postDelayed(this.D0, 1000L);
            }
        }
    }

    @Override // com.baidu.tieba.hx5
    @Nullable
    public jx5 b(@NonNull String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, str, str2)) == null) {
            TbPageContext<?> tbPageContext = this.l;
            if (tbPageContext != null && tbPageContext.getPageActivity() != null && !this.l.getPageActivity().isFinishing()) {
                if ("home_banner".equals(str)) {
                    if (BdActivityStack.getInst().getSize() - BdActivityStack.getInst().isExitAt(this.l.getPageActivity()) > 2) {
                        DefaultLog.getInstance().i("ViewPosLog", "MainTabActivity和栈顶Activity之间存在Activity");
                        return null;
                    }
                    int findFirstVisibleItemPosition = this.E.findFirstVisibleItemPosition();
                    int findLastVisibleItemPosition = this.E.findLastVisibleItemPosition();
                    if (findFirstVisibleItemPosition != -1 && findLastVisibleItemPosition != -1) {
                        while (findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
                            if (findFirstVisibleItemPosition >= 0 && findFirstVisibleItemPosition < this.b.getData().size()) {
                                ym ymVar = this.b.getData().get(findFirstVisibleItemPosition);
                                if (ymVar instanceof b48) {
                                    return w0(str2, findFirstVisibleItemPosition, (b48) ymVar);
                                }
                            }
                            findFirstVisibleItemPosition++;
                        }
                    } else {
                        DefaultLog.getInstance().i("ViewPosLog", "当前RecyclerView无可见item");
                        return null;
                    }
                }
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("ViewPosLog", "未找到对应控件 " + str + " 的位置处理实现");
                return null;
            }
            DefaultLog.getInstance().i("ViewPosLog", "当前上下文环境不可用");
            return null;
        }
        return (jx5) invokeLL.objValue;
    }

    public final void e1(String str, String str2) {
        ThreadCardViewHolder threadCardViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048608, this, str, str2) == null) {
            for (int i2 = 0; i2 < this.b.getChildCount(); i2++) {
                View childAt = this.b.getChildAt(i2);
                if ((childAt instanceof ThreadCardView) && (childAt.getTag() instanceof ThreadCardViewHolder) && (threadCardViewHolder = (ThreadCardViewHolder) childAt.getTag()) != null && threadCardViewHolder.b() != null && (threadCardViewHolder.b().f() instanceof my)) {
                    if (fk5.b.a().a("show_reply_tip") && "home_reply".equals(str2)) {
                        ((my) threadCardViewHolder.b().f()).P();
                    } else if (fk5.b.a().a("show_agree_tip") && "home_agree".equals(str2)) {
                        ((my) threadCardViewHolder.b().f()).O();
                    }
                    SharedPrefHelper.getInstance().putBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount(fc7.a(str, str2)), false);
                    return;
                }
            }
        }
    }

    public final void j1(View view2, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048614, this, view2, str, z2) == null) {
            if (this.s == null) {
                this.s = new om5(getContext(), new j0(this));
            }
            this.s.attachView(view2, z2);
            this.s.o();
            z3a.a("main", false);
        }
    }

    public void n1(DataRes dataRes, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{dataRes, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            lg.g(new h0(this));
            h28 h28Var = this.n;
            if (h28Var != null) {
                h28Var.K0(z2, z3, dataRes, 0, null);
            }
        }
    }

    public void l1(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048616, this, str, str2) != null) || this.b == null) {
            return;
        }
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.a;
        if (bigdaySwipeRefreshLayout != null && bigdaySwipeRefreshLayout.t()) {
            this.a.r();
        }
        int i2 = -1;
        p38 p38Var = this.k;
        if (p38Var == null) {
            return;
        }
        List<ym> k2 = p38Var.k();
        if (!ListUtils.isEmpty(k2)) {
            int i3 = 0;
            while (true) {
                if (i3 >= k2.size()) {
                    break;
                } else if (k2.get(i3) instanceof sn6) {
                    i2 = i3;
                    break;
                } else {
                    i3++;
                }
            }
        }
        View childAt = this.b.getChildAt(i2);
        if (i2 >= 0 && childAt != null && K0(i2)) {
            int[] iArr = new int[2];
            this.b.getLocationOnScreen(iArr);
            int i4 = iArr[1];
            int[] iArr2 = new int[2];
            childAt.getLocationOnScreen(iArr2);
            int i5 = iArr2[1];
            if (i5 == i4) {
                e1(str, str2);
                return;
            }
            this.Q = true;
            this.b.smoothScrollBy(0, i5 - i4);
            return;
        }
        this.Q = true;
        this.b.smoothScrollToPosition(i2);
    }

    public void m1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z2) == null) {
            if (M0) {
                this.h.I();
                i1(true);
                Y0();
            } else {
                q0(z2);
            }
            if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
                k05.i().j();
                k05.i().k();
            }
        }
    }

    public final void s0(int i2) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i2) == null) {
            if (this.a.u() && !PermissionUtil.isBrowseMode()) {
                if (i2 > 0) {
                    string = String.format(this.l.getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i2));
                } else {
                    string = this.l.getString(R.string.recommend_frs_refresh_nodata);
                }
                this.a.z(new i95.i(string, 0));
                return;
            }
            this.a.setRefreshing(false);
        }
    }

    public final jx5 v0(@Nullable View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, view2)) == null) {
            jx5 b2 = jx5.b();
            if (getContext() != null && view2 != null) {
                Rect rect = new Rect();
                view2.getGlobalVisibleRect(rect);
                if (rect.left <= BdUtilHelper.getEquipmentWidth(getContext()) && rect.right >= 0) {
                    int i2 = rect.left;
                    int i3 = rect.top;
                    return new jx5(true, i2, i3, rect.right - i2, rect.bottom - i3);
                }
            }
            return b2;
        }
        return (jx5) invokeL.objValue;
    }

    public final int u0(@NonNull String str, @NonNull List<v97<?>> list) {
        InterceptResult invokeLL;
        n57<?> n57Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048634, this, str, list)) == null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                v97<?> v97Var = list.get(i2);
                if ((v97Var instanceof i57) && (n57Var = ((i57) v97Var).c) != null && str.equals(n57Var.g())) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    @NonNull
    public final jx5 w0(@Nullable String str, int i2, @NonNull b48 b48Var) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048636, this, str, i2, b48Var)) == null) {
            jx5 b2 = jx5.b();
            if (this.b == null) {
                return b2;
            }
            if (bi.isEmpty(str)) {
                return v0(this.b.getChildAt(i2));
            }
            View view2 = null;
            if (w38.a(str).b().equals(b48Var.a)) {
                view2 = this.b.getChildAt(i2);
            }
            return v0(view2);
        }
        return (jx5) invokeLIL.objValue;
    }

    public final void x0(List<Integer> list, String str, e67 e67Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048637, this, list, str, e67Var) == null) && list != null && e67Var != null) {
            StringBuilder sb = new StringBuilder();
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                sb.append(list.get(i3));
                sb.append(",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            if (e67Var.g() == 0) {
                i2 = 1;
            } else if (e67Var.g() == 40) {
                i2 = 2;
            } else if (e67Var.g() == 49 || e67Var.g() == 69) {
                i2 = 3;
            }
            p38 p38Var = this.k;
            if (p38Var != null) {
                p38Var.n();
            }
            P0();
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.NEG_FEEDBACK_KEY).param("tid", e67Var.h()).param("nid", e67Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", e67Var.d()).param("obj_param1", e67Var.i()).param("obj_source", e67Var.f()).param("obj_id", e67Var.a()).param("obj_type", sb.toString()).param("obj_name", str).param(TiebaStatic.Params.OBJ_PARAM2, i2).param("obj_locate", "1"));
        }
    }
}
