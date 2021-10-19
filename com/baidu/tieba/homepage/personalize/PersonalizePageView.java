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
import c.a.q0.s.f0.f;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.t0;
import c.a.q0.s.q.x0;
import c.a.r0.h1.h.e;
import c.a.r0.h1.h.h.c0;
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
import com.baidu.searchbox.performance.speed.SpeedStats;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.ThirdStatisticHelper;
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
/* loaded from: classes7.dex */
public class PersonalizePageView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.b0.p A;
    public boolean B;
    public int C;
    public int D;
    public boolean E;
    public int F;
    public LinearLayoutManager G;
    public c.a.e.l.e.l H;
    public FRSRefreshButton I;
    public RightFloatLayerView J;
    public c.a.q0.t.c.f K;
    public int L;
    public Context M;
    public int N;
    public int O;
    public c.a.r0.h1.h.k.a P;
    public boolean Q;
    public CustomMessageListener R;
    public c0.f S;
    public CustomMessageListener T;
    public CustomMessageListener U;
    public HttpMessageListener V;
    public NEGFeedBackView.b W;
    public FollowUserButton.a a0;
    public ScrollFragmentTabHost b0;
    public int c0;

    /* renamed from: e  reason: collision with root package name */
    public BigdaySwipeRefreshLayout f52320e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f52321f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.h1.h.i.b f52322g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.h1.h.i.a f52323h;

    /* renamed from: i  reason: collision with root package name */
    public h0 f52324i;
    public RecyclerView.OnScrollListener i0;
    public CustomMessageListener isBigdayPullviewShowListener;

    /* renamed from: j  reason: collision with root package name */
    public PbListView f52325j;
    public ScrollFragmentTabHost.s j0;
    public c.a.r0.h1.h.h.c0 k;
    public View.OnClickListener k0;
    public TbPageContext<?> l;
    public View.OnClickListener l0;
    public c.a.r0.h1.d.b m;
    public CustomMessageListener m0;
    public c.a.r0.h1.h.e n;
    public e.l0 n0;
    public c.a.r0.h1.h.a o;
    public f.g o0;
    public c.a.r0.h1.h.k.f p;
    public f.h p0;
    public c.a.q0.g0.g q;
    public f.e q0;
    public c.a.q0.g0.h r;
    public f.InterfaceC0681f r0;
    public long s;
    public Runnable s0;
    public int t;
    public final CustomMessageListener t0;
    public boolean u;
    public View.OnClickListener u0;
    public boolean v;
    public CustomMessageListener v0;
    public long w;
    public View.OnClickListener w0;
    public boolean x;
    public CustomMessageListener x0;
    public boolean y;
    public c.a.r0.b0.q z;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52326e;

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
            this.f52326e = personalizePageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f52326e.f52321f == null) {
                return;
            }
            this.f52326e.f52321f.removeHeaderView(this.f52326e.z.b());
        }
    }

    /* loaded from: classes7.dex */
    public class a0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52327a;

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
            this.f52327a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (this.f52327a.n != null) {
                    this.f52327a.updateData(c.a.q0.s.v.a.b().c(), false, false);
                }
                this.f52327a.b0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52328e;

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
            this.f52328e = personalizePageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f52328e.f52321f != null && this.f52328e.A != null) {
                    this.f52328e.f52321f.removeHeaderView(this.f52328e.A.b());
                    this.f52328e.Q = false;
                    c.a.r0.h1.h.n.a.a(2);
                    Activity currentActivity = TbadkApplication.getInst().getCurrentActivity();
                    if (currentActivity != null) {
                        new BdTopToast(currentActivity, 2000).setIcon(true).setContent(currentActivity.getString(R.string.recommend_card_interest_remove_hint)).show((ViewGroup) currentActivity.findViewById(16908290));
                    }
                }
                c.a.r0.h1.h.n.a.i();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52329a;

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
            this.f52329a = personalizePageView;
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
                this.f52329a.L = ((Integer) data).intValue();
                if (this.f52329a.J != null) {
                    ((FrameLayout.LayoutParams) this.f52329a.J.getLayoutParams()).topMargin = c.a.e.e.p.l.g(this.f52329a.M, R.dimen.tbds1409) - this.f52329a.L;
                    this.f52329a.J.requestLayout();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52330a;

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
            this.f52330a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (TbSingleton.getInstance().isAddBanner || !c.a.r0.h1.h.n.a.e()) {
                    this.f52330a.k0();
                } else if (this.f52330a.P == null) {
                    this.f52330a.P = new c.a.r0.h1.h.k.a();
                    this.f52330a.P.c();
                }
                this.f52330a.e0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c0 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52331a;

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
            this.f52331a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003514 && (httpResponsedMessage instanceof CheckInterestCommitResponseMessage)) {
                CheckInterestCommitResponseMessage checkInterestCommitResponseMessage = (CheckInterestCommitResponseMessage) httpResponsedMessage;
                this.f52331a.N = checkInterestCommitResponseMessage.getFinishInterestStage();
                this.f52331a.O = checkInterestCommitResponseMessage.getPersonalizedSwitchStatus();
                PersonalizePageView personalizePageView = this.f52331a;
                if (c.a.r0.h1.h.n.a.f(personalizePageView.N, personalizePageView.O)) {
                    this.f52331a.l0();
                } else {
                    this.f52331a.k0();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements e.l0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f52332a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52333b;

        public d(PersonalizePageView personalizePageView) {
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
            this.f52333b = personalizePageView;
            this.f52332a = c.a.q0.s.d0.b.j().g("key_first_install", true);
        }

        @Override // c.a.r0.h1.h.e.l0
        public void a(int i2, c.a.q0.d1.e eVar, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), eVar, Integer.valueOf(i3)}) == null) {
                if (this.f52333b.m != null) {
                    boolean g0 = this.f52333b.g0();
                    this.f52333b.c0();
                    if (g0) {
                        this.f52333b.m0(true);
                    }
                    this.f52333b.m.c(i2, eVar, i3);
                    c.a.q0.a.r.g().s();
                    return;
                }
                PersonalizePageView personalizePageView = this.f52333b;
                personalizePageView.o0(personalizePageView, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                this.f52333b.b0();
            }
        }

        @Override // c.a.r0.h1.h.e.l0
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f52333b.f52325j == null) {
                return;
            }
            this.f52333b.f52325j.A(this.f52333b.getContext().getString(R.string.recommend_no_more_data));
            this.f52333b.f52325j.f();
            this.f52333b.f52325j.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }

        @Override // c.a.r0.h1.h.e.l0
        public void c(int i2, int i3, c.a.q0.d1.e eVar, int i4) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), eVar, Integer.valueOf(i4)}) == null) || this.f52333b.m == null) {
                return;
            }
            this.f52333b.m.d(i2, i3, eVar, i4);
        }

        @Override // c.a.r0.h1.h.e.l0
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                e();
                this.f52333b.f52320e.setVisibility(0);
                this.f52333b.b0();
                this.f52333b.c0();
                if (PermissionUtil.checkLocationForGoogle(this.f52333b.getContext())) {
                    MercatorModel.d().f();
                }
                this.f52333b.v = true;
                if (z) {
                    this.f52333b.w = System.currentTimeMillis();
                }
            }
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f52332a) {
                this.f52332a = false;
                c.a.q0.s.d0.b.j().t("key_first_install", false);
            }
        }

        @Override // c.a.r0.h1.h.e.l0
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048581, this, i2, str) == null) {
                this.f52333b.b0();
                if (i2 == 1) {
                    if (c.a.e.e.p.j.z()) {
                        this.f52333b.l.showToast(str);
                    }
                    e();
                } else if (!this.f52332a) {
                    this.f52333b.f52320e.setVisibility(8);
                    PersonalizePageView personalizePageView = this.f52333b;
                    personalizePageView.o0(personalizePageView, str, true);
                } else {
                    e();
                    this.f52333b.startFirstLoad();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d0 implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52334a;

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
            this.f52334a = personalizePageView;
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
            if (this.f52334a.k != null) {
                this.f52334a.k.m();
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

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52335e;

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
            this.f52335e = personalizePageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f52335e.l == null) {
                return;
            }
            c.a.r0.y0.a.i().w(this.f52335e.l.getPageActivity());
        }
    }

    /* loaded from: classes7.dex */
    public class e0 implements FollowUserButton.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52336a;

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
            this.f52336a = personalizePageView;
        }

        @Override // com.baidu.tbadk.core.view.FollowUserButton.a
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            Object tag = view.getTag();
            if (tag instanceof d2) {
                TiebaStatic.log(c.a.r0.j3.a.m("c13696", (d2) tag));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f52337e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52338f;

        public f(PersonalizePageView personalizePageView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizePageView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52338f = personalizePageView;
            this.f52337e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f52338f.K == null) {
                return;
            }
            this.f52338f.J.inHomeLastCloseTime();
            if (!UtilHelper.isMatchScheme(this.f52338f.M, this.f52338f.K.d(), this.f52338f.K.c()) && !StringUtils.isNull(this.f52337e)) {
                this.f52338f.h0(this.f52337e);
            }
            this.f52338f.J.setAutoCompleteShown(false);
            this.f52338f.hideRightFloatLayerView();
            TiebaStatic.log(new StatisticItem("c14129").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", 1).param("obj_param1", 0));
            ThirdStatisticHelper.sendReq(this.f52338f.K.a());
        }
    }

    /* loaded from: classes7.dex */
    public class f0 extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52339a;

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
            this.f52339a = personalizePageView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) || this.f52339a.c0 == i2 || this.f52339a.b0 == null) {
                return;
            }
            this.f52339a.c0 = i2;
            if (this.f52339a.c0 == 1) {
                this.f52339a.b0.showShadow();
            } else if (this.f52339a.recyclerViewIsAtTop(recyclerView)) {
                this.f52339a.b0.dismissShadow();
            } else {
                this.f52339a.b0.showShadow();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52340e;

        public g(PersonalizePageView personalizePageView) {
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
            this.f52340e = personalizePageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f52340e.J.inHomeLastCloseTime();
                this.f52340e.hideRightFloatLayerView();
                TiebaStatic.log(new StatisticItem("c14129").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_param1", 1).param("obj_locate", 1));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g0 extends ScrollFragmentTabHost.s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52341a;

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
            this.f52341a = personalizePageView;
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.s
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f52341a.b0 == null) {
                return;
            }
            this.f52341a.c0 = -1;
            PersonalizePageView personalizePageView = this.f52341a;
            if (personalizePageView.recyclerViewIsAtTop(personalizePageView.f52321f)) {
                this.f52341a.b0.dismissShadow();
            } else {
                this.f52341a.b0.showShadow();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52342e;

        public h(PersonalizePageView personalizePageView) {
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
            this.f52342e = personalizePageView;
        }

        @Override // c.a.q0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                c.a.r0.p.d.c().f("page_recommend");
                this.f52342e.n.V0();
                this.f52342e.n.O0(false);
                this.f52342e.E = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface h0 {
        void a(f.g gVar);

        void b(f.h hVar);

        void f(f.e eVar);

        void h(f.InterfaceC0681f interfaceC0681f);
    }

    /* loaded from: classes7.dex */
    public class i implements f.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52343a;

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
            this.f52343a = personalizePageView;
        }

        @Override // c.a.q0.s.f0.f.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f52343a.n == null || this.f52343a.n.f0() == null) {
                return;
            }
            this.f52343a.n.f0().w();
        }
    }

    /* loaded from: classes7.dex */
    public class j implements f.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52344a;

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
            this.f52344a = personalizePageView;
        }

        @Override // c.a.q0.s.f0.f.e
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f52344a.E) {
                this.f52344a.D = 0;
                this.f52344a.F = 1;
                this.f52344a.E = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52345a;

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
            this.f52345a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (this.f52345a.H == null) {
                        this.f52345a.H = new c.a.e.l.e.l(new c.a.e.l.e.j());
                    }
                    this.f52345a.H.q(this.f52345a.f52321f, 2);
                } else if (this.f52345a.H != null) {
                    this.f52345a.H.w();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements f.InterfaceC0681f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52346a;

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
            this.f52346a = personalizePageView;
        }

        @Override // c.a.q0.s.f0.f.InterfaceC0681f
        public void a(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                if (this.f52346a.n != null) {
                    this.f52346a.n.O0(true);
                    this.f52346a.n.F0();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, Boolean.TRUE));
                c.a.q0.s.n.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > c.a.q0.s.d0.b.j().l("key_bigday_next_showtime_home", 0L)) {
                    aVar = c.a.q0.s.n.b.i().h(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52347a;

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
            this.f52347a = personalizePageView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                if (this.f52347a.G != null && i2 == 0) {
                    int height = ((WindowManager) this.f52347a.getContext().getSystemService("window")).getDefaultDisplay().getHeight() * 3;
                    if (this.f52347a.D < height || this.f52347a.F != 1) {
                        if (this.f52347a.D < height && this.f52347a.F == 2) {
                            this.f52347a.F = 1;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        }
                    } else {
                        this.f52347a.F = 2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(this.f52347a.F)));
                    }
                    if (this.f52347a.G.getItemCount() - this.f52347a.G.findLastVisibleItemPosition() <= 15) {
                        this.f52347a.i0();
                    }
                }
                if (i2 == 0) {
                    if (this.f52347a.J != null) {
                        this.f52347a.J.onScrollIdle();
                    }
                } else if (i2 == 1) {
                    if (this.f52347a.J != null) {
                        this.f52347a.J.onScrollDragging();
                    }
                } else if (i2 != 2 || this.f52347a.J == null) {
                } else {
                    this.f52347a.J.onScrollSettling();
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                this.f52347a.D += i3;
                if (this.f52347a.I != null) {
                    c.a.e.l.e.n item = this.f52347a.f52321f.getItem(this.f52347a.G.findLastVisibleItemPosition());
                    if (item instanceof c.a.r0.b0.e0.k) {
                        if (((c.a.r0.b0.e0.k) item).position >= 6) {
                            this.f52347a.I.show();
                        } else {
                            this.f52347a.I.hide();
                        }
                    }
                }
                if (!c.a.q0.b.d.w() || TbadkCoreApplication.isLogin() || c.a.q0.s.d0.b.j().k("home_page_login_dialog_show_key", 0) != 0 || this.f52347a.D < c.a.e.e.p.l.p(TbadkCoreApplication.getInst().getContext())[1] * 2) {
                    return;
                }
                c.a.q0.s.d0.b.j().v("home_page_login_dialog_show_key", 1);
                DialogLoginHelper.checkUpIsLogin(new t0(this.f52347a.M, "new_shouye"));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52348e;

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
            this.f52348e = personalizePageView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f52348e.i0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements BdListView.o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52349a;

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
            this.f52349a = personalizePageView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.o
        public void onScrollStop(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || System.currentTimeMillis() - this.f52349a.s < 5000) {
                return;
            }
            this.f52349a.n.E0(i2, i3);
        }
    }

    /* loaded from: classes7.dex */
    public class p implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52350a;

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
            this.f52350a = personalizePageView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || viewHolder == null || (view = viewHolder.itemView) == null) {
                return;
            }
            if (this.f52350a.n != null && this.f52350a.n.f0() != null) {
                this.f52350a.n.f0().k(view);
            }
            if (view.getTag() instanceof HomePageCardVideoViewHolder) {
                ((HomePageCardVideoViewHolder) view.getTag()).getCardView().stopPlay();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52351e;

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
            this.f52351e = personalizePageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f52351e.n == null) {
                return;
            }
            this.f52351e.n.V0();
        }
    }

    /* loaded from: classes7.dex */
    public class r implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52352e;

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
            this.f52352e = personalizePageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f52352e.l == null) {
                return;
            }
            c.a.q0.s.d0.b.j().v("show_is_uninterest_tag", PersonalizePageView.K(this.f52352e));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(this.f52352e.l.getContext(), 2)));
        }
    }

    /* loaded from: classes7.dex */
    public class s implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52353e;

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
            this.f52353e = personalizePageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f52353e.j0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52354a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ t f52355e;

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
                this.f52355e = tVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f52355e.f52354a.notifyListViewDataSetChanged();
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
            this.f52354a = personalizePageView;
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
                    c.a.e.e.m.e.a().postDelayed(new a(this), TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52356e;

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
            this.f52356e = personalizePageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f52356e.i0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v implements c0.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52357a;

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
            this.f52357a = personalizePageView;
        }

        @Override // c.a.r0.h1.h.h.c0.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (TbSingleton.getInstance().isAddBanner) {
                    if (this.f52357a.f52321f != null && this.f52357a.z != null) {
                        this.f52357a.f52321f.removeHeaderView(this.f52357a.z.b());
                    }
                    if (this.f52357a.f52321f == null || this.f52357a.A == null) {
                        return;
                    }
                    this.f52357a.f52321f.removeHeaderView(this.f52357a.A.b());
                    return;
                }
                if (c.a.r0.h1.h.n.a.e()) {
                    PersonalizePageView personalizePageView = this.f52357a;
                    if (personalizePageView.N == -1 && personalizePageView.O == -1) {
                        return;
                    }
                }
                this.f52357a.k0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52358a;

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
            this.f52358a = personalizePageView;
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
            this.f52358a.u = true;
        }
    }

    /* loaded from: classes7.dex */
    public class x extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52359a;

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
            this.f52359a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f52359a.f52320e == null || this.f52359a.f52320e.isRefreshing()) {
                return;
            }
            if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof c.a.q0.s.n.a))) {
                if (this.f52359a.f52323h != null) {
                    if (this.f52359a.f52324i == this.f52359a.f52323h) {
                        return;
                    }
                    PersonalizePageView personalizePageView = this.f52359a;
                    personalizePageView.f52324i = personalizePageView.f52323h;
                } else {
                    PersonalizePageView personalizePageView2 = this.f52359a;
                    personalizePageView2.f52323h = new c.a.r0.h1.h.i.a(personalizePageView2.l);
                    this.f52359a.f52323h.D(this.f52359a.t);
                    PersonalizePageView personalizePageView3 = this.f52359a;
                    personalizePageView3.f52324i = personalizePageView3.f52323h;
                    this.f52359a.initPullViewListeners();
                }
                this.f52359a.f52323h.w(true);
                this.f52359a.f52320e.setProgressView(this.f52359a.f52323h);
                int i2 = (int) (this.f52359a.getResources().getDisplayMetrics().density * 86.0f);
                this.f52359a.f52320e.setCustomDistances(i2, i2, i2 * 2);
                return;
            }
            c.a.q0.s.n.a aVar = (c.a.q0.s.n.a) customResponsedMessage.getData();
            if (this.f52359a.f52322g != null) {
                if (this.f52359a.f52324i == this.f52359a.f52322g && aVar.equals(this.f52359a.f52322g.B())) {
                    return;
                }
                PersonalizePageView personalizePageView4 = this.f52359a;
                personalizePageView4.f52324i = personalizePageView4.f52322g;
            } else {
                PersonalizePageView personalizePageView5 = this.f52359a;
                personalizePageView5.f52322g = new c.a.r0.h1.h.i.b(personalizePageView5.l.getContext());
                PersonalizePageView personalizePageView6 = this.f52359a;
                personalizePageView6.f52324i = personalizePageView6.f52322g;
                this.f52359a.initPullViewListeners();
            }
            this.f52359a.f52322g.w(true);
            this.f52359a.f52320e.setProgressView(this.f52359a.f52322g);
            this.f52359a.f52322g.E(aVar);
            this.f52359a.f52320e.setCustomDistances((int) this.f52359a.getResources().getDimension(R.dimen.tbds236), (int) (c.a.e.e.p.l.i(this.f52359a.l.getContext()) * 0.8d), c.a.e.e.p.l.i(this.f52359a.l.getContext()));
        }
    }

    /* loaded from: classes7.dex */
    public class y implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52360e;

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
            this.f52360e = personalizePageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f52360e.I == null) {
                return;
            }
            this.f52360e.I.hide();
            this.f52360e.reload();
        }
    }

    /* loaded from: classes7.dex */
    public class z extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52361a;

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
            this.f52361a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f52361a.forceReload();
                if (this.f52361a.f52321f != null && this.f52361a.A != null) {
                    this.f52361a.f52321f.removeHeaderView(this.f52361a.A.b());
                }
                Activity c2 = c.a.e.a.b.g().c("MainTabActivity");
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
        this.N = -1;
        this.O = -1;
        this.Q = false;
        this.R = new k(this, 2156674);
        this.S = new v(this);
        this.T = new a0(this, 2921456);
        this.U = new b0(this, 2921553);
        this.V = new c0(this, CmdConfigHttp.CMD_CHECK_INTEREST_COMMIT);
        this.W = new d0(this);
        this.a0 = new e0(this);
        this.c0 = -1;
        this.i0 = new f0(this);
        this.j0 = new g0(this);
        this.k0 = new a(this);
        this.l0 = new b(this);
        this.m0 = new c(this, 2001371);
        this.n0 = new d(this);
        this.o0 = new h(this);
        this.p0 = new i(this);
        this.q0 = new j(this);
        this.r0 = new l(this);
        this.s0 = new r(this);
        this.t0 = new t(this, 2001118);
        this.u0 = new u(this);
        this.v0 = new w(this, 2921033);
        this.isBigdayPullviewShowListener = new x(this, 2921349);
        this.w0 = new y(this);
        this.x0 = new z(this, 2921632);
        f0(context);
    }

    public static /* synthetic */ int K(PersonalizePageView personalizePageView) {
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
                this.f52321f.setNextPage(this.f52325j);
                this.f52325j.A(getContext().getString(R.string.pb_load_more));
                this.f52325j.f();
                this.f52325j.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, Boolean.TRUE));
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.f52320e;
            if (bigdaySwipeRefreshLayout != null) {
                bigdaySwipeRefreshLayout.setVisibility(0);
            }
            c.a.r0.h1.d.b bVar = this.m;
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bigdaySwipeRefreshLayout = this.f52320e) == null) {
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
                post(new s(this));
            }
        }
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (!(TbSingleton.getInstance().isShowRightFloatView(0) ? p0() : false)) {
                d0();
                n0();
                return;
            }
            c.a.r0.y0.a.i().r();
        }
    }

    public final void f0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = new BdTypeRecyclerView(context);
            this.f52321f = bdTypeRecyclerView;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(bdTypeRecyclerView.getContext());
            this.G = linearLayoutManager;
            this.f52321f.setLayoutManager(linearLayoutManager);
            this.f52321f.setFadingEdgeLength(0);
            this.f52321f.setOverScrollMode(2);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.f52321f.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            c.a.r0.b0.q qVar = new c.a.r0.b0.q(context);
            this.z = qVar;
            qVar.setFrom("from_personaize");
            this.z.a().setVisibility(0);
            this.z.a().setOnClickListener(this.k0);
            if (TbSingleton.getInstance().isSlideAnimEnable()) {
                c.a.e.l.e.l lVar = new c.a.e.l.e.l(new c.a.e.l.e.j());
                this.H = lVar;
                lVar.q(this.f52321f, 2);
            }
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = new BigdaySwipeRefreshLayout(context);
            this.f52320e = bigdaySwipeRefreshLayout;
            bigdaySwipeRefreshLayout.addView(this.f52321f);
            PbListView pbListView = new PbListView(context);
            this.f52325j = pbListView;
            pbListView.b();
            this.f52325j.o(R.color.transparent);
            this.f52325j.v();
            this.f52325j.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f52325j.E(R.dimen.tbfontsize33);
            this.f52325j.y(R.color.CAM_X0110);
            this.f52325j.r(c.a.e.e.p.l.g(context, R.dimen.tbds182));
            this.f52325j.z(this.u0);
            this.f52325j.q();
            this.f52321f.setNextPage(this.f52325j);
            addView(this.f52320e);
            if (TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
                this.I = new FRSRefreshButton(context);
                int g2 = c.a.e.e.p.l.g(context, R.dimen.tbds170);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g2, g2);
                layoutParams.gravity = 85;
                layoutParams.rightMargin = c.a.e.e.p.l.g(context, R.dimen.tbds24);
                layoutParams.bottomMargin = c.a.e.e.p.l.g(context, R.dimen.tbds180);
                addView(this.I, layoutParams);
                this.I.setOnClickListener(this.w0);
                this.I.setVisibility(8);
            }
            this.J = new RightFloatLayerView(context);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 53;
            layoutParams2.topMargin = c.a.e.e.p.l.g(context, R.dimen.tbds1409) - this.L;
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
            c.a.r0.h1.h.e eVar = this.n;
            if (eVar != null) {
                eVar.V0();
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

    public final void h0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.l.getContext(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
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
            c.a.r0.h1.d.a.d().j(System.currentTimeMillis(), 1);
            PbListView pbListView = this.f52325j;
            if (pbListView != null && !pbListView.l()) {
                this.f52325j.O();
                this.f52325j.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            this.n.q0();
        }
    }

    public void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, context) == null) {
            this.M = context;
            MessageManager.getInstance().registerListener(this.m0);
            MessageManager.getInstance().registerListener(this.R);
            MessageManager.getInstance().registerListener(this.T);
            MessageManager.getInstance().registerListener(this.U);
            MessageManager.getInstance().registerListener(this.isBigdayPullviewShowListener);
            MessageManager.getInstance().registerListener(this.v0);
            MessageManager.getInstance().registerListener(this.V);
            MessageManager.getInstance().registerListener(this.x0);
            c.a.e.a.f<?> a2 = c.a.e.a.j.a(context);
            if (a2 instanceof TbPageContext) {
                this.l = (TbPageContext) a2;
            }
            c.a.q0.s.n.b.i().n(true);
            c.a.q0.s.n.a aVar = null;
            if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > c.a.q0.s.d0.b.j().l("key_bigday_next_showtime_home", 0L)) {
                aVar = c.a.q0.s.n.b.i().h(1);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            this.p = new c.a.r0.h1.h.k.f();
            c.a.r0.h1.h.h.c0 c0Var = new c.a.r0.h1.h.h.c0(context, this.f52321f);
            this.k = c0Var;
            c0Var.x(this.p);
            this.k.v(this.S);
            this.n = new c.a.r0.h1.h.e(this.l, this.f52321f, this.k, this.f52320e);
            this.o = new c.a.r0.h1.h.a(this.l);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.C = c.a.q0.s.d0.b.j().k("show_is_uninterest_tag", 0);
        }
    }

    public void initListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.k.u(this.W);
            this.k.s(this.a0);
            this.n.N0(this.n0);
            this.o.i(this);
            initPullViewListeners();
            this.f52321f.addOnScrollListener(new m(this));
            this.f52321f.setOnSrollToBottomListener(new n(this));
            this.f52321f.setOnScrollStopDelayedListener(new o(this), 1L);
            this.f52321f.setRecyclerListener(new p(this));
            this.f52321f.removeOnScrollListener(this.i0);
            this.f52321f.addOnScrollListener(this.i0);
        }
    }

    public void initPullViewListeners() {
        h0 h0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (h0Var = this.f52324i) == null) {
            return;
        }
        h0Var.a(this.o0);
        this.f52324i.b(this.p0);
        this.f52324i.f(this.q0);
        this.f52324i.h(this.r0);
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (!this.x) {
                long f2 = c.a.r0.h1.d.a.d().f(1) + c.a.r0.h1.d.a.d().b();
                long a2 = c.a.r0.h1.d.a.d().a(1);
                if (a2 > 0) {
                    f2 = System.currentTimeMillis() - a2;
                }
                c.a.q0.q0.n nVar = new c.a.q0.q0.n();
                nVar.a();
                nVar.b();
                c.a.q0.q0.l.b().o(f2);
                if (this.w > 0) {
                    c.a.q0.q0.l.b().I(System.currentTimeMillis() - this.w);
                }
                c.a.q0.q0.l.b().M(nVar.c());
                SpeedStats.getInstance().onMainPageStatsEnd(getContext());
            }
            this.x = true;
        }
    }

    public final void k0() {
        c.a.r0.b0.q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || this.f52321f == null || (qVar = this.z) == null || qVar.b().getParent() != null || StringUtils.isNull(TbSingleton.getInstance().getLFUser()) || TbSingleton.getInstance().isAddBanner || this.Q) {
            return;
        }
        this.z.d();
        this.z.b().setVisibility(0);
        this.z.f("1");
        this.f52321f.setHeaderView(this.z.b());
    }

    public final void l0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || this.f52321f == null) {
            return;
        }
        if (this.A == null) {
            c.a.r0.b0.p pVar = new c.a.r0.b0.p(getContext());
            this.A = pVar;
            pVar.a().setOnClickListener(this.l0);
        }
        this.f52321f.setHeaderView(this.A.b());
        this.Q = true;
        c.a.r0.h1.h.n.a.b();
        c.a.r0.b0.q qVar = this.z;
        if (qVar != null) {
            this.f52321f.removeHeaderView(qVar.b());
        }
    }

    public final void m0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z2) == null) {
            if (this.q == null) {
                this.q = new c.a.q0.g0.g(getContext());
                this.q.o(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + c.a.e.e.p.l.g(getContext(), R.dimen.tbds60));
                this.q.h();
                this.q.setWrapStyle(true);
                this.q.onChangeSkinType();
            }
            this.q.attachView(this, z2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, Boolean.FALSE));
            this.f52321f.setNextPage(null);
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.f52320e;
            if (bigdaySwipeRefreshLayout != null) {
                bigdaySwipeRefreshLayout.setVisibility(8);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921457, this.l.getUniqueId()));
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            c.a.e.e.m.e.a().post(new e(this));
        }
    }

    public void notifyJumpToLastReadPosition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.n.n0();
        }
    }

    public void notifyListViewDataSetChanged() {
        c.a.r0.h1.h.h.c0 c0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (c0Var = this.k) == null) {
            return;
        }
        c0Var.m();
    }

    public final void o0(View view, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048600, this, view, str, z2) == null) {
            if (this.r == null) {
                this.r = new c.a.q0.g0.h(getContext(), new q(this));
            }
            this.r.attachView(view, z2);
            this.r.o();
        }
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
                c.a.r0.h1.h.i.a aVar = this.f52323h;
                if (aVar != null) {
                    aVar.D(i2);
                }
                PbListView pbListView = this.f52325j;
                if (pbListView != null) {
                    pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
                    this.f52325j.d(i2);
                }
                this.k.n(i2);
                c.a.r0.h1.h.e eVar = this.n;
                if (eVar != null) {
                    eVar.v0(i2);
                }
                FRSRefreshButton fRSRefreshButton = this.I;
                if (fRSRefreshButton != null) {
                    fRSRefreshButton.onChangeSkinType(i2);
                }
                c.a.r0.b0.q qVar = this.z;
                if (qVar != null) {
                    qVar.e(i2);
                }
                RightFloatLayerView rightFloatLayerView = this.J;
                if (rightFloatLayerView != null) {
                    rightFloatLayerView.onChangeSkinType();
                }
                c.a.r0.b0.p pVar = this.A;
                if (pVar != null) {
                    pVar.d(i2);
                }
            }
            this.t = i2;
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.m0);
            MessageManager.getInstance().unRegisterListener(this.R);
            MessageManager.getInstance().unRegisterListener(this.T);
            MessageManager.getInstance().unRegisterListener(this.v0);
            MessageManager.getInstance().unRegisterListener(this.isBigdayPullviewShowListener);
            MessageManager.getInstance().unRegisterListener(this.U);
            MessageManager.getInstance().unRegisterListener(this.V);
            MessageManager.getInstance().unRegisterListener(this.x0);
            this.n.w0();
            this.k.u(null);
            this.k.o();
            this.n.N0(null);
            c.a.r0.h1.h.i.b bVar = this.f52322g;
            if (bVar != null) {
                bVar.a(null);
                this.f52322g.b(null);
                this.f52322g.f(null);
                this.f52322g.h(null);
                this.f52322g.C();
            }
            c.a.r0.h1.h.i.a aVar = this.f52323h;
            if (aVar != null) {
                aVar.a(null);
                this.f52323h.b(null);
                this.f52323h.f(null);
                this.f52323h.h(null);
                this.f52323h.T();
            }
            this.f52321f.setOnSrollToBottomListener(null);
            ScrollFragmentTabHost scrollFragmentTabHost = this.b0;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.removeShadowChangeListener(this.j0);
            }
            this.f52321f.removeOnScrollListener(this.i0);
            c.a.q0.g0.g gVar = this.q;
            if (gVar != null) {
                gVar.m();
            }
            this.f52321f.setRecyclerListener(null);
            c.a.r0.h1.h.a aVar2 = this.o;
            if (aVar2 != null) {
                aVar2.g();
            }
            c.a.q0.s.n.b.i().e();
            c.a.e.e.m.e.a().removeCallbacks(this.s0);
            c.a.r0.h1.h.k.a aVar3 = this.P;
            if (aVar3 != null) {
                aVar3.a();
            }
        }
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.n.z0();
            c.a.r0.h1.h.h.c0 c0Var = this.k;
            if (c0Var != null) {
                c0Var.p();
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
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.f52320e;
            if (bigdaySwipeRefreshLayout != null) {
                bigdaySwipeRefreshLayout.resume();
            }
            c.a.r0.h1.h.h.c0 c0Var = this.k;
            if (c0Var != null) {
                c0Var.q();
            }
        }
    }

    public void onViewBackGround() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            c.a.r0.h1.h.e eVar = this.n;
            if (eVar != null) {
                eVar.t0(true);
            }
            c.a.r0.b0.u.b().d(false);
            c.a.r0.p.d.c().h("page_recommend", "show_");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            c.a.e.e.m.e.a().removeCallbacks(this.s0);
        }
    }

    public final boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (this.J == null) {
                return false;
            }
            hideRightFloatLayerView();
            if (RightFloatLayerView.isHomeNeedShow()) {
                c.a.q0.t.c.f adFloatViewData = TbSingleton.getInstance().getAdFloatViewData();
                this.K = adFloatViewData;
                if (adFloatViewData == null) {
                    return false;
                }
                this.J.setAutoCompleteShown(true);
                String b2 = this.K.b();
                if (StringUtils.isNull(b2)) {
                    return false;
                }
                this.J.setData(b2);
                TiebaStatic.log(new StatisticItem("c14128").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", 1));
                String e2 = this.K.e();
                ThirdStatisticHelper.sendReq(this.K.f());
                this.J.setLogoListener(new f(this, e2));
                this.J.setFeedBackListener(new g(this));
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean recyclerViewIsAtTop(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, recyclerView)) == null) ? recyclerView == null || !recyclerView.canScrollVertically(-1) : invokeL.booleanValue;
    }

    public void reload() {
        c.a.r0.h1.h.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            if (this.r != null && (eVar = this.n) != null) {
                eVar.V0();
                return;
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.f52321f;
            if (bdTypeRecyclerView == null || this.f52320e == null) {
                return;
            }
            bdTypeRecyclerView.setSelection(0);
            if (!this.f52320e.isRefreshing()) {
                c.a.r0.h1.h.e eVar2 = this.n;
                if (eVar2 != null && eVar2.f0() != null) {
                    this.n.f0().w();
                    this.n.O0(false);
                }
                this.f52320e.setRefreshing(true);
            }
            ScrollFragmentTabHost.s sVar = this.j0;
            if (sVar != null) {
                sVar.b();
            }
        }
    }

    public void scrollToPositionFromMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.n.K0();
        }
    }

    public void setCallback(c.a.r0.h1.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, bVar) == null) {
            this.m = bVar;
        }
    }

    public void setIsUnreadTipShow(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z2) == null) {
            c.a.r0.h1.h.e eVar = this.n;
            if (eVar != null) {
                eVar.L0(!z2);
            }
            this.B = z2;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, bdUniqueId) == null) {
            c.a.r0.h1.h.h.c0 c0Var = this.k;
            if (c0Var != null) {
                c0Var.w(bdUniqueId);
            }
            c.a.r0.h1.h.e eVar = this.n;
            if (eVar != null) {
                eVar.G0(bdUniqueId);
            }
            c.a.r0.h1.h.k.f fVar = this.p;
            if (fVar != null) {
                fVar.a(bdUniqueId);
            }
            c.a.r0.h1.h.i.a aVar = this.f52323h;
            if (aVar != null) {
                aVar.V(bdUniqueId);
            }
            c.a.q0.s.n.b.i().o(bdUniqueId);
            CustomMessageListener customMessageListener = this.t0;
            if (customMessageListener != null) {
                customMessageListener.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.t0);
            }
            c.a.r0.h1.h.a aVar2 = this.o;
            if (aVar2 != null) {
                aVar2.h(bdUniqueId);
            }
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, scrollFragmentTabHost) == null) {
            this.b0 = scrollFragmentTabHost;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.removeShadowChangeListener(this.j0);
                this.b0.addShadowChangeListener(this.j0);
            }
            c.a.r0.h1.h.e eVar = this.n;
            if (eVar != null) {
                eVar.P0(scrollFragmentTabHost);
            }
            c.a.r0.h1.h.a aVar = this.o;
            if (aVar != null) {
                aVar.j(scrollFragmentTabHost);
            }
        }
    }

    public void setTabInForeBackgroundState(boolean z2) {
        c.a.r0.h1.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048614, this, z2) == null) || (eVar = this.n) == null) {
            return;
        }
        eVar.Q0(z2);
    }

    public void setViewForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            setViewForeground(false);
            c.a.r0.h1.h.e eVar = this.n;
            if (eVar != null) {
                eVar.t0(false);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            if (this.C >= 1 || !TbadkCoreApplication.getInst().isNoInterestTag()) {
                return;
            }
            c.a.e.e.m.e.a().postDelayed(this.s0, 1000L);
        }
    }

    public void showActivityPrize() {
        c.a.r0.h1.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || (eVar = this.n) == null) {
            return;
        }
        eVar.R0();
    }

    public void showFirstLoadingView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048618, this) == null) || this.n == null) {
            return;
        }
        m0(true);
    }

    public void showRightFloatLayerView() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048619, this) == null) || (rightFloatLayerView = this.J) == null) {
            return;
        }
        rightFloatLayerView.completeShow();
    }

    public void startFirstLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            if (this.n != null) {
                m0(true);
                this.n.V0();
            }
            if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
                c.a.q0.s.n.b.i().j();
                c.a.q0.s.n.b.i().k();
            }
        }
    }

    public void updateData(DataRes dataRes, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{dataRes, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            PbListView pbListView = this.f52325j;
            if (pbListView != null) {
                pbListView.A(getContext().getString(R.string.pb_load_more));
                this.f52325j.f();
                this.f52325j.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            this.n.x0(z2, z3, dataRes, 0, null);
        }
    }

    public void updateError(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048622, this, str, i2) == null) {
            PbListView pbListView = this.f52325j;
            if (pbListView != null) {
                pbListView.A(getContext().getString(R.string.pb_load_more));
                this.f52325j.f();
                this.f52325j.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            this.n.x0(true, false, null, i2, str);
        }
    }

    public void setViewForeground(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z2) == null) {
            c.a.r0.h1.h.e eVar = this.n;
            if (eVar != null) {
                eVar.A0(z2);
            }
            ScrollFragmentTabHost scrollFragmentTabHost = this.b0;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.removeShadowChangeListener(this.j0);
                this.b0.addShadowChangeListener(this.j0);
                this.j0.b();
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
        this.N = -1;
        this.O = -1;
        this.Q = false;
        this.R = new k(this, 2156674);
        this.S = new v(this);
        this.T = new a0(this, 2921456);
        this.U = new b0(this, 2921553);
        this.V = new c0(this, CmdConfigHttp.CMD_CHECK_INTEREST_COMMIT);
        this.W = new d0(this);
        this.a0 = new e0(this);
        this.c0 = -1;
        this.i0 = new f0(this);
        this.j0 = new g0(this);
        this.k0 = new a(this);
        this.l0 = new b(this);
        this.m0 = new c(this, 2001371);
        this.n0 = new d(this);
        this.o0 = new h(this);
        this.p0 = new i(this);
        this.q0 = new j(this);
        this.r0 = new l(this);
        this.s0 = new r(this);
        this.t0 = new t(this, 2001118);
        this.u0 = new u(this);
        this.v0 = new w(this, 2921033);
        this.isBigdayPullviewShowListener = new x(this, 2921349);
        this.w0 = new y(this);
        this.x0 = new z(this, 2921632);
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
        this.N = -1;
        this.O = -1;
        this.Q = false;
        this.R = new k(this, 2156674);
        this.S = new v(this);
        this.T = new a0(this, 2921456);
        this.U = new b0(this, 2921553);
        this.V = new c0(this, CmdConfigHttp.CMD_CHECK_INTEREST_COMMIT);
        this.W = new d0(this);
        this.a0 = new e0(this);
        this.c0 = -1;
        this.i0 = new f0(this);
        this.j0 = new g0(this);
        this.k0 = new a(this);
        this.l0 = new b(this);
        this.m0 = new c(this, 2001371);
        this.n0 = new d(this);
        this.o0 = new h(this);
        this.p0 = new i(this);
        this.q0 = new j(this);
        this.r0 = new l(this);
        this.s0 = new r(this);
        this.t0 = new t(this, 2001118);
        this.u0 = new u(this);
        this.v0 = new w(this, 2921033);
        this.isBigdayPullviewShowListener = new x(this, 2921349);
        this.w0 = new y(this);
        this.x0 = new z(this, 2921632);
        f0(context);
    }
}
