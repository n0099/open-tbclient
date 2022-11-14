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
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.fluency.BdTracesManager;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
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
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tbadk.widget.RightFloatLayerLottieView;
import com.baidu.tbadk.widget.RightFloatLayerView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.a46;
import com.baidu.tieba.a56;
import com.baidu.tieba.ah;
import com.baidu.tieba.b57;
import com.baidu.tieba.bf5;
import com.baidu.tieba.d37;
import com.baidu.tieba.df5;
import com.baidu.tieba.di5;
import com.baidu.tieba.e46;
import com.baidu.tieba.eh;
import com.baidu.tieba.f35;
import com.baidu.tieba.g07;
import com.baidu.tieba.hc;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.adapter.HomePageCardVideoViewHolder;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.homepage.personalize.data.CheckInterestCommitResponseMessage;
import com.baidu.tieba.i07;
import com.baidu.tieba.i57;
import com.baidu.tieba.ia5;
import com.baidu.tieba.j07;
import com.baidu.tieba.ja5;
import com.baidu.tieba.jq5;
import com.baidu.tieba.k07;
import com.baidu.tieba.k47;
import com.baidu.tieba.l47;
import com.baidu.tieba.ln8;
import com.baidu.tieba.lr4;
import com.baidu.tieba.m47;
import com.baidu.tieba.mr4;
import com.baidu.tieba.n9;
import com.baidu.tieba.o15;
import com.baidu.tieba.pt4;
import com.baidu.tieba.py4;
import com.baidu.tieba.r9;
import com.baidu.tieba.sw4;
import com.baidu.tieba.va5;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.w47;
import com.baidu.tieba.x9;
import com.baidu.tieba.xn;
import com.baidu.tieba.yi;
import com.baidu.tieba.z27;
import com.baidu.tieba.z36;
import com.baidu.tieba.zm4;
import com.baidu.tieba.zy4;
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
/* loaded from: classes4.dex */
public class PersonalizePageView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public CustomMessageListener A0;
    public boolean B;
    public CustomMessageListener B0;
    public int C;
    public View.OnClickListener C0;
    public LinearLayoutManager D;
    public CustomMessageListener D0;
    public FRSRefreshButton E;
    public CustomMessageListener E0;
    public RightFloatLayerView F;
    public CustomMessageListener F0;
    public int G;
    public g07 H;
    public volatile boolean I;
    public FrameLayout J;
    public boolean K;
    public boolean L;
    public boolean M;
    public Context N;
    public int O;
    public int P;
    public w47 Q;
    public boolean R;
    public Object S;
    public boolean T;
    public k47.f U;
    public CustomMessageListener V;
    public CustomMessageListener W;
    public BigdaySwipeRefreshLayout a;
    public HttpMessageListener a0;
    public BdTypeRecyclerView b;
    public NEGFeedBackView.b b0;
    public m47 c;
    public FollowUserButton.a c0;
    public l47 d;
    public k07 d0;
    public k0 e;
    public int e0;
    public PbListView f;
    public RecyclerView.OnScrollListener f0;
    public k47 g;
    public ScrollFragmentTabHost.v g0;
    public TbPageContext<?> h;
    public View.OnClickListener h0;
    public j07 i;
    public View.OnClickListener i0;
    public d37 j;
    public CustomMessageListener j0;
    public z27 k;
    public b57 l;
    public long m;
    public ia5 n;
    public ja5 o;
    public long p;
    public int q;
    public CustomMessageListener q0;
    public boolean r;
    public d37.q0 r0;
    public boolean s;
    public CustomMessageListener s0;
    public long t;
    public zy4.g t0;
    public boolean u;
    public zy4.h u0;
    public boolean v;
    public zy4.e v0;
    public a46 w;
    public zy4.f w0;
    public z36 x;
    public Runnable x0;
    public boolean y;
    public final CustomMessageListener y0;
    public int z;
    public View.OnClickListener z0;

    /* loaded from: classes4.dex */
    public interface k0 {
        void f(zy4.g gVar);

        void g(zy4.h hVar);

        void k(zy4.e eVar);

        void m(zy4.f fVar);
    }

    /* loaded from: classes4.dex */
    public class d implements d37.q0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ PersonalizePageView b;

        /* loaded from: classes4.dex */
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
                if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                    return;
                }
                this.c.b.c0();
                if (this.a == 1) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        this.c.b.h.showToast(this.b);
                    }
                    this.c.g();
                } else if (this.c.a) {
                    this.c.g();
                    this.c.b.H0(false);
                    return;
                } else {
                    this.c.b.a.setVisibility(8);
                    this.c.b.H.q(false);
                    PersonalizePageView personalizePageView = this.c.b;
                    personalizePageView.F0(personalizePageView, this.b, true);
                }
                hc.b().e();
            }
        }

        /* loaded from: classes4.dex */
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
                    this.b.b.H.q(true);
                    this.b.b.c0();
                    this.b.b.d0();
                    this.b.b.s = true;
                    if (this.a) {
                        this.b.b.t = System.currentTimeMillis();
                    }
                }
            }
        }

        /* loaded from: classes4.dex */
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b.f != null) {
                    this.a.b.f.E(this.a.b.getContext().getString(R.string.obfuscated_res_0x7f0f0ffe));
                    this.a.b.f.f();
                    this.a.b.f.N(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                }
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
            this.a = py4.k().h("key_first_install", true);
        }

        @Override // com.baidu.tieba.d37.q0
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                eh.b(new b(this, z));
            }
        }

        @Override // com.baidu.tieba.d37.q0
        public void b(int i, di5 di5Var, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), di5Var, Integer.valueOf(i2)}) == null) {
                if (this.b.i == null) {
                    PersonalizePageView personalizePageView = this.b;
                    personalizePageView.F0(personalizePageView, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c81), true);
                    this.b.c0();
                    return;
                }
                boolean m0 = this.b.m0();
                this.b.d0();
                if (m0) {
                    this.b.E0(true);
                }
                this.b.i.c(i, di5Var, i2);
                zm4.f().m();
            }
        }

        @Override // com.baidu.tieba.d37.q0
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                eh.b(new c(this));
            }
        }

        public final void g() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.a) {
                this.a = false;
                py4.k().u("key_first_install", false);
            }
        }

        @Override // com.baidu.tieba.d37.q0
        public void d(int i, int i2, di5 di5Var, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), di5Var, Integer.valueOf(i3)}) == null) && this.b.i != null) {
                PersonalizePageView personalizePageView = this.b;
                if (personalizePageView.n0(personalizePageView.b)) {
                    this.b.m = System.currentTimeMillis();
                }
                this.b.i.d(i, i2, di5Var, i3);
            }
        }

        @Override // com.baidu.tieba.d37.q0
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) {
                eh.b(new a(this, i, str));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* loaded from: classes4.dex */
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
                    this.a.a.r0();
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
                    ah.a().postDelayed(new a(this), TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                    i57.a(2);
                    Activity currentActivity = TbadkApplication.getInst().getCurrentActivity();
                    if (currentActivity != null) {
                        BdTopToast bdTopToast = new BdTopToast(currentActivity, 2000);
                        bdTopToast.h(true);
                        bdTopToast.g(currentActivity.getString(R.string.obfuscated_res_0x7f0f0fec));
                        bdTopToast.i((ViewGroup) currentActivity.findViewById(16908290));
                    }
                }
                i57.i();
            }
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.b0();
                if (this.a.b != null && this.a.x != null) {
                    this.a.b.removeHeaderView(this.a.x.b());
                }
                Activity c = n9.g().c("MainTabActivity");
                if (c != null) {
                    BdTopToast bdTopToast = new BdTopToast(c, 2000);
                    bdTopToast.h(true);
                    bdTopToast.g(c.getString(R.string.obfuscated_res_0x7f0f0fec));
                    bdTopToast.i((ViewGroup) c.findViewById(16908290));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                if (!TbSingleton.getInstance().isAddBanner && i57.e()) {
                    if (this.a.Q == null) {
                        this.a.Q = new w47();
                        this.a.Q.c();
                    }
                } else {
                    this.a.C0();
                }
                PersonalizePageView personalizePageView = this.a;
                personalizePageView.K = true;
                if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW || personalizePageView.L) {
                    return;
                }
                personalizePageView.k0();
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.f0();
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && SpeedStatsUtils.UBC_VALUE_SPLASH.equals(customResponsedMessage.getData())) {
                PersonalizePageView personalizePageView = this.a;
                if (personalizePageView.K && !personalizePageView.L) {
                    personalizePageView.k0();
                }
                if (this.a.u) {
                    PersonalizePageView personalizePageView2 = this.a;
                    if (!personalizePageView2.M) {
                        personalizePageView2.M = true;
                        SpeedStats.getInstance().onMainPageStatsEnd(this.a.getContext());
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                    if (!this.a.T) {
                        return;
                    }
                    this.a.T = false;
                    this.a.G0();
                } else if (this.a.F == null || this.a.F.getVisibility() != 0) {
                } else {
                    this.a.T = true;
                    this.a.f0();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Integer) {
                this.a.G = ((Integer) data).intValue();
                if (this.a.F != null) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.F.getLayoutParams();
                    layoutParams.gravity = 85;
                    layoutParams.bottomMargin = yi.g(this.a.N, R.dimen.tbds306) + this.a.G;
                    this.a.F.requestLayout();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(PersonalizePageView personalizePageView, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue() && va5.d().b() && this.a.f != null && this.a.f.j() == 0) {
                this.a.f.N(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
        }
    }

    /* loaded from: classes4.dex */
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
                if (i57.f(personalizePageView.O, personalizePageView.P)) {
                    this.a.D0();
                } else {
                    this.a.C0();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o15 a;
        public final /* synthetic */ PersonalizePageView b;

        public f(PersonalizePageView personalizePageView, o15 o15Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, o15Var};
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
            this.a = o15Var;
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

    /* loaded from: classes4.dex */
    public class f0 implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(pt4 pt4Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pt4Var, compoundButton, z) == null) {
            }
        }

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
        public void a(ArrayList<Integer> arrayList, String str, pt4 pt4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, pt4Var) == null) && arrayList != null && pt4Var != null) {
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
                int i3 = pt4Var.n;
                if (i3 == 0) {
                    i = 1;
                } else if (i3 == 40) {
                    i = 2;
                } else if (i3 == 49 || i3 == 69) {
                    i = 3;
                }
                if (this.a.g != null) {
                    this.a.g.l();
                }
                this.a.p0();
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.NEG_FEEDBACK_KEY).param("tid", pt4Var.f()).param("nid", pt4Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", pt4Var.c()).param("obj_param1", pt4Var.k).param("obj_source", pt4Var.l).param("obj_id", pt4Var.m).param("obj_type", sb.toString()).param("obj_name", str).param(TiebaStatic.Params.OBJ_PARAM2, i).param("obj_locate", "1"));
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(pt4 pt4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pt4Var) != null) || pt4Var == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.NEG_FEEDBACK_KEY).param("obj_locate", "1").param("fid", pt4Var.c()).param("tid", pt4Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("nid", pt4Var.e()));
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.NEGATIVE_FEEDBACK_OPEN_CLICK).param("obj_locate", "1").param("fid", pt4Var.c()).param("tid", pt4Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o15 a;
        public final /* synthetic */ PersonalizePageView b;

        public g(PersonalizePageView personalizePageView, o15 o15Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, o15Var};
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
            this.a = o15Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.F.setHomePbFloatLastCloseTime();
                this.b.e0();
                this.b.F.u(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || view2 == null) {
                return;
            }
            Object tag = view2.getTag();
            if (tag instanceof ThreadData) {
                TiebaStatic.log(ln8.j("c13696", (ThreadData) tag));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements zy4.g {
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

        @Override // com.baidu.tieba.zy4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048576, this, z) != null) {
                return;
            }
            this.a.B = true;
            jq5.c().f("page_recommend");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            this.a.j.update();
            this.a.j.Y0(false);
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable != null && interceptable.invokeLI(1048576, this, recyclerView, i) != null) || this.a.e0 == i || this.a.d0 == null) {
                return;
            }
            this.a.e0 = i;
            if (this.a.e0 == 1) {
                this.a.d0.a();
            } else if (this.a.y0(recyclerView)) {
                this.a.d0.c();
            } else {
                this.a.d0.a();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements zy4.h {
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

        @Override // com.baidu.tieba.zy4.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.j != null && this.a.j.o0() != null) {
                this.a.j.o0().y();
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.d0 == null) {
                return;
            }
            this.a.e0 = -1;
            PersonalizePageView personalizePageView = this.a;
            if (personalizePageView.y0(personalizePageView.b)) {
                this.a.d0.c();
            } else {
                this.a.d0.a();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements zy4.e {
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

        @Override // com.baidu.tieba.zy4.e
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.a.B) {
                return;
            }
            this.a.A = 0;
            this.a.C = 1;
            this.a.B = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null) {
                this.a.b.removeHeaderView(this.a.w.b());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements k47.f {
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

        @Override // com.baidu.tieba.k47.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (TbSingleton.getInstance().isAddBanner) {
                    if (this.a.b != null && this.a.w != null) {
                        this.a.b.removeHeaderView(this.a.w.b());
                    }
                    if (this.a.b != null && this.a.x != null) {
                        this.a.b.removeHeaderView(this.a.x.b());
                        return;
                    }
                    return;
                }
                if (i57.e()) {
                    PersonalizePageView personalizePageView = this.a;
                    if (personalizePageView.O == -1 && personalizePageView.P == -1) {
                        return;
                    }
                }
                this.a.C0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements zy4.f {
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

        @Override // com.baidu.tieba.zy4.f
        public void a(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (this.a.j != null) {
                    this.a.j.Y0(true);
                    this.a.j.P0();
                }
                TbSingleton.getInstance().mIsForceLayoutMaintab = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, Boolean.TRUE));
                lr4 lr4Var = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > py4.k().m("key_bigday_next_showtime_home", 0L)) {
                    lr4Var = mr4.i().h(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, lr4Var));
            }
        }
    }

    /* loaded from: classes4.dex */
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
                    f35 wlConfigData = TbSingleton.getInstance().getWlConfigData();
                    if (UbsABTestHelper.isLoadMoreABTest() && wlConfigData != null && wlConfigData.H() != 0) {
                        i2 = wlConfigData.H();
                    }
                    if (this.a.D.getItemCount() - this.a.D.findLastVisibleItemPosition() <= i2 * 5) {
                        this.a.o0();
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
                    xn B = this.a.b.B(this.a.D.findLastVisibleItemPosition());
                    if (B instanceof a56) {
                        if (((a56) B).position >= 6) {
                            this.a.E.f();
                        } else {
                            this.a.E.b();
                        }
                    }
                }
                if (UbsABTestHelper.isHomePagePromoteLoginUbsABTestA() && !TbadkCoreApplication.isLogin() && py4.k().l("home_page_login_dialog_show_key", 0) == 0 && this.a.A >= yi.s(TbadkCoreApplication.getInst().getContext())[1] * 2) {
                    py4.k().w("home_page_login_dialog_show_key", 1);
                    DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.N, LoginDialogData.HOME_PAGE_RESULT_PAGE));
                }
                if (this.a.H != null) {
                    this.a.H.j();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.o0();
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable != null && interceptable.invokeII(1048576, this, i, i2) != null) || System.currentTimeMillis() - this.a.p < 5000) {
                return;
            }
            this.a.j.O0(i, i2);
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, viewHolder) != null) || viewHolder == null || (view2 = viewHolder.itemView) == null) {
                return;
            }
            if (this.a.j != null && this.a.j.o0() != null) {
                this.a.j.o0().k(view2);
            }
            if (view2.getTag() instanceof HomePageCardVideoViewHolder) {
                ((HomePageCardVideoViewHolder) view2.getTag()).a().stopPlay();
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.f != null) {
                this.a.f.E(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0e21));
                this.a.f.f();
                this.a.f.N(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.j != null) {
                this.a.j.update();
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.h != null) {
                py4.k().w("show_is_uninterest_tag", PersonalizePageView.L(this.a));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(this.a.h.getContext(), 2)));
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.o0();
        }
    }

    /* loaded from: classes4.dex */
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
                    this.a.I0(sw4.b().c(), false, false);
                }
                this.a.c0();
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (!(data instanceof String) || TextUtils.isEmpty((String) data)) {
                    return;
                }
                this.a.r = true;
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.i0(customResponsedMessage.getData());
        }
    }

    /* loaded from: classes4.dex */
    public class y implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lr4 a;
        public final /* synthetic */ PersonalizePageView b;

        public y(PersonalizePageView personalizePageView, lr4 lr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, lr4Var};
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
            this.a = lr4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.c.I(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.E != null) {
                this.a.E.b();
                this.a.z0();
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
        this.K = false;
        this.L = false;
        this.M = false;
        this.O = -1;
        this.P = -1;
        this.R = false;
        this.T = false;
        this.U = new k(this);
        this.V = new v(this, 2921456);
        this.W = new d0(this, 2921553);
        this.a0 = new e0(this, CmdConfigHttp.CMD_CHECK_INTEREST_COMMIT);
        this.b0 = new f0(this);
        this.c0 = new g0(this);
        this.e0 = -1;
        this.f0 = new h0(this);
        this.g0 = new i0(this);
        this.h0 = new j0(this);
        this.i0 = new a(this);
        this.j0 = new b(this, 2001371);
        this.q0 = new c(this, 2921736);
        this.r0 = new d(this);
        this.s0 = new e(this, 2921551);
        this.t0 = new h(this);
        this.u0 = new i(this);
        this.v0 = new j(this);
        this.w0 = new l(this);
        this.x0 = new s(this);
        this.y0 = new t(this, 2001118);
        this.z0 = new u(this);
        this.A0 = new w(this, 2921033);
        this.B0 = new x(this, 2921349);
        this.C0 = new z(this);
        this.D0 = new a0(this, 2921632);
        this.E0 = new b0(this, 2921664);
        this.F0 = new c0(this, 2921667);
        l0(context);
    }

    public synchronized void g0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, context) == null) {
            synchronized (this) {
                if (this.I) {
                    return;
                }
                this.I = true;
                this.N = context;
                MessageManager.getInstance().registerListener(this.q0);
                MessageManager.getInstance().registerListener(this.j0);
                MessageManager.getInstance().registerListener(this.V);
                MessageManager.getInstance().registerListener(this.W);
                MessageManager.getInstance().registerListener(this.B0);
                MessageManager.getInstance().registerListener(this.A0);
                MessageManager.getInstance().registerListener(this.a0);
                MessageManager.getInstance().registerListener(this.D0);
                MessageManager.getInstance().registerListener(this.E0);
                MessageManager.getInstance().registerListener(this.F0);
                MessageManager.getInstance().registerListener(this.s0);
                r9<?> a2 = x9.a(context);
                if (a2 instanceof TbPageContext) {
                    this.h = (TbPageContext) a2;
                }
                this.H.o(this.h);
                lr4 lr4Var = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > py4.k().m("key_bigday_next_showtime_home", 0L)) {
                    lr4Var = mr4.i().h(1);
                }
                if (LaunchViewOptSwitch.getIsOn()) {
                    try {
                        i0(lr4Var);
                    } catch (Exception unused) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, lr4Var));
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, lr4Var));
                }
                this.l = new b57();
                k47 k47Var = new k47(context, this.b);
                this.g = k47Var;
                k47Var.w(this.l);
                this.g.u(this.U);
                this.j = new d37(this.h, this.b, this.g, this.a, this);
                this.k = new z27(this.h);
                s0(TbadkCoreApplication.getInst().getSkinType());
                this.z = py4.k().l("show_is_uninterest_tag", 0);
            }
        }
    }

    public final void l0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, context) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = new BdTypeRecyclerView(context);
            this.b = bdTypeRecyclerView;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(bdTypeRecyclerView.getContext());
            this.D = linearLayoutManager;
            this.b.setLayoutManager(linearLayoutManager);
            this.b.setFadingEdgeLength(0);
            this.b.setOverScrollMode(2);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.b.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            a46 a46Var = new a46(context);
            this.w = a46Var;
            a46Var.setFrom("from_personaize");
            this.w.a().setVisibility(0);
            this.w.a().setOnClickListener(this.h0);
            g07 g07Var = new g07(this, this.b);
            this.H = g07Var;
            g07Var.p(context.getString(R.string.obfuscated_res_0x7f0f13ab));
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = new BigdaySwipeRefreshLayout(context);
            this.a = bigdaySwipeRefreshLayout;
            bigdaySwipeRefreshLayout.addView(this.b);
            PbListView pbListView = new PbListView(context);
            this.f = pbListView;
            pbListView.b();
            this.f.q(R.color.transparent);
            this.f.z();
            this.f.G(SkinManager.getColor(R.color.CAM_X0107));
            this.f.I(R.dimen.tbfontsize33);
            this.f.C(R.color.CAM_X0110);
            this.f.u(yi.g(context, R.dimen.tbds182));
            this.f.D(this.z0);
            this.f.t();
            this.b.setNextPage(this.f);
            addView(this.a);
            if (TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
                this.E = new FRSRefreshButton(context);
                int g2 = yi.g(context, R.dimen.tbds170);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g2, g2);
                layoutParams.gravity = 85;
                layoutParams.rightMargin = yi.g(context, R.dimen.tbds24);
                layoutParams.bottomMargin = yi.g(context, R.dimen.tbds180);
                addView(this.E, layoutParams);
                this.E.setOnClickListener(this.C0);
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
        this.K = false;
        this.L = false;
        this.M = false;
        this.O = -1;
        this.P = -1;
        this.R = false;
        this.T = false;
        this.U = new k(this);
        this.V = new v(this, 2921456);
        this.W = new d0(this, 2921553);
        this.a0 = new e0(this, CmdConfigHttp.CMD_CHECK_INTEREST_COMMIT);
        this.b0 = new f0(this);
        this.c0 = new g0(this);
        this.e0 = -1;
        this.f0 = new h0(this);
        this.g0 = new i0(this);
        this.h0 = new j0(this);
        this.i0 = new a(this);
        this.j0 = new b(this, 2001371);
        this.q0 = new c(this, 2921736);
        this.r0 = new d(this);
        this.s0 = new e(this, 2921551);
        this.t0 = new h(this);
        this.u0 = new i(this);
        this.v0 = new j(this);
        this.w0 = new l(this);
        this.x0 = new s(this);
        this.y0 = new t(this, 2001118);
        this.z0 = new u(this);
        this.A0 = new w(this, 2921033);
        this.B0 = new x(this, 2921349);
        this.C0 = new z(this);
        this.D0 = new a0(this, 2921632);
        this.E0 = new b0(this, 2921664);
        this.F0 = new c0(this, 2921667);
        l0(context);
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
        this.K = false;
        this.L = false;
        this.M = false;
        this.O = -1;
        this.P = -1;
        this.R = false;
        this.T = false;
        this.U = new k(this);
        this.V = new v(this, 2921456);
        this.W = new d0(this, 2921553);
        this.a0 = new e0(this, CmdConfigHttp.CMD_CHECK_INTEREST_COMMIT);
        this.b0 = new f0(this);
        this.c0 = new g0(this);
        this.e0 = -1;
        this.f0 = new h0(this);
        this.g0 = new i0(this);
        this.h0 = new j0(this);
        this.i0 = new a(this);
        this.j0 = new b(this, 2001371);
        this.q0 = new c(this, 2921736);
        this.r0 = new d(this);
        this.s0 = new e(this, 2921551);
        this.t0 = new h(this);
        this.u0 = new i(this);
        this.v0 = new j(this);
        this.w0 = new l(this);
        this.x0 = new s(this);
        this.y0 = new t(this, 2001118);
        this.z0 = new u(this);
        this.A0 = new w(this, 2921033);
        this.B0 = new x(this, 2921349);
        this.C0 = new z(this);
        this.D0 = new a0(this, 2921632);
        this.E0 = new b0(this, 2921664);
        this.F0 = new c0(this, 2921667);
        l0(context);
    }

    public static /* synthetic */ int L(PersonalizePageView personalizePageView) {
        int i2 = personalizePageView.z + 1;
        personalizePageView.z = i2;
        return i2;
    }

    public void H0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z2) == null) {
            d37 d37Var = this.j;
            if (d37Var != null) {
                d37Var.update(z2);
            }
            if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
                mr4.i().j();
                mr4.i().k();
            }
        }
    }

    public void a0(Long l2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, l2) == null) {
            this.j.g0(l2);
        }
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
                w0();
            }
        }
    }

    public boolean n0(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, recyclerView)) == null) {
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

    public void setCallback(j07 j07Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, j07Var) == null) {
            this.i = j07Var;
        }
    }

    public void setIsUnreadTipShow(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z2) == null) {
            d37 d37Var = this.j;
            if (d37Var != null) {
                d37Var.V0(!z2);
            }
            this.y = z2;
        }
    }

    public void setScrollFragmentTabHost(k07 k07Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, k07Var) == null) {
            this.d0 = k07Var;
            if (k07Var != null) {
                k07Var.e(this.g0);
                this.d0.b(this.g0);
            }
            d37 d37Var = this.j;
            if (d37Var != null) {
                d37Var.Z0(k07Var);
            }
            z27 z27Var = this.k;
            if (z27Var != null) {
                z27Var.j(k07Var);
            }
        }
    }

    public void setTabInForeBackgroundState(boolean z2) {
        d37 d37Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048614, this, z2) == null) && (d37Var = this.j) != null) {
            d37Var.a1(z2);
        }
    }

    public void setViewForeground(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z2) == null) {
            d37 d37Var = this.j;
            if (d37Var != null) {
                d37Var.K0(z2);
            }
            k07 k07Var = this.d0;
            if (k07Var != null) {
                k07Var.e(this.g0);
                this.d0.b(this.g0);
                this.g0.b();
            }
        }
    }

    public boolean y0(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, recyclerView)) == null) {
            if (recyclerView == null || !recyclerView.canScrollVertically(-1)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.j.U0();
        }
    }

    public void B0() {
        d37 d37Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (d37Var = this.j) != null) {
            d37Var.b1();
        }
    }

    public void G0() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (rightFloatLayerView = this.F) != null) {
            rightFloatLayerView.d();
        }
    }

    public void Z() {
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (bigdaySwipeRefreshLayout = this.a) != null) {
            bigdaySwipeRefreshLayout.r();
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.o != null) {
                z0();
                return;
            }
            d37 d37Var = this.j;
            if (d37Var != null) {
                d37Var.update();
            }
        }
    }

    public final void d0() {
        ja5 ja5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (ja5Var = this.o) != null) {
            ja5Var.dettachView(this);
            this.o = null;
        }
    }

    public void e0() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (rightFloatLayerView = this.F) != null) {
            rightFloatLayerView.c();
        }
    }

    public final void f0() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (rightFloatLayerView = this.F) != null) {
            rightFloatLayerView.setAutoCompleteShown(false);
            this.F.clearAnimation();
            this.F.setVisibility(8);
        }
    }

    public boolean getIsUnreadTipShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.y;
        }
        return invokeV.booleanValue;
    }

    public FrameLayout getmTaskFloatingView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.J;
        }
        return (FrameLayout) invokeV.objValue;
    }

    public void j0() {
        k0 k0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (k0Var = this.e) != null) {
            k0Var.f(this.t0);
            this.e.g(this.u0);
            this.e.k(this.v0);
            this.e.m(this.w0);
        }
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.L = true;
            o15 homeAdFloatViewItemData = TbSingleton.getInstance().getHomeAdFloatViewItemData();
            if (homeAdFloatViewItemData != null && !homeAdFloatViewItemData.a()) {
                K0(homeAdFloatViewItemData);
            }
        }
    }

    public final boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            ja5 ja5Var = this.o;
            if (ja5Var != null) {
                return ja5Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void p0() {
        g07 g07Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && (g07Var = this.H) != null) {
            g07Var.f();
        }
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.j.x0();
        }
    }

    public void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            k47 k47Var = this.g;
            if (k47Var != null) {
                k47Var.l();
            }
            p0();
        }
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.j.J0();
            k47 k47Var = this.g;
            if (k47Var != null) {
                k47Var.o();
            }
            RightFloatLayerView rightFloatLayerView = this.F;
            if (rightFloatLayerView != null && (rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                ((RightFloatLayerLottieView) rightFloatLayerView).H(600);
            }
        }
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            if (this.r) {
                z0();
                this.r = false;
            }
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.a;
            if (bigdaySwipeRefreshLayout != null) {
                bigdaySwipeRefreshLayout.D();
            }
            k47 k47Var = this.g;
            if (k47Var != null) {
                k47Var.p();
            }
            if (!RightFloatLayerView.k()) {
                f0();
            }
        }
    }

    public final void C0() {
        a46 a46Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.b != null && (a46Var = this.w) != null && a46Var.b().getParent() == null && !StringUtils.isNull(TbSingleton.getInstance().getLFUser()) && !TbSingleton.getInstance().isAddBanner && !this.R) {
            this.w.d();
            this.w.b().setVisibility(0);
            this.w.f("1");
            this.b.setHeaderView(this.w.b());
        }
    }

    public final void D0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.b != null) {
            if (this.x == null) {
                z36 z36Var = new z36(getContext());
                this.x = z36Var;
                z36Var.a().setOnClickListener(this.i0);
            }
            this.b.setHeaderView(this.x.b());
            this.R = true;
            i57.b();
            a46 a46Var = this.w;
            if (a46Var != null) {
                this.b.removeHeaderView(a46Var.b());
            }
        }
    }

    public final void E0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z2) == null) {
            if (this.n == null) {
                this.n = new ia5(getContext());
                this.n.p(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + yi.g(getContext(), R.dimen.tbds60));
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
            this.H.q(false);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921457, this.h.getUniqueId()));
        }
    }

    public final boolean K0(o15 o15Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, o15Var)) == null) {
            if (!RightFloatLayerView.k()) {
                e0();
                return false;
            } else if (o15Var == null) {
                return false;
            } else {
                if (this.F == null) {
                    this.F = RightFloatLayerLottieView.F(o15Var, this.N);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 85;
                    layoutParams.bottomMargin = yi.g(this.N, R.dimen.tbds306) + this.G;
                    this.F.c();
                    addView(this.F, layoutParams);
                }
                this.F.setAutoCompleteShown(true);
                if (o15Var.a()) {
                    return false;
                }
                this.F.setData(o15Var);
                this.F.setLogoListener(new f(this, o15Var));
                this.F.setFeedBackListener(new g(this, o15Var));
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public void s0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            if (this.q != i2) {
                ia5 ia5Var = this.n;
                if (ia5Var != null) {
                    ia5Var.onChangeSkinType();
                }
                ja5 ja5Var = this.o;
                if (ja5Var != null) {
                    ja5Var.onChangeSkinType();
                }
                l47 l47Var = this.d;
                if (l47Var != null) {
                    l47Var.H(i2);
                }
                PbListView pbListView = this.f;
                if (pbListView != null) {
                    pbListView.G(SkinManager.getColor(R.color.CAM_X0109));
                    this.f.d(i2);
                }
                this.g.m(i2);
                d37 d37Var = this.j;
                if (d37Var != null) {
                    d37Var.F0(i2);
                }
                FRSRefreshButton fRSRefreshButton = this.E;
                if (fRSRefreshButton != null) {
                    fRSRefreshButton.d(i2);
                }
                a46 a46Var = this.w;
                if (a46Var != null) {
                    a46Var.e(i2);
                }
                RightFloatLayerView rightFloatLayerView = this.F;
                if (rightFloatLayerView != null) {
                    rightFloatLayerView.o();
                }
                z36 z36Var = this.x;
                if (z36Var != null) {
                    z36Var.d(i2);
                }
                g07 g07Var = this.H;
                if (g07Var != null) {
                    g07Var.n();
                }
            }
            this.q = i2;
        }
    }

    public final void F0(View view2, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048581, this, view2, str, z2) == null) {
            if (this.o == null) {
                this.o = new ja5(getContext(), new r(this));
            }
            this.o.attachView(view2, z2);
            this.o.p();
        }
    }

    public void I0(DataRes dataRes, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{dataRes, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            eh.b(new q(this));
            this.j.H0(z2, z3, dataRes, 0, null);
        }
    }

    public void J0(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, str, i2) == null) {
            PbListView pbListView = this.f;
            if (pbListView != null) {
                pbListView.E(getContext().getString(R.string.obfuscated_res_0x7f0f0e21));
                this.f.f();
                this.f.N(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            this.j.H0(true, false, null, i2, str);
        }
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            ia5 ia5Var = this.n;
            if (ia5Var != null) {
                ia5Var.dettachView(this);
                this.n = null;
                this.b.setNextPage(this.f);
                this.f.E(getContext().getString(R.string.obfuscated_res_0x7f0f0e21));
                this.f.f();
                this.f.N(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, Boolean.TRUE));
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.a;
            if (bigdaySwipeRefreshLayout != null) {
                bigdaySwipeRefreshLayout.setVisibility(0);
            }
            this.H.q(true);
            j07 j07Var = this.i;
            if (j07Var != null) {
                j07Var.b();
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

    public final void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            if (!this.u) {
                long f2 = i07.d().f(1) + i07.d().b();
                long a2 = i07.d().a(1);
                if (a2 > 0) {
                    f2 = System.currentTimeMillis() - a2;
                }
                df5 df5Var = new df5();
                df5Var.a();
                df5Var.b();
                bf5.b().o(f2);
                if (this.t > 0) {
                    bf5.b().E(System.currentTimeMillis() - this.t);
                }
                bf5.b().I(df5Var.c());
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

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.g.t(this.b0);
            this.g.r(this.c0);
            this.j.X0(this.r0);
            this.k.i(this);
            j0();
            this.b.addOnScrollListener(new m(this));
            this.b.setOnSrollToBottomListener(new n(this));
            this.b.setOnScrollStopDelayedListener(new o(this), 1L);
            this.b.setRecyclerListener(new p(this));
            this.b.removeOnScrollListener(this.f0);
            this.b.addOnScrollListener(this.f0);
        }
    }

    public void z0() {
        d37 d37Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            d37 d37Var2 = this.j;
            if (d37Var2 != null && d37Var2.p0() != null) {
                this.j.p0().e();
            }
            if (this.o != null && (d37Var = this.j) != null) {
                d37Var.update();
                return;
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.b;
            if (bdTypeRecyclerView != null && this.a != null) {
                bdTypeRecyclerView.setSelection(0);
                if (!this.a.t()) {
                    d37 d37Var3 = this.j;
                    if (d37Var3 != null && d37Var3.o0() != null) {
                        this.j.o0().y();
                        this.j.Y0(false);
                    }
                    this.a.setRefreshing(true);
                }
                ScrollFragmentTabHost.v vVar = this.g0;
                if (vVar != null) {
                    vVar.b();
                }
            }
        }
    }

    public final void i0(Object obj) {
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, obj) == null) && (bigdaySwipeRefreshLayout = this.a) != null && !bigdaySwipeRefreshLayout.t()) {
            if (obj != null && (obj instanceof lr4)) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                l47 l47Var = this.d;
                if (l47Var == null) {
                    l47 l47Var2 = new l47(this.h);
                    this.d = l47Var2;
                    l47Var2.H(this.q);
                    this.e = this.d;
                    j0();
                } else if (this.e == l47Var) {
                    return;
                } else {
                    this.e = l47Var;
                }
                this.d.A(true);
                this.a.setProgressView(this.d);
                int i2 = (int) (getResources().getDisplayMetrics().density * 86.0f);
                this.a.setCustomDistances(i2, i2, i2 * 2);
                return;
            }
            lr4 lr4Var = (lr4) obj;
            m47 m47Var = this.c;
            if (m47Var == null) {
                m47 m47Var2 = new m47(this.h.getContext());
                this.c = m47Var2;
                this.e = m47Var2;
                j0();
            } else if (this.e == m47Var && lr4Var.equals(m47Var.F())) {
                return;
            } else {
                this.e = this.c;
            }
            this.c.A(true);
            this.a.setProgressView(this.c);
            eh.b(new y(this, lr4Var));
            this.a.setCustomDistances((int) getResources().getDimension(R.dimen.tbds236), (int) (yi.j(this.h.getContext()) * 0.8d), yi.j(this.h.getContext()));
        }
    }

    public final void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            i07.d().j(System.currentTimeMillis(), 1);
            PbListView pbListView = this.f;
            if (pbListView != null && !pbListView.n()) {
                this.f.S();
                this.f.N(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            this.j.A0();
        }
    }

    public void setViewForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            setViewForeground(false);
            d37 d37Var = this.j;
            if (d37Var != null) {
                d37Var.D0(false);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            if (this.z < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
                ah.a().postDelayed(this.x0, 1000L);
            }
        }
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            d37 d37Var = this.j;
            if (d37Var != null) {
                d37Var.D0(true);
            }
            e46.b().d(false);
            jq5.c().h("page_recommend", "show_");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            ah.a().removeCallbacks(this.x0);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, bdUniqueId) == null) {
            k47 k47Var = this.g;
            if (k47Var != null) {
                k47Var.v(bdUniqueId);
            }
            d37 d37Var = this.j;
            if (d37Var != null) {
                d37Var.Q0(bdUniqueId);
            }
            b57 b57Var = this.l;
            if (b57Var != null) {
                b57Var.a(bdUniqueId);
            }
            l47 l47Var = this.d;
            if (l47Var != null) {
                l47Var.b0(bdUniqueId);
            }
            mr4.i().n(bdUniqueId);
            CustomMessageListener customMessageListener = this.y0;
            if (customMessageListener != null) {
                customMessageListener.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.y0);
            }
            z27 z27Var = this.k;
            if (z27Var != null) {
                z27Var.h(bdUniqueId);
            }
        }
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.q0);
            MessageManager.getInstance().unRegisterListener(this.j0);
            MessageManager.getInstance().unRegisterListener(this.V);
            MessageManager.getInstance().unRegisterListener(this.A0);
            MessageManager.getInstance().unRegisterListener(this.B0);
            MessageManager.getInstance().unRegisterListener(this.W);
            MessageManager.getInstance().unRegisterListener(this.a0);
            MessageManager.getInstance().unRegisterListener(this.D0);
            MessageManager.getInstance().unRegisterListener(this.E0);
            MessageManager.getInstance().unRegisterListener(this.F0);
            MessageManager.getInstance().unRegisterListener(this.s0);
            this.j.G0();
            this.g.t(null);
            this.g.n();
            this.I = false;
            this.j.X0(null);
            m47 m47Var = this.c;
            if (m47Var != null) {
                m47Var.f(null);
                this.c.g(null);
                this.c.k(null);
                this.c.m(null);
                this.c.G();
            }
            l47 l47Var = this.d;
            if (l47Var != null) {
                l47Var.f(null);
                this.d.g(null);
                this.d.k(null);
                this.d.m(null);
                this.d.Z();
            }
            this.b.setOnSrollToBottomListener(null);
            k07 k07Var = this.d0;
            if (k07Var != null) {
                k07Var.e(this.g0);
            }
            this.b.removeOnScrollListener(this.f0);
            ia5 ia5Var = this.n;
            if (ia5Var != null) {
                ia5Var.n();
            }
            this.b.setRecyclerListener(null);
            z27 z27Var = this.k;
            if (z27Var != null) {
                z27Var.g();
            }
            mr4.i().e();
            ah.a().removeCallbacks(this.x0);
            w47 w47Var = this.Q;
            if (w47Var != null) {
                w47Var.a();
            }
        }
    }
}
