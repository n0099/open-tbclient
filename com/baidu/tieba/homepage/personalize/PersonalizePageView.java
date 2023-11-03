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
import com.baidu.tbadk.coreExtra.util.PushOpenUtil;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.loading.LoadingView;
import com.baidu.tbadk.mainTab.dynamicIcon.MainTabBottomDynamicIconManager;
import com.baidu.tbadk.switchs.BigdaySwitch;
import com.baidu.tbadk.widget.RightFloatLayerLottieView;
import com.baidu.tbadk.widget.RightFloatLayerView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.a5;
import com.baidu.tieba.aa8;
import com.baidu.tieba.ab7;
import com.baidu.tieba.af8;
import com.baidu.tieba.b67;
import com.baidu.tieba.ba8;
import com.baidu.tieba.bm6;
import com.baidu.tieba.c67;
import com.baidu.tieba.c77;
import com.baidu.tieba.de8;
import com.baidu.tieba.dga;
import com.baidu.tieba.du;
import com.baidu.tieba.e57;
import com.baidu.tieba.ee8;
import com.baidu.tieba.efa;
import com.baidu.tieba.ega;
import com.baidu.tieba.f55;
import com.baidu.tieba.fe8;
import com.baidu.tieba.feed.list.FeedTemplateAdapter;
import com.baidu.tieba.ffa;
import com.baidu.tieba.fga;
import com.baidu.tieba.fr6;
import com.baidu.tieba.g27;
import com.baidu.tieba.gba;
import com.baidu.tieba.gf8;
import com.baidu.tieba.gga;
import com.baidu.tieba.homepage.concern.data.RecommendBarCardModel;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.adapter.HomePageCardVideoViewHolder;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.ih5;
import com.baidu.tieba.ip5;
import com.baidu.tieba.k95;
import com.baidu.tieba.ke8;
import com.baidu.tieba.kfa;
import com.baidu.tieba.kp5;
import com.baidu.tieba.l27;
import com.baidu.tieba.l95;
import com.baidu.tieba.lb7;
import com.baidu.tieba.lfa;
import com.baidu.tieba.lh5;
import com.baidu.tieba.ll6;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.lq6;
import com.baidu.tieba.mb5;
import com.baidu.tieba.me8;
import com.baidu.tieba.mq6;
import com.baidu.tieba.ms5;
import com.baidu.tieba.n95;
import com.baidu.tieba.na7;
import com.baidu.tieba.nm6;
import com.baidu.tieba.o95;
import com.baidu.tieba.oc7;
import com.baidu.tieba.oi;
import com.baidu.tieba.p27;
import com.baidu.tieba.p95;
import com.baidu.tieba.pa7;
import com.baidu.tieba.pe8;
import com.baidu.tieba.pl6;
import com.baidu.tieba.play.AutoPlayController;
import com.baidu.tieba.pq6;
import com.baidu.tieba.q16;
import com.baidu.tieba.q58;
import com.baidu.tieba.q95;
import com.baidu.tieba.qc8;
import com.baidu.tieba.qd;
import com.baidu.tieba.qd7;
import com.baidu.tieba.s05;
import com.baidu.tieba.s27;
import com.baidu.tieba.so5;
import com.baidu.tieba.t27;
import com.baidu.tieba.t75;
import com.baidu.tieba.tbadkCore.writeModel.AttentionBarData;
import com.baidu.tieba.tf8;
import com.baidu.tieba.tla;
import com.baidu.tieba.tpa;
import com.baidu.tieba.uv4;
import com.baidu.tieba.v47;
import com.baidu.tieba.vc8;
import com.baidu.tieba.vj5;
import com.baidu.tieba.vv4;
import com.baidu.tieba.wa7;
import com.baidu.tieba.wpa;
import com.baidu.tieba.x98;
import com.baidu.tieba.xu5;
import com.baidu.tieba.y57;
import com.baidu.tieba.ya7;
import com.baidu.tieba.ye8;
import com.baidu.tieba.yja;
import com.baidu.tieba.yu5;
import com.baidu.tieba.z98;
import com.baidu.tieba.za7;
import com.baidu.tieba.zca;
import com.baidu.tieba.zo4;
import com.baidu.tieba.zu5;
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
public class PersonalizePageView extends FrameLayout implements xu5 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean P0;
    public static final int Q0;
    public transient /* synthetic */ FieldHolder $fh;
    public ll6 A;
    public final CustomRule A0;
    public int B;
    public final lb7.a B0;
    public int C;
    public f55.g C0;
    public boolean D;
    public f55.h D0;
    public LinearLayoutManager E;
    public f55.e E0;
    public RightFloatLayerView F;
    public f55.f F0;
    public int G;
    public Runnable G0;
    public x98 H;
    public AutoPlayController.a H0;
    public volatile boolean I;
    public final CustomMessageListener I0;
    public FrameLayout J;
    public View.OnClickListener J0;
    public boolean K;
    public CustomMessageListener K0;
    public boolean L;
    public CustomMessageListener L0;
    public boolean M;
    public CustomMessageListener M0;
    public Object N;
    public CustomMessageListener N0;
    public String O;
    public CustomMessageListener O0;
    public String P;
    public boolean Q;
    public boolean R;
    public mb5 S;

    /* renamed from: T  reason: collision with root package name */
    public PollingModel f1105T;
    public BdUniqueId U;
    public BdUniqueId V;
    public long W;
    public BigdaySwipeRefreshLayout a;
    public de8.f a0;
    public BdTypeRecyclerView b;
    public CustomMessageListener b0;
    public fe8 c;
    public CustomMessageListener c0;
    public ee8 d;
    public CustomMessageListener d0;
    public c1 e;
    public CustomMessageListener e0;
    public PbListView f;
    public NEGFeedBackView.NEGFeedbackEventCallback f0;
    public pa7 g;
    public FollowUserButton.a g0;
    public kfa h;
    public ba8 h0;
    public AutoPlayController i;
    public int i0;
    public lfa j;
    public RecyclerView.OnScrollListener j0;
    public de8 k;
    public TbPageContext<?> l;
    public aa8 m;
    public vc8 n;
    public qc8 o;
    public af8 p;
    public long q;
    public LoadingView r;
    public ScrollFragmentTabHost.s r0;
    public vj5 s;
    public View.OnClickListener s0;
    public long t;
    public CustomMessageListener t0;
    public int u;
    public CustomMessageListener u0;
    public boolean v;
    public CustomMessageListener v0;
    public boolean w;
    public CustomMessageListener w0;
    public long x;
    public vc8.n0 x0;
    public boolean y;
    public CustomMessageListener y0;
    public boolean z;
    public final CustomMessageListener z0;

    /* loaded from: classes6.dex */
    public interface c1 {
        void a(f55.g gVar);

        void b(f55.h hVar);

        void c(f55.e eVar);

        void e(f55.f fVar);
    }

    public final void e1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class o0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ o0 a;

            public a(o0 o0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {o0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = o0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.S0();
                }
            }
        }

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
    public class p implements vc8.n0 {
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
            public final /* synthetic */ p c;

            public a(p pVar, int i, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {pVar, Integer.valueOf(i), str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = pVar;
                this.a = i;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                    return;
                }
                this.c.b.B0();
                if (this.a == 1) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        this.c.b.l.showToast(this.b);
                    }
                    this.c.g();
                } else if (this.c.a) {
                    this.c.g();
                    this.c.b.n1(false);
                    return;
                } else {
                    this.c.b.a.setVisibility(8);
                    this.c.b.H.r(false);
                    PersonalizePageView personalizePageView = this.c.b;
                    personalizePageView.k1(personalizePageView, this.b, true);
                }
                IdleHandlerManager.getInstance().runIdleTaskImmediately();
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ boolean a;
            public final /* synthetic */ p b;

            public b(p pVar, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {pVar, Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = pVar;
                this.a = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.g();
                    this.b.b.a.setVisibility(0);
                    this.b.b.H.r(true);
                    this.b.b.B0();
                    this.b.b.C0();
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
            public final /* synthetic */ p a;

            public c(p pVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {pVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = pVar;
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

        public p(PersonalizePageView personalizePageView) {
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

        @Override // com.baidu.tieba.vc8.n0
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                UiUtils.runOnUiThread(new b(this, z));
            }
        }

        @Override // com.baidu.tieba.vc8.n0
        public void b(int i, ms5 ms5Var, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), ms5Var, Integer.valueOf(i2)}) == null) {
                if (this.b.m == null) {
                    PersonalizePageView personalizePageView = this.b;
                    personalizePageView.k1(personalizePageView, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e61), true);
                    this.b.B0();
                    return;
                }
                boolean N0 = this.b.N0();
                this.b.C0();
                if (N0) {
                    this.b.j1(true);
                }
                this.b.m.c(i, ms5Var, i2);
                zo4.f().m();
            }
        }

        @Override // com.baidu.tieba.vc8.n0
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                UiUtils.runOnUiThread(new c(this));
            }
        }

        public final void g() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.a) {
                this.a = false;
                SharedPrefHelper.getInstance().putBoolean("key_first_install", false);
            }
        }

        @Override // com.baidu.tieba.vc8.n0
        public void d(int i, int i2, ms5 ms5Var, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), ms5Var, Integer.valueOf(i3)}) == null) && this.b.m != null) {
                PersonalizePageView personalizePageView = this.b;
                if (personalizePageView.O0(personalizePageView.b)) {
                    this.b.q = System.currentTimeMillis();
                }
                this.b.m.d(i, i2, ms5Var, i3);
            }
        }

        @Override // com.baidu.tieba.vc8.n0
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) {
                UiUtils.runOnUiThread(new a(this, i, str));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements na7.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gga a;
        public final /* synthetic */ BdUniqueId b;
        public final /* synthetic */ PersonalizePageView c;

        public a(PersonalizePageView personalizePageView, gga ggaVar, BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, ggaVar, bdUniqueId};
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
            this.a = ggaVar;
            this.b = bdUniqueId;
        }

        @Override // com.baidu.tieba.na7.c
        public void a(@NonNull za7<?> za7Var, @NonNull ya7<?, ?> ya7Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, za7Var, ya7Var, i) == null) {
                this.a.a(za7Var, ya7Var, i);
                so5.a.h(this.b);
            }
        }

        @Override // com.baidu.tieba.na7.c
        public void b(@NonNull RecyclerView recyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView) == null) {
                this.a.b(recyclerView);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a0 implements f55.g {
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

        @Override // com.baidu.tieba.f55.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048576, this, z) != null) {
                return;
            }
            this.a.D = true;
            q16.c().f("page_recommend");
            if (PersonalizePageView.P0) {
                this.a.h.f();
                if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    TiebaStatic.log(new StatisticItem("c11032").param("obj_source", 1));
                }
                this.a.i.p(false);
                this.a.Z0();
                return;
            }
            this.a.q0();
            this.a.n.d1(false);
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
            if ((interceptable != null && interceptable.invokeLI(1048576, this, recyclerView, i) != null) || this.a.i0 == i || this.a.h0 == null) {
                return;
            }
            this.a.i0 = i;
            if (this.a.i0 == 1) {
                this.a.h0.a();
            } else if (this.a.a1(recyclerView)) {
                this.a.h0.c();
            } else {
                this.a.h0.a();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends pq6<o95> {
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
        @Override // com.baidu.tieba.pq6
        public void onEvent(@NonNull o95 o95Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o95Var) == null) {
                if ("recommend_post".equals(o95Var.b()) && (o95Var.a() instanceof JSONObject)) {
                    String optString = ((JSONObject) o95Var.a()).optString("tid");
                    if (!StringUtils.isNull(optString) && this.b.h != null) {
                        this.b.h.v(optString);
                        this.b.h.P((JSONObject) o95Var.a());
                    }
                } else if ("recommend_fun_ad".equals(o95Var.b()) && this.b.b != null && this.b.b.getListAdapter() != null) {
                    this.b.b.getListAdapter().notifyDataSetChanged();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b0 implements f55.h {
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

        @Override // com.baidu.tieba.f55.h
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
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.h0 == null) {
                return;
            }
            this.a.i0 = -1;
            PersonalizePageView personalizePageView = this.a;
            if (personalizePageView.a1(personalizePageView.b)) {
                this.a.h0.c();
            } else {
                this.a.h0.a();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends pq6<q95> {
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
        @Override // com.baidu.tieba.pq6
        public void onEvent(@NonNull q95 q95Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q95Var) == null) {
                String a = q95Var.a();
                if (!TextUtils.isEmpty(a) && this.b.h != null) {
                    this.b.h.v(a);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c0 implements f55.e {
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

        @Override // com.baidu.tieba.f55.e
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
    public class d extends pq6<p95> {
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
        @Override // com.baidu.tieba.pq6
        public void onEvent(@NonNull p95 p95Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p95Var) == null) && (p95Var.a() instanceof b67) && ((b67) p95Var.a()).d().equals("recommend_post")) {
                Object a = ((b67) p95Var.a()).a();
                if (!(a instanceof c67)) {
                    return;
                }
                this.b.z0((c67) a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d0 implements f55.f {
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

        @Override // com.baidu.tieba.f55.f
        public void a(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (PersonalizePageView.P0) {
                    this.a.i.p(true);
                    this.a.i.r();
                } else if (this.a.n != null) {
                    this.a.n.d1(true);
                    this.a.n.S0();
                }
                TbSingleton.getInstance().mIsForceLayoutMaintab = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, Boolean.TRUE));
                uv4 uv4Var = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > SharedPrefHelper.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    uv4Var = vv4.i().h(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, uv4Var));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends pq6<n95> {
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
        @Override // com.baidu.tieba.pq6
        public void onEvent(@NonNull n95 n95Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, n95Var) == null) && (n95Var.a() instanceof b67) && ((b67) n95Var.a()).d().equals("recommend_post")) {
                Object a = ((b67) n95Var.a()).a();
                if (!(a instanceof c67)) {
                    return;
                }
                this.b.y0(n95Var.b(), n95Var.c(), (c67) a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e0 extends RecyclerView.OnScrollListener {
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

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                if (this.a.E != null && i == 0) {
                    k95 wlConfigData = TbSingleton.getInstance().getWlConfigData();
                    int i3 = 3;
                    if (wlConfigData != null && wlConfigData.I() != 0) {
                        i3 = wlConfigData.I();
                    }
                    int itemCount = this.a.E.getItemCount() - this.a.E.findLastVisibleItemPosition();
                    if (PersonalizePageView.P0) {
                        i2 = 1;
                    } else {
                        i2 = 5;
                    }
                    if (itemCount <= i3 * i2) {
                        this.a.P0();
                    }
                }
                if (this.a.Q && i == 0 && SharedPrefHelper.getInstance().getBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount(qd7.a(this.a.P, this.a.O)), true)) {
                    PersonalizePageView personalizePageView = this.a;
                    personalizePageView.f1(personalizePageView.P, this.a.O);
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
                PersonalizePageView.R(this.a, i2);
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
    public class f extends pq6<efa> {
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
        @Override // com.baidu.tieba.pq6
        public void onEvent(@NonNull efa efaVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, efaVar) != null) || this.b.p == null) {
                return;
            }
            this.b.p.e(efaVar.d(), efaVar.f(), efaVar.c(), efaVar.b(), efaVar.a(), efaVar.e(), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, null);
        }
    }

    /* loaded from: classes6.dex */
    public class f0 implements BdListView.p {
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

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.P0();
        }
    }

    /* loaded from: classes6.dex */
    public class g extends pq6<ffa> {
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
        @Override // com.baidu.tieba.pq6
        public void onEvent(@NonNull ffa ffaVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, ffaVar) != null) || this.b.o == null) {
                return;
            }
            this.b.o.e(ffaVar.b(), JavaTypesHelper.toLong(ffaVar.a(), 0L), ffaVar.c());
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
                        this.a.h.T(data);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h extends pq6<l95> {
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
        @Override // com.baidu.tieba.pq6
        public void onEvent(@NonNull l95 l95Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, l95Var) == null) {
                UpdateAttentionMessage.UpdateAttentionData a = l95Var.a();
                if (a.blockData == null && a.isSucc && !TextUtils.isEmpty(a.toUid) && this.b.h != null) {
                    this.b.h.T(a);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h0 implements BdListView.o {
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

        @Override // com.baidu.adp.widget.ListView.BdListView.o
        public void onScrollStop(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && System.currentTimeMillis() - this.a.t >= 5000 && this.a.n != null) {
                this.a.n.R0(i, i2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i extends pq6<ih5> {
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
        @Override // com.baidu.tieba.pq6
        public void onEvent(@NonNull ih5 ih5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ih5Var) == null) {
                if (this.b.n != null) {
                    this.b.n.s0(ih5Var);
                }
                if (this.b.h != null) {
                    this.b.h.C(ih5Var);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i0 implements RecyclerView.RecyclerListener {
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
    public class k implements de8.f {
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

        @Override // com.baidu.tieba.de8.f
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
                this.a.e1();
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.f != null) {
                this.a.f.H(this.a.getContext().getString(R.string.pb_load_more));
                this.a.f.g();
                this.a.f.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
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
                    this.a.e1();
                }
                PersonalizePageView personalizePageView = this.a;
                personalizePageView.K = true;
                if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW || personalizePageView.L) {
                    return;
                }
                personalizePageView.J0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l0 implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (PersonalizePageView.P0) {
                    if (this.a.h != null) {
                        this.a.h.f();
                    }
                } else if (this.a.n == null) {
                } else {
                    this.a.q0();
                }
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
                    personalizePageView.J0();
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
    public class m0 implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.l != null) {
                SharedPrefHelper.getInstance().putInt("show_is_uninterest_tag", PersonalizePageView.d0(this.a));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(this.a.l.getContext(), 2)));
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
                tla.a().e(true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n0 implements AutoPlayController.a {
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

        @Override // com.baidu.tieba.play.AutoPlayController.a
        public void onBackground(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.i.h() != null && (this.a.i.h().getTag() instanceof t27.r)) {
                ((t27.r) this.a.i.h().getTag()).onBackground(z);
            }
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && tf8.a()) {
                PersonalizePageView personalizePageView = this.a;
                personalizePageView.S = PushOpenUtil.showPushOpenView(personalizePageView.l, DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, 0L);
                if (this.a.S != null) {
                    gba.e().h(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public p0(PersonalizePageView personalizePageView) {
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
            this.a.P0();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue() && MainTabBottomDynamicIconManager.getInstance().canShowDynamicIcon() && this.a.f != null && this.a.f.l() == 0) {
                this.a.f.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
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
    public class r extends CustomMessageListener {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
                tla.a().e(true);
            }
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
                        this.a.h.T(data);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s extends CustomRule {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(PersonalizePageView personalizePageView, int i) {
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
                    tla.a().e(true);
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
            this.a.H0(customResponsedMessage.getData());
        }
    }

    /* loaded from: classes6.dex */
    public class t implements ye8.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        @Override // com.baidu.tieba.ye8.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

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

        @Override // com.baidu.tieba.ye8.c
        public void a(me8 me8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, me8Var) != null) {
                return;
            }
            this.a.A0(me8Var);
        }
    }

    /* loaded from: classes6.dex */
    public class t0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uv4 a;
        public final /* synthetic */ PersonalizePageView b;

        public t0(PersonalizePageView personalizePageView, uv4 uv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, uv4Var};
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
            this.a = uv4Var;
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
    public class u implements PollingModel.d {
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

        @Override // com.baidu.tbadk.core.leveiconlivepolling.PollingModel.d
        public void onFail() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.n != null) {
                this.a.n.r0();
            }
        }

        @Override // com.baidu.tbadk.core.leveiconlivepolling.PollingModel.d
        public void onSuccess(List<AlaLiveInfo> list) {
            List<za7<?>> c;
            boolean z;
            List<AlaLiveInfo> liveIndexSecondFloor;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                if (this.a.n != null) {
                    this.a.n.q0();
                }
                if (this.a.h != null && (c = this.a.h.c()) != null && c.size() > 0) {
                    Iterator<za7<?>> it = c.iterator();
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
                        bm6 bm6Var = new bm6(null, liveIndexSecondFloor, "recommend");
                        c77 c77Var = new c77();
                        c77Var.a = bm6Var;
                        this.a.h.G(new ab7(new s27(c77Var), "ala_live_attention"), 0);
                    }
                }
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
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.E0();
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
                    layoutParams.bottomMargin = PersonalizePageView.Q0 + this.a.G;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (!this.a.R) {
                        return;
                    }
                    this.a.R = false;
                    this.a.l1();
                } else if (this.a.F == null || this.a.F.getVisibility() != 0) {
                } else {
                    this.a.R = true;
                    this.a.E0();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class w implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MainTabBottomDynamicIconManager.getInstance().loadImages();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class w0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w0(PersonalizePageView personalizePageView, int i) {
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
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && this.a.i.h() != null && (this.a.i.h().getTag() instanceof t27.r)) {
                    ((t27.r) this.a.i.h().getTag()).onVolumeUp();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class x implements lb7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public x(PersonalizePageView personalizePageView) {
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

        @Override // com.baidu.tieba.lb7.a
        public void a(y57 y57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, y57Var) != null) {
                return;
            }
            this.a.w = true;
            this.a.B0();
            if (y57Var.d == 0) {
                if (ListUtils.isEmpty(y57Var.a)) {
                    this.a.a.setRefreshing(false);
                    PersonalizePageView personalizePageView = this.a;
                    personalizePageView.k1(personalizePageView, y57Var.e, true);
                    this.a.H.r(false);
                    this.a.a.setVisibility(8);
                    this.a.f.O(8);
                } else {
                    this.a.t0(y57Var.b);
                    this.a.C0();
                    this.a.f.O(0);
                    if (y57Var.c) {
                        this.a.h1();
                    } else {
                        this.a.i1();
                    }
                }
                this.a.g.setList(y57Var.a);
                this.a.i.r();
                return;
            }
            this.a.a.setRefreshing(false);
            if (ListUtils.isEmpty(y57Var.a)) {
                PersonalizePageView personalizePageView2 = this.a;
                personalizePageView2.k1(personalizePageView2, y57Var.e, true);
                this.a.H.r(false);
                this.a.a.setVisibility(8);
                this.a.f.O(8);
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
                    this.a.h.B(customResponsedMessage);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class y implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t75 a;
        public final /* synthetic */ PersonalizePageView b;

        public y(PersonalizePageView personalizePageView, t75 t75Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, t75Var};
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
            this.a = t75Var;
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
                this.a.Q0();
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
    public class z implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t75 a;
        public final /* synthetic */ PersonalizePageView b;

        public z(PersonalizePageView personalizePageView, t75 t75Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, t75Var};
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
            this.a = t75Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.F.setHomePbFloatLastCloseTime();
                this.b.D0();
                this.b.F.t(this.a);
            }
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
                TiebaStatic.log(tpa.m("c13696", (ThreadData) tag));
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
        P0 = M0();
        Q0 = UtilHelper.getDimenPixelSize(R.dimen.tbds437);
    }

    public static boolean M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            return UbsABTestHelper.isRecommendFeedTest();
        }
        return invokeV.booleanValue;
    }

    public final void C0() {
        vj5 vj5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (vj5Var = this.s) != null) {
            vj5Var.dettachView(this);
            this.s = null;
        }
    }

    public void D0() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (rightFloatLayerView = this.F) != null) {
            rightFloatLayerView.c();
        }
    }

    public final void E0() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (rightFloatLayerView = this.F) != null) {
            rightFloatLayerView.setAutoCompleteShown(false);
            this.F.clearAnimation();
            this.F.setVisibility(8);
        }
    }

    public void I0() {
        c1 c1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (c1Var = this.e) != null) {
            c1Var.a(this.C0);
            this.e.b(this.D0);
            this.e.c(this.E0);
            this.e.e(this.F0);
        }
    }

    public final void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.L = true;
            t75 homeAdFloatViewItemData = TbSingleton.getInstance().getHomeAdFloatViewItemData();
            if (homeAdFloatViewItemData != null && !homeAdFloatViewItemData.a()) {
                q1(homeAdFloatViewItemData);
            }
        }
    }

    public final boolean N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            vj5 vj5Var = this.s;
            if (vj5Var != null) {
                return vj5Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void Q0() {
        x98 x98Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (x98Var = this.H) != null) {
            x98Var.f();
        }
    }

    public void R0() {
        vc8 vc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (vc8Var = this.n) != null) {
            vc8Var.A0();
        }
    }

    public void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            de8 de8Var = this.k;
            if (de8Var != null) {
                de8Var.n();
            }
            Q0();
        }
    }

    public void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            vc8 vc8Var = this.n;
            if (vc8Var != null) {
                vc8Var.M0();
            }
            de8 de8Var = this.k;
            if (de8Var != null) {
                de8Var.q();
            }
            RightFloatLayerView rightFloatLayerView = this.F;
            if (rightFloatLayerView != null && (rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                ((RightFloatLayerLottieView) rightFloatLayerView).G(600);
            }
        }
    }

    public final void Z0() {
        PollingModel pollingModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (pollingModel = this.f1105T) != null) {
            pollingModel.getData("live,level,icon,festival_info,live_follow_second_floor,member_broadcast,activity_broadcast,live_index_second_floor");
        }
    }

    @Override // com.baidu.tieba.xu5
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

    public void c1() {
        vc8 vc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && (vc8Var = this.n) != null) {
            vc8Var.Y0();
        }
    }

    public void d1() {
        vc8 vc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && (vc8Var = this.n) != null) {
            vc8Var.h1();
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
            this.f.U();
            this.f.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f.w(BdUtilHelper.getDimens(getContext(), R.dimen.tbds150));
        }
    }

    public final void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.f.h();
            this.f.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f.w(BdUtilHelper.getDimens(getContext(), R.dimen.tbds150));
        }
    }

    public void l1() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048616, this) == null) && (rightFloatLayerView = this.F) != null) {
            rightFloatLayerView.d();
        }
    }

    public void p0() {
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048620, this) == null) && (bigdaySwipeRefreshLayout = this.a) != null) {
            bigdaySwipeRefreshLayout.r();
        }
    }

    public final void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            r0(false);
        }
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            if (this.s != null) {
                b1();
            } else if (this.n != null) {
                q0();
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
        this.a0 = new k(this);
        this.b0 = new v(this, 2921553);
        this.c0 = new g0(this, 2001438);
        this.d0 = new r0(this, 2001437);
        this.e0 = new x0(this, 2016331);
        this.f0 = new y0(this);
        this.g0 = new z0(this);
        this.i0 = -1;
        this.j0 = new a1(this);
        this.r0 = new b1(this);
        this.s0 = new j(this);
        this.t0 = new l(this, 2001371);
        this.u0 = new m(this, 2921736);
        this.v0 = new n(this, 2921822);
        this.w0 = new o(this, 2921482);
        this.x0 = new p(this);
        this.y0 = new q(this, 2921551);
        this.z0 = new r(this, 2001222);
        this.A0 = new s(this, 2002001);
        this.B0 = new x(this);
        this.C0 = new a0(this);
        this.D0 = new b0(this);
        this.E0 = new c0(this);
        this.F0 = new d0(this);
        this.G0 = new m0(this);
        this.H0 = new n0(this);
        this.I0 = new o0(this, 2001118);
        this.J0 = new p0(this);
        this.K0 = new q0(this, 2921033);
        this.L0 = new s0(this, 2921349);
        this.M0 = new u0(this, 2921664);
        this.N0 = new v0(this, 2921667);
        this.O0 = new w0(this, 2921381);
        K0(context);
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
        this.a0 = new k(this);
        this.b0 = new v(this, 2921553);
        this.c0 = new g0(this, 2001438);
        this.d0 = new r0(this, 2001437);
        this.e0 = new x0(this, 2016331);
        this.f0 = new y0(this);
        this.g0 = new z0(this);
        this.i0 = -1;
        this.j0 = new a1(this);
        this.r0 = new b1(this);
        this.s0 = new j(this);
        this.t0 = new l(this, 2001371);
        this.u0 = new m(this, 2921736);
        this.v0 = new n(this, 2921822);
        this.w0 = new o(this, 2921482);
        this.x0 = new p(this);
        this.y0 = new q(this, 2921551);
        this.z0 = new r(this, 2001222);
        this.A0 = new s(this, 2002001);
        this.B0 = new x(this);
        this.C0 = new a0(this);
        this.D0 = new b0(this);
        this.E0 = new c0(this);
        this.F0 = new d0(this);
        this.G0 = new m0(this);
        this.H0 = new n0(this);
        this.I0 = new o0(this, 2001118);
        this.J0 = new p0(this);
        this.K0 = new q0(this, 2921033);
        this.L0 = new s0(this, 2921349);
        this.M0 = new u0(this, 2921664);
        this.N0 = new v0(this, 2921667);
        this.O0 = new w0(this, 2921381);
        K0(context);
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
        this.a0 = new k(this);
        this.b0 = new v(this, 2921553);
        this.c0 = new g0(this, 2001438);
        this.d0 = new r0(this, 2001437);
        this.e0 = new x0(this, 2016331);
        this.f0 = new y0(this);
        this.g0 = new z0(this);
        this.i0 = -1;
        this.j0 = new a1(this);
        this.r0 = new b1(this);
        this.s0 = new j(this);
        this.t0 = new l(this, 2001371);
        this.u0 = new m(this, 2921736);
        this.v0 = new n(this, 2921822);
        this.w0 = new o(this, 2921482);
        this.x0 = new p(this);
        this.y0 = new q(this, 2921551);
        this.z0 = new r(this, 2001222);
        this.A0 = new s(this, 2002001);
        this.B0 = new x(this);
        this.C0 = new a0(this);
        this.D0 = new b0(this);
        this.E0 = new c0(this);
        this.F0 = new d0(this);
        this.G0 = new m0(this);
        this.H0 = new n0(this);
        this.I0 = new o0(this, 2001118);
        this.J0 = new p0(this);
        this.K0 = new q0(this, 2921033);
        this.L0 = new s0(this, 2921349);
        this.M0 = new u0(this, 2921664);
        this.N0 = new v0(this, 2921667);
        this.O0 = new w0(this, 2921381);
        K0(context);
    }

    public static /* synthetic */ int R(PersonalizePageView personalizePageView, int i2) {
        int i3 = personalizePageView.C + i2;
        personalizePageView.C = i3;
        return i3;
    }

    public void p1(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048621, this, str, i2) == null) {
            UiUtils.runOnUiThread(new k0(this));
            vc8 vc8Var = this.n;
            if (vc8Var != null) {
                vc8Var.K0(true, false, null, i2, str);
            }
        }
    }

    public static /* synthetic */ int d0(PersonalizePageView personalizePageView) {
        int i2 = personalizePageView.B + 1;
        personalizePageView.B = i2;
        return i2;
    }

    public final boolean L0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
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

    public boolean O0(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, recyclerView)) == null) {
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

    public boolean a1(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, recyclerView)) == null) {
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
                X0();
            }
        }
    }

    public final void r0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z2) == null) {
            vc8 vc8Var = this.n;
            if (vc8Var != null) {
                vc8Var.j1(z2);
            }
            Z0();
        }
    }

    public void s0(Long l2) {
        vc8 vc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048626, this, l2) == null) && (vc8Var = this.n) != null) {
            vc8Var.b0(l2);
        }
    }

    public void setCallback(aa8 aa8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, aa8Var) == null) {
            this.m = aa8Var;
        }
    }

    public void setFragmentUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, bdUniqueId) == null) {
            this.V = bdUniqueId;
        }
    }

    public void setScrollFragmentTabHost(ba8 ba8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, ba8Var) == null) {
            this.h0 = ba8Var;
            if (ba8Var != null) {
                ba8Var.e(this.r0);
                this.h0.b(this.r0);
            }
            vc8 vc8Var = this.n;
            if (vc8Var != null) {
                vc8Var.f1(ba8Var);
            }
        }
    }

    public void setTabInForeBackgroundState(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z2) == null) {
            if (P0) {
                this.i.n(z2);
                return;
            }
            vc8 vc8Var = this.n;
            if (vc8Var != null) {
                vc8Var.g1(z2);
            }
        }
    }

    public void setViewForeground(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048633, this, z2) == null) {
            vc8 vc8Var = this.n;
            if (vc8Var != null) {
                vc8Var.N0(z2);
            }
            ba8 ba8Var = this.h0;
            if (ba8Var != null) {
                ba8Var.e(this.r0);
                this.h0.b(this.r0);
                this.r0.b();
            }
        }
    }

    public final void A0(me8 me8Var) {
        List<za7<?>> c2;
        int v02;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, me8Var) == null) {
            vc8 vc8Var = this.n;
            if (vc8Var != null) {
                vc8Var.p0(me8Var);
            }
            if (this.h != null) {
                int firstVisiblePosition = this.b.getFirstVisiblePosition();
                RecommendBarCardModel d2 = RecommendBarCardModel.d(me8Var);
                if (d2 != null && (c2 = this.h.c()) != null && (v02 = v0(me8Var.b(), c2)) >= 0 && (i2 = v02 + 1) >= 0 && i2 <= c2.size() && i2 > firstVisiblePosition) {
                    d2.o(me8Var.b());
                    d2.q(RecommendBarCardModel.RecDataSource.FORUMBACKCONCERN);
                    this.h.G(new ab7(new s27(new c77(d2)), "recommend_bar_layout"), i2);
                    qc8 qc8Var = this.o;
                    if (qc8Var != null) {
                        qc8Var.c();
                        vc8.t0(me8Var.a());
                    }
                }
            }
        }
    }

    public void T0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            if (this.u != i2) {
                LoadingView loadingView = this.r;
                if (loadingView != null) {
                    loadingView.onChangeSkinType();
                }
                vj5 vj5Var = this.s;
                if (vj5Var != null) {
                    vj5Var.onChangeSkinType();
                }
                ee8 ee8Var = this.d;
                if (ee8Var != null) {
                    ee8Var.D(i2);
                }
                PbListView pbListView = this.f;
                if (pbListView != null) {
                    pbListView.J(SkinManager.getColor(R.color.CAM_X0109));
                    this.f.e(i2);
                }
                de8 de8Var = this.k;
                if (de8Var != null) {
                    de8Var.o(i2);
                }
                vc8 vc8Var = this.n;
                if (vc8Var != null) {
                    vc8Var.I0(i2);
                }
                ll6 ll6Var = this.A;
                if (ll6Var != null) {
                    ll6Var.d(i2);
                }
                RightFloatLayerView rightFloatLayerView = this.F;
                if (rightFloatLayerView != null) {
                    rightFloatLayerView.n();
                }
                x98 x98Var = this.H;
                if (x98Var != null) {
                    x98Var.o();
                }
                mb5 mb5Var = this.S;
                if (mb5Var != null) {
                    mb5Var.w();
                }
                pa7 pa7Var = this.g;
                if (pa7Var != null) {
                    pa7Var.r();
                }
            }
            this.u = i2;
        }
    }

    public final void j1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z2) == null) {
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

    public final boolean q1(t75 t75Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, t75Var)) == null) {
            if (!RightFloatLayerView.k()) {
                D0();
                return false;
            } else if (t75Var == null) {
                return false;
            } else {
                if (this.F == null) {
                    RightFloatLayerView E = RightFloatLayerLottieView.E(t75Var, getContext());
                    this.F = E;
                    E.setPageContext(this.l);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 85;
                    layoutParams.bottomMargin = Q0 + this.G;
                    this.F.c();
                    addView(this.F, layoutParams);
                }
                this.F.setAutoCompleteShown(true);
                if (t75Var.a()) {
                    return false;
                }
                this.F.setData(t75Var);
                this.F.setLogoListener(new y(this, t75Var));
                this.F.setFeedBackListener(new z(this, t75Var));
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final void z0(c67 c67Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048640, this, c67Var) != null) || c67Var == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.NEG_FEEDBACK_KEY).param("obj_locate", "1").param("fid", c67Var.d()).param("tid", c67Var.h()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("nid", c67Var.e()));
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.NEGATIVE_FEEDBACK_OPEN_CLICK).param("obj_locate", "1").param("fid", c67Var.d()).param("tid", c67Var.h()).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public final void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
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
            aa8 aa8Var = this.m;
            if (aa8Var != null) {
                aa8Var.b();
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

    public final void X0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (!this.y) {
                long f2 = z98.d().f(1) + z98.d().b();
                long a2 = z98.d().a(1);
                if (a2 > 0) {
                    f2 = System.currentTimeMillis() - a2;
                }
                kp5 kp5Var = new kp5();
                kp5Var.a();
                kp5Var.b();
                ip5.a().n(f2);
                if (this.x > 0) {
                    ip5.a().D(System.currentTimeMillis() - this.x);
                }
                ip5.a().H(kp5Var.c());
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.SECOND_DRAW_DISPATCH_STAMP_KEY);
                if (!MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW && !this.M) {
                    this.M = true;
                    SpeedStats.getInstance().onMainPageStatsEnd(getContext());
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921637, ""));
                if (P0) {
                    wpa.g().h(this.V, false);
                }
            }
            this.y = true;
        }
    }

    public void g1() {
        Uri data;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            if (lh5.b.a().a("show_reply_tip") || lh5.b.a().a("show_agree_tip")) {
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
                    if (!StringUtils.isNull(optString) && !StringUtils.isNull(this.O) && SharedPrefHelper.getInstance().getBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount(qd7.a(this.P, this.O)), true)) {
                        m1(this.P, this.O);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public synchronized void F0(Context context) {
        uv4 uv4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            synchronized (this) {
                if (this.I) {
                    return;
                }
                this.I = true;
                Context context2 = getContext();
                if (context2 instanceof fr6) {
                    ((fr6) context2).setBaseContext(context);
                }
                MessageManager.getInstance().registerListener(this.u0);
                MessageManager.getInstance().registerListener(this.t0);
                MessageManager.getInstance().registerListener(this.b0);
                MessageManager.getInstance().registerListener(this.L0);
                MessageManager.getInstance().registerListener(this.K0);
                MessageManager.getInstance().registerListener(this.M0);
                MessageManager.getInstance().registerListener(this.N0);
                MessageManager.getInstance().registerListener(this.v0);
                MessageManager.getInstance().registerListener(this.y0);
                MessageManager.getInstance().registerListener(this.c0);
                MessageManager.getInstance().registerListener(this.d0);
                MessageManager.getInstance().registerListener(this.e0);
                if (P0) {
                    MessageManager.getInstance().registerListener(this.O0);
                }
                MessageManager.getInstance().registerListener(this.z0);
                this.A0.setPriority(-1);
                MessageManager.getInstance().addMessageRule(this.A0);
                BdPageContext<?> a2 = a5.a(context);
                if (a2 instanceof TbPageContext) {
                    this.l = (TbPageContext) a2;
                }
                this.H.p(this.l);
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > SharedPrefHelper.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                    uv4Var = vv4.i().h(1);
                } else {
                    uv4Var = null;
                }
                try {
                    H0(uv4Var);
                } catch (Exception unused) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, uv4Var));
                }
                this.o = new qc8(this.l);
                this.o.b().q(new t(this));
                this.p = new af8();
                if (P0) {
                    if (g27.a.getBaseContext() == null) {
                        g27.a.a(TbadkCoreApplication.getInst());
                    }
                    FeedTemplateAdapter feedTemplateAdapter = new FeedTemplateAdapter();
                    this.g = feedTemplateAdapter;
                    feedTemplateAdapter.i(new oc7());
                    this.g.i(new wa7());
                    pa7 pa7Var = this.g;
                    l27 l27Var = new l27(2);
                    l27Var.c(this.l);
                    l27Var.b("INDEX");
                    pa7Var.i(l27Var);
                    this.g.i(new p27(q58.g(), "personalize", null, null));
                    this.g.e(this.b);
                    kfa kfaVar = new kfa(this.l.getPageActivity());
                    this.h = kfaVar;
                    kfaVar.h(this.B0);
                    AutoPlayController autoPlayController = new AutoPlayController(a2, this.b);
                    this.i = autoPlayController;
                    autoPlayController.o(this.H0);
                    this.j = new lfa(this.h);
                    zca.n();
                } else {
                    de8 de8Var = new de8(context, this.b);
                    this.k = de8Var;
                    de8Var.z(this.p);
                    this.k.x(this.a0);
                    this.k.u(this.o);
                    vc8 vc8Var = new vc8(this.l, this.b, this.k, this.a, this);
                    this.n = vc8Var;
                    vc8Var.Z0(this.o);
                }
                PollingModel pollingModel = new PollingModel(this.l, this.U);
                this.f1105T = pollingModel;
                pollingModel.setDialogTime(s05.d);
                this.f1105T.setLiveIndexSecondFloorCallback(new u(this));
                T0(TbadkCoreApplication.getInst().getSkinType());
                this.B = SharedPrefHelper.getInstance().getInt("show_is_uninterest_tag", 0);
                if (!MainTabBottomDynamicIconManager.getInstance().checkIsHasShowIcon()) {
                    SafeHandler.getInst().post(new w(this));
                }
            }
        }
    }

    public void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            de8 de8Var = this.k;
            if (de8Var != null) {
                de8Var.w(this.f0);
                this.k.t(this.g0);
            }
            vc8 vc8Var = this.n;
            if (vc8Var != null) {
                vc8Var.c1(this.x0);
            }
            I0();
            this.b.addOnScrollListener(new e0(this));
            this.b.setOnSrollToBottomListener(new f0(this));
            this.b.setOnScrollStopDelayedListener(new h0(this), 1L);
            this.b.setRecyclerListener(new i0(this));
            this.b.removeOnScrollListener(this.j0);
            this.b.addOnScrollListener(this.j0);
            yu5.b().a(this);
        }
    }

    public final void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            z98.d().j(System.currentTimeMillis(), 1);
            PbListView pbListView = this.f;
            if (pbListView != null && !pbListView.p()) {
                this.f.U();
                this.f.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            if (P0) {
                this.h.g();
                if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    TiebaStatic.log(new StatisticItem("c11032").param("obj_source", 2));
                }
                if (O0(this.b)) {
                    this.q = System.currentTimeMillis();
                    return;
                }
                return;
            }
            this.n.D0();
        }
    }

    public void Y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (P0) {
                this.i.k(true);
            } else {
                vc8 vc8Var = this.n;
                if (vc8Var != null) {
                    vc8Var.G0(true);
                }
            }
            mb5 mb5Var = this.S;
            if (mb5Var != null) {
                mb5Var.q();
            }
            pl6.b().d(false);
            q16.c().h("page_recommend", "show_");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            SafeHandler.getInst().removeCallbacks(this.G0);
            gf8.a.b();
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_RD_USE);
            statisticItem.param("obj_type", "new_feed_test_personalize_duration");
            statisticItem.param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis() - this.W);
            TiebaStatic.log(statisticItem);
        }
    }

    public void b1() {
        kfa kfaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (P0) {
                if (this.s != null && (kfaVar = this.h) != null) {
                    kfaVar.f();
                    Z0();
                    return;
                }
            } else {
                vc8 vc8Var = this.n;
                if (vc8Var != null && vc8Var.m0() != null) {
                    this.n.m0().e();
                }
                if (this.s != null && this.n != null) {
                    q0();
                    return;
                }
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.b;
            if (bdTypeRecyclerView != null && this.a != null) {
                bdTypeRecyclerView.setSelection(0);
                if (!this.a.t()) {
                    if (P0) {
                        this.i.p(false);
                    } else {
                        vc8 vc8Var2 = this.n;
                        if (vc8Var2 != null && vc8Var2.k0() != null) {
                            this.n.k0().y();
                            this.n.d1(false);
                        }
                    }
                    this.a.setRefreshing(true);
                }
                ScrollFragmentTabHost.s sVar = this.r0;
                if (sVar != null) {
                    sVar.b();
                }
            }
        }
    }

    public final void H0(Object obj) {
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, obj) == null) && (bigdaySwipeRefreshLayout = this.a) != null && !bigdaySwipeRefreshLayout.t()) {
            if (obj != null && (obj instanceof uv4)) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                ee8 ee8Var = this.d;
                if (ee8Var == null) {
                    ee8 ee8Var2 = new ee8(this.l);
                    this.d = ee8Var2;
                    ee8Var2.D(this.u);
                    this.e = this.d;
                    I0();
                } else if (this.e == ee8Var) {
                    return;
                } else {
                    this.e = ee8Var;
                }
                this.d.w(true);
                this.a.setProgressView(this.d);
                int i2 = (int) (getResources().getDisplayMetrics().density * 86.0f);
                this.a.setCustomDistances(i2, i2, i2 * 2);
                return;
            }
            uv4 uv4Var = (uv4) obj;
            fe8 fe8Var = this.c;
            if (fe8Var == null) {
                fe8 fe8Var2 = new fe8(this.l.getContext());
                this.c = fe8Var2;
                this.e = fe8Var2;
                I0();
            } else if (this.e == fe8Var && uv4Var.equals(fe8Var.B())) {
                return;
            } else {
                this.e = this.c;
            }
            this.c.w(true);
            this.a.setProgressView(this.c);
            UiUtils.runOnUiThread(new t0(this, uv4Var));
            this.a.setCustomDistances((int) getResources().getDimension(R.dimen.tbds236), (int) (BdUtilHelper.getEquipmentHeight(this.l.getContext()) * 0.8d), BdUtilHelper.getEquipmentHeight(this.l.getContext()));
        }
    }

    public final void K0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = new BdTypeRecyclerView(context);
            this.b = bdTypeRecyclerView;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(bdTypeRecyclerView.getContext());
            this.E = linearLayoutManager;
            this.b.setLayoutManager(linearLayoutManager);
            this.b.setFadingEdgeLength(0);
            this.b.setOverScrollMode(2);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.b.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            ll6 ll6Var = new ll6(context);
            this.A = ll6Var;
            ll6Var.setFrom("from_personaize");
            this.A.a().setVisibility(0);
            this.A.a().setOnClickListener(this.s0);
            x98 x98Var = new x98(this, this.b);
            this.H = x98Var;
            x98Var.q(context.getString(R.string.obfuscated_res_0x7f0f160c));
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
            this.f.G(this.J0);
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
            if (P0) {
                this.g.d(new a(this, new gga(new fga(), bdUniqueId), bdUniqueId));
                pa7 pa7Var = this.g;
                ega egaVar = new ega();
                egaVar.d("1");
                pa7Var.b(new dga(egaVar, bdUniqueId));
                this.i.q(bdUniqueId);
                this.h.Q(bdUniqueId);
            }
            de8 de8Var = this.k;
            if (de8Var != null) {
                de8Var.y(bdUniqueId);
            }
            vc8 vc8Var = this.n;
            if (vc8Var != null) {
                vc8Var.U0(bdUniqueId);
            }
            af8 af8Var = this.p;
            if (af8Var != null) {
                af8Var.a(bdUniqueId);
            }
            ee8 ee8Var = this.d;
            if (ee8Var != null) {
                ee8Var.W(bdUniqueId);
            }
            vv4.i().n(bdUniqueId);
            CustomMessageListener customMessageListener = this.I0;
            if (customMessageListener != null) {
                customMessageListener.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.I0);
            }
            mq6.b().b(new lq6(bdUniqueId, o95.class), new b(this, o95.class));
            mq6.b().b(new lq6(bdUniqueId, q95.class), new c(this, q95.class));
            mq6.b().b(new lq6(bdUniqueId, p95.class), new d(this, p95.class));
            mq6.b().b(new lq6(bdUniqueId, n95.class), new e(this, n95.class));
            mq6.b().b(new lq6(bdUniqueId, efa.class), new f(this, efa.class));
            mq6.b().b(new lq6(bdUniqueId, ffa.class), new g(this, ffa.class));
            mq6.b().b(new lq6(bdUniqueId, l95.class), new h(this, l95.class));
            mq6.b().b(new lq6(bdUniqueId, ih5.class), new i(this, ih5.class));
        }
    }

    public void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.u0);
            MessageManager.getInstance().unRegisterListener(this.t0);
            MessageManager.getInstance().unRegisterListener(this.K0);
            MessageManager.getInstance().unRegisterListener(this.L0);
            MessageManager.getInstance().unRegisterListener(this.b0);
            MessageManager.getInstance().unRegisterListener(this.M0);
            MessageManager.getInstance().unRegisterListener(this.N0);
            MessageManager.getInstance().unRegisterListener(this.y0);
            MessageManager.getInstance().unRegisterListener(this.w0);
            MessageManager.getInstance().unRegisterListener(this.v0);
            MessageManager.getInstance().unRegisterListener(this.c0);
            MessageManager.getInstance().unRegisterListener(this.d0);
            MessageManager.getInstance().registerListener(this.e0);
            if (P0) {
                MessageManager.getInstance().unRegisterListener(this.O0);
                this.h.a();
                this.j.c();
            }
            if (P0) {
                this.i.l();
            }
            vc8 vc8Var = this.n;
            if (vc8Var != null) {
                vc8Var.J0();
            }
            PollingModel pollingModel = this.f1105T;
            if (pollingModel != null) {
                pollingModel.onDestroy();
            }
            de8 de8Var = this.k;
            if (de8Var != null) {
                de8Var.w(null);
                this.k.p();
            }
            MessageManager.getInstance().unRegisterListener(this.z0);
            MessageManager.getInstance().removeMessageRule(this.A0);
            this.I = false;
            vc8 vc8Var2 = this.n;
            if (vc8Var2 != null) {
                vc8Var2.c1(null);
            }
            fe8 fe8Var = this.c;
            if (fe8Var != null) {
                fe8Var.a(null);
                this.c.b(null);
                this.c.c(null);
                this.c.e(null);
                this.c.C();
            }
            ee8 ee8Var = this.d;
            if (ee8Var != null) {
                ee8Var.a(null);
                this.d.b(null);
                this.d.c(null);
                this.d.e(null);
                this.d.U();
            }
            this.b.setOnSrollToBottomListener(null);
            ba8 ba8Var = this.h0;
            if (ba8Var != null) {
                ba8Var.e(this.r0);
            }
            this.b.removeOnScrollListener(this.j0);
            LoadingView loadingView = this.r;
            if (loadingView != null) {
                loadingView.release();
            }
            this.b.setRecyclerListener(null);
            vv4.i().e();
            SafeHandler.getInst().removeCallbacks(this.G0);
            yu5.b().d(this);
        }
    }

    public void W0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.v) {
                b1();
                this.v = false;
            }
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.a;
            if (bigdaySwipeRefreshLayout != null) {
                bigdaySwipeRefreshLayout.D();
            }
            de8 de8Var = this.k;
            if (de8Var != null) {
                de8Var.r();
            }
            if (!RightFloatLayerView.k()) {
                E0();
            }
            r1();
            if (!P0 && tla.a().d()) {
                tla.a().e(false);
                DefaultLog.getInstance().i("RecentForumLog", "首页刷新最近逛的吧");
                vc8 vc8Var = this.n;
                if (vc8Var != null) {
                    vc8Var.T0();
                }
            }
        }
    }

    public final void r1() {
        ThreadCardViewHolder threadCardViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            for (int i2 = 0; i2 < this.b.getChildCount(); i2++) {
                View childAt = this.b.getChildAt(i2);
                if ((childAt instanceof ThreadCardView) && (childAt.getTag() instanceof ThreadCardViewHolder) && (threadCardViewHolder = (ThreadCardViewHolder) childAt.getTag()) != null && threadCardViewHolder.a() != null && (threadCardViewHolder.a().f() instanceof du)) {
                    ((du) threadCardViewHolder.a().f()).P();
                }
            }
        }
    }

    public void setViewForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            setViewForeground(false);
            if (P0) {
                this.i.k(false);
            } else {
                vc8 vc8Var = this.n;
                if (vc8Var != null) {
                    vc8Var.G0(false);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            if (this.B < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
                SafeHandler.getInst().postDelayed(this.G0, 1000L);
            }
            if (gf8.a.a()) {
                b1();
            }
            this.W = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.xu5
    @Nullable
    public zu5 b(@NonNull String str, @Nullable String str2) {
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
                                oi oiVar = this.b.getData().get(findFirstVisibleItemPosition);
                                if (oiVar instanceof pe8) {
                                    return x0(str2, findFirstVisibleItemPosition, (pe8) oiVar);
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
        return (zu5) invokeLL.objValue;
    }

    public final void f1(String str, String str2) {
        ThreadCardViewHolder threadCardViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048609, this, str, str2) == null) {
            for (int i2 = 0; i2 < this.b.getChildCount(); i2++) {
                View childAt = this.b.getChildAt(i2);
                if ((childAt instanceof ThreadCardView) && (childAt.getTag() instanceof ThreadCardViewHolder) && (threadCardViewHolder = (ThreadCardViewHolder) childAt.getTag()) != null && threadCardViewHolder.a() != null && (threadCardViewHolder.a().f() instanceof du)) {
                    if (lh5.b.a().a("show_reply_tip") && "home_reply".equals(str2)) {
                        ((du) threadCardViewHolder.a().f()).O();
                    } else if (lh5.b.a().a("show_agree_tip") && "home_agree".equals(str2)) {
                        ((du) threadCardViewHolder.a().f()).N();
                    }
                    SharedPrefHelper.getInstance().putBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount(qd7.a(str, str2)), false);
                    return;
                }
            }
        }
    }

    public final void k1(View view2, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048615, this, view2, str, z2) == null) {
            if (this.s == null) {
                this.s = new vj5(getContext(), new l0(this));
            }
            this.s.attachView(view2, z2);
            this.s.o();
            so5.a.a(this.V, new Pair<>(PushMessageHelper.ERROR_TYPE, "home_recommend"), new Pair<>("error_info", "home recommend net error"));
            yja.a("main", false);
        }
    }

    @NonNull
    public final zu5 x0(@Nullable String str, int i2, @NonNull pe8 pe8Var) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048638, this, str, i2, pe8Var)) == null) {
            zu5 b2 = zu5.b();
            if (this.b == null) {
                return b2;
            }
            if (qd.isEmpty(str)) {
                return w0(this.b.getChildAt(i2));
            }
            View view2 = null;
            if (ke8.a(str).b().equals(pe8Var.a)) {
                view2 = this.b.getChildAt(i2);
            }
            return w0(view2);
        }
        return (zu5) invokeLIL.objValue;
    }

    public void m1(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048617, this, str, str2) != null) || this.b == null) {
            return;
        }
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.a;
        if (bigdaySwipeRefreshLayout != null && bigdaySwipeRefreshLayout.t()) {
            this.a.r();
        }
        int i2 = -1;
        de8 de8Var = this.k;
        if (de8Var == null) {
            return;
        }
        List<oi> k2 = de8Var.k();
        if (!ListUtils.isEmpty(k2)) {
            int i3 = 0;
            while (true) {
                if (i3 >= k2.size()) {
                    break;
                } else if (k2.get(i3) instanceof nm6) {
                    i2 = i3;
                    break;
                } else {
                    i3++;
                }
            }
        }
        View childAt = this.b.getChildAt(i2);
        if (i2 >= 0 && childAt != null && L0(i2)) {
            int[] iArr = new int[2];
            this.b.getLocationOnScreen(iArr);
            int i4 = iArr[1];
            int[] iArr2 = new int[2];
            childAt.getLocationOnScreen(iArr2);
            int i5 = iArr2[1];
            if (i5 == i4) {
                f1(str, str2);
                return;
            }
            this.Q = true;
            this.b.smoothScrollBy(0, i5 - i4);
            return;
        }
        this.Q = true;
        this.b.smoothScrollToPosition(i2);
    }

    public void n1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z2) == null) {
            if (P0) {
                this.h.f();
                j1(true);
                Z0();
            } else {
                r0(z2);
            }
            if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
                vv4.i().j();
                vv4.i().k();
            }
        }
    }

    public void o1(DataRes dataRes, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{dataRes, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            UiUtils.runOnUiThread(new j0(this));
            vc8 vc8Var = this.n;
            if (vc8Var != null) {
                vc8Var.K0(z2, z3, dataRes, 0, null);
            }
        }
    }

    public final void t0(int i2) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048634, this, i2) == null) {
            if (this.a.u() && !PermissionUtil.isBrowseMode()) {
                if (i2 > 0) {
                    string = String.format(this.l.getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i2));
                } else {
                    string = this.l.getString(R.string.recommend_frs_refresh_nodata);
                }
                this.a.z(new f55.i(string, 0));
                return;
            }
            this.a.setRefreshing(false);
        }
    }

    public final zu5 w0(@Nullable View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, view2)) == null) {
            zu5 b2 = zu5.b();
            if (getContext() != null && view2 != null) {
                Rect rect = new Rect();
                view2.getGlobalVisibleRect(rect);
                if (rect.left <= BdUtilHelper.getEquipmentWidth(getContext()) && rect.right >= 0) {
                    int i2 = rect.left;
                    int i3 = rect.top;
                    return new zu5(true, i2, i3, rect.right - i2, rect.bottom - i3);
                }
            }
            return b2;
        }
        return (zu5) invokeL.objValue;
    }

    public final int v0(@NonNull String str, @NonNull List<za7<?>> list) {
        InterceptResult invokeLL;
        e57<?> e57Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048636, this, str, list)) == null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                za7<?> za7Var = list.get(i2);
                if ((za7Var instanceof v47) && (e57Var = ((v47) za7Var).c) != null && str.equals(e57Var.m())) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public final void y0(List<Integer> list, String str, c67 c67Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048639, this, list, str, c67Var) == null) && list != null && c67Var != null) {
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
            if (c67Var.g() == 0) {
                i2 = 1;
            } else if (c67Var.g() == 40) {
                i2 = 2;
            } else if (c67Var.g() == 49 || c67Var.g() == 69) {
                i2 = 3;
            }
            de8 de8Var = this.k;
            if (de8Var != null) {
                de8Var.n();
            }
            Q0();
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.NEG_FEEDBACK_KEY).param("tid", c67Var.h()).param("nid", c67Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", c67Var.d()).param("obj_param1", c67Var.i()).param("obj_source", c67Var.f()).param("obj_id", c67Var.a()).param("obj_type", sb.toString()).param("obj_name", str).param(TiebaStatic.Params.OBJ_PARAM2, i2).param("obj_locate", "1"));
        }
    }
}
