package com.baidu.tieba.homepage.personalize;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.fluency.BdTracesManager;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.searchbox.performance.speed.SpeedStats;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.FollowUserButton;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.switchs.BigdaySwitch;
import com.baidu.tbadk.switchs.LaunchViewOptSwitch;
import com.baidu.tbadk.switchs.MainTabDataSwitch;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tbadk.widget.RightFloatLayerLottieView;
import com.baidu.tbadk.widget.RightFloatLayerView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.adapter.HomePageCardVideoViewHolder;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.homepage.personalize.data.CheckInterestCommitResponseMessage;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ai4;
import com.repackage.ai5;
import com.repackage.ax4;
import com.repackage.b9;
import com.repackage.bv6;
import com.repackage.bw5;
import com.repackage.cw5;
import com.repackage.d85;
import com.repackage.dx6;
import com.repackage.ex6;
import com.repackage.f85;
import com.repackage.f9;
import com.repackage.ft4;
import com.repackage.fv6;
import com.repackage.gb5;
import com.repackage.gw5;
import com.repackage.ji;
import com.repackage.jm4;
import com.repackage.jn;
import com.repackage.km4;
import com.repackage.kp6;
import com.repackage.kx6;
import com.repackage.li;
import com.repackage.lo4;
import com.repackage.lw6;
import com.repackage.mg;
import com.repackage.mw6;
import com.repackage.mx6;
import com.repackage.nb;
import com.repackage.nv4;
import com.repackage.nw6;
import com.repackage.qg;
import com.repackage.qs6;
import com.repackage.rs6;
import com.repackage.s35;
import com.repackage.t35;
import com.repackage.x8;
import com.repackage.ys4;
import com.repackage.yw6;
import com.repackage.ze8;
import com.repackage.zq4;
import com.repackage.zw5;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import tbclient.Personalized.DataRes;
/* loaded from: classes3.dex */
public class PersonalizePageView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public View.OnClickListener A0;
    public boolean B;
    public CustomMessageListener B0;
    public int C;
    public CustomMessageListener C0;
    public LinearLayoutManager D;
    public CustomMessageListener D0;
    public FRSRefreshButton E;
    public RightFloatLayerView F;
    public int G;
    public volatile boolean H;
    public FrameLayout I;
    public boolean J;
    public boolean K;
    public boolean L;
    public Context M;
    public int N;
    public int O;
    public yw6 P;
    public boolean Q;
    public Object R;
    public boolean S;
    public lw6.f T;
    public CustomMessageListener U;
    public CustomMessageListener V;
    public HttpMessageListener W;
    public BigdaySwipeRefreshLayout a;
    public BdTypeRecyclerView b;
    public nw6 c;
    public mw6 d;
    public k0 e;
    public PbListView f;
    public lw6 g;
    public NEGFeedBackView.b g0;
    public TbPageContext<?> h;
    public FollowUserButton.a h0;
    public rs6 i;
    public ScrollFragmentTabHost i0;
    public fv6 j;
    public int j0;
    public bv6 k;
    public RecyclerView.OnScrollListener k0;
    public dx6 l;
    public ScrollFragmentTabHost.x l0;
    public long m;
    public View.OnClickListener m0;
    public s35 n;
    public View.OnClickListener n0;
    public t35 o;
    public CustomMessageListener o0;
    public long p;
    public CustomMessageListener p0;
    public int q;
    public fv6.p0 q0;
    public boolean r;
    public ft4.g r0;
    public boolean s;
    public ft4.h s0;
    public long t;
    public ft4.e t0;
    public boolean u;
    public ft4.f u0;
    public boolean v;
    public Runnable v0;
    public cw5 w;
    public final CustomMessageListener w0;
    public bw5 x;
    public View.OnClickListener x0;
    public boolean y;
    public CustomMessageListener y0;
    public int z;
    public CustomMessageListener z0;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public a(PersonalizePageView personalizePageView) {
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
                if (this.a.b != null && this.a.x != null) {
                    this.a.b.removeHeaderView(this.a.x.b());
                    this.a.Q = false;
                    mx6.a(2);
                    Activity currentActivity = TbadkApplication.getInst().getCurrentActivity();
                    if (currentActivity != null) {
                        BdTopToast bdTopToast = new BdTopToast(currentActivity, 2000);
                        bdTopToast.i(true);
                        bdTopToast.h(currentActivity.getString(R.string.obfuscated_res_0x7f0f0f73));
                        bdTopToast.j((ViewGroup) currentActivity.findViewById(16908290));
                    }
                }
                mx6.i();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a0(PersonalizePageView personalizePageView, int i) {
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
                this.a.a0();
                if (this.a.b != null && this.a.x != null) {
                    this.a.b.removeHeaderView(this.a.x.b());
                }
                Activity c = x8.g().c("MainTabActivity");
                if (c != null) {
                    BdTopToast bdTopToast = new BdTopToast(c, 2000);
                    bdTopToast.i(true);
                    bdTopToast.h(c.getString(R.string.obfuscated_res_0x7f0f0f73));
                    bdTopToast.j((ViewGroup) c.findViewById(16908290));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PersonalizePageView personalizePageView, int i) {
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
                if (TbSingleton.getInstance().isAddBanner || !mx6.e()) {
                    this.a.A0();
                } else if (this.a.P == null) {
                    this.a.P = new yw6();
                    this.a.P.c();
                }
                PersonalizePageView personalizePageView = this.a;
                personalizePageView.J = true;
                if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW || personalizePageView.K) {
                    return;
                }
                personalizePageView.j0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b0(PersonalizePageView personalizePageView, int i) {
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
                this.a.e0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PersonalizePageView personalizePageView, int i) {
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            PersonalizePageView personalizePageView = this.a;
            if (personalizePageView.J && !personalizePageView.K) {
                personalizePageView.j0();
            }
            if (this.a.u) {
                PersonalizePageView personalizePageView2 = this.a;
                if (personalizePageView2.L) {
                    return;
                }
                personalizePageView2.L = true;
                SpeedStats.getInstance().onMainPageStatsEnd(this.a.getContext());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c0(PersonalizePageView personalizePageView, int i) {
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
                    if (this.a.S) {
                        this.a.S = false;
                        this.a.F0();
                    }
                } else if (this.a.F == null || this.a.F.getVisibility() != 0) {
                } else {
                    this.a.S = true;
                    this.a.e0();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements fv6.p0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ PersonalizePageView b;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ String b;
            public final /* synthetic */ d c;

            public a(d dVar, int i, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, Integer.valueOf(i), str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = dVar;
                this.a = i;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.c.b.b0();
                    if (this.a != 1) {
                        if (this.c.a) {
                            this.c.g();
                            this.c.b.G0();
                            return;
                        }
                        this.c.b.a.setVisibility(8);
                        PersonalizePageView personalizePageView = this.c.b;
                        personalizePageView.E0(personalizePageView, this.b, true);
                    } else {
                        if (ji.z()) {
                            this.c.b.h.showToast(this.b);
                        }
                        this.c.g();
                    }
                    kx6.a("mINetLoadCallbackError" + this.a);
                    kx6.b();
                    nb.b().d();
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ boolean a;
            public final /* synthetic */ d b;

            public b(d dVar, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = dVar;
                this.a = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.g();
                    this.b.b.a.setVisibility(0);
                    this.b.b.b0();
                    this.b.b.c0();
                    this.b.b.s = true;
                    if (this.a) {
                        this.b.b.t = System.currentTimeMillis();
                    }
                    kx6.a("showSuccess");
                    kx6.b();
                }
            }
        }

        /* loaded from: classes3.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public c(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.b.f == null) {
                    return;
                }
                this.a.b.f.C(this.a.b.getContext().getString(R.string.obfuscated_res_0x7f0f0f87));
                this.a.b.f.f();
                this.a.b.f.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
        }

        public d(PersonalizePageView personalizePageView) {
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
            this.a = ys4.k().h("key_first_install", true);
        }

        @Override // com.repackage.fv6.p0
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                qg.b(new b(this, z));
            }
        }

        @Override // com.repackage.fv6.p0
        public void b(int i, gb5 gb5Var, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), gb5Var, Integer.valueOf(i2)}) == null) {
                if (this.b.i != null) {
                    boolean l0 = this.b.l0();
                    this.b.c0();
                    if (l0) {
                        this.b.C0(true);
                    }
                    this.b.i.c(i, gb5Var, i2);
                    ai4.f().m();
                    return;
                }
                PersonalizePageView personalizePageView = this.b;
                personalizePageView.E0(personalizePageView, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c33), true);
                this.b.b0();
            }
        }

        @Override // com.repackage.fv6.p0
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                qg.b(new c(this));
            }
        }

        @Override // com.repackage.fv6.p0
        public void d(int i, int i2, gb5 gb5Var, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), gb5Var, Integer.valueOf(i3)}) == null) || this.b.i == null) {
                return;
            }
            PersonalizePageView personalizePageView = this.b;
            if (personalizePageView.m0(personalizePageView.b)) {
                this.b.m = System.currentTimeMillis();
            }
            this.b.i.d(i, i2, gb5Var, i3);
        }

        public final void g() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.a) {
                this.a = false;
                ys4.k().u("key_first_install", false);
            }
        }

        @Override // com.repackage.fv6.p0
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) {
                qg.b(new a(this, i, str));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d0(PersonalizePageView personalizePageView, int i) {
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Integer) {
                this.a.G = ((Integer) data).intValue();
                if (this.a.F != null) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.F.getLayoutParams();
                    layoutParams.gravity = 85;
                    layoutParams.bottomMargin = li.f(this.a.M, R.dimen.tbds306) + this.a.G;
                    this.a.F.requestLayout();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public e(PersonalizePageView personalizePageView) {
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.h == null) {
                return;
            }
            kp6.j().y(this.a.h.getPageActivity());
        }
    }

    /* loaded from: classes3.dex */
    public class e0 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e0(PersonalizePageView personalizePageView, int i) {
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
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003514 && (httpResponsedMessage instanceof CheckInterestCommitResponseMessage)) {
                CheckInterestCommitResponseMessage checkInterestCommitResponseMessage = (CheckInterestCommitResponseMessage) httpResponsedMessage;
                this.a.N = checkInterestCommitResponseMessage.getFinishInterestStage();
                this.a.O = checkInterestCommitResponseMessage.getPersonalizedSwitchStatus();
                PersonalizePageView personalizePageView = this.a;
                if (mx6.f(personalizePageView.N, personalizePageView.O)) {
                    this.a.B0();
                } else {
                    this.a.A0();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv4 a;
        public final /* synthetic */ PersonalizePageView b;

        public f(PersonalizePageView personalizePageView, nv4 nv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, nv4Var};
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
            this.a = nv4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a == null || this.b.F == null) {
                return;
            }
            this.b.F.g(this.a);
            this.b.F.setAutoCompleteShown(false);
        }
    }

    /* loaded from: classes3.dex */
    public class f0 implements NEGFeedBackView.b {
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

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void a(ArrayList<Integer> arrayList, String str, lo4 lo4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, lo4Var) == null) || arrayList == null || lo4Var == null) {
                return;
            }
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
            int i3 = lo4Var.n;
            if (i3 == 0) {
                i = 1;
            } else if (i3 == 40) {
                i = 2;
            } else if (i3 == 49 || i3 == 69) {
                i = 3;
            }
            if (this.a.g != null) {
                this.a.g.k();
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.NEG_FEEDBACK_KEY).param("tid", lo4Var.f()).param("nid", lo4Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", lo4Var.c()).param("obj_param1", lo4Var.k).param("obj_source", lo4Var.l).param("obj_id", lo4Var.m).param("obj_type", sb.toString()).param("obj_name", str).param(TiebaStatic.Params.OBJ_PARAM2, i).param("obj_locate", "1"));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(lo4 lo4Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lo4Var, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(lo4 lo4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lo4Var) == null) || lo4Var == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.NEG_FEEDBACK_KEY).param("obj_locate", "1").param("fid", lo4Var.c()).param("tid", lo4Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("nid", lo4Var.e()));
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.NEGATIVE_FEEDBACK_OPEN_CLICK).param("obj_locate", "1").param("fid", lo4Var.c()).param("tid", lo4Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv4 a;
        public final /* synthetic */ PersonalizePageView b;

        public g(PersonalizePageView personalizePageView, nv4 nv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, nv4Var};
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
            this.a = nv4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.F.setHomePbFloatLastCloseTime();
                this.b.d0();
                this.b.F.u(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g0 implements FollowUserButton.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public g0(PersonalizePageView personalizePageView) {
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null) {
                return;
            }
            Object tag = view2.getTag();
            if (tag instanceof ThreadData) {
                TiebaStatic.log(ze8.j("c13696", (ThreadData) tag));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements ft4.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public h(PersonalizePageView personalizePageView) {
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

        @Override // com.repackage.ft4.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.B = true;
                ai5.c().f("page_recommend");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
                this.a.j.update();
                this.a.j.V0(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h0 extends RecyclerView.OnScrollListener {
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

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) || this.a.j0 == i || this.a.i0 == null) {
                return;
            }
            this.a.j0 = i;
            if (this.a.j0 == 1) {
                this.a.i0.Y();
            } else if (this.a.w0(recyclerView)) {
                this.a.i0.C();
            } else {
                this.a.i0.Y();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements ft4.h {
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

        @Override // com.repackage.ft4.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.j == null || this.a.j.l0() == null) {
                return;
            }
            this.a.j.l0().x();
        }
    }

    /* loaded from: classes3.dex */
    public class i0 extends ScrollFragmentTabHost.x {
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

        @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.x
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.i0 == null) {
                return;
            }
            this.a.j0 = -1;
            PersonalizePageView personalizePageView = this.a;
            if (personalizePageView.w0(personalizePageView.b)) {
                this.a.i0.C();
            } else {
                this.a.i0.Y();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements ft4.e {
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

        @Override // com.repackage.ft4.e
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.B) {
                this.a.A = 0;
                this.a.C = 1;
                this.a.B = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.b == null) {
                return;
            }
            this.a.b.removeHeaderView(this.a.w.b());
        }
    }

    /* loaded from: classes3.dex */
    public class k implements lw6.f {
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

        @Override // com.repackage.lw6.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (TbSingleton.getInstance().isAddBanner) {
                    if (this.a.b != null && this.a.w != null) {
                        this.a.b.removeHeaderView(this.a.w.b());
                    }
                    if (this.a.b == null || this.a.x == null) {
                        return;
                    }
                    this.a.b.removeHeaderView(this.a.x.b());
                    return;
                }
                if (mx6.e()) {
                    PersonalizePageView personalizePageView = this.a;
                    if (personalizePageView.N == -1 && personalizePageView.O == -1) {
                        return;
                    }
                }
                this.a.A0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface k0 {
        void e(ft4.g gVar);

        void g(ft4.h hVar);

        void k(ft4.e eVar);

        void m(ft4.f fVar);
    }

    /* loaded from: classes3.dex */
    public class l implements ft4.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public l(PersonalizePageView personalizePageView) {
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

        @Override // com.repackage.ft4.f
        public void a(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (this.a.j != null) {
                    this.a.j.V0(true);
                    this.a.j.M0();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, Boolean.TRUE));
                jm4 jm4Var = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > ys4.k().m("key_bigday_next_showtime_home", 0L)) {
                    jm4Var = km4.i().h(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, jm4Var));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public m(PersonalizePageView personalizePageView) {
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
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                if (this.a.D != null && i == 0) {
                    int i2 = 3;
                    int height = ((WindowManager) this.a.getContext().getSystemService("window")).getDefaultDisplay().getHeight() * 3;
                    if (this.a.A < height || this.a.C != 1) {
                        if (this.a.A < height && this.a.C == 2) {
                            this.a.C = 1;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        }
                    } else {
                        this.a.C = 2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(this.a.C)));
                    }
                    ax4 wlConfigData = TbSingleton.getInstance().getWlConfigData();
                    if (UbsABTestHelper.isLoadMoreABTest() && wlConfigData != null && wlConfigData.H() != 0) {
                        i2 = wlConfigData.H();
                    }
                    if (this.a.D.getItemCount() - this.a.D.findLastVisibleItemPosition() <= i2 * 5) {
                        this.a.n0();
                    }
                }
                if (i == 0) {
                    if (this.a.F != null) {
                        this.a.F.q();
                    }
                    if (this.a.R != null) {
                        BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(this.a.R);
                        this.a.R = null;
                    }
                } else if (i == 1) {
                    if (this.a.R == null) {
                        this.a.R = BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_HOME, "1", "scroll");
                    }
                    if (this.a.F != null) {
                        this.a.F.p();
                    }
                } else if (i == 2) {
                    if (this.a.R == null) {
                        this.a.R = BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_HOME, "1", "scroll");
                    }
                    if (this.a.F != null) {
                        this.a.F.r();
                    }
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                this.a.A += i2;
                if (this.a.E != null) {
                    jn C = this.a.b.C(this.a.D.findLastVisibleItemPosition());
                    if (C instanceof zw5) {
                        if (((zw5) C).position >= 6) {
                            this.a.E.f();
                        } else {
                            this.a.E.b();
                        }
                    }
                }
                if (!UbsABTestHelper.isHomePagePromoteLoginUbsABTestA() || TbadkCoreApplication.isLogin() || ys4.k().l("home_page_login_dialog_show_key", 0) != 0 || this.a.A < li.q(TbadkCoreApplication.getInst().getContext())[1] * 2) {
                    return;
                }
                ys4.k().w("home_page_login_dialog_show_key", 1);
                DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.M, LoginDialogData.HOME_PAGE_RESULT_PAGE));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

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
            this.a = personalizePageView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.n0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o implements BdListView.o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

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
            this.a = personalizePageView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.o
        public void onScrollStop(int i, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) || System.currentTimeMillis() - this.a.p < 5000) {
                return;
            }
            this.a.j.L0(i, i2);
        }
    }

    /* loaded from: classes3.dex */
    public class p implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

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
            this.a = personalizePageView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || viewHolder == null || (view2 = viewHolder.itemView) == null) {
                return;
            }
            if (this.a.j != null && this.a.j.l0() != null) {
                this.a.j.l0().k(view2);
            }
            if (view2.getTag() instanceof HomePageCardVideoViewHolder) {
                ((HomePageCardVideoViewHolder) view2.getTag()).c().stopPlay();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public q(PersonalizePageView personalizePageView) {
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f == null) {
                return;
            }
            this.a.f.C(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0dc7));
            this.a.f.f();
            this.a.f.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    /* loaded from: classes3.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.j == null) {
                return;
            }
            this.a.j.update();
        }
    }

    /* loaded from: classes3.dex */
    public class s implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.h == null) {
                return;
            }
            ys4.k().w("show_is_uninterest_tag", PersonalizePageView.K(this.a));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(this.a.h.getContext(), 2)));
        }
    }

    /* loaded from: classes3.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ t a;

            public a(t tVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {tVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = tVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.p0();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(PersonalizePageView personalizePageView, int i) {
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
                    mg.a().postDelayed(new a(this), TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class u implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.n0();
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (this.a.j != null) {
                    this.a.H0(zq4.b().c(), false, false);
                }
                this.a.b0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class w extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(PersonalizePageView personalizePageView, int i) {
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (!(data instanceof String) || TextUtils.isEmpty((String) data)) {
                return;
            }
            this.a.r = true;
        }
    }

    /* loaded from: classes3.dex */
    public class x extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x(PersonalizePageView personalizePageView, int i) {
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
                this.a.h0(customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class y implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jm4 a;
        public final /* synthetic */ PersonalizePageView b;

        public y(PersonalizePageView personalizePageView, jm4 jm4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, jm4Var};
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
            this.a = jm4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.c.I(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class z implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.E == null) {
                return;
            }
            this.a.E.b();
            this.a.x0();
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
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = 0L;
        this.q = 3;
        this.r = false;
        this.s = false;
        this.t = -1L;
        this.u = false;
        this.v = false;
        this.y = false;
        this.z = 0;
        this.A = 0;
        this.B = false;
        this.C = 1;
        this.H = false;
        this.J = false;
        this.K = false;
        this.L = false;
        this.N = -1;
        this.O = -1;
        this.Q = false;
        this.S = false;
        this.T = new k(this);
        this.U = new v(this, 2921456);
        this.V = new d0(this, 2921553);
        this.W = new e0(this, CmdConfigHttp.CMD_CHECK_INTEREST_COMMIT);
        this.g0 = new f0(this);
        this.h0 = new g0(this);
        this.j0 = -1;
        this.k0 = new h0(this);
        this.l0 = new i0(this);
        this.m0 = new j0(this);
        this.n0 = new a(this);
        this.o0 = new b(this, 2001371);
        this.p0 = new c(this, 2921636);
        this.q0 = new d(this);
        this.r0 = new h(this);
        this.s0 = new i(this);
        this.t0 = new j(this);
        this.u0 = new l(this);
        this.v0 = new s(this);
        this.w0 = new t(this, 2001118);
        this.x0 = new u(this);
        this.y0 = new w(this, 2921033);
        this.z0 = new x(this, 2921349);
        this.A0 = new z(this);
        this.B0 = new a0(this, 2921632);
        this.C0 = new b0(this, 2921664);
        this.D0 = new c0(this, 2921667);
        k0(context);
    }

    public static /* synthetic */ int K(PersonalizePageView personalizePageView) {
        int i2 = personalizePageView.z + 1;
        personalizePageView.z = i2;
        return i2;
    }

    public final void A0() {
        cw5 cw5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b == null || (cw5Var = this.w) == null || cw5Var.b().getParent() != null || StringUtils.isNull(TbSingleton.getInstance().getLFUser()) || TbSingleton.getInstance().isAddBanner || this.Q) {
            return;
        }
        this.w.d();
        this.w.b().setVisibility(0);
        this.w.f("1");
        this.b.setHeaderView(this.w.b());
    }

    public final void B0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.b == null) {
            return;
        }
        if (this.x == null) {
            bw5 bw5Var = new bw5(getContext());
            this.x = bw5Var;
            bw5Var.a().setOnClickListener(this.n0);
        }
        this.b.setHeaderView(this.x.b());
        this.Q = true;
        mx6.b();
        cw5 cw5Var = this.w;
        if (cw5Var != null) {
            this.b.removeHeaderView(cw5Var.b());
        }
    }

    public final void C0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z2) == null) {
            if (this.n == null) {
                this.n = new s35(getContext());
                this.n.p(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + li.f(getContext(), R.dimen.tbds60));
                this.n.i();
                this.n.setWrapStyle(true);
                this.n.onChangeSkinType();
            }
            this.n.attachView(this, z2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, Boolean.FALSE));
            this.b.setNextPage(null);
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.a;
            if (bigdaySwipeRefreshLayout != null) {
                bigdaySwipeRefreshLayout.setVisibility(8);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921457, this.h.getUniqueId()));
        }
    }

    public final void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            mg.a().post(new e(this));
        }
    }

    public final void E0(View view2, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048580, this, view2, str, z2) == null) {
            if (this.o == null) {
                this.o = new t35(getContext(), new r(this));
            }
            this.o.attachView(view2, z2);
            this.o.p();
        }
    }

    public void F0() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (rightFloatLayerView = this.F) == null) {
            return;
        }
        rightFloatLayerView.d();
    }

    public void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.j != null) {
                if (!MainTabDataSwitch.isCacheOpen() && ex6.m().n()) {
                    C0(true);
                }
                this.j.update();
            }
            if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
                km4.i().j();
                km4.i().k();
            }
        }
    }

    public void H0(DataRes dataRes, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{dataRes, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            qg.b(new q(this));
            this.j.E0(z2, z3, dataRes, 0, null);
        }
    }

    public void I0(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i2) == null) {
            PbListView pbListView = this.f;
            if (pbListView != null) {
                pbListView.C(getContext().getString(R.string.obfuscated_res_0x7f0f0dc7));
                this.f.f();
                this.f.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            this.j.E0(true, false, null, i2, str);
        }
    }

    public final boolean J0(nv4 nv4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, nv4Var)) == null) {
            if (!RightFloatLayerView.k()) {
                d0();
                return false;
            } else if (nv4Var == null) {
                return false;
            } else {
                if (this.F == null) {
                    this.F = RightFloatLayerLottieView.F(nv4Var, this.M);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 85;
                    layoutParams.bottomMargin = li.f(this.M, R.dimen.tbds306) + this.G;
                    this.F.c();
                    addView(this.F, layoutParams);
                }
                this.F.setAutoCompleteShown(true);
                if (nv4Var.a()) {
                    return false;
                }
                this.F.setData(nv4Var);
                this.F.setLogoListener(new f(this, nv4Var));
                this.F.setFeedBackListener(new g(this, nv4Var));
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public void Y() {
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (bigdaySwipeRefreshLayout = this.a) == null) {
            return;
        }
        bigdaySwipeRefreshLayout.r();
    }

    public void Z(Long l2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, l2) == null) {
            this.j.d0(l2);
        }
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.o != null) {
                x0();
                return;
            }
            fv6 fv6Var = this.j;
            if (fv6Var != null) {
                fv6Var.update();
            }
        }
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            s35 s35Var = this.n;
            if (s35Var != null) {
                s35Var.dettachView(this);
                this.n = null;
                this.b.setNextPage(this.f);
                this.f.C(getContext().getString(R.string.obfuscated_res_0x7f0f0dc7));
                this.f.f();
                this.f.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, Boolean.TRUE));
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.a;
            if (bigdaySwipeRefreshLayout != null) {
                bigdaySwipeRefreshLayout.setVisibility(0);
            }
            rs6 rs6Var = this.i;
            if (rs6Var != null) {
                rs6Var.b();
            }
            if (this.m != 0) {
                this.m = 0L;
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_PERSONALIZE_LOAD_MORE);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param(TiebaStatic.Params.OBJ_DURATION, new DecimalFormat("#.00").format(((System.currentTimeMillis() - this.m) * 1.0d) / 1000.0d));
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public final void c0() {
        t35 t35Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (t35Var = this.o) == null) {
            return;
        }
        t35Var.dettachView(this);
        this.o = null;
    }

    public void d0() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (rightFloatLayerView = this.F) == null) {
            return;
        }
        rightFloatLayerView.c();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, canvas) == null) {
            super.dispatchDraw(canvas);
            if (this.s) {
                if (!this.v) {
                    this.v = true;
                }
                u0();
            }
        }
    }

    public final void e0() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (rightFloatLayerView = this.F) == null) {
            return;
        }
        rightFloatLayerView.setAutoCompleteShown(false);
        this.F.clearAnimation();
        this.F.setVisibility(8);
    }

    public synchronized void f0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, context) == null) {
            synchronized (this) {
                if (this.H) {
                    return;
                }
                this.H = true;
                this.M = context;
                MessageManager.getInstance().registerListener(this.p0);
                MessageManager.getInstance().registerListener(this.o0);
                MessageManager.getInstance().registerListener(this.U);
                MessageManager.getInstance().registerListener(this.V);
                MessageManager.getInstance().registerListener(this.z0);
                MessageManager.getInstance().registerListener(this.y0);
                MessageManager.getInstance().registerListener(this.W);
                MessageManager.getInstance().registerListener(this.B0);
                MessageManager.getInstance().registerListener(this.C0);
                MessageManager.getInstance().registerListener(this.D0);
                b9<?> a2 = f9.a(context);
                if (a2 instanceof TbPageContext) {
                    this.h = (TbPageContext) a2;
                }
                jm4 jm4Var = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > ys4.k().m("key_bigday_next_showtime_home", 0L)) {
                    jm4Var = km4.i().h(1);
                }
                if (LaunchViewOptSwitch.getIsOn()) {
                    try {
                        h0(jm4Var);
                    } catch (Exception unused) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, jm4Var));
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, jm4Var));
                }
                this.l = new dx6();
                lw6 lw6Var = new lw6(context, this.b);
                this.g = lw6Var;
                lw6Var.v(this.l);
                this.g.t(this.T);
                this.j = new fv6(this.h, this.b, this.g, this.a, this);
                this.k = new bv6(this.h);
                q0(TbadkCoreApplication.getInst().getSkinType());
                this.z = ys4.k().l("show_is_uninterest_tag", 0);
            }
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.g.s(this.g0);
            this.g.q(this.h0);
            this.j.U0(this.q0);
            this.k.i(this);
            i0();
            this.b.addOnScrollListener(new m(this));
            this.b.setOnSrollToBottomListener(new n(this));
            this.b.setOnScrollStopDelayedListener(new o(this), 1L);
            this.b.setRecyclerListener(new p(this));
            this.b.removeOnScrollListener(this.k0);
            this.b.addOnScrollListener(this.k0);
        }
    }

    public boolean getIsUnreadTipShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.y : invokeV.booleanValue;
    }

    public FrameLayout getmTaskFloatingView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.I : (FrameLayout) invokeV.objValue;
    }

    public final void h0(Object obj) {
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, obj) == null) || (bigdaySwipeRefreshLayout = this.a) == null || bigdaySwipeRefreshLayout.t()) {
            return;
        }
        if (!(obj != null && (obj instanceof jm4))) {
            mw6 mw6Var = this.d;
            if (mw6Var == null) {
                mw6 mw6Var2 = new mw6(this.h);
                this.d = mw6Var2;
                mw6Var2.H(this.q);
                this.e = this.d;
                i0();
            } else if (this.e == mw6Var) {
                return;
            } else {
                this.e = mw6Var;
            }
            this.d.A(true);
            this.a.setProgressView(this.d);
            int i2 = (int) (getResources().getDisplayMetrics().density * 86.0f);
            this.a.setCustomDistances(i2, i2, i2 * 2);
            return;
        }
        jm4 jm4Var = (jm4) obj;
        nw6 nw6Var = this.c;
        if (nw6Var == null) {
            nw6 nw6Var2 = new nw6(this.h.getContext());
            this.c = nw6Var2;
            this.e = nw6Var2;
            i0();
        } else if (this.e == nw6Var && jm4Var.equals(nw6Var.F())) {
            return;
        } else {
            this.e = this.c;
        }
        this.c.A(true);
        this.a.setProgressView(this.c);
        qg.b(new y(this, jm4Var));
        this.a.setCustomDistances((int) getResources().getDimension(R.dimen.tbds236), (int) (li.i(this.h.getContext()) * 0.8d), li.i(this.h.getContext()));
    }

    public void i0() {
        k0 k0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (k0Var = this.e) == null) {
            return;
        }
        k0Var.e(this.r0);
        this.e.g(this.s0);
        this.e.k(this.t0);
        this.e.m(this.u0);
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.K = true;
            nv4 homeAdFloatViewItemData = TbSingleton.getInstance().getHomeAdFloatViewItemData();
            if (!((homeAdFloatViewItemData == null || homeAdFloatViewItemData.a()) ? false : J0(homeAdFloatViewItemData))) {
                e0();
                D0();
                return;
            }
            kp6.j().t();
        }
    }

    public final void k0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, context) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = new BdTypeRecyclerView(context);
            this.b = bdTypeRecyclerView;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(bdTypeRecyclerView.getContext());
            this.D = linearLayoutManager;
            this.b.setLayoutManager(linearLayoutManager);
            this.b.setFadingEdgeLength(0);
            this.b.setOverScrollMode(2);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.b.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            cw5 cw5Var = new cw5(context);
            this.w = cw5Var;
            cw5Var.setFrom("from_personaize");
            this.w.a().setVisibility(0);
            this.w.a().setOnClickListener(this.m0);
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = new BigdaySwipeRefreshLayout(context);
            this.a = bigdaySwipeRefreshLayout;
            bigdaySwipeRefreshLayout.addView(this.b);
            PbListView pbListView = new PbListView(context);
            this.f = pbListView;
            pbListView.b();
            this.f.p(R.color.transparent);
            this.f.x();
            this.f.E(SkinManager.getColor(R.color.CAM_X0107));
            this.f.G(R.dimen.tbfontsize33);
            this.f.A(R.color.CAM_X0110);
            this.f.t(li.f(context, R.dimen.tbds182));
            this.f.B(this.x0);
            this.f.s();
            this.b.setNextPage(this.f);
            addView(this.a);
            if (TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
                this.E = new FRSRefreshButton(context);
                int f2 = li.f(context, R.dimen.tbds170);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f2, f2);
                layoutParams.gravity = 85;
                layoutParams.rightMargin = li.f(context, R.dimen.tbds24);
                layoutParams.bottomMargin = li.f(context, R.dimen.tbds180);
                addView(this.E, layoutParams);
                this.E.setOnClickListener(this.A0);
                this.E.setVisibility(8);
            }
            this.I = new FrameLayout(context);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 5;
            layoutParams2.topMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
            layoutParams2.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X011);
            addView(this.I, layoutParams2);
        }
    }

    public final boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            t35 t35Var = this.o;
            if (t35Var != null) {
                return t35Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean m0(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, recyclerView)) == null) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            return linearLayoutManager.getChildCount() > 0 && linearLayoutManager.findLastVisibleItemPosition() == linearLayoutManager.getItemCount() - 1 && recyclerView.getScrollState() == 0;
        }
        return invokeL.booleanValue;
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            qs6.d().j(System.currentTimeMillis(), 1);
            PbListView pbListView = this.f;
            if (pbListView != null && !pbListView.m()) {
                this.f.Q();
                this.f.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            this.j.x0();
        }
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.j.u0();
        }
    }

    public void p0() {
        lw6 lw6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (lw6Var = this.g) == null) {
            return;
        }
        lw6Var.k();
    }

    public void q0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            if (this.q != i2) {
                s35 s35Var = this.n;
                if (s35Var != null) {
                    s35Var.onChangeSkinType();
                }
                t35 t35Var = this.o;
                if (t35Var != null) {
                    t35Var.onChangeSkinType();
                }
                mw6 mw6Var = this.d;
                if (mw6Var != null) {
                    mw6Var.H(i2);
                }
                PbListView pbListView = this.f;
                if (pbListView != null) {
                    pbListView.E(SkinManager.getColor(R.color.CAM_X0109));
                    this.f.d(i2);
                }
                this.g.l(i2);
                fv6 fv6Var = this.j;
                if (fv6Var != null) {
                    fv6Var.C0(i2);
                }
                FRSRefreshButton fRSRefreshButton = this.E;
                if (fRSRefreshButton != null) {
                    fRSRefreshButton.d(i2);
                }
                cw5 cw5Var = this.w;
                if (cw5Var != null) {
                    cw5Var.e(i2);
                }
                RightFloatLayerView rightFloatLayerView = this.F;
                if (rightFloatLayerView != null) {
                    rightFloatLayerView.o();
                }
                bw5 bw5Var = this.x;
                if (bw5Var != null) {
                    bw5Var.d(i2);
                }
            }
            this.q = i2;
        }
    }

    public void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.p0);
            MessageManager.getInstance().unRegisterListener(this.o0);
            MessageManager.getInstance().unRegisterListener(this.U);
            MessageManager.getInstance().unRegisterListener(this.y0);
            MessageManager.getInstance().unRegisterListener(this.z0);
            MessageManager.getInstance().unRegisterListener(this.V);
            MessageManager.getInstance().unRegisterListener(this.W);
            MessageManager.getInstance().unRegisterListener(this.B0);
            MessageManager.getInstance().unRegisterListener(this.C0);
            MessageManager.getInstance().unRegisterListener(this.D0);
            this.j.D0();
            this.g.s(null);
            this.g.m();
            this.H = false;
            this.j.U0(null);
            nw6 nw6Var = this.c;
            if (nw6Var != null) {
                nw6Var.e(null);
                this.c.g(null);
                this.c.k(null);
                this.c.m(null);
                this.c.G();
            }
            mw6 mw6Var = this.d;
            if (mw6Var != null) {
                mw6Var.e(null);
                this.d.g(null);
                this.d.k(null);
                this.d.m(null);
                this.d.Y();
            }
            this.b.setOnSrollToBottomListener(null);
            ScrollFragmentTabHost scrollFragmentTabHost = this.i0;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.U(this.l0);
            }
            this.b.removeOnScrollListener(this.k0);
            s35 s35Var = this.n;
            if (s35Var != null) {
                s35Var.n();
            }
            this.b.setRecyclerListener(null);
            bv6 bv6Var = this.k;
            if (bv6Var != null) {
                bv6Var.g();
            }
            km4.i().e();
            mg.a().removeCallbacks(this.v0);
            yw6 yw6Var = this.P;
            if (yw6Var != null) {
                yw6Var.a();
            }
        }
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.j.G0();
            lw6 lw6Var = this.g;
            if (lw6Var != null) {
                lw6Var.n();
            }
            RightFloatLayerView rightFloatLayerView = this.F;
            if (rightFloatLayerView == null || !(rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                return;
            }
            ((RightFloatLayerLottieView) rightFloatLayerView).H(600);
        }
    }

    public void setCallback(rs6 rs6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, rs6Var) == null) {
            this.i = rs6Var;
        }
    }

    public void setIsUnreadTipShow(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z2) == null) {
            fv6 fv6Var = this.j;
            if (fv6Var != null) {
                fv6Var.S0(!z2);
            }
            this.y = z2;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, bdUniqueId) == null) {
            lw6 lw6Var = this.g;
            if (lw6Var != null) {
                lw6Var.u(bdUniqueId);
            }
            fv6 fv6Var = this.j;
            if (fv6Var != null) {
                fv6Var.N0(bdUniqueId);
            }
            dx6 dx6Var = this.l;
            if (dx6Var != null) {
                dx6Var.a(bdUniqueId);
            }
            mw6 mw6Var = this.d;
            if (mw6Var != null) {
                mw6Var.a0(bdUniqueId);
            }
            km4.i().n(bdUniqueId);
            CustomMessageListener customMessageListener = this.w0;
            if (customMessageListener != null) {
                customMessageListener.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.w0);
            }
            bv6 bv6Var = this.k;
            if (bv6Var != null) {
                bv6Var.h(bdUniqueId);
            }
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, scrollFragmentTabHost) == null) {
            this.i0 = scrollFragmentTabHost;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.U(this.l0);
                this.i0.z(this.l0);
            }
            fv6 fv6Var = this.j;
            if (fv6Var != null) {
                fv6Var.W0(scrollFragmentTabHost);
            }
            bv6 bv6Var = this.k;
            if (bv6Var != null) {
                bv6Var.j(scrollFragmentTabHost);
            }
        }
    }

    public void setTabInForeBackgroundState(boolean z2) {
        fv6 fv6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048614, this, z2) == null) || (fv6Var = this.j) == null) {
            return;
        }
        fv6Var.X0(z2);
    }

    public void setViewForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            setViewForeground(false);
            fv6 fv6Var = this.j;
            if (fv6Var != null) {
                fv6Var.A0(false);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            if (this.z >= 1 || !TbadkCoreApplication.getInst().isNoInterestTag()) {
                return;
            }
            mg.a().postDelayed(this.v0, 1000L);
        }
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            if (this.r) {
                x0();
                this.r = false;
            }
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.a;
            if (bigdaySwipeRefreshLayout != null) {
                bigdaySwipeRefreshLayout.D();
            }
            lw6 lw6Var = this.g;
            if (lw6Var != null) {
                lw6Var.o();
            }
            if (RightFloatLayerView.k()) {
                return;
            }
            e0();
        }
    }

    public final void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            if (!this.u) {
                long f2 = qs6.d().f(1) + qs6.d().b();
                long a2 = qs6.d().a(1);
                if (a2 > 0) {
                    f2 = System.currentTimeMillis() - a2;
                }
                f85 f85Var = new f85();
                f85Var.a();
                f85Var.b();
                d85.b().o(f2);
                if (this.t > 0) {
                    d85.b().E(System.currentTimeMillis() - this.t);
                }
                d85.b().I(f85Var.c());
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.SECOND_DRAW_DISPATCH_STAMP_KEY);
                if (!MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW && !this.L) {
                    this.L = true;
                    SpeedStats.getInstance().onMainPageStatsEnd(getContext());
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921637, ""));
            }
            this.u = true;
        }
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            fv6 fv6Var = this.j;
            if (fv6Var != null) {
                fv6Var.A0(true);
            }
            gw5.b().d(false);
            ai5.c().h("page_recommend", "show_");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            mg.a().removeCallbacks(this.v0);
        }
    }

    public boolean w0(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, recyclerView)) == null) ? recyclerView == null || !recyclerView.canScrollVertically(-1) : invokeL.booleanValue;
    }

    public void x0() {
        fv6 fv6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            fv6 fv6Var2 = this.j;
            if (fv6Var2 != null && fv6Var2.m0() != null) {
                this.j.m0().e();
            }
            if (this.o != null && (fv6Var = this.j) != null) {
                fv6Var.update();
                return;
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.b;
            if (bdTypeRecyclerView == null || this.a == null) {
                return;
            }
            bdTypeRecyclerView.setSelection(0);
            if (!this.a.t()) {
                fv6 fv6Var3 = this.j;
                if (fv6Var3 != null && fv6Var3.l0() != null) {
                    this.j.l0().x();
                    this.j.V0(false);
                }
                this.a.setRefreshing(true);
            }
            ScrollFragmentTabHost.x xVar = this.l0;
            if (xVar != null) {
                xVar.b();
            }
        }
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.j.R0();
        }
    }

    public void z0() {
        fv6 fv6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || (fv6Var = this.j) == null) {
            return;
        }
        fv6Var.Y0();
    }

    public void setViewForeground(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z2) == null) {
            fv6 fv6Var = this.j;
            if (fv6Var != null) {
                fv6Var.H0(z2);
            }
            ScrollFragmentTabHost scrollFragmentTabHost = this.i0;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.U(this.l0);
                this.i0.z(this.l0);
                this.l0.b();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.p = 0L;
        this.q = 3;
        this.r = false;
        this.s = false;
        this.t = -1L;
        this.u = false;
        this.v = false;
        this.y = false;
        this.z = 0;
        this.A = 0;
        this.B = false;
        this.C = 1;
        this.H = false;
        this.J = false;
        this.K = false;
        this.L = false;
        this.N = -1;
        this.O = -1;
        this.Q = false;
        this.S = false;
        this.T = new k(this);
        this.U = new v(this, 2921456);
        this.V = new d0(this, 2921553);
        this.W = new e0(this, CmdConfigHttp.CMD_CHECK_INTEREST_COMMIT);
        this.g0 = new f0(this);
        this.h0 = new g0(this);
        this.j0 = -1;
        this.k0 = new h0(this);
        this.l0 = new i0(this);
        this.m0 = new j0(this);
        this.n0 = new a(this);
        this.o0 = new b(this, 2001371);
        this.p0 = new c(this, 2921636);
        this.q0 = new d(this);
        this.r0 = new h(this);
        this.s0 = new i(this);
        this.t0 = new j(this);
        this.u0 = new l(this);
        this.v0 = new s(this);
        this.w0 = new t(this, 2001118);
        this.x0 = new u(this);
        this.y0 = new w(this, 2921033);
        this.z0 = new x(this, 2921349);
        this.A0 = new z(this);
        this.B0 = new a0(this, 2921632);
        this.C0 = new b0(this, 2921664);
        this.D0 = new c0(this, 2921667);
        k0(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalizePageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.p = 0L;
        this.q = 3;
        this.r = false;
        this.s = false;
        this.t = -1L;
        this.u = false;
        this.v = false;
        this.y = false;
        this.z = 0;
        this.A = 0;
        this.B = false;
        this.C = 1;
        this.H = false;
        this.J = false;
        this.K = false;
        this.L = false;
        this.N = -1;
        this.O = -1;
        this.Q = false;
        this.S = false;
        this.T = new k(this);
        this.U = new v(this, 2921456);
        this.V = new d0(this, 2921553);
        this.W = new e0(this, CmdConfigHttp.CMD_CHECK_INTEREST_COMMIT);
        this.g0 = new f0(this);
        this.h0 = new g0(this);
        this.j0 = -1;
        this.k0 = new h0(this);
        this.l0 = new i0(this);
        this.m0 = new j0(this);
        this.n0 = new a(this);
        this.o0 = new b(this, 2001371);
        this.p0 = new c(this, 2921636);
        this.q0 = new d(this);
        this.r0 = new h(this);
        this.s0 = new i(this);
        this.t0 = new j(this);
        this.u0 = new l(this);
        this.v0 = new s(this);
        this.w0 = new t(this, 2001118);
        this.x0 = new u(this);
        this.y0 = new w(this, 2921033);
        this.z0 = new x(this, 2921349);
        this.A0 = new z(this);
        this.B0 = new a0(this, 2921632);
        this.C0 = new b0(this, 2921664);
        this.D0 = new c0(this, 2921667);
        k0(context);
    }
}
