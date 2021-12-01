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
import c.a.q0.s.g0.f;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.t0;
import c.a.q0.s.q.x0;
import c.a.r0.n1.h.e;
import c.a.r0.n1.h.h.d0;
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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import tbclient.Personalized.DataRes;
/* loaded from: classes10.dex */
public class PersonalizePageView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.g0.q A;
    public CustomMessageListener A0;
    public boolean B;
    public View.OnClickListener B0;
    public int C;
    public CustomMessageListener C0;
    public int D;
    public boolean E;
    public int F;
    public LinearLayoutManager G;
    public c.a.d.m.e.l H;
    public FRSRefreshButton I;
    public RightFloatLayerView J;
    public int K;
    public boolean L;
    public boolean M;
    public boolean N;
    public Context O;
    public int P;
    public int Q;
    public c.a.r0.n1.h.k.a R;
    public boolean S;
    public Object T;
    public CustomMessageListener U;
    public d0.f V;
    public CustomMessageListener W;
    public CustomMessageListener a0;
    public HttpMessageListener b0;
    public NEGFeedBackView.b c0;
    public FollowUserButton.a d0;

    /* renamed from: e  reason: collision with root package name */
    public BigdaySwipeRefreshLayout f45293e;
    public ScrollFragmentTabHost e0;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f45294f;
    public int f0;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.n1.h.i.b f45295g;
    public RecyclerView.OnScrollListener g0;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.n1.h.i.a f45296h;
    public ScrollFragmentTabHost.s h0;

    /* renamed from: i  reason: collision with root package name */
    public h0 f45297i;
    public View.OnClickListener i0;
    public CustomMessageListener isBigdayPullviewShowListener;

    /* renamed from: j  reason: collision with root package name */
    public PbListView f45298j;

    /* renamed from: k  reason: collision with root package name */
    public c.a.r0.n1.h.h.d0 f45299k;
    public View.OnClickListener k0;
    public TbPageContext<?> l;
    public c.a.r0.n1.d.b m;
    public c.a.r0.n1.h.e n;
    public c.a.r0.n1.h.a o;
    public c.a.r0.n1.h.k.f p;
    public c.a.q0.g0.g q;
    public CustomMessageListener q0;
    public c.a.q0.g0.h r;
    public CustomMessageListener r0;
    public long s;
    public e.l0 s0;
    public int t;
    public f.g t0;
    public boolean u;
    public f.h u0;
    public boolean v;
    public f.e v0;
    public long w;
    public f.InterfaceC0796f w0;
    public boolean x;
    public Runnable x0;
    public boolean y;
    public final CustomMessageListener y0;
    public c.a.r0.g0.r z;
    public View.OnClickListener z0;

    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f45300e;

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
            this.f45300e = personalizePageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f45300e.f45294f == null) {
                return;
            }
            this.f45300e.f45294f.removeHeaderView(this.f45300e.z.b());
        }
    }

    /* loaded from: classes10.dex */
    public class a0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a0(PersonalizePageView personalizePageView, int i2) {
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
                    this.a.updateData(c.a.q0.s.v.a.b().c(), false, false);
                }
                this.a.b0();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f45301e;

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
            this.f45301e = personalizePageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f45301e.f45294f != null && this.f45301e.A != null) {
                    this.f45301e.f45294f.removeHeaderView(this.f45301e.A.b());
                    this.f45301e.S = false;
                    c.a.r0.n1.h.n.b.a(2);
                    Activity currentActivity = TbadkApplication.getInst().getCurrentActivity();
                    if (currentActivity != null) {
                        new BdTopToast(currentActivity, 2000).setIcon(true).setContent(currentActivity.getString(R.string.recommend_card_interest_remove_hint)).show((ViewGroup) currentActivity.findViewById(16908290));
                    }
                }
                c.a.r0.n1.h.n.b.i();
            }
        }
    }

    /* loaded from: classes10.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Integer) {
                this.a.K = ((Integer) data).intValue();
                if (this.a.J != null) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.J.getLayoutParams();
                    layoutParams.gravity = 85;
                    layoutParams.bottomMargin = c.a.d.f.p.l.f(this.a.O, R.dimen.tbds306) + this.a.K;
                    this.a.J.requestLayout();
                }
            }
        }
    }

    /* loaded from: classes10.dex */
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
                if (TbSingleton.getInstance().isAddBanner || !c.a.r0.n1.h.n.b.e()) {
                    this.a.j0();
                } else if (this.a.R == null) {
                    this.a.R = new c.a.r0.n1.h.k.a();
                    this.a.R.c();
                }
                PersonalizePageView personalizePageView = this.a;
                personalizePageView.L = true;
                if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW || personalizePageView.M) {
                    return;
                }
                personalizePageView.e0();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c0 extends HttpMessageListener {
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
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003514 && (httpResponsedMessage instanceof CheckInterestCommitResponseMessage)) {
                CheckInterestCommitResponseMessage checkInterestCommitResponseMessage = (CheckInterestCommitResponseMessage) httpResponsedMessage;
                this.a.P = checkInterestCommitResponseMessage.getFinishInterestStage();
                this.a.Q = checkInterestCommitResponseMessage.getPersonalizedSwitchStatus();
                PersonalizePageView personalizePageView = this.a;
                if (c.a.r0.n1.h.n.b.f(personalizePageView.P, personalizePageView.Q)) {
                    this.a.k0();
                } else {
                    this.a.j0();
                }
            }
        }
    }

    /* loaded from: classes10.dex */
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
            if (personalizePageView.L && !personalizePageView.M) {
                personalizePageView.e0();
            }
            if (this.a.x) {
                PersonalizePageView personalizePageView2 = this.a;
                if (personalizePageView2.N) {
                    return;
                }
                personalizePageView2.N = true;
                SpeedStats.getInstance().onMainPageStatsEnd(this.a.getContext());
            }
        }
    }

    /* loaded from: classes10.dex */
    public class d0 implements NEGFeedBackView.b {
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
            if (this.a.f45299k != null) {
                this.a.f45299k.m();
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.NEG_FEEDBACK_KEY).param("tid", x0Var.f()).param("nid", x0Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", x0Var.c()).param("obj_param1", x0Var.f13093k).param("obj_source", x0Var.l).param("obj_id", x0Var.m).param("obj_type", sb.toString()).param("obj_name", str).param(TiebaStatic.Params.OBJ_PARAM2, i2).param("obj_locate", "1"));
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

    /* loaded from: classes10.dex */
    public class e implements e.l0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f45302b;

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
            this.f45302b = personalizePageView;
            this.a = c.a.q0.s.e0.b.j().g("key_first_install", true);
        }

        @Override // c.a.r0.n1.h.e.l0
        public void a(int i2, c.a.q0.d1.e eVar, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), eVar, Integer.valueOf(i3)}) == null) {
                if (this.f45302b.m != null) {
                    boolean g0 = this.f45302b.g0();
                    this.f45302b.c0();
                    if (g0) {
                        this.f45302b.l0(true);
                    }
                    this.f45302b.m.c(i2, eVar, i3);
                    c.a.q0.a.r.g().s();
                    return;
                }
                PersonalizePageView personalizePageView = this.f45302b;
                personalizePageView.n0(personalizePageView, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                this.f45302b.b0();
            }
        }

        @Override // c.a.r0.n1.h.e.l0
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f45302b.f45298j == null) {
                return;
            }
            this.f45302b.f45298j.C(this.f45302b.getContext().getString(R.string.recommend_no_more_data));
            this.f45302b.f45298j.f();
            this.f45302b.f45298j.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }

        @Override // c.a.r0.n1.h.e.l0
        public void c(int i2, int i3, c.a.q0.d1.e eVar, int i4) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), eVar, Integer.valueOf(i4)}) == null) || this.f45302b.m == null) {
                return;
            }
            this.f45302b.m.d(i2, i3, eVar, i4);
        }

        @Override // c.a.r0.n1.h.e.l0
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                e();
                this.f45302b.f45293e.setVisibility(0);
                this.f45302b.b0();
                this.f45302b.c0();
                this.f45302b.v = true;
                if (z) {
                    this.f45302b.w = System.currentTimeMillis();
                }
            }
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.a) {
                this.a = false;
                c.a.q0.s.e0.b.j().t("key_first_install", false);
            }
        }

        @Override // c.a.r0.n1.h.e.l0
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048581, this, i2, str) == null) {
                this.f45302b.b0();
                if (i2 == 1) {
                    if (c.a.d.f.p.j.z()) {
                        this.f45302b.l.showToast(str);
                    }
                    e();
                } else if (!this.a) {
                    this.f45302b.f45293e.setVisibility(8);
                    PersonalizePageView personalizePageView = this.f45302b;
                    personalizePageView.n0(personalizePageView, str, true);
                } else {
                    e();
                    this.f45302b.startFirstLoad();
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class e0 implements FollowUserButton.a {
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

        @Override // com.baidu.tbadk.core.view.FollowUserButton.a
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            Object tag = view.getTag();
            if (tag instanceof d2) {
                TiebaStatic.log(c.a.r0.s3.a.m("c13696", (d2) tag));
            }
        }
    }

    /* loaded from: classes10.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f45303e;

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
            this.f45303e = personalizePageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f45303e.l == null) {
                return;
            }
            c.a.r0.e1.a.i().w(this.f45303e.l.getPageActivity());
        }
    }

    /* loaded from: classes10.dex */
    public class f0 extends RecyclerView.OnScrollListener {
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
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) || this.a.f0 == i2 || this.a.e0 == null) {
                return;
            }
            this.a.f0 = i2;
            if (this.a.f0 == 1) {
                this.a.e0.showShadow();
            } else if (this.a.recyclerViewIsAtTop(recyclerView)) {
                this.a.e0.dismissShadow();
            } else {
                this.a.e0.showShadow();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.t.c.g f45304e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f45305f;

        public g(PersonalizePageView personalizePageView, c.a.q0.t.c.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45305f = personalizePageView;
            this.f45304e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f45304e == null || this.f45305f.J == null) {
                return;
            }
            this.f45305f.J.doLink(this.f45304e);
            this.f45305f.J.setAutoCompleteShown(false);
        }
    }

    /* loaded from: classes10.dex */
    public class g0 extends ScrollFragmentTabHost.s {
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

        @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.s
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.e0 == null) {
                return;
            }
            this.a.f0 = -1;
            PersonalizePageView personalizePageView = this.a;
            if (personalizePageView.recyclerViewIsAtTop(personalizePageView.f45294f)) {
                this.a.e0.dismissShadow();
            } else {
                this.a.e0.showShadow();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.t.c.g f45306e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f45307f;

        public h(PersonalizePageView personalizePageView, c.a.q0.t.c.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45307f = personalizePageView;
            this.f45306e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f45307f.J.inHomeLastCloseTime();
                this.f45307f.hideRightFloatLayerView();
                this.f45307f.J.reportClickCloseAd(this.f45306e);
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface h0 {
        void a(f.g gVar);

        void b(f.h hVar);

        void f(f.e eVar);

        void h(f.InterfaceC0796f interfaceC0796f);
    }

    /* loaded from: classes10.dex */
    public class i implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f45308e;

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
            this.f45308e = personalizePageView;
        }

        @Override // c.a.q0.s.g0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                c.a.r0.t.d.c().f("page_recommend");
                this.f45308e.n.update();
                this.f45308e.n.O0(false);
                this.f45308e.E = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        }
    }

    /* loaded from: classes10.dex */
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

        @Override // c.a.q0.s.g0.f.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.n == null || this.a.n.f0() == null) {
                return;
            }
            this.a.n.f0().w();
        }
    }

    /* loaded from: classes10.dex */
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
                if (!((Boolean) customResponsedMessage.getData()).booleanValue() || c.a.q0.b.d.x()) {
                    if (this.a.H != null) {
                        this.a.H.w();
                        return;
                    }
                    return;
                }
                if (this.a.H == null) {
                    this.a.H = new c.a.d.m.e.l(new c.a.d.m.e.j());
                }
                this.a.H.q(this.a.f45294f, 2);
            }
        }
    }

    /* loaded from: classes10.dex */
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

        @Override // c.a.q0.s.g0.f.e
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.E) {
                this.a.D = 0;
                this.a.F = 1;
                this.a.E = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
            }
        }
    }

    /* loaded from: classes10.dex */
    public class m implements f.InterfaceC0796f {
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

        @Override // c.a.q0.s.g0.f.InterfaceC0796f
        public void a(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                if (this.a.n != null) {
                    this.a.n.O0(true);
                    this.a.n.F0();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, Boolean.TRUE));
                c.a.q0.s.n.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > c.a.q0.s.e0.b.j().l("key_bigday_next_showtime_home", 0L)) {
                    aVar = c.a.q0.s.n.b.i().h(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        }
    }

    /* loaded from: classes10.dex */
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
                if (this.a.G != null && i2 == 0) {
                    int height = ((WindowManager) this.a.getContext().getSystemService("window")).getDefaultDisplay().getHeight() * 3;
                    if (this.a.D < height || this.a.F != 1) {
                        if (this.a.D < height && this.a.F == 2) {
                            this.a.F = 1;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        }
                    } else {
                        this.a.F = 2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(this.a.F)));
                    }
                    if (this.a.G.getItemCount() - this.a.G.findLastVisibleItemPosition() <= 15) {
                        this.a.h0();
                    }
                }
                if (i2 == 0) {
                    if (this.a.J != null) {
                        this.a.J.onScrollIdle();
                    }
                    if (this.a.T != null) {
                        BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(this.a.T);
                        this.a.T = null;
                    }
                } else if (i2 == 1) {
                    if (this.a.T == null) {
                        this.a.T = BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect("home", "1", "scroll");
                    }
                    if (this.a.J != null) {
                        this.a.J.onScrollDragging();
                    }
                } else if (i2 == 2) {
                    if (this.a.T == null) {
                        this.a.T = BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect("home", "1", "scroll");
                    }
                    if (this.a.J != null) {
                        this.a.J.onScrollSettling();
                    }
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                this.a.D += i3;
                if (this.a.I != null) {
                    c.a.d.m.e.n item = this.a.f45294f.getItem(this.a.G.findLastVisibleItemPosition());
                    if (item instanceof c.a.r0.g0.f0.k) {
                        if (((c.a.r0.g0.f0.k) item).position >= 6) {
                            this.a.I.show();
                        } else {
                            this.a.I.hide();
                        }
                    }
                }
                if (!c.a.q0.b.d.y() || TbadkCoreApplication.isLogin() || c.a.q0.s.e0.b.j().k("home_page_login_dialog_show_key", 0) != 0 || this.a.D < c.a.d.f.p.l.p(TbadkCoreApplication.getInst().getContext())[1] * 2) {
                    return;
                }
                c.a.q0.s.e0.b.j().v("home_page_login_dialog_show_key", 1);
                DialogLoginHelper.checkUpIsLogin(new t0(this.a.O, "new_shouye"));
            }
        }
    }

    /* loaded from: classes10.dex */
    public class o implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f45309e;

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
            this.f45309e = personalizePageView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f45309e.h0();
            }
        }
    }

    /* loaded from: classes10.dex */
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
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || System.currentTimeMillis() - this.a.s < 5000) {
                return;
            }
            this.a.n.E0(i2, i3);
        }
    }

    /* loaded from: classes10.dex */
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
            if (this.a.n != null && this.a.n.f0() != null) {
                this.a.n.f0().k(view);
            }
            if (view.getTag() instanceof HomePageCardVideoViewHolder) {
                ((HomePageCardVideoViewHolder) view.getTag()).getCardView().stopPlay();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f45310e;

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
            this.f45310e = personalizePageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f45310e.n == null) {
                return;
            }
            this.f45310e.n.update();
        }
    }

    /* loaded from: classes10.dex */
    public class s implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f45311e;

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
            this.f45311e = personalizePageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f45311e.l == null) {
                return;
            }
            c.a.q0.s.e0.b.j().v("show_is_uninterest_tag", PersonalizePageView.L(this.f45311e));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(this.f45311e.l.getContext(), 2)));
        }
    }

    /* loaded from: classes10.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* loaded from: classes10.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ t f45312e;

            public a(t tVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {tVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f45312e = tVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f45312e.a.notifyListViewDataSetChanged();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(PersonalizePageView personalizePageView, int i2) {
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

    /* loaded from: classes10.dex */
    public class u implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f45313e;

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
            this.f45313e = personalizePageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f45313e.h0();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class v implements d0.f {
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

        @Override // c.a.r0.n1.h.h.d0.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (TbSingleton.getInstance().isAddBanner) {
                    if (this.a.f45294f != null && this.a.z != null) {
                        this.a.f45294f.removeHeaderView(this.a.z.b());
                    }
                    if (this.a.f45294f == null || this.a.A == null) {
                        return;
                    }
                    this.a.f45294f.removeHeaderView(this.a.A.b());
                    return;
                }
                if (c.a.r0.n1.h.n.b.e()) {
                    PersonalizePageView personalizePageView = this.a;
                    if (personalizePageView.P == -1 && personalizePageView.Q == -1) {
                        return;
                    }
                }
                this.a.j0();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class w extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

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
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (!(data instanceof String) || TextUtils.isEmpty((String) data)) {
                return;
            }
            this.a.u = true;
        }
    }

    /* loaded from: classes10.dex */
    public class x extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizePageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x(PersonalizePageView personalizePageView, int i2) {
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.f45293e == null || this.a.f45293e.isRefreshing()) {
                return;
            }
            if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof c.a.q0.s.n.a))) {
                if (this.a.f45296h != null) {
                    if (this.a.f45297i == this.a.f45296h) {
                        return;
                    }
                    PersonalizePageView personalizePageView = this.a;
                    personalizePageView.f45297i = personalizePageView.f45296h;
                } else {
                    PersonalizePageView personalizePageView2 = this.a;
                    personalizePageView2.f45296h = new c.a.r0.n1.h.i.a(personalizePageView2.l);
                    this.a.f45296h.C(this.a.t);
                    PersonalizePageView personalizePageView3 = this.a;
                    personalizePageView3.f45297i = personalizePageView3.f45296h;
                    this.a.initPullViewListeners();
                }
                this.a.f45296h.v(true);
                this.a.f45293e.setProgressView(this.a.f45296h);
                int i2 = (int) (this.a.getResources().getDisplayMetrics().density * 86.0f);
                this.a.f45293e.setCustomDistances(i2, i2, i2 * 2);
                return;
            }
            c.a.q0.s.n.a aVar = (c.a.q0.s.n.a) customResponsedMessage.getData();
            if (this.a.f45295g != null) {
                if (this.a.f45297i == this.a.f45295g && aVar.equals(this.a.f45295g.A())) {
                    return;
                }
                PersonalizePageView personalizePageView4 = this.a;
                personalizePageView4.f45297i = personalizePageView4.f45295g;
            } else {
                PersonalizePageView personalizePageView5 = this.a;
                personalizePageView5.f45295g = new c.a.r0.n1.h.i.b(personalizePageView5.l.getContext());
                PersonalizePageView personalizePageView6 = this.a;
                personalizePageView6.f45297i = personalizePageView6.f45295g;
                this.a.initPullViewListeners();
            }
            this.a.f45295g.v(true);
            this.a.f45293e.setProgressView(this.a.f45295g);
            this.a.f45295g.D(aVar);
            this.a.f45293e.setCustomDistances((int) this.a.getResources().getDimension(R.dimen.tbds236), (int) (c.a.d.f.p.l.i(this.a.l.getContext()) * 0.8d), c.a.d.f.p.l.i(this.a.l.getContext()));
        }
    }

    /* loaded from: classes10.dex */
    public class y implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f45314e;

        public y(PersonalizePageView personalizePageView) {
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
            this.f45314e = personalizePageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f45314e.I == null) {
                return;
            }
            this.f45314e.I.hide();
            this.f45314e.reload();
        }
    }

    /* loaded from: classes10.dex */
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
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.forceReload();
                if (this.a.f45294f != null && this.a.A != null) {
                    this.a.f45294f.removeHeaderView(this.a.A.b());
                }
                Activity c2 = c.a.d.a.b.g().c("MainTabActivity");
                if (c2 != null) {
                    new BdTopToast(c2, 2000).setIcon(true).setContent(c2.getString(R.string.recommend_card_interest_remove_hint)).show((ViewGroup) c2.findViewById(16908290));
                }
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
        this.s = 0L;
        this.t = 3;
        this.u = false;
        this.v = false;
        this.w = -1L;
        this.x = false;
        this.y = false;
        this.B = false;
        this.C = 0;
        this.D = 0;
        this.E = false;
        this.F = 1;
        this.L = false;
        this.M = false;
        this.N = false;
        this.P = -1;
        this.Q = -1;
        this.S = false;
        this.U = new k(this, 2156674);
        this.V = new v(this);
        this.W = new a0(this, 2921456);
        this.a0 = new b0(this, 2921553);
        this.b0 = new c0(this, CmdConfigHttp.CMD_CHECK_INTEREST_COMMIT);
        this.c0 = new d0(this);
        this.d0 = new e0(this);
        this.f0 = -1;
        this.g0 = new f0(this);
        this.h0 = new g0(this);
        this.i0 = new a(this);
        this.k0 = new b(this);
        this.q0 = new c(this, 2001371);
        this.r0 = new d(this, 2921636);
        this.s0 = new e(this);
        this.t0 = new i(this);
        this.u0 = new j(this);
        this.v0 = new l(this);
        this.w0 = new m(this);
        this.x0 = new s(this);
        this.y0 = new t(this, 2001118);
        this.z0 = new u(this);
        this.A0 = new w(this, 2921033);
        this.isBigdayPullviewShowListener = new x(this, 2921349);
        this.B0 = new y(this);
        this.C0 = new z(this, 2921632);
        f0(context);
    }

    public static /* synthetic */ int L(PersonalizePageView personalizePageView) {
        int i2 = personalizePageView.C + 1;
        personalizePageView.C = i2;
        return i2;
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.q0.g0.g gVar = this.q;
            if (gVar != null) {
                gVar.dettachView(this);
                this.q = null;
                this.f45294f.setNextPage(this.f45298j);
                this.f45298j.C(getContext().getString(R.string.pb_load_more));
                this.f45298j.f();
                this.f45298j.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, Boolean.TRUE));
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.f45293e;
            if (bigdaySwipeRefreshLayout != null) {
                bigdaySwipeRefreshLayout.setVisibility(0);
            }
            c.a.r0.n1.d.b bVar = this.m;
            if (bVar != null) {
                bVar.b();
            }
        }
    }

    public final void c0() {
        c.a.q0.g0.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (hVar = this.r) == null) {
            return;
        }
        hVar.dettachView(this);
        this.r = null;
    }

    public void completePullRefresh() {
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bigdaySwipeRefreshLayout = this.f45293e) == null) {
            return;
        }
        bigdaySwipeRefreshLayout.interruptRefresh();
    }

    public final void d0() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (rightFloatLayerView = this.J) == null) {
            return;
        }
        rightFloatLayerView.setAutoCompleteShown(false);
        this.J.clearAnimation();
        this.J.setVisibility(8);
    }

    public void deleteGodReplyInThread(Long l2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, l2) == null) {
            this.n.X(l2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            super.dispatchDraw(canvas);
            if (this.v) {
                if (!this.y) {
                    this.y = true;
                }
                i0();
            }
        }
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.M = true;
            c.a.q0.t.c.g homeAdFloatViewItemData = TbSingleton.getInstance().getHomeAdFloatViewItemData();
            if (!((homeAdFloatViewItemData == null || homeAdFloatViewItemData.a()) ? false : o0(homeAdFloatViewItemData))) {
                d0();
                m0();
                return;
            }
            c.a.r0.e1.a.i().r();
        }
    }

    public final void f0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = new BdTypeRecyclerView(context);
            this.f45294f = bdTypeRecyclerView;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(bdTypeRecyclerView.getContext());
            this.G = linearLayoutManager;
            this.f45294f.setLayoutManager(linearLayoutManager);
            this.f45294f.setFadingEdgeLength(0);
            this.f45294f.setOverScrollMode(2);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.f45294f.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            c.a.r0.g0.r rVar = new c.a.r0.g0.r(context);
            this.z = rVar;
            rVar.setFrom("from_personaize");
            this.z.a().setVisibility(0);
            this.z.a().setOnClickListener(this.i0);
            if (TbSingleton.getInstance().isSlideAnimEnable() && !c.a.q0.b.d.x()) {
                c.a.d.m.e.l lVar = new c.a.d.m.e.l(new c.a.d.m.e.j());
                this.H = lVar;
                lVar.q(this.f45294f, 2);
            }
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = new BigdaySwipeRefreshLayout(context);
            this.f45293e = bigdaySwipeRefreshLayout;
            bigdaySwipeRefreshLayout.addView(this.f45294f);
            PbListView pbListView = new PbListView(context);
            this.f45298j = pbListView;
            pbListView.b();
            this.f45298j.p(R.color.transparent);
            this.f45298j.x();
            this.f45298j.E(SkinManager.getColor(R.color.CAM_X0107));
            this.f45298j.G(R.dimen.tbfontsize33);
            this.f45298j.A(R.color.CAM_X0110);
            this.f45298j.s(c.a.d.f.p.l.f(context, R.dimen.tbds182));
            this.f45298j.B(this.z0);
            this.f45298j.r();
            this.f45294f.setNextPage(this.f45298j);
            addView(this.f45293e);
            if (TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
                this.I = new FRSRefreshButton(context);
                int f2 = c.a.d.f.p.l.f(context, R.dimen.tbds170);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f2, f2);
                layoutParams.gravity = 85;
                layoutParams.rightMargin = c.a.d.f.p.l.f(context, R.dimen.tbds24);
                layoutParams.bottomMargin = c.a.d.f.p.l.f(context, R.dimen.tbds180);
                addView(this.I, layoutParams);
                this.I.setOnClickListener(this.B0);
                this.I.setVisibility(8);
            }
        }
    }

    public void forceReload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.r != null) {
                reload();
                return;
            }
            c.a.r0.n1.h.e eVar = this.n;
            if (eVar != null) {
                eVar.update();
            }
        }
    }

    public final boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            c.a.q0.g0.h hVar = this.r;
            if (hVar != null) {
                return hVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean getIsUnreadTipShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.B : invokeV.booleanValue;
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.r0.n1.d.a.d().j(System.currentTimeMillis(), 1);
            PbListView pbListView = this.f45298j;
            if (pbListView != null && !pbListView.m()) {
                this.f45298j.Q();
                this.f45298j.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            this.n.q0();
        }
    }

    public void hideRightFloatLayerView() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (rightFloatLayerView = this.J) == null) {
            return;
        }
        rightFloatLayerView.completeHide();
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (!this.x) {
                long f2 = c.a.r0.n1.d.a.d().f(1) + c.a.r0.n1.d.a.d().b();
                long a2 = c.a.r0.n1.d.a.d().a(1);
                if (a2 > 0) {
                    f2 = System.currentTimeMillis() - a2;
                }
                c.a.q0.r0.n nVar = new c.a.q0.r0.n();
                nVar.a();
                nVar.b();
                c.a.q0.r0.l.b().o(f2);
                if (this.w > 0) {
                    c.a.q0.r0.l.b().F(System.currentTimeMillis() - this.w);
                }
                c.a.q0.r0.l.b().J(nVar.c());
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.SECOND_DRAW_DISPATCH_STAMP_KEY);
                if (!MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW && !this.N) {
                    this.N = true;
                    SpeedStats.getInstance().onMainPageStatsEnd(getContext());
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921637, ""));
            }
            this.x = true;
        }
    }

    public void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, context) == null) {
            this.O = context;
            MessageManager.getInstance().registerListener(this.r0);
            MessageManager.getInstance().registerListener(this.q0);
            MessageManager.getInstance().registerListener(this.U);
            MessageManager.getInstance().registerListener(this.W);
            MessageManager.getInstance().registerListener(this.a0);
            MessageManager.getInstance().registerListener(this.isBigdayPullviewShowListener);
            MessageManager.getInstance().registerListener(this.A0);
            MessageManager.getInstance().registerListener(this.b0);
            MessageManager.getInstance().registerListener(this.C0);
            c.a.d.a.f<?> a2 = c.a.d.a.j.a(context);
            if (a2 instanceof TbPageContext) {
                this.l = (TbPageContext) a2;
            }
            c.a.q0.s.n.b.i().n(true);
            c.a.q0.s.n.a aVar = null;
            if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > c.a.q0.s.e0.b.j().l("key_bigday_next_showtime_home", 0L)) {
                aVar = c.a.q0.s.n.b.i().h(1);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            this.p = new c.a.r0.n1.h.k.f();
            c.a.r0.n1.h.h.d0 d0Var = new c.a.r0.n1.h.h.d0(context, this.f45294f);
            this.f45299k = d0Var;
            d0Var.x(this.p);
            this.f45299k.v(this.V);
            this.n = new c.a.r0.n1.h.e(this.l, this.f45294f, this.f45299k, this.f45293e);
            this.o = new c.a.r0.n1.h.a(this.l);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.C = c.a.q0.s.e0.b.j().k("show_is_uninterest_tag", 0);
        }
    }

    public void initListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f45299k.u(this.c0);
            this.f45299k.s(this.d0);
            this.n.N0(this.s0);
            this.o.i(this);
            initPullViewListeners();
            this.f45294f.addOnScrollListener(new n(this));
            this.f45294f.setOnSrollToBottomListener(new o(this));
            this.f45294f.setOnScrollStopDelayedListener(new p(this), 1L);
            this.f45294f.setRecyclerListener(new q(this));
            this.f45294f.removeOnScrollListener(this.g0);
            this.f45294f.addOnScrollListener(this.g0);
        }
    }

    public void initPullViewListeners() {
        h0 h0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (h0Var = this.f45297i) == null) {
            return;
        }
        h0Var.a(this.t0);
        this.f45297i.b(this.u0);
        this.f45297i.f(this.v0);
        this.f45297i.h(this.w0);
    }

    public final void j0() {
        c.a.r0.g0.r rVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || this.f45294f == null || (rVar = this.z) == null || rVar.b().getParent() != null || StringUtils.isNull(TbSingleton.getInstance().getLFUser()) || TbSingleton.getInstance().isAddBanner || this.S) {
            return;
        }
        this.z.d();
        this.z.b().setVisibility(0);
        this.z.f("1");
        this.f45294f.setHeaderView(this.z.b());
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || this.f45294f == null) {
            return;
        }
        if (this.A == null) {
            c.a.r0.g0.q qVar = new c.a.r0.g0.q(getContext());
            this.A = qVar;
            qVar.a().setOnClickListener(this.k0);
        }
        this.f45294f.setHeaderView(this.A.b());
        this.S = true;
        c.a.r0.n1.h.n.b.b();
        c.a.r0.g0.r rVar = this.z;
        if (rVar != null) {
            this.f45294f.removeHeaderView(rVar.b());
        }
    }

    public final void l0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z2) == null) {
            if (this.q == null) {
                this.q = new c.a.q0.g0.g(getContext());
                this.q.o(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + c.a.d.f.p.l.f(getContext(), R.dimen.tbds60));
                this.q.h();
                this.q.setWrapStyle(true);
                this.q.onChangeSkinType();
            }
            this.q.attachView(this, z2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, Boolean.FALSE));
            this.f45294f.setNextPage(null);
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.f45293e;
            if (bigdaySwipeRefreshLayout != null) {
                bigdaySwipeRefreshLayout.setVisibility(8);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921457, this.l.getUniqueId()));
        }
    }

    public final void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            c.a.d.f.m.e.a().post(new f(this));
        }
    }

    public final void n0(View view, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048597, this, view, str, z2) == null) {
            if (this.r == null) {
                this.r = new c.a.q0.g0.h(getContext(), new r(this));
            }
            this.r.attachView(view, z2);
            this.r.o();
        }
    }

    public void notifyJumpToLastReadPosition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.n.n0();
        }
    }

    public void notifyListViewDataSetChanged() {
        c.a.r0.n1.h.h.d0 d0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (d0Var = this.f45299k) == null) {
            return;
        }
        d0Var.m();
    }

    public final boolean o0(c.a.q0.t.c.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, gVar)) == null) {
            if (gVar == null) {
                return false;
            }
            this.J = RightFloatLayerLottieView.getRightFloatView(gVar, this.O);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = c.a.d.f.p.l.f(this.O, R.dimen.tbds306) + this.K;
            this.J.completeHide();
            addView(this.J, layoutParams);
            if (!RightFloatLayerView.isHomeNeedShow()) {
                hideRightFloatLayerView();
                return false;
            }
            this.J.setAutoCompleteShown(true);
            if (gVar.a()) {
                return false;
            }
            this.J.setData(gVar);
            this.J.setLogoListener(new g(this, gVar));
            this.J.setFeedBackListener(new h(this, gVar));
            return true;
        }
        return invokeL.booleanValue;
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            if (this.t != i2) {
                c.a.q0.g0.g gVar = this.q;
                if (gVar != null) {
                    gVar.onChangeSkinType();
                }
                c.a.q0.g0.h hVar = this.r;
                if (hVar != null) {
                    hVar.onChangeSkinType();
                }
                c.a.r0.n1.h.i.a aVar = this.f45296h;
                if (aVar != null) {
                    aVar.C(i2);
                }
                PbListView pbListView = this.f45298j;
                if (pbListView != null) {
                    pbListView.E(SkinManager.getColor(R.color.CAM_X0109));
                    this.f45298j.d(i2);
                }
                this.f45299k.n(i2);
                c.a.r0.n1.h.e eVar = this.n;
                if (eVar != null) {
                    eVar.v0(i2);
                }
                FRSRefreshButton fRSRefreshButton = this.I;
                if (fRSRefreshButton != null) {
                    fRSRefreshButton.onChangeSkinType(i2);
                }
                c.a.r0.g0.r rVar = this.z;
                if (rVar != null) {
                    rVar.e(i2);
                }
                RightFloatLayerView rightFloatLayerView = this.J;
                if (rightFloatLayerView != null) {
                    rightFloatLayerView.onChangeSkinType();
                }
                c.a.r0.g0.q qVar = this.A;
                if (qVar != null) {
                    qVar.d(i2);
                }
            }
            this.t = i2;
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.r0);
            MessageManager.getInstance().unRegisterListener(this.q0);
            MessageManager.getInstance().unRegisterListener(this.U);
            MessageManager.getInstance().unRegisterListener(this.W);
            MessageManager.getInstance().unRegisterListener(this.A0);
            MessageManager.getInstance().unRegisterListener(this.isBigdayPullviewShowListener);
            MessageManager.getInstance().unRegisterListener(this.a0);
            MessageManager.getInstance().unRegisterListener(this.b0);
            MessageManager.getInstance().unRegisterListener(this.C0);
            this.n.w0();
            this.f45299k.u(null);
            this.f45299k.o();
            this.n.N0(null);
            c.a.r0.n1.h.i.b bVar = this.f45295g;
            if (bVar != null) {
                bVar.a(null);
                this.f45295g.b(null);
                this.f45295g.f(null);
                this.f45295g.h(null);
                this.f45295g.B();
            }
            c.a.r0.n1.h.i.a aVar = this.f45296h;
            if (aVar != null) {
                aVar.a(null);
                this.f45296h.b(null);
                this.f45296h.f(null);
                this.f45296h.h(null);
                this.f45296h.T();
            }
            this.f45294f.setOnSrollToBottomListener(null);
            ScrollFragmentTabHost scrollFragmentTabHost = this.e0;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.removeShadowChangeListener(this.h0);
            }
            this.f45294f.removeOnScrollListener(this.g0);
            c.a.q0.g0.g gVar = this.q;
            if (gVar != null) {
                gVar.m();
            }
            this.f45294f.setRecyclerListener(null);
            c.a.r0.n1.h.a aVar2 = this.o;
            if (aVar2 != null) {
                aVar2.g();
            }
            c.a.q0.s.n.b.i().e();
            c.a.d.f.m.e.a().removeCallbacks(this.x0);
            c.a.r0.n1.h.k.a aVar3 = this.R;
            if (aVar3 != null) {
                aVar3.a();
            }
        }
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.n.z0();
            c.a.r0.n1.h.h.d0 d0Var = this.f45299k;
            if (d0Var != null) {
                d0Var.p();
            }
            RightFloatLayerView rightFloatLayerView = this.J;
            if (rightFloatLayerView == null || !(rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                return;
            }
            ((RightFloatLayerLottieView) rightFloatLayerView).onChangeStyleToUnFold(600);
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (this.u) {
                reload();
                this.u = false;
            }
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.f45293e;
            if (bigdaySwipeRefreshLayout != null) {
                bigdaySwipeRefreshLayout.resume();
            }
            c.a.r0.n1.h.h.d0 d0Var = this.f45299k;
            if (d0Var != null) {
                d0Var.q();
            }
        }
    }

    public void onViewBackGround() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            c.a.r0.n1.h.e eVar = this.n;
            if (eVar != null) {
                eVar.t0(true);
            }
            c.a.r0.g0.v.b().d(false);
            c.a.r0.t.d.c().h("page_recommend", "show_");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            c.a.d.f.m.e.a().removeCallbacks(this.x0);
        }
    }

    public boolean recyclerViewIsAtTop(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, recyclerView)) == null) ? recyclerView == null || !recyclerView.canScrollVertically(-1) : invokeL.booleanValue;
    }

    public void reload() {
        c.a.r0.n1.h.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            if (this.r != null && (eVar = this.n) != null) {
                eVar.update();
                return;
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.f45294f;
            if (bdTypeRecyclerView == null || this.f45293e == null) {
                return;
            }
            bdTypeRecyclerView.setSelection(0);
            if (!this.f45293e.isRefreshing()) {
                c.a.r0.n1.h.e eVar2 = this.n;
                if (eVar2 != null && eVar2.f0() != null) {
                    this.n.f0().w();
                    this.n.O0(false);
                }
                this.f45293e.setRefreshing(true);
            }
            ScrollFragmentTabHost.s sVar = this.h0;
            if (sVar != null) {
                sVar.b();
            }
        }
    }

    public void scrollToPositionFromMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.n.K0();
        }
    }

    public void setCallback(c.a.r0.n1.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, bVar) == null) {
            this.m = bVar;
        }
    }

    public void setIsUnreadTipShow(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z2) == null) {
            c.a.r0.n1.h.e eVar = this.n;
            if (eVar != null) {
                eVar.L0(!z2);
            }
            this.B = z2;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, bdUniqueId) == null) {
            c.a.r0.n1.h.h.d0 d0Var = this.f45299k;
            if (d0Var != null) {
                d0Var.w(bdUniqueId);
            }
            c.a.r0.n1.h.e eVar = this.n;
            if (eVar != null) {
                eVar.G0(bdUniqueId);
            }
            c.a.r0.n1.h.k.f fVar = this.p;
            if (fVar != null) {
                fVar.a(bdUniqueId);
            }
            c.a.r0.n1.h.i.a aVar = this.f45296h;
            if (aVar != null) {
                aVar.V(bdUniqueId);
            }
            c.a.q0.s.n.b.i().o(bdUniqueId);
            CustomMessageListener customMessageListener = this.y0;
            if (customMessageListener != null) {
                customMessageListener.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.y0);
            }
            c.a.r0.n1.h.a aVar2 = this.o;
            if (aVar2 != null) {
                aVar2.h(bdUniqueId);
            }
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, scrollFragmentTabHost) == null) {
            this.e0 = scrollFragmentTabHost;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.removeShadowChangeListener(this.h0);
                this.e0.addShadowChangeListener(this.h0);
            }
            c.a.r0.n1.h.e eVar = this.n;
            if (eVar != null) {
                eVar.P0(scrollFragmentTabHost);
            }
            c.a.r0.n1.h.a aVar = this.o;
            if (aVar != null) {
                aVar.j(scrollFragmentTabHost);
            }
        }
    }

    public void setTabInForeBackgroundState(boolean z2) {
        c.a.r0.n1.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048613, this, z2) == null) || (eVar = this.n) == null) {
            return;
        }
        eVar.Q0(z2);
    }

    public void setViewForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            setViewForeground(false);
            c.a.r0.n1.h.e eVar = this.n;
            if (eVar != null) {
                eVar.t0(false);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            if (this.C >= 1 || !TbadkCoreApplication.getInst().isNoInterestTag()) {
                return;
            }
            c.a.d.f.m.e.a().postDelayed(this.x0, 1000L);
        }
    }

    public void showActivityPrize() {
        c.a.r0.n1.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || (eVar = this.n) == null) {
            return;
        }
        eVar.R0();
    }

    public void showFirstLoadingView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || this.n == null) {
            return;
        }
        l0(true);
    }

    public void showRightFloatLayerView() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048618, this) == null) || (rightFloatLayerView = this.J) == null) {
            return;
        }
        rightFloatLayerView.completeShow();
    }

    public void startFirstLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            if (this.n != null) {
                l0(true);
                this.n.update();
            }
            if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
                c.a.q0.s.n.b.i().j();
                c.a.q0.s.n.b.i().k();
            }
        }
    }

    public void updateData(DataRes dataRes, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{dataRes, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            PbListView pbListView = this.f45298j;
            if (pbListView != null) {
                pbListView.C(getContext().getString(R.string.pb_load_more));
                this.f45298j.f();
                this.f45298j.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            this.n.x0(z2, z3, dataRes, 0, null);
        }
    }

    public void updateError(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048621, this, str, i2) == null) {
            PbListView pbListView = this.f45298j;
            if (pbListView != null) {
                pbListView.C(getContext().getString(R.string.pb_load_more));
                this.f45298j.f();
                this.f45298j.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            this.n.x0(true, false, null, i2, str);
        }
    }

    public void setViewForeground(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z2) == null) {
            c.a.r0.n1.h.e eVar = this.n;
            if (eVar != null) {
                eVar.A0(z2);
            }
            ScrollFragmentTabHost scrollFragmentTabHost = this.e0;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.removeShadowChangeListener(this.h0);
                this.e0.addShadowChangeListener(this.h0);
                this.h0.b();
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
        this.s = 0L;
        this.t = 3;
        this.u = false;
        this.v = false;
        this.w = -1L;
        this.x = false;
        this.y = false;
        this.B = false;
        this.C = 0;
        this.D = 0;
        this.E = false;
        this.F = 1;
        this.L = false;
        this.M = false;
        this.N = false;
        this.P = -1;
        this.Q = -1;
        this.S = false;
        this.U = new k(this, 2156674);
        this.V = new v(this);
        this.W = new a0(this, 2921456);
        this.a0 = new b0(this, 2921553);
        this.b0 = new c0(this, CmdConfigHttp.CMD_CHECK_INTEREST_COMMIT);
        this.c0 = new d0(this);
        this.d0 = new e0(this);
        this.f0 = -1;
        this.g0 = new f0(this);
        this.h0 = new g0(this);
        this.i0 = new a(this);
        this.k0 = new b(this);
        this.q0 = new c(this, 2001371);
        this.r0 = new d(this, 2921636);
        this.s0 = new e(this);
        this.t0 = new i(this);
        this.u0 = new j(this);
        this.v0 = new l(this);
        this.w0 = new m(this);
        this.x0 = new s(this);
        this.y0 = new t(this, 2001118);
        this.z0 = new u(this);
        this.A0 = new w(this, 2921033);
        this.isBigdayPullviewShowListener = new x(this, 2921349);
        this.B0 = new y(this);
        this.C0 = new z(this, 2921632);
        f0(context);
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
        this.s = 0L;
        this.t = 3;
        this.u = false;
        this.v = false;
        this.w = -1L;
        this.x = false;
        this.y = false;
        this.B = false;
        this.C = 0;
        this.D = 0;
        this.E = false;
        this.F = 1;
        this.L = false;
        this.M = false;
        this.N = false;
        this.P = -1;
        this.Q = -1;
        this.S = false;
        this.U = new k(this, 2156674);
        this.V = new v(this);
        this.W = new a0(this, 2921456);
        this.a0 = new b0(this, 2921553);
        this.b0 = new c0(this, CmdConfigHttp.CMD_CHECK_INTEREST_COMMIT);
        this.c0 = new d0(this);
        this.d0 = new e0(this);
        this.f0 = -1;
        this.g0 = new f0(this);
        this.h0 = new g0(this);
        this.i0 = new a(this);
        this.k0 = new b(this);
        this.q0 = new c(this, 2001371);
        this.r0 = new d(this, 2921636);
        this.s0 = new e(this);
        this.t0 = new i(this);
        this.u0 = new j(this);
        this.v0 = new l(this);
        this.w0 = new m(this);
        this.x0 = new s(this);
        this.y0 = new t(this, 2001118);
        this.z0 = new u(this);
        this.A0 = new w(this, 2921033);
        this.isBigdayPullviewShowListener = new x(this, 2921349);
        this.B0 = new y(this);
        this.C0 = new z(this, 2921632);
        f0(context);
    }
}
