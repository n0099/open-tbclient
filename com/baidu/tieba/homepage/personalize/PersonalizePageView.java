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
import b.a.q0.s.g0.f;
import b.a.q0.s.q.d2;
import b.a.q0.s.q.t0;
import b.a.q0.s.q.x0;
import b.a.r0.h1.h.e;
import b.a.r0.h1.h.h.d0;
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
import com.baidu.tbadk.core.util.PermissionUtil;
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
import com.baidu.tbadk.widget.RightFloatLayerView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.adapter.HomePageCardVideoViewHolder;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.homepage.personalize.data.CheckInterestCommitResponseMessage;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
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
/* loaded from: classes9.dex */
public class PersonalizePageView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b.a.r0.b0.q A;
    public View.OnClickListener A0;
    public boolean B;
    public CustomMessageListener B0;
    public int C;
    public int D;
    public boolean E;
    public int F;
    public LinearLayoutManager G;
    public b.a.e.m.e.l H;
    public FRSRefreshButton I;
    public RightFloatLayerView J;
    public int K;
    public boolean L;
    public boolean M;
    public boolean N;
    public Context O;
    public int P;
    public int Q;
    public b.a.r0.h1.h.k.a R;
    public boolean S;
    public Object T;
    public CustomMessageListener U;
    public d0.f V;
    public CustomMessageListener W;
    public CustomMessageListener a0;
    public HttpMessageListener b0;
    public NEGFeedBackView.b c0;

    /* renamed from: e  reason: collision with root package name */
    public BigdaySwipeRefreshLayout f50530e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f50531f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.r0.h1.h.i.b f50532g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.r0.h1.h.i.a f50533h;

    /* renamed from: i  reason: collision with root package name */
    public h0 f50534i;
    public FollowUserButton.a i0;
    public CustomMessageListener isBigdayPullviewShowListener;
    public PbListView j;
    public ScrollFragmentTabHost j0;
    public b.a.r0.h1.h.h.d0 k;
    public int k0;
    public TbPageContext<?> l;
    public RecyclerView.OnScrollListener l0;
    public b.a.r0.h1.d.b m;
    public ScrollFragmentTabHost.s m0;
    public b.a.r0.h1.h.e n;
    public View.OnClickListener n0;
    public b.a.r0.h1.h.a o;
    public View.OnClickListener o0;
    public b.a.r0.h1.h.k.f p;
    public CustomMessageListener p0;
    public b.a.q0.g0.g q;
    public CustomMessageListener q0;
    public b.a.q0.g0.h r;
    public e.l0 r0;
    public long s;
    public f.g s0;
    public int t;
    public f.h t0;
    public boolean u;
    public f.e u0;
    public boolean v;
    public f.InterfaceC0712f v0;
    public long w;
    public Runnable w0;
    public boolean x;
    public final CustomMessageListener x0;
    public boolean y;
    public View.OnClickListener y0;
    public b.a.r0.b0.r z;
    public CustomMessageListener z0;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f50535e;

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
            this.f50535e = personalizePageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f50535e.f50531f == null) {
                return;
            }
            this.f50535e.f50531f.removeHeaderView(this.f50535e.z.b());
        }
    }

    /* loaded from: classes9.dex */
    public class a0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f50536a;

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
            this.f50536a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (this.f50536a.n != null) {
                    this.f50536a.updateData(b.a.q0.s.v.a.b().c(), false, false);
                }
                this.f50536a.b0();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f50537e;

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
            this.f50537e = personalizePageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f50537e.f50531f != null && this.f50537e.A != null) {
                    this.f50537e.f50531f.removeHeaderView(this.f50537e.A.b());
                    this.f50537e.S = false;
                    b.a.r0.h1.h.n.b.a(2);
                    Activity currentActivity = TbadkApplication.getInst().getCurrentActivity();
                    if (currentActivity != null) {
                        new BdTopToast(currentActivity, 2000).setIcon(true).setContent(currentActivity.getString(R.string.recommend_card_interest_remove_hint)).show((ViewGroup) currentActivity.findViewById(16908290));
                    }
                }
                b.a.r0.h1.h.n.b.i();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f50538a;

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
            this.f50538a = personalizePageView;
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
                this.f50538a.K = ((Integer) data).intValue();
                if (this.f50538a.J != null) {
                    ((FrameLayout.LayoutParams) this.f50538a.J.getLayoutParams()).topMargin = b.a.e.f.p.l.g(this.f50538a.O, R.dimen.tbds1409) - this.f50538a.K;
                    this.f50538a.J.requestLayout();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f50539a;

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
            this.f50539a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (TbSingleton.getInstance().isAddBanner || !b.a.r0.h1.h.n.b.e()) {
                    this.f50539a.j0();
                } else if (this.f50539a.R == null) {
                    this.f50539a.R = new b.a.r0.h1.h.k.a();
                    this.f50539a.R.c();
                }
                PersonalizePageView personalizePageView = this.f50539a;
                personalizePageView.L = true;
                if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW || personalizePageView.M) {
                    return;
                }
                personalizePageView.e0();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c0 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f50540a;

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
            this.f50540a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003514 && (httpResponsedMessage instanceof CheckInterestCommitResponseMessage)) {
                CheckInterestCommitResponseMessage checkInterestCommitResponseMessage = (CheckInterestCommitResponseMessage) httpResponsedMessage;
                this.f50540a.P = checkInterestCommitResponseMessage.getFinishInterestStage();
                this.f50540a.Q = checkInterestCommitResponseMessage.getPersonalizedSwitchStatus();
                PersonalizePageView personalizePageView = this.f50540a;
                if (b.a.r0.h1.h.n.b.f(personalizePageView.P, personalizePageView.Q)) {
                    this.f50540a.k0();
                } else {
                    this.f50540a.j0();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f50541a;

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
            this.f50541a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            PersonalizePageView personalizePageView = this.f50541a;
            if (personalizePageView.L && !personalizePageView.M) {
                personalizePageView.e0();
            }
            if (this.f50541a.x) {
                PersonalizePageView personalizePageView2 = this.f50541a;
                if (personalizePageView2.N) {
                    return;
                }
                personalizePageView2.N = true;
                SpeedStats.getInstance().onMainPageStatsEnd(this.f50541a.getContext());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d0 implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f50542a;

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
            this.f50542a = personalizePageView;
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
            if (this.f50542a.k != null) {
                this.f50542a.k.m();
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

    /* loaded from: classes9.dex */
    public class e implements e.l0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f50543a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f50544b;

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
            this.f50544b = personalizePageView;
            this.f50543a = b.a.q0.s.e0.b.j().g("key_first_install", true);
        }

        @Override // b.a.r0.h1.h.e.l0
        public void a(int i2, b.a.q0.c1.e eVar, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), eVar, Integer.valueOf(i3)}) == null) {
                if (this.f50544b.m != null) {
                    boolean g0 = this.f50544b.g0();
                    this.f50544b.c0();
                    if (g0) {
                        this.f50544b.l0(true);
                    }
                    this.f50544b.m.c(i2, eVar, i3);
                    b.a.q0.a.r.g().s();
                    return;
                }
                PersonalizePageView personalizePageView = this.f50544b;
                personalizePageView.n0(personalizePageView, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                this.f50544b.b0();
            }
        }

        @Override // b.a.r0.h1.h.e.l0
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f50544b.j == null) {
                return;
            }
            this.f50544b.j.C(this.f50544b.getContext().getString(R.string.recommend_no_more_data));
            this.f50544b.j.f();
            this.f50544b.j.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }

        @Override // b.a.r0.h1.h.e.l0
        public void c(int i2, int i3, b.a.q0.c1.e eVar, int i4) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), eVar, Integer.valueOf(i4)}) == null) || this.f50544b.m == null) {
                return;
            }
            this.f50544b.m.d(i2, i3, eVar, i4);
        }

        @Override // b.a.r0.h1.h.e.l0
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                e();
                this.f50544b.f50530e.setVisibility(0);
                this.f50544b.b0();
                this.f50544b.c0();
                if (PermissionUtil.checkLocationForGoogle(this.f50544b.getContext())) {
                    MercatorModel.d().f();
                }
                this.f50544b.v = true;
                if (z) {
                    this.f50544b.w = System.currentTimeMillis();
                }
            }
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f50543a) {
                this.f50543a = false;
                b.a.q0.s.e0.b.j().t("key_first_install", false);
            }
        }

        @Override // b.a.r0.h1.h.e.l0
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048581, this, i2, str) == null) {
                this.f50544b.b0();
                if (i2 == 1) {
                    if (b.a.e.f.p.j.z()) {
                        this.f50544b.l.showToast(str);
                    }
                    e();
                } else if (!this.f50543a) {
                    this.f50544b.f50530e.setVisibility(8);
                    PersonalizePageView personalizePageView = this.f50544b;
                    personalizePageView.n0(personalizePageView, str, true);
                } else {
                    e();
                    this.f50544b.startFirstLoad();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e0 implements FollowUserButton.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f50545a;

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
            this.f50545a = personalizePageView;
        }

        @Override // com.baidu.tbadk.core.view.FollowUserButton.a
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            Object tag = view.getTag();
            if (tag instanceof d2) {
                TiebaStatic.log(b.a.r0.l3.a.m("c13696", (d2) tag));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f50546e;

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
            this.f50546e = personalizePageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f50546e.l == null) {
                return;
            }
            b.a.r0.y0.a.i().w(this.f50546e.l.getPageActivity());
        }
    }

    /* loaded from: classes9.dex */
    public class f0 extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f50547a;

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
            this.f50547a = personalizePageView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) || this.f50547a.k0 == i2 || this.f50547a.j0 == null) {
                return;
            }
            this.f50547a.k0 = i2;
            if (this.f50547a.k0 == 1) {
                this.f50547a.j0.showShadow();
            } else if (this.f50547a.recyclerViewIsAtTop(recyclerView)) {
                this.f50547a.j0.dismissShadow();
            } else {
                this.f50547a.j0.showShadow();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.t.c.g f50548e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f50549f;

        public g(PersonalizePageView personalizePageView, b.a.q0.t.c.g gVar) {
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
            this.f50549f = personalizePageView;
            this.f50548e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f50548e == null || this.f50549f.J == null) {
                return;
            }
            this.f50549f.J.doLink(this.f50548e);
            this.f50549f.J.setAutoCompleteShown(false);
        }
    }

    /* loaded from: classes9.dex */
    public class g0 extends ScrollFragmentTabHost.s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f50550a;

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
            this.f50550a = personalizePageView;
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.s
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f50550a.j0 == null) {
                return;
            }
            this.f50550a.k0 = -1;
            PersonalizePageView personalizePageView = this.f50550a;
            if (personalizePageView.recyclerViewIsAtTop(personalizePageView.f50531f)) {
                this.f50550a.j0.dismissShadow();
            } else {
                this.f50550a.j0.showShadow();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.t.c.g f50551e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f50552f;

        public h(PersonalizePageView personalizePageView, b.a.q0.t.c.g gVar) {
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
            this.f50552f = personalizePageView;
            this.f50551e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f50552f.J.inHomeLastCloseTime();
                this.f50552f.hideRightFloatLayerView();
                this.f50552f.J.reportClickCloseAd(this.f50551e);
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface h0 {
        void a(f.g gVar);

        void b(f.h hVar);

        void f(f.e eVar);

        void h(f.InterfaceC0712f interfaceC0712f);
    }

    /* loaded from: classes9.dex */
    public class i implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f50553e;

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
            this.f50553e = personalizePageView;
        }

        @Override // b.a.q0.s.g0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                b.a.r0.p.d.c().f("page_recommend");
                this.f50553e.n.update();
                this.f50553e.n.O0(false);
                this.f50553e.E = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j implements f.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f50554a;

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
            this.f50554a = personalizePageView;
        }

        @Override // b.a.q0.s.g0.f.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f50554a.n == null || this.f50554a.n.f0() == null) {
                return;
            }
            this.f50554a.n.f0().w();
        }
    }

    /* loaded from: classes9.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f50555a;

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
            this.f50555a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (this.f50555a.H == null) {
                        this.f50555a.H = new b.a.e.m.e.l(new b.a.e.m.e.j());
                    }
                    this.f50555a.H.q(this.f50555a.f50531f, 2);
                } else if (this.f50555a.H != null) {
                    this.f50555a.H.w();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class l implements f.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f50556a;

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
            this.f50556a = personalizePageView;
        }

        @Override // b.a.q0.s.g0.f.e
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f50556a.E) {
                this.f50556a.D = 0;
                this.f50556a.F = 1;
                this.f50556a.E = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class m implements f.InterfaceC0712f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f50557a;

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
            this.f50557a = personalizePageView;
        }

        @Override // b.a.q0.s.g0.f.InterfaceC0712f
        public void a(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                if (this.f50557a.n != null) {
                    this.f50557a.n.O0(true);
                    this.f50557a.n.F0();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, Boolean.TRUE));
                b.a.q0.s.n.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > b.a.q0.s.e0.b.j().l("key_bigday_next_showtime_home", 0L)) {
                    aVar = b.a.q0.s.n.b.i().h(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class n extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f50558a;

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
            this.f50558a = personalizePageView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                if (this.f50558a.G != null && i2 == 0) {
                    int height = ((WindowManager) this.f50558a.getContext().getSystemService("window")).getDefaultDisplay().getHeight() * 3;
                    if (this.f50558a.D < height || this.f50558a.F != 1) {
                        if (this.f50558a.D < height && this.f50558a.F == 2) {
                            this.f50558a.F = 1;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        }
                    } else {
                        this.f50558a.F = 2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(this.f50558a.F)));
                    }
                    if (this.f50558a.G.getItemCount() - this.f50558a.G.findLastVisibleItemPosition() <= 15) {
                        this.f50558a.h0();
                    }
                }
                if (i2 == 0) {
                    if (this.f50558a.J != null) {
                        this.f50558a.J.onScrollIdle();
                    }
                    if (this.f50558a.T != null) {
                        BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(this.f50558a.T);
                        this.f50558a.T = null;
                    }
                } else if (i2 == 1) {
                    if (this.f50558a.T == null) {
                        this.f50558a.T = BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect("home", "1", "scroll");
                    }
                    if (this.f50558a.J != null) {
                        this.f50558a.J.onScrollDragging();
                    }
                } else if (i2 == 2) {
                    if (this.f50558a.T == null) {
                        this.f50558a.T = BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect("home", "1", "scroll");
                    }
                    if (this.f50558a.J != null) {
                        this.f50558a.J.onScrollSettling();
                    }
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                this.f50558a.D += i3;
                if (this.f50558a.I != null) {
                    b.a.e.m.e.n item = this.f50558a.f50531f.getItem(this.f50558a.G.findLastVisibleItemPosition());
                    if (item instanceof b.a.r0.b0.f0.k) {
                        if (((b.a.r0.b0.f0.k) item).position >= 6) {
                            this.f50558a.I.show();
                        } else {
                            this.f50558a.I.hide();
                        }
                    }
                }
                if (!b.a.q0.b.d.w() || TbadkCoreApplication.isLogin() || b.a.q0.s.e0.b.j().k("home_page_login_dialog_show_key", 0) != 0 || this.f50558a.D < b.a.e.f.p.l.p(TbadkCoreApplication.getInst().getContext())[1] * 2) {
                    return;
                }
                b.a.q0.s.e0.b.j().v("home_page_login_dialog_show_key", 1);
                DialogLoginHelper.checkUpIsLogin(new t0(this.f50558a.O, "new_shouye"));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class o implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f50559e;

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
            this.f50559e = personalizePageView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f50559e.h0();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class p implements BdListView.o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f50560a;

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
            this.f50560a = personalizePageView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.o
        public void onScrollStop(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || System.currentTimeMillis() - this.f50560a.s < 5000) {
                return;
            }
            this.f50560a.n.E0(i2, i3);
        }
    }

    /* loaded from: classes9.dex */
    public class q implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f50561a;

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
            this.f50561a = personalizePageView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || viewHolder == null || (view = viewHolder.itemView) == null) {
                return;
            }
            if (this.f50561a.n != null && this.f50561a.n.f0() != null) {
                this.f50561a.n.f0().k(view);
            }
            if (view.getTag() instanceof HomePageCardVideoViewHolder) {
                ((HomePageCardVideoViewHolder) view.getTag()).getCardView().stopPlay();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f50562e;

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
            this.f50562e = personalizePageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f50562e.n == null) {
                return;
            }
            this.f50562e.n.update();
        }
    }

    /* loaded from: classes9.dex */
    public class s implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f50563e;

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
            this.f50563e = personalizePageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f50563e.l == null) {
                return;
            }
            b.a.q0.s.e0.b.j().v("show_is_uninterest_tag", PersonalizePageView.L(this.f50563e));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(this.f50563e.l.getContext(), 2)));
        }
    }

    /* loaded from: classes9.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f50564a;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ t f50565e;

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
                this.f50565e = tVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f50565e.f50564a.notifyListViewDataSetChanged();
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
            this.f50564a = personalizePageView;
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
                    b.a.e.f.m.e.a().postDelayed(new a(this), TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class u implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f50566e;

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
            this.f50566e = personalizePageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f50566e.h0();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class v implements d0.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f50567a;

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
            this.f50567a = personalizePageView;
        }

        @Override // b.a.r0.h1.h.h.d0.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (TbSingleton.getInstance().isAddBanner) {
                    if (this.f50567a.f50531f != null && this.f50567a.z != null) {
                        this.f50567a.f50531f.removeHeaderView(this.f50567a.z.b());
                    }
                    if (this.f50567a.f50531f == null || this.f50567a.A == null) {
                        return;
                    }
                    this.f50567a.f50531f.removeHeaderView(this.f50567a.A.b());
                    return;
                }
                if (b.a.r0.h1.h.n.b.e()) {
                    PersonalizePageView personalizePageView = this.f50567a;
                    if (personalizePageView.P == -1 && personalizePageView.Q == -1) {
                        return;
                    }
                }
                this.f50567a.j0();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class w extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f50568a;

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
            this.f50568a = personalizePageView;
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
            this.f50568a.u = true;
        }
    }

    /* loaded from: classes9.dex */
    public class x extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f50569a;

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
            this.f50569a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f50569a.f50530e == null || this.f50569a.f50530e.isRefreshing()) {
                return;
            }
            if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof b.a.q0.s.n.a))) {
                if (this.f50569a.f50533h != null) {
                    if (this.f50569a.f50534i == this.f50569a.f50533h) {
                        return;
                    }
                    PersonalizePageView personalizePageView = this.f50569a;
                    personalizePageView.f50534i = personalizePageView.f50533h;
                } else {
                    PersonalizePageView personalizePageView2 = this.f50569a;
                    personalizePageView2.f50533h = new b.a.r0.h1.h.i.a(personalizePageView2.l);
                    this.f50569a.f50533h.C(this.f50569a.t);
                    PersonalizePageView personalizePageView3 = this.f50569a;
                    personalizePageView3.f50534i = personalizePageView3.f50533h;
                    this.f50569a.initPullViewListeners();
                }
                this.f50569a.f50533h.v(true);
                this.f50569a.f50530e.setProgressView(this.f50569a.f50533h);
                int i2 = (int) (this.f50569a.getResources().getDisplayMetrics().density * 86.0f);
                this.f50569a.f50530e.setCustomDistances(i2, i2, i2 * 2);
                return;
            }
            b.a.q0.s.n.a aVar = (b.a.q0.s.n.a) customResponsedMessage.getData();
            if (this.f50569a.f50532g != null) {
                if (this.f50569a.f50534i == this.f50569a.f50532g && aVar.equals(this.f50569a.f50532g.A())) {
                    return;
                }
                PersonalizePageView personalizePageView4 = this.f50569a;
                personalizePageView4.f50534i = personalizePageView4.f50532g;
            } else {
                PersonalizePageView personalizePageView5 = this.f50569a;
                personalizePageView5.f50532g = new b.a.r0.h1.h.i.b(personalizePageView5.l.getContext());
                PersonalizePageView personalizePageView6 = this.f50569a;
                personalizePageView6.f50534i = personalizePageView6.f50532g;
                this.f50569a.initPullViewListeners();
            }
            this.f50569a.f50532g.v(true);
            this.f50569a.f50530e.setProgressView(this.f50569a.f50532g);
            this.f50569a.f50532g.D(aVar);
            this.f50569a.f50530e.setCustomDistances((int) this.f50569a.getResources().getDimension(R.dimen.tbds236), (int) (b.a.e.f.p.l.i(this.f50569a.l.getContext()) * 0.8d), b.a.e.f.p.l.i(this.f50569a.l.getContext()));
        }
    }

    /* loaded from: classes9.dex */
    public class y implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f50570e;

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
            this.f50570e = personalizePageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f50570e.I == null) {
                return;
            }
            this.f50570e.I.hide();
            this.f50570e.reload();
        }
    }

    /* loaded from: classes9.dex */
    public class z extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f50571a;

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
            this.f50571a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f50571a.forceReload();
                if (this.f50571a.f50531f != null && this.f50571a.A != null) {
                    this.f50571a.f50531f.removeHeaderView(this.f50571a.A.b());
                }
                Activity c2 = b.a.e.a.b.g().c("MainTabActivity");
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
        this.i0 = new e0(this);
        this.k0 = -1;
        this.l0 = new f0(this);
        this.m0 = new g0(this);
        this.n0 = new a(this);
        this.o0 = new b(this);
        this.p0 = new c(this, 2001371);
        this.q0 = new d(this, 2921636);
        this.r0 = new e(this);
        this.s0 = new i(this);
        this.t0 = new j(this);
        this.u0 = new l(this);
        this.v0 = new m(this);
        this.w0 = new s(this);
        this.x0 = new t(this, 2001118);
        this.y0 = new u(this);
        this.z0 = new w(this, 2921033);
        this.isBigdayPullviewShowListener = new x(this, 2921349);
        this.A0 = new y(this);
        this.B0 = new z(this, 2921632);
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
            b.a.q0.g0.g gVar = this.q;
            if (gVar != null) {
                gVar.dettachView(this);
                this.q = null;
                this.f50531f.setNextPage(this.j);
                this.j.C(getContext().getString(R.string.pb_load_more));
                this.j.f();
                this.j.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, Boolean.TRUE));
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.f50530e;
            if (bigdaySwipeRefreshLayout != null) {
                bigdaySwipeRefreshLayout.setVisibility(0);
            }
            b.a.r0.h1.d.b bVar = this.m;
            if (bVar != null) {
                bVar.b();
            }
        }
    }

    public final void c0() {
        b.a.q0.g0.h hVar;
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bigdaySwipeRefreshLayout = this.f50530e) == null) {
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
            b.a.q0.t.c.g homeAdFloatViewItemData = TbSingleton.getInstance().getHomeAdFloatViewItemData();
            if (!((homeAdFloatViewItemData == null || homeAdFloatViewItemData.a()) ? false : o0(homeAdFloatViewItemData))) {
                d0();
                m0();
                return;
            }
            b.a.r0.y0.a.i().r();
        }
    }

    public final void f0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = new BdTypeRecyclerView(context);
            this.f50531f = bdTypeRecyclerView;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(bdTypeRecyclerView.getContext());
            this.G = linearLayoutManager;
            this.f50531f.setLayoutManager(linearLayoutManager);
            this.f50531f.setFadingEdgeLength(0);
            this.f50531f.setOverScrollMode(2);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.f50531f.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            b.a.r0.b0.r rVar = new b.a.r0.b0.r(context);
            this.z = rVar;
            rVar.setFrom("from_personaize");
            this.z.a().setVisibility(0);
            this.z.a().setOnClickListener(this.n0);
            if (TbSingleton.getInstance().isSlideAnimEnable()) {
                b.a.e.m.e.l lVar = new b.a.e.m.e.l(new b.a.e.m.e.j());
                this.H = lVar;
                lVar.q(this.f50531f, 2);
            }
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = new BigdaySwipeRefreshLayout(context);
            this.f50530e = bigdaySwipeRefreshLayout;
            bigdaySwipeRefreshLayout.addView(this.f50531f);
            PbListView pbListView = new PbListView(context);
            this.j = pbListView;
            pbListView.b();
            this.j.p(R.color.transparent);
            this.j.x();
            this.j.E(SkinManager.getColor(R.color.CAM_X0107));
            this.j.G(R.dimen.tbfontsize33);
            this.j.A(R.color.CAM_X0110);
            this.j.s(b.a.e.f.p.l.g(context, R.dimen.tbds182));
            this.j.B(this.y0);
            this.j.r();
            this.f50531f.setNextPage(this.j);
            addView(this.f50530e);
            if (TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
                this.I = new FRSRefreshButton(context);
                int g2 = b.a.e.f.p.l.g(context, R.dimen.tbds170);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g2, g2);
                layoutParams.gravity = 85;
                layoutParams.rightMargin = b.a.e.f.p.l.g(context, R.dimen.tbds24);
                layoutParams.bottomMargin = b.a.e.f.p.l.g(context, R.dimen.tbds180);
                addView(this.I, layoutParams);
                this.I.setOnClickListener(this.A0);
                this.I.setVisibility(8);
            }
            this.J = new RightFloatLayerView(context);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 53;
            layoutParams2.topMargin = b.a.e.f.p.l.g(context, R.dimen.tbds1409) - this.K;
            this.J.completeHide();
            addView(this.J, layoutParams2);
        }
    }

    public void forceReload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.r != null) {
                reload();
                return;
            }
            b.a.r0.h1.h.e eVar = this.n;
            if (eVar != null) {
                eVar.update();
            }
        }
    }

    public final boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            b.a.q0.g0.h hVar = this.r;
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
            b.a.r0.h1.d.a.d().j(System.currentTimeMillis(), 1);
            PbListView pbListView = this.j;
            if (pbListView != null && !pbListView.m()) {
                this.j.Q();
                this.j.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
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
                long f2 = b.a.r0.h1.d.a.d().f(1) + b.a.r0.h1.d.a.d().b();
                long a2 = b.a.r0.h1.d.a.d().a(1);
                if (a2 > 0) {
                    f2 = System.currentTimeMillis() - a2;
                }
                b.a.q0.q0.n nVar = new b.a.q0.q0.n();
                nVar.a();
                nVar.b();
                b.a.q0.q0.l.b().o(f2);
                if (this.w > 0) {
                    b.a.q0.q0.l.b().I(System.currentTimeMillis() - this.w);
                }
                b.a.q0.q0.l.b().M(nVar.c());
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
            MessageManager.getInstance().registerListener(this.q0);
            MessageManager.getInstance().registerListener(this.p0);
            MessageManager.getInstance().registerListener(this.U);
            MessageManager.getInstance().registerListener(this.W);
            MessageManager.getInstance().registerListener(this.a0);
            MessageManager.getInstance().registerListener(this.isBigdayPullviewShowListener);
            MessageManager.getInstance().registerListener(this.z0);
            MessageManager.getInstance().registerListener(this.b0);
            MessageManager.getInstance().registerListener(this.B0);
            b.a.e.a.f<?> a2 = b.a.e.a.j.a(context);
            if (a2 instanceof TbPageContext) {
                this.l = (TbPageContext) a2;
            }
            b.a.q0.s.n.b.i().n(true);
            b.a.q0.s.n.a aVar = null;
            if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > b.a.q0.s.e0.b.j().l("key_bigday_next_showtime_home", 0L)) {
                aVar = b.a.q0.s.n.b.i().h(1);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            this.p = new b.a.r0.h1.h.k.f();
            b.a.r0.h1.h.h.d0 d0Var = new b.a.r0.h1.h.h.d0(context, this.f50531f);
            this.k = d0Var;
            d0Var.x(this.p);
            this.k.v(this.V);
            this.n = new b.a.r0.h1.h.e(this.l, this.f50531f, this.k, this.f50530e);
            this.o = new b.a.r0.h1.h.a(this.l);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.C = b.a.q0.s.e0.b.j().k("show_is_uninterest_tag", 0);
        }
    }

    public void initListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.k.u(this.c0);
            this.k.s(this.i0);
            this.n.N0(this.r0);
            this.o.i(this);
            initPullViewListeners();
            this.f50531f.addOnScrollListener(new n(this));
            this.f50531f.setOnSrollToBottomListener(new o(this));
            this.f50531f.setOnScrollStopDelayedListener(new p(this), 1L);
            this.f50531f.setRecyclerListener(new q(this));
            this.f50531f.removeOnScrollListener(this.l0);
            this.f50531f.addOnScrollListener(this.l0);
        }
    }

    public void initPullViewListeners() {
        h0 h0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (h0Var = this.f50534i) == null) {
            return;
        }
        h0Var.a(this.s0);
        this.f50534i.b(this.t0);
        this.f50534i.f(this.u0);
        this.f50534i.h(this.v0);
    }

    public final void j0() {
        b.a.r0.b0.r rVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || this.f50531f == null || (rVar = this.z) == null || rVar.b().getParent() != null || StringUtils.isNull(TbSingleton.getInstance().getLFUser()) || TbSingleton.getInstance().isAddBanner || this.S) {
            return;
        }
        this.z.d();
        this.z.b().setVisibility(0);
        this.z.f("1");
        this.f50531f.setHeaderView(this.z.b());
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || this.f50531f == null) {
            return;
        }
        if (this.A == null) {
            b.a.r0.b0.q qVar = new b.a.r0.b0.q(getContext());
            this.A = qVar;
            qVar.a().setOnClickListener(this.o0);
        }
        this.f50531f.setHeaderView(this.A.b());
        this.S = true;
        b.a.r0.h1.h.n.b.b();
        b.a.r0.b0.r rVar = this.z;
        if (rVar != null) {
            this.f50531f.removeHeaderView(rVar.b());
        }
    }

    public final void l0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z2) == null) {
            if (this.q == null) {
                this.q = new b.a.q0.g0.g(getContext());
                this.q.o(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + b.a.e.f.p.l.g(getContext(), R.dimen.tbds60));
                this.q.h();
                this.q.setWrapStyle(true);
                this.q.onChangeSkinType();
            }
            this.q.attachView(this, z2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, Boolean.FALSE));
            this.f50531f.setNextPage(null);
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.f50530e;
            if (bigdaySwipeRefreshLayout != null) {
                bigdaySwipeRefreshLayout.setVisibility(8);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921457, this.l.getUniqueId()));
        }
    }

    public final void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            b.a.e.f.m.e.a().post(new f(this));
        }
    }

    public final void n0(View view, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048597, this, view, str, z2) == null) {
            if (this.r == null) {
                this.r = new b.a.q0.g0.h(getContext(), new r(this));
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
        b.a.r0.h1.h.h.d0 d0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (d0Var = this.k) == null) {
            return;
        }
        d0Var.m();
    }

    public final boolean o0(b.a.q0.t.c.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, gVar)) == null) {
            if (this.J == null || gVar == null) {
                return false;
            }
            if (!RightFloatLayerView.isHomeNeedShow()) {
                hideRightFloatLayerView();
                return false;
            }
            this.J.setAutoCompleteShown(true);
            if (StringUtils.isNull(gVar.f14550f)) {
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
                b.a.q0.g0.g gVar = this.q;
                if (gVar != null) {
                    gVar.onChangeSkinType();
                }
                b.a.q0.g0.h hVar = this.r;
                if (hVar != null) {
                    hVar.onChangeSkinType();
                }
                b.a.r0.h1.h.i.a aVar = this.f50533h;
                if (aVar != null) {
                    aVar.C(i2);
                }
                PbListView pbListView = this.j;
                if (pbListView != null) {
                    pbListView.E(SkinManager.getColor(R.color.CAM_X0109));
                    this.j.d(i2);
                }
                this.k.n(i2);
                b.a.r0.h1.h.e eVar = this.n;
                if (eVar != null) {
                    eVar.v0(i2);
                }
                FRSRefreshButton fRSRefreshButton = this.I;
                if (fRSRefreshButton != null) {
                    fRSRefreshButton.onChangeSkinType(i2);
                }
                b.a.r0.b0.r rVar = this.z;
                if (rVar != null) {
                    rVar.e(i2);
                }
                RightFloatLayerView rightFloatLayerView = this.J;
                if (rightFloatLayerView != null) {
                    rightFloatLayerView.onChangeSkinType();
                }
                b.a.r0.b0.q qVar = this.A;
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
            MessageManager.getInstance().unRegisterListener(this.q0);
            MessageManager.getInstance().unRegisterListener(this.p0);
            MessageManager.getInstance().unRegisterListener(this.U);
            MessageManager.getInstance().unRegisterListener(this.W);
            MessageManager.getInstance().unRegisterListener(this.z0);
            MessageManager.getInstance().unRegisterListener(this.isBigdayPullviewShowListener);
            MessageManager.getInstance().unRegisterListener(this.a0);
            MessageManager.getInstance().unRegisterListener(this.b0);
            MessageManager.getInstance().unRegisterListener(this.B0);
            this.n.w0();
            this.k.u(null);
            this.k.o();
            this.n.N0(null);
            b.a.r0.h1.h.i.b bVar = this.f50532g;
            if (bVar != null) {
                bVar.a(null);
                this.f50532g.b(null);
                this.f50532g.f(null);
                this.f50532g.h(null);
                this.f50532g.B();
            }
            b.a.r0.h1.h.i.a aVar = this.f50533h;
            if (aVar != null) {
                aVar.a(null);
                this.f50533h.b(null);
                this.f50533h.f(null);
                this.f50533h.h(null);
                this.f50533h.S();
            }
            this.f50531f.setOnSrollToBottomListener(null);
            ScrollFragmentTabHost scrollFragmentTabHost = this.j0;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.removeShadowChangeListener(this.m0);
            }
            this.f50531f.removeOnScrollListener(this.l0);
            b.a.q0.g0.g gVar = this.q;
            if (gVar != null) {
                gVar.m();
            }
            this.f50531f.setRecyclerListener(null);
            b.a.r0.h1.h.a aVar2 = this.o;
            if (aVar2 != null) {
                aVar2.g();
            }
            b.a.q0.s.n.b.i().e();
            b.a.e.f.m.e.a().removeCallbacks(this.w0);
            b.a.r0.h1.h.k.a aVar3 = this.R;
            if (aVar3 != null) {
                aVar3.a();
            }
        }
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.n.z0();
            b.a.r0.h1.h.h.d0 d0Var = this.k;
            if (d0Var != null) {
                d0Var.p();
            }
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (this.u) {
                reload();
                this.u = false;
            }
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.f50530e;
            if (bigdaySwipeRefreshLayout != null) {
                bigdaySwipeRefreshLayout.resume();
            }
            b.a.r0.h1.h.h.d0 d0Var = this.k;
            if (d0Var != null) {
                d0Var.q();
            }
        }
    }

    public void onViewBackGround() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            b.a.r0.h1.h.e eVar = this.n;
            if (eVar != null) {
                eVar.t0(true);
            }
            b.a.r0.b0.v.b().d(false);
            b.a.r0.p.d.c().h("page_recommend", "show_");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            b.a.e.f.m.e.a().removeCallbacks(this.w0);
        }
    }

    public boolean recyclerViewIsAtTop(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, recyclerView)) == null) ? recyclerView == null || !recyclerView.canScrollVertically(-1) : invokeL.booleanValue;
    }

    public void reload() {
        b.a.r0.h1.h.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            if (this.r != null && (eVar = this.n) != null) {
                eVar.update();
                return;
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.f50531f;
            if (bdTypeRecyclerView == null || this.f50530e == null) {
                return;
            }
            bdTypeRecyclerView.setSelection(0);
            if (!this.f50530e.isRefreshing()) {
                b.a.r0.h1.h.e eVar2 = this.n;
                if (eVar2 != null && eVar2.f0() != null) {
                    this.n.f0().w();
                    this.n.O0(false);
                }
                this.f50530e.setRefreshing(true);
            }
            ScrollFragmentTabHost.s sVar = this.m0;
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

    public void setCallback(b.a.r0.h1.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, bVar) == null) {
            this.m = bVar;
        }
    }

    public void setIsUnreadTipShow(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z2) == null) {
            b.a.r0.h1.h.e eVar = this.n;
            if (eVar != null) {
                eVar.L0(!z2);
            }
            this.B = z2;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, bdUniqueId) == null) {
            b.a.r0.h1.h.h.d0 d0Var = this.k;
            if (d0Var != null) {
                d0Var.w(bdUniqueId);
            }
            b.a.r0.h1.h.e eVar = this.n;
            if (eVar != null) {
                eVar.G0(bdUniqueId);
            }
            b.a.r0.h1.h.k.f fVar = this.p;
            if (fVar != null) {
                fVar.a(bdUniqueId);
            }
            b.a.r0.h1.h.i.a aVar = this.f50533h;
            if (aVar != null) {
                aVar.U(bdUniqueId);
            }
            b.a.q0.s.n.b.i().o(bdUniqueId);
            CustomMessageListener customMessageListener = this.x0;
            if (customMessageListener != null) {
                customMessageListener.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.x0);
            }
            b.a.r0.h1.h.a aVar2 = this.o;
            if (aVar2 != null) {
                aVar2.h(bdUniqueId);
            }
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, scrollFragmentTabHost) == null) {
            this.j0 = scrollFragmentTabHost;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.removeShadowChangeListener(this.m0);
                this.j0.addShadowChangeListener(this.m0);
            }
            b.a.r0.h1.h.e eVar = this.n;
            if (eVar != null) {
                eVar.P0(scrollFragmentTabHost);
            }
            b.a.r0.h1.h.a aVar = this.o;
            if (aVar != null) {
                aVar.j(scrollFragmentTabHost);
            }
        }
    }

    public void setTabInForeBackgroundState(boolean z2) {
        b.a.r0.h1.h.e eVar;
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
            b.a.r0.h1.h.e eVar = this.n;
            if (eVar != null) {
                eVar.t0(false);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            if (this.C >= 1 || !TbadkCoreApplication.getInst().isNoInterestTag()) {
                return;
            }
            b.a.e.f.m.e.a().postDelayed(this.w0, 1000L);
        }
    }

    public void showActivityPrize() {
        b.a.r0.h1.h.e eVar;
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
                b.a.q0.s.n.b.i().j();
                b.a.q0.s.n.b.i().k();
            }
        }
    }

    public void updateData(DataRes dataRes, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{dataRes, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            PbListView pbListView = this.j;
            if (pbListView != null) {
                pbListView.C(getContext().getString(R.string.pb_load_more));
                this.j.f();
                this.j.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            this.n.x0(z2, z3, dataRes, 0, null);
        }
    }

    public void updateError(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048621, this, str, i2) == null) {
            PbListView pbListView = this.j;
            if (pbListView != null) {
                pbListView.C(getContext().getString(R.string.pb_load_more));
                this.j.f();
                this.j.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            this.n.x0(true, false, null, i2, str);
        }
    }

    public void setViewForeground(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z2) == null) {
            b.a.r0.h1.h.e eVar = this.n;
            if (eVar != null) {
                eVar.A0(z2);
            }
            ScrollFragmentTabHost scrollFragmentTabHost = this.j0;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.removeShadowChangeListener(this.m0);
                this.j0.addShadowChangeListener(this.m0);
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
        this.i0 = new e0(this);
        this.k0 = -1;
        this.l0 = new f0(this);
        this.m0 = new g0(this);
        this.n0 = new a(this);
        this.o0 = new b(this);
        this.p0 = new c(this, 2001371);
        this.q0 = new d(this, 2921636);
        this.r0 = new e(this);
        this.s0 = new i(this);
        this.t0 = new j(this);
        this.u0 = new l(this);
        this.v0 = new m(this);
        this.w0 = new s(this);
        this.x0 = new t(this, 2001118);
        this.y0 = new u(this);
        this.z0 = new w(this, 2921033);
        this.isBigdayPullviewShowListener = new x(this, 2921349);
        this.A0 = new y(this);
        this.B0 = new z(this, 2921632);
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
        this.i0 = new e0(this);
        this.k0 = -1;
        this.l0 = new f0(this);
        this.m0 = new g0(this);
        this.n0 = new a(this);
        this.o0 = new b(this);
        this.p0 = new c(this, 2001371);
        this.q0 = new d(this, 2921636);
        this.r0 = new e(this);
        this.s0 = new i(this);
        this.t0 = new j(this);
        this.u0 = new l(this);
        this.v0 = new m(this);
        this.w0 = new s(this);
        this.x0 = new t(this, 2001118);
        this.y0 = new u(this);
        this.z0 = new w(this, 2921033);
        this.isBigdayPullviewShowListener = new x(this, 2921349);
        this.A0 = new y(this);
        this.B0 = new z(this, 2921632);
        f0(context);
    }
}
