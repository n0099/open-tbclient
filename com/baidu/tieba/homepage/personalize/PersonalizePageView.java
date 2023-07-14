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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdNetTypeUtil;
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
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.leveiconlivepolling.PollingModel;
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
import com.baidu.tbadk.switchs.BigdaySwitch;
import com.baidu.tbadk.switchs.LaunchViewOptSwitch;
import com.baidu.tbadk.widget.RightFloatLayerLottieView;
import com.baidu.tbadk.widget.RightFloatLayerView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.a28;
import com.baidu.tieba.a67;
import com.baidu.tieba.a68;
import com.baidu.tieba.af5;
import com.baidu.tieba.ah5;
import com.baidu.tieba.b28;
import com.baidu.tieba.b67;
import com.baidu.tieba.b68;
import com.baidu.tieba.bc;
import com.baidu.tieba.bx9;
import com.baidu.tieba.c1a;
import com.baidu.tieba.cc7;
import com.baidu.tieba.cf5;
import com.baidu.tieba.co5;
import com.baidu.tieba.d1a;
import com.baidu.tieba.da5;
import com.baidu.tieba.df5;
import com.baidu.tieba.dh;
import com.baidu.tieba.do5;
import com.baidu.tieba.e5a;
import com.baidu.tieba.e87;
import com.baidu.tieba.ef5;
import com.baidu.tieba.ev6;
import com.baidu.tieba.feed.list.FeedTemplateAdapter;
import com.baidu.tieba.ff5;
import com.baidu.tieba.g68;
import com.baidu.tieba.gu5;
import com.baidu.tieba.h29;
import com.baidu.tieba.h9;
import com.baidu.tieba.hd5;
import com.baidu.tieba.homepage.concern.data.RecommendBarCardModel;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.adapter.HomePageCardVideoViewHolder;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.i68;
import com.baidu.tieba.iu5;
import com.baidu.tieba.ix5;
import com.baidu.tieba.j78;
import com.baidu.tieba.jc7;
import com.baidu.tieba.jp6;
import com.baidu.tieba.k68;
import com.baidu.tieba.kq6;
import com.baidu.tieba.ku6;
import com.baidu.tieba.l65;
import com.baidu.tieba.l9;
import com.baidu.tieba.lu6;
import com.baidu.tieba.m15;
import com.baidu.tieba.mc7;
import com.baidu.tieba.n15;
import com.baidu.tieba.n97;
import com.baidu.tieba.nc7;
import com.baidu.tieba.np6;
import com.baidu.tieba.o1a;
import com.baidu.tieba.o48;
import com.baidu.tieba.oia;
import com.baidu.tieba.ou6;
import com.baidu.tieba.oz;
import com.baidu.tieba.p1a;
import com.baidu.tieba.play.AutoPlayController;
import com.baidu.tieba.pu4;
import com.baidu.tieba.q1a;
import com.baidu.tieba.q68;
import com.baidu.tieba.qo5;
import com.baidu.tieba.r1a;
import com.baidu.tieba.r66;
import com.baidu.tieba.r87;
import com.baidu.tieba.r9;
import com.baidu.tieba.ria;
import com.baidu.tieba.rl5;
import com.baidu.tieba.s35;
import com.baidu.tieba.s68;
import com.baidu.tieba.sa5;
import com.baidu.tieba.t48;
import com.baidu.tieba.tl5;
import com.baidu.tieba.u87;
import com.baidu.tieba.v87;
import com.baidu.tieba.vc7;
import com.baidu.tieba.vy9;
import com.baidu.tieba.w0a;
import com.baidu.tieba.wd7;
import com.baidu.tieba.we7;
import com.baidu.tieba.wg;
import com.baidu.tieba.wz5;
import com.baidu.tieba.x0a;
import com.baidu.tieba.x18;
import com.baidu.tieba.xi;
import com.baidu.tieba.xz5;
import com.baidu.tieba.yaa;
import com.baidu.tieba.yea;
import com.baidu.tieba.yi;
import com.baidu.tieba.yn;
import com.baidu.tieba.yp6;
import com.baidu.tieba.yz5;
import com.baidu.tieba.z18;
import com.baidu.tieba.z57;
import com.baidu.tieba.z58;
import com.baidu.tieba.z77;
import com.baidu.tieba.ze5;
import com.baidu.tieba.zg;
import com.baidu.tieba.zg5;
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
public class PersonalizePageView extends FrameLayout implements wz5 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean K0;
    public static final int L0;
    public transient /* synthetic */ FieldHolder $fh;
    public jp6 A;
    public sa5.f A0;
    public int B;
    public Runnable B0;
    public int C;
    public AutoPlayController.a C0;
    public boolean D;
    public final CustomMessageListener D0;
    public LinearLayoutManager E;
    public View.OnClickListener E0;
    public RightFloatLayerView F;
    public CustomMessageListener F0;
    public int G;
    public CustomMessageListener G0;
    public x18 H;
    public CustomMessageListener H0;
    public volatile boolean I;
    public CustomMessageListener I0;
    public FrameLayout J;
    public CustomMessageListener J0;
    public boolean K;
    public boolean L;
    public boolean M;
    public Object N;
    public String O;
    public String P;
    public boolean Q;
    public boolean R;
    public zg5 S;

    /* renamed from: T  reason: collision with root package name */
    public PollingModel f1110T;
    public BdUniqueId U;
    public z58.f V;
    public CustomMessageListener W;
    public BigdaySwipeRefreshLayout a;
    public CustomMessageListener a0;
    public BdTypeRecyclerView b;
    public CustomMessageListener b0;
    public b68 c;
    public CustomMessageListener c0;
    public a68 d;
    public NEGFeedBackView.b d0;
    public y0 e;
    public FollowUserButton.a e0;
    public PbListView f;
    public b28 f0;
    public cc7 g;
    public int g0;
    public c1a h;
    public RecyclerView.OnScrollListener h0;
    public AutoPlayController i;
    public ScrollFragmentTabHost.r i0;
    public d1a j;
    public View.OnClickListener j0;
    public z58 k;
    public TbPageContext<?> l;
    public a28 m;
    public t48 n;
    public o48 o;
    public s68 p;
    public long q;
    public co5 r;
    public CustomMessageListener r0;
    public do5 s;
    public CustomMessageListener s0;
    public long t;
    public CustomMessageListener t0;
    public int u;
    public t48.n0 u0;
    public boolean v;
    public CustomMessageListener v0;
    public boolean w;
    public final vc7.a w0;
    public long x;
    public sa5.g x0;
    public boolean y;
    public sa5.h y0;
    public boolean z;
    public sa5.e z0;

    /* loaded from: classes6.dex */
    public interface y0 {
        void f(sa5.g gVar);

        void g(sa5.h hVar);

        void k(sa5.e eVar);

        void m(sa5.f fVar);
    }

    public final void d1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class k0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ k0 a;

            public a(k0 k0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {k0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = k0Var;
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
        public k0(PersonalizePageView personalizePageView, int i) {
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
                    zg.a().postDelayed(new a(this), TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements t48.n0 {
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
                bc.b().f();
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
            this.a = da5.p().l("key_first_install", true);
        }

        @Override // com.baidu.tieba.t48.n0
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                dh.g(new b(this, z));
            }
        }

        @Override // com.baidu.tieba.t48.n0
        public void b(int i, ix5 ix5Var, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), ix5Var, Integer.valueOf(i2)}) == null) {
                if (this.b.m == null) {
                    PersonalizePageView personalizePageView = this.b;
                    personalizePageView.j1(personalizePageView, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e1f), true);
                    this.b.A0();
                    return;
                }
                boolean M0 = this.b.M0();
                this.b.B0();
                if (M0) {
                    this.b.i1(true);
                }
                this.b.m.c(i, ix5Var, i2);
                pu4.f().m();
            }
        }

        @Override // com.baidu.tieba.t48.n0
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                dh.g(new c(this));
            }
        }

        public final void g() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.a) {
                this.a = false;
                da5.p().A("key_first_install", false);
            }
        }

        @Override // com.baidu.tieba.t48.n0
        public void d(int i, int i2, ix5 ix5Var, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), ix5Var, Integer.valueOf(i3)}) == null) && this.b.m != null) {
                PersonalizePageView personalizePageView = this.b;
                if (personalizePageView.N0(personalizePageView.b)) {
                    this.b.q = System.currentTimeMillis();
                }
                this.b.m.d(i, i2, ix5Var, i3);
            }
        }

        @Override // com.baidu.tieba.t48.n0
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) {
                dh.g(new a(this, i, str));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a extends ou6<df5> {
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
        @Override // com.baidu.tieba.ou6
        public void onEvent(@NonNull df5 df5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, df5Var) == null) {
                if ("recommend_post".equals(df5Var.getType()) && (df5Var.a() instanceof JSONObject)) {
                    String optString = ((JSONObject) df5Var.a()).optString("tid");
                    if (StringUtils.isNull(optString)) {
                        return;
                    }
                    this.b.h.t(optString);
                    this.b.h.O((JSONObject) df5Var.a());
                } else if ("recommend_fun_ad".equals(df5Var.getType()) && this.b.b != null && this.b.b.getListAdapter() != null) {
                    this.b.b.getListAdapter().notifyDataSetChanged();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a0 extends RecyclerView.OnScrollListener {
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

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                if (this.a.E != null && i == 0) {
                    ze5 wlConfigData = TbSingleton.getInstance().getWlConfigData();
                    int i3 = 3;
                    if (wlConfigData != null && wlConfigData.H() != 0) {
                        i3 = wlConfigData.H();
                    }
                    int itemCount = this.a.E.getItemCount() - this.a.E.findLastVisibleItemPosition();
                    if (PersonalizePageView.K0) {
                        i2 = 1;
                    } else {
                        i2 = 5;
                    }
                    if (itemCount <= i3 * i2) {
                        this.a.O0();
                    }
                }
                if (this.a.Q && i == 0 && da5.p().l(da5.t(we7.a(this.a.P, this.a.O)), true)) {
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
                if (UbsABTestHelper.isHomePagePromoteLoginUbsABTestA() && !TbadkCoreApplication.isLogin() && da5.p().q("home_page_login_dialog_show_key", 0) == 0 && this.a.C >= yi.t(TbadkCoreApplication.getInst().getContext())[1] * 2) {
                    da5.p().F("home_page_login_dialog_show_key", 1);
                    DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getContext(), LoginDialogData.HOME_PAGE_RESULT_PAGE));
                }
                if (this.a.H != null) {
                    this.a.H.j();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends ou6<ff5> {
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
        @Override // com.baidu.tieba.ou6
        public void onEvent(@NonNull ff5 ff5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ff5Var) == null) {
                String a = ff5Var.a();
                if (!TextUtils.isEmpty(a) && this.b.h != null) {
                    this.b.h.t(a);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b0 implements BdListView.p {
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
    public class c extends ou6<ef5> {
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
        @Override // com.baidu.tieba.ou6
        public void onEvent(@NonNull ef5 ef5Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, ef5Var) == null) && (ef5Var.a() instanceof u87) && ((u87) ef5Var.a()).getType().equals("recommend_post")) {
                Object a = ((u87) ef5Var.a()).a();
                if (!(a instanceof v87)) {
                    return;
                }
                this.b.y0((v87) a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c0 implements BdListView.o {
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

        @Override // com.baidu.adp.widget.ListView.BdListView.o
        public void onScrollStop(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && System.currentTimeMillis() - this.a.t >= 5000 && this.a.n != null) {
                this.a.n.L0(i, i2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends ou6<cf5> {
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
        @Override // com.baidu.tieba.ou6
        public void onEvent(@NonNull cf5 cf5Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, cf5Var) == null) && (cf5Var.a() instanceof u87) && ((u87) cf5Var.a()).getType().equals("recommend_post")) {
                Object a = ((u87) cf5Var.a()).a();
                if (!(a instanceof v87)) {
                    return;
                }
                this.b.x0(cf5Var.b(), cf5Var.c(), (v87) a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d0 implements RecyclerView.RecyclerListener {
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

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, viewHolder) != null) || viewHolder == null || (view2 = viewHolder.itemView) == null) {
                return;
            }
            if (this.a.n != null && this.a.n.g0() != null) {
                this.a.n.g0().k(view2);
            }
            if (view2.getTag() instanceof HomePageCardVideoViewHolder) {
                ((HomePageCardVideoViewHolder) view2.getTag()).b().stopPlay();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends ou6<w0a> {
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
        @Override // com.baidu.tieba.ou6
        public void onEvent(@NonNull w0a w0aVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, w0aVar) != null) || this.b.p == null) {
                return;
            }
            this.b.p.e(w0aVar.d(), w0aVar.e(), w0aVar.c(), w0aVar.b(), w0aVar.a(), w0aVar.getType(), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, null);
        }
    }

    /* loaded from: classes6.dex */
    public class e0 implements Runnable {
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
    public class f extends ou6<x0a> {
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
        @Override // com.baidu.tieba.ou6
        public void onEvent(@NonNull x0a x0aVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x0aVar) != null) || this.b.o == null) {
                return;
            }
            this.b.o.e(x0aVar.b(), wg.g(x0aVar.a(), 0L), x0aVar.c());
        }
    }

    /* loaded from: classes6.dex */
    public class f0 implements Runnable {
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
    public class g extends ou6<af5> {
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
        @Override // com.baidu.tieba.ou6
        public void onEvent(@NonNull af5 af5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, af5Var) == null) {
                UpdateAttentionMessage.b a = af5Var.a();
                if (a.i != null || !a.a || TextUtils.isEmpty(a.c)) {
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
            if (data instanceof yea) {
                yea yeaVar = (yea) data;
                if (yeaVar.b) {
                    yeaVar.d = false;
                    if (this.a.h != null) {
                        this.a.h.S(data);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h extends ou6<rl5> {
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
        @Override // com.baidu.tieba.ou6
        public void onEvent(@NonNull rl5 rl5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rl5Var) == null) {
                if (this.b.n != null) {
                    this.b.n.m0(rl5Var);
                }
                if (this.b.h != null) {
                    this.b.h.B(rl5Var);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h0 implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (PersonalizePageView.K0) {
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.l != null) {
                da5.p().F("show_is_uninterest_tag", PersonalizePageView.c0(this.a));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(this.a.l.getContext(), 2)));
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
    public class j0 implements AutoPlayController.a {
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

        @Override // com.baidu.tieba.play.AutoPlayController.a
        public void onBackground(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.i.h() != null && (this.a.i.h().getTag() instanceof b67.q)) {
                ((b67.q) this.a.i.h().getTag()).onBackground(z);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements z58.f {
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

        @Override // com.baidu.tieba.z58.f
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
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.O0();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && j78.a()) {
                PersonalizePageView personalizePageView = this.a;
                personalizePageView.S = ah5.i(personalizePageView.l, DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, 0L);
                if (this.a.S != null) {
                    bx9.e().h(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

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
    public class n0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

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
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.G0(customResponsedMessage.getData());
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue() && qo5.f().b() && this.a.f != null && this.a.f.l() == 0) {
                this.a.f.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m15 a;
        public final /* synthetic */ PersonalizePageView b;

        public o0(PersonalizePageView personalizePageView, m15 m15Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, m15Var};
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
            this.a = m15Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.c.I(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p implements q68.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        @Override // com.baidu.tieba.q68.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
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
            this.a = personalizePageView;
        }

        @Override // com.baidu.tieba.q68.c
        public void a(i68 i68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, i68Var) != null) {
                return;
            }
            this.a.z0(i68Var);
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
            this.a.D0();
        }
    }

    /* loaded from: classes6.dex */
    public class q implements PollingModel.d {
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

        @Override // com.baidu.tbadk.core.leveiconlivepolling.PollingModel.d
        public void onSuccess(List<AlaLiveInfo> list) {
            List<mc7<?>> b;
            boolean z;
            List<AlaLiveInfo> liveIndexSecondFloor;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                if (this.a.n != null) {
                    this.a.n.l0();
                }
                if (this.a.h != null && (b = this.a.h.b()) != null && b.size() > 0) {
                    Iterator<mc7<?>> it = b.iterator();
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
                        yp6 yp6Var = new yp6(null, liveIndexSecondFloor, "recommend");
                        n97 n97Var = new n97();
                        n97Var.a = yp6Var;
                        this.a.h.F(new nc7(new a67(n97Var), "ala_live_attention"), 0);
                    }
                }
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
    public class r implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                qo5.f().j();
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
            if (data instanceof yea) {
                yea yeaVar = (yea) data;
                if (yeaVar.b) {
                    yeaVar.d = true;
                    if (this.a.h != null) {
                        this.a.h.S(data);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s implements vc7.a {
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

        @Override // com.baidu.tieba.vc7.a
        public void a(r87 r87Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, r87Var) != null) {
                return;
            }
            this.a.w = true;
            this.a.A0();
            if (r87Var.d == 0) {
                if (ListUtils.isEmpty(r87Var.a)) {
                    this.a.a.setRefreshing(false);
                    PersonalizePageView personalizePageView = this.a;
                    personalizePageView.j1(personalizePageView, r87Var.e, true);
                    this.a.H.r(false);
                    this.a.a.setVisibility(8);
                    this.a.f.O(8);
                } else {
                    this.a.s0(r87Var.b);
                    this.a.B0();
                    this.a.f.O(0);
                    if (r87Var.c) {
                        this.a.g1();
                    } else {
                        this.a.h1();
                    }
                }
                this.a.g.setList(r87Var.a);
                this.a.i.r();
                return;
            }
            this.a.a.setRefreshing(false);
            if (ListUtils.isEmpty(r87Var.a)) {
                PersonalizePageView personalizePageView2 = this.a;
                personalizePageView2.j1(personalizePageView2, r87Var.e, true);
                this.a.H.r(false);
                this.a.a.setVisibility(8);
                this.a.f.O(8);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && this.a.i.h() != null && (this.a.i.h().getTag() instanceof b67.q)) {
                    ((b67.q) this.a.i.h().getTag()).onVolumeUp();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hd5 a;
        public final /* synthetic */ PersonalizePageView b;

        public t(PersonalizePageView personalizePageView, hd5 hd5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, hd5Var};
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
            this.a = hd5Var;
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
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (this.a.n != null) {
                    this.a.n.j0(customResponsedMessage);
                }
                if (this.a.h != null) {
                    this.a.h.A(customResponsedMessage);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hd5 a;
        public final /* synthetic */ PersonalizePageView b;

        public u(PersonalizePageView personalizePageView, hd5 hd5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, hd5Var};
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
            this.a = hd5Var;
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
    public class u0 implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(s35 s35Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s35Var, compoundButton, z) == null) {
            }
        }

        public u0(PersonalizePageView personalizePageView) {
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
        public void a(ArrayList<Integer> arrayList, String str, s35 s35Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, s35Var) == null) && arrayList != null && s35Var != null) {
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
                int i3 = s35Var.n;
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
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.NEG_FEEDBACK_KEY).param("tid", s35Var.f()).param("nid", s35Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", s35Var.c()).param("obj_param1", s35Var.k).param("obj_source", s35Var.l).param("obj_id", s35Var.m).param("obj_type", sb.toString()).param("obj_name", str).param(TiebaStatic.Params.OBJ_PARAM2, i).param("obj_locate", "1"));
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(s35 s35Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, s35Var) != null) || s35Var == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.NEG_FEEDBACK_KEY).param("obj_locate", "1").param("fid", s35Var.c()).param("tid", s35Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("nid", s35Var.e()));
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.NEGATIVE_FEEDBACK_OPEN_CLICK).param("obj_locate", "1").param("fid", s35Var.c()).param("tid", s35Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    layoutParams.bottomMargin = PersonalizePageView.L0 + this.a.G;
                    this.a.F.requestLayout();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class v0 implements FollowUserButton.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public v0(PersonalizePageView personalizePageView) {
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
                TiebaStatic.log(yaa.j("c13696", (ThreadData) tag));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class w implements sa5.g {
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

        @Override // com.baidu.tieba.sa5.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048576, this, z) != null) {
                return;
            }
            this.a.D = true;
            r66.c().f("page_recommend");
            if (PersonalizePageView.K0) {
                this.a.h.I();
                if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    TiebaStatic.log(new StatisticItem("c11032").param("obj_source", 1));
                }
                this.a.i.p(false);
                this.a.Y0();
                return;
            }
            this.a.p0();
            this.a.n.V0(false);
        }
    }

    /* loaded from: classes6.dex */
    public class w0 extends RecyclerView.OnScrollListener {
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
    public class x implements sa5.h {
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

        @Override // com.baidu.tieba.sa5.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.n != null && this.a.n.g0() != null) {
                    this.a.n.g0().y();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921792));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class x0 extends ScrollFragmentTabHost.r {
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

        @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.r
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

    /* loaded from: classes6.dex */
    public class y implements sa5.e {
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

        @Override // com.baidu.tieba.sa5.e
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
    public class z implements sa5.f {
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

        @Override // com.baidu.tieba.sa5.f
        public void a(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (PersonalizePageView.K0) {
                    this.a.i.p(true);
                    this.a.i.r();
                } else if (this.a.n != null) {
                    this.a.n.V0(true);
                    this.a.n.M0();
                }
                TbSingleton.getInstance().mIsForceLayoutMaintab = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, Boolean.TRUE));
                m15 m15Var = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > da5.p().r("key_bigday_next_showtime_home", 0L)) {
                    m15Var = n15.i().h(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, m15Var));
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
        K0 = L0();
        L0 = UtilHelper.getDimenPixelSize(R.dimen.tbds437);
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
        do5 do5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (do5Var = this.s) != null) {
            do5Var.dettachView(this);
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
        y0 y0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (y0Var = this.e) != null) {
            y0Var.f(this.x0);
            this.e.g(this.y0);
            this.e.k(this.z0);
            this.e.m(this.A0);
        }
    }

    public final void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.L = true;
            hd5 homeAdFloatViewItemData = TbSingleton.getInstance().getHomeAdFloatViewItemData();
            if (homeAdFloatViewItemData != null && !homeAdFloatViewItemData.a()) {
                p1(homeAdFloatViewItemData);
            }
        }
    }

    public final boolean M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            do5 do5Var = this.s;
            if (do5Var != null) {
                return do5Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void P0() {
        x18 x18Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (x18Var = this.H) != null) {
            x18Var.f();
        }
    }

    public void Q0() {
        t48 t48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (t48Var = this.n) != null) {
            t48Var.u0();
        }
    }

    public void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            z58 z58Var = this.k;
            if (z58Var != null) {
                z58Var.n();
            }
            P0();
        }
    }

    public void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            t48 t48Var = this.n;
            if (t48Var != null) {
                t48Var.G0();
            }
            z58 z58Var = this.k;
            if (z58Var != null) {
                z58Var.q();
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
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (pollingModel = this.f1110T) != null) {
            pollingModel.D0("live,level,icon,festival_info,live_follow_second_floor,member_broadcast,activity_broadcast,live_index_second_floor");
        }
    }

    @Override // com.baidu.tieba.wz5
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
        t48 t48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && (t48Var = this.n) != null) {
            t48Var.R0();
        }
    }

    public void c1() {
        t48 t48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && (t48Var = this.n) != null) {
            t48Var.Y0();
        }
    }

    public final void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.f.U();
            this.f.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f.w(yi.g(getContext(), R.dimen.tbds150));
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
            this.f.w(yi.g(getContext(), R.dimen.tbds150));
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
        this.c0 = new t0(this, 2016331);
        this.d0 = new u0(this);
        this.e0 = new v0(this);
        this.g0 = -1;
        this.h0 = new w0(this);
        this.i0 = new x0(this);
        this.j0 = new i(this);
        this.r0 = new j(this, 2001371);
        this.s0 = new l(this, 2921736);
        this.t0 = new m(this, 2921482);
        this.u0 = new n(this);
        this.v0 = new o(this, 2921551);
        this.w0 = new s(this);
        this.x0 = new w(this);
        this.y0 = new x(this);
        this.z0 = new y(this);
        this.A0 = new z(this);
        this.B0 = new i0(this);
        this.C0 = new j0(this);
        this.D0 = new k0(this, 2001118);
        this.E0 = new l0(this);
        this.F0 = new m0(this, 2921033);
        this.G0 = new n0(this, 2921349);
        this.H0 = new p0(this, 2921664);
        this.I0 = new q0(this, 2921667);
        this.J0 = new s0(this, 2921381);
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
        this.c0 = new t0(this, 2016331);
        this.d0 = new u0(this);
        this.e0 = new v0(this);
        this.g0 = -1;
        this.h0 = new w0(this);
        this.i0 = new x0(this);
        this.j0 = new i(this);
        this.r0 = new j(this, 2001371);
        this.s0 = new l(this, 2921736);
        this.t0 = new m(this, 2921482);
        this.u0 = new n(this);
        this.v0 = new o(this, 2921551);
        this.w0 = new s(this);
        this.x0 = new w(this);
        this.y0 = new x(this);
        this.z0 = new y(this);
        this.A0 = new z(this);
        this.B0 = new i0(this);
        this.C0 = new j0(this);
        this.D0 = new k0(this, 2001118);
        this.E0 = new l0(this);
        this.F0 = new m0(this, 2921033);
        this.G0 = new n0(this, 2921349);
        this.H0 = new p0(this, 2921664);
        this.I0 = new q0(this, 2921667);
        this.J0 = new s0(this, 2921381);
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
        this.c0 = new t0(this, 2016331);
        this.d0 = new u0(this);
        this.e0 = new v0(this);
        this.g0 = -1;
        this.h0 = new w0(this);
        this.i0 = new x0(this);
        this.j0 = new i(this);
        this.r0 = new j(this, 2001371);
        this.s0 = new l(this, 2921736);
        this.t0 = new m(this, 2921482);
        this.u0 = new n(this);
        this.v0 = new o(this, 2921551);
        this.w0 = new s(this);
        this.x0 = new w(this);
        this.y0 = new x(this);
        this.z0 = new y(this);
        this.A0 = new z(this);
        this.B0 = new i0(this);
        this.C0 = new j0(this);
        this.D0 = new k0(this, 2001118);
        this.E0 = new l0(this);
        this.F0 = new m0(this, 2921033);
        this.G0 = new n0(this, 2921349);
        this.H0 = new p0(this, 2921664);
        this.I0 = new q0(this, 2921667);
        this.J0 = new s0(this, 2921381);
        J0(context);
    }

    public void o1(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048620, this, str, i2) == null) {
            dh.g(new f0(this));
            t48 t48Var = this.n;
            if (t48Var != null) {
                t48Var.E0(true, false, null, i2, str);
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
            t48 t48Var = this.n;
            if (t48Var != null) {
                t48Var.update(z2);
            }
            Y0();
        }
    }

    public void r0(Long l2) {
        t48 t48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048625, this, l2) == null) && (t48Var = this.n) != null) {
            t48Var.Y(l2);
        }
    }

    public void setCallback(a28 a28Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, a28Var) == null) {
            this.m = a28Var;
        }
    }

    public void setScrollFragmentTabHost(b28 b28Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, b28Var) == null) {
            this.f0 = b28Var;
            if (b28Var != null) {
                b28Var.e(this.i0);
                this.f0.b(this.i0);
            }
            t48 t48Var = this.n;
            if (t48Var != null) {
                t48Var.W0(b28Var);
            }
        }
    }

    public void setTabInForeBackgroundState(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z2) == null) {
            if (K0) {
                this.i.n(z2);
                return;
            }
            t48 t48Var = this.n;
            if (t48Var != null) {
                t48Var.X0(z2);
            }
        }
    }

    public void setViewForeground(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z2) == null) {
            t48 t48Var = this.n;
            if (t48Var != null) {
                t48Var.H0(z2);
            }
            b28 b28Var = this.f0;
            if (b28Var != null) {
                b28Var.e(this.i0);
                this.f0.b(this.i0);
                this.i0.b();
            }
        }
    }

    public final void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            co5 co5Var = this.r;
            if (co5Var != null) {
                co5Var.dettachView(this);
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
            a28 a28Var = this.m;
            if (a28Var != null) {
                a28Var.b();
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
                long f2 = z18.d().f(1) + z18.d().b();
                long a2 = z18.d().a(1);
                if (a2 > 0) {
                    f2 = System.currentTimeMillis() - a2;
                }
                iu5 iu5Var = new iu5();
                iu5Var.a();
                iu5Var.b();
                gu5.b().o(f2);
                if (this.x > 0) {
                    gu5.b().E(System.currentTimeMillis() - this.x);
                }
                gu5.b().I(iu5Var.c());
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
            if (tl5.b.a().a("show_reply_tip") || tl5.b.a().a("show_agree_tip")) {
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
                    if (!StringUtils.isNull(optString) && !StringUtils.isNull(this.O) && da5.p().l(da5.t(we7.a(this.P, this.O)), true)) {
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
                if (context2 instanceof ev6) {
                    ((ev6) context2).setBaseContext(context);
                }
                MessageManager.getInstance().registerListener(this.s0);
                MessageManager.getInstance().registerListener(this.r0);
                MessageManager.getInstance().registerListener(this.W);
                MessageManager.getInstance().registerListener(this.G0);
                MessageManager.getInstance().registerListener(this.F0);
                MessageManager.getInstance().registerListener(this.H0);
                MessageManager.getInstance().registerListener(this.I0);
                MessageManager.getInstance().registerListener(this.v0);
                MessageManager.getInstance().registerListener(this.a0);
                MessageManager.getInstance().registerListener(this.b0);
                MessageManager.getInstance().registerListener(this.c0);
                if (K0) {
                    MessageManager.getInstance().registerListener(this.J0);
                }
                l9<?> a2 = r9.a(context);
                if (a2 instanceof TbPageContext) {
                    this.l = (TbPageContext) a2;
                }
                this.H.p(this.l);
                m15 m15Var = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > da5.p().r("key_bigday_next_showtime_home", 0L)) {
                    m15Var = n15.i().h(1);
                }
                if (LaunchViewOptSwitch.getIsOn()) {
                    try {
                        G0(m15Var);
                    } catch (Exception unused) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, m15Var));
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, m15Var));
                }
                this.o = new o48(this.l);
                this.o.b().q(new p(this));
                this.p = new s68();
                if (K0) {
                    if (z57.a.getBaseContext() == null) {
                        z57.a.a(TbadkCoreApplication.getInst());
                    }
                    FeedTemplateAdapter feedTemplateAdapter = new FeedTemplateAdapter();
                    this.g = feedTemplateAdapter;
                    feedTemplateAdapter.j(new wd7());
                    this.g.j(new jc7());
                    cc7 cc7Var = this.g;
                    oia oiaVar = new oia(2);
                    oiaVar.c(this.l);
                    oiaVar.b("INDEX");
                    cc7Var.j(oiaVar);
                    this.g.j(new ria());
                    this.g.f(this.b);
                    c1a c1aVar = new c1a(this.l.getPageActivity());
                    this.h = c1aVar;
                    c1aVar.e(this.w0);
                    AutoPlayController autoPlayController = new AutoPlayController(a2, this.b);
                    this.i = autoPlayController;
                    autoPlayController.o(this.C0);
                    this.j = new d1a(this.h);
                    vy9.n();
                } else {
                    z58 z58Var = new z58(context, this.b);
                    this.k = z58Var;
                    z58Var.z(this.p);
                    this.k.x(this.V);
                    this.k.u(this.o);
                    t48 t48Var = new t48(this.l, this.b, this.k, this.a, this);
                    this.n = t48Var;
                    t48Var.S0(this.o);
                }
                PollingModel pollingModel = new PollingModel(this.l, this.U);
                this.f1110T = pollingModel;
                pollingModel.N0(l65.d);
                this.f1110T.R0(new q(this));
                S0(TbadkCoreApplication.getInst().getSkinType());
                this.B = da5.p().q("show_is_uninterest_tag", 0);
                if (!qo5.f().c()) {
                    zg.a().post(new r(this));
                }
            }
        }
    }

    public void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            z58 z58Var = this.k;
            if (z58Var != null) {
                z58Var.w(this.d0);
                this.k.t(this.e0);
            }
            t48 t48Var = this.n;
            if (t48Var != null) {
                t48Var.U0(this.u0);
            }
            H0();
            this.b.addOnScrollListener(new a0(this));
            this.b.setOnSrollToBottomListener(new b0(this));
            this.b.setOnScrollStopDelayedListener(new c0(this), 1L);
            this.b.setRecyclerListener(new d0(this));
            this.b.removeOnScrollListener(this.h0);
            this.b.addOnScrollListener(this.h0);
            xz5.b().a(this);
        }
    }

    public final void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            z18.d().j(System.currentTimeMillis(), 1);
            PbListView pbListView = this.f;
            if (pbListView != null && !pbListView.p()) {
                this.f.U();
                this.f.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            if (K0) {
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
            this.n.x0();
        }
    }

    public void a1() {
        c1a c1aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (K0) {
                if (this.s != null && (c1aVar = this.h) != null) {
                    c1aVar.I();
                    Y0();
                    return;
                }
            } else {
                t48 t48Var = this.n;
                if (t48Var != null && t48Var.h0() != null) {
                    this.n.h0().e();
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
                    if (K0) {
                        this.i.p(false);
                    } else {
                        t48 t48Var2 = this.n;
                        if (t48Var2 != null && t48Var2.g0() != null) {
                            this.n.g0().y();
                            this.n.V0(false);
                        }
                    }
                    this.a.setRefreshing(true);
                }
                ScrollFragmentTabHost.r rVar = this.i0;
                if (rVar != null) {
                    rVar.b();
                }
            }
        }
    }

    public final void G0(Object obj) {
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, obj) == null) && (bigdaySwipeRefreshLayout = this.a) != null && !bigdaySwipeRefreshLayout.t()) {
            if (obj != null && (obj instanceof m15)) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                a68 a68Var = this.d;
                if (a68Var == null) {
                    a68 a68Var2 = new a68(this.l);
                    this.d = a68Var2;
                    a68Var2.H(this.u);
                    this.e = this.d;
                    H0();
                } else if (this.e == a68Var) {
                    return;
                } else {
                    this.e = a68Var;
                }
                this.d.A(true);
                this.a.setProgressView(this.d);
                int i2 = (int) (getResources().getDisplayMetrics().density * 86.0f);
                this.a.setCustomDistances(i2, i2, i2 * 2);
                return;
            }
            m15 m15Var = (m15) obj;
            b68 b68Var = this.c;
            if (b68Var == null) {
                b68 b68Var2 = new b68(this.l.getContext());
                this.c = b68Var2;
                this.e = b68Var2;
                H0();
            } else if (this.e == b68Var && m15Var.equals(b68Var.F())) {
                return;
            } else {
                this.e = this.c;
            }
            this.c.A(true);
            this.a.setProgressView(this.c);
            dh.g(new o0(this, m15Var));
            this.a.setCustomDistances((int) getResources().getDimension(R.dimen.tbds236), (int) (yi.j(this.l.getContext()) * 0.8d), yi.j(this.l.getContext()));
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
            jp6 jp6Var = new jp6(context);
            this.A = jp6Var;
            jp6Var.setFrom("from_personaize");
            this.A.a().setVisibility(0);
            this.A.a().setOnClickListener(this.j0);
            x18 x18Var = new x18(this, this.b);
            this.H = x18Var;
            x18Var.q(context.getString(R.string.obfuscated_res_0x7f0f15b6));
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = new BigdaySwipeRefreshLayout(context);
            this.a = bigdaySwipeRefreshLayout;
            bigdaySwipeRefreshLayout.addView(this.b);
            this.a.setNeedInterceptOnLayout(!K0);
            PbListView pbListView = new PbListView(context);
            this.f = pbListView;
            pbListView.c();
            this.f.s(R.color.transparent);
            this.f.B();
            this.f.J(SkinManager.getColor(R.color.CAM_X0107));
            this.f.L(R.dimen.tbfontsize33);
            this.f.F(R.color.CAM_X0110);
            this.f.w(yi.g(context, R.dimen.tbds182));
            this.f.G(this.E0);
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
            if (K0) {
                this.g.e(new r1a(new q1a(), bdUniqueId));
                cc7 cc7Var = this.g;
                p1a p1aVar = new p1a();
                p1aVar.d("1");
                cc7Var.c(new o1a(p1aVar, bdUniqueId));
                this.i.q(bdUniqueId);
                this.h.P(bdUniqueId);
            }
            z58 z58Var = this.k;
            if (z58Var != null) {
                z58Var.y(bdUniqueId);
            }
            t48 t48Var = this.n;
            if (t48Var != null) {
                t48Var.N0(bdUniqueId);
            }
            s68 s68Var = this.p;
            if (s68Var != null) {
                s68Var.a(bdUniqueId);
            }
            a68 a68Var = this.d;
            if (a68Var != null) {
                a68Var.a0(bdUniqueId);
            }
            n15.i().n(bdUniqueId);
            CustomMessageListener customMessageListener = this.D0;
            if (customMessageListener != null) {
                customMessageListener.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.D0);
            }
            lu6.b().a(new ku6(bdUniqueId, df5.class), new a(this, df5.class));
            lu6.b().a(new ku6(bdUniqueId, ff5.class), new b(this, ff5.class));
            lu6.b().a(new ku6(bdUniqueId, ef5.class), new c(this, ef5.class));
            lu6.b().a(new ku6(bdUniqueId, cf5.class), new d(this, cf5.class));
            lu6.b().a(new ku6(bdUniqueId, w0a.class), new e(this, w0a.class));
            lu6.b().a(new ku6(bdUniqueId, x0a.class), new f(this, x0a.class));
            lu6.b().a(new ku6(bdUniqueId, af5.class), new g(this, af5.class));
            lu6.b().a(new ku6(bdUniqueId, rl5.class), new h(this, rl5.class));
        }
    }

    public void S0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            if (this.u != i2) {
                co5 co5Var = this.r;
                if (co5Var != null) {
                    co5Var.onChangeSkinType();
                }
                do5 do5Var = this.s;
                if (do5Var != null) {
                    do5Var.onChangeSkinType();
                }
                a68 a68Var = this.d;
                if (a68Var != null) {
                    a68Var.H(i2);
                }
                PbListView pbListView = this.f;
                if (pbListView != null) {
                    pbListView.J(SkinManager.getColor(R.color.CAM_X0109));
                    this.f.e(i2);
                }
                z58 z58Var = this.k;
                if (z58Var != null) {
                    z58Var.o(i2);
                }
                t48 t48Var = this.n;
                if (t48Var != null) {
                    t48Var.C0(i2);
                }
                jp6 jp6Var = this.A;
                if (jp6Var != null) {
                    jp6Var.d(i2);
                }
                RightFloatLayerView rightFloatLayerView = this.F;
                if (rightFloatLayerView != null) {
                    rightFloatLayerView.n();
                }
                x18 x18Var = this.H;
                if (x18Var != null) {
                    x18Var.o();
                }
                zg5 zg5Var = this.S;
                if (zg5Var != null) {
                    zg5Var.w();
                }
                cc7 cc7Var = this.g;
                if (cc7Var != null) {
                    cc7Var.b();
                }
            }
            this.u = i2;
        }
    }

    public final void i1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z2) == null) {
            if (this.r == null) {
                this.r = new co5(getContext());
                this.r.p(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + yi.g(getContext(), R.dimen.tbds60));
                this.r.i();
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

    public final boolean p1(hd5 hd5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, hd5Var)) == null) {
            if (!RightFloatLayerView.k()) {
                C0();
                return false;
            } else if (hd5Var == null) {
                return false;
            } else {
                if (this.F == null) {
                    RightFloatLayerView E = RightFloatLayerLottieView.E(hd5Var, getContext());
                    this.F = E;
                    E.setPageContext(this.l);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 85;
                    layoutParams.bottomMargin = L0 + this.G;
                    this.F.c();
                    addView(this.F, layoutParams);
                }
                this.F.setAutoCompleteShown(true);
                if (hd5Var.a()) {
                    return false;
                }
                this.F.setData(hd5Var);
                this.F.setLogoListener(new t(this, hd5Var));
                this.F.setFeedBackListener(new u(this, hd5Var));
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final void y0(v87 v87Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048638, this, v87Var) != null) || v87Var == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.NEG_FEEDBACK_KEY).param("obj_locate", "1").param("fid", v87Var.d()).param("tid", v87Var.h()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("nid", v87Var.e()));
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.NEGATIVE_FEEDBACK_OPEN_CLICK).param("obj_locate", "1").param("fid", v87Var.d()).param("tid", v87Var.h()).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public final void z0(i68 i68Var) {
        List<mc7<?>> b2;
        int u02;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, i68Var) == null) {
            t48 t48Var = this.n;
            if (t48Var != null) {
                t48Var.k0(i68Var);
            }
            if (this.h != null) {
                int firstVisiblePosition = this.b.getFirstVisiblePosition();
                RecommendBarCardModel d2 = RecommendBarCardModel.d(i68Var);
                if (d2 != null && (b2 = this.h.b()) != null && (u02 = u0(i68Var.b(), b2)) >= 0 && (i2 = u02 + 1) >= 0 && i2 <= b2.size() && i2 > firstVisiblePosition) {
                    d2.n(i68Var.b());
                    d2.p(RecommendBarCardModel.RecDataSource.FORUMBACKCONCERN);
                    this.h.F(new nc7(new a67(new n97(d2)), "recommend_bar_layout"), i2);
                    o48 o48Var = this.o;
                    if (o48Var != null) {
                        o48Var.c();
                        t48.n0(i68Var.a());
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
            MessageManager.getInstance().unRegisterListener(this.F0);
            MessageManager.getInstance().unRegisterListener(this.G0);
            MessageManager.getInstance().unRegisterListener(this.W);
            MessageManager.getInstance().unRegisterListener(this.H0);
            MessageManager.getInstance().unRegisterListener(this.I0);
            MessageManager.getInstance().unRegisterListener(this.v0);
            MessageManager.getInstance().unRegisterListener(this.t0);
            MessageManager.getInstance().unRegisterListener(this.a0);
            MessageManager.getInstance().unRegisterListener(this.b0);
            MessageManager.getInstance().registerListener(this.c0);
            if (K0) {
                MessageManager.getInstance().unRegisterListener(this.J0);
                this.h.w();
                this.j.c();
            }
            if (K0) {
                this.i.l();
            }
            t48 t48Var = this.n;
            if (t48Var != null) {
                t48Var.D0();
            }
            PollingModel pollingModel = this.f1110T;
            if (pollingModel != null) {
                pollingModel.onDestroy();
            }
            z58 z58Var = this.k;
            if (z58Var != null) {
                z58Var.w(null);
                this.k.p();
            }
            this.I = false;
            t48 t48Var2 = this.n;
            if (t48Var2 != null) {
                t48Var2.U0(null);
            }
            b68 b68Var = this.c;
            if (b68Var != null) {
                b68Var.f(null);
                this.c.g(null);
                this.c.k(null);
                this.c.m(null);
                this.c.G();
            }
            a68 a68Var = this.d;
            if (a68Var != null) {
                a68Var.f(null);
                this.d.g(null);
                this.d.k(null);
                this.d.m(null);
                this.d.Y();
            }
            this.b.setOnSrollToBottomListener(null);
            b28 b28Var = this.f0;
            if (b28Var != null) {
                b28Var.e(this.i0);
            }
            this.b.removeOnScrollListener(this.h0);
            co5 co5Var = this.r;
            if (co5Var != null) {
                co5Var.n();
            }
            this.b.setRecyclerListener(null);
            n15.i().e();
            zg.a().removeCallbacks(this.B0);
            xz5.b().d(this);
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
            z58 z58Var = this.k;
            if (z58Var != null) {
                z58Var.r();
            }
            if (!RightFloatLayerView.k()) {
                D0();
            }
            q1();
        }
    }

    public void X0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (K0) {
                this.i.k(true);
            } else {
                t48 t48Var = this.n;
                if (t48Var != null) {
                    t48Var.A0(true);
                }
            }
            zg5 zg5Var = this.S;
            if (zg5Var != null) {
                zg5Var.q();
            }
            np6.b().d(false);
            r66.c().h("page_recommend", "show_");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            zg.a().removeCallbacks(this.B0);
        }
    }

    public final void q1() {
        ThreadCardViewHolder threadCardViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            for (int i2 = 0; i2 < this.b.getChildCount(); i2++) {
                View childAt = this.b.getChildAt(i2);
                if ((childAt instanceof ThreadCardView) && (childAt.getTag() instanceof ThreadCardViewHolder) && (threadCardViewHolder = (ThreadCardViewHolder) childAt.getTag()) != null && threadCardViewHolder.b() != null && (threadCardViewHolder.b().f() instanceof oz)) {
                    ((oz) threadCardViewHolder.b().f()).R();
                }
            }
        }
    }

    public void setViewForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            setViewForeground(false);
            if (K0) {
                this.i.k(false);
            } else {
                t48 t48Var = this.n;
                if (t48Var != null) {
                    t48Var.A0(false);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            if (this.B < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
                zg.a().postDelayed(this.B0, 1000L);
            }
        }
    }

    @Override // com.baidu.tieba.wz5
    @Nullable
    public yz5 b(@NonNull String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, str, str2)) == null) {
            TbPageContext<?> tbPageContext = this.l;
            if (tbPageContext != null && tbPageContext.getPageActivity() != null && !this.l.getPageActivity().isFinishing()) {
                if ("home_banner".equals(str)) {
                    if (h9.f().g() - h9.f().i(this.l.getPageActivity()) > 2) {
                        DefaultLog.getInstance().c("ViewPosLog", "MainTabActivity和栈顶Activity之间存在Activity");
                        return null;
                    }
                    int findFirstVisibleItemPosition = this.E.findFirstVisibleItemPosition();
                    int findLastVisibleItemPosition = this.E.findLastVisibleItemPosition();
                    if (findFirstVisibleItemPosition != -1 && findLastVisibleItemPosition != -1) {
                        while (findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
                            if (findFirstVisibleItemPosition >= 0 && findFirstVisibleItemPosition < this.b.getData().size()) {
                                yn ynVar = this.b.getData().get(findFirstVisibleItemPosition);
                                if (ynVar instanceof k68) {
                                    return w0(str2, findFirstVisibleItemPosition, (k68) ynVar);
                                }
                            }
                            findFirstVisibleItemPosition++;
                        }
                    } else {
                        DefaultLog.getInstance().c("ViewPosLog", "当前RecyclerView无可见item");
                        return null;
                    }
                }
                h29 defaultLog = DefaultLog.getInstance();
                defaultLog.c("ViewPosLog", "未找到对应控件 " + str + " 的位置处理实现");
                return null;
            }
            DefaultLog.getInstance().c("ViewPosLog", "当前上下文环境不可用");
            return null;
        }
        return (yz5) invokeLL.objValue;
    }

    public final void e1(String str, String str2) {
        ThreadCardViewHolder threadCardViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048608, this, str, str2) == null) {
            for (int i2 = 0; i2 < this.b.getChildCount(); i2++) {
                View childAt = this.b.getChildAt(i2);
                if ((childAt instanceof ThreadCardView) && (childAt.getTag() instanceof ThreadCardViewHolder) && (threadCardViewHolder = (ThreadCardViewHolder) childAt.getTag()) != null && threadCardViewHolder.b() != null && (threadCardViewHolder.b().f() instanceof oz)) {
                    if (tl5.b.a().a("show_reply_tip") && "home_reply".equals(str2)) {
                        ((oz) threadCardViewHolder.b().f()).Q();
                    } else if (tl5.b.a().a("show_agree_tip") && "home_agree".equals(str2)) {
                        ((oz) threadCardViewHolder.b().f()).P();
                    }
                    da5.p().A(da5.t(we7.a(str, str2)), false);
                    return;
                }
            }
        }
    }

    public final void j1(View view2, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048614, this, view2, str, z2) == null) {
            if (this.s == null) {
                this.s = new do5(getContext(), new h0(this));
            }
            this.s.attachView(view2, z2);
            this.s.p();
            e5a.a("main", false);
        }
    }

    public void n1(DataRes dataRes, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{dataRes, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            dh.g(new e0(this));
            t48 t48Var = this.n;
            if (t48Var != null) {
                t48Var.E0(z2, z3, dataRes, 0, null);
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
        z58 z58Var = this.k;
        if (z58Var == null) {
            return;
        }
        List<yn> k2 = z58Var.k();
        if (!ListUtils.isEmpty(k2)) {
            int i3 = 0;
            while (true) {
                if (i3 >= k2.size()) {
                    break;
                } else if (k2.get(i3) instanceof kq6) {
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
            if (K0) {
                this.h.I();
                i1(true);
                Y0();
            } else {
                q0(z2);
            }
            if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
                n15.i().j();
                n15.i().k();
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
                this.a.z(new sa5.i(string, 0));
                return;
            }
            this.a.setRefreshing(false);
        }
    }

    public final yz5 v0(@Nullable View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, view2)) == null) {
            yz5 b2 = yz5.b();
            if (getContext() != null && view2 != null) {
                Rect rect = new Rect();
                view2.getGlobalVisibleRect(rect);
                if (rect.left <= yi.l(getContext()) && rect.right >= 0) {
                    int i2 = rect.left;
                    int i3 = rect.top;
                    return new yz5(true, i2, i3, rect.right - i2, rect.bottom - i3);
                }
            }
            return b2;
        }
        return (yz5) invokeL.objValue;
    }

    public final int u0(@NonNull String str, @NonNull List<mc7<?>> list) {
        InterceptResult invokeLL;
        e87<?> e87Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048634, this, str, list)) == null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                mc7<?> mc7Var = list.get(i2);
                if ((mc7Var instanceof z77) && (e87Var = ((z77) mc7Var).c) != null && str.equals(e87Var.g())) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    @NonNull
    public final yz5 w0(@Nullable String str, int i2, @NonNull k68 k68Var) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048636, this, str, i2, k68Var)) == null) {
            yz5 b2 = yz5.b();
            if (this.b == null) {
                return b2;
            }
            if (xi.isEmpty(str)) {
                return v0(this.b.getChildAt(i2));
            }
            View view2 = null;
            if (g68.a(str).b().equals(k68Var.a)) {
                view2 = this.b.getChildAt(i2);
            }
            return v0(view2);
        }
        return (yz5) invokeLIL.objValue;
    }

    public final void x0(List<Integer> list, String str, v87 v87Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048637, this, list, str, v87Var) == null) && list != null && v87Var != null) {
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
            if (v87Var.g() == 0) {
                i2 = 1;
            } else if (v87Var.g() == 40) {
                i2 = 2;
            } else if (v87Var.g() == 49 || v87Var.g() == 69) {
                i2 = 3;
            }
            z58 z58Var = this.k;
            if (z58Var != null) {
                z58Var.n();
            }
            P0();
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.NEG_FEEDBACK_KEY).param("tid", v87Var.h()).param("nid", v87Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", v87Var.d()).param("obj_param1", v87Var.i()).param("obj_source", v87Var.f()).param("obj_id", v87Var.a()).param("obj_type", sb.toString()).param("obj_name", str).param(TiebaStatic.Params.OBJ_PARAM2, i2).param("obj_locate", "1"));
        }
    }
}
