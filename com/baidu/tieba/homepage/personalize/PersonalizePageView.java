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
import com.baidu.adp.lib.safe.UiUtils;
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
import com.baidu.tbadk.abtest.helper.LiveEnterForumTestHelper;
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
import com.baidu.tbadk.core.util.CommonStatisticKey;
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
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.loading.LoadingView;
import com.baidu.tbadk.mainTab.dynamicIcon.MainTabBottomDynamicIconManager;
import com.baidu.tbadk.switchs.BigdaySwitch;
import com.baidu.tbadk.widget.RightFloatLayerLottieView;
import com.baidu.tbadk.widget.RightFloatLayerView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.a2b;
import com.baidu.tieba.a5;
import com.baidu.tieba.am6;
import com.baidu.tieba.ar6;
import com.baidu.tieba.b37;
import com.baidu.tieba.bd8;
import com.baidu.tieba.bi8;
import com.baidu.tieba.br6;
import com.baidu.tieba.c26;
import com.baidu.tieba.cd8;
import com.baidu.tieba.cla;
import com.baidu.tieba.d85;
import com.baidu.tieba.dd8;
import com.baidu.tieba.di8;
import com.baidu.tieba.dka;
import com.baidu.tieba.dla;
import com.baidu.tieba.dn6;
import com.baidu.tieba.dp4;
import com.baidu.tieba.ec7;
import com.baidu.tieba.eka;
import com.baidu.tieba.ela;
import com.baidu.tieba.em6;
import com.baidu.tieba.er6;
import com.baidu.tieba.eu;
import com.baidu.tieba.f37;
import com.baidu.tieba.feed.list.FeedTemplateAdapter;
import com.baidu.tieba.fk5;
import com.baidu.tieba.fla;
import com.baidu.tieba.fp5;
import com.baidu.tieba.gb7;
import com.baidu.tieba.gh8;
import com.baidu.tieba.hd7;
import com.baidu.tieba.hh8;
import com.baidu.tieba.homepage.concern.data.RecommendBarCardModel;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.adapter.HomePageCardVideoViewHolder;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.i37;
import com.baidu.tieba.ib7;
import com.baidu.tieba.ih8;
import com.baidu.tieba.j37;
import com.baidu.tieba.je7;
import com.baidu.tieba.ji8;
import com.baidu.tieba.jka;
import com.baidu.tieba.kka;
import com.baidu.tieba.kv5;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.lv5;
import com.baidu.tieba.mv5;
import com.baidu.tieba.n57;
import com.baidu.tieba.nh8;
import com.baidu.tieba.nqa;
import com.baidu.tieba.nua;
import com.baidu.tieba.p55;
import com.baidu.tieba.pb7;
import com.baidu.tieba.ph8;
import com.baidu.tieba.pi;
import com.baidu.tieba.play.AutoPlayController;
import com.baidu.tieba.q67;
import com.baidu.tieba.q88;
import com.baidu.tieba.qm6;
import com.baidu.tieba.qua;
import com.baidu.tieba.rb7;
import com.baidu.tieba.rd;
import com.baidu.tieba.s95;
import com.baidu.tieba.sb7;
import com.baidu.tieba.sf8;
import com.baidu.tieba.sh5;
import com.baidu.tieba.sh8;
import com.baidu.tieba.t67;
import com.baidu.tieba.t95;
import com.baidu.tieba.tb7;
import com.baidu.tieba.tbadkCore.writeModel.AttentionBarData;
import com.baidu.tieba.u67;
import com.baidu.tieba.u77;
import com.baidu.tieba.ur6;
import com.baidu.tieba.v27;
import com.baidu.tieba.v95;
import com.baidu.tieba.vb5;
import com.baidu.tieba.vh5;
import com.baidu.tieba.vp5;
import com.baidu.tieba.w57;
import com.baidu.tieba.w95;
import com.baidu.tieba.x95;
import com.baidu.tieba.xc8;
import com.baidu.tieba.xf8;
import com.baidu.tieba.xha;
import com.baidu.tieba.xoa;
import com.baidu.tieba.xp5;
import com.baidu.tieba.y05;
import com.baidu.tieba.yv4;
import com.baidu.tieba.z95;
import com.baidu.tieba.zc8;
import com.baidu.tieba.zs5;
import com.baidu.tieba.zv4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.AlaLiveInfo;
import tbclient.Personalized.DataRes;
/* loaded from: classes6.dex */
public class PersonalizePageView extends FrameLayout implements kv5 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean O0;
    public static final int P0;
    public transient /* synthetic */ FieldHolder $fh;
    public am6 A;
    public p55.g A0;
    public int B;
    public p55.h B0;
    public int C;
    public p55.e C0;
    public boolean D;
    public p55.f D0;
    public LinearLayoutManager E;
    public Runnable E0;
    public RightFloatLayerView F;
    public AutoPlayController.a F0;
    public int G;
    public final CustomMessageListener G0;
    public zc8 H;
    public View.OnClickListener H0;
    public volatile boolean I;
    public CustomMessageListener I0;
    public FrameLayout J;
    public CustomMessageListener J0;
    public boolean K;
    public CustomMessageListener K0;
    public boolean L;
    public CustomMessageListener L0;
    public boolean M;
    public CustomMessageListener M0;
    public Object N;
    public jka.a N0;
    public String O;
    public String P;
    public boolean Q;
    public boolean R;
    public vb5 S;

    /* renamed from: T  reason: collision with root package name */
    public PollingModel f1104T;
    public BdUniqueId U;
    public BdUniqueId V;
    public gh8.f W;
    public BigdaySwipeRefreshLayout a;
    public CustomMessageListener a0;
    public BdTypeRecyclerView b;
    public CustomMessageListener b0;
    public ih8 c;
    public CustomMessageListener c0;
    public hh8 d;
    public CustomMessageListener d0;
    public c1 e;
    public NEGFeedBackView.NEGFeedbackEventCallback e0;
    public PbListView f;
    public FollowUserButton.a f0;
    public ib7 g;
    public dd8 g0;
    public jka h;
    public int h0;
    public AutoPlayController i;
    public RecyclerView.OnScrollListener i0;
    public kka j;
    public ScrollFragmentTabHost.s j0;
    public gh8 k;
    public TbPageContext<?> l;
    public cd8 m;
    public xf8 n;
    public sf8 o;
    public di8 p;
    public long q;
    public LoadingView r;
    public View.OnClickListener r0;
    public fk5 s;
    public CustomMessageListener s0;
    public long t;
    public CustomMessageListener t0;
    public int u;
    public CustomMessageListener u0;
    public boolean v;
    public xf8.o0 v0;
    public boolean w;
    public CustomMessageListener w0;
    public long x;
    public final CustomMessageListener x0;
    public boolean y;
    public final CustomRule y0;
    public boolean z;
    public final ec7.a z0;

    /* loaded from: classes6.dex */
    public interface c1 {
        void a(p55.g gVar);

        void b(p55.h hVar);

        void c(p55.e eVar);

        void e(p55.f fVar);
    }

    public final void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class n0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ n0 a;

            public a(n0 n0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {n0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = n0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.Q0();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n0(PersonalizePageView personalizePageView, int i) {
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
    public class o implements xf8.o0 {
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
            public final /* synthetic */ o c;

            public a(o oVar, int i, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar, Integer.valueOf(i), str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = oVar;
                this.a = i;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                    return;
                }
                this.c.b.z0();
                if (this.a == 1) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        this.c.b.l.showToast(this.b);
                    }
                    this.c.f();
                } else if (this.c.a) {
                    this.c.f();
                    this.c.b.l1(false);
                    return;
                } else {
                    this.c.b.a.setVisibility(8);
                    this.c.b.H.r(false);
                    PersonalizePageView personalizePageView = this.c.b;
                    personalizePageView.i1(personalizePageView, this.b, true);
                }
                IdleHandlerManager.getInstance().runIdleTaskImmediately();
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ boolean a;
            public final /* synthetic */ o b;

            public b(o oVar, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar, Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = oVar;
                this.a = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.f();
                    this.b.b.a.setVisibility(0);
                    this.b.b.H.r(true);
                    this.b.b.z0();
                    this.b.b.A0();
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
            public final /* synthetic */ o a;

            public c(o oVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = oVar;
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

        public o(PersonalizePageView personalizePageView) {
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

        @Override // com.baidu.tieba.xf8.o0
        public void onSuccess(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
                UiUtils.runOnUiThread(new b(this, z));
            }
        }

        @Override // com.baidu.tieba.xf8.o0
        public void a(int i, zs5 zs5Var, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), zs5Var, Integer.valueOf(i2)}) == null) {
                if (this.b.m == null) {
                    PersonalizePageView personalizePageView = this.b;
                    personalizePageView.i1(personalizePageView, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e70), true);
                    this.b.z0();
                    return;
                }
                boolean L0 = this.b.L0();
                this.b.A0();
                if (L0) {
                    this.b.h1(true);
                }
                this.b.m.c(i, zs5Var, i2);
                dp4.f().m();
            }
        }

        @Override // com.baidu.tieba.xf8.o0
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                UiUtils.runOnUiThread(new c(this));
            }
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.a) {
                this.a = false;
                SharedPrefHelper.getInstance().putBoolean("key_first_install", false);
            }
        }

        @Override // com.baidu.tieba.xf8.o0
        public void c(int i, int i2, zs5 zs5Var, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), zs5Var, Integer.valueOf(i3)}) == null) && this.b.m != null) {
                PersonalizePageView personalizePageView = this.b;
                if (personalizePageView.M0(personalizePageView.b)) {
                    this.b.q = System.currentTimeMillis();
                }
                this.b.m.d(i, i2, zs5Var, i3);
            }
        }

        @Override // com.baidu.tieba.xf8.o0
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) {
                UiUtils.runOnUiThread(new a(this, i, str));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements gb7.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fla a;
        public final /* synthetic */ BdUniqueId b;
        public final /* synthetic */ PersonalizePageView c;

        public a(PersonalizePageView personalizePageView, fla flaVar, BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, flaVar, bdUniqueId};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = personalizePageView;
            this.a = flaVar;
            this.b = bdUniqueId;
        }

        @Override // com.baidu.tieba.gb7.c
        public void a(@NonNull sb7<?> sb7Var, @NonNull rb7<?, ?> rb7Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, sb7Var, rb7Var, i) == null) {
                this.a.a(sb7Var, rb7Var, i);
                fp5.a.h(this.b);
            }
        }

        @Override // com.baidu.tieba.gb7.c
        public void b(@NonNull RecyclerView recyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView) == null) {
                this.a.b(recyclerView);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a0 implements p55.h {
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

        @Override // com.baidu.tieba.p55.h
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
    public class a1 extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public a1(PersonalizePageView personalizePageView) {
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
            if ((interceptable != null && interceptable.invokeLI(1048576, this, recyclerView, i) != null) || this.a.h0 == i || this.a.g0 == null) {
                return;
            }
            this.a.h0 = i;
            if (this.a.h0 == 1) {
                this.a.g0.a();
            } else if (this.a.Y0(recyclerView)) {
                this.a.g0.c();
            } else {
                this.a.g0.a();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends er6<w95> {
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
        @Override // com.baidu.tieba.er6
        public void onEvent(@NonNull w95 w95Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, w95Var) == null) {
                if ("recommend_post".equals(w95Var.b()) && (w95Var.a() instanceof JSONObject)) {
                    String optString = ((JSONObject) w95Var.a()).optString("tid");
                    if (!StringUtils.isNull(optString) && this.b.h != null) {
                        this.b.h.w(optString);
                        this.b.h.R((JSONObject) w95Var.a());
                    }
                } else if ("recommend_fun_ad".equals(w95Var.b()) && this.b.b != null && this.b.b.getListAdapter() != null) {
                    this.b.b.getListAdapter().notifyDataSetChanged();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b0 implements p55.e {
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

        @Override // com.baidu.tieba.p55.e
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
    public class b1 extends ScrollFragmentTabHost.s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public b1(PersonalizePageView personalizePageView) {
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
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.g0 == null) {
                return;
            }
            this.a.h0 = -1;
            PersonalizePageView personalizePageView = this.a;
            if (personalizePageView.Y0(personalizePageView.b)) {
                this.a.g0.c();
            } else {
                this.a.g0.a();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends er6<z95> {
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
        @Override // com.baidu.tieba.er6
        public void onEvent(@NonNull z95 z95Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z95Var) == null) {
                String a = z95Var.a();
                if (!TextUtils.isEmpty(a) && this.b.h != null) {
                    this.b.h.w(a);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c0 implements p55.f {
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

        @Override // com.baidu.tieba.p55.f
        public void a(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (PersonalizePageView.O0) {
                    this.a.i.p(true);
                    this.a.i.r();
                } else if (this.a.n != null) {
                    this.a.n.d1(true);
                    this.a.n.S0();
                }
                TbSingleton.getInstance().mIsForceLayoutMaintab = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, Boolean.TRUE));
                yv4 yv4Var = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > SharedPrefHelper.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    yv4Var = zv4.i().h(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, yv4Var));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends er6<x95> {
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
        @Override // com.baidu.tieba.er6
        public void onEvent(@NonNull x95 x95Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x95Var) == null) && (x95Var.a() instanceof t67) && ((t67) x95Var.a()).d().equals("recommend_post")) {
                Object a = ((t67) x95Var.a()).a();
                if (!(a instanceof u67)) {
                    return;
                }
                this.b.x0((u67) a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d0 extends RecyclerView.OnScrollListener {
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

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                if (this.a.E != null && i == 0) {
                    s95 wlConfigData = TbSingleton.getInstance().getWlConfigData();
                    int i3 = 3;
                    if (wlConfigData != null && wlConfigData.I() != 0) {
                        i3 = wlConfigData.I();
                    }
                    int itemCount = this.a.E.getItemCount() - this.a.E.findLastVisibleItemPosition();
                    if (PersonalizePageView.O0) {
                        i2 = 1;
                    } else {
                        i2 = 5;
                    }
                    if (itemCount <= i3 * i2) {
                        this.a.N0();
                    }
                }
                if (this.a.Q && i == 0 && SharedPrefHelper.getInstance().getBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount(je7.a(this.a.P, this.a.O)), true)) {
                    PersonalizePageView personalizePageView = this.a;
                    personalizePageView.d1(personalizePageView.P, this.a.O);
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
                PersonalizePageView.P(this.a, i2);
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
    public static class d1 {
        public static /* synthetic */ Interceptable $ic;
        public static final boolean a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(879330564, "Lcom/baidu/tieba/homepage/personalize/PersonalizePageView$d1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(879330564, "Lcom/baidu/tieba/homepage/personalize/PersonalizePageView$d1;");
                    return;
                }
            }
            a = UbsABTestHelper.isRecommendFeedTest();
        }
    }

    /* loaded from: classes6.dex */
    public class e extends er6<v95> {
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
        @Override // com.baidu.tieba.er6
        public void onEvent(@NonNull v95 v95Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v95Var) == null) && (v95Var.a() instanceof t67) && ((t67) v95Var.a()).d().equals("recommend_post")) {
                Object a = ((t67) v95Var.a()).a();
                if (!(a instanceof u67)) {
                    return;
                }
                this.b.w0(v95Var.b(), v95Var.c(), (u67) a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e0 implements BdListView.p {
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

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.N0();
        }
    }

    /* loaded from: classes6.dex */
    public class f extends er6<dka> {
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
        @Override // com.baidu.tieba.er6
        public void onEvent(@NonNull dka dkaVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dkaVar) != null) || this.b.p == null) {
                return;
            }
            this.b.p.e(dkaVar.d(), dkaVar.f(), dkaVar.c(), dkaVar.b(), dkaVar.a(), dkaVar.e(), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, null);
        }
    }

    /* loaded from: classes6.dex */
    public class f0 implements BdListView.o {
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

        @Override // com.baidu.adp.widget.ListView.BdListView.o
        public void onScrollStop(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && System.currentTimeMillis() - this.a.t >= 5000 && this.a.n != null) {
                this.a.n.R0(i, i2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends er6<eka> {
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
        @Override // com.baidu.tieba.er6
        public void onEvent(@NonNull eka ekaVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ekaVar) != null) || this.b.o == null) {
                return;
            }
            this.b.o.e(ekaVar.b(), JavaTypesHelper.toLong(ekaVar.a(), 0L), ekaVar.c());
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
                        this.a.h.W(data);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h extends er6<t95> {
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
        @Override // com.baidu.tieba.er6
        public void onEvent(@NonNull t95 t95Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t95Var) == null) {
                UpdateAttentionMessage.UpdateAttentionData a = t95Var.a();
                if (a.blockData == null && a.isSucc && !TextUtils.isEmpty(a.toUid) && this.b.h != null) {
                    this.b.h.W(a);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h0 implements RecyclerView.RecyclerListener {
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
                ((HomePageCardVideoViewHolder) view2.getTag()).a().stopPlay();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i extends er6<sh5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(PersonalizePageView personalizePageView, Class cls) {
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
        @Override // com.baidu.tieba.er6
        public void onEvent(@NonNull sh5 sh5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sh5Var) == null) {
                if (this.b.n != null) {
                    this.b.n.s0(sh5Var);
                }
                if (this.b.h != null) {
                    this.b.h.E(sh5Var);
                }
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
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public j(PersonalizePageView personalizePageView) {
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
    public class j0 implements Runnable {
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
    public class k implements gh8.f {
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

        @Override // com.baidu.tieba.gh8.f
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
                this.a.c1();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k0 implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (PersonalizePageView.O0) {
                    if (this.a.h != null) {
                        this.a.h.f();
                    }
                } else if (this.a.n == null) {
                } else {
                    this.a.o0();
                }
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
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (!TbSingleton.getInstance().isAddBanner) {
                    this.a.c1();
                }
                PersonalizePageView personalizePageView = this.a;
                personalizePageView.K = true;
                if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW || personalizePageView.L) {
                    return;
                }
                personalizePageView.H0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l0 implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.l != null) {
                SharedPrefHelper.getInstance().putInt("show_is_uninterest_tag", PersonalizePageView.b0(this.a));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(this.a.l.getContext(), 2)));
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && SpeedStatsUtils.UBC_VALUE_SPLASH.equals(customResponsedMessage.getData())) {
                PersonalizePageView personalizePageView = this.a;
                if (personalizePageView.K && !personalizePageView.L) {
                    personalizePageView.H0();
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
    public class m0 implements AutoPlayController.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public m0(PersonalizePageView personalizePageView) {
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
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.i.h() != null && (this.a.i.h().getTag() instanceof j37.r)) {
                ((j37.r) this.a.i.h().getTag()).onBackground(z);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(PersonalizePageView personalizePageView, int i) {
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
                nqa.c().h(true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public o0(PersonalizePageView personalizePageView) {
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
            this.a.N0();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue() && MainTabBottomDynamicIconManager.getInstance().canShowDynamicIcon() && this.a.f != null && this.a.f.l() == 0) {
                this.a.f.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
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
    public class q extends CustomMessageListener {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
                nqa.c().h(true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q0(PersonalizePageView personalizePageView, int i) {
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
            this.a.F0(customResponsedMessage.getData());
        }
    }

    /* loaded from: classes6.dex */
    public class r extends CustomRule {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(PersonalizePageView personalizePageView, int i) {
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
                    nqa.c().h(true);
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
                        this.a.h.W(data);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s implements bi8.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        @Override // com.baidu.tieba.bi8.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

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

        @Override // com.baidu.tieba.bi8.c
        public void a(ph8 ph8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, ph8Var) != null) {
                return;
            }
            this.a.y0(ph8Var);
        }
    }

    /* loaded from: classes6.dex */
    public class s0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yv4 a;
        public final /* synthetic */ PersonalizePageView b;

        public s0(PersonalizePageView personalizePageView, yv4 yv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, yv4Var};
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
            this.a = yv4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.c.E(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t implements PollingModel.d {
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

        @Override // com.baidu.tbadk.core.leveiconlivepolling.PollingModel.d
        public void onFail() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.n != null) {
                this.a.n.r0();
            }
        }

        @Override // com.baidu.tbadk.core.leveiconlivepolling.PollingModel.d
        public void onSuccess(List<AlaLiveInfo> list) {
            List<sb7<?>> c;
            boolean z;
            List<AlaLiveInfo> liveIndexSecondFloor;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                if (!ListUtils.isEmpty(list)) {
                    DefaultLog.getInstance().i("liveTipLog", "直播数据返回，发送event事件通知渲染直播tip");
                    br6.b().c(new xc8(list));
                }
                if (this.a.n != null && !LiveEnterForumTestHelper.forbidInsertLiveModel()) {
                    this.a.n.q0();
                }
                if (this.a.h != null && (c = this.a.h.c()) != null && c.size() > 0) {
                    Iterator<sb7<?>> it = c.iterator();
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
                        qm6 qm6Var = new qm6(null, liveIndexSecondFloor, "recommend");
                        u77 u77Var = new u77();
                        u77Var.a = qm6Var;
                        this.a.h.I(new tb7(new i37(u77Var), "ala_live_attention"), 0);
                    }
                }
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
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.C0();
        }
    }

    /* loaded from: classes6.dex */
    public class u implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MainTabBottomDynamicIconManager.getInstance().loadImages();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (!this.a.R) {
                        return;
                    }
                    this.a.R = false;
                    this.a.j1();
                } else if (this.a.F == null || this.a.F.getVisibility() != 0) {
                } else {
                    this.a.R = true;
                    this.a.C0();
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
                    layoutParams.bottomMargin = PersonalizePageView.P0 + this.a.G;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && this.a.i.h() != null && (this.a.i.h().getTag() instanceof j37.r)) {
                    ((j37.r) this.a.i.h().getTag()).onVolumeUp();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class w implements ec7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public w(PersonalizePageView personalizePageView) {
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

        @Override // com.baidu.tieba.ec7.a
        public void a(q67 q67Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, q67Var) != null) {
                return;
            }
            this.a.w = true;
            this.a.z0();
            if (q67Var.d == 0) {
                if (ListUtils.isEmpty(q67Var.a)) {
                    this.a.a.setRefreshing(false);
                    PersonalizePageView personalizePageView = this.a;
                    personalizePageView.i1(personalizePageView, q67Var.e, true);
                    this.a.H.r(false);
                    this.a.a.setVisibility(8);
                    this.a.f.O(8);
                } else {
                    this.a.r0(q67Var.b);
                    this.a.A0();
                    this.a.f.O(0);
                    if (q67Var.c) {
                        this.a.f1();
                    } else {
                        this.a.g1();
                    }
                }
                this.a.g.setList(q67Var.a);
                this.a.i.r();
                return;
            }
            this.a.a.setRefreshing(false);
            if (ListUtils.isEmpty(q67Var.a)) {
                PersonalizePageView personalizePageView2 = this.a;
                personalizePageView2.i1(personalizePageView2, q67Var.e, true);
                this.a.H.r(false);
                this.a.a.setVisibility(8);
                this.a.f.O(8);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class w0 implements jka.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

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

        @Override // com.baidu.tieba.jka.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && !z) {
                this.a.Z0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class x implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d85 a;
        public final /* synthetic */ PersonalizePageView b;

        public x(PersonalizePageView personalizePageView, d85 d85Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, d85Var};
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
            this.a = d85Var;
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
    public class x0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x0(PersonalizePageView personalizePageView, int i) {
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
                    this.a.h.D(customResponsedMessage);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class y implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d85 a;
        public final /* synthetic */ PersonalizePageView b;

        public y(PersonalizePageView personalizePageView, d85 d85Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, d85Var};
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
            this.a = d85Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.F.setHomePbFloatLastCloseTime();
                this.b.B0();
                this.b.F.t(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class y0 implements NEGFeedBackView.NEGFeedbackEventCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.NEGFeedbackEventCallback
        public void onCheckedChanged(NegativeFeedBackData negativeFeedBackData, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048576, this, negativeFeedBackData, compoundButton, z) == null) {
            }
        }

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
                this.a.O0();
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
    public class z implements p55.g {
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

        @Override // com.baidu.tieba.p55.g
        public void g(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048576, this, z) != null) {
                return;
            }
            this.a.D = true;
            c26.c().f("page_recommend");
            if (PersonalizePageView.O0) {
                this.a.h.f();
                if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    TiebaStatic.log(new StatisticItem("c11032").param("obj_source", 1));
                }
                this.a.i.p(false);
                this.a.X0();
                return;
            }
            this.a.o0();
            this.a.n.d1(false);
        }
    }

    /* loaded from: classes6.dex */
    public class z0 implements FollowUserButton.a {
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

        @Override // com.baidu.tbadk.core.view.FollowUserButton.a
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || view2 == null) {
                return;
            }
            Object tag = view2.getTag();
            if (tag instanceof ThreadData) {
                TiebaStatic.log(nua.m("c13696", (ThreadData) tag));
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
        O0 = K0();
        P0 = UtilHelper.getDimenPixelSize(R.dimen.tbds437);
    }

    public static boolean K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            a2b.b().n(d1.a);
            return d1.a;
        }
        return invokeV.booleanValue;
    }

    public final void A0() {
        fk5 fk5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (fk5Var = this.s) != null) {
            fk5Var.dettachView(this);
            this.s = null;
        }
    }

    public void B0() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (rightFloatLayerView = this.F) != null) {
            rightFloatLayerView.c();
        }
    }

    public final void C0() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (rightFloatLayerView = this.F) != null) {
            rightFloatLayerView.setAutoCompleteShown(false);
            this.F.clearAnimation();
            this.F.setVisibility(8);
        }
    }

    public void G0() {
        c1 c1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (c1Var = this.e) != null) {
            c1Var.a(this.A0);
            this.e.b(this.B0);
            this.e.c(this.C0);
            this.e.e(this.D0);
        }
    }

    public final void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.L = true;
            d85 homeAdFloatViewItemData = TbSingleton.getInstance().getHomeAdFloatViewItemData();
            if (homeAdFloatViewItemData != null && !homeAdFloatViewItemData.a()) {
                o1(homeAdFloatViewItemData);
            }
        }
    }

    public final boolean L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            fk5 fk5Var = this.s;
            if (fk5Var != null) {
                return fk5Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void O0() {
        zc8 zc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (zc8Var = this.H) != null) {
            zc8Var.f();
        }
    }

    public void P0() {
        xf8 xf8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (xf8Var = this.n) != null) {
            xf8Var.A0();
        }
    }

    public void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            gh8 gh8Var = this.k;
            if (gh8Var != null) {
                gh8Var.n();
            }
            O0();
        }
    }

    public void T0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            xf8 xf8Var = this.n;
            if (xf8Var != null) {
                xf8Var.M0();
            }
            gh8 gh8Var = this.k;
            if (gh8Var != null) {
                gh8Var.q();
            }
            RightFloatLayerView rightFloatLayerView = this.F;
            if (rightFloatLayerView != null && (rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                ((RightFloatLayerLottieView) rightFloatLayerView).G(600);
            }
        }
    }

    public final void X0() {
        PollingModel pollingModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (pollingModel = this.f1104T) != null) {
            pollingModel.getData("live,level,icon,festival_info,live_follow_second_floor,member_broadcast,activity_broadcast,live_index_second_floor");
        }
    }

    @Override // com.baidu.tieba.kv5
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

    public void a1() {
        xf8 xf8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (xf8Var = this.n) != null) {
            xf8Var.Y0();
        }
    }

    public void b1() {
        xf8 xf8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && (xf8Var = this.n) != null) {
            xf8Var.h1();
        }
    }

    public final void f1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.f.U();
            this.f.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f.w(BdUtilHelper.getDimens(getContext(), R.dimen.tbds150));
        }
    }

    public final void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.f.h();
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

    public void j1() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && (rightFloatLayerView = this.F) != null) {
            rightFloatLayerView.d();
        }
    }

    public void n0() {
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048618, this) == null) && (bigdaySwipeRefreshLayout = this.a) != null) {
            bigdaySwipeRefreshLayout.r();
        }
    }

    public final void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            p0(false);
        }
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            if (this.s != null) {
                Z0();
            } else if (this.n != null) {
                o0();
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
        this.W = new k(this);
        this.a0 = new v(this, 2921553);
        this.b0 = new g0(this, 2001438);
        this.c0 = new r0(this, 2001437);
        this.d0 = new x0(this, 2016331);
        this.e0 = new y0(this);
        this.f0 = new z0(this);
        this.h0 = -1;
        this.i0 = new a1(this);
        this.j0 = new b1(this);
        this.r0 = new j(this);
        this.s0 = new l(this, 2001371);
        this.t0 = new m(this, 2921736);
        this.u0 = new n(this, 2921822);
        this.v0 = new o(this);
        this.w0 = new p(this, 2921551);
        this.x0 = new q(this, 2001222);
        this.y0 = new r(this, 2002001);
        this.z0 = new w(this);
        this.A0 = new z(this);
        this.B0 = new a0(this);
        this.C0 = new b0(this);
        this.D0 = new c0(this);
        this.E0 = new l0(this);
        this.F0 = new m0(this);
        this.G0 = new n0(this, 2001118);
        this.H0 = new o0(this);
        this.I0 = new p0(this, 2921033);
        this.J0 = new q0(this, 2921349);
        this.K0 = new t0(this, 2921664);
        this.L0 = new u0(this, 2921667);
        this.M0 = new v0(this, 2921381);
        this.N0 = new w0(this);
        I0(context);
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
        this.W = new k(this);
        this.a0 = new v(this, 2921553);
        this.b0 = new g0(this, 2001438);
        this.c0 = new r0(this, 2001437);
        this.d0 = new x0(this, 2016331);
        this.e0 = new y0(this);
        this.f0 = new z0(this);
        this.h0 = -1;
        this.i0 = new a1(this);
        this.j0 = new b1(this);
        this.r0 = new j(this);
        this.s0 = new l(this, 2001371);
        this.t0 = new m(this, 2921736);
        this.u0 = new n(this, 2921822);
        this.v0 = new o(this);
        this.w0 = new p(this, 2921551);
        this.x0 = new q(this, 2001222);
        this.y0 = new r(this, 2002001);
        this.z0 = new w(this);
        this.A0 = new z(this);
        this.B0 = new a0(this);
        this.C0 = new b0(this);
        this.D0 = new c0(this);
        this.E0 = new l0(this);
        this.F0 = new m0(this);
        this.G0 = new n0(this, 2001118);
        this.H0 = new o0(this);
        this.I0 = new p0(this, 2921033);
        this.J0 = new q0(this, 2921349);
        this.K0 = new t0(this, 2921664);
        this.L0 = new u0(this, 2921667);
        this.M0 = new v0(this, 2921381);
        this.N0 = new w0(this);
        I0(context);
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
        this.W = new k(this);
        this.a0 = new v(this, 2921553);
        this.b0 = new g0(this, 2001438);
        this.c0 = new r0(this, 2001437);
        this.d0 = new x0(this, 2016331);
        this.e0 = new y0(this);
        this.f0 = new z0(this);
        this.h0 = -1;
        this.i0 = new a1(this);
        this.j0 = new b1(this);
        this.r0 = new j(this);
        this.s0 = new l(this, 2001371);
        this.t0 = new m(this, 2921736);
        this.u0 = new n(this, 2921822);
        this.v0 = new o(this);
        this.w0 = new p(this, 2921551);
        this.x0 = new q(this, 2001222);
        this.y0 = new r(this, 2002001);
        this.z0 = new w(this);
        this.A0 = new z(this);
        this.B0 = new a0(this);
        this.C0 = new b0(this);
        this.D0 = new c0(this);
        this.E0 = new l0(this);
        this.F0 = new m0(this);
        this.G0 = new n0(this, 2001118);
        this.H0 = new o0(this);
        this.I0 = new p0(this, 2921033);
        this.J0 = new q0(this, 2921349);
        this.K0 = new t0(this, 2921664);
        this.L0 = new u0(this, 2921667);
        this.M0 = new v0(this, 2921381);
        this.N0 = new w0(this);
        I0(context);
    }

    public static /* synthetic */ int b0(PersonalizePageView personalizePageView) {
        int i2 = personalizePageView.B + 1;
        personalizePageView.B = i2;
        return i2;
    }

    public final boolean J0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
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

    public boolean M0(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, recyclerView)) == null) {
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

    public boolean Y0(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, recyclerView)) == null) {
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
                V0();
            }
        }
    }

    public final void p0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z2) == null) {
            xf8 xf8Var = this.n;
            if (xf8Var != null) {
                xf8Var.j1(z2);
            }
            X0();
        }
    }

    public void q0(Long l2) {
        xf8 xf8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048624, this, l2) == null) && (xf8Var = this.n) != null) {
            xf8Var.b0(l2);
        }
    }

    public void setCallback(cd8 cd8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, cd8Var) == null) {
            this.m = cd8Var;
        }
    }

    public void setFragmentUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, bdUniqueId) == null) {
            this.V = bdUniqueId;
        }
    }

    public void setScrollFragmentTabHost(dd8 dd8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, dd8Var) == null) {
            this.g0 = dd8Var;
            if (dd8Var != null) {
                dd8Var.e(this.j0);
                this.g0.b(this.j0);
            }
            xf8 xf8Var = this.n;
            if (xf8Var != null) {
                xf8Var.f1(dd8Var);
            }
        }
    }

    public void setTabInForeBackgroundState(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z2) == null) {
            if (O0) {
                this.i.n(z2);
                return;
            }
            xf8 xf8Var = this.n;
            if (xf8Var != null) {
                xf8Var.g1(z2);
            }
        }
    }

    public void setViewForeground(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048633, this, z2) == null) {
            xf8 xf8Var = this.n;
            if (xf8Var != null) {
                xf8Var.N0(z2);
            }
            dd8 dd8Var = this.g0;
            if (dd8Var != null) {
                dd8Var.e(this.j0);
                this.g0.b(this.j0);
                this.j0.b();
            }
        }
    }

    public static /* synthetic */ int P(PersonalizePageView personalizePageView, int i2) {
        int i3 = personalizePageView.C + i2;
        personalizePageView.C = i3;
        return i3;
    }

    public void n1(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048619, this, str, i2) == null) {
            UiUtils.runOnUiThread(new j0(this));
            xf8 xf8Var = this.n;
            if (xf8Var != null) {
                xf8Var.K0(true, false, null, i2, str);
            }
        }
    }

    public synchronized void D0(Context context) {
        yv4 yv4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            synchronized (this) {
                if (this.I) {
                    return;
                }
                this.I = true;
                Context context2 = getContext();
                if (context2 instanceof ur6) {
                    ((ur6) context2).setBaseContext(context);
                }
                MessageManager.getInstance().registerListener(this.t0);
                MessageManager.getInstance().registerListener(this.s0);
                MessageManager.getInstance().registerListener(this.a0);
                MessageManager.getInstance().registerListener(this.J0);
                MessageManager.getInstance().registerListener(this.I0);
                MessageManager.getInstance().registerListener(this.K0);
                MessageManager.getInstance().registerListener(this.L0);
                MessageManager.getInstance().registerListener(this.u0);
                MessageManager.getInstance().registerListener(this.w0);
                MessageManager.getInstance().registerListener(this.b0);
                MessageManager.getInstance().registerListener(this.c0);
                MessageManager.getInstance().registerListener(this.d0);
                if (O0) {
                    MessageManager.getInstance().registerListener(this.M0);
                }
                MessageManager.getInstance().registerListener(this.x0);
                this.y0.setPriority(-1);
                MessageManager.getInstance().addMessageRule(this.y0);
                BdPageContext<?> a2 = a5.a(context);
                if (a2 instanceof TbPageContext) {
                    this.l = (TbPageContext) a2;
                }
                this.H.p(this.l);
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > SharedPrefHelper.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    yv4Var = zv4.i().h(1);
                } else {
                    yv4Var = null;
                }
                try {
                    F0(yv4Var);
                } catch (Exception unused) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, yv4Var));
                }
                this.o = new sf8(this.l);
                this.o.b().q(new s(this));
                this.p = new di8();
                if (O0) {
                    if (v27.a.getBaseContext() == null) {
                        v27.a.a(TbadkCoreApplication.getInst());
                    }
                    FeedTemplateAdapter feedTemplateAdapter = new FeedTemplateAdapter();
                    this.g = feedTemplateAdapter;
                    feedTemplateAdapter.j(new hd7());
                    this.g.j(new pb7());
                    ib7 ib7Var = this.g;
                    b37 b37Var = new b37(2);
                    b37Var.c(this.l);
                    b37Var.b("INDEX");
                    ib7Var.j(b37Var);
                    this.g.j(new f37(q88.g(), "personalize", null, null));
                    this.g.e(this.b);
                    jka jkaVar = new jka(this.l.getPageActivity());
                    this.h = jkaVar;
                    jkaVar.h(this.z0);
                    this.h.S(this.N0);
                    AutoPlayController autoPlayController = new AutoPlayController(a2, this.b);
                    this.i = autoPlayController;
                    autoPlayController.o(this.F0);
                    this.j = new kka(this.h);
                    xha.n();
                } else {
                    gh8 gh8Var = new gh8(context, this.b);
                    this.k = gh8Var;
                    gh8Var.z(this.p);
                    this.k.x(this.W);
                    this.k.u(this.o);
                    xf8 xf8Var = new xf8(this.l, this.b, this.k, this.a, this);
                    this.n = xf8Var;
                    xf8Var.Z0(this.o);
                }
                PollingModel pollingModel = new PollingModel(this.l, this.U);
                this.f1104T = pollingModel;
                pollingModel.setDialogTime(y05.d);
                this.f1104T.setLiveIndexSecondFloorCallback(new t(this));
                R0(TbadkCoreApplication.getInst().getSkinType());
                this.B = SharedPrefHelper.getInstance().getInt("show_is_uninterest_tag", 0);
                if (!MainTabBottomDynamicIconManager.getInstance().checkIsHasShowIcon()) {
                    SafeHandler.getInst().post(new u(this));
                }
            }
        }
    }

    public void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            gh8 gh8Var = this.k;
            if (gh8Var != null) {
                gh8Var.w(this.e0);
                this.k.t(this.f0);
            }
            xf8 xf8Var = this.n;
            if (xf8Var != null) {
                xf8Var.c1(this.v0);
            }
            G0();
            this.b.addOnScrollListener(new d0(this));
            this.b.setOnSrollToBottomListener(new e0(this));
            this.b.setOnScrollStopDelayedListener(new f0(this), 1L);
            this.b.setRecyclerListener(new h0(this));
            this.b.removeOnScrollListener(this.i0);
            this.b.addOnScrollListener(this.i0);
            lv5.b().a(this);
        }
    }

    public final void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            bd8.d().j(System.currentTimeMillis(), 1);
            PbListView pbListView = this.f;
            if (pbListView != null && !pbListView.p()) {
                this.f.U();
                this.f.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            if (O0) {
                this.h.g();
                if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    TiebaStatic.log(new StatisticItem("c11032").param("obj_source", 2));
                }
                if (M0(this.b)) {
                    this.q = System.currentTimeMillis();
                    return;
                }
                return;
            }
            this.n.D0();
        }
    }

    public void Z0() {
        jka jkaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (O0) {
                if (this.s != null && (jkaVar = this.h) != null) {
                    jkaVar.f();
                    X0();
                    return;
                }
            } else {
                xf8 xf8Var = this.n;
                if (xf8Var != null && xf8Var.m0() != null) {
                    this.n.m0().e();
                }
                if (this.s != null && this.n != null) {
                    o0();
                    return;
                }
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.b;
            if (bdTypeRecyclerView != null && this.a != null) {
                bdTypeRecyclerView.setSelection(0);
                if (!this.a.t()) {
                    if (O0) {
                        this.i.p(false);
                    } else {
                        xf8 xf8Var2 = this.n;
                        if (xf8Var2 != null && xf8Var2.k0() != null) {
                            this.n.k0().y();
                            this.n.d1(false);
                        }
                    }
                    this.a.setRefreshing(true);
                }
                ScrollFragmentTabHost.s sVar = this.j0;
                if (sVar != null) {
                    sVar.b();
                }
            }
        }
    }

    public void setViewForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            setViewForeground(false);
            if (O0) {
                this.i.k(false);
            } else {
                xf8 xf8Var = this.n;
                if (xf8Var != null) {
                    xf8Var.G0(false);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            if (this.B < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
                SafeHandler.getInst().postDelayed(this.E0, 1000L);
            }
            if (ji8.a.a()) {
                Z0();
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_type", "HomeHotReloadHelper").param("obj_param1", System.currentTimeMillis()));
            }
        }
    }

    public final void F0(Object obj) {
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, obj) == null) && (bigdaySwipeRefreshLayout = this.a) != null && !bigdaySwipeRefreshLayout.t()) {
            if (obj != null && (obj instanceof yv4)) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                hh8 hh8Var = this.d;
                if (hh8Var == null) {
                    hh8 hh8Var2 = new hh8(this.l);
                    this.d = hh8Var2;
                    hh8Var2.D(this.u);
                    this.e = this.d;
                    G0();
                } else if (this.e == hh8Var) {
                    return;
                } else {
                    this.e = hh8Var;
                }
                this.d.w(true);
                this.a.setProgressView(this.d);
                int i2 = (int) (getResources().getDisplayMetrics().density * 86.0f);
                this.a.setCustomDistances(i2, i2, i2 * 2);
                return;
            }
            yv4 yv4Var = (yv4) obj;
            ih8 ih8Var = this.c;
            if (ih8Var == null) {
                ih8 ih8Var2 = new ih8(this.l.getContext());
                this.c = ih8Var2;
                this.e = ih8Var2;
                G0();
            } else if (this.e == ih8Var && yv4Var.equals(ih8Var.B())) {
                return;
            } else {
                this.e = this.c;
            }
            this.c.w(true);
            this.a.setProgressView(this.c);
            UiUtils.runOnUiThread(new s0(this, yv4Var));
            this.a.setCustomDistances((int) getResources().getDimension(R.dimen.tbds236), (int) (BdUtilHelper.getEquipmentHeight(this.l.getContext()) * 0.8d), BdUtilHelper.getEquipmentHeight(this.l.getContext()));
        }
    }

    public final void I0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = new BdTypeRecyclerView(context);
            this.b = bdTypeRecyclerView;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(bdTypeRecyclerView.getContext());
            this.E = linearLayoutManager;
            this.b.setLayoutManager(linearLayoutManager);
            this.b.setFadingEdgeLength(0);
            this.b.setOverScrollMode(2);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.b.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            am6 am6Var = new am6(context);
            this.A = am6Var;
            am6Var.setFrom("from_personaize");
            this.A.a().setVisibility(0);
            this.A.a().setOnClickListener(this.r0);
            zc8 zc8Var = new zc8(this, this.b);
            this.H = zc8Var;
            zc8Var.q(context.getString(R.string.obfuscated_res_0x7f0f161d));
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = new BigdaySwipeRefreshLayout(context);
            this.a = bigdaySwipeRefreshLayout;
            bigdaySwipeRefreshLayout.addView(this.b);
            PbListView pbListView = new PbListView(context);
            this.f = pbListView;
            pbListView.c();
            this.f.s(R.color.transparent);
            this.f.B();
            this.f.J(SkinManager.getColor(R.color.CAM_X0107));
            this.f.L(R.dimen.tbfontsize33);
            this.f.F(R.color.CAM_X0110);
            this.f.w(BdUtilHelper.getDimens(context, R.dimen.tbds182));
            this.f.G(this.H0);
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
        if (interceptable == null || interceptable.invokeL(1048629, this, bdUniqueId) == null) {
            this.V = bdUniqueId;
            if (O0) {
                this.g.d(new a(this, new fla(new ela(), bdUniqueId), bdUniqueId));
                ib7 ib7Var = this.g;
                dla dlaVar = new dla();
                dlaVar.d("1");
                ib7Var.b(new cla(dlaVar, bdUniqueId));
                this.i.q(bdUniqueId);
                this.h.T(bdUniqueId);
            }
            gh8 gh8Var = this.k;
            if (gh8Var != null) {
                gh8Var.y(bdUniqueId);
            }
            xf8 xf8Var = this.n;
            if (xf8Var != null) {
                xf8Var.U0(bdUniqueId);
            }
            di8 di8Var = this.p;
            if (di8Var != null) {
                di8Var.a(bdUniqueId);
            }
            hh8 hh8Var = this.d;
            if (hh8Var != null) {
                hh8Var.W(bdUniqueId);
            }
            zv4.i().n(bdUniqueId);
            CustomMessageListener customMessageListener = this.G0;
            if (customMessageListener != null) {
                customMessageListener.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.G0);
            }
            br6.b().b(new ar6(bdUniqueId, w95.class), new b(this, w95.class));
            br6.b().b(new ar6(bdUniqueId, z95.class), new c(this, z95.class));
            br6.b().b(new ar6(bdUniqueId, x95.class), new d(this, x95.class));
            br6.b().b(new ar6(bdUniqueId, v95.class), new e(this, v95.class));
            br6.b().b(new ar6(bdUniqueId, dka.class), new f(this, dka.class));
            br6.b().b(new ar6(bdUniqueId, eka.class), new g(this, eka.class));
            br6.b().b(new ar6(bdUniqueId, t95.class), new h(this, t95.class));
            br6.b().b(new ar6(bdUniqueId, sh5.class), new i(this, sh5.class));
        }
    }

    public void R0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            if (this.u != i2) {
                LoadingView loadingView = this.r;
                if (loadingView != null) {
                    loadingView.onChangeSkinType();
                }
                fk5 fk5Var = this.s;
                if (fk5Var != null) {
                    fk5Var.onChangeSkinType();
                }
                hh8 hh8Var = this.d;
                if (hh8Var != null) {
                    hh8Var.D(i2);
                }
                PbListView pbListView = this.f;
                if (pbListView != null) {
                    pbListView.J(SkinManager.getColor(R.color.CAM_X0109));
                    this.f.e(i2);
                }
                gh8 gh8Var = this.k;
                if (gh8Var != null) {
                    gh8Var.o(i2);
                }
                xf8 xf8Var = this.n;
                if (xf8Var != null) {
                    xf8Var.I0(i2);
                }
                am6 am6Var = this.A;
                if (am6Var != null) {
                    am6Var.d(i2);
                }
                RightFloatLayerView rightFloatLayerView = this.F;
                if (rightFloatLayerView != null) {
                    rightFloatLayerView.n();
                }
                zc8 zc8Var = this.H;
                if (zc8Var != null) {
                    zc8Var.o();
                }
                vb5 vb5Var = this.S;
                if (vb5Var != null) {
                    vb5Var.u();
                }
                ib7 ib7Var = this.g;
                if (ib7Var != null) {
                    ib7Var.f();
                }
            }
            this.u = i2;
        }
    }

    public final void h1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z2) == null) {
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

    public final boolean o1(d85 d85Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, d85Var)) == null) {
            if (!RightFloatLayerView.k()) {
                B0();
                return false;
            } else if (d85Var == null) {
                return false;
            } else {
                if (this.F == null) {
                    RightFloatLayerView E = RightFloatLayerLottieView.E(d85Var, getContext());
                    this.F = E;
                    E.setPageContext(this.l);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 85;
                    layoutParams.bottomMargin = P0 + this.G;
                    this.F.c();
                    addView(this.F, layoutParams);
                }
                this.F.setAutoCompleteShown(true);
                if (d85Var.a()) {
                    return false;
                }
                this.F.setData(d85Var);
                this.F.setLogoListener(new x(this, d85Var));
                this.F.setFeedBackListener(new y(this, d85Var));
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final void x0(u67 u67Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048638, this, u67Var) != null) || u67Var == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.NEG_FEEDBACK_KEY).param("obj_locate", "1").param("fid", u67Var.d()).param("tid", u67Var.h()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("nid", u67Var.e()));
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.NEGATIVE_FEEDBACK_OPEN_CLICK).param("obj_locate", "1").param("fid", u67Var.d()).param("tid", u67Var.h()).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public final void y0(ph8 ph8Var) {
        List<sb7<?>> c2;
        int t02;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, ph8Var) == null) {
            xf8 xf8Var = this.n;
            if (xf8Var != null) {
                xf8Var.p0(ph8Var);
            }
            if (this.h != null) {
                int firstVisiblePosition = this.b.getFirstVisiblePosition();
                RecommendBarCardModel d2 = RecommendBarCardModel.d(ph8Var);
                if (d2 != null && (c2 = this.h.c()) != null && (t02 = t0(ph8Var.b(), c2)) >= 0 && (i2 = t02 + 1) >= 0 && i2 <= c2.size() && i2 > firstVisiblePosition) {
                    d2.o(ph8Var.b());
                    d2.q(RecommendBarCardModel.RecDataSource.FORUMBACKCONCERN);
                    this.h.I(new tb7(new i37(new u77(d2)), "recommend_bar_layout"), i2);
                    sf8 sf8Var = this.o;
                    if (sf8Var != null) {
                        sf8Var.c();
                        xf8.t0(ph8Var.a());
                    }
                }
            }
        }
    }

    public void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.t0);
            MessageManager.getInstance().unRegisterListener(this.s0);
            MessageManager.getInstance().unRegisterListener(this.I0);
            MessageManager.getInstance().unRegisterListener(this.J0);
            MessageManager.getInstance().unRegisterListener(this.a0);
            MessageManager.getInstance().unRegisterListener(this.K0);
            MessageManager.getInstance().unRegisterListener(this.L0);
            MessageManager.getInstance().unRegisterListener(this.w0);
            MessageManager.getInstance().unRegisterListener(this.u0);
            MessageManager.getInstance().unRegisterListener(this.b0);
            MessageManager.getInstance().unRegisterListener(this.c0);
            MessageManager.getInstance().unRegisterListener(this.d0);
            if (O0) {
                MessageManager.getInstance().unRegisterListener(this.M0);
                this.h.a();
                this.j.c();
            }
            if (O0) {
                this.i.l();
            }
            xf8 xf8Var = this.n;
            if (xf8Var != null) {
                xf8Var.J0();
            }
            PollingModel pollingModel = this.f1104T;
            if (pollingModel != null) {
                pollingModel.onDestroy();
            }
            gh8 gh8Var = this.k;
            if (gh8Var != null) {
                gh8Var.w(null);
                this.k.p();
            }
            MessageManager.getInstance().unRegisterListener(this.x0);
            MessageManager.getInstance().removeMessageRule(this.y0);
            this.I = false;
            xf8 xf8Var2 = this.n;
            if (xf8Var2 != null) {
                xf8Var2.c1(null);
            }
            ih8 ih8Var = this.c;
            if (ih8Var != null) {
                ih8Var.a(null);
                this.c.b(null);
                this.c.c(null);
                this.c.e(null);
                this.c.C();
            }
            hh8 hh8Var = this.d;
            if (hh8Var != null) {
                hh8Var.a(null);
                this.d.b(null);
                this.d.c(null);
                this.d.e(null);
                this.d.U();
            }
            this.b.setOnSrollToBottomListener(null);
            dd8 dd8Var = this.g0;
            if (dd8Var != null) {
                dd8Var.e(this.j0);
            }
            this.b.removeOnScrollListener(this.i0);
            LoadingView loadingView = this.r;
            if (loadingView != null) {
                loadingView.release();
            }
            this.b.setRecyclerListener(null);
            zv4.i().e();
            SafeHandler.getInst().removeCallbacks(this.E0);
            lv5.b().d(this);
        }
    }

    public void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.v) {
                Z0();
                this.v = false;
            }
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.a;
            if (bigdaySwipeRefreshLayout != null) {
                bigdaySwipeRefreshLayout.D();
            }
            gh8 gh8Var = this.k;
            if (gh8Var != null) {
                gh8Var.r();
            }
            if (!RightFloatLayerView.k()) {
                C0();
            }
            p1();
            if (!O0 && nqa.c().e()) {
                nqa.c().h(false);
                DefaultLog.getInstance().i("RecentForumLog", "首页刷新最近逛的吧");
                xf8 xf8Var = this.n;
                if (xf8Var != null) {
                    xf8Var.T0();
                }
            }
        }
    }

    public void W0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (O0) {
                this.i.k(true);
            } else {
                xf8 xf8Var = this.n;
                if (xf8Var != null) {
                    xf8Var.G0(true);
                }
            }
            vb5 vb5Var = this.S;
            if (vb5Var != null) {
                vb5Var.o();
            }
            em6.b().d(false);
            c26.c().h("page_recommend", "show_");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            SafeHandler.getInst().removeCallbacks(this.E0);
            ji8.a.b();
        }
    }

    public final void p1() {
        ThreadCardViewHolder threadCardViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            for (int i2 = 0; i2 < this.b.getChildCount(); i2++) {
                View childAt = this.b.getChildAt(i2);
                if ((childAt instanceof ThreadCardView) && (childAt.getTag() instanceof ThreadCardViewHolder) && (threadCardViewHolder = (ThreadCardViewHolder) childAt.getTag()) != null && threadCardViewHolder.a() != null && (threadCardViewHolder.a().f() instanceof eu)) {
                    ((eu) threadCardViewHolder.a().f()).P();
                }
            }
        }
    }

    public final void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (!this.y) {
                long f2 = bd8.d().f(1) + bd8.d().b();
                long a2 = bd8.d().a(1);
                if (a2 > 0) {
                    f2 = System.currentTimeMillis() - a2;
                }
                xp5 xp5Var = new xp5();
                xp5Var.a();
                xp5Var.b();
                vp5.a().n(f2);
                if (this.x > 0) {
                    vp5.a().D(System.currentTimeMillis() - this.x);
                }
                vp5.a().H(xp5Var.c());
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.SECOND_DRAW_DISPATCH_STAMP_KEY);
                if (!MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW && !this.M) {
                    this.M = true;
                    SpeedStats.getInstance().onMainPageStatsEnd(getContext());
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921637, ""));
                if (O0) {
                    qua.g().h(this.V, false);
                }
            }
            this.y = true;
        }
    }

    public void e1() {
        Uri data;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            if (vh5.b.a().a("show_reply_tip") || vh5.b.a().a("show_agree_tip")) {
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
                    if (!StringUtils.isNull(optString) && !StringUtils.isNull(this.O) && SharedPrefHelper.getInstance().getBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount(je7.a(this.P, this.O)), true)) {
                        k1(this.P, this.O);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
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
            cd8 cd8Var = this.m;
            if (cd8Var != null) {
                cd8Var.b();
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

    @Override // com.baidu.tieba.kv5
    @Nullable
    public mv5 b(@NonNull String str, @Nullable String str2) {
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
                                pi piVar = this.b.getData().get(findFirstVisibleItemPosition);
                                if (piVar instanceof sh8) {
                                    return v0(str2, findFirstVisibleItemPosition, (sh8) piVar);
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
        return (mv5) invokeLL.objValue;
    }

    public final void d1(String str, String str2) {
        ThreadCardViewHolder threadCardViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, str, str2) == null) {
            for (int i2 = 0; i2 < this.b.getChildCount(); i2++) {
                View childAt = this.b.getChildAt(i2);
                if ((childAt instanceof ThreadCardView) && (childAt.getTag() instanceof ThreadCardViewHolder) && (threadCardViewHolder = (ThreadCardViewHolder) childAt.getTag()) != null && threadCardViewHolder.a() != null && (threadCardViewHolder.a().f() instanceof eu)) {
                    if (vh5.b.a().a("show_reply_tip") && "home_reply".equals(str2)) {
                        ((eu) threadCardViewHolder.a().f()).O();
                    } else if (vh5.b.a().a("show_agree_tip") && "home_agree".equals(str2)) {
                        ((eu) threadCardViewHolder.a().f()).N();
                    }
                    SharedPrefHelper.getInstance().putBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount(je7.a(str, str2)), false);
                    return;
                }
            }
        }
    }

    public final void i1(View view2, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048613, this, view2, str, z2) == null) {
            if (this.s == null) {
                this.s = new fk5(getContext(), new k0(this));
            }
            this.s.attachView(view2, z2);
            this.s.q();
            fp5.a.a(this.V, new Pair<>(PushMessageHelper.ERROR_TYPE, "home_recommend"), new Pair<>("error_info", "home recommend net error"));
            xoa.a("main", false);
        }
    }

    @NonNull
    public final mv5 v0(@Nullable String str, int i2, @NonNull sh8 sh8Var) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048636, this, str, i2, sh8Var)) == null) {
            mv5 b2 = mv5.b();
            if (this.b == null) {
                return b2;
            }
            if (rd.isEmpty(str)) {
                return u0(this.b.getChildAt(i2));
            }
            View view2 = null;
            if (nh8.a(str).b().equals(sh8Var.a)) {
                view2 = this.b.getChildAt(i2);
            }
            return u0(view2);
        }
        return (mv5) invokeLIL.objValue;
    }

    public void k1(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048615, this, str, str2) != null) || this.b == null) {
            return;
        }
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.a;
        if (bigdaySwipeRefreshLayout != null && bigdaySwipeRefreshLayout.t()) {
            this.a.r();
        }
        int i2 = -1;
        gh8 gh8Var = this.k;
        if (gh8Var == null) {
            return;
        }
        List<pi> k2 = gh8Var.k();
        if (!ListUtils.isEmpty(k2)) {
            int i3 = 0;
            while (true) {
                if (i3 >= k2.size()) {
                    break;
                } else if (k2.get(i3) instanceof dn6) {
                    i2 = i3;
                    break;
                } else {
                    i3++;
                }
            }
        }
        View childAt = this.b.getChildAt(i2);
        if (i2 >= 0 && childAt != null && J0(i2)) {
            int[] iArr = new int[2];
            this.b.getLocationOnScreen(iArr);
            int i4 = iArr[1];
            int[] iArr2 = new int[2];
            childAt.getLocationOnScreen(iArr2);
            int i5 = iArr2[1];
            if (i5 == i4) {
                d1(str, str2);
                return;
            }
            this.Q = true;
            this.b.smoothScrollBy(0, i5 - i4);
            return;
        }
        this.Q = true;
        this.b.smoothScrollToPosition(i2);
    }

    public void l1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z2) == null) {
            if (O0) {
                this.h.f();
                h1(true);
                X0();
            } else {
                p0(z2);
            }
            if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
                zv4.i().j();
                zv4.i().k();
            }
        }
    }

    public void m1(DataRes dataRes, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{dataRes, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            UiUtils.runOnUiThread(new i0(this));
            xf8 xf8Var = this.n;
            if (xf8Var != null) {
                xf8Var.K0(z2, z3, dataRes, 0, null);
            }
        }
    }

    public final void r0(int i2) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
            if (this.a.u() && !PermissionUtil.isBrowseMode()) {
                if (i2 > 0) {
                    string = String.format(this.l.getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i2));
                } else {
                    string = this.l.getString(R.string.recommend_frs_refresh_nodata);
                }
                this.a.z(new p55.i(string, 0));
                return;
            }
            this.a.setRefreshing(false);
        }
    }

    public final mv5 u0(@Nullable View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, view2)) == null) {
            mv5 b2 = mv5.b();
            if (getContext() != null && view2 != null) {
                Rect rect = new Rect();
                view2.getGlobalVisibleRect(rect);
                if (rect.left <= BdUtilHelper.getEquipmentWidth(getContext()) && rect.right >= 0) {
                    int i2 = rect.left;
                    int i3 = rect.top;
                    return new mv5(true, i2, i3, rect.right - i2, rect.bottom - i3);
                }
            }
            return b2;
        }
        return (mv5) invokeL.objValue;
    }

    public final int t0(@NonNull String str, @NonNull List<sb7<?>> list) {
        InterceptResult invokeLL;
        w57<?> w57Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048634, this, str, list)) == null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb7<?> sb7Var = list.get(i2);
                if ((sb7Var instanceof n57) && (w57Var = ((n57) sb7Var).c) != null && str.equals(w57Var.m())) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public final void w0(List<Integer> list, String str, u67 u67Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048637, this, list, str, u67Var) == null) && list != null && u67Var != null) {
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
            if (u67Var.g() == 0) {
                i2 = 1;
            } else if (u67Var.g() == 40) {
                i2 = 2;
            } else if (u67Var.g() == 49 || u67Var.g() == 69) {
                i2 = 3;
            }
            gh8 gh8Var = this.k;
            if (gh8Var != null) {
                gh8Var.n();
            }
            O0();
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.NEG_FEEDBACK_KEY).param("tid", u67Var.h()).param("nid", u67Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", u67Var.d()).param("obj_param1", u67Var.i()).param("obj_source", u67Var.f()).param("obj_id", u67Var.a()).param("obj_type", sb.toString()).param("obj_name", str).param(TiebaStatic.Params.OBJ_PARAM2, i2).param("obj_locate", "1"));
        }
    }
}
