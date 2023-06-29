package com.baidu.tieba.homepage.personalize;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
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
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.ListUtils;
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
import com.baidu.tbadk.widget.RightFloatLayerLottieView;
import com.baidu.tbadk.widget.RightFloatLayerView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.a08;
import com.baidu.tieba.aa5;
import com.baidu.tieba.bc;
import com.baidu.tieba.ch;
import com.baidu.tieba.ct5;
import com.baidu.tieba.dn5;
import com.baidu.tieba.dx9;
import com.baidu.tieba.e15;
import com.baidu.tieba.en5;
import com.baidu.tieba.et5;
import com.baidu.tieba.ew5;
import com.baidu.tieba.ew8;
import com.baidu.tieba.ex7;
import com.baidu.tieba.f15;
import com.baidu.tieba.fo6;
import com.baidu.tieba.g18;
import com.baidu.tieba.gp6;
import com.baidu.tieba.gx7;
import com.baidu.tieba.h18;
import com.baidu.tieba.h9;
import com.baidu.tieba.he5;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.adapter.HomePageCardVideoViewHolder;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.hx7;
import com.baidu.tieba.i18;
import com.baidu.tieba.ix7;
import com.baidu.tieba.jo6;
import com.baidu.tieba.k35;
import com.baidu.tieba.l9;
import com.baidu.tieba.n18;
import com.baidu.tieba.n2a;
import com.baidu.tieba.n56;
import com.baidu.tieba.nz;
import com.baidu.tieba.pc5;
import com.baidu.tieba.qa7;
import com.baidu.tieba.r18;
import com.baidu.tieba.r9;
import com.baidu.tieba.r95;
import com.baidu.tieba.rn5;
import com.baidu.tieba.sy5;
import com.baidu.tieba.ty5;
import com.baidu.tieba.uk5;
import com.baidu.tieba.uy5;
import com.baidu.tieba.vz7;
import com.baidu.tieba.wi;
import com.baidu.tieba.wu4;
import com.baidu.tieba.xi;
import com.baidu.tieba.xn;
import com.baidu.tieba.y18;
import com.baidu.tieba.yg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.Personalized.DataRes;
/* loaded from: classes6.dex */
public class PersonalizePageView extends FrameLayout implements sy5 {
    public static /* synthetic */ Interceptable $ic;
    public static final int w0;
    public transient /* synthetic */ FieldHolder $fh;
    public RightFloatLayerView A;
    public int B;
    public ex7 C;
    public volatile boolean D;
    public FrameLayout E;
    public boolean F;
    public boolean G;
    public boolean H;
    public Context I;
    public Object J;
    public String K;
    public String L;
    public boolean M;
    public boolean N;
    public g18.f O;
    public CustomMessageListener P;
    public NEGFeedBackView.b Q;
    public FollowUserButton.a R;
    public ix7 S;

    /* renamed from: T  reason: collision with root package name */
    public int f1106T;
    public RecyclerView.OnScrollListener U;
    public ScrollFragmentTabHost.r V;
    public View.OnClickListener W;
    public BigdaySwipeRefreshLayout a;
    public CustomMessageListener a0;
    public BdTypeRecyclerView b;
    public CustomMessageListener b0;
    public i18 c;
    public a08.q0 c0;
    public h18 d;
    public CustomMessageListener d0;
    public h0 e;
    public aa5.g e0;
    public PbListView f;
    public aa5.h f0;
    public g18 g;
    public aa5.e g0;
    public TbPageContext<?> h;
    public aa5.f h0;
    public hx7 i;
    public Runnable i0;
    public a08 j;
    public final CustomMessageListener j0;
    public y18 k;
    public long l;
    public dn5 m;
    public en5 n;
    public long o;
    public int p;
    public boolean q;
    public boolean r;
    public View.OnClickListener r0;
    public long s;
    public CustomMessageListener s0;
    public boolean t;
    public CustomMessageListener t0;
    public boolean u;
    public CustomMessageListener u0;
    public fo6 v;
    public CustomMessageListener v0;
    public int w;
    public int x;
    public boolean y;
    public LinearLayoutManager z;

    /* loaded from: classes6.dex */
    public interface h0 {
        void f(aa5.g gVar);

        void g(aa5.h hVar);

        void k(aa5.e eVar);

        void m(aa5.f fVar);
    }

    public final void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements a08.q0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ PersonalizePageView b;

        /* renamed from: com.baidu.tieba.homepage.personalize.PersonalizePageView$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0330a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ String b;
            public final /* synthetic */ a c;

            public RunnableC0330a(a aVar, int i, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i), str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = aVar;
                this.a = i;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                    return;
                }
                this.c.b.e0();
                if (this.a == 1) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        this.c.b.h.showToast(this.b);
                    }
                    this.c.g();
                } else if (this.c.a) {
                    this.c.g();
                    this.c.b.M0(false);
                    return;
                } else {
                    this.c.b.a.setVisibility(8);
                    this.c.b.C.r(false);
                    PersonalizePageView personalizePageView = this.c.b;
                    personalizePageView.J0(personalizePageView, this.b, true);
                }
                bc.b().e();
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ boolean a;
            public final /* synthetic */ a b;

            public b(a aVar, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.g();
                    this.b.b.a.setVisibility(0);
                    this.b.b.C.r(true);
                    this.b.b.e0();
                    this.b.b.f0();
                    this.b.b.r = true;
                    if (this.a) {
                        this.b.b.s = System.currentTimeMillis();
                    }
                }
            }
        }

        /* loaded from: classes6.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public c(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
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
            this.b = personalizePageView;
            this.a = r95.p().l("key_first_install", true);
        }

        @Override // com.baidu.tieba.a08.q0
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                ch.g(new b(this, z));
            }
        }

        @Override // com.baidu.tieba.a08.q0
        public void b(int i, ew5 ew5Var, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), ew5Var, Integer.valueOf(i2)}) == null) {
                if (this.b.i == null) {
                    PersonalizePageView personalizePageView = this.b;
                    personalizePageView.J0(personalizePageView, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e0f), true);
                    this.b.e0();
                    return;
                }
                boolean p0 = this.b.p0();
                this.b.f0();
                if (p0) {
                    this.b.I0(true);
                }
                this.b.i.c(i, ew5Var, i2);
                wu4.f().m();
            }
        }

        @Override // com.baidu.tieba.a08.q0
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                ch.g(new c(this));
            }
        }

        public final void g() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.a) {
                this.a = false;
                r95.p().A("key_first_install", false);
            }
        }

        @Override // com.baidu.tieba.a08.q0
        public void d(int i, int i2, ew5 ew5Var, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), ew5Var, Integer.valueOf(i3)}) == null) && this.b.i != null) {
                PersonalizePageView personalizePageView = this.b;
                if (personalizePageView.q0(personalizePageView.b)) {
                    this.b.l = System.currentTimeMillis();
                }
                this.b.i.d(i, i2, ew5Var, i3);
            }
        }

        @Override // com.baidu.tieba.a08.q0
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) {
                ch.g(new RunnableC0330a(this, i, str));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ s a;

            public a(s sVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = sVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.u0();
                }
            }
        }

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
                    yg.a().postDelayed(new a(this), TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a0 implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(k35 k35Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k35Var, compoundButton, z) == null) {
            }
        }

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

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void a(ArrayList<Integer> arrayList, String str, k35 k35Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, k35Var) == null) && arrayList != null && k35Var != null) {
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
                int i3 = k35Var.n;
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
                this.a.s0();
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.NEG_FEEDBACK_KEY).param("tid", k35Var.f()).param("nid", k35Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", k35Var.c()).param("obj_param1", k35Var.k).param("obj_source", k35Var.l).param("obj_id", k35Var.m).param("obj_type", sb.toString()).param("obj_name", str).param(TiebaStatic.Params.OBJ_PARAM2, i).param("obj_locate", "1"));
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(k35 k35Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k35Var) != null) || k35Var == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.NEG_FEEDBACK_KEY).param("obj_locate", "1").param("fid", k35Var.c()).param("tid", k35Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("nid", k35Var.e()));
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.NEGATIVE_FEEDBACK_OPEN_CLICK).param("obj_locate", "1").param("fid", k35Var.c()).param("tid", k35Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    /* loaded from: classes6.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue() && rn5.f().b() && this.a.f != null && this.a.f.l() == 0) {
                this.a.f.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b0 implements FollowUserButton.a {
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

        @Override // com.baidu.tbadk.core.view.FollowUserButton.a
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || view2 == null) {
                return;
            }
            Object tag = view2.getTag();
            if (tag instanceof ThreadData) {
                TiebaStatic.log(n2a.j("c13696", (ThreadData) tag));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public c(PersonalizePageView personalizePageView) {
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
                rn5.f().j();
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
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLI(1048576, this, recyclerView, i) != null) || this.a.f1106T == i || this.a.S == null) {
                return;
            }
            this.a.f1106T = i;
            if (this.a.f1106T == 1) {
                this.a.S.a();
            } else if (this.a.B0(recyclerView)) {
                this.a.S.c();
            } else {
                this.a.S.a();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pc5 a;
        public final /* synthetic */ PersonalizePageView b;

        public d(PersonalizePageView personalizePageView, pc5 pc5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, pc5Var};
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
            this.a = pc5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a != null && this.b.A != null) {
                this.b.A.g(this.a);
                this.b.A.setAutoCompleteShown(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d0 extends ScrollFragmentTabHost.r {
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

        @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.r
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.S == null) {
                return;
            }
            this.a.f1106T = -1;
            PersonalizePageView personalizePageView = this.a;
            if (personalizePageView.B0(personalizePageView.b)) {
                this.a.S.c();
            } else {
                this.a.S.a();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pc5 a;
        public final /* synthetic */ PersonalizePageView b;

        public e(PersonalizePageView personalizePageView, pc5 pc5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, pc5Var};
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
            this.a = pc5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.A.setHomePbFloatLastCloseTime();
                this.b.g0();
                this.b.A.t(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e0 implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null) {
                this.a.b.removeHeaderView(this.a.v.b());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements aa5.g {
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

        @Override // com.baidu.tieba.aa5.g
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048576, this, z) != null) {
                return;
            }
            this.a.y = true;
            n56.c().f("page_recommend");
            this.a.j.update();
            this.a.j.X0(false);
        }
    }

    /* loaded from: classes6.dex */
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
                if (!TbSingleton.getInstance().isAddBanner) {
                    this.a.F0();
                }
                PersonalizePageView personalizePageView = this.a;
                personalizePageView.F = true;
                if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW || personalizePageView.G) {
                    return;
                }
                personalizePageView.m0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements aa5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        public g(PersonalizePageView personalizePageView) {
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

        @Override // com.baidu.tieba.aa5.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.j != null && this.a.j.m0() != null) {
                    this.a.j.m0().y();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921792));
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && SpeedStatsUtils.UBC_VALUE_SPLASH.equals(customResponsedMessage.getData())) {
                PersonalizePageView personalizePageView = this.a;
                if (personalizePageView.F && !personalizePageView.G) {
                    personalizePageView.m0();
                }
                if (this.a.t) {
                    PersonalizePageView personalizePageView2 = this.a;
                    if (!personalizePageView2.H) {
                        personalizePageView2.H = true;
                        SpeedStats.getInstance().onMainPageStatsEnd(this.a.getContext());
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements aa5.e {
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

        @Override // com.baidu.tieba.aa5.e
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.a.y) {
                return;
            }
            this.a.x = 0;
            this.a.y = false;
        }
    }

    /* loaded from: classes6.dex */
    public class i implements aa5.f {
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

        @Override // com.baidu.tieba.aa5.f
        public void a(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (this.a.j != null) {
                    this.a.j.X0(true);
                    this.a.j.O0();
                }
                TbSingleton.getInstance().mIsForceLayoutMaintab = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, Boolean.TRUE));
                e15 e15Var = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > r95.p().r("key_bigday_next_showtime_home", 0L)) {
                    e15Var = f15.i().h(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, e15Var));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends RecyclerView.OnScrollListener {
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

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                if (this.a.z != null && i == 0) {
                    he5 wlConfigData = TbSingleton.getInstance().getWlConfigData();
                    int i2 = 3;
                    if (wlConfigData != null && wlConfigData.H() != 0) {
                        i2 = wlConfigData.H();
                    }
                    if (this.a.z.getItemCount() - this.a.z.findLastVisibleItemPosition() <= i2 * 5) {
                        this.a.r0();
                    }
                }
                if (this.a.M && i == 0 && r95.p().l(r95.t(qa7.a(this.a.L, this.a.K)), true)) {
                    PersonalizePageView personalizePageView = this.a;
                    personalizePageView.G0(personalizePageView.L, this.a.K);
                    this.a.M = false;
                }
                if (i == 0) {
                    if (this.a.A != null) {
                        this.a.A.p();
                    }
                    if (this.a.J != null) {
                        BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(this.a.J);
                        this.a.J = null;
                    }
                } else if (i == 1) {
                    if (this.a.J == null) {
                        this.a.J = BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect("home", "1", "scroll");
                    }
                    if (this.a.A != null) {
                        this.a.A.o();
                    }
                } else if (i == 2) {
                    if (this.a.J == null) {
                        this.a.J = BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect("home", "1", "scroll");
                    }
                    if (this.a.A != null) {
                        this.a.A.q();
                    }
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                this.a.x += i2;
                if (UbsABTestHelper.isHomePagePromoteLoginUbsABTestA() && !TbadkCoreApplication.isLogin() && r95.p().q("home_page_login_dialog_show_key", 0) == 0 && this.a.x >= xi.s(TbadkCoreApplication.getInst().getContext())[1] * 2) {
                    r95.p().F("home_page_login_dialog_show_key", 1);
                    DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.I, LoginDialogData.HOME_PAGE_RESULT_PAGE));
                }
                if (this.a.C != null) {
                    this.a.C.j();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements g18.f {
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

        @Override // com.baidu.tieba.g18.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (TbSingleton.getInstance().isAddBanner) {
                    if (this.a.b != null && this.a.v != null) {
                        this.a.b.removeHeaderView(this.a.v.b());
                        return;
                    }
                    return;
                }
                this.a.F0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements BdListView.p {
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

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.r0();
        }
    }

    /* loaded from: classes6.dex */
    public class m implements BdListView.o {
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

        @Override // com.baidu.adp.widget.ListView.BdListView.o
        public void onScrollStop(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeII(1048576, this, i, i2) != null) || System.currentTimeMillis() - this.a.o < 5000) {
                return;
            }
            this.a.j.N0(i, i2);
        }
    }

    /* loaded from: classes6.dex */
    public class n implements RecyclerView.RecyclerListener {
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

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, viewHolder) != null) || viewHolder == null || (view2 = viewHolder.itemView) == null) {
                return;
            }
            if (this.a.j != null && this.a.j.m0() != null) {
                this.a.j.m0().k(view2);
            }
            if (view2.getTag() instanceof HomePageCardVideoViewHolder) {
                ((HomePageCardVideoViewHolder) view2.getTag()).a().stopPlay();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements Runnable {
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
    public class p implements Runnable {
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
    public class q implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.j != null) {
                this.a.j.update();
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.h != null) {
                r95.p().F("show_is_uninterest_tag", PersonalizePageView.L(this.a));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(this.a.h.getContext(), 2)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.r0();
        }
    }

    /* loaded from: classes6.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (!(data instanceof String) || TextUtils.isEmpty((String) data)) {
                    return;
                }
                this.a.q = true;
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
                this.a.B = ((Integer) data).intValue();
                if (this.a.A != null) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.A.getLayoutParams();
                    layoutParams.gravity = 85;
                    layoutParams.bottomMargin = PersonalizePageView.w0 + this.a.B;
                    this.a.A.requestLayout();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.k0(customResponsedMessage.getData());
        }
    }

    /* loaded from: classes6.dex */
    public class x implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e15 a;
        public final /* synthetic */ PersonalizePageView b;

        public x(PersonalizePageView personalizePageView, e15 e15Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, e15Var};
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
            this.a = e15Var;
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
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.h0();
        }
    }

    /* loaded from: classes6.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (!this.a.N) {
                        return;
                    }
                    this.a.N = false;
                    this.a.K0();
                } else if (this.a.A == null || this.a.A.getVisibility() != 0) {
                } else {
                    this.a.N = true;
                    this.a.h0();
                }
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
        w0 = UtilHelper.getDimenPixelSize(R.dimen.tbds437);
    }

    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.j.T0();
        }
    }

    public void E0() {
        a08 a08Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (a08Var = this.j) != null) {
            a08Var.a1();
        }
    }

    public void K0() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (rightFloatLayerView = this.A) != null) {
            rightFloatLayerView.d();
        }
    }

    public void Z() {
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (bigdaySwipeRefreshLayout = this.a) != null) {
            bigdaySwipeRefreshLayout.r();
        }
    }

    @Override // com.baidu.tieba.sy5
    @NonNull
    public List<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("home_banner");
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.n != null) {
                C0();
                return;
            }
            a08 a08Var = this.j;
            if (a08Var != null) {
                a08Var.update();
            }
        }
    }

    public final void f0() {
        en5 en5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (en5Var = this.n) != null) {
            en5Var.dettachView(this);
            this.n = null;
        }
    }

    public void g0() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (rightFloatLayerView = this.A) != null) {
            rightFloatLayerView.c();
        }
    }

    public FrameLayout getmTaskFloatingView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.E;
        }
        return (FrameLayout) invokeV.objValue;
    }

    public final void h0() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && (rightFloatLayerView = this.A) != null) {
            rightFloatLayerView.setAutoCompleteShown(false);
            this.A.clearAnimation();
            this.A.setVisibility(8);
        }
    }

    public void l0() {
        h0 h0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && (h0Var = this.e) != null) {
            h0Var.f(this.e0);
            this.e.g(this.f0);
            this.e.k(this.g0);
            this.e.m(this.h0);
        }
    }

    public final void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.G = true;
            pc5 homeAdFloatViewItemData = TbSingleton.getInstance().getHomeAdFloatViewItemData();
            if (homeAdFloatViewItemData != null && !homeAdFloatViewItemData.a()) {
                P0(homeAdFloatViewItemData);
            }
        }
    }

    public final boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            en5 en5Var = this.n;
            if (en5Var != null) {
                return en5Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void s0() {
        ex7 ex7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048616, this) == null) && (ex7Var = this.C) != null) {
            ex7Var.f();
        }
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.j.w0();
        }
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            g18 g18Var = this.g;
            if (g18Var != null) {
                g18Var.l();
            }
            s0();
        }
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            this.j.I0();
            g18 g18Var = this.g;
            if (g18Var != null) {
                g18Var.o();
            }
            RightFloatLayerView rightFloatLayerView = this.A;
            if (rightFloatLayerView != null && (rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                ((RightFloatLayerLottieView) rightFloatLayerView).G(600);
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
        this.o = 0L;
        this.p = 3;
        this.q = false;
        this.r = false;
        this.s = -1L;
        this.t = false;
        this.u = false;
        this.w = 0;
        this.x = 0;
        this.y = false;
        this.D = false;
        this.F = false;
        this.G = false;
        this.H = false;
        this.K = "";
        this.L = "";
        this.M = false;
        this.N = false;
        this.O = new k(this);
        this.P = new v(this, 2921553);
        this.Q = new a0(this);
        this.R = new b0(this);
        this.f1106T = -1;
        this.U = new c0(this);
        this.V = new d0(this);
        this.W = new e0(this);
        this.a0 = new f0(this, 2001371);
        this.b0 = new g0(this, 2921736);
        this.c0 = new a(this);
        this.d0 = new b(this, 2921551);
        this.e0 = new f(this);
        this.f0 = new g(this);
        this.g0 = new h(this);
        this.h0 = new i(this);
        this.i0 = new r(this);
        this.j0 = new s(this, 2001118);
        this.r0 = new t(this);
        this.s0 = new u(this, 2921033);
        this.t0 = new w(this, 2921349);
        this.u0 = new y(this, 2921664);
        this.v0 = new z(this, 2921667);
        n0(context);
    }

    public final void k0(Object obj) {
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, obj) == null) && (bigdaySwipeRefreshLayout = this.a) != null && !bigdaySwipeRefreshLayout.t()) {
            if (obj != null && (obj instanceof e15)) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                h18 h18Var = this.d;
                if (h18Var == null) {
                    h18 h18Var2 = new h18(this.h);
                    this.d = h18Var2;
                    h18Var2.H(this.p);
                    this.e = this.d;
                    l0();
                } else if (this.e == h18Var) {
                    return;
                } else {
                    this.e = h18Var;
                }
                this.d.A(true);
                this.a.setProgressView(this.d);
                int i2 = (int) (getResources().getDisplayMetrics().density * 86.0f);
                this.a.setCustomDistances(i2, i2, i2 * 2);
                return;
            }
            e15 e15Var = (e15) obj;
            i18 i18Var = this.c;
            if (i18Var == null) {
                i18 i18Var2 = new i18(this.h.getContext());
                this.c = i18Var2;
                this.e = i18Var2;
                l0();
            } else if (this.e == i18Var && e15Var.equals(i18Var.F())) {
                return;
            } else {
                this.e = this.c;
            }
            this.c.A(true);
            this.a.setProgressView(this.c);
            ch.g(new x(this, e15Var));
            this.a.setCustomDistances((int) getResources().getDimension(R.dimen.tbds236), (int) (xi.j(this.h.getContext()) * 0.8d), xi.j(this.h.getContext()));
        }
    }

    public final void n0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, context) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = new BdTypeRecyclerView(context);
            this.b = bdTypeRecyclerView;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(bdTypeRecyclerView.getContext());
            this.z = linearLayoutManager;
            this.b.setLayoutManager(linearLayoutManager);
            this.b.setFadingEdgeLength(0);
            this.b.setOverScrollMode(2);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.b.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            fo6 fo6Var = new fo6(context);
            this.v = fo6Var;
            fo6Var.setFrom("from_personaize");
            this.v.a().setVisibility(0);
            this.v.a().setOnClickListener(this.W);
            ex7 ex7Var = new ex7(this, this.b);
            this.C = ex7Var;
            ex7Var.q(context.getString(R.string.obfuscated_res_0x7f0f15a0));
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
            this.f.w(xi.g(context, R.dimen.tbds182));
            this.f.G(this.r0);
            this.f.v();
            this.b.setNextPage(this.f);
            addView(this.a);
            this.E = new FrameLayout(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 5;
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
            layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X011);
            addView(this.E, layoutParams);
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
        this.o = 0L;
        this.p = 3;
        this.q = false;
        this.r = false;
        this.s = -1L;
        this.t = false;
        this.u = false;
        this.w = 0;
        this.x = 0;
        this.y = false;
        this.D = false;
        this.F = false;
        this.G = false;
        this.H = false;
        this.K = "";
        this.L = "";
        this.M = false;
        this.N = false;
        this.O = new k(this);
        this.P = new v(this, 2921553);
        this.Q = new a0(this);
        this.R = new b0(this);
        this.f1106T = -1;
        this.U = new c0(this);
        this.V = new d0(this);
        this.W = new e0(this);
        this.a0 = new f0(this, 2001371);
        this.b0 = new g0(this, 2921736);
        this.c0 = new a(this);
        this.d0 = new b(this, 2921551);
        this.e0 = new f(this);
        this.f0 = new g(this);
        this.g0 = new h(this);
        this.h0 = new i(this);
        this.i0 = new r(this);
        this.j0 = new s(this, 2001118);
        this.r0 = new t(this);
        this.s0 = new u(this, 2921033);
        this.t0 = new w(this, 2921349);
        this.u0 = new y(this, 2921664);
        this.v0 = new z(this, 2921667);
        n0(context);
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
        this.o = 0L;
        this.p = 3;
        this.q = false;
        this.r = false;
        this.s = -1L;
        this.t = false;
        this.u = false;
        this.w = 0;
        this.x = 0;
        this.y = false;
        this.D = false;
        this.F = false;
        this.G = false;
        this.H = false;
        this.K = "";
        this.L = "";
        this.M = false;
        this.N = false;
        this.O = new k(this);
        this.P = new v(this, 2921553);
        this.Q = new a0(this);
        this.R = new b0(this);
        this.f1106T = -1;
        this.U = new c0(this);
        this.V = new d0(this);
        this.W = new e0(this);
        this.a0 = new f0(this, 2001371);
        this.b0 = new g0(this, 2921736);
        this.c0 = new a(this);
        this.d0 = new b(this, 2921551);
        this.e0 = new f(this);
        this.f0 = new g(this);
        this.g0 = new h(this);
        this.h0 = new i(this);
        this.i0 = new r(this);
        this.j0 = new s(this, 2001118);
        this.r0 = new t(this);
        this.s0 = new u(this, 2921033);
        this.t0 = new w(this, 2921349);
        this.u0 = new y(this, 2921664);
        this.v0 = new z(this, 2921667);
        n0(context);
    }

    public static /* synthetic */ int L(PersonalizePageView personalizePageView) {
        int i2 = personalizePageView.w + 1;
        personalizePageView.w = i2;
        return i2;
    }

    public boolean B0(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView)) == null) {
            if (recyclerView == null || !recyclerView.canScrollVertically(-1)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void M0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z2) == null) {
            a08 a08Var = this.j;
            if (a08Var != null) {
                a08Var.update(z2);
            }
            if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
                f15.i().j();
                f15.i().k();
            }
        }
    }

    public void a0(Long l2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, l2) == null) {
            this.j.e0(l2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, canvas) == null) {
            super.dispatchDraw(canvas);
            if (this.r) {
                if (!this.u) {
                    this.u = true;
                }
                z0();
            }
        }
    }

    public final boolean o0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048612, this, i2)) == null) {
            if (i2 < 0) {
                return false;
            }
            int findFirstVisibleItemPosition = this.z.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = this.z.findLastVisibleItemPosition();
            if (i2 < findFirstVisibleItemPosition || i2 > findLastVisibleItemPosition) {
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public boolean q0(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, recyclerView)) == null) {
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

    public void setCallback(hx7 hx7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, hx7Var) == null) {
            this.i = hx7Var;
        }
    }

    public void setScrollFragmentTabHost(ix7 ix7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, ix7Var) == null) {
            this.S = ix7Var;
            if (ix7Var != null) {
                ix7Var.e(this.V);
                this.S.b(this.V);
            }
            a08 a08Var = this.j;
            if (a08Var != null) {
                a08Var.Y0(ix7Var);
            }
        }
    }

    public void setTabInForeBackgroundState(boolean z2) {
        a08 a08Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048620, this, z2) == null) && (a08Var = this.j) != null) {
            a08Var.Z0(z2);
        }
    }

    public void setViewForeground(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z2) == null) {
            a08 a08Var = this.j;
            if (a08Var != null) {
                a08Var.J0(z2);
            }
            ix7 ix7Var = this.S;
            if (ix7Var != null) {
                ix7Var.e(this.V);
                this.S.b(this.V);
                this.V.b();
            }
        }
    }

    public void O0(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, str, i2) == null) {
            ch.g(new p(this));
            this.j.G0(true, false, null, i2, str);
        }
    }

    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a08 a08Var = this.j;
            if (a08Var != null) {
                a08Var.C0(true);
            }
            jo6.b().d(false);
            n56.c().h("page_recommend", "show_");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            yg.a().removeCallbacks(this.i0);
        }
    }

    public final void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            gx7.d().j(System.currentTimeMillis(), 1);
            PbListView pbListView = this.f;
            if (pbListView != null && !pbListView.p()) {
                this.f.U();
                this.f.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            this.j.z0();
        }
    }

    public void setViewForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            setViewForeground(false);
            a08 a08Var = this.j;
            if (a08Var != null) {
                a08Var.C0(false);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            if (this.w < 1 && TbadkCoreApplication.getInst().isNoInterestTag()) {
                yg.a().postDelayed(this.i0, 1000L);
            }
        }
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            if (this.q) {
                C0();
                this.q = false;
            }
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.a;
            if (bigdaySwipeRefreshLayout != null) {
                bigdaySwipeRefreshLayout.D();
            }
            g18 g18Var = this.g;
            if (g18Var != null) {
                g18Var.p();
            }
            if (!RightFloatLayerView.k()) {
                h0();
            }
            Q0();
        }
    }

    public void C0() {
        a08 a08Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a08 a08Var2 = this.j;
            if (a08Var2 != null && a08Var2.n0() != null) {
                this.j.n0().e();
            }
            if (this.n != null && (a08Var = this.j) != null) {
                a08Var.update();
                return;
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.b;
            if (bdTypeRecyclerView != null && this.a != null) {
                bdTypeRecyclerView.setSelection(0);
                if (!this.a.t()) {
                    a08 a08Var3 = this.j;
                    if (a08Var3 != null && a08Var3.m0() != null) {
                        this.j.m0().y();
                        this.j.X0(false);
                    }
                    this.a.setRefreshing(true);
                }
                ScrollFragmentTabHost.r rVar = this.V;
                if (rVar != null) {
                    rVar.b();
                }
            }
        }
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.g.u(this.Q);
            this.g.r(this.R);
            this.j.W0(this.c0);
            l0();
            this.b.addOnScrollListener(new j(this));
            this.b.setOnSrollToBottomListener(new l(this));
            this.b.setOnScrollStopDelayedListener(new m(this), 1L);
            this.b.setRecyclerListener(new n(this));
            this.b.removeOnScrollListener(this.U);
            this.b.addOnScrollListener(this.U);
            ty5.b().a(this);
        }
    }

    public final void G0(String str, String str2) {
        ThreadCardViewHolder threadCardViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            for (int i2 = 0; i2 < this.b.getChildCount(); i2++) {
                View childAt = this.b.getChildAt(i2);
                if ((childAt instanceof ThreadCardView) && (childAt.getTag() instanceof ThreadCardViewHolder) && (threadCardViewHolder = (ThreadCardViewHolder) childAt.getTag()) != null && threadCardViewHolder.a() != null && (threadCardViewHolder.a().f() instanceof nz)) {
                    if (uk5.b.a().a("show_reply_tip") && "home_reply".equals(str2)) {
                        ((nz) threadCardViewHolder.a().f()).O();
                    } else if (uk5.b.a().a("show_agree_tip") && "home_agree".equals(str2)) {
                        ((nz) threadCardViewHolder.a().f()).N();
                    }
                    r95.p().A(r95.t(qa7.a(str, str2)), false);
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.sy5
    @Nullable
    public uy5 b(@NonNull String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, str, str2)) == null) {
            TbPageContext<?> tbPageContext = this.h;
            if (tbPageContext != null && tbPageContext.getPageActivity() != null && !this.h.getPageActivity().isFinishing()) {
                if ("home_banner".equals(str)) {
                    if (h9.f().g() - h9.f().i(this.h.getPageActivity()) > 2) {
                        DefaultLog.getInstance().c("ViewPosLog", "MainTabActivity和栈顶Activity之间存在Activity");
                        return null;
                    }
                    int findFirstVisibleItemPosition = this.z.findFirstVisibleItemPosition();
                    int findLastVisibleItemPosition = this.z.findLastVisibleItemPosition();
                    if (findFirstVisibleItemPosition != -1 && findLastVisibleItemPosition != -1) {
                        while (findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
                            if (findFirstVisibleItemPosition >= 0 && findFirstVisibleItemPosition < this.b.getData().size()) {
                                xn xnVar = this.b.getData().get(findFirstVisibleItemPosition);
                                if (xnVar instanceof r18) {
                                    return d0(str2, findFirstVisibleItemPosition, (r18) xnVar);
                                }
                            }
                            findFirstVisibleItemPosition++;
                        }
                    } else {
                        DefaultLog.getInstance().c("ViewPosLog", "当前RecyclerView无可见item");
                        return null;
                    }
                }
                ew8 defaultLog = DefaultLog.getInstance();
                defaultLog.c("ViewPosLog", "未找到对应控件 " + str + " 的位置处理实现");
                return null;
            }
            DefaultLog.getInstance().c("ViewPosLog", "当前上下文环境不可用");
            return null;
        }
        return (uy5) invokeLL.objValue;
    }

    public void H0() {
        Uri data;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (uk5.b.a().a("show_reply_tip") || uk5.b.a().a("show_agree_tip")) {
                Intent intent = null;
                Context context = this.I;
                if ((context instanceof TbPageContextSupport) && ((TbPageContextSupport) context) != null && ((TbPageContextSupport) context).getPageContext() != null && ((TbPageContextSupport) this.I).getPageContext().getPageActivity() != null) {
                    intent = ((TbPageContextSupport) this.I).getPageContext().getPageActivity().getIntent();
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
                    this.K = jSONObject.optString("taskname");
                    String optString = jSONObject.optString("active");
                    this.L = optString;
                    if (!StringUtils.isNull(optString) && !StringUtils.isNull(this.K) && r95.p().l(r95.t(qa7.a(this.L, this.K)), true)) {
                        L0(this.L, this.K);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            dn5 dn5Var = this.m;
            if (dn5Var != null) {
                dn5Var.dettachView(this);
                this.m = null;
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
            this.C.r(true);
            hx7 hx7Var = this.i;
            if (hx7Var != null) {
                hx7Var.b();
            }
            if (this.l != 0) {
                this.l = 0L;
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_PERSONALIZE_LOAD_MORE);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param(TiebaStatic.Params.OBJ_DURATION, new DecimalFormat("#.00").format(((System.currentTimeMillis() - this.l) * 1.0d) / 1000.0d));
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public final void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            if (!this.t) {
                long f2 = gx7.d().f(1) + gx7.d().b();
                long a2 = gx7.d().a(1);
                if (a2 > 0) {
                    f2 = System.currentTimeMillis() - a2;
                }
                et5 et5Var = new et5();
                et5Var.a();
                et5Var.b();
                ct5.b().o(f2);
                if (this.s > 0) {
                    ct5.b().E(System.currentTimeMillis() - this.s);
                }
                ct5.b().I(et5Var.c());
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.SECOND_DRAW_DISPATCH_STAMP_KEY);
                if (!MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW && !this.H) {
                    this.H = true;
                    SpeedStats.getInstance().onMainPageStatsEnd(getContext());
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921637, ""));
            }
            this.t = true;
        }
    }

    public final void I0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z2) == null) {
            if (this.m == null) {
                this.m = new dn5(getContext());
                this.m.p(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + xi.g(getContext(), R.dimen.tbds60));
                this.m.i();
                this.m.setWrapStyle(true);
                this.m.onChangeSkinType();
            }
            this.m.attachView(this, z2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, Boolean.FALSE));
            this.b.setNextPage(null);
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.a;
            if (bigdaySwipeRefreshLayout != null) {
                bigdaySwipeRefreshLayout.setVisibility(8);
            }
            this.C.r(false);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921457, this.h.getUniqueId()));
        }
    }

    public final boolean P0(pc5 pc5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, pc5Var)) == null) {
            if (!RightFloatLayerView.k()) {
                g0();
                return false;
            } else if (pc5Var == null) {
                return false;
            } else {
                if (this.A == null) {
                    RightFloatLayerView E = RightFloatLayerLottieView.E(pc5Var, this.I);
                    this.A = E;
                    E.setPageContext(this.h);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 85;
                    layoutParams.bottomMargin = w0 + this.B;
                    this.A.c();
                    addView(this.A, layoutParams);
                }
                this.A.setAutoCompleteShown(true);
                if (pc5Var.a()) {
                    return false;
                }
                this.A.setData(pc5Var);
                this.A.setLogoListener(new d(this, pc5Var));
                this.A.setFeedBackListener(new e(this, pc5Var));
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final void J0(View view2, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048585, this, view2, str, z2) == null) {
            if (this.n == null) {
                this.n = new en5(getContext(), new q(this));
            }
            this.n.attachView(view2, z2);
            this.n.p();
            dx9.a("main", false);
        }
    }

    public void N0(DataRes dataRes, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{dataRes, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            ch.g(new o(this));
            this.j.G0(z2, z3, dataRes, 0, null);
        }
    }

    public void L0(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, str, str2) != null) || this.b == null) {
            return;
        }
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.a;
        if (bigdaySwipeRefreshLayout != null && bigdaySwipeRefreshLayout.t()) {
            this.a.r();
        }
        int i2 = -1;
        List<xn> h2 = this.g.h();
        if (!ListUtils.isEmpty(h2)) {
            int i3 = 0;
            while (true) {
                if (i3 >= h2.size()) {
                    break;
                } else if (h2.get(i3) instanceof gp6) {
                    i2 = i3;
                    break;
                } else {
                    i3++;
                }
            }
        }
        View childAt = this.b.getChildAt(i2);
        if (i2 >= 0 && childAt != null && o0(i2)) {
            int[] iArr = new int[2];
            this.b.getLocationOnScreen(iArr);
            int i4 = iArr[1];
            int[] iArr2 = new int[2];
            childAt.getLocationOnScreen(iArr2);
            int i5 = iArr2[1];
            if (i5 == i4) {
                G0(str, str2);
                return;
            }
            this.M = true;
            this.b.smoothScrollBy(0, i5 - i4);
            return;
        }
        this.M = true;
        this.b.smoothScrollToPosition(i2);
    }

    public final void Q0() {
        ThreadCardViewHolder threadCardViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            for (int i2 = 0; i2 < this.b.getChildCount(); i2++) {
                View childAt = this.b.getChildAt(i2);
                if ((childAt instanceof ThreadCardView) && (childAt.getTag() instanceof ThreadCardViewHolder) && (threadCardViewHolder = (ThreadCardViewHolder) childAt.getTag()) != null && threadCardViewHolder.a() != null && (threadCardViewHolder.a().f() instanceof nz)) {
                    ((nz) threadCardViewHolder.a().f()).P();
                }
            }
        }
    }

    public final uy5 c0(@Nullable View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, view2)) == null) {
            uy5 b2 = uy5.b();
            if (getContext() != null && view2 != null) {
                Rect rect = new Rect();
                view2.getGlobalVisibleRect(rect);
                if (rect.left <= xi.l(getContext()) && rect.right >= 0) {
                    int i2 = rect.left;
                    int i3 = rect.top;
                    return new uy5(true, i2, i3, rect.right - i2, rect.bottom - i3);
                }
            }
            return b2;
        }
        return (uy5) invokeL.objValue;
    }

    public void v0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
            if (this.p != i2) {
                dn5 dn5Var = this.m;
                if (dn5Var != null) {
                    dn5Var.onChangeSkinType();
                }
                en5 en5Var = this.n;
                if (en5Var != null) {
                    en5Var.onChangeSkinType();
                }
                h18 h18Var = this.d;
                if (h18Var != null) {
                    h18Var.H(i2);
                }
                PbListView pbListView = this.f;
                if (pbListView != null) {
                    pbListView.J(SkinManager.getColor(R.color.CAM_X0109));
                    this.f.e(i2);
                }
                this.g.m(i2);
                a08 a08Var = this.j;
                if (a08Var != null) {
                    a08Var.E0(i2);
                }
                fo6 fo6Var = this.v;
                if (fo6Var != null) {
                    fo6Var.d(i2);
                }
                RightFloatLayerView rightFloatLayerView = this.A;
                if (rightFloatLayerView != null) {
                    rightFloatLayerView.n();
                }
                ex7 ex7Var = this.C;
                if (ex7Var != null) {
                    ex7Var.o();
                }
            }
            this.p = i2;
        }
    }

    @NonNull
    public final uy5 d0(@Nullable String str, int i2, @NonNull r18 r18Var) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048599, this, str, i2, r18Var)) == null) {
            uy5 b2 = uy5.b();
            if (this.b == null) {
                return b2;
            }
            if (wi.isEmpty(str)) {
                return c0(this.b.getChildAt(i2));
            }
            View view2 = null;
            if (n18.a(str).b().equals(r18Var.a)) {
                view2 = this.b.getChildAt(i2);
            }
            return c0(view2);
        }
        return (uy5) invokeLIL.objValue;
    }

    public synchronized void i0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, context) == null) {
            synchronized (this) {
                if (this.D) {
                    return;
                }
                this.D = true;
                this.I = context;
                MessageManager.getInstance().registerListener(this.b0);
                MessageManager.getInstance().registerListener(this.a0);
                MessageManager.getInstance().registerListener(this.P);
                MessageManager.getInstance().registerListener(this.t0);
                MessageManager.getInstance().registerListener(this.s0);
                MessageManager.getInstance().registerListener(this.u0);
                MessageManager.getInstance().registerListener(this.v0);
                MessageManager.getInstance().registerListener(this.d0);
                l9<?> a2 = r9.a(context);
                if (a2 instanceof TbPageContext) {
                    this.h = (TbPageContext) a2;
                }
                this.C.p(this.h);
                e15 e15Var = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > r95.p().r("key_bigday_next_showtime_home", 0L)) {
                    e15Var = f15.i().h(1);
                }
                if (LaunchViewOptSwitch.getIsOn()) {
                    try {
                        k0(e15Var);
                    } catch (Exception unused) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, e15Var));
                    }
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, e15Var));
                }
                vz7 vz7Var = new vz7(this.h);
                this.k = new y18();
                g18 g18Var = new g18(context, this.b);
                this.g = g18Var;
                g18Var.x(this.k);
                this.g.v(this.O);
                this.g.s(vz7Var);
                a08 a08Var = new a08(this.h, this.b, this.g, this.a, this);
                this.j = a08Var;
                a08Var.U0(vz7Var);
                v0(TbadkCoreApplication.getInst().getSkinType());
                this.w = r95.p().q("show_is_uninterest_tag", 0);
                if (!rn5.f().c()) {
                    yg.a().post(new c(this));
                }
            }
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, bdUniqueId) == null) {
            g18 g18Var = this.g;
            if (g18Var != null) {
                g18Var.w(bdUniqueId);
            }
            a08 a08Var = this.j;
            if (a08Var != null) {
                a08Var.P0(bdUniqueId);
            }
            y18 y18Var = this.k;
            if (y18Var != null) {
                y18Var.a(bdUniqueId);
            }
            h18 h18Var = this.d;
            if (h18Var != null) {
                h18Var.a0(bdUniqueId);
            }
            f15.i().n(bdUniqueId);
            CustomMessageListener customMessageListener = this.j0;
            if (customMessageListener != null) {
                customMessageListener.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.j0);
            }
        }
    }

    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.b0);
            MessageManager.getInstance().unRegisterListener(this.a0);
            MessageManager.getInstance().unRegisterListener(this.s0);
            MessageManager.getInstance().unRegisterListener(this.t0);
            MessageManager.getInstance().unRegisterListener(this.P);
            MessageManager.getInstance().unRegisterListener(this.u0);
            MessageManager.getInstance().unRegisterListener(this.v0);
            MessageManager.getInstance().unRegisterListener(this.d0);
            this.j.F0();
            this.g.u(null);
            this.g.n();
            this.D = false;
            this.j.W0(null);
            i18 i18Var = this.c;
            if (i18Var != null) {
                i18Var.f(null);
                this.c.g(null);
                this.c.k(null);
                this.c.m(null);
                this.c.G();
            }
            h18 h18Var = this.d;
            if (h18Var != null) {
                h18Var.f(null);
                this.d.g(null);
                this.d.k(null);
                this.d.m(null);
                this.d.Y();
            }
            this.b.setOnSrollToBottomListener(null);
            ix7 ix7Var = this.S;
            if (ix7Var != null) {
                ix7Var.e(this.V);
            }
            this.b.removeOnScrollListener(this.U);
            dn5 dn5Var = this.m;
            if (dn5Var != null) {
                dn5Var.n();
            }
            this.b.setRecyclerListener(null);
            f15.i().e();
            yg.a().removeCallbacks(this.i0);
            ty5.b().d(this);
        }
    }
}
