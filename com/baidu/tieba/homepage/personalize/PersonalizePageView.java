package com.baidu.tieba.homepage.personalize;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Looper;
import android.os.MessageQueue;
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
import c.a.o0.h0.e;
import c.a.o0.r.l0.f;
import c.a.o0.r.r.v0;
import c.a.o0.s.c.p0;
import c.a.p0.q1.i.e;
import c.a.p0.q1.i.h.d0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
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
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import tbclient.Personalized.DataRes;
/* loaded from: classes5.dex */
public class PersonalizePageView extends FrameLayout implements e.a, e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public RecPersonalizePageModel.c A0;
    public boolean B;
    public final CustomMessageListener B0;
    public int C;
    public View.OnClickListener C0;
    public LinearLayoutManager D;
    public CustomMessageListener D0;
    public c.a.d.o.e.l E;
    public CustomMessageListener E0;
    public FRSRefreshButton F;
    public View.OnClickListener F0;
    public RightFloatLayerView G;
    public CustomMessageListener G0;
    public int H;
    public CustomMessageListener H0;
    public boolean I;
    public CustomMessageListener I0;
    public boolean J;
    public FrameLayout K;
    public boolean L;
    public boolean M;
    public boolean N;
    public Context O;
    public int P;
    public int Q;
    public c.a.p0.q1.i.k.a R;
    public boolean S;
    public Object T;
    public boolean U;
    public CustomMessageListener V;
    public d0.g W;
    public BigdaySwipeRefreshLayout a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f33350b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.q1.i.i.b f33351c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.q1.i.i.a f33352d;

    /* renamed from: e  reason: collision with root package name */
    public m0 f33353e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f33354f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.q1.i.h.d0 f33355g;
    public CustomMessageListener g0;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext<?> f33356h;
    public CustomMessageListener h0;
    public c.a.p0.q1.e.c i;
    public HttpMessageListener i0;
    public c.a.p0.q1.i.e j;
    public NEGFeedBackView.b j0;
    public c.a.p0.q1.i.a k;
    public FollowUserButton.a k0;
    public c.a.p0.q1.i.k.f l;
    public ScrollFragmentTabHost l0;
    public long m;
    public int m0;
    public c.a.o0.f0.g n;
    public RecyclerView.OnScrollListener n0;
    public c.a.o0.f0.h o;
    public ScrollFragmentTabHost.v o0;
    public long p;
    public View.OnClickListener p0;
    public int q;
    public View.OnClickListener q0;
    public boolean r;
    public CustomMessageListener r0;
    public boolean s;
    public CustomMessageListener s0;
    public long t;
    public e.o0 t0;
    public boolean u;
    public f.g u0;
    public boolean v;
    public f.h v0;
    public c.a.p0.h0.q w;
    public f.e w0;
    public c.a.p0.h0.p x;
    public f.InterfaceC0828f x0;
    public boolean y;
    public Runnable y0;
    public int z;
    public RecPersonalizePageModel.c z0;

    /* loaded from: classes5.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f33350b == null) {
                return;
            }
            this.a.f33350b.removeHeaderView(this.a.w.b());
        }
    }

    /* loaded from: classes5.dex */
    public class a0 implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.F == null) {
                return;
            }
            this.a.F.b();
            this.a.F0();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public b(PersonalizePageView personalizePageView) {
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a.f33350b != null && this.a.x != null) {
                    this.a.f33350b.removeHeaderView(this.a.x.b());
                    this.a.S = false;
                    c.a.p0.q1.i.n.c.a(2);
                    Activity currentActivity = TbadkApplication.getInst().getCurrentActivity();
                    if (currentActivity != null) {
                        BdTopToast bdTopToast = new BdTopToast(currentActivity, 2000);
                        bdTopToast.i(true);
                        bdTopToast.h(currentActivity.getString(R.string.obfuscated_res_0x7f0f0f41));
                        bdTopToast.j((ViewGroup) currentActivity.findViewById(16908290));
                    }
                }
                c.a.p0.q1.i.n.c.i();
            }
        }
    }

    /* loaded from: classes5.dex */
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
                this.a.i0();
                if (this.a.f33350b != null && this.a.x != null) {
                    this.a.f33350b.removeHeaderView(this.a.x.b());
                }
                Activity c2 = c.a.d.a.b.g().c("MainTabActivity");
                if (c2 != null) {
                    BdTopToast bdTopToast = new BdTopToast(c2, 2000);
                    bdTopToast.i(true);
                    bdTopToast.h(c2.getString(R.string.obfuscated_res_0x7f0f0f41));
                    bdTopToast.j((ViewGroup) c2.findViewById(16908290));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (TbSingleton.getInstance().isAddBanner || !c.a.p0.q1.i.n.c.e()) {
                    this.a.J0();
                } else if (this.a.R == null) {
                    this.a.R = new c.a.p0.q1.i.k.a();
                    this.a.R.c();
                }
                PersonalizePageView personalizePageView = this.a;
                personalizePageView.L = true;
                if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW || personalizePageView.M) {
                    return;
                }
                personalizePageView.q0();
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.m0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(PersonalizePageView personalizePageView, int i) {
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
            if (personalizePageView.L && !personalizePageView.M) {
                personalizePageView.q0();
            }
            if (this.a.u) {
                PersonalizePageView personalizePageView2 = this.a;
                if (personalizePageView2.N) {
                    return;
                }
                personalizePageView2.N = true;
                SpeedStats.getInstance().onMainPageStatsEnd(this.a.getContext());
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (this.a.U) {
                        this.a.U = false;
                        this.a.O0();
                    }
                } else if (this.a.G == null || this.a.G.getVisibility() != 0) {
                } else {
                    this.a.U = true;
                    this.a.m0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements e.o0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f33357b;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f33358b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ e f33359c;

            public a(e eVar, int i, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, Integer.valueOf(i), str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f33359c = eVar;
                this.a = i;
                this.f33358b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f33359c.f33357b.j0();
                    if (this.a != 1) {
                        if (this.f33359c.a) {
                            this.f33359c.g();
                            this.f33359c.f33357b.P0();
                            return;
                        }
                        this.f33359c.f33357b.a.setVisibility(8);
                        PersonalizePageView personalizePageView = this.f33359c.f33357b;
                        personalizePageView.N0(personalizePageView, this.f33358b, true);
                    } else {
                        if (c.a.d.f.p.l.z()) {
                            this.f33359c.f33357b.f33356h.showToast(this.f33358b);
                        }
                        this.f33359c.g();
                    }
                    c.a.d.e.a.b().d();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ boolean a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ e f33360b;

            public b(e eVar, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f33360b = eVar;
                this.a = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f33360b.g();
                    this.f33360b.f33357b.a.setVisibility(0);
                    this.f33360b.f33357b.j0();
                    this.f33360b.f33357b.k0();
                    this.f33360b.f33357b.s = true;
                    if (this.a) {
                        this.f33360b.f33357b.t = System.currentTimeMillis();
                    }
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public c(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f33357b.f33354f == null) {
                    return;
                }
                this.a.f33357b.f33354f.D(this.a.f33357b.getContext().getString(R.string.obfuscated_res_0x7f0f0f56));
                this.a.f33357b.f33354f.f();
                this.a.f33357b.f33354f.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
        }

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
            this.f33357b = personalizePageView;
            this.a = c.a.o0.r.j0.b.k().h("key_first_install", true);
        }

        @Override // c.a.p0.q1.i.e.o0
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                c.a.d.f.m.i.b(new b(this, z));
            }
        }

        @Override // c.a.p0.q1.i.e.o0
        public void b(int i, c.a.o0.c1.g gVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), gVar, Integer.valueOf(i2)}) == null) {
                if (this.f33357b.i != null) {
                    boolean t0 = this.f33357b.t0();
                    this.f33357b.k0();
                    if (t0) {
                        this.f33357b.L0(true);
                    }
                    this.f33357b.i.c(i, gVar, i2);
                    c.a.o0.a.r.g().s();
                    return;
                }
                PersonalizePageView personalizePageView = this.f33357b;
                personalizePageView.N0(personalizePageView, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c15), true);
                this.f33357b.j0();
            }
        }

        @Override // c.a.p0.q1.i.e.o0
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                c.a.d.f.m.i.b(new c(this));
            }
        }

        @Override // c.a.p0.q1.i.e.o0
        public void d(int i, int i2, c.a.o0.c1.g gVar, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), gVar, Integer.valueOf(i3)}) == null) || this.f33357b.i == null) {
                return;
            }
            PersonalizePageView personalizePageView = this.f33357b;
            if (personalizePageView.u0(personalizePageView.f33350b)) {
                this.f33357b.m = System.currentTimeMillis();
            }
            this.f33357b.i.d(i, i2, gVar, i3);
        }

        public final void g() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.a) {
                this.a = false;
                c.a.o0.r.j0.b.k().u("key_first_install", false);
            }
        }

        @Override // c.a.p0.q1.i.e.o0
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) {
                c.a.d.f.m.i.b(new a(this, i, str));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e0 implements MessageQueue.IdleHandler {
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

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    this.a.F0();
                    return false;
                } catch (Exception e2) {
                    BdLog.e(e2);
                    return false;
                }
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public f(PersonalizePageView personalizePageView) {
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f33356h == null) {
                return;
            }
            c.a.p0.g1.b.j().y(this.a.f33356h.getPageActivity());
        }
    }

    /* loaded from: classes5.dex */
    public class f0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f0(PersonalizePageView personalizePageView, int i) {
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
                    this.a.Q0(c.a.o0.r.w.a.b().c(), false, false);
                }
                this.a.j0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.o0.s.c.f a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f33361b;

        public g(PersonalizePageView personalizePageView, c.a.o0.s.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33361b = personalizePageView;
            this.a = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a == null || this.f33361b.G == null) {
                return;
            }
            this.f33361b.G.g(this.a);
            this.f33361b.G.setAutoCompleteShown(false);
        }
    }

    /* loaded from: classes5.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Integer) {
                this.a.H = ((Integer) data).intValue();
                if (this.a.G != null) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.G.getLayoutParams();
                    layoutParams.gravity = 85;
                    layoutParams.bottomMargin = c.a.d.f.p.n.f(this.a.O, R.dimen.tbds306) + this.a.H;
                    this.a.G.requestLayout();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.o0.s.c.f a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f33362b;

        public h(PersonalizePageView personalizePageView, c.a.o0.s.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33362b = personalizePageView;
            this.a = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f33362b.G.setHomePbFloatLastCloseTime();
                this.f33362b.l0();
                this.f33362b.G.u(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h0 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h0(PersonalizePageView personalizePageView, int i) {
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
                this.a.P = checkInterestCommitResponseMessage.getFinishInterestStage();
                this.a.Q = checkInterestCommitResponseMessage.getPersonalizedSwitchStatus();
                PersonalizePageView personalizePageView = this.a;
                if (c.a.p0.q1.i.n.c.f(personalizePageView.P, personalizePageView.Q)) {
                    this.a.K0();
                } else {
                    this.a.J0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements f.g {
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

        @Override // c.a.o0.r.l0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                c.a.p0.v.d.c().f("page_recommend");
                this.a.j.update();
                this.a.j.T0(false);
                this.a.B = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i0 implements NEGFeedBackView.b {
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

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void a(ArrayList<Integer> arrayList, String str, v0 v0Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, v0Var) == null) || arrayList == null || v0Var == null) {
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
            int i3 = v0Var.n;
            if (i3 == 0) {
                i = 1;
            } else if (i3 == 40) {
                i = 2;
            } else if (i3 == 49 || i3 == 69) {
                i = 3;
            }
            if (this.a.f33355g != null) {
                this.a.f33355g.n();
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.NEG_FEEDBACK_KEY).param("tid", v0Var.f()).param("nid", v0Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", v0Var.c()).param("obj_param1", v0Var.k).param("obj_source", v0Var.l).param("obj_id", v0Var.m).param("obj_type", sb.toString()).param("obj_name", str).param(TiebaStatic.Params.OBJ_PARAM2, i).param("obj_locate", "1"));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(v0 v0Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v0Var, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(v0 v0Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, v0Var) == null) || v0Var == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.NEG_FEEDBACK_KEY).param("obj_locate", "1").param("fid", v0Var.c()).param("tid", v0Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("nid", v0Var.e()));
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.NEGATIVE_FEEDBACK_OPEN_CLICK).param("obj_locate", "1").param("fid", v0Var.c()).param("tid", v0Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    /* loaded from: classes5.dex */
    public class j implements f.h {
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

        @Override // c.a.o0.r.l0.f.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.j == null || this.a.j.j0() == null) {
                return;
            }
            this.a.j.j0().x();
        }
    }

    /* loaded from: classes5.dex */
    public class j0 implements FollowUserButton.a {
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

        @Override // com.baidu.tbadk.core.view.FollowUserButton.a
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            Object tag = view.getTag();
            if (tag instanceof ThreadData) {
                TiebaStatic.log(c.a.p0.z3.a.m("c13696", (ThreadData) tag));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(PersonalizePageView personalizePageView, int i) {
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
                if (!((Boolean) customResponsedMessage.getData()).booleanValue() || UbsABTestHelper.isHomeElasticABTest()) {
                    if (this.a.E != null) {
                        this.a.E.w();
                        return;
                    }
                    return;
                }
                if (this.a.E == null) {
                    this.a.E = new c.a.d.o.e.l(new c.a.d.o.e.j());
                }
                this.a.E.q(this.a.f33350b, 2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k0 extends RecyclerView.OnScrollListener {
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

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) || this.a.m0 == i || this.a.l0 == null) {
                return;
            }
            this.a.m0 = i;
            if (this.a.m0 == 1) {
                this.a.l0.X();
            } else if (this.a.D0(recyclerView)) {
                this.a.l0.B();
            } else {
                this.a.l0.X();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements f.e {
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

        @Override // c.a.o0.r.l0.f.e
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

    /* loaded from: classes5.dex */
    public class l0 extends ScrollFragmentTabHost.v {
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

        @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.v
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.l0 == null) {
                return;
            }
            this.a.m0 = -1;
            PersonalizePageView personalizePageView = this.a;
            if (personalizePageView.D0(personalizePageView.f33350b)) {
                this.a.l0.B();
            } else {
                this.a.l0.X();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements f.InterfaceC0828f {
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

        @Override // c.a.o0.r.l0.f.InterfaceC0828f
        public void a(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                if (this.a.j != null) {
                    this.a.j.T0(true);
                    this.a.j.K0();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, Boolean.TRUE));
                c.a.o0.r.o.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > c.a.o0.r.j0.b.k().m("key_bigday_next_showtime_home", 0L)) {
                    aVar = c.a.o0.r.o.b.i().h(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface m0 {
        void f(f.g gVar);

        void g(f.h hVar);

        void k(f.e eVar);

        void m(f.InterfaceC0828f interfaceC0828f);
    }

    /* loaded from: classes5.dex */
    public class n extends RecyclerView.OnScrollListener {
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
                    p0 wlConfigData = TbSingleton.getInstance().getWlConfigData();
                    if (UbsABTestHelper.isLoadMoreABTest() && wlConfigData != null && wlConfigData.K() != 0) {
                        i2 = wlConfigData.K();
                    }
                    if (this.a.D.getItemCount() - this.a.D.findLastVisibleItemPosition() <= i2 * 5) {
                        this.a.v0();
                    }
                }
                if (i == 0) {
                    if (this.a.G != null) {
                        this.a.G.q();
                    }
                    if (this.a.T != null) {
                        BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(this.a.T);
                        this.a.T = null;
                    }
                } else if (i == 1) {
                    if (this.a.T == null) {
                        this.a.T = BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_HOME, "1", "scroll");
                    }
                    if (this.a.G != null) {
                        this.a.G.p();
                    }
                } else if (i == 2) {
                    if (this.a.T == null) {
                        this.a.T = BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_HOME, "1", "scroll");
                    }
                    if (this.a.G != null) {
                        this.a.G.r();
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
                if (this.a.F != null) {
                    c.a.d.o.e.n C = this.a.f33350b.C(this.a.D.findLastVisibleItemPosition());
                    if (C instanceof c.a.p0.h0.e0.k) {
                        if (((c.a.p0.h0.e0.k) C).position >= 6) {
                            this.a.F.f();
                        } else {
                            this.a.F.b();
                        }
                    }
                }
                if (!UbsABTestHelper.isHomePagePromoteLoginUbsABTestA() || TbadkCoreApplication.isLogin() || c.a.o0.r.j0.b.k().l("home_page_login_dialog_show_key", 0) != 0 || this.a.A < c.a.d.f.p.n.p(TbadkCoreApplication.getInst().getContext())[1] * 2) {
                    return;
                }
                c.a.o0.r.j0.b.k().w("home_page_login_dialog_show_key", 1);
                DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.O, LoginDialogData.HOME_PAGE_RESULT_PAGE));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements BdListView.p {
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

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.v0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements BdListView.o {
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

        @Override // com.baidu.adp.widget.ListView.BdListView.o
        public void onScrollStop(int i, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) || System.currentTimeMillis() - this.a.p < 5000) {
                return;
            }
            this.a.j.J0(i, i2);
        }
    }

    /* loaded from: classes5.dex */
    public class q implements RecyclerView.RecyclerListener {
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

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || viewHolder == null || (view = viewHolder.itemView) == null) {
                return;
            }
            if (this.a.j != null && this.a.j.j0() != null) {
                this.a.j.j0().k(view);
            }
            if (view.getTag() instanceof HomePageCardVideoViewHolder) {
                ((HomePageCardVideoViewHolder) view.getTag()).c().stopPlay();
            }
        }
    }

    /* loaded from: classes5.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.j == null) {
                return;
            }
            this.a.j.update();
        }
    }

    /* loaded from: classes5.dex */
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f33356h == null) {
                return;
            }
            c.a.o0.r.j0.b.k().w("show_is_uninterest_tag", PersonalizePageView.N(this.a));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(this.a.f33356h.getContext(), 2)));
        }
    }

    /* loaded from: classes5.dex */
    public class t implements RecPersonalizePageModel.c {
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

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.c
        public void a(DataRes dataRes, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.a.Q0(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.c
        public void onLoadError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u implements c.a.p0.q1.e.c {
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

        @Override // c.a.p0.q1.e.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.p0.q1.e.c
        public void c(int i, c.a.o0.c1.g gVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), gVar, Integer.valueOf(i2)}) == null) {
                RecPersonalizePageModel.g().i(1, i, gVar, 1, i2);
            }
        }

        @Override // c.a.p0.q1.e.c
        public void d(int i, int i2, c.a.o0.c1.g gVar, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), gVar, Integer.valueOf(i3)}) == null) {
                RecPersonalizePageModel.g().i(2, i2, gVar, i, i3);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v implements d0.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public v(PersonalizePageView personalizePageView) {
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

        @Override // c.a.p0.q1.i.h.d0.g
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (TbSingleton.getInstance().isAddBanner) {
                    if (this.a.f33350b != null && this.a.w != null) {
                        this.a.f33350b.removeHeaderView(this.a.w.b());
                    }
                    if (this.a.f33350b == null || this.a.x == null) {
                        return;
                    }
                    this.a.f33350b.removeHeaderView(this.a.x.b());
                    return;
                }
                if (c.a.p0.q1.i.n.c.e()) {
                    PersonalizePageView personalizePageView = this.a;
                    if (personalizePageView.P == -1 && personalizePageView.Q == -1) {
                        return;
                    }
                }
                this.a.J0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ w a;

            public a(w wVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {wVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = wVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.x0();
                }
            }
        }

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
                    c.a.d.f.m.e.a().postDelayed(new a(this), TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.v0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class y extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(PersonalizePageView personalizePageView, int i) {
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

    /* loaded from: classes5.dex */
    public class z extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z(PersonalizePageView personalizePageView, int i) {
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.a == null || this.a.a.t()) {
                return;
            }
            if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof c.a.o0.r.o.a))) {
                if (this.a.f33352d != null) {
                    if (this.a.f33353e == this.a.f33352d) {
                        return;
                    }
                    PersonalizePageView personalizePageView = this.a;
                    personalizePageView.f33353e = personalizePageView.f33352d;
                } else {
                    PersonalizePageView personalizePageView2 = this.a;
                    personalizePageView2.f33352d = new c.a.p0.q1.i.i.a(personalizePageView2.f33356h);
                    this.a.f33352d.H(this.a.q);
                    PersonalizePageView personalizePageView3 = this.a;
                    personalizePageView3.f33353e = personalizePageView3.f33352d;
                    this.a.p0();
                }
                this.a.f33352d.A(true);
                this.a.a.setProgressView(this.a.f33352d);
                int i = (int) (this.a.getResources().getDisplayMetrics().density * 86.0f);
                this.a.a.setCustomDistances(i, i, i * 2);
                return;
            }
            c.a.o0.r.o.a aVar = (c.a.o0.r.o.a) customResponsedMessage.getData();
            if (this.a.f33351c != null) {
                if (this.a.f33353e == this.a.f33351c && aVar.equals(this.a.f33351c.F())) {
                    return;
                }
                PersonalizePageView personalizePageView4 = this.a;
                personalizePageView4.f33353e = personalizePageView4.f33351c;
            } else {
                PersonalizePageView personalizePageView5 = this.a;
                personalizePageView5.f33351c = new c.a.p0.q1.i.i.b(personalizePageView5.f33356h.getContext());
                PersonalizePageView personalizePageView6 = this.a;
                personalizePageView6.f33353e = personalizePageView6.f33351c;
                this.a.p0();
            }
            this.a.f33351c.A(true);
            this.a.a.setProgressView(this.a.f33351c);
            this.a.f33351c.I(aVar);
            this.a.a.setCustomDistances((int) this.a.getResources().getDimension(R.dimen.tbds236), (int) (c.a.d.f.p.n.i(this.a.f33356h.getContext()) * 0.8d), c.a.d.f.p.n.i(this.a.f33356h.getContext()));
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
        this.I = false;
        this.J = false;
        this.L = false;
        this.M = false;
        this.N = false;
        this.P = -1;
        this.Q = -1;
        this.S = false;
        this.U = false;
        this.V = new k(this, 2156674);
        this.W = new v(this);
        this.g0 = new f0(this, 2921456);
        this.h0 = new g0(this, 2921553);
        this.i0 = new h0(this, CmdConfigHttp.CMD_CHECK_INTEREST_COMMIT);
        this.j0 = new i0(this);
        this.k0 = new j0(this);
        this.m0 = -1;
        this.n0 = new k0(this);
        this.o0 = new l0(this);
        this.p0 = new a(this);
        this.q0 = new b(this);
        this.r0 = new c(this, 2001371);
        this.s0 = new d(this, 2921636);
        this.t0 = new e(this);
        this.u0 = new i(this);
        this.v0 = new j(this);
        this.w0 = new l(this);
        this.x0 = new m(this);
        this.y0 = new s(this);
        this.z0 = null;
        this.A0 = new t(this);
        this.B0 = new w(this, 2001118);
        this.C0 = new x(this);
        this.D0 = new y(this, 2921033);
        this.E0 = new z(this, 2921349);
        this.F0 = new a0(this);
        this.G0 = new b0(this, 2921632);
        this.H0 = new c0(this, 2921664);
        this.I0 = new d0(this, 2921667);
        r0(context);
    }

    public static /* synthetic */ int N(PersonalizePageView personalizePageView) {
        int i2 = personalizePageView.z + 1;
        personalizePageView.z = i2;
        return i2;
    }

    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.r) {
                F0();
                this.r = false;
            }
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.a;
            if (bigdaySwipeRefreshLayout != null) {
                bigdaySwipeRefreshLayout.D();
            }
            c.a.p0.q1.i.h.d0 d0Var = this.f33355g;
            if (d0Var != null) {
                d0Var.r();
            }
            if (RightFloatLayerView.k()) {
                return;
            }
            m0();
        }
    }

    public final void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!this.u) {
                long f2 = c.a.p0.q1.e.b.d().f(1) + c.a.p0.q1.e.b.d().b();
                long a2 = c.a.p0.q1.e.b.d().a(1);
                if (a2 > 0) {
                    f2 = System.currentTimeMillis() - a2;
                }
                c.a.o0.r0.m mVar = new c.a.o0.r0.m();
                mVar.a();
                mVar.b();
                c.a.o0.r0.k.b().o(f2);
                if (this.t > 0) {
                    c.a.o0.r0.k.b().F(System.currentTimeMillis() - this.t);
                }
                c.a.o0.r0.k.b().J(mVar.c());
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.SECOND_DRAW_DISPATCH_STAMP_KEY);
                if (!MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW && !this.N) {
                    this.N = true;
                    SpeedStats.getInstance().onMainPageStatsEnd(getContext());
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921637, ""));
                if (!c.a.o0.h0.e.e().a()) {
                    E0();
                }
            }
            this.u = true;
        }
    }

    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.p0.q1.i.e eVar = this.j;
            if (eVar != null) {
                eVar.y0(true);
            }
            c.a.p0.h0.u.b().d(false);
            c.a.p0.v.d.c().h("page_recommend", "show_");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            c.a.d.f.m.e.a().removeCallbacks(this.y0);
        }
    }

    public boolean D0(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, recyclerView)) == null) ? recyclerView == null || !recyclerView.canScrollVertically(-1) : invokeL.booleanValue;
    }

    public void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            boolean o2 = c.a.p0.q1.i.k.g.n().o();
            if (MainTabDataSwitch.isCacheOpen() && o2) {
                Looper.myQueue().addIdleHandler(new e0(this));
            }
        }
    }

    public void F0() {
        c.a.p0.q1.i.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.p0.q1.i.e eVar2 = this.j;
            if (eVar2 != null && eVar2.k0() != null) {
                this.j.k0().e();
            }
            if (this.o != null && (eVar = this.j) != null) {
                eVar.update();
                return;
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.f33350b;
            if (bdTypeRecyclerView == null || this.a == null) {
                return;
            }
            bdTypeRecyclerView.setSelection(0);
            if (!this.a.t()) {
                c.a.p0.q1.i.e eVar3 = this.j;
                if (eVar3 != null && eVar3.j0() != null) {
                    this.j.j0().x();
                    this.j.T0(false);
                }
                this.a.setRefreshing(true);
            }
            ScrollFragmentTabHost.v vVar = this.o0;
            if (vVar != null) {
                vVar.b();
            }
        }
    }

    public void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.a;
            if (bigdaySwipeRefreshLayout != null && bigdaySwipeRefreshLayout.t()) {
                this.a.r();
            }
            PbListView pbListView = this.f33354f;
            if (pbListView == null || !pbListView.m()) {
                return;
            }
            this.f33354f.D(getContext().getString(R.string.obfuscated_res_0x7f0f0da7));
            this.f33354f.f();
            this.f33354f.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.j.P0();
        }
    }

    public void I0() {
        c.a.p0.q1.i.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (eVar = this.j) == null) {
            return;
        }
        eVar.W0();
    }

    public final void J0() {
        c.a.p0.h0.q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f33350b == null || (qVar = this.w) == null || qVar.b().getParent() != null || StringUtils.isNull(TbSingleton.getInstance().getLFUser()) || TbSingleton.getInstance().isAddBanner || this.S) {
            return;
        }
        this.w.d();
        this.w.b().setVisibility(0);
        this.w.f("1");
        this.f33350b.setHeaderView(this.w.b());
    }

    public final void K0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f33350b == null) {
            return;
        }
        if (this.x == null) {
            c.a.p0.h0.p pVar = new c.a.p0.h0.p(getContext());
            this.x = pVar;
            pVar.a().setOnClickListener(this.q0);
        }
        this.f33350b.setHeaderView(this.x.b());
        this.S = true;
        c.a.p0.q1.i.n.c.b();
        c.a.p0.h0.q qVar = this.w;
        if (qVar != null) {
            this.f33350b.removeHeaderView(qVar.b());
        }
    }

    public final void L0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z2) == null) {
            if (this.n == null) {
                this.n = new c.a.o0.f0.g(getContext());
                this.n.p(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + c.a.d.f.p.n.f(getContext(), R.dimen.tbds60));
                this.n.i();
                this.n.setWrapStyle(true);
                this.n.onChangeSkinType();
            }
            this.n.attachView(this, z2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, Boolean.FALSE));
            this.f33350b.setNextPage(null);
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.a;
            if (bigdaySwipeRefreshLayout != null) {
                bigdaySwipeRefreshLayout.setVisibility(8);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921457, this.f33356h.getUniqueId()));
        }
    }

    public final void M0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            c.a.d.f.m.e.a().post(new f(this));
        }
    }

    public final void N0(View view, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048589, this, view, str, z2) == null) {
            if (this.o == null) {
                this.o = new c.a.o0.f0.h(getContext(), new r(this));
            }
            this.o.attachView(view, z2);
            this.o.p();
        }
    }

    public void O0() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (rightFloatLayerView = this.G) == null) {
            return;
        }
        rightFloatLayerView.d();
    }

    public void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.I) {
                this.I = false;
                if (this.z0 != null) {
                    if (c.a.p0.q1.i.k.g.n().m() == this.A0) {
                        c.a.p0.q1.i.k.g.n().r(this.z0);
                    }
                    this.z0 = null;
                    return;
                }
                return;
            }
            if (this.j != null) {
                if (!MainTabDataSwitch.isCacheOpen() && c.a.p0.q1.i.k.g.n().o()) {
                    L0(true);
                }
                this.j.update();
            }
            if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
                c.a.o0.r.o.b.i().j();
                c.a.o0.r.o.b.i().k();
            }
        }
    }

    public void Q0(DataRes dataRes, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{dataRes, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            PbListView pbListView = this.f33354f;
            if (pbListView != null) {
                pbListView.D(getContext().getString(R.string.obfuscated_res_0x7f0f0da7));
                this.f33354f.f();
                this.f33354f.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            this.j.C0(z2, z3, dataRes, 0, null);
        }
    }

    public void R0(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048593, this, str, i2) == null) {
            PbListView pbListView = this.f33354f;
            if (pbListView != null) {
                pbListView.D(getContext().getString(R.string.obfuscated_res_0x7f0f0da7));
                this.f33354f.f();
                this.f33354f.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            this.j.C0(true, false, null, i2, str);
        }
    }

    public final boolean S0(c.a.o0.s.c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, fVar)) == null) {
            if (!RightFloatLayerView.k()) {
                l0();
                return false;
            } else if (fVar == null) {
                return false;
            } else {
                if (this.G == null) {
                    this.G = RightFloatLayerLottieView.F(fVar, this.O);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 85;
                    layoutParams.bottomMargin = c.a.d.f.p.n.f(this.O, R.dimen.tbds306) + this.H;
                    this.G.c();
                    addView(this.G, layoutParams);
                }
                this.G.setAutoCompleteShown(true);
                if (fVar.a()) {
                    return false;
                }
                this.G.setData(fVar);
                this.G.setLogoListener(new g(this, fVar));
                this.G.setFeedBackListener(new h(this, fVar));
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.o0.h0.e.a
    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, context) == null) {
            n0(context);
            o0();
            this.I = true;
            this.z0 = c.a.p0.q1.i.k.g.n().m();
            c.a.p0.q1.i.k.g.n().r(this.A0);
            this.i = new u(this);
            if (this.j != null) {
                if (!MainTabDataSwitch.isCacheOpen() && c.a.p0.q1.i.k.g.n().o()) {
                    L0(true);
                }
                this.j.update();
            }
            if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
                c.a.o0.r.o.b.i().j();
                c.a.o0.r.o.b.i().k();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, canvas) == null) {
            super.dispatchDraw(canvas);
            if (this.s) {
                if (!this.v) {
                    this.v = true;
                }
                B0();
            }
        }
    }

    public void g0() {
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (bigdaySwipeRefreshLayout = this.a) == null) {
            return;
        }
        bigdaySwipeRefreshLayout.r();
    }

    public boolean getIsUnreadTipShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.y : invokeV.booleanValue;
    }

    public FrameLayout getmTaskFloatingView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.K : (FrameLayout) invokeV.objValue;
    }

    public void h0(Long l2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, l2) == null) {
            this.j.b0(l2);
        }
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (this.o != null) {
                F0();
                return;
            }
            c.a.p0.q1.i.e eVar = this.j;
            if (eVar != null) {
                eVar.update();
            }
        }
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            c.a.o0.f0.g gVar = this.n;
            if (gVar != null) {
                gVar.dettachView(this);
                this.n = null;
                this.f33350b.setNextPage(this.f33354f);
                this.f33354f.D(getContext().getString(R.string.obfuscated_res_0x7f0f0da7));
                this.f33354f.f();
                this.f33354f.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, Boolean.TRUE));
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.a;
            if (bigdaySwipeRefreshLayout != null) {
                bigdaySwipeRefreshLayout.setVisibility(0);
            }
            c.a.p0.q1.e.c cVar = this.i;
            if (cVar != null) {
                cVar.b();
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

    public final void k0() {
        c.a.o0.f0.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (hVar = this.o) == null) {
            return;
        }
        hVar.dettachView(this);
        this.o = null;
    }

    public void l0() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (rightFloatLayerView = this.G) == null) {
            return;
        }
        rightFloatLayerView.c();
    }

    public final void m0() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (rightFloatLayerView = this.G) == null) {
            return;
        }
        rightFloatLayerView.setAutoCompleteShown(false);
        this.G.clearAnimation();
        this.G.setVisibility(8);
    }

    public void n0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, context) == null) {
            this.J = true;
            this.O = context;
            MessageManager.getInstance().registerListener(this.s0);
            MessageManager.getInstance().registerListener(this.r0);
            MessageManager.getInstance().registerListener(this.V);
            MessageManager.getInstance().registerListener(this.g0);
            MessageManager.getInstance().registerListener(this.h0);
            MessageManager.getInstance().registerListener(this.E0);
            MessageManager.getInstance().registerListener(this.D0);
            MessageManager.getInstance().registerListener(this.i0);
            MessageManager.getInstance().registerListener(this.G0);
            MessageManager.getInstance().registerListener(this.H0);
            MessageManager.getInstance().registerListener(this.I0);
            c.a.d.a.f<?> a2 = c.a.d.a.j.a(context);
            if (a2 instanceof TbPageContext) {
                this.f33356h = (TbPageContext) a2;
            }
            c.a.o0.r.o.b.i().n(true);
            c.a.o0.r.o.a aVar = null;
            if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > c.a.o0.r.j0.b.k().m("key_bigday_next_showtime_home", 0L)) {
                aVar = c.a.o0.r.o.b.i().h(1);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            this.l = new c.a.p0.q1.i.k.f();
            c.a.p0.q1.i.h.d0 d0Var = new c.a.p0.q1.i.h.d0(context, this.f33350b);
            this.f33355g = d0Var;
            d0Var.y(this.l);
            this.f33355g.w(this.W);
            this.j = new c.a.p0.q1.i.e(this.f33356h, this.f33350b, this.f33355g, this.a);
            this.k = new c.a.p0.q1.i.a(this.f33356h);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.z = c.a.o0.r.j0.b.k().l("show_is_uninterest_tag", 0);
        }
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.f33355g.v(this.j0);
            this.f33355g.t(this.k0);
            this.j.S0(this.t0);
            this.k.i(this);
            p0();
            this.f33350b.addOnScrollListener(new n(this));
            this.f33350b.setOnSrollToBottomListener(new o(this));
            this.f33350b.setOnScrollStopDelayedListener(new p(this), 1L);
            this.f33350b.setRecyclerListener(new q(this));
            this.f33350b.removeOnScrollListener(this.n0);
            this.f33350b.addOnScrollListener(this.n0);
        }
    }

    @Override // c.a.o0.h0.e.b
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            if (this.q != i2) {
                c.a.o0.f0.g gVar = this.n;
                if (gVar != null) {
                    gVar.onChangeSkinType();
                }
                c.a.o0.f0.h hVar = this.o;
                if (hVar != null) {
                    hVar.onChangeSkinType();
                }
                c.a.p0.q1.i.i.a aVar = this.f33352d;
                if (aVar != null) {
                    aVar.H(i2);
                }
                PbListView pbListView = this.f33354f;
                if (pbListView != null) {
                    pbListView.F(SkinManager.getColor(R.color.CAM_X0109));
                    this.f33354f.d(i2);
                }
                this.f33355g.o(i2);
                c.a.p0.q1.i.e eVar = this.j;
                if (eVar != null) {
                    eVar.A0(i2);
                }
                FRSRefreshButton fRSRefreshButton = this.F;
                if (fRSRefreshButton != null) {
                    fRSRefreshButton.d(i2);
                }
                c.a.p0.h0.q qVar = this.w;
                if (qVar != null) {
                    qVar.e(i2);
                }
                RightFloatLayerView rightFloatLayerView = this.G;
                if (rightFloatLayerView != null) {
                    rightFloatLayerView.o();
                }
                c.a.p0.h0.p pVar = this.x;
                if (pVar != null) {
                    pVar.d(i2);
                }
            }
            this.q = i2;
        }
    }

    public void p0() {
        m0 m0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || (m0Var = this.f33353e) == null) {
            return;
        }
        m0Var.f(this.u0);
        this.f33353e.g(this.v0);
        this.f33353e.k(this.w0);
        this.f33353e.m(this.x0);
    }

    public final void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.M = true;
            c.a.o0.s.c.f homeAdFloatViewItemData = TbSingleton.getInstance().getHomeAdFloatViewItemData();
            if (!((homeAdFloatViewItemData == null || homeAdFloatViewItemData.a()) ? false : S0(homeAdFloatViewItemData))) {
                m0();
                M0();
                return;
            }
            c.a.p0.g1.b.j().t();
        }
    }

    public final void r0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, context) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = new BdTypeRecyclerView(context);
            this.f33350b = bdTypeRecyclerView;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(bdTypeRecyclerView.getContext());
            this.D = linearLayoutManager;
            this.f33350b.setLayoutManager(linearLayoutManager);
            this.f33350b.setFadingEdgeLength(0);
            this.f33350b.setOverScrollMode(2);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.f33350b.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            c.a.p0.h0.q qVar = new c.a.p0.h0.q(context);
            this.w = qVar;
            qVar.setFrom("from_personaize");
            this.w.a().setVisibility(0);
            this.w.a().setOnClickListener(this.p0);
            if (TbSingleton.getInstance().isSlideAnimEnable() && !UbsABTestHelper.isHomeElasticABTest()) {
                c.a.d.o.e.l lVar = new c.a.d.o.e.l(new c.a.d.o.e.j());
                this.E = lVar;
                lVar.q(this.f33350b, 2);
            }
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = new BigdaySwipeRefreshLayout(context);
            this.a = bigdaySwipeRefreshLayout;
            bigdaySwipeRefreshLayout.addView(this.f33350b);
            PbListView pbListView = new PbListView(context);
            this.f33354f = pbListView;
            pbListView.b();
            this.f33354f.p(R.color.transparent);
            this.f33354f.y();
            this.f33354f.F(SkinManager.getColor(R.color.CAM_X0107));
            this.f33354f.H(R.dimen.tbfontsize33);
            this.f33354f.B(R.color.CAM_X0110);
            this.f33354f.t(c.a.d.f.p.n.f(context, R.dimen.tbds182));
            this.f33354f.C(this.C0);
            this.f33354f.s();
            this.f33350b.setNextPage(this.f33354f);
            addView(this.a);
            if (TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
                this.F = new FRSRefreshButton(context);
                int f2 = c.a.d.f.p.n.f(context, R.dimen.tbds170);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f2, f2);
                layoutParams.gravity = 85;
                layoutParams.rightMargin = c.a.d.f.p.n.f(context, R.dimen.tbds24);
                layoutParams.bottomMargin = c.a.d.f.p.n.f(context, R.dimen.tbds180);
                addView(this.F, layoutParams);
                this.F.setOnClickListener(this.F0);
                this.F.setVisibility(8);
            }
            this.K = new FrameLayout(context);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 5;
            layoutParams2.topMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
            layoutParams2.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X011);
            addView(this.K, layoutParams2);
        }
    }

    public boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.J : invokeV.booleanValue;
    }

    public void setCallback(c.a.p0.q1.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, cVar) == null) {
            this.i = cVar;
        }
    }

    public void setIsUnreadTipShow(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z2) == null) {
            c.a.p0.q1.i.e eVar = this.j;
            if (eVar != null) {
                eVar.Q0(!z2);
            }
            this.y = z2;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, bdUniqueId) == null) {
            c.a.p0.q1.i.h.d0 d0Var = this.f33355g;
            if (d0Var != null) {
                d0Var.x(bdUniqueId);
            }
            c.a.p0.q1.i.e eVar = this.j;
            if (eVar != null) {
                eVar.L0(bdUniqueId);
            }
            c.a.p0.q1.i.k.f fVar = this.l;
            if (fVar != null) {
                fVar.a(bdUniqueId);
            }
            c.a.p0.q1.i.i.a aVar = this.f33352d;
            if (aVar != null) {
                aVar.a0(bdUniqueId);
            }
            c.a.o0.r.o.b.i().o(bdUniqueId);
            CustomMessageListener customMessageListener = this.B0;
            if (customMessageListener != null) {
                customMessageListener.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.B0);
            }
            c.a.p0.q1.i.a aVar2 = this.k;
            if (aVar2 != null) {
                aVar2.h(bdUniqueId);
            }
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, scrollFragmentTabHost) == null) {
            this.l0 = scrollFragmentTabHost;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.T(this.o0);
                this.l0.y(this.o0);
            }
            c.a.p0.q1.i.e eVar = this.j;
            if (eVar != null) {
                eVar.U0(scrollFragmentTabHost);
            }
            c.a.p0.q1.i.a aVar = this.k;
            if (aVar != null) {
                aVar.j(scrollFragmentTabHost);
            }
        }
    }

    public void setTabInForeBackgroundState(boolean z2) {
        c.a.p0.q1.i.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048617, this, z2) == null) || (eVar = this.j) == null) {
            return;
        }
        eVar.V0(z2);
    }

    public void setViewForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            setViewForeground(false);
            c.a.p0.q1.i.e eVar = this.j;
            if (eVar != null) {
                eVar.y0(false);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            if (this.z >= 1 || !TbadkCoreApplication.getInst().isNoInterestTag()) {
                return;
            }
            c.a.d.f.m.e.a().postDelayed(this.y0, 1000L);
        }
    }

    public final boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            c.a.o0.f0.h hVar = this.o;
            if (hVar != null) {
                return hVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean u0(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, recyclerView)) == null) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            return linearLayoutManager.getChildCount() > 0 && linearLayoutManager.findLastVisibleItemPosition() == linearLayoutManager.getItemCount() - 1 && recyclerView.getScrollState() == 0;
        }
        return invokeL.booleanValue;
    }

    public final void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            c.a.p0.q1.e.b.d().j(System.currentTimeMillis(), 1);
            PbListView pbListView = this.f33354f;
            if (pbListView != null && !pbListView.m()) {
                this.f33354f.R();
                this.f33354f.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            this.j.v0();
        }
    }

    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.j.s0();
        }
    }

    public void x0() {
        c.a.p0.q1.i.h.d0 d0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048624, this) == null) || (d0Var = this.f33355g) == null) {
            return;
        }
        d0Var.n();
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.s0);
            MessageManager.getInstance().unRegisterListener(this.r0);
            MessageManager.getInstance().unRegisterListener(this.V);
            MessageManager.getInstance().unRegisterListener(this.g0);
            MessageManager.getInstance().unRegisterListener(this.D0);
            MessageManager.getInstance().unRegisterListener(this.E0);
            MessageManager.getInstance().unRegisterListener(this.h0);
            MessageManager.getInstance().unRegisterListener(this.i0);
            MessageManager.getInstance().unRegisterListener(this.G0);
            MessageManager.getInstance().unRegisterListener(this.H0);
            MessageManager.getInstance().unRegisterListener(this.I0);
            this.j.B0();
            this.f33355g.v(null);
            this.f33355g.p();
            this.J = false;
            this.j.S0(null);
            c.a.p0.q1.i.i.b bVar = this.f33351c;
            if (bVar != null) {
                bVar.f(null);
                this.f33351c.g(null);
                this.f33351c.k(null);
                this.f33351c.m(null);
                this.f33351c.G();
            }
            c.a.p0.q1.i.i.a aVar = this.f33352d;
            if (aVar != null) {
                aVar.f(null);
                this.f33352d.g(null);
                this.f33352d.k(null);
                this.f33352d.m(null);
                this.f33352d.Y();
            }
            this.f33350b.setOnSrollToBottomListener(null);
            ScrollFragmentTabHost scrollFragmentTabHost = this.l0;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.T(this.o0);
            }
            this.f33350b.removeOnScrollListener(this.n0);
            c.a.o0.f0.g gVar = this.n;
            if (gVar != null) {
                gVar.n();
            }
            this.f33350b.setRecyclerListener(null);
            c.a.p0.q1.i.a aVar2 = this.k;
            if (aVar2 != null) {
                aVar2.g();
            }
            c.a.o0.r.o.b.i().e();
            c.a.d.f.m.e.a().removeCallbacks(this.y0);
            c.a.p0.q1.i.k.a aVar3 = this.R;
            if (aVar3 != null) {
                aVar3.a();
            }
        }
    }

    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            this.j.E0();
            c.a.p0.q1.i.h.d0 d0Var = this.f33355g;
            if (d0Var != null) {
                d0Var.q();
            }
            RightFloatLayerView rightFloatLayerView = this.G;
            if (rightFloatLayerView == null || !(rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                return;
            }
            ((RightFloatLayerLottieView) rightFloatLayerView).H(600);
        }
    }

    public void setViewForeground(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z2) == null) {
            c.a.p0.q1.i.e eVar = this.j;
            if (eVar != null) {
                eVar.F0(z2);
            }
            ScrollFragmentTabHost scrollFragmentTabHost = this.l0;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.T(this.o0);
                this.l0.y(this.o0);
                this.o0.b();
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
        this.I = false;
        this.J = false;
        this.L = false;
        this.M = false;
        this.N = false;
        this.P = -1;
        this.Q = -1;
        this.S = false;
        this.U = false;
        this.V = new k(this, 2156674);
        this.W = new v(this);
        this.g0 = new f0(this, 2921456);
        this.h0 = new g0(this, 2921553);
        this.i0 = new h0(this, CmdConfigHttp.CMD_CHECK_INTEREST_COMMIT);
        this.j0 = new i0(this);
        this.k0 = new j0(this);
        this.m0 = -1;
        this.n0 = new k0(this);
        this.o0 = new l0(this);
        this.p0 = new a(this);
        this.q0 = new b(this);
        this.r0 = new c(this, 2001371);
        this.s0 = new d(this, 2921636);
        this.t0 = new e(this);
        this.u0 = new i(this);
        this.v0 = new j(this);
        this.w0 = new l(this);
        this.x0 = new m(this);
        this.y0 = new s(this);
        this.z0 = null;
        this.A0 = new t(this);
        this.B0 = new w(this, 2001118);
        this.C0 = new x(this);
        this.D0 = new y(this, 2921033);
        this.E0 = new z(this, 2921349);
        this.F0 = new a0(this);
        this.G0 = new b0(this, 2921632);
        this.H0 = new c0(this, 2921664);
        this.I0 = new d0(this, 2921667);
        r0(context);
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
        this.I = false;
        this.J = false;
        this.L = false;
        this.M = false;
        this.N = false;
        this.P = -1;
        this.Q = -1;
        this.S = false;
        this.U = false;
        this.V = new k(this, 2156674);
        this.W = new v(this);
        this.g0 = new f0(this, 2921456);
        this.h0 = new g0(this, 2921553);
        this.i0 = new h0(this, CmdConfigHttp.CMD_CHECK_INTEREST_COMMIT);
        this.j0 = new i0(this);
        this.k0 = new j0(this);
        this.m0 = -1;
        this.n0 = new k0(this);
        this.o0 = new l0(this);
        this.p0 = new a(this);
        this.q0 = new b(this);
        this.r0 = new c(this, 2001371);
        this.s0 = new d(this, 2921636);
        this.t0 = new e(this);
        this.u0 = new i(this);
        this.v0 = new j(this);
        this.w0 = new l(this);
        this.x0 = new m(this);
        this.y0 = new s(this);
        this.z0 = null;
        this.A0 = new t(this);
        this.B0 = new w(this, 2001118);
        this.C0 = new x(this);
        this.D0 = new y(this, 2921033);
        this.E0 = new z(this, 2921349);
        this.F0 = new a0(this);
        this.G0 = new b0(this, 2921632);
        this.H0 = new c0(this, 2921664);
        this.I0 = new d0(this, 2921667);
        r0(context);
    }
}
