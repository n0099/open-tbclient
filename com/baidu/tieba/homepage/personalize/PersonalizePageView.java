package com.baidu.tieba.homepage.personalize;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.p0.s.f0.f;
import c.a.p0.s.q.c2;
import c.a.p0.s.q.t0;
import c.a.p0.s.q.x0;
import c.a.q0.f1.h.e;
import c.a.q0.f1.h.h.c0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.SpeedStats;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
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
import com.baidu.tieba.tbadkCore.util.MercatorModel;
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
    public boolean A;
    public int B;
    public int C;
    public boolean D;
    public int E;
    public LinearLayoutManager F;
    public c.a.e.l.e.l G;
    public FRSRefreshButton H;
    public RightFloatLayerView I;
    public c.a.p0.t.c.f J;
    public int K;
    public Context L;
    public CustomMessageListener M;
    public c0.f N;
    public CustomMessageListener O;
    public CustomMessageListener P;
    public NEGFeedBackView.b Q;
    public FollowUserButton.a R;
    public ScrollFragmentTabHost S;
    public int T;
    public RecyclerView.OnScrollListener U;
    public ScrollFragmentTabHost.s V;
    public View.OnClickListener W;
    public CustomMessageListener a0;
    public e.l0 b0;
    public f.g c0;

    /* renamed from: e  reason: collision with root package name */
    public BigdaySwipeRefreshLayout f52130e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f52131f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.f1.h.i.b f52132g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.q0.f1.h.i.a f52133h;

    /* renamed from: i  reason: collision with root package name */
    public e0 f52134i;
    public f.h i0;
    public CustomMessageListener isBigdayPullviewShowListener;

    /* renamed from: j  reason: collision with root package name */
    public PbListView f52135j;
    public f.e j0;
    public c.a.q0.f1.h.h.c0 k;
    public f.InterfaceC0681f k0;
    public TbPageContext<?> l;
    public Runnable l0;
    public c.a.q0.f1.d.b m;
    public final CustomMessageListener m0;
    public c.a.q0.f1.h.e n;
    public View.OnClickListener n0;
    public c.a.q0.f1.h.a o;
    public CustomMessageListener o0;
    public c.a.q0.f1.h.k.e p;
    public View.OnClickListener p0;
    public c.a.p0.f0.g q;
    public c.a.p0.f0.h r;
    public long s;
    public int t;
    public boolean u;
    public boolean v;
    public long w;
    public boolean x;
    public boolean y;
    public c.a.q0.a0.p z;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52136a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PersonalizePageView personalizePageView, int i2) {
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
            this.f52136a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (this.f52136a.f52131f != null && this.f52136a.z != null && this.f52136a.z.b().getParent() == null && !StringUtils.isNull(TbSingleton.getInstance().getLFUser()) && !TbSingleton.getInstance().isAddBanner) {
                    this.f52136a.z.d();
                    this.f52136a.z.b().setVisibility(0);
                    this.f52136a.z.f("1");
                    this.f52136a.f52131f.setHeaderView(this.f52136a.z.b());
                }
                this.f52136a.Z();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a0 implements FollowUserButton.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52137a;

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
            this.f52137a = personalizePageView;
        }

        @Override // com.baidu.tbadk.core.view.FollowUserButton.a
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            Object tag = view.getTag();
            if (tag instanceof c2) {
                TiebaStatic.log(c.a.q0.h3.a.m("c13696", (c2) tag));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements e.l0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f52138a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52139b;

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
            this.f52139b = personalizePageView;
            this.f52138a = c.a.p0.s.d0.b.j().g("key_first_install", true);
        }

        @Override // c.a.q0.f1.h.e.l0
        public void a(int i2, c.a.p0.b1.c cVar, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), cVar, Integer.valueOf(i3)}) == null) {
                if (this.f52139b.m != null) {
                    boolean a0 = this.f52139b.a0();
                    this.f52139b.W();
                    if (a0) {
                        this.f52139b.e0(true);
                    }
                    this.f52139b.m.c(i2, cVar, i3);
                    c.a.p0.a.r.g().s();
                    return;
                }
                PersonalizePageView personalizePageView = this.f52139b;
                personalizePageView.g0(personalizePageView, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                this.f52139b.V();
            }
        }

        @Override // c.a.q0.f1.h.e.l0
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f52139b.f52135j == null) {
                return;
            }
            this.f52139b.f52135j.A(this.f52139b.getContext().getString(R.string.recommend_no_more_data));
            this.f52139b.f52135j.f();
            this.f52139b.f52135j.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }

        @Override // c.a.q0.f1.h.e.l0
        public void c(int i2, int i3, c.a.p0.b1.c cVar, int i4) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), cVar, Integer.valueOf(i4)}) == null) || this.f52139b.m == null) {
                return;
            }
            this.f52139b.m.d(i2, i3, cVar, i4);
        }

        @Override // c.a.q0.f1.h.e.l0
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                e();
                this.f52139b.f52130e.setVisibility(0);
                this.f52139b.V();
                this.f52139b.W();
                if (PermissionUtil.checkLocationForGoogle(this.f52139b.getContext())) {
                    MercatorModel.d().f();
                }
                this.f52139b.v = true;
                if (z) {
                    this.f52139b.w = System.currentTimeMillis();
                }
            }
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f52138a) {
                this.f52138a = false;
                c.a.p0.s.d0.b.j().t("key_first_install", false);
            }
        }

        @Override // c.a.q0.f1.h.e.l0
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048581, this, i2, str) == null) {
                this.f52139b.V();
                if (i2 == 1) {
                    if (c.a.e.e.p.j.z()) {
                        this.f52139b.l.showToast(str);
                    }
                    e();
                } else if (!this.f52138a) {
                    this.f52139b.f52130e.setVisibility(8);
                    PersonalizePageView personalizePageView = this.f52139b;
                    personalizePageView.g0(personalizePageView, str, true);
                } else {
                    e();
                    this.f52139b.startFirstLoad();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b0 extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52140a;

        public b0(PersonalizePageView personalizePageView) {
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
            this.f52140a = personalizePageView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) || this.f52140a.T == i2 || this.f52140a.S == null) {
                return;
            }
            this.f52140a.T = i2;
            if (this.f52140a.T == 1) {
                this.f52140a.S.showShadow();
            } else if (this.f52140a.recyclerViewIsAtTop(recyclerView)) {
                this.f52140a.S.dismissShadow();
            } else {
                this.f52140a.S.showShadow();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52141e;

        public c(PersonalizePageView personalizePageView) {
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
            this.f52141e = personalizePageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f52141e.l == null) {
                return;
            }
            c.a.q0.w0.a.i().w(this.f52141e.l.getPageActivity());
        }
    }

    /* loaded from: classes7.dex */
    public class c0 extends ScrollFragmentTabHost.s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52142a;

        public c0(PersonalizePageView personalizePageView) {
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
            this.f52142a = personalizePageView;
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.s
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f52142a.S == null) {
                return;
            }
            this.f52142a.T = -1;
            PersonalizePageView personalizePageView = this.f52142a;
            if (personalizePageView.recyclerViewIsAtTop(personalizePageView.f52131f)) {
                this.f52142a.S.dismissShadow();
            } else {
                this.f52142a.S.showShadow();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f52143e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52144f;

        public d(PersonalizePageView personalizePageView, String str) {
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
            this.f52144f = personalizePageView;
            this.f52143e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f52144f.I.inHomeLastCloseTime();
                if (!StringUtils.isNull(this.f52143e)) {
                    this.f52144f.b0(this.f52143e);
                }
                this.f52144f.I.setAutoCompleteShown(false);
                this.f52144f.hideRightFloatLayerView();
                TiebaStatic.log(new StatisticItem("c14129").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", 1).param("obj_param1", 0));
                c.a.q0.i3.e0.a(this.f52144f.J.a());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52145e;

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
            this.f52145e = personalizePageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f52145e.f52131f == null) {
                return;
            }
            this.f52145e.f52131f.removeHeaderView(this.f52145e.z.b());
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52146e;

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
            this.f52146e = personalizePageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f52146e.I.inHomeLastCloseTime();
                this.f52146e.hideRightFloatLayerView();
                TiebaStatic.log(new StatisticItem("c14129").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_param1", 1).param("obj_locate", 1));
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface e0 {
        void a(f.g gVar);

        void b(f.h hVar);

        void f(f.e eVar);

        void h(f.InterfaceC0681f interfaceC0681f);
    }

    /* loaded from: classes7.dex */
    public class f implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52147e;

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
            this.f52147e = personalizePageView;
        }

        @Override // c.a.p0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                c.a.q0.o.d.c().f("page_recommend");
                this.f52147e.n.Z0();
                this.f52147e.n.Q0(false);
                this.f52147e.D = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements f.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52148a;

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
            this.f52148a = personalizePageView;
        }

        @Override // c.a.p0.s.f0.f.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f52148a.n == null || this.f52148a.n.h0() == null) {
                return;
            }
            this.f52148a.n.h0().w();
        }
    }

    /* loaded from: classes7.dex */
    public class h implements f.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52149a;

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
            this.f52149a = personalizePageView;
        }

        @Override // c.a.p0.s.f0.f.e
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f52149a.D) {
                this.f52149a.C = 0;
                this.f52149a.E = 1;
                this.f52149a.D = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements f.InterfaceC0681f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52150a;

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
            this.f52150a = personalizePageView;
        }

        @Override // c.a.p0.s.f0.f.InterfaceC0681f
        public void a(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                if (this.f52150a.n != null) {
                    this.f52150a.n.Q0(true);
                    this.f52150a.n.H0();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, Boolean.TRUE));
                c.a.p0.s.n.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > c.a.p0.s.d0.b.j().l("key_bigday_next_showtime_home", 0L)) {
                    aVar = c.a.p0.s.n.b.i().h(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52151a;

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
            this.f52151a = personalizePageView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                if (this.f52151a.F != null && i2 == 0) {
                    int height = ((WindowManager) this.f52151a.getContext().getSystemService("window")).getDefaultDisplay().getHeight() * 3;
                    if (this.f52151a.C < height || this.f52151a.E != 1) {
                        if (this.f52151a.C < height && this.f52151a.E == 2) {
                            this.f52151a.E = 1;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        }
                    } else {
                        this.f52151a.E = 2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(this.f52151a.E)));
                    }
                    if (this.f52151a.F.getItemCount() - this.f52151a.F.findLastVisibleItemPosition() <= 15) {
                        this.f52151a.c0();
                    }
                }
                if (i2 == 0) {
                    if (this.f52151a.I != null) {
                        this.f52151a.I.onScrollIdle();
                    }
                } else if (i2 == 1) {
                    if (this.f52151a.I != null) {
                        this.f52151a.I.onScrollDragging();
                    }
                } else if (i2 != 2 || this.f52151a.I == null) {
                } else {
                    this.f52151a.I.onScrollSettling();
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                this.f52151a.C += i3;
                if (this.f52151a.H != null) {
                    c.a.e.l.e.n item = this.f52151a.f52131f.getItem(this.f52151a.F.findLastVisibleItemPosition());
                    if (item instanceof c.a.q0.a0.d0.k) {
                        if (((c.a.q0.a0.d0.k) item).position >= 6) {
                            this.f52151a.H.show();
                        } else {
                            this.f52151a.H.hide();
                        }
                    }
                }
                if (!c.a.p0.b.d.F() || TbadkCoreApplication.isLogin() || c.a.p0.s.d0.b.j().k("home_page_login_dialog_show_key", 0) != 0 || this.f52151a.C < c.a.e.e.p.l.p(TbadkCoreApplication.getInst().getContext())[1] * 2) {
                    return;
                }
                c.a.p0.s.d0.b.j().v("home_page_login_dialog_show_key", 1);
                DialogLoginHelper.checkUpIsLogin(new t0(this.f52151a.L, "new_shouye"));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52152a;

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
            this.f52152a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (this.f52152a.G == null) {
                        this.f52152a.G = new c.a.e.l.e.l(new c.a.e.l.e.j());
                    }
                    this.f52152a.G.q(this.f52152a.f52131f, 2);
                } else if (this.f52152a.G != null) {
                    this.f52152a.G.w();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52153e;

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
            this.f52153e = personalizePageView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f52153e.c0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements BdListView.o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52154a;

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
            this.f52154a = personalizePageView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.o
        public void onScrollStop(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || System.currentTimeMillis() - this.f52154a.s < 5000) {
                return;
            }
            this.f52154a.n.G0(i2, i3);
        }
    }

    /* loaded from: classes7.dex */
    public class n implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52155a;

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
            this.f52155a = personalizePageView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || viewHolder == null || (view = viewHolder.itemView) == null) {
                return;
            }
            if (this.f52155a.n != null && this.f52155a.n.h0() != null) {
                this.f52155a.n.h0().k(view);
            }
            if (view.getTag() instanceof HomePageCardVideoViewHolder) {
                ((HomePageCardVideoViewHolder) view.getTag()).getCardView().stopPlay();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52156e;

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
            this.f52156e = personalizePageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f52156e.n == null) {
                return;
            }
            this.f52156e.n.Z0();
        }
    }

    /* loaded from: classes7.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52157e;

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
            this.f52157e = personalizePageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f52157e.l == null) {
                return;
            }
            c.a.p0.s.d0.b.j().v("show_is_uninterest_tag", PersonalizePageView.D(this.f52157e));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(this.f52157e.l.getContext(), 2)));
        }
    }

    /* loaded from: classes7.dex */
    public class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52158e;

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
            this.f52158e = personalizePageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f52158e.d0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52159a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ r f52160e;

            public a(r rVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {rVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f52160e = rVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f52160e.f52159a.notifyListViewDataSetChanged();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(PersonalizePageView personalizePageView, int i2) {
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
            this.f52159a = personalizePageView;
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
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52161e;

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
            this.f52161e = personalizePageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f52161e.c0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52162a;

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
            this.f52162a = personalizePageView;
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
            this.f52162a.u = true;
        }
    }

    /* loaded from: classes7.dex */
    public class u extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52163a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(PersonalizePageView personalizePageView, int i2) {
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
            this.f52163a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f52163a.f52130e == null || this.f52163a.f52130e.isRefreshing()) {
                return;
            }
            if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof c.a.p0.s.n.a))) {
                if (this.f52163a.f52133h != null) {
                    if (this.f52163a.f52134i == this.f52163a.f52133h) {
                        return;
                    }
                    PersonalizePageView personalizePageView = this.f52163a;
                    personalizePageView.f52134i = personalizePageView.f52133h;
                } else {
                    PersonalizePageView personalizePageView2 = this.f52163a;
                    personalizePageView2.f52133h = new c.a.q0.f1.h.i.a(personalizePageView2.l);
                    this.f52163a.f52133h.D(this.f52163a.t);
                    PersonalizePageView personalizePageView3 = this.f52163a;
                    personalizePageView3.f52134i = personalizePageView3.f52133h;
                    this.f52163a.initPullViewListeners();
                }
                this.f52163a.f52133h.w(true);
                this.f52163a.f52130e.setProgressView(this.f52163a.f52133h);
                int i2 = (int) (this.f52163a.getResources().getDisplayMetrics().density * 86.0f);
                this.f52163a.f52130e.setCustomDistances(i2, i2, i2 * 2);
                return;
            }
            c.a.p0.s.n.a aVar = (c.a.p0.s.n.a) customResponsedMessage.getData();
            if (this.f52163a.f52132g != null) {
                if (this.f52163a.f52134i == this.f52163a.f52132g && aVar.equals(this.f52163a.f52132g.B())) {
                    return;
                }
                PersonalizePageView personalizePageView4 = this.f52163a;
                personalizePageView4.f52134i = personalizePageView4.f52132g;
            } else {
                PersonalizePageView personalizePageView5 = this.f52163a;
                personalizePageView5.f52132g = new c.a.q0.f1.h.i.b(personalizePageView5.l.getContext());
                PersonalizePageView personalizePageView6 = this.f52163a;
                personalizePageView6.f52134i = personalizePageView6.f52132g;
                this.f52163a.initPullViewListeners();
            }
            this.f52163a.f52132g.w(true);
            this.f52163a.f52130e.setProgressView(this.f52163a.f52132g);
            this.f52163a.f52132g.E(aVar);
            this.f52163a.f52130e.setCustomDistances((int) this.f52163a.getResources().getDimension(R.dimen.tbds236), (int) (c.a.e.e.p.l.i(this.f52163a.l.getContext()) * 0.8d), c.a.e.e.p.l.i(this.f52163a.l.getContext()));
        }
    }

    /* loaded from: classes7.dex */
    public class v implements c0.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52164a;

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
            this.f52164a = personalizePageView;
        }

        @Override // c.a.q0.f1.h.h.c0.f
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f52164a.f52131f == null || this.f52164a.z == null) {
                return;
            }
            if (TbSingleton.getInstance().isAddBanner) {
                this.f52164a.f52131f.removeHeaderView(this.f52164a.z.b());
            } else if (this.f52164a.z.b().getParent() != null || StringUtils.isNull(TbSingleton.getInstance().getLFUser())) {
            } else {
                this.f52164a.z.d();
                this.f52164a.z.b().setVisibility(0);
                this.f52164a.z.f("1");
                this.f52164a.f52131f.setHeaderView(this.f52164a.z.b());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52165e;

        public w(PersonalizePageView personalizePageView) {
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
            this.f52165e = personalizePageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f52165e.H == null) {
                return;
            }
            this.f52165e.H.hide();
            this.f52165e.reload();
        }
    }

    /* loaded from: classes7.dex */
    public class x extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52166a;

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
            this.f52166a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (this.f52166a.n != null) {
                    this.f52166a.updateData(c.a.p0.s.v.a.b().c(), false, false);
                }
                this.f52166a.V();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52167a;

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
            this.f52167a = personalizePageView;
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
                this.f52167a.K = ((Integer) data).intValue();
                if (this.f52167a.I != null) {
                    ((FrameLayout.LayoutParams) this.f52167a.I.getLayoutParams()).topMargin = c.a.e.e.p.l.g(this.f52167a.L, R.dimen.tbds1409) - this.f52167a.K;
                    this.f52167a.I.requestLayout();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class z implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f52168a;

        public z(PersonalizePageView personalizePageView) {
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
            this.f52168a = personalizePageView;
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
            if (this.f52168a.k != null) {
                this.f52168a.k.m();
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
        this.A = false;
        this.B = 0;
        this.C = 0;
        this.D = false;
        this.E = 1;
        this.M = new k(this, 2156674);
        this.N = new v(this);
        this.O = new x(this, 2921456);
        this.P = new y(this, 2921553);
        this.Q = new z(this);
        this.R = new a0(this);
        this.T = -1;
        this.U = new b0(this);
        this.V = new c0(this);
        this.W = new d0(this);
        this.a0 = new a(this, 2001371);
        this.b0 = new b(this);
        this.c0 = new f(this);
        this.i0 = new g(this);
        this.j0 = new h(this);
        this.k0 = new i(this);
        this.l0 = new p(this);
        this.m0 = new r(this, 2001118);
        this.n0 = new s(this);
        this.o0 = new t(this, 2921033);
        this.isBigdayPullviewShowListener = new u(this, 2921349);
        this.p0 = new w(this);
        Y(context);
    }

    public static /* synthetic */ int D(PersonalizePageView personalizePageView) {
        int i2 = personalizePageView.B + 1;
        personalizePageView.B = i2;
        return i2;
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.p0.f0.g gVar = this.q;
            if (gVar != null) {
                gVar.dettachView(this);
                this.q = null;
                this.f52131f.setNextPage(this.f52135j);
                this.f52135j.A(getContext().getString(R.string.pb_load_more));
                this.f52135j.f();
                this.f52135j.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, Boolean.TRUE));
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.f52130e;
            if (bigdaySwipeRefreshLayout != null) {
                bigdaySwipeRefreshLayout.setVisibility(0);
            }
            c.a.q0.f1.d.b bVar = this.m;
            if (bVar != null) {
                bVar.b();
            }
        }
    }

    public final void W() {
        c.a.p0.f0.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (hVar = this.r) == null) {
            return;
        }
        hVar.dettachView(this);
        this.r = null;
    }

    public final void X() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (rightFloatLayerView = this.I) == null) {
            return;
        }
        rightFloatLayerView.setAutoCompleteShown(false);
        this.I.clearAnimation();
        this.I.setVisibility(8);
    }

    public final void Y(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.L = context;
            BdTypeRecyclerView bdTypeRecyclerView = new BdTypeRecyclerView(context);
            this.f52131f = bdTypeRecyclerView;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(bdTypeRecyclerView.getContext());
            this.F = linearLayoutManager;
            this.f52131f.setLayoutManager(linearLayoutManager);
            this.f52131f.setFadingEdgeLength(0);
            this.f52131f.setOverScrollMode(2);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.f52131f.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            c.a.q0.a0.p pVar = new c.a.q0.a0.p(context);
            this.z = pVar;
            pVar.setFrom("from_personaize");
            this.z.a().setVisibility(0);
            this.z.a().setOnClickListener(this.W);
            MessageManager.getInstance().registerListener(this.a0);
            if (TbSingleton.getInstance().isSlideAnimEnable()) {
                c.a.e.l.e.l lVar = new c.a.e.l.e.l(new c.a.e.l.e.j());
                this.G = lVar;
                lVar.q(this.f52131f, 2);
            }
            MessageManager.getInstance().registerListener(this.M);
            MessageManager.getInstance().registerListener(this.O);
            MessageManager.getInstance().registerListener(this.P);
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = new BigdaySwipeRefreshLayout(context);
            this.f52130e = bigdaySwipeRefreshLayout;
            bigdaySwipeRefreshLayout.addView(this.f52131f);
            PbListView pbListView = new PbListView(context);
            this.f52135j = pbListView;
            pbListView.b();
            this.f52135j.o(R.color.transparent);
            this.f52135j.v();
            this.f52135j.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f52135j.E(R.dimen.tbfontsize33);
            this.f52135j.y(R.color.CAM_X0110);
            this.f52135j.r(c.a.e.e.p.l.g(context, R.dimen.tbds182));
            this.f52135j.z(this.n0);
            this.f52135j.q();
            this.f52131f.setNextPage(this.f52135j);
            c.a.e.a.f<?> a2 = c.a.e.a.j.a(context);
            if (a2 instanceof TbPageContext) {
                this.l = (TbPageContext) a2;
            }
            MessageManager.getInstance().registerListener(this.isBigdayPullviewShowListener);
            c.a.p0.s.n.b.i().n(true);
            c.a.p0.s.n.a aVar = null;
            if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > c.a.p0.s.d0.b.j().l("key_bigday_next_showtime_home", 0L)) {
                aVar = c.a.p0.s.n.b.i().h(1);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            addView(this.f52130e);
            if (TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
                this.H = new FRSRefreshButton(context);
                int g2 = c.a.e.e.p.l.g(context, R.dimen.tbds170);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g2, g2);
                layoutParams.gravity = 85;
                layoutParams.rightMargin = c.a.e.e.p.l.g(context, R.dimen.tbds24);
                layoutParams.bottomMargin = c.a.e.e.p.l.g(context, R.dimen.tbds180);
                addView(this.H, layoutParams);
                this.H.setOnClickListener(this.p0);
                this.H.setVisibility(8);
            }
            this.I = new RightFloatLayerView(context);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 53;
            layoutParams2.topMargin = c.a.e.e.p.l.g(context, R.dimen.tbds1409) - this.K;
            this.I.completeHide();
            addView(this.I, layoutParams2);
            this.p = new c.a.q0.f1.h.k.e();
            c.a.q0.f1.h.h.c0 c0Var = new c.a.q0.f1.h.h.c0(context, this.f52131f);
            this.k = c0Var;
            c0Var.x(this.p);
            this.k.v(this.N);
            this.n = new c.a.q0.f1.h.e(this.l, this.f52131f, this.k, this.f52130e);
            this.o = new c.a.q0.f1.h.a(this.l);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            MessageManager.getInstance().registerListener(this.o0);
            this.B = c.a.p0.s.d0.b.j().k("show_is_uninterest_tag", 0);
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!(TbSingleton.getInstance().isShowRightFloatView(0) ? h0() : false)) {
                X();
                f0();
                return;
            }
            c.a.q0.w0.a.i().r();
        }
    }

    public final boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.a.p0.f0.h hVar = this.r;
            if (hVar != null) {
                return hVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void b0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.l.getContext(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.q0.f1.d.a.d().j(System.currentTimeMillis(), 1);
            PbListView pbListView = this.f52135j;
            if (pbListView != null && !pbListView.l()) {
                this.f52135j.O();
                this.f52135j.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            this.n.s0();
        }
    }

    public void completePullRefresh() {
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (bigdaySwipeRefreshLayout = this.f52130e) == null) {
            return;
        }
        bigdaySwipeRefreshLayout.interruptRefresh();
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (!this.x) {
                long f2 = c.a.q0.f1.d.a.d().f(1) + c.a.q0.f1.d.a.d().b();
                long a2 = c.a.q0.f1.d.a.d().a(1);
                if (a2 > 0) {
                    f2 = System.currentTimeMillis() - a2;
                }
                c.a.p0.o0.n nVar = new c.a.p0.o0.n();
                nVar.a();
                nVar.b();
                c.a.p0.o0.l.b().o(f2);
                if (this.w > 0) {
                    c.a.p0.o0.l.b().I(System.currentTimeMillis() - this.w);
                }
                c.a.p0.o0.l.b().M(nVar.c());
                SpeedStats.getInstance().onMainPageStatsEnd(getContext());
            }
            this.x = true;
        }
    }

    public void deleteGodReplyInThread(Long l2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, l2) == null) {
            this.n.Z(l2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, canvas) == null) {
            super.dispatchDraw(canvas);
            if (this.v) {
                if (!this.y) {
                    this.y = true;
                }
                post(new q(this));
            }
        }
    }

    public final void e0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z2) == null) {
            if (this.q == null) {
                this.q = new c.a.p0.f0.g(getContext());
                this.q.o(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + c.a.e.e.p.l.g(getContext(), R.dimen.tbds60));
                this.q.h();
                this.q.setWrapStyle(true);
                this.q.onChangeSkinType();
            }
            this.q.attachView(this, z2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, Boolean.FALSE));
            this.f52131f.setNextPage(null);
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.f52130e;
            if (bigdaySwipeRefreshLayout != null) {
                bigdaySwipeRefreshLayout.setVisibility(8);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921457, this.l.getUniqueId()));
        }
    }

    public final void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            c.a.e.e.m.e.a().post(new c(this));
        }
    }

    public void forceReload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (this.r != null) {
                reload();
                return;
            }
            c.a.q0.f1.h.e eVar = this.n;
            if (eVar != null) {
                eVar.Z0();
            }
        }
    }

    public final void g0(View view, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048591, this, view, str, z2) == null) {
            if (this.r == null) {
                this.r = new c.a.p0.f0.h(getContext(), new o(this));
            }
            this.r.attachView(view, z2);
            this.r.o();
        }
    }

    public boolean getIsUnreadTipShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.A : invokeV.booleanValue;
    }

    public final boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.I == null) {
                return false;
            }
            hideRightFloatLayerView();
            if (RightFloatLayerView.isHomeNeedShow()) {
                c.a.p0.t.c.f adFloatViewData = TbSingleton.getInstance().getAdFloatViewData();
                this.J = adFloatViewData;
                if (adFloatViewData == null) {
                    return false;
                }
                this.I.setAutoCompleteShown(true);
                String b2 = this.J.b();
                if (StringUtils.isNull(b2)) {
                    return false;
                }
                this.I.setData(b2);
                TiebaStatic.log(new StatisticItem("c14128").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", 1));
                String c2 = this.J.c();
                c.a.q0.i3.e0.a(this.J.d());
                this.I.setLogoListener(new d(this, c2));
                this.I.setFeedBackListener(new e(this));
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void hideRightFloatLayerView() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (rightFloatLayerView = this.I) == null) {
            return;
        }
        rightFloatLayerView.completeHide();
    }

    public void initListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.k.u(this.Q);
            this.k.s(this.R);
            this.n.P0(this.b0);
            this.o.i(this);
            initPullViewListeners();
            this.f52131f.addOnScrollListener(new j(this));
            this.f52131f.setOnSrollToBottomListener(new l(this));
            this.f52131f.setOnScrollStopDelayedListener(new m(this), 1L);
            this.f52131f.setRecyclerListener(new n(this));
            this.f52131f.removeOnScrollListener(this.U);
            this.f52131f.addOnScrollListener(this.U);
        }
    }

    public void initPullViewListeners() {
        e0 e0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (e0Var = this.f52134i) == null) {
            return;
        }
        e0Var.a(this.c0);
        this.f52134i.b(this.i0);
        this.f52134i.f(this.j0);
        this.f52134i.h(this.k0);
    }

    public void notifyJumpToLastReadPosition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.n.p0();
        }
    }

    public void notifyListViewDataSetChanged() {
        c.a.q0.f1.h.h.c0 c0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (c0Var = this.k) == null) {
            return;
        }
        c0Var.m();
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            if (this.t != i2) {
                c.a.p0.f0.g gVar = this.q;
                if (gVar != null) {
                    gVar.onChangeSkinType();
                }
                c.a.p0.f0.h hVar = this.r;
                if (hVar != null) {
                    hVar.onChangeSkinType();
                }
                c.a.q0.f1.h.i.a aVar = this.f52133h;
                if (aVar != null) {
                    aVar.D(i2);
                }
                PbListView pbListView = this.f52135j;
                if (pbListView != null) {
                    pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
                    this.f52135j.d(i2);
                }
                this.k.n(i2);
                c.a.q0.f1.h.e eVar = this.n;
                if (eVar != null) {
                    eVar.x0(i2);
                }
                FRSRefreshButton fRSRefreshButton = this.H;
                if (fRSRefreshButton != null) {
                    fRSRefreshButton.onChangeSkinType(i2);
                }
                c.a.q0.a0.p pVar = this.z;
                if (pVar != null) {
                    pVar.e(i2);
                }
                RightFloatLayerView rightFloatLayerView = this.I;
                if (rightFloatLayerView != null) {
                    rightFloatLayerView.onChangeSkinType();
                }
            }
            this.t = i2;
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.a0);
            MessageManager.getInstance().unRegisterListener(this.M);
            MessageManager.getInstance().unRegisterListener(this.O);
            MessageManager.getInstance().unRegisterListener(this.o0);
            MessageManager.getInstance().unRegisterListener(this.isBigdayPullviewShowListener);
            MessageManager.getInstance().unRegisterListener(this.P);
            this.n.y0();
            this.k.u(null);
            this.k.o();
            this.n.P0(null);
            c.a.q0.f1.h.i.b bVar = this.f52132g;
            if (bVar != null) {
                bVar.a(null);
                this.f52132g.b(null);
                this.f52132g.f(null);
                this.f52132g.h(null);
                this.f52132g.C();
            }
            c.a.q0.f1.h.i.a aVar = this.f52133h;
            if (aVar != null) {
                aVar.a(null);
                this.f52133h.b(null);
                this.f52133h.f(null);
                this.f52133h.h(null);
                this.f52133h.T();
            }
            this.f52131f.setOnSrollToBottomListener(null);
            ScrollFragmentTabHost scrollFragmentTabHost = this.S;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.removeShadowChangeListener(this.V);
            }
            this.f52131f.removeOnScrollListener(this.U);
            c.a.p0.f0.g gVar = this.q;
            if (gVar != null) {
                gVar.m();
            }
            this.f52131f.setRecyclerListener(null);
            c.a.q0.f1.h.a aVar2 = this.o;
            if (aVar2 != null) {
                aVar2.g();
            }
            c.a.p0.s.n.b.i().e();
            c.a.e.e.m.e.a().removeCallbacks(this.l0);
        }
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.n.B0();
            c.a.q0.f1.h.h.c0 c0Var = this.k;
            if (c0Var != null) {
                c0Var.p();
            }
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (this.u) {
                reload();
                this.u = false;
            }
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.f52130e;
            if (bigdaySwipeRefreshLayout != null) {
                bigdaySwipeRefreshLayout.resume();
            }
            c.a.q0.f1.h.h.c0 c0Var = this.k;
            if (c0Var != null) {
                c0Var.q();
            }
        }
    }

    public void onViewBackGround() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            c.a.q0.f1.h.e eVar = this.n;
            if (eVar != null) {
                eVar.v0(true);
            }
            c.a.q0.a0.t.b().d(false);
            c.a.q0.o.d.c().h("page_recommend", "show_");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            c.a.e.e.m.e.a().removeCallbacks(this.l0);
        }
    }

    public boolean recyclerViewIsAtTop(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, recyclerView)) == null) ? recyclerView == null || !recyclerView.canScrollVertically(-1) : invokeL.booleanValue;
    }

    public void reload() {
        c.a.q0.f1.h.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            if (this.r != null && (eVar = this.n) != null) {
                eVar.Z0();
            } else if (this.f52131f == null || this.f52130e == null) {
            } else {
                showFloatingView();
                this.f52131f.setSelection(0);
                if (!this.f52130e.isRefreshing()) {
                    c.a.q0.f1.h.e eVar2 = this.n;
                    if (eVar2 != null && eVar2.h0() != null) {
                        this.n.h0().w();
                        this.n.Q0(false);
                    }
                    this.f52130e.setRefreshing(true);
                }
                ScrollFragmentTabHost.s sVar = this.V;
                if (sVar != null) {
                    sVar.b();
                }
            }
        }
    }

    public void scrollToPositionFromMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.n.M0();
        }
    }

    public void setCallback(c.a.q0.f1.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bVar) == null) {
            this.m = bVar;
        }
    }

    public void setIsUnreadTipShow(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z2) == null) {
            c.a.q0.f1.h.e eVar = this.n;
            if (eVar != null) {
                eVar.N0(!z2);
            }
            this.A = z2;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, bdUniqueId) == null) {
            c.a.q0.f1.h.h.c0 c0Var = this.k;
            if (c0Var != null) {
                c0Var.w(bdUniqueId);
            }
            c.a.q0.f1.h.e eVar = this.n;
            if (eVar != null) {
                eVar.I0(bdUniqueId);
            }
            c.a.q0.f1.h.k.e eVar2 = this.p;
            if (eVar2 != null) {
                eVar2.a(bdUniqueId);
            }
            c.a.q0.f1.h.i.a aVar = this.f52133h;
            if (aVar != null) {
                aVar.V(bdUniqueId);
            }
            c.a.p0.s.n.b.i().o(bdUniqueId);
            CustomMessageListener customMessageListener = this.m0;
            if (customMessageListener != null) {
                customMessageListener.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.m0);
            }
            c.a.q0.f1.h.a aVar2 = this.o;
            if (aVar2 != null) {
                aVar2.h(bdUniqueId);
            }
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(c.a.p0.b1.d0 d0Var) {
        c.a.q0.f1.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, d0Var) == null) || (eVar = this.n) == null) {
            return;
        }
        eVar.R0(d0Var);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, scrollFragmentTabHost) == null) {
            this.S = scrollFragmentTabHost;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.removeShadowChangeListener(this.V);
                this.S.addShadowChangeListener(this.V);
            }
            c.a.q0.f1.h.e eVar = this.n;
            if (eVar != null) {
                eVar.S0(scrollFragmentTabHost);
            }
            c.a.q0.f1.h.a aVar = this.o;
            if (aVar != null) {
                aVar.j(scrollFragmentTabHost);
            }
        }
    }

    public void setTabInForeBackgroundState(boolean z2) {
        c.a.q0.f1.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048612, this, z2) == null) || (eVar = this.n) == null) {
            return;
        }
        eVar.T0(z2);
    }

    public void setViewForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            setViewForeground(false);
            c.a.q0.f1.h.e eVar = this.n;
            if (eVar != null) {
                eVar.v0(false);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            if (this.B >= 1 || !TbadkCoreApplication.getInst().isNoInterestTag()) {
                return;
            }
            c.a.e.e.m.e.a().postDelayed(this.l0, 1000L);
        }
    }

    public void showActivityPrize() {
        c.a.q0.f1.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || (eVar = this.n) == null) {
            return;
        }
        eVar.U0();
    }

    public void showFirstLoadingView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || this.n == null) {
            return;
        }
        e0(true);
    }

    public void showFloatingView() {
        c.a.q0.f1.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || (eVar = this.n) == null) {
            return;
        }
        eVar.W0();
    }

    public void showRightFloatLayerView() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048618, this) == null) || (rightFloatLayerView = this.I) == null) {
            return;
        }
        rightFloatLayerView.completeShow();
    }

    public void startFirstLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            if (this.n != null) {
                e0(true);
                this.n.Z0();
            }
            if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
                c.a.p0.s.n.b.i().j();
                c.a.p0.s.n.b.i().k();
            }
        }
    }

    public void updateData(DataRes dataRes, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{dataRes, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            PbListView pbListView = this.f52135j;
            if (pbListView != null) {
                pbListView.A(getContext().getString(R.string.pb_load_more));
                this.f52135j.f();
                this.f52135j.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            this.n.z0(z2, z3, dataRes, 0, null);
        }
    }

    public void updateError(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048621, this, str, i2) == null) {
            PbListView pbListView = this.f52135j;
            if (pbListView != null) {
                pbListView.A(getContext().getString(R.string.pb_load_more));
                this.f52135j.f();
                this.f52135j.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            this.n.z0(true, false, null, i2, str);
        }
    }

    public void setViewForeground(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z2) == null) {
            c.a.q0.f1.h.e eVar = this.n;
            if (eVar != null) {
                eVar.C0(z2);
            }
            ScrollFragmentTabHost scrollFragmentTabHost = this.S;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.removeShadowChangeListener(this.V);
                this.S.addShadowChangeListener(this.V);
                this.V.b();
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
        this.A = false;
        this.B = 0;
        this.C = 0;
        this.D = false;
        this.E = 1;
        this.M = new k(this, 2156674);
        this.N = new v(this);
        this.O = new x(this, 2921456);
        this.P = new y(this, 2921553);
        this.Q = new z(this);
        this.R = new a0(this);
        this.T = -1;
        this.U = new b0(this);
        this.V = new c0(this);
        this.W = new d0(this);
        this.a0 = new a(this, 2001371);
        this.b0 = new b(this);
        this.c0 = new f(this);
        this.i0 = new g(this);
        this.j0 = new h(this);
        this.k0 = new i(this);
        this.l0 = new p(this);
        this.m0 = new r(this, 2001118);
        this.n0 = new s(this);
        this.o0 = new t(this, 2921033);
        this.isBigdayPullviewShowListener = new u(this, 2921349);
        this.p0 = new w(this);
        Y(context);
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
        this.A = false;
        this.B = 0;
        this.C = 0;
        this.D = false;
        this.E = 1;
        this.M = new k(this, 2156674);
        this.N = new v(this);
        this.O = new x(this, 2921456);
        this.P = new y(this, 2921553);
        this.Q = new z(this);
        this.R = new a0(this);
        this.T = -1;
        this.U = new b0(this);
        this.V = new c0(this);
        this.W = new d0(this);
        this.a0 = new a(this, 2001371);
        this.b0 = new b(this);
        this.c0 = new f(this);
        this.i0 = new g(this);
        this.j0 = new h(this);
        this.k0 = new i(this);
        this.l0 = new p(this);
        this.m0 = new r(this, 2001118);
        this.n0 = new s(this);
        this.o0 = new t(this, 2921033);
        this.isBigdayPullviewShowListener = new u(this, 2921349);
        this.p0 = new w(this);
        Y(context);
    }
}
