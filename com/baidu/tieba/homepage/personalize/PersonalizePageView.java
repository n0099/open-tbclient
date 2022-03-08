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
import c.a.q0.h0.e;
import c.a.q0.r.l0.f;
import c.a.q0.r.r.e2;
import c.a.q0.r.r.t0;
import c.a.q0.r.r.x0;
import c.a.q0.s.c.p0;
import c.a.r0.o1.i.e;
import c.a.r0.o1.i.h.d0;
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
    public c.a.r0.f0.q A;
    public f.e A0;
    public c.a.r0.f0.p B;
    public f.InterfaceC0861f B0;
    public boolean C;
    public Runnable C0;
    public int D;
    public RecPersonalizePageModel.c D0;
    public int E;
    public RecPersonalizePageModel.c E0;
    public boolean F;
    public final CustomMessageListener F0;
    public int G;
    public View.OnClickListener G0;
    public LinearLayoutManager H;
    public CustomMessageListener H0;
    public c.a.d.o.e.l I;
    public View.OnClickListener I0;
    public FRSRefreshButton J;
    public CustomMessageListener J0;
    public RightFloatLayerView K;
    public CustomMessageListener K0;
    public int L;
    public CustomMessageListener L0;
    public boolean M;
    public boolean N;
    public FrameLayout O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public Context S;
    public int T;
    public int U;
    public c.a.r0.o1.i.k.a V;
    public boolean W;
    public Object a0;
    public boolean b0;
    public CustomMessageListener c0;
    public d0.g d0;

    /* renamed from: e  reason: collision with root package name */
    public BigdaySwipeRefreshLayout f42975e;
    public CustomMessageListener e0;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f42976f;
    public CustomMessageListener f0;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.o1.i.i.b f42977g;
    public HttpMessageListener g0;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.o1.i.i.a f42978h;
    public NEGFeedBackView.b h0;

    /* renamed from: i  reason: collision with root package name */
    public m0 f42979i;
    public FollowUserButton.a i0;
    public CustomMessageListener isBigdayPullviewShowListener;

    /* renamed from: j  reason: collision with root package name */
    public PbListView f42980j;
    public c.a.r0.o1.i.h.d0 k;
    public ScrollFragmentTabHost k0;
    public TbPageContext<?> l;
    public c.a.r0.o1.e.c m;
    public c.a.r0.o1.i.e n;
    public c.a.r0.o1.i.a o;
    public c.a.r0.o1.i.k.f p;
    public long q;
    public int q0;
    public c.a.q0.f0.g r;
    public RecyclerView.OnScrollListener r0;
    public c.a.q0.f0.h s;
    public ScrollFragmentTabHost.v s0;
    public long t;
    public View.OnClickListener t0;
    public int u;
    public View.OnClickListener u0;
    public boolean v;
    public CustomMessageListener v0;
    public boolean w;
    public CustomMessageListener w0;
    public long x;
    public e.p0 x0;
    public boolean y;
    public f.g y0;
    public boolean z;
    public f.h z0;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f42981e;

        public a(PersonalizePageView personalizePageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42981e = personalizePageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f42981e.f42976f == null) {
                return;
            }
            this.f42981e.f42976f.removeHeaderView(this.f42981e.A.b());
        }
    }

    /* loaded from: classes5.dex */
    public class a0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f42982e;

        public a0(PersonalizePageView personalizePageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42982e = personalizePageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f42982e.J == null) {
                return;
            }
            this.f42982e.J.hide();
            this.f42982e.reload();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f42983e;

        public b(PersonalizePageView personalizePageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42983e = personalizePageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f42983e.f42976f != null && this.f42983e.B != null) {
                    this.f42983e.f42976f.removeHeaderView(this.f42983e.B.b());
                    this.f42983e.W = false;
                    c.a.r0.o1.i.n.c.a(2);
                    Activity currentActivity = TbadkApplication.getInst().getCurrentActivity();
                    if (currentActivity != null) {
                        new BdTopToast(currentActivity, 2000).setIcon(true).setContent(currentActivity.getString(R.string.recommend_card_interest_remove_hint)).show((ViewGroup) currentActivity.findViewById(16908290));
                    }
                }
                c.a.r0.o1.i.n.c.i();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b0(PersonalizePageView personalizePageView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, Integer.valueOf(i2)};
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
            this.a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.forceReload();
                if (this.a.f42976f != null && this.a.B != null) {
                    this.a.f42976f.removeHeaderView(this.a.B.b());
                }
                Activity c2 = c.a.d.a.b.g().c("MainTabActivity");
                if (c2 != null) {
                    new BdTopToast(c2, 2000).setIcon(true).setContent(c2.getString(R.string.recommend_card_interest_remove_hint)).show((ViewGroup) c2.findViewById(16908290));
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
        public c(PersonalizePageView personalizePageView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, Integer.valueOf(i2)};
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
            this.a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (TbSingleton.getInstance().isAddBanner || !c.a.r0.o1.i.n.c.e()) {
                    this.a.n0();
                } else if (this.a.V == null) {
                    this.a.V = new c.a.r0.o1.i.k.a();
                    this.a.V.c();
                }
                PersonalizePageView personalizePageView = this.a;
                personalizePageView.P = true;
                if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW || personalizePageView.Q) {
                    return;
                }
                personalizePageView.i0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c0(PersonalizePageView personalizePageView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, Integer.valueOf(i2)};
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
            this.a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.h0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(PersonalizePageView personalizePageView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, Integer.valueOf(i2)};
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
            if (personalizePageView.P && !personalizePageView.Q) {
                personalizePageView.i0();
            }
            if (this.a.y) {
                PersonalizePageView personalizePageView2 = this.a;
                if (personalizePageView2.R) {
                    return;
                }
                personalizePageView2.R = true;
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
        public d0(PersonalizePageView personalizePageView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, Integer.valueOf(i2)};
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
            this.a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (this.a.b0) {
                        this.a.b0 = false;
                        this.a.showRightFloatLayerView();
                    }
                } else if (this.a.K == null || this.a.K.getVisibility() != 0) {
                } else {
                    this.a.b0 = true;
                    this.a.h0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements e.p0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f42984b;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f42985e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f42986f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ e f42987g;

            public a(e eVar, int i2, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, Integer.valueOf(i2), str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f42987g = eVar;
                this.f42985e = i2;
                this.f42986f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f42987g.f42984b.f0();
                    if (this.f42985e != 1) {
                        if (this.f42987g.a) {
                            this.f42987g.g();
                            this.f42987g.f42984b.startFirstLoad();
                            return;
                        }
                        this.f42987g.f42984b.f42975e.setVisibility(8);
                        PersonalizePageView personalizePageView = this.f42987g.f42984b;
                        personalizePageView.r0(personalizePageView, this.f42986f, true);
                    } else {
                        if (c.a.d.f.p.l.z()) {
                            this.f42987g.f42984b.l.showToast(this.f42986f);
                        }
                        this.f42987g.g();
                    }
                    c.a.d.e.a.b().d();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ boolean f42988e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f42989f;

            public b(e eVar, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f42989f = eVar;
                this.f42988e = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f42989f.g();
                    this.f42989f.f42984b.f42975e.setVisibility(0);
                    this.f42989f.f42984b.f0();
                    this.f42989f.f42984b.g0();
                    this.f42989f.f42984b.w = true;
                    if (this.f42988e) {
                        this.f42989f.f42984b.x = System.currentTimeMillis();
                    }
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f42990e;

            public c(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f42990e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f42990e.f42984b.f42980j == null) {
                    return;
                }
                this.f42990e.f42984b.f42980j.D(this.f42990e.f42984b.getContext().getString(R.string.recommend_no_more_data));
                this.f42990e.f42984b.f42980j.f();
                this.f42990e.f42984b.f42980j.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
        }

        public e(PersonalizePageView personalizePageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42984b = personalizePageView;
            this.a = c.a.q0.r.j0.b.k().h("key_first_install", true);
        }

        @Override // c.a.r0.o1.i.e.p0
        public void a(int i2, c.a.q0.c1.g gVar, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), gVar, Integer.valueOf(i3)}) == null) {
                if (this.f42984b.m != null) {
                    boolean k0 = this.f42984b.k0();
                    this.f42984b.g0();
                    if (k0) {
                        this.f42984b.p0(true);
                    }
                    this.f42984b.m.c(i2, gVar, i3);
                    c.a.q0.a.q.g().s();
                    return;
                }
                PersonalizePageView personalizePageView = this.f42984b;
                personalizePageView.r0(personalizePageView, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                this.f42984b.f0();
            }
        }

        @Override // c.a.r0.o1.i.e.p0
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.d.f.m.i.b(new c(this));
            }
        }

        @Override // c.a.r0.o1.i.e.p0
        public void c(int i2, int i3, c.a.q0.c1.g gVar, int i4) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), gVar, Integer.valueOf(i4)}) == null) || this.f42984b.m == null) {
                return;
            }
            PersonalizePageView personalizePageView = this.f42984b;
            if (personalizePageView.isVisBottom(personalizePageView.f42976f)) {
                this.f42984b.q = System.currentTimeMillis();
            }
            this.f42984b.m.d(i2, i3, gVar, i4);
        }

        @Override // c.a.r0.o1.i.e.p0
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                c.a.d.f.m.i.b(new b(this, z));
            }
        }

        public final void g() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.a) {
                this.a = false;
                c.a.q0.r.j0.b.k().u("key_first_install", false);
            }
        }

        @Override // c.a.r0.o1.i.e.p0
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048581, this, i2, str) == null) {
                c.a.d.f.m.i.b(new a(this, i2, str));
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                    this.a.reload();
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

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f42991e;

        public f(PersonalizePageView personalizePageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42991e = personalizePageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f42991e.l == null) {
                return;
            }
            c.a.r0.e1.a.i().w(this.f42991e.l.getPageActivity());
        }
    }

    /* loaded from: classes5.dex */
    public class f0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f0(PersonalizePageView personalizePageView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, Integer.valueOf(i2)};
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
            this.a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (this.a.n != null) {
                    this.a.updateData(c.a.q0.r.w.a.b().c(), false, false);
                }
                this.a.f0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.s.c.f f42992e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f42993f;

        public g(PersonalizePageView personalizePageView, c.a.q0.s.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42993f = personalizePageView;
            this.f42992e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f42992e == null || this.f42993f.K == null) {
                return;
            }
            this.f42993f.K.doLink(this.f42992e);
            this.f42993f.K.setAutoCompleteShown(false);
        }
    }

    /* loaded from: classes5.dex */
    public class g0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g0(PersonalizePageView personalizePageView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, Integer.valueOf(i2)};
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
                this.a.L = ((Integer) data).intValue();
                if (this.a.K != null) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.K.getLayoutParams();
                    layoutParams.gravity = 85;
                    layoutParams.bottomMargin = c.a.d.f.p.n.f(this.a.S, R.dimen.tbds306) + this.a.L;
                    this.a.K.requestLayout();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.s.c.f f42994e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f42995f;

        public h(PersonalizePageView personalizePageView, c.a.q0.s.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42995f = personalizePageView;
            this.f42994e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f42995f.K.setHomePbFloatLastCloseTime();
                this.f42995f.hideRightFloatLayerView();
                this.f42995f.K.reportClickCloseAd(this.f42994e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h0 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h0(PersonalizePageView personalizePageView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, Integer.valueOf(i2)};
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
            this.a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003514 && (httpResponsedMessage instanceof CheckInterestCommitResponseMessage)) {
                CheckInterestCommitResponseMessage checkInterestCommitResponseMessage = (CheckInterestCommitResponseMessage) httpResponsedMessage;
                this.a.T = checkInterestCommitResponseMessage.getFinishInterestStage();
                this.a.U = checkInterestCommitResponseMessage.getPersonalizedSwitchStatus();
                PersonalizePageView personalizePageView = this.a;
                if (c.a.r0.o1.i.n.c.f(personalizePageView.T, personalizePageView.U)) {
                    this.a.o0();
                } else {
                    this.a.n0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f42996e;

        public i(PersonalizePageView personalizePageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42996e = personalizePageView;
        }

        @Override // c.a.q0.r.l0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                c.a.r0.t.d.c().f("page_recommend");
                this.f42996e.n.update();
                this.f42996e.n.U0(false);
                this.f42996e.F = true;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalizePageView;
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onCheckedChanged(x0 x0Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048576, this, x0Var, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, x0 x0Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, str, x0Var) == null) || arrayList == null || x0Var == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            int size = arrayList.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                sb.append(arrayList.get(i3));
                sb.append(",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            int i4 = x0Var.n;
            if (i4 == 0) {
                i2 = 1;
            } else if (i4 == 40) {
                i2 = 2;
            } else if (i4 == 49 || i4 == 69) {
                i2 = 3;
            }
            if (this.a.k != null) {
                this.a.k.n();
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.NEG_FEEDBACK_KEY).param("tid", x0Var.f()).param("nid", x0Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", x0Var.c()).param("obj_param1", x0Var.k).param("obj_source", x0Var.l).param("obj_id", x0Var.m).param("obj_type", sb.toString()).param("obj_name", str).param(TiebaStatic.Params.OBJ_PARAM2, i2).param("obj_locate", "1"));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackWindowShow(x0 x0Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, x0Var) == null) || x0Var == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.NEG_FEEDBACK_KEY).param("obj_locate", "1").param("fid", x0Var.c()).param("tid", x0Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("nid", x0Var.e()));
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.NEGATIVE_FEEDBACK_OPEN_CLICK).param("obj_locate", "1").param("fid", x0Var.c()).param("tid", x0Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalizePageView;
        }

        @Override // c.a.q0.r.l0.f.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.n == null || this.a.n.k0() == null) {
                return;
            }
            this.a.n.k0().x();
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (tag instanceof e2) {
                TiebaStatic.log(c.a.r0.x3.a.m("c13696", (e2) tag));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(PersonalizePageView personalizePageView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, Integer.valueOf(i2)};
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
            this.a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (!((Boolean) customResponsedMessage.getData()).booleanValue() || UbsABTestHelper.isHomeElasticABTest()) {
                    if (this.a.I != null) {
                        this.a.I.w();
                        return;
                    }
                    return;
                }
                if (this.a.I == null) {
                    this.a.I = new c.a.d.o.e.l(new c.a.d.o.e.j());
                }
                this.a.I.q(this.a.f42976f, 2);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalizePageView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) || this.a.q0 == i2 || this.a.k0 == null) {
                return;
            }
            this.a.q0 = i2;
            if (this.a.q0 == 1) {
                this.a.k0.showShadow();
            } else if (this.a.recyclerViewIsAtTop(recyclerView)) {
                this.a.k0.dismissShadow();
            } else {
                this.a.k0.showShadow();
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalizePageView;
        }

        @Override // c.a.q0.r.l0.f.e
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.F) {
                this.a.E = 0;
                this.a.G = 1;
                this.a.F = false;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.k0 == null) {
                return;
            }
            this.a.q0 = -1;
            PersonalizePageView personalizePageView = this.a;
            if (personalizePageView.recyclerViewIsAtTop(personalizePageView.f42976f)) {
                this.a.k0.dismissShadow();
            } else {
                this.a.k0.showShadow();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements f.InterfaceC0861f {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalizePageView;
        }

        @Override // c.a.q0.r.l0.f.InterfaceC0861f
        public void a(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                if (this.a.n != null) {
                    this.a.n.U0(true);
                    this.a.n.L0();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, Boolean.TRUE));
                c.a.q0.r.o.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > c.a.q0.r.j0.b.k().m("key_bigday_next_showtime_home", 0L)) {
                    aVar = c.a.q0.r.o.b.i().h(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface m0 {
        void a(f.g gVar);

        void b(f.h hVar);

        void f(f.e eVar);

        void h(f.InterfaceC0861f interfaceC0861f);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalizePageView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                if (this.a.H != null && i2 == 0) {
                    int i3 = 3;
                    int height = ((WindowManager) this.a.getContext().getSystemService("window")).getDefaultDisplay().getHeight() * 3;
                    if (this.a.E < height || this.a.G != 1) {
                        if (this.a.E < height && this.a.G == 2) {
                            this.a.G = 1;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        }
                    } else {
                        this.a.G = 2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(this.a.G)));
                    }
                    p0 wlConfigData = TbSingleton.getInstance().getWlConfigData();
                    if (UbsABTestHelper.isLoadMoreABTest() && wlConfigData != null && wlConfigData.K() != 0) {
                        i3 = wlConfigData.K();
                    }
                    if (this.a.H.getItemCount() - this.a.H.findLastVisibleItemPosition() <= i3 * 5) {
                        this.a.l0();
                    }
                }
                if (i2 == 0) {
                    if (this.a.K != null) {
                        this.a.K.onScrollIdle();
                    }
                    if (this.a.a0 != null) {
                        BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(this.a.a0);
                        this.a.a0 = null;
                    }
                } else if (i2 == 1) {
                    if (this.a.a0 == null) {
                        this.a.a0 = BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect("home", "1", "scroll");
                    }
                    if (this.a.K != null) {
                        this.a.K.onScrollDragging();
                    }
                } else if (i2 == 2) {
                    if (this.a.a0 == null) {
                        this.a.a0 = BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect("home", "1", "scroll");
                    }
                    if (this.a.K != null) {
                        this.a.K.onScrollSettling();
                    }
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                this.a.E += i3;
                if (this.a.J != null) {
                    c.a.d.o.e.n item = this.a.f42976f.getItem(this.a.H.findLastVisibleItemPosition());
                    if (item instanceof c.a.r0.f0.d0.k) {
                        if (((c.a.r0.f0.d0.k) item).position >= 6) {
                            this.a.J.show();
                        } else {
                            this.a.J.hide();
                        }
                    }
                }
                if (!UbsABTestHelper.isHomePagePromoteLoginUbsABTestA() || TbadkCoreApplication.isLogin() || c.a.q0.r.j0.b.k().l("home_page_login_dialog_show_key", 0) != 0 || this.a.E < c.a.d.f.p.n.p(TbadkCoreApplication.getInst().getContext())[1] * 2) {
                    return;
                }
                c.a.q0.r.j0.b.k().w("home_page_login_dialog_show_key", 1);
                DialogLoginHelper.checkUpIsLogin(new t0(this.a.S, "new_shouye"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f42997e;

        public o(PersonalizePageView personalizePageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42997e = personalizePageView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f42997e.l0();
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalizePageView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.o
        public void onScrollStop(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || System.currentTimeMillis() - this.a.t < 5000) {
                return;
            }
            this.a.n.K0(i2, i3);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (this.a.n != null && this.a.n.k0() != null) {
                this.a.n.k0().k(view);
            }
            if (view.getTag() instanceof HomePageCardVideoViewHolder) {
                ((HomePageCardVideoViewHolder) view.getTag()).getCardView().stopPlay();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f42998e;

        public r(PersonalizePageView personalizePageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42998e = personalizePageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f42998e.n == null) {
                return;
            }
            this.f42998e.n.update();
        }
    }

    /* loaded from: classes5.dex */
    public class s implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f42999e;

        public s(PersonalizePageView personalizePageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42999e = personalizePageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f42999e.l == null) {
                return;
            }
            c.a.q0.r.j0.b.k().w("show_is_uninterest_tag", PersonalizePageView.M(this.f42999e));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(this.f42999e.l.getContext(), 2)));
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                this.a.updateData(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.c
        public void onLoadError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u implements c.a.r0.o1.e.c {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalizePageView;
        }

        @Override // c.a.r0.o1.e.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.r0.o1.e.c
        public void c(int i2, c.a.q0.c1.g gVar, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), gVar, Integer.valueOf(i3)}) == null) {
                RecPersonalizePageModel.g().i(1, i2, gVar, 1, i3);
            }
        }

        @Override // c.a.r0.o1.e.c
        public void d(int i2, int i3, c.a.q0.c1.g gVar, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), gVar, Integer.valueOf(i4)}) == null) {
                RecPersonalizePageModel.g().i(2, i3, gVar, i2, i4);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalizePageView;
        }

        @Override // c.a.r0.o1.i.h.d0.g
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (TbSingleton.getInstance().isAddBanner) {
                    if (this.a.f42976f != null && this.a.A != null) {
                        this.a.f42976f.removeHeaderView(this.a.A.b());
                    }
                    if (this.a.f42976f == null || this.a.B == null) {
                        return;
                    }
                    this.a.f42976f.removeHeaderView(this.a.B.b());
                    return;
                }
                if (c.a.r0.o1.i.n.c.e()) {
                    PersonalizePageView personalizePageView = this.a;
                    if (personalizePageView.T == -1 && personalizePageView.U == -1) {
                        return;
                    }
                }
                this.a.n0();
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

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ w f43000e;

            public a(w wVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {wVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f43000e = wVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f43000e.a.notifyListViewDataSetChanged();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(PersonalizePageView personalizePageView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, Integer.valueOf(i2)};
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

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f43001e;

        public x(PersonalizePageView personalizePageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43001e = personalizePageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f43001e.l0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class y extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(PersonalizePageView personalizePageView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, Integer.valueOf(i2)};
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
            this.a.v = true;
        }
    }

    /* loaded from: classes5.dex */
    public class z extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z(PersonalizePageView personalizePageView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, Integer.valueOf(i2)};
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
            this.a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.f42975e == null || this.a.f42975e.isRefreshing()) {
                return;
            }
            if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof c.a.q0.r.o.a))) {
                if (this.a.f42978h != null) {
                    if (this.a.f42979i == this.a.f42978h) {
                        return;
                    }
                    PersonalizePageView personalizePageView = this.a;
                    personalizePageView.f42979i = personalizePageView.f42978h;
                } else {
                    PersonalizePageView personalizePageView2 = this.a;
                    personalizePageView2.f42978h = new c.a.r0.o1.i.i.a(personalizePageView2.l);
                    this.a.f42978h.C(this.a.u);
                    PersonalizePageView personalizePageView3 = this.a;
                    personalizePageView3.f42979i = personalizePageView3.f42978h;
                    this.a.initPullViewListeners();
                }
                this.a.f42978h.v(true);
                this.a.f42975e.setProgressView(this.a.f42978h);
                int i2 = (int) (this.a.getResources().getDisplayMetrics().density * 86.0f);
                this.a.f42975e.setCustomDistances(i2, i2, i2 * 2);
                return;
            }
            c.a.q0.r.o.a aVar = (c.a.q0.r.o.a) customResponsedMessage.getData();
            if (this.a.f42977g != null) {
                if (this.a.f42979i == this.a.f42977g && aVar.equals(this.a.f42977g.A())) {
                    return;
                }
                PersonalizePageView personalizePageView4 = this.a;
                personalizePageView4.f42979i = personalizePageView4.f42977g;
            } else {
                PersonalizePageView personalizePageView5 = this.a;
                personalizePageView5.f42977g = new c.a.r0.o1.i.i.b(personalizePageView5.l.getContext());
                PersonalizePageView personalizePageView6 = this.a;
                personalizePageView6.f42979i = personalizePageView6.f42977g;
                this.a.initPullViewListeners();
            }
            this.a.f42977g.v(true);
            this.a.f42975e.setProgressView(this.a.f42977g);
            this.a.f42977g.D(aVar);
            this.a.f42975e.setCustomDistances((int) this.a.getResources().getDimension(R.dimen.tbds236), (int) (c.a.d.f.p.n.i(this.a.l.getContext()) * 0.8d), c.a.d.f.p.n.i(this.a.l.getContext()));
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
        this.t = 0L;
        this.u = 3;
        this.v = false;
        this.w = false;
        this.x = -1L;
        this.y = false;
        this.z = false;
        this.C = false;
        this.D = 0;
        this.E = 0;
        this.F = false;
        this.G = 1;
        this.M = false;
        this.N = false;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.T = -1;
        this.U = -1;
        this.W = false;
        this.b0 = false;
        this.c0 = new k(this, 2156674);
        this.d0 = new v(this);
        this.e0 = new f0(this, 2921456);
        this.f0 = new g0(this, 2921553);
        this.g0 = new h0(this, CmdConfigHttp.CMD_CHECK_INTEREST_COMMIT);
        this.h0 = new i0(this);
        this.i0 = new j0(this);
        this.q0 = -1;
        this.r0 = new k0(this);
        this.s0 = new l0(this);
        this.t0 = new a(this);
        this.u0 = new b(this);
        this.v0 = new c(this, 2001371);
        this.w0 = new d(this, 2921636);
        this.x0 = new e(this);
        this.y0 = new i(this);
        this.z0 = new j(this);
        this.A0 = new l(this);
        this.B0 = new m(this);
        this.C0 = new s(this);
        this.D0 = null;
        this.E0 = new t(this);
        this.F0 = new w(this, 2001118);
        this.G0 = new x(this);
        this.H0 = new y(this, 2921033);
        this.isBigdayPullviewShowListener = new z(this, 2921349);
        this.I0 = new a0(this);
        this.J0 = new b0(this, 2921632);
        this.K0 = new c0(this, 2921664);
        this.L0 = new d0(this, 2921667);
        j0(context);
    }

    public static /* synthetic */ int M(PersonalizePageView personalizePageView) {
        int i2 = personalizePageView.D + 1;
        personalizePageView.D = i2;
        return i2;
    }

    public void completePullRefresh() {
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bigdaySwipeRefreshLayout = this.f42975e) == null) {
            return;
        }
        bigdaySwipeRefreshLayout.interruptRefresh();
    }

    public void deleteGodReplyInThread(Long l2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l2) == null) {
            this.n.c0(l2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.dispatchDraw(canvas);
            if (this.w) {
                if (!this.z) {
                    this.z = true;
                }
                m0();
            }
        }
    }

    public final void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.q0.f0.g gVar = this.r;
            if (gVar != null) {
                gVar.dettachView(this);
                this.r = null;
                this.f42976f.setNextPage(this.f42980j);
                this.f42980j.D(getContext().getString(R.string.pb_load_more));
                this.f42980j.f();
                this.f42980j.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, Boolean.TRUE));
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.f42975e;
            if (bigdaySwipeRefreshLayout != null) {
                bigdaySwipeRefreshLayout.setVisibility(0);
            }
            c.a.r0.o1.e.c cVar = this.m;
            if (cVar != null) {
                cVar.b();
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

    public void forceReload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.s != null) {
                reload();
                return;
            }
            c.a.r0.o1.i.e eVar = this.n;
            if (eVar != null) {
                eVar.update();
            }
        }
    }

    public final void g0() {
        c.a.q0.f0.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (hVar = this.s) == null) {
            return;
        }
        hVar.dettachView(this);
        this.s = null;
    }

    public boolean getIsUnreadTipShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.C : invokeV.booleanValue;
    }

    public FrameLayout getmTaskFloatingView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.O : (FrameLayout) invokeV.objValue;
    }

    public final void h0() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (rightFloatLayerView = this.K) == null) {
            return;
        }
        rightFloatLayerView.setAutoCompleteShown(false);
        this.K.clearAnimation();
        this.K.setVisibility(8);
    }

    public void hideRightFloatLayerView() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (rightFloatLayerView = this.K) == null) {
            return;
        }
        rightFloatLayerView.completeHide();
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.Q = true;
            c.a.q0.s.c.f homeAdFloatViewItemData = TbSingleton.getInstance().getHomeAdFloatViewItemData();
            if (!((homeAdFloatViewItemData == null || homeAdFloatViewItemData.a()) ? false : s0(homeAdFloatViewItemData))) {
                h0();
                q0();
                return;
            }
            c.a.r0.e1.a.i().r();
        }
    }

    public void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, context) == null) {
            this.N = true;
            this.S = context;
            MessageManager.getInstance().registerListener(this.w0);
            MessageManager.getInstance().registerListener(this.v0);
            MessageManager.getInstance().registerListener(this.c0);
            MessageManager.getInstance().registerListener(this.e0);
            MessageManager.getInstance().registerListener(this.f0);
            MessageManager.getInstance().registerListener(this.isBigdayPullviewShowListener);
            MessageManager.getInstance().registerListener(this.H0);
            MessageManager.getInstance().registerListener(this.g0);
            MessageManager.getInstance().registerListener(this.J0);
            MessageManager.getInstance().registerListener(this.K0);
            MessageManager.getInstance().registerListener(this.L0);
            c.a.d.a.f<?> a2 = c.a.d.a.j.a(context);
            if (a2 instanceof TbPageContext) {
                this.l = (TbPageContext) a2;
            }
            c.a.q0.r.o.b.i().n(true);
            c.a.q0.r.o.a aVar = null;
            if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > c.a.q0.r.j0.b.k().m("key_bigday_next_showtime_home", 0L)) {
                aVar = c.a.q0.r.o.b.i().h(1);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            this.p = new c.a.r0.o1.i.k.f();
            c.a.r0.o1.i.h.d0 d0Var = new c.a.r0.o1.i.h.d0(context, this.f42976f);
            this.k = d0Var;
            d0Var.y(this.p);
            this.k.w(this.d0);
            this.n = new c.a.r0.o1.i.e(this.l, this.f42976f, this.k, this.f42975e);
            this.o = new c.a.r0.o1.i.a(this.l);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.D = c.a.q0.r.j0.b.k().l("show_is_uninterest_tag", 0);
        }
    }

    @Override // c.a.q0.h0.e.a
    public void initAndLoadForPreShow(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, context) == null) {
            init(context);
            initListeners();
            this.M = true;
            this.D0 = c.a.r0.o1.i.k.g.n().m();
            c.a.r0.o1.i.k.g.n().r(this.E0);
            this.m = new u(this);
            if (this.n != null) {
                if (!MainTabDataSwitch.isCacheOpen() && c.a.r0.o1.i.k.g.n().o()) {
                    p0(true);
                }
                this.n.update();
            }
            if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
                c.a.q0.r.o.b.i().j();
                c.a.q0.r.o.b.i().k();
            }
        }
    }

    public void initListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.k.v(this.h0);
            this.k.t(this.i0);
            this.n.T0(this.x0);
            this.o.i(this);
            initPullViewListeners();
            this.f42976f.addOnScrollListener(new n(this));
            this.f42976f.setOnSrollToBottomListener(new o(this));
            this.f42976f.setOnScrollStopDelayedListener(new p(this), 1L);
            this.f42976f.setRecyclerListener(new q(this));
            this.f42976f.removeOnScrollListener(this.r0);
            this.f42976f.addOnScrollListener(this.r0);
        }
    }

    public void initPullViewListeners() {
        m0 m0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (m0Var = this.f42979i) == null) {
            return;
        }
        m0Var.a(this.y0);
        this.f42979i.b(this.z0);
        this.f42979i.f(this.A0);
        this.f42979i.h(this.B0);
    }

    public boolean isInit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.N : invokeV.booleanValue;
    }

    public boolean isVisBottom(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, recyclerView)) == null) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            return linearLayoutManager.getChildCount() > 0 && linearLayoutManager.findLastVisibleItemPosition() == linearLayoutManager.getItemCount() - 1 && recyclerView.getScrollState() == 0;
        }
        return invokeL.booleanValue;
    }

    public final void j0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, context) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = new BdTypeRecyclerView(context);
            this.f42976f = bdTypeRecyclerView;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(bdTypeRecyclerView.getContext());
            this.H = linearLayoutManager;
            this.f42976f.setLayoutManager(linearLayoutManager);
            this.f42976f.setFadingEdgeLength(0);
            this.f42976f.setOverScrollMode(2);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.f42976f.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            c.a.r0.f0.q qVar = new c.a.r0.f0.q(context);
            this.A = qVar;
            qVar.setFrom("from_personaize");
            this.A.a().setVisibility(0);
            this.A.a().setOnClickListener(this.t0);
            if (TbSingleton.getInstance().isSlideAnimEnable() && !UbsABTestHelper.isHomeElasticABTest()) {
                c.a.d.o.e.l lVar = new c.a.d.o.e.l(new c.a.d.o.e.j());
                this.I = lVar;
                lVar.q(this.f42976f, 2);
            }
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = new BigdaySwipeRefreshLayout(context);
            this.f42975e = bigdaySwipeRefreshLayout;
            bigdaySwipeRefreshLayout.addView(this.f42976f);
            PbListView pbListView = new PbListView(context);
            this.f42980j = pbListView;
            pbListView.b();
            this.f42980j.p(R.color.transparent);
            this.f42980j.y();
            this.f42980j.F(SkinManager.getColor(R.color.CAM_X0107));
            this.f42980j.H(R.dimen.tbfontsize33);
            this.f42980j.B(R.color.CAM_X0110);
            this.f42980j.t(c.a.d.f.p.n.f(context, R.dimen.tbds182));
            this.f42980j.C(this.G0);
            this.f42980j.s();
            this.f42976f.setNextPage(this.f42980j);
            addView(this.f42975e);
            if (TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
                this.J = new FRSRefreshButton(context);
                int f2 = c.a.d.f.p.n.f(context, R.dimen.tbds170);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f2, f2);
                layoutParams.gravity = 85;
                layoutParams.rightMargin = c.a.d.f.p.n.f(context, R.dimen.tbds24);
                layoutParams.bottomMargin = c.a.d.f.p.n.f(context, R.dimen.tbds180);
                addView(this.J, layoutParams);
                this.J.setOnClickListener(this.I0);
                this.J.setVisibility(8);
            }
            this.O = new FrameLayout(context);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 5;
            layoutParams2.topMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
            layoutParams2.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X011);
            addView(this.O, layoutParams2);
        }
    }

    public final boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            c.a.q0.f0.h hVar = this.s;
            if (hVar != null) {
                return hVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            c.a.r0.o1.e.b.d().j(System.currentTimeMillis(), 1);
            PbListView pbListView = this.f42980j;
            if (pbListView != null && !pbListView.m()) {
                this.f42980j.R();
                this.f42980j.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            this.n.w0();
        }
    }

    public final void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (!this.y) {
                long f2 = c.a.r0.o1.e.b.d().f(1) + c.a.r0.o1.e.b.d().b();
                long a2 = c.a.r0.o1.e.b.d().a(1);
                if (a2 > 0) {
                    f2 = System.currentTimeMillis() - a2;
                }
                c.a.q0.r0.m mVar = new c.a.q0.r0.m();
                mVar.a();
                mVar.b();
                c.a.q0.r0.k.b().o(f2);
                if (this.x > 0) {
                    c.a.q0.r0.k.b().F(System.currentTimeMillis() - this.x);
                }
                c.a.q0.r0.k.b().J(mVar.c());
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.SECOND_DRAW_DISPATCH_STAMP_KEY);
                if (!MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW && !this.R) {
                    this.R = true;
                    SpeedStats.getInstance().onMainPageStatsEnd(getContext());
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921637, ""));
                if (!c.a.q0.h0.e.e().a()) {
                    refreshMainTabForCacheInvalid();
                }
            }
            this.y = true;
        }
    }

    public final void n0() {
        c.a.r0.f0.q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || this.f42976f == null || (qVar = this.A) == null || qVar.b().getParent() != null || StringUtils.isNull(TbSingleton.getInstance().getLFUser()) || TbSingleton.getInstance().isAddBanner || this.W) {
            return;
        }
        this.A.d();
        this.A.b().setVisibility(0);
        this.A.f("1");
        this.f42976f.setHeaderView(this.A.b());
    }

    public void notifyJumpToLastReadPosition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.n.t0();
        }
    }

    public void notifyListViewDataSetChanged() {
        c.a.r0.o1.i.h.d0 d0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (d0Var = this.k) == null) {
            return;
        }
        d0Var.n();
    }

    public final void o0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || this.f42976f == null) {
            return;
        }
        if (this.B == null) {
            c.a.r0.f0.p pVar = new c.a.r0.f0.p(getContext());
            this.B = pVar;
            pVar.a().setOnClickListener(this.u0);
        }
        this.f42976f.setHeaderView(this.B.b());
        this.W = true;
        c.a.r0.o1.i.n.c.b();
        c.a.r0.f0.q qVar = this.A;
        if (qVar != null) {
            this.f42976f.removeHeaderView(qVar.b());
        }
    }

    @Override // c.a.q0.h0.e.b
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            if (this.u != i2) {
                c.a.q0.f0.g gVar = this.r;
                if (gVar != null) {
                    gVar.onChangeSkinType();
                }
                c.a.q0.f0.h hVar = this.s;
                if (hVar != null) {
                    hVar.onChangeSkinType();
                }
                c.a.r0.o1.i.i.a aVar = this.f42978h;
                if (aVar != null) {
                    aVar.C(i2);
                }
                PbListView pbListView = this.f42980j;
                if (pbListView != null) {
                    pbListView.F(SkinManager.getColor(R.color.CAM_X0109));
                    this.f42980j.d(i2);
                }
                this.k.o(i2);
                c.a.r0.o1.i.e eVar = this.n;
                if (eVar != null) {
                    eVar.B0(i2);
                }
                FRSRefreshButton fRSRefreshButton = this.J;
                if (fRSRefreshButton != null) {
                    fRSRefreshButton.onChangeSkinType(i2);
                }
                c.a.r0.f0.q qVar = this.A;
                if (qVar != null) {
                    qVar.e(i2);
                }
                RightFloatLayerView rightFloatLayerView = this.K;
                if (rightFloatLayerView != null) {
                    rightFloatLayerView.onChangeSkinType();
                }
                c.a.r0.f0.p pVar = this.B;
                if (pVar != null) {
                    pVar.d(i2);
                }
            }
            this.u = i2;
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.w0);
            MessageManager.getInstance().unRegisterListener(this.v0);
            MessageManager.getInstance().unRegisterListener(this.c0);
            MessageManager.getInstance().unRegisterListener(this.e0);
            MessageManager.getInstance().unRegisterListener(this.H0);
            MessageManager.getInstance().unRegisterListener(this.isBigdayPullviewShowListener);
            MessageManager.getInstance().unRegisterListener(this.f0);
            MessageManager.getInstance().unRegisterListener(this.g0);
            MessageManager.getInstance().unRegisterListener(this.J0);
            MessageManager.getInstance().unRegisterListener(this.K0);
            MessageManager.getInstance().unRegisterListener(this.L0);
            this.n.C0();
            this.k.v(null);
            this.k.p();
            this.N = false;
            this.n.T0(null);
            c.a.r0.o1.i.i.b bVar = this.f42977g;
            if (bVar != null) {
                bVar.a(null);
                this.f42977g.b(null);
                this.f42977g.f(null);
                this.f42977g.h(null);
                this.f42977g.B();
            }
            c.a.r0.o1.i.i.a aVar = this.f42978h;
            if (aVar != null) {
                aVar.a(null);
                this.f42978h.b(null);
                this.f42978h.f(null);
                this.f42978h.h(null);
                this.f42978h.T();
            }
            this.f42976f.setOnSrollToBottomListener(null);
            ScrollFragmentTabHost scrollFragmentTabHost = this.k0;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.removeShadowChangeListener(this.s0);
            }
            this.f42976f.removeOnScrollListener(this.r0);
            c.a.q0.f0.g gVar = this.r;
            if (gVar != null) {
                gVar.n();
            }
            this.f42976f.setRecyclerListener(null);
            c.a.r0.o1.i.a aVar2 = this.o;
            if (aVar2 != null) {
                aVar2.g();
            }
            c.a.q0.r.o.b.i().e();
            c.a.d.f.m.e.a().removeCallbacks(this.C0);
            c.a.r0.o1.i.k.a aVar3 = this.V;
            if (aVar3 != null) {
                aVar3.a();
            }
        }
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.n.F0();
            c.a.r0.o1.i.h.d0 d0Var = this.k;
            if (d0Var != null) {
                d0Var.q();
            }
            RightFloatLayerView rightFloatLayerView = this.K;
            if (rightFloatLayerView == null || !(rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                return;
            }
            ((RightFloatLayerLottieView) rightFloatLayerView).onChangeStyleToUnFold(600);
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (this.v) {
                reload();
                this.v = false;
            }
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.f42975e;
            if (bigdaySwipeRefreshLayout != null) {
                bigdaySwipeRefreshLayout.resume();
            }
            c.a.r0.o1.i.h.d0 d0Var = this.k;
            if (d0Var != null) {
                d0Var.r();
            }
            if (RightFloatLayerView.isHomePbNeedShow()) {
                return;
            }
            h0();
        }
    }

    public void onViewBackGround() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            c.a.r0.o1.i.e eVar = this.n;
            if (eVar != null) {
                eVar.z0(true);
            }
            c.a.r0.f0.u.b().d(false);
            c.a.r0.t.d.c().h("page_recommend", "show_");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            c.a.d.f.m.e.a().removeCallbacks(this.C0);
        }
    }

    public final void p0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z2) == null) {
            if (this.r == null) {
                this.r = new c.a.q0.f0.g(getContext());
                this.r.p(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + c.a.d.f.p.n.f(getContext(), R.dimen.tbds60));
                this.r.i();
                this.r.setWrapStyle(true);
                this.r.onChangeSkinType();
            }
            this.r.attachView(this, z2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, Boolean.FALSE));
            this.f42976f.setNextPage(null);
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.f42975e;
            if (bigdaySwipeRefreshLayout != null) {
                bigdaySwipeRefreshLayout.setVisibility(8);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921457, this.l.getUniqueId()));
        }
    }

    public final void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            c.a.d.f.m.e.a().post(new f(this));
        }
    }

    public final void r0(View view, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048608, this, view, str, z2) == null) {
            if (this.s == null) {
                this.s = new c.a.q0.f0.h(getContext(), new r(this));
            }
            this.s.attachView(view, z2);
            this.s.p();
        }
    }

    public boolean recyclerViewIsAtTop(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, recyclerView)) == null) ? recyclerView == null || !recyclerView.canScrollVertically(-1) : invokeL.booleanValue;
    }

    public void refreshMainTabForCacheInvalid() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            boolean o2 = c.a.r0.o1.i.k.g.n().o();
            if (MainTabDataSwitch.isCacheOpen() && o2) {
                Looper.myQueue().addIdleHandler(new e0(this));
            }
        }
    }

    public void reload() {
        c.a.r0.o1.i.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            c.a.r0.o1.i.e eVar2 = this.n;
            if (eVar2 != null && eVar2.l0() != null) {
                this.n.l0().e();
            }
            if (this.s != null && (eVar = this.n) != null) {
                eVar.update();
                return;
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.f42976f;
            if (bdTypeRecyclerView == null || this.f42975e == null) {
                return;
            }
            bdTypeRecyclerView.setSelection(0);
            if (!this.f42975e.isRefreshing()) {
                c.a.r0.o1.i.e eVar3 = this.n;
                if (eVar3 != null && eVar3.k0() != null) {
                    this.n.k0().x();
                    this.n.U0(false);
                }
                this.f42975e.setRefreshing(true);
            }
            ScrollFragmentTabHost.v vVar = this.s0;
            if (vVar != null) {
                vVar.b();
            }
        }
    }

    public void resetRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.f42975e;
            if (bigdaySwipeRefreshLayout != null && bigdaySwipeRefreshLayout.isRefreshing()) {
                this.f42975e.interruptRefresh();
            }
            PbListView pbListView = this.f42980j;
            if (pbListView == null || !pbListView.m()) {
                return;
            }
            this.f42980j.D(getContext().getString(R.string.pb_load_more));
            this.f42980j.f();
            this.f42980j.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public final boolean s0(c.a.q0.s.c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, fVar)) == null) {
            if (!RightFloatLayerView.isHomePbNeedShow()) {
                hideRightFloatLayerView();
                return false;
            } else if (fVar == null) {
                return false;
            } else {
                if (this.K == null) {
                    this.K = RightFloatLayerLottieView.getRightFloatView(fVar, this.S);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 85;
                    layoutParams.bottomMargin = c.a.d.f.p.n.f(this.S, R.dimen.tbds306) + this.L;
                    this.K.completeHide();
                    addView(this.K, layoutParams);
                }
                this.K.setAutoCompleteShown(true);
                if (fVar.a()) {
                    return false;
                }
                this.K.setData(fVar);
                this.K.setLogoListener(new g(this, fVar));
                this.K.setFeedBackListener(new h(this, fVar));
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public void scrollToPositionFromMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.n.Q0();
        }
    }

    public void setCallback(c.a.r0.o1.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, cVar) == null) {
            this.m = cVar;
        }
    }

    public void setIsUnreadTipShow(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z2) == null) {
            c.a.r0.o1.i.e eVar = this.n;
            if (eVar != null) {
                eVar.R0(!z2);
            }
            this.C = z2;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, bdUniqueId) == null) {
            c.a.r0.o1.i.h.d0 d0Var = this.k;
            if (d0Var != null) {
                d0Var.x(bdUniqueId);
            }
            c.a.r0.o1.i.e eVar = this.n;
            if (eVar != null) {
                eVar.M0(bdUniqueId);
            }
            c.a.r0.o1.i.k.f fVar = this.p;
            if (fVar != null) {
                fVar.a(bdUniqueId);
            }
            c.a.r0.o1.i.i.a aVar = this.f42978h;
            if (aVar != null) {
                aVar.V(bdUniqueId);
            }
            c.a.q0.r.o.b.i().o(bdUniqueId);
            CustomMessageListener customMessageListener = this.F0;
            if (customMessageListener != null) {
                customMessageListener.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.F0);
            }
            c.a.r0.o1.i.a aVar2 = this.o;
            if (aVar2 != null) {
                aVar2.h(bdUniqueId);
            }
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, scrollFragmentTabHost) == null) {
            this.k0 = scrollFragmentTabHost;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.removeShadowChangeListener(this.s0);
                this.k0.addShadowChangeListener(this.s0);
            }
            c.a.r0.o1.i.e eVar = this.n;
            if (eVar != null) {
                eVar.V0(scrollFragmentTabHost);
            }
            c.a.r0.o1.i.a aVar = this.o;
            if (aVar != null) {
                aVar.j(scrollFragmentTabHost);
            }
        }
    }

    public void setTabInForeBackgroundState(boolean z2) {
        c.a.r0.o1.i.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048619, this, z2) == null) || (eVar = this.n) == null) {
            return;
        }
        eVar.W0(z2);
    }

    public void setViewForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            setViewForeground(false);
            c.a.r0.o1.i.e eVar = this.n;
            if (eVar != null) {
                eVar.z0(false);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            if (this.D >= 1 || !TbadkCoreApplication.getInst().isNoInterestTag()) {
                return;
            }
            c.a.d.f.m.e.a().postDelayed(this.C0, 1000L);
        }
    }

    public void showActivityPrize() {
        c.a.r0.o1.i.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048622, this) == null) || (eVar = this.n) == null) {
            return;
        }
        eVar.X0();
    }

    public void showFirstLoadingView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || this.n == null) {
            return;
        }
        p0(true);
    }

    public void showRightFloatLayerView() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048624, this) == null) || (rightFloatLayerView = this.K) == null) {
            return;
        }
        rightFloatLayerView.completeShow();
    }

    public void startFirstLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            if (this.M) {
                this.M = false;
                if (this.D0 != null) {
                    if (c.a.r0.o1.i.k.g.n().m() == this.E0) {
                        c.a.r0.o1.i.k.g.n().r(this.D0);
                    }
                    this.D0 = null;
                    return;
                }
                return;
            }
            if (this.n != null) {
                if (!MainTabDataSwitch.isCacheOpen() && c.a.r0.o1.i.k.g.n().o()) {
                    p0(true);
                }
                this.n.update();
            }
            if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
                c.a.q0.r.o.b.i().j();
                c.a.q0.r.o.b.i().k();
            }
        }
    }

    public void updateData(DataRes dataRes, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{dataRes, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            PbListView pbListView = this.f42980j;
            if (pbListView != null) {
                pbListView.D(getContext().getString(R.string.pb_load_more));
                this.f42980j.f();
                this.f42980j.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            this.n.D0(z2, z3, dataRes, 0, null);
        }
    }

    public void updateError(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048627, this, str, i2) == null) {
            PbListView pbListView = this.f42980j;
            if (pbListView != null) {
                pbListView.D(getContext().getString(R.string.pb_load_more));
                this.f42980j.f();
                this.f42980j.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            this.n.D0(true, false, null, i2, str);
        }
    }

    public void setViewForeground(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z2) == null) {
            c.a.r0.o1.i.e eVar = this.n;
            if (eVar != null) {
                eVar.G0(z2);
            }
            ScrollFragmentTabHost scrollFragmentTabHost = this.k0;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.removeShadowChangeListener(this.s0);
                this.k0.addShadowChangeListener(this.s0);
                this.s0.b();
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
        this.t = 0L;
        this.u = 3;
        this.v = false;
        this.w = false;
        this.x = -1L;
        this.y = false;
        this.z = false;
        this.C = false;
        this.D = 0;
        this.E = 0;
        this.F = false;
        this.G = 1;
        this.M = false;
        this.N = false;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.T = -1;
        this.U = -1;
        this.W = false;
        this.b0 = false;
        this.c0 = new k(this, 2156674);
        this.d0 = new v(this);
        this.e0 = new f0(this, 2921456);
        this.f0 = new g0(this, 2921553);
        this.g0 = new h0(this, CmdConfigHttp.CMD_CHECK_INTEREST_COMMIT);
        this.h0 = new i0(this);
        this.i0 = new j0(this);
        this.q0 = -1;
        this.r0 = new k0(this);
        this.s0 = new l0(this);
        this.t0 = new a(this);
        this.u0 = new b(this);
        this.v0 = new c(this, 2001371);
        this.w0 = new d(this, 2921636);
        this.x0 = new e(this);
        this.y0 = new i(this);
        this.z0 = new j(this);
        this.A0 = new l(this);
        this.B0 = new m(this);
        this.C0 = new s(this);
        this.D0 = null;
        this.E0 = new t(this);
        this.F0 = new w(this, 2001118);
        this.G0 = new x(this);
        this.H0 = new y(this, 2921033);
        this.isBigdayPullviewShowListener = new z(this, 2921349);
        this.I0 = new a0(this);
        this.J0 = new b0(this, 2921632);
        this.K0 = new c0(this, 2921664);
        this.L0 = new d0(this, 2921667);
        j0(context);
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
        this.t = 0L;
        this.u = 3;
        this.v = false;
        this.w = false;
        this.x = -1L;
        this.y = false;
        this.z = false;
        this.C = false;
        this.D = 0;
        this.E = 0;
        this.F = false;
        this.G = 1;
        this.M = false;
        this.N = false;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.T = -1;
        this.U = -1;
        this.W = false;
        this.b0 = false;
        this.c0 = new k(this, 2156674);
        this.d0 = new v(this);
        this.e0 = new f0(this, 2921456);
        this.f0 = new g0(this, 2921553);
        this.g0 = new h0(this, CmdConfigHttp.CMD_CHECK_INTEREST_COMMIT);
        this.h0 = new i0(this);
        this.i0 = new j0(this);
        this.q0 = -1;
        this.r0 = new k0(this);
        this.s0 = new l0(this);
        this.t0 = new a(this);
        this.u0 = new b(this);
        this.v0 = new c(this, 2001371);
        this.w0 = new d(this, 2921636);
        this.x0 = new e(this);
        this.y0 = new i(this);
        this.z0 = new j(this);
        this.A0 = new l(this);
        this.B0 = new m(this);
        this.C0 = new s(this);
        this.D0 = null;
        this.E0 = new t(this);
        this.F0 = new w(this, 2001118);
        this.G0 = new x(this);
        this.H0 = new y(this, 2921033);
        this.isBigdayPullviewShowListener = new z(this, 2921349);
        this.I0 = new a0(this);
        this.J0 = new b0(this, 2921632);
        this.K0 = new c0(this, 2921664);
        this.L0 = new d0(this, 2921667);
        j0(context);
    }
}
