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
import d.a.p0.s.f0.f;
import d.a.p0.s.q.b2;
import d.a.p0.s.q.s0;
import d.a.p0.s.q.w0;
import d.a.q0.e1.h.e;
import d.a.q0.e1.h.h.c0;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class PersonalizePageView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public boolean C;
    public int D;
    public LinearLayoutManager E;
    public d.a.d.k.e.l F;
    public FRSRefreshButton G;
    public RightFloatLayerView H;
    public d.a.p0.t.c.f I;
    public int J;
    public Context K;
    public CustomMessageListener L;
    public c0.f M;
    public CustomMessageListener N;
    public CustomMessageListener O;
    public NEGFeedBackView.b P;
    public FollowUserButton.a Q;
    public ScrollFragmentTabHost R;
    public int S;
    public RecyclerView.OnScrollListener T;
    public ScrollFragmentTabHost.s U;
    public View.OnClickListener V;
    public CustomMessageListener W;
    public e.l0 a0;
    public f.g b0;
    public f.h c0;

    /* renamed from: e  reason: collision with root package name */
    public BigdaySwipeRefreshLayout f16757e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f16758f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.q0.e1.h.i.b f16759g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.q0.e1.h.i.a f16760h;

    /* renamed from: i  reason: collision with root package name */
    public d0 f16761i;
    public f.e i0;
    public PbListView j;
    public f.InterfaceC1212f j0;
    public d.a.q0.e1.h.h.c0 k;
    public Runnable k0;
    public TbPageContext<?> l;
    public final CustomMessageListener l0;
    public d.a.q0.e1.d.b m;
    public View.OnClickListener m0;
    public d.a.q0.e1.h.e n;
    public CustomMessageListener n0;
    public d.a.q0.e1.h.a o;
    public CustomMessageListener o0;
    public d.a.q0.e1.h.k.e p;
    public View.OnClickListener p0;
    public d.a.p0.f0.g q;
    public d.a.p0.f0.h r;
    public long s;
    public int t;
    public boolean u;
    public boolean v;
    public long w;
    public boolean x;
    public d.a.q0.a0.p y;
    public boolean z;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f16762a;

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
            this.f16762a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (this.f16762a.f16758f != null && this.f16762a.y != null && this.f16762a.y.b().getParent() == null && !StringUtils.isNull(TbSingleton.getInstance().getLFUser()) && !TbSingleton.getInstance().isAddBanner) {
                    this.f16762a.y.d();
                    this.f16762a.y.b().setVisibility(0);
                    this.f16762a.y.f("1");
                    this.f16762a.f16758f.setHeaderView(this.f16762a.y.b());
                }
                this.f16762a.d0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a0 extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f16763a;

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
            this.f16763a = personalizePageView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) || this.f16763a.S == i2 || this.f16763a.R == null) {
                return;
            }
            this.f16763a.S = i2;
            if (this.f16763a.S == 1) {
                this.f16763a.R.V();
            } else if (this.f16763a.p0(recyclerView)) {
                this.f16763a.R.y();
            } else {
                this.f16763a.R.V();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements e.l0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f16764a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f16765b;

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
            this.f16765b = personalizePageView;
            this.f16764a = d.a.p0.s.d0.b.j().g("key_first_install", true);
        }

        @Override // d.a.q0.e1.h.e.l0
        public void a(int i2, d.a.p0.b1.c cVar, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), cVar, Integer.valueOf(i3)}) == null) {
                if (this.f16765b.m != null) {
                    boolean e0 = this.f16765b.e0();
                    this.f16765b.Y();
                    if (e0) {
                        this.f16765b.u0(true);
                    }
                    this.f16765b.m.c(i2, cVar, i3);
                    d.a.p0.a.s.g().s();
                    return;
                }
                PersonalizePageView personalizePageView = this.f16765b;
                personalizePageView.v0(personalizePageView, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                this.f16765b.X();
            }
        }

        @Override // d.a.q0.e1.h.e.l0
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f16765b.j == null) {
                return;
            }
            this.f16765b.j.A(this.f16765b.getContext().getString(R.string.recommend_no_more_data));
            this.f16765b.j.f();
            this.f16765b.j.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }

        @Override // d.a.q0.e1.h.e.l0
        public void c(int i2, int i3, d.a.p0.b1.c cVar, int i4) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), cVar, Integer.valueOf(i4)}) == null) || this.f16765b.m == null) {
                return;
            }
            this.f16765b.m.d(i2, i3, cVar, i4);
        }

        @Override // d.a.q0.e1.h.e.l0
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                e();
                this.f16765b.f16757e.setVisibility(0);
                this.f16765b.X();
                this.f16765b.Y();
                if (PermissionUtil.checkLocationForGoogle(this.f16765b.getContext())) {
                    MercatorModel.d().f();
                }
                if (z) {
                    this.f16765b.v = true;
                    this.f16765b.w = System.currentTimeMillis();
                }
            }
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f16764a) {
                this.f16764a = false;
                d.a.p0.s.d0.b.j().t("key_first_install", false);
            }
        }

        @Override // d.a.q0.e1.h.e.l0
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048581, this, i2, str) == null) {
                this.f16765b.X();
                if (i2 == 1) {
                    if (d.a.d.e.p.j.z()) {
                        this.f16765b.l.showToast(str);
                    }
                    e();
                } else if (!this.f16764a) {
                    this.f16765b.f16757e.setVisibility(8);
                    PersonalizePageView personalizePageView = this.f16765b;
                    personalizePageView.v0(personalizePageView, str, true);
                } else {
                    e();
                    this.f16765b.w0();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b0 extends ScrollFragmentTabHost.s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f16766a;

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
            this.f16766a = personalizePageView;
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.s
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f16766a.R == null) {
                return;
            }
            this.f16766a.S = -1;
            PersonalizePageView personalizePageView = this.f16766a;
            if (personalizePageView.p0(personalizePageView.f16758f)) {
                this.f16766a.R.y();
            } else {
                this.f16766a.R.V();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f16767e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f16768f;

        public c(PersonalizePageView personalizePageView, String str) {
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
            this.f16768f = personalizePageView;
            this.f16767e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16768f.H.j();
                this.f16768f.f0(this.f16767e);
                this.f16768f.Z();
                TiebaStatic.log(new StatisticItem("c14129").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", 1).param("obj_param1", 0));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f16769e;

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
            this.f16769e = personalizePageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f16769e.f16758f == null) {
                return;
            }
            this.f16769e.f16758f.removeHeaderView(this.f16769e.y.b());
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f16770e;

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
            this.f16770e = personalizePageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16770e.H.j();
                this.f16770e.Z();
                TiebaStatic.log(new StatisticItem("c14129").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_param1", 1).param("obj_locate", 1));
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d0 {
        void a(f.g gVar);

        void b(f.h hVar);

        void i(f.e eVar);

        void l(f.InterfaceC1212f interfaceC1212f);
    }

    /* loaded from: classes4.dex */
    public class e implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f16771e;

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
            this.f16771e = personalizePageView;
        }

        @Override // d.a.p0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                d.a.q0.o.d.c().f("page_recommend");
                this.f16771e.n.Z0();
                this.f16771e.n.Q0(false);
                this.f16771e.C = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 3));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements f.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f16772a;

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
            this.f16772a = personalizePageView;
        }

        @Override // d.a.p0.s.f0.f.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f16772a.n == null || this.f16772a.n.h0() == null) {
                return;
            }
            this.f16772a.n.h0().w();
        }
    }

    /* loaded from: classes4.dex */
    public class g implements f.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f16773a;

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
            this.f16773a = personalizePageView;
        }

        @Override // d.a.p0.s.f0.f.e
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f16773a.C) {
                this.f16773a.B = 0;
                this.f16773a.D = 1;
                this.f16773a.C = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements f.InterfaceC1212f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f16774a;

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
            this.f16774a = personalizePageView;
        }

        @Override // d.a.p0.s.f0.f.InterfaceC1212f
        public void a(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                if (this.f16774a.n != null) {
                    this.f16774a.n.Q0(true);
                    this.f16774a.n.H0();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, Boolean.TRUE));
                d.a.p0.s.n.a aVar = null;
                if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > d.a.p0.s.d0.b.j().l("key_bigday_next_showtime_home", 0L)) {
                    aVar = d.a.p0.s.n.b.i().h(1);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f16775a;

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
            this.f16775a = personalizePageView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                if (this.f16775a.E != null && i2 == 0) {
                    int height = ((WindowManager) this.f16775a.getContext().getSystemService("window")).getDefaultDisplay().getHeight() * 3;
                    if (this.f16775a.B < height || this.f16775a.D != 1) {
                        if (this.f16775a.B < height && this.f16775a.D == 2) {
                            this.f16775a.D = 1;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 5));
                        }
                    } else {
                        this.f16775a.D = 2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, Integer.valueOf(this.f16775a.D)));
                    }
                    if (this.f16775a.E.getItemCount() - this.f16775a.E.findLastVisibleItemPosition() <= 15) {
                        this.f16775a.g0();
                    }
                }
                if (i2 == 0) {
                    if (this.f16775a.H != null) {
                        this.f16775a.H.q();
                    }
                } else if (i2 == 1) {
                    if (this.f16775a.H != null) {
                        this.f16775a.H.p();
                    }
                } else if (i2 != 2 || this.f16775a.H == null) {
                } else {
                    this.f16775a.H.r();
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                this.f16775a.B += i3;
                if (this.f16775a.G != null) {
                    d.a.d.k.e.n B = this.f16775a.f16758f.B(this.f16775a.E.findLastVisibleItemPosition());
                    if (B instanceof d.a.q0.a0.e0.k) {
                        if (((d.a.q0.a0.e0.k) B).position >= 6) {
                            this.f16775a.G.f();
                        } else {
                            this.f16775a.G.b();
                        }
                    }
                }
                if (!d.a.p0.b.d.F() || TbadkCoreApplication.isLogin() || d.a.p0.s.d0.b.j().k("home_page_login_dialog_show_key", 0) != 0 || this.f16775a.B < d.a.d.e.p.l.p(TbadkCoreApplication.getInst().getContext())[1] * 2) {
                    return;
                }
                d.a.p0.s.d0.b.j().v("home_page_login_dialog_show_key", 1);
                DialogLoginHelper.checkUpIsLogin(new s0(this.f16775a.K, "new_shouye"));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f16776e;

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
            this.f16776e = personalizePageView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f16776e.g0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f16777a;

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
            this.f16777a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (this.f16777a.F == null) {
                        this.f16777a.F = new d.a.d.k.e.l(new d.a.d.k.e.j());
                    }
                    this.f16777a.F.q(this.f16777a.f16758f, 2);
                } else if (this.f16777a.F != null) {
                    this.f16777a.F.w();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements BdListView.o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f16778a;

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
            this.f16778a = personalizePageView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.o
        public void onScrollStop(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || System.currentTimeMillis() - this.f16778a.s < 5000) {
                return;
            }
            this.f16778a.n.G0(i2, i3);
        }
    }

    /* loaded from: classes4.dex */
    public class m implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f16779a;

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
            this.f16779a = personalizePageView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || viewHolder == null || (view = viewHolder.itemView) == null) {
                return;
            }
            if (this.f16779a.n != null && this.f16779a.n.h0() != null) {
                this.f16779a.n.h0().k(view);
            }
            if (view.getTag() instanceof HomePageCardVideoViewHolder) {
                ((HomePageCardVideoViewHolder) view.getTag()).b().stopPlay();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f16780e;

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
            this.f16780e = personalizePageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f16780e.n == null) {
                return;
            }
            this.f16780e.n.Z0();
        }
    }

    /* loaded from: classes4.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f16781e;

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
            this.f16781e = personalizePageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f16781e.l == null) {
                return;
            }
            d.a.p0.s.d0.b.j().v("show_is_uninterest_tag", PersonalizePageView.C(this.f16781e));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(this.f16781e.l.getContext(), 2)));
        }
    }

    /* loaded from: classes4.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f16782e;

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
            this.f16782e = personalizePageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f16782e.n0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f16783a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ q f16784e;

            public a(q qVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {qVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f16784e = qVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f16784e.f16783a.i0();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(PersonalizePageView personalizePageView, int i2) {
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
            this.f16783a = personalizePageView;
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
                    d.a.d.e.m.e.a().postDelayed(new a(this), TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f16785e;

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
            this.f16785e = personalizePageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16785e.g0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f16786a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(PersonalizePageView personalizePageView, int i2) {
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
            this.f16786a = personalizePageView;
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
            this.f16786a.u = true;
        }
    }

    /* loaded from: classes4.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f16787a;

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
            this.f16787a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f16787a.f16757e == null || this.f16787a.f16757e.t()) {
                return;
            }
            if (!(customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof d.a.p0.s.n.a))) {
                if (this.f16787a.f16760h != null) {
                    if (this.f16787a.f16761i == this.f16787a.f16760h) {
                        return;
                    }
                    PersonalizePageView personalizePageView = this.f16787a;
                    personalizePageView.f16761i = personalizePageView.f16760h;
                } else {
                    PersonalizePageView personalizePageView2 = this.f16787a;
                    personalizePageView2.f16760h = new d.a.q0.e1.h.i.a(personalizePageView2.l);
                    this.f16787a.f16760h.I(this.f16787a.t);
                    PersonalizePageView personalizePageView3 = this.f16787a;
                    personalizePageView3.f16761i = personalizePageView3.f16760h;
                    this.f16787a.c0();
                }
                this.f16787a.f16760h.B(true);
                this.f16787a.f16757e.setProgressView(this.f16787a.f16760h);
                int i2 = (int) (this.f16787a.getResources().getDisplayMetrics().density * 86.0f);
                this.f16787a.f16757e.setCustomDistances(i2, i2, i2 * 2);
                return;
            }
            d.a.p0.s.n.a aVar = (d.a.p0.s.n.a) customResponsedMessage.getData();
            if (this.f16787a.f16759g != null) {
                if (this.f16787a.f16761i == this.f16787a.f16759g && aVar.equals(this.f16787a.f16759g.G())) {
                    return;
                }
                PersonalizePageView personalizePageView4 = this.f16787a;
                personalizePageView4.f16761i = personalizePageView4.f16759g;
            } else {
                PersonalizePageView personalizePageView5 = this.f16787a;
                personalizePageView5.f16759g = new d.a.q0.e1.h.i.b(personalizePageView5.l.getContext());
                PersonalizePageView personalizePageView6 = this.f16787a;
                personalizePageView6.f16761i = personalizePageView6.f16759g;
                this.f16787a.c0();
            }
            this.f16787a.f16759g.B(true);
            this.f16787a.f16757e.setProgressView(this.f16787a.f16759g);
            this.f16787a.f16759g.J(aVar);
            this.f16787a.f16757e.setCustomDistances((int) this.f16787a.getResources().getDimension(R.dimen.tbds236), (int) (d.a.d.e.p.l.i(this.f16787a.l.getContext()) * 0.8d), d.a.d.e.p.l.i(this.f16787a.l.getContext()));
        }
    }

    /* loaded from: classes4.dex */
    public class u implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f16788e;

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
            this.f16788e = personalizePageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f16788e.G == null) {
                return;
            }
            this.f16788e.G.b();
            this.f16788e.q0();
        }
    }

    /* loaded from: classes4.dex */
    public class v implements c0.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f16789a;

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
            this.f16789a = personalizePageView;
        }

        @Override // d.a.q0.e1.h.h.c0.f
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f16789a.f16758f == null || this.f16789a.y == null) {
                return;
            }
            if (TbSingleton.getInstance().isAddBanner) {
                this.f16789a.f16758f.removeHeaderView(this.f16789a.y.b());
            } else if (this.f16789a.y.b().getParent() != null || StringUtils.isNull(TbSingleton.getInstance().getLFUser())) {
            } else {
                this.f16789a.y.d();
                this.f16789a.y.b().setVisibility(0);
                this.f16789a.y.f("1");
                this.f16789a.f16758f.setHeaderView(this.f16789a.y.b());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class w extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f16790a;

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
            this.f16790a = personalizePageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (this.f16790a.n != null) {
                    this.f16790a.x0(d.a.p0.s.v.a.b().c(), false, false);
                }
                this.f16790a.X();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class x extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f16791a;

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
            this.f16791a = personalizePageView;
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
                this.f16791a.J = ((Integer) data).intValue();
                if (this.f16791a.H != null) {
                    ((FrameLayout.LayoutParams) this.f16791a.H.getLayoutParams()).topMargin = d.a.d.e.p.l.g(this.f16791a.K, R.dimen.tbds1409) - this.f16791a.J;
                    this.f16791a.H.requestLayout();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class y implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f16792a;

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
            this.f16792a = personalizePageView;
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onCheckedChanged(w0 w0Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048576, this, w0Var, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, w0 w0Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, str, w0Var) == null) || arrayList == null || w0Var == null) {
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
            int i4 = w0Var.m;
            if (i4 == 0) {
                i2 = 1;
            } else if (i4 == 40) {
                i2 = 2;
            } else if (i4 == 49 || i4 == 69) {
                i2 = 3;
            }
            if (this.f16792a.k != null) {
                this.f16792a.k.m();
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.NEG_FEEDBACK_KEY).param("tid", w0Var.e()).param("nid", w0Var.d()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", w0Var.c()).param("obj_param1", w0Var.j).param("obj_source", w0Var.k).param("obj_id", w0Var.l).param("obj_type", sb.toString()).param("obj_name", str).param(TiebaStatic.Params.OBJ_PARAM2, i2).param("obj_locate", "1"));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackWindowShow(w0 w0Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, w0Var) == null) || w0Var == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.NEG_FEEDBACK_KEY).param("obj_locate", "1").param("fid", w0Var.c()).param("tid", w0Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("nid", w0Var.d()));
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.NEGATIVE_FEEDBACK_OPEN_CLICK).param("obj_locate", "1").param("fid", w0Var.c()).param("tid", w0Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    /* loaded from: classes4.dex */
    public class z implements FollowUserButton.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalizePageView f16793a;

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
            this.f16793a = personalizePageView;
        }

        @Override // com.baidu.tbadk.core.view.FollowUserButton.a
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            Object tag = view.getTag();
            if (tag instanceof b2) {
                TiebaStatic.log(d.a.q0.g3.a.m("c13696", (b2) tag));
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
        this.z = false;
        this.A = 0;
        this.B = 0;
        this.C = false;
        this.D = 1;
        this.L = new k(this, 2156674);
        this.M = new v(this);
        this.N = new w(this, 2921456);
        this.O = new x(this, 2921553);
        this.P = new y(this);
        this.Q = new z(this);
        this.S = -1;
        this.T = new a0(this);
        this.U = new b0(this);
        this.V = new c0(this);
        this.W = new a(this, 2001371);
        this.a0 = new b(this);
        this.b0 = new e(this);
        this.c0 = new f(this);
        this.i0 = new g(this);
        this.j0 = new h(this);
        this.k0 = new o(this);
        this.l0 = new q(this, 2001118);
        this.m0 = new r(this);
        this.n0 = new s(this, 2921033);
        this.o0 = new t(this, 2921349);
        this.p0 = new u(this);
        a0(context);
    }

    public static /* synthetic */ int C(PersonalizePageView personalizePageView) {
        int i2 = personalizePageView.A + 1;
        personalizePageView.A = i2;
        return i2;
    }

    public void U() {
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bigdaySwipeRefreshLayout = this.f16757e) == null) {
            return;
        }
        bigdaySwipeRefreshLayout.r();
    }

    public void V(Long l2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l2) == null) {
            this.n.Z(l2);
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.r != null) {
                q0();
                return;
            }
            d.a.q0.e1.h.e eVar = this.n;
            if (eVar != null) {
                eVar.Z0();
            }
        }
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d.a.p0.f0.g gVar = this.q;
            if (gVar != null) {
                gVar.dettachView(this);
                this.q = null;
                this.f16758f.setNextPage(this.j);
                this.j.A(getContext().getString(R.string.pb_load_more));
                this.j.f();
                this.j.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, Boolean.TRUE));
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.f16757e;
            if (bigdaySwipeRefreshLayout != null) {
                bigdaySwipeRefreshLayout.setVisibility(0);
            }
            d.a.q0.e1.d.b bVar = this.m;
            if (bVar != null) {
                bVar.b();
            }
        }
    }

    public final void Y() {
        d.a.p0.f0.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (hVar = this.r) == null) {
            return;
        }
        hVar.dettachView(this);
        this.r = null;
    }

    public void Z() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (rightFloatLayerView = this.H) == null) {
            return;
        }
        rightFloatLayerView.f();
    }

    public final void a0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            this.K = context;
            BdTypeRecyclerView bdTypeRecyclerView = new BdTypeRecyclerView(context);
            this.f16758f = bdTypeRecyclerView;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(bdTypeRecyclerView.getContext());
            this.E = linearLayoutManager;
            this.f16758f.setLayoutManager(linearLayoutManager);
            this.f16758f.setFadingEdgeLength(0);
            this.f16758f.setOverScrollMode(2);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.f16758f.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            d.a.q0.a0.p pVar = new d.a.q0.a0.p(context);
            this.y = pVar;
            pVar.setFrom("from_personaize");
            this.y.a().setVisibility(0);
            this.y.a().setOnClickListener(this.V);
            MessageManager.getInstance().registerListener(this.W);
            if (TbSingleton.getInstance().isSlideAnimEnable()) {
                d.a.d.k.e.l lVar = new d.a.d.k.e.l(new d.a.d.k.e.j());
                this.F = lVar;
                lVar.q(this.f16758f, 2);
            }
            MessageManager.getInstance().registerListener(this.L);
            MessageManager.getInstance().registerListener(this.N);
            MessageManager.getInstance().registerListener(this.O);
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = new BigdaySwipeRefreshLayout(context);
            this.f16757e = bigdaySwipeRefreshLayout;
            bigdaySwipeRefreshLayout.addView(this.f16758f);
            PbListView pbListView = new PbListView(context);
            this.j = pbListView;
            pbListView.b();
            this.j.o(R.color.transparent);
            this.j.v();
            this.j.C(SkinManager.getColor(R.color.CAM_X0107));
            this.j.E(R.dimen.tbfontsize33);
            this.j.y(R.color.CAM_X0110);
            this.j.r(d.a.d.e.p.l.g(context, R.dimen.tbds182));
            this.j.z(this.m0);
            this.j.q();
            this.f16758f.setNextPage(this.j);
            d.a.d.a.f<?> a2 = d.a.d.a.j.a(context);
            if (a2 instanceof TbPageContext) {
                this.l = (TbPageContext) a2;
            }
            MessageManager.getInstance().registerListener(this.o0);
            d.a.p0.s.n.b.i().n(true);
            d.a.p0.s.n.a aVar = null;
            if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > d.a.p0.s.d0.b.j().l("key_bigday_next_showtime_home", 0L)) {
                aVar = d.a.p0.s.n.b.i().h(1);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, aVar));
            addView(this.f16757e);
            if (TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
                this.G = new FRSRefreshButton(context);
                int g2 = d.a.d.e.p.l.g(context, R.dimen.tbds170);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g2, g2);
                layoutParams.gravity = 85;
                layoutParams.rightMargin = d.a.d.e.p.l.g(context, R.dimen.tbds24);
                layoutParams.bottomMargin = d.a.d.e.p.l.g(context, R.dimen.tbds180);
                addView(this.G, layoutParams);
                this.G.setOnClickListener(this.p0);
                this.G.setVisibility(8);
            }
            this.H = new RightFloatLayerView(context);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 53;
            layoutParams2.topMargin = d.a.d.e.p.l.g(context, R.dimen.tbds1409) - this.J;
            this.H.f();
            addView(this.H, layoutParams2);
            d0();
            this.p = new d.a.q0.e1.h.k.e();
            d.a.q0.e1.h.h.c0 c0Var = new d.a.q0.e1.h.h.c0(context, this.f16758f);
            this.k = c0Var;
            c0Var.x(this.p);
            this.k.v(this.M);
            this.n = new d.a.q0.e1.h.e(this.l, this.f16758f, this.k, this.f16757e);
            this.o = new d.a.q0.e1.h.a(this.l);
            j0(TbadkCoreApplication.getInst().getSkinType());
            MessageManager.getInstance().registerListener(this.n0);
            this.A = d.a.p0.s.d0.b.j().k("show_is_uninterest_tag", 0);
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.k.u(this.P);
            this.k.s(this.Q);
            this.n.P0(this.a0);
            this.o.i(this);
            c0();
            this.f16758f.addOnScrollListener(new i(this));
            this.f16758f.setOnSrollToBottomListener(new j(this));
            this.f16758f.setOnScrollStopDelayedListener(new l(this), 1L);
            this.f16758f.setRecyclerListener(new m(this));
            this.f16758f.removeOnScrollListener(this.T);
            this.f16758f.addOnScrollListener(this.T);
        }
    }

    public void c0() {
        d0 d0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (d0Var = this.f16761i) == null) {
            return;
        }
        d0Var.a(this.b0);
        this.f16761i.b(this.c0);
        this.f16761i.i(this.i0);
        this.f16761i.l(this.j0);
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && TbSingleton.getInstance().isShowRightFloatView(0)) {
            z0();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, canvas) == null) {
            super.dispatchDraw(canvas);
            if (this.v) {
                post(new p(this));
            }
        }
    }

    public final boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            d.a.p0.f0.h hVar = this.r;
            if (hVar != null) {
                return hVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void f0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.l.getContext(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            d.a.q0.e1.d.a.d().j(System.currentTimeMillis(), 1);
            PbListView pbListView = this.j;
            if (pbListView != null && !pbListView.l()) {
                this.j.O();
                this.j.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            this.n.s0();
        }
    }

    public boolean getIsUnreadTipShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.z : invokeV.booleanValue;
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.n.p0();
        }
    }

    public void i0() {
        d.a.q0.e1.h.h.c0 c0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (c0Var = this.k) == null) {
            return;
        }
        c0Var.m();
    }

    public void j0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            if (this.t != i2) {
                d.a.p0.f0.g gVar = this.q;
                if (gVar != null) {
                    gVar.onChangeSkinType();
                }
                d.a.p0.f0.h hVar = this.r;
                if (hVar != null) {
                    hVar.onChangeSkinType();
                }
                d.a.q0.e1.h.i.a aVar = this.f16760h;
                if (aVar != null) {
                    aVar.I(i2);
                }
                PbListView pbListView = this.j;
                if (pbListView != null) {
                    pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
                    this.j.d(i2);
                }
                this.k.n(i2);
                d.a.q0.e1.h.e eVar = this.n;
                if (eVar != null) {
                    eVar.x0(i2);
                }
                FRSRefreshButton fRSRefreshButton = this.G;
                if (fRSRefreshButton != null) {
                    fRSRefreshButton.d(i2);
                }
                d.a.q0.a0.p pVar = this.y;
                if (pVar != null) {
                    pVar.e(i2);
                }
                RightFloatLayerView rightFloatLayerView = this.H;
                if (rightFloatLayerView != null) {
                    rightFloatLayerView.o();
                }
            }
            this.t = i2;
        }
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.W);
            MessageManager.getInstance().unRegisterListener(this.L);
            MessageManager.getInstance().unRegisterListener(this.N);
            MessageManager.getInstance().unRegisterListener(this.n0);
            MessageManager.getInstance().unRegisterListener(this.o0);
            MessageManager.getInstance().unRegisterListener(this.O);
            this.n.y0();
            this.k.u(null);
            this.k.o();
            this.n.P0(null);
            d.a.q0.e1.h.i.b bVar = this.f16759g;
            if (bVar != null) {
                bVar.a(null);
                this.f16759g.b(null);
                this.f16759g.i(null);
                this.f16759g.l(null);
                this.f16759g.H();
            }
            d.a.q0.e1.h.i.a aVar = this.f16760h;
            if (aVar != null) {
                aVar.a(null);
                this.f16760h.b(null);
                this.f16760h.i(null);
                this.f16760h.l(null);
                this.f16760h.Y();
            }
            this.f16758f.setOnSrollToBottomListener(null);
            ScrollFragmentTabHost scrollFragmentTabHost = this.R;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.S(this.U);
            }
            this.f16758f.removeOnScrollListener(this.T);
            d.a.p0.f0.g gVar = this.q;
            if (gVar != null) {
                gVar.m();
            }
            this.f16758f.setRecyclerListener(null);
            d.a.q0.e1.h.a aVar2 = this.o;
            if (aVar2 != null) {
                aVar2.g();
            }
            d.a.p0.s.n.b.i().e();
            d.a.d.e.m.e.a().removeCallbacks(this.k0);
        }
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.n.B0();
            d.a.q0.e1.h.h.c0 c0Var = this.k;
            if (c0Var != null) {
                c0Var.p();
            }
        }
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (this.u) {
                q0();
                this.u = false;
            }
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.f16757e;
            if (bigdaySwipeRefreshLayout != null) {
                bigdaySwipeRefreshLayout.D();
            }
            d.a.q0.e1.h.h.c0 c0Var = this.k;
            if (c0Var != null) {
                c0Var.q();
            }
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (!this.x) {
                long f2 = d.a.q0.e1.d.a.d().f(1) + d.a.q0.e1.d.a.d().b();
                long a2 = d.a.q0.e1.d.a.d().a(1);
                if (a2 > 0) {
                    f2 = System.currentTimeMillis() - a2;
                }
                d.a.p0.o0.n nVar = new d.a.p0.o0.n();
                nVar.a();
                nVar.b();
                d.a.p0.o0.l.b().o(f2);
                if (this.w > 0) {
                    d.a.p0.o0.l.b().I(System.currentTimeMillis() - this.w);
                }
                d.a.p0.o0.l.b().M(nVar.c());
            }
            this.x = true;
        }
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            d.a.q0.e1.h.e eVar = this.n;
            if (eVar != null) {
                eVar.v0(true);
            }
            d.a.q0.a0.t.b().d(false);
            d.a.q0.o.d.c().h("page_recommend", "show_");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            d.a.d.e.m.e.a().removeCallbacks(this.k0);
        }
    }

    public boolean p0(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, recyclerView)) == null) ? recyclerView == null || !recyclerView.canScrollVertically(-1) : invokeL.booleanValue;
    }

    public void q0() {
        d.a.q0.e1.h.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (this.r != null && (eVar = this.n) != null) {
                eVar.Z0();
            } else if (this.f16758f == null || this.f16757e == null) {
            } else {
                t0();
                this.f16758f.setSelection(0);
                if (!this.f16757e.t()) {
                    d.a.q0.e1.h.e eVar2 = this.n;
                    if (eVar2 != null && eVar2.h0() != null) {
                        this.n.h0().w();
                        this.n.Q0(false);
                    }
                    this.f16757e.setRefreshing(true);
                }
                ScrollFragmentTabHost.s sVar = this.U;
                if (sVar != null) {
                    sVar.b();
                }
            }
        }
    }

    public void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.n.M0();
        }
    }

    public void s0() {
        d.a.q0.e1.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (eVar = this.n) == null) {
            return;
        }
        eVar.U0();
    }

    public void setCallback(d.a.q0.e1.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bVar) == null) {
            this.m = bVar;
        }
    }

    public void setIsUnreadTipShow(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z2) == null) {
            d.a.q0.e1.h.e eVar = this.n;
            if (eVar != null) {
                eVar.N0(!z2);
            }
            this.z = z2;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, bdUniqueId) == null) {
            d.a.q0.e1.h.h.c0 c0Var = this.k;
            if (c0Var != null) {
                c0Var.w(bdUniqueId);
            }
            d.a.q0.e1.h.e eVar = this.n;
            if (eVar != null) {
                eVar.I0(bdUniqueId);
            }
            d.a.q0.e1.h.k.e eVar2 = this.p;
            if (eVar2 != null) {
                eVar2.a(bdUniqueId);
            }
            d.a.q0.e1.h.i.a aVar = this.f16760h;
            if (aVar != null) {
                aVar.a0(bdUniqueId);
            }
            d.a.p0.s.n.b.i().o(bdUniqueId);
            CustomMessageListener customMessageListener = this.l0;
            if (customMessageListener != null) {
                customMessageListener.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.l0);
            }
            d.a.q0.e1.h.a aVar2 = this.o;
            if (aVar2 != null) {
                aVar2.h(bdUniqueId);
            }
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(d.a.p0.b1.b0 b0Var) {
        d.a.q0.e1.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, b0Var) == null) || (eVar = this.n) == null) {
            return;
        }
        eVar.R0(b0Var);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, scrollFragmentTabHost) == null) {
            this.R = scrollFragmentTabHost;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.S(this.U);
                this.R.w(this.U);
            }
            d.a.q0.e1.h.e eVar = this.n;
            if (eVar != null) {
                eVar.S0(scrollFragmentTabHost);
            }
            d.a.q0.e1.h.a aVar = this.o;
            if (aVar != null) {
                aVar.j(scrollFragmentTabHost);
            }
        }
    }

    public void setTabInForeBackgroundState(boolean z2) {
        d.a.q0.e1.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048608, this, z2) == null) || (eVar = this.n) == null) {
            return;
        }
        eVar.T0(z2);
    }

    public void setViewForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            setViewForeground(false);
            d.a.q0.e1.h.e eVar = this.n;
            if (eVar != null) {
                eVar.v0(false);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            if (this.A >= 1 || !TbadkCoreApplication.getInst().isNoInterestTag()) {
                return;
            }
            d.a.d.e.m.e.a().postDelayed(this.k0, 1000L);
        }
    }

    public void t0() {
        d.a.q0.e1.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || (eVar = this.n) == null) {
            return;
        }
        eVar.W0();
    }

    public final void u0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z2) == null) {
            if (this.q == null) {
                this.q = new d.a.p0.f0.g(getContext());
                this.q.o(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + d.a.d.e.p.l.g(getContext(), R.dimen.tbds60));
                this.q.h();
                this.q.setWrapStyle(true);
                this.q.onChangeSkinType();
            }
            this.q.attachView(this, z2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, Boolean.FALSE));
            this.f16758f.setNextPage(null);
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.f16757e;
            if (bigdaySwipeRefreshLayout != null) {
                bigdaySwipeRefreshLayout.setVisibility(8);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921457, this.l.getUniqueId()));
        }
    }

    public final void v0(View view, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048613, this, view, str, z2) == null) {
            if (this.r == null) {
                this.r = new d.a.p0.f0.h(getContext(), new n(this));
            }
            this.r.attachView(view, z2);
            this.r.o();
        }
    }

    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            if (this.n != null) {
                u0(true);
                this.n.Z0();
            }
            if (SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1) {
                d.a.p0.s.n.b.i().j();
                d.a.p0.s.n.b.i().k();
            }
        }
    }

    public void x0(DataRes dataRes, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{dataRes, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            PbListView pbListView = this.j;
            if (pbListView != null) {
                pbListView.A(getContext().getString(R.string.pb_load_more));
                this.j.f();
                this.j.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            this.n.z0(z2, z3, dataRes, 0, null);
        }
    }

    public void y0(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048616, this, str, i2) == null) {
            PbListView pbListView = this.j;
            if (pbListView != null) {
                pbListView.A(getContext().getString(R.string.pb_load_more));
                this.j.f();
                this.j.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            this.n.z0(true, false, null, i2, str);
        }
    }

    public final void z0() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && (rightFloatLayerView = this.H) != null && rightFloatLayerView.m()) {
            d.a.p0.t.c.f adFloatViewData = TbSingleton.getInstance().getAdFloatViewData();
            this.I = adFloatViewData;
            if (adFloatViewData == null) {
                return;
            }
            this.H.setData(adFloatViewData.a());
            TiebaStatic.log(new StatisticItem("c14128").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", 1));
            this.H.setLogoListener(new c(this, this.I.b()));
            this.H.setFeedBackListener(new d(this));
        }
    }

    public void setViewForeground(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z2) == null) {
            d.a.q0.e1.h.e eVar = this.n;
            if (eVar != null) {
                eVar.C0(z2);
            }
            ScrollFragmentTabHost scrollFragmentTabHost = this.R;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.S(this.U);
                this.R.w(this.U);
                this.U.b();
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
        this.z = false;
        this.A = 0;
        this.B = 0;
        this.C = false;
        this.D = 1;
        this.L = new k(this, 2156674);
        this.M = new v(this);
        this.N = new w(this, 2921456);
        this.O = new x(this, 2921553);
        this.P = new y(this);
        this.Q = new z(this);
        this.S = -1;
        this.T = new a0(this);
        this.U = new b0(this);
        this.V = new c0(this);
        this.W = new a(this, 2001371);
        this.a0 = new b(this);
        this.b0 = new e(this);
        this.c0 = new f(this);
        this.i0 = new g(this);
        this.j0 = new h(this);
        this.k0 = new o(this);
        this.l0 = new q(this, 2001118);
        this.m0 = new r(this);
        this.n0 = new s(this, 2921033);
        this.o0 = new t(this, 2921349);
        this.p0 = new u(this);
        a0(context);
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
        this.z = false;
        this.A = 0;
        this.B = 0;
        this.C = false;
        this.D = 1;
        this.L = new k(this, 2156674);
        this.M = new v(this);
        this.N = new w(this, 2921456);
        this.O = new x(this, 2921553);
        this.P = new y(this);
        this.Q = new z(this);
        this.S = -1;
        this.T = new a0(this);
        this.U = new b0(this);
        this.V = new c0(this);
        this.W = new a(this, 2001371);
        this.a0 = new b(this);
        this.b0 = new e(this);
        this.c0 = new f(this);
        this.i0 = new g(this);
        this.j0 = new h(this);
        this.k0 = new o(this);
        this.l0 = new q(this, 2001118);
        this.m0 = new r(this);
        this.n0 = new s(this, 2921033);
        this.o0 = new t(this, 2921349);
        this.p0 = new u(this);
        a0(context);
    }
}
