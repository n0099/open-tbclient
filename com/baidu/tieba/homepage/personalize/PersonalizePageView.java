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
import com.repackage.a07;
import com.repackage.b9;
import com.repackage.bj8;
import com.repackage.by6;
import com.repackage.cj4;
import com.repackage.cu4;
import com.repackage.es6;
import com.repackage.f9;
import com.repackage.fy5;
import com.repackage.g07;
import com.repackage.g45;
import com.repackage.h45;
import com.repackage.hx5;
import com.repackage.hz6;
import com.repackage.i07;
import com.repackage.ix5;
import com.repackage.iz6;
import com.repackage.jz6;
import com.repackage.kn4;
import com.repackage.kw4;
import com.repackage.ln4;
import com.repackage.lp4;
import com.repackage.mi;
import com.repackage.mv6;
import com.repackage.mx5;
import com.repackage.nb;
import com.repackage.nv6;
import com.repackage.oi;
import com.repackage.oi5;
import com.repackage.pg;
import com.repackage.s85;
import com.repackage.tg;
import com.repackage.u85;
import com.repackage.uo;
import com.repackage.ux4;
import com.repackage.uz6;
import com.repackage.vb5;
import com.repackage.vt4;
import com.repackage.x8;
import com.repackage.xx6;
import com.repackage.yr4;
import com.repackage.zz6;
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
    public View.OnClickListener D0;
    public FRSRefreshButton E;
    public CustomMessageListener E0;
    public RightFloatLayerView F;
    public CustomMessageListener F0;
    public int G;
    public CustomMessageListener G0;
    public boolean H;
    public volatile boolean I;
    public FrameLayout J;
    public boolean K;
    public boolean L;
    public boolean M;
    public Context N;
    public int O;
    public int P;
    public uz6 Q;
    public boolean R;
    public Object S;
    public boolean T;
    public hz6.g U;
    public CustomMessageListener V;
    public CustomMessageListener W;
    public BigdaySwipeRefreshLayout a;
    public BdTypeRecyclerView b;
    public jz6 c;
    public iz6 d;
    public k0 e;
    public PbListView f;
    public hz6 g;
    public HttpMessageListener g0;
    public TbPageContext<?> h;
    public NEGFeedBackView.b h0;
    public nv6 i;
    public FollowUserButton.a i0;
    public by6 j;
    public ScrollFragmentTabHost j0;
    public xx6 k;
    public int k0;
    public zz6 l;
    public RecyclerView.OnScrollListener l0;
    public long m;
    public ScrollFragmentTabHost.v m0;
    public g45 n;
    public View.OnClickListener n0;
    public h45 o;
    public View.OnClickListener o0;
    public long p;
    public CustomMessageListener p0;
    public int q;
    public CustomMessageListener q0;
    public boolean r;
    public by6.o0 r0;
    public boolean s;
    public cu4.g s0;
    public long t;
    public cu4.h t0;
    public boolean u;
    public cu4.e u0;
    public boolean v;
    public cu4.f v0;
    public ix5 w;
    public Runnable w0;
    public hx5 x;
    public RecPersonalizePageModel.c x0;
    public boolean y;
    public RecPersonalizePageModel.c y0;
    public int z;
    public final CustomMessageListener z0;

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
                    this.a.R = false;
                    i07.a(2);
                    Activity currentActivity = TbadkApplication.getInst().getCurrentActivity();
                    if (currentActivity != null) {
                        BdTopToast bdTopToast = new BdTopToast(currentActivity, 2000);
                        bdTopToast.i(true);
                        bdTopToast.h(currentActivity.getString(R.string.obfuscated_res_0x7f0f0f45));
                        bdTopToast.j((ViewGroup) currentActivity.findViewById(16908290));
                    }
                }
                i07.i();
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
                this.a.f0();
                if (this.a.b != null && this.a.x != null) {
                    this.a.b.removeHeaderView(this.a.x.b());
                }
                Activity c = x8.f().c("MainTabActivity");
                if (c != null) {
                    BdTopToast bdTopToast = new BdTopToast(c, 2000);
                    bdTopToast.i(true);
                    bdTopToast.h(c.getString(R.string.obfuscated_res_0x7f0f0f45));
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
                if (TbSingleton.getInstance().isAddBanner || !i07.e()) {
                    this.a.F0();
                } else if (this.a.Q == null) {
                    this.a.Q = new uz6();
                    this.a.Q.c();
                }
                PersonalizePageView personalizePageView = this.a;
                personalizePageView.K = true;
                if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW || personalizePageView.L) {
                    return;
                }
                personalizePageView.n0();
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
                this.a.j0();
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
            if (personalizePageView.K && !personalizePageView.L) {
                personalizePageView.n0();
            }
            if (this.a.u) {
                PersonalizePageView personalizePageView2 = this.a;
                if (personalizePageView2.M) {
                    return;
                }
                personalizePageView2.M = true;
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
                    if (this.a.T) {
                        this.a.T = false;
                        this.a.K0();
                    }
                } else if (this.a.F == null || this.a.F.getVisibility() != 0) {
                } else {
                    this.a.T = true;
                    this.a.j0();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements by6.o0 {
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
                    this.c.b.g0();
                    if (this.a != 1) {
                        if (this.c.a) {
                            this.c.g();
                            this.c.b.L0();
                            return;
                        }
                        this.c.b.a.setVisibility(8);
                        PersonalizePageView personalizePageView = this.c.b;
                        personalizePageView.J0(personalizePageView, this.b, true);
                    } else {
                        if (mi.z()) {
                            this.c.b.h.showToast(this.b);
                        }
                        this.c.g();
                    }
                    g07.a("mINetLoadCallbackError" + this.a);
                    g07.b();
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
                    this.b.b.g0();
                    this.b.b.h0();
                    this.b.b.s = true;
                    if (this.a) {
                        this.b.b.t = System.currentTimeMillis();
                    }
                    g07.a("showSuccess");
                    g07.b();
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
                this.a.b.f.C(this.a.b.getContext().getString(R.string.obfuscated_res_0x7f0f0f5a));
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
            this.a = vt4.k().h("key_first_install", true);
        }

        @Override // com.repackage.by6.o0
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                tg.b(new b(this, z));
            }
        }

        @Override // com.repackage.by6.o0
        public void b(int i, vb5 vb5Var, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), vb5Var, Integer.valueOf(i2)}) == null) {
                if (this.b.i != null) {
                    boolean p0 = this.b.p0();
                    this.b.h0();
                    if (p0) {
                        this.b.H0(true);
                    }
                    this.b.i.c(i, vb5Var, i2);
                    cj4.g().s();
                    return;
                }
                PersonalizePageView personalizePageView = this.b;
                personalizePageView.J0(personalizePageView, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c17), true);
                this.b.g0();
            }
        }

        @Override // com.repackage.by6.o0
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                tg.b(new c(this));
            }
        }

        @Override // com.repackage.by6.o0
        public void d(int i, int i2, vb5 vb5Var, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), vb5Var, Integer.valueOf(i3)}) == null) || this.b.i == null) {
                return;
            }
            PersonalizePageView personalizePageView = this.b;
            if (personalizePageView.q0(personalizePageView.b)) {
                this.b.m = System.currentTimeMillis();
            }
            this.b.i.d(i, i2, vb5Var, i3);
        }

        public final void g() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.a) {
                this.a = false;
                vt4.k().u("key_first_install", false);
            }
        }

        @Override // com.repackage.by6.o0
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) {
                tg.b(new a(this, i, str));
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
                    layoutParams.bottomMargin = oi.f(this.a.N, R.dimen.tbds306) + this.a.G;
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
            es6.j().y(this.a.h.getPageActivity());
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
                this.a.O = checkInterestCommitResponseMessage.getFinishInterestStage();
                this.a.P = checkInterestCommitResponseMessage.getPersonalizedSwitchStatus();
                PersonalizePageView personalizePageView = this.a;
                if (i07.f(personalizePageView.O, personalizePageView.P)) {
                    this.a.G0();
                } else {
                    this.a.F0();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kw4 a;
        public final /* synthetic */ PersonalizePageView b;

        public f(PersonalizePageView personalizePageView, kw4 kw4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, kw4Var};
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
            this.a = kw4Var;
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
        public void a(ArrayList<Integer> arrayList, String str, lp4 lp4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, lp4Var) == null) || arrayList == null || lp4Var == null) {
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
            int i3 = lp4Var.n;
            if (i3 == 0) {
                i = 1;
            } else if (i3 == 40) {
                i = 2;
            } else if (i3 == 49 || i3 == 69) {
                i = 3;
            }
            if (this.a.g != null) {
                this.a.g.n();
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.NEG_FEEDBACK_KEY).param("tid", lp4Var.f()).param("nid", lp4Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", lp4Var.c()).param("obj_param1", lp4Var.k).param("obj_source", lp4Var.l).param("obj_id", lp4Var.m).param("obj_type", sb.toString()).param("obj_name", str).param(TiebaStatic.Params.OBJ_PARAM2, i).param("obj_locate", "1"));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(lp4 lp4Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lp4Var, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(lp4 lp4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lp4Var) == null) || lp4Var == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.NEG_FEEDBACK_KEY).param("obj_locate", "1").param("fid", lp4Var.c()).param("tid", lp4Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("nid", lp4Var.e()));
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.NEGATIVE_FEEDBACK_OPEN_CLICK).param("obj_locate", "1").param("fid", lp4Var.c()).param("tid", lp4Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kw4 a;
        public final /* synthetic */ PersonalizePageView b;

        public g(PersonalizePageView personalizePageView, kw4 kw4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, kw4Var};
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
            this.a = kw4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.F.setHomePbFloatLastCloseTime();
                this.b.i0();
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
                TiebaStatic.log(bj8.k("c13696", (ThreadData) tag));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements cu4.g {
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

        @Override // com.repackage.cu4.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                oi5.c().f("page_recommend");
                this.a.j.update();
                this.a.j.U0(false);
                this.a.B = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
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
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) || this.a.k0 == i || this.a.j0 == null) {
                return;
            }
            this.a.k0 = i;
            if (this.a.k0 == 1) {
                this.a.j0.X();
            } else if (this.a.A0(recyclerView)) {
                this.a.j0.B();
            } else {
                this.a.j0.X();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements cu4.h {
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

        @Override // com.repackage.cu4.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.j == null || this.a.j.k0() == null) {
                return;
            }
            this.a.j.k0().x();
        }
    }

    /* loaded from: classes3.dex */
    public class i0 extends ScrollFragmentTabHost.v {
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

        @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.v
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.j0 == null) {
                return;
            }
            this.a.k0 = -1;
            PersonalizePageView personalizePageView = this.a;
            if (personalizePageView.A0(personalizePageView.b)) {
                this.a.j0.B();
            } else {
                this.a.j0.X();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements cu4.e {
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

        @Override // com.repackage.cu4.e
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
    public class k implements hz6.g {
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

        @Override // com.repackage.hz6.g
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
                if (i07.e()) {
                    PersonalizePageView personalizePageView = this.a;
                    if (personalizePageView.O == -1 && personalizePageView.P == -1) {
                        return;
                    }
                }
                this.a.F0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface k0 {
        void f(cu4.g gVar);

        void g(cu4.h hVar);

        void k(cu4.e eVar);

        void m(cu4.f fVar);
    }

    /* loaded from: classes3.dex */
    public class l implements cu4.f {
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

        @Override // com.repackage.cu4.f
        public void a(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (this.a.j != null) {
                    this.a.j.U0(true);
                    this.a.j.L0();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, Boolean.TRUE));
                kn4 kn4Var = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > vt4.k().m("key_bigday_next_showtime_home", 0L)) {
                    kn4Var = ln4.i().h(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, kn4Var));
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
                    ux4 wlConfigData = TbSingleton.getInstance().getWlConfigData();
                    if (UbsABTestHelper.isLoadMoreABTest() && wlConfigData != null && wlConfigData.L() != 0) {
                        i2 = wlConfigData.L();
                    }
                    if (this.a.D.getItemCount() - this.a.D.findLastVisibleItemPosition() <= i2 * 5) {
                        this.a.r0();
                    }
                }
                if (i == 0) {
                    if (this.a.F != null) {
                        this.a.F.q();
                    }
                    if (this.a.S != null) {
                        BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(this.a.S);
                        this.a.S = null;
                    }
                } else if (i == 1) {
                    if (this.a.S == null) {
                        this.a.S = BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_HOME, "1", "scroll");
                    }
                    if (this.a.F != null) {
                        this.a.F.p();
                    }
                } else if (i == 2) {
                    if (this.a.S == null) {
                        this.a.S = BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_HOME, "1", "scroll");
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
                    uo C = this.a.b.C(this.a.D.findLastVisibleItemPosition());
                    if (C instanceof fy5) {
                        if (((fy5) C).position >= 6) {
                            this.a.E.f();
                        } else {
                            this.a.E.b();
                        }
                    }
                }
                if (!UbsABTestHelper.isHomePagePromoteLoginUbsABTestA() || TbadkCoreApplication.isLogin() || vt4.k().l("home_page_login_dialog_show_key", 0) != 0 || this.a.A < oi.p(TbadkCoreApplication.getInst().getContext())[1] * 2) {
                    return;
                }
                vt4.k().w("home_page_login_dialog_show_key", 1);
                DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.N, LoginDialogData.HOME_PAGE_RESULT_PAGE));
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
                this.a.r0();
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
            this.a.j.K0(i, i2);
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
            if (this.a.j != null && this.a.j.k0() != null) {
                this.a.j.k0().k(view2);
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
            this.a.f.C(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0da9));
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
            vt4.k().w("show_is_uninterest_tag", PersonalizePageView.K(this.a));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(this.a.h.getContext(), 2)));
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.M0(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.c
        public void onLoadError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class u extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(PersonalizePageView personalizePageView, int i) {
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
                    this.a.M0(yr4.b().c(), false, false);
                }
                this.a.g0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class v extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ v a;

            public a(v vVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {vVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = vVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.t0();
                }
            }
        }

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
                    pg.a().postDelayed(new a(this), TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class w implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.r0();
            }
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.a == null || this.a.a.t()) {
                return;
            }
            if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof kn4))) {
                if (this.a.d != null) {
                    if (this.a.e == this.a.d) {
                        return;
                    }
                    PersonalizePageView personalizePageView = this.a;
                    personalizePageView.e = personalizePageView.d;
                } else {
                    PersonalizePageView personalizePageView2 = this.a;
                    personalizePageView2.d = new iz6(personalizePageView2.h);
                    this.a.d.H(this.a.q);
                    PersonalizePageView personalizePageView3 = this.a;
                    personalizePageView3.e = personalizePageView3.d;
                    this.a.m0();
                }
                this.a.d.A(true);
                this.a.a.setProgressView(this.a.d);
                int i = (int) (this.a.getResources().getDisplayMetrics().density * 86.0f);
                this.a.a.setCustomDistances(i, i, i * 2);
                return;
            }
            kn4 kn4Var = (kn4) customResponsedMessage.getData();
            if (this.a.c != null) {
                if (this.a.e == this.a.c && kn4Var.equals(this.a.c.F())) {
                    return;
                }
                PersonalizePageView personalizePageView4 = this.a;
                personalizePageView4.e = personalizePageView4.c;
            } else {
                PersonalizePageView personalizePageView5 = this.a;
                personalizePageView5.c = new jz6(personalizePageView5.h.getContext());
                PersonalizePageView personalizePageView6 = this.a;
                personalizePageView6.e = personalizePageView6.c;
                this.a.m0();
            }
            this.a.c.A(true);
            this.a.a.setProgressView(this.a.c);
            this.a.c.I(kn4Var);
            this.a.a.setCustomDistances((int) this.a.getResources().getDimension(R.dimen.tbds236), (int) (oi.i(this.a.h.getContext()) * 0.8d), oi.i(this.a.h.getContext()));
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
            this.a.B0();
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
        this.I = false;
        this.K = false;
        this.L = false;
        this.M = false;
        this.O = -1;
        this.P = -1;
        this.R = false;
        this.T = false;
        this.U = new k(this);
        this.V = new u(this, 2921456);
        this.W = new d0(this, 2921553);
        this.g0 = new e0(this, CmdConfigHttp.CMD_CHECK_INTEREST_COMMIT);
        this.h0 = new f0(this);
        this.i0 = new g0(this);
        this.k0 = -1;
        this.l0 = new h0(this);
        this.m0 = new i0(this);
        this.n0 = new j0(this);
        this.o0 = new a(this);
        this.p0 = new b(this, 2001371);
        this.q0 = new c(this, 2921636);
        this.r0 = new d(this);
        this.s0 = new h(this);
        this.t0 = new i(this);
        this.u0 = new j(this);
        this.v0 = new l(this);
        this.w0 = new s(this);
        this.x0 = null;
        this.y0 = new t(this);
        this.z0 = new v(this, 2001118);
        this.A0 = new w(this);
        this.B0 = new x(this, 2921033);
        this.C0 = new y(this, 2921349);
        this.D0 = new z(this);
        this.E0 = new a0(this, 2921632);
        this.F0 = new b0(this, 2921664);
        this.G0 = new c0(this, 2921667);
        o0(context);
    }

    public static /* synthetic */ int K(PersonalizePageView personalizePageView) {
        int i2 = personalizePageView.z + 1;
        personalizePageView.z = i2;
        return i2;
    }

    public boolean A0(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, recyclerView)) == null) ? recyclerView == null || !recyclerView.canScrollVertically(-1) : invokeL.booleanValue;
    }

    public void B0() {
        by6 by6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            by6 by6Var2 = this.j;
            if (by6Var2 != null && by6Var2.l0() != null) {
                this.j.l0().e();
            }
            if (this.o != null && (by6Var = this.j) != null) {
                by6Var.update();
                return;
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.b;
            if (bdTypeRecyclerView == null || this.a == null) {
                return;
            }
            bdTypeRecyclerView.setSelection(0);
            if (!this.a.t()) {
                by6 by6Var3 = this.j;
                if (by6Var3 != null && by6Var3.k0() != null) {
                    this.j.k0().x();
                    this.j.U0(false);
                }
                this.a.setRefreshing(true);
            }
            ScrollFragmentTabHost.v vVar = this.m0;
            if (vVar != null) {
                vVar.b();
            }
        }
    }

    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.a;
            if (bigdaySwipeRefreshLayout != null && bigdaySwipeRefreshLayout.t()) {
                this.a.r();
            }
            PbListView pbListView = this.f;
            if (pbListView == null || !pbListView.m()) {
                return;
            }
            this.f.C(getContext().getString(R.string.obfuscated_res_0x7f0f0da9));
            this.f.f();
            this.f.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.j.Q0();
        }
    }

    public void E0() {
        by6 by6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (by6Var = this.j) == null) {
            return;
        }
        by6Var.X0();
    }

    public final void F0() {
        ix5 ix5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.b == null || (ix5Var = this.w) == null || ix5Var.b().getParent() != null || StringUtils.isNull(TbSingleton.getInstance().getLFUser()) || TbSingleton.getInstance().isAddBanner || this.R) {
            return;
        }
        this.w.d();
        this.w.b().setVisibility(0);
        this.w.f("1");
        this.b.setHeaderView(this.w.b());
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.b == null) {
            return;
        }
        if (this.x == null) {
            hx5 hx5Var = new hx5(getContext());
            this.x = hx5Var;
            hx5Var.a().setOnClickListener(this.o0);
        }
        this.b.setHeaderView(this.x.b());
        this.R = true;
        i07.b();
        ix5 ix5Var = this.w;
        if (ix5Var != null) {
            this.b.removeHeaderView(ix5Var.b());
        }
    }

    public final void H0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z2) == null) {
            if (this.n == null) {
                this.n = new g45(getContext());
                this.n.p(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + oi.f(getContext(), R.dimen.tbds60));
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

    public final void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            pg.a().post(new e(this));
        }
    }

    public final void J0(View view2, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048585, this, view2, str, z2) == null) {
            if (this.o == null) {
                this.o = new h45(getContext(), new r(this));
            }
            this.o.attachView(view2, z2);
            this.o.p();
        }
    }

    public void K0() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (rightFloatLayerView = this.F) == null) {
            return;
        }
        rightFloatLayerView.d();
    }

    public void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.H) {
                this.H = false;
                if (this.x0 != null) {
                    if (a07.n().m() == this.y0) {
                        a07.n().s(this.x0);
                    }
                    this.x0 = null;
                    return;
                }
                return;
            }
            if (this.j != null) {
                if (!MainTabDataSwitch.isCacheOpen() && a07.n().o()) {
                    H0(true);
                }
                this.j.update();
            }
            if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
                ln4.i().j();
                ln4.i().k();
            }
        }
    }

    public void M0(DataRes dataRes, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{dataRes, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            tg.b(new q(this));
            this.j.D0(z2, z3, dataRes, 0, null);
        }
    }

    public void N0(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, str, i2) == null) {
            PbListView pbListView = this.f;
            if (pbListView != null) {
                pbListView.C(getContext().getString(R.string.obfuscated_res_0x7f0f0da9));
                this.f.f();
                this.f.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            this.j.D0(true, false, null, i2, str);
        }
    }

    public final boolean O0(kw4 kw4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, kw4Var)) == null) {
            if (!RightFloatLayerView.k()) {
                i0();
                return false;
            } else if (kw4Var == null) {
                return false;
            } else {
                if (this.F == null) {
                    this.F = RightFloatLayerLottieView.F(kw4Var, this.N);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 85;
                    layoutParams.bottomMargin = oi.f(this.N, R.dimen.tbds306) + this.G;
                    this.F.c();
                    addView(this.F, layoutParams);
                }
                this.F.setAutoCompleteShown(true);
                if (kw4Var.a()) {
                    return false;
                }
                this.F.setData(kw4Var);
                this.F.setLogoListener(new f(this, kw4Var));
                this.F.setFeedBackListener(new g(this, kw4Var));
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public void d0() {
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (bigdaySwipeRefreshLayout = this.a) == null) {
            return;
        }
        bigdaySwipeRefreshLayout.r();
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
                y0();
            }
        }
    }

    public void e0(Long l2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, l2) == null) {
            this.j.c0(l2);
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (this.o != null) {
                B0();
                return;
            }
            by6 by6Var = this.j;
            if (by6Var != null) {
                by6Var.update();
            }
        }
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            g45 g45Var = this.n;
            if (g45Var != null) {
                g45Var.dettachView(this);
                this.n = null;
                this.b.setNextPage(this.f);
                this.f.C(getContext().getString(R.string.obfuscated_res_0x7f0f0da9));
                this.f.f();
                this.f.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, Boolean.TRUE));
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.a;
            if (bigdaySwipeRefreshLayout != null) {
                bigdaySwipeRefreshLayout.setVisibility(0);
            }
            nv6 nv6Var = this.i;
            if (nv6Var != null) {
                nv6Var.b();
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

    public boolean getIsUnreadTipShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.y : invokeV.booleanValue;
    }

    public FrameLayout getmTaskFloatingView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.J : (FrameLayout) invokeV.objValue;
    }

    public final void h0() {
        h45 h45Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (h45Var = this.o) == null) {
            return;
        }
        h45Var.dettachView(this);
        this.o = null;
    }

    public void i0() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (rightFloatLayerView = this.F) == null) {
            return;
        }
        rightFloatLayerView.c();
    }

    public final void j0() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (rightFloatLayerView = this.F) == null) {
            return;
        }
        rightFloatLayerView.setAutoCompleteShown(false);
        this.F.clearAnimation();
        this.F.setVisibility(8);
    }

    public synchronized void k0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, context) == null) {
            synchronized (this) {
                if (this.I) {
                    return;
                }
                this.I = true;
                this.N = context;
                MessageManager.getInstance().registerListener(this.q0);
                MessageManager.getInstance().registerListener(this.p0);
                MessageManager.getInstance().registerListener(this.V);
                MessageManager.getInstance().registerListener(this.W);
                MessageManager.getInstance().registerListener(this.C0);
                MessageManager.getInstance().registerListener(this.B0);
                MessageManager.getInstance().registerListener(this.g0);
                MessageManager.getInstance().registerListener(this.E0);
                MessageManager.getInstance().registerListener(this.F0);
                MessageManager.getInstance().registerListener(this.G0);
                b9<?> a2 = f9.a(context);
                if (a2 instanceof TbPageContext) {
                    this.h = (TbPageContext) a2;
                }
                ln4.i().n(true);
                kn4 kn4Var = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > vt4.k().m("key_bigday_next_showtime_home", 0L)) {
                    kn4Var = ln4.i().h(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, kn4Var));
                this.l = new zz6();
                hz6 hz6Var = new hz6(context, this.b);
                this.g = hz6Var;
                hz6Var.y(this.l);
                this.g.w(this.U);
                this.j = new by6(this.h, this.b, this.g, this.a, this);
                this.k = new xx6(this.h);
                u0(TbadkCoreApplication.getInst().getSkinType());
                this.z = vt4.k().l("show_is_uninterest_tag", 0);
            }
        }
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.g.v(this.h0);
            this.g.t(this.i0);
            this.j.T0(this.r0);
            this.k.i(this);
            m0();
            this.b.addOnScrollListener(new m(this));
            this.b.setOnSrollToBottomListener(new n(this));
            this.b.setOnScrollStopDelayedListener(new o(this), 1L);
            this.b.setRecyclerListener(new p(this));
            this.b.removeOnScrollListener(this.l0);
            this.b.addOnScrollListener(this.l0);
        }
    }

    public void m0() {
        k0 k0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (k0Var = this.e) == null) {
            return;
        }
        k0Var.f(this.s0);
        this.e.g(this.t0);
        this.e.k(this.u0);
        this.e.m(this.v0);
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.L = true;
            kw4 homeAdFloatViewItemData = TbSingleton.getInstance().getHomeAdFloatViewItemData();
            if (!((homeAdFloatViewItemData == null || homeAdFloatViewItemData.a()) ? false : O0(homeAdFloatViewItemData))) {
                j0();
                I0();
                return;
            }
            es6.j().t();
        }
    }

    public final void o0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, context) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = new BdTypeRecyclerView(context);
            this.b = bdTypeRecyclerView;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(bdTypeRecyclerView.getContext());
            this.D = linearLayoutManager;
            this.b.setLayoutManager(linearLayoutManager);
            this.b.setFadingEdgeLength(0);
            this.b.setOverScrollMode(2);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.b.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            ix5 ix5Var = new ix5(context);
            this.w = ix5Var;
            ix5Var.setFrom("from_personaize");
            this.w.a().setVisibility(0);
            this.w.a().setOnClickListener(this.n0);
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
            this.f.t(oi.f(context, R.dimen.tbds182));
            this.f.B(this.A0);
            this.f.s();
            this.b.setNextPage(this.f);
            addView(this.a);
            if (TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
                this.E = new FRSRefreshButton(context);
                int f2 = oi.f(context, R.dimen.tbds170);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f2, f2);
                layoutParams.gravity = 85;
                layoutParams.rightMargin = oi.f(context, R.dimen.tbds24);
                layoutParams.bottomMargin = oi.f(context, R.dimen.tbds180);
                addView(this.E, layoutParams);
                this.E.setOnClickListener(this.D0);
                this.E.setVisibility(8);
            }
            this.J = new FrameLayout(context);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 5;
            layoutParams2.topMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
            layoutParams2.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X011);
            addView(this.J, layoutParams2);
        }
    }

    public final boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            h45 h45Var = this.o;
            if (h45Var != null) {
                return h45Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean q0(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, recyclerView)) == null) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            return linearLayoutManager.getChildCount() > 0 && linearLayoutManager.findLastVisibleItemPosition() == linearLayoutManager.getItemCount() - 1 && recyclerView.getScrollState() == 0;
        }
        return invokeL.booleanValue;
    }

    public final void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            mv6.d().j(System.currentTimeMillis(), 1);
            PbListView pbListView = this.f;
            if (pbListView != null && !pbListView.m()) {
                this.f.Q();
                this.f.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            this.j.w0();
        }
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.j.t0();
        }
    }

    public void setCallback(nv6 nv6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, nv6Var) == null) {
            this.i = nv6Var;
        }
    }

    public void setIsUnreadTipShow(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z2) == null) {
            by6 by6Var = this.j;
            if (by6Var != null) {
                by6Var.R0(!z2);
            }
            this.y = z2;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, bdUniqueId) == null) {
            hz6 hz6Var = this.g;
            if (hz6Var != null) {
                hz6Var.x(bdUniqueId);
            }
            by6 by6Var = this.j;
            if (by6Var != null) {
                by6Var.M0(bdUniqueId);
            }
            zz6 zz6Var = this.l;
            if (zz6Var != null) {
                zz6Var.a(bdUniqueId);
            }
            iz6 iz6Var = this.d;
            if (iz6Var != null) {
                iz6Var.a0(bdUniqueId);
            }
            ln4.i().o(bdUniqueId);
            CustomMessageListener customMessageListener = this.z0;
            if (customMessageListener != null) {
                customMessageListener.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.z0);
            }
            xx6 xx6Var = this.k;
            if (xx6Var != null) {
                xx6Var.h(bdUniqueId);
            }
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, scrollFragmentTabHost) == null) {
            this.j0 = scrollFragmentTabHost;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.T(this.m0);
                this.j0.y(this.m0);
            }
            by6 by6Var = this.j;
            if (by6Var != null) {
                by6Var.V0(scrollFragmentTabHost);
            }
            xx6 xx6Var = this.k;
            if (xx6Var != null) {
                xx6Var.j(scrollFragmentTabHost);
            }
        }
    }

    public void setTabInForeBackgroundState(boolean z2) {
        by6 by6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048614, this, z2) == null) || (by6Var = this.j) == null) {
            return;
        }
        by6Var.W0(z2);
    }

    public void setViewForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            setViewForeground(false);
            by6 by6Var = this.j;
            if (by6Var != null) {
                by6Var.z0(false);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            if (this.z >= 1 || !TbadkCoreApplication.getInst().isNoInterestTag()) {
                return;
            }
            pg.a().postDelayed(this.w0, 1000L);
        }
    }

    public void t0() {
        hz6 hz6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || (hz6Var = this.g) == null) {
            return;
        }
        hz6Var.n();
    }

    public void u0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            if (this.q != i2) {
                g45 g45Var = this.n;
                if (g45Var != null) {
                    g45Var.onChangeSkinType();
                }
                h45 h45Var = this.o;
                if (h45Var != null) {
                    h45Var.onChangeSkinType();
                }
                iz6 iz6Var = this.d;
                if (iz6Var != null) {
                    iz6Var.H(i2);
                }
                PbListView pbListView = this.f;
                if (pbListView != null) {
                    pbListView.E(SkinManager.getColor(R.color.CAM_X0109));
                    this.f.d(i2);
                }
                this.g.o(i2);
                by6 by6Var = this.j;
                if (by6Var != null) {
                    by6Var.B0(i2);
                }
                FRSRefreshButton fRSRefreshButton = this.E;
                if (fRSRefreshButton != null) {
                    fRSRefreshButton.d(i2);
                }
                ix5 ix5Var = this.w;
                if (ix5Var != null) {
                    ix5Var.e(i2);
                }
                RightFloatLayerView rightFloatLayerView = this.F;
                if (rightFloatLayerView != null) {
                    rightFloatLayerView.o();
                }
                hx5 hx5Var = this.x;
                if (hx5Var != null) {
                    hx5Var.d(i2);
                }
            }
            this.q = i2;
        }
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.q0);
            MessageManager.getInstance().unRegisterListener(this.p0);
            MessageManager.getInstance().unRegisterListener(this.V);
            MessageManager.getInstance().unRegisterListener(this.B0);
            MessageManager.getInstance().unRegisterListener(this.C0);
            MessageManager.getInstance().unRegisterListener(this.W);
            MessageManager.getInstance().unRegisterListener(this.g0);
            MessageManager.getInstance().unRegisterListener(this.E0);
            MessageManager.getInstance().unRegisterListener(this.F0);
            MessageManager.getInstance().unRegisterListener(this.G0);
            this.j.C0();
            this.g.v(null);
            this.g.p();
            this.I = false;
            this.j.T0(null);
            jz6 jz6Var = this.c;
            if (jz6Var != null) {
                jz6Var.f(null);
                this.c.g(null);
                this.c.k(null);
                this.c.m(null);
                this.c.G();
            }
            iz6 iz6Var = this.d;
            if (iz6Var != null) {
                iz6Var.f(null);
                this.d.g(null);
                this.d.k(null);
                this.d.m(null);
                this.d.Y();
            }
            this.b.setOnSrollToBottomListener(null);
            ScrollFragmentTabHost scrollFragmentTabHost = this.j0;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.T(this.m0);
            }
            this.b.removeOnScrollListener(this.l0);
            g45 g45Var = this.n;
            if (g45Var != null) {
                g45Var.n();
            }
            this.b.setRecyclerListener(null);
            xx6 xx6Var = this.k;
            if (xx6Var != null) {
                xx6Var.g();
            }
            ln4.i().e();
            pg.a().removeCallbacks(this.w0);
            uz6 uz6Var = this.Q;
            if (uz6Var != null) {
                uz6Var.a();
            }
        }
    }

    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.j.F0();
            hz6 hz6Var = this.g;
            if (hz6Var != null) {
                hz6Var.q();
            }
            RightFloatLayerView rightFloatLayerView = this.F;
            if (rightFloatLayerView == null || !(rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                return;
            }
            ((RightFloatLayerLottieView) rightFloatLayerView).H(600);
        }
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            if (this.r) {
                B0();
                this.r = false;
            }
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.a;
            if (bigdaySwipeRefreshLayout != null) {
                bigdaySwipeRefreshLayout.D();
            }
            hz6 hz6Var = this.g;
            if (hz6Var != null) {
                hz6Var.r();
            }
            if (RightFloatLayerView.k()) {
                return;
            }
            j0();
        }
    }

    public final void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            if (!this.u) {
                long f2 = mv6.d().f(1) + mv6.d().b();
                long a2 = mv6.d().a(1);
                if (a2 > 0) {
                    f2 = System.currentTimeMillis() - a2;
                }
                u85 u85Var = new u85();
                u85Var.a();
                u85Var.b();
                s85.b().o(f2);
                if (this.t > 0) {
                    s85.b().E(System.currentTimeMillis() - this.t);
                }
                s85.b().I(u85Var.c());
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.SECOND_DRAW_DISPATCH_STAMP_KEY);
                if (!MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW && !this.M) {
                    this.M = true;
                    SpeedStats.getInstance().onMainPageStatsEnd(getContext());
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921637, ""));
            }
            this.u = true;
        }
    }

    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            by6 by6Var = this.j;
            if (by6Var != null) {
                by6Var.z0(true);
            }
            mx5.b().d(false);
            oi5.c().h("page_recommend", "show_");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            pg.a().removeCallbacks(this.w0);
        }
    }

    public void setViewForeground(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z2) == null) {
            by6 by6Var = this.j;
            if (by6Var != null) {
                by6Var.G0(z2);
            }
            ScrollFragmentTabHost scrollFragmentTabHost = this.j0;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.T(this.m0);
                this.j0.y(this.m0);
                this.m0.b();
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
        this.I = false;
        this.K = false;
        this.L = false;
        this.M = false;
        this.O = -1;
        this.P = -1;
        this.R = false;
        this.T = false;
        this.U = new k(this);
        this.V = new u(this, 2921456);
        this.W = new d0(this, 2921553);
        this.g0 = new e0(this, CmdConfigHttp.CMD_CHECK_INTEREST_COMMIT);
        this.h0 = new f0(this);
        this.i0 = new g0(this);
        this.k0 = -1;
        this.l0 = new h0(this);
        this.m0 = new i0(this);
        this.n0 = new j0(this);
        this.o0 = new a(this);
        this.p0 = new b(this, 2001371);
        this.q0 = new c(this, 2921636);
        this.r0 = new d(this);
        this.s0 = new h(this);
        this.t0 = new i(this);
        this.u0 = new j(this);
        this.v0 = new l(this);
        this.w0 = new s(this);
        this.x0 = null;
        this.y0 = new t(this);
        this.z0 = new v(this, 2001118);
        this.A0 = new w(this);
        this.B0 = new x(this, 2921033);
        this.C0 = new y(this, 2921349);
        this.D0 = new z(this);
        this.E0 = new a0(this, 2921632);
        this.F0 = new b0(this, 2921664);
        this.G0 = new c0(this, 2921667);
        o0(context);
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
        this.I = false;
        this.K = false;
        this.L = false;
        this.M = false;
        this.O = -1;
        this.P = -1;
        this.R = false;
        this.T = false;
        this.U = new k(this);
        this.V = new u(this, 2921456);
        this.W = new d0(this, 2921553);
        this.g0 = new e0(this, CmdConfigHttp.CMD_CHECK_INTEREST_COMMIT);
        this.h0 = new f0(this);
        this.i0 = new g0(this);
        this.k0 = -1;
        this.l0 = new h0(this);
        this.m0 = new i0(this);
        this.n0 = new j0(this);
        this.o0 = new a(this);
        this.p0 = new b(this, 2001371);
        this.q0 = new c(this, 2921636);
        this.r0 = new d(this);
        this.s0 = new h(this);
        this.t0 = new i(this);
        this.u0 = new j(this);
        this.v0 = new l(this);
        this.w0 = new s(this);
        this.x0 = null;
        this.y0 = new t(this);
        this.z0 = new v(this, 2001118);
        this.A0 = new w(this);
        this.B0 = new x(this, 2921033);
        this.C0 = new y(this, 2921349);
        this.D0 = new z(this);
        this.E0 = new a0(this, 2921632);
        this.F0 = new b0(this, 2921664);
        this.G0 = new c0(this, 2921667);
        o0(context);
    }
}
